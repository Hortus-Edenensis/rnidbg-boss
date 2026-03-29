package com.ss.android.ttvecamera.hardware;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.util.SizeF;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@TargetApi(21)
public class TECameraSSProxy extends TECameraHardware2Proxy {
    public Map<String, Float> sizeMap;

    public TECameraSSProxy(Context context) {
        super(context);
        this.sizeMap = new HashMap();
    }

    public void addCamera(CameraCharacteristics cameraCharacteristics, String str) {
        this.sizeMap.put(str, Float.valueOf(((SizeF) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE)).getHeight()));
    }

    public String getRightCam() {
        Map<String, Float> map = this.sizeMap;
        if (map == null) {
            return null;
        }
        float f = 0.0f;
        String str = "";
        for (String str2 : map.keySet()) {
            float fFloatValue = this.sizeMap.get(str2).floatValue();
            if (f < fFloatValue) {
                str = str2;
                f = fFloatValue;
            }
        }
        return str;
    }

    public String selectCamera(CameraManager cameraManager, int i, String[] strArr) throws CameraAccessException {
        int i2 = 0;
        for (String str : strArr) {
            CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
            int i3 = ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 1 ? 0 : 1;
            if (i3 == i && i3 == 1) {
                addCamera(cameraCharacteristics, str);
                i2++;
            }
        }
        if (i2 >= 2) {
            return getRightCam();
        }
        return null;
    }
}
