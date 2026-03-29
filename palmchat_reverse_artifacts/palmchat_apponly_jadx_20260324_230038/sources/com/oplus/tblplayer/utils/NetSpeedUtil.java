package com.oplus.tblplayer.utils;

import android.net.TrafficStats;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class NetSpeedUtil {
    public static long getTotalRxBytes(int i) {
        if (TrafficStats.getUidRxBytes(i) == -1) {
            return 0L;
        }
        return TrafficStats.getTotalRxBytes();
    }
}
