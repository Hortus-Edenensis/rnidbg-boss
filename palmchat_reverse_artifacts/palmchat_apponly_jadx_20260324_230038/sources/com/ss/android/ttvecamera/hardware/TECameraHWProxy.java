package com.ss.android.ttvecamera.hardware;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@TargetApi(21)
public class TECameraHWProxy extends TECameraHardware2Proxy {
    public TECameraHWProxy(Context context) {
        super(context);
    }

    private static boolean isYale() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("YAL-AL00");
        arrayList.add("YAL-AL10");
        arrayList.add("YAL-TL00");
        arrayList.add("YAL-TL10");
        arrayList.add("YAL-L21");
        arrayList.add("YAL-L41");
        arrayList.add("YAL-AL50");
        arrayList.add("YAL-TL50");
        arrayList.add("YAL-L51");
        arrayList.add("SEA-AL00");
        arrayList.add("SEA-TL00");
        arrayList.add("SEA-AL10");
        arrayList.add("SEA-TL10");
        return arrayList.contains(Build.MODEL);
    }

    @Override // com.ss.android.ttvecamera.hardware.TECameraHardware2Proxy
    public void fillWideCameraID(int i, CameraManager cameraManager) {
        if (isYale()) {
            TECameraHardware2Proxy.mWideCameraID = "3";
        } else {
            super.fillWideCameraID(i, cameraManager);
        }
    }

    @Override // com.ss.android.ttvecamera.hardware.TECameraHardware2Proxy
    public String getWideAngleID() {
        return isYale() ? "3" : super.getWideAngleID();
    }

    @Override // com.ss.android.ttvecamera.hardware.TECameraHardware2Proxy
    public boolean isSupportWideAngle(CameraCharacteristics cameraCharacteristics) {
        Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
        if (num != null && num.intValue() == 0) {
            return false;
        }
        float f = ((float[]) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS))[0];
        return false;
    }

    @Override // com.ss.android.ttvecamera.hardware.TECameraHardware2Proxy
    public boolean isSupportWideAngle() {
        return !"0".equals(getWideAngleID()) || isYale();
    }
}
