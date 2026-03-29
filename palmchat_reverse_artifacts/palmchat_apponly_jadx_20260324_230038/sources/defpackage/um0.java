package defpackage;

import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.oplus.tblplayer.processor.util.EffectConstants;
import com.ss.bytertc.engine.type.AudioProfileType;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class um0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap<String, Pair<Integer, Integer>> f21242a = new a();
    public static final AudioProfileType b = AudioProfileType.AUDIO_PROFILE_STANDARD;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends LinkedHashMap<String, Pair<Integer, Integer>> {
        public a() {
            put("720*1280", new Pair(720, 1280));
            put("540*960", new Pair(540, 960));
            put("360*640", new Pair(360, Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK)));
            put("180*320", new Pair(Integer.valueOf(EffectConstants.ROTATION_DEGREES_180), Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME)));
        }
    }

    public static String a() {
        return nl0.k() ? "6605085c1edf0b01624958a1" : "6618e833686185016f1df950";
    }
}
