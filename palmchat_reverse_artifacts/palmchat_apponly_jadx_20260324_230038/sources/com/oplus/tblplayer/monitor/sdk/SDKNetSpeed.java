package com.oplus.tblplayer.monitor.sdk;

import android.os.Process;
import com.oplus.tblplayer.utils.NetSpeedUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SDKNetSpeed {
    private long lastTotalRxBytes = 0;
    private long lastTimeStamp = 0;

    public SDKNetSpeed() {
        resetInternal();
    }

    private void resetInternal() {
        this.lastTimeStamp = System.currentTimeMillis();
        this.lastTotalRxBytes = NetSpeedUtil.getTotalRxBytes(Process.myUid());
    }

    public long getNetSpeed() {
        long totalRxBytes = NetSpeedUtil.getTotalRxBytes(Process.myUid());
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.lastTimeStamp;
        if (j <= 0) {
            return 0L;
        }
        long j2 = ((totalRxBytes - this.lastTotalRxBytes) * 1000) / j;
        this.lastTimeStamp = jCurrentTimeMillis;
        this.lastTotalRxBytes = totalRxBytes;
        return j2;
    }

    public void reset() {
        resetInternal();
    }
}
