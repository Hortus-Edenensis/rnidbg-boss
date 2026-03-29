package com.ss.android.ttvecamera.armode;

import android.content.Context;
import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import com.ss.android.ttvecamera.TECameraSettings;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ArCoreManager {

    /* JADX INFO: compiled from: SearchBox */
    public static class Holder {
        private static final ArCoreManager INSTANCE = new ArCoreManager();

        private Holder() {
        }
    }

    public static ArCoreManager getInstance() {
        return Holder.INSTANCE;
    }

    public CameraDevice.StateCallback getDevicesStateCallback() {
        return null;
    }

    public boolean init(Context context, TECameraSettings tECameraSettings) {
        return false;
    }

    public void registerEventHandler(Handler handler) {
    }
}
