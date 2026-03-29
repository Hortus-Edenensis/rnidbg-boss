package defpackage;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class kn5 {
    public int A;
    public int B;
    public int C;
    public int D;
    public StaticLayout E;
    public StaticLayout F;
    public int G;
    public int H;
    public int I;
    public Rect J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f18728a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final TextPaint f;
    public final Paint g;
    public final Paint h;

    @Nullable
    public CharSequence i;

    @Nullable
    public Layout.Alignment j;

    @Nullable
    public Bitmap k;
    public float l;
    public int m;
    public int n;
    public float o;
    public int p;
    public float q;
    public float r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public float x;
    public float y;
    public float z;

    public kn5(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.d = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        typedArrayObtainStyledAttributes.recycle();
        float fRound = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f18728a = fRound;
        this.b = fRound;
        this.c = fRound;
        TextPaint textPaint = new TextPaint();
        this.f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    public static boolean a(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }

    public void b(pr0 pr0Var, oz ozVar, float f, float f2, float f3, Canvas canvas, int i, int i2, int i3, int i4) {
        int i5;
        boolean z = pr0Var.d == null;
        if (!z) {
            i5 = -16777216;
        } else if (TextUtils.isEmpty(pr0Var.f20082a)) {
            return;
        } else {
            i5 = pr0Var.l ? pr0Var.m : ozVar.c;
        }
        if (a(this.i, pr0Var.f20082a) && g86.c(this.j, pr0Var.b) && this.k == pr0Var.d && this.l == pr0Var.e && this.m == pr0Var.f && g86.c(Integer.valueOf(this.n), Integer.valueOf(pr0Var.g)) && this.o == pr0Var.h && g86.c(Integer.valueOf(this.p), Integer.valueOf(pr0Var.i)) && this.q == pr0Var.j && this.r == pr0Var.k && this.s == ozVar.f19903a && this.t == ozVar.b && this.u == i5 && this.w == ozVar.d && this.v == ozVar.e && g86.c(this.f.getTypeface(), ozVar.f) && this.x == f && this.y == f2 && this.z == f3 && this.A == i && this.B == i2 && this.C == i3 && this.D == i4) {
            d(canvas, z);
            return;
        }
        this.i = pr0Var.f20082a;
        this.j = pr0Var.b;
        this.k = pr0Var.d;
        this.l = pr0Var.e;
        this.m = pr0Var.f;
        this.n = pr0Var.g;
        this.o = pr0Var.h;
        this.p = pr0Var.i;
        this.q = pr0Var.j;
        this.r = pr0Var.k;
        this.s = ozVar.f19903a;
        this.t = ozVar.b;
        this.u = i5;
        this.w = ozVar.d;
        this.v = ozVar.e;
        this.f.setTypeface(ozVar.f);
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.A = i;
        this.B = i2;
        this.C = i3;
        this.D = i4;
        if (z) {
            vh.e(this.i);
            g();
        } else {
            vh.e(this.k);
            f();
        }
        d(canvas, z);
    }

    public final void c(Canvas canvas) {
        canvas.drawBitmap(this.k, (Rect) null, this.J, this.h);
    }

    public final void d(Canvas canvas, boolean z) {
        if (z) {
            e(canvas);
            return;
        }
        vh.e(this.J);
        vh.e(this.k);
        c(canvas);
    }

    public final void e(Canvas canvas) {
        StaticLayout staticLayout = this.E;
        StaticLayout staticLayout2 = this.F;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.G, this.H);
        if (Color.alpha(this.u) > 0) {
            this.g.setColor(this.u);
            canvas.drawRect(-this.I, 0.0f, staticLayout.getWidth() + this.I, staticLayout.getHeight(), this.g);
        }
        int i = this.w;
        if (i == 1) {
            this.f.setStrokeJoin(Paint.Join.ROUND);
            this.f.setStrokeWidth(this.f18728a);
            this.f.setColor(this.v);
            this.f.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas);
        } else if (i == 2) {
            TextPaint textPaint = this.f;
            float f = this.b;
            float f2 = this.c;
            textPaint.setShadowLayer(f, f2, f2, this.v);
        } else if (i == 3 || i == 4) {
            boolean z = i == 3;
            int i2 = z ? -1 : this.v;
            int i3 = z ? this.v : -1;
            float f3 = this.b / 2.0f;
            this.f.setColor(this.s);
            this.f.setStyle(Paint.Style.FILL);
            float f4 = -f3;
            this.f.setShadowLayer(this.b, f4, f4, i2);
            staticLayout2.draw(canvas);
            this.f.setShadowLayer(this.b, f3, f3, i3);
        }
        this.f.setColor(this.s);
        this.f.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas.restoreToCount(iSave);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f() {
        float f;
        int i;
        float f2;
        Bitmap bitmap = this.k;
        int i2 = this.C;
        int i3 = this.A;
        int i4 = this.D;
        int i5 = this.B;
        float f3 = i2 - i3;
        float f4 = i3 + (this.o * f3);
        float f5 = i4 - i5;
        float f6 = i5 + (this.l * f5);
        int iRound = Math.round(f3 * this.q);
        float f7 = this.r;
        int iRound2 = f7 != -3.4028235E38f ? Math.round(f5 * f7) : Math.round(iRound * (bitmap.getHeight() / bitmap.getWidth()));
        int i6 = this.p;
        if (i6 != 2) {
            if (i6 == 1) {
                f = iRound / 2;
            }
            int iRound3 = Math.round(f4);
            i = this.n;
            if (i == 2) {
                if (i == 1) {
                    f2 = iRound2 / 2;
                }
                int iRound4 = Math.round(f6);
                this.J = new Rect(iRound3, iRound4, iRound + iRound3, iRound2 + iRound4);
            }
            f2 = iRound2;
            f6 -= f2;
            int iRound42 = Math.round(f6);
            this.J = new Rect(iRound3, iRound42, iRound + iRound3, iRound2 + iRound42);
        }
        f = iRound;
        f4 -= f;
        int iRound32 = Math.round(f4);
        i = this.n;
        if (i == 2) {
        }
        f6 -= f2;
        int iRound422 = Math.round(f6);
        this.J = new Rect(iRound32, iRound422, iRound + iRound32, iRound2 + iRound422);
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g() {
        int i;
        int i2;
        int iMax;
        int iMin;
        int iRound;
        int i3;
        int i4;
        int i5;
        CharSequence charSequence = this.i;
        SpannableStringBuilder spannableStringBuilder = charSequence instanceof SpannableStringBuilder ? (SpannableStringBuilder) charSequence : new SpannableStringBuilder(this.i);
        int i6 = this.C - this.A;
        int i7 = this.D - this.B;
        this.f.setTextSize(this.x);
        int i8 = (int) ((this.x * 0.125f) + 0.5f);
        int i9 = i8 * 2;
        int i10 = i6 - i9;
        float f = this.q;
        if (f != -3.4028235E38f) {
            i10 = (int) (i10 * f);
        }
        int i11 = i10;
        if (i11 <= 0) {
            y53.i("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (this.y > 0.0f) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) this.y), 0, spannableStringBuilder.length(), 16711680);
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
        if (this.w == 1) {
            for (ForegroundColorSpan foregroundColorSpan : (ForegroundColorSpan[]) spannableStringBuilder2.getSpans(0, spannableStringBuilder2.length(), ForegroundColorSpan.class)) {
                spannableStringBuilder2.removeSpan(foregroundColorSpan);
            }
        }
        if (Color.alpha(this.t) > 0) {
            int i12 = this.w;
            if (i12 == 0 || i12 == 2) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.t), 0, spannableStringBuilder.length(), 16711680);
            } else {
                spannableStringBuilder2.setSpan(new BackgroundColorSpan(this.t), 0, spannableStringBuilder2.length(), 16711680);
            }
        }
        Layout.Alignment alignment = this.j;
        if (alignment == null) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        }
        Layout.Alignment alignment2 = alignment;
        StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, this.f, i11, alignment2, this.d, this.e, true);
        this.E = staticLayout;
        int height = staticLayout.getHeight();
        int lineCount = this.E.getLineCount();
        int iMax2 = 0;
        for (int i13 = 0; i13 < lineCount; i13++) {
            iMax2 = Math.max((int) Math.ceil(this.E.getLineWidth(i13)), iMax2);
        }
        if (this.q == -3.4028235E38f || iMax2 >= i11) {
            i11 = iMax2;
        }
        int i14 = i11 + i9;
        float f2 = this.o;
        if (f2 != -3.4028235E38f) {
            int iRound2 = Math.round(i6 * f2);
            int i15 = this.A;
            int i16 = iRound2 + i15;
            int i17 = this.p;
            i = 1;
            if (i17 != 1) {
                i2 = 2;
                if (i17 == 2) {
                    i16 -= i14;
                }
            } else {
                i2 = 2;
                i16 = ((i16 * 2) - i14) / 2;
            }
            iMax = Math.max(i16, i15);
            iMin = Math.min(i14 + iMax, this.C);
        } else {
            i = 1;
            i2 = 2;
            iMax = ((i6 - i14) / 2) + this.A;
            iMin = iMax + i14;
        }
        int i18 = iMin - iMax;
        if (i18 <= 0) {
            y53.i("SubtitlePainter", "Skipped drawing subtitle cue (invalid horizontal positioning)");
            return;
        }
        float f3 = this.l;
        if (f3 != -3.4028235E38f) {
            if (this.m == 0) {
                iRound = Math.round(i7 * f3) + this.B;
                int i19 = this.n;
                if (i19 == i2) {
                    iRound -= height;
                } else if (i19 == i) {
                    iRound = ((iRound * 2) - height) / i2;
                }
                i4 = iRound + height;
                i5 = this.D;
                if (i4 > i5) {
                    iRound = i5 - height;
                } else {
                    int i20 = this.B;
                    if (iRound < i20) {
                        i3 = i20;
                    }
                }
            } else {
                int lineBottom = this.E.getLineBottom(0) - this.E.getLineTop(0);
                float f4 = this.l;
                if (f4 >= 0.0f) {
                    iRound = Math.round(f4 * lineBottom) + this.B;
                    i4 = iRound + height;
                    i5 = this.D;
                    if (i4 > i5) {
                    }
                } else {
                    iRound = Math.round((f4 + 1.0f) * lineBottom) + this.D;
                    iRound -= height;
                    i4 = iRound + height;
                    i5 = this.D;
                    if (i4 > i5) {
                    }
                }
            }
            this.E = new StaticLayout(spannableStringBuilder, this.f, i18, alignment2, this.d, this.e, true);
            this.F = new StaticLayout(spannableStringBuilder2, this.f, i18, alignment2, this.d, this.e, true);
            this.G = iMax;
            this.H = i3;
            this.I = i8;
        }
        iRound = (this.D - height) - ((int) (i7 * this.z));
        i3 = iRound;
        this.E = new StaticLayout(spannableStringBuilder, this.f, i18, alignment2, this.d, this.e, true);
        this.F = new StaticLayout(spannableStringBuilder2, this.f, i18, alignment2, this.d, this.e, true);
        this.G = iMax;
        this.H = i3;
        this.I = i8;
    }
}
