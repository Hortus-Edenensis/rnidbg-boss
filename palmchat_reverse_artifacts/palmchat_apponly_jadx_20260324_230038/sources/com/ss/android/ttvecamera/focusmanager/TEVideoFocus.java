package com.ss.android.ttvecamera.focusmanager;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
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
public class TEVideoFocus extends TEFocusStrategyBase {
    public static final String TAG = "TEVideoFocus";
    private AtomicBoolean mManualFocusEngaged;
    private final ITEFocusStrategy.NormalCallbackRequest mNormalCallbackRequest;

    public TEVideoFocus(@NonNull ITEFocusStrategy.NormalCallbackRequest normalCallbackRequest) {
        this.mNormalCallbackRequest = normalCallbackRequest;
    }

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public int cancelFocus() {
        return this.mNormalCallbackRequest.rollbackNormalSessionRequest();
    }

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public void enableCaf(@NonNull CaptureRequest.Builder builder) {
        builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
        builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
    }

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public CameraCaptureSession.CaptureCallback getFocusCaptureCallback(@NonNull final CaptureRequest.Builder builder, AtomicBoolean atomicBoolean, final boolean z) {
        this.mManualFocusEngaged = atomicBoolean;
        return new CameraCaptureSession.CaptureCallback() { // from class: com.ss.android.ttvecamera.focusmanager.TEVideoFocus.1
            private int mLastAfState = -1;
            private boolean mIsFocusDone = false;

            private void enableNextManualFocus() {
                if (TEVideoFocus.this.mManualFocusEngaged != null) {
                    TEVideoFocus.this.mManualFocusEngaged.set(false);
                }
            }

            private void onTouchFocusFailed(CameraCaptureSession cameraCaptureSession) {
                if (z) {
                    builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                    TEVideoFocus.this.mNormalCallbackRequest.updateRequestRepeating(cameraCaptureSession, builder);
                }
                enableNextManualFocus();
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureBufferLost(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Surface surface, long j) {
                super.onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j);
                TELogUtils.e(TEVideoFocus.TAG, "Manual Focus capture buffer lost ");
                TEFocusSettings tEFocusSettings = TEVideoFocus.this.mFocusSettings;
                if (tEFocusSettings != null) {
                    tEFocusSettings.getFocusCallback().onFocus(TECameraResult.TER_CAMERA_FOCUS_FAILED, TEVideoFocus.this.mFocusSettings.getFocusConsumingMS(), "Manual Focus capture buffer lost ");
                }
                onTouchFocusFailed(cameraCaptureSession);
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
                if (captureRequest == null || !ITEFocusStrategy.FOCUS_TAG.equals(captureRequest.getTag())) {
                    TELogUtils.w(TEVideoFocus.TAG, "Not focus request!");
                    enableNextManualFocus();
                    return;
                }
                Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
                TELogUtils.d(TEVideoFocus.TAG, "Manual Focus onCaptureCompleted: afState = " + num + ", triggerState = " + ((Integer) captureRequest.get(CaptureRequest.CONTROL_AF_TRIGGER)));
                if (num == null) {
                    TELogUtils.w(TEVideoFocus.TAG, "Focus failed.");
                    enableNextManualFocus();
                    return;
                }
                if (this.mLastAfState != num.intValue() && (num.intValue() == 4 || num.intValue() == 5)) {
                    if (z) {
                        builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                        TEVideoFocus.this.mNormalCallbackRequest.updateRequestRepeating(cameraCaptureSession, builder);
                    } else {
                        TEVideoFocus tEVideoFocus = TEVideoFocus.this;
                        if (!tEVideoFocus.mCameraSettings.mEnableMonitorGyroscope) {
                            tEVideoFocus.mNormalCallbackRequest.rollbackNormalSessionRequest();
                        }
                    }
                    if (!this.mIsFocusDone) {
                        this.mIsFocusDone = true;
                        TEFocusSettings tEFocusSettings = TEVideoFocus.this.mFocusSettings;
                        if (tEFocusSettings != null) {
                            tEFocusSettings.getFocusCallback().onFocus(TEVideoFocus.this.mFocusSettings.getFocusConsumingMS(), TEVideoFocus.this.mCameraSettings.mFacing, "Done");
                        }
                    }
                    enableNextManualFocus();
                    TELogUtils.i(TEVideoFocus.TAG, "Focus done, isLock = " + z + ", afState = " + num);
                }
                if (this.mIsFocusDone && num.intValue() != 4 && num.intValue() != 5) {
                    TELogUtils.e(TEVideoFocus.TAG, "afState error!!!, may be re-auto-focus in some device, switch to caf");
                    TEVideoFocus tEVideoFocus2 = TEVideoFocus.this;
                    if (!tEVideoFocus2.mCameraSettings.mEnableMonitorGyroscope) {
                        tEVideoFocus2.mNormalCallbackRequest.rollbackNormalSessionRequest();
                    }
                }
                this.mLastAfState = num.intValue();
                TEVideoFocus tEVideoFocus3 = TEVideoFocus.this;
                if (tEVideoFocus3.mIsManualFinalize) {
                    tEVideoFocus3.mIsManualFinalize = TECameraUtils.finalizeCameraResult(totalCaptureResult);
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
                super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                TELogUtils.e(TEVideoFocus.TAG, "Manual Focus Failed: " + captureFailure);
                TEFocusSettings tEFocusSettings = TEVideoFocus.this.mFocusSettings;
                if (tEFocusSettings != null) {
                    tEFocusSettings.getFocusCallback().onFocus(TECameraResult.TER_CAMERA_FOCUS_FAILED, TEVideoFocus.this.mCameraSettings.mFacing, captureFailure.toString());
                }
                onTouchFocusFailed(cameraCaptureSession);
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
                super.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
                TELogUtils.d(TEVideoFocus.TAG, "Focus onCaptureProgressed!");
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureSequenceAborted(@NonNull CameraCaptureSession cameraCaptureSession, int i) {
                super.onCaptureSequenceAborted(cameraCaptureSession, i);
                TELogUtils.e(TEVideoFocus.TAG, "Manual Focus capture abort ");
                TEFocusSettings tEFocusSettings = TEVideoFocus.this.mFocusSettings;
                if (tEFocusSettings != null) {
                    tEFocusSettings.getFocusCallback().onFocus(TECameraResult.TER_CAMERA_FOCUS_CANCELLED, TEVideoFocus.this.mCameraSettings.mFacing, "Manual Focus capture abort ");
                }
                onTouchFocusFailed(cameraCaptureSession);
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureSequenceCompleted(@NonNull CameraCaptureSession cameraCaptureSession, int i, long j) {
                super.onCaptureSequenceCompleted(cameraCaptureSession, i, j);
                TELogUtils.d(TEVideoFocus.TAG, "Focus onCaptureSequenceCompleted!");
                enableNextManualFocus();
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j, long j2) {
                super.onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
                TELogUtils.d(TEVideoFocus.TAG, "Focus onCaptureStarted!");
            }
        };
    }

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public CameraCaptureSession.CaptureCallback getMeteringCaptureCallback(@NonNull CaptureRequest.Builder builder, final boolean z) {
        return new CameraCaptureSession.CaptureCallback() { // from class: com.ss.android.ttvecamera.focusmanager.TEVideoFocus.2
            private boolean mIsMeteringDone = false;

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
                TEFocusSettings tEFocusSettings;
                Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num == null) {
                    TELogUtils.w(TEVideoFocus.TAG, "metering failed.");
                    return;
                }
                if (num.intValue() == 3 || num.intValue() == 2) {
                    if (!z && (tEFocusSettings = TEVideoFocus.this.mFocusSettings) != null && !this.mIsMeteringDone) {
                        tEFocusSettings.getFocusCallback().onFocus(TEVideoFocus.this.mFocusSettings.getFocusConsumingMS(), TEVideoFocus.this.mCameraSettings.mFacing, "Done");
                        this.mIsMeteringDone = true;
                    }
                    TEVideoFocus tEVideoFocus = TEVideoFocus.this;
                    if (!tEVideoFocus.mCameraSettings.mEnableMonitorGyroscope) {
                        tEVideoFocus.mNormalCallbackRequest.rollbackMeteringSessionRequest();
                    }
                    TELogUtils.d(TEVideoFocus.TAG, "Manual Metering success");
                }
                TEVideoFocus tEVideoFocus2 = TEVideoFocus.this;
                if (tEVideoFocus2.mIsManualFinalize) {
                    tEVideoFocus2.mIsManualFinalize = TECameraUtils.finalizeCameraResult(totalCaptureResult);
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
                TEFocusSettings tEFocusSettings;
                super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                if (!z && (tEFocusSettings = TEVideoFocus.this.mFocusSettings) != null) {
                    tEFocusSettings.getFocusCallback().onFocus(TECameraResult.TER_CAMERA_FOCUS_FAILED, TEVideoFocus.this.mCameraSettings.mFacing, captureFailure.toString());
                }
                TELogUtils.e(TEVideoFocus.TAG, "Manual Metering Failed: " + captureFailure);
            }
        };
    }
}
