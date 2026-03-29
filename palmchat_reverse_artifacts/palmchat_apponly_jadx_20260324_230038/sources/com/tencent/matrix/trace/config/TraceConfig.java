package com.tencent.matrix.trace.config;

import com.huawei.openalliance.ad.constant.x;
import com.tencent.matrix.trace.listeners.IDefaultConfig;
import com.tencent.mrs.plugin.IDynamicConfig;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TraceConfig implements IDefaultConfig {
    private static final String TAG = "Matrix.TraceConfig";
    public String anrTraceFilePath;
    public boolean defaultAnrEnable;
    public boolean defaultAppMethodBeatEnable;
    public boolean defaultFpsEnable;
    public boolean defaultMainThreadPriorityTraceEnable;
    public boolean defaultMethodTraceEnable;
    public boolean defaultSignalAnrEnable;
    public boolean defaultStartupEnable;
    public boolean defualtIdleHandlerEnable;
    public IDynamicConfig dynamicConfig;
    public boolean isDebug;
    public boolean isDevEnv;
    public boolean isHasActivity;
    public String printTraceFilePath;
    public String splashActivities;
    public Set<String> splashActivitiesSet;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private TraceConfig config = new TraceConfig();

        public Builder anrTracePath(String str) {
            this.config.anrTraceFilePath = str;
            return this;
        }

        public TraceConfig build() {
            return this.config;
        }

        public Builder dynamicConfig(IDynamicConfig iDynamicConfig) {
            this.config.dynamicConfig = iDynamicConfig;
            return this;
        }

        public Builder enableAnrTrace(boolean z) {
            this.config.defaultAnrEnable = z;
            return this;
        }

        public Builder enableAppMethodBeat(boolean z) {
            this.config.defaultAppMethodBeatEnable = z;
            return this;
        }

        public Builder enableEvilMethodTrace(boolean z) {
            this.config.defaultMethodTraceEnable = z;
            return this;
        }

        public Builder enableFPS(boolean z) {
            this.config.defaultFpsEnable = z;
            return this;
        }

        public Builder enableIdleHandlerTrace(boolean z) {
            this.config.defualtIdleHandlerEnable = z;
            return this;
        }

        public Builder enableMainThreadPriorityTrace(boolean z) {
            this.config.defaultMainThreadPriorityTraceEnable = z;
            return this;
        }

        public Builder enableSignalAnrTrace(boolean z) {
            this.config.defaultSignalAnrEnable = z;
            return this;
        }

        public Builder enableStartup(boolean z) {
            this.config.defaultStartupEnable = z;
            return this;
        }

        public Builder isDebug(boolean z) {
            this.config.isDebug = z;
            return this;
        }

        public Builder isDevEnv(boolean z) {
            this.config.isDevEnv = z;
            return this;
        }

        public Builder isHasActivity(boolean z) {
            this.config.isHasActivity = z;
            return this;
        }

        public Builder printTracePath(String str) {
            this.config.printTraceFilePath = str;
            return this;
        }

        public Builder splashActivities(String str) {
            this.config.splashActivities = str;
            return this;
        }
    }

    @Override // com.tencent.matrix.trace.listeners.IDefaultConfig
    public String getAnrTraceFilePath() {
        return this.anrTraceFilePath;
    }

    public int getColdStartupThresholdMs() {
        IDynamicConfig iDynamicConfig = this.dynamicConfig;
        if (iDynamicConfig == null) {
            return 10000;
        }
        return iDynamicConfig.get(IDynamicConfig.ExptEnum.clicfg_matrix_trace_app_start_up_threshold.name(), 10000);
    }

    public int getEvilThresholdMs() {
        IDynamicConfig iDynamicConfig = this.dynamicConfig;
        if (iDynamicConfig == null) {
            return 700;
        }
        return iDynamicConfig.get(IDynamicConfig.ExptEnum.clicfg_matrix_trace_evil_method_threshold.name(), 700);
    }

    public int getFrozenThreshold() {
        IDynamicConfig iDynamicConfig = this.dynamicConfig;
        if (iDynamicConfig == null) {
            return 42;
        }
        return iDynamicConfig.get(IDynamicConfig.ExptEnum.clicfg_matrix_fps_dropped_frozen.name(), 42);
    }

    public int getHighThreshold() {
        IDynamicConfig iDynamicConfig = this.dynamicConfig;
        if (iDynamicConfig == null) {
            return 24;
        }
        return iDynamicConfig.get(IDynamicConfig.ExptEnum.clicfg_matrix_fps_dropped_high.name(), 24);
    }

    public int getMiddleThreshold() {
        IDynamicConfig iDynamicConfig = this.dynamicConfig;
        if (iDynamicConfig == null) {
            return 9;
        }
        return iDynamicConfig.get(IDynamicConfig.ExptEnum.clicfg_matrix_fps_dropped_middle.name(), 9);
    }

    public int getNormalThreshold() {
        IDynamicConfig iDynamicConfig = this.dynamicConfig;
        if (iDynamicConfig == null) {
            return 3;
        }
        return iDynamicConfig.get(IDynamicConfig.ExptEnum.clicfg_matrix_fps_dropped_normal.name(), 3);
    }

    @Override // com.tencent.matrix.trace.listeners.IDefaultConfig
    public String getPrintTraceFilePath() {
        return this.printTraceFilePath;
    }

    public Set<String> getSplashActivities() {
        if (this.splashActivitiesSet == null) {
            HashSet hashSet = new HashSet();
            this.splashActivitiesSet = hashSet;
            IDynamicConfig iDynamicConfig = this.dynamicConfig;
            if (iDynamicConfig == null) {
                String str = this.splashActivities;
                if (str == null) {
                    return hashSet;
                }
                hashSet.addAll(Arrays.asList(str.split(x.aQ)));
            } else {
                String str2 = iDynamicConfig.get(IDynamicConfig.ExptEnum.clicfg_matrix_trace_care_scene_set.name(), this.splashActivities);
                if (str2 != null) {
                    this.splashActivities = str2;
                }
                String str3 = this.splashActivities;
                if (str3 != null) {
                    this.splashActivitiesSet.addAll(Arrays.asList(str3.split(x.aQ)));
                }
            }
        }
        return this.splashActivitiesSet;
    }

    public int getTimeSliceMs() {
        IDynamicConfig iDynamicConfig = this.dynamicConfig;
        if (iDynamicConfig == null) {
            return 10000;
        }
        return iDynamicConfig.get(IDynamicConfig.ExptEnum.clicfg_matrix_trace_fps_time_slice.name(), 10000);
    }

    public int getWarmStartupThresholdMs() {
        IDynamicConfig iDynamicConfig = this.dynamicConfig;
        if (iDynamicConfig == null) {
            return 4000;
        }
        return iDynamicConfig.get(IDynamicConfig.ExptEnum.clicfg_matrix_trace_warm_app_start_up_threshold.name(), 4000);
    }

    @Override // com.tencent.matrix.trace.listeners.IDefaultConfig
    public boolean isAnrTraceEnable() {
        return this.defaultAnrEnable;
    }

    @Override // com.tencent.matrix.trace.listeners.IDefaultConfig
    public boolean isAppMethodBeatEnable() {
        return this.defaultAppMethodBeatEnable;
    }

    @Override // com.tencent.matrix.trace.listeners.IDefaultConfig
    public boolean isDebug() {
        return this.isDebug;
    }

    @Override // com.tencent.matrix.trace.listeners.IDefaultConfig
    public boolean isDevEnv() {
        return this.isDevEnv;
    }

    @Override // com.tencent.matrix.trace.listeners.IDefaultConfig
    public boolean isEvilMethodTraceEnable() {
        return this.defaultMethodTraceEnable;
    }

    @Override // com.tencent.matrix.trace.listeners.IDefaultConfig
    public boolean isFPSEnable() {
        return this.defaultFpsEnable;
    }

    public boolean isHasActivity() {
        return this.isHasActivity;
    }

    @Override // com.tencent.matrix.trace.listeners.IDefaultConfig
    public boolean isIdleHandlerEnable() {
        return this.defualtIdleHandlerEnable;
    }

    @Override // com.tencent.matrix.trace.listeners.IDefaultConfig
    public boolean isMainThreadPriorityTraceEnable() {
        return this.defaultMainThreadPriorityTraceEnable;
    }

    @Override // com.tencent.matrix.trace.listeners.IDefaultConfig
    public boolean isSignalAnrTraceEnable() {
        return this.defaultSignalAnrEnable;
    }

    public boolean isStartupEnable() {
        return this.defaultStartupEnable;
    }

    public String toString() {
        return " \n# TraceConfig\n* isDebug:\t" + this.isDebug + "\n* isDevEnv:\t" + this.isDevEnv + "\n* isHasActivity:\t" + this.isHasActivity + "\n* defaultFpsEnable:\t" + this.defaultFpsEnable + "\n* defaultMethodTraceEnable:\t" + this.defaultMethodTraceEnable + "\n* defaultStartupEnable:\t" + this.defaultStartupEnable + "\n* defaultAnrEnable:\t" + this.defaultAnrEnable + "\n* splashActivities:\t" + this.splashActivities + "\n";
    }

    private TraceConfig() {
        this.defaultAppMethodBeatEnable = true;
        this.anrTraceFilePath = "";
        this.printTraceFilePath = "";
        this.isHasActivity = true;
    }
}
