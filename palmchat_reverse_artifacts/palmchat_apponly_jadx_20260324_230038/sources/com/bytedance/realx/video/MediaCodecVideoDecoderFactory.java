package com.bytedance.realx.video;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import androidx.annotation.Nullable;
import com.bytedance.realx.base.CalledByNative;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.video.EglBase;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class MediaCodecVideoDecoderFactory {
    private static final String TAG = "MediaCodecVideoDecoderFactory";

    @Nullable
    private EglBase.Context sharedContext;

    @CalledByNative
    public MediaCodecVideoDecoderFactory(@Nullable EglBase.Context context) {
        this.sharedContext = context;
    }

    @Nullable
    private MediaCodecInfo findCodecForType(RXVideoCodecStandard rXVideoCodecStandard) {
        MediaCodecInfo codecInfoAt;
        for (int i = 0; i < MediaCodecList.getCodecCount(); i++) {
            try {
                try {
                    codecInfoAt = MediaCodecList.getCodecInfoAt(i);
                } catch (IllegalArgumentException e) {
                    RXLogging.e(TAG, "Cannot retrieve decoder codec info", e);
                    codecInfoAt = null;
                }
                if (codecInfoAt != null && !codecInfoAt.isEncoder() && !isSoftwareDecoder(codecInfoAt) && isSupportedCodec(codecInfoAt, rXVideoCodecStandard)) {
                    return codecInfoAt;
                }
            } catch (Exception e2) {
                RXLogging.e(TAG, "findCodecForType got system error:", e2);
            }
        }
        return null;
    }

    private boolean isH264HighProfileSupported(MediaCodecInfo mediaCodecInfo, RXVideoCodecStandard rXVideoCodecStandard) {
        String name = mediaCodecInfo.getName();
        int i = Build.VERSION.SDK_INT;
        if (name.startsWith("OMX.qcom.")) {
            return true;
        }
        if (i >= 23 && name.startsWith("OMX.Exynos.")) {
            return true;
        }
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(rXVideoCodecStandard.mimeType());
        int i2 = 0;
        while (true) {
            MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType.profileLevels;
            if (i2 >= codecProfileLevelArr.length) {
                return false;
            }
            if (8 == codecProfileLevelArr[i2].profile) {
                return true;
            }
            i2++;
        }
    }

    private boolean isSoftwareDecoder(MediaCodecInfo mediaCodecInfo) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                return mediaCodecInfo.isSoftwareOnly();
            }
            String name = mediaCodecInfo.getName();
            if (name == null) {
                return false;
            }
            String lowerCase = name.toLowerCase();
            if (lowerCase.startsWith("arc.")) {
                return false;
            }
            return lowerCase.startsWith("omx.google.") || lowerCase.startsWith("omx.ffmpeg.") || (lowerCase.startsWith("omx.sec.") && lowerCase.contains(".sw.")) || lowerCase.startsWith("c2.android.") || lowerCase.equals("omx.qcom.video.decoder.hevcswvdec") || lowerCase.startsWith("c2.google.") || !(lowerCase.startsWith("omx.") || lowerCase.startsWith("c2."));
        } catch (Exception e) {
            RXLogging.e(TAG, "check decoder softonly error.", e);
            return false;
        }
    }

    private boolean isSupportedCodec(MediaCodecInfo mediaCodecInfo, RXVideoCodecStandard rXVideoCodecStandard) {
        mediaCodecInfo.getName();
        return MediaCodecUtils.codecSupportsType(mediaCodecInfo, rXVideoCodecStandard) && MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, mediaCodecInfo.getCapabilitiesForType(rXVideoCodecStandard.mimeType())) != null;
    }

    @Nullable
    @CalledByNative
    public VideoDecoder createDecoder(RXVideoCodecDesc rXVideoCodecDesc) {
        RXVideoCodecStandard standard = rXVideoCodecDesc.getStandard();
        MediaCodecInfo mediaCodecInfoFindCodecForType = findCodecForType(standard);
        if (mediaCodecInfoFindCodecForType == null) {
            return null;
        }
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfoFindCodecForType.getCapabilitiesForType(standard.mimeType());
        for (int i : capabilitiesForType.colorFormats) {
            RXLogging.w(TAG, "support codecColorFormat:" + i);
        }
        Integer numSelectColorFormat = MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, capabilitiesForType);
        if (numSelectColorFormat == null) {
            return null;
        }
        return new AndroidVideoDecoder(new MediaCodecWrapperFactoryImpl(), mediaCodecInfoFindCodecForType.getName(), standard, numSelectColorFormat.intValue(), this.sharedContext);
    }

    @CalledByNative
    public void enableEglLock(boolean z) {
        RXLogging.e(TAG, "MediaCodecVideoDecoderFactory enableEglLock:" + z);
        EglBase.EglLock.enableEglLock = z;
    }

    @CalledByNative
    public RXVideoCodecDesc[] getSupportedCodecs() {
        ArrayList arrayList = new ArrayList();
        RXVideoCodecStandard rXVideoCodecStandard = RXVideoCodecStandard.H264;
        MediaCodecInfo mediaCodecInfoFindCodecForType = findCodecForType(rXVideoCodecStandard);
        if (mediaCodecInfoFindCodecForType != null) {
            if (isH264HighProfileSupported(mediaCodecInfoFindCodecForType, rXVideoCodecStandard)) {
                arrayList.add(new RXVideoCodecDesc(rXVideoCodecStandard, RXVideoCodecProfile.ProfileHigh));
            }
            arrayList.add(new RXVideoCodecDesc(rXVideoCodecStandard, RXVideoCodecProfile.ProfileBaseline));
        }
        return (RXVideoCodecDesc[]) arrayList.toArray(new RXVideoCodecDesc[arrayList.size()]);
    }

    @CalledByNative
    public void setHardwareContext(EglBase.Context context) {
        this.sharedContext = context;
    }
}
