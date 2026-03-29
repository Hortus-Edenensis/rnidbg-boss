package com.tencent.matrix.batterycanary.monitor.feature;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.matrix.batterycanary.BatteryEventDelegate;
import com.tencent.matrix.batterycanary.monitor.BatteryMonitorCore;
import com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature;
import com.tencent.matrix.batterycanary.utils.BatteryCanaryUtil;
import com.tencent.matrix.batterycanary.utils.Consumer;
import com.tencent.matrix.batterycanary.utils.TimeBreaker;
import com.tencent.matrix.util.MatrixLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class DeviceStatMonitorFeature extends AbsMonitorFeature {
    private static final String TAG = "Matrix.battery.DeviceStatusMonitorFeature";

    @NonNull
    private DevStatListener mDevStatListener;

    @NonNull
    List<TimeBreaker.Stamp> mStampList = Collections.emptyList();

    @NonNull
    Runnable coolingTask = new Runnable() { // from class: com.tencent.matrix.batterycanary.monitor.feature.DeviceStatMonitorFeature.1
        @Override // java.lang.Runnable
        public void run() {
            if (DeviceStatMonitorFeature.this.mStampList.size() >= DeviceStatMonitorFeature.this.mCore.getConfig().overHeatCount) {
                synchronized (DeviceStatMonitorFeature.TAG) {
                    TimeBreaker.gcList(DeviceStatMonitorFeature.this.mStampList);
                }
            }
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public static class BatteryTmpSnapshot extends MonitorFeature.Snapshot<BatteryTmpSnapshot> {
        public MonitorFeature.Snapshot.Entry.DigitEntry<Integer> temp;

        @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot
        public MonitorFeature.Snapshot.Delta<BatteryTmpSnapshot> diff(BatteryTmpSnapshot batteryTmpSnapshot) {
            return new MonitorFeature.Snapshot.Delta<BatteryTmpSnapshot>(batteryTmpSnapshot, this) { // from class: com.tencent.matrix.batterycanary.monitor.feature.DeviceStatMonitorFeature.BatteryTmpSnapshot.1
                @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot.Delta
                public BatteryTmpSnapshot computeDelta() {
                    BatteryTmpSnapshot batteryTmpSnapshot2 = new BatteryTmpSnapshot();
                    batteryTmpSnapshot2.temp = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((BatteryTmpSnapshot) this.bgn).temp, ((BatteryTmpSnapshot) this.end).temp);
                    return batteryTmpSnapshot2;
                }
            };
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class CpuFreqSnapshot extends MonitorFeature.Snapshot<CpuFreqSnapshot> {
        public MonitorFeature.Snapshot.Entry.ListEntry<MonitorFeature.Snapshot.Entry.DigitEntry<Integer>> cpuFreqs;

        @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot
        public MonitorFeature.Snapshot.Delta<CpuFreqSnapshot> diff(CpuFreqSnapshot cpuFreqSnapshot) {
            return new MonitorFeature.Snapshot.Delta<CpuFreqSnapshot>(cpuFreqSnapshot, this) { // from class: com.tencent.matrix.batterycanary.monitor.feature.DeviceStatMonitorFeature.CpuFreqSnapshot.1
                @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot.Delta
                public CpuFreqSnapshot computeDelta() {
                    CpuFreqSnapshot cpuFreqSnapshot2 = new CpuFreqSnapshot();
                    cpuFreqSnapshot2.cpuFreqs = MonitorFeature.Snapshot.Differ.ListDiffer.globalDiff(((CpuFreqSnapshot) this.bgn).cpuFreqs, ((CpuFreqSnapshot) this.end).cpuFreqs);
                    return cpuFreqSnapshot2;
                }
            };
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class DevStatListener {

        @Nullable
        private BatteryEventDelegate.Listener mBatterStatListener;
        Consumer<Integer> mListener = new Consumer<Integer>() { // from class: com.tencent.matrix.batterycanary.monitor.feature.DeviceStatMonitorFeature.DevStatListener.1
            @Override // com.tencent.matrix.batterycanary.utils.Consumer
            public void accept(Integer num) {
            }
        };
        boolean mIsCharging = true;
        boolean mIsListening = false;

        public boolean isListening() {
            return this.mIsListening;
        }

        public void setListener(Consumer<Integer> consumer) {
            this.mListener = consumer;
        }

        public boolean startListen(Context context) {
            if (!this.mIsListening) {
                if (!BatteryEventDelegate.isInit()) {
                    throw new IllegalStateException("BatteryEventDelegate is not yet init!");
                }
                this.mBatterStatListener = new BatteryEventDelegate.Listener() { // from class: com.tencent.matrix.batterycanary.monitor.feature.DeviceStatMonitorFeature.DevStatListener.2
                    @Override // com.tencent.matrix.batterycanary.BatteryEventDelegate.Listener
                    public boolean onAppLowEnergy(BatteryEventDelegate.BatteryState batteryState, long j) {
                        return false;
                    }

                    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                    /* JADX WARN: Removed duplicated region for block: B:4:0x0013  */
                    @Override // com.tencent.matrix.batterycanary.BatteryEventDelegate.Listener
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public boolean onStateChanged(String str) {
                        str.hashCode();
                        switch (str) {
                            case "android.intent.action.SCREEN_OFF":
                                DevStatListener devStatListener = DevStatListener.this;
                                if (!devStatListener.mIsCharging) {
                                    devStatListener.mListener.accept(3);
                                }
                                return false;
                            case "android.intent.action.ACTION_POWER_DISCONNECTED":
                                DevStatListener devStatListener2 = DevStatListener.this;
                                devStatListener2.mIsCharging = false;
                                devStatListener2.mListener.accept(2);
                                return false;
                            case "android.intent.action.SCREEN_ON":
                                DevStatListener devStatListener3 = DevStatListener.this;
                                if (!devStatListener3.mIsCharging) {
                                    devStatListener3.mListener.accept(2);
                                }
                                return false;
                            case "android.intent.action.ACTION_POWER_CONNECTED":
                                DevStatListener devStatListener4 = DevStatListener.this;
                                devStatListener4.mIsCharging = true;
                                devStatListener4.mListener.accept(1);
                                return false;
                            default:
                                return false;
                        }
                    }
                };
                this.mIsCharging = BatteryCanaryUtil.isDeviceCharging(context);
                BatteryEventDelegate.getInstance().addListener(this.mBatterStatListener);
                this.mIsListening = true;
            }
            return true;
        }

        public void stopListen() {
            if (this.mIsListening) {
                try {
                    if (this.mBatterStatListener != null && BatteryEventDelegate.isInit()) {
                        BatteryEventDelegate.getInstance().removeListener(this.mBatterStatListener);
                    }
                } catch (Throwable unused) {
                }
                this.mIsListening = false;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class DevStatSnapshot extends MonitorFeature.Snapshot<DevStatSnapshot> {
        public MonitorFeature.Snapshot.Entry.DigitEntry<Long> uptime = MonitorFeature.Snapshot.Entry.DigitEntry.of(0L);
        public MonitorFeature.Snapshot.Entry.DigitEntry<Long> chargingRatio = MonitorFeature.Snapshot.Entry.DigitEntry.of(0L);
        public MonitorFeature.Snapshot.Entry.DigitEntry<Long> unChargingRatio = MonitorFeature.Snapshot.Entry.DigitEntry.of(0L);
        public MonitorFeature.Snapshot.Entry.DigitEntry<Long> screenOff = MonitorFeature.Snapshot.Entry.DigitEntry.of(0L);
        public MonitorFeature.Snapshot.Entry.DigitEntry<Long> lowEnergyRatio = MonitorFeature.Snapshot.Entry.DigitEntry.of(0L);

        @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot
        public MonitorFeature.Snapshot.Delta<DevStatSnapshot> diff(DevStatSnapshot devStatSnapshot) {
            return new MonitorFeature.Snapshot.Delta<DevStatSnapshot>(devStatSnapshot, this) { // from class: com.tencent.matrix.batterycanary.monitor.feature.DeviceStatMonitorFeature.DevStatSnapshot.1
                @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot.Delta
                public DevStatSnapshot computeDelta() {
                    DevStatSnapshot devStatSnapshot2 = new DevStatSnapshot();
                    devStatSnapshot2.uptime = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((DevStatSnapshot) this.bgn).uptime, ((DevStatSnapshot) this.end).uptime);
                    devStatSnapshot2.chargingRatio = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((DevStatSnapshot) this.bgn).chargingRatio, ((DevStatSnapshot) this.end).chargingRatio);
                    devStatSnapshot2.unChargingRatio = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((DevStatSnapshot) this.bgn).unChargingRatio, ((DevStatSnapshot) this.end).unChargingRatio);
                    devStatSnapshot2.screenOff = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((DevStatSnapshot) this.bgn).screenOff, ((DevStatSnapshot) this.end).screenOff);
                    devStatSnapshot2.lowEnergyRatio = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((DevStatSnapshot) this.bgn).lowEnergyRatio, ((DevStatSnapshot) this.end).lowEnergyRatio);
                    return devStatSnapshot2;
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkOverHeat() {
        this.mCore.getHandler().removeCallbacks(this.coolingTask);
        this.mCore.getHandler().postDelayed(this.coolingTask, 1000L);
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void configure(BatteryMonitorCore batteryMonitorCore) {
        super.configure(batteryMonitorCore);
        this.mDevStatListener = new DevStatListener();
    }

    public BatteryTmpSnapshot currentBatteryTemperature(Context context) {
        BatteryTmpSnapshot batteryTmpSnapshot = new BatteryTmpSnapshot();
        batteryTmpSnapshot.temp = MonitorFeature.Snapshot.Entry.DigitEntry.of(Integer.valueOf(this.mCore.getCurrentBatteryTemperature(context)));
        return batteryTmpSnapshot;
    }

    public CpuFreqSnapshot currentCpuFreq() {
        CpuFreqSnapshot cpuFreqSnapshot = new CpuFreqSnapshot();
        try {
            cpuFreqSnapshot.cpuFreqs = MonitorFeature.Snapshot.Entry.ListEntry.ofDigits(BatteryCanaryUtil.getCpuCurrentFreq());
        } catch (Throwable th) {
            MatrixLog.printErrStackTrace(TAG, th, "#currentCpuFreq error", new Object[0]);
            cpuFreqSnapshot.cpuFreqs = MonitorFeature.Snapshot.Entry.ListEntry.ofDigits(new int[0]);
        }
        return cpuFreqSnapshot;
    }

    public DevStatSnapshot currentDevStatSnapshot() {
        return currentDevStatSnapshot(0L);
    }

    @NonNull
    public List<TimeBreaker.Stamp> getStampList() {
        return this.mStampList.isEmpty() ? Collections.emptyList() : new ArrayList(this.mStampList);
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature
    public String getTag() {
        return TAG;
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onForeground(boolean z) {
        super.onForeground(z);
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onTurnOff() {
        super.onTurnOff();
        this.mDevStatListener.stopListen();
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onTurnOn() {
        super.onTurnOn();
        TimeBreaker.Stamp stamp = new TimeBreaker.Stamp(String.valueOf(BatteryCanaryUtil.getDeviceStat(this.mCore.getContext())));
        synchronized (TAG) {
            ArrayList arrayList = new ArrayList();
            this.mStampList = arrayList;
            arrayList.add(0, stamp);
        }
        this.mDevStatListener.setListener(new Consumer<Integer>() { // from class: com.tencent.matrix.batterycanary.monitor.feature.DeviceStatMonitorFeature.2
            @Override // com.tencent.matrix.batterycanary.utils.Consumer
            @SuppressLint({"VisibleForTests"})
            public void accept(Integer num) {
                BatteryCanaryUtil.getProxy().updateDevStat(num.intValue());
                synchronized (DeviceStatMonitorFeature.TAG) {
                    if (DeviceStatMonitorFeature.this.mStampList != Collections.EMPTY_LIST) {
                        MatrixLog.i(BatteryEventDelegate.TAG, "onStat >> " + BatteryCanaryUtil.convertDevStat(num.intValue()), new Object[0]);
                        DeviceStatMonitorFeature.this.mStampList.add(0, new TimeBreaker.Stamp(String.valueOf(num)));
                        DeviceStatMonitorFeature.this.checkOverHeat();
                    }
                }
            }
        });
        if (this.mDevStatListener.isListening()) {
            return;
        }
        this.mDevStatListener.startListen(this.mCore.getContext());
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public int weight() {
        return Integer.MAX_VALUE;
    }

    public DevStatSnapshot currentDevStatSnapshot(long j) {
        try {
            TimeBreaker.TimePortions timePortionsConfigurePortions = TimeBreaker.configurePortions(this.mStampList, j, 10L, new TimeBreaker.Stamp.Stamper() { // from class: com.tencent.matrix.batterycanary.monitor.feature.DeviceStatMonitorFeature.3
                @Override // com.tencent.matrix.batterycanary.utils.TimeBreaker.Stamp.Stamper
                public TimeBreaker.Stamp stamp(String str) {
                    return new TimeBreaker.Stamp(String.valueOf(BatteryCanaryUtil.getDeviceStat(DeviceStatMonitorFeature.this.mCore.getContext())));
                }
            });
            DevStatSnapshot devStatSnapshot = new DevStatSnapshot();
            devStatSnapshot.setValid(timePortionsConfigurePortions.isValid());
            devStatSnapshot.uptime = MonitorFeature.Snapshot.Entry.DigitEntry.of(Long.valueOf(timePortionsConfigurePortions.totalUptime));
            devStatSnapshot.chargingRatio = MonitorFeature.Snapshot.Entry.DigitEntry.of(Long.valueOf(timePortionsConfigurePortions.getRatio("1")));
            devStatSnapshot.unChargingRatio = MonitorFeature.Snapshot.Entry.DigitEntry.of(Long.valueOf(timePortionsConfigurePortions.getRatio("2")));
            devStatSnapshot.screenOff = MonitorFeature.Snapshot.Entry.DigitEntry.of(Long.valueOf(timePortionsConfigurePortions.getRatio("3")));
            devStatSnapshot.lowEnergyRatio = MonitorFeature.Snapshot.Entry.DigitEntry.of(Long.valueOf(timePortionsConfigurePortions.getRatio("4")));
            return devStatSnapshot;
        } catch (Throwable th) {
            MatrixLog.w(TAG, "configureSnapshot fail: " + th.getMessage(), new Object[0]);
            DevStatSnapshot devStatSnapshot2 = new DevStatSnapshot();
            devStatSnapshot2.setValid(false);
            return devStatSnapshot2;
        }
    }
}
