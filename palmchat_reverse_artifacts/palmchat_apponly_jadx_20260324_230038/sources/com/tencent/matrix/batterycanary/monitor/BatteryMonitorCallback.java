package com.tencent.matrix.batterycanary.monitor;

import android.content.ComponentName;
import android.os.HandlerThread;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LongSparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.cdo.oaps.ad.OapsKey;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.batterycanary.monitor.BatteryMonitorCore;
import com.tencent.matrix.batterycanary.monitor.feature.AbsTaskMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.AlarmMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.AppStatMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.BlueToothMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.DeviceStatMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.JiffiesMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.LocationMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.LooperTaskMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.NotificationMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.TrafficMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.WakeLockMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.WifiMonitorFeature;
import com.tencent.matrix.batterycanary.utils.BatteryCanaryUtil;
import com.tencent.matrix.batterycanary.utils.Consumer;
import com.tencent.matrix.util.MatrixLog;
import com.wifi.adsdk.download.LxAdDLManager;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface BatteryMonitorCallback extends BatteryMonitorCore.JiffiesListener, LooperTaskMonitorFeature.LooperTaskListener, WakeLockMonitorFeature.WakeLockListener, AlarmMonitorFeature.AlarmListener, JiffiesMonitorFeature.JiffiesListener, NotificationMonitorFeature.NotificationListener, AppStatMonitorFeature.AppStatListener {

    /* JADX INFO: compiled from: SearchBox */
    public static class BatteryPrinter implements BatteryMonitorCallback {
        private static final int ONE_MIN = 60000;
        private static final String TAG = "Matrix.battery.BatteryPrinter";

        @Nullable
        protected AlarmMonitorFeature mAlarmFeat;

        @Nullable
        protected AppStatMonitorFeature mAppStatFeat;

        @Nullable
        AppStats mAppStats;

        @Nullable
        protected BlueToothMonitorFeature mBlueToothFeat;

        @Nullable
        protected DeviceStatMonitorFeature mDevStatFeat;
        private boolean mIsForeground;

        @Nullable
        protected JiffiesMonitorFeature mJiffiesFeat;

        @Nullable
        protected AlarmMonitorFeature.AlarmSnapshot mLastAlarmSnapshot;

        @Nullable
        protected DeviceStatMonitorFeature.BatteryTmpSnapshot mLastBatteryTmpSnapshot;

        @Nullable
        protected BlueToothMonitorFeature.BlueToothSnapshot mLastBlueToothSnapshot;

        @Nullable
        protected DeviceStatMonitorFeature.CpuFreqSnapshot mLastCpuFreqSnapshot;

        @Nullable
        protected JiffiesMonitorFeature.JiffiesSnapshot mLastJiffiesSnapshot;

        @Nullable
        protected LocationMonitorFeature.LocationSnapshot mLastLocationSnapshot;

        @Nullable
        protected TrafficMonitorFeature.RadioStatSnapshot mLastTrafficSnapshot;

        @Nullable
        protected WakeLockMonitorFeature.WakeLockSnapshot mLastWakeWakeLockSnapshot;

        @Nullable
        protected WifiMonitorFeature.WifiSnapshot mLastWifiSnapshot;

        @Nullable
        protected LocationMonitorFeature mLocationFeat;

        @NonNull
        private BatteryMonitorCore mMonitor;
        private long mTraceBgnMillis;

        @Nullable
        protected TrafficMonitorFeature mTrafficFeat;

        @Nullable
        protected WakeLockMonitorFeature mWakeLockFeat;

        @Nullable
        protected WifiMonitorFeature mWifiMonitorFeat;
        private final Printer mPrinter = new Printer();
        private final LongSparseArray<List<LooperTaskMonitorFeature.TaskTraceInfo>> tasks = new LongSparseArray<>();

        /* JADX INFO: compiled from: SearchBox */
        public static class Printer {
            private final StringBuilder sb = new StringBuilder();

            public Printer append(Object obj) {
                this.sb.append(obj);
                return this;
            }

            public void clear() {
                StringBuilder sb = this.sb;
                sb.delete(0, sb.length());
            }

            public Printer createSection(String str) {
                StringBuilder sb = this.sb;
                sb.append("+ --------------------------------------------------------------------------------------------");
                sb.append("\n");
                StringBuilder sb2 = this.sb;
                sb2.append("| ");
                sb2.append(str);
                sb2.append(" :");
                sb2.append("\n");
                return this;
            }

            public Printer createSubSection(String str) {
                StringBuilder sb = this.sb;
                sb.append("| ");
                sb.append("  <");
                sb.append(str);
                sb.append(">\n");
                return this;
            }

            public void dump() {
                try {
                    MatrixLog.i(BatteryPrinter.TAG, "%s", "\t\n" + this.sb.toString());
                } catch (Throwable th) {
                    MatrixLog.printErrStackTrace(BatteryPrinter.TAG, th, "log format error", new Object[0]);
                }
            }

            public Printer enter() {
                this.sb.append("\n");
                return this;
            }

            public Printer tab() {
                this.sb.append("\t");
                return this;
            }

            @NonNull
            public String toString() {
                return this.sb.toString();
            }

            public Printer writeEnding() {
                this.sb.append("**********************************************************************************************");
                return this;
            }

            public Printer writeLine(String str) {
                StringBuilder sb = this.sb;
                sb.append("| ");
                sb.append("  -> ");
                sb.append(str);
                sb.append("\n");
                return this;
            }

            public Printer writeTitle() {
                StringBuilder sb = this.sb;
                sb.append("****************************************** PowerTest *****************************************");
                sb.append("\n");
                return this;
            }

            public Printer writeLine(String str, String str2) {
                StringBuilder sb = this.sb;
                sb.append("| ");
                sb.append("  -> ");
                sb.append(str);
                sb.append("\t= ");
                sb.append(str2);
                sb.append("\n");
                return this;
            }
        }

        @VisibleForTesting
        public final BatteryPrinter attach(BatteryMonitorCore batteryMonitorCore) {
            this.mMonitor = batteryMonitorCore;
            return this;
        }

        public void createSection(String str, Consumer<Printer> consumer) {
            this.mPrinter.createSection(str);
            consumer.accept(this.mPrinter);
        }

        public AppStats getAppStats() {
            AppStats appStats = this.mAppStats;
            return appStats != null ? appStats : AppStats.current();
        }

        @NonNull
        public BatteryMonitorCore getMonitor() {
            return this.mMonitor;
        }

        public boolean isForegroundReport() {
            return this.mIsForeground;
        }

        @CallSuper
        public void onCanaryDump(AppStats appStats) {
            this.mPrinter.clear();
            this.mPrinter.writeTitle();
            onWritingJiffiesSection(appStats);
            onWritingSections(appStats);
            onWritingAppStatSection(appStats);
            this.mPrinter.writeEnding();
            this.mPrinter.dump();
            synchronized (this.tasks) {
                this.tasks.clear();
            }
        }

        @Override // com.tencent.matrix.batterycanary.monitor.feature.LooperTaskMonitorFeature.LooperTaskListener
        public void onTaskTrace(Thread thread, List<LooperTaskMonitorFeature.TaskTraceInfo> list) {
            if (thread instanceof HandlerThread) {
                synchronized (this.tasks) {
                    this.tasks.put(((HandlerThread) thread).getThreadId(), list);
                }
            }
        }

        @Override // com.tencent.matrix.batterycanary.monitor.BatteryMonitorCore.JiffiesListener
        @CallSuper
        public void onTraceBegin() {
            this.mTraceBgnMillis = SystemClock.uptimeMillis();
            AlarmMonitorFeature alarmMonitorFeature = (AlarmMonitorFeature) this.mMonitor.getMonitorFeature(AlarmMonitorFeature.class);
            this.mAlarmFeat = alarmMonitorFeature;
            if (alarmMonitorFeature != null) {
                this.mLastAlarmSnapshot = alarmMonitorFeature.currentAlarms();
            }
            this.mAppStatFeat = (AppStatMonitorFeature) this.mMonitor.getMonitorFeature(AppStatMonitorFeature.class);
            BlueToothMonitorFeature blueToothMonitorFeature = (BlueToothMonitorFeature) this.mMonitor.getMonitorFeature(BlueToothMonitorFeature.class);
            this.mBlueToothFeat = blueToothMonitorFeature;
            if (blueToothMonitorFeature != null) {
                this.mLastBlueToothSnapshot = blueToothMonitorFeature.currentSnapshot();
            }
            DeviceStatMonitorFeature deviceStatMonitorFeature = (DeviceStatMonitorFeature) this.mMonitor.getMonitorFeature(DeviceStatMonitorFeature.class);
            this.mDevStatFeat = deviceStatMonitorFeature;
            if (deviceStatMonitorFeature != null) {
                this.mLastCpuFreqSnapshot = deviceStatMonitorFeature.currentCpuFreq();
                this.mLastBatteryTmpSnapshot = this.mDevStatFeat.currentBatteryTemperature(this.mMonitor.getContext());
            }
            JiffiesMonitorFeature jiffiesMonitorFeature = (JiffiesMonitorFeature) this.mMonitor.getMonitorFeature(JiffiesMonitorFeature.class);
            this.mJiffiesFeat = jiffiesMonitorFeature;
            if (jiffiesMonitorFeature != null) {
                this.mLastJiffiesSnapshot = jiffiesMonitorFeature.currentJiffiesSnapshot();
            }
            LocationMonitorFeature locationMonitorFeature = (LocationMonitorFeature) this.mMonitor.getMonitorFeature(LocationMonitorFeature.class);
            this.mLocationFeat = locationMonitorFeature;
            if (locationMonitorFeature != null) {
                this.mLastLocationSnapshot = locationMonitorFeature.currentSnapshot();
            }
            TrafficMonitorFeature trafficMonitorFeature = (TrafficMonitorFeature) this.mMonitor.getMonitorFeature(TrafficMonitorFeature.class);
            this.mTrafficFeat = trafficMonitorFeature;
            if (trafficMonitorFeature != null) {
                this.mLastTrafficSnapshot = trafficMonitorFeature.currentRadioSnapshot(this.mMonitor.getContext());
            }
            WakeLockMonitorFeature wakeLockMonitorFeature = (WakeLockMonitorFeature) this.mMonitor.getMonitorFeature(WakeLockMonitorFeature.class);
            this.mWakeLockFeat = wakeLockMonitorFeature;
            if (wakeLockMonitorFeature != null) {
                this.mLastWakeWakeLockSnapshot = wakeLockMonitorFeature.currentWakeLocks();
            }
            WifiMonitorFeature wifiMonitorFeature = (WifiMonitorFeature) this.mMonitor.getMonitorFeature(WifiMonitorFeature.class);
            this.mWifiMonitorFeat = wifiMonitorFeature;
            if (wifiMonitorFeature != null) {
                this.mLastWifiSnapshot = wifiMonitorFeature.currentSnapshot();
            }
        }

        @Override // com.tencent.matrix.batterycanary.monitor.BatteryMonitorCore.JiffiesListener
        public void onTraceEnd(boolean z) {
            this.mIsForeground = z;
            long jUptimeMillis = SystemClock.uptimeMillis();
            long j = this.mTraceBgnMillis;
            long j2 = jUptimeMillis - j;
            if (j > 0 && j2 > 0) {
                AppStats foreground = AppStats.current(j2).setForeground(z);
                this.mAppStats = foreground;
                onCanaryDump(foreground);
                this.mAppStats = null;
                return;
            }
            MatrixLog.w(TAG, "skip invalid battery tracing, bgn = " + this.mTraceBgnMillis + ", during = " + j2, new Object[0]);
        }

        @Override // com.tencent.matrix.batterycanary.monitor.feature.WakeLockMonitorFeature.WakeLockListener
        public void onWakeLockTimeout(int i, WakeLockMonitorFeature.WakeLockTrace.WakeLockRecord wakeLockRecord) {
        }

        @Override // com.tencent.matrix.batterycanary.monitor.feature.JiffiesMonitorFeature.JiffiesListener
        public void onWatchingThreads(MonitorFeature.Snapshot.Entry.ListEntry<? extends JiffiesMonitorFeature.JiffiesSnapshot.ThreadJiffiesEntry> listEntry) {
            Printer printer = new Printer();
            printer.writeTitle();
            printer.append("| Thread WatchDog").append("\n");
            printer.createSection("jiffies(" + listEntry.getList().size() + ")");
            printer.writeLine(LxAdDLManager.ITEM_DESC, "(status)name(tid)\ttotal");
            for (ITEM item : listEntry.getList()) {
                printer.append("|   -> (").append(item.isNewAdded ? "+" : Constants.WAVE_SEPARATOR).append("/").append(item.stat).append(")").append(item.name).append("(").append(Integer.valueOf(item.tid)).append(")\t").append(Long.valueOf(item.get().longValue())).append("\tjiffies").append("\n");
            }
            printer.createSection("stacks");
            boolean z = getMonitor().getConfig().isAggressiveMode;
            if (!z || !getMonitor().getConfig().threadWatchList.isEmpty()) {
                for (ITEM item2 : listEntry.getList()) {
                    for (String str : getMonitor().getConfig().threadWatchList) {
                        if (str.equalsIgnoreCase(item2.name) || item2.name.contains(str)) {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        break;
                    }
                }
            }
            if (z) {
                Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
                MatrixLog.i(TAG, "onWatchingThreads dump stacks, get all threads size = " + allStackTraces, new Object[0]);
                for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                    Thread key = entry.getKey();
                    StackTraceElement[] value = entry.getValue();
                    String name = key.getName();
                    Iterator it = listEntry.getList().iterator();
                    while (it.hasNext()) {
                        String str2 = ((JiffiesMonitorFeature.JiffiesSnapshot.ThreadJiffiesEntry) it.next()).name;
                        if (str2.equalsIgnoreCase(name) || name.contains(str2)) {
                            printer.append("|   -> ").append("(").append(key.getState()).append(")").append(name).append("(").append(Long.valueOf(key.getId())).append(")").append("\n");
                            BatteryCanaryUtil.stackTraceToString(value);
                            for (StackTraceElement stackTraceElement : value) {
                                printer.append("|      ").append(stackTraceElement).append("\n");
                            }
                        }
                    }
                }
            } else {
                printer.append("|   disabled").append("\n");
            }
            printer.writeEnding();
            printer.dump();
        }

        @CallSuper
        public void onWritingAppStatSection(final AppStats appStats) {
            createSection("app_stats", new Consumer<Printer>() { // from class: com.tencent.matrix.batterycanary.monitor.BatteryMonitorCallback.BatteryPrinter.1
                @Override // com.tencent.matrix.batterycanary.utils.Consumer
                public void accept(Printer printer) {
                    printer.createSubSection("stat_time");
                    printer.writeLine("time", appStats.getMinute() + "(min)");
                    printer.writeLine("fg", String.valueOf(appStats.appFgRatio));
                    printer.writeLine(OapsKey.KEY_BG, String.valueOf(appStats.appBgRatio));
                    printer.writeLine("fgSrv", String.valueOf(appStats.appFgSrvRatio));
                    printer.writeLine("devCharging", String.valueOf(appStats.devChargingRatio));
                    printer.writeLine("devScreenOff", String.valueOf(appStats.devSceneOffRatio));
                    if (!TextUtils.isEmpty(appStats.sceneTop1)) {
                        printer.writeLine("sceneTop1", appStats.sceneTop1 + "/" + appStats.sceneTop1Ratio);
                    }
                    if (!TextUtils.isEmpty(appStats.sceneTop2)) {
                        printer.writeLine("sceneTop2", appStats.sceneTop2 + "/" + appStats.sceneTop2Ratio);
                    }
                    AppStatMonitorFeature appStatMonitorFeature = BatteryPrinter.this.mAppStatFeat;
                    if (appStatMonitorFeature != null) {
                        AppStatMonitorFeature.AppStatSnapshot appStatSnapshotCurrentAppStatSnapshot = appStatMonitorFeature.currentAppStatSnapshot();
                        printer.createSubSection("run_time");
                        printer.writeLine("time", (((Long) appStatSnapshotCurrentAppStatSnapshot.uptime.get()).longValue() / 60000) + "(min)");
                        printer.writeLine("fg", String.valueOf(appStatSnapshotCurrentAppStatSnapshot.fgRatio.get()));
                        printer.writeLine(OapsKey.KEY_BG, String.valueOf(appStatSnapshotCurrentAppStatSnapshot.bgRatio.get()));
                        printer.writeLine("fgSrv", String.valueOf(appStatSnapshotCurrentAppStatSnapshot.fgSrvRatio.get()));
                    }
                }
            });
        }

        @CallSuper
        public void onWritingJiffiesSection(AppStats appStats) {
            JiffiesMonitorFeature jiffiesMonitorFeature = this.mJiffiesFeat;
            if (jiffiesMonitorFeature == null || this.mLastJiffiesSnapshot == null) {
                return;
            }
            MonitorFeature.Snapshot.Delta<JiffiesMonitorFeature.JiffiesSnapshot> deltaDiff = jiffiesMonitorFeature.currentJiffiesSnapshot().diff(this.mLastJiffiesSnapshot);
            long minute = appStats.getMinute();
            for (ITEM item : ((JiffiesMonitorFeature.JiffiesSnapshot) deltaDiff.dlt).threadEntries.getList()) {
                if (item.stat.toUpperCase().contains("R")) {
                    long jLongValue = item.get().longValue() / minute;
                    int i = getMonitor().getConfig().threadRunTimeWatchingLimit;
                    if (appStats.isForeground()) {
                        if (minute > i && jLongValue > getMonitor().getConfig().fgThreadWatchingLimit) {
                            MatrixLog.i(TAG, "threadWatchDog fg set, name = " + ((JiffiesMonitorFeature.JiffiesSnapshot) deltaDiff.dlt).name + ", pid = " + ((JiffiesMonitorFeature.JiffiesSnapshot) deltaDiff.dlt).pid + ", tid = " + item.tid, new Object[0]);
                            this.mJiffiesFeat.watchBackThreadSate(true, ((JiffiesMonitorFeature.JiffiesSnapshot) deltaDiff.dlt).pid, item.tid);
                        }
                    } else if (minute > i && jLongValue > getMonitor().getConfig().bgThreadWatchingLimit) {
                        MatrixLog.i(TAG, "threadWatchDog bg set, name = " + ((JiffiesMonitorFeature.JiffiesSnapshot) deltaDiff.dlt).name + ", pid = " + ((JiffiesMonitorFeature.JiffiesSnapshot) deltaDiff.dlt).pid + ", tid = " + item.tid, new Object[0]);
                        this.mJiffiesFeat.watchBackThreadSate(false, ((JiffiesMonitorFeature.JiffiesSnapshot) deltaDiff.dlt).pid, item.tid);
                    }
                }
            }
            onReportJiffies(deltaDiff);
            onWritingSectionContent(deltaDiff, appStats, this.mPrinter);
        }

        @CallSuper
        public boolean onWritingSectionContent(@NonNull MonitorFeature.Snapshot.Delta<?> delta, AppStats appStats, Printer printer) {
            RECORD record = delta.dlt;
            if (record instanceof JiffiesMonitorFeature.JiffiesSnapshot) {
                long jMax = Math.max(1L, delta.during / 60000);
                long jLongValue = ((Long) ((JiffiesMonitorFeature.JiffiesSnapshot) delta.dlt).totalJiffies.get()).longValue() / jMax;
                printer.append("| ").append("pid=").append(Integer.valueOf(Process.myPid())).tab().tab().append("fg=").append(BatteryCanaryUtil.convertAppStat(appStats.getAppStat())).tab().tab().append("during(min)=").append(Long.valueOf(jMax)).tab().tab().append("diff(jiffies)=").append(((JiffiesMonitorFeature.JiffiesSnapshot) delta.dlt).totalJiffies.get()).tab().tab().append("avg(jiffies/min)=").append(Long.valueOf(jLongValue)).enter();
                printer.createSection("jiffies(" + ((JiffiesMonitorFeature.JiffiesSnapshot) delta.dlt).threadEntries.getList().size() + ")");
                printer.writeLine(LxAdDLManager.ITEM_DESC, "(status)name(tid)\tavg/total");
                printer.writeLine("inc_thread_num", String.valueOf(((JiffiesMonitorFeature.JiffiesSnapshot) delta.dlt).threadNum.get()));
                printer.writeLine("cur_thread_num", String.valueOf(((JiffiesMonitorFeature.JiffiesSnapshot) delta.end).threadNum.get()));
                for (JiffiesMonitorFeature.JiffiesSnapshot.ThreadJiffiesEntry threadJiffiesEntry : ((JiffiesMonitorFeature.JiffiesSnapshot) delta.dlt).threadEntries.getList().subList(0, Math.min(((JiffiesMonitorFeature.JiffiesSnapshot) delta.dlt).threadEntries.getList().size(), 8))) {
                    long jLongValue2 = threadJiffiesEntry.get().longValue();
                    printer.append("|   -> (").append(threadJiffiesEntry.isNewAdded ? "+" : Constants.WAVE_SEPARATOR).append("/").append(threadJiffiesEntry.stat).append(")").append(threadJiffiesEntry.name).append("(").append(Integer.valueOf(threadJiffiesEntry.tid)).append(")\t").append(Long.valueOf(jLongValue2 / jMax)).append("/").append(Long.valueOf(jLongValue2)).append("\tjiffies").append("\n");
                    List<LooperTaskMonitorFeature.TaskTraceInfo> list = this.tasks.get(threadJiffiesEntry.tid);
                    if (list != null && !list.isEmpty()) {
                        Iterator<LooperTaskMonitorFeature.TaskTraceInfo> it = list.subList(0, Math.min(3, list.size())).iterator();
                        while (it.hasNext()) {
                            printer.append("|\t\t").append(it.next()).append("\n");
                        }
                    }
                }
                printer.append("|\t\t......\n");
                if (jLongValue <= 1000 && delta.isValid()) {
                    return true;
                }
                printer.append("|  ").append(jLongValue > 1000 ? " #overHeat" : "").append(delta.isValid() ? "" : " #invalid").append("\n");
                return true;
            }
            if (record instanceof AlarmMonitorFeature.AlarmSnapshot) {
                printer.createSubSection(NotificationCompat.CATEGORY_ALARM);
                printer.writeLine(delta.during + "(mls)\t" + (delta.during / 60000) + "(min)");
                printer.writeLine("inc_alarm_count", String.valueOf(((AlarmMonitorFeature.AlarmSnapshot) delta.dlt).totalCount.get()));
                printer.writeLine("inc_trace_count", String.valueOf(((AlarmMonitorFeature.AlarmSnapshot) delta.dlt).tracingCount.get()));
                printer.writeLine("inc_dupli_group", String.valueOf(((AlarmMonitorFeature.AlarmSnapshot) delta.dlt).duplicatedGroup.get()));
                printer.writeLine("inc_dupli_count", String.valueOf(((AlarmMonitorFeature.AlarmSnapshot) delta.dlt).duplicatedCount.get()));
                return true;
            }
            if (record instanceof WakeLockMonitorFeature.WakeLockSnapshot) {
                printer.createSubSection("wake_lock");
                printer.writeLine(delta.during + "(mls)\t" + (delta.during / 60000) + "(min)");
                printer.writeLine("inc_lock_count", String.valueOf(((WakeLockMonitorFeature.WakeLockSnapshot) delta.dlt).totalWakeLockCount));
                printer.writeLine("inc_time_total", String.valueOf(((WakeLockMonitorFeature.WakeLockSnapshot) delta.dlt).totalWakeLockTime));
                List<ITEM> list2 = ((WakeLockMonitorFeature.WakeLockSnapshot) delta.end).totalWakeLockRecords.getList();
                if (list2.isEmpty()) {
                    return true;
                }
                printer.createSubSection("locking");
                for (ITEM item : list2) {
                    if (!((WakeLockMonitorFeature.WakeLockTrace.WakeLockRecord) item.get()).isFinished()) {
                        printer.writeLine(((WakeLockMonitorFeature.WakeLockTrace.WakeLockRecord) item.get()).toString());
                    }
                }
                return true;
            }
            if (record instanceof BlueToothMonitorFeature.BlueToothSnapshot) {
                printer.createSubSection("bluetooh");
                printer.writeLine(delta.during + "(mls)\t" + (delta.during / 60000) + "(min)");
                printer.writeLine("inc_regs_count", String.valueOf(((BlueToothMonitorFeature.BlueToothSnapshot) delta.dlt).regsCount.get()));
                printer.writeLine("inc_dics_count", String.valueOf(((BlueToothMonitorFeature.BlueToothSnapshot) delta.dlt).discCount.get()));
                printer.writeLine("inc_scan_count", String.valueOf(((BlueToothMonitorFeature.BlueToothSnapshot) delta.dlt).scanCount.get()));
                return true;
            }
            if (record instanceof WifiMonitorFeature.WifiSnapshot) {
                printer.createSubSection("wifi");
                printer.writeLine(delta.during + "(mls)\t" + (delta.during / 60000) + "(min)");
                printer.writeLine("inc_scan_count", String.valueOf(((WifiMonitorFeature.WifiSnapshot) delta.dlt).scanCount.get()));
                printer.writeLine("inc_qury_count", String.valueOf(((WifiMonitorFeature.WifiSnapshot) delta.dlt).queryCount.get()));
                return true;
            }
            if (record instanceof LocationMonitorFeature.LocationSnapshot) {
                printer.createSubSection("location");
                printer.writeLine(delta.during + "(mls)\t" + (delta.during / 60000) + "(min)");
                printer.writeLine("inc_scan_count", String.valueOf(((LocationMonitorFeature.LocationSnapshot) delta.dlt).scanCount.get()));
                return true;
            }
            if (record instanceof DeviceStatMonitorFeature.CpuFreqSnapshot) {
                printer.createSubSection("cpufreq");
                printer.writeLine(delta.during + "(mls)\t" + (delta.during / 60000) + "(min)");
                printer.writeLine("inc", Arrays.toString(((DeviceStatMonitorFeature.CpuFreqSnapshot) delta.dlt).cpuFreqs.getList().toArray()));
                printer.writeLine("cur", Arrays.toString(((DeviceStatMonitorFeature.CpuFreqSnapshot) delta.end).cpuFreqs.getList().toArray()));
                return true;
            }
            if (!(record instanceof DeviceStatMonitorFeature.BatteryTmpSnapshot)) {
                return false;
            }
            printer.createSubSection("batt_temp");
            printer.writeLine(delta.during + "(mls)\t" + (delta.during / 60000) + "(min)");
            printer.writeLine("inc", String.valueOf(((DeviceStatMonitorFeature.BatteryTmpSnapshot) delta.dlt).temp.get()));
            printer.writeLine("cur", String.valueOf(((DeviceStatMonitorFeature.BatteryTmpSnapshot) delta.end).temp.get()));
            return true;
        }

        @CallSuper
        @Deprecated
        public void onWritingSections() {
        }

        @Override // com.tencent.matrix.batterycanary.monitor.feature.WakeLockMonitorFeature.WakeLockListener
        public void onWakeLockTimeout(WakeLockMonitorFeature.WakeLockTrace.WakeLockRecord wakeLockRecord, long j) {
        }

        @CallSuper
        public void onWritingSections(final AppStats appStats) {
            DeviceStatMonitorFeature deviceStatMonitorFeature;
            if ((this.mAlarmFeat != null && this.mLastAlarmSnapshot != null) || (this.mWakeLockFeat != null && this.mLastWakeWakeLockSnapshot != null)) {
                createSection("awake", new Consumer<Printer>() { // from class: com.tencent.matrix.batterycanary.monitor.BatteryMonitorCallback.BatteryPrinter.2
                    @Override // com.tencent.matrix.batterycanary.utils.Consumer
                    public void accept(Printer printer) {
                        BatteryPrinter batteryPrinter = BatteryPrinter.this;
                        AlarmMonitorFeature alarmMonitorFeature = batteryPrinter.mAlarmFeat;
                        if (alarmMonitorFeature != null && batteryPrinter.mLastAlarmSnapshot != null) {
                            MonitorFeature.Snapshot.Delta<AlarmMonitorFeature.AlarmSnapshot> deltaDiff = alarmMonitorFeature.currentAlarms().diff(BatteryPrinter.this.mLastAlarmSnapshot);
                            BatteryPrinter.this.onReportAlarm(deltaDiff);
                            BatteryPrinter batteryPrinter2 = BatteryPrinter.this;
                            batteryPrinter2.onWritingSectionContent(deltaDiff, appStats, batteryPrinter2.mPrinter);
                        }
                        BatteryPrinter batteryPrinter3 = BatteryPrinter.this;
                        WakeLockMonitorFeature wakeLockMonitorFeature = batteryPrinter3.mWakeLockFeat;
                        if (wakeLockMonitorFeature == null || batteryPrinter3.mLastWakeWakeLockSnapshot == null) {
                            return;
                        }
                        MonitorFeature.Snapshot.Delta<WakeLockMonitorFeature.WakeLockSnapshot> deltaDiff2 = wakeLockMonitorFeature.currentWakeLocks().diff(BatteryPrinter.this.mLastWakeWakeLockSnapshot);
                        BatteryPrinter.this.onReportWakeLock(deltaDiff2);
                        BatteryPrinter batteryPrinter4 = BatteryPrinter.this;
                        batteryPrinter4.onWritingSectionContent(deltaDiff2, appStats, batteryPrinter4.mPrinter);
                    }
                });
            }
            if ((this.mBlueToothFeat != null && this.mLastBlueToothSnapshot != null) || ((this.mWifiMonitorFeat != null && this.mLastWifiSnapshot != null) || (this.mLocationFeat != null && this.mLastLocationSnapshot != null))) {
                createSection("scanning", new Consumer<Printer>() { // from class: com.tencent.matrix.batterycanary.monitor.BatteryMonitorCallback.BatteryPrinter.3
                    @Override // com.tencent.matrix.batterycanary.utils.Consumer
                    public void accept(Printer printer) {
                        BatteryPrinter batteryPrinter = BatteryPrinter.this;
                        BlueToothMonitorFeature blueToothMonitorFeature = batteryPrinter.mBlueToothFeat;
                        if (blueToothMonitorFeature != null && batteryPrinter.mLastBlueToothSnapshot != null) {
                            MonitorFeature.Snapshot.Delta<BlueToothMonitorFeature.BlueToothSnapshot> deltaDiff = blueToothMonitorFeature.currentSnapshot().diff(BatteryPrinter.this.mLastBlueToothSnapshot);
                            BatteryPrinter.this.onReportBlueTooth(deltaDiff);
                            BatteryPrinter batteryPrinter2 = BatteryPrinter.this;
                            batteryPrinter2.onWritingSectionContent(deltaDiff, appStats, batteryPrinter2.mPrinter);
                        }
                        BatteryPrinter batteryPrinter3 = BatteryPrinter.this;
                        WifiMonitorFeature wifiMonitorFeature = batteryPrinter3.mWifiMonitorFeat;
                        if (wifiMonitorFeature != null && batteryPrinter3.mLastWifiSnapshot != null) {
                            MonitorFeature.Snapshot.Delta<WifiMonitorFeature.WifiSnapshot> deltaDiff2 = wifiMonitorFeature.currentSnapshot().diff(BatteryPrinter.this.mLastWifiSnapshot);
                            BatteryPrinter.this.onReportWifi(deltaDiff2);
                            BatteryPrinter batteryPrinter4 = BatteryPrinter.this;
                            batteryPrinter4.onWritingSectionContent(deltaDiff2, appStats, batteryPrinter4.mPrinter);
                        }
                        BatteryPrinter batteryPrinter5 = BatteryPrinter.this;
                        LocationMonitorFeature locationMonitorFeature = batteryPrinter5.mLocationFeat;
                        if (locationMonitorFeature == null || batteryPrinter5.mLastLocationSnapshot == null) {
                            return;
                        }
                        MonitorFeature.Snapshot.Delta<LocationMonitorFeature.LocationSnapshot> deltaDiff3 = locationMonitorFeature.currentSnapshot().diff(BatteryPrinter.this.mLastLocationSnapshot);
                        BatteryPrinter.this.onReportLocation(deltaDiff3);
                        BatteryPrinter batteryPrinter6 = BatteryPrinter.this;
                        batteryPrinter6.onWritingSectionContent(deltaDiff3, appStats, batteryPrinter6.mPrinter);
                    }
                });
            }
            if (this.mAppStatFeat != null || (((deviceStatMonitorFeature = this.mDevStatFeat) != null && this.mLastCpuFreqSnapshot != null) || (deviceStatMonitorFeature != null && this.mLastBatteryTmpSnapshot != null))) {
                createSection("dev_stats", new Consumer<Printer>() { // from class: com.tencent.matrix.batterycanary.monitor.BatteryMonitorCallback.BatteryPrinter.4
                    @Override // com.tencent.matrix.batterycanary.utils.Consumer
                    public void accept(Printer printer) {
                        BatteryPrinter batteryPrinter = BatteryPrinter.this;
                        DeviceStatMonitorFeature deviceStatMonitorFeature2 = batteryPrinter.mDevStatFeat;
                        if (deviceStatMonitorFeature2 != null && batteryPrinter.mLastCpuFreqSnapshot != null) {
                            MonitorFeature.Snapshot.Delta<DeviceStatMonitorFeature.CpuFreqSnapshot> deltaDiff = deviceStatMonitorFeature2.currentCpuFreq().diff(BatteryPrinter.this.mLastCpuFreqSnapshot);
                            BatteryPrinter.this.onReportCpuFreq(deltaDiff);
                            BatteryPrinter batteryPrinter2 = BatteryPrinter.this;
                            batteryPrinter2.onWritingSectionContent(deltaDiff, appStats, batteryPrinter2.mPrinter);
                        }
                        BatteryPrinter batteryPrinter3 = BatteryPrinter.this;
                        DeviceStatMonitorFeature deviceStatMonitorFeature3 = batteryPrinter3.mDevStatFeat;
                        if (deviceStatMonitorFeature3 == null || batteryPrinter3.mLastBatteryTmpSnapshot == null) {
                            return;
                        }
                        MonitorFeature.Snapshot.Delta<DeviceStatMonitorFeature.BatteryTmpSnapshot> deltaDiff2 = deviceStatMonitorFeature3.currentBatteryTemperature(Matrix.with().getApplication()).diff(BatteryPrinter.this.mLastBatteryTmpSnapshot);
                        BatteryPrinter.this.onReportTemperature(deltaDiff2);
                        BatteryPrinter batteryPrinter4 = BatteryPrinter.this;
                        batteryPrinter4.onWritingSectionContent(deltaDiff2, appStats, batteryPrinter4.mPrinter);
                    }
                });
            }
            onWritingSections();
        }

        @Override // com.tencent.matrix.batterycanary.monitor.feature.LooperTaskMonitorFeature.LooperTaskListener
        public void onLooperTaskOverHeat(@NonNull List<MonitorFeature.Snapshot.Delta<AbsTaskMonitorFeature.TaskJiffiesSnapshot>> list) {
        }

        @Override // com.tencent.matrix.batterycanary.monitor.feature.NotificationMonitorFeature.NotificationListener
        public void onNotify(@NonNull NotificationMonitorFeature.BadNotification badNotification) {
        }

        public void onReportAlarm(@NonNull MonitorFeature.Snapshot.Delta<AlarmMonitorFeature.AlarmSnapshot> delta) {
        }

        public void onReportBlueTooth(@NonNull MonitorFeature.Snapshot.Delta<BlueToothMonitorFeature.BlueToothSnapshot> delta) {
        }

        public void onReportCpuFreq(@NonNull MonitorFeature.Snapshot.Delta<DeviceStatMonitorFeature.CpuFreqSnapshot> delta) {
        }

        @Override // com.tencent.matrix.batterycanary.monitor.BatteryMonitorCore.JiffiesListener
        public void onReportInternalJiffies(MonitorFeature.Snapshot.Delta<AbsTaskMonitorFeature.TaskJiffiesSnapshot> delta) {
        }

        public void onReportJiffies(@NonNull MonitorFeature.Snapshot.Delta<JiffiesMonitorFeature.JiffiesSnapshot> delta) {
        }

        public void onReportLocation(@NonNull MonitorFeature.Snapshot.Delta<LocationMonitorFeature.LocationSnapshot> delta) {
        }

        public void onReportTemperature(@NonNull MonitorFeature.Snapshot.Delta<DeviceStatMonitorFeature.BatteryTmpSnapshot> delta) {
        }

        public void onReportWakeLock(@NonNull MonitorFeature.Snapshot.Delta<WakeLockMonitorFeature.WakeLockSnapshot> delta) {
        }

        public void onReportWifi(@NonNull MonitorFeature.Snapshot.Delta<WifiMonitorFeature.WifiSnapshot> delta) {
        }

        @Override // com.tencent.matrix.batterycanary.monitor.feature.AlarmMonitorFeature.AlarmListener
        public void onAlarmDuplicated(int i, AlarmMonitorFeature.AlarmRecord alarmRecord) {
        }

        @Override // com.tencent.matrix.batterycanary.monitor.feature.JiffiesMonitorFeature.JiffiesListener
        public void onParseError(int i, int i2) {
        }

        @Override // com.tencent.matrix.batterycanary.monitor.feature.LooperTaskMonitorFeature.LooperTaskListener
        public void onLooperConcurrentOverHeat(String str, int i, long j) {
        }

        @Override // com.tencent.matrix.batterycanary.monitor.feature.AppStatMonitorFeature.AppStatListener
        public void onAppSateLeak(boolean z, int i, ComponentName componentName, long j) {
        }

        @Override // com.tencent.matrix.batterycanary.monitor.feature.AppStatMonitorFeature.AppStatListener
        public void onForegroundServiceLeak(boolean z, int i, int i2, ComponentName componentName, long j) {
        }
    }
}
