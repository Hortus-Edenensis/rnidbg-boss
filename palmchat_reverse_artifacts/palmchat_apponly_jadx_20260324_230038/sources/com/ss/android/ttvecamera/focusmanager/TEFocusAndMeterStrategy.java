package com.ss.android.ttvecamera.focusmanager;

import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.ss.android.ttvecamera.TECameraResult;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ttvecamera.TEFocusSettings;
import com.ss.android.ttvecamera.TELogUtils;
import com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@RequiresApi(api = 21)
public class TEFocusAndMeterStrategy extends TEFocusStrategyBase {
    private static final String TAG = "TEFocusAndMeterStrategy";
    private AtomicBoolean mManualFocusEngaged;
    private final ITEFocusStrategy.NormalCallbackRequest mNormalCallbackRequest;

    public TEFocusAndMeterStrategy(@NonNull ITEFocusStrategy.NormalCallbackRequest normalCallbackRequest) {
        this.mNormalCallbackRequest = normalCallbackRequest;
    }

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public int cancelFocus() {
        return this.mNormalCallbackRequest.rollbackNormalSessionRequest();
    }

    @Override // com.ss.android.ttvecamera.focusmanager.TEFocusStrategyBase, com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public void configFocus(@NonNull CaptureRequest.Builder builder, @NonNull Rect rect) {
        builder.set(CaptureRequest.CONTROL_MODE, 1);
        builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
        builder.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect, 999)});
        builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
    }

    @Override // com.ss.android.ttvecamera.focusmanager.TEFocusStrategyBase, com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public void configMeter(@NonNull CaptureRequest.Builder builder, @NonNull Rect rect) {
        builder.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect, 999)});
    }

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public void enableCaf(@NonNull CaptureRequest.Builder builder) {
        builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
        builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
    }

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public CameraCaptureSession.CaptureCallback getFocusCaptureCallback(@NonNull final CaptureRequest.Builder builder, AtomicBoolean atomicBoolean, final boolean z) {
        this.mManualFocusEngaged = atomicBoolean;
        return new CameraCaptureSession.CaptureCallback() { // from class: com.ss.android.ttvecamera.focusmanager.TEFocusAndMeterStrategy.1
            private int mLastAfState = -1;
            private boolean mIsFocusDone = false;

            private void enableNextManualFocus() {
                if (TEFocusAndMeterStrategy.this.mManualFocusEngaged != null) {
                    TEFocusAndMeterStrategy.this.mManualFocusEngaged.set(false);
                }
            }

            private void onTouchFocusFailed(CameraCaptureSession cameraCaptureSession) {
                if (z) {
                    builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                    TEFocusAndMeterStrategy.this.mNormalCallbackRequest.updateRequestRepeating(cameraCaptureSession, builder);
                }
                enableNextManualFocus();
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureBufferLost(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Surface surface, long j) {
                super.onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j);
                TELogUtils.e(TEFocusAndMeterStrategy.TAG, "Manual Focus capture buffer lost , session: " + cameraCaptureSession);
                TEFocusSettings tEFocusSettings = TEFocusAndMeterStrategy.this.mFocusSettings;
                if (tEFocusSettings != null) {
                    tEFocusSettings.getFocusCallback().onFocus(TECameraResult.TER_CAMERA_FOCUS_FAILED, TEFocusAndMeterStrategy.this.mFocusSettings.getFocusConsumingMS(), "Manual Focus capture buffer lost ");
                }
                onTouchFocusFailed(cameraCaptureSession);
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
                boolean z2;
                Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
                if (num == null) {
                    TELogUtils.w(TEFocusAndMeterStrategy.TAG, "Focus failed.");
                    enableNextManualFocus();
                    return;
                }
                if (this.mLastAfState != num.intValue()) {
                    TELogUtils.i(TEFocusAndMeterStrategy.TAG, "Focus onCaptureCompleted! afState = " + num);
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.mLastAfState = num.intValue();
                if (z2 && (num.intValue() == 4 || num.intValue() == 5)) {
                    if (z) {
                        TEFocusAndMeterStrategy.this.mNormalCallbackRequest.updateRequestRepeating(cameraCaptureSession, builder);
                    } else {
                        TEFocusAndMeterStrategy.this.mNormalCallbackRequest.rollbackNormalSessionRequest();
                    }
                    if (!this.mIsFocusDone) {
                        this.mIsFocusDone = true;
                        TEFocusSettings tEFocusSettings = TEFocusAndMeterStrategy.this.mFocusSettings;
                        if (tEFocusSettings != null) {
                            tEFocusSettings.getFocusCallback().onFocus(TEFocusAndMeterStrategy.this.mFocusSettings.getFocusConsumingMS(), TEFocusAndMeterStrategy.this.mCameraSettings.mFacing, "Done");
                        }
                    }
                    enableNextManualFocus();
                    TELogUtils.i(TEFocusAndMeterStrategy.TAG, "Focus done, isLock = " + z + ", afState = " + num);
                }
                if (this.mIsFocusDone && num.intValue() != 4 && num.intValue() != 5) {
                    TELogUtils.e(TEFocusAndMeterStrategy.TAG, "afState error!!!, may be re-auto-focus in some device, switch to caf");
                    TEFocusAndMeterStrategy.this.mNormalCallbackRequest.rollbackNormalSessionRequest();
                }
                TEFocusAndMeterStrategy tEFocusAndMeterStrategy = TEFocusAndMeterStrategy.this;
                if (tEFocusAndMeterStrategy.mIsManualFinalize) {
                    tEFocusAndMeterStrategy.mIsManualFinalize = TECameraUtils.finalizeCameraResult(totalCaptureResult);
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
                super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                TELogUtils.e(TEFocusAndMeterStrategy.TAG, "Manual Focus Failed: " + captureFailure + ", session: " + cameraCaptureSession);
                TEFocusSettings tEFocusSettings = TEFocusAndMeterStrategy.this.mFocusSettings;
                if (tEFocusSettings != null) {
                    tEFocusSettings.getFocusCallback().onFocus(TECameraResult.TER_CAMERA_FOCUS_FAILED, TEFocusAndMeterStrategy.this.mCameraSettings.mFacing, captureFailure.toString());
                }
                onTouchFocusFailed(cameraCaptureSession);
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
                super.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
                TELogUtils.d(TEFocusAndMeterStrategy.TAG, "Focus onCaptureProgressed!");
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureSequenceAborted(@NonNull CameraCaptureSession cameraCaptureSession, int i) {
                super.onCaptureSequenceAborted(cameraCaptureSession, i);
                TELogUtils.e(TEFocusAndMeterStrategy.TAG, "Manual Focus capture abort ");
                TEFocusSettings tEFocusSettings = TEFocusAndMeterStrategy.this.mFocusSettings;
                if (tEFocusSettings != null) {
                    tEFocusSettings.getFocusCallback().onFocus(TECameraResult.TER_CAMERA_FOCUS_CANCELLED, TEFocusAndMeterStrategy.this.mCameraSettings.mFacing, "Manual Focus capture abort ");
                }
                onTouchFocusFailed(cameraCaptureSession);
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureSequenceCompleted(@NonNull CameraCaptureSession cameraCaptureSession, int i, long j) {
                super.onCaptureSequenceCompleted(cameraCaptureSession, i, j);
                TELogUtils.d(TEFocusAndMeterStrategy.TAG, "Focus onCaptureSequenceCompleted!");
                enableNextManualFocus();
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j, long j2) {
                super.onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
                TELogUtils.d(TEFocusAndMeterStrategy.TAG, "Focus onCaptureStarted!");
            }
        };
    }

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public CameraCaptureSession.CaptureCallback getMeteringCaptureCallback(@NonNull CaptureRequest.Builder builder, final boolean z) {
        return new CameraCaptureSession.CaptureCallback() { // from class: com.ss.android.ttvecamera.focusmanager.TEFocusAndMeterStrategy.2
            private boolean mIsMeteringDone = false;

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
                TEFocusSettings tEFocusSettings;
                Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num == null) {
                    TELogUtils.w(TEFocusAndMeterStrategy.TAG, "metering failed.");
                    return;
                }
                if (num.intValue() == 3 || num.intValue() == 2) {
                    if (!z && (tEFocusSettings = TEFocusAndMeterStrategy.this.mFocusSettings) != null && !this.mIsMeteringDone) {
                        tEFocusSettings.getFocusCallback().onFocus(TEFocusAndMeterStrategy.this.mFocusSettings.getFocusConsumingMS(), TEFocusAndMeterStrategy.this.mCameraSettings.mFacing, "Done");
                        this.mIsMeteringDone = true;
                    }
                    TEFocusAndMeterStrategy.this.mNormalCallbackRequest.rollbackMeteringSessionRequest();
                }
                TEFocusAndMeterStrategy tEFocusAndMeterStrategy = TEFocusAndMeterStrategy.this;
                if (tEFocusAndMeterStrategy.mIsManualFinalize) {
                    tEFocusAndMeterStrategy.mIsManualFinalize = TECameraUtils.finalizeCameraResult(totalCaptureResult);
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
                TEFocusSettings tEFocusSettings;
                super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                if (!z && (tEFocusSettings = TEFocusAndMeterStrategy.this.mFocusSettings) != null) {
                    tEFocusSettings.getFocusCallback().onFocus(TECameraResult.TER_CAMERA_FOCUS_FAILED, TEFocusAndMeterStrategy.this.mCameraSettings.mFacing, captureFailure.toString());
                }
                TELogUtils.e(TEFocusAndMeterStrategy.TAG, "Manual Metering Failed: " + captureFailure);
            }
        };
    }
}
