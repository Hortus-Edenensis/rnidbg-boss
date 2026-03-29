package com.xiaomi.push;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class bd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f11435a;
    private long b;
    private long c;
    private long d;
    private final long e = System.currentTimeMillis();

    public int a() {
        return com.xiaomi.push.service.ag.a() ? 1 : 0;
    }

    public long b() {
        return this.b;
    }

    public long c() {
        return this.c;
    }

    public long d() {
        return this.d;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m203a() {
        return this.f11435a;
    }

    public void b(long j) {
        this.b += j;
    }

    public void c(long j) {
        this.d += j;
    }

    public void a(long j) {
        this.f11435a = j;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m204a() {
        this.c++;
    }
}
