package com.ss.android.socialbase.downloader.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u implements ThreadFactory {
    private final boolean fx;
    private final AtomicInteger nr;
    private final String u;

    public u(String str) {
        this(str, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        com.bytedance.sdk.component.jk.b.fx fxVar = new com.bytedance.sdk.component.jk.b.fx(runnable, this.u + "-" + this.nr.incrementAndGet());
        if (!this.fx) {
            if (fxVar.isDaemon()) {
                fxVar.setDaemon(false);
            }
            if (fxVar.getPriority() != 5) {
                fxVar.setPriority(5);
            }
        }
        return fxVar;
    }

    public u(String str, boolean z) {
        this.nr = new AtomicInteger();
        this.u = str;
        this.fx = z;
    }
}
