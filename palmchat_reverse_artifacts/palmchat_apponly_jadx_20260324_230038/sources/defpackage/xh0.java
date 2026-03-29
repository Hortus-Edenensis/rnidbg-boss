package defpackage;

import android.graphics.Color;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.oplus.tblplayer.processor.util.EffectConstants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class xh0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f21958a = {Color.rgb(207, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT), Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_EANABLE_DROPPING_DTS_ROLLBACK, 212, 212), Color.rgb(136, EffectConstants.ROTATION_DEGREES_180, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME), Color.rgb(118, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED), Color.rgb(42, 109, 130)};
    public static final int[] b = {Color.rgb(217, 80, 138), Color.rgb(MediaPlayer.MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE, 149, 7), Color.rgb(MediaPlayer.MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 120), Color.rgb(106, 167, 134), Color.rgb(53, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 209)};
    public static final int[] c = {Color.rgb(64, 89, 128), Color.rgb(149, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, 124), Color.rgb(217, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, 162), Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 134, 134), Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 48, 80)};
    public static final int[] d = {Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT, 37, 82), Color.rgb(255, 102, 0), Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_AUDIO_GRAPH, 0), Color.rgb(106, 150, 31), Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 100, 53)};
    public static final int[] e = {Color.rgb(192, 255, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID), Color.rgb(255, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID), Color.rgb(255, 208, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID), Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, 234, 255), Color.rgb(255, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, 157)};
    public static final int[] f = {b("#2ecc71"), b("#f1c40f"), b("#e74c3c"), b("#3498db")};

    public static int a(int i, int i2) {
        return (i & 16777215) | ((i2 & 255) << 24);
    }

    public static int b(String str) {
        int i = (int) Long.parseLong(str.replace("#", ""), 16);
        return Color.rgb((i >> 16) & 255, (i >> 8) & 255, (i >> 0) & 255);
    }
}
