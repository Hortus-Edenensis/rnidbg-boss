package defpackage;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ky4 {
    public Activity c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18854a = false;
    public MediaPlayer b = null;
    public AudioManager.OnAudioFocusChangeListener d = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        public a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            LogUtil.d("RingtoneHelper", "onAudioFocusChange :" + i);
        }
    }

    public ky4(Activity activity) {
        this.c = activity;
    }

    public final void a() {
        try {
            if (this.f18854a) {
                ((AudioManager) this.c.getSystemService("audio")).abandonAudioFocus(this.d);
                this.f18854a = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void b() {
        try {
            ((AudioManager) this.c.getSystemService("audio")).requestAudioFocus(this.d, 3, 2);
            this.f18854a = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c() {
        AssetFileDescriptor assetFileDescriptorOpenFd;
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            if (this.b == null) {
                this.b = new MediaPlayer();
            }
            this.b.setAudioStreamType(3);
            this.b.setLooping(true);
            try {
                assetFileDescriptorOpenFd = this.c.getAssets().openFd("sound/voicematch_matching.mp3");
            } catch (IOException e) {
                e = e;
                assetFileDescriptorOpenFd = null;
            }
            try {
                this.b.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
                this.b.prepare();
                this.b.start();
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                this.b.stop();
                this.b.release();
                this.b = null;
                if (assetFileDescriptorOpenFd != null) {
                    try {
                        assetFileDescriptorOpenFd.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }
            b();
        }
    }

    public void d() {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            try {
                try {
                    if (mediaPlayer.isPlaying()) {
                        this.b.stop();
                        this.b.release();
                        this.b = null;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                a();
            }
        }
    }
}
