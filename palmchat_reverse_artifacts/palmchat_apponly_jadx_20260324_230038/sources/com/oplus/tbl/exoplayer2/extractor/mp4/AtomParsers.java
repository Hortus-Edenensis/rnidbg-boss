package com.oplus.tbl.exoplayer2.extractor.mp4;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import com.oplus.tbl.exoplayer2.ColorInfo;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.ParserException;
import com.oplus.tbl.exoplayer2.audio.AacUtil;
import com.oplus.tbl.exoplayer2.audio.Ac3Util;
import com.oplus.tbl.exoplayer2.audio.Ac4Util;
import com.oplus.tbl.exoplayer2.audio.OpusUtil;
import com.oplus.tbl.exoplayer2.drm.DrmInitData;
import com.oplus.tbl.exoplayer2.extractor.GaplessInfoHolder;
import com.oplus.tbl.exoplayer2.extractor.mp4.Atom;
import com.oplus.tbl.exoplayer2.extractor.mp4.FixedSampleSizeRechunker;
import com.oplus.tbl.exoplayer2.metadata.Metadata;
import com.oplus.tbl.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.oplus.tbl.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.CodecSpecificDataUtil;
import com.oplus.tbl.exoplayer2.util.Log;
import com.oplus.tbl.exoplayer2.util.MimeTypes;
import com.oplus.tbl.exoplayer2.util.ParsableByteArray;
import com.oplus.tbl.exoplayer2.util.Util;
import com.oplus.tbl.exoplayer2.video.AvcConfig;
import com.oplus.tbl.exoplayer2.video.DolbyVisionConfig;
import com.oplus.tbl.exoplayer2.video.HevcConfig;
import com.oplus.tblplayer.processor.util.EffectConstants;
import defpackage.u42;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class AtomParsers {
    private static final int MAX_GAPLESS_TRIM_SIZE_SAMPLES = 4;
    private static final String TAG = "AtomParsers";
    private static final int TYPE_clcp = 1668047728;
    private static final int TYPE_mdta = 1835299937;
    private static final int TYPE_meta = 1835365473;
    private static final int TYPE_nclc = 1852009571;
    private static final int TYPE_nclx = 1852009592;
    private static final int TYPE_sbtl = 1935832172;
    private static final int TYPE_soun = 1936684398;
    private static final int TYPE_subt = 1937072756;
    private static final int TYPE_text = 1952807028;
    private static final int TYPE_vide = 1986618469;
    private static final byte[] opusMagic = Util.getUtf8Bytes("OpusHead");

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

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            Assertions.checkState(parsableByteArray.readInt() == 1, "first_chunk must be 1");
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
    public static final class ClefData {
        private final float height;
        private final float width;

        public ClefData(float f, float f2) {
            this.width = f;
            this.height = f2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface SampleSizeBox {
        int getFixedSampleSize();

        int getSampleCount();

        int readNextSampleSize();
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

        public StszSampleSizeBox(Atom.LeafAtom leafAtom, Format format) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if ("audio/raw".equals(format.sampleMimeType)) {
                int pcmFrameSize = Util.getPcmFrameSize(format.pcmEncoding, format.channelCount);
                if (unsignedIntToInt == 0 || unsignedIntToInt % pcmFrameSize != 0) {
                    Log.w(AtomParsers.TAG, "Audio sample size mismatch. stsd sample size: " + pcmFrameSize + ", stsz sample size: " + unsignedIntToInt);
                    unsignedIntToInt = pcmFrameSize;
                }
            }
            this.fixedSampleSize = unsignedIntToInt == 0 ? -1 : unsignedIntToInt;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // com.oplus.tbl.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getFixedSampleSize() {
            return this.fixedSampleSize;
        }

        @Override // com.oplus.tbl.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.oplus.tbl.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
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

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fieldSize = parsableByteArray.readUnsignedIntToInt() & 255;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // com.oplus.tbl.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getFixedSampleSize() {
            return -1;
        }

        @Override // com.oplus.tbl.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.oplus.tbl.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
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
        private final long duration;
        private final int id;
        private final int rotationDegrees;

        public TkhdData(int i, long j, int i2) {
            this.id = i;
            this.duration = j;
            this.rotationDegrees = i2;
        }
    }

    private AtomParsers() {
    }

    private static boolean canApplyEditWithGaplessInfo(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        return jArr[0] <= j2 && j2 < jArr[Util.constrainValue(4, 0, length)] && jArr[Util.constrainValue(jArr.length - 4, 0, length)] < j3 && j3 <= j;
    }

    private static int findEsdsPosition(ParsableByteArray parsableByteArray, int i, int i2) {
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int i3 = parsableByteArray.readInt();
            Assertions.checkState(i3 > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == 1702061171) {
                return position;
            }
            position += i3;
        }
        return -1;
    }

    private static int getTrackTypeForHdlr(int i) {
        if (i == TYPE_soun) {
            return 1;
        }
        if (i == TYPE_vide) {
            return 2;
        }
        if (i == TYPE_text || i == TYPE_sbtl || i == TYPE_subt || i == TYPE_clcp) {
            return 3;
        }
        return i == 1835365473 ? 5 : -1;
    }

    public static void maybeSkipRemainingMetaAtomHeaderBytes(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(4);
        if (parsableByteArray.readInt() != 1751411826) {
            position += 4;
        }
        parsableByteArray.setPosition(position);
    }

    /* JADX WARN: Removed duplicated region for block: B:99:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void parseAudioSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, boolean z, @Nullable DrmInitData drmInitData, StsdData stsdData, int i5) throws ParserException {
        int unsignedShort;
        int iIntValue;
        int unsignedIntToInt;
        DrmInitData drmInitDataCopyWithSchemeType;
        String str2;
        String str3;
        int i6;
        int i7;
        Format formatBuild;
        int i8 = i2;
        int i9 = i3;
        parsableByteArray.setPosition(i8 + 8 + 8);
        if (z) {
            unsignedShort = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
        } else {
            parsableByteArray.skipBytes(8);
            unsignedShort = 0;
        }
        boolean z2 = true;
        if (unsignedShort == 0 || unsignedShort == 1) {
            int unsignedShort2 = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
            int unsignedFixedPoint1616 = parsableByteArray.readUnsignedFixedPoint1616();
            if (unsignedShort == 1) {
                parsableByteArray.skipBytes(16);
            }
            iIntValue = unsignedFixedPoint1616;
            unsignedIntToInt = unsignedShort2;
        } else {
            if (unsignedShort != 2) {
                return;
            }
            parsableByteArray.skipBytes(16);
            iIntValue = (int) Math.round(parsableByteArray.readDouble());
            unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            parsableByteArray.skipBytes(20);
        }
        int position = parsableByteArray.getPosition();
        int iIntValue2 = i;
        if (iIntValue2 == 1701733217) {
            Pair<Integer, TrackEncryptionBox> sampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i8, i9);
            if (sampleEntryEncryptionData != null) {
                iIntValue2 = ((Integer) sampleEntryEncryptionData.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitData == null ? null : drmInitData.copyWithSchemeType(((TrackEncryptionBox) sampleEntryEncryptionData.second).schemeType);
                stsdData.trackEncryptionBoxes[i5] = (TrackEncryptionBox) sampleEntryEncryptionData.second;
            } else {
                drmInitDataCopyWithSchemeType = drmInitData;
            }
            parsableByteArray.setPosition(position);
        } else {
            drmInitDataCopyWithSchemeType = drmInitData;
        }
        if (iIntValue2 == 1633889587) {
            str2 = "audio/ac3";
        } else if (iIntValue2 == 1700998451) {
            str2 = "audio/eac3";
        } else if (iIntValue2 == 1633889588) {
            str2 = "audio/ac4";
        } else if (iIntValue2 == 1685353315) {
            str2 = "audio/vnd.dts";
        } else if (iIntValue2 == 1685353320 || iIntValue2 == 1685353324) {
            str2 = "audio/vnd.dts.hd";
        } else if (iIntValue2 == 1685353317) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (iIntValue2 == 1685353336) {
            str2 = MimeTypes.AUDIO_DTS_UHD;
        } else if (iIntValue2 == 1935764850) {
            str2 = "audio/3gpp";
        } else {
            if (iIntValue2 != 1935767394) {
                str3 = "audio/raw";
                if (iIntValue2 == 1819304813 || iIntValue2 == 1936684916) {
                    i6 = 2;
                } else if (iIntValue2 == 1953984371) {
                    i6 = 268435456;
                } else if (iIntValue2 == 778924082 || iIntValue2 == 778924083) {
                    str2 = "audio/mpeg";
                } else if (iIntValue2 == 1634492771) {
                    str2 = "audio/alac";
                } else if (iIntValue2 == 1634492791) {
                    str2 = "audio/g711-alaw";
                } else if (iIntValue2 == 1970037111) {
                    str2 = "audio/g711-mlaw";
                } else if (iIntValue2 == 1332770163) {
                    str2 = "audio/opus";
                } else if (iIntValue2 == 1716281667) {
                    str2 = "audio/flac";
                } else if (iIntValue2 == 1835557169) {
                    str2 = "audio/mha1";
                } else if (iIntValue2 == 1835560241) {
                    str2 = "audio/mhm1";
                } else {
                    i6 = -1;
                    str3 = null;
                }
                String str4 = str3;
                String str5 = null;
                List<byte[]> listOf = null;
                while (position - i8 < i9) {
                    parsableByteArray.setPosition(position);
                    int i10 = parsableByteArray.readInt();
                    if (i10 <= 0) {
                        z2 = false;
                    }
                    Assertions.checkState(z2, "childAtomSize should be positive");
                    int i11 = parsableByteArray.readInt();
                    if (i11 == 1702061171) {
                        z2 = true;
                        i7 = 1702061171;
                    } else if (z && i11 == 2002876005) {
                        i7 = 1702061171;
                        z2 = true;
                    } else {
                        if (i11 == 1684103987) {
                            parsableByteArray.setPosition(position + 8);
                            formatBuild = Ac3Util.parseAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitDataCopyWithSchemeType);
                        } else if (i11 == 1684366131) {
                            parsableByteArray.setPosition(position + 8);
                            formatBuild = Ac3Util.parseEAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitDataCopyWithSchemeType);
                        } else if (i11 == 1684103988) {
                            parsableByteArray.setPosition(position + 8);
                            formatBuild = Ac4Util.parseAc4AnnexEFormat(parsableByteArray, Integer.toString(i4), str, drmInitDataCopyWithSchemeType);
                        } else if (i11 == 1684305011) {
                            formatBuild = new Format.Builder().setId(i4).setSampleMimeType(str4).setChannelCount(unsignedIntToInt).setSampleRate(iIntValue).setDrmInitData(drmInitDataCopyWithSchemeType).setLanguage(str).build();
                        } else {
                            if (i11 == 1682927731) {
                                int i12 = i10 - 8;
                                byte[] bArr = opusMagic;
                                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length + i12);
                                parsableByteArray.setPosition(position + 8);
                                parsableByteArray.readBytes(bArrCopyOf, bArr.length, i12);
                                listOf = OpusUtil.buildInitializationData(bArrCopyOf);
                                z2 = true;
                            } else if (i11 == 1684425825) {
                                int i13 = i10 - 12;
                                byte[] bArr2 = new byte[i13 + 4];
                                bArr2[0] = 102;
                                z2 = true;
                                bArr2[1] = 76;
                                bArr2[2] = 97;
                                bArr2[3] = 67;
                                parsableByteArray.setPosition(position + 12);
                                parsableByteArray.readBytes(bArr2, 4, i13);
                                listOf = ImmutableList.of(bArr2);
                            } else {
                                z2 = true;
                                if (i11 == 1634492771) {
                                    int i14 = i10 - 12;
                                    byte[] bArr3 = new byte[i14];
                                    parsableByteArray.setPosition(position + 12);
                                    parsableByteArray.readBytes(bArr3, 0, i14);
                                    Pair<Integer, Integer> alacAudioSpecificConfig = CodecSpecificDataUtil.parseAlacAudioSpecificConfig(bArr3);
                                    iIntValue = ((Integer) alacAudioSpecificConfig.first).intValue();
                                    int iIntValue3 = ((Integer) alacAudioSpecificConfig.second).intValue();
                                    listOf = ImmutableList.of(bArr3);
                                    unsignedIntToInt = iIntValue3;
                                } else if (i11 == 1835557187) {
                                    int i15 = i10 - 13;
                                    byte[] bArr4 = new byte[i15];
                                    parsableByteArray.setPosition(position + 13);
                                    parsableByteArray.readBytes(bArr4, 0, i15);
                                    listOf = ImmutableList.of(bArr4);
                                }
                            }
                            position += i10;
                            i8 = i2;
                            i9 = i3;
                        }
                        stsdData.format = formatBuild;
                        z2 = true;
                        position += i10;
                        i8 = i2;
                        i9 = i3;
                    }
                    int iFindEsdsPosition = i11 == i7 ? position : findEsdsPosition(parsableByteArray, position, i10);
                    if (iFindEsdsPosition != -1) {
                        Pair<String, byte[]> esdsFromParent = parseEsdsFromParent(parsableByteArray, iFindEsdsPosition);
                        str4 = (String) esdsFromParent.first;
                        byte[] bArr5 = (byte[]) esdsFromParent.second;
                        if (bArr5 != null) {
                            if ("audio/mp4a-latm".equals(str4)) {
                                AacUtil.Config audioSpecificConfig = AacUtil.parseAudioSpecificConfig(bArr5);
                                iIntValue = audioSpecificConfig.sampleRateHz;
                                unsignedIntToInt = audioSpecificConfig.channelCount;
                                str5 = audioSpecificConfig.codecs;
                            }
                            listOf = ImmutableList.of(bArr5);
                        }
                    }
                    position += i10;
                    i8 = i2;
                    i9 = i3;
                }
                if (stsdData.format == null || str4 == null) {
                }
                stsdData.format = new Format.Builder().setId(i4).setSampleMimeType(str4).setCodecs(str5).setChannelCount(unsignedIntToInt).setSampleRate(iIntValue).setPcmEncoding(i6).setInitializationData(listOf).setDrmInitData(drmInitDataCopyWithSchemeType).setLanguage(str).build();
                return;
            }
            str2 = "audio/amr-wb";
        }
        str3 = str2;
        i6 = -1;
        String str42 = str3;
        String str52 = null;
        List<byte[]> listOf2 = null;
        while (position - i8 < i9) {
        }
        if (stsdData.format == null) {
        }
    }

    private static ClefData parseClef(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(12);
        return new ClefData(parsableByteArray.readInt() / 65536.0f, parsableByteArray.readInt() / 65536.0f);
    }

    @Nullable
    public static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
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
        Assertions.checkStateNotNull(numValueOf, "frma atom is mandatory");
        Assertions.checkState(i4 != -1, "schi atom is mandatory");
        return Pair.create(numValueOf, (TrackEncryptionBox) Assertions.checkStateNotNull(parseSchiFromParent(parsableByteArray, i4, i5, string), "tenc atom is mandatory"));
    }

    @Nullable
    private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(1701606260);
        if (leafAtomOfType == null) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType.data;
        parsableByteArray.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[unsignedIntToInt];
        long[] jArr2 = new long[unsignedIntToInt];
        for (int i = 0; i < unsignedIntToInt; i++) {
            jArr[i] = fullAtomVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[i] = fullAtomVersion == 1 ? parsableByteArray.readLong() : parsableByteArray.readInt();
            if (parsableByteArray.readShort() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            parsableByteArray.skipBytes(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static Pair<String, byte[]> parseEsdsFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8 + 4);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        if ((unsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((unsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort());
        }
        if ((unsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if ("audio/mpeg".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts.hd".equals(mimeTypeFromMp4ObjectType)) {
            return Pair.create(mimeTypeFromMp4ObjectType, null);
        }
        parsableByteArray.skipBytes(12);
        parsableByteArray.skipBytes(1);
        int expandableClassSize = parseExpandableClassSize(parsableByteArray);
        byte[] bArr = new byte[expandableClassSize];
        parsableByteArray.readBytes(bArr, 0, expandableClassSize);
        return Pair.create(mimeTypeFromMp4ObjectType, bArr);
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

    private static Pair<Long, String> parseMdhd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(fullAtomVersion == 0 ? 8 : 16);
        long unsignedInt = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(fullAtomVersion == 0 ? 4 : 8);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        return Pair.create(Long.valueOf(unsignedInt), "" + ((char) (((unsignedShort >> 10) & 31) + 96)) + ((char) (((unsignedShort >> 5) & 31) + 96)) + ((char) ((unsignedShort & 31) + 96)));
    }

    @Nullable
    public static Metadata parseMdtaFromMeta(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(1751411826);
        Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(1801812339);
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(1768715124);
        if (leafAtomOfType == null || leafAtomOfType2 == null || leafAtomOfType3 == null || parseHdlr(leafAtomOfType.data) != TYPE_mdta) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType2.data;
        parsableByteArray.setPosition(12);
        int i = parsableByteArray.readInt();
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            strArr[i2] = parsableByteArray.readString(i3 - 8);
        }
        ParsableByteArray parsableByteArray2 = leafAtomOfType3.data;
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

    private static long parseMvhd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        parsableByteArray.skipBytes(Atom.parseFullAtomVersion(parsableByteArray.readInt()) != 0 ? 16 : 8);
        return parsableByteArray.readUnsignedInt();
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
    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i, int i2) {
        Pair<Integer, TrackEncryptionBox> commonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int i3 = parsableByteArray.readInt();
            Assertions.checkState(i3 > 0, "childAtomSize should be positive");
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
                int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (fullAtomVersion == 0) {
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

    @Nullable
    private static Metadata parseSmta(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(12);
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int i2 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1935766900) {
                if (i2 < 14) {
                    return null;
                }
                parsableByteArray.skipBytes(5);
                int unsignedByte = parsableByteArray.readUnsignedByte();
                if (unsignedByte != 12 && unsignedByte != 13) {
                    return null;
                }
                float f = unsignedByte == 12 ? 240.0f : 120.0f;
                parsableByteArray.skipBytes(1);
                return new Metadata(new SmtaMetadataEntry(f, parsableByteArray.readUnsignedByte()));
            }
            parsableByteArray.setPosition(position + i2);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static TrackSampleTable parseStbl(Track track, Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder) throws ParserException {
        SampleSizeBox stz2SampleSizeBox;
        boolean z;
        int unsignedIntToInt;
        int unsignedIntToInt2;
        int unsignedIntToInt3;
        int fixedSampleSize;
        String str;
        int[] iArrCopyOf;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z2;
        int i5;
        Track track2;
        int i6;
        long[] jArr;
        int[] iArr;
        int i7;
        long[] jArr2;
        long j;
        int i8;
        int i9;
        long[] jArr3;
        int i10;
        int[] iArr2;
        long[] jArr4;
        int[] iArr3;
        boolean z3;
        int i11;
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(1937011578);
        if (leafAtomOfType != null) {
            stz2SampleSizeBox = new StszSampleSizeBox(leafAtomOfType, track.format);
        } else {
            Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(1937013298);
            if (leafAtomOfType2 == null) {
                throw new ParserException("Track has no sample table size information");
            }
            stz2SampleSizeBox = new Stz2SampleSizeBox(leafAtomOfType2);
        }
        int sampleCount = stz2SampleSizeBox.getSampleCount();
        if (sampleCount == 0) {
            return new TrackSampleTable(track, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(1937007471);
        if (leafAtomOfType3 == null) {
            leafAtomOfType3 = (Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(1668232756));
            z = true;
        } else {
            z = false;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType3.data;
        ParsableByteArray parsableByteArray2 = ((Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(1937011555))).data;
        ParsableByteArray parsableByteArray3 = ((Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(1937011827))).data;
        Atom.LeafAtom leafAtomOfType4 = containerAtom.getLeafAtomOfType(1937011571);
        ParsableByteArray parsableByteArray4 = leafAtomOfType4 != null ? leafAtomOfType4.data : null;
        Atom.LeafAtom leafAtomOfType5 = containerAtom.getLeafAtomOfType(1668576371);
        ParsableByteArray parsableByteArray5 = leafAtomOfType5 != null ? leafAtomOfType5.data : null;
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
                str = track.format.sampleMimeType;
                if (fixedSampleSize == -1 && ("audio/raw".equals(str) || "audio/g711-mlaw".equals(str) || "audio/g711-alaw".equals(str)) && unsignedIntToInt4 == 0 && unsignedIntToInt == 0 && unsignedIntToInt2 == 0) {
                    long[] jArrCopyOf = new long[sampleCount];
                    int[] iArrCopyOf2 = new int[sampleCount];
                    long[] jArrCopyOf2 = new long[sampleCount];
                    int i12 = unsignedIntToInt2;
                    iArrCopyOf = new int[sampleCount];
                    int unsignedIntToInt7 = unsignedIntToInt3;
                    long j2 = 0;
                    long j3 = 0;
                    int i13 = 0;
                    int i14 = 0;
                    int i15 = 0;
                    int i16 = 0;
                    int unsignedIntToInt8 = 0;
                    int i17 = unsignedIntToInt;
                    int i18 = unsignedIntToInt6;
                    int i19 = unsignedIntToInt5;
                    int i20 = unsignedIntToInt4;
                    int i21 = i12;
                    while (true) {
                        i = i20;
                        if (i13 >= sampleCount) {
                            i2 = i19;
                            i3 = i15;
                            i4 = i16;
                            break;
                        }
                        long j4 = j3;
                        int i22 = i16;
                        boolean zMoveNext = true;
                        while (i22 == 0) {
                            zMoveNext = chunkIterator.moveNext();
                            if (!zMoveNext) {
                                break;
                            }
                            int i23 = i19;
                            long j5 = chunkIterator.offset;
                            i22 = chunkIterator.numSamples;
                            j4 = j5;
                            i19 = i23;
                            i18 = i18;
                            sampleCount = sampleCount;
                        }
                        int i24 = sampleCount;
                        i2 = i19;
                        int i25 = i18;
                        if (!zMoveNext) {
                            Log.w(TAG, "Unexpected end of chunk data");
                            jArrCopyOf = Arrays.copyOf(jArrCopyOf, i13);
                            iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i13);
                            jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i13);
                            iArrCopyOf = Arrays.copyOf(iArrCopyOf, i13);
                            sampleCount = i13;
                            i3 = i15;
                            i4 = i22;
                            break;
                        }
                        if (parsableByteArray5 != null) {
                            while (unsignedIntToInt8 == 0 && i17 > 0) {
                                unsignedIntToInt8 = parsableByteArray5.readUnsignedIntToInt();
                                i15 = parsableByteArray5.readInt();
                                i17--;
                            }
                            unsignedIntToInt8--;
                        }
                        int i26 = i15;
                        jArrCopyOf[i13] = j4;
                        int nextSampleSize = stz2SampleSizeBox.readNextSampleSize();
                        iArrCopyOf2[i13] = nextSampleSize;
                        if (nextSampleSize > i14) {
                            i14 = nextSampleSize;
                        }
                        jArrCopyOf2[i13] = j2 + ((long) i26);
                        iArrCopyOf[i13] = parsableByteArray4 == null ? 1 : 0;
                        if (i13 == unsignedIntToInt7) {
                            iArrCopyOf[i13] = 1;
                            i21--;
                            if (i21 > 0) {
                                unsignedIntToInt7 = ((ParsableByteArray) Assertions.checkNotNull(parsableByteArray4)).readUnsignedIntToInt() - 1;
                            }
                        }
                        int i27 = unsignedIntToInt7;
                        j2 += (long) i25;
                        int unsignedIntToInt9 = i2 - 1;
                        if (unsignedIntToInt9 != 0 || i <= 0) {
                            i8 = i25;
                            i9 = i;
                        } else {
                            unsignedIntToInt9 = parsableByteArray3.readUnsignedIntToInt();
                            i8 = parsableByteArray3.readInt();
                            i9 = i - 1;
                        }
                        int i28 = unsignedIntToInt9;
                        long j6 = j4 + ((long) iArrCopyOf2[i13]);
                        i16 = i22 - 1;
                        i13++;
                        j3 = j6;
                        unsignedIntToInt7 = i27;
                        i18 = i8;
                        sampleCount = i24;
                        i15 = i26;
                        i20 = i9;
                        i19 = i28;
                    }
                    long j7 = j2 + ((long) i3);
                    if (parsableByteArray5 != null) {
                        while (i17 > 0) {
                            if (parsableByteArray5.readUnsignedIntToInt() != 0) {
                                z2 = false;
                                break;
                            }
                            parsableByteArray5.readInt();
                            i17--;
                        }
                        z2 = true;
                        if (i21 != 0 && i2 == 0 && i4 == 0 && i == 0) {
                            i5 = unsignedIntToInt8;
                            if (i5 == 0 && z2) {
                                track2 = track;
                            }
                            i6 = sampleCount;
                            jArr = jArrCopyOf;
                            iArr = iArrCopyOf2;
                            i7 = i14;
                            jArr2 = jArrCopyOf2;
                            j = j7;
                        } else {
                            i5 = unsignedIntToInt8;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("Inconsistent stbl box for track ");
                        track2 = track;
                        sb.append(track2.id);
                        sb.append(": remainingSynchronizationSamples ");
                        sb.append(i21);
                        sb.append(", remainingSamplesAtTimestampDelta ");
                        sb.append(i2);
                        sb.append(", remainingSamplesInChunk ");
                        sb.append(i4);
                        sb.append(", remainingTimestampDeltaChanges ");
                        sb.append(i);
                        sb.append(", remainingSamplesAtTimestampOffset ");
                        sb.append(i5);
                        sb.append(z2 ? ", ctts invalid" : "");
                        Log.w(TAG, sb.toString());
                        i6 = sampleCount;
                        jArr = jArrCopyOf;
                        iArr = iArrCopyOf2;
                        i7 = i14;
                        jArr2 = jArrCopyOf2;
                        j = j7;
                    } else {
                        z2 = true;
                        if (i21 != 0) {
                            i5 = unsignedIntToInt8;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Inconsistent stbl box for track ");
                            track2 = track;
                            sb2.append(track2.id);
                            sb2.append(": remainingSynchronizationSamples ");
                            sb2.append(i21);
                            sb2.append(", remainingSamplesAtTimestampDelta ");
                            sb2.append(i2);
                            sb2.append(", remainingSamplesInChunk ");
                            sb2.append(i4);
                            sb2.append(", remainingTimestampDeltaChanges ");
                            sb2.append(i);
                            sb2.append(", remainingSamplesAtTimestampOffset ");
                            sb2.append(i5);
                            sb2.append(z2 ? ", ctts invalid" : "");
                            Log.w(TAG, sb2.toString());
                            i6 = sampleCount;
                            jArr = jArrCopyOf;
                            iArr = iArrCopyOf2;
                            i7 = i14;
                            jArr2 = jArrCopyOf2;
                            j = j7;
                        }
                    }
                } else {
                    int i29 = chunkIterator.length;
                    long[] jArr5 = new long[i29];
                    int[] iArr4 = new int[i29];
                    while (chunkIterator.moveNext()) {
                        int i30 = chunkIterator.index;
                        jArr5[i30] = chunkIterator.offset;
                        iArr4[i30] = chunkIterator.numSamples;
                    }
                    FixedSampleSizeRechunker.Results resultsRechunk = FixedSampleSizeRechunker.rechunk(fixedSampleSize, jArr5, iArr4, unsignedIntToInt6);
                    long[] jArr6 = resultsRechunk.offsets;
                    int[] iArr5 = resultsRechunk.sizes;
                    int i31 = resultsRechunk.maximumSize;
                    long[] jArr7 = resultsRechunk.timestamps;
                    int[] iArr6 = resultsRechunk.flags;
                    j = resultsRechunk.duration;
                    track2 = track;
                    i6 = sampleCount;
                    jArr = jArr6;
                    iArr = iArr5;
                    i7 = i31;
                    jArr2 = jArr7;
                    iArrCopyOf = iArr6;
                }
                long jScaleLargeTimestamp = Util.scaleLargeTimestamp(j, 1000000L, track2.timescale);
                jArr3 = track2.editListDurations;
                if (jArr3 != null) {
                    Util.scaleLargeTimestampsInPlace(jArr2, 1000000L, track2.timescale);
                    return new TrackSampleTable(track, jArr, iArr, i7, jArr2, iArrCopyOf, jScaleLargeTimestamp);
                }
                if (jArr3.length == 1 && track2.type == 1 && jArr2.length >= 2) {
                    long j8 = ((long[]) Assertions.checkNotNull(track2.editListMediaTimes))[0];
                    long jScaleLargeTimestamp2 = Util.scaleLargeTimestamp(track2.editListDurations[0], track2.timescale, track2.movieTimescale) + j8;
                    if (canApplyEditWithGaplessInfo(jArr2, j, j8, jScaleLargeTimestamp2)) {
                        long j9 = j - jScaleLargeTimestamp2;
                        long jScaleLargeTimestamp3 = Util.scaleLargeTimestamp(j8 - jArr2[0], track2.format.sampleRate, track2.timescale);
                        long jScaleLargeTimestamp4 = Util.scaleLargeTimestamp(j9, track2.format.sampleRate, track2.timescale);
                        if ((jScaleLargeTimestamp3 != 0 || jScaleLargeTimestamp4 != 0) && jScaleLargeTimestamp3 <= 2147483647L && jScaleLargeTimestamp4 <= 2147483647L) {
                            gaplessInfoHolder.encoderDelay = (int) jScaleLargeTimestamp3;
                            gaplessInfoHolder.encoderPadding = (int) jScaleLargeTimestamp4;
                            Util.scaleLargeTimestampsInPlace(jArr2, 1000000L, track2.timescale);
                            return new TrackSampleTable(track, jArr, iArr, i7, jArr2, iArrCopyOf, Util.scaleLargeTimestamp(track2.editListDurations[0], 1000000L, track2.movieTimescale));
                        }
                    }
                }
                long[] jArr8 = track2.editListDurations;
                if (jArr8.length == 1 && jArr8[0] == 0) {
                    long j10 = ((long[]) Assertions.checkNotNull(track2.editListMediaTimes))[0];
                    for (int i32 = 0; i32 < jArr2.length; i32++) {
                        jArr2[i32] = Util.scaleLargeTimestamp(jArr2[i32] - j10, 1000000L, track2.timescale);
                    }
                    return new TrackSampleTable(track, jArr, iArr, i7, jArr2, iArrCopyOf, Util.scaleLargeTimestamp(j - j10, 1000000L, track2.timescale));
                }
                boolean z4 = track2.type == 1;
                int[] iArr7 = new int[jArr8.length];
                int[] iArr8 = new int[jArr8.length];
                long[] jArr9 = (long[]) Assertions.checkNotNull(track2.editListMediaTimes);
                int i33 = 0;
                boolean z5 = false;
                int i34 = 0;
                int i35 = 0;
                while (true) {
                    long[] jArr10 = track2.editListDurations;
                    i10 = i7;
                    iArr2 = iArr;
                    if (i33 >= jArr10.length) {
                        break;
                    }
                    long j11 = jArr9[i33];
                    if (j11 != -1) {
                        int i36 = i35;
                        boolean z6 = z5;
                        int i37 = i34;
                        long jScaleLargeTimestamp5 = Util.scaleLargeTimestamp(jArr10[i33], track2.timescale, track2.movieTimescale);
                        int i38 = 1;
                        iArr7[i33] = Util.binarySearchFloor(jArr2, j11, true, true);
                        iArr8[i33] = Util.binarySearchCeil(jArr2, j11 + jScaleLargeTimestamp5, z4, false);
                        while (true) {
                            i11 = iArr7[i33];
                            if (i11 < 0 || (iArrCopyOf[i11] & i38) != 0) {
                                break;
                            }
                            iArr7[i33] = i11 - 1;
                            i38 = 1;
                        }
                        int i39 = iArr8[i33];
                        i34 = i37 + (i39 - i11);
                        z3 = z6 | (i36 != i11);
                        i35 = i39;
                    } else {
                        z3 = z5;
                    }
                    i33++;
                    i7 = i10;
                    z5 = z3;
                    iArr = iArr2;
                }
                boolean z7 = z5;
                int i40 = 0;
                boolean z8 = z7 | (i34 != i6);
                long[] jArr11 = z8 ? new long[i34] : jArr;
                int[] iArr9 = z8 ? new int[i34] : iArr2;
                int i41 = z8 ? 0 : i10;
                int[] iArr10 = z8 ? new int[i34] : iArrCopyOf;
                long[] jArr12 = new long[i34];
                int i42 = i41;
                long j12 = 0;
                boolean z9 = false;
                int i43 = 0;
                while (i40 < track2.editListDurations.length) {
                    long j13 = track2.editListMediaTimes[i40];
                    int i44 = iArr7[i40];
                    int[] iArr11 = iArr7;
                    int i45 = iArr8[i40];
                    int[] iArr12 = iArr8;
                    if (z8) {
                        int i46 = i45 - i44;
                        System.arraycopy(jArr, i44, jArr11, i43, i46);
                        jArr4 = jArr;
                        iArr3 = iArr2;
                        System.arraycopy(iArr3, i44, iArr9, i43, i46);
                        System.arraycopy(iArrCopyOf, i44, iArr10, i43, i46);
                    } else {
                        jArr4 = jArr;
                        iArr3 = iArr2;
                    }
                    int i47 = i42;
                    while (i44 < i45) {
                        int[] iArr13 = iArrCopyOf;
                        int i48 = i45;
                        long jScaleLargeTimestamp6 = Util.scaleLargeTimestamp(j12, 1000000L, track2.movieTimescale);
                        long j14 = j12;
                        long jScaleLargeTimestamp7 = Util.scaleLargeTimestamp(jArr2[i44] - j13, 1000000L, track2.timescale);
                        boolean z10 = jScaleLargeTimestamp7 < 0 ? true : z9;
                        jArr12[i43] = jScaleLargeTimestamp6 + jScaleLargeTimestamp7;
                        if (z8 && iArr9[i43] > i47) {
                            i47 = iArr3[i44];
                        }
                        i43++;
                        i44++;
                        i45 = i48;
                        iArrCopyOf = iArr13;
                        z9 = z10;
                        j12 = j14;
                    }
                    j12 += track2.editListDurations[i40];
                    i40++;
                    i42 = i47;
                    iArrCopyOf = iArrCopyOf;
                    iArr7 = iArr11;
                    iArr8 = iArr12;
                    iArr2 = iArr3;
                    jArr = jArr4;
                }
                return new TrackSampleTable(z9 ? track2.copyWithFormat(track2.format.buildUpon().setHasPrerollSamples(true).build()) : track2, jArr11, iArr9, i42, jArr12, iArr10, Util.scaleLargeTimestamp(j12, 1000000L, track2.movieTimescale));
            }
            parsableByteArray4 = null;
        } else {
            unsignedIntToInt2 = 0;
        }
        unsignedIntToInt3 = -1;
        fixedSampleSize = stz2SampleSizeBox.getFixedSampleSize();
        str = track.format.sampleMimeType;
        if (fixedSampleSize == -1 && ("audio/raw".equals(str) || "audio/g711-mlaw".equals(str) || "audio/g711-alaw".equals(str)) && unsignedIntToInt4 == 0 && unsignedIntToInt == 0 && unsignedIntToInt2 == 0) {
        }
        long jScaleLargeTimestamp8 = Util.scaleLargeTimestamp(j, 1000000L, track2.timescale);
        jArr3 = track2.editListDurations;
        if (jArr3 != null) {
        }
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int i, int i2, String str, @Nullable DrmInitData drmInitData, boolean z) throws ParserException {
        int i3;
        parsableByteArray.setPosition(12);
        int i4 = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(i4);
        for (int i5 = 0; i5 < i4; i5++) {
            int position = parsableByteArray.getPosition();
            int i6 = parsableByteArray.readInt();
            Assertions.checkState(i6 > 0, "childAtomSize should be positive");
            int i7 = parsableByteArray.readInt();
            if (i7 == 1635148593 || i7 == 1635148595 || i7 == 1701733238 || i7 == 1831958048 || i7 == 1836070006 || i7 == 1752589105 || i7 == 1751479857 || i7 == 1932670515 || i7 == 1211250227 || i7 == 1987063864 || i7 == 1987063865 || i7 == 1635135537 || i7 == 1685479798 || i7 == 1685479729 || i7 == 1685481573 || i7 == 1685481521) {
                i3 = position;
                parseVideoSampleEntry(parsableByteArray, i7, i3, i6, i, i2, drmInitData, stsdData, i5);
            } else if (i7 == 1836069985 || i7 == 1701733217 || i7 == 1633889587 || i7 == 1700998451 || i7 == 1633889588 || i7 == 1685353315 || i7 == 1685353317 || i7 == 1685353320 || i7 == 1685353324 || i7 == 1685353336 || i7 == 1935764850 || i7 == 1935767394 || i7 == 1819304813 || i7 == 1936684916 || i7 == 1953984371 || i7 == 778924082 || i7 == 778924083 || i7 == 1634492771 || i7 == 1634492791 || i7 == 1970037111 || i7 == 1332770163 || i7 == 1716281667 || i7 == 1835557169 || i7 == 1835560241) {
                i3 = position;
                parseAudioSampleEntry(parsableByteArray, i7, position, i6, i, str, z, drmInitData, stsdData, i5);
            } else {
                if (i7 == 1414810956 || i7 == 1954034535 || i7 == 2004251764 || i7 == 1937010800 || i7 == 1664495672) {
                    parseTextSampleEntry(parsableByteArray, i7, position, i6, i, str, stsdData);
                } else if (i7 == 1835365492) {
                    parseMetaDataSampleEntry(parsableByteArray, i7, position, i, stsdData);
                } else if (i7 == 1667329389) {
                    stsdData.format = new Format.Builder().setId(i).setSampleMimeType("application/x-camera-motion").build();
                }
                i3 = position;
            }
            parsableByteArray.setPosition(i3 + i6);
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 8 + 8);
        String str2 = "application/ttml+xml";
        ImmutableList immutableListOf = null;
        long j = Long.MAX_VALUE;
        if (i != 1414810956) {
            if (i == 1954034535) {
                int i5 = (i3 - 8) - 8;
                byte[] bArr = new byte[i5];
                parsableByteArray.readBytes(bArr, 0, i5);
                immutableListOf = ImmutableList.of(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i == 1937010800) {
                j = 0;
            } else {
                if (i != 1664495672) {
                    throw new IllegalStateException();
                }
                stsdData.requiredSampleTransformation = 1;
                str2 = "application/x-mp4-cea-608";
            }
        }
        stsdData.format = new Format.Builder().setId(i4).setSampleMimeType(str2).setLanguage(str).setSubsampleOffsetUs(j).setInitializationData(immutableListOf).build();
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        boolean z;
        parsableByteArray.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(fullAtomVersion == 0 ? 8 : 16);
        int i = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        int i2 = fullAtomVersion == 0 ? 4 : 8;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= i2) {
                z = true;
                break;
            }
            if (parsableByteArray.getData()[position + i4] != -1) {
                z = false;
                break;
            }
            i4++;
        }
        long j = -9223372036854775807L;
        if (z) {
            parsableByteArray.skipBytes(i2);
        } else {
            long unsignedInt = fullAtomVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
            if (unsignedInt != 0) {
                j = unsignedInt;
            }
        }
        parsableByteArray.skipBytes(16);
        int i5 = parsableByteArray.readInt();
        int i6 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int i7 = parsableByteArray.readInt();
        int i8 = parsableByteArray.readInt();
        if (i5 == 0 && i6 == 65536 && i7 == -65536 && i8 == 0) {
            i3 = 90;
        } else if (i5 == 0 && i6 == -65536 && i7 == 65536 && i8 == 0) {
            i3 = 270;
        } else if (i5 == -65536 && i6 == 0 && i7 == 0 && i8 == -65536) {
            i3 = EffectConstants.ROTATION_DEGREES_180;
        }
        return new TkhdData(i, j, i3);
    }

    @Nullable
    private static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j, @Nullable DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        Atom.LeafAtom leafAtom2;
        long j2;
        long[] jArr;
        long[] jArr2;
        Format formatBuild;
        Atom.ContainerAtom containerAtomOfType;
        Atom.ContainerAtom containerAtomOfType2;
        Pair<long[], long[]> edts;
        Atom.ContainerAtom containerAtom2 = (Atom.ContainerAtom) Assertions.checkNotNull(containerAtom.getContainerAtomOfType(1835297121));
        int trackTypeForHdlr = getTrackTypeForHdlr(parseHdlr(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom2.getLeafAtomOfType(1751411826))).data));
        if (trackTypeForHdlr == -1) {
            return null;
        }
        TkhdData tkhd = parseTkhd(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(1953196132))).data);
        if (j == -9223372036854775807L) {
            leafAtom2 = leafAtom;
            j2 = tkhd.duration;
        } else {
            leafAtom2 = leafAtom;
            j2 = j;
        }
        long mvhd = parseMvhd(leafAtom2.data);
        long jScaleLargeTimestamp = j2 != -9223372036854775807L ? Util.scaleLargeTimestamp(j2, 1000000L, mvhd) : -9223372036854775807L;
        Atom.ContainerAtom containerAtom3 = (Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(containerAtom2.getContainerAtomOfType(1835626086))).getContainerAtomOfType(1937007212));
        Pair<Long, String> mdhd = parseMdhd(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom2.getLeafAtomOfType(1835296868))).data);
        StsdData stsd = parseStsd(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom3.getLeafAtomOfType(1937011556))).data, tkhd.id, tkhd.rotationDegrees, (String) mdhd.second, drmInitData, z2);
        if (z || (containerAtomOfType2 = containerAtom.getContainerAtomOfType(1701082227)) == null || (edts = parseEdts(containerAtomOfType2)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) edts.first;
            jArr2 = (long[]) edts.second;
            jArr = jArr3;
        }
        Format format = stsd.format;
        if (format == null) {
            return null;
        }
        if (!z2 || (containerAtomOfType = containerAtom.getContainerAtomOfType(Atom.TYPE_tapt)) == null) {
            formatBuild = format;
        } else {
            ClefData clef = parseClef(((Atom.LeafAtom) Assertions.checkNotNull(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_clef))).data);
            formatBuild = format.buildUpon().setDisplayWidth((int) clef.width).setDisplayHeight((int) clef.height).build();
        }
        return new Track(tkhd.id, trackTypeForHdlr, ((Long) mdhd.first).longValue(), mvhd, jScaleLargeTimestamp, formatBuild, stsd.requiredSampleTransformation, stsd.trackEncryptionBoxes, stsd.nalUnitLengthFieldLength, jArr, jArr2);
    }

    public static List<TrackSampleTable> parseTraks(Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder, long j, @Nullable DrmInitData drmInitData, boolean z, boolean z2, u42<Track, Track> u42Var) throws ParserException {
        Track trackApply;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < containerAtom.containerChildren.size(); i++) {
            Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i);
            if (containerAtom2.type == 1953653099 && (trackApply = u42Var.apply(parseTrak(containerAtom2, (Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(1836476516)), j, drmInitData, z, z2))) != null) {
                arrayList.add(parseStbl(trackApply, (Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(containerAtom2.getContainerAtomOfType(1835297121))).getContainerAtomOfType(1835626086))).getContainerAtomOfType(1937007212)), gaplessInfoHolder));
            }
        }
        return arrayList;
    }

    public static Pair<Metadata, Metadata> parseUdta(Atom.LeafAtom leafAtom) {
        ParsableByteArray parsableByteArray = leafAtom.data;
        parsableByteArray.setPosition(8);
        Metadata udtaMeta = null;
        Metadata smta = null;
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int i = parsableByteArray.readInt();
            int i2 = parsableByteArray.readInt();
            if (i2 == 1835365473) {
                parsableByteArray.setPosition(position);
                udtaMeta = parseUdtaMeta(parsableByteArray, position + i);
            } else if (i2 == 1936553057) {
                parsableByteArray.setPosition(position);
                smta = parseSmta(parsableByteArray, position + i);
            }
            parsableByteArray.setPosition(position + i);
        }
        return Pair.create(udtaMeta, smta);
    }

    @Nullable
    private static Metadata parseUdtaMeta(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        maybeSkipRemainingMetaAtomHeaderBytes(parsableByteArray);
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

    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, int i5, @Nullable DrmInitData drmInitData, StsdData stsdData, int i6) throws ParserException {
        DrmInitData drmInitData2;
        List<byte[]> list;
        int i7;
        String str;
        int i8;
        int i9;
        String str2;
        int i10 = i2;
        int i11 = i3;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        parsableByteArray.setPosition(i10 + 8 + 8);
        parsableByteArray.skipBytes(16);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int unsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(50);
        int position = parsableByteArray.getPosition();
        int iIntValue = i;
        if (iIntValue == 1701733238) {
            Pair<Integer, TrackEncryptionBox> sampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i10, i11);
            if (sampleEntryEncryptionData != null) {
                iIntValue = ((Integer) sampleEntryEncryptionData.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((TrackEncryptionBox) sampleEntryEncryptionData.second).schemeType);
                stsdData.trackEncryptionBoxes[i6] = (TrackEncryptionBox) sampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        String str3 = iIntValue == 1831958048 ? "video/mpeg" : iIntValue == 1211250227 ? "video/3gpp" : null;
        float paspFromParent = 1.0f;
        byte[] projFromParent = null;
        int i12 = -1;
        String str4 = null;
        List<byte[]> listOf = null;
        int i13 = -1;
        int i14 = -1;
        int iIsoTransferCharacteristicsToColorTransfer = -1;
        boolean z = false;
        while (true) {
            if (position - i10 >= i11) {
                drmInitData2 = drmInitDataCopyWithSchemeType;
                list = listOf;
                break;
            }
            parsableByteArray.setPosition(position);
            int position2 = parsableByteArray.getPosition();
            drmInitData2 = drmInitDataCopyWithSchemeType;
            int i15 = parsableByteArray.readInt();
            if (i15 == 0) {
                list = listOf;
                if (parsableByteArray.getPosition() - i10 == i11) {
                    break;
                }
            } else {
                list = listOf;
            }
            Assertions.checkState(i15 > 0, "childAtomSize should be positive");
            int i16 = parsableByteArray.readInt();
            if (i16 == 1635148611) {
                Assertions.checkState(str3 == null);
                parsableByteArray.setPosition(position2 + 8);
                AvcConfig avcConfig = AvcConfig.parse(parsableByteArray);
                listOf = avcConfig.initializationData;
                stsdData.nalUnitLengthFieldLength = avcConfig.nalUnitLengthFieldLength;
                if (!z) {
                    paspFromParent = avcConfig.pixelWidthHeightRatio;
                }
                str4 = avcConfig.codecs;
                i12 = avcConfig.colorSpace;
                i8 = avcConfig.colorRange;
                i9 = avcConfig.colorTransfer;
                str2 = "video/avc";
            } else if (i16 == 1752589123) {
                Assertions.checkState(str3 == null);
                parsableByteArray.setPosition(position2 + 8);
                HevcConfig hevcConfig = HevcConfig.parse(parsableByteArray);
                listOf = hevcConfig.initializationData;
                stsdData.nalUnitLengthFieldLength = hevcConfig.nalUnitLengthFieldLength;
                if (!z) {
                    paspFromParent = hevcConfig.pixelWidthHeightRatio;
                }
                str4 = hevcConfig.codecs;
                i12 = hevcConfig.colorSpace;
                i8 = hevcConfig.colorRange;
                i9 = hevcConfig.colorTransfer;
                str2 = "video/hevc";
            } else {
                if (i16 == 1685480259 || i16 == 1685485123) {
                    i7 = iIsoTransferCharacteristicsToColorTransfer;
                    DolbyVisionConfig dolbyVisionConfig = DolbyVisionConfig.parse(parsableByteArray);
                    if (dolbyVisionConfig != null) {
                        str4 = dolbyVisionConfig.codecs;
                        str3 = "video/dolby-vision";
                    }
                } else {
                    if (i16 == 1987076931) {
                        Assertions.checkState(str3 == null);
                        str = iIntValue == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                    } else if (i16 == 1635135811) {
                        Assertions.checkState(str3 == null);
                        str = "video/av01";
                    } else {
                        if (i16 == 1681012275) {
                            Assertions.checkState(str3 == null);
                            str3 = "video/3gpp";
                        } else {
                            if (i16 == 1702061171) {
                                Assertions.checkState(str3 == null);
                                Pair<String, byte[]> esdsFromParent = parseEsdsFromParent(parsableByteArray, position2);
                                str3 = (String) esdsFromParent.first;
                                byte[] bArr = (byte[]) esdsFromParent.second;
                                if (bArr != null) {
                                    listOf = ImmutableList.of(bArr);
                                }
                            } else if (i16 == 1885434736) {
                                paspFromParent = parsePaspFromParent(parsableByteArray, position2);
                                listOf = list;
                                z = true;
                            } else if (i16 == 1937126244) {
                                projFromParent = parseProjFromParent(parsableByteArray, position2, i15);
                            } else if (i16 == 1936995172) {
                                int unsignedByte = parsableByteArray.readUnsignedByte();
                                parsableByteArray.skipBytes(3);
                                if (unsignedByte == 0) {
                                    int unsignedByte2 = parsableByteArray.readUnsignedByte();
                                    if (unsignedByte2 == 0) {
                                        i13 = 0;
                                    } else if (unsignedByte2 == 1) {
                                        i13 = 1;
                                    } else if (unsignedByte2 == 2) {
                                        i13 = 2;
                                    } else if (unsignedByte2 == 3) {
                                        i13 = 3;
                                    }
                                }
                            } else if (i16 == 1668246642) {
                                i7 = iIsoTransferCharacteristicsToColorTransfer;
                                if ((i12 == -1 && i7 == -1) || (i12 == 2 && i7 == 2)) {
                                    int i17 = parsableByteArray.readInt();
                                    if (i17 == TYPE_nclx || i17 == TYPE_nclc) {
                                        int unsignedShort3 = parsableByteArray.readUnsignedShort();
                                        int unsignedShort4 = parsableByteArray.readUnsignedShort();
                                        parsableByteArray.skipBytes(2);
                                        boolean z2 = i15 == 19 && (parsableByteArray.readUnsignedByte() & 128) != 0;
                                        int iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(unsignedShort3);
                                        i14 = z2 ? 1 : 2;
                                        iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(unsignedShort4);
                                        i12 = iIsoColorPrimariesToColorSpace;
                                    } else {
                                        Log.w(TAG, "Unsupported color type: " + Atom.getAtomTypeString(i17));
                                    }
                                }
                            } else {
                                i7 = iIsoTransferCharacteristicsToColorTransfer;
                            }
                            position += i15;
                            i10 = i2;
                            i11 = i3;
                            drmInitDataCopyWithSchemeType = drmInitData2;
                        }
                        listOf = list;
                        position += i15;
                        i10 = i2;
                        i11 = i3;
                        drmInitDataCopyWithSchemeType = drmInitData2;
                    }
                    str3 = str;
                    listOf = list;
                    position += i15;
                    i10 = i2;
                    i11 = i3;
                    drmInitDataCopyWithSchemeType = drmInitData2;
                }
                iIsoTransferCharacteristicsToColorTransfer = i7;
                listOf = list;
                position += i15;
                i10 = i2;
                i11 = i3;
                drmInitDataCopyWithSchemeType = drmInitData2;
            }
            iIsoTransferCharacteristicsToColorTransfer = i9;
            i14 = i8;
            str3 = str2;
            position += i15;
            i10 = i2;
            i11 = i3;
            drmInitDataCopyWithSchemeType = drmInitData2;
        }
        int i18 = iIsoTransferCharacteristicsToColorTransfer;
        if (str3 == null) {
            return;
        }
        stsdData.format = new Format.Builder().setId(i4).setSampleMimeType(str3).setCodecs(str4).setWidth(unsignedShort).setHeight(unsignedShort2).setPixelWidthHeightRatio(paspFromParent).setRotationDegrees(i5).setProjectionData(projFromParent).setStereoMode(i13).setInitializationData(list).setDrmInitData(drmInitData2).setColorInfo(new ColorInfo.Builder().setColorSpace(i12).setColorRange(i14).setColorTransfer(i18).setHdrStaticInfo(null).build()).build();
    }
}
