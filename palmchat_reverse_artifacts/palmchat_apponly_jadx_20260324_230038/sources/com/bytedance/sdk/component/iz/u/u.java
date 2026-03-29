package com.bytedance.sdk.component.iz.u;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements ThreadFactory {
    private final AtomicInteger nr = new AtomicInteger(1);
    private final ThreadGroup u;

    public u(String str) {
        this.u = new ThreadGroup("tt_img_".concat(String.valueOf(str)));
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        com.bytedance.sdk.component.jk.b.fx fxVar = new com.bytedance.sdk.component.jk.b.fx(this.u, runnable, "tt_img_" + this.nr.getAndIncrement());
        if (fxVar.isDaemon()) {
            fxVar.setDaemon(false);
        }
        return fxVar;
    }
}
