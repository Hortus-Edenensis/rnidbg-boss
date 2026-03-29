package com.ss.android.ttvecamera.camera2;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import android.os.Handler;
import android.util.Range;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import com.ss.android.ttvecamera.TECamera2;
import com.ss.android.ttvecamera.TECameraResult;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.TELogUtils;
import com.ss.android.ttvecamera.focusmanager.TEVideoFocus;
import com.ss.android.ttvecamera.focusmanager.TEVideoFocusAndMeterStrategy;
import com.ss.android.ttvecamera.framework.TECameraModeBase;
import com.ss.android.ttvecamera.provider.TECameraProviderManager;
import defpackage.is5;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@TargetApi(21)
public class TEVideo2Mode extends TECameraModeBase {
    private static final String TAG = "TEVideo2Mode";

    public TEVideo2Mode(TECamera2 tECamera2, Context context, CameraManager cameraManager, Handler handler) {
        super(tECamera2, context, handler);
        this.mCameraManager = cameraManager;
        if (this.mCameraSettings.mEnableRefactorFocusAndMeter) {
            this.mFocusStrategy = new TEVideoFocusAndMeterStrategy(this);
        } else {
            this.mFocusStrategy = new TEVideoFocus(this);
        }
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase
    public int getContinuousFocusMode() {
        return 3;
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase, com.ss.android.ttvecamera.framework.ITECameraMode
    @RequiresApi(api = 28)
    public int startPreview() throws Exception {
        TECameraProviderManager providerManager = this.mCameraHolder.getProviderManager();
        if (this.mCameraDevice == null || providerManager == null) {
            TELogUtils.d(TAG, "CameraDevice or ProviderManager is null!");
            return -100;
        }
        int iPrepareProvider = super.prepareProvider();
        if (iPrepareProvider != 0) {
            return iPrepareProvider;
        }
        TECameraSettings tECameraSettings = this.mCameraSettings;
        if (!tECameraSettings.mEnableCamera2DeferredSurface || this.mCaptureRequestBuilder == null) {
            if (tECameraSettings.mExtParameters.getBoolean("enablePreviewTemplate")) {
                this.mCaptureRequestBuilder = this.mCameraDevice.createCaptureRequest(1);
            } else {
                this.mCaptureRequestBuilder = this.mCameraDevice.createCaptureRequest(3);
            }
        }
        ArrayList arrayList = new ArrayList();
        if (providerManager.getProvider().getType() == 8) {
            arrayList.addAll(Arrays.asList(providerManager.getPreviewSurfaces()));
        } else if (providerManager.getProvider().getType() == 16) {
            arrayList.add(providerManager.getPreviewSurface());
            arrayList.add(providerManager.getProvider().getRecorderSurface());
        } else {
            arrayList.add(providerManager.getPreviewSurface());
        }
        boolean z = false;
        for (Surface surface : arrayList) {
            this.mCaptureRequestBuilder.addTarget(surface);
            if (!surface.isValid()) {
                z = true;
            }
        }
        this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, configFps(new Range<>(Integer.valueOf(this.mFpsRange.min / this.mCameraSettings.mFPSRange.fpsUnitFactor), Integer.valueOf(this.mFpsRange.max / this.mCameraSettings.mFPSRange.fpsUnitFactor))));
        if (z) {
            TELogUtils.e(TAG, "start preview may be failed, surface invalid...");
        }
        this.mIsFirstPreviewFrameArrived = false;
        this.mCreateSessionStartTimestamp = System.currentTimeMillis();
        Handler cameraHandler = this.mCameraSettings.mUseSyncModeOnCamera2 ? getCameraHandler() : this.mHandler;
        if (this.mCameraSettings.mEnableCamera2DeferredSurface) {
            if (!this.mOutputConfigurations.isEmpty() && !this.mIsSurfaceReady) {
                for (int i = 0; i < arrayList.size(); i++) {
                    is5.a(this.mOutputConfigurations.get(i)).addSurface(arrayList.get(i));
                    this.mIsSurfaceReady = true;
                }
            }
            if (Build.VERSION.SDK_INT >= 28 && this.mCameraSession != null) {
                this.mCameraSession.finalizeOutputConfigurations(this.mOutputConfigurations);
                this.mIsSessionFinalized = true;
                TELogUtils.d(TAG, "finalizeOutputConfigurations in startPreview");
                try {
                    final int iUpdateCapture = updateCapture();
                    if (iUpdateCapture != 0) {
                        openCameraLock();
                        Runnable runnable = new Runnable() { // from class: com.ss.android.ttvecamera.camera2.TEVideo2Mode.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((TECameraModeBase) TEVideo2Mode.this).mCameraEvents.onCameraError(((TECameraModeBase) TEVideo2Mode.this).mCameraSettings.mCameraType, iUpdateCapture, "updateCapture : something wrong.", ((TECameraModeBase) TEVideo2Mode.this).mCameraDevice);
                            }
                        };
                        if (this.mCameraSettings.mUseSyncModeOnCamera2) {
                            this.mHandler.post(runnable);
                        } else {
                            runnable.run();
                        }
                    }
                } catch (Exception e) {
                    openCameraLock();
                    e.printStackTrace();
                }
            }
        } else {
            this.mCameraSession = null;
            createSession(arrayList, this.mSessionStateCallback, cameraHandler);
        }
        if (this.mCameraSession == null) {
            waitCameraTaskDoneOrTimeout();
        }
        return 0;
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase, com.ss.android.ttvecamera.framework.ITECameraMode
    public int startRecording() {
        return super.startRecording();
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase, com.ss.android.ttvecamera.framework.ITECameraMode
    public int stopRecording() {
        return super.stopRecording();
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void switchFlashMode(int i) {
        CaptureRequest.Builder builder = this.mCaptureRequestBuilder;
        if (builder == null) {
            String str = TAG;
            TELogUtils.e(str, "[VE_UI_TEST]Failed event: TOGGLE_TORCH. Code: -100. Reason: mCaptureRequestBuilder is null");
            TELogUtils.e(str, "switchFlashMode: CaptureRequest.Builder is null");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, -100, "switchFlashMode:CaptureRequest.Builder is null", this.mCameraDevice);
            this.mCameraEvents.onTorchError(this.mCameraSettings.mCameraType, -100, i == 0 ? 0 : 1, "switchFlashMode:CaptureRequest.Builder is null", this.mCameraDevice);
            return;
        }
        if (i == 0) {
            builder.set(CaptureRequest.CONTROL_AE_MODE, 1);
            this.mCaptureRequestBuilder.set(CaptureRequest.FLASH_MODE, 0);
        } else {
            if (i != 2) {
                String str2 = TAG;
                TELogUtils.e(str2, "[VE_UI_TEST]Failed event: TOGGLE_TORCH. Code: -100. Reason: not support flash mode " + i);
                TELogUtils.w(str2, "Video Mode not support this mode : " + i);
                this.mCameraEvents.onTorchError(this.mCameraSettings.mCameraType, -100, -1, "Video Mode not support this mode : " + i, this.mCameraDevice);
                return;
            }
            builder.set(CaptureRequest.CONTROL_AE_MODE, 1);
            this.mCaptureRequestBuilder.set(CaptureRequest.FLASH_MODE, 2);
        }
        this.mCameraSettings.mFlashMode = i;
        this.mCameraEvents.onCameraInfo(104, 0, "camera2 will change flash mode " + i, null);
        TECameraModeBase.Response responseUpdatePreview = updatePreview(this.mCaptureRequestBuilder);
        this.mCameraEvents.onCameraInfo(105, 0, "camera2 did change flash mode " + i, null);
        if (responseUpdatePreview.isSuccess()) {
            this.mCameraEvents.onTorchSuccess(this.mCameraSettings.mCameraType, 0, i != 0 ? 1 : 0, "torch success", this.mCameraDevice);
            return;
        }
        TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: TOGGLE_TORCH. Code: -418. Reason: " + responseUpdatePreview.getErrMsg());
        this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_SWITCH_FLASH_FAILED, TECameraResult.TER_CAMERA_SWITCH_FLASH_FAILED, "switch flash failed." + responseUpdatePreview.getErrMsg(), this.mCameraDevice);
        this.mCameraEvents.onTorchError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_SWITCH_FLASH_FAILED, i == 0 ? 0 : 1, "switch flash failed." + responseUpdatePreview.getErrMsg(), this.mCameraDevice);
    }
}
