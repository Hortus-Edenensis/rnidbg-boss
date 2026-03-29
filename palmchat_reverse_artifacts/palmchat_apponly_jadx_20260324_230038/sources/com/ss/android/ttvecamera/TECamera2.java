package com.ss.android.ttvecamera;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraExtensionCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import com.bytedance.bpea.basics.Cert;
import com.oplus.tblplayer.processor.util.EffectConstants;
import com.ss.android.ttvecamera.TECameraBase;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.armode.TEARVideoMode;
import com.ss.android.ttvecamera.camera2.TEImage2Mode;
import com.ss.android.ttvecamera.camera2.TEVideo2Mode;
import com.ss.android.ttvecamera.cameracapabilitycollector.TECameraCapabilityCollector;
import com.ss.android.ttvecamera.focusmanager.Gyro;
import com.ss.android.ttvecamera.framework.TECameraModeBase;
import com.ss.android.ttvecamera.hardware.TECameraHardware2Proxy;
import com.ss.android.ttvecamera.model.BurstRequest;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@TargetApi(21)
public class TECamera2 extends TECameraBase {
    public static final int SESSION_STATE_ERROR = 4;
    public static final int SESSION_STATE_IDLE = 0;
    public static final int SESSION_STATE_OPENED = 2;
    public static final int SESSION_STATE_OPENING = 1;
    public static final int SESSION_STATE_RUNNING = 3;
    protected static final String TAG = "TECamera2";
    protected CameraCharacteristics mCameraCharacteristics;
    protected ConditionVariable mCameraCondition;
    protected volatile CameraDevice mCameraDevice;
    protected CameraManager mCameraManager;
    protected CaptureRequest mCaptureRequest;
    protected TECameraHardware2Proxy mDeviceProxy;
    protected CameraDevice.StateCallback mDeviceStateCallback;
    private final Gyro mGyro;
    protected boolean mIsCameraOpenCloseSyncEnable;
    protected boolean mIsFirstOpenCamera;
    protected boolean mIsRequestCloseIntent;
    protected int mLastOrientation;
    protected TECameraModeBase mMode;
    protected volatile int mSessionState;
    private List<TEFrameSizei> mSupportedPictureSizes;
    private List<TEFrameSizei> mSupportedPreviewSizes;

    /* JADX INFO: compiled from: SearchBox */
    public static class CameraStateCallback<T> {
        WeakReference<TECamera2> cameraWeakReference;

        public CameraStateCallback(TECamera2 tECamera2) {
            this.cameraWeakReference = new WeakReference<>(tECamera2);
        }

        public boolean onDisconnected(@NonNull T t) {
            TELogUtils.e(TECamera2.TAG, "StateCallback::onDisconnected...");
            final TECamera2 tECamera2 = this.cameraWeakReference.get();
            if (tECamera2 == null) {
                return false;
            }
            if (tECamera2.mCameraSettings.mIgnoreCameraResetTaskOnDisconnected) {
                TELogUtils.e(TECamera2.TAG, "StateCallback::onDisconnected...ignore reset...");
                tECamera2.mCameraSettings.mIgnoreCameraResetTaskOnDisconnected = false;
                return false;
            }
            Runnable runnable = new Runnable() { // from class: com.ss.android.ttvecamera.TECamera2.CameraStateCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    TECamera2 tECamera22 = tECamera2;
                    tECamera22._reset(tECamera22.openPrivacyCert);
                    TECamera2 tECamera23 = tECamera2;
                    TECameraBase.CameraEvents cameraEvents = tECamera23.mCameraEvents;
                    if (cameraEvents != null) {
                        cameraEvents.onCameraError(tECamera23.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_DISCONNECTED, "Camera onDisconnected", tECamera23.mCameraDevice);
                    }
                }
            };
            if (tECamera2.mCameraSettings.mUseSyncModeOnCamera2) {
                tECamera2.mHandler.post(runnable);
                return true;
            }
            runnable.run();
            return true;
        }

        public boolean onError(@NonNull T t, final int i) {
            final TECamera2 tECamera2 = this.cameraWeakReference.get();
            if (tECamera2 == null) {
                TELogUtils.e(TECamera2.TAG, "onError...no camera holder");
                return false;
            }
            final int sessionState = tECamera2.getSessionState();
            final String str = "StateCallback::onError..." + i + ", session code: " + sessionState;
            TELogUtils.i(TECamera2.TAG, str);
            Runnable runnable = new Runnable() { // from class: com.ss.android.ttvecamera.TECamera2.CameraStateCallback.3
                @Override // java.lang.Runnable
                public void run() {
                    int i2;
                    TECamera2 tECamera22 = tECamera2;
                    tECamera22._reset(tECamera22.openPrivacyCert);
                    TECamera2 tECamera23 = tECamera2;
                    TECameraBase.CameraEvents cameraEvents = tECamera23.mCameraEvents;
                    if (cameraEvents != null) {
                        if (sessionState == 3 && (i2 = i) == 3) {
                            cameraEvents.onCameraError(tECamera23.mCameraSettings.mCameraType, i2, str, tECamera23.mCameraDevice);
                        } else {
                            cameraEvents.onCameraOpened(tECamera23.mCameraSettings.mCameraType, i, null, tECamera23.mCameraDevice);
                        }
                    }
                }
            };
            if (tECamera2.mCameraSettings.mUseSyncModeOnCamera2) {
                tECamera2.mHandler.post(runnable);
            } else {
                runnable.run();
            }
            tECamera2.updateSessionState(4);
            return true;
        }

        public boolean onOpened(@NonNull T t) {
            TELogUtils.i(TECamera2.TAG, "StateCallback::onOpened...");
            final TECamera2 tECamera2 = this.cameraWeakReference.get();
            if (tECamera2 == null) {
                return false;
            }
            tECamera2.mCameraSettings.mIgnoreCameraResetTaskOnDisconnected = false;
            tECamera2.updateSessionState(2);
            Runnable runnable = new Runnable() { // from class: com.ss.android.ttvecamera.TECamera2.CameraStateCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    TECamera2 tECamera22 = tECamera2;
                    TECameraBase.CameraEvents cameraEvents = tECamera22.mCameraEvents;
                    if (cameraEvents != null) {
                        cameraEvents.onCameraOpened(tECamera22.mCameraSettings.mCameraType, 0, null, tECamera22.mCameraDevice);
                    } else {
                        TELogUtils.e(TECamera2.TAG, "mCameraEvents is null!");
                    }
                }
            };
            if (tECamera2.mCameraSettings.mUseSyncModeOnCamera2) {
                tECamera2.mHandler.post(runnable);
            } else {
                runnable.run();
            }
            tECamera2.mIsFirstOpenCamera = false;
            return true;
        }
    }

    public TECamera2(int i, Context context, TECameraBase.CameraEvents cameraEvents, Handler handler, TECameraBase.PictureSizeCallBack pictureSizeCallBack) {
        super(context, cameraEvents, handler, pictureSizeCallBack);
        this.mSessionState = 0;
        this.mLastOrientation = -1;
        this.mIsFirstOpenCamera = true;
        this.mIsRequestCloseIntent = false;
        this.mIsCameraOpenCloseSyncEnable = false;
        this.mSupportedPreviewSizes = null;
        this.mSupportedPictureSizes = null;
        this.mCameraCondition = new ConditionVariable();
        this.mDeviceStateCallback = new CameraDevice.StateCallback() { // from class: com.ss.android.ttvecamera.TECamera2.1
            CameraStateCallback<CameraDevice> stateCallback;

            {
                this.stateCallback = new CameraStateCallback<>(TECamera2.this);
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onClosed(@NonNull CameraDevice cameraDevice) {
                TECameraModeBase tECameraModeBase = TECamera2.this.mMode;
                if (tECameraModeBase instanceof TEARVideoMode) {
                    ((TEARVideoMode) tECameraModeBase).onDeviceProxy(cameraDevice, 4, -1);
                }
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onDisconnected(@NonNull CameraDevice cameraDevice) {
                TELogUtils.i(TECamera2.TAG, "onDisconnected: OpenCameraCallBack");
                TECameraModeBase tECameraModeBase = TECamera2.this.mMode;
                if (tECameraModeBase instanceof TEARVideoMode) {
                    ((TEARVideoMode) tECameraModeBase).onDeviceProxy(cameraDevice, 1, -1);
                }
                TECamera2.this.openCameraLock();
                CameraStateCallback<CameraDevice> cameraStateCallback = this.stateCallback;
                if (cameraStateCallback != null) {
                    cameraStateCallback.onDisconnected(cameraDevice);
                }
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onError(@NonNull CameraDevice cameraDevice, int i2) {
                TELogUtils.i(TECamera2.TAG, "onError: " + i2);
                TECameraModeBase tECameraModeBase = TECamera2.this.mMode;
                if (tECameraModeBase instanceof TEARVideoMode) {
                    ((TEARVideoMode) tECameraModeBase).onDeviceProxy(cameraDevice, 3, i2);
                }
                TECamera2.this.openCameraLock();
                CameraStateCallback<CameraDevice> cameraStateCallback = this.stateCallback;
                if (cameraStateCallback == null) {
                    TELogUtils.e(TECamera2.TAG, "had called onError");
                } else {
                    cameraStateCallback.onError(cameraDevice, i2);
                    this.stateCallback = null;
                }
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onOpened(@NonNull CameraDevice cameraDevice) {
                TELogUtils.i(TECamera2.TAG, "onOpened: OpenCameraCallBack");
                TECamera2.this.mCameraEvents.onCameraInfo(107, 0, "did start camera2", null);
                TECameraModeBase tECameraModeBase = TECamera2.this.mMode;
                if (tECameraModeBase instanceof TEARVideoMode) {
                    ((TEARVideoMode) tECameraModeBase).onDeviceProxy(cameraDevice, 0, -1);
                }
                TECamera2.this.mCameraDevice = cameraDevice;
                TECamera2.this.mMode.setCameraDevice(cameraDevice);
                TECamera2.this.openCameraLock();
                CameraStateCallback<CameraDevice> cameraStateCallback = this.stateCallback;
                if (cameraStateCallback == null || !cameraStateCallback.onOpened(cameraDevice)) {
                    TECamera2PolicyAdapter.closeCamera(TECamera2.this.openPrivacyCert, cameraDevice);
                    TELogUtils.w(TECamera2.TAG, "onOpened: OpenCameraCallBack, some bad case occur, close camera!");
                    return;
                }
                TECamera2 tECamera2 = TECamera2.this;
                if (tECamera2.mIsCameraOpenCloseSyncEnable && tECamera2.mIsRequestCloseIntent) {
                    TECamera2PolicyAdapter.closeCamera(tECamera2.openPrivacyCert, cameraDevice);
                    TELogUtils.w(TECamera2.TAG, "onOpened: OpenCameraCallBack, but had camera close intent...");
                    TECamera2.this.mIsRequestCloseIntent = false;
                } else if (tECamera2.mCameraSettings.mEnableCamera2DeferredSurface) {
                    try {
                        tECamera2.mMode.createSessionByDeferredSurface();
                    } catch (Exception e) {
                        TELogUtils.w(TECamera2.TAG, "onOpened: createSessionByDeferredSurface, some bad case occur, close camera! exception msg: " + e.getMessage());
                        TECamera2 tECamera22 = TECamera2.this;
                        tECamera22.mCameraSettings.mEnableCamera2DeferredSurface = false;
                        if (tECamera22.mSessionState != 3) {
                            TECamera2.this.startCapture();
                        }
                    }
                }
            }
        };
        this.mCameraSettings = new TECameraSettings(context, i);
        this.mGyro = new Gyro(context);
        this.mDeviceProxy = TECameraHardware2Proxy.getDeviceProxy(context, i);
    }

    private int convertExeptionToErrCode(CameraAccessException cameraAccessException) {
        int reason = cameraAccessException.getReason();
        if (reason == 1) {
            return TECameraResult.TER_CAMERA_DISABLED;
        }
        if (reason == 2) {
            return TECameraResult.TER_CAMERA_DISCONNECTED;
        }
        if (reason == 3) {
            return TECameraResult.TER_CAMERA_DEVICE_ERROR;
        }
        if (reason == 4 || reason == 5) {
            return -406;
        }
        return TECameraResult.TER_CAMERA_OPEN_FAILED;
    }

    public static TECamera2 create(@TECameraSettings.CameraType int i, Context context, TECameraBase.CameraEvents cameraEvents, Handler handler, TECameraBase.PictureSizeCallBack pictureSizeCallBack) {
        return new TECamera2(i, context, cameraEvents, handler, pictureSizeCallBack);
    }

    private void fillWideCameraID(int i, CameraManager cameraManager) {
        TETraceUtils.beginSection("TECamera2-fillWideCameraID");
        TECameraHardware2Proxy tECameraHardware2Proxy = this.mDeviceProxy;
        if (tECameraHardware2Proxy != null) {
            tECameraHardware2Proxy.fillWideCameraID(this.mCameraSettings.mCameraType, this.mCameraManager);
        }
        TETraceUtils.endSection();
    }

    private List<TEFrameRateRange> getSupportedFpsRanges() {
        CameraCharacteristics cameraCharacteristics;
        TECameraModeBase tECameraModeBase = this.mMode;
        if (tECameraModeBase != null && (cameraCharacteristics = tECameraModeBase.mCameraCharacteristics) != null) {
            return TECameraUtils.convertRanges((Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
        }
        TELogUtils.e(TAG, "getSupportedFpsRanges: camera is null.");
        this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "getSupportedFpsRanges: camera is null.", this.mCameraDevice);
        return null;
    }

    public boolean _isDeviceReady() {
        return this.mCameraDevice != null;
    }

    @SuppressLint({"MissingPermission"})
    public int _open(Cert cert) throws Exception {
        TETraceUtils.beginSection("TECamera2-_open");
        if (this.mCameraManager == null) {
            CameraManager cameraManager = (CameraManager) this.mContext.getSystemService("camera");
            this.mCameraManager = cameraManager;
            if (cameraManager == null) {
                return TECameraResult.TER_CAMERA_SERVER_ERROR;
            }
        }
        int i = this.mCameraSettings.mMode;
        if (i == 0) {
            createVideoMode();
        } else if (i == 1) {
            TEImage2Mode tEImage2Mode = new TEImage2Mode(this, this.mContext, this.mCameraManager, this.mHandler);
            this.mMode = tEImage2Mode;
            tEImage2Mode.setPictureSizeCallback(this.mPictureSizeCallback);
            this.mMode.setFpsConfigCallback(this.mFpsConfigCallback);
        } else {
            this.mMode = new TEARVideoMode(this, this.mContext, this.mCameraManager, this.mHandler);
            this.mCameraEvents.onCameraInfo(117, 0, "enable arcore", this.mCameraDevice);
        }
        this.mMode.setPreviewSizeCallback(this.mPreviewSizeCallback);
        Handler cameraHandler = this.mCameraSettings.mUseSyncModeOnCamera2 ? this.mMode.getCameraHandler() : this.mHandler;
        TECameraModeBase tECameraModeBase = this.mMode;
        if (tECameraModeBase instanceof TEARVideoMode) {
            ((TEARVideoMode) tECameraModeBase).initArCore(this.mContext, cameraHandler);
        }
        TECameraSettings tECameraSettings = this.mCameraSettings;
        tECameraSettings.mStrCameraID = selectCamera(tECameraSettings.mFacing);
        TECameraSettings tECameraSettings2 = this.mCameraSettings;
        String str = tECameraSettings2.mStrCameraID;
        if (str == null) {
            TELogUtils.e(TAG, "Invalid CameraID");
            return TECameraResult.TER_CAMERA_INVALID_CAMERA_ID;
        }
        int iOpenCamera = this.mMode.openCamera(str, this.mIsFirstOpenCamera ? tECameraSettings2.mRequiredCameraLevel : 0);
        if (iOpenCamera != 0) {
            return iOpenCamera;
        }
        checkIfEnableDeferredSurface();
        fillFeatures();
        fillWideCameraID(this.mCameraSettings.mCameraType, this.mCameraManager);
        this.mCameraEvents.onCameraInfo(1, 0, "TECamera2 features is ready", this.mCameraDevice);
        if (this.mCameraSettings.mUseSyncModeOnCamera2) {
            try {
                this.mCameraDevice = null;
                TECamera2PolicyAdapter.openCamera(cert, this.mCameraManager, this.mCameraSettings.mStrCameraID, this.mDeviceStateCallback, cameraHandler);
                if (this.mCameraDevice == null) {
                    waitCameraTaskDoneOrTimeout();
                }
            } catch (CameraAccessException e) {
                int iConvertExeptionToErrCode = convertExeptionToErrCode(e);
                e.printStackTrace();
                openCameraLock();
                return iConvertExeptionToErrCode;
            }
        } else {
            try {
                this.mCameraEvents.onCameraInfo(106, 0, "will start camera2", null);
                TECamera2PolicyAdapter.openCamera(cert, this.mCameraManager, this.mCameraSettings.mStrCameraID, this.mDeviceStateCallback, cameraHandler);
            } catch (CameraAccessException e2) {
                int iConvertExeptionToErrCode2 = convertExeptionToErrCode(e2);
                e2.printStackTrace();
                return iConvertExeptionToErrCode2;
            }
        }
        TETraceUtils.endSection();
        return 0;
    }

    public void _reset(Cert cert) {
        try {
            this.mMode.reset();
            this.mMode.closePreviewSession();
            if (this.mCameraDevice != null) {
                this.mCameraEvents.onCameraInfo(108, 0, "will close camera2", null);
                TECamera2PolicyAdapter.closeCamera(cert, this.mCameraDevice);
                this.mCameraEvents.onCameraInfo(109, 0, "did close camera2", null);
                this.mCameraDevice = null;
                this.mCameraEvents.onCameraClosed(2, this, this.mCameraDevice);
            }
        } catch (Throwable th) {
            TELogUtils.e(TAG, th.getMessage());
        }
        updateSessionState(0);
        this.mCameraCharacteristics = null;
        this.mCaptureRequest = null;
        this.openPrivacyCert = null;
        TECameraModeBase tECameraModeBase = this.mMode;
        if (tECameraModeBase == null || this.mCameraSettings.mMode != 2) {
            return;
        }
        ((TEARVideoMode) tECameraModeBase).closeARSession();
    }

    public int _startCapture() {
        TETraceUtils.beginSection("TECamera2-_startCapture");
        TECameraModeBase tECameraModeBase = this.mMode;
        if (tECameraModeBase == null) {
            stopRetryStartPreview();
            this.mCameraEvents.onPreviewError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "_startCapture : mode is null", this.mCameraDevice);
            return -1;
        }
        try {
            int iStartPreview = tECameraModeBase.startPreview();
            if (iStartPreview != 0) {
                openCameraLock();
                this.mCameraEvents.onPreviewError(this.mCameraSettings.mCameraType, iStartPreview, "_startCapture : something wrong", this.mCameraDevice);
            }
            TETraceUtils.endSection();
            return iStartPreview;
        } catch (Exception e) {
            int i = e instanceof CameraAccessException ? TECameraResult.TER_CAMERA_DEVICE_ERROR : e instanceof IllegalArgumentException ? TECameraResult.TER_CAMERA_SET_PARAMS_FAILED : e instanceof IllegalStateException ? TECameraResult.TER_CAMERA_DISCONNECTED : TECameraResult.TER_CAMERA_PREVIEW_FAILED;
            openCameraLock();
            e.printStackTrace();
            TECameraExceptionMonitor.monitorException(e);
            this.mCameraEvents.onPreviewError(this.mCameraSettings.mCameraType, i, "_startCapture : mode is null, err msg: " + e.getMessage(), this.mCameraDevice);
            return i;
        }
    }

    public int _stopCapture() {
        TECameraModeBase tECameraModeBase = this.mMode;
        if (tECameraModeBase == null) {
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "_stopCapture : mode is null", this.mCameraDevice);
            return -1;
        }
        try {
            tECameraModeBase.closePreviewSession();
            this.mCameraEvents.onPreviewStopped(2, 4, 0, "TECamera2 preview stoped", this.mCameraDevice);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_PREVIEW_FAILED, "Error:_stopCapture : mode is null", this.mCameraDevice);
            return -1;
        }
    }

    public void _switchCameraMode(int i) {
        if (this.mMode == null) {
            return;
        }
        _stopCapture();
        if (i == 0) {
            createVideoMode();
        } else if (i == 1) {
            TEImage2Mode tEImage2Mode = new TEImage2Mode(this, this.mContext, this.mCameraManager, this.mHandler);
            this.mMode = tEImage2Mode;
            tEImage2Mode.setPictureSizeCallback(this.mPictureSizeCallback);
            this.mMode.setPreviewSizeCallback(this.mPreviewSizeCallback);
            this.mMode.setFpsConfigCallback(this.mFpsConfigCallback);
        } else {
            this.mMode = new TEARVideoMode(this, this.mContext, this.mCameraManager, this.mHandler);
        }
        Handler cameraHandler = this.mCameraSettings.mUseSyncModeOnCamera2 ? this.mMode.getCameraHandler() : this.mHandler;
        TECameraModeBase tECameraModeBase = this.mMode;
        if (tECameraModeBase instanceof TEARVideoMode) {
            ((TEARVideoMode) tECameraModeBase).initArCore(this.mContext, cameraHandler);
        }
        try {
            TECameraSettings tECameraSettings = this.mCameraSettings;
            tECameraSettings.mStrCameraID = selectCamera(tECameraSettings.mFacing);
            TECameraSettings tECameraSettings2 = this.mCameraSettings;
            String str = tECameraSettings2.mStrCameraID;
            if (str == null) {
                return;
            }
            if (this.mMode.openCamera(str, tECameraSettings2.mRequiredCameraLevel) != 0) {
                return;
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
        this.mMode.setCameraDevice(this.mCameraDevice);
        _startCapture();
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void abortSession() {
        if (!_isDeviceReady()) {
            TELogUtils.e(TAG, "Device is not ready.");
            return;
        }
        TECameraModeBase tECameraModeBase = this.mMode;
        if (tECameraModeBase != null) {
            tECameraModeBase.abortSession();
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void cancelFocus() {
        TECameraModeBase tECameraModeBase;
        if (this.mSessionState == 1) {
            TELogUtils.d(TAG, "Camera is opening, ignore cancelAutoFocus operation.");
        } else if (_isDeviceReady() && (tECameraModeBase = this.mMode) != null) {
            tECameraModeBase.cancelFocus();
        } else {
            TELogUtils.e(TAG, "cancelFocus : camera is null.");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "cancelFocus : camera is null.", this.mCameraDevice);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void captureBurst(BurstRequest burstRequest, TECameraSettings.CaptureBufferFrameCallback captureBufferFrameCallback) {
        this.mMode.captureBurst(burstRequest, this.mNewFacing, captureBufferFrameCallback);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void checkIfEnableDeferredSurface() {
        boolean z;
        TECameraSettings tECameraSettings = this.mCameraSettings;
        if (tECameraSettings.mEnableCamera2DeferredSurface && tECameraSettings.mCameraType == 2 && tECameraSettings.mMode == 0) {
            z = true;
            if (!this.mDeviceProxy.isHardwareLevelSupported(this.mMode.mCameraCharacteristics, 1)) {
            }
        } else {
            z = false;
        }
        tECameraSettings.mEnableCamera2DeferredSurface = z;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void close(Cert cert) {
        TELogUtils.d(TAG, "close...");
        if (this.mSessionState == 1) {
            if (this.mIsCameraOpenCloseSyncEnable) {
                this.mIsRequestCloseIntent = true;
            }
        } else {
            _reset(cert);
            TECameraModeBase tECameraModeBase = this.mMode;
            if (tECameraModeBase != null) {
                tECameraModeBase.close();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:166:0x03f7 A[LOOP:0: B:164:0x03f1->B:166:0x03f7, LOOP_END] */
    @Override // com.ss.android.ttvecamera.TECameraBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void collectCameraCapabilities() {
        long j;
        JSONException jSONException;
        CameraAccessException cameraAccessException;
        String str;
        String[] strArr;
        int i;
        long j2;
        CameraExtensionCharacteristics cameraExtensionCharacteristics;
        Iterator<Integer> it;
        int i2;
        String str2 = "camera_id";
        TETraceUtils.beginSection("TECamera2-collectCameraCapabilities");
        if (!isNeedCollectCameraCapabilities()) {
            TETraceUtils.endSection();
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        HashMap map = new HashMap();
        if (this.mCameraManager != null) {
            try {
                this.mCameraCapabilitiesMap.putOpt("camera_id", this.mCameraSettings.mStrCameraID);
                TECameraHardware2Proxy tECameraHardware2Proxy = this.mDeviceProxy;
                if (tECameraHardware2Proxy != null) {
                    try {
                        CameraCharacteristics cameraCharacteristics = this.mMode.mCameraCharacteristics;
                        TECameraSettings tECameraSettings = this.mCameraSettings;
                        this.mCameraCapabilitiesMap.putOpt("camera_zoom_max_ability", Float.valueOf(tECameraHardware2Proxy.getMaxZoomValue(cameraCharacteristics, tECameraSettings.mCameraType, tECameraSettings.mCameraZoomLimitFactor)));
                    } catch (CameraAccessException e) {
                        cameraAccessException = e;
                        j = jCurrentTimeMillis;
                        TELogUtils.w(TAG, "Get Camera Capbilities failed!");
                        cameraAccessException.printStackTrace();
                    } catch (JSONException e2) {
                        jSONException = e2;
                        j = jCurrentTimeMillis;
                        jSONException.printStackTrace();
                    }
                }
                JSONArray jSONArray = new JSONArray();
                String[] cameraIdList = this.mCameraManager.getCameraIdList();
                int length = cameraIdList.length;
                int i3 = 0;
                while (i3 < length) {
                    String str3 = cameraIdList[i3];
                    JSONObject jSONObject = new JSONObject();
                    CameraCharacteristics cameraCharacteristics2 = this.mCameraManager.getCameraCharacteristics(str3);
                    if (cameraCharacteristics2 == null) {
                        str = str2;
                        j2 = jCurrentTimeMillis;
                        strArr = cameraIdList;
                        i = length;
                    } else {
                        jSONObject.putOpt(str2, str3);
                        str = str2;
                        jSONObject.putOpt("camera_facing", Integer.valueOf(((Integer) cameraCharacteristics2.get(CameraCharacteristics.LENS_FACING)).intValue() == 1 ? 0 : 1));
                        int[] iArr = (int[]) cameraCharacteristics2.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
                        if (iArr != null) {
                            ArrayList arrayList = new ArrayList();
                            int length2 = iArr.length;
                            strArr = cameraIdList;
                            int i4 = 0;
                            while (i4 < length2) {
                                arrayList.add(Integer.valueOf(iArr[i4]));
                                i4++;
                                iArr = iArr;
                            }
                            Iterator<Integer> it2 = TECameraCapabilityCollector.sCapabilityMetadataMap.keySet().iterator();
                            while (it2.hasNext()) {
                                Integer next = it2.next();
                                TECameraCapabilityCollector.Capability capability = TECameraCapabilityCollector.sCapabilityMetadataMap.get(next);
                                if (capability != null) {
                                    if (map.get(capability) == null) {
                                        it = it2;
                                        map.put(capability, new HashMap());
                                    } else {
                                        it = it2;
                                    }
                                    i2 = length;
                                    ((Map) map.get(capability)).put(str3, Boolean.valueOf(arrayList.contains(next)));
                                    if (capability.equals(TECameraCapabilityCollector.Capability.DEPTH_OUTPUT)) {
                                        jSONObject.putOpt("depth_out_put", Boolean.valueOf(arrayList.contains(next)));
                                    }
                                    if (capability.equals(TECameraCapabilityCollector.Capability.MANUAL_3A)) {
                                        jSONObject.put("manual_3A", arrayList.contains(next));
                                    }
                                    if (capability.equals(TECameraCapabilityCollector.Capability.LOGICAL_MULTI_CAMERA)) {
                                        jSONObject.put("logical_multi_Camera", arrayList.contains(next));
                                    }
                                } else {
                                    it = it2;
                                    i2 = length;
                                }
                                it2 = it;
                                length = i2;
                            }
                        } else {
                            strArr = cameraIdList;
                        }
                        i = length;
                        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics2.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                        if (streamConfigurationMap != null) {
                            Range<Integer>[] highSpeedVideoFpsRanges = streamConfigurationMap.getHighSpeedVideoFpsRanges();
                            if (highSpeedVideoFpsRanges == null || highSpeedVideoFpsRanges.length == 0) {
                                j2 = jCurrentTimeMillis;
                            } else {
                                TECameraCapabilityCollector.Capability capability2 = TECameraCapabilityCollector.Capability.HIGH_SPEED_VIDEO_FPS_RANGE;
                                if (map.get(capability2) == null) {
                                    map.put(capability2, new HashMap());
                                }
                                ((Map) map.get(capability2)).put(str3, Arrays.toString(highSpeedVideoFpsRanges));
                                JSONArray jSONArray2 = new JSONArray();
                                int length3 = highSpeedVideoFpsRanges.length;
                                int i5 = 0;
                                while (i5 < length3) {
                                    Range<Integer> range = highSpeedVideoFpsRanges[i5];
                                    Range<Integer>[] rangeArr = highSpeedVideoFpsRanges;
                                    JSONObject jSONObject2 = new JSONObject();
                                    int i6 = length3;
                                    j = jCurrentTimeMillis;
                                    try {
                                        jSONObject2.putOpt("high_fps_min", range.getLower());
                                        jSONObject2.putOpt("high_fps_max", range.getUpper());
                                        jSONArray2.put(jSONObject2);
                                        i5++;
                                        highSpeedVideoFpsRanges = rangeArr;
                                        length3 = i6;
                                        jCurrentTimeMillis = j;
                                    } catch (CameraAccessException e3) {
                                        e = e3;
                                        cameraAccessException = e;
                                        TELogUtils.w(TAG, "Get Camera Capbilities failed!");
                                        cameraAccessException.printStackTrace();
                                        while (r2.hasNext()) {
                                        }
                                        this.mCapabilityCollector.upload();
                                        long jCurrentTimeMillis2 = System.currentTimeMillis() - j;
                                        TELogUtils.i(TAG, "collectCameraCapabilities consume: " + jCurrentTimeMillis2);
                                        TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_COLLECT_CAPBILITIES_COST, jCurrentTimeMillis2);
                                        this.mHaveCollectedCapbilities = true;
                                        TETraceUtils.endSection();
                                    } catch (JSONException e4) {
                                        e = e4;
                                        jSONException = e;
                                        jSONException.printStackTrace();
                                        while (r2.hasNext()) {
                                        }
                                        this.mCapabilityCollector.upload();
                                        long jCurrentTimeMillis22 = System.currentTimeMillis() - j;
                                        TELogUtils.i(TAG, "collectCameraCapabilities consume: " + jCurrentTimeMillis22);
                                        TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_COLLECT_CAPBILITIES_COST, jCurrentTimeMillis22);
                                        this.mHaveCollectedCapbilities = true;
                                        TETraceUtils.endSection();
                                    }
                                }
                                j2 = jCurrentTimeMillis;
                                jSONObject.putOpt("high_speed_fps_range", jSONArray2);
                            }
                            Size[] outputSizes = streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
                            TECameraCapabilityCollector.Capability capability3 = TECameraCapabilityCollector.Capability.PREVIEW_SIZE;
                            if (map.get(capability3) == null) {
                                map.put(capability3, new HashMap());
                            }
                            ((Map) map.get(capability3)).put(str3, Arrays.toString(outputSizes));
                            JSONArray jSONArray3 = new JSONArray();
                            if (outputSizes != null && outputSizes.length > 0) {
                                int length4 = outputSizes.length;
                                int i7 = 0;
                                while (i7 < length4) {
                                    Size size = outputSizes[i7];
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.putOpt("width", Integer.valueOf(size.getWidth()));
                                    jSONObject3.putOpt("height", Integer.valueOf(size.getHeight()));
                                    jSONArray3.put(jSONObject3);
                                    i7++;
                                    outputSizes = outputSizes;
                                }
                                jSONObject.putOpt("preview_size_list", jSONArray3);
                            }
                        } else {
                            j2 = jCurrentTimeMillis;
                        }
                        Range[] rangeArr2 = (Range[]) cameraCharacteristics2.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
                        TECameraCapabilityCollector.Capability capability4 = TECameraCapabilityCollector.Capability.FPS_RANGE;
                        if (map.get(capability4) == null) {
                            map.put(capability4, new HashMap());
                        }
                        ((Map) map.get(capability4)).put(str3, Arrays.toString(rangeArr2));
                        JSONArray jSONArray4 = new JSONArray();
                        if (rangeArr2 != null && rangeArr2.length > 0) {
                            int length5 = rangeArr2.length;
                            int i8 = 0;
                            while (i8 < length5) {
                                Range range2 = rangeArr2[i8];
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.putOpt("fps_min", range2.getLower());
                                jSONObject4.putOpt("fps_high", range2.getUpper());
                                jSONArray4.put(jSONObject4);
                                i8++;
                                rangeArr2 = rangeArr2;
                            }
                            jSONObject.putOpt("fps_range_List", jSONArray4);
                        }
                        float[] fArr = (float[]) cameraCharacteristics2.get(CameraCharacteristics.LENS_INFO_AVAILABLE_APERTURES);
                        TECameraCapabilityCollector.Capability capability5 = TECameraCapabilityCollector.Capability.SUPPORT_APERTURES;
                        if (map.get(capability5) == null) {
                            map.put(capability5, new HashMap());
                        }
                        ((Map) map.get(capability5)).put(str3, Arrays.toString(fArr));
                        JSONArray jSONArray5 = new JSONArray();
                        if (fArr != null && fArr.length > 0) {
                            for (float f : fArr) {
                                jSONArray5.put(f);
                            }
                            jSONObject.putOpt("support_apertures", jSONArray5);
                        }
                        if (Build.VERSION.SDK_INT >= 31 && (cameraExtensionCharacteristics = this.mCameraManager.getCameraExtensionCharacteristics(str3)) != null) {
                            List supportedExtensions = cameraExtensionCharacteristics.getSupportedExtensions();
                            TECameraCapabilityCollector.Capability capability6 = TECameraCapabilityCollector.Capability.SUPPORT_EXTENSIONS;
                            if (map.get(capability6) == null) {
                                map.put(capability6, new HashMap());
                            }
                            if (supportedExtensions != null) {
                                ((Map) map.get(capability6)).put(str3, supportedExtensions.toString());
                                JSONArray jSONArray6 = new JSONArray();
                                if (supportedExtensions.size() > 0) {
                                    Iterator it3 = supportedExtensions.iterator();
                                    while (it3.hasNext()) {
                                        jSONArray6.put(((Integer) it3.next()).intValue());
                                    }
                                    jSONObject.putOpt("support_extensions", jSONArray6);
                                }
                            }
                        }
                        jSONArray.put(jSONObject);
                    }
                    i3++;
                    str2 = str;
                    cameraIdList = strArr;
                    length = i;
                    jCurrentTimeMillis = j2;
                }
                j = jCurrentTimeMillis;
                this.mCameraCapabilitiesMap.putOpt("camera_feature", jSONArray);
                if (Build.VERSION.SDK_INT >= 30) {
                    Set<Set> concurrentCameraIds = this.mCameraManager.getConcurrentCameraIds();
                    ArrayList arrayList2 = new ArrayList();
                    if (concurrentCameraIds != null) {
                        for (Set set : concurrentCameraIds) {
                            Iterator it4 = set.iterator();
                            boolean z = false;
                            boolean z2 = false;
                            while (it4.hasNext()) {
                                CameraCharacteristics cameraCharacteristics3 = this.mCameraManager.getCameraCharacteristics((String) it4.next());
                                if (cameraCharacteristics3 != null) {
                                    if (((Integer) cameraCharacteristics3.get(CameraCharacteristics.LENS_FACING)).intValue() == 1) {
                                        z2 = true;
                                    } else if (((Integer) cameraCharacteristics3.get(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
                                        z = true;
                                    }
                                }
                            }
                            if (z && z2) {
                                arrayList2.add(set);
                            }
                        }
                        TECameraCapabilityCollector.Capability capability7 = TECameraCapabilityCollector.Capability.FRONT_BACK_MULTICAM_COMBOS;
                        TECameraCapabilityCollector tECameraCapabilityCollector = this.mCapabilityCollector;
                        tECameraCapabilityCollector.addCapability(new TECameraCapabilityCollector.CapabilityDescription(capability7, tECameraCapabilityCollector.getDataType(capability7), arrayList2.toString()));
                        JSONArray jSONArray7 = new JSONArray();
                        if (arrayList2.size() > 0) {
                            Iterator it5 = arrayList2.iterator();
                            while (it5.hasNext()) {
                                jSONArray7.put((Set) it5.next());
                            }
                            this.mCameraCapabilitiesMap.putOpt("camera_front_back_multicam_combos", jSONArray7);
                        }
                    }
                }
            } catch (CameraAccessException e5) {
                e = e5;
                j = jCurrentTimeMillis;
            } catch (JSONException e6) {
                e = e6;
                j = jCurrentTimeMillis;
            }
        } else {
            j = jCurrentTimeMillis;
        }
        for (Map.Entry entry : map.entrySet()) {
            TECameraCapabilityCollector.Capability capability8 = (TECameraCapabilityCollector.Capability) entry.getKey();
            Object value = entry.getValue();
            TECameraCapabilityCollector tECameraCapabilityCollector2 = this.mCapabilityCollector;
            tECameraCapabilityCollector2.addCapability(new TECameraCapabilityCollector.CapabilityDescription(capability8, tECameraCapabilityCollector2.getDataType(capability8), value.toString()));
        }
        this.mCapabilityCollector.upload();
        long jCurrentTimeMillis222 = System.currentTimeMillis() - j;
        TELogUtils.i(TAG, "collectCameraCapabilities consume: " + jCurrentTimeMillis222);
        TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_COLLECT_CAPBILITIES_COST, jCurrentTimeMillis222);
        this.mHaveCollectedCapbilities = true;
        TETraceUtils.endSection();
    }

    public void createVideoMode() {
        TELogUtils.d(TAG, "create TEVideo2Mode");
        this.mMode = new TEVideo2Mode(this, this.mContext, this.mCameraManager, this.mHandler);
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void destroy() {
        super.destroy();
        removeFocusSettings();
        this.mGyro.destroy();
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void enableCaf() {
        TECameraModeBase tECameraModeBase;
        if (this.mSessionState == 1) {
            TELogUtils.d(TAG, "Camera is opening, ignore cancelAutoFocus operation.");
        } else if (_isDeviceReady() && (tECameraModeBase = this.mMode) != null) {
            tECameraModeBase.enableCaf();
        } else {
            TELogUtils.e(TAG, "enableCaf : camera is null.");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "enableCaf : camera is null.", this.mCameraDevice);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void enableMulticamZoom(boolean z) {
        TECameraModeBase tECameraModeBase = this.mMode;
        if (tECameraModeBase == null) {
            TELogUtils.e(TAG, "enableMulticamZoom failed, mode is null...");
        } else {
            tECameraModeBase.enableMulticamZoom(z);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public Bundle fillFeatures() {
        CameraCharacteristics cameraCharacteristics;
        TECameraHardware2Proxy tECameraHardware2Proxy;
        TETraceUtils.beginSection("TECamera2-fillFeatures");
        Bundle bundleFillFeatures = super.fillFeatures();
        if (bundleFillFeatures != null) {
            bundleFillFeatures.putParcelableArrayList(TECameraSettings.Features.SUPPORT_PREVIEW_SIZES, (ArrayList) getSupportedPreviewSizes());
            bundleFillFeatures.putParcelableArrayList(TECameraSettings.Features.SUPPORT_PICTURE_SIZES, (ArrayList) getSupportedPictureSizes());
            bundleFillFeatures.putParcelableArrayList(TECameraSettings.Features.CAMERA_SUPPORT_FPS_RANGE, (ArrayList) getSupportedFpsRanges());
            TECameraModeBase tECameraModeBase = this.mMode;
            if (tECameraModeBase != null && (cameraCharacteristics = tECameraModeBase.mCameraCharacteristics) != null && (tECameraHardware2Proxy = this.mDeviceProxy) != null) {
                bundleFillFeatures.putBoolean(TECameraSettings.Features.DEVICE_SUPPORT_MULTICAMERA_ZOOM, tECameraHardware2Proxy.isLogicalMultiCamSupported(cameraCharacteristics) && Build.VERSION.SDK_INT >= 30);
                bundleFillFeatures.putBoolean(TECameraSettings.Features.CAMERA_TORCH_SUPPORTED, this.mDeviceProxy.isTorchSupported(this.mMode.mCameraCharacteristics));
            }
            bundleFillFeatures.putInt(TECameraSettings.Features.DEVICE_SUPPORT_WIDE_ANGLE_MODE, isSupportWideAngle() ? 1 : 0);
        }
        TETraceUtils.endSection();
        return bundleFillFeatures;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void focusAtPoint(TEFocusSettings tEFocusSettings) {
        TECameraModeBase tECameraModeBase;
        TELogUtils.d(TAG, "setFocusAreas...");
        if (this.mSessionState != 3) {
            TELogUtils.w(TAG, "Camera is not previewing, ignore setFocusAreas operation.");
            tEFocusSettings.getFocusCallback().onFocus(0, this.mCameraSettings.mFacing, "Camera is not previewing, ignore setFocusAreas operation.");
            return;
        }
        if (!_isDeviceReady() || (tECameraModeBase = this.mMode) == null) {
            TELogUtils.e(TAG, "focusAtPoint : camera is null.");
            tEFocusSettings.getFocusCallback().onFocus(TECameraResult.TER_CAMERA_INTERNAL_ERROR, this.mCameraSettings.mFacing, "focusAtPoint : camera is null.");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "focusAtPoint : camera is null.", this.mCameraDevice);
        } else {
            int iFocusAtPoint = tECameraModeBase.focusAtPoint(tEFocusSettings);
            if (iFocusAtPoint != 0) {
                TELogUtils.e(TAG, "focusAtPoint : something wrong.");
                this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_FOCUS_FAILED, iFocusAtPoint, "focusAtPoint : something wrong.", this.mCameraDevice);
            }
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void forceCloseCamera(Cert cert) {
        super.forceCloseCamera(cert);
        TELogUtils.i(TAG, "force close camera: " + this.mCameraDevice);
        if (this.mCameraDevice != null) {
            TECamera2PolicyAdapter.closeCamera(cert, this.mCameraDevice);
            this.mCameraDevice = null;
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public float[] getApertureRange() {
        TECameraModeBase tECameraModeBase;
        TELogUtils.d(TAG, "getApertureRange...");
        if (this.mSessionState == 1) {
            TELogUtils.w(TAG, "Camera is opening, ignore getApertureRange operation.");
            return new float[]{-1.0f, -1.0f};
        }
        if (_isDeviceReady() && (tECameraModeBase = this.mMode) != null) {
            return tECameraModeBase.getApertureRange();
        }
        TELogUtils.w(TAG, "getApertureRange : camera is null.");
        this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "getApertureRange : camera is null.", this.mCameraDevice);
        return new float[]{-1.0f, -1.0f};
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public TEFrameSizei getBestPreviewSize(float f, TEFrameSizei tEFrameSizei) {
        if (this.mSessionState == 0 || this.mSessionState == 1) {
            TELogUtils.e(TAG, "Camera is not opened, ignore getBestPreviewSize operation.");
            return null;
        }
        TECameraModeBase tECameraModeBase = this.mMode;
        if (tECameraModeBase.mStreamConfigurationMap == null) {
            tECameraModeBase.mStreamConfigurationMap = (StreamConfigurationMap) tECameraModeBase.mCameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        }
        StreamConfigurationMap streamConfigurationMap = this.mMode.mStreamConfigurationMap;
        if (!StreamConfigurationMap.isOutputSupportedFor(SurfaceTexture.class)) {
            TELogUtils.e(TAG, "Output is not supported, ignore getBestPreviewSize operation.");
            return null;
        }
        Size[] outputSizes = streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
        ArrayList arrayList = new ArrayList();
        for (Size size : outputSizes) {
            arrayList.add(new TEFrameSizei(size.getWidth(), size.getHeight()));
        }
        TECameraBase.PreviewSizeCallBack previewSizeCallBack = this.mPreviewSizeCallback;
        TEFrameSizei previewSize = previewSizeCallBack != null ? previewSizeCallBack.getPreviewSize(arrayList) : null;
        return previewSize == null ? tEFrameSizei != null ? TECameraUtils.calcPreviewSize(arrayList, tEFrameSizei) : TECameraUtils.calcPreviewSizeByRadio(arrayList, f) : previewSize;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public JSONObject getCameraCapbilitiesForBytebench() {
        return this.mCameraCapabilitiesMap;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public int[] getCameraCaptureSize() {
        TECameraModeBase tECameraModeBase = this.mMode;
        if (tECameraModeBase == null) {
            return null;
        }
        return tECameraModeBase.getCameraCaptureSize();
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public int getCameraType() {
        return 2;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public float[] getFOV() {
        TECameraModeBase tECameraModeBase;
        TELogUtils.d(TAG, "getVFOV...");
        if (this.mSessionState == 1) {
            TELogUtils.d(TAG, "Camera is opening, ignore getVFOV operation.");
            return new float[]{-2.0f, -2.0f};
        }
        if (_isDeviceReady() && (tECameraModeBase = this.mMode) != null) {
            return tECameraModeBase.getFOV();
        }
        TELogUtils.e(TAG, "getFOV : camera is null.");
        this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "getFOV : camera is null.", this.mCameraDevice);
        return new float[]{-2.0f, -2.0f};
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public int getFlashMode() {
        TECameraModeBase tECameraModeBase = this.mMode;
        if (tECameraModeBase == null) {
            return -1;
        }
        return tECameraModeBase.getFlashMode();
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public int getFrameOrientation() {
        int deviceOrientation = this.mDeviceRotation;
        if (deviceOrientation < 0) {
            deviceOrientation = TECameraUtils.getDeviceOrientation(this.mContext);
        }
        this.mFacing = this.mNewFacing;
        CameraCharacteristics cameraCharacteristics = this.mCameraCharacteristics;
        int iIntValue = cameraCharacteristics != null ? ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue() : this.mCameraSettings.mRotation;
        if (this.mFacing == 1) {
            int i = (iIntValue + deviceOrientation) % 360;
            this.mCameraRotation = i;
            this.mCameraRotation = ((360 - i) + EffectConstants.ROTATION_DEGREES_180) % 360;
        } else {
            this.mCameraRotation = ((iIntValue - deviceOrientation) + 360) % 360;
        }
        return this.mCameraRotation;
    }

    public Gyro getGyro() {
        return this.mGyro;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public int getISO() {
        TECameraModeBase tECameraModeBase;
        TELogUtils.d(TAG, "getISO...");
        if (this.mSessionState == 1) {
            TELogUtils.w(TAG, "Camera is opening, ignore setISO operation.");
            return -1;
        }
        if (_isDeviceReady() && (tECameraModeBase = this.mMode) != null) {
            return tECameraModeBase.getISO();
        }
        TELogUtils.w(TAG, "getISO : camera is null.");
        this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "getISO : camera is null.", this.mCameraDevice);
        return -1;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public int[] getISORange() {
        TECameraModeBase tECameraModeBase;
        TELogUtils.d(TAG, "getISORange...");
        if (this.mSessionState == 1) {
            TELogUtils.w(TAG, "Camera is opening, ignore setWhileBalance operation.");
            return new int[]{-1, -1};
        }
        if (_isDeviceReady() && (tECameraModeBase = this.mMode) != null) {
            return tECameraModeBase.getISORange();
        }
        TELogUtils.w(TAG, "setWhileBalance : camera is null.");
        this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "setWhileBalance : camera is null.", this.mCameraDevice);
        return new int[]{-1, -1};
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public float getManualFocusAbility() {
        TECameraModeBase tECameraModeBase;
        if (this.mSessionState == 1) {
            TELogUtils.d(TAG, "Camera is opening, ignore getManualFocusAbility operation.");
            return -1.0f;
        }
        if (_isDeviceReady() && (tECameraModeBase = this.mMode) != null) {
            return tECameraModeBase.getManualFocusAbility();
        }
        TELogUtils.e(TAG, "getManualFocusAbility : camera is null.");
        this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "getManualFocusAbility : camera is null.", this.mCameraDevice);
        return -1.0f;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public int[] getPictureSize() {
        TECameraModeBase tECameraModeBase = this.mMode;
        if (tECameraModeBase != null) {
            return tECameraModeBase.getPictureSize();
        }
        TELogUtils.e(TAG, "get picture size failed, no mode...");
        return null;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public int[] getPreviewFps() {
        TECameraModeBase tECameraModeBase = this.mMode;
        if (tECameraModeBase == null) {
            return null;
        }
        return tECameraModeBase.getPreviewFps();
    }

    public int getSessionState() {
        return this.mSessionState;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public long[] getShutterTimeRange() {
        TECameraModeBase tECameraModeBase;
        TELogUtils.d(TAG, "getShutterTimeRange...");
        if (this.mSessionState == 1) {
            TELogUtils.w(TAG, "Camera is opening, ignore getShutterTimeRange operation.");
            return new long[]{-1, -1};
        }
        if (_isDeviceReady() && (tECameraModeBase = this.mMode) != null) {
            return tECameraModeBase.getShutterTimeRange();
        }
        TELogUtils.w(TAG, "getShutterTimeRange : camera is null.");
        this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "getShutterTimeRange : camera is null.", this.mCameraDevice);
        return new long[]{-1, -1};
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public List<TEFrameSizei> getSupportedPictureSizes() {
        CameraCharacteristics cameraCharacteristics;
        TECameraModeBase tECameraModeBase = this.mMode;
        if (tECameraModeBase == null || (cameraCharacteristics = tECameraModeBase.mCameraCharacteristics) == null) {
            TELogUtils.e(TAG, "getSupportedPictureSizes: camera is null.");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "getSupportedPictureSizes: camera is null.", this.mCameraDevice);
            return null;
        }
        if (this.mSupportedPictureSizes == null) {
            if (tECameraModeBase.mStreamConfigurationMap == null) {
                tECameraModeBase.mStreamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            }
            this.mSupportedPictureSizes = TECameraUtils.convertSizes(this.mMode.mStreamConfigurationMap.getOutputSizes(256));
        }
        return this.mSupportedPictureSizes;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public List<TEFrameSizei> getSupportedPreviewSizes() {
        CameraCharacteristics cameraCharacteristics;
        TECameraModeBase tECameraModeBase = this.mMode;
        if (tECameraModeBase == null || (cameraCharacteristics = tECameraModeBase.mCameraCharacteristics) == null) {
            TELogUtils.e(TAG, "getSupportedPreviewSizes: camera is null.");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "getSupportedPreviewSizes: camera is null.", this.mCameraDevice);
            return null;
        }
        if (this.mSupportedPreviewSizes == null) {
            if (tECameraModeBase.mStreamConfigurationMap == null) {
                tECameraModeBase.mStreamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            }
            this.mSupportedPreviewSizes = TECameraUtils.convertSizes(this.mMode.mStreamConfigurationMap.getOutputSizes(SurfaceTexture.class));
        }
        return this.mSupportedPreviewSizes;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public boolean isAutoExposureLockSupported() {
        TECameraModeBase tECameraModeBase;
        CameraCharacteristics cameraCharacteristics;
        Boolean bool;
        TELogUtils.i(TAG, "isAutoExposureLockSupported...");
        if (this.mSessionState == 1) {
            TELogUtils.w(TAG, "Camera is opening, ignore isAutoExposureLockSupported operation.");
            return false;
        }
        if (!_isDeviceReady() || (tECameraModeBase = this.mMode) == null || (cameraCharacteristics = tECameraModeBase.mCameraCharacteristics) == null) {
            TELogUtils.e(TAG, "isAutoExposureLockSupported : camera is null.");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "isAutoExposureLockSupported : camera is null.", this.mCameraDevice);
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23 && (bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_LOCK_AVAILABLE)) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public boolean isAutoFocusLockSupported() {
        return true;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public boolean isSupportWhileBalance() {
        return true;
    }

    public boolean isSupportWideAngle() {
        TECameraHardware2Proxy tECameraHardware2Proxy = this.mDeviceProxy;
        return tECameraHardware2Proxy != null && tECameraHardware2Proxy.isSupportWideAngle();
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public boolean isSupportedExposureCompensation() {
        TECameraModeBase tECameraModeBase;
        TELogUtils.i(TAG, "isSupportedExposureCompensation...");
        if (this.mSessionState == 1) {
            TELogUtils.w(TAG, "Camera is opening, ignore setExposureCompensation operation.");
            return false;
        }
        if (_isDeviceReady() && (tECameraModeBase = this.mMode) != null && tECameraModeBase.mCameraCharacteristics != null) {
            return this.mCameraSettings.mCameraECInfo.isSupportExposureCompensation();
        }
        TELogUtils.e(TAG, "isSupportedExposureCompensation : camera is null.");
        this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "isSupportedExposureCompensation : camera is null.", this.mCameraDevice);
        return false;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public boolean isTorchSupported() {
        TECameraModeBase tECameraModeBase;
        if (!_isDeviceReady() || (tECameraModeBase = this.mMode) == null || tECameraModeBase.mCameraCharacteristics == null) {
            TELogUtils.w(TAG, "Query torch info failed, you must open camera first.");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "Query torch info failed, you must open camera first.", this.mCameraDevice);
            return false;
        }
        if (this.mDeviceProxy == null) {
            TELogUtils.e(TAG, "DeviceProxy is null!");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_TORCH_FAILED, "", this.mCameraDevice);
            return false;
        }
        Bundle bundle = getFeatures().get(this.mCameraSettings.mStrCameraID);
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(TECameraSettings.Features.CAMERA_TORCH_SUPPORTED, false);
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public int open(int i, int i2, int i3, int i4, int i5, boolean z, Cert cert) {
        TELogUtils.d(TAG, "open...");
        TECameraSettings tECameraSettings = this.mCameraSettings;
        tECameraSettings.mFacing = i;
        TEFrameSizei tEFrameSizei = tECameraSettings.mPreviewSize;
        tEFrameSizei.width = i2;
        tEFrameSizei.height = i3;
        tECameraSettings.mFPSRange.max = i4;
        tECameraSettings.mRequiredCameraLevel = i5;
        return open(tECameraSettings, cert);
    }

    public void openCameraLock() {
        if (this.mCameraSettings.mUseSyncModeOnCamera2) {
            this.mCameraCondition.open();
            TELogUtils.i(TAG, "open camera-operation lock");
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void queryShaderZoomStep(TECameraSettings.ShaderZoomCallback shaderZoomCallback) {
        TECameraModeBase tECameraModeBase;
        CameraCharacteristics cameraCharacteristics;
        if (!_isDeviceReady() || (tECameraModeBase = this.mMode) == null || (cameraCharacteristics = tECameraModeBase.mCameraCharacteristics) == null) {
            TELogUtils.e(TAG, "queryShaderZoomStep: camera is null.");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "queryShaderZoomStep: camera is null.", this.mCameraDevice);
            return;
        }
        TECameraHardware2Proxy tECameraHardware2Proxy = this.mDeviceProxy;
        if (tECameraHardware2Proxy == null) {
            TELogUtils.e(TAG, "DeviceProxy is null!");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_ZOOM_FAILED, "", this.mCameraDevice);
        } else {
            float shaderZoomStep = tECameraHardware2Proxy.getShaderZoomStep(cameraCharacteristics);
            if (shaderZoomCallback != null) {
                shaderZoomCallback.getShaderStep(shaderZoomStep);
            }
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void queryZoomAbility(TECameraSettings.ZoomCallback zoomCallback, boolean z) {
        TECameraModeBase tECameraModeBase;
        CameraCharacteristics cameraCharacteristics;
        if (!_isDeviceReady() || (tECameraModeBase = this.mMode) == null || (cameraCharacteristics = tECameraModeBase.mCameraCharacteristics) == null) {
            TELogUtils.e(TAG, "queryZoomAbility: camera is null.");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "queryZoomAbility: camera is null.", this.mCameraDevice);
            return;
        }
        TECameraHardware2Proxy tECameraHardware2Proxy = this.mDeviceProxy;
        if (tECameraHardware2Proxy == null) {
            TELogUtils.e(TAG, "DeviceProxy is null!");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_ZOOM_FAILED, "", this.mCameraDevice);
            return;
        }
        TECameraSettings tECameraSettings = this.mCameraSettings;
        float maxZoomValue = tECameraHardware2Proxy.getMaxZoomValue(cameraCharacteristics, tECameraSettings.mCameraType, tECameraSettings.mCameraZoomLimitFactor);
        this.mMaxZoom = maxZoomValue;
        TELogUtils.d(TAG, "zoom: " + maxZoomValue + ", factor = " + this.mCameraSettings.mCameraZoomLimitFactor);
        if (zoomCallback != null) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(Integer.valueOf((int) (100.0f * maxZoomValue)));
            zoomCallback.onZoomSupport(this.mCameraSettings.mCameraType, maxZoomValue > 0.0f, false, maxZoomValue, arrayList);
        }
    }

    public void removeFocusSettings() {
        TECameraModeBase tECameraModeBase = this.mMode;
        if (tECameraModeBase != null) {
            tECameraModeBase.removeFocusSettings();
        }
    }

    public String selectCamera(@TECameraSettings.CameraFacing int i) throws CameraAccessException {
        return this.mMode.selectCamera(this.mCameraSettings.mFacing);
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void setAperture(float f) {
        TECameraModeBase tECameraModeBase;
        TELogUtils.d(TAG, "setAperture : " + f);
        if (this.mSessionState == 1) {
            TELogUtils.w(TAG, "Camera is opening, ignore setAperture operation.");
        } else if (_isDeviceReady() && (tECameraModeBase = this.mMode) != null) {
            tECameraModeBase.setAperture(f);
        } else {
            TELogUtils.w(TAG, "setAperture : camera is null.");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "setAperture : camera is null.", this.mCameraDevice);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void setAutoExposureLock(boolean z) {
        TECameraModeBase tECameraModeBase;
        CameraCharacteristics cameraCharacteristics;
        TELogUtils.i(TAG, "setAutoExposureLock...");
        if (this.mSessionState == 1) {
            TELogUtils.w(TAG, "Camera is opening, ignore setAutoExposureLock operation.");
            return;
        }
        if (!_isDeviceReady() || (tECameraModeBase = this.mMode) == null || (cameraCharacteristics = tECameraModeBase.mCameraCharacteristics) == null) {
            TELogUtils.e(TAG, "setAutoExposureLock : camera is null.");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "setAutoExposureLock : camera is null.", this.mCameraDevice);
            return;
        }
        if (Build.VERSION.SDK_INT < 23) {
            TELogUtils.w(TAG, "Current camera doesn't support auto exposure lock.");
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_AE_LOCK_NO_SUPPORT, TECameraResult.TER_CAMERA_AE_LOCK_NO_SUPPORT, "Current camera doesn't support auto exposure lock.", this.mCameraDevice);
            return;
        }
        Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_LOCK_AVAILABLE);
        if (bool != null && bool.booleanValue()) {
            this.mMode.setAutoExposureLock(z);
        } else {
            TELogUtils.w(TAG, "Current camera doesn't support auto exposure lock.");
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_AE_LOCK_NO_SUPPORT, TECameraResult.TER_CAMERA_AE_LOCK_NO_SUPPORT, "Current camera doesn't support auto exposure lock.", this.mCameraDevice);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void setAutoFocusLock(boolean z) {
        TECameraModeBase tECameraModeBase;
        TELogUtils.i(TAG, "setAutoFocusLock...");
        if (this.mSessionState == 1) {
            TELogUtils.w(TAG, "Camera is opening, ignore setAutoFocusLock operation.");
            return;
        }
        if (_isDeviceReady() && (tECameraModeBase = this.mMode) != null && tECameraModeBase.mCameraCharacteristics != null) {
            tECameraModeBase.setAutoFocusLock(z);
        } else {
            TELogUtils.e(TAG, "setAutoFocusLock : camera is null.");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "setAutoFocusLock : camera is null.", this.mCameraDevice);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public boolean setExposureCompensation(int i) {
        TECameraModeBase tECameraModeBase;
        TELogUtils.i(TAG, "setExposureCompensation... value: " + i);
        if (this.mSessionState == 1) {
            TELogUtils.w(TAG, "Camera is opening, ignore setExposureCompensation operation.");
            return false;
        }
        if (!_isDeviceReady() || (tECameraModeBase = this.mMode) == null || tECameraModeBase.mCameraCharacteristics == null) {
            TELogUtils.e(TAG, "setExposureCompensation : camera is null.");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_OPEN_FAILED, "setExposureCompensation : camera is null.", this.mCameraDevice);
            return false;
        }
        if (!this.mCameraSettings.mCameraECInfo.isSupportExposureCompensation()) {
            TELogUtils.w(TAG, "Current camera doesn't support setting exposure compensation.");
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_EC_NOT_SUPPORT, TECameraResult.TER_CAMERA_EC_NOT_SUPPORT, "Current camera doesn't support setting exposure compensation.", this.mCameraDevice);
            return false;
        }
        TECameraSettings.ExposureCompensationInfo exposureCompensationInfo = this.mCameraSettings.mCameraECInfo;
        if (i <= exposureCompensationInfo.max && i >= exposureCompensationInfo.min) {
            return this.mMode.setExposureCompensation(i);
        }
        String str = "Invalid exposure compensation value: " + i + ", it must between [" + this.mCameraSettings.mCameraECInfo.min + ", " + this.mCameraSettings.mCameraECInfo.max + "].";
        TELogUtils.w(TAG, str);
        this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_EC_OUT_OF_RANGE, TECameraResult.TER_CAMERA_EC_OUT_OF_RANGE, str, this.mCameraDevice);
        return false;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void setFeatureParameters(Bundle bundle) {
        super.setFeatureParameters(bundle);
        if (bundle == null) {
            return;
        }
        Bundle bundle2 = this.mFeatures.get(this.mCameraSettings.mStrCameraID);
        for (String str : bundle.keySet()) {
            if (TECameraSettings.Parameters.isValid(str, bundle.get(str)) && TECameraSettings.Features.SUPPORT_LIGHT_SOFT.equalsIgnoreCase(str)) {
                bundle2.putBoolean(TECameraSettings.Features.SUPPORT_LIGHT_SOFT, bundle.getBoolean(TECameraSettings.Features.SUPPORT_LIGHT_SOFT));
            }
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void setISO(int i) {
        TECameraModeBase tECameraModeBase;
        TELogUtils.d(TAG, "setISO : " + i);
        if (this.mSessionState == 1) {
            TELogUtils.w(TAG, "Camera is opening, ignore setISO operation.");
        } else if (_isDeviceReady() && (tECameraModeBase = this.mMode) != null) {
            tECameraModeBase.setISO(i);
        } else {
            TELogUtils.w(TAG, "setISO : camera is null.");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "setISO : camera is null.", this.mCameraDevice);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void setManualFocusDistance(float f) {
        TECameraModeBase tECameraModeBase;
        if (this.mSessionState == 1) {
            TELogUtils.d(TAG, "Camera is opening, ignore setManualFocusDistance operation.");
        } else if (_isDeviceReady() && (tECameraModeBase = this.mMode) != null) {
            tECameraModeBase.setManualFocusDistance(f);
        } else {
            TELogUtils.e(TAG, "setManualFocusDistance : camera is null.");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "setManualFocusDistance : camera is null.", this.mCameraDevice);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void setPictureSize(int i, int i2) {
        TECameraModeBase tECameraModeBase = this.mMode;
        if (tECameraModeBase == null) {
            TELogUtils.e(TAG, "set picture size failed, no mode...");
        } else {
            tECameraModeBase.setPictureSize(i, i2);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void setSceneMode(int i) {
        super.setSceneMode(i);
        TECameraModeBase tECameraModeBase = this.mMode;
        if (tECameraModeBase == null) {
            TELogUtils.e(TAG, "set scene failed, no mode...");
        } else {
            tECameraModeBase.setSceneMode(i);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void setShutterTime(long j) {
        TECameraModeBase tECameraModeBase;
        TELogUtils.d(TAG, "setShutterTime : " + j);
        if (this.mSessionState == 1) {
            TELogUtils.w(TAG, "Camera is opening, ignore setShutterTime operation.");
        } else if (_isDeviceReady() && (tECameraModeBase = this.mMode) != null) {
            tECameraModeBase.setShutterTime(j);
        } else {
            TELogUtils.w(TAG, "setISO : camera is null.");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "setISO : camera is null.", this.mCameraDevice);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void setWhileBalance(boolean z, String str) {
        TECameraModeBase tECameraModeBase;
        TELogUtils.d(TAG, "setWhileBalance: " + str);
        if (this.mSessionState == 1) {
            TELogUtils.w(TAG, "Camera is opening, ignore setWhileBalance operation.");
        } else if (_isDeviceReady() && (tECameraModeBase = this.mMode) != null) {
            tECameraModeBase.setWhileBalance(z, str);
        } else {
            TELogUtils.w(TAG, "setWhileBalance : camera is null.");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "setWhileBalance : camera is null.", this.mCameraDevice);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void startCapture() {
        TETraceUtils.beginSection("TECamera2-startCapture");
        TELogUtils.d(TAG, "startCapture...");
        if (!_isDeviceReady() || this.mProviderMgr == null) {
            TELogUtils.e(TAG, "startCapture, Device is not ready.");
            return;
        }
        if (this.mSessionState != 2 && this.mSessionState != 3) {
            TELogUtils.e(TAG, "startCapture, Invalid state: " + this.mSessionState);
            return;
        }
        try {
            this.mCameraSettings.mRotation = getFrameOrientation();
            TELogUtils.i(TAG, "Camera rotation = " + this.mCameraSettings.mRotation);
        } catch (Exception e) {
            TECameraExceptionMonitor.monitorException(e);
            _reset(this.openPrivacyCert);
            TECameraBase.CameraEvents cameraEvents = this.mCameraEvents;
            if (cameraEvents != null) {
                cameraEvents.onCameraOpened(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_PREVIEW_FAILED, null, this.mCameraDevice);
            }
        }
        _startCapture();
        TETraceUtils.endSection();
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public int startRecording() {
        return this.mMode.startRecording();
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void startZoom(float f, TECameraSettings.ZoomCallback zoomCallback) {
        TECameraModeBase tECameraModeBase;
        if (this.mSessionState != 3) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: START_ZOOM. Code: -420. Reason: session is not running");
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_ZOOM_FAILED, TECameraResult.TER_CAMERA_ZOOM_FAILED, "Invalid state, state = " + this.mSessionState, this.mCameraDevice);
            return;
        }
        if (_isDeviceReady() && (tECameraModeBase = this.mMode) != null) {
            tECameraModeBase.startZoom(f, zoomCallback);
        } else {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: START_ZOOM. Code: -439. Reason: camera is null");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "startZoom : Camera is null.", this.mCameraDevice);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void stopCapture() {
        TELogUtils.i(TAG, "stopCapture...");
        if (!_isDeviceReady()) {
            TELogUtils.e(TAG, "Device is not ready.");
            return;
        }
        if (this.mSessionState != 3) {
            TELogUtils.e(TAG, "Invalid state: " + this.mSessionState);
        }
        _stopCapture();
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public int stopRecording() {
        return this.mMode.stopRecording();
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void switchCameraMode(int i) {
        if (this.mSessionState == 3) {
            _switchCameraMode(i);
            return;
        }
        TELogUtils.w(TAG, "Invalid state: " + this.mSessionState);
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void switchFlashMode(int i) {
        TECameraModeBase tECameraModeBase;
        TELogUtils.d(TAG, "switchFlashMode: " + i);
        if (this.mSessionState == 1) {
            TECameraModeBase tECameraModeBase2 = this.mMode;
            if (tECameraModeBase2 != null && (tECameraModeBase2 instanceof TEImage2Mode)) {
                ((TEImage2Mode) tECameraModeBase2).updateFlashModeParam(i);
                return;
            }
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: TOGGLE_TORCH. Code: -439. Reason: camera is opening, ignore toggleTorch operation");
            TELogUtils.w(TAG, "Camera is opening, ignore toggleTorch operation.");
            this.mCameraEvents.onTorchError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, i == 0 ? 0 : 1, "Camera is opening, ignore toggleTorch operation.", this.mCameraDevice);
            return;
        }
        if (_isDeviceReady() && (tECameraModeBase = this.mMode) != null) {
            tECameraModeBase.switchFlashMode(i);
            return;
        }
        TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: TOGGLE_TORCH. Code: -439. Reason: camera is null");
        TELogUtils.e(TAG, "switch flash mode  failed, you must open camera first.");
        this.mCameraEvents.onTorchError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, i == 0 ? 0 : 1, "switch flash mode  failed, you must open camera first.", this.mCameraDevice);
        this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "switch flash mode  failed, you must open camera first.", this.mCameraDevice);
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void takePicture(int i, int i2, TECameraSettings.PictureCallback pictureCallback) {
        TECameraModeBase tECameraModeBase;
        if (this.mSessionState == 1) {
            TELogUtils.d(TAG, "Camera is opening, ignore takePicture operation.");
            return;
        }
        if (this.mSessionState == 2) {
            TELogUtils.d(TAG, "Camera is opened, ignore takePicture operation.");
        } else if (_isDeviceReady() && (tECameraModeBase = this.mMode) != null) {
            tECameraModeBase.takePicture(i, i2, pictureCallback);
        } else {
            TELogUtils.e(TAG, "takePicture : camera is null.");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "takePicture : camera is null.", this.mCameraDevice);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void toggleTorch(boolean z) {
        TECameraModeBase tECameraModeBase;
        TELogUtils.d(TAG, "toggleTorch: " + z);
        if (this.mSessionState == 1) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: TOGGLE_TORCH. Code: -439. Reason: camera is opening, ignore toggleTorch operation");
            TELogUtils.d(TAG, "Camera is opening, ignore toggleTorch operation.");
            this.mCameraEvents.onTorchError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, z ? 1 : 0, "Camera is opening, ignore toggleTorch operation.", this.mCameraDevice);
        } else {
            if (_isDeviceReady() && (tECameraModeBase = this.mMode) != null) {
                tECameraModeBase.toggleTorch(z);
                return;
            }
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: TOGGLE_TORCH. Code: -439. Reason: camera is null");
            TELogUtils.w(TAG, "Toggle torch failed, you must open camera first.");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "Toggle torch failed, you must open camera first.", this.mCameraDevice);
            this.mCameraEvents.onTorchError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, z ? 1 : 0, "Toggle torch failed, you must open camera first.", this.mCameraDevice);
        }
    }

    public void updateSessionState(int i) {
        if (this.mSessionState == i) {
            TELogUtils.w(TAG, "No need update state: " + i);
            return;
        }
        TELogUtils.i(TAG, "[updateSessionState]: " + this.mSessionState + " -> " + i);
        this.mSessionState = i;
    }

    public void waitCameraTaskDoneOrTimeout() {
        if (this.mCameraSettings.mUseSyncModeOnCamera2) {
            this.mCameraCondition.close();
            TELogUtils.i(TAG, "block camera-operation start...");
            TELogUtils.i(TAG, "block camera-operation end...result = " + this.mCameraCondition.block(1000L));
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void zoomV2(float f, TECameraSettings.ZoomCallback zoomCallback) {
        TECameraModeBase tECameraModeBase;
        if (this.mSessionState != 3) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: START_ZOOM. Code: -420. Reason: session is not running");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_ZOOM_FAILED, "Invalid state, state = " + this.mSessionState, this.mCameraDevice);
            return;
        }
        if (_isDeviceReady() && (tECameraModeBase = this.mMode) != null) {
            tECameraModeBase.zoomV2(f, zoomCallback);
        } else {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: START_ZOOM. Code: -439. Reason: camera is null");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "zoomV2 : Camera is null.", this.mCameraDevice);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public int open(TECameraSettings tECameraSettings, Cert cert) {
        int iConvertExeptionToErrCode;
        TETraceUtils.beginSection("TECamera2-open");
        super.open(tECameraSettings, cert);
        this.openPrivacyCert = cert;
        this.mCameraSettings = tECameraSettings;
        if (this.mSessionState == 4) {
            _reset(cert);
        }
        try {
            updateSessionState(1);
            int i_open = _open(cert);
            this.mNewFacing = tECameraSettings.mFacing;
            TELogUtils.i(TAG, "open: camera face = " + this.mNewFacing + ", ret: " + i_open);
            if (i_open != 0) {
                updateSessionState(0);
                _reset(cert);
                TECameraBase.CameraEvents cameraEvents = this.mCameraEvents;
                if (cameraEvents == null) {
                    return -1;
                }
                cameraEvents.onCameraOpened(tECameraSettings.mCameraType, i_open, null, this.mCameraDevice);
                return -1;
            }
            this.mIsCameraOpenCloseSyncEnable = tECameraSettings.mIsCameraOpenCloseSync;
            TETraceUtils.endSection();
            return 0;
        } catch (Throwable th) {
            TELogUtils.e(TAG, "open: camera face = " + this.mNewFacing + " failed: " + th.getMessage());
            if (th instanceof CameraAccessException) {
                iConvertExeptionToErrCode = convertExeptionToErrCode(th);
            } else if (th instanceof IllegalArgumentException) {
                iConvertExeptionToErrCode = TECameraResult.TER_CAMERA_INVALID_CAMERA_ID;
            } else {
                iConvertExeptionToErrCode = th instanceof SecurityException ? TECameraResult.TER_CAMERA_DISABLED : TECameraResult.TER_CAMERA_OPEN_FAILED;
            }
            updateSessionState(4);
            _reset(cert);
            TECameraBase.CameraEvents cameraEvents2 = this.mCameraEvents;
            if (cameraEvents2 != null) {
                cameraEvents2.onCameraOpened(tECameraSettings.mCameraType, iConvertExeptionToErrCode, null, this.mCameraDevice);
            }
            return iConvertExeptionToErrCode;
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void takePicture(TECameraSettings.PictureCallback pictureCallback) {
        TECameraModeBase tECameraModeBase;
        if (this.mSessionState == 1) {
            TELogUtils.d(TAG, "Camera is opening, ignore takePicture operation.");
            return;
        }
        if (this.mSessionState == 2) {
            TELogUtils.d(TAG, "Camera is opened, ignore takePicture operation.");
        } else if (_isDeviceReady() && (tECameraModeBase = this.mMode) != null) {
            tECameraModeBase.takePicture(pictureCallback, this.mNewFacing);
        } else {
            TELogUtils.e(TAG, "takePicture : camera is null.");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "takePicture : camera is null.", this.mCameraDevice);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void stopZoom(TECameraSettings.ZoomCallback zoomCallback) {
    }
}
