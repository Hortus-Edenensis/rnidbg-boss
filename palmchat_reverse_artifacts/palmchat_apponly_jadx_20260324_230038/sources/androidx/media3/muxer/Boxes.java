package androidx.media3.muxer;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.DolbyVisionConfig;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4LocationData;
import androidx.media3.container.Mp4TimestampData;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.container.XmpData;
import androidx.media3.muxer.FragmentedMp4Writer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.collect.ImmutableList;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.dn;
import defpackage.bv2;
import defpackage.d43;
import defpackage.jh5;
import defpackage.ku2;
import defpackage.vv;
import j$.util.Objects;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class Boxes {
    public static final int BOX_HEADER_SIZE = 8;
    private static final int BYTES_PER_INTEGER = 4;
    public static final int LARGE_SIZE_BOX_HEADER_SIZE = 16;
    private static final int MAX_FIXED_LEAF_BOX_SIZE = 200;
    public static final int MFHD_BOX_CONTENT_SIZE = 8;
    private static final long MVHD_TIMEBASE = 10000;
    private static final String TAG = "Boxes";
    public static final int TFHD_BOX_CONTENT_SIZE = 16;
    private static final int TRUN_BOX_NON_SYNC_SAMPLE_FLAGS = 16842752;
    private static final int TRUN_BOX_SYNC_SAMPLE_FLAGS = 33554432;
    public static final ImmutableList<Byte> XMP_UUID = ImmutableList.of((byte) -66, (byte) 122, (byte) -49, (byte) -53, (byte) -105, (byte) -87, (byte) 66, (byte) -24, (byte) -100, (byte) 113, (byte) -103, (byte) -108, (byte) -111, (byte) -29, (byte) -81, (byte) -84);

    private Boxes() {
    }

    private static ByteBuffer apvCBox(Format format) {
        Assertions.checkArgument(!format.initializationData.isEmpty(), "csd-0 is not found in the format for avpC box");
        byte[] bArr = format.initializationData.get(0);
        Assertions.checkArgument(bArr.length > 0, "csd-0 is empty for avpC box.");
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + 4);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.put(bArr);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("apvC", byteBufferAllocate);
    }

    public static ByteBuffer audioSampleEntry(Format format) {
        String strCodecSpecificFourcc = codecSpecificFourcc(format);
        ByteBuffer byteBufferCodecSpecificBox = codecSpecificBox(format);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBufferCodecSpecificBox.remaining() + 200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putShort((short) 1);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putShort((short) format.channelCount);
        byteBufferAllocate.putShort((short) 16);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putInt(format.sampleRate << 16);
        byteBufferAllocate.put(byteBufferCodecSpecificBox);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox(strCodecSpecificFourcc, byteBufferAllocate);
    }

    private static ByteBuffer av1CBox(Format format) {
        return BoxUtils.wrapIntoBox("av1C", ByteBuffer.wrap(format.initializationData.get(0)));
    }

    private static ByteBuffer avcCBox(Format format) {
        Assertions.checkArgument(format.initializationData.size() >= 2, "csd-0 and/or csd-1 not found in the format for avcC box.");
        byte[] bArr = format.initializationData.get(0);
        Assertions.checkArgument(bArr.length > 0, "csd-0 is empty for avcC box.");
        byte[] bArr2 = format.initializationData.get(1);
        Assertions.checkArgument(bArr2.length > 0, "csd-1 is empty for avcC box.");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(bArr2);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBufferWrap.limit() + byteBufferWrap2.limit() + 200);
        byteBufferAllocate.put((byte) 1);
        ImmutableList<ByteBuffer> immutableListFindNalUnits = AnnexBUtils.findNalUnits(byteBufferWrap);
        Assertions.checkArgument(immutableListFindNalUnits.size() == 1, "SPS data not found in csd0 for avcC box.");
        ByteBuffer byteBuffer = immutableListFindNalUnits.get(0);
        int iRemaining = byteBuffer.remaining();
        byte[] bArr3 = new byte[iRemaining];
        byteBuffer.get(bArr3);
        byteBuffer.rewind();
        NalUnitUtil.SpsData spsNalUnit = NalUnitUtil.parseSpsNalUnit(bArr3, 0, iRemaining);
        byteBufferAllocate.put((byte) spsNalUnit.profileIdc);
        byteBufferAllocate.put((byte) spsNalUnit.constraintsFlagsAndReservedZero2Bits);
        byteBufferAllocate.put((byte) spsNalUnit.levelIdc);
        byteBufferAllocate.put((byte) -1);
        byteBufferAllocate.put((byte) -31);
        byteBufferAllocate.putShort((short) byteBuffer.remaining());
        byteBufferAllocate.put(byteBuffer);
        byteBuffer.rewind();
        ImmutableList<ByteBuffer> immutableListFindNalUnits2 = AnnexBUtils.findNalUnits(byteBufferWrap2);
        Assertions.checkState(immutableListFindNalUnits2.size() == 1, "PPS data not found in csd1.");
        byteBufferAllocate.put((byte) 1);
        ByteBuffer byteBuffer2 = immutableListFindNalUnits2.get(0);
        byteBufferAllocate.putShort((short) byteBuffer2.remaining());
        byteBufferAllocate.put(byteBuffer2);
        byteBuffer2.rewind();
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("avcC", byteBufferAllocate);
    }

    private static String bcp47LanguageTagToIso3(String str) {
        if (str == null) {
            return null;
        }
        Locale localeForLanguageTag = Locale.forLanguageTag(str);
        return localeForLanguageTag.getISO3Language().isEmpty() ? str : localeForLanguageTag.getISO3Language();
    }

    public static List<Integer> calculateSampleCompositionTimeOffsets(List<BufferInfo> list, List<Integer> list2, int i) {
        List<BufferInfo> list3 = list;
        ArrayList arrayList = new ArrayList(list.size());
        if (list.isEmpty()) {
            return arrayList;
        }
        boolean z = false;
        long j = list3.get(0).presentationTimeUs;
        long jIntValue = 0;
        long j2 = 0;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < list.size()) {
            long j3 = list3.get(i2).presentationTimeUs - j;
            long jVuFromUs = vuFromUs(j3, i) - jIntValue;
            if (jVuFromUs <= 2147483647L) {
                z = true;
            }
            Assertions.checkState(z, "Only 32-bit composition offset is allowed");
            long j4 = j;
            jIntValue += (long) list2.get(i2).intValue();
            arrayList.add(Integer.valueOf((int) jVuFromUs));
            if (j3 < j2) {
                z2 = true;
            }
            i2++;
            list3 = list;
            j2 = j3;
            j = j4;
            z = false;
        }
        if (!z2) {
            arrayList.clear();
        }
        return arrayList;
    }

    public static ByteBuffer co64(List<Long> list) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((list.size() * 2 * 4) + 8);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(list.size());
        for (int i = 0; i < list.size(); i++) {
            byteBufferAllocate.putLong(list.get(i).longValue());
        }
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("co64", byteBufferAllocate);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static ByteBuffer codecSpecificBox(Format format) {
        String str = (String) Assertions.checkNotNull(format.sampleMimeType);
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1851077871:
                if (str.equals("video/dolby-vision")) {
                    b = 0;
                }
                break;
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    b = 1;
                }
                break;
            case -1662735862:
                if (str.equals("video/av01")) {
                    b = 2;
                }
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    b = 3;
                }
                break;
            case -1606874997:
                if (str.equals("audio/amr-wb")) {
                    b = 4;
                }
                break;
            case -1003765268:
                if (str.equals("audio/vorbis")) {
                    b = 5;
                }
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    b = 6;
                }
                break;
            case 187094639:
                if (str.equals("audio/raw")) {
                    b = 7;
                }
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    b = 8;
                }
                break;
            case 1331836563:
                if (str.equals(MimeTypes.VIDEO_APV)) {
                    b = 9;
                }
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    b = 10;
                }
                break;
            case 1503095341:
                if (str.equals("audio/3gpp")) {
                    b = 11;
                }
                break;
            case 1504891608:
                if (str.equals("audio/opus")) {
                    b = 12;
                }
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    b = dn.k;
                }
                break;
        }
        switch (b) {
            case 0:
                return doviSpecificBox(format);
            case 1:
                return d263Box(format);
            case 2:
                return av1CBox(format);
            case 3:
                return hvcCBox(format);
            case 4:
                return damrBox((short) -31745);
            case 5:
            case 6:
                return esdsBox(format);
            case 7:
                return ByteBuffer.allocate(0);
            case 8:
                return esdsBox(format);
            case 9:
                return apvCBox(format);
            case 10:
                return avcCBox(format);
            case 11:
                return damrBox((short) -32257);
            case 12:
                return dOpsBox(format);
            case 13:
                return vpcCBox(format);
            default:
                throw new IllegalArgumentException("Unsupported format: " + str);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static String codecSpecificFourcc(Format format) {
        String str = (String) Assertions.checkNotNull(format.sampleMimeType);
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1851077871:
                if (str.equals("video/dolby-vision")) {
                    b = 0;
                }
                break;
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    b = 1;
                }
                break;
            case -1662735862:
                if (str.equals("video/av01")) {
                    b = 2;
                }
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    b = 3;
                }
                break;
            case -1606874997:
                if (str.equals("audio/amr-wb")) {
                    b = 4;
                }
                break;
            case -1003765268:
                if (str.equals("audio/vorbis")) {
                    b = 5;
                }
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    b = 6;
                }
                break;
            case 187094639:
                if (str.equals("audio/raw")) {
                    b = 7;
                }
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    b = 8;
                }
                break;
            case 1331836563:
                if (str.equals(MimeTypes.VIDEO_APV)) {
                    b = 9;
                }
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    b = 10;
                }
                break;
            case 1503095341:
                if (str.equals("audio/3gpp")) {
                    b = 11;
                }
                break;
            case 1504891608:
                if (str.equals("audio/opus")) {
                    b = 12;
                }
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    b = dn.k;
                }
                break;
        }
        switch (b) {
            case 0:
                return getDoviFourcc(format);
            case 1:
                return "s263";
            case 2:
                return "av01";
            case 3:
                return "hvc1";
            case 4:
                return "sawb";
            case 5:
            case 6:
                return "mp4a";
            case 7:
                int i = format.pcmEncoding;
                if (i == 2) {
                    return "sowt";
                }
                if (i == 268435456) {
                    return "twos";
                }
                throw new IllegalArgumentException("Unsupported PCM encoding: " + format.pcmEncoding);
            case 8:
                return "mp4v-es";
            case 9:
                return "apv1";
            case 10:
                return "avc1";
            case 11:
                return "samr";
            case 12:
                return "Opus";
            case 13:
                return "vp09";
            default:
                throw new IllegalArgumentException("Unsupported format: " + str);
        }
    }

    private static ByteBuffer colrBox(ColorInfo colorInfo) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(20);
        byteBufferAllocate.put((byte) 110);
        byteBufferAllocate.put((byte) 99);
        byteBufferAllocate.put((byte) 108);
        byteBufferAllocate.put((byte) 120);
        short sColorSpaceToIsoColorPrimaries = (short) ColorInfo.colorSpaceToIsoColorPrimaries(colorInfo.colorSpace);
        short sColorTransferToIsoTransferCharacteristics = (short) ColorInfo.colorTransferToIsoTransferCharacteristics(colorInfo.colorTransfer);
        short sColorSpaceToIsoMatrixCoefficients = (short) ColorInfo.colorSpaceToIsoMatrixCoefficients(colorInfo.colorSpace);
        byte b = colorInfo.colorRange == 1 ? ByteCompanionObject.MIN_VALUE : (byte) 0;
        byteBufferAllocate.putShort(sColorSpaceToIsoColorPrimaries);
        byteBufferAllocate.putShort(sColorTransferToIsoTransferCharacteristics);
        byteBufferAllocate.putShort(sColorSpaceToIsoMatrixCoefficients);
        byteBufferAllocate.put(b);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("colr", byteBufferAllocate);
    }

    public static List<Integer> convertPresentationTimestampsToDurationsVu(List<BufferInfo> list, int i, int i2, long j) {
        long jVuFromUs;
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        if (list.isEmpty()) {
            return arrayList2;
        }
        long j2 = 0;
        int i3 = 0;
        boolean z = false;
        while (i3 < list.size()) {
            long j3 = list.get(i3).presentationTimeUs;
            arrayList.add(Long.valueOf(j3));
            if (j3 < j2) {
                z = true;
            }
            i3++;
            j2 = j3;
        }
        if (z) {
            Collections.sort(arrayList);
        }
        long jLongValue = ((Long) arrayList.get(0)).longValue();
        int i4 = 1;
        while (i4 < arrayList.size()) {
            long jLongValue2 = ((Long) arrayList.get(i4)).longValue();
            long jVuFromUs2 = vuFromUs(jLongValue2 - jLongValue, i);
            Assertions.checkState(jVuFromUs2 <= 2147483647L, "Only 32-bit sample duration is allowed");
            arrayList2.add(Integer.valueOf((int) jVuFromUs2));
            i4++;
            jLongValue = jLongValue2;
        }
        if (j != -9223372036854775807L) {
            long j4 = i;
            jVuFromUs = vuFromUs(j, j4) - vuFromUs(jLongValue, j4);
            Assertions.checkState(jVuFromUs <= 2147483647L, "Only 32-bit sample duration is allowed");
        } else {
            jVuFromUs = -1;
        }
        arrayList2.add(Integer.valueOf(getLastSampleDurationVu(arrayList2, i2, (int) jVuFromUs)));
        return arrayList2;
    }

    public static ByteBuffer ctts(List<BufferInfo> list, List<Integer> list2, int i) {
        List<Integer> listCalculateSampleCompositionTimeOffsets = calculateSampleCompositionTimeOffsets(list, list2, i);
        if (listCalculateSampleCompositionTimeOffsets.isEmpty()) {
            return ByteBuffer.allocate(0);
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((listCalculateSampleCompositionTimeOffsets.size() * 2 * 4) + 8);
        byteBufferAllocate.putInt(16777216);
        int iPosition = byteBufferAllocate.position();
        byteBufferAllocate.putInt(0);
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < listCalculateSampleCompositionTimeOffsets.size(); i5++) {
            int iIntValue = listCalculateSampleCompositionTimeOffsets.get(i5).intValue();
            if (i3 != iIntValue) {
                int iPosition2 = byteBufferAllocate.position();
                byteBufferAllocate.putInt(1);
                byteBufferAllocate.putInt(iIntValue);
                i2++;
                i4 = iPosition2;
                i3 = iIntValue;
            } else {
                byteBufferAllocate.putInt(i4, byteBufferAllocate.getInt(i4) + 1);
            }
        }
        byteBufferAllocate.putInt(iPosition, i2);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("ctts", byteBufferAllocate);
    }

    private static ByteBuffer d263Box(Format format) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(7);
        byteBufferAllocate.put("    ".getBytes(StandardCharsets.UTF_8));
        byteBufferAllocate.put((byte) 0);
        Pair<Integer, Integer> codecProfileAndLevel = CodecSpecificDataUtil.getCodecProfileAndLevel(format);
        if (codecProfileAndLevel == null) {
            codecProfileAndLevel = new Pair<>(1, 1);
        }
        byteBufferAllocate.put(((Integer) codecProfileAndLevel.second).byteValue());
        byteBufferAllocate.put(((Integer) codecProfileAndLevel.first).byteValue());
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("d263", byteBufferAllocate);
    }

    private static ByteBuffer dOpsBox(Format format) {
        Assertions.checkArgument(!format.initializationData.isEmpty(), "csd-0 not found in the format for dOps box.");
        byte[] bArr = format.initializationData.get(0);
        Assertions.checkArgument(bArr.length >= 8, "As csd0 contains 'OpusHead' in first 8 bytes, csd0 length should be greater than 8");
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length);
        byteBufferAllocate.put(bArr, 8, bArr.length - 8);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("dOps", byteBufferAllocate);
    }

    private static ByteBuffer damrBox(short s) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(200);
        byteBufferAllocate.put("    ".getBytes(StandardCharsets.UTF_8));
        byteBufferAllocate.put((byte) 0);
        byteBufferAllocate.putShort(s);
        byteBufferAllocate.put((byte) 0);
        byteBufferAllocate.put((byte) 1);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("damr", byteBufferAllocate);
    }

    public static ByteBuffer dinf(ByteBuffer byteBuffer) {
        return BoxUtils.wrapIntoBox("dinf", byteBuffer);
    }

    private static ByteBuffer doviBox(int i, byte[] bArr) {
        Assertions.checkArgument(bArr.length > 0, "csd is empty for dovi box.");
        return i <= 7 ? BoxUtils.wrapIntoBox("dvcC", ByteBuffer.wrap(bArr)) : i <= 10 ? BoxUtils.wrapIntoBox("dvvC", ByteBuffer.wrap(bArr)) : i <= 19 ? BoxUtils.wrapIntoBox("dvwC", ByteBuffer.wrap(bArr)) : i == 20 ? BoxUtils.wrapIntoBox("dvcC", ByteBuffer.wrap(bArr)) : BoxUtils.wrapIntoBox("dvwC", ByteBuffer.wrap(bArr));
    }

    private static ByteBuffer doviSpecificBox(Format format) {
        Assertions.checkArgument(!format.initializationData.isEmpty(), "csd is not found in the format for dolby vision");
        byte[] bArr = (byte[]) bv2.g(format.initializationData);
        DolbyVisionConfig dolbyVisionConfig = getDolbyVisionConfig(format);
        Assertions.checkNotNull(dolbyVisionConfig, "Dolby vision codec is not supported.");
        return BoxUtils.concatenateBuffers(dolbyVisionConfig.profile <= 8 ? hvcCBox(format) : avcCBox(format), doviBox(dolbyVisionConfig.profile, bArr));
    }

    public static ByteBuffer dref(ByteBuffer... byteBufferArr) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(byteBufferArr.length);
        byteBufferAllocate.flip();
        ArrayList arrayList = new ArrayList();
        arrayList.add(byteBufferAllocate);
        Collections.addAll(arrayList, byteBufferArr);
        return BoxUtils.wrapBoxesIntoBox("dref", arrayList);
    }

    public static ByteBuffer edts(long j, long j2, long j3, long j4, long j5) {
        long j6 = j2 > 0 ? j - j2 : j;
        return j6 != 0 ? BoxUtils.wrapIntoBox("edts", elst(j6, j3, j4, j5)) : ByteBuffer.allocate(0);
    }

    private static ByteBuffer elst(long j, long j2, long j3, long j4) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(50);
        byteBufferAllocate.putInt(16777216);
        if (j > 0) {
            byteBufferAllocate.putInt(2);
            byteBufferAllocate.put(elstEntry(vuFromUs(j, j3), -1L, 1, 0));
            byteBufferAllocate.put(elstEntry(vuFromUs(j2, j3), 0L, 1, 0));
        } else {
            byteBufferAllocate.putInt(1);
            byteBufferAllocate.put(elstEntry(vuFromUs(j2, j3), vuFromUs(Math.abs(j), j4), 1, 0));
        }
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("elst", byteBufferAllocate);
    }

    private static ByteBuffer elstEntry(long j, long j2, int i, int i2) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(20);
        byteBufferAllocate.putLong(j);
        byteBufferAllocate.putLong(j2);
        byteBufferAllocate.putShort((short) i);
        byteBufferAllocate.putShort((short) i2);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    private static ByteBuffer esdsBox(Format format) {
        Assertions.checkArgument(!format.initializationData.isEmpty(), "csd-0 not found in the format for esds box.");
        byte[] bArr = format.initializationData.get(0);
        Assertions.checkArgument(bArr.length > 0, "csd-0 is empty for esds box.");
        String str = (String) Assertions.checkNotNull(format.sampleMimeType);
        ByteBuffer vorbisInitializationData = str.equals("audio/vorbis") ? getVorbisInitializationData(format) : ByteBuffer.wrap(bArr);
        int i = format.peakBitrate;
        int i2 = format.averageBitrate;
        boolean zIsVideo = MimeTypes.isVideo(str);
        int iRemaining = vorbisInitializationData.remaining();
        ByteBuffer sizeBuffer = getSizeBuffer(iRemaining);
        ByteBuffer sizeBuffer2 = getSizeBuffer(sizeBuffer.remaining() + iRemaining + 14);
        ByteBuffer sizeBuffer3 = getSizeBuffer(sizeBuffer.remaining() + iRemaining + sizeBuffer2.remaining() + 21);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iRemaining + 200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.put((byte) 3);
        byteBufferAllocate.put(sizeBuffer3);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.put(zIsVideo ? TELogUtils.DEBUG_LEVEL_V : (byte) 0);
        byteBufferAllocate.put((byte) 4);
        byteBufferAllocate.put(sizeBuffer2);
        byteBufferAllocate.put(((Byte) Assertions.checkNotNull(MimeTypes.getMp4ObjectTypeFromMimeType(str))).byteValue());
        byteBufferAllocate.put((byte) ((zIsVideo ? 16 : 20) | 1));
        byteBufferAllocate.putShort((short) (((zIsVideo ? 96000 : 768) >> 8) & 65535));
        byteBufferAllocate.put((byte) 0);
        if (i == -1) {
            i = 0;
        }
        byteBufferAllocate.putInt(i);
        byteBufferAllocate.putInt(i2 != -1 ? i2 : 0);
        byteBufferAllocate.put((byte) 5);
        byteBufferAllocate.put(sizeBuffer);
        byteBufferAllocate.put(vorbisInitializationData);
        vorbisInitializationData.rewind();
        byteBufferAllocate.put((byte) 6);
        byteBufferAllocate.put((byte) 1);
        byteBufferAllocate.put((byte) 2);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("esds", byteBufferAllocate);
    }

    private static long findMinimumPresentationTimestampUsAcrossTracks(List<Track> list) {
        long jMin = Long.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            Track track = list.get(i);
            if (!track.writtenSamples.isEmpty()) {
                jMin = Math.min(track.writtenSamples.get(0).presentationTimeUs, jMin);
            }
        }
        if (jMin != Long.MAX_VALUE) {
            return jMin;
        }
        return -9223372036854775807L;
    }

    public static ByteBuffer ftyp() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ByteBuffer.wrap(Util.getUtf8Bytes("isom")));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.putInt(131072);
        byteBufferAllocate.flip();
        arrayList.add(byteBufferAllocate);
        String[] strArr = {"isom", "iso2", "mp41"};
        for (int i = 0; i < 3; i++) {
            arrayList.add(ByteBuffer.wrap(Util.getUtf8Bytes(strArr[i])));
        }
        return BoxUtils.wrapBoxesIntoBox("ftyp", arrayList);
    }

    public static ByteBuffer getAxteBoxHeader(long j) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
        byteBufferAllocate.putInt(1);
        byteBufferAllocate.put(Util.getUtf8Bytes("axte"));
        byteBufferAllocate.putLong(j + 16);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    @Nullable
    private static DolbyVisionConfig getDolbyVisionConfig(Format format) {
        DolbyVisionConfig dolbyVisionConfig = DolbyVisionConfig.parse(new ParsableByteArray((byte[]) bv2.g(format.initializationData)));
        if (dolbyVisionConfig != null || format.codecs == null) {
            return dolbyVisionConfig;
        }
        Pair<Integer, Integer> dolbyVisionProfileAndLevel = getDolbyVisionProfileAndLevel(format);
        Assertions.checkNotNull(dolbyVisionProfileAndLevel, "Dolby Vision profile and level is not found.");
        return DolbyVisionConfig.parse(new ParsableByteArray(CodecSpecificDataUtil.buildDolbyVisionInitializationData(((Integer) dolbyVisionProfileAndLevel.first).intValue(), ((Integer) dolbyVisionProfileAndLevel.second).intValue())));
    }

    @Nullable
    public static Pair<Integer, Integer> getDolbyVisionProfileAndLevel(Format format) {
        Assertions.checkNotNull(format.codecs, "Codec string is null for Dolby Vision format.");
        List<String> listF = jh5.d('.').f(format.codecs);
        if (listF.size() >= 3) {
            return Pair.create(Integer.valueOf(Integer.parseInt(listF.get(1))), Integer.valueOf(Integer.parseInt(listF.get(2))));
        }
        Log.w(TAG, "Invalid Dolby Vision codec string: " + format.codecs);
        return null;
    }

    private static String getDoviFourcc(Format format) {
        DolbyVisionConfig dolbyVisionConfig = getDolbyVisionConfig(format);
        Assertions.checkNotNull(dolbyVisionConfig, "Dolby Vision Initialization data is not found for format: %s" + format.sampleMimeType);
        int i = dolbyVisionConfig.profile;
        if (i == 5) {
            return "dvh1";
        }
        if (i == 8) {
            return "hvc1";
        }
        if (i == 9) {
            return "avc1";
        }
        throw new IllegalArgumentException("Unsupported profile " + dolbyVisionConfig.profile + " for format: " + format.sampleMimeType);
    }

    private static int getLastSampleDurationVu(List<Integer> list, int i, int i2) {
        if (i == 0) {
            return 0;
        }
        if (i != 1) {
            throw new IllegalArgumentException("Unexpected value for the last frame duration behavior " + i);
        }
        if (i2 != -1) {
            return i2;
        }
        if (list.size() < 2) {
            return 0;
        }
        return ((Integer) bv2.g(list)).intValue();
    }

    private static ByteBuffer getSizeBuffer(int i) {
        ArrayDeque arrayDeque = new ArrayDeque();
        int i2 = 0;
        while (true) {
            arrayDeque.push(Byte.valueOf((byte) (i2 | (i & 127))));
            i >>= 7;
            if (i <= 0) {
                break;
            }
            i2 = 128;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(arrayDeque.size());
        while (!arrayDeque.isEmpty()) {
            byteBufferAllocate.put(((Byte) arrayDeque.removeFirst()).byteValue());
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public static int getTrunBoxContentSize(int i, boolean z) {
        return ((z ? 4 : 3) * i * 4) + 12;
    }

    private static ByteBuffer getVorbisInitializationData(Format format) {
        Assertions.checkArgument(format.initializationData.size() > 1, "csd-1 should contain setup header for Vorbis.");
        byte[] bArr = format.initializationData.get(0);
        int length = (bArr.length / 255) + 1;
        byte[] bArr2 = new byte[length];
        Arrays.fill(bArr2, (byte) -1);
        bArr2[length - 1] = (byte) (bArr.length % 255);
        byte[] bArr3 = format.initializationData.get(1);
        Assertions.checkArgument(bArr3.length > 0, "csd-1 should be present and contain setup header for Vorbis.");
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length + bArr.length + bArr3.length + 2);
        byteBufferAllocate.put((byte) 2);
        byteBufferAllocate.put(bArr2);
        byteBufferAllocate.put((byte) 0);
        byteBufferAllocate.put(bArr);
        byteBufferAllocate.put(bArr3);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public static ByteBuffer hdlr(String str, String str2) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.put(Util.getUtf8Bytes(str));
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.put(Util.getUtf8Bytes(str2));
        byteBufferAllocate.put((byte) 0);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("hdlr", byteBufferAllocate);
    }

    private static ByteBuffer hvcCBox(Format format) {
        Assertions.checkArgument(!format.initializationData.isEmpty(), "csd-0 not found in the format for hvcC box.");
        byte[] bArr = format.initializationData.get(0);
        Assertions.checkArgument(bArr.length > 0, "csd-0 is empty for hvcC box.");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBufferWrap.limit() + 200);
        ImmutableList<ByteBuffer> immutableListFindNalUnits = AnnexBUtils.findNalUnits(byteBufferWrap);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < immutableListFindNalUnits.size(); i++) {
            arrayList.add(AnnexBUtils.stripEmulationPrevention(immutableListFindNalUnits.get(i)));
        }
        byteBufferAllocate.put((byte) 1);
        ByteBuffer byteBuffer = (ByteBuffer) arrayList.get(0);
        if (byteBuffer.get(byteBuffer.position()) != 64) {
            throw new IllegalArgumentException("First NALU in csd-0 is not the VPS.");
        }
        byteBufferAllocate.put(byteBuffer.get(6));
        byteBufferAllocate.putInt(byteBuffer.getInt(7));
        byteBufferAllocate.putInt(byteBuffer.getInt(11));
        byteBufferAllocate.putShort(byteBuffer.getShort(15));
        byteBufferAllocate.put(byteBuffer.get(17));
        byteBufferAllocate.putShort((short) -4096);
        byteBufferAllocate.put((byte) -4);
        ByteBuffer byteBuffer2 = immutableListFindNalUnits.get(1);
        int iRemaining = byteBuffer2.remaining();
        byte[] bArr2 = new byte[iRemaining];
        byteBuffer2.get(bArr2);
        byteBuffer2.rewind();
        NalUnitUtil.H265SpsData h265SpsNalUnit = NalUnitUtil.parseH265SpsNalUnit(bArr2, 0, iRemaining, null);
        byte b = (byte) (h265SpsNalUnit.chromaFormatIdc | MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF);
        byte b2 = (byte) (h265SpsNalUnit.bitDepthLumaMinus8 | MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT);
        byte b3 = (byte) (h265SpsNalUnit.bitDepthChromaMinus8 | MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT);
        byteBufferAllocate.put(b);
        byteBufferAllocate.put(b2);
        byteBufferAllocate.put(b3);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.put((byte) 15);
        byteBufferAllocate.put((byte) immutableListFindNalUnits.size());
        for (int i2 = 0; i2 < immutableListFindNalUnits.size(); i2++) {
            ByteBuffer byteBuffer3 = immutableListFindNalUnits.get(i2);
            byteBufferAllocate.put((byte) ((byteBuffer3.get(0) >> 1) & 63));
            byteBufferAllocate.putShort((short) 1);
            byteBufferAllocate.putShort((short) byteBuffer3.limit());
            byteBufferAllocate.put(byteBuffer3);
        }
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("hvcC", byteBufferAllocate);
    }

    public static ByteBuffer ilst(List<MdtaMetadataEntry> list) {
        int i = 0;
        int length = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            length += list.get(i2).value.length + 16 + 8;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        while (i < list.size()) {
            int i3 = i + 1;
            MdtaMetadataEntry mdtaMetadataEntry = list.get(i);
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(mdtaMetadataEntry.value.length + 8);
            byteBufferAllocate2.putInt(mdtaMetadataEntry.typeIndicator);
            byteBufferAllocate2.putInt(mdtaMetadataEntry.localeIndicator);
            byteBufferAllocate2.put(mdtaMetadataEntry.value);
            byteBufferAllocate2.flip();
            ByteBuffer byteBufferWrapIntoBox = BoxUtils.wrapIntoBox("data", byteBufferAllocate2);
            byteBufferAllocate.putInt(byteBufferWrapIntoBox.remaining() + 8);
            byteBufferAllocate.putInt(i3);
            byteBufferAllocate.put(byteBufferWrapIntoBox);
            i = i3;
        }
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("ilst", byteBufferAllocate);
    }

    public static ByteBuffer keys(List<MdtaMetadataEntry> list) {
        int length = 0;
        for (int i = 0; i < list.size(); i++) {
            length += list.get(i).key.length() + 8;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length + 8);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            byteBufferAllocate.put(BoxUtils.wrapIntoBox("mdta", ByteBuffer.wrap(Util.getUtf8Bytes(list.get(i2).key))));
        }
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("keys", byteBufferAllocate);
    }

    private static short languageCodeFromString(@Nullable String str) {
        if (str == null) {
            return (short) 0;
        }
        byte[] utf8Bytes = Util.getUtf8Bytes(str);
        if (utf8Bytes.length != 3) {
            return (short) 0;
        }
        return (short) (((utf8Bytes[2] & TELogUtils.DEBUG_LEVEL_V) + ((utf8Bytes[1] & TELogUtils.DEBUG_LEVEL_V) << 5) + ((utf8Bytes[0] & TELogUtils.DEBUG_LEVEL_V) << 10)) & 32767);
    }

    public static ByteBuffer localUrl() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.putInt(1);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("url ", byteBufferAllocate);
    }

    public static ByteBuffer mdhd(long j, int i, int i2, int i3, @Nullable String str) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(i2);
        byteBufferAllocate.putInt(i3);
        byteBufferAllocate.putInt(i);
        byteBufferAllocate.putInt((int) j);
        byteBufferAllocate.putShort(languageCodeFromString(str));
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("mdhd", byteBufferAllocate);
    }

    public static ByteBuffer mdia(ByteBuffer... byteBufferArr) {
        return BoxUtils.wrapBoxesIntoBox("mdia", Arrays.asList(byteBufferArr));
    }

    public static ByteBuffer meta(ByteBuffer... byteBufferArr) {
        return BoxUtils.wrapBoxesIntoBox("meta", Arrays.asList(byteBufferArr));
    }

    public static ByteBuffer mfhd(int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(i);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("mfhd", byteBufferAllocate);
    }

    public static ByteBuffer minf(ByteBuffer... byteBufferArr) {
        return BoxUtils.wrapBoxesIntoBox("minf", Arrays.asList(byteBufferArr));
    }

    public static ByteBuffer moof(ByteBuffer byteBuffer, List<ByteBuffer> list) {
        return BoxUtils.wrapBoxesIntoBox("moof", new ImmutableList.a().a(byteBuffer).l(list).e());
    }

    public static ByteBuffer moov(List<Track> list, MetadataCollector metadataCollector, boolean z, int i) {
        long j;
        int i2;
        String str;
        ByteBuffer byteBufferNmhd;
        ByteBuffer byteBufferStbl;
        String str2;
        int i3;
        ArrayList arrayList;
        ArrayList arrayList2;
        int i4;
        ByteBuffer byteBufferSmhd;
        ByteBuffer byteBufferStbl2;
        String str3;
        String str4;
        MetadataCollector metadataCollector2 = metadataCollector;
        Mp4TimestampData mp4TimestampData = metadataCollector2.timestampData;
        int i5 = (int) mp4TimestampData.creationTimestampSeconds;
        int i6 = (int) mp4TimestampData.modificationTimestampSeconds;
        long jFindMinimumPresentationTimestampUsAcrossTracks = findMinimumPresentationTimestampUsAcrossTracks(list);
        if (!z && jFindMinimumPresentationTimestampUsAcrossTracks == -9223372036854775807L) {
            return ByteBuffer.allocate(0);
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        long jMax = 0;
        int i7 = 1;
        int i8 = 0;
        while (i8 < list.size()) {
            Track track = list.get(i8);
            if (z || !track.writtenSamples.isEmpty()) {
                Format format = track.format;
                Format formatBuild = (Objects.equals(format.sampleMimeType, "video/av01") && format.initializationData.isEmpty()) ? format.buildUpon().setInitializationData(ImmutableList.of((byte[]) Assertions.checkNotNull(track.parsedCsd))).build() : format;
                String strBcp47LanguageTagToIso3 = bcp47LanguageTagToIso3(formatBuild.language);
                long j2 = jMax;
                ArrayList arrayList5 = arrayList3;
                List<Integer> listConvertPresentationTimestampsToDurationsVu = convertPresentationTimestampsToDurationsVu(track.writtenSamples, track.videoUnitTimebase(), i, track.endOfStreamTimestampUs);
                long jIntValue = 0;
                int i9 = 0;
                while (i9 < listConvertPresentationTimestampsToDurationsVu.size()) {
                    jIntValue += (long) listConvertPresentationTimestampsToDurationsVu.get(i9).intValue();
                    i9++;
                    arrayList4 = arrayList4;
                }
                ArrayList arrayList6 = arrayList4;
                long j3 = track.writtenSamples.isEmpty() ? 0L : track.writtenSamples.get(0).presentationTimeUs;
                j = jFindMinimumPresentationTimestampUsAcrossTracks;
                long jUsFromVu = usFromVu(jIntValue, track.videoUnitTimebase());
                if (j3 < 0) {
                    jUsFromVu -= Math.abs(j3);
                }
                long j4 = jUsFromVu;
                int trackType = MimeTypes.getTrackType(formatBuild.sampleMimeType);
                ByteBuffer byteBufferStts = stts(listConvertPresentationTimestampsToDurationsVu);
                long j5 = jIntValue;
                ByteBuffer byteBufferCtts = MimeTypes.isVideo(formatBuild.sampleMimeType) ? ctts(track.writtenSamples, listConvertPresentationTimestampsToDurationsVu, track.videoUnitTimebase()) : ByteBuffer.allocate(0);
                ByteBuffer byteBufferStsz = stsz(track.writtenSamples);
                ByteBuffer byteBufferStsc = stsc(track.writtenChunkSampleCounts);
                int i10 = i8;
                List<Long> list2 = track.writtenChunkOffsets;
                ByteBuffer byteBufferStco = z ? stco(list2) : co64(list2);
                long j6 = j3;
                if (trackType == -1 || trackType == 5) {
                    i2 = 3;
                    str = "MetaHandle";
                    byteBufferNmhd = nmhd();
                    byteBufferStbl = stbl(stsd(textMetaDataSampleEntry(formatBuild)), byteBufferStts, byteBufferStsz, byteBufferStsc, byteBufferStco);
                    str2 = "meta";
                } else {
                    if (trackType == 1) {
                        byteBufferSmhd = smhd();
                        byteBufferStbl2 = stbl(stsd(audioSampleEntry(formatBuild)), byteBufferStts, byteBufferStsz, byteBufferStsc, byteBufferStco);
                        str3 = "soun";
                        str4 = "SoundHandle";
                    } else {
                        if (trackType != 2) {
                            throw new IllegalArgumentException("Unsupported track type");
                        }
                        byteBufferSmhd = vmhd();
                        byteBufferStbl2 = stbl(stsd(videoSampleEntry(formatBuild)), byteBufferStts, byteBufferCtts, byteBufferStsz, byteBufferStsc, byteBufferStco, stss(track.writtenSamples));
                        str3 = "vide";
                        str4 = "VideoHandle";
                    }
                    byteBufferNmhd = byteBufferSmhd;
                    byteBufferStbl = byteBufferStbl2;
                    str2 = str3;
                    str = str4;
                    i2 = 3;
                }
                ByteBuffer[] byteBufferArr = new ByteBuffer[i2];
                int i11 = i7;
                i3 = i10;
                byteBufferArr[0] = tkhd(i7, j4, i5, i6, metadataCollector2.orientationData.orientation, formatBuild);
                arrayList = arrayList5;
                byteBufferArr[1] = edts(j6, j, j4, 10000L, track.videoUnitTimebase());
                byteBufferArr[2] = mdia(mdhd(j5, track.videoUnitTimebase(), i5, i6, strBcp47LanguageTagToIso3), hdlr(str2, str), minf(byteBufferNmhd, dinf(dref(localUrl())), byteBufferStbl));
                arrayList.add(trak(byteBufferArr));
                jMax = Math.max(j2, j4);
                arrayList2 = arrayList6;
                arrayList2.add(trex(i11));
                i4 = i11 + 1;
            } else {
                i4 = i7;
                i3 = i8;
                arrayList = arrayList3;
                arrayList2 = arrayList4;
                j = jFindMinimumPresentationTimestampUsAcrossTracks;
            }
            i8 = i3 + 1;
            arrayList3 = arrayList;
            arrayList4 = arrayList2;
            jFindMinimumPresentationTimestampUsAcrossTracks = j;
            metadataCollector2 = metadataCollector;
            i7 = i4;
        }
        int i12 = i7;
        ArrayList arrayList7 = arrayList3;
        ArrayList arrayList8 = arrayList4;
        ByteBuffer byteBufferMvhd = mvhd(i12, i5, i6, jMax);
        ByteBuffer byteBufferUdta = udta(metadataCollector.locationData);
        ByteBuffer byteBufferAllocate = metadataCollector.metadataEntries.isEmpty() ? ByteBuffer.allocate(0) : meta(hdlr("mdta", ""), keys(d43.i(metadataCollector.metadataEntries)), ilst(d43.i(metadataCollector.metadataEntries)));
        ArrayList arrayList9 = new ArrayList();
        arrayList9.add(byteBufferMvhd);
        arrayList9.add(byteBufferUdta);
        arrayList9.add(byteBufferAllocate);
        arrayList9.addAll(arrayList7);
        if (z) {
            arrayList9.add(mvex(arrayList8));
        }
        ByteBuffer byteBufferWrapBoxesIntoBox = BoxUtils.wrapBoxesIntoBox("moov", arrayList9);
        XmpData xmpData = metadataCollector.xmpData;
        return xmpData != null ? BoxUtils.concatenateBuffers(byteBufferWrapBoxesIntoBox, uuid(XMP_UUID, ByteBuffer.wrap(xmpData.data))) : byteBufferWrapBoxesIntoBox;
    }

    public static ByteBuffer mvex(List<ByteBuffer> list) {
        return BoxUtils.wrapBoxesIntoBox("mvex", list);
    }

    public static ByteBuffer mvhd(int i, int i2, int i3, long j) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(i2);
        byteBufferAllocate.putInt(i3);
        byteBufferAllocate.putInt(10000);
        byteBufferAllocate.putInt((int) vuFromUs(j, 10000L));
        byteBufferAllocate.putInt(65536);
        byteBufferAllocate.putShort((short) 256);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        int[] iArr = {65536, 0, 0, 0, 65536, 0, 0, 0, 1073741824};
        for (int i4 = 0; i4 < 9; i4++) {
            byteBufferAllocate.putInt(iArr[i4]);
        }
        for (int i5 = 0; i5 < 6; i5++) {
            byteBufferAllocate.putInt(0);
        }
        byteBufferAllocate.putInt(i);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("mvhd", byteBufferAllocate);
    }

    public static ByteBuffer nmhd() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("nmhd", byteBufferAllocate);
    }

    private static ByteBuffer parseVp9CodecPrivateFromCsd(byte[] bArr, int i) {
        byte b = 0;
        int i2 = 0;
        byte b2 = 10;
        int i3 = 8;
        for (int i4 = 0; i4 < bArr.length; i4 += 3) {
            byte b3 = bArr[i4];
            int i5 = i4 + 2;
            if (b3 == 1) {
                b = bArr[i5];
            } else if (b3 == 2) {
                b2 = bArr[i5];
            } else if (b3 == 3) {
                i3 = bArr[i5];
            } else if (b3 == 4) {
                i2 = bArr[i5];
            }
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(3);
        byteBufferAllocate.put(b);
        byteBufferAllocate.put(b2);
        byteBufferAllocate.put((byte) (i | (i3 << 4) | (i2 << 1)));
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    private static ByteBuffer paspBox() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.putInt(65536);
        byteBufferAllocate.putInt(65536);
        byteBufferAllocate.rewind();
        return BoxUtils.wrapIntoBox("pasp", byteBufferAllocate);
    }

    private static byte[] rotationMatrixFromOrientation(int i) {
        if (i == 0) {
            return Util.toByteArray(65536, 0, 0, 0, 65536, 0, 0, 0, 1073741824);
        }
        if (i == 90) {
            return Util.toByteArray(0, 65536, 0, SupportMenu.CATEGORY_MASK, 0, 0, 0, 0, 1073741824);
        }
        if (i == 180) {
            return Util.toByteArray(SupportMenu.CATEGORY_MASK, 0, 0, 0, SupportMenu.CATEGORY_MASK, 0, 0, 0, 1073741824);
        }
        if (i == 270) {
            return Util.toByteArray(0, SupportMenu.CATEGORY_MASK, 0, 65536, 0, 0, 0, 0, 1073741824);
        }
        throw new IllegalArgumentException("invalid orientation " + i);
    }

    private static ByteBuffer smDmBox(ColorInfo colorInfo) {
        byte[] bArr = colorInfo.hdrStaticInfo;
        if (bArr == null) {
            return ByteBuffer.allocate(0);
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.put(bArr);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("SmDm", byteBufferAllocate);
    }

    public static ByteBuffer smhd() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("smhd", byteBufferAllocate);
    }

    public static ByteBuffer stbl(ByteBuffer... byteBufferArr) {
        return BoxUtils.wrapBoxesIntoBox("stbl", Arrays.asList(byteBufferArr));
    }

    public static ByteBuffer stco(List<Long> list) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((list.size() * 4) + 8);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(list.size());
        for (int i = 0; i < list.size(); i++) {
            long jLongValue = list.get(i).longValue();
            Assertions.checkState(jLongValue <= MuxerUtil.UNSIGNED_INT_MAX_VALUE, "Only 32-bit chunk offset is allowed");
            byteBufferAllocate.putInt((int) jLongValue);
        }
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("stco", byteBufferAllocate);
    }

    public static ByteBuffer stsc(List<Integer> list) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((list.size() * 12) + 200);
        byteBufferAllocate.putInt(0);
        int iPosition = byteBufferAllocate.position();
        byteBufferAllocate.putInt(0);
        int i = 0;
        int i2 = -1;
        int i3 = 1;
        for (int i4 = 0; i4 < list.size(); i4++) {
            int iIntValue = list.get(i4).intValue();
            if (iIntValue != i2) {
                byteBufferAllocate.putInt(i3);
                byteBufferAllocate.putInt(iIntValue);
                byteBufferAllocate.putInt(1);
                i++;
                i2 = iIntValue;
            }
            i3++;
        }
        byteBufferAllocate.putInt(iPosition, i);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("stsc", byteBufferAllocate);
    }

    public static ByteBuffer stsd(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.limit() + 200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(1);
        byteBufferAllocate.put(byteBuffer);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("stsd", byteBufferAllocate);
    }

    public static ByteBuffer stss(List<BufferInfo> list) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((list.size() * 4) + 200);
        byteBufferAllocate.putInt(0);
        int iPosition = byteBufferAllocate.position();
        byteBufferAllocate.putInt(list.size());
        int i = 0;
        int i2 = 1;
        for (int i3 = 0; i3 < list.size(); i3++) {
            if ((list.get(i3).flags & 1) > 0) {
                byteBufferAllocate.putInt(i2);
                i++;
            }
            i2++;
        }
        byteBufferAllocate.putInt(iPosition, i);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("stss", byteBufferAllocate);
    }

    public static ByteBuffer stsz(List<BufferInfo> list) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((list.size() * 4) + 200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(list.size());
        for (int i = 0; i < list.size(); i++) {
            byteBufferAllocate.putInt(list.get(i).size);
        }
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("stsz", byteBufferAllocate);
    }

    public static ByteBuffer stts(List<Integer> list) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((list.size() * 8) + 200);
        byteBufferAllocate.putInt(0);
        int iPosition = byteBufferAllocate.position();
        byteBufferAllocate.putInt(0);
        long j = -1;
        int i = 0;
        int i2 = -1;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int iIntValue = list.get(i3).intValue();
            long j2 = iIntValue;
            if (j != j2) {
                int iPosition2 = byteBufferAllocate.position();
                byteBufferAllocate.putInt(1);
                byteBufferAllocate.putInt(iIntValue);
                i++;
                i2 = iPosition2;
                j = j2;
            } else {
                byteBufferAllocate.putInt(i2, byteBufferAllocate.getInt(i2) + 1);
            }
        }
        byteBufferAllocate.putInt(iPosition, i);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("stts", byteBufferAllocate);
    }

    public static ByteBuffer textMetaDataSampleEntry(Format format) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(200);
        byte[] utf8Bytes = Util.getUtf8Bytes((String) Assertions.checkNotNull(format.sampleMimeType));
        byteBufferAllocate.put(utf8Bytes);
        byteBufferAllocate.put((byte) 0);
        byteBufferAllocate.put(utf8Bytes);
        byteBufferAllocate.put((byte) 0);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("mett", byteBufferAllocate);
    }

    public static ByteBuffer tfhd(int i, long j) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
        byteBufferAllocate.putInt(1);
        byteBufferAllocate.putInt(i);
        byteBufferAllocate.putLong(j);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("tfhd", byteBufferAllocate);
    }

    public static ByteBuffer tkhd(int i, long j, int i2, int i3, int i4, Format format) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(200);
        byteBufferAllocate.putInt(7);
        byteBufferAllocate.putInt(i2);
        byteBufferAllocate.putInt(i3);
        byteBufferAllocate.putInt(i);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt((int) vuFromUs(j, 10000L));
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putShort(MimeTypes.isAudio(format.sampleMimeType) ? (short) 256 : (short) 0);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.put(rotationMatrixFromOrientation(i4));
        int i5 = format.width;
        if (i5 == -1) {
            i5 = 0;
        }
        int i6 = format.height;
        int i7 = i6 != -1 ? i6 : 0;
        byteBufferAllocate.putInt(i5 << 16);
        byteBufferAllocate.putInt(i7 << 16);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("tkhd", byteBufferAllocate);
    }

    public static ByteBuffer traf(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        return BoxUtils.wrapBoxesIntoBox("traf", ImmutableList.of(byteBuffer, byteBuffer2));
    }

    public static ByteBuffer trak(ByteBuffer... byteBufferArr) {
        return BoxUtils.wrapBoxesIntoBox("trak", Arrays.asList(byteBufferArr));
    }

    public static ByteBuffer trex(int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(i);
        byteBufferAllocate.putInt(1);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("trex", byteBufferAllocate);
    }

    public static ByteBuffer trun(Format format, List<FragmentedMp4Writer.SampleMetadata> list, int i, boolean z) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(getTrunBoxContentSize(list.size(), z));
        byteBufferAllocate.putInt(z ? 16781057 : 16779009);
        byteBufferAllocate.putInt(list.size());
        byteBufferAllocate.putInt(i);
        boolean zAllSamplesAreSyncSamples = MimeTypes.allSamplesAreSyncSamples(format.sampleMimeType, format.codecs);
        for (int i2 = 0; i2 < list.size(); i2++) {
            FragmentedMp4Writer.SampleMetadata sampleMetadata = list.get(i2);
            byteBufferAllocate.putInt(sampleMetadata.durationVu);
            byteBufferAllocate.putInt(sampleMetadata.size);
            boolean z2 = true;
            if ((sampleMetadata.flags & 1) == 0 && !zAllSamplesAreSyncSamples) {
                z2 = false;
            }
            byteBufferAllocate.putInt(z2 ? TRUN_BOX_SYNC_SAMPLE_FLAGS : 16842752);
            if (z) {
                byteBufferAllocate.putInt(sampleMetadata.compositionTimeOffsetVu);
            }
        }
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("trun", byteBufferAllocate);
    }

    public static ByteBuffer udta(@Nullable Mp4LocationData mp4LocationData) {
        if (mp4LocationData == null) {
            return ByteBuffer.allocate(0);
        }
        String invariant = Util.formatInvariant("%+.4f%+.4f/", Float.valueOf(mp4LocationData.latitude), Float.valueOf(mp4LocationData.longitude));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(invariant.length() + 2 + 2);
        byteBufferAllocate.putShort((short) (byteBufferAllocate.capacity() - 4));
        byteBufferAllocate.putShort((short) 5575);
        byteBufferAllocate.put(Util.getUtf8Bytes(invariant));
        Assertions.checkState(byteBufferAllocate.limit() == byteBufferAllocate.capacity());
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("udta", BoxUtils.wrapIntoBox(new byte[]{-87, 120, 121, 122}, byteBufferAllocate));
    }

    private static long usFromVu(long j, long j2) {
        return Util.scaleLargeValue(j, 1000000L, j2, RoundingMode.HALF_UP);
    }

    public static ByteBuffer uuid(List<Byte> list, ByteBuffer byteBuffer) {
        Assertions.checkArgument(byteBuffer.remaining() > 0);
        return BoxUtils.wrapBoxesIntoBox(Constant.MAP_KEY_UUID, ImmutableList.of(ByteBuffer.wrap(vv.f(list)), byteBuffer));
    }

    public static ByteBuffer videoSampleEntry(Format format) {
        ByteBuffer byteBufferCodecSpecificBox = codecSpecificBox(format);
        String strCodecSpecificFourcc = codecSpecificFourcc(format);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBufferCodecSpecificBox.limit() + 200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putShort((short) 1);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        int i = format.width;
        byteBufferAllocate.putShort(i != -1 ? (short) i : (short) 0);
        int i2 = format.height;
        byteBufferAllocate.putShort(i2 != -1 ? (short) i2 : (short) 0);
        byteBufferAllocate.putInt(4718592);
        byteBufferAllocate.putInt(4718592);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putShort((short) 1);
        byteBufferAllocate.putLong(0L);
        byteBufferAllocate.putLong(0L);
        byteBufferAllocate.putLong(0L);
        byteBufferAllocate.putLong(0L);
        byteBufferAllocate.putShort((short) 24);
        byteBufferAllocate.putShort((short) -1);
        byteBufferAllocate.put(byteBufferCodecSpecificBox);
        if (format.colorInfo != null && strCodecSpecificFourcc.equals("vp09")) {
            byteBufferAllocate.put(smDmBox(format.colorInfo));
        }
        byteBufferAllocate.put(paspBox());
        ColorInfo colorInfo = format.colorInfo;
        if (colorInfo != null) {
            byteBufferAllocate.put(colrBox(colorInfo));
        }
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox(strCodecSpecificFourcc, byteBufferAllocate);
    }

    public static ByteBuffer vmhd() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("vmhd", byteBufferAllocate);
    }

    private static ByteBuffer vpcCBox(Format format) {
        int i;
        int iColorSpaceToIsoMatrixCoefficients;
        int iColorTransferToIsoTransferCharacteristics;
        int iColorSpaceToIsoColorPrimaries = 1;
        Assertions.checkArgument(!format.initializationData.isEmpty(), "csd-0 is not found in the format for vpcC box");
        byte[] bArr = format.initializationData.get(0);
        Assertions.checkArgument(bArr.length > 3, "csd-0 for vp9 is invalid.");
        if (ku2.i(bArr) == 16777216) {
            return BoxUtils.wrapIntoBox("vpcC", ByteBuffer.wrap(bArr));
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(200);
        byteBufferAllocate.putInt(16777216);
        ColorInfo colorInfo = format.colorInfo;
        if (colorInfo == null || (i = colorInfo.colorRange) == -1) {
            i = 0;
        }
        byteBufferAllocate.put(parseVp9CodecPrivateFromCsd(bArr, i));
        ColorInfo colorInfo2 = format.colorInfo;
        if (colorInfo2 != null) {
            iColorSpaceToIsoColorPrimaries = ColorInfo.colorSpaceToIsoColorPrimaries(colorInfo2.colorSpace);
            iColorTransferToIsoTransferCharacteristics = ColorInfo.colorTransferToIsoTransferCharacteristics(format.colorInfo.colorTransfer);
            iColorSpaceToIsoMatrixCoefficients = ColorInfo.colorSpaceToIsoMatrixCoefficients(format.colorInfo.colorSpace);
        } else {
            iColorSpaceToIsoMatrixCoefficients = 1;
            iColorTransferToIsoTransferCharacteristics = 1;
        }
        byteBufferAllocate.put((byte) iColorSpaceToIsoColorPrimaries);
        byteBufferAllocate.put((byte) iColorTransferToIsoTransferCharacteristics);
        byteBufferAllocate.put((byte) iColorSpaceToIsoMatrixCoefficients);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.flip();
        return BoxUtils.wrapIntoBox("vpcC", byteBufferAllocate);
    }

    private static long vuFromUs(long j, long j2) {
        return Util.scaleLargeValue(j, j2, 1000000L, RoundingMode.HALF_UP);
    }
}
