package com.zenmen.palmchat.battery.bean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class BatteryCanaryConfig {
    private int backgroundLoopCheckTime;
    private int bgThreadWatchingLimit;
    private int fgThreadWatchingLimit;
    private int foregroundLoopCheckTime;
    private boolean isMonitorAlarm;
    private boolean isMonitorAppStat;
    private boolean isMonitorBluetooth;
    private boolean isMonitorDevStat;
    private boolean isMonitorLocation;
    private boolean isMonitorThread;
    private boolean isMonitorTraffic;
    private boolean isMonitorWakeLock;
    private boolean isMonitorWifi;
    private int maxJiffiesLogCount;
    private int threadRunTimeWatchingLimit;
    private int wakelockTimeout;
    private int wakelockWarnCount;

    public static BatteryCanaryConfig setTestConfig() {
        BatteryCanaryConfig batteryCanaryConfig = new BatteryCanaryConfig();
        batteryCanaryConfig.wakelockTimeout = 120;
        batteryCanaryConfig.isMonitorBluetooth = true;
        batteryCanaryConfig.isMonitorLocation = true;
        batteryCanaryConfig.maxJiffiesLogCount = 5;
        batteryCanaryConfig.isMonitorTraffic = true;
        batteryCanaryConfig.isMonitorAppStat = true;
        batteryCanaryConfig.foregroundLoopCheckTime = 1200;
        batteryCanaryConfig.wakelockWarnCount = 3;
        batteryCanaryConfig.isMonitorDevStat = true;
        batteryCanaryConfig.isMonitorAlarm = true;
        batteryCanaryConfig.fgThreadWatchingLimit = 5000;
        batteryCanaryConfig.isMonitorWifi = true;
        batteryCanaryConfig.isMonitorWakeLock = true;
        batteryCanaryConfig.threadRunTimeWatchingLimit = 5;
        batteryCanaryConfig.backgroundLoopCheckTime = 120;
        batteryCanaryConfig.isMonitorThread = true;
        batteryCanaryConfig.bgThreadWatchingLimit = 3000;
        return batteryCanaryConfig;
    }

    public int getBackgroundLoopCheckTime() {
        return this.backgroundLoopCheckTime;
    }

    public int getBgThreadWatchingLimit() {
        return this.bgThreadWatchingLimit;
    }

    public int getFgThreadWatchingLimit() {
        return this.fgThreadWatchingLimit;
    }

    public int getForegroundLoopCheckTime() {
        return this.foregroundLoopCheckTime;
    }

    public int getMaxJiffiesLogCount() {
        return this.maxJiffiesLogCount;
    }

    public int getThreadRunTimeWatchingLimit() {
        return this.threadRunTimeWatchingLimit;
    }

    public int getWakelockTimeout() {
        return this.wakelockTimeout;
    }

    public int getWakelockWarnCount() {
        return this.wakelockWarnCount;
    }

    public boolean isMonitorAlarm() {
        return this.isMonitorAlarm;
    }

    public boolean isMonitorAppStat() {
        return this.isMonitorAppStat;
    }

    public boolean isMonitorBluetooth() {
        return this.isMonitorBluetooth;
    }

    public boolean isMonitorDevStat() {
        return this.isMonitorDevStat;
    }

    public boolean isMonitorLocation() {
        return this.isMonitorLocation;
    }

    public boolean isMonitorThread() {
        return this.isMonitorThread;
    }

    public boolean isMonitorTraffic() {
        return this.isMonitorTraffic;
    }

    public boolean isMonitorWakeLock() {
        return this.isMonitorWakeLock;
    }

    public boolean isMonitorWifi() {
        return this.isMonitorWifi;
    }

    public String toString() {
        return "BatteryCanaryConfig{isMonitorThread=" + this.isMonitorThread + ", isMonitorDevStat=" + this.isMonitorDevStat + ", isMonitorAppStat=" + this.isMonitorAppStat + ", isMonitorAlarm=" + this.isMonitorAlarm + ", isMonitorWakeLock=" + this.isMonitorWakeLock + ", isMonitorLocation=" + this.isMonitorLocation + ", isMonitorBluetooth=" + this.isMonitorBluetooth + ", isMonitorWifi=" + this.isMonitorWifi + ", isMonitorTraffic=" + this.isMonitorTraffic + ", backgroundLoopCheckTime=" + this.backgroundLoopCheckTime + ", foregroundLoopCheckTime=" + this.foregroundLoopCheckTime + ", fgThreadWatchingLimit=" + this.fgThreadWatchingLimit + ", bgThreadWatchingLimit=" + this.bgThreadWatchingLimit + ", maxJiffiesLogCount=" + this.maxJiffiesLogCount + ", threadRunTimeWatchingLimit=" + this.threadRunTimeWatchingLimit + ", wakelockTimeout=" + this.wakelockTimeout + ", wakelockWarnCount=" + this.wakelockWarnCount + '}';
    }
}
