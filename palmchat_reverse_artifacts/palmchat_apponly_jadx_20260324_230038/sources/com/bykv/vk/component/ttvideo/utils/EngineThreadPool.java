package com.bykv.vk.component.ttvideo.utils;

import com.bytedance.sdk.component.jk.jk;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class EngineThreadPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ThreadPoolExecutor f4961a;

    public static ExecutorService a() {
        if (f4961a == null) {
            synchronized (EngineThreadPool.class) {
                if (f4961a == null) {
                    com.bytedance.sdk.component.jk.b.b bVar = new com.bytedance.sdk.component.jk.b.b(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new jk("EngineThreadPool"));
                    f4961a = bVar;
                    bVar.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f4961a;
    }

    public static void setExcutorInstance(ThreadPoolExecutor threadPoolExecutor) {
        synchronized (EngineThreadPool.class) {
            f4961a = threadPoolExecutor;
        }
    }
}
