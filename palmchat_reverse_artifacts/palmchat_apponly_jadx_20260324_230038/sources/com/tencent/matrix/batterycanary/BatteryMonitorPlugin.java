package com.tencent.matrix.batterycanary;

import android.app.Application;
import com.tencent.matrix.AppActiveMatrixDelegate;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.batterycanary.monitor.BatteryMonitorConfig;
import com.tencent.matrix.batterycanary.monitor.BatteryMonitorCore;
import com.tencent.matrix.plugin.Plugin;
import com.tencent.matrix.plugin.PluginListener;
import com.tencent.matrix.util.MatrixLog;
import com.tencent.matrix.util.MatrixUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class BatteryMonitorPlugin extends Plugin {
    private static final String TAG = "Matrix.battery.BatteryMonitorPlugin";
    private static String sPackageName;
    private static String sProcessName;
    final BatteryMonitorCore mDelegate;

    public BatteryMonitorPlugin(BatteryMonitorConfig batteryMonitorConfig) {
        this.mDelegate = new BatteryMonitorCore(batteryMonitorConfig);
        MatrixLog.i(TAG, "setUp battery monitor plugin with configs: " + batteryMonitorConfig, new Object[0]);
    }

    public BatteryMonitorCore core() {
        return this.mDelegate;
    }

    public String getPackageName() {
        if (sPackageName == null) {
            synchronized (this) {
                if (sPackageName == null) {
                    Application application = getApplication();
                    if (application == null) {
                        if (!Matrix.isInstalled()) {
                            throw new IllegalStateException(getTag() + " is not yet init!");
                        }
                        application = Matrix.with().getApplication();
                    }
                    sPackageName = application.getPackageName();
                }
            }
        }
        return sPackageName;
    }

    public String getProcessName() {
        if (sProcessName == null) {
            synchronized (this) {
                if (sProcessName == null) {
                    Application application = getApplication();
                    if (application == null) {
                        if (!Matrix.isInstalled()) {
                            throw new IllegalStateException(getTag() + " is not yet init!");
                        }
                        application = Matrix.with().getApplication();
                    }
                    sProcessName = MatrixUtil.getProcessName(application);
                }
            }
        }
        return sProcessName;
    }

    @Override // com.tencent.matrix.plugin.Plugin, com.tencent.matrix.plugin.IPlugin
    public String getTag() {
        return "BatteryMonitorPlugin";
    }

    @Override // com.tencent.matrix.plugin.Plugin, com.tencent.matrix.plugin.IPlugin
    public void init(Application application, PluginListener pluginListener) {
        super.init(application, pluginListener);
        if (this.mDelegate.getConfig().isBuiltinForegroundNotifyEnabled) {
            return;
        }
        AppActiveMatrixDelegate.INSTANCE.removeListener(this);
    }

    @Override // com.tencent.matrix.plugin.Plugin
    public boolean isForeground() {
        return this.mDelegate.isForeground();
    }

    @Override // com.tencent.matrix.plugin.Plugin, com.tencent.matrix.plugin.IPlugin, com.tencent.matrix.listeners.IAppForeground
    public void onForeground(boolean z) {
        this.mDelegate.onForeground(z);
    }

    @Override // com.tencent.matrix.plugin.Plugin, com.tencent.matrix.plugin.IPlugin
    public void start() {
        super.start();
        this.mDelegate.start();
    }

    @Override // com.tencent.matrix.plugin.Plugin, com.tencent.matrix.plugin.IPlugin
    public void stop() {
        super.stop();
        this.mDelegate.stop();
    }
}
