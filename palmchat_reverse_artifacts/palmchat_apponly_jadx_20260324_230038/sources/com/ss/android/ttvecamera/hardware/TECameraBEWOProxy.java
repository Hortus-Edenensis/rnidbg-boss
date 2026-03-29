package com.ss.android.ttvecamera.hardware;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@RequiresApi(api = 21)
public class TECameraBEWOProxy extends TECameraHardware2Proxy {
    public static final String CAMERA_TYPE_MASTER = "Master";
    public static final String CAMERA_TYPE_PERISCOPE = "Periscope";
    public static final String CAMERA_TYPE_SAT = "SAT";
    public static final String CAMERA_TYPE_TELE = "Tele";
    public static final String CAMERA_TYPE_WIDE = "Wide";
    private static final String TAG = "TECameraBEWOProxy";
    public static final CameraCharacteristics.Key<byte[]> VO_PHYSICAL_CAMERA_TYPES = null;
    public static final CaptureResult.Key<String> VO_SAT_CURRENT_CAMERA_TYPE = null;
    public static final CaptureRequest.Key<Float> VO_ZOOM_RATIO = null;

    public TECameraBEWOProxy(Context context) {
        super(context);
    }

    @Override // com.ss.android.ttvecamera.hardware.TECameraHardware2Proxy
    public String getWideAngleID() {
        return CAMERA_TYPE_WIDE;
    }

    @Override // com.ss.android.ttvecamera.hardware.TECameraHardware2Proxy
    public boolean isSupportWideAngle() {
        return super.isSupportWideAngle();
    }

    @Override // com.ss.android.ttvecamera.hardware.TECameraHardware2Proxy
    public boolean isSupportWideAngle(CameraCharacteristics cameraCharacteristics) {
        return super.isSupportWideAngle(cameraCharacteristics);
    }

    @Override // com.ss.android.ttvecamera.hardware.TECameraHardware2Proxy
    public void fillWideCameraID(int i, CameraManager cameraManager) {
    }
}
