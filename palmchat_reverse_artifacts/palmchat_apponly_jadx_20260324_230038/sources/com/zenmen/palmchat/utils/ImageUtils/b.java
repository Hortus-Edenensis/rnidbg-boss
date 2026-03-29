package com.zenmen.palmchat.utils.ImageUtils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.TypedValue;
import android.view.View;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RectF f15708a;
    public Rect b;
    public Matrix c;
    public RectF d;
    public View h;
    public boolean i;
    public int j;
    public boolean m;
    public float n;
    public float o;
    public float p;
    public boolean q;
    public final Paint e = new Paint();
    public final Paint f = new Paint();
    public final Paint g = new Paint();
    public EnumC1121b k = EnumC1121b.None;
    public a l = a.Changing;

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        Changing,
        Always,
        Never
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.utils.ImageUtils.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public enum EnumC1121b {
        None,
        Move,
        Grow
    }

    public b(View view) {
        this.h = view;
        l(view.getContext());
    }

    public final Rect a() {
        RectF rectF = this.f15708a;
        RectF rectF2 = new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom);
        this.c.mapRect(rectF2);
        return new Rect(Math.round(rectF2.left), Math.round(rectF2.top), Math.round(rectF2.right), Math.round(rectF2.bottom));
    }

    public final float b(float f) {
        return f * this.h.getResources().getDisplayMetrics().density;
    }

    public void c(Canvas canvas) {
        canvas.save();
        Path path = new Path();
        this.f.setStrokeWidth(this.p);
        if (!k()) {
            this.f.setColor(-16777216);
            canvas.drawRect(this.b, this.f);
            return;
        }
        Rect rect = new Rect();
        this.h.getDrawingRect(rect);
        path.addRect(new RectF(this.b), Path.Direction.CW);
        this.f.setColor(this.j);
        if (n(canvas)) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawRect(rect, this.e);
        } else {
            e(canvas);
        }
        canvas.restore();
        canvas.drawPath(path, this.f);
        if (this.i) {
            f(canvas);
        }
        a aVar = this.l;
        if (aVar == a.Always || (aVar == a.Changing && this.k == EnumC1121b.Grow)) {
            d(canvas);
        }
    }

    public final void d(Canvas canvas) {
        Rect rect = this.b;
        int i = rect.left;
        int i2 = ((rect.right - i) / 2) + i;
        int i3 = rect.top;
        int i4 = i3 + ((rect.bottom - i3) / 2);
        float f = i;
        float f2 = i4;
        canvas.drawCircle(f, f2, this.o, this.g);
        float f3 = i2;
        canvas.drawCircle(f3, this.b.top, this.o, this.g);
        canvas.drawCircle(this.b.right, f2, this.o, this.g);
        canvas.drawCircle(f3, this.b.bottom, this.o, this.g);
    }

    public final void e(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), this.b.top, this.e);
        canvas.drawRect(0.0f, this.b.bottom, canvas.getWidth(), canvas.getHeight(), this.e);
        Rect rect = this.b;
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom, this.e);
        Rect rect2 = this.b;
        canvas.drawRect(rect2.right, rect2.top, canvas.getWidth(), this.b.bottom, this.e);
    }

    public final void f(Canvas canvas) {
        this.f.setStrokeWidth(1.0f);
        Rect rect = this.b;
        int i = rect.right;
        int i2 = rect.left;
        float f = (i - i2) / 3;
        int i3 = rect.bottom;
        int i4 = rect.top;
        float f2 = (i3 - i4) / 3;
        canvas.drawLine(i2 + f, i4, i2 + f, i3, this.f);
        int i5 = this.b.left;
        float f3 = f * 2.0f;
        canvas.drawLine(i5 + f3, r0.top, i5 + f3, r0.bottom, this.f);
        Rect rect2 = this.b;
        float f4 = rect2.left;
        int i6 = rect2.top;
        canvas.drawLine(f4, i6 + f2, rect2.right, i6 + f2, this.f);
        Rect rect3 = this.b;
        float f5 = rect3.left;
        int i7 = rect3.top;
        float f6 = f2 * 2.0f;
        canvas.drawLine(f5, i7 + f6, rect3.right, i7 + f6, this.f);
    }

    public int g(float f, float f2) {
        Rect rectA = a();
        boolean z = false;
        boolean z2 = f2 >= ((float) rectA.top) - 20.0f && f2 < ((float) rectA.bottom) + 20.0f;
        int i = rectA.left;
        if (f >= i - 20.0f && f < rectA.right + 20.0f) {
            z = true;
        }
        int i2 = (Math.abs(((float) i) - f) >= 20.0f || !z2) ? 1 : 3;
        if (Math.abs(rectA.right - f) < 20.0f && z2) {
            i2 |= 4;
        }
        if (Math.abs(rectA.top - f2) < 20.0f && z) {
            i2 |= 8;
        }
        if (Math.abs(rectA.bottom - f2) < 20.0f && z) {
            i2 |= 16;
        }
        if (i2 == 1 && rectA.contains((int) f, (int) f2)) {
            return 32;
        }
        return i2;
    }

    public Rect h(float f) {
        RectF rectF = this.f15708a;
        return new Rect((int) (rectF.left * f), (int) (rectF.top * f), (int) (rectF.right * f), (int) (rectF.bottom * f));
    }

    public void i(float f, float f2) {
        if (this.m) {
            if (f != 0.0f) {
                f2 = f / this.n;
            } else if (f2 != 0.0f) {
                f = this.n * f2;
            }
        }
        RectF rectF = new RectF(this.f15708a);
        if (f > 0.0f && rectF.width() + (f * 2.0f) > this.d.width()) {
            f = (this.d.width() - rectF.width()) / 2.0f;
            if (this.m) {
                f2 = f / this.n;
            }
        }
        if (f2 > 0.0f && rectF.height() + (f2 * 2.0f) > this.d.height()) {
            f2 = (this.d.height() - rectF.height()) / 2.0f;
            if (this.m) {
                f = this.n * f2;
            }
        }
        rectF.inset(-f, -f2);
        if (rectF.width() < 25.0f) {
            rectF.inset((-(25.0f - rectF.width())) / 2.0f, 0.0f);
        }
        float f3 = this.m ? 25.0f / this.n : 25.0f;
        if (rectF.height() < f3) {
            rectF.inset(0.0f, (-(f3 - rectF.height())) / 2.0f);
        }
        float f4 = rectF.left;
        RectF rectF2 = this.d;
        float f5 = rectF2.left;
        if (f4 < f5) {
            rectF.offset(f5 - f4, 0.0f);
        } else {
            float f6 = rectF.right;
            float f7 = rectF2.right;
            if (f6 > f7) {
                rectF.offset(-(f6 - f7), 0.0f);
            }
        }
        float f8 = rectF.top;
        RectF rectF3 = this.d;
        float f9 = rectF3.top;
        if (f8 < f9) {
            rectF.offset(0.0f, f9 - f8);
        } else {
            float f10 = rectF.bottom;
            float f11 = rectF3.bottom;
            if (f10 > f11) {
                rectF.offset(0.0f, -(f10 - f11));
            }
        }
        this.f15708a.set(rectF);
        this.b = a();
        this.h.invalidate();
    }

    public void j(int i, float f, float f2) {
        Rect rectA = a();
        if (i == 32) {
            o(f * (this.f15708a.width() / rectA.width()), f2 * (this.f15708a.height() / rectA.height()));
            return;
        }
        if ((i & 6) == 0) {
            f = 0.0f;
        }
        if ((i & 24) == 0) {
            f2 = 0.0f;
        }
        i(((i & 2) != 0 ? -1 : 1) * f * (this.f15708a.width() / rectA.width()), ((i & 8) == 0 ? 1 : -1) * f2 * (this.f15708a.height() / rectA.height()));
    }

    public boolean k() {
        return this.q;
    }

    public final void l(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.cropImageStyle, typedValue, true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(typedValue.resourceId, R.styleable.CropImageView);
        try {
            this.i = typedArrayObtainStyledAttributes.getBoolean(34, false);
            this.j = typedArrayObtainStyledAttributes.getColor(32, -13388315);
            this.l = a.values()[typedArrayObtainStyledAttributes.getInt(33, 0)];
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void m() {
        this.b = a();
    }

    @SuppressLint({"NewApi"})
    public final boolean n(Canvas canvas) {
        return true;
    }

    public void o(float f, float f2) {
        Rect rect = new Rect(this.b);
        this.f15708a.offset(f, f2);
        RectF rectF = this.f15708a;
        rectF.offset(Math.max(0.0f, this.d.left - rectF.left), Math.max(0.0f, this.d.top - this.f15708a.top));
        RectF rectF2 = this.f15708a;
        rectF2.offset(Math.min(0.0f, this.d.right - rectF2.right), Math.min(0.0f, this.d.bottom - this.f15708a.bottom));
        Rect rectA = a();
        this.b = rectA;
        rect.union(rectA);
        float f3 = this.o;
        rect.inset(-((int) f3), -((int) f3));
        this.h.invalidate(rect);
    }

    public void p(boolean z) {
        this.q = z;
    }

    public void q(EnumC1121b enumC1121b) {
        if (enumC1121b != this.k) {
            this.k = enumC1121b;
            this.h.invalidate();
        }
    }

    public void r(Matrix matrix, Rect rect, RectF rectF, boolean z) {
        this.c = new Matrix(matrix);
        this.f15708a = rectF;
        this.d = new RectF(rect);
        this.m = z;
        this.n = this.f15708a.width() / this.f15708a.height();
        this.b = a();
        this.e.setARGB(125, 50, 50, 50);
        this.f.setStyle(Paint.Style.STROKE);
        this.f.setAntiAlias(true);
        this.p = b(2.0f);
        this.g.setColor(this.j);
        this.g.setStyle(Paint.Style.FILL);
        this.g.setAntiAlias(true);
        this.o = b(12.0f);
        this.k = EnumC1121b.None;
    }
}
