package com.ss.android.ttvecamera.focusmanager;

import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@RequiresApi(api = 21)
public class TEVideoFocusAndMeterStrategy extends TEFocusAndMeterStrategy {
    public TEVideoFocusAndMeterStrategy(@NonNull ITEFocusStrategy.NormalCallbackRequest normalCallbackRequest) {
        super(normalCallbackRequest);
    }

    @Override // com.ss.android.ttvecamera.focusmanager.TEFocusAndMeterStrategy, com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public void enableCaf(@NonNull CaptureRequest.Builder builder) {
        builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
        builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
    }
}
