package com.vivo.push.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f11301a;
    private static final int b;
    private static final int c;
    private static ExecutorService d;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f11301a = iAvailableProcessors;
        int iMax = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
        b = iMax;
        int i = (iAvailableProcessors * 2) + 1;
        c = i;
        d = new ThreadPoolExecutor(iMax, i, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new h("COMMON_THREAD"), new ThreadPoolExecutor.DiscardPolicy());
    }

    public static ExecutorService a() {
        return d;
    }
}
