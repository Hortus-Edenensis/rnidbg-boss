package androidx.media3.transformer;

import android.media.CamcorderProfile;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import defpackage.ku2;
import defpackage.th;
import java.util.Collection;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class EncoderUtil {
    public static final int LEVEL_UNSET = -1;

    @GuardedBy("EncoderUtil.class")
    private static final ArrayListMultimap<String, MediaCodecInfo> mimeTypeToEncoders = ArrayListMultimap.create();

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(29)
    public static final class Api29 {
        private Api29() {
        }

        public static boolean isHardwareAccelerated(MediaCodecInfo mediaCodecInfo) {
            return mediaCodecInfo.isHardwareAccelerated();
        }

        public static boolean isSoftwareOnly(MediaCodecInfo mediaCodecInfo) {
            return mediaCodecInfo.isSoftwareOnly();
        }
    }

    private EncoderUtil() {
    }

    private static int alignResolution(int i, int i2) {
        return i % 10 == 1 ? (int) (((double) i2) * Math.floor(i / i2)) : Math.round(i / i2) * i2;
    }

    @VisibleForTesting
    public static synchronized void clearCachedEncoders() {
        mimeTypeToEncoders.clear();
    }

    public static int findHighestSupportedEncodingLevel(MediaCodecInfo mediaCodecInfo, String str, int i) {
        int iMax = -1;
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : mediaCodecInfo.getCapabilitiesForType(str).profileLevels) {
            if (codecProfileLevel.profile == i) {
                iMax = Math.max(iMax, codecProfileLevel.level);
            }
        }
        return iMax;
    }

    public static ImmutableSet<Integer> findSupportedEncodingProfiles(MediaCodecInfo mediaCodecInfo, String str) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = mediaCodecInfo.getCapabilitiesForType(str).profileLevels;
        ImmutableSet.a aVar = new ImmutableSet.a();
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
            aVar.a(Integer.valueOf(codecProfileLevel.profile));
        }
        return aVar.e();
    }

    public static int getClosestSupportedSampleRate(MediaCodecInfo mediaCodecInfo, String str, int i) {
        MediaCodecInfo.AudioCapabilities audioCapabilities = (MediaCodecInfo.AudioCapabilities) Assertions.checkNotNull(mediaCodecInfo.getCapabilitiesForType(str).getAudioCapabilities());
        int[] supportedSampleRates = audioCapabilities.getSupportedSampleRates();
        int i2 = 0;
        int i3 = Integer.MAX_VALUE;
        if (supportedSampleRates != null) {
            int length = supportedSampleRates.length;
            while (i2 < length) {
                int i4 = supportedSampleRates[i2];
                if (Math.abs(i4 - i) < Math.abs(i3 - i)) {
                    i3 = i4;
                }
                i2++;
            }
            return i3;
        }
        Range<Integer>[] supportedSampleRateRanges = audioCapabilities.getSupportedSampleRateRanges();
        int length2 = supportedSampleRateRanges.length;
        while (i2 < length2) {
            int iIntValue = ((Integer) supportedSampleRateRanges[i2].clamp(Integer.valueOf(i))).intValue();
            if (Math.abs(iIntValue - i) < Math.abs(i3 - i)) {
                i3 = iIntValue;
            }
            i2++;
        }
        return i3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ImmutableList<Integer> getCodecProfilesForHdrFormat(String str, int i) {
        str.hashCode();
        switch (str) {
            case "video/dolby-vision":
                if (i == 7) {
                    return ImmutableList.of(256);
                }
                break;
            case "video/av01":
                if (i == 7) {
                    return ImmutableList.of(2);
                }
                if (i == 6) {
                    return ImmutableList.of(4096);
                }
                break;
            case "video/hevc":
                if (i == 7) {
                    return ImmutableList.of(2);
                }
                if (i == 6) {
                    return ImmutableList.of(4096);
                }
                break;
            case "video/avc":
                if (i == 7) {
                    return ImmutableList.of(16);
                }
                break;
            case "video/x-vnd.on2.vp9":
                if (i == 7 || i == 6) {
                    return ImmutableList.of(4096, 8192);
                }
                break;
        }
        return ImmutableList.of();
    }

    @RequiresApi(23)
    public static int getMaxSupportedInstances(MediaCodecInfo mediaCodecInfo, String str) {
        return mediaCodecInfo.getCapabilitiesForType(str).getMaxSupportedInstances();
    }

    public static Range<Integer> getSupportedBitrateRange(MediaCodecInfo mediaCodecInfo, String str) {
        return ((MediaCodecInfo.VideoCapabilities) Assertions.checkNotNull(mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities())).getBitrateRange();
    }

    public static ImmutableList<Integer> getSupportedColorFormats(MediaCodecInfo mediaCodecInfo, String str) {
        return ImmutableList.copyOf((Collection) ku2.c(mediaCodecInfo.getCapabilitiesForType(str).colorFormats));
    }

    public static synchronized ImmutableList<MediaCodecInfo> getSupportedEncoders(String str) {
        maybePopulateEncoderInfo();
        return ImmutableList.copyOf((Collection) mimeTypeToEncoders.get((Object) th.e(str)));
    }

    public static ImmutableList<MediaCodecInfo> getSupportedEncodersForHdrEditing(String str, @Nullable ColorInfo colorInfo) {
        if (Build.VERSION.SDK_INT < 33 || colorInfo == null) {
            return ImmutableList.of();
        }
        ImmutableList<MediaCodecInfo> supportedEncoders = getSupportedEncoders(str);
        ImmutableList.a aVar = new ImmutableList.a();
        for (int i = 0; i < supportedEncoders.size(); i++) {
            MediaCodecInfo mediaCodecInfo = supportedEncoders.get(i);
            if (!mediaCodecInfo.isAlias() && isHdrEditingSupported(mediaCodecInfo, str, colorInfo)) {
                aVar.a(mediaCodecInfo);
            }
        }
        return aVar.e();
    }

    public static Range<Integer> getSupportedHeights(MediaCodecInfo mediaCodecInfo, String str, int i) {
        return ((MediaCodecInfo.VideoCapabilities) Assertions.checkNotNull(mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities())).getSupportedHeightsFor(i);
    }

    public static synchronized ImmutableSet<String> getSupportedMimeTypes() {
        maybePopulateEncoderInfo();
        return ImmutableSet.copyOf((Collection) mimeTypeToEncoders.keySet());
    }

    @Nullable
    public static Size getSupportedResolution(MediaCodecInfo mediaCodecInfo, String str, int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities = (MediaCodecInfo.VideoCapabilities) Assertions.checkNotNull(mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities());
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        int iAlignResolution = alignResolution(i, widthAlignment);
        int iAlignResolution2 = alignResolution(i2, heightAlignment);
        if (isSizeSupported(mediaCodecInfo, str, iAlignResolution, iAlignResolution2)) {
            return new Size(iAlignResolution, iAlignResolution2);
        }
        float[] fArr = {0.95f, 0.9f, 0.85f, 0.8f, 0.75f, 0.7f, 0.6666667f, 0.6f, 0.55f, 0.5f, 0.4f, 0.33333334f, 0.25f};
        for (int i3 = 0; i3 < 13; i3++) {
            float f = fArr[i3];
            int iAlignResolution3 = alignResolution(Math.round(i * f), widthAlignment);
            int iAlignResolution4 = alignResolution(Math.round(i2 * f), heightAlignment);
            if (isSizeSupported(mediaCodecInfo, str, iAlignResolution3, iAlignResolution4)) {
                return new Size(iAlignResolution3, iAlignResolution4);
            }
        }
        int iIntValue = ((Integer) videoCapabilities.getSupportedHeightsFor(((Integer) videoCapabilities.getSupportedWidths().clamp(Integer.valueOf(i))).intValue()).clamp(Integer.valueOf(i2))).intValue();
        if (iIntValue != i2) {
            i = alignResolution((int) Math.round((((double) i) * ((double) iIntValue)) / ((double) i2)), widthAlignment);
            i2 = alignResolution(iIntValue, heightAlignment);
        }
        if (isSizeSupported(mediaCodecInfo, str, i, i2)) {
            return new Size(i, i2);
        }
        return null;
    }

    public static Pair<Range<Integer>, Range<Integer>> getSupportedResolutionRanges(MediaCodecInfo mediaCodecInfo, String str) {
        MediaCodecInfo.VideoCapabilities videoCapabilities = (MediaCodecInfo.VideoCapabilities) Assertions.checkNotNull(mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities());
        return Pair.create(videoCapabilities.getSupportedWidths(), videoCapabilities.getSupportedHeights());
    }

    public static boolean isBitrateModeSupported(MediaCodecInfo mediaCodecInfo, String str, int i) {
        return ((MediaCodecInfo.EncoderCapabilities) Assertions.checkNotNull(mediaCodecInfo.getCapabilitiesForType(str).getEncoderCapabilities())).isBitrateModeSupported(i);
    }

    public static boolean isFeatureSupported(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        return mediaCodecInfo.getCapabilitiesForType(str).isFeatureSupported(str2);
    }

    public static boolean isHardwareAccelerated(MediaCodecInfo mediaCodecInfo, String str) {
        return Build.VERSION.SDK_INT >= 29 ? Api29.isHardwareAccelerated(mediaCodecInfo) : !isSoftwareOnly(mediaCodecInfo, str);
    }

    @RequiresApi(33)
    public static boolean isHdrEditingSupported(MediaCodecInfo mediaCodecInfo, String str, ColorInfo colorInfo) {
        if (!(str.equals("video/dolby-vision") || isFeatureSupported(mediaCodecInfo, str, "hdr-editing") || (colorInfo.colorTransfer == 7 && Build.VERSION.SDK_INT >= 35 && isFeatureSupported(mediaCodecInfo, str, "hlg-editing")))) {
            return false;
        }
        ImmutableList<Integer> codecProfilesForHdrFormat = getCodecProfilesForHdrFormat(str, colorInfo.colorTransfer);
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : mediaCodecInfo.getCapabilitiesForType(str).profileLevels) {
            if (codecProfilesForHdrFormat.contains(Integer.valueOf(codecProfileLevel.profile))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSizeSupported(MediaCodecInfo mediaCodecInfo, String str, int i, int i2) {
        if (((MediaCodecInfo.VideoCapabilities) Assertions.checkNotNull(mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities())).isSizeSupported(i, i2)) {
            return true;
        }
        if (i == 1920 && i2 == 1080) {
            return CamcorderProfile.hasProfile(6);
        }
        if (i == 3840 && i2 == 2160) {
            return CamcorderProfile.hasProfile(8);
        }
        return false;
    }

    private static boolean isSoftwareOnly(MediaCodecInfo mediaCodecInfo, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29.isSoftwareOnly(mediaCodecInfo);
        }
        if (MimeTypes.isAudio(str)) {
            return true;
        }
        String strE = th.e(mediaCodecInfo.getName());
        if (strE.startsWith("arc.")) {
            return false;
        }
        if (strE.startsWith("omx.google.") || strE.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((strE.startsWith("omx.sec.") && strE.contains(".sw.")) || strE.equals("omx.qcom.video.decoder.hevcswvdec") || strE.startsWith("c2.android.") || strE.startsWith("c2.google.")) {
            return true;
        }
        return (strE.startsWith("omx.") || strE.startsWith("c2.")) ? false : true;
    }

    private static synchronized void maybePopulateEncoderInfo() {
        if (mimeTypeToEncoders.isEmpty()) {
            for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
                if (mediaCodecInfo.isEncoder()) {
                    for (String str : mediaCodecInfo.getSupportedTypes()) {
                        mimeTypeToEncoders.put(th.e(str), mediaCodecInfo);
                    }
                }
            }
        }
    }
}
