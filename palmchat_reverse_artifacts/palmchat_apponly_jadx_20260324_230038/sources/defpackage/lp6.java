package defpackage;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class lp6 extends Drawable {
    public static final double q = Math.cos(Math.toRadians(45.0d));
    public static a r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19052a;
    public Paint b;
    public Paint c;
    public Paint d;
    public final RectF e;
    public float f;
    public Path g;
    public float h;
    public float i;
    public float j;
    public float k;
    public int m;
    public int n;
    public boolean l = true;
    public boolean o = true;
    public boolean p = false;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    public lp6(Resources resources, int i, float f, float f2, float f3, int i2, int i3) {
        Log.e("AAA", "RoundRectDrawableWithShadow");
        if (i2 != 0) {
            this.m = i2;
        } else {
            this.m = resources.getColor(R.color.yc_cardview_shadow_start_color);
        }
        if (i3 != 0) {
            this.n = i3;
        } else {
            this.n = resources.getColor(R.color.yc_cardview_shadow_end_color);
        }
        this.f19052a = resources.getDimensionPixelSize(R.dimen.yc_cardview_compat_inset_shadow);
        Paint paint = new Paint(5);
        this.b = paint;
        paint.setColor(i);
        Paint paint2 = new Paint(5);
        this.c = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f = (int) (f + 0.5f);
        this.e = new RectF();
        Paint paint3 = new Paint(this.c);
        this.d = paint3;
        paint3.setAntiAlias(false);
        q(f2, f3);
    }

    public static float c(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - q) * ((double) f2))) : f;
    }

    public static float d(float f, float f2, boolean z) {
        return z ? (float) (((double) (f * 1.5f)) + ((1.0d - q) * ((double) f2))) : f * 1.5f;
    }

    public final void a(Rect rect) {
        float f = this.i;
        float f2 = 1.5f * f;
        this.e.set(rect.left + f, rect.top + f2, rect.right - f, rect.bottom - f2);
        b();
    }

    public final void b() {
        float f = this.f;
        RectF rectF = new RectF(-f, -f, f, f);
        RectF rectF2 = new RectF(rectF);
        float f2 = this.j;
        rectF2.inset(-f2, -f2);
        Path path = this.g;
        if (path == null) {
            this.g = new Path();
        } else {
            path.reset();
        }
        this.g.setFillType(Path.FillType.EVEN_ODD);
        this.g.moveTo(-this.f, 0.0f);
        this.g.rLineTo(-this.j, 0.0f);
        this.g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.g.arcTo(rectF, 270.0f, -90.0f, false);
        this.g.close();
        float f3 = this.f;
        float f4 = f3 / (this.j + f3);
        Paint paint = this.c;
        float f5 = this.f + this.j;
        int i = this.m;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f5, new int[]{i, i, this.n}, new float[]{0.0f, f4, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.d;
        float f6 = this.f;
        float f7 = this.j;
        float f8 = (-f6) + f7;
        float f9 = (-f6) - f7;
        int i2 = this.m;
        paint2.setShader(new LinearGradient(0.0f, f8, 0.0f, f9, new int[]{i2, i2, this.n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.d.setAntiAlias(false);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.l) {
            a(getBounds());
            this.l = false;
        }
        canvas.translate(0.0f, this.k / 2.0f);
        e(canvas);
        canvas.translate(0.0f, (-this.k) / 2.0f);
        r.drawRoundRect(canvas, this.e, this.f, this.b);
    }

    public final void e(Canvas canvas) {
        float f = this.f;
        float f2 = (-f) - this.j;
        float f3 = f + this.f19052a + (this.k / 2.0f);
        float f4 = f3 * 2.0f;
        boolean z = this.e.width() - f4 > 0.0f;
        boolean z2 = this.e.height() - f4 > 0.0f;
        int iSave = canvas.save();
        RectF rectF = this.e;
        canvas.translate(rectF.left + f3, rectF.top + f3);
        canvas.drawPath(this.g, this.c);
        if (z) {
            canvas.drawRect(0.0f, f2, this.e.width() - f4, -this.f, this.d);
        }
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        RectF rectF2 = this.e;
        canvas.translate(rectF2.right - f3, rectF2.bottom - f3);
        canvas.rotate(180.0f);
        canvas.drawPath(this.g, this.c);
        if (z) {
            canvas.drawRect(0.0f, f2, this.e.width() - f4, (-this.f) + this.j, this.d);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        RectF rectF3 = this.e;
        canvas.translate(rectF3.left + f3, rectF3.bottom - f3);
        canvas.rotate(270.0f);
        canvas.drawPath(this.g, this.c);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.e.height() - f4, -this.f, this.d);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        RectF rectF4 = this.e;
        canvas.translate(rectF4.right - f3, rectF4.top + f3);
        canvas.rotate(90.0f);
        canvas.drawPath(this.g, this.c);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.e.height() - f4, -this.f, this.d);
        }
        canvas.restoreToCount(iSave4);
    }

    public float f() {
        return this.f;
    }

    public void g(Rect rect) {
        getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(d(this.i, this.f, this.o));
        int iCeil2 = (int) Math.ceil(c(this.i, this.f, this.o));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    public float h() {
        return this.i;
    }

    public float i() {
        float f = this.i;
        return (Math.max(f, this.f + this.f19052a + ((f * 1.5f) / 2.0f)) * 2.0f) + (((this.i * 1.5f) + this.f19052a) * 2.0f);
    }

    public float j() {
        float f = this.i;
        return (Math.max(f, this.f + this.f19052a + (f / 2.0f)) * 2.0f) + ((this.i + this.f19052a) * 2.0f);
    }

    public float k() {
        return this.k;
    }

    public void l(boolean z) {
        this.o = z;
        invalidateSelf();
    }

    public void m(int i) {
        this.b.setColor(i);
        invalidateSelf();
    }

    public void n(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
        }
        float f2 = (int) (f + 0.5f);
        if (this.f == f2) {
            return;
        }
        this.f = f2;
        this.l = true;
        invalidateSelf();
    }

    public void o(float f) {
        q(this.k, f);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.l = true;
    }

    public void p(float f) {
        q(f, this.i);
    }

    public void q(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        }
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        }
        float fR = r(f);
        float fR2 = r(f2);
        if (fR > fR2) {
            if (!this.p) {
                this.p = true;
            }
            fR = fR2;
        }
        if (this.k == fR && this.i == fR2) {
            return;
        }
        this.k = fR;
        this.i = fR2;
        int i = this.f19052a;
        this.j = (int) ((fR * 1.5f) + i + 0.5f);
        this.h = fR2 + i;
        this.l = true;
        invalidateSelf();
    }

    public final int r(float f) {
        int i = (int) (f + 0.5f);
        return i % 2 == 1 ? i - 1 : i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.b.setAlpha(i);
        this.c.setAlpha(i);
        this.d.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }
}
