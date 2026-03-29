package com.opos.cmn.module.ui.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f8046a;
    private Paint b;
    private boolean c;
    private RectF d;
    private Path e;
    private Path f;
    private a g;

    @Nullable
    private PorterDuffColorFilter h;

    @Nullable
    private PorterDuffColorFilter i;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public ColorFilter f8047a;

        @Nullable
        public ColorStateList b;

        @Nullable
        public ColorStateList c;

        @Nullable
        public ColorStateList d;

        @Nullable
        public ColorStateList e;

        @Nullable
        public PorterDuff.Mode f;
        public float g;
        public int h;
        public float i;

        public a() {
            this.f8047a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = PorterDuff.Mode.SRC_IN;
            this.h = 255;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            d dVar = new d(this);
            dVar.c = true;
            return dVar;
        }

        public a(a aVar) {
            this.f8047a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = PorterDuff.Mode.SRC_IN;
            this.h = 255;
            this.f8047a = aVar.f8047a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.g = aVar.g;
            this.i = aVar.i;
        }
    }

    public d() {
        this(new a());
    }

    private static int a(int i, int i2) {
        return (i * (i2 + (i2 >>> 7))) >>> 8;
    }

    private boolean d() {
        Paint paint = this.f8046a;
        return ((paint == null || paint.getColor() == 0) && this.h == null) ? false : true;
    }

    private boolean e() {
        Paint paint = this.b;
        return ((paint == null || paint.getStrokeWidth() <= 0.0f || this.b.getColor() == 0) && this.i == null) ? false : true;
    }

    private void f() {
        this.f = g.a(this.f, a(), this.g.i);
    }

    private void g() {
        this.e = g.a(this.e, a(), this.g.i);
    }

    public ColorStateList b() {
        return this.g.b;
    }

    public void c() {
        this.c = false;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.f8046a.setColorFilter(this.h);
        int alpha = this.f8046a.getAlpha();
        this.f8046a.setAlpha(a(alpha, this.g.h));
        this.b.setStrokeWidth(this.g.g);
        this.b.setColorFilter(this.i);
        int alpha2 = this.b.getAlpha();
        this.b.setAlpha(a(alpha2, this.g.h));
        if (this.c) {
            f();
            g();
            this.c = false;
        }
        if (d()) {
            canvas.drawPath(this.e, this.f8046a);
        }
        if (e()) {
            canvas.drawPath(this.f, this.b);
        }
        this.f8046a.setAlpha(alpha);
        this.b.setAlpha(alpha2);
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.c = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.g.e) != null && colorStateList.isStateful()) || (((colorStateList2 = this.g.d) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.g.c) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.g.b) != null && colorStateList4.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.g = new a(this.g);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.c = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean zA = a(iArr);
        if (zA) {
            invalidateSelf();
        }
        return zA;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        a aVar = this.g;
        if (aVar.h != i) {
            aVar.h = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        a aVar = this.g;
        if (aVar.f8047a != colorFilter) {
            aVar.f8047a = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(@ColorInt int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        a aVar = this.g;
        aVar.e = colorStateList;
        PorterDuffColorFilter porterDuffColorFilterA = a(colorStateList, aVar.f);
        this.i = porterDuffColorFilterA;
        this.h = porterDuffColorFilterA;
        c();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        a aVar = this.g;
        aVar.f = mode;
        PorterDuffColorFilter porterDuffColorFilterA = a(aVar.e, mode);
        this.i = porterDuffColorFilterA;
        this.h = porterDuffColorFilterA;
        c();
    }

    public d(@NonNull a aVar) {
        this.f8046a = new Paint(1);
        this.b = new Paint(1);
        this.d = new RectF();
        this.e = new Path();
        this.f = new Path();
        this.g = aVar;
        this.f8046a.setStyle(Paint.Style.FILL);
        this.b.setStyle(Paint.Style.STROKE);
    }

    @NonNull
    private PorterDuffColorFilter a(@Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @NonNull
    public RectF a() {
        this.d.set(getBounds());
        return this.d;
    }

    public void a(float f) {
        this.g.i = f;
    }

    public void a(@ColorInt int i) {
        a(ColorStateList.valueOf(i));
    }

    public void a(ColorStateList colorStateList) {
        a aVar = this.g;
        if (aVar.b != colorStateList) {
            aVar.b = colorStateList;
            onStateChange(getState());
        }
    }

    private boolean a(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.g.b == null || color2 == (colorForState2 = this.g.b.getColorForState(iArr, (color2 = this.f8046a.getColor())))) {
            z = false;
        } else {
            this.f8046a.setColor(colorForState2);
            z = true;
        }
        if (this.g.c == null || color == (colorForState = this.g.c.getColorForState(iArr, (color = this.b.getColor())))) {
            return z;
        }
        this.b.setColor(colorForState);
        return true;
    }
}
