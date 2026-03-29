package defpackage;

import com.zenmen.media.player.MagicTextureMediaPlayer;
import com.zenmen.media.player.OnStateChangeListener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class hz2 implements gm2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18074a;
    public int b;
    public int c;
    public int d;
    public MagicTextureMediaPlayer e;

    public hz2(MagicTextureMediaPlayer magicTextureMediaPlayer) {
        this.e = magicTextureMediaPlayer;
        magicTextureMediaPlayer.setLoop(false);
        magicTextureMediaPlayer.setKeepScreenOn(true);
        magicTextureMediaPlayer.setMode(4);
        magicTextureMediaPlayer.setFixedSize(true);
    }

    @Override // defpackage.gm2
    public int a() {
        return this.c - this.d;
    }

    public int b() {
        return this.e.getDuration();
    }

    public int c() {
        return this.e.getPosition();
    }

    public boolean d() {
        return this.e.isPaused();
    }

    public boolean e() {
        return this.e.isPlaying();
    }

    public void f(boolean z) {
        this.e.mute(z);
    }

    public void g() {
        if (this.e.isPlaying()) {
            this.e.pause();
        }
    }

    @Override // defpackage.gm2
    public int getProgress() {
        return ((this.f18074a * b()) + c()) - this.d;
    }

    public void h() {
        this.e.release();
    }

    public void i(int i) {
        this.e.seek(i);
    }

    public void j(int i) {
        this.d = i;
    }

    public void k(OnStateChangeListener onStateChangeListener) {
        this.e.setOnStateChangeListener(onStateChangeListener);
    }

    public void l(String str) {
        this.e.setVideo(str);
    }

    public void m() {
        this.e.start();
    }

    public void n() {
        this.e.stop();
    }
}
