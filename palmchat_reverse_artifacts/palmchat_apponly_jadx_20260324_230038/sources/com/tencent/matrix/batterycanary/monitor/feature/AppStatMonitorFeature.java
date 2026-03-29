package com.tencent.matrix.batterycanary.monitor.feature;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.tencent.matrix.batterycanary.BatteryEventDelegate;
import com.tencent.matrix.batterycanary.monitor.BatteryMonitorCore;
import com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature;
import com.tencent.matrix.batterycanary.utils.BatteryCanaryUtil;
import com.tencent.matrix.batterycanary.utils.TimeBreaker;
import com.tencent.matrix.util.MatrixLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class AppStatMonitorFeature extends AbsMonitorFeature {
    public static final int IMPORTANCE_LEAST = 1024;
    private static final String TAG = "Matrix.battery.AppStatMonitorFeature";
    int mAppImportance = 1024;
    int mGlobalAppImportance = 1024;
    int mForegroundServiceImportanceLimit = 100;

    @NonNull
    List<TimeBreaker.Stamp> mStampList = Collections.emptyList();

    @NonNull
    List<TimeBreaker.Stamp> mSceneStampList = Collections.emptyList();

    @NonNull
    Runnable coolingTask = new Runnable() { // from class: com.tencent.matrix.batterycanary.monitor.feature.AppStatMonitorFeature.1
        @Override // java.lang.Runnable
        public void run() {
            if (AppStatMonitorFeature.this.mStampList.size() >= AppStatMonitorFeature.this.mCore.getConfig().overHeatCount) {
                synchronized (AppStatMonitorFeature.TAG) {
                    TimeBreaker.gcList(AppStatMonitorFeature.this.mStampList);
                }
            }
            if (AppStatMonitorFeature.this.mSceneStampList.size() >= AppStatMonitorFeature.this.mCore.getConfig().overHeatCount) {
                synchronized (AppStatMonitorFeature.TAG) {
                    TimeBreaker.gcList(AppStatMonitorFeature.this.mSceneStampList);
                }
            }
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public interface AppStatListener {
        void onAppSateLeak(boolean z, int i, ComponentName componentName, long j);

        void onForegroundServiceLeak(boolean z, int i, int i2, ComponentName componentName, long j);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class AppStatSnapshot extends MonitorFeature.Snapshot<AppStatSnapshot> {
        public MonitorFeature.Snapshot.Entry.DigitEntry<Long> uptime = MonitorFeature.Snapshot.Entry.DigitEntry.of(0L);
        public MonitorFeature.Snapshot.Entry.DigitEntry<Long> fgRatio = MonitorFeature.Snapshot.Entry.DigitEntry.of(0L);
        public MonitorFeature.Snapshot.Entry.DigitEntry<Long> bgRatio = MonitorFeature.Snapshot.Entry.DigitEntry.of(0L);
        public MonitorFeature.Snapshot.Entry.DigitEntry<Long> fgSrvRatio = MonitorFeature.Snapshot.Entry.DigitEntry.of(0L);

        @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot
        public MonitorFeature.Snapshot.Delta<AppStatSnapshot> diff(AppStatSnapshot appStatSnapshot) {
            return new MonitorFeature.Snapshot.Delta<AppStatSnapshot>(appStatSnapshot, this) { // from class: com.tencent.matrix.batterycanary.monitor.feature.AppStatMonitorFeature.AppStatSnapshot.1
                @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot.Delta
                public AppStatSnapshot computeDelta() {
                    AppStatSnapshot appStatSnapshot2 = new AppStatSnapshot();
                    appStatSnapshot2.uptime = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((AppStatSnapshot) this.bgn).uptime, ((AppStatSnapshot) this.end).uptime);
                    appStatSnapshot2.fgRatio = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((AppStatSnapshot) this.bgn).fgRatio, ((AppStatSnapshot) this.end).fgRatio);
                    appStatSnapshot2.bgRatio = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((AppStatSnapshot) this.bgn).bgRatio, ((AppStatSnapshot) this.end).bgRatio);
                    appStatSnapshot2.fgSrvRatio = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((AppStatSnapshot) this.bgn).fgSrvRatio, ((AppStatSnapshot) this.end).fgSrvRatio);
                    return appStatSnapshot2;
                }
            };
        }
    }

    private void checkBackgroundAppState(final long j) {
        Runnable runnable = new Runnable() { // from class: com.tencent.matrix.batterycanary.monitor.feature.AppStatMonitorFeature.3
            @Override // java.lang.Runnable
            public void run() {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
                Context context = AppStatMonitorFeature.this.mCore.getContext();
                String packageName = context.getPackageName();
                if (packageName.contains(":")) {
                    packageName = packageName.substring(0, packageName.indexOf(":"));
                }
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                    return;
                }
                MatrixLog.i(AppStatMonitorFeature.TAG, "Dump backgroud app sate:", new Object[0]);
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.processName.startsWith(packageName)) {
                        if (runningAppProcessInfo.importance <= AppStatMonitorFeature.this.mForegroundServiceImportanceLimit) {
                            MatrixLog.w(AppStatMonitorFeature.TAG, " + " + runningAppProcessInfo.processName + ", proc = " + runningAppProcessInfo.importance + ", reason = " + runningAppProcessInfo.importanceReasonComponent, new Object[0]);
                            AppStatMonitorFeature.this.mCore.onAppSateLeak(runningAppProcessInfo.processName.equals(context.getPackageName()), runningAppProcessInfo.importance, runningAppProcessInfo.importanceReasonComponent, j);
                        } else {
                            MatrixLog.i(AppStatMonitorFeature.TAG, " - " + runningAppProcessInfo.processName + ", proc = " + runningAppProcessInfo.importance + ", reason = " + runningAppProcessInfo.importanceReasonComponent, new Object[0]);
                        }
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.mCore.getHandler().post(runnable);
        } else {
            runnable.run();
        }
    }

    private void checkOverHeat() {
        this.mCore.getHandler().removeCallbacks(this.coolingTask);
        this.mCore.getHandler().postDelayed(this.coolingTask, 1000L);
    }

    private void updateAppImportance() {
        int i = this.mAppImportance;
        int i2 = this.mForegroundServiceImportanceLimit;
        if (i > i2 || this.mGlobalAppImportance > i2) {
            Runnable runnable = new Runnable() { // from class: com.tencent.matrix.batterycanary.monitor.feature.AppStatMonitorFeature.2
                @Override // java.lang.Runnable
                public void run() {
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
                    Context context = AppStatMonitorFeature.this.mCore.getContext();
                    String packageName = context.getPackageName();
                    if (packageName.contains(":")) {
                        packageName = packageName.substring(0, packageName.indexOf(":"));
                    }
                    ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                    if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                        return;
                    }
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.processName.startsWith(packageName)) {
                            if (AppStatMonitorFeature.this.mGlobalAppImportance > runningAppProcessInfo.importance) {
                                MatrixLog.i(AppStatMonitorFeature.TAG, "update global importance: " + AppStatMonitorFeature.this.mGlobalAppImportance + " > " + runningAppProcessInfo.importance + ", reason = " + runningAppProcessInfo.importanceReasonComponent, new Object[0]);
                                AppStatMonitorFeature.this.mGlobalAppImportance = runningAppProcessInfo.importance;
                            }
                            if (runningAppProcessInfo.processName.equals(context.getPackageName()) && AppStatMonitorFeature.this.mAppImportance > runningAppProcessInfo.importance) {
                                MatrixLog.i(AppStatMonitorFeature.TAG, "update app importance: " + AppStatMonitorFeature.this.mAppImportance + " > " + runningAppProcessInfo.importance + ", reason = " + runningAppProcessInfo.importanceReasonComponent, new Object[0]);
                                AppStatMonitorFeature.this.mAppImportance = runningAppProcessInfo.importance;
                            }
                        }
                    }
                }
            };
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.mCore.getHandler().post(runnable);
            } else {
                runnable.run();
            }
        }
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void configure(BatteryMonitorCore batteryMonitorCore) {
        super.configure(batteryMonitorCore);
        this.mForegroundServiceImportanceLimit = Math.max(batteryMonitorCore.getConfig().foregroundServiceLeakLimit, 100);
    }

    public AppStatSnapshot currentAppStatSnapshot() {
        return currentAppStatSnapshot(0L);
    }

    public TimeBreaker.TimePortions currentSceneSnapshot() {
        return currentSceneSnapshot(0L);
    }

    @NonNull
    public List<TimeBreaker.Stamp> getAppStatStampList() {
        return this.mStampList.isEmpty() ? Collections.emptyList() : new ArrayList(this.mStampList);
    }

    @NonNull
    public List<TimeBreaker.Stamp> getSceneStampList() {
        return this.mSceneStampList.isEmpty() ? Collections.emptyList() : new ArrayList(this.mSceneStampList);
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature
    public String getTag() {
        return TAG;
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    @WorkerThread
    public void onBackgroundCheck(long j) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        super.onBackgroundCheck(j);
        MatrixLog.i(TAG, "#onBackgroundCheck, during = " + j, new Object[0]);
        int i = this.mGlobalAppImportance;
        int i2 = this.mForegroundServiceImportanceLimit;
        if (i > i2 || this.mAppImportance > i2) {
            Context context = this.mCore.getContext();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null || (runningServices = activityManager.getRunningServices(Integer.MAX_VALUE)) == null) {
                return;
            }
            for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                if (!TextUtils.isEmpty(runningServiceInfo.process) && runningServiceInfo.process.startsWith(context.getPackageName()) && runningServiceInfo.foreground) {
                    MatrixLog.i(TAG, "checkForegroundService whether app importance is low, during = " + j, new Object[0]);
                    if (this.mGlobalAppImportance > this.mForegroundServiceImportanceLimit) {
                        MatrixLog.w(TAG, "foreground service detected with low global importance: " + this.mAppImportance + ", " + this.mGlobalAppImportance + ", " + runningServiceInfo.service, new Object[0]);
                        this.mCore.onForegroundServiceLeak(false, this.mAppImportance, this.mGlobalAppImportance, runningServiceInfo.service, j);
                    }
                    if (this.mAppImportance > this.mForegroundServiceImportanceLimit && runningServiceInfo.process.equals(context.getPackageName())) {
                        MatrixLog.w(TAG, "foreground service detected with low app importance: " + this.mAppImportance + ", " + this.mGlobalAppImportance + ", " + runningServiceInfo.service, new Object[0]);
                        this.mCore.onForegroundServiceLeak(true, this.mAppImportance, this.mGlobalAppImportance, runningServiceInfo.service, j);
                    }
                }
            }
        }
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onForeground(boolean z) {
        super.onForeground(z);
        int appStatImmediately = BatteryCanaryUtil.getAppStatImmediately(this.mCore.getContext(), z);
        BatteryCanaryUtil.getProxy().updateAppStat(appStatImmediately);
        synchronized (TAG) {
            if (this.mStampList != Collections.EMPTY_LIST) {
                MatrixLog.i(BatteryEventDelegate.TAG, "onStat >> " + BatteryCanaryUtil.convertAppStat(appStatImmediately), new Object[0]);
                this.mStampList.add(0, new TimeBreaker.Stamp(String.valueOf(appStatImmediately)));
                checkOverHeat();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("updateAppImportance when app ");
        sb.append(z ? "foreground" : "background");
        MatrixLog.i(TAG, sb.toString(), new Object[0]);
        updateAppImportance();
    }

    public void onStatScene(@NonNull String str) {
        synchronized (TAG) {
            List<TimeBreaker.Stamp> list = this.mSceneStampList;
            if (list != Collections.EMPTY_LIST) {
                list.add(0, new TimeBreaker.Stamp(str));
                checkOverHeat();
            }
        }
        MatrixLog.i(TAG, "updateAppImportance when launch: " + str, new Object[0]);
        updateAppImportance();
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onTurnOff() {
        super.onTurnOff();
        synchronized (TAG) {
            this.mStampList.clear();
            this.mSceneStampList.clear();
        }
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onTurnOn() {
        super.onTurnOn();
        TimeBreaker.Stamp stamp = new TimeBreaker.Stamp("1");
        TimeBreaker.Stamp stamp2 = new TimeBreaker.Stamp(this.mCore.getScene());
        synchronized (TAG) {
            ArrayList arrayList = new ArrayList();
            this.mStampList = arrayList;
            arrayList.add(0, stamp);
            ArrayList arrayList2 = new ArrayList();
            this.mSceneStampList = arrayList2;
            arrayList2.add(0, stamp2);
        }
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public int weight() {
        return Integer.MAX_VALUE;
    }

    public AppStatSnapshot currentAppStatSnapshot(long j) {
        try {
            TimeBreaker.TimePortions timePortionsConfigurePortions = TimeBreaker.configurePortions(this.mStampList, j, 10L, new TimeBreaker.Stamp.Stamper() { // from class: com.tencent.matrix.batterycanary.monitor.feature.AppStatMonitorFeature.4
                @Override // com.tencent.matrix.batterycanary.utils.TimeBreaker.Stamp.Stamper
                public TimeBreaker.Stamp stamp(String str) {
                    return new TimeBreaker.Stamp(String.valueOf(BatteryCanaryUtil.getAppStat(AppStatMonitorFeature.this.mCore.getContext(), AppStatMonitorFeature.this.mCore.isForeground())));
                }
            });
            AppStatSnapshot appStatSnapshot = new AppStatSnapshot();
            appStatSnapshot.setValid(timePortionsConfigurePortions.isValid());
            appStatSnapshot.uptime = MonitorFeature.Snapshot.Entry.DigitEntry.of(Long.valueOf(timePortionsConfigurePortions.totalUptime));
            appStatSnapshot.fgRatio = MonitorFeature.Snapshot.Entry.DigitEntry.of(Long.valueOf(timePortionsConfigurePortions.getRatio("1")));
            appStatSnapshot.bgRatio = MonitorFeature.Snapshot.Entry.DigitEntry.of(Long.valueOf(timePortionsConfigurePortions.getRatio("2")));
            appStatSnapshot.fgSrvRatio = MonitorFeature.Snapshot.Entry.DigitEntry.of(Long.valueOf(timePortionsConfigurePortions.getRatio("3")));
            return appStatSnapshot;
        } catch (Throwable th) {
            MatrixLog.w(TAG, "configureSnapshot fail: " + th.getMessage(), new Object[0]);
            AppStatSnapshot appStatSnapshot2 = new AppStatSnapshot();
            appStatSnapshot2.setValid(false);
            return appStatSnapshot2;
        }
    }

    public TimeBreaker.TimePortions currentSceneSnapshot(long j) {
        try {
            return TimeBreaker.configurePortions(this.mSceneStampList, j, 10L, new TimeBreaker.Stamp.Stamper() { // from class: com.tencent.matrix.batterycanary.monitor.feature.AppStatMonitorFeature.5
                @Override // com.tencent.matrix.batterycanary.utils.TimeBreaker.Stamp.Stamper
                public TimeBreaker.Stamp stamp(String str) {
                    return new TimeBreaker.Stamp(AppStatMonitorFeature.this.mCore.getScene());
                }
            });
        } catch (Throwable th) {
            MatrixLog.w(TAG, "currentSceneSnapshot fail: " + th.getMessage(), new Object[0]);
            return TimeBreaker.TimePortions.ofInvalid();
        }
    }
}
