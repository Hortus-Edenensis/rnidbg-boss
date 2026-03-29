package com.tencent.matrix.batterycanary.monitor.feature;

import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.os.WorkSource;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.tencent.matrix.batterycanary.monitor.BatteryMonitorCore;
import com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature;
import com.tencent.matrix.batterycanary.utils.BatteryCanaryUtil;
import com.tencent.matrix.batterycanary.utils.PowerManagerServiceHooker;
import com.tencent.matrix.util.MatrixLog;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class WakeLockMonitorFeature extends AbsMonitorFeature {
    private static final String TAG = "Matrix.battery.WakeLockMonitorFeature";

    @Nullable
    PowerManagerServiceHooker.IListener mListener;

    @VisibleForTesting
    long mOverTimeMillis;
    final Map<IBinder, WakeLockTrace> mWorkingWakeLocks = new ConcurrentHashMap(2);
    final WakeLockTracing mWakeLockTracing = new WakeLockTracing();

    /* JADX INFO: compiled from: SearchBox */
    public interface WakeLockListener {
        @Deprecated
        void onWakeLockTimeout(int i, WakeLockTrace.WakeLockRecord wakeLockRecord);

        void onWakeLockTimeout(WakeLockTrace.WakeLockRecord wakeLockRecord, long j);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class WakeLockSnapshot extends MonitorFeature.Snapshot<WakeLockSnapshot> {
        public MonitorFeature.Snapshot.Entry.DigitEntry<Integer> totalAcquireCount;
        public MonitorFeature.Snapshot.Entry.DigitEntry<Integer> totalReleaseCount;
        public MonitorFeature.Snapshot.Entry.DigitEntry<Integer> totalWakeLockCount;
        public MonitorFeature.Snapshot.Entry.ListEntry<MonitorFeature.Snapshot.Entry.BeanEntry<WakeLockTrace.WakeLockRecord>> totalWakeLockRecords;
        public MonitorFeature.Snapshot.Entry.DigitEntry<Long> totalWakeLockTime;

        @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot
        public MonitorFeature.Snapshot.Delta<WakeLockSnapshot> diff(WakeLockSnapshot wakeLockSnapshot) {
            return new MonitorFeature.Snapshot.Delta<WakeLockSnapshot>(wakeLockSnapshot, this) { // from class: com.tencent.matrix.batterycanary.monitor.feature.WakeLockMonitorFeature.WakeLockSnapshot.1
                @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot.Delta
                public WakeLockSnapshot computeDelta() {
                    WakeLockSnapshot wakeLockSnapshot2 = new WakeLockSnapshot();
                    wakeLockSnapshot2.totalWakeLockTime = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((WakeLockSnapshot) this.bgn).totalWakeLockTime, ((WakeLockSnapshot) this.end).totalWakeLockTime);
                    wakeLockSnapshot2.totalWakeLockCount = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((WakeLockSnapshot) this.bgn).totalWakeLockCount, ((WakeLockSnapshot) this.end).totalWakeLockCount);
                    wakeLockSnapshot2.totalWakeLockRecords = MonitorFeature.Snapshot.Differ.ListDiffer.globalDiff(((WakeLockSnapshot) this.bgn).totalWakeLockRecords, ((WakeLockSnapshot) this.end).totalWakeLockRecords);
                    wakeLockSnapshot2.totalAcquireCount = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((WakeLockSnapshot) this.bgn).totalAcquireCount, ((WakeLockSnapshot) this.end).totalAcquireCount);
                    wakeLockSnapshot2.totalReleaseCount = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((WakeLockSnapshot) this.bgn).totalReleaseCount, ((WakeLockSnapshot) this.end).totalReleaseCount);
                    return wakeLockSnapshot2;
                }
            };
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class WakeLockTrace {
        private Runnable loopTask;
        private OverTimeListener mListener;
        final WakeLockRecord record;
        final IBinder token;
        int warningCount;
        int warningCountLimit = 30;

        /* JADX INFO: compiled from: SearchBox */
        public interface OverTimeListener {
            void onWakeLockOvertime(int i, WakeLockRecord wakeLockRecord);
        }

        /* JADX INFO: compiled from: SearchBox */
        public static class WakeLockRecord {
            public final int flags;
            public final String packageName;
            public final String stack;
            public final String tag;
            public long timeEnd = 0;
            public final long timeBgn = SystemClock.uptimeMillis();

            public WakeLockRecord(String str, int i, String str2, String str3) {
                this.flags = i;
                this.tag = str;
                this.packageName = str2;
                this.stack = str3;
            }

            public void finish() {
                this.timeEnd = SystemClock.uptimeMillis();
            }

            public long getLockingTimeMillis() {
                long jUptimeMillis = (isFinished() ? this.timeEnd : SystemClock.uptimeMillis()) - this.timeBgn;
                if (jUptimeMillis > 0) {
                    return jUptimeMillis;
                }
                return 0L;
            }

            public boolean isFinished() {
                return this.timeEnd >= this.timeBgn;
            }

            @NonNull
            public String toString() {
                return "WakeLockRecord{flags=" + this.flags + ", tag='" + this.tag + "', packageName='" + this.packageName + "', stack='" + this.stack + "', timeBgn=" + this.timeBgn + ", timeEnd=" + this.timeEnd + '}';
            }
        }

        public WakeLockTrace(IBinder iBinder, String str, int i, String str2, String str3) {
            this.token = iBinder;
            this.record = new WakeLockRecord(str, i, str2, str3);
        }

        public WakeLockTrace attach(int i) {
            this.warningCountLimit = i;
            return this;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof WakeLockTrace) {
                return this.token.equals(obj);
            }
            return false;
        }

        public void finish(Handler handler) {
            Runnable runnable = this.loopTask;
            if (runnable != null) {
                handler.removeCallbacks(runnable);
                this.loopTask = null;
            }
            this.record.finish();
        }

        public int hashCode() {
            return this.token.hashCode();
        }

        public boolean isExpired() {
            return this.warningCount >= this.warningCountLimit;
        }

        public boolean isFinished() {
            return this.record.isFinished();
        }

        public void setListener(OverTimeListener overTimeListener) {
            this.mListener = overTimeListener;
        }

        public void start(final Handler handler, final long j) {
            if (this.loopTask != null || isFinished()) {
                MatrixLog.w(WakeLockMonitorFeature.TAG, "cant not start tracing of wakelock, target = " + this.record, new Object[0]);
                return;
            }
            this.warningCount = 0;
            Runnable runnable = new Runnable() { // from class: com.tencent.matrix.batterycanary.monitor.feature.WakeLockMonitorFeature.WakeLockTrace.1
                @Override // java.lang.Runnable
                public void run() {
                    WakeLockTrace wakeLockTrace = WakeLockTrace.this;
                    wakeLockTrace.warningCount++;
                    if (wakeLockTrace.mListener != null) {
                        OverTimeListener overTimeListener = WakeLockTrace.this.mListener;
                        WakeLockTrace wakeLockTrace2 = WakeLockTrace.this;
                        overTimeListener.onWakeLockOvertime(wakeLockTrace2.warningCount, wakeLockTrace2.record);
                    }
                    WakeLockTrace wakeLockTrace3 = WakeLockTrace.this;
                    if (wakeLockTrace3.warningCount < wakeLockTrace3.warningCountLimit) {
                        handler.postDelayed(this, j);
                    }
                }
            };
            this.loopTask = runnable;
            handler.postDelayed(runnable, j);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class WakeLockTracing {
        private int mCount;
        private final byte[] mLock = new byte[0];
        private long mMillis;
        private int mTotalCount;
        private int mTracingCount;

        public void add(WakeLockTrace.WakeLockRecord wakeLockRecord) {
            synchronized (this.mLock) {
                this.mCount++;
                this.mMillis += wakeLockRecord.getLockingTimeMillis();
            }
        }

        public WakeLockSnapshot getSnapshot() {
            WakeLockSnapshot wakeLockSnapshot = new WakeLockSnapshot();
            wakeLockSnapshot.totalWakeLockTime = MonitorFeature.Snapshot.Entry.DigitEntry.of(Long.valueOf(getTimeMillis()));
            wakeLockSnapshot.totalWakeLockCount = MonitorFeature.Snapshot.Entry.DigitEntry.of(Integer.valueOf(getTotalCount()));
            wakeLockSnapshot.totalWakeLockRecords = MonitorFeature.Snapshot.Entry.ListEntry.ofEmpty();
            wakeLockSnapshot.totalAcquireCount = MonitorFeature.Snapshot.Entry.DigitEntry.of(Integer.valueOf(this.mTotalCount));
            wakeLockSnapshot.totalReleaseCount = MonitorFeature.Snapshot.Entry.DigitEntry.of(Integer.valueOf(this.mTracingCount));
            return wakeLockSnapshot;
        }

        public long getTimeMillis() {
            return this.mMillis;
        }

        public int getTotalCount() {
            return this.mCount;
        }

        public void onAcquire() {
            synchronized (this.mLock) {
                this.mTotalCount++;
                this.mTracingCount++;
            }
        }

        public void onClear() {
            this.mCount = 0;
            this.mMillis = 0L;
            this.mTotalCount = 0;
            this.mTracingCount = 0;
        }

        public void onRelease() {
            synchronized (this.mLock) {
                this.mTracingCount--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dumpTracingForTag(String str) {
        if (this.mCore.getConfig().tagBlackList.contains(str)) {
            MatrixLog.w(TAG, "dump wakelocks tracing for tag '" + str + "':", new Object[0]);
            for (WakeLockTrace wakeLockTrace : this.mWorkingWakeLocks.values()) {
                if (wakeLockTrace.record.tag.equalsIgnoreCase(str)) {
                    MatrixLog.w(TAG, " - " + wakeLockTrace.record, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WakeLockListener getListener() {
        return this.mCore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldTracing(String str) {
        return shouldTracing() || !this.mCore.getConfig().tagWhiteList.contains(str) || this.mCore.getConfig().tagBlackList.contains(str);
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void configure(BatteryMonitorCore batteryMonitorCore) {
        super.configure(batteryMonitorCore);
        this.mOverTimeMillis = batteryMonitorCore.getConfig().wakelockTimeout;
    }

    public WakeLockSnapshot currentWakeLocks() {
        return this.mWakeLockTracing.getSnapshot();
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature
    public String getTag() {
        return TAG;
    }

    @NonNull
    public WakeLockTracing getTracing() {
        return this.mWakeLockTracing;
    }

    @VisibleForTesting
    public void onAcquireWakeLock(IBinder iBinder, int i, String str, String str2, WorkSource workSource, String str3) {
        PowerManagerServiceHooker.IListener iListener = this.mListener;
        if (iListener != null) {
            iListener.onAcquireWakeLock(iBinder, i, str, str2, workSource, str3);
        }
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onBackgroundCheck(long j) {
        super.onBackgroundCheck(j);
        if (this.mWorkingWakeLocks.isEmpty()) {
            return;
        }
        for (WakeLockTrace wakeLockTrace : this.mWorkingWakeLocks.values()) {
            if (!wakeLockTrace.isFinished() && shouldTracing(wakeLockTrace.record.tag)) {
                getListener().onWakeLockTimeout(wakeLockTrace.record, j);
            }
        }
    }

    @VisibleForTesting
    public void onReleaseWakeLock(IBinder iBinder, int i) {
        PowerManagerServiceHooker.IListener iListener = this.mListener;
        if (iListener != null) {
            iListener.onReleaseWakeLock(iBinder, i);
        }
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onTurnOff() {
        super.onTurnOff();
        PowerManagerServiceHooker.removeListener(this.mListener);
        this.mCore.getHandler().removeCallbacksAndMessages(null);
        this.mWorkingWakeLocks.clear();
        this.mWakeLockTracing.onClear();
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onTurnOn() {
        super.onTurnOn();
        if (this.mCore.getConfig().isAmsHookEnabled) {
            PowerManagerServiceHooker.IListener iListener = new PowerManagerServiceHooker.IListener() { // from class: com.tencent.matrix.batterycanary.monitor.feature.WakeLockMonitorFeature.1
                @Override // com.tencent.matrix.batterycanary.utils.PowerManagerServiceHooker.IListener
                public void onAcquireWakeLock(IBinder iBinder, int i, String str, String str2, @Nullable WorkSource workSource, @Nullable String str3) {
                    String strStackTraceToString = WakeLockMonitorFeature.this.shouldTracing(str) ? BatteryCanaryUtil.stackTraceToString(new Throwable().getStackTrace()) : "";
                    MatrixLog.i(WakeLockMonitorFeature.TAG, "[onAcquireWakeLock] token=%s flags=%s tag=%s historyTag=%s packageName=%s workSource=%s stack=%s", String.valueOf(iBinder), Integer.valueOf(i), str, str3, str2, workSource, strStackTraceToString);
                    WakeLockTrace wakeLockTrace = WakeLockMonitorFeature.this.mWorkingWakeLocks.get(iBinder);
                    if (wakeLockTrace != null) {
                        wakeLockTrace.finish(WakeLockMonitorFeature.this.mCore.getHandler());
                    }
                    final WakeLockTrace wakeLockTrace2 = new WakeLockTrace(iBinder, str, i, str2, strStackTraceToString);
                    wakeLockTrace2.attach(WakeLockMonitorFeature.this.mCore.getConfig().wakelockWarnCount);
                    wakeLockTrace2.setListener(new WakeLockTrace.OverTimeListener() { // from class: com.tencent.matrix.batterycanary.monitor.feature.WakeLockMonitorFeature.1.1
                        @Override // com.tencent.matrix.batterycanary.monitor.feature.WakeLockMonitorFeature.WakeLockTrace.OverTimeListener
                        public void onWakeLockOvertime(int i2, WakeLockTrace.WakeLockRecord wakeLockRecord) {
                            WakeLockMonitorFeature.this.getListener().onWakeLockTimeout(i2, wakeLockRecord);
                            if (wakeLockTrace2.isExpired()) {
                                wakeLockTrace2.finish(WakeLockMonitorFeature.this.mCore.getHandler());
                                Iterator<Map.Entry<IBinder, WakeLockTrace>> it = WakeLockMonitorFeature.this.mWorkingWakeLocks.entrySet().iterator();
                                while (it.hasNext()) {
                                    if (it.next().getValue() == wakeLockTrace2) {
                                        it.remove();
                                        return;
                                    }
                                }
                            }
                        }
                    });
                    wakeLockTrace2.start(WakeLockMonitorFeature.this.mCore.getHandler(), WakeLockMonitorFeature.this.mOverTimeMillis);
                    WakeLockMonitorFeature.this.mWorkingWakeLocks.put(iBinder, wakeLockTrace2);
                    WakeLockMonitorFeature.this.dumpTracingForTag(wakeLockTrace2.record.tag);
                }

                @Override // com.tencent.matrix.batterycanary.utils.PowerManagerServiceHooker.IListener
                public void onReleaseWakeLock(IBinder iBinder, int i) {
                    WakeLockTrace value;
                    MatrixLog.i(WakeLockMonitorFeature.TAG, "[onReleaseWakeLock] token=%s flags=%s", Integer.valueOf(iBinder.hashCode()), Integer.valueOf(i));
                    Iterator<Map.Entry<IBinder, WakeLockTrace>> it = WakeLockMonitorFeature.this.mWorkingWakeLocks.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            value = null;
                            break;
                        }
                        Map.Entry<IBinder, WakeLockTrace> next = it.next();
                        if (next.getKey() == iBinder) {
                            value = next.getValue();
                            it.remove();
                            break;
                        }
                    }
                    if (value == null) {
                        MatrixLog.w(WakeLockMonitorFeature.TAG, "missing tracking, token = " + iBinder, new Object[0]);
                        return;
                    }
                    value.finish(WakeLockMonitorFeature.this.mCore.getHandler());
                    WakeLockMonitorFeature.this.mWakeLockTracing.add(value.record);
                    String str = value.record.tag;
                    MatrixLog.i(WakeLockMonitorFeature.TAG, "[onReleaseWakeLock] tag = " + str + ", stack = " + (WakeLockMonitorFeature.this.shouldTracing(str) ? BatteryCanaryUtil.stackTraceToString(new Throwable().getStackTrace()) : ""), new Object[0]);
                    WakeLockMonitorFeature.this.dumpTracingForTag(str);
                }
            };
            this.mListener = iListener;
            PowerManagerServiceHooker.addListener(iListener);
        }
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public int weight() {
        return Integer.MIN_VALUE;
    }
}
