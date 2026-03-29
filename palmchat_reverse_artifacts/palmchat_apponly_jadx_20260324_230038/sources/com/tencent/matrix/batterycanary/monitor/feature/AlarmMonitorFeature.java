package com.tencent.matrix.batterycanary.monitor.feature;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.tencent.matrix.batterycanary.monitor.BatteryMonitorCore;
import com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature;
import com.tencent.matrix.batterycanary.utils.AlarmManagerServiceHooker;
import com.tencent.matrix.batterycanary.utils.BatteryCanaryUtil;
import com.tencent.matrix.util.MatrixLog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class AlarmMonitorFeature extends AbsMonitorFeature {
    private static final String TAG = "Matrix.battery.AlarmMonitorFeature";

    @NonNull
    @VisibleForTesting
    Handler handler;
    final AlarmTracing mAlarmTracing = new AlarmTracing();

    @Nullable
    AlarmManagerServiceHooker.IListener mListener;

    /* JADX INFO: compiled from: SearchBox */
    public interface AlarmListener {
        void onAlarmDuplicated(int i, AlarmRecord alarmRecord);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class AlarmRecord {
        public final int flag;
        public final long intervalMillis;
        public final String stack;
        public final long timeBgn = System.currentTimeMillis();
        public final long triggerAtMillis;
        public final int type;
        public final long windowMillis;

        public AlarmRecord(int i, long j, long j2, long j3, int i2, String str) {
            this.type = i;
            this.triggerAtMillis = j;
            this.windowMillis = j2;
            this.intervalMillis = j3;
            this.flag = i2;
            this.stack = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && hashCode() == ((AlarmRecord) obj).hashCode();
        }

        @NonNull
        public String toString() {
            return "AlarmRecord{type=" + this.type + ", triggerAtMillis=" + this.triggerAtMillis + ", windowMillis=" + this.windowMillis + ", intervalMillis=" + this.intervalMillis + ", flag=" + this.flag + ", timeBgn=" + this.timeBgn + ", stack='" + this.stack + "'}";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class AlarmSnapshot extends MonitorFeature.Snapshot<AlarmSnapshot> {
        public MonitorFeature.Snapshot.Entry.DigitEntry<Integer> duplicatedCount;
        public MonitorFeature.Snapshot.Entry.DigitEntry<Integer> duplicatedGroup;
        public MonitorFeature.Snapshot.Entry.ListEntry<MonitorFeature.Snapshot.Entry.BeanEntry<AlarmRecord>> records;
        public MonitorFeature.Snapshot.Entry.DigitEntry<Integer> totalCount;
        public MonitorFeature.Snapshot.Entry.DigitEntry<Integer> tracingCount;

        @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot
        public MonitorFeature.Snapshot.Delta<AlarmSnapshot> diff(AlarmSnapshot alarmSnapshot) {
            return new MonitorFeature.Snapshot.Delta<AlarmSnapshot>(alarmSnapshot, this) { // from class: com.tencent.matrix.batterycanary.monitor.feature.AlarmMonitorFeature.AlarmSnapshot.1
                @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot.Delta
                public AlarmSnapshot computeDelta() {
                    AlarmSnapshot alarmSnapshot2 = new AlarmSnapshot();
                    alarmSnapshot2.totalCount = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((AlarmSnapshot) this.bgn).totalCount, ((AlarmSnapshot) this.end).totalCount);
                    alarmSnapshot2.tracingCount = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((AlarmSnapshot) this.bgn).tracingCount, ((AlarmSnapshot) this.end).tracingCount);
                    alarmSnapshot2.duplicatedGroup = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((AlarmSnapshot) this.bgn).duplicatedGroup, ((AlarmSnapshot) this.end).duplicatedGroup);
                    alarmSnapshot2.duplicatedCount = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((AlarmSnapshot) this.bgn).duplicatedCount, ((AlarmSnapshot) this.end).duplicatedCount);
                    alarmSnapshot2.records = MonitorFeature.Snapshot.Differ.ListDiffer.globalDiff(((AlarmSnapshot) this.bgn).records, ((AlarmSnapshot) this.end).records);
                    return alarmSnapshot2;
                }
            };
        }
    }

    private AlarmListener getListener() {
        return this.mCore;
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void configure(BatteryMonitorCore batteryMonitorCore) {
        super.configure(batteryMonitorCore);
        this.handler = batteryMonitorCore.getHandler();
    }

    public AlarmSnapshot currentAlarms() {
        return this.mAlarmTracing.getSnapshot();
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature
    public String getTag() {
        return TAG;
    }

    @NonNull
    public AlarmTracing getTracing() {
        return this.mAlarmTracing;
    }

    @VisibleForTesting
    public void onAlarmRemove(PendingIntent pendingIntent, AlarmManager.OnAlarmListener onAlarmListener) {
        AlarmManagerServiceHooker.IListener iListener = this.mListener;
        if (iListener != null) {
            iListener.onAlarmRemove(pendingIntent, onAlarmListener);
        }
    }

    @VisibleForTesting
    public void onAlarmSet(int i, long j, long j2, long j3, int i2, PendingIntent pendingIntent, AlarmManager.OnAlarmListener onAlarmListener) {
        AlarmManagerServiceHooker.IListener iListener = this.mListener;
        if (iListener != null) {
            iListener.onAlarmSet(i, j, j2, j3, i2, pendingIntent, onAlarmListener);
        }
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onTurnOff() {
        super.onTurnOff();
        AlarmManagerServiceHooker.removeListener(this.mListener);
        this.handler.removeCallbacksAndMessages(null);
        this.mAlarmTracing.onClear();
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onTurnOn() {
        super.onTurnOn();
        if (this.mCore.getConfig().isAmsHookEnabled) {
            AlarmManagerServiceHooker.IListener iListener = new AlarmManagerServiceHooker.IListener() { // from class: com.tencent.matrix.batterycanary.monitor.feature.AlarmMonitorFeature.1
                @Override // com.tencent.matrix.batterycanary.utils.AlarmManagerServiceHooker.IListener
                public void onAlarmRemove(PendingIntent pendingIntent, AlarmManager.OnAlarmListener onAlarmListener) {
                    if (pendingIntent == null && onAlarmListener == null) {
                        return;
                    }
                    AlarmMonitorFeature.this.mAlarmTracing.onRemove(pendingIntent != null ? pendingIntent.hashCode() : onAlarmListener.hashCode());
                }

                @Override // com.tencent.matrix.batterycanary.utils.AlarmManagerServiceHooker.IListener
                public void onAlarmSet(int i, long j, long j2, long j3, int i2, PendingIntent pendingIntent, AlarmManager.OnAlarmListener onAlarmListener) {
                    AlarmRecord alarmRecord = new AlarmRecord(i, j, j2, j3, i2, AlarmMonitorFeature.this.mCore.getConfig().isStatAsSample ? BatteryCanaryUtil.polishStack(Log.getStackTraceString(new Throwable()), "at android.app.AlarmManager") : "");
                    MatrixLog.i(AlarmMonitorFeature.TAG, "#onAlarmSet, target = " + alarmRecord, new Object[0]);
                    if (pendingIntent == null && onAlarmListener == null) {
                        return;
                    }
                    AlarmMonitorFeature.this.mAlarmTracing.onSet(pendingIntent != null ? pendingIntent.hashCode() : onAlarmListener.hashCode(), alarmRecord);
                }
            };
            this.mListener = iListener;
            AlarmManagerServiceHooker.addListener(iListener);
        }
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public int weight() {
        return Integer.MIN_VALUE;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class AlarmTracing {
        private int mDuplicatedCounts;
        private int mDuplicatedGroups;
        private final byte[] mLock = new byte[0];
        private int mTotalCount;
        private int mTracingCount;

        public AlarmSnapshot getSnapshot() {
            AlarmSnapshot alarmSnapshot = new AlarmSnapshot();
            synchronized (this.mLock) {
                alarmSnapshot.totalCount = MonitorFeature.Snapshot.Entry.DigitEntry.of(Integer.valueOf(this.mTotalCount));
                alarmSnapshot.tracingCount = MonitorFeature.Snapshot.Entry.DigitEntry.of(Integer.valueOf(this.mTracingCount));
                alarmSnapshot.duplicatedGroup = MonitorFeature.Snapshot.Entry.DigitEntry.of(Integer.valueOf(this.mDuplicatedGroups));
                alarmSnapshot.duplicatedCount = MonitorFeature.Snapshot.Entry.DigitEntry.of(Integer.valueOf(this.mDuplicatedCounts));
                alarmSnapshot.records = MonitorFeature.Snapshot.Entry.ListEntry.ofEmpty();
            }
            return alarmSnapshot;
        }

        public void onClear() {
            this.mTotalCount = 0;
            this.mTracingCount = 0;
            this.mDuplicatedGroups = 0;
            this.mDuplicatedCounts = 0;
        }

        public void onRemove(int i) {
            synchronized (this.mLock) {
                this.mTracingCount--;
            }
        }

        public void onSet(int i, AlarmRecord alarmRecord) {
            synchronized (this.mLock) {
                this.mTotalCount++;
                this.mTracingCount++;
            }
        }

        public void onRemove() {
            synchronized (this.mLock) {
                this.mTracingCount--;
            }
        }

        public void onSet() {
            synchronized (this.mLock) {
                this.mTotalCount++;
                this.mTracingCount++;
            }
        }
    }
}
