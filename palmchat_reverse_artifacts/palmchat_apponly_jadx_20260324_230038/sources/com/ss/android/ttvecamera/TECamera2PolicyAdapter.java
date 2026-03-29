package com.ss.android.ttvecamera;

import android.annotation.SuppressLint;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import defpackage.c96;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TECamera2PolicyAdapter {
    private static final String TAG = "TECamera2PolicyAdapter";

    public static boolean checkPrivacy(Cert cert, boolean z) {
        boolean z2 = true;
        if (cert == null) {
            TELogUtils.i(TAG, "privacyCert is null.");
            return true;
        }
        try {
            if (z) {
                c96.b(cert);
            } else {
                c96.a(cert);
            }
        } catch (BPEAException e) {
            TELogUtils.e(TAG, "error:" + e.getErrorMsg() + " errorCode:" + e.getErrorCode());
            z2 = false;
        }
        TELogUtils.i(TAG, "check privacy:" + z2 + ", open:" + z);
        return z2;
    }

    @RequiresApi(api = 21)
    public static void closeCamera(Cert cert, @NonNull CameraDevice cameraDevice) {
        TETraceUtils.beginSection("TECamera2PolicyAdapter-closeCamera");
        if (checkPrivacy(cert, false)) {
            cameraDevice.close();
        }
        TETraceUtils.endSection();
    }

    @RequiresApi(api = 21)
    @SuppressLint({"MissingPermission"})
    public static void openCamera(Cert cert, CameraManager cameraManager, @NonNull String str, @NonNull CameraDevice.StateCallback stateCallback, @Nullable Handler handler) throws CameraAccessException {
        TETraceUtils.beginSection("TECamera2PolicyAdapter-openCamera");
        if (checkPrivacy(cert, true)) {
            cameraManager.openCamera(str, stateCallback, handler);
        }
        TETraceUtils.endSection();
    }
}
