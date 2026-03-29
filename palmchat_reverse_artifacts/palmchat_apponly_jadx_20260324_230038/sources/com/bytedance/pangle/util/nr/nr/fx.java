package com.bytedance.pangle.util.nr.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5072a;
    private int iz;
    private String n;
    private int pn;
    private int u;
    private int x;
    private long nr = 0;
    private long fx = 0;
    private long b = 0;
    private final long jk = 30;

    public long a() {
        return this.b;
    }

    public long b() {
        return ((long) this.pn) + 30 + ((long) this.x);
    }

    public long fx() {
        return b() + nr();
    }

    public int iz() {
        return this.x;
    }

    public int jk() {
        return this.pn;
    }

    public String l() {
        return this.n;
    }

    public long mv() {
        return this.f5072a;
    }

    public long n() {
        return this.fx;
    }

    public long nr() {
        long j = this.fx;
        return j > 0 ? j : this.b;
    }

    public long pn() {
        return 28L;
    }

    public int t() {
        return this.iz;
    }

    public int u() {
        return this.u;
    }

    public long x() {
        return this.nr;
    }

    public void b(int i) {
        this.iz = i;
    }

    public void fx(long j) {
        this.b = j;
    }

    public void u(int i) {
        this.u = i;
    }

    public void b(long j) {
        this.f5072a = j;
    }

    public void fx(int i) {
        this.pn = i;
    }

    public void nr(int i) {
        this.x = i;
    }

    public void u(long j) {
        this.nr = j;
    }

    public void nr(long j) {
        this.fx = j;
    }

    public void u(String str) {
        this.n = str;
    }
}
