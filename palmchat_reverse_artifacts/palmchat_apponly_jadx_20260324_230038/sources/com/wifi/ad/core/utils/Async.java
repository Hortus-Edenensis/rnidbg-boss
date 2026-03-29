package com.wifi.ad.core.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/wifi/ad/core/utils/Async;", "", "()V", "HANDLER", "Landroid/os/Handler;", "cache", "Ljava/util/concurrent/Executor;", "getCache", "()Ljava/util/concurrent/Executor;", "main", "getMain$core_release", "core_release"}, k = 1, mv = {1, 1, 16})
public final class Async {
    private static final Handler HANDLER;
    public static final Async INSTANCE = new Async();
    private static final Executor cache;
    private static final Executor main;

    static {
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        Intrinsics.checkExpressionValueIsNotNull(executorServiceNewCachedThreadPool, "Executors.newCachedThreadPool()");
        cache = executorServiceNewCachedThreadPool;
        HANDLER = new Handler(Looper.getMainLooper());
        main = new Executor() { // from class: com.wifi.ad.core.utils.Async$main$1
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                Async async = Async.INSTANCE;
                Async.HANDLER.post(runnable);
            }
        };
    }

    private Async() {
    }

    public final Executor getCache() {
        return cache;
    }

    public final Executor getMain$core_release() {
        return main;
    }
}
