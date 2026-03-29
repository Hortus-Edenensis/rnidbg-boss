package com.ss.android.ttvecamera;

import android.hardware.Camera;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ITECameraArea {

    /* JADX INFO: compiled from: SearchBox */
    public interface ITECameraFocusArea {
        List<Camera.Area> calculateArea(int i, int i2, int i3, int i4, int i5, boolean z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface ITECameraMeteringArea {
        List<Camera.Area> calculateArea(int i, int i2, int i3, int i4, int i5, boolean z);
    }
}
