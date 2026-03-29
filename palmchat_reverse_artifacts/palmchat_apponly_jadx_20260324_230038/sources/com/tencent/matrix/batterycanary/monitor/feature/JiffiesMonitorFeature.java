package com.tencent.matrix.batterycanary.monitor.feature;

import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import com.baidu.platform.comapi.map.MapController;
import com.oplus.tblplayer.monitor.sdk.SysPerformanceCollector;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.batterycanary.monitor.BatteryMonitorCore;
import com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature;
import com.tencent.matrix.batterycanary.utils.BatteryCanaryUtil;
import com.tencent.matrix.batterycanary.utils.ProcStatUtil;
import com.tencent.matrix.util.MatrixLog;
import com.tencent.matrix.util.MatrixUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class JiffiesMonitorFeature extends AbsMonitorFeature {
    private static final String TAG = "Matrix.battery.JiffiesMonitorFeature";
    private final ThreadWatchDog mFgThreadWatchDog = new ThreadWatchDog();
    private final ThreadWatchDog mBgThreadWatchDog = new ThreadWatchDog();

    /* JADX INFO: compiled from: SearchBox */
    public interface JiffiesListener {
        @Deprecated
        void onParseError(int i, int i2);

        void onWatchingThreads(MonitorFeature.Snapshot.Entry.ListEntry<? extends JiffiesSnapshot.ThreadJiffiesEntry> listEntry);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class JiffiesSnapshot extends MonitorFeature.Snapshot<JiffiesSnapshot> {
        public String name;
        public int pid;
        public MonitorFeature.Snapshot.Entry.ListEntry<ThreadJiffiesSnapshot> threadEntries;
        public MonitorFeature.Snapshot.Entry.DigitEntry<Integer> threadNum;
        public MonitorFeature.Snapshot.Entry.DigitEntry<Long> totalJiffies;

        /* JADX INFO: compiled from: SearchBox */
        public static class ThreadJiffiesEntry extends MonitorFeature.Snapshot.Entry.DigitEntry<Long> {
            public boolean isNewAdded;

            @NonNull
            public String name;

            @NonNull
            public String stat;
            public int tid;

            public ThreadJiffiesEntry(Long l) {
                super(l);
            }

            @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot.Entry.DigitEntry
            public Long diff(Long l) {
                return Long.valueOf(((Long) this.value).longValue() - l.longValue());
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        @Deprecated
        public static class ThreadJiffiesSnapshot extends ThreadJiffiesEntry {
            public ThreadJiffiesSnapshot(Long l) {
                super(l);
            }

            @Nullable
            public static ThreadJiffiesSnapshot parseThreadJiffies(ProcessInfo.ThreadInfo threadInfo) {
                try {
                    threadInfo.loadProcStat();
                    ThreadJiffiesSnapshot threadJiffiesSnapshot = new ThreadJiffiesSnapshot(Long.valueOf(threadInfo.jiffies));
                    threadJiffiesSnapshot.name = threadInfo.name;
                    threadJiffiesSnapshot.stat = threadInfo.stat;
                    threadJiffiesSnapshot.tid = threadInfo.tid;
                    threadJiffiesSnapshot.isNewAdded = true;
                    return threadJiffiesSnapshot;
                } catch (IOException e) {
                    MatrixLog.printErrStackTrace(JiffiesMonitorFeature.TAG, e, "parseThreadJiffies fail", new Object[0]);
                    return null;
                }
            }
        }

        public static JiffiesSnapshot currentJiffiesSnapshot(ProcessInfo processInfo, boolean z) {
            JiffiesSnapshot jiffiesSnapshot = new JiffiesSnapshot();
            jiffiesSnapshot.pid = processInfo.pid;
            jiffiesSnapshot.name = processInfo.name;
            int i = 0;
            long jLongValue = 0;
            if (z) {
                try {
                    processInfo.loadProcStat();
                    jLongValue = processInfo.jiffies;
                } catch (IOException e) {
                    MatrixLog.printErrStackTrace(JiffiesMonitorFeature.TAG, e, "parseProcJiffies fail", new Object[0]);
                    jiffiesSnapshot.setValid(false);
                    z = false;
                }
            }
            List listEmptyList = Collections.emptyList();
            if (processInfo.threadInfo.size() > 0) {
                int size = processInfo.threadInfo.size();
                ArrayList arrayList = new ArrayList(processInfo.threadInfo.size());
                Iterator<ProcessInfo.ThreadInfo> it = processInfo.threadInfo.iterator();
                while (it.hasNext()) {
                    ThreadJiffiesSnapshot threadJiffies = ThreadJiffiesSnapshot.parseThreadJiffies(it.next());
                    if (threadJiffies != null) {
                        arrayList.add(threadJiffies);
                        if (!z) {
                            jLongValue += ((Long) threadJiffies.value).longValue();
                        }
                    } else {
                        jiffiesSnapshot.setValid(false);
                    }
                }
                i = size;
                listEmptyList = arrayList;
            }
            jiffiesSnapshot.totalJiffies = MonitorFeature.Snapshot.Entry.DigitEntry.of(Long.valueOf(jLongValue));
            jiffiesSnapshot.threadEntries = MonitorFeature.Snapshot.Entry.ListEntry.of(listEmptyList);
            jiffiesSnapshot.threadNum = MonitorFeature.Snapshot.Entry.DigitEntry.of(Integer.valueOf(i));
            return jiffiesSnapshot;
        }

        private JiffiesSnapshot() {
        }

        @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot
        public MonitorFeature.Snapshot.Delta<JiffiesSnapshot> diff(JiffiesSnapshot jiffiesSnapshot) {
            return new MonitorFeature.Snapshot.Delta<JiffiesSnapshot>(jiffiesSnapshot, this) { // from class: com.tencent.matrix.batterycanary.monitor.feature.JiffiesMonitorFeature.JiffiesSnapshot.1
                @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot.Delta
                public JiffiesSnapshot computeDelta() {
                    boolean z;
                    JiffiesSnapshot jiffiesSnapshot2 = new JiffiesSnapshot();
                    RECORD record = this.end;
                    jiffiesSnapshot2.pid = ((JiffiesSnapshot) record).pid;
                    jiffiesSnapshot2.name = ((JiffiesSnapshot) record).name;
                    jiffiesSnapshot2.totalJiffies = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((JiffiesSnapshot) this.bgn).totalJiffies, ((JiffiesSnapshot) record).totalJiffies);
                    jiffiesSnapshot2.threadNum = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((JiffiesSnapshot) this.bgn).threadNum, ((JiffiesSnapshot) this.end).threadNum);
                    jiffiesSnapshot2.threadEntries = MonitorFeature.Snapshot.Entry.ListEntry.ofEmpty();
                    if (((JiffiesSnapshot) this.end).threadEntries.getList().size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (ITEM item : ((JiffiesSnapshot) this.end).threadEntries.getList()) {
                            long jLongValue = ((Long) item.value).longValue();
                            Iterator it = ((JiffiesSnapshot) this.bgn).threadEntries.getList().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z = true;
                                    break;
                                }
                                ThreadJiffiesSnapshot threadJiffiesSnapshot = (ThreadJiffiesSnapshot) it.next();
                                if (threadJiffiesSnapshot.name.equals(item.name) && threadJiffiesSnapshot.tid == item.tid) {
                                    jLongValue = ((Long) MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(threadJiffiesSnapshot, item).value).longValue();
                                    z = false;
                                    break;
                                }
                            }
                            if (jLongValue > 0) {
                                ThreadJiffiesSnapshot threadJiffiesSnapshot2 = new ThreadJiffiesSnapshot(Long.valueOf(jLongValue));
                                threadJiffiesSnapshot2.tid = item.tid;
                                threadJiffiesSnapshot2.name = item.name;
                                threadJiffiesSnapshot2.stat = item.stat;
                                threadJiffiesSnapshot2.isNewAdded = z;
                                arrayList.add(threadJiffiesSnapshot2);
                            }
                        }
                        if (arrayList.size() > 0) {
                            Collections.sort(arrayList, new Comparator<ThreadJiffiesSnapshot>() { // from class: com.tencent.matrix.batterycanary.monitor.feature.JiffiesMonitorFeature.JiffiesSnapshot.1.1
                                @Override // java.util.Comparator
                                public int compare(ThreadJiffiesSnapshot threadJiffiesSnapshot3, ThreadJiffiesSnapshot threadJiffiesSnapshot4) {
                                    long jLongValue2 = threadJiffiesSnapshot3.get().longValue() - threadJiffiesSnapshot4.get().longValue();
                                    if (jLongValue2 == 0) {
                                        return 0;
                                    }
                                    return jLongValue2 > 0 ? -1 : 1;
                                }
                            });
                            jiffiesSnapshot2.threadEntries = MonitorFeature.Snapshot.Entry.ListEntry.of(arrayList);
                        }
                    }
                    return jiffiesSnapshot2;
                }
            };
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class ProcessInfo {
        public long jiffies;
        String name;
        int pid;
        List<ThreadInfo> threadInfo = Collections.emptyList();
        long time;
        long upTime;

        /* JADX INFO: compiled from: SearchBox */
        public static class ThreadInfo {
            public long jiffies;
            public String name;
            public int pid;
            public String stat;
            public int tid;

            /* JADX INFO: Access modifiers changed from: private */
            public static ThreadInfo of(int i, int i2) {
                ThreadInfo threadInfo = new ThreadInfo();
                threadInfo.pid = i;
                threadInfo.tid = i2;
                return threadInfo;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static List<ThreadInfo> parseThreadsInfo(int i) {
                File file = new File(SysPerformanceCollector.APP_CPU_INFO_ROOT_PATH + i + "/task/");
                try {
                    if (file.isDirectory()) {
                        File[] fileArrListFiles = file.listFiles();
                        if (fileArrListFiles == null) {
                            return Collections.emptyList();
                        }
                        ArrayList arrayList = new ArrayList(fileArrListFiles.length);
                        for (File file2 : fileArrListFiles) {
                            if (file2.isDirectory()) {
                                try {
                                    arrayList.add(of(i, Integer.parseInt(file2.getName())));
                                } catch (Exception e) {
                                    MatrixLog.printErrStackTrace(JiffiesMonitorFeature.TAG, e, "parse thread error: " + file2.getName(), new Object[0]);
                                }
                            }
                        }
                        return arrayList;
                    }
                } catch (Exception e2) {
                    MatrixLog.printErrStackTrace(JiffiesMonitorFeature.TAG, e2, "list thread dir error", new Object[0]);
                }
                return Collections.emptyList();
            }

            public void loadProcStat() throws IOException {
                ProcStatUtil.ProcStat procStatOf = ProcStatUtil.of(this.pid, this.tid);
                if (procStatOf != null && !TextUtils.isEmpty(procStatOf.comm)) {
                    this.name = procStatOf.comm;
                    this.stat = procStatOf.stat;
                    this.jiffies = procStatOf.getJiffies();
                    return;
                }
                throw new IOException("parse fail: " + BatteryCanaryUtil.cat(SysPerformanceCollector.APP_CPU_INFO_ROOT_PATH + this.pid + "/task/" + this.tid + SysPerformanceCollector.APP_CPU_INFO_FILE));
            }

            @NonNull
            public String toString() {
                return "thread:" + this.name + "(" + this.tid + ") " + this.jiffies;
            }
        }

        public static ProcessInfo getProcessInfo() {
            ProcessInfo processInfo = new ProcessInfo();
            processInfo.pid = Process.myPid();
            processInfo.name = Matrix.isInstalled() ? MatrixUtil.getProcessName(Matrix.with().getApplication()) : MapController.DEFAULT_LAYER_TAG;
            processInfo.threadInfo = ThreadInfo.parseThreadsInfo(processInfo.pid);
            processInfo.upTime = SystemClock.uptimeMillis();
            processInfo.time = System.currentTimeMillis();
            return processInfo;
        }

        public void loadProcStat() throws IOException {
            ProcStatUtil.ProcStat procStatOf = ProcStatUtil.of(this.pid);
            if (procStatOf != null) {
                this.name = procStatOf.comm;
                this.jiffies = procStatOf.getJiffies();
                return;
            }
            throw new IOException("parse fail: " + BatteryCanaryUtil.cat(SysPerformanceCollector.APP_CPU_INFO_ROOT_PATH + this.pid + SysPerformanceCollector.APP_CPU_INFO_FILE));
        }

        @NonNull
        public String toString() {
            return "process:" + this.name + "(" + this.pid + ") thread size:" + this.threadInfo.size();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class ThreadWatchDog implements Runnable {
        private long duringMillis;
        private final List<ProcessInfo.ThreadInfo> mWatchingThreads = new ArrayList();

        public ThreadWatchDog() {
        }

        private long reset() {
            this.duringMillis = 0L;
            setNext(300000L);
            return this.duringMillis;
        }

        private long setNext(long j) {
            this.duringMillis += j;
            return j;
        }

        @Override // java.lang.Runnable
        public void run() {
            MatrixLog.i(JiffiesMonitorFeature.TAG, "threadWatchDog start, size = " + this.mWatchingThreads.size() + ", delayMillis = " + this.duringMillis, new Object[0]);
            ArrayList arrayList = new ArrayList();
            synchronized (this.mWatchingThreads) {
                Iterator<ProcessInfo.ThreadInfo> it = this.mWatchingThreads.iterator();
                while (it.hasNext()) {
                    JiffiesSnapshot.ThreadJiffiesSnapshot threadJiffies = JiffiesSnapshot.ThreadJiffiesSnapshot.parseThreadJiffies(it.next());
                    if (threadJiffies != null) {
                        threadJiffies.isNewAdded = false;
                        arrayList.add(threadJiffies);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                JiffiesMonitorFeature.this.mCore.getConfig().callback.onWatchingThreads(MonitorFeature.Snapshot.Entry.ListEntry.of(arrayList));
            }
            long j = this.duringMillis;
            if (j <= 300000) {
                JiffiesMonitorFeature.this.mCore.getHandler().postDelayed(this, setNext(300000L));
            } else {
                if (j <= 600000) {
                    JiffiesMonitorFeature.this.mCore.getHandler().postDelayed(this, setNext(600000L));
                    return;
                }
                synchronized (this.mWatchingThreads) {
                    this.mWatchingThreads.clear();
                }
            }
        }

        public void start() {
            synchronized (this.mWatchingThreads) {
                MatrixLog.i(JiffiesMonitorFeature.TAG, "ThreadWatchDog start watching, count = " + this.mWatchingThreads.size(), new Object[0]);
                if (!this.mWatchingThreads.isEmpty()) {
                    JiffiesMonitorFeature.this.mCore.getHandler().postDelayed(this, reset());
                }
            }
        }

        public void stop() {
            JiffiesMonitorFeature.this.mCore.getHandler().removeCallbacks(this);
        }

        public void watch(int i, int i2) {
            synchronized (this.mWatchingThreads) {
                for (ProcessInfo.ThreadInfo threadInfo : this.mWatchingThreads) {
                    if (threadInfo.pid == i && threadInfo.tid == i2) {
                        return;
                    }
                }
                this.mWatchingThreads.add(ProcessInfo.ThreadInfo.of(i, i2));
            }
        }
    }

    @WorkerThread
    public JiffiesSnapshot currentJiffiesSnapshot() {
        return JiffiesSnapshot.currentJiffiesSnapshot(ProcessInfo.getProcessInfo(), this.mCore.getConfig().isStatPidProc);
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature
    public String getTag() {
        return TAG;
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onForeground(boolean z) {
        super.onForeground(z);
        if (z) {
            this.mFgThreadWatchDog.start();
            this.mBgThreadWatchDog.stop();
        } else {
            this.mBgThreadWatchDog.start();
            this.mFgThreadWatchDog.stop();
        }
    }

    public void watchBackThreadSate(boolean z, int i, int i2) {
        if (z) {
            this.mFgThreadWatchDog.watch(i, i2);
        } else {
            this.mBgThreadWatchDog.watch(i, i2);
        }
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public int weight() {
        return Integer.MAX_VALUE;
    }

    @AnyThread
    public void currentJiffiesSnapshot(@NonNull final BatteryMonitorCore.Callback<JiffiesSnapshot> callback) {
        this.mCore.getHandler().post(new Runnable() { // from class: com.tencent.matrix.batterycanary.monitor.feature.JiffiesMonitorFeature.1
            @Override // java.lang.Runnable
            public void run() {
                callback.onGetJiffies(JiffiesMonitorFeature.this.currentJiffiesSnapshot());
            }
        });
    }
}
