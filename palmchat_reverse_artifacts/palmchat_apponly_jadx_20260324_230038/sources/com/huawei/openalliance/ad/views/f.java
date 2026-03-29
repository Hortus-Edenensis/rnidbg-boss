package com.huawei.openalliance.ad.views;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.utils.bg;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class f extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f6986a;
    private float b;
    private float c;
    private float d;
    private float e;
    private int i;
    private long k;
    private LinearGradient l;
    private float m;
    private boolean n;
    private int f = 1728053247;
    private boolean g = true;
    private float h = 0.0f;
    private boolean j = false;

    public f() {
        B();
    }

    private void B() {
        Paint paint = new Paint();
        this.f6986a = paint;
        paint.setAntiAlias(true);
        this.f6986a.setStyle(Paint.Style.FILL);
        this.b = 0.0f;
        this.d = 0.0f;
        V(2);
        this.n = bg.C();
    }

    private boolean C() {
        return this.i == 2;
    }

    private long D() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.k;
        Code(jCurrentTimeMillis);
        if (j < 0) {
            return 0L;
        }
        return j;
    }

    private void F() {
        this.h = (this.d + this.c) / 2000.0f;
        if (this.g) {
            this.g = false;
        }
    }

    private void L() {
        int i = this.f;
        int i2 = 16777215 & i;
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, this.d, 0.0f, new int[]{i2, i, i2}, new float[]{0.0f, 0.93f, 1.0f}, Shader.TileMode.CLAMP);
        this.l = linearGradient;
        this.f6986a.setShader(linearGradient);
    }

    private boolean S() {
        return this.j && this.g;
    }

    private void V(int i) {
        this.i = i;
    }

    private void a() {
        this.e = -this.d;
    }

    public void Code() {
        if (fh.Code()) {
            fh.Code("HwFlickerDrawable", "start()");
        }
        if (this.i == 0) {
            return;
        }
        this.j = false;
        Code(System.currentTimeMillis());
        invalidateSelf();
        V(0);
    }

    public void I() {
        if (fh.Code()) {
            fh.Code("HwFlickerDrawable", "stop()");
        }
        a();
        V(2);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (C()) {
            this.j = false;
            return;
        }
        F();
        float fD = this.e + (this.h * D());
        if (Float.compare(fD, this.c) > 0) {
            if (((int) this.c) != 0) {
                fD = (fD % ((int) r0)) - this.d;
            }
            this.g = true;
        }
        this.e = fD;
        Rect bounds = getBounds();
        if (Float.compare(this.m, 0.0f) > 0) {
            RectF rectF = new RectF();
            rectF.set(bounds);
            Path path = new Path();
            float f = this.m;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
            canvas.clipPath(path);
        }
        if (this.n) {
            canvas.scale(-1.0f, 1.0f, bounds.width() / 2.0f, bounds.height() / 2.0f);
        }
        canvas.save();
        canvas.translate(fD, 0.0f);
        float f2 = Float.compare(this.d + fD, this.c) > 0 ? this.c - fD : this.d;
        if (Float.compare(fD, 0.0f) < 0) {
            int i = bounds.left;
            canvas.clipRect(i - fD, bounds.top, (i - fD) + f2, bounds.bottom);
        }
        int i2 = bounds.left;
        canvas.drawRect(i2, bounds.top, i2 + f2, bounds.bottom, this.f6986a);
        canvas.restore();
        invalidateSelf();
        if (S()) {
            this.j = false;
            I();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        this.c = (this.b * i) / 10000.0f;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        Code(i, i3);
    }

    public f(float f) {
        this.m = f;
        B();
    }

    private void Code(float f, float f2) {
        float f3 = f2 - f;
        this.b = f3;
        float level = (f3 * getLevel()) / 10000.0f;
        this.c = level;
        float f4 = this.b * 0.3f;
        this.d = f4;
        this.h = (f4 + level) / 2000.0f;
        a();
        L();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
        Code(rect.left, rect.right);
    }

    private void Code(long j) {
        this.k = j;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
