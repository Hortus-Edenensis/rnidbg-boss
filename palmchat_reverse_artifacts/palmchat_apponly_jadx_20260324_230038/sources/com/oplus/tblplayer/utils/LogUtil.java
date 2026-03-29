package com.oplus.tblplayer.utils;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.oplus.tbl.exoplayer2.ExoPlaybackException;
import com.oplus.tbl.exoplayer2.analytics.AnalyticsListener;
import com.oplus.tbl.exoplayer2.decoder.DecoderCounters;
import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.logger.Logger;
import java.lang.reflect.Field;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class LogUtil {
    private static final NumberFormat NUMBER_TIME_FORMAT;
    private static final SimpleDateFormat SIMPLE_DTAT_FORMAT;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
        SIMPLE_DTAT_FORMAT = simpleDateFormat;
        simpleDateFormat.setTimeZone(Calendar.getInstance().getTimeZone());
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        NUMBER_TIME_FORMAT = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }

    public static void d(@NonNull String str, String str2) {
        Logger.d(str, str2);
    }

    public static void dfmt(@NonNull String str, String str2, Object... objArr) {
        Logger.d(str, String.format(str2, objArr));
    }

    public static void e(@NonNull String str, String str2) {
        Logger.e(str, str2);
    }

    public static String getDateTimeString(long j) {
        return j == -9223372036854775807L ? Constants.STRING_VALUE_UNSET : SIMPLE_DTAT_FORMAT.format(Long.valueOf(j));
    }

    public static String getDecoderCountersString(DecoderCounters decoderCounters) {
        return "decoderCountersToString: DecoderCounters[decoderInitCount = " + decoderCounters.decoderInitCount + ", decoderReleaseCount = " + decoderCounters.decoderReleaseCount + ", inputBufferCount = " + decoderCounters.inputBufferCount + ", skippedInputBufferCount = " + decoderCounters.skippedInputBufferCount + ", renderedOutputBufferCount = " + decoderCounters.renderedOutputBufferCount + ", skippedOutputBufferCount = " + decoderCounters.skippedOutputBufferCount + ", droppedBufferCount = " + decoderCounters.droppedBufferCount + ", maxConsecutiveDroppedBufferCount = " + decoderCounters.maxConsecutiveDroppedBufferCount + ", droppedToKeyframeCount = " + decoderCounters.droppedToKeyframeCount + "]";
    }

    public static String getDiscontinuityReasonString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? Constants.STRING_VALUE_UNSET : "INTERNAL" : "AD_INSERTION" : "SEEK_ADJUSTMENT" : "SEEK" : "PERIOD_TRANSITION";
    }

    public static String getErrorTypeString(@NonNull ExoPlaybackException exoPlaybackException) {
        int i = exoPlaybackException.type;
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? Constants.STRING_VALUE_UNSET : "Remote" : "Unexpected" : "Renderer" : "Source";
    }

    public static String getEventTimeString(AnalyticsListener.EventTime eventTime, long j) {
        String str = "window=" + eventTime.windowIndex;
        if (eventTime.mediaPeriodId != null) {
            str = str + ", period=" + eventTime.timeline.getIndexOfPeriod(eventTime.mediaPeriodId.periodUid);
            if (eventTime.mediaPeriodId.isAd()) {
                str = (str + ", adGroup=" + eventTime.mediaPeriodId.adGroupIndex) + ", ad=" + eventTime.mediaPeriodId.adIndexInAdGroup;
            }
        }
        return "eventTime=" + getNumberTimeString(eventTime.realtimeMs - j) + ", mediaPos=" + getNumberTimeString(eventTime.currentPlaybackPositionMs) + ", " + str;
    }

    public static String getExoPlayerStateString(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? Constants.STRING_VALUE_UNSET : "ENDED" : "READY" : "BUFFERING" : "IDLE";
    }

    public static String getExtractorTypeString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? Constants.STRING_VALUE_UNSET : "Ffmpeg Extractor Prefer" : "Ffmpeg Extractor" : "Exo Extractor" : "All Extractor";
    }

    public static String getLoadingStateString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? Constants.STRING_VALUE_UNSET : "LOADING_COMPLETED" : "LOADING_STARTED" : "LOADING_IDLE";
    }

    public static String getNetworkTypeString(int i) {
        return i != 2 ? i != 5 ? Constants.STRING_VALUE_UNSET : "4G" : "Wifi";
    }

    public static String getNumberTimeString(long j) {
        return j == -9223372036854775807L ? Constants.STRING_VALUE_UNSET : NUMBER_TIME_FORMAT.format(j / 1000.0f);
    }

    public static String getPlayerStateString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 4 ? i != 8 ? i != 16 ? i != 32 ? i != 64 ? i != 128 ? i != 256 ? Constants.STRING_VALUE_UNSET : "End" : "Completed" : "Stopped" : "Paused" : "Started" : "Prepared" : "Preparing" : "Initialized" : "Idle" : "Error";
    }

    public static String getRendererTypeString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? Constants.STRING_VALUE_UNSET : "Ffmpeg Codec" : "Media Codec" : "Auto Codec";
    }

    public static String getSeekModeString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? Constants.STRING_VALUE_UNSET : "Seek closet" : "Seek closet sync" : "Seek next sync" : "Seek previous sync";
    }

    public static String getStreamTypeString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 8 ? Constants.STRING_VALUE_UNSET : "DTMF" : "NOTIFICATION" : "ALARM" : "MUSIC" : "RING" : "SYSTEM" : "VOICE_CALL";
    }

    public static String getTrackTypeString(int i) {
        return i != 1 ? i != 2 ? i != 3 ? Constants.STRING_VALUE_UNSET : "Text" : "Video" : "Audio";
    }

    public static String getVPPFilterFlags(int i) {
        return i != 1 ? i != 2 ? Constants.STRING_VALUE_UNSET : "Screen Image Engine" : "Super-Resolution";
    }

    public static String getVideoDropFramePolicyString(int i) {
        switch (i) {
            case 0:
                return "NONE";
            case 1:
                return "FORCE_24FPS";
            case 2:
                return "FORCE_30FPS";
            case 3:
                return "FORCE_HALF_FPS";
            case 4:
                return "FORCE_60FPS";
            case 5:
                return "FORCE_90FPS";
            case 6:
                return "FORCE_120FPS";
            default:
                return Constants.STRING_VALUE_UNSET;
        }
    }

    public static String getVideoScalingModeString(int i) {
        return i != 1 ? i != 2 ? Constants.STRING_VALUE_UNSET : "SCALE_TO_FIT_WITH_CROPPING" : "SCALE_TO_FIT";
    }

    public static void i(String str, String str2) {
        Logger.i(str, str2);
    }

    public static void printPlatformBuildInfo() {
        for (Field field : Build.class.getDeclaredFields()) {
            String name = field.getName();
            try {
                boolean zIsAccessible = field.isAccessible();
                field.setAccessible(true);
                Log.d("BuildInfo", name + ": " + field.get(Build.class));
                field.setAccessible(zIsAccessible);
            } catch (IllegalAccessException | IllegalArgumentException e) {
                Log.e("BuildInfo", "printPlatformBuildInfo: " + e.getMessage());
            }
        }
    }

    public static void w(String str, String str2) {
        Logger.w(str, str2);
    }

    public static void d(@NonNull String str, String str2, Throwable th) {
        Logger.d(str, str2, th);
    }

    public static void e(@NonNull String str, String str2, Throwable th) {
        Logger.e(str, str2, th);
    }

    public static void i(String str, String str2, Throwable th) {
        Logger.i(str, str2, th);
    }

    public static void w(String str, String str2, Throwable th) {
        Logger.w(str, str2, th);
    }
}
