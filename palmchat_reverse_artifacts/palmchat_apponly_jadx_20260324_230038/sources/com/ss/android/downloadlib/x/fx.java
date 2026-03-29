package com.ss.android.downloadlib.x;

import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class fx<P, R> implements Runnable {
    private SoftReference<u<P, R>> b;
    private int fx;
    private fx<R, ?> iz;
    private R nr;
    private fx<?, P> pn;
    private P u;

    /* JADX INFO: compiled from: SearchBox */
    public interface u<PARAM, RESULT> {
        RESULT u(PARAM param);
    }

    private fx(int i, u<P, R> uVar, P p) {
        this.fx = i;
        this.b = new SoftReference<>(uVar);
        this.u = p;
    }

    private R nr() {
        return this.nr;
    }

    public static <P, R> fx<P, R> u(u<P, R> uVar, P p) {
        return new fx<>(2, uVar, p);
    }

    @Override // java.lang.Runnable
    public void run() {
        fx<?, P> fxVar;
        if (this.fx == 0 && !mv.nr()) {
            com.ss.android.downloadlib.n.u().nr().post(this);
            return;
        }
        if (this.fx == 1 && mv.nr()) {
            com.ss.android.downloadlib.pn.u().u(this);
            return;
        }
        if (this.fx == 2 && mv.nr()) {
            com.ss.android.downloadlib.pn.u().nr(this);
            return;
        }
        if (this.u == null && (fxVar = this.pn) != null) {
            this.u = fxVar.nr();
        }
        u<P, R> uVar = this.b.get();
        if (uVar == null) {
            return;
        }
        this.nr = uVar.u(this.u);
        fx<R, ?> fxVar2 = this.iz;
        if (fxVar2 != null) {
            fxVar2.run();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <NR> fx<R, NR> u(int i, u<R, NR> uVar) {
        fx fxVar = (fx<R, ?>) new fx(i, uVar, null);
        this.iz = fxVar;
        fxVar.pn = this;
        return fxVar;
    }

    public <NR> fx<R, NR> u(u<R, NR> uVar) {
        return u(0, uVar);
    }

    public void u() {
        fx<?, P> fxVar = this.pn;
        if (fxVar != null) {
            fxVar.u();
        } else {
            run();
        }
    }
}
