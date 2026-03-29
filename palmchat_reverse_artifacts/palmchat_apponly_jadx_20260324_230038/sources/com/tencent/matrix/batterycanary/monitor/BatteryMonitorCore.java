package com.tencent.matrix.batterycanary.monitor;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.tencent.matrix.AppActiveMatrixDelegate;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.batterycanary.BatteryEventDelegate;
import com.tencent.matrix.batterycanary.monitor.BatteryMonitorCallback;
import com.tencent.matrix.batterycanary.monitor.feature.AbsTaskMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.AlarmMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.AppStatMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.JiffiesMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.LooperTaskMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.NotificationMonitorFeature;
import com.tencent.matrix.batterycanary.monitor.feature.WakeLockMonitorFeature;
import com.tencent.matrix.batterycanary.utils.BatteryCanaryUtil;
import com.tencent.matrix.batterycanary.utils.ProcStatUtil;
import com.tencent.matrix.util.MatrixHandlerThread;
import com.tencent.matrix.util.MatrixLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class BatteryMonitorCore implements LooperTaskMonitorFeature.LooperTaskListener, WakeLockMonitorFeature.WakeLockListener, AlarmMonitorFeature.AlarmListener, JiffiesMonitorFeature.JiffiesListener, AppStatMonitorFeature.AppStatListener, NotificationMonitorFeature.NotificationListener, Handler.Callback {
    private static final int MSG_ARG_FOREGROUND = 3;
    private static final int MSG_ID_JIFFIES_END = 2;
    private static final int MSG_ID_JIFFIES_START = 1;
    private static final String TAG = "Matrix.battery.BatteryMonitorCore";
    private boolean mBackgroundModeEnabled;
    private final long mBgLooperMillis;

    @Nullable
    private BackgroundLoopCheckTask mBgLooperTask;
    private final BatteryMonitorConfig mConfig;
    private final long mFgLooperMillis;

    @Nullable
    private ForegroundLoopCheckTask mFgLooperTask;
    private boolean mForegroundModeEnabled;

    @NonNull
    private final Handler mHandler;

    @Nullable
    private AbsTaskMonitorFeature.TaskJiffiesSnapshot mLastInternalSnapshot;
    private final long mMonitorDelayMillis;

    @NonNull
    Callable<String> mSupplier;
    private volatile boolean mTurnOn = false;
    private boolean mAppForeground = AppActiveMatrixDelegate.INSTANCE.isAppForeground();
    private int mWorkerTid = -1;

    /* JADX INFO: compiled from: SearchBox */
    public class BackgroundLoopCheckTask implements Runnable {
        int round;

        private BackgroundLoopCheckTask() {
            this.round = 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.round++;
            MatrixLog.i(BatteryMonitorCore.TAG, "#onBackgroundLoopCheck, round = " + this.round, new Object[0]);
            if (!BatteryMonitorCore.this.isForeground()) {
                synchronized (BatteryMonitorCore.class) {
                    Iterator<MonitorFeature> it = BatteryMonitorCore.this.mConfig.features.iterator();
                    while (it.hasNext()) {
                        it.next().onBackgroundCheck(BatteryMonitorCore.this.mBgLooperMillis * ((long) this.round));
                    }
                }
            }
            if (BatteryMonitorCore.this.isForeground()) {
                return;
            }
            BatteryMonitorCore.this.mHandler.postDelayed(this, BatteryMonitorCore.this.mBgLooperMillis);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface Callback<T extends MonitorFeature.Snapshot<T>> {
        void onGetJiffies(T t);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class ForegroundLoopCheckTask implements Runnable {
        int lastWhat;

        private ForegroundLoopCheckTask() {
            this.lastWhat = 1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BatteryMonitorCore.this.mForegroundModeEnabled) {
                Message messageObtain = Message.obtain(BatteryMonitorCore.this.mHandler);
                messageObtain.what = this.lastWhat;
                messageObtain.arg1 = 3;
                BatteryMonitorCore.this.mHandler.sendMessageAtFrontOfQueue(messageObtain);
                this.lastWhat = this.lastWhat == 2 ? 1 : 2;
                BatteryMonitorCore.this.mHandler.postDelayed(this, BatteryMonitorCore.this.mFgLooperMillis);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface JiffiesListener {
        void onReportInternalJiffies(MonitorFeature.Snapshot.Delta<AbsTaskMonitorFeature.TaskJiffiesSnapshot> delta);

        void onTraceBegin();

        void onTraceEnd(boolean z);
    }

    @SuppressLint({"VisibleForTests"})
    public BatteryMonitorCore(BatteryMonitorConfig batteryMonitorConfig) {
        this.mSupplier = new Callable<String>() { // from class: com.tencent.matrix.batterycanary.monitor.BatteryMonitorCore.1
            @Override // java.util.concurrent.Callable
            public String call() {
                return "unknown";
            }
        };
        this.mConfig = batteryMonitorConfig;
        BatteryMonitorCallback batteryMonitorCallback = batteryMonitorConfig.callback;
        if (batteryMonitorCallback instanceof BatteryMonitorCallback.BatteryPrinter) {
            ((BatteryMonitorCallback.BatteryPrinter) batteryMonitorCallback).attach(this);
        }
        Callable<String> callable = batteryMonitorConfig.onSceneSupplier;
        if (callable != null) {
            this.mSupplier = callable;
        }
        this.mHandler = new Handler(MatrixHandlerThread.getDefaultHandlerThread().getLooper(), this);
        enableForegroundLoopCheck(batteryMonitorConfig.isForegroundModeEnabled);
        enableBackgroundLoopCheck(batteryMonitorConfig.isBackgroundModeEnabled);
        this.mMonitorDelayMillis = batteryMonitorConfig.greyTime;
        this.mFgLooperMillis = batteryMonitorConfig.foregroundLoopCheckTime;
        this.mBgLooperMillis = batteryMonitorConfig.backgroundLoopCheckTime;
        Iterator<MonitorFeature> it = batteryMonitorConfig.features.iterator();
        while (it.hasNext()) {
            it.next().configure(this);
        }
    }

    private void notifyTraceBegin() {
        MatrixLog.d(TAG, "#onTraceBegin", new Object[0]);
        getConfig().callback.onTraceBegin();
    }

    private void notifyTraceEnd(boolean z) {
        MatrixLog.d(TAG, "#onTraceEnd", new Object[0]);
        getConfig().callback.onTraceEnd(z);
    }

    @Nullable
    @WorkerThread
    public AbsTaskMonitorFeature.TaskJiffiesSnapshot configureMonitorConsuming() {
        if (Looper.myLooper() == Looper.getMainLooper() || Looper.myLooper() == this.mHandler.getLooper()) {
            throw new IllegalStateException("'#configureMonitorConsuming' should work within worker thread except matrix thread!");
        }
        if (this.mWorkerTid <= 0) {
            return null;
        }
        MatrixLog.i(TAG, "#configureMonitorConsuming, tid = " + this.mWorkerTid, new Object[0]);
        AbsTaskMonitorFeature.TaskJiffiesSnapshot taskJiffiesSnapshotCreateSnapshot = createSnapshot(this.mWorkerTid);
        if (taskJiffiesSnapshotCreateSnapshot == null) {
            return null;
        }
        AbsTaskMonitorFeature.TaskJiffiesSnapshot taskJiffiesSnapshot = this.mLastInternalSnapshot;
        if (taskJiffiesSnapshot != null) {
            getConfig().callback.onReportInternalJiffies(taskJiffiesSnapshotCreateSnapshot.diff(taskJiffiesSnapshot));
        }
        this.mLastInternalSnapshot = taskJiffiesSnapshotCreateSnapshot;
        return taskJiffiesSnapshotCreateSnapshot;
    }

    @Nullable
    public AbsTaskMonitorFeature.TaskJiffiesSnapshot createSnapshot(int i) {
        AbsTaskMonitorFeature.TaskJiffiesSnapshot taskJiffiesSnapshot = new AbsTaskMonitorFeature.TaskJiffiesSnapshot();
        taskJiffiesSnapshot.tid = i;
        taskJiffiesSnapshot.appStat = BatteryCanaryUtil.getAppStat(getContext(), isForeground());
        taskJiffiesSnapshot.devStat = BatteryCanaryUtil.getDeviceStat(getContext());
        try {
            Callable<String> callable = getConfig().onSceneSupplier;
            taskJiffiesSnapshot.scene = callable == null ? "" : callable.call();
        } catch (Exception unused) {
            taskJiffiesSnapshot.scene = "";
        }
        ProcStatUtil.ProcStat procStatOf = ProcStatUtil.of(Process.myPid(), i);
        if (procStatOf == null) {
            return null;
        }
        taskJiffiesSnapshot.jiffies = MonitorFeature.Snapshot.Entry.DigitEntry.of(Long.valueOf(procStatOf.getJiffies()));
        taskJiffiesSnapshot.name = procStatOf.comm;
        return taskJiffiesSnapshot;
    }

    @VisibleForTesting
    public void enableBackgroundLoopCheck(boolean z) {
        this.mBackgroundModeEnabled = z;
    }

    @VisibleForTesting
    public void enableForegroundLoopCheck(boolean z) {
        this.mForegroundModeEnabled = z;
        if (z) {
            this.mFgLooperTask = new ForegroundLoopCheckTask();
        }
    }

    public BatteryMonitorConfig getConfig() {
        return this.mConfig;
    }

    public Context getContext() {
        return Matrix.with().getApplication();
    }

    public int getCurrentBatteryTemperature(Context context) {
        try {
            return BatteryCanaryUtil.getBatteryTemperature(context);
        } catch (Throwable th) {
            MatrixLog.printErrStackTrace(TAG, th, "#currentBatteryTemperature error", new Object[0]);
            return 0;
        }
    }

    @NonNull
    public Handler getHandler() {
        return this.mHandler;
    }

    public <T extends MonitorFeature> T getMonitorFeature(Class<T> cls) {
        Iterator<MonitorFeature> it = this.mConfig.features.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (cls.isAssignableFrom(t.getClass())) {
                return t;
            }
        }
        return null;
    }

    public String getScene() {
        try {
            return this.mSupplier.call();
        } catch (Exception unused) {
            return "unknown";
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            notifyTraceBegin();
            return true;
        }
        if (i != 2) {
            return false;
        }
        notifyTraceEnd(message.arg1 == 3);
        return true;
    }

    public boolean isForeground() {
        return this.mAppForeground;
    }

    public boolean isTurnOn() {
        boolean z;
        synchronized (BatteryMonitorCore.class) {
            z = this.mTurnOn;
        }
        return z;
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AlarmMonitorFeature.AlarmListener
    public void onAlarmDuplicated(int i, AlarmMonitorFeature.AlarmRecord alarmRecord) {
        getConfig().callback.onAlarmDuplicated(i, alarmRecord);
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AppStatMonitorFeature.AppStatListener
    public void onAppSateLeak(boolean z, int i, ComponentName componentName, long j) {
        getConfig().callback.onAppSateLeak(z, i, componentName, j);
    }

    public void onForeground(boolean z) {
        ForegroundLoopCheckTask foregroundLoopCheckTask;
        if (!Matrix.isInstalled()) {
            MatrixLog.e(TAG, "Matrix was not installed yet, just ignore the event", new Object[0]);
            return;
        }
        this.mAppForeground = z;
        if (BatteryEventDelegate.isInit()) {
            BatteryEventDelegate.getInstance().onForeground(z);
        }
        if (!z) {
            this.mHandler.removeCallbacksAndMessages(null);
            Message messageObtain = Message.obtain(this.mHandler);
            messageObtain.what = 1;
            this.mHandler.sendMessageDelayed(messageObtain, this.mMonitorDelayMillis);
            if (this.mBackgroundModeEnabled) {
                BackgroundLoopCheckTask backgroundLoopCheckTask = this.mBgLooperTask;
                if (backgroundLoopCheckTask != null) {
                    this.mHandler.removeCallbacks(backgroundLoopCheckTask);
                    this.mBgLooperTask = null;
                }
                BackgroundLoopCheckTask backgroundLoopCheckTask2 = new BackgroundLoopCheckTask();
                this.mBgLooperTask = backgroundLoopCheckTask2;
                this.mHandler.postDelayed(backgroundLoopCheckTask2, this.mBgLooperMillis);
            }
        } else if (!this.mHandler.hasMessages(1)) {
            BackgroundLoopCheckTask backgroundLoopCheckTask3 = this.mBgLooperTask;
            if (backgroundLoopCheckTask3 != null) {
                this.mHandler.removeCallbacks(backgroundLoopCheckTask3);
                this.mBgLooperTask = null;
            }
            Message messageObtain2 = Message.obtain(this.mHandler);
            messageObtain2.what = 2;
            this.mHandler.sendMessageAtFrontOfQueue(messageObtain2);
            if (this.mForegroundModeEnabled && (foregroundLoopCheckTask = this.mFgLooperTask) != null) {
                this.mHandler.removeCallbacks(foregroundLoopCheckTask);
                ForegroundLoopCheckTask foregroundLoopCheckTask2 = this.mFgLooperTask;
                foregroundLoopCheckTask2.lastWhat = 1;
                this.mHandler.post(foregroundLoopCheckTask2);
            }
        }
        Iterator<MonitorFeature> it = this.mConfig.features.iterator();
        while (it.hasNext()) {
            it.next().onForeground(z);
        }
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AppStatMonitorFeature.AppStatListener
    public void onForegroundServiceLeak(boolean z, int i, int i2, ComponentName componentName, long j) {
        getConfig().callback.onForegroundServiceLeak(z, i, i2, componentName, j);
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.LooperTaskMonitorFeature.LooperTaskListener
    public void onLooperConcurrentOverHeat(String str, int i, long j) {
        getConfig().callback.onLooperConcurrentOverHeat(str, i, j);
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.LooperTaskMonitorFeature.LooperTaskListener
    public void onLooperTaskOverHeat(@NonNull List<MonitorFeature.Snapshot.Delta<AbsTaskMonitorFeature.TaskJiffiesSnapshot>> list) {
        getConfig().callback.onLooperTaskOverHeat(list);
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.NotificationMonitorFeature.NotificationListener
    public void onNotify(NotificationMonitorFeature.BadNotification badNotification) {
        getConfig().callback.onNotify(badNotification);
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.JiffiesMonitorFeature.JiffiesListener
    public void onParseError(int i, int i2) {
        getConfig().callback.onParseError(i, i2);
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.LooperTaskMonitorFeature.LooperTaskListener
    public void onTaskTrace(Thread thread, List<LooperTaskMonitorFeature.TaskTraceInfo> list) {
        MatrixLog.d(TAG, "#onTaskTrace, thread = " + thread.getName(), new Object[0]);
        getConfig().callback.onTaskTrace(thread, list);
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.WakeLockMonitorFeature.WakeLockListener
    public void onWakeLockTimeout(int i, WakeLockMonitorFeature.WakeLockTrace.WakeLockRecord wakeLockRecord) {
        getConfig().callback.onWakeLockTimeout(i, wakeLockRecord);
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.JiffiesMonitorFeature.JiffiesListener
    public void onWatchingThreads(MonitorFeature.Snapshot.Entry.ListEntry<? extends JiffiesMonitorFeature.JiffiesSnapshot.ThreadJiffiesEntry> listEntry) {
        getConfig().callback.onWatchingThreads(listEntry);
    }

    public void start() {
        synchronized (BatteryMonitorCore.class) {
            if (!this.mTurnOn) {
                Iterator<MonitorFeature> it = this.mConfig.features.iterator();
                while (it.hasNext()) {
                    it.next().onTurnOn();
                }
                this.mTurnOn = true;
            }
            this.mHandler.post(new Runnable() { // from class: com.tencent.matrix.batterycanary.monitor.BatteryMonitorCore.2
                @Override // java.lang.Runnable
                public void run() {
                    BatteryMonitorCore.this.mWorkerTid = Process.myTid();
                }
            });
            if (BatteryEventDelegate.isInit()) {
                BatteryEventDelegate.getInstance().attach(this).startListening();
            }
        }
    }

    public void stop() {
        synchronized (BatteryMonitorCore.class) {
            if (this.mTurnOn) {
                this.mHandler.removeCallbacksAndMessages(null);
                Iterator<MonitorFeature> it = this.mConfig.features.iterator();
                while (it.hasNext()) {
                    it.next().onTurnOff();
                }
                this.mTurnOn = false;
            }
        }
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.WakeLockMonitorFeature.WakeLockListener
    public void onWakeLockTimeout(WakeLockMonitorFeature.WakeLockTrace.WakeLockRecord wakeLockRecord, long j) {
        getConfig().callback.onWakeLockTimeout(wakeLockRecord, j);
    }
}
