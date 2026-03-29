package defpackage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class su0 extends pv4 {
    public g10 b;
    public Paint c;
    public Paint d;
    public Paint e;
    public Paint f;

    public su0(g10 g10Var, nf6 nf6Var) {
        super(nf6Var);
        this.b = g10Var;
        Paint paint = new Paint(1);
        this.c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.e = new Paint(4);
        Paint paint2 = new Paint(1);
        this.f = paint2;
        paint2.setColor(Color.rgb(63, 63, 63));
        this.f.setTextAlign(Paint.Align.CENTER);
        this.f.setTextSize(s86.e(9.0f));
        Paint paint3 = new Paint(1);
        this.d = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(2.0f);
        this.d.setColor(Color.rgb(255, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME, 115));
    }

    public void a(kl2 kl2Var) {
        this.f.setTypeface(kl2Var.j());
        this.f.setTextSize(kl2Var.t0());
    }

    public abstract void b(Canvas canvas);

    public abstract void c(Canvas canvas);

    public abstract void d(Canvas canvas, vh2[] vh2VarArr);

    public abstract void e(Canvas canvas);

    public abstract void f();

    public boolean g(j10 j10Var) {
        return ((float) j10Var.getData().i()) < ((float) j10Var.getMaxVisibleCount()) * this.f20113a.r();
    }
}
