package androidx.media3.container;

import androidx.annotation.Nullable;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableList;
import com.ss.android.ttvecamera.TELogUtils;
import defpackage.ue1;
import j$.util.Objects;
import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class NalUnitUtil {
    public static final int EXTENDED_SAR = 255;
    public static final int H264_NAL_UNIT_TYPE_AUD = 9;
    public static final int H264_NAL_UNIT_TYPE_IDR = 5;
    public static final int H264_NAL_UNIT_TYPE_NON_IDR = 1;
    public static final int H264_NAL_UNIT_TYPE_PARTITION_A = 2;
    public static final int H264_NAL_UNIT_TYPE_PPS = 8;
    public static final int H264_NAL_UNIT_TYPE_PREFIX = 14;
    public static final int H264_NAL_UNIT_TYPE_SEI = 6;
    public static final int H264_NAL_UNIT_TYPE_SPS = 7;
    public static final int H264_NAL_UNIT_TYPE_UNSPECIFIED = 24;
    public static final int H265_NAL_UNIT_TYPE_AUD = 35;
    public static final int H265_NAL_UNIT_TYPE_BLA_W_LP = 16;
    public static final int H265_NAL_UNIT_TYPE_CRA = 21;
    public static final int H265_NAL_UNIT_TYPE_PPS = 34;
    public static final int H265_NAL_UNIT_TYPE_PREFIX_SEI = 39;
    public static final int H265_NAL_UNIT_TYPE_RASL_R = 9;
    public static final int H265_NAL_UNIT_TYPE_SPS = 33;
    public static final int H265_NAL_UNIT_TYPE_SUFFIX_SEI = 40;
    public static final int H265_NAL_UNIT_TYPE_UNSPECIFIED = 48;
    public static final int H265_NAL_UNIT_TYPE_VPS = 32;
    private static final int INVALID_ID = -1;

    @Deprecated
    public static final int NAL_UNIT_TYPE_AUD = 9;

    @Deprecated
    public static final int NAL_UNIT_TYPE_IDR = 5;

    @Deprecated
    public static final int NAL_UNIT_TYPE_NON_IDR = 1;

    @Deprecated
    public static final int NAL_UNIT_TYPE_PARTITION_A = 2;

    @Deprecated
    public static final int NAL_UNIT_TYPE_PPS = 8;

    @Deprecated
    public static final int NAL_UNIT_TYPE_PREFIX = 14;

    @Deprecated
    public static final int NAL_UNIT_TYPE_SEI = 6;

    @Deprecated
    public static final int NAL_UNIT_TYPE_SPS = 7;
    private static final String TAG = "NalUnitUtil";
    public static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    public static final float[] ASPECT_RATIO_IDC_VALUES = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object scratchEscapePositionsLock = new Object();
    private static int[] scratchEscapePositions = new int[10];

    /* JADX INFO: compiled from: SearchBox */
    public static final class H265LayerInfo {
        public final int layerIdInVps;
        public final int viewId;

        public H265LayerInfo(int i, int i2) {
            this.layerIdInVps = i;
            this.viewId = i2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class H265NalHeader {
        public final int layerId;
        public final int nalUnitType;
        public final int temporalId;

        public H265NalHeader(int i, int i2, int i3) {
            this.nalUnitType = i;
            this.layerId = i2;
            this.temporalId = i3;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class H265ProfileTierLevel {
        public final int[] constraintBytes;
        public final int generalLevelIdc;
        public final int generalProfileCompatibilityFlags;
        public final int generalProfileIdc;
        public final int generalProfileSpace;
        public final boolean generalTierFlag;

        public H265ProfileTierLevel(int i, boolean z, int i2, int i3, int[] iArr, int i4) {
            this.generalProfileSpace = i;
            this.generalTierFlag = z;
            this.generalProfileIdc = i2;
            this.generalProfileCompatibilityFlags = i3;
            this.constraintBytes = iArr;
            this.generalLevelIdc = i4;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class H265ProfileTierLevelsAndIndices {
        public final int[] indices;
        public final ImmutableList<H265ProfileTierLevel> profileTierLevels;

        public H265ProfileTierLevelsAndIndices(List<H265ProfileTierLevel> list, int[] iArr) {
            this.profileTierLevels = ImmutableList.copyOf((Collection) list);
            this.indices = iArr;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class H265RepFormat {
        public final int bitDepthChromaMinus8;
        public final int bitDepthLumaMinus8;
        public final int chromaFormatIdc;
        public final int height;
        public final int width;

        public H265RepFormat(int i, int i2, int i3, int i4, int i5) {
            this.chromaFormatIdc = i;
            this.bitDepthLumaMinus8 = i2;
            this.bitDepthChromaMinus8 = i3;
            this.width = i4;
            this.height = i5;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class H265RepFormatsAndIndices {
        public final int[] indices;
        public final ImmutableList<H265RepFormat> repFormats;

        public H265RepFormatsAndIndices(List<H265RepFormat> list, int[] iArr) {
            this.repFormats = ImmutableList.copyOf((Collection) list);
            this.indices = iArr;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class H265Sei3dRefDisplayInfoData {
        public final int exponentRefDisplayWidth;
        public final int exponentRefViewingDist;
        public final int leftViewId;
        public final int mantissaRefDisplayWidth;
        public final int mantissaRefViewingDist;
        public final int numRefDisplays;
        public final int precRefDisplayWidth;
        public final int precRefViewingDist;
        public final int rightViewId;

        public H265Sei3dRefDisplayInfoData(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.precRefDisplayWidth = i;
            this.precRefViewingDist = i2;
            this.numRefDisplays = i3;
            this.leftViewId = i4;
            this.rightViewId = i5;
            this.exponentRefDisplayWidth = i6;
            this.mantissaRefDisplayWidth = i7;
            this.exponentRefViewingDist = i8;
            this.mantissaRefViewingDist = i9;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class H265SpsData {
        public final int bitDepthChromaMinus8;
        public final int bitDepthLumaMinus8;
        public final int chromaFormatIdc;
        public final int colorRange;
        public final int colorSpace;
        public final int colorTransfer;
        public final int decodedHeight;
        public final int decodedWidth;
        public final int height;
        public final int maxNumReorderPics;
        public final int maxSubLayersMinus1;
        public final H265NalHeader nalHeader;
        public final float pixelWidthHeightRatio;

        @Nullable
        public final H265ProfileTierLevel profileTierLevel;
        public final int seqParameterSetId;
        public final int width;

        public H265SpsData(H265NalHeader h265NalHeader, int i, @Nullable H265ProfileTierLevel h265ProfileTierLevel, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f, int i10, int i11, int i12, int i13) {
            this.nalHeader = h265NalHeader;
            this.maxSubLayersMinus1 = i;
            this.profileTierLevel = h265ProfileTierLevel;
            this.chromaFormatIdc = i2;
            this.bitDepthLumaMinus8 = i3;
            this.bitDepthChromaMinus8 = i4;
            this.seqParameterSetId = i5;
            this.width = i6;
            this.height = i7;
            this.pixelWidthHeightRatio = f;
            this.maxNumReorderPics = i10;
            this.colorSpace = i11;
            this.colorRange = i12;
            this.colorTransfer = i13;
            this.decodedWidth = i8;
            this.decodedHeight = i9;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class H265VideoSignalInfo {
        public final int colorRange;
        public final int colorSpace;
        public final int colorTransfer;

        public H265VideoSignalInfo(int i, int i2, int i3) {
            this.colorSpace = i;
            this.colorRange = i2;
            this.colorTransfer = i3;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class H265VideoSignalInfosAndIndices {
        public final int[] indices;
        public final ImmutableList<H265VideoSignalInfo> videoSignalInfos;

        public H265VideoSignalInfosAndIndices(List<H265VideoSignalInfo> list, int[] iArr) {
            this.videoSignalInfos = ImmutableList.copyOf((Collection) list);
            this.indices = iArr;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class H265VpsData {
        public final ImmutableList<H265LayerInfo> layerInfos;
        public final H265NalHeader nalHeader;
        public final H265ProfileTierLevelsAndIndices profileTierLevelsAndIndices;

        @Nullable
        public final H265RepFormatsAndIndices repFormatsAndIndices;

        @Nullable
        public final H265VideoSignalInfosAndIndices videoSignalInfosAndIndices;

        public H265VpsData(H265NalHeader h265NalHeader, @Nullable List<H265LayerInfo> list, H265ProfileTierLevelsAndIndices h265ProfileTierLevelsAndIndices, @Nullable H265RepFormatsAndIndices h265RepFormatsAndIndices, @Nullable H265VideoSignalInfosAndIndices h265VideoSignalInfosAndIndices) {
            this.nalHeader = h265NalHeader;
            this.layerInfos = list != null ? ImmutableList.copyOf((Collection) list) : ImmutableList.of();
            this.profileTierLevelsAndIndices = h265ProfileTierLevelsAndIndices;
            this.repFormatsAndIndices = h265RepFormatsAndIndices;
            this.videoSignalInfosAndIndices = h265VideoSignalInfosAndIndices;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class PpsData {
        public final boolean bottomFieldPicOrderInFramePresentFlag;
        public final int picParameterSetId;
        public final int seqParameterSetId;

        public PpsData(int i, int i2, boolean z) {
            this.picParameterSetId = i;
            this.seqParameterSetId = i2;
            this.bottomFieldPicOrderInFramePresentFlag = z;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class SpsData {
        public final int bitDepthChromaMinus8;
        public final int bitDepthLumaMinus8;
        public final int colorRange;
        public final int colorSpace;
        public final int colorTransfer;
        public final int constraintsFlagsAndReservedZero2Bits;
        public final boolean deltaPicOrderAlwaysZeroFlag;
        public final boolean frameMbsOnlyFlag;
        public final int frameNumLength;
        public final int height;
        public final int levelIdc;
        public final int maxNumRefFrames;
        public final int maxNumReorderFrames;
        public final int picOrderCntLsbLength;
        public final int picOrderCountType;
        public final float pixelWidthHeightRatio;
        public final int profileIdc;
        public final boolean separateColorPlaneFlag;
        public final int seqParameterSetId;
        public final int width;

        public SpsData(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, boolean z, boolean z2, int i10, int i11, int i12, boolean z3, int i13, int i14, int i15, int i16) {
            this.profileIdc = i;
            this.constraintsFlagsAndReservedZero2Bits = i2;
            this.levelIdc = i3;
            this.seqParameterSetId = i4;
            this.maxNumRefFrames = i5;
            this.width = i6;
            this.height = i7;
            this.pixelWidthHeightRatio = f;
            this.bitDepthLumaMinus8 = i8;
            this.bitDepthChromaMinus8 = i9;
            this.separateColorPlaneFlag = z;
            this.frameMbsOnlyFlag = z2;
            this.frameNumLength = i10;
            this.picOrderCountType = i11;
            this.picOrderCntLsbLength = i12;
            this.deltaPicOrderAlwaysZeroFlag = z3;
            this.colorSpace = i13;
            this.colorRange = i14;
            this.colorTransfer = i15;
            this.maxNumReorderFrames = i16;
        }
    }

    private NalUnitUtil() {
    }

    private static int applyConformanceWindowToHeight(int i, int i2, int i3, int i4) {
        return i - ((i2 == 1 ? 2 : 1) * (i3 + i4));
    }

    private static int applyConformanceWindowToWidth(int i, int i2, int i3, int i4) {
        int i5 = 2;
        if (i2 != 1 && i2 != 2) {
            i5 = 1;
        }
        return i - (i5 * (i3 + i4));
    }

    public static void clearPrefixFlags(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    @Nullable
    private static String createCodecStringFromH265SpsPalyoad(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        parsableNalUnitBitArray.skipBits(4);
        int bits = parsableNalUnitBitArray.readBits(3);
        parsableNalUnitBitArray.skipBit();
        H265ProfileTierLevel h265ProfileTierLevel = parseH265ProfileTierLevel(parsableNalUnitBitArray, true, bits, null);
        return CodecSpecificDataUtil.buildHevcCodecString(h265ProfileTierLevel.generalProfileSpace, h265ProfileTierLevel.generalTierFlag, h265ProfileTierLevel.generalProfileIdc, h265ProfileTierLevel.generalProfileCompatibilityFlags, h265ProfileTierLevel.constraintBytes, h265ProfileTierLevel.generalLevelIdc);
    }

    public static void discardToSps(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            if (i3 >= iPosition) {
                byteBuffer.clear();
                return;
            }
            int i4 = byteBuffer.get(i) & UByte.MAX_VALUE;
            if (i2 == 3) {
                if (i4 == 1 && (byteBuffer.get(i3) & TELogUtils.DEBUG_LEVEL_V) == 7) {
                    ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                    byteBufferDuplicate.position(i - 3);
                    byteBufferDuplicate.limit(iPosition);
                    byteBuffer.position(0);
                    byteBuffer.put(byteBufferDuplicate);
                    return;
                }
            } else if (i4 == 0) {
                i2++;
            }
            if (i4 != 0) {
                i2 = 0;
            }
            i = i3;
        }
    }

    public static int findNalUnit(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        Assertions.checkState(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            clearPrefixFlags(zArr);
            return i - 3;
        }
        if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            clearPrefixFlags(zArr);
            return i - 2;
        }
        if (i3 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
            clearPrefixFlags(zArr);
            return i - 1;
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            byte b = bArr[i5];
            if ((b & 254) == 0) {
                int i6 = i5 - 2;
                if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b == 1) {
                    clearPrefixFlags(zArr);
                    return i6;
                }
                i5 -= 2;
            }
            i5 += 3;
        }
        zArr[0] = i3 <= 2 ? !(i3 != 2 ? !(zArr[1] && bArr[i4] == 1) : !(zArr[2] && bArr[i2 + (-2)] == 0 && bArr[i4] == 1)) : bArr[i2 + (-3)] == 0 && bArr[i2 + (-2)] == 0 && bArr[i4] == 1;
        zArr[1] = i3 <= 1 ? zArr[2] && bArr[i4] == 0 : bArr[i2 + (-2)] == 0 && bArr[i4] == 0;
        zArr[2] = bArr[i4] == 0;
        return i2;
    }

    private static ImmutableList<Integer> findNalUnitPositions(byte[] bArr) {
        boolean[] zArr = new boolean[3];
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        int i = 0;
        while (i < bArr.length) {
            int iFindNalUnit = findNalUnit(bArr, i, bArr.length, zArr);
            if (iFindNalUnit != bArr.length) {
                aVarBuilder.a(Integer.valueOf(iFindNalUnit));
            }
            i = iFindNalUnit + 3;
        }
        return aVarBuilder.e();
    }

    private static int findNextUnescapeIndex(byte[] bArr, int i, int i2) {
        while (i < i2 - 2) {
            if (bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 3) {
                return i;
            }
            i++;
        }
        return i2;
    }

    @Nullable
    public static String getH265BaseLayerCodecsString(List<byte[]> list) {
        for (int i = 0; i < list.size(); i++) {
            byte[] bArr = list.get(i);
            int length = bArr.length;
            if (length > 3) {
                ImmutableList<Integer> immutableListFindNalUnitPositions = findNalUnitPositions(bArr);
                for (int i2 = 0; i2 < immutableListFindNalUnitPositions.size(); i2++) {
                    if (immutableListFindNalUnitPositions.get(i2).intValue() + 3 < length) {
                        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, immutableListFindNalUnitPositions.get(i2).intValue() + 3, length);
                        H265NalHeader h265NalHeader = parseH265NalHeader(parsableNalUnitBitArray);
                        if (h265NalHeader.nalUnitType == 33 && h265NalHeader.layerId == 0) {
                            return createCodecStringFromH265SpsPalyoad(parsableNalUnitBitArray);
                        }
                    }
                }
            }
        }
        return null;
    }

    public static int getH265NalUnitType(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    public static int getNalUnitType(byte[] bArr, int i) {
        return bArr[i + 3] & TELogUtils.DEBUG_LEVEL_V;
    }

    public static boolean isDependedOn(byte[] bArr, int i, int i2, Format format) {
        if (Objects.equals(format.sampleMimeType, "video/avc")) {
            return isH264NalUnitDependedOn(bArr[i]);
        }
        if (Objects.equals(format.sampleMimeType, "video/hevc")) {
            return isH265NalUnitDependedOn(bArr, i, i2, format);
        }
        return true;
    }

    public static boolean isH264NalUnitDependedOn(byte b) {
        if (((b & 96) >> 5) != 0) {
            return true;
        }
        int i = b & TELogUtils.DEBUG_LEVEL_V;
        return (i == 1 || i == 9 || i == 14) ? false : true;
    }

    private static boolean isH265NalUnitDependedOn(byte[] bArr, int i, int i2, Format format) {
        H265NalHeader h265NalHeader = parseH265NalHeader(new ParsableNalUnitBitArray(bArr, i, i2 + i));
        int i3 = h265NalHeader.nalUnitType;
        if (i3 == 35) {
            return false;
        }
        return ((i3 <= 14 && i3 % 2 == 0) && h265NalHeader.temporalId == format.maxSubLayers - 1) ? false : true;
    }

    @Deprecated
    public static boolean isNalUnitSei(@Nullable String str, byte b) {
        if ("video/avc".equals(str) && (b & TELogUtils.DEBUG_LEVEL_V) == 6) {
            return true;
        }
        return "video/hevc".equals(str) && ((b & 126) >> 1) == 39;
    }

    public static int numberOfBytesInNalUnitHeader(Format format) {
        if (Objects.equals(format.sampleMimeType, "video/avc")) {
            return 1;
        }
        return (Objects.equals(format.sampleMimeType, "video/hevc") || MimeTypes.containsCodecsCorrespondingToMimeType(format.codecs, "video/hevc")) ? 2 : 0;
    }

    private static H265NalHeader parseH265NalHeader(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        parsableNalUnitBitArray.skipBit();
        return new H265NalHeader(parsableNalUnitBitArray.readBits(6), parsableNalUnitBitArray.readBits(6), parsableNalUnitBitArray.readBits(3) - 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static H265ProfileTierLevel parseH265ProfileTierLevel(ParsableNalUnitBitArray parsableNalUnitBitArray, boolean z, int i, @Nullable H265ProfileTierLevel h265ProfileTierLevel) {
        int[] iArr;
        int i2;
        boolean z2;
        int i3;
        int i4;
        boolean bit;
        int bits;
        int i5;
        int[] iArr2 = new int[6];
        if (z) {
            int bits2 = parsableNalUnitBitArray.readBits(2);
            bit = parsableNalUnitBitArray.readBit();
            bits = parsableNalUnitBitArray.readBits(5);
            i5 = 0;
            for (int i6 = 0; i6 < 32; i6++) {
                if (parsableNalUnitBitArray.readBit()) {
                    i5 |= 1 << i6;
                }
            }
            for (int i7 = 0; i7 < 6; i7++) {
                iArr2[i7] = parsableNalUnitBitArray.readBits(8);
            }
            i2 = bits2;
        } else {
            if (h265ProfileTierLevel == null) {
                iArr = iArr2;
                i2 = 0;
                z2 = false;
                i3 = 0;
                i4 = 0;
                int bits3 = parsableNalUnitBitArray.readBits(8);
                int i8 = 0;
                for (int i9 = 0; i9 < i; i9++) {
                    if (parsableNalUnitBitArray.readBit()) {
                        i8 += 88;
                    }
                    if (parsableNalUnitBitArray.readBit()) {
                        i8 += 8;
                    }
                }
                parsableNalUnitBitArray.skipBits(i8);
                if (i > 0) {
                    parsableNalUnitBitArray.skipBits((8 - i) * 2);
                }
                return new H265ProfileTierLevel(i2, z2, i3, i4, iArr, bits3);
            }
            int i10 = h265ProfileTierLevel.generalProfileSpace;
            bit = h265ProfileTierLevel.generalTierFlag;
            bits = h265ProfileTierLevel.generalProfileIdc;
            i5 = h265ProfileTierLevel.generalProfileCompatibilityFlags;
            iArr2 = h265ProfileTierLevel.constraintBytes;
            i2 = i10;
        }
        iArr = iArr2;
        z2 = bit;
        i3 = bits;
        i4 = i5;
        int bits32 = parsableNalUnitBitArray.readBits(8);
        int i82 = 0;
        while (i9 < i) {
        }
        parsableNalUnitBitArray.skipBits(i82);
        if (i > 0) {
        }
        return new H265ProfileTierLevel(i2, z2, i3, i4, iArr, bits32);
    }

    private static H265RepFormat parseH265RepFormat(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int i;
        int i2;
        int bits;
        int bits2 = parsableNalUnitBitArray.readBits(16);
        int bits3 = parsableNalUnitBitArray.readBits(16);
        if (parsableNalUnitBitArray.readBit()) {
            int bits4 = parsableNalUnitBitArray.readBits(2);
            if (bits4 == 3) {
                parsableNalUnitBitArray.skipBit();
            }
            int bits5 = parsableNalUnitBitArray.readBits(4);
            bits = parsableNalUnitBitArray.readBits(4);
            i2 = bits5;
            i = bits4;
        } else {
            i = 0;
            i2 = 0;
            bits = 0;
        }
        if (parsableNalUnitBitArray.readBit()) {
            int unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int unsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int unsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int unsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            bits2 = applyConformanceWindowToWidth(bits2, i, unsignedExpGolombCodedInt, unsignedExpGolombCodedInt2);
            bits3 = applyConformanceWindowToHeight(bits3, i, unsignedExpGolombCodedInt3, unsignedExpGolombCodedInt4);
        }
        return new H265RepFormat(i, i2, bits, bits2, bits3);
    }

    private static H265RepFormatsAndIndices parseH265RepFormatsAndIndices(ParsableNalUnitBitArray parsableNalUnitBitArray, int i) {
        int unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        ImmutableList.a aVarBuilderWithExpectedSize = ImmutableList.builderWithExpectedSize(unsignedExpGolombCodedInt);
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < unsignedExpGolombCodedInt; i2++) {
            aVarBuilderWithExpectedSize.a(parseH265RepFormat(parsableNalUnitBitArray));
        }
        if (unsignedExpGolombCodedInt <= 1 || !parsableNalUnitBitArray.readBit()) {
            for (int i3 = 1; i3 < i; i3++) {
                iArr[i3] = Math.min(i3, unsignedExpGolombCodedInt - 1);
            }
        } else {
            int iD = ue1.d(unsignedExpGolombCodedInt, RoundingMode.CEILING);
            for (int i4 = 1; i4 < i; i4++) {
                iArr[i4] = parsableNalUnitBitArray.readBits(iD);
            }
        }
        return new H265RepFormatsAndIndices(aVarBuilderWithExpectedSize.e(), iArr);
    }

    @Nullable
    public static H265Sei3dRefDisplayInfoData parseH265Sei3dRefDisplayInfo(byte[] bArr, int i, int i2) {
        byte b;
        int i3 = i + 2;
        int i4 = i2 - 1;
        while (true) {
            b = bArr[i4];
            if (b != 0 || i4 <= i3) {
                break;
            }
            i4--;
        }
        if (b != 0 && i4 > i3) {
            ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i3, i4 + 1);
            while (parsableNalUnitBitArray.canReadBits(16)) {
                int bits = parsableNalUnitBitArray.readBits(8);
                int i5 = 0;
                while (bits == 255) {
                    i5 += 255;
                    bits = parsableNalUnitBitArray.readBits(8);
                }
                int i6 = i5 + bits;
                int bits2 = parsableNalUnitBitArray.readBits(8);
                int i7 = 0;
                while (bits2 == 255) {
                    i7 += 255;
                    bits2 = parsableNalUnitBitArray.readBits(8);
                }
                int i8 = i7 + bits2;
                if (i8 == 0 || !parsableNalUnitBitArray.canReadBits(i8)) {
                    break;
                }
                if (i6 == 176) {
                    int unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    boolean bit = parsableNalUnitBitArray.readBit();
                    int unsignedExpGolombCodedInt2 = bit ? parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() : 0;
                    int unsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    int unsignedExpGolombCodedInt4 = -1;
                    int unsignedExpGolombCodedInt5 = -1;
                    int bits3 = -1;
                    int bits4 = -1;
                    int i9 = -1;
                    int bits5 = -1;
                    for (int i10 = 0; i10 <= unsignedExpGolombCodedInt3; i10++) {
                        unsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        unsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        bits3 = parsableNalUnitBitArray.readBits(6);
                        if (bits3 == 63) {
                            return null;
                        }
                        bits4 = parsableNalUnitBitArray.readBits(bits3 == 0 ? Math.max(0, unsignedExpGolombCodedInt - 30) : Math.max(0, (bits3 + unsignedExpGolombCodedInt) - 31));
                        if (bit) {
                            int bits6 = parsableNalUnitBitArray.readBits(6);
                            if (bits6 == 63) {
                                return null;
                            }
                            bits5 = parsableNalUnitBitArray.readBits(bits6 == 0 ? Math.max(0, unsignedExpGolombCodedInt2 - 30) : Math.max(0, (bits6 + unsignedExpGolombCodedInt2) - 31));
                            i9 = bits6;
                        }
                        if (parsableNalUnitBitArray.readBit()) {
                            parsableNalUnitBitArray.skipBits(10);
                        }
                    }
                    return new H265Sei3dRefDisplayInfoData(unsignedExpGolombCodedInt, unsignedExpGolombCodedInt2, unsignedExpGolombCodedInt3 + 1, unsignedExpGolombCodedInt4, unsignedExpGolombCodedInt5, bits3, bits4, i9, bits5);
                }
                parsableNalUnitBitArray.skipBits(i8 * 8);
            }
        }
        return null;
    }

    public static H265SpsData parseH265SpsNalUnit(byte[] bArr, int i, int i2, @Nullable H265VpsData h265VpsData) {
        return parseH265SpsNalUnitPayload(bArr, i + 2, i2, parseH265NalHeader(new ParsableNalUnitBitArray(bArr, i, i2)), h265VpsData);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static H265SpsData parseH265SpsNalUnitPayload(byte[] bArr, int i, int i2, H265NalHeader h265NalHeader, @Nullable H265VpsData h265VpsData) {
        int iApplyConformanceWindowToWidth;
        int iApplyConformanceWindowToHeight;
        int unsignedExpGolombCodedInt;
        int i3;
        int i4;
        int i5;
        int unsignedExpGolombCodedInt2;
        int i6;
        int i7;
        int i8;
        int i9;
        float f;
        int i10;
        int i11;
        int i12;
        int iIsoColorPrimariesToColorSpace;
        int iIsoTransferCharacteristicsToColorTransfer;
        H265VideoSignalInfosAndIndices h265VideoSignalInfosAndIndices;
        int i13;
        H265RepFormatsAndIndices h265RepFormatsAndIndices;
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
        parsableNalUnitBitArray.skipBits(4);
        int bits = parsableNalUnitBitArray.readBits(3);
        boolean z = h265NalHeader.layerId != 0 && bits == 7;
        int i14 = (h265VpsData == null || h265VpsData.layerInfos.isEmpty()) ? 0 : h265VpsData.layerInfos.get(Math.min(h265NalHeader.layerId, h265VpsData.layerInfos.size() - 1)).layerIdInVps;
        H265ProfileTierLevel h265ProfileTierLevel = null;
        if (!z) {
            parsableNalUnitBitArray.skipBit();
            h265ProfileTierLevel = parseH265ProfileTierLevel(parsableNalUnitBitArray, true, bits, null);
        } else if (h265VpsData != null) {
            H265ProfileTierLevelsAndIndices h265ProfileTierLevelsAndIndices = h265VpsData.profileTierLevelsAndIndices;
            int i15 = h265ProfileTierLevelsAndIndices.indices[i14];
            if (h265ProfileTierLevelsAndIndices.profileTierLevels.size() > i15) {
                h265ProfileTierLevel = h265VpsData.profileTierLevelsAndIndices.profileTierLevels.get(i15);
            }
        }
        int unsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (z) {
            int bits2 = parsableNalUnitBitArray.readBit() ? parsableNalUnitBitArray.readBits(8) : -1;
            if (h265VpsData == null || (h265RepFormatsAndIndices = h265VpsData.repFormatsAndIndices) == null) {
                iApplyConformanceWindowToHeight = 0;
                i3 = 0;
                unsignedExpGolombCodedInt = 0;
                i5 = 0;
                i4 = 0;
                unsignedExpGolombCodedInt2 = 0;
                i6 = 0;
            } else {
                if (bits2 == -1) {
                    bits2 = h265RepFormatsAndIndices.indices[i14];
                }
                if (bits2 != -1 && h265RepFormatsAndIndices.repFormats.size() > bits2) {
                    H265RepFormat h265RepFormat = h265VpsData.repFormatsAndIndices.repFormats.get(bits2);
                    int i16 = h265RepFormat.chromaFormatIdc;
                    i5 = h265RepFormat.width;
                    int i17 = h265RepFormat.height;
                    unsignedExpGolombCodedInt = h265RepFormat.bitDepthLumaMinus8;
                    unsignedExpGolombCodedInt2 = h265RepFormat.bitDepthChromaMinus8;
                    iApplyConformanceWindowToHeight = i17;
                    i3 = i16;
                    i4 = i5;
                    i6 = iApplyConformanceWindowToHeight;
                }
            }
        } else {
            int unsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            if (unsignedExpGolombCodedInt4 == 3) {
                parsableNalUnitBitArray.skipBit();
            }
            int unsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int unsignedExpGolombCodedInt6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            if (parsableNalUnitBitArray.readBit()) {
                int unsignedExpGolombCodedInt7 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int unsignedExpGolombCodedInt8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int unsignedExpGolombCodedInt9 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int unsignedExpGolombCodedInt10 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                iApplyConformanceWindowToWidth = applyConformanceWindowToWidth(unsignedExpGolombCodedInt5, unsignedExpGolombCodedInt4, unsignedExpGolombCodedInt7, unsignedExpGolombCodedInt8);
                iApplyConformanceWindowToHeight = applyConformanceWindowToHeight(unsignedExpGolombCodedInt6, unsignedExpGolombCodedInt4, unsignedExpGolombCodedInt9, unsignedExpGolombCodedInt10);
            } else {
                iApplyConformanceWindowToWidth = unsignedExpGolombCodedInt5;
                iApplyConformanceWindowToHeight = unsignedExpGolombCodedInt6;
            }
            unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            i3 = unsignedExpGolombCodedInt4;
            i4 = unsignedExpGolombCodedInt5;
            i5 = iApplyConformanceWindowToWidth;
            unsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            i6 = unsignedExpGolombCodedInt6;
        }
        int unsignedExpGolombCodedInt11 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (z) {
            i7 = i6;
            i8 = -1;
        } else {
            int i18 = parsableNalUnitBitArray.readBit() ? 0 : bits;
            int iMax = -1;
            while (i18 <= bits) {
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                iMax = Math.max(parsableNalUnitBitArray.readUnsignedExpGolombCodedInt(), iMax);
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                i18++;
                i6 = i6;
            }
            i7 = i6;
            i8 = iMax;
        }
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (parsableNalUnitBitArray.readBit()) {
            if (z ? parsableNalUnitBitArray.readBit() : false) {
                parsableNalUnitBitArray.skipBits(6);
            } else if (parsableNalUnitBitArray.readBit()) {
                skipH265ScalingList(parsableNalUnitBitArray);
            }
        }
        int i19 = 2;
        parsableNalUnitBitArray.skipBits(2);
        if (parsableNalUnitBitArray.readBit()) {
            parsableNalUnitBitArray.skipBits(8);
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
        }
        skipH265ShortTermReferencePictureSets(parsableNalUnitBitArray);
        if (parsableNalUnitBitArray.readBit()) {
            int unsignedExpGolombCodedInt12 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int i20 = 0;
            while (i20 < unsignedExpGolombCodedInt12) {
                parsableNalUnitBitArray.skipBits(unsignedExpGolombCodedInt11 + 4 + 1);
                i20++;
                i19 = 2;
            }
        }
        parsableNalUnitBitArray.skipBits(i19);
        if (!parsableNalUnitBitArray.readBit()) {
            i9 = iApplyConformanceWindowToHeight;
            f = 1.0f;
            i10 = -1;
            i11 = -1;
            i12 = -1;
        } else if (parsableNalUnitBitArray.readBit()) {
            int bits3 = parsableNalUnitBitArray.readBits(8);
            if (bits3 == 255) {
                int bits4 = parsableNalUnitBitArray.readBits(16);
                int bits5 = parsableNalUnitBitArray.readBits(16);
                if (bits4 != 0 && bits5 != 0) {
                    f = bits4 / bits5;
                }
                if (parsableNalUnitBitArray.readBit()) {
                }
                if (!parsableNalUnitBitArray.readBit()) {
                }
                if (parsableNalUnitBitArray.readBit()) {
                }
                parsableNalUnitBitArray.skipBit();
                if (parsableNalUnitBitArray.readBit()) {
                }
                i10 = iIsoColorPrimariesToColorSpace;
                i11 = iIsoTransferCharacteristicsToColorTransfer;
                i9 = iApplyConformanceWindowToHeight;
            } else {
                float[] fArr = ASPECT_RATIO_IDC_VALUES;
                if (bits3 < fArr.length) {
                    f = fArr[bits3];
                    if (parsableNalUnitBitArray.readBit()) {
                    }
                    if (!parsableNalUnitBitArray.readBit()) {
                    }
                    if (parsableNalUnitBitArray.readBit()) {
                    }
                    parsableNalUnitBitArray.skipBit();
                    if (parsableNalUnitBitArray.readBit()) {
                    }
                    i10 = iIsoColorPrimariesToColorSpace;
                    i11 = iIsoTransferCharacteristicsToColorTransfer;
                    i9 = iApplyConformanceWindowToHeight;
                } else {
                    Log.w(TAG, "Unexpected aspect_ratio_idc value: " + bits3);
                    f = 1.0f;
                    if (parsableNalUnitBitArray.readBit()) {
                    }
                    if (!parsableNalUnitBitArray.readBit()) {
                    }
                    if (parsableNalUnitBitArray.readBit()) {
                    }
                    parsableNalUnitBitArray.skipBit();
                    if (parsableNalUnitBitArray.readBit()) {
                    }
                    i10 = iIsoColorPrimariesToColorSpace;
                    i11 = iIsoTransferCharacteristicsToColorTransfer;
                    i9 = iApplyConformanceWindowToHeight;
                }
            }
        } else {
            f = 1.0f;
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.skipBit();
            }
            if (!parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.skipBits(3);
                i12 = parsableNalUnitBitArray.readBit() ? 1 : 2;
                if (parsableNalUnitBitArray.readBit()) {
                    int bits6 = parsableNalUnitBitArray.readBits(8);
                    int bits7 = parsableNalUnitBitArray.readBits(8);
                    parsableNalUnitBitArray.skipBits(8);
                    iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(bits6);
                    iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(bits7);
                } else {
                    iIsoColorPrimariesToColorSpace = -1;
                    iIsoTransferCharacteristicsToColorTransfer = -1;
                }
            } else if (h265VpsData == null || (h265VideoSignalInfosAndIndices = h265VpsData.videoSignalInfosAndIndices) == null || h265VideoSignalInfosAndIndices.videoSignalInfos.size() <= (i13 = h265VideoSignalInfosAndIndices.indices[i14])) {
                iIsoColorPrimariesToColorSpace = -1;
                iIsoTransferCharacteristicsToColorTransfer = -1;
                i12 = -1;
            } else {
                H265VideoSignalInfo h265VideoSignalInfo = h265VpsData.videoSignalInfosAndIndices.videoSignalInfos.get(i13);
                int i21 = h265VideoSignalInfo.colorSpace;
                i12 = h265VideoSignalInfo.colorRange;
                iIsoTransferCharacteristicsToColorTransfer = h265VideoSignalInfo.colorTransfer;
                iIsoColorPrimariesToColorSpace = i21;
            }
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            }
            parsableNalUnitBitArray.skipBit();
            if (parsableNalUnitBitArray.readBit()) {
                iApplyConformanceWindowToHeight *= 2;
            }
            i10 = iIsoColorPrimariesToColorSpace;
            i11 = iIsoTransferCharacteristicsToColorTransfer;
            i9 = iApplyConformanceWindowToHeight;
        }
        return new H265SpsData(h265NalHeader, bits, h265ProfileTierLevel, i3, unsignedExpGolombCodedInt, unsignedExpGolombCodedInt2, unsignedExpGolombCodedInt3, i5, i9, i4, i7, f, i8, i10, i12, i11);
    }

    private static H265VideoSignalInfo parseH265VideoSignalInfo(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        parsableNalUnitBitArray.skipBits(3);
        int i = parsableNalUnitBitArray.readBit() ? 1 : 2;
        int iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(parsableNalUnitBitArray.readBits(8));
        int iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(parsableNalUnitBitArray.readBits(8));
        parsableNalUnitBitArray.skipBits(8);
        return new H265VideoSignalInfo(iIsoColorPrimariesToColorSpace, i, iIsoTransferCharacteristicsToColorTransfer);
    }

    private static H265VideoSignalInfosAndIndices parseH265VideoSignalInfosAndIndices(ParsableNalUnitBitArray parsableNalUnitBitArray, int i, int i2, int[] iArr) {
        if (!parsableNalUnitBitArray.readBit() ? parsableNalUnitBitArray.readBit() : true) {
            parsableNalUnitBitArray.skipBit();
        }
        boolean bit = parsableNalUnitBitArray.readBit();
        boolean bit2 = parsableNalUnitBitArray.readBit();
        if (bit || bit2) {
            for (int i3 = 0; i3 < i2; i3++) {
                for (int i4 = 0; i4 < iArr[i3]; i4++) {
                    boolean bit3 = bit ? parsableNalUnitBitArray.readBit() : false;
                    boolean bit4 = bit2 ? parsableNalUnitBitArray.readBit() : false;
                    if (bit3) {
                        parsableNalUnitBitArray.skipBits(32);
                    }
                    if (bit4) {
                        parsableNalUnitBitArray.skipBits(18);
                    }
                }
            }
        }
        boolean bit5 = parsableNalUnitBitArray.readBit();
        int bits = bit5 ? parsableNalUnitBitArray.readBits(4) + 1 : i;
        ImmutableList.a aVarBuilderWithExpectedSize = ImmutableList.builderWithExpectedSize(bits);
        int[] iArr2 = new int[i];
        for (int i5 = 0; i5 < bits; i5++) {
            aVarBuilderWithExpectedSize.a(parseH265VideoSignalInfo(parsableNalUnitBitArray));
        }
        if (bit5 && bits > 1) {
            for (int i6 = 0; i6 < i; i6++) {
                iArr2[i6] = parsableNalUnitBitArray.readBits(4);
            }
        }
        return new H265VideoSignalInfosAndIndices(aVarBuilderWithExpectedSize.e(), iArr2);
    }

    public static H265VpsData parseH265VpsNalUnit(byte[] bArr, int i, int i2) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
        return parseH265VpsNalUnitPayload(parsableNalUnitBitArray, parseH265NalHeader(parsableNalUnitBitArray));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0518  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x052d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static H265VpsData parseH265VpsNalUnitPayload(ParsableNalUnitBitArray parsableNalUnitBitArray, H265NalHeader h265NalHeader) {
        H265ProfileTierLevel h265ProfileTierLevel;
        H265ProfileTierLevel h265ProfileTierLevel2;
        int i;
        int i2;
        H265VideoSignalInfosAndIndices h265VideoSignalInfosAndIndices;
        int i3;
        int i4;
        boolean[][] zArr;
        H265ProfileTierLevelsAndIndices h265ProfileTierLevelsAndIndices;
        int i5;
        int[] iArr;
        boolean z;
        int[] iArr2;
        int[] iArr3;
        parsableNalUnitBitArray.skipBits(4);
        boolean bit = parsableNalUnitBitArray.readBit();
        boolean bit2 = parsableNalUnitBitArray.readBit();
        int bits = parsableNalUnitBitArray.readBits(6) + 1;
        int bits2 = parsableNalUnitBitArray.readBits(3);
        parsableNalUnitBitArray.skipBits(17);
        H265ProfileTierLevel h265ProfileTierLevel3 = parseH265ProfileTierLevel(parsableNalUnitBitArray, true, bits2, null);
        for (int i6 = parsableNalUnitBitArray.readBit() ? 0 : bits2; i6 <= bits2; i6++) {
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        }
        int bits3 = parsableNalUnitBitArray.readBits(6);
        int unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        H265ProfileTierLevelsAndIndices h265ProfileTierLevelsAndIndices2 = new H265ProfileTierLevelsAndIndices(ImmutableList.of(h265ProfileTierLevel3), new int[1]);
        boolean z2 = bits >= 2 && unsignedExpGolombCodedInt >= 2;
        boolean z3 = bit && bit2;
        int i7 = bits3 + 1;
        boolean z4 = i7 >= bits;
        if (!z2 || !z3 || !z4) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices2, null, null);
        }
        int[][] iArr4 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, unsignedExpGolombCodedInt, i7);
        int[] iArr5 = new int[unsignedExpGolombCodedInt];
        int[] iArr6 = new int[unsignedExpGolombCodedInt];
        iArr4[0][0] = 0;
        iArr5[0] = 1;
        iArr6[0] = 0;
        for (int i8 = 1; i8 < unsignedExpGolombCodedInt; i8++) {
            int i9 = 0;
            for (int i10 = 0; i10 <= bits3; i10++) {
                if (parsableNalUnitBitArray.readBit()) {
                    iArr4[i8][i9] = i10;
                    iArr6[i8] = i10;
                    i9++;
                }
                iArr5[i8] = i9;
            }
        }
        if (parsableNalUnitBitArray.readBit()) {
            parsableNalUnitBitArray.skipBits(64);
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            }
            int unsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int i11 = 0;
            while (i11 < unsignedExpGolombCodedInt2) {
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                skipH265HrdParameters(parsableNalUnitBitArray, i11 == 0 || parsableNalUnitBitArray.readBit(), bits2);
                i11++;
            }
        }
        if (!parsableNalUnitBitArray.readBit()) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices2, null, null);
        }
        H265ProfileTierLevelsAndIndices h265ProfileTierLevelsAndIndices3 = h265ProfileTierLevelsAndIndices2;
        parsableNalUnitBitArray.byteAlign();
        H265ProfileTierLevel h265ProfileTierLevel4 = parseH265ProfileTierLevel(parsableNalUnitBitArray, false, bits2, h265ProfileTierLevel3);
        boolean bit3 = parsableNalUnitBitArray.readBit();
        boolean[] zArr2 = new boolean[16];
        int i12 = 0;
        for (int i13 = 0; i13 < 16; i13++) {
            boolean bit4 = parsableNalUnitBitArray.readBit();
            zArr2[i13] = bit4;
            if (bit4) {
                i12++;
            }
        }
        if (i12 == 0 || !zArr2[1]) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices3, null, null);
        }
        int[] iArr7 = new int[i12];
        int i14 = 0;
        while (true) {
            h265ProfileTierLevel = h265ProfileTierLevel4;
            if (i14 >= i12 - (bit3 ? 1 : 0)) {
                break;
            }
            iArr7[i14] = parsableNalUnitBitArray.readBits(3);
            i14++;
            h265ProfileTierLevel4 = h265ProfileTierLevel;
        }
        int[] iArr8 = new int[i12 + 1];
        if (bit3) {
            int i15 = 1;
            while (i15 < i12) {
                H265ProfileTierLevel h265ProfileTierLevel5 = h265ProfileTierLevel3;
                for (int i16 = 0; i16 < i15; i16++) {
                    iArr8[i15] = iArr8[i15] + iArr7[i16] + 1;
                }
                i15++;
                h265ProfileTierLevel3 = h265ProfileTierLevel5;
            }
            h265ProfileTierLevel2 = h265ProfileTierLevel3;
            iArr8[i12] = 6;
        } else {
            h265ProfileTierLevel2 = h265ProfileTierLevel3;
        }
        int[][] iArr9 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, bits, i12);
        int[] iArr10 = new int[bits];
        iArr10[0] = 0;
        boolean bit5 = parsableNalUnitBitArray.readBit();
        int i17 = 1;
        while (i17 < bits) {
            if (bit5) {
                iArr2 = iArr5;
                iArr10[i17] = parsableNalUnitBitArray.readBits(6);
            } else {
                iArr2 = iArr5;
                iArr10[i17] = i17;
            }
            if (bit3) {
                iArr3 = iArr7;
                for (int i18 = 0; i18 < i12; i18++) {
                    iArr9[i17][i18] = (iArr10[i17] & ((1 << iArr8[r31]) - 1)) >> iArr8[i18];
                }
            } else {
                int i19 = 0;
                while (i19 < i12) {
                    iArr9[i17][i19] = parsableNalUnitBitArray.readBits(iArr7[i19] + 1);
                    i19++;
                    iArr7 = iArr7;
                }
                iArr3 = iArr7;
            }
            i17++;
            iArr5 = iArr2;
            iArr7 = iArr3;
        }
        int[] iArr11 = iArr5;
        int[] iArr12 = new int[i7];
        int i20 = 1;
        for (int i21 = 0; i21 < bits; i21++) {
            iArr12[iArr10[i21]] = -1;
            int i22 = 0;
            for (int i23 = 0; i23 < 16; i23++) {
                if (zArr2[i23]) {
                    if (i23 == 1) {
                        iArr12[iArr10[i21]] = iArr9[i21][i22];
                    }
                    i22++;
                }
            }
            if (i21 > 0) {
                int i24 = 0;
                while (true) {
                    if (i24 >= i21) {
                        z = true;
                        break;
                    }
                    if (iArr12[iArr10[i21]] == iArr12[iArr10[i24]]) {
                        z = false;
                        break;
                    }
                    i24++;
                }
                if (z) {
                    i20++;
                }
            }
        }
        int bits4 = parsableNalUnitBitArray.readBits(4);
        if (i20 < 2 || bits4 == 0) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices3, null, null);
        }
        int[] iArr13 = new int[i20];
        for (int i25 = 0; i25 < i20; i25++) {
            iArr13[i25] = parsableNalUnitBitArray.readBits(bits4);
        }
        int[] iArr14 = new int[i7];
        for (int i26 = 0; i26 < bits; i26++) {
            iArr14[Math.min(iArr10[i26], bits3)] = i26;
        }
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        int i27 = 0;
        while (i27 <= bits3) {
            int iMin = Math.min(iArr12[i27], i20 - 1);
            aVarBuilder.a(new H265LayerInfo(iArr14[i27], iMin >= 0 ? iArr13[iMin] : -1));
            i27++;
            iArr12 = iArr12;
        }
        ImmutableList immutableListE = aVarBuilder.e();
        if (((H265LayerInfo) immutableListE.get(0)).viewId == -1) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices3, null, null);
        }
        int i28 = 1;
        while (true) {
            if (i28 > bits3) {
                i = -1;
                i2 = -1;
                break;
            }
            i = -1;
            if (((H265LayerInfo) immutableListE.get(i28)).viewId != -1) {
                i2 = i28;
                break;
            }
            i28++;
        }
        if (i2 == i) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices3, null, null);
        }
        Class cls = Boolean.TYPE;
        boolean[][] zArr3 = (boolean[][]) Array.newInstance((Class<?>) cls, bits, bits);
        boolean[][] zArr4 = (boolean[][]) Array.newInstance((Class<?>) cls, bits, bits);
        for (int i29 = 1; i29 < bits; i29++) {
            for (int i30 = 0; i30 < i29; i30++) {
                boolean[] zArr5 = zArr3[i29];
                boolean[] zArr6 = zArr4[i29];
                boolean bit6 = parsableNalUnitBitArray.readBit();
                zArr6[i30] = bit6;
                zArr5[i30] = bit6;
            }
        }
        for (int i31 = 1; i31 < bits; i31++) {
            for (int i32 = 0; i32 < bits - 1; i32++) {
                int i33 = 0;
                while (true) {
                    if (i33 < i31) {
                        boolean[] zArr7 = zArr4[i31];
                        if (zArr7[i33] && zArr4[i33][i32]) {
                            zArr7[i32] = true;
                            break;
                        }
                        i33++;
                    }
                }
            }
        }
        int[] iArr15 = new int[i7];
        for (int i34 = 0; i34 < bits; i34++) {
            int i35 = 0;
            for (int i36 = 0; i36 < i34; i36++) {
                i35 += zArr3[i34][i36] ? 1 : 0;
            }
            iArr15[iArr10[i34]] = i35;
        }
        int i37 = 0;
        for (int i38 = 0; i38 < bits; i38++) {
            if (iArr15[iArr10[i38]] == 0) {
                i37++;
            }
        }
        if (i37 > 1) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices3, null, null);
        }
        int[] iArr16 = new int[bits];
        int[] iArr17 = new int[unsignedExpGolombCodedInt];
        if (parsableNalUnitBitArray.readBit()) {
            for (int i39 = 0; i39 < bits; i39++) {
                iArr16[i39] = parsableNalUnitBitArray.readBits(3);
            }
        } else {
            Arrays.fill(iArr16, 0, bits, bits2);
        }
        int i40 = 0;
        while (i40 < unsignedExpGolombCodedInt) {
            int[] iArr18 = iArr15;
            int[] iArr19 = iArr10;
            int iMax = 0;
            for (int i41 = 0; i41 < iArr11[i40]; i41++) {
                iMax = Math.max(iMax, iArr16[((H265LayerInfo) immutableListE.get(iArr4[i40][i41])).layerIdInVps]);
            }
            iArr17[i40] = iMax + 1;
            i40++;
            iArr10 = iArr19;
            iArr15 = iArr18;
        }
        int[] iArr20 = iArr15;
        int[] iArr21 = iArr10;
        if (parsableNalUnitBitArray.readBit()) {
            int i42 = 0;
            while (i42 < bits - 1) {
                int i43 = i42 + 1;
                for (int i44 = i43; i44 < bits; i44++) {
                    if (zArr3[i44][i42]) {
                        parsableNalUnitBitArray.skipBits(3);
                    }
                }
                i42 = i43;
            }
        }
        parsableNalUnitBitArray.skipBit();
        int unsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        ImmutableList.a aVarBuilder2 = ImmutableList.builder();
        aVarBuilder2.a(h265ProfileTierLevel2);
        if (unsignedExpGolombCodedInt3 > 1) {
            H265ProfileTierLevel h265ProfileTierLevel6 = h265ProfileTierLevel;
            aVarBuilder2.a(h265ProfileTierLevel6);
            for (int i45 = 2; i45 < unsignedExpGolombCodedInt3; i45++) {
                h265ProfileTierLevel6 = parseH265ProfileTierLevel(parsableNalUnitBitArray, parsableNalUnitBitArray.readBit(), bits2, h265ProfileTierLevel6);
                aVarBuilder2.a(h265ProfileTierLevel6);
            }
        }
        ImmutableList immutableListE2 = aVarBuilder2.e();
        int unsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + unsignedExpGolombCodedInt;
        if (unsignedExpGolombCodedInt4 > unsignedExpGolombCodedInt) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices3, null, null);
        }
        int bits5 = parsableNalUnitBitArray.readBits(2);
        boolean[][] zArr8 = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, unsignedExpGolombCodedInt4, i7);
        int[] iArr22 = new int[unsignedExpGolombCodedInt4];
        int[] iArr23 = new int[unsignedExpGolombCodedInt4];
        int i46 = 0;
        while (i46 < unsignedExpGolombCodedInt) {
            int i47 = unsignedExpGolombCodedInt;
            iArr22[i46] = 0;
            iArr23[i46] = iArr6[i46];
            if (bits5 == 0) {
                iArr = iArr17;
                i5 = bits;
                h265ProfileTierLevelsAndIndices = h265ProfileTierLevelsAndIndices3;
                Arrays.fill(zArr8[i46], 0, iArr11[i46], true);
                iArr22[i46] = iArr11[i46];
            } else {
                h265ProfileTierLevelsAndIndices = h265ProfileTierLevelsAndIndices3;
                i5 = bits;
                iArr = iArr17;
                if (bits5 == 1) {
                    int i48 = iArr6[i46];
                    for (int i49 = 0; i49 < iArr11[i46]; i49++) {
                        zArr8[i46][i49] = iArr4[i46][i49] == i48;
                    }
                    iArr22[i46] = 1;
                } else {
                    zArr8[0][0] = true;
                    iArr22[0] = 1;
                }
            }
            i46++;
            unsignedExpGolombCodedInt = i47;
            iArr17 = iArr;
            bits = i5;
            h265ProfileTierLevelsAndIndices3 = h265ProfileTierLevelsAndIndices;
        }
        H265ProfileTierLevelsAndIndices h265ProfileTierLevelsAndIndices4 = h265ProfileTierLevelsAndIndices3;
        int i50 = bits;
        int[] iArr24 = iArr17;
        int i51 = unsignedExpGolombCodedInt;
        int[] iArr25 = new int[i7];
        boolean[][] zArr9 = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, unsignedExpGolombCodedInt4, i7);
        int i52 = 1;
        int i53 = 0;
        while (i52 < unsignedExpGolombCodedInt4) {
            if (bits5 == 2) {
                for (int i54 = 0; i54 < iArr11[i52]; i54++) {
                    zArr8[i52][i54] = parsableNalUnitBitArray.readBit();
                    int i55 = iArr22[i52];
                    boolean z5 = zArr8[i52][i54];
                    iArr22[i52] = i55 + (z5 ? 1 : 0);
                    if (z5) {
                        iArr23[i52] = iArr4[i52][i54];
                    }
                }
            }
            if (i53 == 0 && iArr4[i52][0] == 0 && zArr8[i52][0]) {
                for (int i56 = 1; i56 < iArr11[i52]; i56++) {
                    if (iArr4[i52][i56] == i2 && zArr8[i52][i2]) {
                        i53 = i52;
                    }
                }
            }
            int i57 = 0;
            while (i57 < iArr11[i52]) {
                if (unsignedExpGolombCodedInt3 > 1) {
                    zArr9[i52][i57] = zArr8[i52][i57];
                    zArr = zArr8;
                    i3 = i2;
                    int iD = ue1.d(unsignedExpGolombCodedInt3, RoundingMode.CEILING);
                    if (zArr9[i52][i57]) {
                        i4 = unsignedExpGolombCodedInt3;
                        if (zArr9[i52][i57]) {
                        }
                    } else {
                        int i58 = ((H265LayerInfo) immutableListE.get(iArr4[i52][i57])).layerIdInVps;
                        int i59 = 0;
                        while (i59 < i57) {
                            i4 = unsignedExpGolombCodedInt3;
                            if (zArr4[i58][((H265LayerInfo) immutableListE.get(iArr4[i52][i59])).layerIdInVps]) {
                                zArr9[i52][i57] = true;
                                break;
                            }
                            i59++;
                            unsignedExpGolombCodedInt3 = i4;
                        }
                        i4 = unsignedExpGolombCodedInt3;
                        if (zArr9[i52][i57]) {
                            if (i53 <= 0 || i52 != i53) {
                                parsableNalUnitBitArray.skipBits(iD);
                            } else {
                                iArr25[i57] = parsableNalUnitBitArray.readBits(iD);
                            }
                        }
                    }
                } else {
                    i3 = i2;
                    i4 = unsignedExpGolombCodedInt3;
                    zArr = zArr8;
                }
                i57++;
                zArr8 = zArr;
                i2 = i3;
                unsignedExpGolombCodedInt3 = i4;
            }
            int i60 = i2;
            int i61 = unsignedExpGolombCodedInt3;
            boolean[][] zArr10 = zArr8;
            if (iArr22[i52] == 1 && iArr20[iArr23[i52]] > 0) {
                parsableNalUnitBitArray.skipBit();
            }
            i52++;
            zArr8 = zArr10;
            i2 = i60;
            unsignedExpGolombCodedInt3 = i61;
        }
        if (i53 == 0) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices4, null, null);
        }
        H265RepFormatsAndIndices h265RepFormatsAndIndices = parseH265RepFormatsAndIndices(parsableNalUnitBitArray, i50);
        parsableNalUnitBitArray.skipBits(2);
        for (int i62 = 1; i62 < i50; i62++) {
            if (iArr20[iArr21[i62]] == 0) {
                parsableNalUnitBitArray.skipBit();
            }
        }
        skipH265DpbSize(parsableNalUnitBitArray, unsignedExpGolombCodedInt4, iArr24, iArr11, zArr9);
        skipToH265VuiPresentFlagAfterDpbSize(parsableNalUnitBitArray, i50, zArr3);
        if (parsableNalUnitBitArray.readBit()) {
            parsableNalUnitBitArray.byteAlign();
            h265VideoSignalInfosAndIndices = parseH265VideoSignalInfosAndIndices(parsableNalUnitBitArray, i50, i51, iArr24);
        } else {
            h265VideoSignalInfosAndIndices = null;
        }
        return new H265VpsData(h265NalHeader, immutableListE, new H265ProfileTierLevelsAndIndices(immutableListE2, iArr25), h265RepFormatsAndIndices, h265VideoSignalInfosAndIndices);
    }

    public static PpsData parsePpsNalUnit(byte[] bArr, int i, int i2) {
        return parsePpsNalUnitPayload(bArr, i + 1, i2);
    }

    public static PpsData parsePpsNalUnitPayload(byte[] bArr, int i, int i2) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
        int unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int unsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        return new PpsData(unsignedExpGolombCodedInt, unsignedExpGolombCodedInt2, parsableNalUnitBitArray.readBit());
    }

    public static SpsData parseSpsNalUnit(byte[] bArr, int i, int i2) {
        return parseSpsNalUnitPayload(bArr, i + 1, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x015c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SpsData parseSpsNalUnitPayload(byte[] bArr, int i, int i2) {
        int unsignedExpGolombCodedInt;
        boolean bit;
        int unsignedExpGolombCodedInt2;
        int unsignedExpGolombCodedInt3;
        int i3;
        int unsignedExpGolombCodedInt4;
        boolean z;
        boolean bit2;
        int i4;
        float f;
        int i5;
        int i6;
        int iIsoTransferCharacteristicsToColorTransfer;
        int i7;
        int i8;
        int i9;
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
        int bits = parsableNalUnitBitArray.readBits(8);
        int bits2 = parsableNalUnitBitArray.readBits(8);
        int bits3 = parsableNalUnitBitArray.readBits(8);
        int unsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (bits == 100 || bits == 110 || bits == 122 || bits == 244 || bits == 44 || bits == 83 || bits == 86 || bits == 118 || bits == 128 || bits == 138) {
            unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            bit = unsignedExpGolombCodedInt == 3 ? parsableNalUnitBitArray.readBit() : false;
            unsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            unsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
            if (parsableNalUnitBitArray.readBit()) {
                int i10 = unsignedExpGolombCodedInt == 3 ? 12 : 8;
                int i11 = 0;
                while (i11 < i10) {
                    if (parsableNalUnitBitArray.readBit()) {
                        skipScalingList(parsableNalUnitBitArray, i11 < 6 ? 16 : 64);
                    }
                    i11++;
                }
            }
        } else {
            unsignedExpGolombCodedInt = 1;
            bit = false;
            unsignedExpGolombCodedInt2 = 0;
            unsignedExpGolombCodedInt3 = 0;
        }
        int unsignedExpGolombCodedInt6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 4;
        int unsignedExpGolombCodedInt7 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (unsignedExpGolombCodedInt7 == 0) {
            i3 = bits;
            unsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 4;
        } else {
            if (unsignedExpGolombCodedInt7 == 1) {
                boolean bit3 = parsableNalUnitBitArray.readBit();
                parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                i3 = bits;
                long unsignedExpGolombCodedInt8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                for (int i12 = 0; i12 < unsignedExpGolombCodedInt8; i12++) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                }
                z = bit3;
                unsignedExpGolombCodedInt4 = 0;
                int unsignedExpGolombCodedInt9 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.skipBit();
                int unsignedExpGolombCodedInt10 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
                int unsignedExpGolombCodedInt11 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
                bit2 = parsableNalUnitBitArray.readBit();
                int i13 = (2 - (bit2 ? 1 : 0)) * unsignedExpGolombCodedInt11;
                if (!bit2) {
                    parsableNalUnitBitArray.skipBit();
                }
                parsableNalUnitBitArray.skipBit();
                int i14 = unsignedExpGolombCodedInt10 * 16;
                int i15 = i13 * 16;
                if (parsableNalUnitBitArray.readBit()) {
                    int unsignedExpGolombCodedInt12 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    int unsignedExpGolombCodedInt13 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    int unsignedExpGolombCodedInt14 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    int unsignedExpGolombCodedInt15 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    if (unsignedExpGolombCodedInt == 0) {
                        i9 = 2 - (bit2 ? 1 : 0);
                        i8 = 1;
                    } else {
                        i8 = unsignedExpGolombCodedInt == 3 ? 1 : 2;
                        i9 = (unsignedExpGolombCodedInt == 1 ? 2 : 1) * (2 - (bit2 ? 1 : 0));
                    }
                    i14 -= (unsignedExpGolombCodedInt12 + unsignedExpGolombCodedInt13) * i8;
                    i15 -= (unsignedExpGolombCodedInt14 + unsignedExpGolombCodedInt15) * i9;
                }
                int i16 = i15;
                int i17 = i3;
                int i18 = i14;
                int unsignedExpGolombCodedInt16 = ((i17 != 44 || i17 == 86 || i17 == 100 || i17 == 110 || i17 == 122 || i17 == 244) && (bits2 & 16) != 0) ? 0 : 16;
                int iIsoColorPrimariesToColorSpace = -1;
                float f2 = 1.0f;
                if (parsableNalUnitBitArray.readBit()) {
                    i4 = unsignedExpGolombCodedInt16;
                    f = 1.0f;
                    i5 = -1;
                    i6 = -1;
                } else {
                    if (parsableNalUnitBitArray.readBit()) {
                        int bits4 = parsableNalUnitBitArray.readBits(8);
                        if (bits4 == 255) {
                            int bits5 = parsableNalUnitBitArray.readBits(16);
                            int bits6 = parsableNalUnitBitArray.readBits(16);
                            if (bits5 != 0 && bits6 != 0) {
                                f2 = bits5 / bits6;
                            }
                        } else {
                            float[] fArr = ASPECT_RATIO_IDC_VALUES;
                            if (bits4 < fArr.length) {
                                f2 = fArr[bits4];
                            } else {
                                Log.w(TAG, "Unexpected aspect_ratio_idc value: " + bits4);
                            }
                        }
                    }
                    if (parsableNalUnitBitArray.readBit()) {
                        parsableNalUnitBitArray.skipBit();
                    }
                    if (parsableNalUnitBitArray.readBit()) {
                        parsableNalUnitBitArray.skipBits(3);
                        i7 = parsableNalUnitBitArray.readBit() ? 1 : 2;
                        if (parsableNalUnitBitArray.readBit()) {
                            int bits7 = parsableNalUnitBitArray.readBits(8);
                            int bits8 = parsableNalUnitBitArray.readBits(8);
                            parsableNalUnitBitArray.skipBits(8);
                            iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(bits7);
                            iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(bits8);
                        } else {
                            iIsoTransferCharacteristicsToColorTransfer = -1;
                        }
                    } else {
                        iIsoTransferCharacteristicsToColorTransfer = -1;
                        i7 = -1;
                    }
                    if (parsableNalUnitBitArray.readBit()) {
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    }
                    if (parsableNalUnitBitArray.readBit()) {
                        parsableNalUnitBitArray.skipBits(65);
                    }
                    boolean bit4 = parsableNalUnitBitArray.readBit();
                    if (bit4) {
                        skipHrdParameters(parsableNalUnitBitArray);
                    }
                    boolean bit5 = parsableNalUnitBitArray.readBit();
                    if (bit5) {
                        skipHrdParameters(parsableNalUnitBitArray);
                    }
                    if (bit4 || bit5) {
                        parsableNalUnitBitArray.skipBit();
                    }
                    parsableNalUnitBitArray.skipBit();
                    if (parsableNalUnitBitArray.readBit()) {
                        parsableNalUnitBitArray.skipBit();
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        unsignedExpGolombCodedInt16 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    }
                    i4 = unsignedExpGolombCodedInt16;
                    i6 = iIsoTransferCharacteristicsToColorTransfer;
                    f = f2;
                    i5 = i7;
                }
                return new SpsData(i17, bits2, bits3, unsignedExpGolombCodedInt5, unsignedExpGolombCodedInt9, i18, i16, f, unsignedExpGolombCodedInt2, unsignedExpGolombCodedInt3, bit, bit2, unsignedExpGolombCodedInt6, unsignedExpGolombCodedInt7, unsignedExpGolombCodedInt4, z, iIsoColorPrimariesToColorSpace, i5, i6, i4);
            }
            i3 = bits;
            unsignedExpGolombCodedInt4 = 0;
        }
        z = false;
        int unsignedExpGolombCodedInt92 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        int unsignedExpGolombCodedInt102 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        int unsignedExpGolombCodedInt112 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        bit2 = parsableNalUnitBitArray.readBit();
        int i132 = (2 - (bit2 ? 1 : 0)) * unsignedExpGolombCodedInt112;
        if (!bit2) {
        }
        parsableNalUnitBitArray.skipBit();
        int i142 = unsignedExpGolombCodedInt102 * 16;
        int i152 = i132 * 16;
        if (parsableNalUnitBitArray.readBit()) {
        }
        int i162 = i152;
        int i172 = i3;
        int i182 = i142;
        if (i172 != 44) {
        }
        int iIsoColorPrimariesToColorSpace2 = -1;
        float f22 = 1.0f;
        if (parsableNalUnitBitArray.readBit()) {
        }
        return new SpsData(i172, bits2, bits3, unsignedExpGolombCodedInt5, unsignedExpGolombCodedInt92, i182, i162, f, unsignedExpGolombCodedInt2, unsignedExpGolombCodedInt3, bit, bit2, unsignedExpGolombCodedInt6, unsignedExpGolombCodedInt7, unsignedExpGolombCodedInt4, z, iIsoColorPrimariesToColorSpace2, i5, i6, i4);
    }

    private static void skipH265DpbSize(ParsableNalUnitBitArray parsableNalUnitBitArray, int i, int[] iArr, int[] iArr2, boolean[][] zArr) {
        for (int i2 = 1; i2 < i; i2++) {
            boolean bit = parsableNalUnitBitArray.readBit();
            int i3 = 0;
            while (i3 < iArr[i2]) {
                if ((i3 <= 0 || !bit) ? i3 == 0 : parsableNalUnitBitArray.readBit()) {
                    for (int i4 = 0; i4 < iArr2[i2]; i4++) {
                        if (zArr[i2][i4]) {
                            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        }
                    }
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                }
                i3++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void skipH265HrdParameters(ParsableNalUnitBitArray parsableNalUnitBitArray, boolean z, int i) {
        boolean z2;
        boolean z3;
        int i2;
        boolean bit;
        int i3;
        int i4;
        boolean bit2;
        if (z) {
            boolean bit3 = parsableNalUnitBitArray.readBit();
            boolean bit4 = parsableNalUnitBitArray.readBit();
            z3 = bit4;
            z2 = bit3;
            if (bit3 || bit4) {
                bit = parsableNalUnitBitArray.readBit();
                if (bit) {
                    parsableNalUnitBitArray.skipBits(19);
                }
                parsableNalUnitBitArray.skipBits(8);
                if (bit) {
                    parsableNalUnitBitArray.skipBits(4);
                }
                parsableNalUnitBitArray.skipBits(15);
                i3 = bit4;
                i2 = bit3;
            }
            for (i4 = 0; i4 <= i; i4++) {
                boolean bit5 = parsableNalUnitBitArray.readBit();
                if (!bit5) {
                    bit5 = parsableNalUnitBitArray.readBit();
                }
                if (bit5) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    bit2 = false;
                } else {
                    bit2 = parsableNalUnitBitArray.readBit();
                }
                int unsignedExpGolombCodedInt = !bit2 ? parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() : 0;
                int i5 = i2 + 0 + i3;
                for (int i6 = 0; i6 < i5; i6++) {
                    for (int i7 = 0; i7 <= unsignedExpGolombCodedInt; i7++) {
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        if (bit) {
                            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        }
                        parsableNalUnitBitArray.skipBit();
                    }
                }
            }
        }
        z2 = false;
        z3 = false;
        bit = false;
        i3 = z3;
        i2 = z2;
        while (i4 <= i) {
        }
    }

    private static void skipH265ScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        for (int i = 0; i < 4; i++) {
            int i2 = 0;
            while (i2 < 6) {
                int i3 = 1;
                if (parsableNalUnitBitArray.readBit()) {
                    int iMin = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                    for (int i4 = 0; i4 < iMin; i4++) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                } else {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                }
                if (i == 3) {
                    i3 = 3;
                }
                i2 += i3;
            }
        }
    }

    private static void skipH265ShortTermReferencePictureSets(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int[] iArr = new int[0];
        int[] iArrCopyOf = new int[0];
        int i = -1;
        int i2 = -1;
        int i3 = 0;
        while (i3 < unsignedExpGolombCodedInt) {
            if (i3 != 0 && parsableNalUnitBitArray.readBit()) {
                int i4 = i + i2;
                int unsignedExpGolombCodedInt2 = (1 - ((parsableNalUnitBitArray.readBit() ? 1 : 0) * 2)) * (parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1);
                int i5 = i4 + 1;
                boolean[] zArr = new boolean[i5];
                for (int i6 = 0; i6 <= i4; i6++) {
                    if (parsableNalUnitBitArray.readBit()) {
                        zArr[i6] = true;
                    } else {
                        zArr[i6] = parsableNalUnitBitArray.readBit();
                    }
                }
                int[] iArr2 = new int[i5];
                int[] iArr3 = new int[i5];
                int i7 = 0;
                for (int i8 = i2 - 1; i8 >= 0; i8--) {
                    int i9 = iArrCopyOf[i8] + unsignedExpGolombCodedInt2;
                    if (i9 < 0 && zArr[i + i8]) {
                        iArr2[i7] = i9;
                        i7++;
                    }
                }
                if (unsignedExpGolombCodedInt2 < 0 && zArr[i4]) {
                    iArr2[i7] = unsignedExpGolombCodedInt2;
                    i7++;
                }
                for (int i10 = 0; i10 < i; i10++) {
                    int i11 = iArr[i10] + unsignedExpGolombCodedInt2;
                    if (i11 < 0 && zArr[i10]) {
                        iArr2[i7] = i11;
                        i7++;
                    }
                }
                int[] iArrCopyOf2 = Arrays.copyOf(iArr2, i7);
                int i12 = 0;
                for (int i13 = i - 1; i13 >= 0; i13--) {
                    int i14 = iArr[i13] + unsignedExpGolombCodedInt2;
                    if (i14 > 0 && zArr[i13]) {
                        iArr3[i12] = i14;
                        i12++;
                    }
                }
                if (unsignedExpGolombCodedInt2 > 0 && zArr[i4]) {
                    iArr3[i12] = unsignedExpGolombCodedInt2;
                    i12++;
                }
                for (int i15 = 0; i15 < i2; i15++) {
                    int i16 = iArrCopyOf[i15] + unsignedExpGolombCodedInt2;
                    if (i16 > 0 && zArr[i + i15]) {
                        iArr3[i12] = i16;
                        i12++;
                    }
                }
                iArrCopyOf = Arrays.copyOf(iArr3, i12);
                iArr = iArrCopyOf2;
                i = i7;
                i2 = i12;
            } else {
                int unsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int unsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int[] iArr4 = new int[unsignedExpGolombCodedInt3];
                int i17 = 0;
                while (i17 < unsignedExpGolombCodedInt3) {
                    iArr4[i17] = (i17 > 0 ? iArr4[i17 - 1] : 0) - (parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1);
                    parsableNalUnitBitArray.skipBit();
                    i17++;
                }
                int[] iArr5 = new int[unsignedExpGolombCodedInt4];
                int i18 = 0;
                while (i18 < unsignedExpGolombCodedInt4) {
                    iArr5[i18] = (i18 > 0 ? iArr5[i18 - 1] : 0) + parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
                    parsableNalUnitBitArray.skipBit();
                    i18++;
                }
                i = unsignedExpGolombCodedInt3;
                iArr = iArr4;
                i2 = unsignedExpGolombCodedInt4;
                iArrCopyOf = iArr5;
            }
            i3++;
        }
    }

    private static void skipHrdParameters(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        parsableNalUnitBitArray.skipBits(8);
        for (int i = 0; i < unsignedExpGolombCodedInt; i++) {
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
        }
        parsableNalUnitBitArray.skipBits(20);
    }

    private static void skipScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray, int i) {
        int signedExpGolombCodedInt = 8;
        int i2 = 8;
        for (int i3 = 0; i3 < i; i3++) {
            if (signedExpGolombCodedInt != 0) {
                signedExpGolombCodedInt = ((parsableNalUnitBitArray.readSignedExpGolombCodedInt() + i2) + 256) % 256;
            }
            if (signedExpGolombCodedInt != 0) {
                i2 = signedExpGolombCodedInt;
            }
        }
    }

    private static void skipToH265VuiPresentFlagAfterDpbSize(ParsableNalUnitBitArray parsableNalUnitBitArray, int i, boolean[][] zArr) {
        int unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 2;
        if (parsableNalUnitBitArray.readBit()) {
            parsableNalUnitBitArray.skipBits(unsignedExpGolombCodedInt);
        } else {
            for (int i2 = 1; i2 < i; i2++) {
                for (int i3 = 0; i3 < i2; i3++) {
                    if (zArr[i2][i3]) {
                        parsableNalUnitBitArray.skipBits(unsignedExpGolombCodedInt);
                    }
                }
            }
        }
        int unsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        for (int i4 = 1; i4 <= unsignedExpGolombCodedInt2; i4++) {
            parsableNalUnitBitArray.skipBits(8);
        }
    }

    public static int unescapeStream(byte[] bArr, int i) {
        int i2;
        synchronized (scratchEscapePositionsLock) {
            int iFindNextUnescapeIndex = 0;
            int i3 = 0;
            while (iFindNextUnescapeIndex < i) {
                try {
                    iFindNextUnescapeIndex = findNextUnescapeIndex(bArr, iFindNextUnescapeIndex, i);
                    if (iFindNextUnescapeIndex < i) {
                        int[] iArr = scratchEscapePositions;
                        if (iArr.length <= i3) {
                            scratchEscapePositions = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        scratchEscapePositions[i3] = iFindNextUnescapeIndex;
                        iFindNextUnescapeIndex += 3;
                        i3++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            i2 = i - i3;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = scratchEscapePositions[i6] - i5;
                System.arraycopy(bArr, i5, bArr, i4, i7);
                int i8 = i4 + i7;
                int i9 = i8 + 1;
                bArr[i8] = 0;
                i4 = i9 + 1;
                bArr[i9] = 0;
                i5 += i7 + 3;
            }
            System.arraycopy(bArr, i5, bArr, i4, i2 - i4);
        }
        return i2;
    }

    public static boolean isNalUnitSei(Format format, byte b) {
        if ((Objects.equals(format.sampleMimeType, "video/avc") || MimeTypes.containsCodecsCorrespondingToMimeType(format.codecs, "video/avc")) && (b & TELogUtils.DEBUG_LEVEL_V) == 6) {
            return true;
        }
        return (Objects.equals(format.sampleMimeType, "video/hevc") || MimeTypes.containsCodecsCorrespondingToMimeType(format.codecs, "video/hevc")) && ((b & 126) >> 1) == 39;
    }
}
