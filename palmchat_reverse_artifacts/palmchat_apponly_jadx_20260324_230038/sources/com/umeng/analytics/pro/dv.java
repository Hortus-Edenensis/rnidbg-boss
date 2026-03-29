package com.umeng.analytics.pro;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class dv extends cn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f10938a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    private static final long g = 1;
    protected int f;

    public dv() {
        this.f = 0;
    }

    public int a() {
        return this.f;
    }

    public dv(int i) {
        this.f = i;
    }

    public dv(int i, String str) {
        super(str);
        this.f = i;
    }

    public dv(String str) {
        super(str);
        this.f = 0;
    }

    public dv(int i, Throwable th) {
        super(th);
        this.f = i;
    }

    public dv(Throwable th) {
        super(th);
        this.f = 0;
    }

    public dv(String str, Throwable th) {
        super(str, th);
        this.f = 0;
    }

    public dv(int i, String str, Throwable th) {
        super(str, th);
        this.f = i;
    }
}
