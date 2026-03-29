package com.tencent.matrix.batterycanary.utils;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.tencent.matrix.util.MatrixLog;
import defpackage.ks4;
import defpackage.ss4;
import defpackage.ts4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class RadioStatUtil {
    static final long MIN_QUERY_INTERVAL = 2000;
    private static final String TAG = "Matrix.battery.ProcStatUtil";
    static long sLastQueryMillis;

    /* JADX INFO: compiled from: SearchBox */
    public static final class RadioStat {
        public long mobileRxBytes;
        public long mobileTxBytes;
        public long wifiRxBytes;
        public long wifiTxBytes;
    }

    private static boolean checkIfFrequently() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - sLastQueryMillis < 2000) {
            return true;
        }
        sLastQueryMillis = jCurrentTimeMillis;
        return false;
    }

    @Nullable
    public static RadioStat getCurrentStat(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return null;
        }
        if (checkIfFrequently()) {
            MatrixLog.i(TAG, "over frequently just return", new Object[0]);
            return null;
        }
        try {
            NetworkStatsManager networkStatsManagerA = ks4.a(context.getSystemService("netstats"));
            if (networkStatsManagerA == null) {
                return null;
            }
            RadioStat radioStat = new RadioStat();
            NetworkStats networkStatsQuerySummary = networkStatsManagerA.querySummary(1, null, 0L, System.currentTimeMillis());
            while (networkStatsQuerySummary.hasNextBucket()) {
                try {
                    ts4.a();
                    NetworkStats.Bucket bucketA = ss4.a();
                    if (networkStatsQuerySummary.getNextBucket(bucketA) && bucketA.getUid() == Process.myUid()) {
                        radioStat.wifiRxBytes += bucketA.getRxBytes();
                        radioStat.wifiTxBytes += bucketA.getTxBytes();
                    }
                } finally {
                }
            }
            if (networkStatsQuerySummary != null) {
                networkStatsQuerySummary.close();
            }
            networkStatsQuerySummary = networkStatsManagerA.querySummary(0, null, 0L, System.currentTimeMillis());
            while (networkStatsQuerySummary.hasNextBucket()) {
                try {
                    ts4.a();
                    NetworkStats.Bucket bucketA2 = ss4.a();
                    if (networkStatsQuerySummary.getNextBucket(bucketA2) && bucketA2.getUid() == Process.myUid()) {
                        radioStat.mobileRxBytes += bucketA2.getRxBytes();
                        radioStat.mobileTxBytes += bucketA2.getTxBytes();
                    }
                } finally {
                }
            }
            if (networkStatsQuerySummary != null) {
                networkStatsQuerySummary.close();
            }
            return radioStat;
        } catch (Throwable th) {
            MatrixLog.w(TAG, "querySummary fail: " + th.getMessage(), new Object[0]);
            return null;
        }
    }
}
