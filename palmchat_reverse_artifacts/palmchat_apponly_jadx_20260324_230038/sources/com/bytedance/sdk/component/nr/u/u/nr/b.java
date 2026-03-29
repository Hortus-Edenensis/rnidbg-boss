package com.bytedance.sdk.component.nr.u.u.nr;

import com.bytedance.sdk.component.nr.u.u.nr.u;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends com.bytedance.sdk.component.nr.u.b {
    private ExecutorService u;
    private final Deque<u.C0228u> nr = new ArrayDeque();
    private final Deque<u.C0228u> fx = new ArrayDeque();
    private final Deque<u> b = new ArrayDeque();
    private AtomicInteger pn = new AtomicInteger(64);

    public b() {
        if (this.u == null) {
            this.u = new com.bytedance.sdk.component.jk.b.b(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.bytedance.sdk.component.nr.u.u.nr.b.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    com.bytedance.sdk.component.jk.b.fx fxVar = new com.bytedance.sdk.component.jk.b.fx(runnable, "systemHttp Dispatcher");
                    fxVar.setDaemon(false);
                    fxVar.setPriority(10);
                    return fxVar;
                }
            });
        }
    }

    private void fx() {
        if (this.fx.size() < u() && !this.nr.isEmpty()) {
            Iterator<u.C0228u> it = this.nr.iterator();
            while (it.hasNext()) {
                u.C0228u next = it.next();
                it.remove();
                this.fx.add(next);
                if (next != null) {
                    next.u();
                }
                nr().submit(next);
                if (this.fx.size() >= u()) {
                    return;
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.nr.u.b
    public void nr(int i) {
    }

    @Override // com.bytedance.sdk.component.nr.u.b
    public void u(int i) {
        this.pn.set(i);
    }

    @Override // com.bytedance.sdk.component.nr.u.b
    public ExecutorService nr() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.nr.u.b
    public int u() {
        return this.pn.get();
    }

    public void nr(u.C0228u c0228u) {
        u(this.fx, c0228u, true);
    }

    public synchronized void u(u.C0228u c0228u) {
        try {
            if (this.fx.size() < u()) {
                this.fx.add(c0228u);
                if (c0228u != null) {
                    c0228u.u();
                }
                nr().submit(c0228u);
                return;
            }
            this.nr.add(c0228u);
        } catch (Throwable unused) {
        }
    }

    public void nr(u uVar) {
        u(this.b, uVar, false);
    }

    public synchronized void u(u uVar) {
        this.b.add(uVar);
    }

    private <T> void u(Deque<T> deque, T t, boolean z) {
        synchronized (this) {
            deque.remove(t);
            if (z) {
                fx();
            }
        }
    }
}
