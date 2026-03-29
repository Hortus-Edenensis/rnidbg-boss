package com.tencent.matrix.batterycanary.monitor.feature;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature;
import com.tencent.matrix.batterycanary.utils.BatteryCanaryUtil;
import com.tencent.matrix.batterycanary.utils.LocationManagerServiceHooker;
import com.tencent.matrix.util.MatrixLog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class LocationMonitorFeature extends AbsMonitorFeature {
    private static final String TAG = "Matrix.battery.LocationMonitorFeature";
    LocationManagerServiceHooker.IListener mListener;
    final LocationTracing mTracing = new LocationTracing();

    /* JADX INFO: compiled from: SearchBox */
    public static class LocationSnapshot extends MonitorFeature.Snapshot<LocationSnapshot> {
        public MonitorFeature.Snapshot.Entry.DigitEntry<Integer> scanCount;
        public String stack;

        @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot
        public MonitorFeature.Snapshot.Delta<LocationSnapshot> diff(LocationSnapshot locationSnapshot) {
            return new MonitorFeature.Snapshot.Delta<LocationSnapshot>(locationSnapshot, this) { // from class: com.tencent.matrix.batterycanary.monitor.feature.LocationMonitorFeature.LocationSnapshot.1
                @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot.Delta
                public LocationSnapshot computeDelta() {
                    LocationSnapshot locationSnapshot2 = new LocationSnapshot();
                    locationSnapshot2.scanCount = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((LocationSnapshot) this.bgn).scanCount, ((LocationSnapshot) this.end).scanCount);
                    locationSnapshot2.stack = ((LocationSnapshot) this.end).stack;
                    return locationSnapshot2;
                }
            };
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class LocationTracing {
        private String mLastConfiguredStack = "";
        private int mScanCount;

        public LocationSnapshot getSnapshot() {
            LocationSnapshot locationSnapshot = new LocationSnapshot();
            locationSnapshot.scanCount = MonitorFeature.Snapshot.Entry.DigitEntry.of(Integer.valueOf(this.mScanCount));
            locationSnapshot.stack = this.mLastConfiguredStack;
            return locationSnapshot;
        }

        public void onClear() {
            this.mScanCount = 0;
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

    public LocationSnapshot currentSnapshot() {
        return this.mTracing.getSnapshot();
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature
    public String getTag() {
        return TAG;
    }

    @NonNull
    public LocationTracing getTracing() {
        return this.mTracing;
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onTurnOff() {
        super.onTurnOff();
        LocationManagerServiceHooker.removeListener(this.mListener);
        this.mTracing.onClear();
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onTurnOn() {
        super.onTurnOn();
        if (this.mCore.getConfig().isAmsHookEnabled) {
            LocationManagerServiceHooker.IListener iListener = new LocationManagerServiceHooker.IListener() { // from class: com.tencent.matrix.batterycanary.monitor.feature.LocationMonitorFeature.1
                @Override // com.tencent.matrix.batterycanary.utils.LocationManagerServiceHooker.IListener
                public void onRequestLocationUpdates(long j, float f) {
                    String strStackTraceToString = LocationMonitorFeature.this.shouldTracing() ? BatteryCanaryUtil.stackTraceToString(new Throwable().getStackTrace()) : "";
                    MatrixLog.i(LocationMonitorFeature.TAG, "#onRequestLocationUpdates, time = " + j + ", distance = " + f + ", stack = " + strStackTraceToString, new Object[0]);
                    LocationMonitorFeature.this.mTracing.setStack(strStackTraceToString);
                    LocationMonitorFeature.this.mTracing.onStartScan();
                }
            };
            this.mListener = iListener;
            LocationManagerServiceHooker.addListener(iListener);
        }
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public int weight() {
        return Integer.MIN_VALUE;
    }
}
