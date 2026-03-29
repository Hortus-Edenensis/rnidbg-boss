package com.amap.api.col.p0002sl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class jd implements Runnable {
    a e;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(jd jdVar);
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        a aVar;
        try {
            if (Thread.interrupted()) {
                return;
            }
            a();
            if (Thread.interrupted() || (aVar = this.e) == null) {
                return;
            }
            aVar.a(this);
        } catch (Throwable th) {
            hd.c(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }
}
