package com.bytedance.sdk.component.jk.b;

import com.bytedance.sdk.component.jk.t;
import com.bytedance.sdk.component.jk.u.x;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends Thread {
    private x proxy;

    public fx() {
    }

    @Override // java.lang.Thread
    public void interrupt() {
        x xVar = this.proxy;
        if (xVar != null) {
            xVar.interrupt();
        } else {
            super.interrupt();
        }
    }

    @Override // java.lang.Thread
    public boolean isInterrupted() {
        x xVar = this.proxy;
        return xVar != null ? xVar.isInterrupted() : super.isInterrupted();
    }

    public boolean isProxyEnable() {
        return t.nr.nr(1);
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        try {
            if (!isProxyEnable()) {
                super.start();
                return;
            }
            if (this.proxy == null) {
                this.proxy = new x(this);
            }
            this.proxy.start();
        } catch (OutOfMemoryError unused) {
            com.bytedance.sdk.component.jk.b.u.u("PThread");
            t tVar = t.nr;
            tVar.l().schedule(new Runnable() { // from class: com.bytedance.sdk.component.jk.b.fx.1
                @Override // java.lang.Runnable
                public void run() {
                    fx.super.start();
                }
            }, tVar.b(), TimeUnit.MILLISECONDS);
        }
    }

    public fx(Runnable runnable) {
        super(runnable);
    }

    public fx(String str) {
        super(str);
    }

    public fx(ThreadGroup threadGroup, Runnable runnable) {
        super(threadGroup, runnable);
    }

    public fx(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }

    public fx(Runnable runnable, String str) {
        super(runnable, str);
    }

    public fx(ThreadGroup threadGroup, Runnable runnable, String str) {
        super(threadGroup, runnable, str);
    }

    public fx(ThreadGroup threadGroup, Runnable runnable, String str, long j) {
        super(threadGroup, runnable, str, j);
    }
}
