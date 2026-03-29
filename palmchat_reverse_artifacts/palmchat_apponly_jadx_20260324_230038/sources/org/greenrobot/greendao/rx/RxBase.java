package org.greenrobot.greendao.rx;

import defpackage.n54;
import defpackage.x25;
import java.util.concurrent.Callable;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import org.greenrobot.greendao.annotation.apihint.Internal;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
@Internal
class RxBase {
    protected final x25 scheduler;

    public RxBase() {
        this.scheduler = null;
    }

    @Experimental
    public x25 getScheduler() {
        return this.scheduler;
    }

    public <R> n54<R> wrap(Callable<R> callable) {
        return wrap(RxUtils.fromCallable(callable));
    }

    public <R> n54<R> wrap(n54<R> n54Var) {
        x25 x25Var = this.scheduler;
        return x25Var != null ? n54Var.u(x25Var) : n54Var;
    }

    @Experimental
    public RxBase(x25 x25Var) {
        this.scheduler = x25Var;
    }
}
