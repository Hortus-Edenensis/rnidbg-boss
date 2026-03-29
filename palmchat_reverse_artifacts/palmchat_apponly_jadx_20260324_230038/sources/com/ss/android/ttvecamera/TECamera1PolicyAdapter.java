package com.ss.android.ttvecamera;

import android.hardware.Camera;
import androidx.annotation.NonNull;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import defpackage.c96;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TECamera1PolicyAdapter {
    private static final String TAG = "TECamera1PolicyAdapter";

    private static boolean checkPrivacy(Cert cert, boolean z) {
        boolean z2;
        try {
            if (z) {
                c96.b(cert);
            } else {
                c96.a(cert);
            }
            z2 = true;
        } catch (BPEAException e) {
            TELogUtils.e(TAG, "error:" + e.getErrorMsg() + " errorCode:" + e.getErrorCode());
            z2 = false;
        }
        TELogUtils.i(TAG, "check privacy:" + z2 + ", open:" + z);
        return z2;
    }

    public static void closeCamera(Cert cert, @NonNull Camera camera) {
        if (checkPrivacy(cert, false)) {
            camera.release();
        }
    }

    public static Camera openCamera(Cert cert, int i) {
        if (checkPrivacy(cert, true)) {
            return i >= 0 ? Camera.open(i) : Camera.open();
        }
        return null;
    }
}
