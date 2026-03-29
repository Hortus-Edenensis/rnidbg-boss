package com.tencent.matrix.batterycanary.monitor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.matrix.batterycanary.monitor.BatteryMonitorCallback;
import com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class BatteryMonitorConfig {
    public static final int AMS_HOOK_FLAG_BT = 1;
    public static final long DEF_BACKGROUND_SCHEDULE_TIME = 600000;
    public static final long DEF_FOREGROUND_SCHEDULE_TIME = 1200000;
    public static final long DEF_JIFFIES_DELAY = 30000;
    public static final int DEF_MAX_JIFFIES_LOG_COUNT = 8;
    public static final int DEF_STAMP_OVERHEAT = 200;
    public static final int DEF_THREAD_RUN_TIME_WATCHING_LIMIT = 10;
    public static final long DEF_WAKELOCK_TIMEOUT = 120000;
    public static final int DEF_WAKELOCK_WARN_COUNT = 30;
    public int amsHookEnableFlag;
    public long backgroundLoopCheckTime;
    public int bgThreadWatchingLimit;

    @NonNull
    public BatteryMonitorCallback callback;
    public final List<MonitorFeature> features;
    public int fgThreadWatchingLimit;
    public long foregroundLoopCheckTime;
    public int foregroundServiceLeakLimit;
    public long greyTime;
    public boolean isAggressiveMode;
    public boolean isAmsHookEnabled;
    public boolean isBackgroundModeEnabled;
    public boolean isBuiltinForegroundNotifyEnabled;
    public boolean isForegroundModeEnabled;
    public boolean isInspectiffiesError;
    public boolean isStatAsSample;
    public boolean isStatPidProc;
    public boolean isUseThreadClock;
    public List<String> looperWatchList;
    public int maxJiffiesLogCount;

    @Nullable
    public Callable<String> onSceneSupplier;
    public int overHeatCount;
    public List<String> tagBlackList;
    public List<String> tagWhiteList;
    public int threadRunTimeWatchingLimit;
    public List<String> threadWatchList;
    public long wakelockTimeout;
    public int wakelockWarnCount;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private final BatteryMonitorConfig config = new BatteryMonitorConfig();

        public Builder addLooperWatchList(String str) {
            BatteryMonitorConfig batteryMonitorConfig = this.config;
            if (batteryMonitorConfig.looperWatchList == Collections.EMPTY_LIST) {
                batteryMonitorConfig.looperWatchList = new ArrayList();
            }
            this.config.looperWatchList.add(str);
            return this;
        }

        public Builder addThreadWatchList(String str) {
            BatteryMonitorConfig batteryMonitorConfig = this.config;
            if (batteryMonitorConfig.threadWatchList == Collections.EMPTY_LIST) {
                batteryMonitorConfig.threadWatchList = new ArrayList();
            }
            this.config.threadWatchList.add(str);
            return this;
        }

        public Builder addWakeLockBlackList(String str) {
            BatteryMonitorConfig batteryMonitorConfig = this.config;
            if (batteryMonitorConfig.tagBlackList == Collections.EMPTY_LIST) {
                batteryMonitorConfig.tagBlackList = new ArrayList();
            }
            this.config.tagBlackList.add(str);
            return this;
        }

        public Builder addWakeLockWhiteList(String str) {
            BatteryMonitorConfig batteryMonitorConfig = this.config;
            if (batteryMonitorConfig.tagWhiteList == Collections.EMPTY_LIST) {
                batteryMonitorConfig.tagWhiteList = new ArrayList();
            }
            this.config.tagWhiteList.add(str);
            return this;
        }

        public Builder backgroundLoopCheckTime(long j) {
            if (j > 0) {
                this.config.backgroundLoopCheckTime = j;
            }
            return this;
        }

        public BatteryMonitorConfig build() {
            Collections.sort(this.config.features, new Comparator<MonitorFeature>() { // from class: com.tencent.matrix.batterycanary.monitor.BatteryMonitorConfig.Builder.1
                @Override // java.util.Comparator
                public int compare(MonitorFeature monitorFeature, MonitorFeature monitorFeature2) {
                    return Integer.compare(monitorFeature2.weight(), monitorFeature.weight());
                }
            });
            return this.config;
        }

        public Builder enable(Class<? extends MonitorFeature> cls) {
            try {
                this.config.features.add(cls.newInstance());
            } catch (Exception unused) {
            }
            return this;
        }

        public Builder enableAggressive(boolean z) {
            this.config.isAggressiveMode = z;
            return this;
        }

        public Builder enableAmsHook(boolean z) {
            this.config.isAmsHookEnabled = z;
            return this;
        }

        public Builder enableBackgroundMode(boolean z) {
            this.config.isBackgroundModeEnabled = z;
            return this;
        }

        public Builder enableBuiltinForegroundNotify(boolean z) {
            this.config.isBuiltinForegroundNotifyEnabled = z;
            return this;
        }

        public Builder enableForegroundMode(boolean z) {
            this.config.isForegroundModeEnabled = z;
            return this;
        }

        public Builder enableInspectJffiesError(boolean z) {
            this.config.isInspectiffiesError = z;
            return this;
        }

        public Builder enableStatAsSample(boolean z) {
            this.config.isStatAsSample = z;
            return this;
        }

        public Builder enableStatPidProc(boolean z) {
            this.config.isStatPidProc = z;
            return this;
        }

        public Builder foregroundLoopCheckTime(long j) {
            if (j > 0) {
                this.config.foregroundLoopCheckTime = j;
            }
            return this;
        }

        public Builder foregroundServiceLeakLimit(int i) {
            this.config.foregroundServiceLeakLimit = i;
            return this;
        }

        public Builder greyJiffiesTime(long j) {
            if (j > 0) {
                this.config.greyTime = j;
            }
            return this;
        }

        public Builder setAmsHookEnableFlag(int i) {
            if (i >= 0) {
                this.config.amsHookEnableFlag = i;
            }
            return this;
        }

        public Builder setBgThreadWatchingLimit(int i) {
            if (i > 1000) {
                this.config.bgThreadWatchingLimit = i;
            }
            return this;
        }

        public Builder setCallback(BatteryMonitorCallback batteryMonitorCallback) {
            this.config.callback = batteryMonitorCallback;
            return this;
        }

        public Builder setFgThreadWatchingLimit(int i) {
            if (i > 1000) {
                this.config.fgThreadWatchingLimit = i;
            }
            return this;
        }

        public Builder setMaxJiffiesLogCount(int i) {
            if (i > 0) {
                this.config.maxJiffiesLogCount = i;
            }
            return this;
        }

        public Builder setOverHeatCount(int i) {
            if (i >= 10) {
                this.config.overHeatCount = i;
            }
            return this;
        }

        public Builder setSceneSupplier(Callable<String> callable) {
            this.config.onSceneSupplier = callable;
            return this;
        }

        public Builder setThreadRunTimeWatchingLimit(int i) {
            if (i > 0) {
                this.config.threadRunTimeWatchingLimit = i;
            }
            return this;
        }

        public Builder useThreadClock(boolean z) {
            this.config.isUseThreadClock = z;
            return this;
        }

        public Builder wakelockTimeout(long j) {
            if (j > 0) {
                this.config.wakelockTimeout = j;
            }
            return this;
        }

        public Builder wakelockWarnCount(int i) {
            if (i > 0) {
                this.config.wakelockWarnCount = i;
            }
            return this;
        }
    }

    @NonNull
    public String toString() {
        return "BatteryMonitorConfig{wakelockTimeout=" + this.wakelockTimeout + ", wakelockWarnCount=" + this.wakelockWarnCount + ", greyTime=" + this.greyTime + ", foregroundLoopCheckTime=" + this.foregroundLoopCheckTime + ", backgroundLoopCheckTime=" + this.backgroundLoopCheckTime + ", overHeatCount=" + this.overHeatCount + ", foregroundServiceLeakLimit=" + this.foregroundServiceLeakLimit + ", fgThreadWatchingLimit=" + this.fgThreadWatchingLimit + ", bgThreadWatchingLimit=" + this.bgThreadWatchingLimit + ", isForegroundModeEnabled=" + this.isForegroundModeEnabled + ", isBackgroundModeEnabled=" + this.isBackgroundModeEnabled + ", isBuiltinForegroundNotifyEnabled=" + this.isBuiltinForegroundNotifyEnabled + ", isStatAsSample=" + this.isStatAsSample + ", isStatPidProc=" + this.isStatPidProc + ", isInspectiffiesError=" + this.isInspectiffiesError + ", isAmsHookEnabled=" + this.isAmsHookEnabled + ", isAggressiveMode=" + this.isAggressiveMode + ", isUseThreadClock=" + this.isUseThreadClock + ", tagWhiteList=" + this.tagWhiteList + ", tagBlackList=" + this.tagBlackList + ", looperWatchList=" + this.looperWatchList + ", threadWatchList=" + this.threadWatchList + ", features=" + this.features + '}';
    }

    private BatteryMonitorConfig() {
        this.callback = new BatteryMonitorCallback.BatteryPrinter();
        this.wakelockTimeout = 120000L;
        this.wakelockWarnCount = 30;
        this.greyTime = 30000L;
        this.foregroundLoopCheckTime = 1200000L;
        this.backgroundLoopCheckTime = 600000L;
        this.overHeatCount = 200;
        this.maxJiffiesLogCount = 8;
        this.threadRunTimeWatchingLimit = 10;
        this.foregroundServiceLeakLimit = 100;
        this.fgThreadWatchingLimit = 10000;
        this.bgThreadWatchingLimit = 5000;
        this.isForegroundModeEnabled = true;
        this.isBackgroundModeEnabled = false;
        this.isBuiltinForegroundNotifyEnabled = true;
        this.isStatAsSample = false;
        this.isStatPidProc = false;
        this.isInspectiffiesError = false;
        this.isAmsHookEnabled = false;
        this.amsHookEnableFlag = 0;
        this.isAggressiveMode = false;
        this.isUseThreadClock = false;
        this.tagWhiteList = Collections.emptyList();
        this.tagBlackList = Collections.emptyList();
        this.looperWatchList = Collections.emptyList();
        this.threadWatchList = Collections.emptyList();
        this.features = new ArrayList(3);
    }
}
