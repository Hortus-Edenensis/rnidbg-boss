package com.opos.mobad.template.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.core.graphics.ColorUtils;
import com.heytap.msp.mobad.api.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a extends com.opos.mobad.template.cmn.baseview.d {
    private int A;
    private int B;
    private int C;
    private float D;
    private float E;
    private int F;
    private int G;
    private int H;
    private boolean I;
    private int J;
    private int K;
    private int L;
    private int M;
    private com.opos.mobad.template.cmn.q N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f9469a;
    float b;
    float c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private Paint i;
    private Paint j;
    private Paint k;
    private int l;
    private String m;
    private int n;
    private SweepGradient o;
    private LinearGradient p;
    private int[] q;
    private float[] r;
    private Bitmap s;
    private Bitmap t;
    private float u;
    private float v;
    private float w;
    private float x;
    private float y;
    private int z;

    public a(Context context) {
        super(context);
        this.s = null;
        this.t = null;
        this.u = 0.0f;
        this.v = 0.0f;
        this.w = 0.0f;
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.f9469a = 255;
        this.b = 0.0f;
        this.c = 0.0f;
        this.D = 22.0f;
        this.E = 12.0f;
        this.F = 1;
        this.G = 0;
        this.H = 2000;
        if (context == null) {
            return;
        }
        a(context);
        setLayoutParams(new ViewGroup.LayoutParams(-1, this.h));
        this.i = new Paint();
        this.j = new Paint();
        this.k = new Paint();
    }

    private void d() {
        int i = this.F;
        if (i != 0) {
            int i2 = this.G + 1;
            this.G = i2;
            if (i2 >= i) {
                this.G = 0;
                return;
            }
        }
        postInvalidateDelayed(this.H);
    }

    public a a() {
        this.I = true;
        invalidate();
        return this;
    }

    public a b() {
        this.I = false;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public float c() {
        float f;
        float f2 = this.v;
        int i = this.J;
        if (f2 >= i / 6) {
            if (f2 >= i / 5) {
                if (f2 < i / 4) {
                    f = 10.0f;
                } else if (f2 >= i / 3) {
                    if (f2 < i / 2 || f2 < i / 1.8f) {
                        this.E = 14.0f;
                    } else if (f2 < i / 1.5f) {
                        this.E = 12.0f;
                    } else if (f2 < i) {
                        this.E = 8.0f;
                    }
                }
            }
            return this.E;
        }
        f = 6.0f;
        this.E = f;
        return this.E;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
        Bitmap bitmap = this.s;
        if (bitmap != null) {
            bitmap.recycle();
            this.s = null;
        }
        Bitmap bitmap2 = this.t;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.t = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        com.opos.mobad.template.cmn.q qVar = this.N;
        if (qVar != null && qVar.b == 0 && this.F != 0) {
            this.I = false;
        }
        Bitmap bitmap = this.s;
        int i = this.l;
        canvas.drawBitmap(bitmap, (Rect) null, new RectF(i, i, this.J - i, this.K - i), (Paint) null);
        c(canvas);
        float f = this.u;
        boolean z = f < ((float) this.J) + this.b;
        if (z && this.I) {
            a(canvas, f);
        }
        boolean z2 = this.w < ((float) (this.J - (this.M * 2)));
        if (z2 && this.I) {
            b(canvas);
            a(canvas);
        }
        d(canvas);
        if (this.I && !z && !z2) {
            this.u = 0.0f;
            this.v = 0.0f;
            this.w = 0.0f;
            this.x = 0.0f;
            this.z = 0;
            this.B = 0;
            this.y = 0.0f;
            this.f9469a = 255;
            this.A = 0;
            this.C = 0;
            this.E = 12.0f;
            d();
        }
        com.opos.mobad.template.cmn.q qVar2 = this.N;
        if (qVar2 == null || qVar2.b != 1) {
            return;
        }
        this.I = true;
        d();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.K = i2;
        this.J = i;
        this.L = i / 3;
    }

    private void b(Canvas canvas) {
        float f;
        float f2;
        this.k.reset();
        this.k.setAntiAlias(true);
        this.k.setStrokeWidth(this.l);
        float fC = this.v + c();
        this.v = fC;
        int i = this.e;
        if (fC < this.L) {
            i = this.f;
            int i2 = this.M;
            f = i2;
            f2 = i2 + fC;
        } else {
            float fC2 = this.w + c();
            this.w = fC2;
            f = this.l + fC2 + this.M;
            f2 = this.L + f;
        }
        float f3 = f2;
        float f4 = f;
        int i3 = this.e;
        if (this.A > 255) {
            i3 = this.g;
            int i4 = this.z + 5;
            this.z = i4;
            int i5 = 255 - i4;
            if (i5 <= 0) {
                i5 = 0;
            }
            this.k.setAlpha(i5);
        }
        int i6 = this.A + 5;
        this.A = i6;
        if (i6 <= 255) {
            this.k.setAlpha(i6);
        }
        if (this.A >= 255) {
            this.A = 256;
        }
        int i7 = this.g;
        this.q = new int[]{i, i7, i7, i7, i3};
        this.r = new float[]{0.05f, 0.3f, 0.5f, 0.9f, 1.0f};
        int i8 = this.l;
        LinearGradient linearGradient = new LinearGradient(f4, i8, f3, i8, this.q, this.r, Shader.TileMode.CLAMP);
        this.p = linearGradient;
        this.k.setShader(linearGradient);
        int i9 = this.l;
        canvas.drawLine(f4, i9, f3, i9, this.k);
        invalidate();
    }

    private void c(Canvas canvas) {
        this.i.reset();
        this.i.setAntiAlias(true);
        Paint paint = this.i;
        int i = this.d;
        if (i == 0) {
            i = -16777216;
        }
        paint.setColor(i);
        this.i.setShader(this.o);
        this.i.setStrokeWidth(this.l);
        this.i.setStyle(Paint.Style.STROKE);
        int i2 = this.l;
        RectF rectF = new RectF(i2, i2, this.J - i2, this.h - i2);
        int i3 = this.K;
        canvas.drawRoundRect(rectF, i3 / 2, i3 / 2, this.i);
    }

    private void d(Canvas canvas) {
        if (TextUtils.isEmpty(this.m)) {
            return;
        }
        this.j.reset();
        this.j.setAntiAlias(true);
        Paint paint = this.j;
        int color = this.d;
        if (color == 0) {
            color = Color.parseColor("#25A0D1");
        }
        paint.setColor(color);
        this.j.setTextSize(this.n);
        this.j.setStrokeWidth(0.8f);
        this.j.setStyle(Paint.Style.FILL_AND_STROKE);
        Rect rect = new Rect();
        Paint paint2 = this.j;
        String str = this.m;
        paint2.getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(this.m, (this.J - rect.width()) / 2, ((this.K / 2) + (rect.height() / 2)) - this.l, this.j);
    }

    public a a(int i, boolean z) {
        this.d = i;
        float[] fArr = new float[3];
        ColorUtils.colorToHSL(i, fArr);
        fArr[1] = fArr[1] / 1.5f;
        fArr[2] = fArr[2] / 1.5f;
        int iHSLToColor = ColorUtils.HSLToColor(fArr);
        this.e = iHSLToColor;
        this.o = new SweepGradient(this.J / 2, this.K / 2, new int[]{i, iHSLToColor, iHSLToColor, iHSLToColor, i, i, iHSLToColor, iHSLToColor, i}, new float[]{0.002f, 0.026f, 0.03f, 0.4558f, 0.5f, 0.51f, 0.528f, 0.96f, 1.0f});
        float[] fArr2 = new float[3];
        ColorUtils.colorToHSL(i, fArr2);
        fArr2[1] = fArr2[1] / 2.0f;
        fArr2[2] = fArr2[2] / 1.5f;
        this.g = ColorUtils.HSLToColor(fArr2);
        this.f = ColorUtils.HSLToColor(fArr2);
        return this;
    }

    public a a(String str) {
        this.m = str;
        return this;
    }

    private void a(Context context) {
        this.h = com.opos.cmn.an.h.f.a.a(context, 44.0f);
        this.l = com.opos.cmn.an.h.f.a.a(context, 2.0f);
        this.n = com.opos.cmn.an.h.f.a.a(context, 16.0f);
        this.b = com.opos.cmn.an.h.f.a.a(context, 100.0f);
        this.c = com.opos.cmn.an.h.f.a.a(context, 60.0f);
        this.M = com.opos.cmn.an.h.f.a.a(context, 20.0f);
        this.s = BitmapFactory.decodeResource(context.getResources(), R.drawable.opos_mobad_full_button_shading);
        this.t = BitmapFactory.decodeResource(context.getResources(), R.drawable.opos_mobad_full_btn_splash);
    }

    public void a(Canvas canvas) {
        float f;
        float f2;
        this.k.reset();
        this.k.setAntiAlias(true);
        this.k.setStrokeWidth(this.l);
        float fC = this.x + c();
        this.x = fC;
        if (fC < this.L) {
            int i = this.J;
            float f3 = i - fC;
            int i2 = this.M;
            f = f3 - i2;
            f2 = i - i2;
        } else {
            float fC2 = this.y + c();
            this.y = fC2;
            f = (this.J - fC2) - this.M;
            f2 = f - this.L;
        }
        int i3 = this.f;
        double d = f;
        int i4 = this.J;
        int i5 = d < ((double) i4) * 0.9d ? this.e : i3;
        if (f2 < ((double) i4) * 0.8d) {
            i3 = this.e;
        }
        if (this.C >= 255) {
            i3 = this.g;
            int i6 = this.B + 5;
            this.B = i6;
            int i7 = 255 - i6;
            if (i7 <= 0) {
                i7 = 0;
            }
            this.k.setAlpha(i7);
        }
        int i8 = this.C + 5;
        this.C = i8;
        if (i8 <= 255) {
            this.k.setAlpha(i8);
        }
        if (this.C >= 255) {
            this.C = 256;
        }
        int i9 = this.g;
        this.q = new int[]{i5, i9, i9, i9, i3};
        this.r = new float[]{0.05f, 0.3f, 0.5f, 0.9f, 1.0f};
        int i10 = this.K;
        int i11 = this.l;
        float f4 = f2;
        LinearGradient linearGradient = new LinearGradient(f, i10 - i11, f4, i10 - i11, this.q, this.r, Shader.TileMode.CLAMP);
        this.p = linearGradient;
        this.k.setShader(linearGradient);
        int i12 = this.K;
        int i13 = this.l;
        canvas.drawLine(f, i12 - i13, f4, i12 - i13, this.k);
        invalidate();
    }

    private void a(Canvas canvas, float f) {
        this.u += this.D;
        float f2 = this.b;
        Bitmap bitmap = this.t;
        int i = this.l;
        canvas.drawBitmap(bitmap, (Rect) null, new RectF((f2 - (2.0f * f2)) + f, i * 0.5f, f, this.h - (i * 1.5f)), (Paint) null);
        invalidate();
    }

    public void a(com.opos.mobad.template.cmn.q qVar) {
        this.N = qVar;
    }
}
