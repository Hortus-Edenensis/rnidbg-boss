package com.ss.android.ttvecamera.hardware;

import android.os.Build;
import com.ss.android.ttvecamera.TELogUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TECameraHardware2 {
    public static final int HW_CHECK_LEVEL_3 = 3;
    public static final int HW_CHECK_LEVEL_FULL = 2;
    public static final int HW_CHECK_LEVEL_LEGACY = 0;
    public static final int HW_CHECK_LEVEL_LIMITED = 1;
    private static final String TAG = "TECameraHardware2";
    public static final int[] CameraHWLevelVE2Android = {2, 0, 1, 3};
    public static final int[] CameraHWLevelAndroid2VE = {1, 2, 0, 3, 4};

    public static boolean isHWPlatform() {
        String lowerCase = Build.BRAND.toLowerCase();
        return lowerCase.equals("huawei") || lowerCase.equals("honor");
    }

    public static boolean isMTKPlatform() {
        if (!Build.HARDWARE.toLowerCase().matches("mt[0-9]*")) {
            return false;
        }
        TELogUtils.d(TAG, "MTK Platform.");
        return true;
    }

    public static boolean isQCOMPlatform() {
        String lowerCase = Build.HARDWARE.toLowerCase();
        if (!lowerCase.equals("qcom") && !lowerCase.matches("msm[0-9]*")) {
            return false;
        }
        TELogUtils.d(TAG, "QCOM Platform.");
        return true;
    }

    public static boolean isSSPlatform() {
        return Build.BRAND.toLowerCase().equals("samsung");
    }
}
