package com.tencent.matrix.batterycanary.monitor.feature;

import android.bluetooth.le.ScanSettings;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature;
import com.tencent.matrix.batterycanary.utils.BatteryCanaryUtil;
import com.tencent.matrix.batterycanary.utils.BluetoothManagerServiceHooker;
import com.tencent.matrix.util.MatrixLog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class BlueToothMonitorFeature extends AbsMonitorFeature {
    private static final String TAG = "Matrix.battery.BlueToothMonitorFeature";
    BluetoothManagerServiceHooker.IListener mListener;
    final BlueToothTracing mTracing = new BlueToothTracing();

    /* JADX INFO: compiled from: SearchBox */
    public static class BlueToothSnapshot extends MonitorFeature.Snapshot<BlueToothSnapshot> {
        public MonitorFeature.Snapshot.Entry.DigitEntry<Integer> discCount;
        public MonitorFeature.Snapshot.Entry.DigitEntry<Integer> regsCount;
        public MonitorFeature.Snapshot.Entry.DigitEntry<Integer> scanCount;
        public String stack;

        @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot
        public MonitorFeature.Snapshot.Delta<BlueToothSnapshot> diff(BlueToothSnapshot blueToothSnapshot) {
            return new MonitorFeature.Snapshot.Delta<BlueToothSnapshot>(blueToothSnapshot, this) { // from class: com.tencent.matrix.batterycanary.monitor.feature.BlueToothMonitorFeature.BlueToothSnapshot.1
                @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot.Delta
                public BlueToothSnapshot computeDelta() {
                    BlueToothSnapshot blueToothSnapshot2 = new BlueToothSnapshot();
                    blueToothSnapshot2.regsCount = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((BlueToothSnapshot) this.bgn).regsCount, ((BlueToothSnapshot) this.end).regsCount);
                    blueToothSnapshot2.discCount = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((BlueToothSnapshot) this.bgn).discCount, ((BlueToothSnapshot) this.end).discCount);
                    blueToothSnapshot2.scanCount = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((BlueToothSnapshot) this.bgn).scanCount, ((BlueToothSnapshot) this.end).scanCount);
                    blueToothSnapshot2.stack = ((BlueToothSnapshot) this.end).stack;
                    return blueToothSnapshot2;
                }
            };
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class BlueToothTracing {
        private int mDiscCount;
        private String mLastConfiguredStack = "";
        private int mRegsCount;
        private int mScanCount;

        public BlueToothSnapshot getSnapshot() {
            BlueToothSnapshot blueToothSnapshot = new BlueToothSnapshot();
            blueToothSnapshot.regsCount = MonitorFeature.Snapshot.Entry.DigitEntry.of(Integer.valueOf(this.mRegsCount));
            blueToothSnapshot.discCount = MonitorFeature.Snapshot.Entry.DigitEntry.of(Integer.valueOf(this.mDiscCount));
            blueToothSnapshot.scanCount = MonitorFeature.Snapshot.Entry.DigitEntry.of(Integer.valueOf(this.mScanCount));
            blueToothSnapshot.stack = this.mLastConfiguredStack;
            return blueToothSnapshot;
        }

        public void onClear() {
            this.mRegsCount = 0;
            this.mDiscCount = 0;
            this.mScanCount = 0;
        }

        public void onRegisterScanner() {
            this.mRegsCount++;
        }

        public void onStartDiscovery() {
            this.mDiscCount++;
        }

        public void onStartScan() {
            this.mScanCount++;
        }

        public void setStack(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mLastConfiguredStack = str;
        }
    }

    public BlueToothSnapshot currentSnapshot() {
        return this.mTracing.getSnapshot();
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature
    public String getTag() {
        return TAG;
    }

    @NonNull
    public BlueToothTracing getTracing() {
        return this.mTracing;
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onTurnOff() {
        super.onTurnOff();
        BluetoothManagerServiceHooker.removeListener(this.mListener);
        this.mTracing.onClear();
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onTurnOn() {
        super.onTurnOn();
        if (Build.VERSION.SDK_INT < 26) {
            MatrixLog.w(TAG, "only support >= android 8.0 for the moment", new Object[0]);
        } else if (this.mCore.getConfig().isAmsHookEnabled || (this.mCore.getConfig().amsHookEnableFlag & 1) == 1) {
            BluetoothManagerServiceHooker.IListener iListener = new BluetoothManagerServiceHooker.IListener() { // from class: com.tencent.matrix.batterycanary.monitor.feature.BlueToothMonitorFeature.1
                @Override // com.tencent.matrix.batterycanary.utils.BluetoothManagerServiceHooker.IListener
                public void onRegisterScanner() {
                    String strStackTraceToString = BlueToothMonitorFeature.this.shouldTracing() ? BatteryCanaryUtil.stackTraceToString(new Throwable().getStackTrace()) : "";
                    MatrixLog.i(BlueToothMonitorFeature.TAG, "#onRegisterScanner, stack = " + strStackTraceToString, new Object[0]);
                    BlueToothMonitorFeature.this.mTracing.setStack(strStackTraceToString);
                    BlueToothMonitorFeature.this.mTracing.onRegisterScanner();
                }

                @Override // com.tencent.matrix.batterycanary.utils.BluetoothManagerServiceHooker.IListener
                public void onStartDiscovery() {
                    String strStackTraceToString = BlueToothMonitorFeature.this.shouldTracing() ? BatteryCanaryUtil.stackTraceToString(new Throwable().getStackTrace()) : "";
                    MatrixLog.i(BlueToothMonitorFeature.TAG, "#onStartDiscovery, stack = " + strStackTraceToString, new Object[0]);
                    BlueToothMonitorFeature.this.mTracing.setStack(strStackTraceToString);
                    BlueToothMonitorFeature.this.mTracing.onStartDiscovery();
                }

                @Override // com.tencent.matrix.batterycanary.utils.BluetoothManagerServiceHooker.IListener
                public void onStartScan(int i, @Nullable ScanSettings scanSettings) {
                    MatrixLog.i(BlueToothMonitorFeature.TAG, "#onStartScan, id = " + i, new Object[0]);
                    BlueToothMonitorFeature.this.mTracing.onStartScan();
                }

                @Override // com.tencent.matrix.batterycanary.utils.BluetoothManagerServiceHooker.IListener
                public void onStartScanForIntent(@Nullable ScanSettings scanSettings) {
                    MatrixLog.i(BlueToothMonitorFeature.TAG, "#onStartScanForIntent", new Object[0]);
                    BlueToothMonitorFeature.this.mTracing.onStartScan();
                }
            };
            this.mListener = iListener;
            BluetoothManagerServiceHooker.addListener(iListener);
        }
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public int weight() {
        return Integer.MIN_VALUE;
    }
}
