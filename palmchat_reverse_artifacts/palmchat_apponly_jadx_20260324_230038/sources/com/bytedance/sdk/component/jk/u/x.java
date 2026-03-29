package com.bytedance.sdk.component.jk.u;

import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.jk.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class x extends Thread {
    private final Thread fx;
    private volatile boolean nr;
    private volatile Thread u;

    public x(Thread thread) {
        this.fx = thread;
    }

    @Override // java.lang.Thread
    public void interrupt() {
        if (this.u != null) {
            this.u.interrupt();
        }
    }

    @Override // java.lang.Thread
    public boolean isInterrupted() {
        if (this.u != null) {
            return this.u.isInterrupted();
        }
        return true;
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        if (this.nr) {
            return;
        }
        this.nr = true;
        t.nr.jk().execute(new com.bytedance.sdk.component.jk.fx.fx(new a(this.fx.getName()) { // from class: com.bytedance.sdk.component.jk.u.x.1
            @Override // java.lang.Runnable
            public void run() {
                if (t.nr.k()) {
                    x.this.u();
                } else {
                    x.this.nr();
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr() {
        Thread threadCurrentThread = Thread.currentThread();
        this.u = threadCurrentThread;
        threadCurrentThread.setPriority(this.fx.getPriority());
        this.fx.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        try {
            nr nrVarFx = t.nr.fx();
            String name2 = this.fx.getName();
            if (nrVarFx != null) {
                name2 = nrVarFx.u(name2);
            }
            threadCurrentThread.setName(name2);
            this.u = threadCurrentThread;
            threadCurrentThread.setPriority(this.fx.getPriority());
            this.fx.run();
        } finally {
            threadCurrentThread.setName(name);
        }
    }
}
