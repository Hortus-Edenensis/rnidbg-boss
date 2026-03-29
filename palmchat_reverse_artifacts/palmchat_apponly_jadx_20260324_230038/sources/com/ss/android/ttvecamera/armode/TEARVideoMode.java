package com.ss.android.ttvecamera.armode;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.util.Range;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.ss.android.ttvecamera.TECamera2;
import com.ss.android.ttvecamera.TECameraResult;
import com.ss.android.ttvecamera.TELogUtils;
import com.ss.android.ttvecamera.focusmanager.TEVideoFocus;
import com.ss.android.ttvecamera.framework.TECameraModeBase;
import com.ss.android.ttvecamera.provider.TECameraProviderManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@TargetApi(21)
public class TEARVideoMode extends TECameraModeBase {
    public static final int DEVICE_CLOSED = 4;
    public static final int DEVICE_DISCONNECTED = 1;
    public static final int DEVICE_ERROR = 3;
    public static final int DEVICE_OPENED = 0;
    public static final int SESSION_ACTIVE = 3;
    public static final int SESSION_CAPTURE_QUEUE_EMPTY = 6;
    public static final int SESSION_CLOSED = 5;
    public static final int SESSION_CONFIGURED = 0;
    public static final int SESSION_CONFIGURE_FAILED = 1;
    public static final int SESSION_READY = 4;
    public static final int SESSION_SURFACE_PREPARED = 7;
    private static final String TAG = "TEARVideoMode";
    private ArCoreManager mArCoreManager;

    public TEARVideoMode(@NonNull TECamera2 tECamera2, @NonNull Context context, @NonNull CameraManager cameraManager, Handler handler) {
        super(tECamera2, context, handler);
        this.mArCoreManager = null;
        this.mCameraManager = cameraManager;
        this.mFocusStrategy = new TEVideoFocus(this);
    }

    public void closeARSession() {
        TELogUtils.d(TAG, "closeARSession not supported");
    }

    public CameraDevice.StateCallback getDevicesStateCallback() {
        ArCoreManager arCoreManager = this.mArCoreManager;
        if (arCoreManager == null) {
            return null;
        }
        return arCoreManager.getDevicesStateCallback();
    }

    public void initArCore(Context context, Handler handler) {
        if (this.mDeviceProxy.isARCoreSupported()) {
            ArCoreManager arCoreManager = ArCoreManager.getInstance();
            this.mArCoreManager = arCoreManager;
            arCoreManager.init(context, null);
            this.mArCoreManager.registerEventHandler(handler);
        }
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase, com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy.NormalCallbackRequest
    public int rollbackMeteringSessionRequest() {
        if (this.mCaptureRequestBuilder == null) {
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, -100, "rollbackNormalSessionRequest : param is null.", this.mCameraDevice);
            return -100;
        }
        useFaceAEStrategy(this.mUseFaceAE);
        this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, 1);
        updatePreview(this.mCaptureRequestBuilder);
        return 0;
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase, com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy.NormalCallbackRequest
    public int rollbackNormalSessionRequest() {
        CaptureRequest.Builder builder = this.mCaptureRequestBuilder;
        if (builder == null) {
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, -100, "rollbackNormalSessionRequest : param is null.", this.mCameraDevice);
            return -100;
        }
        builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
        this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, 3);
        this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, 1);
        updatePreview(this.mCaptureRequestBuilder);
        return 0;
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase, com.ss.android.ttvecamera.framework.ITECameraMode
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
        this.mCaptureRequestBuilder = this.mCameraDevice.createCaptureRequest(3);
        ArrayList arrayList = new ArrayList();
        if (providerManager.getProvider().getType() == 8) {
            arrayList.addAll(Arrays.asList(providerManager.getPreviewSurfaces()));
        } else {
            arrayList.add(providerManager.getPreviewSurface());
        }
        Iterator<Surface> it = arrayList.iterator();
        while (it.hasNext()) {
            this.mCaptureRequestBuilder.addTarget(it.next());
        }
        this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, configFps(new Range<>(Integer.valueOf(this.mFpsRange.min / this.mCameraSettings.mFPSRange.fpsUnitFactor), Integer.valueOf(this.mFpsRange.max / this.mCameraSettings.mFPSRange.fpsUnitFactor))));
        this.mIsFirstPreviewFrameArrived = false;
        this.mCreateSessionStartTimestamp = System.currentTimeMillis();
        Handler cameraHandler = this.mCameraSettings.mUseSyncModeOnCamera2 ? getCameraHandler() : this.mHandler;
        this.mCameraSession = null;
        createSession(arrayList, this.mSessionStateCallback, cameraHandler);
        if (this.mCameraSession == null) {
            waitCameraTaskDoneOrTimeout();
        }
        return 0;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void switchFlashMode(int i) {
        CaptureRequest.Builder builder = this.mCaptureRequestBuilder;
        if (builder == null) {
            String str = TAG;
            TELogUtils.e(str, "[VE_UI_TEST]Failed event: TOGGLE_TORCH. Code: -100. Reason: mCaptureRequestBuilder is null");
            TELogUtils.e(str, "switchFlashMode: CaptureRequest.Builder is null");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, -100, "switchFlashMode:CaptureRequest.Builder is null", this.mCameraDevice);
            return;
        }
        if (i == 0) {
            builder.set(CaptureRequest.CONTROL_AE_MODE, 1);
            this.mCaptureRequestBuilder.set(CaptureRequest.FLASH_MODE, 0);
        } else {
            if (i != 2) {
                TELogUtils.w(TAG, "Video Mode not support this mode : " + i);
                return;
            }
            builder.set(CaptureRequest.CONTROL_AE_MODE, 1);
            this.mCaptureRequestBuilder.set(CaptureRequest.FLASH_MODE, 2);
        }
        this.mCameraSettings.mFlashMode = i;
        TECameraModeBase.Response responseUpdatePreview = updatePreview(this.mCaptureRequestBuilder);
        if (responseUpdatePreview.isSuccess()) {
            return;
        }
        TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: TOGGLE_TORCH. Code: -418. Reason: " + responseUpdatePreview.getErrMsg());
        this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_SWITCH_FLASH_FAILED, TECameraResult.TER_CAMERA_SWITCH_FLASH_FAILED, "switch flash failed." + responseUpdatePreview.getErrMsg(), this.mCameraDevice);
    }

    public CameraDevice.StateCallback wrapDeviceStateCallback(CameraDevice.StateCallback stateCallback, Handler handler) {
        TELogUtils.d(TAG, "wrapDeviceStateCallback not supported");
        return null;
    }

    public void onDeviceProxy(CameraDevice cameraDevice, int i, int i2) {
    }

    public void onSessionProxy(CameraCaptureSession cameraCaptureSession, int i, Object obj) {
    }
}
