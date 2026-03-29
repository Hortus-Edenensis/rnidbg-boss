package androidx.media3.extractor;

import androidx.annotation.Nullable;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.TECameraUtils;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class Ac4Util {
    public static final int AC40_SYNCWORD = 44096;
    public static final int AC41_SYNCWORD = 44097;
    private static final int CHANNEL_COUNT_2 = 2;
    private static final int CHANNEL_MODE_22_2 = 15;
    private static final int CHANNEL_MODE_3_0 = 2;
    private static final int CHANNEL_MODE_5_0 = 3;
    private static final int CHANNEL_MODE_5_1 = 4;
    private static final int CHANNEL_MODE_7_0_322 = 9;
    private static final int CHANNEL_MODE_7_0_34 = 5;
    private static final int CHANNEL_MODE_7_0_4 = 11;
    private static final int CHANNEL_MODE_7_0_52 = 7;
    private static final int CHANNEL_MODE_7_1_322 = 10;
    private static final int CHANNEL_MODE_7_1_34 = 6;
    private static final int CHANNEL_MODE_7_1_4 = 12;
    private static final int CHANNEL_MODE_7_1_52 = 8;
    private static final int CHANNEL_MODE_9_0_4 = 13;
    private static final int CHANNEL_MODE_9_1_4 = 14;
    private static final int CHANNEL_MODE_MONO = 0;
    private static final int CHANNEL_MODE_STEREO = 1;
    private static final int CHANNEL_MODE_UNKNOWN = -1;
    public static final int HEADER_SIZE_FOR_PARSER = 16;
    public static final int MAX_RATE_BYTES_PER_SECOND = 336000;
    private static final int[] SAMPLE_COUNT = {2002, 2000, TECameraUtils.CAPTURE_NORMAL, 1601, 1600, 1001, 1000, 960, 800, 800, TECameraSettings.FPS_480, 400, 400, 2048};
    public static final int SAMPLE_HEADER_SIZE = 7;
    private static final String TAG = "Ac4Util";

    /* JADX INFO: compiled from: SearchBox */
    public static final class Ac4Presentation {
        public int channelMode;
        public boolean hasBackChannels;
        public boolean isChannelCoded;
        public int level;
        public int numOfUmxObjects;
        public int topChannelPairs;
        public int version;

        private Ac4Presentation() {
            this.isChannelCoded = true;
            this.channelMode = -1;
            this.numOfUmxObjects = -1;
            this.hasBackChannels = true;
            this.topChannelPairs = 2;
            this.version = 1;
            this.level = 0;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class SyncFrameInfo {
        public final int bitstreamVersion;
        public final int channelCount;
        public final int frameSize;
        public final int sampleCount;
        public final int sampleRate;

        private SyncFrameInfo(int i, int i2, int i3, int i4, int i5) {
            this.bitstreamVersion = i;
            this.channelCount = i2;
            this.sampleRate = i3;
            this.frameSize = i4;
            this.sampleCount = i5;
        }
    }

    private Ac4Util() {
    }

    private static String createCodecsString(int i, int i2, int i3) {
        return Util.formatInvariant("ac-4.%02d.%02d.%02d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static void getAc4SampleHeader(int i, ParsableByteArray parsableByteArray) {
        parsableByteArray.reset(7);
        byte[] data = parsableByteArray.getData();
        data[0] = -84;
        data[1] = 64;
        data[2] = -1;
        data[3] = -1;
        data[4] = (byte) ((i >> 16) & 255);
        data[5] = (byte) ((i >> 8) & 255);
        data[6] = (byte) (i & 255);
    }

    private static int getAdjustedChannelCount(int i, boolean z, int i2) {
        int channelCountFromChannelMode = getChannelCountFromChannelMode(i);
        if (i != 11 && i != 12 && i != 13 && i != 14) {
            return channelCountFromChannelMode;
        }
        if (!z) {
            channelCountFromChannelMode -= 2;
        }
        return i2 != 0 ? i2 != 1 ? channelCountFromChannelMode : channelCountFromChannelMode - 2 : channelCountFromChannelMode - 4;
    }

    private static int getChannelCountFromChannelMode(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 5;
            case 4:
                return 6;
            case 5:
            case 7:
            case 9:
                return 7;
            case 6:
            case 8:
            case 10:
                return 8;
            case 11:
                return 11;
            case 12:
                return 12;
            case 13:
                return 13;
            case 14:
                return 14;
            case 15:
                return 24;
            default:
                return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:163:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Format parseAc4AnnexEFormat(ParsableByteArray parsableByteArray, String str, @Nullable String str2, @Nullable DrmInitData drmInitData) throws ParserException {
        int adjustedChannelCount;
        boolean bit;
        int bits;
        int bits2;
        int iBitsLeft;
        int bits3;
        boolean z;
        boolean bit2;
        int i;
        ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.reset(parsableByteArray);
        int iBitsLeft2 = parsableBitArray.bitsLeft();
        int bits4 = parsableBitArray.readBits(3);
        if (bits4 > 1) {
            throw ParserException.createForUnsupportedContainerFeature("Unsupported AC-4 DSI version: " + bits4);
        }
        int bits5 = parsableBitArray.readBits(7);
        int i2 = parsableBitArray.readBit() ? 48000 : 44100;
        parsableBitArray.skipBits(4);
        int bits6 = parsableBitArray.readBits(9);
        if (bits5 > 1) {
            if (bits4 == 0) {
                throw ParserException.createForUnsupportedContainerFeature("Invalid AC-4 DSI version: " + bits4);
            }
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(16);
                if (parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(128);
                }
            }
        }
        if (bits4 == 1) {
            if (!skipDsiBitrate(parsableBitArray)) {
                throw ParserException.createForUnsupportedContainerFeature("Invalid AC-4 DSI bitrate.");
            }
            parsableBitArray.byteAlign();
        }
        Ac4Presentation ac4Presentation = new Ac4Presentation();
        for (int i3 = 0; i3 < bits6; i3++) {
            if (bits4 == 0) {
                bit = parsableBitArray.readBit();
                bits = parsableBitArray.readBits(5);
                bits2 = parsableBitArray.readBits(5);
                iBitsLeft = 0;
                bits3 = 0;
                z = false;
            } else {
                int bits7 = parsableBitArray.readBits(8);
                bits3 = parsableBitArray.readBits(8);
                if (bits3 == 255) {
                    bits3 += parsableBitArray.readBits(16);
                }
                if (bits7 > 2) {
                    parsableBitArray.skipBits(bits3 * 8);
                } else {
                    iBitsLeft = (iBitsLeft2 - parsableBitArray.bitsLeft()) / 8;
                    int bits8 = parsableBitArray.readBits(5);
                    z = bits8 == 31;
                    bits2 = bits7;
                    bits = bits8;
                    bit = false;
                }
            }
            ac4Presentation.version = bits2;
            if (bit || z || bits != 6) {
                ac4Presentation.level = parsableBitArray.readBits(3);
                if (parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(5);
                }
                parsableBitArray.skipBits(2);
                int i4 = 1;
                if (bits4 == 1 && (bits2 == 1 || bits2 == 2)) {
                    parsableBitArray.skipBits(2);
                }
                parsableBitArray.skipBits(5);
                parsableBitArray.skipBits(10);
                if (bits4 == 1) {
                    if (bits2 > 0) {
                        ac4Presentation.isChannelCoded = parsableBitArray.readBit();
                    }
                    if (ac4Presentation.isChannelCoded) {
                        if (bits2 != 1) {
                            i = 2;
                            if (bits2 == 2) {
                                int bits9 = parsableBitArray.readBits(5);
                                if (bits9 >= 0 && bits9 <= 15) {
                                    ac4Presentation.channelMode = bits9;
                                }
                                if (bits9 < 11 || bits9 > 14) {
                                    i = 2;
                                } else {
                                    ac4Presentation.hasBackChannels = parsableBitArray.readBit();
                                    i = 2;
                                    ac4Presentation.topChannelPairs = parsableBitArray.readBits(2);
                                }
                            }
                            parsableBitArray.skipBits(24);
                            i4 = 1;
                        }
                        if (ac4Presentation.isChannelCoded) {
                            adjustedChannelCount = getAdjustedChannelCount(ac4Presentation.channelMode, ac4Presentation.hasBackChannels, ac4Presentation.topChannelPairs);
                        } else {
                            int i5 = ac4Presentation.numOfUmxObjects;
                            if (i5 > 0) {
                                int i6 = i5 + 1;
                                if (ac4Presentation.level == 4 && i6 == 17) {
                                    i6 = 21;
                                }
                                adjustedChannelCount = i6;
                            } else {
                                int i7 = ac4Presentation.level;
                                if (i7 != 0) {
                                    if (i7 == 1) {
                                        adjustedChannelCount = 6;
                                    } else if (i7 == 2) {
                                        adjustedChannelCount = 8;
                                    } else if (i7 == 3) {
                                        adjustedChannelCount = 10;
                                    } else if (i7 != 4) {
                                        Log.w(TAG, "AC-4 level " + ac4Presentation.level + " has not been defined.");
                                    } else {
                                        adjustedChannelCount = 12;
                                    }
                                }
                                adjustedChannelCount = 2;
                            }
                        }
                        if (adjustedChannelCount > 0) {
                            return new Format.Builder().setId(str).setSampleMimeType("audio/ac4").setChannelCount(adjustedChannelCount).setSampleRate(i2).setDrmInitData(drmInitData).setLanguage(str2).setCodecs(createCodecsString(bits5, ac4Presentation.version, ac4Presentation.level)).build();
                        }
                        throw ParserException.createForUnsupportedContainerFeature("Cannot determine channel count of presentation.");
                    }
                    i = 2;
                    if (bits2 == i4 || bits2 == i) {
                        if (parsableBitArray.readBit() && parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(i);
                        }
                        if (parsableBitArray.readBit()) {
                            parsableBitArray.skipBit();
                            int i8 = 8;
                            int bits10 = parsableBitArray.readBits(8);
                            int i9 = 0;
                            while (i9 < bits10) {
                                parsableBitArray.skipBits(i8);
                                i9++;
                                i8 = 8;
                            }
                        }
                    }
                }
                if (!bit && !z) {
                    parsableBitArray.skipBit();
                    if (bits == 0 || bits == 1 || bits == 2) {
                        if (bits2 == 0) {
                            for (int i10 = 0; i10 < 2; i10++) {
                                parseDsiSubstream(parsableBitArray, ac4Presentation);
                            }
                        } else {
                            int i11 = 0;
                            for (int i12 = 2; i11 < i12; i12 = 2) {
                                parseDsiSubstreamGroup(parsableBitArray, ac4Presentation);
                                i11++;
                            }
                        }
                    } else if (bits == 3 || bits == 4) {
                        if (bits2 == 0) {
                            for (int i13 = 0; i13 < 3; i13++) {
                                parseDsiSubstream(parsableBitArray, ac4Presentation);
                            }
                        } else {
                            int i14 = 0;
                            for (int i15 = 3; i14 < i15; i15 = 3) {
                                parseDsiSubstreamGroup(parsableBitArray, ac4Presentation);
                                i14++;
                            }
                        }
                    } else if (bits != 5) {
                        int bits11 = parsableBitArray.readBits(7);
                        for (int i16 = 0; i16 < bits11; i16++) {
                            parsableBitArray.skipBits(8);
                        }
                    } else if (bits2 == 0) {
                        parseDsiSubstream(parsableBitArray, ac4Presentation);
                    } else {
                        int bits12 = parsableBitArray.readBits(3);
                        for (int i17 = 0; i17 < bits12 + 2; i17++) {
                            parseDsiSubstreamGroup(parsableBitArray, ac4Presentation);
                        }
                    }
                } else if (bits2 == 0) {
                    parseDsiSubstream(parsableBitArray, ac4Presentation);
                } else {
                    parseDsiSubstreamGroup(parsableBitArray, ac4Presentation);
                }
                parsableBitArray.skipBit();
                bit2 = parsableBitArray.readBit();
            } else {
                bit2 = true;
            }
            if (bit2) {
                int bits13 = parsableBitArray.readBits(7);
                for (int i18 = 0; i18 < bits13; i18++) {
                    parsableBitArray.skipBits(15);
                }
            }
            if (bits2 > 0) {
                if (parsableBitArray.readBit() && !skipDsiBitrate(parsableBitArray)) {
                    throw ParserException.createForUnsupportedContainerFeature("Can't parse bitrate DSI.");
                }
                if (parsableBitArray.readBit()) {
                    parsableBitArray.byteAlign();
                    parsableBitArray.skipBytes(parsableBitArray.readBits(16));
                    int bits14 = parsableBitArray.readBits(5);
                    for (int i19 = 0; i19 < bits14; i19++) {
                        parsableBitArray.skipBits(3);
                        parsableBitArray.skipBits(8);
                    }
                }
            }
            parsableBitArray.byteAlign();
            if (bits4 == 1) {
                int iBitsLeft3 = ((iBitsLeft2 - parsableBitArray.bitsLeft()) / 8) - iBitsLeft;
                if (bits3 < iBitsLeft3) {
                    throw ParserException.createForUnsupportedContainerFeature("pres_bytes is smaller than presentation bytes read.");
                }
                parsableBitArray.skipBytes(bits3 - iBitsLeft3);
            }
            if (ac4Presentation.isChannelCoded && ac4Presentation.channelMode == -1) {
                throw ParserException.createForUnsupportedContainerFeature("Can't determine channel mode of presentation " + i3);
            }
            if (ac4Presentation.isChannelCoded) {
            }
            if (adjustedChannelCount > 0) {
            }
        }
        if (ac4Presentation.isChannelCoded) {
        }
        if (adjustedChannelCount > 0) {
        }
    }

    public static int parseAc4SyncframeAudioSampleCount(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(iPosition);
        return parseAc4SyncframeInfo(new ParsableBitArray(bArr)).sampleCount;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SyncFrameInfo parseAc4SyncframeInfo(ParsableBitArray parsableBitArray) {
        int i;
        int i2;
        int bits = parsableBitArray.readBits(16);
        int bits2 = parsableBitArray.readBits(16);
        if (bits2 == 65535) {
            bits2 = parsableBitArray.readBits(24);
            i = 7;
        } else {
            i = 4;
        }
        int i3 = bits2 + i;
        if (bits == 44097) {
            i3 += 2;
        }
        int i4 = i3;
        int bits3 = parsableBitArray.readBits(2);
        if (bits3 == 3) {
            bits3 += readVariableBits(parsableBitArray, 2);
        }
        int i5 = bits3;
        int bits4 = parsableBitArray.readBits(10);
        if (parsableBitArray.readBit() && parsableBitArray.readBits(3) > 0) {
            parsableBitArray.skipBits(2);
        }
        int i6 = parsableBitArray.readBit() ? 48000 : 44100;
        int bits5 = parsableBitArray.readBits(4);
        if (i6 == 44100 && bits5 == 13) {
            i2 = SAMPLE_COUNT[bits5];
        } else if (i6 == 48000) {
            int[] iArr = SAMPLE_COUNT;
            if (bits5 < iArr.length) {
                int i7 = iArr[bits5];
                int i8 = bits4 % 5;
                if (i8 == 1) {
                    if (bits5 == 3 || bits5 == 8) {
                        i7++;
                    }
                    i2 = i7;
                } else if (i8 == 2) {
                    if (bits5 == 8 || bits5 == 11) {
                    }
                    i2 = i7;
                } else if (i8 != 3) {
                    if (i8 == 4 && (bits5 == 3 || bits5 == 8 || bits5 == 11)) {
                    }
                    i2 = i7;
                }
            } else {
                i2 = 0;
            }
        }
        return new SyncFrameInfo(i5, 2, i6, i4, i2);
    }

    public static int parseAc4SyncframeSize(byte[] bArr, int i) {
        int i2 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        int i3 = ((bArr[2] & UByte.MAX_VALUE) << 8) | (bArr[3] & UByte.MAX_VALUE);
        if (i3 == 65535) {
            i3 = ((bArr[4] & UByte.MAX_VALUE) << 16) | ((bArr[5] & UByte.MAX_VALUE) << 8) | (bArr[6] & UByte.MAX_VALUE);
        } else {
            i2 = 4;
        }
        if (i == 44097) {
            i2 += 2;
        }
        return i3 + i2;
    }

    private static void parseDsiSubstream(ParsableBitArray parsableBitArray, Ac4Presentation ac4Presentation) throws ParserException {
        int bits = parsableBitArray.readBits(5);
        parsableBitArray.skipBits(2);
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(5);
        }
        if (bits >= 7 && bits <= 10) {
            parsableBitArray.skipBit();
        }
        if (parsableBitArray.readBit()) {
            int bits2 = parsableBitArray.readBits(3);
            if (ac4Presentation.channelMode == -1 && bits >= 0 && bits <= 15 && (bits2 == 0 || bits2 == 1)) {
                ac4Presentation.channelMode = bits;
            }
            if (parsableBitArray.readBit()) {
                skipDsiLanguage(parsableBitArray);
            }
        }
    }

    private static void parseDsiSubstreamGroup(ParsableBitArray parsableBitArray, Ac4Presentation ac4Presentation) throws ParserException {
        parsableBitArray.skipBits(2);
        boolean bit = parsableBitArray.readBit();
        int bits = parsableBitArray.readBits(8);
        for (int i = 0; i < bits; i++) {
            parsableBitArray.skipBits(2);
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(5);
            }
            if (bit) {
                parsableBitArray.skipBits(24);
            } else {
                if (parsableBitArray.readBit()) {
                    if (!parsableBitArray.readBit()) {
                        parsableBitArray.skipBits(4);
                    }
                    ac4Presentation.numOfUmxObjects = parsableBitArray.readBits(6) + 1;
                }
                parsableBitArray.skipBits(4);
            }
        }
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(3);
            if (parsableBitArray.readBit()) {
                skipDsiLanguage(parsableBitArray);
            }
        }
    }

    private static int readVariableBits(ParsableBitArray parsableBitArray, int i) {
        int i2 = 0;
        while (true) {
            int bits = i2 + parsableBitArray.readBits(i);
            if (!parsableBitArray.readBit()) {
                return bits;
            }
            i2 = (bits + 1) << i;
        }
    }

    private static boolean skipDsiBitrate(ParsableBitArray parsableBitArray) {
        if (parsableBitArray.bitsLeft() < 66) {
            return false;
        }
        parsableBitArray.skipBits(66);
        return true;
    }

    private static void skipDsiLanguage(ParsableBitArray parsableBitArray) throws ParserException {
        int bits = parsableBitArray.readBits(6);
        if (bits < 2 || bits > 42) {
            throw ParserException.createForUnsupportedContainerFeature(String.format("Invalid language tag bytes number: %d. Must be between 2 and 42.", Integer.valueOf(bits)));
        }
        parsableBitArray.skipBits(bits * 8);
    }
}
