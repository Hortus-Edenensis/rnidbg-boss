package com.oplus.tblplayer.utils.executor;

import com.oplus.tblplayer.utils.LogUtil;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultDiscardPolicy implements RejectedExecutionHandler {
    private static final String TAG = "DefaultDiscardPolicy";

    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        LogUtil.d(TAG, "rejectedExecution executor:" + threadPoolExecutor.toString() + ", runnable:%s" + runnable.toString());
        if (threadPoolExecutor.isShutdown()) {
            return;
        }
        threadPoolExecutor.getQueue().poll();
        threadPoolExecutor.execute(runnable);
    }
}
