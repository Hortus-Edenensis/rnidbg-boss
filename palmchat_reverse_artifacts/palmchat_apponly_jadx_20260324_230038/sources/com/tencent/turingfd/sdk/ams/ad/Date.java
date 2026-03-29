package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class Date<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f10690a;
    public long b;
    public long c;

    public synchronized void a(T t, long j) {
        if (t == null) {
            return;
        }
        this.f10690a = t;
        this.b = System.currentTimeMillis();
        this.c = j;
    }

    public synchronized T a() {
        T t = this.f10690a;
        if (t == null) {
            return null;
        }
        long j = this.c;
        if (j < 0) {
            return t;
        }
        if (j != 0 && Math.abs(System.currentTimeMillis() - this.b) <= this.c) {
            return this.f10690a;
        }
        this.f10690a = null;
        return null;
    }
}
