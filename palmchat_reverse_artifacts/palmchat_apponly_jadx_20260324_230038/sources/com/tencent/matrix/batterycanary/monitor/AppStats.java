package com.tencent.matrix.batterycanary.monitor;

import androidx.annotation.Nullable;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.batterycanary.BatteryCanary;
import com.tencent.matrix.batterycanary.BatteryMonitorPlugin;
import com.tencent.matrix.batterycanary.monitor.feature.AppStatMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.DeviceStatMonitorFeature;
import com.tencent.matrix.batterycanary.utils.BatteryCanaryUtil;
import com.tencent.matrix.batterycanary.utils.TimeBreaker;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AppStats {
    public static final int APP_STAT_BACKGROUND = 2;
    public static final int APP_STAT_FOREGROUND = 1;
    public static final int APP_STAT_FOREGROUND_SERVICE = 3;
    public static final int DEV_STAT_CHARGING = 1;
    public static final int DEV_STAT_SAVE_POWER_MODE = 4;
    public static final int DEV_STAT_SCREEN_OFF = 3;
    public static final int DEV_STAT_UN_CHARGING = 2;
    public int appBgRatio;
    public int appFgRatio;
    public int appFgSrvRatio;
    public int devChargingRatio;
    public int devLowEnergyRatio;
    public int devSceneOffRatio;
    public int devUnChargingRatio;
    public long duringMillis;

    @Nullable
    private AtomicBoolean mForegroundOverride;
    public int sceneTop1Ratio;
    public int sceneTop2Ratio;
    public String sceneTop1 = "";
    public String sceneTop2 = "";
    public boolean isValid = false;

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface AppStatusDef {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class CurrAppStats extends AppStats {
        final BatteryMonitorCore mCore;

        public CurrAppStats(BatteryMonitorCore batteryMonitorCore) {
            this.mCore = batteryMonitorCore;
        }

        @Override // com.tencent.matrix.batterycanary.monitor.AppStats
        public int getAppStat() {
            return BatteryCanaryUtil.getAppStat(this.mCore.getContext(), isForeground());
        }

        @Override // com.tencent.matrix.batterycanary.monitor.AppStats
        public int getDevStat() {
            return BatteryCanaryUtil.getDeviceStat(this.mCore.getContext());
        }

        @Override // com.tencent.matrix.batterycanary.monitor.AppStats
        public long getMinute() {
            return 0L;
        }

        @Override // com.tencent.matrix.batterycanary.monitor.AppStats
        public boolean hasForegroundService() {
            return BatteryCanaryUtil.hasForegroundService(this.mCore.getContext());
        }

        @Override // com.tencent.matrix.batterycanary.monitor.AppStats
        public boolean isCharging() {
            return BatteryCanaryUtil.isDeviceCharging(this.mCore.getContext());
        }

        @Override // com.tencent.matrix.batterycanary.monitor.AppStats
        public boolean isForeground() {
            return this.mCore.isForeground();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface DevStatusDef {
    }

    public static AppStats current() {
        BatteryMonitorPlugin batteryMonitorPlugin;
        if (!Matrix.isInstalled() || (batteryMonitorPlugin = (BatteryMonitorPlugin) Matrix.with().getPluginByClass(BatteryMonitorPlugin.class)) == null) {
            return current(1L);
        }
        CurrAppStats currAppStats = new CurrAppStats(batteryMonitorPlugin.core());
        currAppStats.isValid = true;
        return currAppStats;
    }

    public int getAppStat() {
        if (this.appFgRatio >= 50) {
            return 1;
        }
        return this.appFgSrvRatio >= 50 ? 3 : 2;
    }

    public int getDevStat() {
        if (this.devChargingRatio >= 50) {
            return 1;
        }
        if (this.devSceneOffRatio >= 50) {
            return 3;
        }
        return this.devLowEnergyRatio >= 50 ? 4 : 2;
    }

    public long getMinute() {
        return Math.max(1L, this.duringMillis / 60000);
    }

    public boolean hasForegroundService() {
        return getAppStat() == 3;
    }

    public boolean isCharging() {
        return getDevStat() == 1;
    }

    public boolean isForeground() {
        AtomicBoolean atomicBoolean = this.mForegroundOverride;
        return atomicBoolean != null ? atomicBoolean.get() : getAppStat() == 1;
    }

    public AppStats setForeground(boolean z) {
        this.mForegroundOverride = new AtomicBoolean(z);
        return this;
    }

    public String toString() {
        return "AppStats{appFgRatio=" + this.appFgRatio + ", appBgRatio=" + this.appBgRatio + ", appFgSrvRatio=" + this.appFgSrvRatio + ", devChargingRatio=" + this.devChargingRatio + ", devUnChargingRatio=" + this.devUnChargingRatio + ", devSceneOffRatio=" + this.devSceneOffRatio + ", devLowEnergyRatio=" + this.devLowEnergyRatio + ", sceneTop1='" + this.sceneTop1 + "', sceneTop1Ratio=" + this.sceneTop1Ratio + ", sceneTop2='" + this.sceneTop2 + "', sceneTop2Ratio=" + this.sceneTop2Ratio + ", isValid=" + this.isValid + ", duringMillis=" + this.duringMillis + ", foregroundOverride=" + this.mForegroundOverride + '}';
    }

    public static AppStats current(long j) {
        if (j <= 0) {
            j = 0;
        }
        AppStats appStats = new AppStats();
        appStats.duringMillis = j;
        AppStatMonitorFeature appStatMonitorFeature = (AppStatMonitorFeature) BatteryCanary.getMonitorFeature(AppStatMonitorFeature.class);
        if (appStatMonitorFeature != null) {
            AppStatMonitorFeature.AppStatSnapshot appStatSnapshotCurrentAppStatSnapshot = appStatMonitorFeature.currentAppStatSnapshot(j);
            if (appStatSnapshotCurrentAppStatSnapshot.isValid()) {
                appStats.appFgRatio = ((Long) appStatSnapshotCurrentAppStatSnapshot.fgRatio.get()).intValue();
                appStats.appBgRatio = ((Long) appStatSnapshotCurrentAppStatSnapshot.bgRatio.get()).intValue();
                appStats.appFgSrvRatio = ((Long) appStatSnapshotCurrentAppStatSnapshot.fgSrvRatio.get()).intValue();
                TimeBreaker.TimePortions timePortionsCurrentSceneSnapshot = appStatMonitorFeature.currentSceneSnapshot(j);
                TimeBreaker.TimePortions.Portion p1Var = timePortionsCurrentSceneSnapshot.top1();
                if (p1Var != null) {
                    appStats.sceneTop1 = p1Var.key;
                    appStats.sceneTop1Ratio = p1Var.ratio;
                    TimeBreaker.TimePortions.Portion p2Var = timePortionsCurrentSceneSnapshot.top2();
                    if (p2Var != null) {
                        appStats.sceneTop2 = p2Var.key;
                        appStats.sceneTop2Ratio = p2Var.ratio;
                    }
                    DeviceStatMonitorFeature deviceStatMonitorFeature = (DeviceStatMonitorFeature) BatteryCanary.getMonitorFeature(DeviceStatMonitorFeature.class);
                    if (deviceStatMonitorFeature != null) {
                        DeviceStatMonitorFeature.DevStatSnapshot devStatSnapshotCurrentDevStatSnapshot = deviceStatMonitorFeature.currentDevStatSnapshot(j);
                        if (devStatSnapshotCurrentDevStatSnapshot.isValid()) {
                            appStats.devChargingRatio = ((Long) devStatSnapshotCurrentDevStatSnapshot.chargingRatio.get()).intValue();
                            appStats.devUnChargingRatio = ((Long) devStatSnapshotCurrentDevStatSnapshot.unChargingRatio.get()).intValue();
                            appStats.devSceneOffRatio = ((Long) devStatSnapshotCurrentDevStatSnapshot.screenOff.get()).intValue();
                            appStats.devLowEnergyRatio = ((Long) devStatSnapshotCurrentDevStatSnapshot.lowEnergyRatio.get()).intValue();
                            appStats.isValid = true;
                        }
                    }
                }
            }
        }
        return appStats;
    }
}
