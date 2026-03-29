package com.tencent.matrix.batterycanary.monitor.feature;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.tencent.matrix.batterycanary.monitor.BatteryMonitorCore;
import com.tencent.matrix.util.MatrixLog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbsMonitorFeature implements MonitorFeature {
    private static final String TAG = "Matrix.battery.MonitorFeature";

    @NonNull
    protected BatteryMonitorCore mCore;

    @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    @CallSuper
    public void configure(BatteryMonitorCore batteryMonitorCore) {
        MatrixLog.i(getTag(), "#configure", new Object[0]);
        this.mCore = batteryMonitorCore;
    }

    public String getTag() {
        return TAG;
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    @CallSuper
    @WorkerThread
    public void onBackgroundCheck(long j) {
        MatrixLog.i(getTag(), "#onBackgroundCheck, since background started millis = " + j, new Object[0]);
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    @CallSuper
    public void onForeground(boolean z) {
        MatrixLog.i(getTag(), "#onForeground, foreground = " + z, new Object[0]);
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    @CallSuper
    public void onTurnOff() {
        MatrixLog.i(getTag(), "#onTurnOff", new Object[0]);
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    @CallSuper
    public void onTurnOn() {
        MatrixLog.i(getTag(), "#onTurnOn", new Object[0]);
    }

    public boolean shouldTracing() {
        return this.mCore.getConfig().isAggressiveMode || (this.mCore.getContext().getApplicationInfo().flags & 2) != 0;
    }

    public String toString() {
        return getTag();
    }
}
