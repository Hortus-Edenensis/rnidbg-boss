package com.bytedance.sdk.openadsdk.core.live.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DoubleColorBallAnimationView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f5334a;
    private final float b;
    private float bg;
    private float bq;
    private float dw;
    private final float fx;
    private final long iz;
    private final PorterDuffXfermode jk;
    private boolean k;
    private boolean l;
    private boolean mv;
    private long my;
    private int n;
    private final float nr;
    private int o;
    private final float pn;
    private int s;
    private float sx;
    private float t;
    private final float u;
    private int x;

    public DoubleColorBallAnimationView(Context context) {
        this(context, null);
    }

    private Paint b() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    private void pn() {
        this.my = -1L;
        if (this.o <= 0) {
            setProgressBarInfo(y.fx(getContext(), 60.0f));
        }
        int iMin = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (this.o > iMin && iMin > 0) {
            setProgressBarInfo(iMin);
        }
        if (this.f5334a == null) {
            this.f5334a = b();
        }
        this.mv = true;
    }

    private float u(float f) {
        return ((double) f) < 0.5d ? 2.0f * f * f : ((f * 2.0f) * (2.0f - f)) - 1.0f;
    }

    public void fx() {
        this.k = false;
        this.mv = false;
        this.t = 0.0f;
    }

    public void nr() {
        pn();
        this.k = true;
        this.l = true;
        postInvalidate();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fx();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if ((u() || !this.l) && this.mv) {
            if (this.l) {
                long jNanoTime = System.nanoTime() / 1000000;
                if (this.my < 0) {
                    this.my = jNanoTime;
                }
                float f = (jNanoTime - this.my) / 400.0f;
                this.t = f;
                int i = (int) f;
                z = ((this.s + i) & 1) == 1;
                this.t = f - i;
            }
            try {
                float fU = u(this.t);
                int i2 = this.o;
                int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, i2, i2, this.f5334a, 31);
                float f2 = (this.dw * fU) + this.bq;
                float f3 = ((double) fU) < 0.5d ? fU * 2.0f : 2.0f - (fU * 2.0f);
                float f4 = this.bg;
                float f5 = (0.25f * f3 * f4) + f4;
                this.f5334a.setColor(z ? this.n : this.x);
                canvas.drawCircle(f2, this.sx, f5, this.f5334a);
                float f6 = this.o - f2;
                float f7 = this.bg;
                float f8 = f7 - ((f3 * 0.375f) * f7);
                this.f5334a.setColor(z ? this.x : this.n);
                this.f5334a.setXfermode(this.jk);
                canvas.drawCircle(f6, this.sx, f8, this.f5334a);
                this.f5334a.setXfermode(null);
                canvas.restoreToCount(iSaveLayer);
            } catch (Throwable unused) {
            }
            postInvalidateDelayed(17L);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iMin = Math.min(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        if (this.o <= iMin || iMin <= 0) {
            return;
        }
        setProgressBarInfo(iMin);
    }

    public void setCycleBias(int i) {
        this.s = i;
    }

    public void setProgress(float f) {
        if (!this.mv) {
            pn();
        }
        this.t = f;
        this.k = false;
        this.l = false;
        postInvalidate();
    }

    public void setProgressBarInfo(int i) {
        if (i > 0) {
            this.o = i;
            this.sx = i / 2.0f;
            float f = (i >> 1) * 0.32f;
            this.bg = f;
            float f2 = (i * 0.16f) + f;
            this.bq = f2;
            this.dw = i - (f2 * 2.0f);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            nr();
        } else {
            fx();
        }
    }

    public DoubleColorBallAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean u() {
        return this.k;
    }

    public DoubleColorBallAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.u = 0.25f;
        this.nr = 0.375f;
        this.fx = 0.16f;
        this.b = 0.32f;
        this.pn = 400.0f;
        this.iz = 17L;
        this.x = -119723;
        this.n = -14289682;
        this.jk = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.l = false;
        this.mv = false;
        this.s = 0;
        this.k = false;
        this.my = -1L;
        this.o = -1;
    }
}
