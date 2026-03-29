package com.opos.cmn.func.dl.base.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7988a;
    public long b;
    public long c;
    public volatile long d;

    public c(int i, long j, long j2, long j3) {
        this.f7988a = i;
        this.b = j;
        this.c = j3;
        this.d = j2;
    }

    public final String toString() {
        return "ThreadInfo{index=" + this.f7988a + ", startPos=" + this.b + ", contentLen=" + this.c + ", downloadedLen=" + this.d + '}';
    }
}
