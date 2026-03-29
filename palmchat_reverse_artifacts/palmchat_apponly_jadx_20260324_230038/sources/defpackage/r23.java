package defpackage;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class r23<T extends Entry> extends t23<T> implements im2<T> {
    public int B;
    public Drawable C;
    public int D;
    public float E;
    public boolean F;

    public r23(List<T> list, String str) {
        super(list, str);
        this.B = Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, 234, 255);
        this.D = 85;
        this.E = 2.5f;
        this.F = false;
    }

    @Override // defpackage.im2
    public int R() {
        return this.D;
    }

    @Override // defpackage.im2
    public float U() {
        return this.E;
    }

    public void e1(boolean z) {
        this.F = z;
    }

    @Override // defpackage.im2
    public Drawable f() {
        return this.C;
    }

    public void f1(int i) {
        this.B = i;
        this.C = null;
    }

    @TargetApi(18)
    public void g1(Drawable drawable) {
        this.C = drawable;
    }

    @Override // defpackage.im2
    public int getFillColor() {
        return this.B;
    }

    public void h1(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 10.0f) {
            f = 10.0f;
        }
        this.E = s86.e(f);
    }

    @Override // defpackage.im2
    public boolean w0() {
        return this.F;
    }
}
