package com.ss.bytertc.engine.utils;

import androidx.core.content.ContextCompat;
import com.bytedance.realx.base.CalledByNative;
import com.ss.bytertc.base.utils.RtcContextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class PermissionChecker {
    @CalledByNative
    public static boolean checkAudioPermission() {
        return ContextCompat.checkSelfPermission(RtcContextUtils.getApplicationContext(), "android.permission.RECORD_AUDIO") == 0;
    }

    @CalledByNative
    public static boolean checkCameraPermission() {
        return ContextCompat.checkSelfPermission(RtcContextUtils.getApplicationContext(), "android.permission.CAMERA") == 0;
    }
}
