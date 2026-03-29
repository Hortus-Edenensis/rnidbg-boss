package com.ss.android.ttvecamera;

import android.content.Context;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TEVBoostInterface {
    public static final int SHORTEST_TIMEOUT = 50;
    private static final String TAG = "TEVBoostInterface";

    /* JADX INFO: compiled from: SearchBox */
    public enum VBoostCapabilityType {
        UNKNOWN,
        CPU_FREQ_MIN,
        CPU_FREQ_MAX,
        CPU_CORE_MIN,
        CPU_CORE_MAX,
        GPU_FREQ_MIN,
        GPU_FREQ_MAX,
        BUS_FREQ_MIN,
        BUS_FREQ_MAX,
        UFS_FREQ_MIN,
        UFS_FREQ_MAX,
        TASK_PRIORITY,
        CPU_AFFINITY,
        IDLE_STATE,
        IO_PRELOAD,
        NETWORK_ENHANCE,
        PRESET_SCENE,
        THUMB_FETCH,
        VIBRATE_ENHANCE
    }

    public static int cancelRequest(VBoostCapabilityType vBoostCapabilityType) {
        return 0;
    }

    public static Set<VBoostCapabilityType> getSupportCapabilities() {
        return null;
    }

    public static boolean isSupportCapability(VBoostCapabilityType vBoostCapabilityType) {
        return false;
    }

    public static int requestCustomBoost(VBoostCapabilityType vBoostCapabilityType, int i, long j) {
        return 0;
    }

    public static void requestCpuBoost() {
    }

    public static void requestCpuBoostLong() {
    }

    public static void requestCpuLimit() {
    }

    public static void requestCpuLimitLong() {
    }

    public static void restoreCpuBoost() {
    }

    public static void restoreCpuLimit() {
    }

    public static void init(Context context) {
    }
}
