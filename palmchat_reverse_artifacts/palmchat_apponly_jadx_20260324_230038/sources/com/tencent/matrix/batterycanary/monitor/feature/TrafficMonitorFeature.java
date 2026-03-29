package com.tencent.matrix.batterycanary.monitor.feature;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature;
import com.tencent.matrix.batterycanary.utils.RadioStatUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class TrafficMonitorFeature extends AbsMonitorFeature {
    private static final String TAG = "Matrix.battery.TrafficMonitorFeature";

    /* JADX INFO: compiled from: SearchBox */
    public static class RadioStatSnapshot extends MonitorFeature.Snapshot<RadioStatSnapshot> {
        public MonitorFeature.Snapshot.Entry.DigitEntry<Long> wifiRxBytes = MonitorFeature.Snapshot.Entry.DigitEntry.of(0L);
        public MonitorFeature.Snapshot.Entry.DigitEntry<Long> wifiTxBytes = MonitorFeature.Snapshot.Entry.DigitEntry.of(0L);
        public MonitorFeature.Snapshot.Entry.DigitEntry<Long> mobileRxBytes = MonitorFeature.Snapshot.Entry.DigitEntry.of(0L);
        public MonitorFeature.Snapshot.Entry.DigitEntry<Long> mobileTxBytes = MonitorFeature.Snapshot.Entry.DigitEntry.of(0L);

        @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot
        public MonitorFeature.Snapshot.Delta<RadioStatSnapshot> diff(RadioStatSnapshot radioStatSnapshot) {
            return new MonitorFeature.Snapshot.Delta<RadioStatSnapshot>(radioStatSnapshot, this) { // from class: com.tencent.matrix.batterycanary.monitor.feature.TrafficMonitorFeature.RadioStatSnapshot.1
                @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature.Snapshot.Delta
                public RadioStatSnapshot computeDelta() {
                    RadioStatSnapshot radioStatSnapshot2 = new RadioStatSnapshot();
                    radioStatSnapshot2.wifiRxBytes = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((RadioStatSnapshot) this.bgn).wifiRxBytes, ((RadioStatSnapshot) this.end).wifiRxBytes);
                    radioStatSnapshot2.wifiTxBytes = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((RadioStatSnapshot) this.bgn).wifiTxBytes, ((RadioStatSnapshot) this.end).wifiTxBytes);
                    radioStatSnapshot2.mobileRxBytes = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((RadioStatSnapshot) this.bgn).mobileRxBytes, ((RadioStatSnapshot) this.end).mobileRxBytes);
                    radioStatSnapshot2.mobileTxBytes = MonitorFeature.Snapshot.Differ.DigitDiffer.globalDiff(((RadioStatSnapshot) this.bgn).mobileTxBytes, ((RadioStatSnapshot) this.end).mobileTxBytes);
                    return radioStatSnapshot2;
                }
            };
        }
    }

    @Nullable
    public RadioStatSnapshot currentRadioSnapshot(Context context) {
        RadioStatUtil.RadioStat currentStat = RadioStatUtil.getCurrentStat(context);
        if (currentStat == null) {
            return null;
        }
        RadioStatSnapshot radioStatSnapshot = new RadioStatSnapshot();
        radioStatSnapshot.wifiRxBytes = MonitorFeature.Snapshot.Entry.DigitEntry.of(Long.valueOf(currentStat.wifiRxBytes));
        radioStatSnapshot.wifiTxBytes = MonitorFeature.Snapshot.Entry.DigitEntry.of(Long.valueOf(currentStat.wifiTxBytes));
        radioStatSnapshot.mobileRxBytes = MonitorFeature.Snapshot.Entry.DigitEntry.of(Long.valueOf(currentStat.mobileRxBytes));
        radioStatSnapshot.mobileTxBytes = MonitorFeature.Snapshot.Entry.DigitEntry.of(Long.valueOf(currentStat.mobileTxBytes));
        return radioStatSnapshot;
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature
    public String getTag() {
        return TAG;
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public int weight() {
        return Integer.MIN_VALUE;
    }
}
