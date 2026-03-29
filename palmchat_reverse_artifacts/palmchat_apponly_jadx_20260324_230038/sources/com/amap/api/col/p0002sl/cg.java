package com.amap.api.col.p0002sl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class cg extends p {
    private af c;
    private af d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private ch l;
    private long m;
    private int n;

    public cg(int i, af afVar, af afVar2, ch chVar) {
        super(i, 10);
        this.c = afVar;
        this.d = afVar2;
        this.e = (int) afVar.e();
        this.f = (int) this.c.f();
        this.l = chVar;
        this.i = (int) Math.abs(afVar2.e() - this.c.e());
        this.j = (int) Math.abs(afVar2.f() - this.c.f());
        this.m = System.currentTimeMillis();
        this.n = i;
    }

    private void b(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i2 = (int) (jCurrentTimeMillis - this.m);
        this.m = jCurrentTimeMillis;
        float f = i2 / i;
        this.g = (int) (this.i * f);
        this.h = (int) (this.j * f);
    }

    private static void i() {
        bv.a().b();
    }

    @Override // com.amap.api.col.p0002sl.p
    public final void a() {
        b(this.n);
        int iE = (int) this.d.e();
        int iF = (int) this.d.f();
        if (!g()) {
            this.e = iE;
            this.f = iF;
            this.l.a(new af(iF, iE, false));
            return;
        }
        this.k++;
        this.e = a(this.e, iE, this.g);
        int iA = a(this.f, iF, this.h);
        this.f = iA;
        this.l.a(new af(iA, this.e, false));
        if (this.e == iE && this.f == iF) {
            f();
            h();
            i();
        }
    }

    @Override // com.amap.api.col.p0002sl.p
    public final void c() {
        this.l.c();
        u.a().b();
    }

    @Override // com.amap.api.col.p0002sl.p
    public final void b() {
        this.l.c();
        w.a().b();
    }

    private int a(int i, int i2, int i3) {
        int i4;
        if (i2 > i) {
            i4 = i + i3;
            if (i4 >= i2) {
                this.k = 0;
                return i2;
            }
        } else {
            i4 = i - i3;
            if (i4 <= i2) {
                this.k = 0;
                return i2;
            }
        }
        return i4;
    }
}
