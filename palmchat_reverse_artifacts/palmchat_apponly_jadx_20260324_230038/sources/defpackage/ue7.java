package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ue7<TResult> extends Task<TResult> {
    public boolean b;
    public volatile boolean c;
    public TResult d;
    public Exception e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f21201a = new Object();
    public List<ho1<TResult>> f = new ArrayList();

    @Override // defpackage.Task
    public final Task<TResult> a(s64<TResult> s64Var) {
        return l(mt5.b(), s64Var);
    }

    @Override // defpackage.Task
    public final Task<TResult> b(w64 w64Var) {
        return m(mt5.b(), w64Var);
    }

    @Override // defpackage.Task
    public final Task<TResult> c(s74<TResult> s74Var) {
        return n(mt5.b(), s74Var);
    }

    @Override // defpackage.Task
    public final Exception d() {
        Exception exc;
        synchronized (this.f21201a) {
            exc = this.e;
        }
        return exc;
    }

    @Override // defpackage.Task
    public final TResult e() {
        TResult tresult;
        synchronized (this.f21201a) {
            if (this.e != null) {
                throw new RuntimeException(this.e);
            }
            tresult = this.d;
        }
        return tresult;
    }

    @Override // defpackage.Task
    public final boolean f() {
        return this.c;
    }

    @Override // defpackage.Task
    public final boolean g() {
        boolean z;
        synchronized (this.f21201a) {
            z = this.b;
        }
        return z;
    }

    @Override // defpackage.Task
    public final boolean h() {
        boolean z;
        synchronized (this.f21201a) {
            z = this.b && !f() && this.e == null;
        }
        return z;
    }

    public final Task<TResult> i(ho1<TResult> ho1Var) {
        boolean zG;
        synchronized (this.f21201a) {
            zG = g();
            if (!zG) {
                this.f.add(ho1Var);
            }
        }
        if (zG) {
            ho1Var.onComplete(this);
        }
        return this;
    }

    public final void j(Exception exc) {
        synchronized (this.f21201a) {
            if (this.b) {
                return;
            }
            this.b = true;
            this.e = exc;
            this.f21201a.notifyAll();
            o();
        }
    }

    public final void k(TResult tresult) {
        synchronized (this.f21201a) {
            if (this.b) {
                return;
            }
            this.b = true;
            this.d = tresult;
            this.f21201a.notifyAll();
            o();
        }
    }

    public final Task<TResult> l(Executor executor, s64<TResult> s64Var) {
        return i(new j77(executor, s64Var));
    }

    public final Task<TResult> m(Executor executor, w64 w64Var) {
        return i(new tb7(executor, w64Var));
    }

    public final Task<TResult> n(Executor executor, s74<TResult> s74Var) {
        return i(new yd7(executor, s74Var));
    }

    public final void o() {
        synchronized (this.f21201a) {
            Iterator<ho1<TResult>> it = this.f.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onComplete(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.f = null;
        }
    }
}
