package com.ss.android.ttvecamera.focusmanager;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.ss.android.ttvecamera.TECameraResult;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ttvecamera.TEFocusSettings;
import com.ss.android.ttvecamera.TELogUtils;
import com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@TargetApi(21)
public class TEImageFocus extends TEFocusStrategyBase {
    private static final String TAG = "TEImageFocus";
    private boolean ifFinalize = true;
    private AtomicBoolean mManualFocusEngaged;
    protected ITEFocusStrategy.NormalCallbackRequest mNormalCallbackRequest;

    public TEImageFocus(@NonNull ITEFocusStrategy.NormalCallbackRequest normalCallbackRequest) {
        this.mNormalCallbackRequest = normalCallbackRequest;
    }

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public int cancelFocus() {
        return this.mNormalCallbackRequest.rollbackNormalSessionRequest();
    }

    @Override // com.ss.android.ttvecamera.focusmanager.TEFocusStrategyBase, com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public void configMeter(@NonNull CaptureRequest.Builder builder, @NonNull Rect rect) {
        if (Build.VERSION.SDK_INT >= 23) {
            builder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 2);
        }
        super.configMeter(builder, rect);
    }

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public void enableCaf(@NonNull CaptureRequest.Builder builder) {
        builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
        builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
    }

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public CameraCaptureSession.CaptureCallback getFocusCaptureCallback(@NonNull final CaptureRequest.Builder builder, AtomicBoolean atomicBoolean, final boolean z) {
        this.mManualFocusEngaged = atomicBoolean;
        return new CameraCaptureSession.CaptureCallback() { // from class: com.ss.android.ttvecamera.focusmanager.TEImageFocus.1
            private int mLastAfState = -1;
            private boolean mIsFocusDone = false;

            private void enableNextManualFocus() {
                if (TEImageFocus.this.mManualFocusEngaged != null) {
                    TEImageFocus.this.mManualFocusEngaged.set(false);
                }
            }

            private void onTouchFocusFailed(CameraCaptureSession cameraCaptureSession) {
                if (z) {
                    builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                    TEImageFocus.this.mNormalCallbackRequest.updateRequestRepeating(cameraCaptureSession, builder);
                }
                enableNextManualFocus();
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureBufferLost(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Surface surface, long j) {
                super.onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j);
                TELogUtils.e(TEImageFocus.TAG, "Manual Focus capture buffer lost ");
                TEFocusSettings tEFocusSettings = TEImageFocus.this.mFocusSettings;
                if (tEFocusSettings != null) {
                    tEFocusSettings.getFocusCallback().onFocus(TECameraResult.TER_CAMERA_FOCUS_FAILED, TEImageFocus.this.mCameraSettings.mFacing, "Manual Focus capture buffer lost ");
                }
                onTouchFocusFailed(cameraCaptureSession);
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
                if (captureRequest == null || !ITEFocusStrategy.FOCUS_TAG.equals(captureRequest.getTag())) {
                    TELogUtils.w(TEImageFocus.TAG, "Not focus request!");
                    return;
                }
                Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
                if (num == null) {
                    TELogUtils.w(TEImageFocus.TAG, "Focus failed.");
                    enableNextManualFocus();
                    return;
                }
                if (this.mLastAfState != num.intValue() && (num.intValue() == 4 || num.intValue() == 5)) {
                    if (z) {
                        builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                        TEImageFocus.this.mNormalCallbackRequest.updateRequestRepeating(cameraCaptureSession, builder);
                    } else {
                        TEImageFocus tEImageFocus = TEImageFocus.this;
                        if (!tEImageFocus.mCameraSettings.mEnableMonitorGyroscope) {
                            tEImageFocus.mNormalCallbackRequest.rollbackNormalSessionRequest();
                        }
                    }
                    if (!this.mIsFocusDone) {
                        this.mIsFocusDone = true;
                        TEFocusSettings tEFocusSettings = TEImageFocus.this.mFocusSettings;
                        if (tEFocusSettings != null) {
                            tEFocusSettings.getFocusCallback().onFocus(TEImageFocus.this.mFocusSettings.getFocusConsumingMS(), TEImageFocus.this.mCameraSettings.mFacing, "Done");
                        }
                    }
                    enableNextManualFocus();
                    TELogUtils.i(TEImageFocus.TAG, "Focus done, isLock = " + z + ", afState = " + num);
                }
                if (this.mIsFocusDone && num.intValue() != 4 && num.intValue() != 5) {
                    TELogUtils.e(TEImageFocus.TAG, "afState error!!!, may be re-auto-focus in some device, switch to caf");
                    TEImageFocus tEImageFocus2 = TEImageFocus.this;
                    if (!tEImageFocus2.mCameraSettings.mEnableMonitorGyroscope) {
                        tEImageFocus2.mNormalCallbackRequest.rollbackNormalSessionRequest();
                    }
                }
                this.mLastAfState = num.intValue();
                if (TEImageFocus.this.ifFinalize) {
                    TEImageFocus.this.ifFinalize = TECameraUtils.finalizeCameraResult(totalCaptureResult);
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
                super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                TELogUtils.e(TEImageFocus.TAG, "Manual Focus Failed: " + captureFailure);
                TEFocusSettings tEFocusSettings = TEImageFocus.this.mFocusSettings;
                if (tEFocusSettings != null) {
                    tEFocusSettings.getFocusCallback().onFocus(TECameraResult.TER_CAMERA_FOCUS_FAILED, TEImageFocus.this.mCameraSettings.mFacing, captureFailure.toString());
                }
                onTouchFocusFailed(cameraCaptureSession);
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureSequenceAborted(@NonNull CameraCaptureSession cameraCaptureSession, int i) {
                super.onCaptureSequenceAborted(cameraCaptureSession, i);
                TELogUtils.e(TEImageFocus.TAG, "Manual Focus capture abort ");
                TEFocusSettings tEFocusSettings = TEImageFocus.this.mFocusSettings;
                if (tEFocusSettings != null) {
                    tEFocusSettings.getFocusCallback().onFocus(TECameraResult.TER_CAMERA_FOCUS_CANCELLED, TEImageFocus.this.mCameraSettings.mFacing, "Manual Focus capture abort ");
                }
                onTouchFocusFailed(cameraCaptureSession);
            }
        };
    }

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public CameraCaptureSession.CaptureCallback getMeteringCaptureCallback(@NonNull CaptureRequest.Builder builder, final boolean z) {
        return new CameraCaptureSession.CaptureCallback() { // from class: com.ss.android.ttvecamera.focusmanager.TEImageFocus.2
            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
                TEFocusSettings tEFocusSettings;
                Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num == null) {
                    TELogUtils.w(TEImageFocus.TAG, "metering failed.");
                    return;
                }
                if (num.intValue() == 3 || num.intValue() == 2) {
                    if (!z && (tEFocusSettings = TEImageFocus.this.mFocusSettings) != null) {
                        tEFocusSettings.getFocusCallback().onFocus(TEImageFocus.this.mFocusSettings.getFocusConsumingMS(), TEImageFocus.this.mCameraSettings.mFacing, "Done");
                    }
                    TEImageFocus tEImageFocus = TEImageFocus.this;
                    if (!tEImageFocus.mCameraSettings.mEnableMonitorGyroscope) {
                        tEImageFocus.mNormalCallbackRequest.rollbackMeteringSessionRequest();
                    }
                }
                if (TEImageFocus.this.ifFinalize) {
                    TEImageFocus.this.ifFinalize = TECameraUtils.finalizeCameraResult(totalCaptureResult);
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
                TEFocusSettings tEFocusSettings;
                super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                if (!z && (tEFocusSettings = TEImageFocus.this.mFocusSettings) != null) {
                    tEFocusSettings.getFocusCallback().onFocus(TECameraResult.TER_CAMERA_FOCUS_FAILED, TEImageFocus.this.mCameraSettings.mFacing, captureFailure.toString());
                }
                TELogUtils.e(TEImageFocus.TAG, "Manual Metering Failed: " + captureFailure);
            }
        };
    }
}
