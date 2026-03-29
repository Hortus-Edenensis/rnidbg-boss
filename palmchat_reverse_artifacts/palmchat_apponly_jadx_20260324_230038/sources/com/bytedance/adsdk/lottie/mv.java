package com.bytedance.adsdk.lottie;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class mv<T> {
    public static Executor u = com.bytedance.sdk.component.jk.fx.nr(new com.bytedance.sdk.component.jk.jk("ie/LottieTask"));
    private final Handler b;
    private final Set<jk<Throwable>> fx;
    private final Set<jk<T>> nr;
    private volatile l<T> pn;

    /* JADX INFO: compiled from: SearchBox */
    public class u extends FutureTask<l<T>> {
        public u(Callable<l<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (isCancelled()) {
                return;
            }
            try {
                mv.this.setResult(get());
            } catch (InterruptedException | ExecutionException e) {
                mv.this.setResult(new l(e));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public mv(Callable<l<T>> callable) {
        this(callable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(l<T> lVar) {
        if (this.pn != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.pn = lVar;
        u();
    }

    public synchronized mv<T> b(jk<Throwable> jkVar) {
        this.fx.remove(jkVar);
        return this;
    }

    public synchronized mv<T> fx(jk<Throwable> jkVar) {
        l<T> lVar = this.pn;
        if (lVar != null && lVar.nr() != null) {
            jkVar.u(lVar.nr());
        }
        this.fx.add(jkVar);
        return this;
    }

    public synchronized mv<T> nr(jk<T> jkVar) {
        this.nr.remove(jkVar);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public mv(Callable<l<T>> callable, boolean z) {
        this.nr = new LinkedHashSet(1);
        this.fx = new LinkedHashSet(1);
        this.b = new Handler(Looper.getMainLooper());
        this.pn = null;
        if (!z) {
            u.execute(new u(callable));
            return;
        }
        try {
            setResult(callable.call());
        } catch (Throwable th) {
            setResult(new l<>(th));
        }
    }

    public synchronized mv<T> u(jk<T> jkVar) {
        l<T> lVar = this.pn;
        if (lVar != null && lVar.u() != null) {
            jkVar.u(lVar.u());
        }
        this.nr.add(jkVar);
        return this;
    }

    private void u() {
        this.b.post(new Runnable() { // from class: com.bytedance.adsdk.lottie.mv.1
            @Override // java.lang.Runnable
            public void run() {
                l lVar = mv.this.pn;
                if (lVar == null) {
                    return;
                }
                if (lVar.u() != null) {
                    mv.this.u(lVar.u());
                } else {
                    mv.this.u(lVar.nr());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(T t) {
        Iterator it = new ArrayList(this.nr).iterator();
        while (it.hasNext()) {
            ((jk) it.next()).u(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(Throwable th) {
        ArrayList arrayList = new ArrayList(this.fx);
        if (arrayList.isEmpty()) {
            com.bytedance.adsdk.lottie.pn.pn.u("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((jk) it.next()).u(th);
        }
    }
}
