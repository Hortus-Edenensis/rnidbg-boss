package com.tencent.matrix.batterycanary.monitor.feature;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature;
import com.tencent.matrix.batterycanary.utils.BatteryCanaryUtil;
import com.tencent.matrix.batterycanary.utils.WifiManagerServiceHooker;
import com.tencent.matrix.util.MatrixLog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class WifiMonitorFeature extends AbsMonitorFeature {
    private static final String TAG = "Matrix.battery.WifiMonitorFeature";
    WifiManagerServiceHooker.IListener mListener;
    final WifiTracing mTracing = new WifiTracing();

    /* JADX INFO: compiled from: SearchBox */
    public static class WifiSnapshot extends MonitorFeature.Snapshot<WifiSnapshot> {
        public MonitorFeature.Snapshot.Entry.DigitEntry<Integer> queryCount;
        public MonitorFeature.Snapshot.Entry.DigitEntry<Integer> scanCount;
        public String stack;

        @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot
        public MonitorFeature.Snapshot.Delta<WifiSnapshot> diff(WifiSnapshot wifiSnapshot) {
            return new MonitorFeature.Snapshot.Delta<WifiSnapshot>(wifiSnapshot, this) { // from class: com.tencent.matrix.batterycanary.monitor.feature.WifiMonitorFeature.WifiSnapshot.1
                @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot.Delta
                public WifiSnapshot computeDelta() {
                    WifiSnapshot wifiSnapshot2 = new WifiSnapshot();
                    wifiSnapshot2.scanCount = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((WifiSnapshot) this.bgn).scanCount, ((WifiSnapshot) this.end).scanCount);
                    wifiSnapshot2.queryCount = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((WifiSnapshot) this.bgn).queryCount, ((WifiSnapshot) this.end).queryCount);
                    wifiSnapshot2.stack = ((WifiSnapshot) this.end).stack;
                    return wifiSnapshot2;
                }
            };
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class WifiTracing {
        private String mLastConfiguredStack = "";
        private int mQueryCount;
        private int mScanCount;

        public WifiSnapshot getSnapshot() {
            WifiSnapshot wifiSnapshot = new WifiSnapshot();
            wifiSnapshot.scanCount = MonitorFeature.Snapshot.Entry.DigitEntry.of(Integer.valueOf(this.mScanCount));
            wifiSnapshot.queryCount = MonitorFeature.Snapshot.Entry.DigitEntry.of(Integer.valueOf(this.mQueryCount));
            wifiSnapshot.stack = this.mLastConfiguredStack;
            return wifiSnapshot;
        }

        public void onClear() {
            this.mScanCount = 0;
            this.mQueryCount = 0;
        }

        public void onGetScanResults() {
            this.mQueryCount++;
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

    public WifiSnapshot currentSnapshot() {
        return this.mTracing.getSnapshot();
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature
    public String getTag() {
        return TAG;
    }

    @NonNull
    public WifiTracing getTracing() {
        return this.mTracing;
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onTurnOff() {
        super.onTurnOff();
        WifiManagerServiceHooker.removeListener(this.mListener);
        this.mTracing.onClear();
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onTurnOn() {
        super.onTurnOn();
        if (this.mCore.getConfig().isAmsHookEnabled) {
            WifiManagerServiceHooker.IListener iListener = new WifiManagerServiceHooker.IListener() { // from class: com.tencent.matrix.batterycanary.monitor.feature.WifiMonitorFeature.1
                @Override // com.tencent.matrix.batterycanary.utils.WifiManagerServiceHooker.IListener
                public void onGetScanResults() {
                    String strStackTraceToString = WifiMonitorFeature.this.shouldTracing() ? BatteryCanaryUtil.stackTraceToString(new Throwable().getStackTrace()) : "";
                    MatrixLog.i(WifiMonitorFeature.TAG, "#onGetScanResults, stack = " + strStackTraceToString, new Object[0]);
                    WifiMonitorFeature.this.mTracing.setStack(strStackTraceToString);
                    WifiMonitorFeature.this.mTracing.onGetScanResults();
                }

                @Override // com.tencent.matrix.batterycanary.utils.WifiManagerServiceHooker.IListener
                public void onStartScan() {
                    String strStackTraceToString = WifiMonitorFeature.this.shouldTracing() ? BatteryCanaryUtil.stackTraceToString(new Throwable().getStackTrace()) : "";
                    MatrixLog.i(WifiMonitorFeature.TAG, "#onStartScan, stack = " + strStackTraceToString, new Object[0]);
                    WifiMonitorFeature.this.mTracing.setStack(strStackTraceToString);
                    WifiMonitorFeature.this.mTracing.onStartScan();
                }
            };
            this.mListener = iListener;
            WifiManagerServiceHooker.addListener(iListener);
        }
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public int weight() {
        return Integer.MIN_VALUE;
    }
}
