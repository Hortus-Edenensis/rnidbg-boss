package com.ss.android.ttvecamera.focusmanager;

import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.TEFocusSettings;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@RequiresApi(api = 21)
public abstract class TEFocusStrategyBase implements ITEFocusStrategy {
    protected TECameraSettings mCameraSettings;
    protected TEFocusSettings mFocusSettings;
    protected boolean mIsManualFinalize = true;

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public void configFocus(@NonNull CaptureRequest.Builder builder, @NonNull Rect rect) {
        builder.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect, 999)});
        builder.set(CaptureRequest.CONTROL_MODE, 1);
        builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
        builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        builder.setTag(ITEFocusStrategy.FOCUS_TAG);
    }

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public void configMeter(@NonNull CaptureRequest.Builder builder, @NonNull Rect rect) {
        builder.setTag(ITEFocusStrategy.FOCUS_TAG);
        builder.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect, 999)});
    }

    public void setCameraSettings(TECameraSettings tECameraSettings) {
        this.mCameraSettings = tECameraSettings;
        this.mIsManualFinalize = tECameraSettings.mEnableManualReleaseCaptureResult;
    }

    public void setFocusSettings(TEFocusSettings tEFocusSettings) {
        this.mFocusSettings = tEFocusSettings;
    }
}
