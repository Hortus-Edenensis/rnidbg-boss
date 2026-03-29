package com.tencent.matrix.batterycanary.monitor.feature;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.tencent.matrix.batterycanary.monitor.BatteryMonitorCore;
import com.tencent.matrix.batterycanary.monitor.feature.AppStatMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.DeviceStatMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature;
import com.tencent.matrix.batterycanary.utils.BatteryCanaryUtil;
import com.tencent.matrix.batterycanary.utils.ProcStatUtil;
import com.tencent.matrix.batterycanary.utils.TimeBreaker;
import com.tencent.matrix.util.MatrixLog;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbsTaskMonitorFeature extends AbsMonitorFeature {
    public static final String IDLE_TASK = "thread_pool@idle";
    private static final long INITIAL_JIFFIES = 0;
    private static final long JIFFIES_PORTIONING_DELTA = 10;
    private static final String TAG = "Matrix.battery.AbsTaskMonitorFeature";

    @Nullable
    protected AppStatMonitorFeature mAppStatFeat;

    @Nullable
    protected DeviceStatMonitorFeature mDevStatFeat;

    @NonNull
    protected TimeBreaker.Stamp mFirstTaskStamp;

    @NonNull
    protected final List<MonitorFeature.Snapshot.Delta<TaskJiffiesSnapshot>> mDeltaList = new ArrayList();

    @NonNull
    protected final Map<Integer, TaskJiffiesSnapshot> mTaskJiffiesTrace = new ConcurrentHashMap();

    @NonNull
    protected final Map<String, Pair<? extends List<Integer>, Long>> mTaskConcurrentTrace = new ConcurrentHashMap();

    @NonNull
    protected final SparseArray<List<TimeBreaker.Stamp>> mTaskStampList = new SparseArray<>();
    protected int mOverHeatCount = 200;
    protected int mConcurrentLimit = 50;

    @NonNull
    protected Runnable coolingTask = new Runnable() { // from class: com.tencent.matrix.batterycanary.monitor.feature.AbsTaskMonitorFeature.1
        @Override // java.lang.Runnable
        @SuppressLint({"RestrictedApi"})
        public void run() {
            AbsTaskMonitorFeature.this.onCoolingDown();
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public static final class TaskJiffiesSnapshot extends MonitorFeature.Snapshot<TaskJiffiesSnapshot> {
        public int appStat;
        public int devStat;
        public MonitorFeature.Snapshot.Entry.DigitEntry<Long> jiffies;
        public String name;
        public String scene;
        public int tid;
        public long timeMillis = System.currentTimeMillis();
        public boolean isFinished = false;
        public long bgRatio = 100;
        public long chargeRatio = 100;
        public long sceneRatio = 100;

        public String toString() {
            return "TaskJiffiesSnapshot{appStat=" + this.appStat + ", devStat=" + this.devStat + ", tid=" + this.tid + ", name='" + this.name + "', jiffies=" + this.jiffies + '}';
        }

        @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot
        public MonitorFeature.Snapshot.Delta<TaskJiffiesSnapshot> diff(TaskJiffiesSnapshot taskJiffiesSnapshot) {
            return new MonitorFeature.Snapshot.Delta<TaskJiffiesSnapshot>(taskJiffiesSnapshot, this) { // from class: com.tencent.matrix.batterycanary.monitor.feature.AbsTaskMonitorFeature.TaskJiffiesSnapshot.1
                @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot.Delta
                public TaskJiffiesSnapshot computeDelta() {
                    TaskJiffiesSnapshot taskJiffiesSnapshot2 = new TaskJiffiesSnapshot();
                    RECORD record = this.end;
                    taskJiffiesSnapshot2.tid = ((TaskJiffiesSnapshot) record).tid;
                    taskJiffiesSnapshot2.name = ((TaskJiffiesSnapshot) record).name;
                    long j = ((TaskJiffiesSnapshot) record).timeMillis;
                    RECORD record2 = this.bgn;
                    taskJiffiesSnapshot2.timeMillis = j - ((TaskJiffiesSnapshot) record2).timeMillis;
                    taskJiffiesSnapshot2.jiffies = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((TaskJiffiesSnapshot) record2).jiffies, ((TaskJiffiesSnapshot) record).jiffies);
                    RECORD record3 = this.end;
                    taskJiffiesSnapshot2.isFinished = ((TaskJiffiesSnapshot) record3).isFinished;
                    RECORD record4 = this.bgn;
                    if (((TaskJiffiesSnapshot) record4).appStat == 1 || ((TaskJiffiesSnapshot) record3).appStat == 1) {
                        taskJiffiesSnapshot2.appStat = 1;
                    } else if (((TaskJiffiesSnapshot) record4).appStat == 3 && ((TaskJiffiesSnapshot) record3).appStat == 3) {
                        taskJiffiesSnapshot2.appStat = 3;
                    } else {
                        taskJiffiesSnapshot2.appStat = 2;
                    }
                    if (((TaskJiffiesSnapshot) record4).devStat == 1 || ((TaskJiffiesSnapshot) record3).devStat == 1) {
                        taskJiffiesSnapshot2.devStat = 1;
                    } else if (((TaskJiffiesSnapshot) record4).devStat == 3 && ((TaskJiffiesSnapshot) record3).devStat == 3) {
                        taskJiffiesSnapshot2.devStat = 3;
                    } else if (((TaskJiffiesSnapshot) record4).devStat == 4 && ((TaskJiffiesSnapshot) record3).devStat == 4) {
                        taskJiffiesSnapshot2.devStat = 3;
                    } else {
                        taskJiffiesSnapshot2.devStat = 2;
                    }
                    taskJiffiesSnapshot2.scene = ((TaskJiffiesSnapshot) record3).scene;
                    return taskJiffiesSnapshot2;
                }
            };
        }
    }

    public void checkOverHeat() {
        this.mCore.getHandler().removeCallbacks(this.coolingTask);
        this.mCore.getHandler().postDelayed(this.coolingTask, 1000L);
    }

    public void clearFinishedJiffies() {
        synchronized (this.mDeltaList) {
            this.mDeltaList.clear();
        }
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void configure(BatteryMonitorCore batteryMonitorCore) {
        super.configure(batteryMonitorCore);
        this.mAppStatFeat = (AppStatMonitorFeature) batteryMonitorCore.getMonitorFeature(AppStatMonitorFeature.class);
        this.mDevStatFeat = (DeviceStatMonitorFeature) batteryMonitorCore.getMonitorFeature(DeviceStatMonitorFeature.class);
        this.mFirstTaskStamp = new TimeBreaker.Stamp(IDLE_TASK, 0L);
        this.mOverHeatCount = Math.max(batteryMonitorCore.getConfig().overHeatCount, this.mOverHeatCount);
    }

    @Nullable
    public TaskJiffiesSnapshot createSnapshot(String str, int i) {
        TaskJiffiesSnapshot taskJiffiesSnapshot = new TaskJiffiesSnapshot();
        taskJiffiesSnapshot.tid = i;
        taskJiffiesSnapshot.name = str;
        taskJiffiesSnapshot.appStat = BatteryCanaryUtil.getAppStat(this.mCore.getContext(), this.mCore.isForeground());
        taskJiffiesSnapshot.devStat = BatteryCanaryUtil.getDeviceStat(this.mCore.getContext());
        try {
            Callable<String> callable = this.mCore.getConfig().onSceneSupplier;
            taskJiffiesSnapshot.scene = callable == null ? "" : callable.call();
        } catch (Exception unused) {
            taskJiffiesSnapshot.scene = "";
        }
        if (this.mCore.getConfig().isUseThreadClock) {
            taskJiffiesSnapshot.jiffies = MonitorFeature.Snapshot.Entry.DigitEntry.of(Long.valueOf(SystemClock.currentThreadTimeMillis() / JIFFIES_PORTIONING_DELTA));
            return taskJiffiesSnapshot;
        }
        int iMyPid = Process.myPid();
        ProcStatUtil.ProcStat procStatOf = ProcStatUtil.of(iMyPid, i);
        if (procStatOf != null) {
            taskJiffiesSnapshot.jiffies = MonitorFeature.Snapshot.Entry.DigitEntry.of(Long.valueOf(procStatOf.getJiffies()));
            return taskJiffiesSnapshot;
        }
        MatrixLog.w(TAG, "parse task procStat fail, name = " + str + ", tid = " + i, new Object[0]);
        onParseTaskJiffiesFail(str, iMyPid, i);
        return null;
    }

    public List<MonitorFeature.Snapshot.Delta<TaskJiffiesSnapshot>> currentJiffies() {
        ArrayList arrayList;
        synchronized (this.mDeltaList) {
            arrayList = new ArrayList(this.mDeltaList);
        }
        Collections.sort(arrayList, new Comparator<MonitorFeature.Snapshot.Delta<TaskJiffiesSnapshot>>() { // from class: com.tencent.matrix.batterycanary.monitor.feature.AbsTaskMonitorFeature.2
            @Override // java.util.Comparator
            public int compare(MonitorFeature.Snapshot.Delta<TaskJiffiesSnapshot> delta, MonitorFeature.Snapshot.Delta<TaskJiffiesSnapshot> delta2) {
                RECORD record;
                RECORD record2 = delta.dlt;
                if (record2 == 0 || (record = delta2.dlt) == 0) {
                    MatrixLog.w(AbsTaskMonitorFeature.TAG, "delta should not be null: " + delta + " vs " + delta2, new Object[0]);
                    return 0;
                }
                TaskJiffiesSnapshot taskJiffiesSnapshot = (TaskJiffiesSnapshot) record2;
                TaskJiffiesSnapshot taskJiffiesSnapshot2 = (TaskJiffiesSnapshot) record;
                int i = taskJiffiesSnapshot.appStat;
                if (i != 1 || taskJiffiesSnapshot2.appStat != 1) {
                    if (i == 1) {
                        return 1;
                    }
                    if (taskJiffiesSnapshot2.appStat == 1) {
                        return -1;
                    }
                }
                long jLongValue = ((Long) taskJiffiesSnapshot.jiffies.get()).longValue() - ((Long) taskJiffiesSnapshot2.jiffies.get()).longValue();
                if (jLongValue == 0) {
                    return 0;
                }
                return jLongValue > 0 ? -1 : 1;
            }
        });
        return arrayList;
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature
    public String getTag() {
        return TAG;
    }

    @SuppressLint({"RestrictedApi"})
    public TimeBreaker.TimePortions getTaskPortions(int i, long j, final long j2) {
        synchronized (this.mTaskStampList) {
            if (j >= 0) {
                if (this.mTaskStampList.get(i) != null) {
                    return TimeBreaker.configurePortions(this.mTaskStampList.get(i), j, JIFFIES_PORTIONING_DELTA, new TimeBreaker.Stamp.Stamper() { // from class: com.tencent.matrix.batterycanary.monitor.feature.AbsTaskMonitorFeature.3
                        @Override // com.tencent.matrix.batterycanary.utils.TimeBreaker.Stamp.Stamper
                        public TimeBreaker.Stamp stamp(String str) {
                            return new TimeBreaker.Stamp(str, j2);
                        }
                    });
                }
            }
            return TimeBreaker.TimePortions.ofInvalid();
        }
    }

    @Nullable
    public ArrayList<TimeBreaker.Stamp> getTaskStamps(int i) {
        synchronized (this.mTaskStampList) {
            List<TimeBreaker.Stamp> list = this.mTaskStampList.get(i);
            if (list == null) {
                return null;
            }
            return new ArrayList<>(list);
        }
    }

    public void onCoolingDown() {
        synchronized (this.mTaskStampList) {
            for (int i = 0; i < this.mTaskStampList.size(); i++) {
                List<TimeBreaker.Stamp> listValueAt = this.mTaskStampList.valueAt(i);
                if (listValueAt != null && listValueAt.size() > this.mOverHeatCount) {
                    TimeBreaker.gcList(listValueAt);
                }
            }
        }
        if (this.mDeltaList.size() > this.mOverHeatCount) {
            MatrixLog.w(TAG, "cooling task jiffies list, before = " + this.mDeltaList.size(), new Object[0]);
            List<MonitorFeature.Snapshot.Delta<TaskJiffiesSnapshot>> listCurrentJiffies = currentJiffies();
            clearFinishedJiffies();
            MatrixLog.w(TAG, "cooling task jiffies list, after = " + this.mDeltaList.size(), new Object[0]);
            MatrixLog.w(TAG, "report task jiffies list overheat", new Object[0]);
            onTraceOverHeat(listCurrentJiffies);
        }
    }

    public void onStatTask(int i, @NonNull String str, long j) {
        synchronized (this.mTaskStampList) {
            List<TimeBreaker.Stamp> arrayList = this.mTaskStampList.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                arrayList.add(0, this.mFirstTaskStamp);
                this.mTaskStampList.put(i, arrayList);
            }
            arrayList.add(0, new TimeBreaker.Stamp(str, j));
        }
        checkOverHeat();
    }

    public void onTaskConcurrentDec(final int i) {
        this.mCore.getHandler().post(new Runnable() { // from class: com.tencent.matrix.batterycanary.monitor.feature.AbsTaskMonitorFeature.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (AbsTaskMonitorFeature.this.mTaskConcurrentTrace) {
                    Iterator<Map.Entry<String, Pair<? extends List<Integer>, Long>>> it = AbsTaskMonitorFeature.this.mTaskConcurrentTrace.entrySet().iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        Map.Entry<String, Pair<? extends List<Integer>, Long>> next = it.next();
                        Iterator it2 = ((List) next.getValue().first).iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            if (((Integer) it2.next()).intValue() == i) {
                                it2.remove();
                                z = true;
                                break;
                            }
                        }
                        if (((List) next.getValue().first).isEmpty()) {
                            it.remove();
                        }
                        if (z) {
                            break;
                        }
                    }
                }
            }
        });
    }

    public void onTaskConcurrentInc(final String str, final int i) {
        this.mCore.getHandler().post(new Runnable() { // from class: com.tencent.matrix.batterycanary.monitor.feature.AbsTaskMonitorFeature.4
            @Override // java.lang.Runnable
            public void run() {
                Pair<? extends List<Integer>, Long> pair;
                synchronized (AbsTaskMonitorFeature.this.mTaskConcurrentTrace) {
                    pair = AbsTaskMonitorFeature.this.mTaskConcurrentTrace.get(str);
                    if (pair == null) {
                        pair = new Pair<>(new LinkedList(), Long.valueOf(SystemClock.uptimeMillis()));
                    }
                    ((List) pair.first).add(Integer.valueOf(i));
                    AbsTaskMonitorFeature.this.mTaskConcurrentTrace.put(str, pair);
                }
                if (((List) pair.first).size() > AbsTaskMonitorFeature.this.mConcurrentLimit) {
                    MatrixLog.w(AbsTaskMonitorFeature.TAG, "reach task concurrent limit, count = " + ((List) pair.first).size() + ", key = " + str, new Object[0]);
                    long jUptimeMillis = SystemClock.uptimeMillis() - ((Long) pair.second).longValue();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onConcurrentOverHeat, during = ");
                    sb.append(jUptimeMillis);
                    MatrixLog.w(AbsTaskMonitorFeature.TAG, sb.toString(), new Object[0]);
                    AbsTaskMonitorFeature.this.onConcurrentOverHeat(str, ((List) pair.first).size(), jUptimeMillis);
                }
            }
        });
    }

    @WorkerThread
    public void onTaskFinished(String str, int i) {
        TaskJiffiesSnapshot taskJiffiesSnapshotRemove = this.mTaskJiffiesTrace.remove(Integer.valueOf(i));
        if (Looper.myLooper() == Looper.getMainLooper() || taskJiffiesSnapshotRemove == null) {
            return;
        }
        TaskJiffiesSnapshot taskJiffiesSnapshotCreateSnapshot = createSnapshot(str, Process.myTid());
        if (taskJiffiesSnapshotCreateSnapshot != null) {
            taskJiffiesSnapshotCreateSnapshot.isFinished = true;
            updateDeltas(taskJiffiesSnapshotRemove, taskJiffiesSnapshotCreateSnapshot);
        }
        onStatTask(Process.myTid(), IDLE_TASK, ((Long) (taskJiffiesSnapshotCreateSnapshot == null ? taskJiffiesSnapshotRemove.jiffies : taskJiffiesSnapshotCreateSnapshot.jiffies).get()).longValue());
    }

    @AnyThread
    public void onTaskRemoved(int i) {
        this.mTaskJiffiesTrace.remove(Integer.valueOf(i));
    }

    @WorkerThread
    public void onTaskStarted(String str, int i) {
        TaskJiffiesSnapshot taskJiffiesSnapshotCreateSnapshot;
        if (Looper.myLooper() == Looper.getMainLooper() || (taskJiffiesSnapshotCreateSnapshot = createSnapshot(str, Process.myTid())) == null) {
            return;
        }
        this.mTaskJiffiesTrace.put(Integer.valueOf(i), taskJiffiesSnapshotCreateSnapshot);
        onStatTask(Process.myTid(), str, ((Long) taskJiffiesSnapshotCreateSnapshot.jiffies.get()).longValue());
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onTurnOff() {
        super.onTurnOff();
        this.mTaskJiffiesTrace.clear();
        synchronized (this.mTaskConcurrentTrace) {
            this.mTaskConcurrentTrace.clear();
        }
        synchronized (this.mDeltaList) {
            this.mDeltaList.clear();
        }
        synchronized (this.mTaskStampList) {
            this.mTaskStampList.clear();
        }
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onTurnOn() {
        super.onTurnOn();
    }

    public boolean shouldTraceTask(MonitorFeature.Snapshot.Delta<TaskJiffiesSnapshot> delta) {
        return delta.during > 1000 && ((Long) ((TaskJiffiesSnapshot) delta.dlt).jiffies.get()).longValue() / Math.max(1L, delta.during / 60000) > 100;
    }

    public void updateDeltas(TaskJiffiesSnapshot taskJiffiesSnapshot, TaskJiffiesSnapshot taskJiffiesSnapshot2) {
        long j;
        if (taskJiffiesSnapshot2.tid != taskJiffiesSnapshot.tid) {
            MatrixLog.w(TAG, "task tid mismatch: " + taskJiffiesSnapshot + " vs " + taskJiffiesSnapshot2, new Object[0]);
            return;
        }
        if (!taskJiffiesSnapshot2.name.equals(taskJiffiesSnapshot.name)) {
            MatrixLog.w(TAG, "task name mismatch: " + taskJiffiesSnapshot + " vs " + taskJiffiesSnapshot2, new Object[0]);
            return;
        }
        MonitorFeature.Snapshot.Delta<TaskJiffiesSnapshot> deltaDiff = taskJiffiesSnapshot2.diff(taskJiffiesSnapshot);
        if (shouldTraceTask(deltaDiff)) {
            RECORD record = deltaDiff.dlt;
            MatrixLog.i(TAG, "onTaskReport: %s, jiffies = %s, millis = %s", ((TaskJiffiesSnapshot) record).name, ((TaskJiffiesSnapshot) record).jiffies.get(), Long.valueOf(deltaDiff.during));
            AppStatMonitorFeature appStatMonitorFeature = this.mAppStatFeat;
            if (appStatMonitorFeature != null) {
                AppStatMonitorFeature.AppStatSnapshot appStatSnapshotCurrentAppStatSnapshot = appStatMonitorFeature.currentAppStatSnapshot(deltaDiff.during);
                if (!appStatSnapshotCurrentAppStatSnapshot.isValid()) {
                    ((TaskJiffiesSnapshot) deltaDiff.end).setValid(false);
                    ((TaskJiffiesSnapshot) deltaDiff.dlt).setValid(false);
                }
                String str = ((TaskJiffiesSnapshot) deltaDiff.dlt).scene;
                TimeBreaker.TimePortions.Portion p1Var = this.mAppStatFeat.currentSceneSnapshot(deltaDiff.during).top1();
                if (p1Var != null) {
                    str = p1Var.key;
                    j = p1Var.ratio;
                } else {
                    j = 100;
                }
                ((TaskJiffiesSnapshot) deltaDiff.dlt).bgRatio = ((Long) appStatSnapshotCurrentAppStatSnapshot.bgRatio.get()).longValue();
                RECORD record2 = deltaDiff.dlt;
                ((TaskJiffiesSnapshot) record2).scene = str;
                ((TaskJiffiesSnapshot) record2).sceneRatio = j;
            }
            DeviceStatMonitorFeature deviceStatMonitorFeature = this.mDevStatFeat;
            if (deviceStatMonitorFeature != null) {
                DeviceStatMonitorFeature.DevStatSnapshot devStatSnapshotCurrentDevStatSnapshot = deviceStatMonitorFeature.currentDevStatSnapshot(deltaDiff.during);
                if (!devStatSnapshotCurrentDevStatSnapshot.isValid()) {
                    ((TaskJiffiesSnapshot) deltaDiff.end).setValid(false);
                    ((TaskJiffiesSnapshot) deltaDiff.dlt).setValid(false);
                }
                ((TaskJiffiesSnapshot) deltaDiff.dlt).chargeRatio = ((Long) devStatSnapshotCurrentDevStatSnapshot.chargingRatio.get()).longValue();
            }
            updateDeltas(deltaDiff);
            if (this.mDeltaList.size() >= this.mOverHeatCount) {
                MatrixLog.w(TAG, "task list overheat, size = " + this.mDeltaList.size(), new Object[0]);
                checkOverHeat();
            }
        }
    }

    public void onTraceOverHeat(List<MonitorFeature.Snapshot.Delta<TaskJiffiesSnapshot>> list) {
    }

    public void updateDeltas(MonitorFeature.Snapshot.Delta<TaskJiffiesSnapshot> delta) {
        synchronized (this.mDeltaList) {
            Iterator<MonitorFeature.Snapshot.Delta<TaskJiffiesSnapshot>> it = this.mDeltaList.iterator();
            while (it.hasNext()) {
                MonitorFeature.Snapshot.Delta<TaskJiffiesSnapshot> next = it.next();
                if (((TaskJiffiesSnapshot) next.dlt).name.equals(((TaskJiffiesSnapshot) delta.dlt).name)) {
                    RECORD record = next.dlt;
                    if (((TaskJiffiesSnapshot) record).tid == ((TaskJiffiesSnapshot) delta.dlt).tid && !((TaskJiffiesSnapshot) record).isFinished) {
                        it.remove();
                    }
                }
            }
            this.mDeltaList.add(delta);
        }
    }

    public void onConcurrentOverHeat(String str, int i, long j) {
    }

    public void onParseTaskJiffiesFail(String str, int i, int i2) {
    }
}
