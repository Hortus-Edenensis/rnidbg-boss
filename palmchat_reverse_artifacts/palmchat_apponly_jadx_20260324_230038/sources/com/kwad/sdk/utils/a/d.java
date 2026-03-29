package com.kwad.sdk.utils.a;

import com.kwad.sdk.utils.a.c;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class d {
    static c.d bhG;
    static volatile Executor bhH;
    static ExecutorService bhI = Executors.newSingleThreadExecutor();

    private d() {
    }

    public static void a(c.d dVar) {
        bhG = dVar;
    }

    public static Executor getExecutor() {
        if (bhH == null) {
            synchronized (d.class) {
                if (bhH == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    bhH = threadPoolExecutor;
                }
            }
        }
        return bhH;
    }

    public static void setExecutor(Executor executor) {
        if (executor != null) {
            bhH = executor;
        }
    }
}
