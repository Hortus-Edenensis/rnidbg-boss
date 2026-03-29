package com.amap.api.col.p0002sl;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class t {
    private static float I = (float) (Math.log(0.78d) / Math.log(0.9d));
    private static final float[] J = new float[101];
    private static final float[] K = new float[101];
    private static float O;
    private static float P;
    private float A;
    private float B;
    private boolean C;
    private Interpolator D;
    private boolean E;
    private float F;
    private int G;
    private float H;
    private float L;
    private final float M;
    private float N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3048a;
    private int b;
    private int c;
    private float d;
    private float e;
    private float f;
    private int g;
    private int h;
    private float i;
    private float j;
    private float k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private float r;
    private float s;
    private float t;
    private long u;
    private long v;
    private float w;
    private float x;
    private float y;
    private float z;

    static {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11 = 0.0f;
        float f12 = 0.0f;
        int i = 0;
        while (true) {
            float f13 = 1.0f;
            if (i >= 100) {
                float[] fArr = J;
                K[100] = 1.0f;
                fArr[100] = 1.0f;
                O = 8.0f;
                P = 1.0f;
                P = 1.0f / b(1.0f);
                return;
            }
            float f14 = i / 100.0f;
            float f15 = 1.0f;
            while (true) {
                f = 2.0f;
                f2 = ((f15 - f11) / 2.0f) + f11;
                f3 = 3.0f;
                f4 = f13 - f2;
                f5 = f2 * 3.0f * f4;
                f6 = f2 * f2 * f2;
                float f16 = (((f4 * 0.175f) + (f2 * 0.35000002f)) * f5) + f6;
                float f17 = f15;
                if (Math.abs(f16 - f14) < 1.0E-5d) {
                    break;
                }
                if (f16 > f14) {
                    f15 = f2;
                } else {
                    f11 = f2;
                    f15 = f17;
                }
                f13 = 1.0f;
            }
            J[i] = (f5 * ((f4 * 0.5f) + f2)) + f6;
            float f18 = 1.0f;
            while (true) {
                f7 = ((f18 - f12) / f) + f12;
                f8 = 1.0f - f7;
                f9 = f7 * f3 * f8;
                f10 = f7 * f7 * f7;
                float f19 = (((f8 * 0.5f) + f7) * f9) + f10;
                if (Math.abs(f19 - f14) >= 1.0E-5d) {
                    if (f19 > f14) {
                        f18 = f7;
                    } else {
                        f12 = f7;
                    }
                    f = 2.0f;
                    f3 = 3.0f;
                }
            }
            K[i] = (f9 * ((f8 * 0.175f) + (f7 * 0.35000002f))) + f10;
            i++;
        }
    }

    public t(Context context) {
        this(context, (byte) 0);
    }

    private float a(float f) {
        return this.M * 386.0878f * f;
    }

    public final void b() {
        this.C = true;
    }

    public final int c() {
        return this.p;
    }

    public final int d() {
        return this.q;
    }

    public final float e() {
        return this.r;
    }

    public final float f() {
        return this.s;
    }

    public final float g() {
        return this.t;
    }

    public final boolean h() {
        float f;
        float f2;
        if (this.C) {
            return false;
        }
        int iCurrentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.u);
        long j = iCurrentAnimationTimeMillis;
        long j2 = this.v;
        if (j < j2) {
            int i = this.f3048a;
            if (i == 1) {
                float f3 = iCurrentAnimationTimeMillis / j2;
                int i2 = (int) (f3 * 100.0f);
                if (i2 < 100) {
                    float f4 = i2 / 100.0f;
                    int i3 = i2 + 1;
                    float[] fArr = J;
                    float f5 = fArr[i2];
                    f2 = (fArr[i3] - f5) / ((i3 / 100.0f) - f4);
                    f = f5 + ((f3 - f4) * f2);
                } else {
                    f = 1.0f;
                    f2 = 0.0f;
                }
                this.F = ((f2 * this.G) / j2) * 1000.0f;
                int iRound = this.b + Math.round((this.g - r1) * f);
                this.p = iRound;
                int iMin = Math.min(iRound, this.m);
                this.p = iMin;
                this.p = Math.max(iMin, this.l);
                int iRound2 = this.c + Math.round(f * (this.h - r1));
                this.q = iRound2;
                int iMin2 = Math.min(iRound2, this.o);
                this.q = iMin2;
                int iMax = Math.max(iMin2, this.n);
                this.q = iMax;
                if (this.p == this.g && iMax == this.h) {
                    this.C = true;
                }
            } else if (i == 2) {
                float f6 = iCurrentAnimationTimeMillis * this.w;
                Interpolator interpolator = this.D;
                float fB = interpolator == null ? b(f6) : interpolator.getInterpolation(f6);
                this.p = this.b + Math.round(this.x * fB);
                this.q = this.c + Math.round(this.y * fB);
                this.r = this.d + (this.z * fB);
                this.s = this.e + (this.A * fB);
                this.t = this.f + (fB * this.B);
            }
        } else {
            this.p = this.g;
            this.q = this.h;
            this.r = this.i;
            this.s = this.j;
            this.t = this.k;
            this.C = true;
        }
        return true;
    }

    public final int i() {
        return this.f3048a;
    }

    private t(Context context, byte b) {
        this(context, context.getApplicationInfo().targetSdkVersion >= 11);
    }

    private static float b(float f) {
        float f2 = f * O;
        return (f2 < 1.0f ? f2 - (1.0f - ((float) Math.exp(-f2))) : 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - f2))) * 0.63212055f)) * P;
    }

    public final boolean a() {
        return this.C;
    }

    private t(Context context, boolean z) {
        this.H = ViewConfiguration.getScrollFriction();
        this.C = true;
        this.D = null;
        this.M = context.getResources().getDisplayMetrics().density * 160.0f;
        this.L = a(ViewConfiguration.getScrollFriction());
        this.E = z;
        this.N = a(0.84f);
    }
}
