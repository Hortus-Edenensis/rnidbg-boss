package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ze6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f22403a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float v;
    public float w;
    public float x;
    public d75 y;
    public float[] g = new float[9];
    public i52 h = null;
    public f52 i = null;
    public i52 j = null;
    public f52 k = null;
    public i52 l = null;
    public f52 m = null;
    public f52 n = null;
    public i52 o = null;
    public i52 p = null;
    public j52 q = null;
    public f52 r = null;
    public f52 s = null;
    public i52 t = null;
    public j52 u = null;
    public int z = 3;
    public int A = 2;

    public ze6(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.f22403a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = f5;
        this.v = f6;
        this.w = f7;
        this.x = f8;
        this.y = new d75(f, f2, f3, f4);
    }

    public void a() {
        float f = this.d;
        float f2 = this.c;
        float f3 = this.f22403a;
        float f4 = this.e;
        float f5 = this.b;
        float fTan = ((((float) Math.tan(0.7853981633974483d)) * this.w) / 2.0f) / this.f;
        double dAtan = (float) Math.atan((fTan / r6) * 2.0f);
        float f6 = (float) (1.5707963267948966d - dAtan);
        int i = this.A;
        if (i == 0) {
            f3 += fTan;
        }
        float f7 = f3;
        if (i != 2) {
            f2 -= fTan;
        }
        float f8 = f2;
        float f9 = this.z == 0 ? 0.0f : f4;
        float f10 = f7 + f9;
        float f11 = f9 * 2.0f;
        this.h = new i52(f10, f5, f8 - f11, f, this.y);
        float f12 = f5 - f9;
        f52 f52Var = new f52(f10, f12, f9, this.y);
        this.i = f52Var;
        f52Var.d();
        float f13 = f9;
        this.j = new i52(f7, f5, f13, f13, this.y);
        float f14 = (f7 + f8) - f13;
        this.k = new f52(f14, f12, f13, this.y);
        this.l = new i52(f14, f5, f13, f13, this.y);
        float f15 = (f5 - f) + f13;
        f52 f52Var2 = new f52(f14, f15, f13, this.y);
        this.m = f52Var2;
        f52Var2.e();
        f52 f52Var3 = new f52(f10, f15, f13, this.y);
        this.n = f52Var3;
        f52Var3.d();
        this.n.e();
        float f16 = f - f11;
        this.o = new i52(f7, f12, f13, f16, this.y);
        this.p = new i52(f14, f12, f13, f16, this.y);
        if (this.A == 1) {
            f7 = (this.f22403a + this.c) - fTan;
        }
        float[] fArr = this.g;
        fArr[0] = f7;
        fArr[1] = f5 - this.v;
        fArr[2] = 0.0f;
        float fTan2 = (this.w * ((float) Math.tan(dAtan))) / 2.0f;
        float f17 = this.x * fTan2;
        float f18 = fTan2 - f17;
        double d = f6;
        float fSin = (fTan2 / ((float) Math.sin(dAtan))) - (((float) Math.cos(d)) * f18);
        int i2 = this.A;
        if (i2 == 0) {
            this.g[3] = f7 - (((float) Math.sin(dAtan)) * fSin);
        } else if (i2 == 1) {
            this.g[3] = f7 + (((float) Math.sin(dAtan)) * fSin);
        }
        float[] fArr2 = this.g;
        fArr2[4] = fArr2[1] - (((float) Math.cos(dAtan)) * fSin);
        float[] fArr3 = this.g;
        fArr3[5] = 0.0f;
        fArr3[6] = f7;
        fArr3[7] = fArr3[4];
        fArr3[8] = 0.0f;
        this.q = new j52(fArr3, this.y);
        float fSin2 = f18 * ((float) Math.sin(d));
        int i3 = this.A;
        float f19 = i3 == 0 ? f7 - f17 : i3 == 1 ? f7 + f17 : f7;
        float f20 = this.g[1] - (this.w / 2.0f);
        f52 f52Var4 = new f52(f19, f20, fSin2, this.y);
        this.r = f52Var4;
        if (this.A == 0) {
            f52Var4.d();
        }
        f52 f52Var5 = new f52(f19, f20, fSin2, this.y);
        this.s = f52Var5;
        if (this.A == 0) {
            f52Var5.d();
        }
        this.s.e();
        int i4 = this.A;
        if (i4 == 0) {
            float[] fArr4 = this.g;
            this.t = new i52(fArr4[3], fArr4[4], fSin * ((float) Math.sin(dAtan)), this.w - ((fSin * 2.0f) * ((float) Math.cos(dAtan))), this.y);
        } else if (i4 == 1) {
            float[] fArr5 = this.g;
            this.t = new i52(fArr5[6], fArr5[7], fSin * ((float) Math.sin(dAtan)), this.w - ((fSin * 2.0f) * ((float) Math.cos(dAtan))), this.y);
        }
        float[] fArr6 = this.g;
        fArr6[1] = (fArr6[1] - this.w) + (fSin * ((float) Math.cos(dAtan)));
        float[] fArr7 = this.g;
        fArr7[4] = fArr7[1];
        fArr7[6] = f7;
        fArr7[7] = (f5 - this.v) - this.w;
        fArr7[8] = 0.0f;
        this.u = new j52(fArr7, this.y);
    }

    public void b(int i, int i2) {
        this.h.c(i, i2);
        int i3 = this.z;
        if (i3 == 3) {
            this.i.c(i, i2);
            this.k.c(i, i2);
            this.m.c(i, i2);
            this.n.c(i, i2);
            this.o.c(i, i2);
            this.p.c(i, i2);
        } else if (i3 == 1) {
            this.j.c(i, i2);
            this.k.c(i, i2);
            this.m.c(i, i2);
            this.n.c(i, i2);
            this.o.c(i, i2);
            this.p.c(i, i2);
        } else if (i3 == 2) {
            this.i.c(i, i2);
            this.l.c(i, i2);
            this.m.c(i, i2);
            this.n.c(i, i2);
            this.o.c(i, i2);
            this.p.c(i, i2);
        }
        if (this.A != 2) {
            this.q.b(i, i2);
            this.r.c(i, i2);
            this.s.c(i, i2);
            this.t.c(i, i2);
            this.u.b(i, i2);
        }
    }

    public void c(int i) {
        this.z = i;
        a();
    }

    public void d(int i) {
        this.A = i;
        a();
    }

    public void e(float f) {
        this.f = f;
    }
}
