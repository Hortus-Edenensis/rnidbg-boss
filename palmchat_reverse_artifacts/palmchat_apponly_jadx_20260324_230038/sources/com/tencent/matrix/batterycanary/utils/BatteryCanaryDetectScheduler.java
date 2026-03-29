package com.tencent.matrix.batterycanary.utils;

import android.os.Handler;
import androidx.annotation.RestrictTo;
import com.tencent.matrix.util.MatrixHandlerThread;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class BatteryCanaryDetectScheduler {
    private static final String TAG = "Matrix.battery.DetectScheduler";
    private Handler mDetectHandler;
    private boolean started = false;

    public void addDetectTask(Runnable runnable) {
        this.mDetectHandler.post(runnable);
    }

    public void quit() {
        if (this.started) {
            this.mDetectHandler.removeCallbacksAndMessages(null);
            this.started = false;
        }
    }

    public void start() {
        if (this.started) {
            return;
        }
        this.mDetectHandler = new Handler(MatrixHandlerThread.getDefaultHandlerThread().getLooper());
        this.started = true;
    }

    public void addDetectTask(Runnable runnable, long j) {
        this.mDetectHandler.postDelayed(runnable, j);
    }
}
