package com.ss.android.ttvecamera.focusmanager;

import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ITEFocusStrategy {
    public static final String FOCUS_TAG = "FOCUS_TAG";
    public static final MeteringRectangle[] ZERO_WEIGHT_3A_REGION = {new MeteringRectangle(0, 0, 0, 0, 0)};

    /* JADX INFO: compiled from: SearchBox */
    public interface NormalCallbackRequest {
        int rollbackMeteringSessionRequest();

        int rollbackNormalSessionRequest();

        void updateRequestRepeating(CameraCaptureSession cameraCaptureSession, CaptureRequest.Builder builder);
    }

    int cancelFocus();

    void configFocus(@NonNull CaptureRequest.Builder builder, @NonNull Rect rect);

    void configMeter(@NonNull CaptureRequest.Builder builder, @NonNull Rect rect);

    void enableCaf(@NonNull CaptureRequest.Builder builder);

    CameraCaptureSession.CaptureCallback getFocusCaptureCallback(@NonNull CaptureRequest.Builder builder, AtomicBoolean atomicBoolean, boolean z);

    CameraCaptureSession.CaptureCallback getMeteringCaptureCallback(@NonNull CaptureRequest.Builder builder, boolean z);
}
