package com.amap.api.col.p0002sl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class bz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Thread[] f2665a = new Thread[4];

    public bz(Runnable runnable, Runnable runnable2) {
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                this.f2665a[0] = new Thread(runnable);
            } else {
                this.f2665a[i] = new Thread(runnable2);
            }
        }
    }

    public final void a() {
        try {
            for (Thread thread : this.f2665a) {
                thread.setDaemon(true);
                thread.start();
            }
        } catch (Throwable th) {
            ct.a(th, "ThreadPool", "start");
        }
    }

    public final void b() {
        Thread[] threadArr = this.f2665a;
        if (threadArr == null) {
            return;
        }
        int length = threadArr.length;
        for (int i = 0; i < length; i++) {
            this.f2665a[i].interrupt();
            this.f2665a[i] = null;
        }
        this.f2665a = null;
    }
}
