package com.amap.api.col.p0002sl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f2616a;
    private long b;
    private double c;
    private double d;

    public af() {
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.f2616a = 0L;
        this.b = 0L;
    }

    public final void a(double d) {
        this.d = d;
    }

    public final void b(double d) {
        this.c = d;
    }

    public final long c() {
        return this.b;
    }

    public final long d() {
        return this.f2616a;
    }

    public final double e() {
        if (Double.doubleToLongBits(this.d) == Double.doubleToLongBits(Double.MIN_VALUE)) {
            this.d = (aa.a(this.b) * 2.003750834E7d) / 180.0d;
        }
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || af.class != obj.getClass()) {
            return false;
        }
        af afVar = (af) obj;
        return this.f2616a == afVar.f2616a && this.b == afVar.b && Double.doubleToLongBits(this.c) == Double.doubleToLongBits(afVar.c) && Double.doubleToLongBits(this.d) == Double.doubleToLongBits(afVar.d);
    }

    public final double f() {
        if (Double.doubleToLongBits(this.c) == Double.doubleToLongBits(Double.MIN_VALUE)) {
            this.c = ((Math.log(Math.tan(((aa.a(this.f2616a) + 90.0d) * 3.141592653589793d) / 360.0d)) / 0.017453292519943295d) * 2.003750834E7d) / 180.0d;
        }
        return this.c;
    }

    public final af g() {
        return new af(this.c, this.d, this.f2616a, this.b);
    }

    public final int hashCode() {
        long j = this.f2616a;
        long j2 = this.b;
        int i = ((((int) (j ^ (j >>> 32))) + 31) * 31) + ((int) (j2 ^ (j2 >>> 32)));
        long jDoubleToLongBits = Double.doubleToLongBits(this.c);
        int i2 = (i * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.d);
        return (i2 * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
    }

    public final int a() {
        return (int) this.b;
    }

    public final int b() {
        return (int) this.f2616a;
    }

    public af(int i, int i2) {
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.f2616a = i;
        this.b = i2;
    }

    public af(double d, double d2, boolean z) {
        this.f2616a = Long.MIN_VALUE;
        this.b = Long.MIN_VALUE;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        if (z) {
            this.f2616a = (long) (d * 1000000.0d);
            this.b = (long) (d2 * 1000000.0d);
        } else {
            this.c = d;
            this.d = d2;
        }
    }

    private af(double d, double d2, long j, long j2) {
        this.c = d;
        this.d = d2;
        this.f2616a = j;
        this.b = j2;
    }
}
