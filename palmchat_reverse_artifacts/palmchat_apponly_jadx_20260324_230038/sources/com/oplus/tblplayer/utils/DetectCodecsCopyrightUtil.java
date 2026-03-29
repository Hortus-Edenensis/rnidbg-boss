package com.oplus.tblplayer.utils;

import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tblplayer.config.Globals;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class DetectCodecsCopyrightUtil {
    private static final String AUDIO_DOLBY_AC3 = "audio/ac3";
    private static final String AUDIO_DOLBY_AC4 = "audio/ac4";
    private static final String AUDIO_DOLBY_EAC3 = "audio/eac3";
    private static final String AUDIO_DOLBY_EAC3_JOC = "audio/eac3-joc";
    private static final String AUDIO_REAL_COOK = "audio/cook";
    private static final String AUDIO_REAL_RA144 = "audio/ra_144";
    private static final String AUDIO_REAL_RA288 = "audio/ra_288";
    private static final String AUDIO_REAL_RALF = "audio/ralf";
    private static final String AUDIO_REAL_SIPR = "audio/sipr";
    public static final int CODEC_TYPE_DOLBYAUDIO = 11;
    public static final int CODEC_TYPE_OTHER = 0;
    public static final int CODEC_TYPE_PRORESVIDEO = 21;
    public static final int CODEC_TYPE_REALAUDIO = 10;
    public static final int CODEC_TYPE_REALVIDEO = 20;
    private static final String TAG = "DetectCodecsCopyrightUtil";
    private static final String VIDEO_PRORES = "video/prores";
    private static final String VIDEO_REAL_RV10 = "video/rv10";
    private static final String VIDEO_REAL_RV13 = "video/rv13";
    private static final String VIDEO_REAL_RV20 = "video/rv20";
    private static final String VIDEO_REAL_RV30 = "video/rv30";
    private static final String VIDEO_REAL_RV40 = "video/rv40";
    private static final String VIDEO_REAL_RV60 = "video/rv60";
    public static final boolean DETECT_ENABLED = Globals.isDetectCodecsCopyrightEnabled();
    public static int unsupportedAudioCodecType = 0;
    public static int unsupportedVideoCodecType = 0;

    private DetectCodecsCopyrightUtil() {
    }

    @Nullable
    private static String getSystemProperty(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e) {
            LogUtil.e(TAG, "Failed to read system property " + str + "," + e.getMessage());
            return null;
        }
    }

    private static boolean isDolbyAudioCodec(String str) {
        if (!str.toLowerCase().contains("audio/ac3") && !str.toLowerCase().contains("audio/eac3") && !str.toLowerCase().contains("audio/eac3-joc") && !str.toLowerCase().contains("audio/ac4")) {
            return false;
        }
        unsupportedAudioCodecType = 11;
        return true;
    }

    private static boolean isDolbyAudioEffectType() {
        String systemProperty = getSystemProperty("ro.oplus.audio.effect.type");
        LogUtil.d(TAG, "audio_effect_type is " + systemProperty);
        Assertions.checkNotNull(systemProperty);
        return systemProperty.contains("dolby");
    }

    private static boolean isProResVideoCodec(String str) {
        if (!str.toLowerCase().contains(VIDEO_PRORES)) {
            return false;
        }
        unsupportedVideoCodecType = 21;
        return true;
    }

    private static boolean isRealAudioCodec(String str) {
        if (!str.toLowerCase().contains(AUDIO_REAL_COOK) && !str.toLowerCase().contains(AUDIO_REAL_RA144) && !str.toLowerCase().contains(AUDIO_REAL_RA288) && !str.toLowerCase().contains(AUDIO_REAL_SIPR) && !str.toLowerCase().contains(AUDIO_REAL_RALF)) {
            return false;
        }
        unsupportedAudioCodecType = 10;
        return true;
    }

    private static boolean isRealVideoCodec(String str) {
        if (!str.toLowerCase().contains(VIDEO_REAL_RV10) && !str.toLowerCase().contains(VIDEO_REAL_RV13) && !str.toLowerCase().contains(VIDEO_REAL_RV20) && !str.toLowerCase().contains(VIDEO_REAL_RV30) && !str.toLowerCase().contains(VIDEO_REAL_RV40) && !str.toLowerCase().contains(VIDEO_REAL_RV60)) {
            return false;
        }
        unsupportedVideoCodecType = 20;
        return true;
    }

    public static boolean isUnsupportedAudioCopyrightCodec(String str) {
        return DETECT_ENABLED && ((isDolbyAudioCodec(str) && !isDolbyAudioEffectType()) || isRealAudioCodec(str));
    }

    public static boolean isUnsupportedVideoCopyrightCodec(String str) {
        return DETECT_ENABLED && (isRealVideoCodec(str) || isProResVideoCodec(str));
    }
}
