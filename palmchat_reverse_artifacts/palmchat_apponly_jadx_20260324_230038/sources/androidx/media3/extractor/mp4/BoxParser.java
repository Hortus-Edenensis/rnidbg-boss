package androidx.media3.extractor.mp4;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.container.DolbyVisionConfig;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4AlternateGroupData;
import androidx.media3.container.Mp4Box;
import androidx.media3.container.Mp4LocationData;
import androidx.media3.container.Mp4TimestampData;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.AvcConfig;
import androidx.media3.extractor.ExtractorUtil;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.HevcConfig;
import androidx.media3.extractor.OpusUtil;
import androidx.media3.extractor.VorbisUtil;
import androidx.media3.extractor.mp4.FixedSampleSizeRechunker;
import com.google.common.collect.ImmutableList;
import com.oplus.tblplayer.processor.util.EffectConstants;
import defpackage.ku2;
import defpackage.qy2;
import defpackage.u42;
import j$.util.Objects;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class BoxParser {
    private static final int MAX_GAPLESS_TRIM_SIZE_SAMPLES = 4;
    private static final int SAMPLE_RATE_AMR_NB = 8000;
    private static final int SAMPLE_RATE_AMR_WB = 16000;
    private static final String TAG = "BoxParsers";
    private static final int TYPE_clcp = 1668047728;
    private static final int TYPE_mdta = 1835299937;
    private static final int TYPE_meta = 1835365473;
    private static final int TYPE_nclc = 1852009571;
    private static final int TYPE_nclx = 1852009592;
    private static final int TYPE_sbtl = 1935832172;
    private static final int TYPE_soun = 1936684398;
    private static final int TYPE_subp = 1937072752;
    private static final int TYPE_subt = 1937072756;
    private static final int TYPE_text = 1952807028;
    private static final int TYPE_vide = 1986618469;
    private static final byte[] opusMagic = Util.getUtf8Bytes("OpusHead");

    /* JADX INFO: compiled from: SearchBox */
    public static final class BtrtData {
        private final long avgBitrate;
        private final long maxBitrate;

        public BtrtData(long j, long j2) {
            this.avgBitrate = j;
            this.maxBitrate = j2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) throws ParserException {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            ExtractorUtil.checkContainerInput(parsableByteArray.readInt() == 1, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                return false;
            }
            this.offset = this.chunkOffsetsAreLongs ? this.chunkOffsets.readUnsignedLongToLong() : this.chunkOffsets.readUnsignedInt();
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i2 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i2;
                this.nextSamplesPerChunkChangeIndex = i2 > 0 ? this.stsc.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class EsdsData {
        private final long bitrate;
        private final byte[] initializationData;
        private final String mimeType;
        private final long peakBitrate;

        public EsdsData(String str, byte[] bArr, long j, long j2) {
            this.mimeType = str;
            this.initializationData = bArr;
            this.bitrate = j;
            this.peakBitrate = j2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class EyesData {
        private final StriData striData;

        public EyesData(StriData striData) {
            this.striData = striData;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class MdhdData {

        @Nullable
        private final String language;
        private final long mediaDurationUs;
        private final long timescale;

        public MdhdData(long j, long j2, @Nullable String str) {
            this.timescale = j;
            this.mediaDurationUs = j2;
            this.language = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface SampleSizeBox {
        int getFixedSampleSize();

        int getSampleCount();

        int readNextSampleSize();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class StriData {
        private final boolean eyeViewsReversed;
        private final boolean hasLeftEyeView;
        private final boolean hasRightEyeView;

        public StriData(boolean z, boolean z2, boolean z3) {
            this.hasLeftEyeView = z;
            this.hasRightEyeView = z2;
            this.eyeViewsReversed = z3;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class StsdData {
        public static final int STSD_HEADER_SIZE = 8;

        @Nullable
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i];
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize;
        private final int sampleCount;

        public StszSampleSizeBox(Mp4Box.LeafBox leafBox, Format format) {
            ParsableByteArray parsableByteArray = leafBox.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if ("audio/raw".equals(format.sampleMimeType)) {
                int pcmFrameSize = Util.getPcmFrameSize(format.pcmEncoding, format.channelCount);
                if (unsignedIntToInt == 0 || unsignedIntToInt % pcmFrameSize != 0) {
                    Log.w(BoxParser.TAG, "Audio sample size mismatch. stsd sample size: " + pcmFrameSize + ", stsz sample size: " + unsignedIntToInt);
                    unsignedIntToInt = pcmFrameSize;
                }
            }
            this.fixedSampleSize = unsignedIntToInt == 0 ? -1 : unsignedIntToInt;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int getFixedSampleSize() {
            return this.fixedSampleSize;
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int readNextSampleSize() {
            int i = this.fixedSampleSize;
            return i == -1 ? this.data.readUnsignedIntToInt() : i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize;
        private final int sampleCount;
        private int sampleIndex;

        public Stz2SampleSizeBox(Mp4Box.LeafBox leafBox) {
            ParsableByteArray parsableByteArray = leafBox.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fieldSize = parsableByteArray.readUnsignedIntToInt() & 255;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int getFixedSampleSize() {
            return -1;
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int readNextSampleSize() {
            int i = this.fieldSize;
            if (i == 8) {
                return this.data.readUnsignedByte();
            }
            if (i == 16) {
                return this.data.readUnsignedShort();
            }
            int i2 = this.sampleIndex;
            this.sampleIndex = i2 + 1;
            if (i2 % 2 != 0) {
                return this.currentByte & 15;
            }
            int unsignedByte = this.data.readUnsignedByte();
            this.currentByte = unsignedByte;
            return (unsignedByte & 240) >> 4;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class TkhdData {
        private final int alternateGroup;
        private final long duration;
        private final int height;
        private final int id;
        private final int rotationDegrees;
        private final int width;

        public TkhdData(int i, long j, int i2, int i3, int i4, int i5) {
            this.id = i;
            this.duration = j;
            this.alternateGroup = i2;
            this.rotationDegrees = i3;
            this.width = i4;
            this.height = i5;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class VexuData {

        @Nullable
        private final EyesData eyesData;

        public VexuData(EyesData eyesData) {
            this.eyesData = eyesData;
        }

        public boolean hasBothEyeViews() {
            EyesData eyesData = this.eyesData;
            return eyesData != null && eyesData.striData.hasLeftEyeView && this.eyesData.striData.hasRightEyeView;
        }
    }

    private BoxParser() {
    }

    private static ByteBuffer allocateHdrStaticInfo() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static boolean canApplyEditWithGaplessInfo(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        return jArr[0] <= j2 && j2 < jArr[Util.constrainValue(4, 0, length)] && jArr[Util.constrainValue(jArr.length - 4, 0, length)] < j3 && j3 <= j;
    }

    private static int findBoxPosition(ParsableByteArray parsableByteArray, int i, int i2, int i3) throws ParserException {
        int position = parsableByteArray.getPosition();
        ExtractorUtil.checkContainerInput(position >= i2, null);
        while (position - i2 < i3) {
            parsableByteArray.setPosition(position);
            int i4 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i4 > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == i) {
                return position;
            }
            position += i4;
        }
        return -1;
    }

    private static String formatVobsubIdx(byte[] bArr, int i, int i2) {
        Assertions.checkState(bArr.length == 64);
        ArrayList arrayList = new ArrayList(16);
        for (int i3 = 0; i3 < bArr.length - 3; i3 += 4) {
            arrayList.add(String.format("%06x", Integer.valueOf(vobsubYuvToRgb(ku2.j(bArr[i3], bArr[i3 + 1], bArr[i3 + 2], bArr[i3 + 3])))));
        }
        return "size: " + i + "x" + i2 + "\npalette: " + qy2.h(", ").d(arrayList) + "\n";
    }

    @Nullable
    private static String getLanguageFromCode(int i) {
        char[] cArr = {(char) (((i >> 10) & 31) + 96), (char) (((i >> 5) & 31) + 96), (char) ((i & 31) + 96)};
        for (int i2 = 0; i2 < 3; i2++) {
            char c = cArr[i2];
            if (c < 'a' || c > 'z') {
                return null;
            }
        }
        return new String(cArr);
    }

    private static int getTrackTypeForHdlr(int i) {
        if (i == TYPE_soun) {
            return 1;
        }
        if (i == TYPE_vide) {
            return 2;
        }
        if (i == TYPE_text || i == TYPE_sbtl || i == TYPE_subt || i == TYPE_clcp || i == TYPE_subp) {
            return 3;
        }
        return i == 1835365473 ? 5 : -1;
    }

    public static void maybeSkipRemainingMetaBoxHeaderBytes(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(4);
        if (parsableByteArray.readInt() != 1751411826) {
            position += 4;
        }
        parsableByteArray.setPosition(position);
    }

    private static ColorInfo parseApvc(ParsableByteArray parsableByteArray) {
        ColorInfo.Builder builder = new ColorInfo.Builder();
        ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray.getData());
        parsableBitArray.setPosition(parsableByteArray.getPosition() * 8);
        parsableBitArray.skipBytes(1);
        int bits = parsableBitArray.readBits(8);
        for (int i = 0; i < bits; i++) {
            parsableBitArray.skipBytes(1);
            int bits2 = parsableBitArray.readBits(8);
            for (int i2 = 0; i2 < bits2; i2++) {
                parsableBitArray.skipBits(6);
                boolean bit = parsableBitArray.readBit();
                parsableBitArray.skipBit();
                parsableBitArray.skipBytes(11);
                parsableBitArray.skipBits(4);
                int bits3 = parsableBitArray.readBits(4) + 8;
                builder.setLumaBitdepth(bits3);
                builder.setChromaBitdepth(bits3);
                parsableBitArray.skipBytes(1);
                if (bit) {
                    int bits4 = parsableBitArray.readBits(8);
                    int bits5 = parsableBitArray.readBits(8);
                    parsableBitArray.skipBytes(1);
                    builder.setColorSpace(ColorInfo.isoColorPrimariesToColorSpace(bits4)).setColorRange(parsableBitArray.readBit() ? 1 : 2).setColorTransfer(ColorInfo.isoTransferCharacteristicsToColorTransfer(bits5));
                }
            }
        }
        return builder.build();
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0159  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void parseAudioSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, @Nullable String str, boolean z, @Nullable DrmInitData drmInitData, StsdData stsdData, int i5) throws ParserException {
        int unsignedShort;
        int unsignedShort2;
        int i6;
        int i7;
        int i8;
        String str2;
        int i9;
        String str3;
        int i10;
        String str4;
        String str5;
        String strBuildIamfCodecString;
        int i11;
        int pcmEncoding;
        int i12;
        int i13;
        String str6;
        int i14;
        int iIntValue = i;
        int i15 = i2;
        int i16 = i3;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        parsableByteArray.setPosition(i15 + 8 + 8);
        if (z) {
            unsignedShort = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
        } else {
            parsableByteArray.skipBytes(8);
            unsignedShort = 0;
        }
        if (unsignedShort == 0 || unsignedShort == 1) {
            unsignedShort2 = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
            int unsignedFixedPoint1616 = parsableByteArray.readUnsignedFixedPoint1616();
            parsableByteArray.setPosition(parsableByteArray.getPosition() - 4);
            i6 = parsableByteArray.readInt();
            if (unsignedShort == 1) {
                parsableByteArray.skipBytes(16);
            }
            i7 = unsignedFixedPoint1616;
            i8 = -1;
        } else {
            if (unsignedShort != 2) {
                return;
            }
            parsableByteArray.skipBytes(16);
            int iRound = (int) Math.round(parsableByteArray.readDouble());
            int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            parsableByteArray.skipBytes(4);
            int unsignedIntToInt2 = parsableByteArray.readUnsignedIntToInt();
            int unsignedIntToInt3 = parsableByteArray.readUnsignedIntToInt();
            boolean z2 = (unsignedIntToInt3 & 1) != 0;
            boolean z3 = (unsignedIntToInt3 & 2) != 0;
            if (z2) {
                if (unsignedIntToInt2 == 32) {
                    i14 = 4;
                }
                parsableByteArray.skipBytes(8);
                unsignedShort2 = unsignedIntToInt;
                i7 = iRound;
                i8 = i14;
                i6 = 0;
            } else {
                i14 = unsignedIntToInt2 == 8 ? 3 : unsignedIntToInt2 == 16 ? z3 ? 268435456 : 2 : unsignedIntToInt2 == 24 ? z3 ? C.ENCODING_PCM_24BIT_BIG_ENDIAN : 21 : unsignedIntToInt2 == 32 ? z3 ? C.ENCODING_PCM_32BIT_BIG_ENDIAN : 22 : -1;
                parsableByteArray.skipBytes(8);
                unsignedShort2 = unsignedIntToInt;
                i7 = iRound;
                i8 = i14;
                i6 = 0;
            }
        }
        if (iIntValue == 1767992678) {
            unsignedShort2 = -1;
            i7 = -1;
        } else if (iIntValue == 1935764850) {
            unsignedShort2 = 1;
            i7 = 8000;
        } else if (iIntValue == 1935767394) {
            unsignedShort2 = 1;
            i7 = 16000;
        }
        int position = parsableByteArray.getPosition();
        if (iIntValue == 1701733217) {
            Pair<Integer, TrackEncryptionBox> sampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i15, i16);
            if (sampleEntryEncryptionData != null) {
                iIntValue = ((Integer) sampleEntryEncryptionData.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((TrackEncryptionBox) sampleEntryEncryptionData.second).schemeType);
                stsdData.trackEncryptionBoxes[i5] = (TrackEncryptionBox) sampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        String str7 = "audio/mhm1";
        if (iIntValue == 1633889587) {
            str2 = "audio/ac3";
        } else if (iIntValue == 1700998451) {
            str2 = "audio/eac3";
        } else if (iIntValue == 1633889588) {
            str2 = "audio/ac4";
        } else if (iIntValue == 1685353315) {
            str2 = "audio/vnd.dts";
        } else if (iIntValue == 1685353320 || iIntValue == 1685353324) {
            str2 = "audio/vnd.dts.hd";
        } else if (iIntValue == 1685353317) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (iIntValue == 1685353336) {
            str2 = MimeTypes.AUDIO_DTS_X;
        } else if (iIntValue == 1935764850) {
            str2 = "audio/3gpp";
        } else {
            if (iIntValue != 1935767394) {
                if (iIntValue != 1936684916) {
                    if (iIntValue == 1953984371) {
                        str3 = "audio/raw";
                        i9 = 268435456;
                    } else if (iIntValue == 1819304813) {
                        if (i8 == -1) {
                            str3 = "audio/raw";
                            i9 = 2;
                        } else {
                            i9 = i8;
                            str3 = "audio/raw";
                        }
                    } else if (iIntValue == 778924082 || iIntValue == 778924083) {
                        str2 = "audio/mpeg";
                    } else if (iIntValue == 1835557169) {
                        str2 = "audio/mha1";
                    } else if (iIntValue == 1835560241) {
                        i9 = i8;
                        str3 = "audio/mhm1";
                    } else if (iIntValue == 1634492771) {
                        str2 = "audio/alac";
                    } else if (iIntValue == 1634492791) {
                        str2 = "audio/g711-alaw";
                    } else if (iIntValue == 1970037111) {
                        str2 = "audio/g711-mlaw";
                    } else if (iIntValue == 1332770163) {
                        str2 = "audio/opus";
                    } else if (iIntValue == 1716281667) {
                        str2 = "audio/flac";
                    } else if (iIntValue == 1835823201) {
                        str2 = "audio/true-hd";
                    } else if (iIntValue == 1767992678) {
                        str2 = MimeTypes.AUDIO_IAMF;
                    } else {
                        i9 = i8;
                        str3 = null;
                    }
                }
                int i17 = i9;
                String str8 = null;
                List<byte[]> listOf = null;
                EsdsData esdsFromParent = null;
                BtrtData btrtFromParent = null;
                while (position - i15 < i16) {
                    parsableByteArray.setPosition(position);
                    int i18 = parsableByteArray.readInt();
                    ExtractorUtil.checkContainerInput(i18 > 0, "childAtomSize must be positive");
                    int i19 = parsableByteArray.readInt();
                    if (i19 == 1835557187) {
                        parsableByteArray.setPosition(position + 8);
                        parsableByteArray.skipBytes(1);
                        int unsignedByte = parsableByteArray.readUnsignedByte();
                        parsableByteArray.skipBytes(1);
                        if (Objects.equals(str3, str7)) {
                            str4 = str7;
                            i13 = 0;
                            str6 = String.format("mhm1.%02X", Integer.valueOf(unsignedByte));
                            i10 = i7;
                        } else {
                            i10 = i7;
                            str4 = str7;
                            i13 = 0;
                            str6 = String.format("mha1.%02X", Integer.valueOf(unsignedByte));
                        }
                        int unsignedShort3 = parsableByteArray.readUnsignedShort();
                        byte[] bArr = new byte[unsignedShort3];
                        parsableByteArray.readBytes(bArr, i13, unsignedShort3);
                        listOf = listOf == null ? ImmutableList.of(bArr) : ImmutableList.of(bArr, listOf.get(i13));
                        strBuildIamfCodecString = str6;
                    } else {
                        i10 = i7;
                        str4 = str7;
                        if (i19 == 1835557200) {
                            parsableByteArray.setPosition(position + 8);
                            int unsignedByte2 = parsableByteArray.readUnsignedByte();
                            if (unsignedByte2 > 0) {
                                byte[] bArr2 = new byte[unsignedByte2];
                                parsableByteArray.readBytes(bArr2, 0, unsignedByte2);
                                listOf = listOf == null ? ImmutableList.of(bArr2) : ImmutableList.of(listOf.get(0), bArr2);
                            }
                        } else {
                            if (i19 == 1702061171 || (z && i19 == 2002876005)) {
                                i7 = i10;
                                int iFindBoxPosition = i19 == 1702061171 ? position : findBoxPosition(parsableByteArray, 1702061171, position, i18);
                                if (iFindBoxPosition != -1) {
                                    esdsFromParent = parseEsdsFromParent(parsableByteArray, iFindBoxPosition);
                                    str3 = esdsFromParent.mimeType;
                                    byte[] bArr3 = esdsFromParent.initializationData;
                                    if (bArr3 != null) {
                                        if ("audio/vorbis".equals(str3)) {
                                            listOf = VorbisUtil.parseVorbisCsdFromEsdsInitializationData(bArr3);
                                        } else {
                                            if ("audio/mp4a-latm".equals(str3)) {
                                                AacUtil.Config audioSpecificConfig = AacUtil.parseAudioSpecificConfig(bArr3);
                                                i7 = audioSpecificConfig.sampleRateHz;
                                                int i20 = audioSpecificConfig.channelCount;
                                                str5 = audioSpecificConfig.codecs;
                                                unsignedShort2 = i20;
                                            } else {
                                                str5 = str8;
                                            }
                                            String str9 = str5;
                                            listOf = ImmutableList.of(bArr3);
                                            strBuildIamfCodecString = str9;
                                        }
                                    }
                                }
                                position += i18;
                                i16 = i3;
                                str7 = str4;
                                str8 = strBuildIamfCodecString;
                                i15 = i2;
                            } else if (i19 == 1651798644) {
                                btrtFromParent = parseBtrtFromParent(parsableByteArray, position);
                            } else {
                                if (i19 == 1684103987) {
                                    parsableByteArray.setPosition(position + 8);
                                    stsdData.format = Ac3Util.parseAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitDataCopyWithSchemeType);
                                } else if (i19 == 1684366131) {
                                    parsableByteArray.setPosition(position + 8);
                                    stsdData.format = Ac3Util.parseEAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitDataCopyWithSchemeType);
                                } else if (i19 == 1684103988) {
                                    parsableByteArray.setPosition(position + 8);
                                    stsdData.format = Ac4Util.parseAc4AnnexEFormat(parsableByteArray, Integer.toString(i4), str, drmInitDataCopyWithSchemeType);
                                } else if (i19 != 1684892784) {
                                    if (i19 == 1684305011 || i19 == 1969517683) {
                                        i11 = i10;
                                        stsdData.format = new Format.Builder().setId(i4).setSampleMimeType(str3).setChannelCount(unsignedShort2).setSampleRate(i11).setDrmInitData(drmInitDataCopyWithSchemeType).setLanguage(str).build();
                                    } else if (i19 == 1682927731) {
                                        int i21 = i18 - 8;
                                        byte[] bArr4 = opusMagic;
                                        byte[] bArrCopyOf = Arrays.copyOf(bArr4, bArr4.length + i21);
                                        parsableByteArray.setPosition(position + 8);
                                        parsableByteArray.readBytes(bArrCopyOf, bArr4.length, i21);
                                        listOf = OpusUtil.buildInitializationData(bArrCopyOf);
                                    } else if (i19 == 1684425825) {
                                        int i22 = i18 - 12;
                                        byte[] bArr5 = new byte[i22 + 4];
                                        bArr5[0] = 102;
                                        bArr5[1] = 76;
                                        bArr5[2] = 97;
                                        bArr5[3] = 67;
                                        parsableByteArray.setPosition(position + 12);
                                        parsableByteArray.readBytes(bArr5, 4, i22);
                                        listOf = ImmutableList.of(bArr5);
                                        i7 = i10;
                                    } else if (i19 == 1634492771) {
                                        int i23 = i18 - 12;
                                        byte[] bArr6 = new byte[i23];
                                        parsableByteArray.setPosition(position + 12);
                                        parsableByteArray.readBytes(bArr6, 0, i23);
                                        Pair<Integer, Integer> alacAudioSpecificConfig = CodecSpecificDataUtil.parseAlacAudioSpecificConfig(bArr6);
                                        int iIntValue2 = ((Integer) alacAudioSpecificConfig.first).intValue();
                                        int iIntValue3 = ((Integer) alacAudioSpecificConfig.second).intValue();
                                        i7 = iIntValue2;
                                        listOf = ImmutableList.of(bArr6);
                                        unsignedShort2 = iIntValue3;
                                    } else if (i19 == 1767990114) {
                                        parsableByteArray.setPosition(position + 8 + 1);
                                        int unsignedLeb128ToInt = parsableByteArray.readUnsignedLeb128ToInt();
                                        byte[] bArr7 = new byte[unsignedLeb128ToInt];
                                        parsableByteArray.readBytes(bArr7, 0, unsignedLeb128ToInt);
                                        strBuildIamfCodecString = CodecSpecificDataUtil.buildIamfCodecString(bArr7);
                                        listOf = ImmutableList.of(bArr7);
                                        i7 = i10;
                                        position += i18;
                                        i16 = i3;
                                        str7 = str4;
                                        str8 = strBuildIamfCodecString;
                                        i15 = i2;
                                    } else if (i19 == 1885564227) {
                                        parsableByteArray.setPosition(position + 12);
                                        ByteOrder byteOrder = (parsableByteArray.readUnsignedByte() & 1) != 0 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
                                        int unsignedByte3 = parsableByteArray.readUnsignedByte();
                                        if (iIntValue == 1768973165) {
                                            pcmEncoding = Util.getPcmEncoding(unsignedByte3, byteOrder);
                                            i12 = -1;
                                        } else {
                                            pcmEncoding = (iIntValue == 1718641517 && unsignedByte3 == 32 && byteOrder.equals(ByteOrder.LITTLE_ENDIAN)) ? 4 : i17;
                                            i12 = -1;
                                        }
                                        i17 = pcmEncoding;
                                        if (pcmEncoding != i12) {
                                            str3 = "audio/raw";
                                        }
                                        i7 = i10;
                                    } else {
                                        i11 = i10;
                                    }
                                    strBuildIamfCodecString = str8;
                                    i7 = i11;
                                    position += i18;
                                    i16 = i3;
                                    str7 = str4;
                                    str8 = strBuildIamfCodecString;
                                    i15 = i2;
                                } else {
                                    if (i6 <= 0) {
                                        throw ParserException.createForMalformedContainer("Invalid sample rate for Dolby TrueHD MLP stream: " + i6, null);
                                    }
                                    strBuildIamfCodecString = str8;
                                    i7 = i6;
                                    unsignedShort2 = 2;
                                    position += i18;
                                    i16 = i3;
                                    str7 = str4;
                                    str8 = strBuildIamfCodecString;
                                    i15 = i2;
                                }
                                i11 = i10;
                                strBuildIamfCodecString = str8;
                                i7 = i11;
                                position += i18;
                                i16 = i3;
                                str7 = str4;
                                str8 = strBuildIamfCodecString;
                                i15 = i2;
                            }
                            strBuildIamfCodecString = str8;
                            position += i18;
                            i16 = i3;
                            str7 = str4;
                            str8 = strBuildIamfCodecString;
                            i15 = i2;
                        }
                        strBuildIamfCodecString = str8;
                    }
                    i7 = i10;
                    position += i18;
                    i16 = i3;
                    str7 = str4;
                    str8 = strBuildIamfCodecString;
                    i15 = i2;
                }
                if (stsdData.format == null || str3 == null) {
                }
                Format.Builder language = new Format.Builder().setId(i4).setSampleMimeType(str3).setCodecs(str8).setChannelCount(unsignedShort2).setSampleRate(i7).setPcmEncoding(i17).setInitializationData(listOf).setDrmInitData(drmInitDataCopyWithSchemeType).setLanguage(str);
                if (esdsFromParent != null) {
                    language.setAverageBitrate(ku2.o(esdsFromParent.bitrate)).setPeakBitrate(ku2.o(esdsFromParent.peakBitrate));
                } else if (btrtFromParent != null) {
                    language.setAverageBitrate(ku2.o(btrtFromParent.avgBitrate)).setPeakBitrate(ku2.o(btrtFromParent.maxBitrate));
                }
                stsdData.format = language.build();
                return;
            }
            str2 = "audio/amr-wb";
        }
        String str10 = str2;
        i9 = i8;
        str3 = str10;
        int i172 = i9;
        String str82 = null;
        List<byte[]> listOf2 = null;
        EsdsData esdsFromParent2 = null;
        BtrtData btrtFromParent2 = null;
        while (position - i15 < i16) {
        }
        if (stsdData.format == null) {
        }
    }

    private static ColorInfo parseAv1c(ParsableByteArray parsableByteArray) {
        ColorInfo.Builder builder = new ColorInfo.Builder();
        ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray.getData());
        parsableBitArray.setPosition(parsableByteArray.getPosition() * 8);
        parsableBitArray.skipBytes(1);
        int bits = parsableBitArray.readBits(3);
        parsableBitArray.skipBits(6);
        boolean bit = parsableBitArray.readBit();
        boolean bit2 = parsableBitArray.readBit();
        if (bits == 2 && bit) {
            builder.setLumaBitdepth(bit2 ? 12 : 10);
            builder.setChromaBitdepth(bit2 ? 12 : 10);
        } else if (bits <= 2) {
            builder.setLumaBitdepth(bit ? 10 : 8);
            builder.setChromaBitdepth(bit ? 10 : 8);
        }
        parsableBitArray.skipBits(13);
        parsableBitArray.skipBit();
        int bits2 = parsableBitArray.readBits(4);
        if (bits2 != 1) {
            Log.i(TAG, "Unsupported obu_type: " + bits2);
            return builder.build();
        }
        if (parsableBitArray.readBit()) {
            Log.i(TAG, "Unsupported obu_extension_flag");
            return builder.build();
        }
        boolean bit3 = parsableBitArray.readBit();
        parsableBitArray.skipBit();
        if (bit3 && parsableBitArray.readBits(8) > 127) {
            Log.i(TAG, "Excessive obu_size");
            return builder.build();
        }
        int bits3 = parsableBitArray.readBits(3);
        parsableBitArray.skipBit();
        if (parsableBitArray.readBit()) {
            Log.i(TAG, "Unsupported reduced_still_picture_header");
            return builder.build();
        }
        if (parsableBitArray.readBit()) {
            Log.i(TAG, "Unsupported timing_info_present_flag");
            return builder.build();
        }
        if (parsableBitArray.readBit()) {
            Log.i(TAG, "Unsupported initial_display_delay_present_flag");
            return builder.build();
        }
        int bits4 = parsableBitArray.readBits(5);
        boolean z = false;
        for (int i = 0; i <= bits4; i++) {
            parsableBitArray.skipBits(12);
            if (parsableBitArray.readBits(5) > 7) {
                parsableBitArray.skipBit();
            }
        }
        int bits5 = parsableBitArray.readBits(4);
        int bits6 = parsableBitArray.readBits(4);
        parsableBitArray.skipBits(bits5 + 1);
        parsableBitArray.skipBits(bits6 + 1);
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(7);
        }
        parsableBitArray.skipBits(7);
        boolean bit4 = parsableBitArray.readBit();
        if (bit4) {
            parsableBitArray.skipBits(2);
        }
        if ((parsableBitArray.readBit() ? 2 : parsableBitArray.readBits(1)) > 0 && !parsableBitArray.readBit()) {
            parsableBitArray.skipBits(1);
        }
        if (bit4) {
            parsableBitArray.skipBits(3);
        }
        parsableBitArray.skipBits(3);
        boolean bit5 = parsableBitArray.readBit();
        if (bits3 == 2 && bit5) {
            parsableBitArray.skipBit();
        }
        if (bits3 != 1 && parsableBitArray.readBit()) {
            z = true;
        }
        if (parsableBitArray.readBit()) {
            int bits7 = parsableBitArray.readBits(8);
            int bits8 = parsableBitArray.readBits(8);
            builder.setColorSpace(ColorInfo.isoColorPrimariesToColorSpace(bits7)).setColorRange(((z || bits7 != 1 || bits8 != 13 || parsableBitArray.readBits(8) != 0) ? parsableBitArray.readBits(1) : 1) != 1 ? 2 : 1).setColorTransfer(ColorInfo.isoTransferCharacteristicsToColorTransfer(bits8));
        }
        return builder.build();
    }

    private static BtrtData parseBtrtFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8);
        parsableByteArray.skipBytes(4);
        return new BtrtData(parsableByteArray.readUnsignedInt(), parsableByteArray.readUnsignedInt());
    }

    @Nullable
    public static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        int i3 = i + 8;
        String string = null;
        Integer numValueOf = null;
        int i4 = -1;
        int i5 = 0;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int i6 = parsableByteArray.readInt();
            int i7 = parsableByteArray.readInt();
            if (i7 == 1718775137) {
                numValueOf = Integer.valueOf(parsableByteArray.readInt());
            } else if (i7 == 1935894637) {
                parsableByteArray.skipBytes(4);
                string = parsableByteArray.readString(4);
            } else if (i7 == 1935894633) {
                i4 = i3;
                i5 = i6;
            }
            i3 += i6;
        }
        if (!"cenc".equals(string) && !"cbc1".equals(string) && !"cens".equals(string) && !"cbcs".equals(string)) {
            return null;
        }
        ExtractorUtil.checkContainerInput(numValueOf != null, "frma atom is mandatory");
        ExtractorUtil.checkContainerInput(i4 != -1, "schi atom is mandatory");
        TrackEncryptionBox schiFromParent = parseSchiFromParent(parsableByteArray, i4, i5, string);
        ExtractorUtil.checkContainerInput(schiFromParent != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, (TrackEncryptionBox) Util.castNonNull(schiFromParent));
    }

    @Nullable
    private static Pair<long[], long[]> parseEdts(Mp4Box.ContainerBox containerBox) {
        Mp4Box.LeafBox leafBoxOfType = containerBox.getLeafBoxOfType(1701606260);
        if (leafBoxOfType == null) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafBoxOfType.data;
        parsableByteArray.setPosition(8);
        int fullBoxVersion = parseFullBoxVersion(parsableByteArray.readInt());
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[unsignedIntToInt];
        long[] jArr2 = new long[unsignedIntToInt];
        for (int i = 0; i < unsignedIntToInt; i++) {
            jArr[i] = fullBoxVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[i] = fullBoxVersion == 1 ? parsableByteArray.readLong() : parsableByteArray.readInt();
            if (parsableByteArray.readShort() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            parsableByteArray.skipBytes(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static EsdsData parseEsdsFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8 + 4);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        if ((unsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((unsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedByte());
        }
        if ((unsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if ("audio/mpeg".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts.hd".equals(mimeTypeFromMp4ObjectType)) {
            return new EsdsData(mimeTypeFromMp4ObjectType, null, -1L, -1L);
        }
        parsableByteArray.skipBytes(4);
        long unsignedInt = parsableByteArray.readUnsignedInt();
        long unsignedInt2 = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(1);
        int expandableClassSize = parseExpandableClassSize(parsableByteArray);
        byte[] bArr = new byte[expandableClassSize];
        parsableByteArray.readBytes(bArr, 0, expandableClassSize);
        return new EsdsData(mimeTypeFromMp4ObjectType, bArr, unsignedInt2 > 0 ? unsignedInt2 : -1L, unsignedInt > 0 ? unsignedInt : -1L);
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int i = unsignedByte & 127;
        while ((unsignedByte & 128) == 128) {
            unsignedByte = parsableByteArray.readUnsignedByte();
            i = (i << 7) | (unsignedByte & 127);
        }
        return i;
    }

    public static int parseFullBoxFlags(int i) {
        return i & 16777215;
    }

    public static int parseFullBoxVersion(int i) {
        return (i >> 24) & 255;
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        return parsableByteArray.readInt();
    }

    @Nullable
    private static Metadata parseIlst(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.getPosition() < i) {
            Metadata.Entry ilstElement = MetadataUtil.parseIlstElement(parsableByteArray);
            if (ilstElement != null) {
                arrayList.add(ilstElement);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static MdhdData parseMdhd(ParsableByteArray parsableByteArray) {
        long jScaleLargeTimestamp;
        parsableByteArray.setPosition(8);
        int fullBoxVersion = parseFullBoxVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(fullBoxVersion == 0 ? 8 : 16);
        long unsignedInt = parsableByteArray.readUnsignedInt();
        int position = parsableByteArray.getPosition();
        int i = fullBoxVersion == 0 ? 4 : 8;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                z = true;
                break;
            }
            if (parsableByteArray.getData()[position + i2] != -1) {
                break;
            }
            i2++;
        }
        if (!z) {
            long unsignedInt2 = fullBoxVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
            if (unsignedInt2 != 0) {
                jScaleLargeTimestamp = Util.scaleLargeTimestamp(unsignedInt2, 1000000L, unsignedInt);
            }
            return new MdhdData(unsignedInt, jScaleLargeTimestamp, getLanguageFromCode(parsableByteArray.readUnsignedShort()));
        }
        parsableByteArray.skipBytes(i);
        jScaleLargeTimestamp = -9223372036854775807L;
        return new MdhdData(unsignedInt, jScaleLargeTimestamp, getLanguageFromCode(parsableByteArray.readUnsignedShort()));
    }

    @Nullable
    public static Metadata parseMdtaFromMeta(Mp4Box.ContainerBox containerBox) {
        Mp4Box.LeafBox leafBoxOfType = containerBox.getLeafBoxOfType(1751411826);
        Mp4Box.LeafBox leafBoxOfType2 = containerBox.getLeafBoxOfType(1801812339);
        Mp4Box.LeafBox leafBoxOfType3 = containerBox.getLeafBoxOfType(1768715124);
        if (leafBoxOfType == null || leafBoxOfType2 == null || leafBoxOfType3 == null || parseHdlr(leafBoxOfType.data) != TYPE_mdta) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafBoxOfType2.data;
        parsableByteArray.setPosition(12);
        int i = parsableByteArray.readInt();
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            strArr[i2] = parsableByteArray.readString(i3 - 8);
        }
        ParsableByteArray parsableByteArray2 = leafBoxOfType3.data;
        parsableByteArray2.setPosition(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray2.bytesLeft() > 8) {
            int position = parsableByteArray2.getPosition();
            int i4 = parsableByteArray2.readInt();
            int i5 = parsableByteArray2.readInt() - 1;
            if (i5 < 0 || i5 >= i) {
                Log.w(TAG, "Skipped metadata with unknown key index: " + i5);
            } else {
                MdtaMetadataEntry mdtaMetadataEntryFromIlst = MetadataUtil.parseMdtaMetadataEntryFromIlst(parsableByteArray2, position + i4, strArr[i5]);
                if (mdtaMetadataEntryFromIlst != null) {
                    arrayList.add(mdtaMetadataEntryFromIlst);
                }
            }
            parsableByteArray2.setPosition(position + i4);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static void parseMetaDataSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 8 + 8);
        if (i == 1835365492) {
            parsableByteArray.readNullTerminatedString();
            String nullTerminatedString = parsableByteArray.readNullTerminatedString();
            if (nullTerminatedString != null) {
                stsdData.format = new Format.Builder().setId(i3).setSampleMimeType(nullTerminatedString).build();
            }
        }
    }

    public static Mp4TimestampData parseMvhd(ParsableByteArray parsableByteArray) {
        long unsignedInt;
        long unsignedInt2;
        parsableByteArray.setPosition(8);
        if (parseFullBoxVersion(parsableByteArray.readInt()) == 0) {
            unsignedInt = parsableByteArray.readUnsignedInt();
            unsignedInt2 = parsableByteArray.readUnsignedInt();
        } else {
            unsignedInt = parsableByteArray.readLong();
            unsignedInt2 = parsableByteArray.readLong();
        }
        return new Mp4TimestampData(unsignedInt, unsignedInt2, parsableByteArray.readUnsignedInt());
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8);
        return parsableByteArray.readUnsignedIntToInt() / parsableByteArray.readUnsignedIntToInt();
    }

    @Nullable
    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int i4 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1886547818) {
                return Arrays.copyOfRange(parsableByteArray.getData(), i3, i4 + i3);
            }
            i3 += i4;
        }
        return null;
    }

    @Nullable
    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        Pair<Integer, TrackEncryptionBox> commonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int i3 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i3 > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == 1936289382 && (commonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, i3)) != null) {
                return commonEncryptionSinfFromParent;
            }
            position += i3;
        }
        return null;
    }

    @Nullable
    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            parsableByteArray.setPosition(i5);
            int i6 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1952804451) {
                int fullBoxVersion = parseFullBoxVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (fullBoxVersion == 0) {
                    parsableByteArray.skipBytes(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int unsignedByte = parsableByteArray.readUnsignedByte();
                    i3 = unsignedByte & 15;
                    i4 = (unsignedByte & 240) >> 4;
                }
                boolean z = parsableByteArray.readUnsignedByte() == 1;
                int unsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, 16);
                if (z && unsignedByte2 == 0) {
                    int unsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[unsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, unsignedByte3);
                }
                return new TrackEncryptionBox(z, str, unsignedByte2, bArr2, i4, i3, bArr);
            }
            i5 += i6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static TrackSampleTable parseStbl(Track track, Mp4Box.ContainerBox containerBox, GaplessInfoHolder gaplessInfoHolder) throws ParserException {
        SampleSizeBox stz2SampleSizeBox;
        boolean z;
        int unsignedIntToInt;
        int unsignedIntToInt2;
        int unsignedIntToInt3;
        int fixedSampleSize;
        String str;
        int i;
        int i2;
        long[] jArr;
        int[] iArr;
        long[] jArrCopyOf;
        int[] iArrCopyOf;
        int i3;
        int i4;
        boolean z2;
        int i5;
        Track trackCopyWithFormat;
        int[] iArr2;
        long[] jArr2;
        long j;
        long j2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        long j3;
        long[] jArr3;
        int[] iArr3;
        int i12;
        int[] iArr4;
        boolean z3;
        int i13;
        int i14;
        Track trackCopyWithFormat2 = track;
        Mp4Box.LeafBox leafBoxOfType = containerBox.getLeafBoxOfType(1937011578);
        if (leafBoxOfType != null) {
            stz2SampleSizeBox = new StszSampleSizeBox(leafBoxOfType, trackCopyWithFormat2.format);
        } else {
            Mp4Box.LeafBox leafBoxOfType2 = containerBox.getLeafBoxOfType(1937013298);
            if (leafBoxOfType2 == null) {
                throw ParserException.createForMalformedContainer("Track has no sample table size information", null);
            }
            stz2SampleSizeBox = new Stz2SampleSizeBox(leafBoxOfType2);
        }
        int sampleCount = stz2SampleSizeBox.getSampleCount();
        if (sampleCount == 0) {
            return new TrackSampleTable(track, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        if (trackCopyWithFormat2.type == 2) {
            long j4 = trackCopyWithFormat2.mediaDurationUs;
            if (j4 > 0) {
                trackCopyWithFormat2 = trackCopyWithFormat2.copyWithFormat(trackCopyWithFormat2.format.buildUpon().setFrameRate(sampleCount / (j4 / 1000000.0f)).build());
            }
        }
        Mp4Box.LeafBox leafBoxOfType3 = containerBox.getLeafBoxOfType(1937007471);
        if (leafBoxOfType3 == null) {
            leafBoxOfType3 = (Mp4Box.LeafBox) Assertions.checkNotNull(containerBox.getLeafBoxOfType(1668232756));
            z = true;
        } else {
            z = false;
        }
        ParsableByteArray parsableByteArray = leafBoxOfType3.data;
        ParsableByteArray parsableByteArray2 = ((Mp4Box.LeafBox) Assertions.checkNotNull(containerBox.getLeafBoxOfType(1937011555))).data;
        ParsableByteArray parsableByteArray3 = ((Mp4Box.LeafBox) Assertions.checkNotNull(containerBox.getLeafBoxOfType(1937011827))).data;
        Mp4Box.LeafBox leafBoxOfType4 = containerBox.getLeafBoxOfType(1937011571);
        ParsableByteArray parsableByteArray4 = leafBoxOfType4 != null ? leafBoxOfType4.data : null;
        Mp4Box.LeafBox leafBoxOfType5 = containerBox.getLeafBoxOfType(1668576371);
        ParsableByteArray parsableByteArray5 = leafBoxOfType5 != null ? leafBoxOfType5.data : null;
        ChunkIterator chunkIterator = new ChunkIterator(parsableByteArray2, parsableByteArray, z);
        parsableByteArray3.setPosition(12);
        int unsignedIntToInt4 = parsableByteArray3.readUnsignedIntToInt() - 1;
        int unsignedIntToInt5 = parsableByteArray3.readUnsignedIntToInt();
        int unsignedIntToInt6 = parsableByteArray3.readUnsignedIntToInt();
        if (parsableByteArray5 != null) {
            parsableByteArray5.setPosition(12);
            unsignedIntToInt = parsableByteArray5.readUnsignedIntToInt();
        } else {
            unsignedIntToInt = 0;
        }
        if (parsableByteArray4 != null) {
            parsableByteArray4.setPosition(12);
            unsignedIntToInt2 = parsableByteArray4.readUnsignedIntToInt();
            if (unsignedIntToInt2 > 0) {
                unsignedIntToInt3 = parsableByteArray4.readUnsignedIntToInt() - 1;
                fixedSampleSize = stz2SampleSizeBox.getFixedSampleSize();
                str = trackCopyWithFormat2.format.sampleMimeType;
                if (fixedSampleSize == -1 && ("audio/raw".equals(str) || "audio/g711-mlaw".equals(str) || "audio/g711-alaw".equals(str)) && unsignedIntToInt4 == 0 && unsignedIntToInt == 0 && unsignedIntToInt2 == 0) {
                    long[] jArr4 = new long[sampleCount];
                    int[] iArr5 = new int[sampleCount];
                    long[] jArr5 = new long[sampleCount];
                    int[] iArr6 = new int[sampleCount];
                    int i15 = unsignedIntToInt4;
                    int unsignedIntToInt7 = unsignedIntToInt3;
                    int i16 = unsignedIntToInt;
                    i = 0;
                    int i17 = 0;
                    int i18 = 0;
                    int unsignedIntToInt8 = 0;
                    long j5 = 0;
                    long j6 = 0;
                    long j7 = 0;
                    Track track2 = trackCopyWithFormat2;
                    int i19 = 0;
                    while (true) {
                        if (i19 >= sampleCount) {
                            i2 = unsignedIntToInt2;
                            jArr = jArr4;
                            iArr = iArr5;
                            jArrCopyOf = jArr5;
                            iArrCopyOf = iArr6;
                            i3 = i17;
                            i4 = i18;
                            break;
                        }
                        long j8 = j7;
                        int i20 = i17;
                        boolean zMoveNext = true;
                        while (i20 == 0) {
                            zMoveNext = chunkIterator.moveNext();
                            if (!zMoveNext) {
                                break;
                            }
                            int i21 = unsignedIntToInt6;
                            long j9 = chunkIterator.offset;
                            i20 = chunkIterator.numSamples;
                            j8 = j9;
                            unsignedIntToInt6 = i21;
                            unsignedIntToInt2 = unsignedIntToInt2;
                            sampleCount = sampleCount;
                        }
                        int i22 = sampleCount;
                        int i23 = unsignedIntToInt6;
                        i2 = unsignedIntToInt2;
                        if (!zMoveNext) {
                            Log.w(TAG, "Unexpected end of chunk data");
                            long[] jArrCopyOf2 = Arrays.copyOf(jArr4, i19);
                            int[] iArrCopyOf2 = Arrays.copyOf(iArr5, i19);
                            jArrCopyOf = Arrays.copyOf(jArr5, i19);
                            iArrCopyOf = Arrays.copyOf(iArr6, i19);
                            jArr = jArrCopyOf2;
                            iArr = iArrCopyOf2;
                            i4 = i18;
                            sampleCount = i19;
                            i3 = i20;
                            break;
                        }
                        if (parsableByteArray5 != null) {
                            while (unsignedIntToInt8 == 0 && i16 > 0) {
                                unsignedIntToInt8 = parsableByteArray5.readUnsignedIntToInt();
                                i18 = parsableByteArray5.readInt();
                                i16--;
                            }
                            unsignedIntToInt8--;
                        }
                        int i24 = i18;
                        jArr4[i19] = j8;
                        int nextSampleSize = stz2SampleSizeBox.readNextSampleSize();
                        iArr5[i19] = nextSampleSize;
                        ChunkIterator chunkIterator2 = chunkIterator;
                        SampleSizeBox sampleSizeBox = stz2SampleSizeBox;
                        j6 += (long) nextSampleSize;
                        if (nextSampleSize > i) {
                            i = nextSampleSize;
                        }
                        jArr5[i19] = j5 + ((long) i24);
                        iArr6[i19] = parsableByteArray4 == null ? 1 : 0;
                        if (i19 == unsignedIntToInt7) {
                            iArr6[i19] = 1;
                            i9 = i2 - 1;
                            if (i9 > 0) {
                                unsignedIntToInt7 = ((ParsableByteArray) Assertions.checkNotNull(parsableByteArray4)).readUnsignedIntToInt() - 1;
                            }
                            i6 = unsignedIntToInt7;
                            i7 = i24;
                            i8 = i23;
                        } else {
                            i6 = unsignedIntToInt7;
                            i7 = i24;
                            i8 = i23;
                            i9 = i2;
                        }
                        j5 += (long) i8;
                        unsignedIntToInt5--;
                        if (unsignedIntToInt5 != 0 || i15 <= 0) {
                            i10 = i8;
                            i11 = i15;
                        } else {
                            int unsignedIntToInt9 = parsableByteArray3.readUnsignedIntToInt();
                            i10 = parsableByteArray3.readInt();
                            i11 = i15 - 1;
                            unsignedIntToInt5 = unsignedIntToInt9;
                        }
                        int i25 = i10;
                        long j10 = j8 + ((long) iArr5[i19]);
                        i17 = i20 - 1;
                        i19++;
                        j7 = j10;
                        i18 = i7;
                        unsignedIntToInt7 = i6;
                        sampleCount = i22;
                        chunkIterator = chunkIterator2;
                        int i26 = i11;
                        unsignedIntToInt6 = i25;
                        i15 = i26;
                        unsignedIntToInt2 = i9;
                        stz2SampleSizeBox = sampleSizeBox;
                    }
                    long j11 = j5 + ((long) i4);
                    if (parsableByteArray5 != null) {
                        while (i16 > 0) {
                            if (parsableByteArray5.readUnsignedIntToInt() != 0) {
                                z2 = false;
                                break;
                            }
                            parsableByteArray5.readInt();
                            i16--;
                        }
                        z2 = true;
                        if (i2 != 0 && unsignedIntToInt5 == 0 && i3 == 0 && i15 == 0) {
                            i5 = unsignedIntToInt8;
                            if (i5 == 0 && z2) {
                                trackCopyWithFormat = track2;
                            }
                            iArr2 = iArr;
                            jArr2 = jArrCopyOf;
                            j = j11;
                            j2 = j6;
                        } else {
                            i5 = unsignedIntToInt8;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("Inconsistent stbl box for track ");
                        trackCopyWithFormat = track2;
                        sb.append(trackCopyWithFormat.id);
                        sb.append(": remainingSynchronizationSamples ");
                        sb.append(i2);
                        sb.append(", remainingSamplesAtTimestampDelta ");
                        sb.append(unsignedIntToInt5);
                        sb.append(", remainingSamplesInChunk ");
                        sb.append(i3);
                        sb.append(", remainingTimestampDeltaChanges ");
                        sb.append(i15);
                        sb.append(", remainingSamplesAtTimestampOffset ");
                        sb.append(i5);
                        sb.append(z2 ? ", ctts invalid" : "");
                        Log.w(TAG, sb.toString());
                        iArr2 = iArr;
                        jArr2 = jArrCopyOf;
                        j = j11;
                        j2 = j6;
                    } else {
                        z2 = true;
                        if (i2 != 0) {
                            i5 = unsignedIntToInt8;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Inconsistent stbl box for track ");
                            trackCopyWithFormat = track2;
                            sb2.append(trackCopyWithFormat.id);
                            sb2.append(": remainingSynchronizationSamples ");
                            sb2.append(i2);
                            sb2.append(", remainingSamplesAtTimestampDelta ");
                            sb2.append(unsignedIntToInt5);
                            sb2.append(", remainingSamplesInChunk ");
                            sb2.append(i3);
                            sb2.append(", remainingTimestampDeltaChanges ");
                            sb2.append(i15);
                            sb2.append(", remainingSamplesAtTimestampOffset ");
                            sb2.append(i5);
                            sb2.append(z2 ? ", ctts invalid" : "");
                            Log.w(TAG, sb2.toString());
                            iArr2 = iArr;
                            jArr2 = jArrCopyOf;
                            j = j11;
                            j2 = j6;
                        }
                    }
                } else {
                    int i27 = chunkIterator.length;
                    long[] jArr6 = new long[i27];
                    int[] iArr7 = new int[i27];
                    while (chunkIterator.moveNext()) {
                        int i28 = chunkIterator.index;
                        jArr6[i28] = chunkIterator.offset;
                        iArr7[i28] = chunkIterator.numSamples;
                    }
                    FixedSampleSizeRechunker.Results resultsRechunk = FixedSampleSizeRechunker.rechunk(fixedSampleSize, jArr6, iArr7, unsignedIntToInt6);
                    jArr = resultsRechunk.offsets;
                    int[] iArr8 = resultsRechunk.sizes;
                    int i29 = resultsRechunk.maximumSize;
                    long[] jArr7 = resultsRechunk.timestamps;
                    iArrCopyOf = resultsRechunk.flags;
                    long j12 = resultsRechunk.duration;
                    j2 = resultsRechunk.totalSize;
                    trackCopyWithFormat = trackCopyWithFormat2;
                    iArr2 = iArr8;
                    i = i29;
                    jArr2 = jArr7;
                    j = j12;
                }
                int[] iArr9 = iArrCopyOf;
                j3 = trackCopyWithFormat.mediaDurationUs;
                if (j3 > 0) {
                    long jScaleLargeValue = Util.scaleLargeValue(j2 * 8, 1000000L, j3, RoundingMode.HALF_DOWN);
                    if (jScaleLargeValue > 0 && jScaleLargeValue < 2147483647L) {
                        trackCopyWithFormat = trackCopyWithFormat.copyWithFormat(trackCopyWithFormat.format.buildUpon().setAverageBitrate((int) jScaleLargeValue).build());
                    }
                }
                int[] iArr10 = iArr9;
                long jScaleLargeTimestamp = Util.scaleLargeTimestamp(j, 1000000L, trackCopyWithFormat.timescale);
                jArr3 = trackCopyWithFormat.editListDurations;
                if (jArr3 != null) {
                    Util.scaleLargeTimestampsInPlace(jArr2, 1000000L, trackCopyWithFormat.timescale);
                    return new TrackSampleTable(trackCopyWithFormat, jArr, iArr2, i, jArr2, iArr10, jScaleLargeTimestamp);
                }
                if (jArr3.length == 1 && trackCopyWithFormat.type == 1 && jArr2.length >= 2) {
                    long j13 = ((long[]) Assertions.checkNotNull(trackCopyWithFormat.editListMediaTimes))[0];
                    long jScaleLargeTimestamp2 = Util.scaleLargeTimestamp(trackCopyWithFormat.editListDurations[0], trackCopyWithFormat.timescale, trackCopyWithFormat.movieTimescale) + j13;
                    if (canApplyEditWithGaplessInfo(jArr2, j, j13, jScaleLargeTimestamp2)) {
                        long j14 = j - jScaleLargeTimestamp2;
                        long jScaleLargeTimestamp3 = Util.scaleLargeTimestamp(j13 - jArr2[0], trackCopyWithFormat.format.sampleRate, trackCopyWithFormat.timescale);
                        long jScaleLargeTimestamp4 = Util.scaleLargeTimestamp(j14, trackCopyWithFormat.format.sampleRate, trackCopyWithFormat.timescale);
                        if ((jScaleLargeTimestamp3 != 0 || jScaleLargeTimestamp4 != 0) && jScaleLargeTimestamp3 <= 2147483647L && jScaleLargeTimestamp4 <= 2147483647L) {
                            gaplessInfoHolder.encoderDelay = (int) jScaleLargeTimestamp3;
                            gaplessInfoHolder.encoderPadding = (int) jScaleLargeTimestamp4;
                            Util.scaleLargeTimestampsInPlace(jArr2, 1000000L, trackCopyWithFormat.timescale);
                            return new TrackSampleTable(trackCopyWithFormat, jArr, iArr2, i, jArr2, iArr10, Util.scaleLargeTimestamp(trackCopyWithFormat.editListDurations[0], 1000000L, trackCopyWithFormat.movieTimescale));
                        }
                    }
                }
                long[] jArr8 = trackCopyWithFormat.editListDurations;
                if (jArr8.length == 1 && jArr8[0] == 0) {
                    long j15 = ((long[]) Assertions.checkNotNull(trackCopyWithFormat.editListMediaTimes))[0];
                    for (int i30 = 0; i30 < jArr2.length; i30++) {
                        jArr2[i30] = Util.scaleLargeTimestamp(jArr2[i30] - j15, 1000000L, trackCopyWithFormat.timescale);
                    }
                    return new TrackSampleTable(trackCopyWithFormat, jArr, iArr2, i, jArr2, iArr10, Util.scaleLargeTimestamp(j - j15, 1000000L, trackCopyWithFormat.timescale));
                }
                boolean z4 = trackCopyWithFormat.type == 1;
                int[] iArr11 = new int[jArr8.length];
                int[] iArr12 = new int[jArr8.length];
                long[] jArr9 = (long[]) Assertions.checkNotNull(trackCopyWithFormat.editListMediaTimes);
                int i31 = 0;
                boolean z5 = false;
                int i32 = 0;
                int i33 = 0;
                while (true) {
                    long[] jArr10 = trackCopyWithFormat.editListDurations;
                    if (i31 >= jArr10.length) {
                        break;
                    }
                    int i34 = i;
                    long j16 = jArr9[i31];
                    if (j16 != -1) {
                        long j17 = jArr10[i31];
                        iArr3 = iArr2;
                        i12 = sampleCount;
                        boolean z6 = z5;
                        int i35 = i32;
                        long jScaleLargeTimestamp5 = Util.scaleLargeTimestamp(j17, trackCopyWithFormat.timescale, trackCopyWithFormat.movieTimescale);
                        iArr11[i31] = Util.binarySearchFloor(jArr2, j16, true, true);
                        long j18 = j16 + jScaleLargeTimestamp5;
                        iArr12[i31] = Util.binarySearchCeil(jArr2, j18, z4, false);
                        int i36 = iArr11[i31];
                        while (true) {
                            i14 = iArr11[i31];
                            iArr4 = iArr10;
                            if (i14 < 0 || (iArr4[i14] & 1) != 0) {
                                break;
                            }
                            iArr11[i31] = i14 - 1;
                            iArr10 = iArr4;
                        }
                        if (i14 < 0) {
                            iArr11[i31] = i36;
                            while (true) {
                                int i37 = iArr11[i31];
                                if (i37 >= iArr12[i31] || (iArr4[i37] & 1) != 0) {
                                    break;
                                }
                                iArr11[i31] = i37 + 1;
                            }
                        }
                        if (trackCopyWithFormat.type == 2 && iArr11[i31] != iArr12[i31]) {
                            while (true) {
                                int i38 = iArr12[i31];
                                if (i38 >= jArr2.length - 1 || jArr2[i38 + 1] > j18) {
                                    break;
                                }
                                iArr12[i31] = i38 + 1;
                            }
                        }
                        int i39 = iArr12[i31];
                        int i40 = iArr11[i31];
                        i13 = i35 + (i39 - i40);
                        z3 = z6 | (i33 != i40);
                        i33 = i39;
                    } else {
                        iArr3 = iArr2;
                        i12 = sampleCount;
                        int i41 = i32;
                        iArr4 = iArr10;
                        z3 = z5;
                        i13 = i41;
                    }
                    i31++;
                    iArr10 = iArr4;
                    z5 = z3;
                    iArr2 = iArr3;
                    i32 = i13;
                    i = i34;
                    sampleCount = i12;
                }
                int[] iArr13 = iArr2;
                int i42 = i32;
                int i43 = i;
                int[] iArr14 = iArr10;
                boolean z7 = z5 | (i42 != sampleCount);
                long[] jArr11 = z7 ? new long[i42] : jArr;
                int[] iArr15 = z7 ? new int[i42] : iArr13;
                int i44 = z7 ? 0 : i43;
                int[] iArr16 = z7 ? new int[i42] : iArr14;
                long[] jArr12 = new long[i42];
                int i45 = i44;
                int i46 = 0;
                int i47 = 0;
                long j19 = 0;
                boolean z8 = false;
                while (i46 < trackCopyWithFormat.editListDurations.length) {
                    long j20 = trackCopyWithFormat.editListMediaTimes[i46];
                    int i48 = iArr11[i46];
                    int[] iArr17 = iArr11;
                    int i49 = iArr12[i46];
                    int[] iArr18 = iArr12;
                    if (z7) {
                        int i50 = i49 - i48;
                        System.arraycopy(jArr, i48, jArr11, i47, i50);
                        System.arraycopy(iArr13, i48, iArr15, i47, i50);
                        System.arraycopy(iArr14, i48, iArr16, i47, i50);
                    }
                    int i51 = i45;
                    while (i48 < i49) {
                        int i52 = i49;
                        int[] iArr19 = iArr14;
                        long jScaleLargeTimestamp6 = Util.scaleLargeTimestamp(j19, 1000000L, trackCopyWithFormat.movieTimescale);
                        long[] jArr13 = jArr11;
                        long[] jArr14 = jArr;
                        long jScaleLargeTimestamp7 = Util.scaleLargeTimestamp(jArr2[i48] - j20, 1000000L, trackCopyWithFormat.timescale);
                        if (jScaleLargeTimestamp7 < 0) {
                            z8 = true;
                        }
                        jArr12[i47] = jScaleLargeTimestamp6 + jScaleLargeTimestamp7;
                        if (z7 && iArr15[i47] > i51) {
                            i51 = iArr13[i48];
                        }
                        i47++;
                        i48++;
                        iArr14 = iArr19;
                        i49 = i52;
                        jArr = jArr14;
                        jArr11 = jArr13;
                    }
                    j19 += trackCopyWithFormat.editListDurations[i46];
                    i46++;
                    iArr14 = iArr14;
                    i45 = i51;
                    iArr11 = iArr17;
                    iArr12 = iArr18;
                    jArr11 = jArr11;
                }
                long[] jArr15 = jArr11;
                long jScaleLargeTimestamp8 = Util.scaleLargeTimestamp(j19, 1000000L, trackCopyWithFormat.movieTimescale);
                if (z8) {
                    trackCopyWithFormat = trackCopyWithFormat.copyWithFormat(trackCopyWithFormat.format.buildUpon().setHasPrerollSamples(true).build());
                }
                return new TrackSampleTable(trackCopyWithFormat, jArr15, iArr15, i45, jArr12, iArr16, jScaleLargeTimestamp8);
            }
            parsableByteArray4 = null;
        } else {
            unsignedIntToInt2 = 0;
        }
        unsignedIntToInt3 = -1;
        fixedSampleSize = stz2SampleSizeBox.getFixedSampleSize();
        str = trackCopyWithFormat2.format.sampleMimeType;
        if (fixedSampleSize == -1 && ("audio/raw".equals(str) || "audio/g711-mlaw".equals(str) || "audio/g711-alaw".equals(str)) && unsignedIntToInt4 == 0 && unsignedIntToInt == 0 && unsignedIntToInt2 == 0) {
        }
        int[] iArr92 = iArrCopyOf;
        j3 = trackCopyWithFormat.mediaDurationUs;
        if (j3 > 0) {
        }
        int[] iArr102 = iArr92;
        long jScaleLargeTimestamp9 = Util.scaleLargeTimestamp(j, 1000000L, trackCopyWithFormat.timescale);
        jArr3 = trackCopyWithFormat.editListDurations;
        if (jArr3 != null) {
        }
    }

    @Nullable
    private static EyesData parseStereoViewBox(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        parsableByteArray.setPosition(i + 8);
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int i3 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i3 > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == 1937011305) {
                parsableByteArray.skipBytes(4);
                int unsignedByte = parsableByteArray.readUnsignedByte() & 15;
                return new EyesData(new StriData((unsignedByte & 1) == 1, (unsignedByte & 2) == 2, (unsignedByte & 8) == 8));
            }
            position += i3;
        }
        return null;
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, TkhdData tkhdData, @Nullable String str, @Nullable DrmInitData drmInitData, boolean z) throws ParserException {
        parsableByteArray.setPosition(12);
        int i = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(i);
        for (int i2 = 0; i2 < i; i2++) {
            int position = parsableByteArray.getPosition();
            int i3 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i3 > 0, "childAtomSize must be positive");
            int i4 = parsableByteArray.readInt();
            if (i4 == 1635148593 || i4 == 1635148595 || i4 == 1701733238 || i4 == 1831958048 || i4 == 1836070006 || i4 == 1752589105 || i4 == 1751479857 || i4 == 1932670515 || i4 == 1211250227 || i4 == 1748121139 || i4 == 1987063864 || i4 == 1987063865 || i4 == 1635135537 || i4 == 1685479798 || i4 == 1685479729 || i4 == 1685481573 || i4 == 1685481521 || i4 == 1634760241) {
                parseVideoSampleEntry(parsableByteArray, i4, position, i3, tkhdData.id, str, tkhdData.rotationDegrees, drmInitData, stsdData, i2);
            } else if (i4 == 1836069985 || i4 == 1701733217 || i4 == 1633889587 || i4 == 1700998451 || i4 == 1633889588 || i4 == 1835823201 || i4 == 1685353315 || i4 == 1685353317 || i4 == 1685353320 || i4 == 1685353324 || i4 == 1685353336 || i4 == 1935764850 || i4 == 1935767394 || i4 == 1819304813 || i4 == 1936684916 || i4 == 1953984371 || i4 == 778924082 || i4 == 778924083 || i4 == 1835557169 || i4 == 1835560241 || i4 == 1634492771 || i4 == 1634492791 || i4 == 1970037111 || i4 == 1332770163 || i4 == 1716281667 || i4 == 1767992678 || i4 == 1768973165 || i4 == 1718641517) {
                parseAudioSampleEntry(parsableByteArray, i4, position, i3, tkhdData.id, str, z, drmInitData, stsdData, i2);
            } else if (i4 == 1414810956 || i4 == 1954034535 || i4 == 2004251764 || i4 == 1937010800 || i4 == 1664495672 || i4 == 1836070003) {
                parseTextSampleEntry(parsableByteArray, i4, position, i3, tkhdData, str, stsdData);
            } else if (i4 == 1835365492) {
                parseMetaDataSampleEntry(parsableByteArray, i4, position, tkhdData.id, stsdData);
            } else if (i4 == 1667329389) {
                stsdData.format = new Format.Builder().setId(tkhdData.id).setSampleMimeType("application/x-camera-motion").build();
            }
            parsableByteArray.setPosition(position + i3);
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, TkhdData tkhdData, @Nullable String str, StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 8 + 8);
        String str2 = "application/ttml+xml";
        ImmutableList immutableListOf = null;
        long j = Long.MAX_VALUE;
        if (i != 1414810956) {
            if (i == 1954034535) {
                int i4 = (i3 - 8) - 8;
                byte[] bArr = new byte[i4];
                parsableByteArray.readBytes(bArr, 0, i4);
                immutableListOf = ImmutableList.of(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i == 1937010800) {
                j = 0;
            } else if (i == 1664495672) {
                stsdData.requiredSampleTransformation = 1;
                str2 = "application/x-mp4-cea-608";
            } else {
                if (i != 1836070003) {
                    throw new IllegalStateException();
                }
                int position = parsableByteArray.getPosition();
                parsableByteArray.skipBytes(4);
                if (parsableByteArray.readInt() == 1702061171) {
                    EsdsData esdsFromParent = parseEsdsFromParent(parsableByteArray, position);
                    if (esdsFromParent.initializationData == null || esdsFromParent.initializationData.length != 64) {
                        return;
                    }
                    immutableListOf = ImmutableList.of(Util.getUtf8Bytes(formatVobsubIdx(esdsFromParent.initializationData, tkhdData.width, tkhdData.height)));
                    str2 = "application/vobsub";
                } else {
                    str2 = null;
                }
            }
        }
        if (str2 != null) {
            stsdData.format = new Format.Builder().setId(tkhdData.id).setSampleMimeType(str2).setLanguage(str).setSubsampleOffsetUs(j).setInitializationData(immutableListOf).build();
        }
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        boolean z;
        parsableByteArray.setPosition(8);
        int fullBoxVersion = parseFullBoxVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(fullBoxVersion == 0 ? 8 : 16);
        int i = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        int i2 = fullBoxVersion == 0 ? 4 : 8;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                z = true;
                break;
            }
            if (parsableByteArray.getData()[position + i3] != -1) {
                z = false;
                break;
            }
            i3++;
        }
        long j = -9223372036854775807L;
        if (z) {
            parsableByteArray.skipBytes(i2);
        } else {
            long unsignedInt = fullBoxVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
            if (unsignedInt != 0) {
                j = unsignedInt;
            }
        }
        parsableByteArray.skipBytes(10);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(4);
        int i4 = parsableByteArray.readInt();
        int i5 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int i6 = parsableByteArray.readInt();
        int i7 = parsableByteArray.readInt();
        int i8 = (i4 == 0 && i5 == 65536 && (i6 == -65536 || i6 == 65536) && i7 == 0) ? 90 : (i4 == 0 && i5 == -65536 && (i6 == 65536 || i6 == -65536) && i7 == 0) ? 270 : ((i4 == -65536 || i4 == 65536) && i5 == 0 && i6 == 0 && i7 == -65536) ? EffectConstants.ROTATION_DEGREES_180 : 0;
        parsableByteArray.skipBytes(16);
        short s = parsableByteArray.readShort();
        parsableByteArray.skipBytes(2);
        return new TkhdData(i, j, unsignedShort, i8, s, parsableByteArray.readShort());
    }

    @Nullable
    public static Track parseTrak(Mp4Box.ContainerBox containerBox, Mp4Box.LeafBox leafBox, long j, @Nullable DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        Mp4Box.LeafBox leafBox2;
        long j2;
        long[] jArr;
        long[] jArr2;
        Format formatBuild;
        Mp4Box.ContainerBox containerBoxOfType;
        Pair<long[], long[]> edts;
        Mp4Box.ContainerBox containerBox2 = (Mp4Box.ContainerBox) Assertions.checkNotNull(containerBox.getContainerBoxOfType(1835297121));
        int trackTypeForHdlr = getTrackTypeForHdlr(parseHdlr(((Mp4Box.LeafBox) Assertions.checkNotNull(containerBox2.getLeafBoxOfType(1751411826))).data));
        if (trackTypeForHdlr == -1) {
            return null;
        }
        TkhdData tkhd = parseTkhd(((Mp4Box.LeafBox) Assertions.checkNotNull(containerBox.getLeafBoxOfType(1953196132))).data);
        if (j == -9223372036854775807L) {
            leafBox2 = leafBox;
            j2 = tkhd.duration;
        } else {
            leafBox2 = leafBox;
            j2 = j;
        }
        long j3 = parseMvhd(leafBox2.data).timescale;
        long jScaleLargeTimestamp = j2 != -9223372036854775807L ? Util.scaleLargeTimestamp(j2, 1000000L, j3) : -9223372036854775807L;
        Mp4Box.ContainerBox containerBox3 = (Mp4Box.ContainerBox) Assertions.checkNotNull(((Mp4Box.ContainerBox) Assertions.checkNotNull(containerBox2.getContainerBoxOfType(1835626086))).getContainerBoxOfType(1937007212));
        MdhdData mdhd = parseMdhd(((Mp4Box.LeafBox) Assertions.checkNotNull(containerBox2.getLeafBoxOfType(1835296868))).data);
        Mp4Box.LeafBox leafBoxOfType = containerBox3.getLeafBoxOfType(1937011556);
        if (leafBoxOfType == null) {
            throw ParserException.createForMalformedContainer("Malformed sample table (stbl) missing sample description (stsd)", null);
        }
        StsdData stsd = parseStsd(leafBoxOfType.data, tkhd, mdhd.language, drmInitData, z2);
        if (z || (containerBoxOfType = containerBox.getContainerBoxOfType(1701082227)) == null || (edts = parseEdts(containerBoxOfType)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) edts.first;
            jArr2 = (long[]) edts.second;
            jArr = jArr3;
        }
        if (stsd.format == null) {
            return null;
        }
        if (tkhd.alternateGroup != 0) {
            Mp4AlternateGroupData mp4AlternateGroupData = new Mp4AlternateGroupData(tkhd.alternateGroup);
            Format.Builder builderBuildUpon = stsd.format.buildUpon();
            Metadata metadata = stsd.format.metadata;
            formatBuild = builderBuildUpon.setMetadata(metadata != null ? metadata.copyWithAppendedEntries(mp4AlternateGroupData) : new Metadata(mp4AlternateGroupData)).build();
        } else {
            formatBuild = stsd.format;
        }
        return new Track(tkhd.id, trackTypeForHdlr, mdhd.timescale, j3, jScaleLargeTimestamp, mdhd.mediaDurationUs, formatBuild, stsd.requiredSampleTransformation, stsd.trackEncryptionBoxes, stsd.nalUnitLengthFieldLength, jArr, jArr2);
    }

    public static List<TrackSampleTable> parseTraks(Mp4Box.ContainerBox containerBox, GaplessInfoHolder gaplessInfoHolder, long j, @Nullable DrmInitData drmInitData, boolean z, boolean z2, u42<Track, Track> u42Var) throws ParserException {
        Track trackApply;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < containerBox.containerChildren.size(); i++) {
            Mp4Box.ContainerBox containerBox2 = containerBox.containerChildren.get(i);
            if (containerBox2.type == 1953653099 && (trackApply = u42Var.apply(parseTrak(containerBox2, (Mp4Box.LeafBox) Assertions.checkNotNull(containerBox.getLeafBoxOfType(1836476516)), j, drmInitData, z, z2))) != null) {
                arrayList.add(parseStbl(trackApply, (Mp4Box.ContainerBox) Assertions.checkNotNull(((Mp4Box.ContainerBox) Assertions.checkNotNull(((Mp4Box.ContainerBox) Assertions.checkNotNull(containerBox2.getContainerBoxOfType(1835297121))).getContainerBoxOfType(1835626086))).getContainerBoxOfType(1937007212)), gaplessInfoHolder));
            }
        }
        return arrayList;
    }

    public static Metadata parseUdta(Mp4Box.LeafBox leafBox) {
        ParsableByteArray parsableByteArray = leafBox.data;
        parsableByteArray.setPosition(8);
        Metadata metadata = new Metadata(new Metadata.Entry[0]);
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int i = parsableByteArray.readInt();
            int i2 = parsableByteArray.readInt();
            if (i2 == 1835365473) {
                parsableByteArray.setPosition(position);
                metadata = metadata.copyWithAppendedEntriesFrom(parseUdtaMeta(parsableByteArray, position + i));
            } else if (i2 == 1936553057) {
                parsableByteArray.setPosition(position);
                metadata = metadata.copyWithAppendedEntriesFrom(SmtaAtomUtil.parseSmta(parsableByteArray, position + i));
            } else if (i2 == -1451722374) {
                metadata = metadata.copyWithAppendedEntriesFrom(parseXyz(parsableByteArray));
            }
            parsableByteArray.setPosition(position + i);
        }
        return metadata;
    }

    @Nullable
    private static Metadata parseUdtaMeta(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        maybeSkipRemainingMetaBoxHeaderBytes(parsableByteArray);
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int i2 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1768715124) {
                parsableByteArray.setPosition(position);
                return parseIlst(parsableByteArray, position + i2);
            }
            parsableByteArray.setPosition(position + i2);
        }
        return null;
    }

    @Nullable
    public static VexuData parseVideoExtendedUsageBox(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        parsableByteArray.setPosition(i + 8);
        int position = parsableByteArray.getPosition();
        EyesData stereoViewBox = null;
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int i3 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i3 > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == 1702454643) {
                stereoViewBox = parseStereoViewBox(parsableByteArray, position, i3);
            }
            position += i3;
        }
        if (stereoViewBox == null) {
            return null;
        }
        return new VexuData(stereoViewBox);
    }

    /* JADX WARN: Removed duplicated region for block: B:205:0x04d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, @Nullable String str, int i5, @Nullable DrmInitData drmInitData, StsdData stsdData, int i6) throws ParserException {
        String str2;
        DrmInitData drmInitData2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        NalUnitUtil.H265VpsData h265VpsData;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17 = i2;
        int i18 = i3;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        StsdData stsdData2 = stsdData;
        int i19 = 8;
        parsableByteArray.setPosition(i17 + 8 + 8);
        parsableByteArray.skipBytes(16);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int unsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(50);
        int position = parsableByteArray.getPosition();
        int iIntValue = i;
        if (iIntValue == 1701733238) {
            Pair<Integer, TrackEncryptionBox> sampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i17, i18);
            if (sampleEntryEncryptionData != null) {
                iIntValue = ((Integer) sampleEntryEncryptionData.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((TrackEncryptionBox) sampleEntryEncryptionData.second).schemeType);
                stsdData2.trackEncryptionBoxes[i6] = (TrackEncryptionBox) sampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        String str3 = "video/3gpp";
        String str4 = iIntValue == 1831958048 ? "video/mpeg" : iIntValue == 1211250227 ? "video/3gpp" : null;
        List<byte[]> listE = null;
        float paspFromParent = 1.0f;
        ByteBuffer byteBuffer = null;
        String str5 = null;
        byte[] projFromParent = null;
        int i20 = -1;
        int i21 = -1;
        int i22 = -1;
        int i23 = -1;
        int i24 = -1;
        int iIsoColorPrimariesToColorSpace = -1;
        int i25 = -1;
        int iIsoTransferCharacteristicsToColorTransfer = -1;
        BtrtData btrtFromParent = null;
        EsdsData esdsFromParent = null;
        NalUnitUtil.H265VpsData h265VpsData2 = null;
        boolean z = false;
        int i26 = position;
        int i27 = 8;
        while (i26 - i17 < i18) {
            parsableByteArray.setPosition(i26);
            int position2 = parsableByteArray.getPosition();
            int i28 = parsableByteArray.readInt();
            if (i28 == 0) {
                str2 = str3;
                if (parsableByteArray.getPosition() - i17 == i18) {
                    break;
                }
            } else {
                str2 = str3;
            }
            ExtractorUtil.checkContainerInput(i28 > 0, "childAtomSize must be positive");
            int i29 = parsableByteArray.readInt();
            if (i29 == 1635148611) {
                ExtractorUtil.checkContainerInput(str4 == null, null);
                parsableByteArray.setPosition(position2 + 8);
                AvcConfig avcConfig = AvcConfig.parse(parsableByteArray);
                listE = avcConfig.initializationData;
                stsdData2.nalUnitLengthFieldLength = avcConfig.nalUnitLengthFieldLength;
                if (!z) {
                    paspFromParent = avcConfig.pixelWidthHeightRatio;
                }
                String str6 = avcConfig.codecs;
                int i30 = avcConfig.maxNumReorderFrames;
                int i31 = avcConfig.colorSpace;
                int i32 = avcConfig.colorRange;
                int i33 = avcConfig.colorTransfer;
                int i34 = avcConfig.bitdepthLuma;
                drmInitData2 = drmInitDataCopyWithSchemeType;
                i8 = unsignedShort;
                i10 = unsignedShort2;
                i21 = i30;
                i11 = iIntValue;
                iIsoColorPrimariesToColorSpace = i31;
                i7 = i32;
                iIsoTransferCharacteristicsToColorTransfer = i33;
                str4 = "video/avc";
                i27 = avcConfig.bitdepthChroma;
                str5 = str6;
                h265VpsData = h265VpsData2;
                i9 = i34;
            } else if (i29 == 1752589123) {
                ExtractorUtil.checkContainerInput(str4 == null, null);
                parsableByteArray.setPosition(position2 + 8);
                HevcConfig hevcConfig = HevcConfig.parse(parsableByteArray);
                listE = hevcConfig.initializationData;
                stsdData2.nalUnitLengthFieldLength = hevcConfig.nalUnitLengthFieldLength;
                if (!z) {
                    paspFromParent = hevcConfig.pixelWidthHeightRatio;
                }
                int i35 = hevcConfig.maxNumReorderPics;
                int i36 = hevcConfig.maxSubLayers;
                String str7 = hevcConfig.codecs;
                int i37 = hevcConfig.stereoMode;
                if (i37 != -1) {
                    i20 = i37;
                }
                int i38 = hevcConfig.decodedWidth;
                int i39 = hevcConfig.decodedHeight;
                int i40 = hevcConfig.colorSpace;
                int i41 = hevcConfig.colorRange;
                int i42 = hevcConfig.colorTransfer;
                int i43 = hevcConfig.bitdepthLuma;
                int i44 = hevcConfig.bitdepthChroma;
                h265VpsData = hevcConfig.vpsData;
                drmInitData2 = drmInitDataCopyWithSchemeType;
                i8 = unsignedShort;
                i10 = unsignedShort2;
                i11 = iIntValue;
                iIsoColorPrimariesToColorSpace = i40;
                i7 = i41;
                iIsoTransferCharacteristicsToColorTransfer = i42;
                i9 = i43;
                i22 = i36;
                i23 = i38;
                i24 = i39;
                i21 = i35;
                str5 = str7;
                str4 = "video/hevc";
                i27 = i44;
            } else {
                drmInitData2 = drmInitDataCopyWithSchemeType;
                if (i29 == 1818785347) {
                    ExtractorUtil.checkContainerInput("video/hevc".equals(str4), "lhvC must follow hvcC atom");
                    NalUnitUtil.H265VpsData h265VpsData3 = h265VpsData2;
                    ExtractorUtil.checkContainerInput(h265VpsData3 != null && h265VpsData3.layerInfos.size() >= 2, "must have at least two layers");
                    parsableByteArray.setPosition(position2 + 8);
                    HevcConfig layered = HevcConfig.parseLayered(parsableByteArray, (NalUnitUtil.H265VpsData) Assertions.checkNotNull(h265VpsData3));
                    ExtractorUtil.checkContainerInput(stsdData2.nalUnitLengthFieldLength == layered.nalUnitLengthFieldLength, "nalUnitLengthFieldLength must be same for both hvcC and lhvC atoms");
                    int i45 = layered.colorSpace;
                    int i46 = iIsoColorPrimariesToColorSpace;
                    if (i45 != -1) {
                        ExtractorUtil.checkContainerInput(i46 == i45, "colorSpace must be the same for both views");
                    }
                    int i47 = layered.colorRange;
                    int i48 = i25;
                    if (i47 != -1) {
                        ExtractorUtil.checkContainerInput(i48 == i47, "colorRange must be the same for both views");
                    }
                    int i49 = layered.colorTransfer;
                    if (i49 != -1) {
                        i16 = iIsoTransferCharacteristicsToColorTransfer;
                        i15 = i46;
                        ExtractorUtil.checkContainerInput(i16 == i49, "colorTransfer must be the same for both views");
                    } else {
                        i15 = i46;
                        i16 = iIsoTransferCharacteristicsToColorTransfer;
                    }
                    ExtractorUtil.checkContainerInput(i19 == layered.bitdepthLuma, "bitdepthLuma must be the same for both views");
                    ExtractorUtil.checkContainerInput(i27 == layered.bitdepthChroma, "bitdepthChroma must be the same for both views");
                    if (listE != null) {
                        listE = ImmutableList.builder().l(listE).l(layered.initializationData).e();
                    } else {
                        ExtractorUtil.checkContainerInput(false, "initializationData must be already set from hvcC atom");
                    }
                    i8 = unsignedShort;
                    i9 = i19;
                    i10 = unsignedShort2;
                    i11 = iIntValue;
                    iIsoTransferCharacteristicsToColorTransfer = i16;
                    i7 = i48;
                    iIsoColorPrimariesToColorSpace = i15;
                    str5 = layered.codecs;
                    h265VpsData = h265VpsData3;
                    str4 = MimeTypes.VIDEO_MV_HEVC;
                } else {
                    int i50 = iIsoColorPrimariesToColorSpace;
                    i7 = i25;
                    int i51 = iIsoTransferCharacteristicsToColorTransfer;
                    NalUnitUtil.H265VpsData h265VpsData4 = h265VpsData2;
                    if (i29 == 1986361461) {
                        VexuData videoExtendedUsageBox = parseVideoExtendedUsageBox(parsableByteArray, position2, i28);
                        if (videoExtendedUsageBox == null || videoExtendedUsageBox.eyesData == null) {
                            i14 = i20;
                            h265VpsData = h265VpsData4;
                            i8 = unsignedShort;
                            i9 = i19;
                            i10 = unsignedShort2;
                            i11 = iIntValue;
                            iIsoTransferCharacteristicsToColorTransfer = i51;
                            iIsoColorPrimariesToColorSpace = i50;
                        } else if (h265VpsData4 == null || h265VpsData4.layerInfos.size() < 2) {
                            i14 = i20;
                            i20 = i14 == -1 ? videoExtendedUsageBox.eyesData.striData.eyeViewsReversed ? 5 : 4 : i14;
                            h265VpsData = h265VpsData4;
                            i8 = unsignedShort;
                            i9 = i19;
                            i10 = unsignedShort2;
                            i11 = iIntValue;
                            iIsoTransferCharacteristicsToColorTransfer = i51;
                            iIsoColorPrimariesToColorSpace = i50;
                        } else {
                            ExtractorUtil.checkContainerInput(videoExtendedUsageBox.hasBothEyeViews(), "both eye views must be marked as available");
                            ExtractorUtil.checkContainerInput(!videoExtendedUsageBox.eyesData.striData.eyeViewsReversed, "for MV-HEVC, eye_views_reversed must be set to false");
                            i14 = i20;
                            h265VpsData = h265VpsData4;
                            i8 = unsignedShort;
                            i9 = i19;
                            i10 = unsignedShort2;
                            i11 = iIntValue;
                            iIsoTransferCharacteristicsToColorTransfer = i51;
                            iIsoColorPrimariesToColorSpace = i50;
                        }
                        i26 += i28;
                        i18 = i3;
                        stsdData2 = stsdData;
                        str3 = str2;
                        iIntValue = i11;
                        i19 = i9;
                        drmInitDataCopyWithSchemeType = drmInitData2;
                        i25 = i7;
                        unsignedShort2 = i10;
                        unsignedShort = i8;
                        h265VpsData2 = h265VpsData;
                        i17 = i2;
                    } else {
                        int i52 = i20;
                        if (i29 == 1685480259 || i29 == 1685485123 || i29 == 1685485379) {
                            i8 = unsignedShort;
                            i9 = i19;
                            i10 = unsignedShort2;
                            int i53 = i27;
                            i11 = iIntValue;
                            int i54 = i28 - 8;
                            byte[] bArr = new byte[i54];
                            parsableByteArray.readBytes(bArr, 0, i54);
                            if (listE != null) {
                                listE = ImmutableList.builder().l(listE).a(bArr).e();
                            } else {
                                ExtractorUtil.checkContainerInput(false, "initializationData must already be set from hvcC or avcC atom");
                            }
                            parsableByteArray.setPosition(position2 + 8);
                            DolbyVisionConfig dolbyVisionConfig = DolbyVisionConfig.parse(parsableByteArray);
                            if (dolbyVisionConfig != null) {
                                str4 = "video/dolby-vision";
                                str5 = dolbyVisionConfig.codecs;
                            }
                            iIsoColorPrimariesToColorSpace = i50;
                            h265VpsData = h265VpsData4;
                            i27 = i53;
                            i20 = i52;
                        } else if (i29 == 1987076931) {
                            ExtractorUtil.checkContainerInput(str4 == null, null);
                            String str8 = iIntValue == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                            parsableByteArray.setPosition(position2 + 12);
                            byte unsignedByte = (byte) parsableByteArray.readUnsignedByte();
                            byte unsignedByte2 = (byte) parsableByteArray.readUnsignedByte();
                            int unsignedByte3 = parsableByteArray.readUnsignedByte();
                            int i55 = unsignedByte3 >> 4;
                            byte b = (byte) ((unsignedByte3 >> 1) & 7);
                            if (str8.equals("video/x-vnd.on2.vp9")) {
                                listE = CodecSpecificDataUtil.buildVp9CodecPrivateInitializationData(unsignedByte, unsignedByte2, (byte) i55, b);
                            }
                            boolean z2 = (unsignedByte3 & 1) != 0;
                            int unsignedByte4 = parsableByteArray.readUnsignedByte();
                            int unsignedByte5 = parsableByteArray.readUnsignedByte();
                            int iIsoColorPrimariesToColorSpace2 = ColorInfo.isoColorPrimariesToColorSpace(unsignedByte4);
                            int i56 = z2 ? 1 : 2;
                            iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(unsignedByte5);
                            str4 = str8;
                            i8 = unsignedShort;
                            iIsoColorPrimariesToColorSpace = iIsoColorPrimariesToColorSpace2;
                            i10 = unsignedShort2;
                            i27 = i55;
                            i9 = i27;
                            h265VpsData = h265VpsData4;
                            i7 = i56;
                            i20 = i52;
                            i11 = iIntValue;
                        } else if (i29 == 1635135811) {
                            int i57 = i28 - 8;
                            byte[] bArr2 = new byte[i57];
                            parsableByteArray.readBytes(bArr2, 0, i57);
                            listE = ImmutableList.of(bArr2);
                            parsableByteArray.setPosition(position2 + 8);
                            ColorInfo av1c = parseAv1c(parsableByteArray);
                            int i58 = av1c.lumaBitdepth;
                            int i59 = av1c.chromaBitdepth;
                            int i60 = av1c.colorSpace;
                            int i61 = av1c.colorRange;
                            iIsoTransferCharacteristicsToColorTransfer = av1c.colorTransfer;
                            i9 = i58;
                            i8 = unsignedShort;
                            i10 = unsignedShort2;
                            iIsoColorPrimariesToColorSpace = i60;
                            i11 = iIntValue;
                            i7 = i61;
                            str4 = "video/av01";
                            h265VpsData = h265VpsData4;
                            i20 = i52;
                            i27 = i59;
                        } else if (i29 == 1668050025) {
                            ByteBuffer byteBufferAllocateHdrStaticInfo = byteBuffer == null ? allocateHdrStaticInfo() : byteBuffer;
                            byteBufferAllocateHdrStaticInfo.position(21);
                            byteBufferAllocateHdrStaticInfo.putShort(parsableByteArray.readShort());
                            byteBufferAllocateHdrStaticInfo.putShort(parsableByteArray.readShort());
                            byteBuffer = byteBufferAllocateHdrStaticInfo;
                            i8 = unsignedShort;
                            i9 = i19;
                            i10 = unsignedShort2;
                            i11 = iIntValue;
                            iIsoTransferCharacteristicsToColorTransfer = i51;
                            h265VpsData = h265VpsData4;
                            iIsoColorPrimariesToColorSpace = i50;
                            i20 = i52;
                        } else if (i29 == 1835295606) {
                            ByteBuffer byteBufferAllocateHdrStaticInfo2 = byteBuffer == null ? allocateHdrStaticInfo() : byteBuffer;
                            short s = parsableByteArray.readShort();
                            short s2 = parsableByteArray.readShort();
                            i11 = iIntValue;
                            short s3 = parsableByteArray.readShort();
                            short s4 = parsableByteArray.readShort();
                            int i62 = i27;
                            short s5 = parsableByteArray.readShort();
                            i9 = i19;
                            short s6 = parsableByteArray.readShort();
                            short s7 = parsableByteArray.readShort();
                            i10 = unsignedShort2;
                            short s8 = parsableByteArray.readShort();
                            long unsignedInt = parsableByteArray.readUnsignedInt();
                            long unsignedInt2 = parsableByteArray.readUnsignedInt();
                            i8 = unsignedShort;
                            byteBufferAllocateHdrStaticInfo2.position(1);
                            byteBufferAllocateHdrStaticInfo2.putShort(s5);
                            byteBufferAllocateHdrStaticInfo2.putShort(s6);
                            byteBufferAllocateHdrStaticInfo2.putShort(s);
                            byteBufferAllocateHdrStaticInfo2.putShort(s2);
                            byteBufferAllocateHdrStaticInfo2.putShort(s3);
                            byteBufferAllocateHdrStaticInfo2.putShort(s4);
                            byteBufferAllocateHdrStaticInfo2.putShort(s7);
                            byteBufferAllocateHdrStaticInfo2.putShort(s8);
                            byteBufferAllocateHdrStaticInfo2.putShort((short) (unsignedInt / 10000));
                            byteBufferAllocateHdrStaticInfo2.putShort((short) (unsignedInt2 / 10000));
                            byteBuffer = byteBufferAllocateHdrStaticInfo2;
                            h265VpsData = h265VpsData4;
                            i27 = i62;
                            iIsoColorPrimariesToColorSpace = i50;
                            i20 = i52;
                        } else {
                            i8 = unsignedShort;
                            i9 = i19;
                            i10 = unsignedShort2;
                            int i63 = i27;
                            i11 = iIntValue;
                            if (i29 == 1681012275) {
                                ExtractorUtil.checkContainerInput(str4 == null, null);
                                str4 = str2;
                            } else if (i29 == 1702061171) {
                                ExtractorUtil.checkContainerInput(str4 == null, null);
                                esdsFromParent = parseEsdsFromParent(parsableByteArray, position2);
                                String str9 = esdsFromParent.mimeType;
                                byte[] bArr3 = esdsFromParent.initializationData;
                                if (bArr3 != null) {
                                    listE = ImmutableList.of(bArr3);
                                }
                                str4 = str9;
                            } else if (i29 == 1651798644) {
                                btrtFromParent = parseBtrtFromParent(parsableByteArray, position2);
                            } else if (i29 == 1885434736) {
                                paspFromParent = parsePaspFromParent(parsableByteArray, position2);
                                h265VpsData = h265VpsData4;
                                i27 = i63;
                                iIsoColorPrimariesToColorSpace = i50;
                                i20 = i52;
                                z = true;
                            } else if (i29 == 1937126244) {
                                projFromParent = parseProjFromParent(parsableByteArray, position2, i28);
                            } else if (i29 == 1936995172) {
                                int unsignedByte6 = parsableByteArray.readUnsignedByte();
                                parsableByteArray.skipBytes(3);
                                if (unsignedByte6 != 0) {
                                    i13 = i52;
                                    h265VpsData = h265VpsData4;
                                    i20 = i13;
                                    i27 = i63;
                                    iIsoColorPrimariesToColorSpace = i50;
                                } else {
                                    int unsignedByte7 = parsableByteArray.readUnsignedByte();
                                    if (unsignedByte7 == 0) {
                                        i13 = 0;
                                    } else if (unsignedByte7 == 1) {
                                        i13 = 1;
                                    } else if (unsignedByte7 == 2) {
                                        i13 = 2;
                                    } else if (unsignedByte7 == 3) {
                                        i13 = 3;
                                    }
                                    h265VpsData = h265VpsData4;
                                    i20 = i13;
                                    i27 = i63;
                                    iIsoColorPrimariesToColorSpace = i50;
                                }
                                i26 += i28;
                                i18 = i3;
                                stsdData2 = stsdData;
                                str3 = str2;
                                iIntValue = i11;
                                i19 = i9;
                                drmInitDataCopyWithSchemeType = drmInitData2;
                                i25 = i7;
                                unsignedShort2 = i10;
                                unsignedShort = i8;
                                h265VpsData2 = h265VpsData;
                                i17 = i2;
                            } else if (i29 == 1634760259) {
                                int i64 = i28 - 12;
                                byte[] bArr4 = new byte[i64];
                                parsableByteArray.setPosition(position2 + 12);
                                parsableByteArray.readBytes(bArr4, 0, i64);
                                listE = ImmutableList.of(bArr4);
                                ColorInfo apvc = parseApvc(new ParsableByteArray(bArr4));
                                int i65 = apvc.lumaBitdepth;
                                int i66 = apvc.chromaBitdepth;
                                int i67 = apvc.colorSpace;
                                int i68 = apvc.colorRange;
                                iIsoTransferCharacteristicsToColorTransfer = apvc.colorTransfer;
                                i9 = i65;
                                i27 = i66;
                                iIsoColorPrimariesToColorSpace = i67;
                                i7 = i68;
                                str4 = MimeTypes.VIDEO_APV;
                                h265VpsData = h265VpsData4;
                                i20 = i52;
                            } else {
                                if (i29 == 1668246642) {
                                    i12 = i50;
                                    if (i12 == -1 && i51 == -1) {
                                        int i69 = parsableByteArray.readInt();
                                        if (i69 == TYPE_nclx || i69 == TYPE_nclc) {
                                            int unsignedShort3 = parsableByteArray.readUnsignedShort();
                                            int unsignedShort4 = parsableByteArray.readUnsignedShort();
                                            parsableByteArray.skipBytes(2);
                                            boolean z3 = i28 == 19 && (parsableByteArray.readUnsignedByte() & 128) != 0;
                                            iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(unsignedShort3);
                                            i7 = z3 ? 1 : 2;
                                            i27 = i63;
                                            iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(unsignedShort4);
                                            h265VpsData = h265VpsData4;
                                            i20 = i52;
                                            i26 += i28;
                                            i18 = i3;
                                            stsdData2 = stsdData;
                                            str3 = str2;
                                            iIntValue = i11;
                                            i19 = i9;
                                            drmInitDataCopyWithSchemeType = drmInitData2;
                                            i25 = i7;
                                            unsignedShort2 = i10;
                                            unsignedShort = i8;
                                            h265VpsData2 = h265VpsData;
                                            i17 = i2;
                                        } else {
                                            Log.w(TAG, "Unsupported color type: " + Mp4Box.getBoxTypeString(i69));
                                        }
                                    }
                                } else {
                                    i12 = i50;
                                }
                                iIsoColorPrimariesToColorSpace = i12;
                                h265VpsData = h265VpsData4;
                                i27 = i63;
                                i20 = i52;
                            }
                            h265VpsData = h265VpsData4;
                            i27 = i63;
                            iIsoColorPrimariesToColorSpace = i50;
                            i20 = i52;
                        }
                        iIsoTransferCharacteristicsToColorTransfer = i51;
                        i26 += i28;
                        i18 = i3;
                        stsdData2 = stsdData;
                        str3 = str2;
                        iIntValue = i11;
                        i19 = i9;
                        drmInitDataCopyWithSchemeType = drmInitData2;
                        i25 = i7;
                        unsignedShort2 = i10;
                        unsignedShort = i8;
                        h265VpsData2 = h265VpsData;
                        i17 = i2;
                    }
                    i26 += i28;
                    i18 = i3;
                    stsdData2 = stsdData;
                    str3 = str2;
                    iIntValue = i11;
                    i19 = i9;
                    drmInitDataCopyWithSchemeType = drmInitData2;
                    i25 = i7;
                    unsignedShort2 = i10;
                    unsignedShort = i8;
                    h265VpsData2 = h265VpsData;
                    i17 = i2;
                }
                i26 += i28;
                i18 = i3;
                stsdData2 = stsdData;
                str3 = str2;
                iIntValue = i11;
                i19 = i9;
                drmInitDataCopyWithSchemeType = drmInitData2;
                i25 = i7;
                unsignedShort2 = i10;
                unsignedShort = i8;
                h265VpsData2 = h265VpsData;
                i17 = i2;
            }
            i26 += i28;
            i18 = i3;
            stsdData2 = stsdData;
            str3 = str2;
            iIntValue = i11;
            i19 = i9;
            drmInitDataCopyWithSchemeType = drmInitData2;
            i25 = i7;
            unsignedShort2 = i10;
            unsignedShort = i8;
            h265VpsData2 = h265VpsData;
            i17 = i2;
        }
        DrmInitData drmInitData3 = drmInitDataCopyWithSchemeType;
        int i70 = unsignedShort;
        int i71 = i19;
        int i72 = unsignedShort2;
        int i73 = i20;
        int i74 = iIsoColorPrimariesToColorSpace;
        int i75 = i25;
        int i76 = iIsoTransferCharacteristicsToColorTransfer;
        int i77 = i27;
        if (str4 == null) {
            return;
        }
        Format.Builder colorInfo = new Format.Builder().setId(i4).setSampleMimeType(str4).setCodecs(str5).setWidth(i70).setHeight(i72).setDecodedWidth(i23).setDecodedHeight(i24).setPixelWidthHeightRatio(paspFromParent).setRotationDegrees(i5).setProjectionData(projFromParent).setStereoMode(i73).setInitializationData(listE).setMaxNumReorderSamples(i21).setMaxSubLayers(i22).setDrmInitData(drmInitData3).setLanguage(str).setColorInfo(new ColorInfo.Builder().setColorSpace(i74).setColorRange(i75).setColorTransfer(i76).setHdrStaticInfo(byteBuffer != null ? byteBuffer.array() : null).setLumaBitdepth(i71).setChromaBitdepth(i77).build());
        if (btrtFromParent != null) {
            colorInfo.setAverageBitrate(ku2.o(btrtFromParent.avgBitrate)).setPeakBitrate(ku2.o(btrtFromParent.maxBitrate));
        } else if (esdsFromParent != null) {
            colorInfo.setAverageBitrate(ku2.o(esdsFromParent.bitrate)).setPeakBitrate(ku2.o(esdsFromParent.peakBitrate));
        }
        stsdData.format = colorInfo.build();
    }

    @Nullable
    private static Metadata parseXyz(ParsableByteArray parsableByteArray) {
        short s = parsableByteArray.readShort();
        parsableByteArray.skipBytes(2);
        String string = parsableByteArray.readString(s);
        int iMax = Math.max(string.lastIndexOf(43), string.lastIndexOf(45));
        try {
            return new Metadata(new Mp4LocationData(Float.parseFloat(string.substring(0, iMax)), Float.parseFloat(string.substring(iMax, string.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static int vobsubYuvToRgb(int i) {
        int i2 = (i >> 16) & 255;
        int i3 = ((i >> 8) & 255) - 128;
        int i4 = (i & 255) - 128;
        return Util.constrainValue(i2 + ((i4 * 17790) / 10000), 0, 255) | (Util.constrainValue(((i3 * 14075) / 10000) + i2, 0, 255) << 16) | (Util.constrainValue((i2 - ((i4 * 3455) / 10000)) - ((i3 * 7169) / 10000), 0, 255) << 8);
    }
}
