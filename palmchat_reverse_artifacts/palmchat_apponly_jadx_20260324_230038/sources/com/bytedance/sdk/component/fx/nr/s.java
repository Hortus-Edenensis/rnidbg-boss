package com.bytedance.sdk.component.fx.nr;

import com.bytedance.sdk.component.fx.nr.kj;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class s {
    private String b;
    private Runnable fx;
    private ExecutorService pn;
    private int u = 64;
    private int nr = 5;
    private final Deque<kj.u> iz = new ArrayDeque();
    private final Deque<kj.u> x = new ArrayDeque();
    private final Deque<kj> n = new ArrayDeque();

    public s() {
    }

    private void fx() {
        if (this.x.size() < this.u && !this.iz.isEmpty()) {
            Iterator<kj.u> it = this.iz.iterator();
            while (it.hasNext()) {
                kj.u next = it.next();
                if (fx(next) < this.nr) {
                    it.remove();
                    this.x.add(next);
                    if (next != null) {
                        next.nr();
                    }
                    u().execute(next);
                }
                if (this.x.size() >= this.u) {
                    return;
                }
            }
        }
    }

    public synchronized void nr(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i)));
        }
        this.nr = i;
        fx();
    }

    public synchronized ExecutorService u() {
        if (this.pn == null) {
            String str = this.b;
            this.pn = new com.bytedance.sdk.component.jk.b.b(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.fx.nr.u.fx.u((str == null || str.length() == 0) ? TKDownloadReason.KSAD_TK_NET : this.b, false));
        }
        return this.pn;
    }

    public void nr(kj.u uVar) {
        u(this.x, uVar, true);
    }

    public void nr(kj kjVar) {
        u(this.n, kjVar, false);
    }

    public synchronized void u(int i) {
        if (i > 0) {
            this.u = i;
            fx();
        } else {
            throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i)));
        }
    }

    public s(String str) {
        this.b = str;
    }

    public synchronized int nr() {
        return this.x.size() + this.n.size();
    }

    public synchronized void u(kj.u uVar) {
        try {
            if (this.x.size() < this.u && fx(uVar) < this.nr) {
                this.x.add(uVar);
                if (uVar != null) {
                    uVar.nr();
                }
                u().execute(uVar);
                return;
            }
            this.iz.add(uVar);
        } catch (Throwable unused) {
        }
    }

    private int fx(kj.u uVar) {
        Iterator<kj.u> it = this.x.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().u().equals(uVar.u())) {
                i++;
            }
        }
        return i;
    }

    public synchronized void u(kj kjVar) {
        this.n.add(kjVar);
    }

    private <T> void u(Deque<T> deque, T t, boolean z) {
        int iNr;
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                if (z) {
                    fx();
                }
                iNr = nr();
                runnable = this.fx;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (iNr != 0 || runnable == null) {
            return;
        }
        runnable.run();
    }
}
