package defpackage;

import android.media.MediaPlayer;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class wq2 {
    public static wq2 c = new wq2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaPlayer f21775a = null;
    public HashMap<Long, String> b = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements MediaPlayer.OnCompletionListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            LogUtil.i("ImageBgMusicController", "onCompletion");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements MediaPlayer.OnErrorListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            LogUtil.i("ImageBgMusicController", "onError" + i + " " + i2);
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements MediaPlayer.OnBufferingUpdateListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            LogUtil.i("ImageBgMusicController", "onBufferingUpdate " + i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements MediaPlayer.OnPreparedListener {
        public d() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            LogUtil.i("ImageBgMusicController", "onPrepared ");
            mediaPlayer.start();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements MediaPlayer.OnInfoListener {
        public e() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            LogUtil.i("ImageBgMusicController", "onInfo ");
            return false;
        }
    }

    public static wq2 a() {
        return c;
    }

    public final String b(long j) {
        String str = this.b.get(Long.valueOf(j));
        if (str != null) {
            return str;
        }
        JSONArray jSONArrayC = vs0.a().c("show_bgm_list");
        String strOptString = (jSONArrayC == null || jSONArrayC.length() <= 0) ? null : jSONArrayC.optString(new Random().nextInt(jSONArrayC.length() - 1));
        if (strOptString != null) {
            this.b.put(Long.valueOf(j), strOptString);
        }
        return strOptString;
    }

    public final MediaPlayer c() {
        e();
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f21775a = mediaPlayer;
        return mediaPlayer;
    }

    public void d(long j) {
        String strB = b(j);
        LogUtil.i("ImageBgMusicController", "play start path=" + strB);
        if (strB == null) {
            return;
        }
        MediaPlayer mediaPlayerC = c();
        mediaPlayerC.setAudioStreamType(3);
        mediaPlayerC.setLooping(true);
        LogUtil.i("ImageBgMusicController", "play start path =" + strB);
        try {
            mediaPlayerC.setDataSource(strB);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        mediaPlayerC.setOnCompletionListener(new a());
        mediaPlayerC.setOnErrorListener(new b());
        mediaPlayerC.setOnBufferingUpdateListener(new c());
        mediaPlayerC.setOnPreparedListener(new d());
        mediaPlayerC.setOnInfoListener(new e());
        mediaPlayerC.prepareAsync();
        LogUtil.i("ImageBgMusicController", "play end");
    }

    public final void e() {
        LogUtil.i("ImageBgMusicController", "stop  start");
        try {
            MediaPlayer mediaPlayer = this.f21775a;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                this.f21775a.stop();
            }
        } catch (Exception unused) {
            LogUtil.i("ImageBgMusicController", "stop  stop 1");
        }
        try {
            MediaPlayer mediaPlayer2 = this.f21775a;
            if (mediaPlayer2 != null) {
                mediaPlayer2.release();
            }
        } catch (Exception unused2) {
            LogUtil.i("ImageBgMusicController", "stop  release 1");
        }
        this.f21775a = null;
        LogUtil.i("ImageBgMusicController", "stop  end");
    }

    public void f() {
        e();
    }
}
