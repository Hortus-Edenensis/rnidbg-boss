package com.opos.exoplayer.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import com.opos.exoplayer.core.text.CaptionStyleCompat;
import com.opos.exoplayer.core.text.Cue;
import com.opos.exoplayer.core.util.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class d {
    private float A;
    private float B;
    private int C;
    private int D;
    private int E;
    private int F;
    private StaticLayout G;
    private int H;
    private int I;
    private int J;
    private Rect K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RectF f8450a = new RectF();
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final float f;
    private final float g;
    private final TextPaint h;
    private final Paint i;
    private CharSequence j;
    private Layout.Alignment k;
    private Bitmap l;
    private float m;
    private int n;
    private int o;
    private float p;
    private int q;
    private float r;
    private float s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public d(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.g = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        typedArrayObtainStyledAttributes.recycle();
        float fRound = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.b = fRound;
        this.c = fRound;
        this.d = fRound;
        this.e = fRound;
        TextPaint textPaint = new TextPaint();
        this.h = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.i = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0161  */
    /* JADX WARN: Type inference failed for: r17v0, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r8v17, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a() {
        ?? spannableStringBuilder;
        int iMax;
        int iMin;
        int i;
        int iRound;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = this.E - this.C;
        int i7 = this.F - this.D;
        this.h.setTextSize(this.A);
        int i8 = (int) ((this.A * 0.125f) + 0.5f);
        int i9 = i8 * 2;
        int i10 = i6 - i9;
        float f = this.r;
        if (f != Float.MIN_VALUE) {
            i10 = (int) (i10 * f);
        }
        if (i10 <= 0) {
            com.opos.cmn.an.f.a.c("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (this.u && this.t) {
            spannableStringBuilder = this.j;
        } else if (this.t) {
            spannableStringBuilder = new SpannableStringBuilder(this.j);
            int length = spannableStringBuilder.length();
            AbsoluteSizeSpan[] absoluteSizeSpanArr = (AbsoluteSizeSpan[]) spannableStringBuilder.getSpans(0, length, AbsoluteSizeSpan.class);
            RelativeSizeSpan[] relativeSizeSpanArr = (RelativeSizeSpan[]) spannableStringBuilder.getSpans(0, length, RelativeSizeSpan.class);
            for (AbsoluteSizeSpan absoluteSizeSpan : absoluteSizeSpanArr) {
                spannableStringBuilder.removeSpan(absoluteSizeSpan);
            }
            for (RelativeSizeSpan relativeSizeSpan : relativeSizeSpanArr) {
                spannableStringBuilder.removeSpan(relativeSizeSpan);
            }
        } else {
            spannableStringBuilder = this.j.toString();
        }
        ?? r17 = spannableStringBuilder;
        Layout.Alignment alignment = this.k;
        if (alignment == null) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        }
        Layout.Alignment alignment2 = alignment;
        StaticLayout staticLayout = new StaticLayout(r17, this.h, i10, alignment2, this.f, this.g, true);
        this.G = staticLayout;
        int height = staticLayout.getHeight();
        int lineCount = this.G.getLineCount();
        int iMax2 = 0;
        for (int i11 = 0; i11 < lineCount; i11++) {
            iMax2 = Math.max((int) Math.ceil(this.G.getLineWidth(i11)), iMax2);
        }
        if (this.r == Float.MIN_VALUE || iMax2 >= i10) {
            i10 = iMax2;
        }
        int i12 = i10 + i9;
        float f2 = this.p;
        if (f2 != Float.MIN_VALUE) {
            int iRound2 = Math.round(i6 * f2);
            int i13 = this.C;
            int i14 = iRound2 + i13;
            int i15 = this.q;
            if (i15 == 2) {
                i14 -= i12;
            } else if (i15 == 1) {
                i14 = ((i14 * 2) - i12) / 2;
            }
            iMax = Math.max(i14, i13);
            iMin = Math.min(i12 + iMax, this.E);
        } else {
            iMax = (i6 - i12) / 2;
            iMin = iMax + i12;
        }
        int i16 = iMin - iMax;
        if (i16 <= 0) {
            com.opos.cmn.an.f.a.c("SubtitlePainter", "Skipped drawing subtitle cue (invalid horizontal positioning)");
            return;
        }
        float f3 = this.m;
        if (f3 != Float.MIN_VALUE) {
            if (this.n == 0) {
                iRound = Math.round(i7 * f3);
            } else {
                int lineBottom = this.G.getLineBottom(0) - this.G.getLineTop(0);
                float f4 = this.m;
                if (f4 >= 0.0f) {
                    iRound = Math.round(f4 * lineBottom);
                } else {
                    iRound = Math.round((f4 + 1.0f) * lineBottom);
                    i2 = this.F;
                    i = iRound + i2;
                    i3 = this.o;
                    if (i3 != 2) {
                        i -= height;
                    } else if (i3 == 1) {
                        i = ((i * 2) - height) / 2;
                    }
                    i4 = i + height;
                    i5 = this.F;
                    if (i4 <= i5) {
                        i = i5 - height;
                    } else {
                        int i17 = this.D;
                        if (i < i17) {
                            i = i17;
                        }
                    }
                }
            }
            i2 = this.D;
            i = iRound + i2;
            i3 = this.o;
            if (i3 != 2) {
            }
            i4 = i + height;
            i5 = this.F;
            if (i4 <= i5) {
            }
        } else {
            i = (this.F - height) - ((int) (i7 * this.B));
        }
        this.G = new StaticLayout(r17, this.h, i16, alignment2, this.f, this.g, true);
        this.H = iMax;
        this.I = i;
        this.J = i8;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b() {
        float f;
        int i;
        float f2;
        int i2 = this.E;
        int i3 = this.C;
        int i4 = this.F;
        int i5 = this.D;
        float f3 = i2 - i3;
        float f4 = i3 + (this.p * f3);
        float f5 = i4 - i5;
        float f6 = i5 + (this.m * f5);
        int iRound = Math.round(f3 * this.r);
        float height = this.s;
        if (height == Float.MIN_VALUE) {
            f5 = iRound;
            height = this.l.getHeight() / this.l.getWidth();
        }
        int iRound2 = Math.round(f5 * height);
        int i6 = this.o;
        if (i6 != 2) {
            if (i6 == 1) {
                f = iRound / 2;
            }
            int iRound3 = Math.round(f4);
            i = this.q;
            if (i == 2) {
                if (i == 1) {
                    f2 = iRound2 / 2;
                }
                int iRound4 = Math.round(f6);
                this.K = new Rect(iRound3, iRound4, iRound + iRound3, iRound2 + iRound4);
            }
            f2 = iRound2;
            f6 -= f2;
            int iRound42 = Math.round(f6);
            this.K = new Rect(iRound3, iRound42, iRound + iRound3, iRound2 + iRound42);
        }
        f = iRound;
        f4 -= f;
        int iRound32 = Math.round(f4);
        i = this.q;
        if (i == 2) {
        }
        f6 -= f2;
        int iRound422 = Math.round(f6);
        this.K = new Rect(iRound32, iRound422, iRound + iRound32, iRound2 + iRound422);
    }

    private void a(Canvas canvas) {
        StaticLayout staticLayout = this.G;
        if (staticLayout == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.H, this.I);
        if (Color.alpha(this.x) > 0) {
            this.i.setColor(this.x);
            canvas.drawRect(-this.J, 0.0f, staticLayout.getWidth() + this.J, staticLayout.getHeight(), this.i);
        }
        if (Color.alpha(this.w) > 0) {
            this.i.setColor(this.w);
            float lineTop = staticLayout.getLineTop(0);
            int lineCount = staticLayout.getLineCount();
            int i = 0;
            while (i < lineCount) {
                this.f8450a.left = staticLayout.getLineLeft(i) - this.J;
                this.f8450a.right = staticLayout.getLineRight(i) + this.J;
                RectF rectF = this.f8450a;
                rectF.top = lineTop;
                rectF.bottom = staticLayout.getLineBottom(i);
                RectF rectF2 = this.f8450a;
                float f = rectF2.bottom;
                float f2 = this.b;
                canvas.drawRoundRect(rectF2, f2, f2, this.i);
                i++;
                lineTop = f;
            }
        }
        int i2 = this.z;
        if (i2 == 1) {
            this.h.setStrokeJoin(Paint.Join.ROUND);
            this.h.setStrokeWidth(this.c);
            this.h.setColor(this.y);
            this.h.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout.draw(canvas);
        } else if (i2 == 2) {
            TextPaint textPaint = this.h;
            float f3 = this.d;
            float f4 = this.e;
            textPaint.setShadowLayer(f3, f4, f4, this.y);
        } else if (i2 == 3 || i2 == 4) {
            boolean z = i2 == 3;
            int i3 = z ? -1 : this.y;
            int i4 = z ? this.y : -1;
            float f5 = this.d / 2.0f;
            this.h.setColor(this.v);
            this.h.setStyle(Paint.Style.FILL);
            float f6 = -f5;
            this.h.setShadowLayer(this.d, f6, f6, i3);
            staticLayout.draw(canvas);
            this.h.setShadowLayer(this.d, f5, f5, i4);
        }
        this.h.setColor(this.v);
        this.h.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.h.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas.restoreToCount(iSave);
    }

    private void b(Canvas canvas) {
        canvas.drawBitmap(this.l, (Rect) null, this.K, (Paint) null);
    }

    private void a(Canvas canvas, boolean z) {
        if (z) {
            a(canvas);
        } else {
            b(canvas);
        }
    }

    public void a(Cue cue, boolean z, boolean z2, CaptionStyleCompat captionStyleCompat, float f, float f2, Canvas canvas, int i, int i2, int i3, int i4) {
        int i5;
        boolean z3 = cue.c == null;
        if (!z3) {
            i5 = -16777216;
        } else if (TextUtils.isEmpty(cue.f8314a)) {
            return;
        } else {
            i5 = (cue.k && z) ? cue.l : captionStyleCompat.d;
        }
        if (a(this.j, cue.f8314a) && y.a(this.k, cue.b) && this.l == cue.c && this.m == cue.d && this.n == cue.e && y.a(Integer.valueOf(this.o), Integer.valueOf(cue.f)) && this.p == cue.g && y.a(Integer.valueOf(this.q), Integer.valueOf(cue.h)) && this.r == cue.i && this.s == cue.j && this.t == z && this.u == z2 && this.v == captionStyleCompat.b && this.w == captionStyleCompat.c && this.x == i5 && this.z == captionStyleCompat.e && this.y == captionStyleCompat.f && y.a(this.h.getTypeface(), captionStyleCompat.g) && this.A == f && this.B == f2 && this.C == i && this.D == i2 && this.E == i3 && this.F == i4) {
            a(canvas, z3);
            return;
        }
        this.j = cue.f8314a;
        this.k = cue.b;
        this.l = cue.c;
        this.m = cue.d;
        this.n = cue.e;
        this.o = cue.f;
        this.p = cue.g;
        this.q = cue.h;
        this.r = cue.i;
        this.s = cue.j;
        this.t = z;
        this.u = z2;
        this.v = captionStyleCompat.b;
        this.w = captionStyleCompat.c;
        this.x = i5;
        this.z = captionStyleCompat.e;
        this.y = captionStyleCompat.f;
        this.h.setTypeface(captionStyleCompat.g);
        this.A = f;
        this.B = f2;
        this.C = i;
        this.D = i2;
        this.E = i3;
        this.F = i4;
        if (z3) {
            a();
        } else {
            b();
        }
        a(canvas, z3);
    }

    private static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }
}
