package com.oplus.tbl.exoplayer2;

import com.oplus.tbl.exoplayer2.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultStreamingSpeedControl {
    private static final float DEFAULT_FAST_SPEED = 1.2f;
    private static final int DEFAULT_FAST_THRESHOLD_US = 300000;
    private static final float DEFAULT_NORMAL_SPEED = 1.0f;
    private static final int DEFAULT_NORMAL_THRESHOLD_US = 200000;
    private static final String TAG = "DefaultStreamingSpeedControl";

    private float calculateSpeed(long j, float f) {
        if (j >= 200000) {
            Log.d(TAG, "calculateSpeed: " + j);
        }
        if (j > 200000 || f == 1.0f) {
            return (j < 300000 || f != 1.0f) ? f : DEFAULT_FAST_SPEED;
        }
        return 1.0f;
    }

    public float getAdjustedPlaybackSpeed(long j, float f) {
        return calculateSpeed(j, f);
    }
}
