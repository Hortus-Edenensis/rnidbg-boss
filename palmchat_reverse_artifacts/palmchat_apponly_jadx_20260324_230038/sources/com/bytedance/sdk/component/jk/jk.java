package com.bytedance.sdk.component.jk;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk implements ThreadFactory {
    private final AtomicInteger b;
    private int fx;
    private final ThreadGroup nr;
    public final String u;

    public jk(String str) {
        this(5, str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadU = u(this.nr, runnable, this.u + "_" + this.b.getAndIncrement());
        if (threadU.isDaemon()) {
            threadU.setDaemon(false);
        }
        int i = this.fx;
        if (i > 10) {
            this.fx = 10;
        } else if (i <= 0) {
            this.fx = 1;
        }
        threadU.setPriority(this.fx);
        return threadU;
    }

    public Thread u(ThreadGroup threadGroup, Runnable runnable, String str) {
        return new com.bytedance.sdk.component.jk.b.fx(threadGroup, runnable, str);
    }

    public jk(int i, String str) {
        this.b = new AtomicInteger(1);
        this.fx = i;
        this.nr = new ThreadGroup("csj_g_" + str);
        StringBuilder sb = new StringBuilder("csj_");
        sb.append(t.nr.iz() ? "p" : "");
        sb.append(str);
        this.u = sb.toString();
    }
}
