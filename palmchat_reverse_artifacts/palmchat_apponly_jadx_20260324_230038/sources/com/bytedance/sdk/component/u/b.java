package com.bytedance.sdk.component.u;

import com.bytedance.component.sdk.annotation.CallSuper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b<P, R> extends com.bytedance.sdk.component.u.nr<P, R> {
    private iz fx;
    private u nr;
    private boolean u = true;

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        b u();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(Object obj);

        void u(Throwable th);
    }

    private boolean x() {
        if (this.u) {
            return true;
        }
        a.u(new IllegalStateException("Jsb async call already finished: " + u() + ", hashcode: " + hashCode()));
        return false;
    }

    public abstract void b();

    public final void fx() {
        u((Throwable) null);
    }

    public void iz() {
        b();
        pn();
    }

    @CallSuper
    public void pn() {
        this.u = false;
        this.fx = null;
    }

    @Override // com.bytedance.sdk.component.u.nr
    public /* bridge */ /* synthetic */ String u() {
        return super.u();
    }

    public abstract void u(P p, iz izVar) throws Exception;

    public final void u(R r) {
        if (x()) {
            this.nr.u(r);
            pn();
        }
    }

    public final void u(Throwable th) {
        if (x()) {
            this.nr.u(th);
            pn();
        }
    }

    public void u(P p, iz izVar, u uVar) throws Exception {
        this.fx = izVar;
        this.nr = uVar;
        u(p, izVar);
    }
}
