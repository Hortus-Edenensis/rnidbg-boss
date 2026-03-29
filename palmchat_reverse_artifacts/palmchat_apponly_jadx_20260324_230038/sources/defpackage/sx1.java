package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class sx1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20865a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public double g;
    public double h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public double o;

    public void a(float f) {
        float fMin = Math.min(f, 1.0f);
        float fPow = 1.0f - ((float) Math.pow(1.0f - fMin, 4.0d));
        this.m = g(fPow);
        this.n = h(fPow);
        this.o = f(fMin);
    }

    public void b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f20865a = i;
        this.b = i2;
        this.c = i5;
        this.d = i7;
        this.e = i6;
        this.f = i8;
        double d = i3;
        double d2 = i4;
        double dHypot = Math.hypot(d, d2);
        this.g = d2 / dHypot;
        this.h = d / dHypot;
        int iRound = (int) Math.round(Math.pow(Math.abs(dHypot), 0.3333333333333333d) * 50.0d);
        this.i = iRound;
        this.j = (int) Math.round(((dHypot * ((double) iRound)) / 4.0d) / 1000.0d);
        this.k = g(1.0f);
        this.l = h(1.0f);
    }

    public int c() {
        return this.m;
    }

    public int d() {
        return this.n;
    }

    public int e() {
        return this.i;
    }

    public final double f(float f) {
        return (((double) ((this.j * 4) * 1000)) * Math.pow(1.0f - f, 3.0d)) / ((double) this.i);
    }

    public final int g(float f) {
        int iRound = (int) Math.round(((double) this.f20865a) + (((double) (f * this.j)) * this.h));
        double d = this.h;
        if (d > 0.0d) {
            int i = this.f20865a;
            int i2 = this.e;
            if (i <= i2) {
                return Math.min(iRound, i2);
            }
        }
        if (d >= 0.0d) {
            return iRound;
        }
        int i3 = this.f20865a;
        int i4 = this.c;
        return i3 >= i4 ? Math.max(iRound, i4) : iRound;
    }

    public final int h(float f) {
        int iRound = (int) Math.round(((double) this.b) + (((double) (f * this.j)) * this.g));
        double d = this.g;
        if (d > 0.0d) {
            int i = this.b;
            int i2 = this.f;
            if (i <= i2) {
                return Math.min(iRound, i2);
            }
        }
        if (d >= 0.0d) {
            return iRound;
        }
        int i3 = this.b;
        int i4 = this.d;
        return i3 >= i4 ? Math.max(iRound, i4) : iRound;
    }
}
