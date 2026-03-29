package com.oplus.tblplayer.misc;

import com.oplus.tbl.exoplayer2.util.Util;
import com.oplus.tblplayer.utils.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class DeviceModelDetection {
    private static final String TAG = "DeviceModelDetection";

    private DeviceModelDetection() {
    }

    public static boolean deviceNeedNotifyErrorWithDolbyVideosWorkaround() {
        String str;
        str = Util.MODEL;
        str.hashCode();
        switch (str) {
            case "PHN110":
            case "PHY110":
            case "PHY120":
            case "PHZ110":
            case "CPH2499":
            case "CPH2551":
                LogUtil.w(TAG, str + " needs notify error with dobly videos on this device.");
                return true;
            default:
                return false;
        }
    }

    public static boolean deviceNeedsConfigureMaxOutputFrameRateWorkaround() {
        String str = Util.MODEL;
        str.hashCode();
        if (!str.equals("CPH2565") && !str.equals("RMX3871")) {
            return false;
        }
        LogUtil.w(TAG, str + " need config output frame rate on this device.");
        return true;
    }

    public static boolean deviceNeedsNotifyHighSpecWorkaround() {
        String str;
        str = Util.MODEL;
        str.hashCode();
        switch (str) {
            case "CPH2577":
            case "CPH2579":
            case "CPH2591":
                LogUtil.w(TAG, str + " needs notify highspec through mediacodec path on this device.");
                return true;
            default:
                return false;
        }
    }

    public static boolean deviceNeedsRotationConvertErrorWorkaround() {
        String str;
        str = Util.MODEL;
        str.hashCode();
        switch (str) {
            case "CPH2095":
            case "CPH2097":
            case "CPH2099":
            case "CPH2101":
            case "CPH2103":
                LogUtil.w(TAG, str + ",Ffmpeg rotation convert error on this device.");
                return true;
            default:
                return false;
        }
    }

    public static boolean deviceNeedsUnsupportedHDRWorkaround() {
        String str = Util.MODEL;
        str.hashCode();
        if (!str.equals("CPH2309") && !str.equals("A102OP")) {
            return false;
        }
        LogUtil.w(TAG, str + ",HDR hardware decoder is unsupported on this device.");
        return true;
    }

    public static boolean deviceNeedsUseFfmpegAudioDecoderWorkaround() {
        String str = Util.MODEL;
        str.hashCode();
        if (!str.equals("PFZM10") && !str.equals("PGJM10")) {
            return false;
        }
        LogUtil.w(TAG, str + " needs use ffmpeg decoder for audio codec OPUS/VORBIS.");
        return true;
    }
}
