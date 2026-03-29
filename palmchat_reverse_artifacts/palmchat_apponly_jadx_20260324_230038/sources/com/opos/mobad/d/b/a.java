package com.opos.mobad.d.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f8744a;
    private double b;
    private double c;
    private boolean d;

    public a(double d, double d2, long j) {
        this(d, d2, j, false);
    }

    public long a() {
        return this.f8744a;
    }

    public double b() {
        return this.b;
    }

    public double c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public a(double d, double d2, long j, boolean z) {
        this.b = d;
        this.c = d2;
        this.f8744a = j;
        this.d = z;
    }

    public void a(boolean z) {
        this.d = z;
    }
}
