package com.oplus.tblplayer.utils.executor;

import com.oplus.tblplayer.utils.LogUtil;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class SafeRunnable implements Runnable {
    private static final String TAG = "SafeRunnable";

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                safeRun();
            } catch (Exception e) {
                LogUtil.e(TAG, "SafeRunnable catch exception:" + e.getMessage() + ", runnable:%s" + toString());
            }
        } finally {
            doLast();
        }
    }

    public abstract void safeRun() throws InterruptedException, IOException;

    public void doLast() {
    }
}
