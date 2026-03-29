package com.tencent.matrix.batterycanary;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.batterycanary.BatteryEventDelegate;
import com.tencent.matrix.batterycanary.monitor.BatteryMonitorCore;
import com.tencent.matrix.batterycanary.monitor.feature.JiffiesMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class BatteryCanary {
    public static void addBatteryStateListener(BatteryEventDelegate.Listener listener) {
        if (listener == null || !BatteryEventDelegate.isInit()) {
            return;
        }
        BatteryEventDelegate.getInstance().addListener(listener);
    }

    public static void currentJiffies(@NonNull BatteryMonitorCore.Callback<JiffiesMonitorFeature.JiffiesSnapshot> callback) {
        BatteryMonitorPlugin batteryMonitorPlugin;
        JiffiesMonitorFeature jiffiesMonitorFeature;
        if (!Matrix.isInstalled() || (batteryMonitorPlugin = (BatteryMonitorPlugin) Matrix.with().getPluginByClass(BatteryMonitorPlugin.class)) == null || (jiffiesMonitorFeature = (JiffiesMonitorFeature) batteryMonitorPlugin.core().getMonitorFeature(JiffiesMonitorFeature.class)) == null) {
            return;
        }
        jiffiesMonitorFeature.currentJiffiesSnapshot(callback);
    }

    @Nullable
    public static <T extends MonitorFeature> T getMonitorFeature(Class<T> cls) {
        BatteryMonitorPlugin batteryMonitorPlugin;
        if (!Matrix.isInstalled() || (batteryMonitorPlugin = (BatteryMonitorPlugin) Matrix.with().getPluginByClass(BatteryMonitorPlugin.class)) == null) {
            return null;
        }
        return (T) batteryMonitorPlugin.core().getMonitorFeature(cls);
    }

    public static void removeBatteryStateListener(BatteryEventDelegate.Listener listener) {
        if (listener == null || !BatteryEventDelegate.isInit()) {
            return;
        }
        BatteryEventDelegate.getInstance().removeListener(listener);
    }
}
