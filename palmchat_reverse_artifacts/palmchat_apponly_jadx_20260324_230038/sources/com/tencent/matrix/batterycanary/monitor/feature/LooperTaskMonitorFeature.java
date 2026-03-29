package com.tencent.matrix.batterycanary.monitor.feature;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.matrix.batterycanary.monitor.feature.AbsTaskMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature;
import com.tencent.matrix.trace.core.LooperMonitor;
import com.tencent.matrix.util.MatrixLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class LooperTaskMonitorFeature extends AbsTaskMonitorFeature {
    private static final String TAG = "Matrix.battery.LooperTaskMonitorFeature";

    @Nullable
    Runnable mDelayWatchingTask;

    @Nullable
    LooperMonitor.LooperDispatchListener mLooperTaskListener;
    final List<String> mWatchingList = new ArrayList();
    final Map<Looper, LooperMonitor> mLooperMonitorTrace = new HashMap();

    /* JADX INFO: compiled from: SearchBox */
    public interface LooperTaskListener {
        void onLooperConcurrentOverHeat(String str, int i, long j);

        void onLooperTaskOverHeat(@NonNull List<MonitorFeature.Snapshot.Delta<AbsTaskMonitorFeature.TaskJiffiesSnapshot>> list);

        @Deprecated
        void onTaskTrace(Thread thread, List<TaskTraceInfo> list);
    }

    /* JADX INFO: compiled from: SearchBox */
    @Deprecated
    public static class TaskTraceInfo {
        private static final int LENGTH = 1000;
        private int count;
        String helpfulStr;
        private long[] times;

        public boolean equals(@Nullable Object obj) {
            String str = this.helpfulStr;
            if (str != null && (obj instanceof String)) {
                return str.equals(obj);
            }
            return false;
        }

        public int hashCode() {
            return this.helpfulStr.hashCode();
        }

        public void increment() {
            if (this.times == null) {
                this.times = new long[1000];
            }
            this.times[this.count % 1000] = System.currentTimeMillis();
            this.count++;
        }

        @NonNull
        public String toString() {
            return this.helpfulStr + ContainerUtils.KEY_VALUE_DELIMITER + this.count;
        }
    }

    private Collection<Thread> getAllThreads() {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        return allStackTraces == null ? Collections.emptyList() : allStackTraces.keySet();
    }

    public LooperTaskListener getListener() {
        return this.mCore;
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsTaskMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature
    public String getTag() {
        return TAG;
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsTaskMonitorFeature
    public void onConcurrentOverHeat(String str, int i, long j) {
        getListener().onLooperConcurrentOverHeat(str, i, j);
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onForeground(boolean z) {
        super.onForeground(z);
        if (!z) {
            this.mDelayWatchingTask = new Runnable() { // from class: com.tencent.matrix.batterycanary.monitor.feature.LooperTaskMonitorFeature.2
                @Override // java.lang.Runnable
                public void run() {
                    LooperTaskMonitorFeature.this.startWatching();
                }
            };
            this.mCore.getHandler().postDelayed(this.mDelayWatchingTask, this.mCore.getConfig().greyTime);
        } else if (this.mDelayWatchingTask != null) {
            this.mCore.getHandler().removeCallbacks(this.mDelayWatchingTask);
        }
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsTaskMonitorFeature
    @WorkerThread
    public void onTaskFinished(String str, int i) {
        AbsTaskMonitorFeature.TaskJiffiesSnapshot taskJiffiesSnapshotRemove = this.mTaskJiffiesTrace.remove(Integer.valueOf(i));
        if (taskJiffiesSnapshotRemove != null) {
            AbsTaskMonitorFeature.TaskJiffiesSnapshot taskJiffiesSnapshotCreateSnapshot = createSnapshot(str, Process.myTid());
            if (taskJiffiesSnapshotCreateSnapshot != null) {
                taskJiffiesSnapshotCreateSnapshot.isFinished = true;
                updateDeltas(taskJiffiesSnapshotRemove, taskJiffiesSnapshotCreateSnapshot);
            }
            onStatTask(Process.myTid(), AbsTaskMonitorFeature.IDLE_TASK, ((Long) (taskJiffiesSnapshotCreateSnapshot == null ? taskJiffiesSnapshotRemove.jiffies : taskJiffiesSnapshotCreateSnapshot.jiffies).get()).longValue());
        }
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsTaskMonitorFeature
    @WorkerThread
    public void onTaskStarted(String str, int i) {
        AbsTaskMonitorFeature.TaskJiffiesSnapshot taskJiffiesSnapshotCreateSnapshot = createSnapshot(str, Process.myTid());
        if (taskJiffiesSnapshotCreateSnapshot != null) {
            this.mTaskJiffiesTrace.put(Integer.valueOf(i), taskJiffiesSnapshotCreateSnapshot);
            onStatTask(Process.myTid(), str, ((Long) taskJiffiesSnapshotCreateSnapshot.jiffies.get()).longValue());
        }
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsTaskMonitorFeature
    public void onTraceOverHeat(List<MonitorFeature.Snapshot.Delta<AbsTaskMonitorFeature.TaskJiffiesSnapshot>> list) {
        getListener().onLooperTaskOverHeat(list);
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsTaskMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onTurnOff() {
        super.onTurnOff();
        stopWatching();
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsTaskMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onTurnOn() {
        super.onTurnOn();
        this.mLooperTaskListener = new LooperMonitor.LooperDispatchListener() { // from class: com.tencent.matrix.batterycanary.monitor.feature.LooperTaskMonitorFeature.1
            private int computeHashcode(String str) {
                if (TextUtils.isEmpty(str)) {
                    return -1;
                }
                int iIndexOf = str.indexOf("@");
                int iLastIndexOf = str.contains(": ") ? str.lastIndexOf(": ") : Integer.MAX_VALUE;
                if (iIndexOf >= iLastIndexOf - 1) {
                    return -1;
                }
                int i = iIndexOf + 1;
                try {
                    return Integer.parseInt(iLastIndexOf == Integer.MAX_VALUE ? str.substring(i) : str.substring(i, iLastIndexOf), 16);
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            private String computeTaskName(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                int iIndexOf = str.indexOf("} ");
                int iLastIndexOf = str.lastIndexOf("@");
                if (iIndexOf >= iLastIndexOf - 1) {
                    return null;
                }
                return str.substring(iIndexOf + 2, iLastIndexOf);
            }

            @Override // com.tencent.matrix.trace.core.LooperMonitor.LooperDispatchListener
            public boolean isValid() {
                return LooperTaskMonitorFeature.this.mCore.isTurnOn();
            }

            @Override // com.tencent.matrix.trace.core.LooperMonitor.LooperDispatchListener
            public void onDispatchEnd(String str) {
                int iComputeHashcode;
                super.onDispatchEnd(str);
                if (LooperTaskMonitorFeature.this.mCore.getConfig().isAggressiveMode) {
                    MatrixLog.i(LooperTaskMonitorFeature.TAG, "[" + Thread.currentThread().getName() + "]" + str, new Object[0]);
                }
                String strComputeTaskName = computeTaskName(str);
                if (TextUtils.isEmpty(strComputeTaskName) || (iComputeHashcode = computeHashcode(str)) <= 0) {
                    return;
                }
                LooperTaskMonitorFeature.this.onTaskFinished(strComputeTaskName, iComputeHashcode);
            }

            @Override // com.tencent.matrix.trace.core.LooperMonitor.LooperDispatchListener
            public void onDispatchStart(String str) {
                int iComputeHashcode;
                super.onDispatchStart(str);
                if (LooperTaskMonitorFeature.this.mCore.getConfig().isAggressiveMode) {
                    MatrixLog.i(LooperTaskMonitorFeature.TAG, "[" + Thread.currentThread().getName() + "]" + str, new Object[0]);
                }
                String strComputeTaskName = computeTaskName(str);
                if (TextUtils.isEmpty(strComputeTaskName) || (iComputeHashcode = computeHashcode(str)) <= 0) {
                    return;
                }
                LooperTaskMonitorFeature.this.onTaskStarted(strComputeTaskName, iComputeHashcode);
            }
        };
    }

    public void startWatching() {
        Looper looper;
        synchronized (this.mWatchingList) {
            if (this.mLooperTaskListener == null) {
                return;
            }
            MatrixLog.i(TAG, "#startWatching", new Object[0]);
            if (this.mCore.getConfig().looperWatchList.contains("all")) {
                for (Thread thread : getAllThreads()) {
                    if (thread instanceof HandlerThread) {
                        Looper looper2 = ((HandlerThread) thread).getLooper();
                        if (looper2 != null && !this.mLooperMonitorTrace.containsKey(looper2)) {
                            watchLooper((HandlerThread) thread);
                        }
                    } else if (Looper.getMainLooper().getThread() == thread && !this.mLooperMonitorTrace.containsKey(Looper.getMainLooper())) {
                        watchLooper("main", Looper.getMainLooper());
                    }
                }
            } else {
                Collection<Thread> collectionEmptyList = Collections.emptyList();
                for (String str : this.mCore.getConfig().looperWatchList) {
                    if (!TextUtils.isEmpty(str)) {
                        if ("main".equalsIgnoreCase(str)) {
                            Looper mainLooper = Looper.getMainLooper();
                            if (!this.mLooperMonitorTrace.containsKey(mainLooper)) {
                                watchLooper("main", mainLooper);
                            }
                        } else if (!this.mWatchingList.contains(str)) {
                            if (collectionEmptyList.isEmpty()) {
                                collectionEmptyList = getAllThreads();
                            }
                            for (Thread thread2 : collectionEmptyList) {
                                if (Looper.getMainLooper().getThread() != thread2 && thread2.getName().contains(str) && (thread2 instanceof HandlerThread) && (looper = ((HandlerThread) thread2).getLooper()) != null && !this.mLooperMonitorTrace.containsKey(looper)) {
                                    watchLooper(thread2.getName(), looper);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void stopWatching() {
        synchronized (this.mWatchingList) {
            this.mLooperTaskListener = null;
            Iterator<LooperMonitor> it = this.mLooperMonitorTrace.values().iterator();
            while (it.hasNext()) {
                it.next().onRelease();
            }
            this.mLooperMonitorTrace.clear();
            this.mWatchingList.clear();
        }
    }

    public void watchLooper(HandlerThread handlerThread) {
        Looper looper = handlerThread.getLooper();
        if (looper != null) {
            watchLooper(handlerThread.getName(), looper);
        }
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public int weight() {
        return 0;
    }

    public void watchLooper(String str, Looper looper) {
        if (TextUtils.isEmpty(str) || looper == null) {
            return;
        }
        synchronized (this.mWatchingList) {
            if (this.mLooperTaskListener != null) {
                this.mWatchingList.remove(str);
                LooperMonitor looperMonitorRemove = this.mLooperMonitorTrace.remove(looper);
                if (looperMonitorRemove != null) {
                    looperMonitorRemove.onRelease();
                }
                LooperMonitor looperMonitorOf = LooperMonitor.of(looper);
                looperMonitorOf.addListener(this.mLooperTaskListener);
                this.mWatchingList.add(str);
                this.mLooperMonitorTrace.put(looper, looperMonitorOf);
            }
        }
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsTaskMonitorFeature
    public void onParseTaskJiffiesFail(String str, int i, int i2) {
    }
}
