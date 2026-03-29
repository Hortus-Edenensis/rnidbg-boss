package com.opos.cmn.biz.requeststatistic.cache;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile long f7868a;
    public final String b;
    public final long c;

    public c(long j, String str, long j2) {
        this.f7868a = -1L;
        this.f7868a = j;
        this.b = str;
        this.c = j2;
    }

    public long a() {
        return this.f7868a;
    }

    public c(String str, long j) {
        this.f7868a = -1L;
        this.b = str;
        this.c = j;
    }

    public void a(long j) {
        this.f7868a = j;
    }
}
