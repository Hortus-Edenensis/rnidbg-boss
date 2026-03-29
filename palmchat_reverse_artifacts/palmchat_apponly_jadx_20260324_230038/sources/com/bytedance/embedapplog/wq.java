package com.bytedance.embedapplog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
abstract class wq {
    private volatile boolean b;
    private boolean fx;
    private int nr = 0;
    final xg u;

    public wq(xg xgVar) {
        this.u = xgVar;
    }

    public abstract String b();

    public abstract boolean fx();

    public boolean iz() {
        return this.fx;
    }

    public void n() {
        ti.u("setImmediately, " + b());
        this.b = true;
    }

    public abstract long[] nr();

    public void pn() {
        this.fx = true;
    }

    public abstract long u();

    public final long x() {
        boolean zFx;
        long jU = u();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.b) {
            this.b = false;
            jU = 0;
        }
        if (jU <= 1000 + jCurrentTimeMillis) {
            try {
                zFx = fx();
            } catch (Exception e) {
                ti.nr(e);
                zFx = false;
            }
            if (!zFx) {
                long[] jArrNr = nr();
                int i = this.nr;
                this.nr = i + 1;
                return jArrNr[i % jArrNr.length];
            }
            this.nr = 0;
            jU = u();
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        return jU - jCurrentTimeMillis;
    }
}
