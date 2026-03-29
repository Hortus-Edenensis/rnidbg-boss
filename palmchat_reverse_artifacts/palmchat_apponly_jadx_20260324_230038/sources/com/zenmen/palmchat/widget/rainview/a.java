package com.zenmen.palmchat.widget.rainview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public Paint F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16062a;
    public int b;
    public Random c;
    public int d;
    public int e;
    public float f;
    public float g;
    public int h;
    public int i;
    public float j;
    public float k;
    public float l;
    public float m;
    public int n;
    public int o;
    public float p;
    public float q;
    public float r;
    public float s;
    public float t;
    public float u;
    public Bitmap v;
    public C1149a w;
    public boolean x;
    public boolean y;
    public boolean z;

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap c(Drawable drawable) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public void b(Canvas canvas) {
        e();
        if (this.E) {
            return;
        }
        if (!this.B && !this.C) {
            canvas.drawBitmap(this.v, this.p, this.q, (Paint) null);
            return;
        }
        canvas.save();
        canvas.translate(this.p + (this.v.getWidth() / 2), this.q + (this.v.getHeight() / 2));
        if (this.B) {
            float f = this.s + this.u;
            this.s = f;
            canvas.rotate(f);
        }
        if (!this.C || this.q + this.g <= this.h) {
            Paint paint = this.F;
            if (paint != null) {
                paint.setAlpha(255);
            }
        } else {
            if (this.F == null) {
                this.F = new Paint();
            }
            this.F.setStyle(Paint.Style.STROKE);
            int i = this.h;
            this.F.setAlpha((int) ((((i + r1) - (this.q + this.g)) / this.i) * 255.0f));
        }
        canvas.drawBitmap(this.v, (-r0.getWidth()) / 2, (-this.v.getHeight()) / 2, this.F);
        canvas.restore();
    }

    public synchronized boolean d(float f, float f2) {
        float f3 = this.p;
        float f4 = this.q;
        boolean z = false;
        if (f <= f3 || f2 <= f4) {
            return false;
        }
        float width = this.v.getWidth() + f3;
        float height = this.v.getHeight() + f4;
        if (f < width && f2 < height) {
            z = true;
        }
        return z;
    }

    public final void e() {
        f();
        g();
        if (this.C) {
            if (this.q + this.g > this.h + this.i || this.p < (-this.v.getWidth()) || this.p > this.d + this.v.getWidth()) {
                if (this.D) {
                    this.E = true;
                    return;
                } else {
                    m();
                    return;
                }
            }
            return;
        }
        if (this.q > this.e || this.p < (-this.v.getWidth()) || this.p > this.d + this.v.getWidth()) {
            if (this.D) {
                this.E = true;
            } else {
                m();
            }
        }
    }

    public final void f() {
        this.p = (float) (((double) this.p) + (Math.sin(this.t) * 10.0d));
        if (this.A) {
            this.t = (float) (((double) this.t) + (((double) (this.c.nextBoolean() ? -1 : 1)) * Math.random() * 0.0025d));
        }
    }

    public final void g() {
        this.q += this.r;
    }

    public void h(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    public final void i() {
        this.u = (float) (Math.random() + 0.2d);
    }

    public final void j() {
        if (this.y) {
            float fNextInt = this.c.nextInt(11) * 0.1f * this.m;
            float f = this.l;
            if (fNextInt < f) {
                fNextInt = f;
            }
            Log.e("RainView", fNextInt + "");
            this.v = a(this.w.c, (int) (((float) this.w.c.getWidth()) * fNextInt), (int) (fNextInt * ((float) this.w.c.getHeight())));
        } else {
            this.v = this.w.c;
        }
        this.f = this.v.getWidth();
        this.g = this.v.getHeight();
    }

    public final void k() {
        if (this.x) {
            this.r = ((float) ((((double) (this.c.nextInt(3) + 1)) * 0.1d) + 1.0d)) * this.n;
        } else {
            this.r = this.n;
        }
    }

    public final void l() {
        if (this.z) {
            this.t = (float) (((((double) (this.c.nextBoolean() ? -1 : 1)) * Math.random()) * ((double) this.o)) / 50.0d);
        } else {
            this.t = this.o / 50.0f;
        }
        float f = this.t;
        if (f > 1.5707964f) {
            this.t = 1.5707964f;
        } else if (f < -1.5707964f) {
            this.t = -1.5707964f;
        }
    }

    public final void m() {
        this.p = this.c.nextInt(this.d);
        this.q = -this.g;
        k();
        l();
        i();
    }

    public a(C1149a c1149a, int i, int i2) {
        this.j = 0.7f;
        this.k = 0.2f;
        this.s = 0.0f;
        this.F = null;
        this.c = new Random();
        this.d = i;
        this.e = i2;
        this.w = c1149a;
        this.x = c1149a.d;
        this.y = c1149a.e;
        this.z = c1149a.f;
        this.A = c1149a.g;
        this.B = c1149a.h;
        this.C = c1149a.i;
        this.D = c1149a.j;
        this.o = c1149a.b;
        this.n = c1149a.f16063a;
        this.j = c1149a.k;
        this.k = c1149a.l;
        this.l = c1149a.m;
        this.m = c1149a.n;
        int i3 = this.e;
        this.h = (int) (i3 * this.j);
        this.i = (int) (i3 * this.k);
        this.f16062a = this.c.nextInt(i);
        int iNextInt = this.c.nextInt(i2) - i2;
        this.b = iNextInt;
        this.p = this.f16062a;
        this.q = iNextInt;
        if (this.C) {
            this.F = new Paint();
        }
        k();
        j();
        l();
        i();
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.widget.rainview.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C1149a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16063a;
        public int b;
        public Bitmap c;
        public boolean d;
        public boolean e;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        public float k;
        public float l;
        public float m;
        public float n;

        public C1149a(Object obj) {
            if (obj instanceof Drawable) {
                this.c = a.c((Drawable) obj);
            } else if (obj instanceof Bitmap) {
                this.c = (Bitmap) obj;
            }
            p();
        }

        public a o() {
            return new a(this);
        }

        public void p() {
            this.f16063a = 10;
            this.b = 0;
            this.d = false;
            this.e = false;
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = false;
            this.k = 0.7f;
            this.l = 0.2f;
            this.m = 0.5f;
            this.n = 1.5f;
        }

        public C1149a q(boolean z) {
            this.j = z;
            return this;
        }

        public C1149a r(boolean z, float f, float f2) {
            this.e = z;
            if (f > 0.0f && f2 > 0.0f && f2 > f) {
                this.m = f;
                this.n = f2;
            }
            return this;
        }

        public C1149a s(boolean z) {
            this.h = z;
            return this;
        }

        public C1149a t(int i, int i2) {
            this.c = a.a(this.c, i, i2);
            return this;
        }

        public C1149a u(int i, boolean z) {
            this.f16063a = i;
            this.d = z;
            return this;
        }

        public C1149a v(boolean z) {
            this.i = z;
            return this;
        }

        public C1149a w(float f, float f2) {
            if (f != 0.0f && f2 != 0.0f) {
                this.k = f;
                this.l = f2;
            }
            return this;
        }

        public C1149a x(int i, boolean z, boolean z2) {
            this.b = i;
            this.f = z;
            this.g = z2;
            return this;
        }

        public C1149a(Drawable drawable) {
            this.c = a.c(drawable);
            p();
        }
    }

    public a(C1149a c1149a) {
        this.j = 0.7f;
        this.k = 0.2f;
        this.s = 0.0f;
        this.F = null;
        this.w = c1149a;
        this.n = c1149a.f16063a;
        this.o = c1149a.b;
        this.v = c1149a.c;
        this.x = c1149a.d;
        this.y = c1149a.e;
        this.z = c1149a.f;
        this.A = c1149a.g;
        this.B = c1149a.h;
    }
}
