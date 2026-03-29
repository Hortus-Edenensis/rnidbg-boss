package com.ss.android.ttvecamera.framework;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import android.util.SizeF;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.ss.android.ttvecamera.TECamera2;
import com.ss.android.ttvecamera.TECameraBase;
import com.ss.android.ttvecamera.TECameraConfigKey;
import com.ss.android.ttvecamera.TECameraFrame;
import com.ss.android.ttvecamera.TECameraMonitor;
import com.ss.android.ttvecamera.TECameraResult;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ttvecamera.TEFocusParameters;
import com.ss.android.ttvecamera.TEFocusSettings;
import com.ss.android.ttvecamera.TEFrameRateRange;
import com.ss.android.ttvecamera.TEFrameSizei;
import com.ss.android.ttvecamera.TELogUtils;
import com.ss.android.ttvecamera.TETraceUtils;
import com.ss.android.ttvecamera.focusmanager.Gyro;
import com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy;
import com.ss.android.ttvecamera.focusmanager.TEFocusStrategyBase;
import com.ss.android.ttvecamera.hardware.TECameraHardware2;
import com.ss.android.ttvecamera.hardware.TECameraHardware2Proxy;
import com.ss.android.ttvecamera.hardware.TECameraSSProxy;
import com.ss.android.ttvecamera.model.BurstRequest;
import com.ss.android.ttvecamera.provider.TECameraProviderManager;
import defpackage.cs5;
import defpackage.ds5;
import defpackage.es5;
import defpackage.is5;
import defpackage.xr5;
import defpackage.yr5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@RequiresApi(api = 21)
public abstract class TECameraModeBase implements ITECameraMode, ITEFocusStrategy.NormalCallbackRequest {
    public static final String TAG = "TECameraModeBase";
    protected boolean ifFinalize;
    private Rect mActiveArraySize;
    public CameraCharacteristics mCameraCharacteristics;
    protected CameraDevice mCameraDevice;
    protected TECameraBase.CameraEvents mCameraEvents;
    protected TECamera2 mCameraHolder;
    protected boolean mCameraLightOn;
    protected CameraManager mCameraManager;
    protected volatile CameraCaptureSession mCameraSession;
    protected TECameraSettings mCameraSettings;
    public CaptureRequest mCaptureRequest;
    protected CaptureRequest.Builder mCaptureRequestBuilder;
    protected int mCurrentIso;
    protected TECameraHardware2Proxy mDeviceProxy;
    protected int[] mFaceDetectSupportMode;
    protected TEFocusSettings mFocusSettings;
    protected TEFocusStrategyBase mFocusStrategy;
    protected TECameraBase.CameraFpsConfigCallback mFpsConfigCallback;
    protected Handler mHandler;
    protected TECameraBase.PictureSizeCallBack mPictureSizeCallback;
    protected TECameraBase.SATZoomCallback mSATZoomCallback;
    public StreamConfigurationMap mStreamConfigurationMap = null;
    protected AtomicBoolean mManualFocusEngaged = new AtomicBoolean(false);
    protected float mMaxZoom = 0.0f;
    protected float mNowZoom = 1.0f;
    protected Range<Float> mZoomRatioRange = null;
    protected int mExposureCompensation = 0;
    protected Rect mZoomSize = null;
    protected TECameraBase.PreviewSizeCallBack mPreviewSizeCallback = null;
    protected int mUseFaceAE = 0;
    protected CaptureRequest.Key<?> mFaceForce3aModesRequestKey = null;
    protected TEFrameRateRange mFpsRange = new TEFrameRateRange(7, 30);
    protected Handler mCameraThreadHandler = null;
    private HandlerThread mCameraThread = null;
    protected volatile boolean mIsFirstPreviewFrameArrived = false;
    protected long mCreateSessionStartTimestamp = 0;
    protected long mCreateSessionConsume = 0;
    protected long mFirstRepeatingRequestStartTimestamp = 0;
    protected int mPreviewCapturedFailedCount = 0;
    private boolean mEnableMulticamZoom = false;
    protected volatile boolean mIsActiveCameraSession = false;
    private Map<String, Integer> mWhiteBalanceMap = new HashMap<String, Integer>() { // from class: com.ss.android.ttvecamera.framework.TECameraModeBase.1
        {
            put("auto", 1);
            put(TECameraSettings.WHITE_BALANCE_INCANDESCENT, 2);
            put(TECameraSettings.WHITE_BALANCE_FLUORESCENT, 3);
            put(TECameraSettings.WHITE_BALANCE_WARM_FLUORESCENT, 4);
            put(TECameraSettings.WHITE_BALANCE_DAYLIGHT, 5);
            put(TECameraSettings.WHITE_BALANCE_CLOUDY_DAYLIGHT, 6);
            put(TECameraSettings.WHITE_BALANCE_TWILIGHT, 7);
            put(TECameraSettings.WHITE_BALANCE_SHADE, 8);
        }
    };
    protected HashMap<Integer, String> mCameraDevicesCache = new HashMap<>();
    protected boolean mIsSessionFinalized = false;
    protected boolean mIsSurfaceReady = false;
    protected List<OutputConfiguration> mOutputConfigurations = new ArrayList();
    private Runnable mFocusCancelRunnable = new Runnable() { // from class: com.ss.android.ttvecamera.framework.TECameraModeBase.3
        @Override // java.lang.Runnable
        public void run() {
            TECameraModeBase.this.mFocusStrategy.cancelFocus();
        }
    };
    private final Gyro.GyroListener mGyroListener = new Gyro.GyroListener() { // from class: com.ss.android.ttvecamera.framework.TECameraModeBase.4
        @Override // com.ss.android.ttvecamera.focusmanager.Gyro.GyroListener
        public void onChange() {
            TECamera2 tECamera2;
            TECameraModeBase tECameraModeBase = TECameraModeBase.this;
            if (tECameraModeBase.mCameraSettings.mEnableMonitorGyroscope && (tECamera2 = tECameraModeBase.mCameraHolder) != null && tECamera2.getSessionState() == 3) {
                TELogUtils.i(TECameraModeBase.TAG, "gyro onChange set focus mode to continuous focus.");
                TECameraModeBase.this.rollbackMeteringSessionRequest();
                TECameraModeBase.this.rollbackNormalSessionRequest();
                if (TECameraModeBase.this.mCameraHolder.getGyro() != null) {
                    TECameraModeBase.this.mCameraHolder.getGyro().unregister(TECameraModeBase.this.mGyroListener);
                }
            }
        }
    };
    protected CameraCaptureSession.StateCallback mSessionStateCallback = new CameraCaptureSession.StateCallback() { // from class: com.ss.android.ttvecamera.framework.TECameraModeBase.5
        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
            TELogUtils.e(TECameraModeBase.TAG, "onConfigureFailed...");
            TECameraModeBase.this.openCameraLock();
            TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA2_CREATE_SESSION_RET, 0L);
            TELogUtils.logMonitorInfo(TECameraMonitor.TE_RECORD_CAMERA2_CREATE_SESSION_RET, 0);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00cb -> B:39:0x00d3). Please report as a decompilation issue!!! */
        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            TETraceUtils.beginSection("TECameraModeBase-onConfigured");
            long jCurrentTimeMillis = System.currentTimeMillis();
            TECameraModeBase tECameraModeBase = TECameraModeBase.this;
            long j = jCurrentTimeMillis - tECameraModeBase.mCreateSessionStartTimestamp;
            tECameraModeBase.mCreateSessionConsume = j;
            tECameraModeBase.mFirstRepeatingRequestStartTimestamp = jCurrentTimeMillis;
            tECameraModeBase.mIsFirstPreviewFrameArrived = false;
            TECameraModeBase.this.mCameraSession = cameraCaptureSession;
            TECameraModeBase tECameraModeBase2 = TECameraModeBase.this;
            if (tECameraModeBase2.mCameraSettings.mEnableCamera2DeferredSurface && Build.VERSION.SDK_INT >= 28) {
                try {
                    if (!tECameraModeBase2.mIsSurfaceReady && tECameraModeBase2.mCameraHolder.getProviderManager() != null && TECameraModeBase.this.mCameraHolder.getProviderManager().getPreviewSurface() != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(TECameraModeBase.this.mCameraHolder.getProviderManager().getPreviewSurface());
                        for (int i = 0; i < arrayList.size(); i++) {
                            is5.a(TECameraModeBase.this.mOutputConfigurations.get(i)).addSurface((Surface) arrayList.get(i));
                            TECameraModeBase.this.mIsSurfaceReady = true;
                        }
                    }
                    TECameraModeBase tECameraModeBase3 = TECameraModeBase.this;
                    if (!tECameraModeBase3.mIsSessionFinalized && tECameraModeBase3.mIsSurfaceReady) {
                        tECameraModeBase3.mCameraSession.finalizeOutputConfigurations(TECameraModeBase.this.mOutputConfigurations);
                        TECameraModeBase.this.mIsSessionFinalized = true;
                        TELogUtils.d(TECameraModeBase.TAG, "finalizeOutputConfigurations in session onConfigured");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            TECameraModeBase tECameraModeBase4 = TECameraModeBase.this;
            if (!tECameraModeBase4.mCameraSettings.mEnableCamera2DeferredSurface || tECameraModeBase4.mIsSessionFinalized) {
                try {
                    final int iUpdateCapture = tECameraModeBase4.updateCapture();
                    if (iUpdateCapture != 0) {
                        TECameraModeBase.this.openCameraLock();
                        Runnable runnable = new Runnable() { // from class: com.ss.android.ttvecamera.framework.TECameraModeBase.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                TECameraModeBase tECameraModeBase5 = TECameraModeBase.this;
                                tECameraModeBase5.mCameraEvents.onCameraError(tECameraModeBase5.mCameraSettings.mCameraType, iUpdateCapture, "updateCapture : something wrong.", tECameraModeBase5.mCameraDevice);
                            }
                        };
                        TECameraModeBase tECameraModeBase5 = TECameraModeBase.this;
                        if (tECameraModeBase5.mCameraSettings.mUseSyncModeOnCamera2) {
                            tECameraModeBase5.mHandler.post(runnable);
                        } else {
                            runnable.run();
                        }
                    }
                } catch (Exception e2) {
                    TECameraModeBase.this.openCameraLock();
                    e2.printStackTrace();
                }
            }
            TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA2_CREATE_SESSION_RET, 1L);
            TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA2_CREATE_SESSION_COST, j);
            TELogUtils.logMonitorInfo(TECameraMonitor.TE_RECORD_CAMERA2_CREATE_SESSION_RET, 1);
            TELogUtils.logMonitorInfo(TECameraMonitor.TE_RECORD_CAMERA2_CREATE_SESSION_COST, Long.valueOf(j));
            TETraceUtils.endSection();
        }
    };
    protected CameraCaptureSession.CaptureCallback mPreviewCaptureCallback = new CameraCaptureSession.CaptureCallback() { // from class: com.ss.android.ttvecamera.framework.TECameraModeBase.6
        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
            if (totalCaptureResult != null) {
                TECameraModeBase.this.mCurrentIso = totalCaptureResult.get(CaptureResult.SENSOR_SENSITIVITY) == null ? -1 : ((Integer) totalCaptureResult.get(CaptureResult.SENSOR_SENSITIVITY)).intValue();
            }
            if (!TECameraModeBase.this.mIsFirstPreviewFrameArrived) {
                TECameraModeBase.this.openCameraLock();
                TECameraModeBase.this.mIsFirstPreviewFrameArrived = true;
                long jCurrentTimeMillis = System.currentTimeMillis() - TECameraModeBase.this.mFirstRepeatingRequestStartTimestamp;
                TELogUtils.i(TECameraModeBase.TAG, "first preview frame callback arrived! consume = " + jCurrentTimeMillis + ", session consume: " + TECameraModeBase.this.mCreateSessionConsume);
                TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_2_SET_REPEATING_REQUEST_COST, jCurrentTimeMillis);
                TELogUtils.logMonitorInfo(TECameraMonitor.TE_RECORD_CAMERA_2_SET_REPEATING_REQUEST_COST, Long.valueOf(jCurrentTimeMillis));
            }
            if (TECameraModeBase.this.mCameraSettings.mIsGetMetadata) {
                TECameraFrame.Metadata metadata = new TECameraFrame.Metadata();
                metadata.timestamp = System.currentTimeMillis();
                metadata.captureResult = totalCaptureResult;
                metadata.maxIso = TECameraModeBase.this.getISORange()[1];
                metadata.minIso = TECameraModeBase.this.getISORange()[0];
                TECameraModeBase.this.mCameraHolder.getProviderManager().getProvider().setMetadata(metadata);
            }
            TECameraModeBase tECameraModeBase = TECameraModeBase.this;
            if (tECameraModeBase.ifFinalize) {
                tECameraModeBase.ifFinalize = TECameraUtils.finalizeCameraResult(totalCaptureResult);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
            super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
            TECameraModeBase tECameraModeBase = TECameraModeBase.this;
            if (tECameraModeBase.mCameraSettings.mEnablePreviewingFallback && !tECameraModeBase.mIsFirstPreviewFrameArrived && captureFailure.getReason() == 0) {
                TECameraModeBase tECameraModeBase2 = TECameraModeBase.this;
                int i = tECameraModeBase2.mPreviewCapturedFailedCount + 1;
                tECameraModeBase2.mPreviewCapturedFailedCount = i;
                tECameraModeBase2.mCameraSettings.getClass();
                if (i >= 5) {
                    TECameraModeBase tECameraModeBase3 = TECameraModeBase.this;
                    tECameraModeBase3.mCameraEvents.onPreviewError(tECameraModeBase3.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_PREVIEWNG_FAILED, "Camera previewing failed", tECameraModeBase3.mCameraDevice);
                }
            }
            TELogUtils.e(TECameraModeBase.TAG, "failure: " + captureFailure + ",reason:" + captureFailure.getReason());
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public static class Response {
        boolean isSuccess = false;
        String errMsg = "";

        public String getErrMsg() {
            return this.errMsg;
        }

        public Exception getException() {
            return new Exception(this.errMsg);
        }

        public boolean isSuccess() {
            return this.isSuccess;
        }

        public String toString() {
            return "Response{isSuccess=" + this.isSuccess + ", errMsg='" + this.errMsg + "'}";
        }
    }

    public TECameraModeBase(@NonNull TECamera2 tECamera2, @NonNull Context context, Handler handler) {
        this.ifFinalize = true;
        this.mCameraLightOn = false;
        this.mCameraHolder = tECamera2;
        TECameraSettings cameraSettings = tECamera2.getCameraSettings();
        this.mCameraSettings = cameraSettings;
        this.mDeviceProxy = TECameraHardware2Proxy.getDeviceProxy(context, cameraSettings.mCameraType);
        this.mCameraEvents = this.mCameraHolder.getCameraEvents();
        this.mHandler = handler;
        this.ifFinalize = this.mCameraSettings.mEnableManualReleaseCaptureResult;
        this.mCameraLightOn = false;
    }

    public static List<TEFrameSizei> convertSizes(Size[] sizeArr) {
        ArrayList arrayList = new ArrayList();
        for (Size size : sizeArr) {
            arrayList.add(new TEFrameSizei(size.getWidth(), size.getHeight()));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v8 */
    private int doFocusOrMeter(TEFocusSettings tEFocusSettings) {
        ?? r14;
        Rect rect;
        boolean z;
        TELogUtils.d(TAG, "settings = " + tEFocusSettings);
        this.mFocusSettings = tEFocusSettings;
        this.mFocusStrategy.setFocusSettings(tEFocusSettings);
        this.mFocusStrategy.setCameraSettings(this.mCameraSettings);
        if (this.mDeviceProxy == null || this.mCameraSession == null || this.mCaptureRequestBuilder == null || this.mFocusSettings == null) {
            TELogUtils.w(TAG, "Env is null");
            TEFocusSettings tEFocusSettings2 = this.mFocusSettings;
            if (tEFocusSettings2 != null) {
                tEFocusSettings2.getFocusCallback().onFocus(-100, this.mCameraSettings.mFacing, "Env is null");
            }
            return -100;
        }
        boolean zIsMeteringSupported = this.mDeviceProxy.isMeteringSupported(this.mCameraCharacteristics);
        boolean zIsFocusSupported = this.mDeviceProxy.isFocusSupported(this.mCameraCharacteristics);
        if (!zIsFocusSupported && !zIsMeteringSupported) {
            TELogUtils.w(TAG, "not support focus and meter!");
            this.mFocusSettings.getFocusCallback().onFocus(TECameraResult.TER_CAMERA_FOCUS_NOT_SUPPORT, this.mCameraSettings.mFacing, "not support focus and meter!");
            return TECameraResult.TER_CAMERA_FOCUS_NOT_SUPPORT;
        }
        boolean z2 = this.mManualFocusEngaged.get();
        boolean z3 = (zIsFocusSupported && this.mFocusSettings.isNeedFocus()) ? false : true;
        if (z2 && !z3) {
            this.mFocusCancelRunnable.run();
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            TELogUtils.i(TAG, "cancel previous touch af..");
        }
        if (zIsMeteringSupported && this.mFocusSettings.isNeedMetering()) {
            TEFocusSettings tEFocusSettings3 = this.mFocusSettings;
            TECameraSettings tECameraSettings = this.mCameraSettings;
            Rect rectCalculateMeteringArea = tEFocusSettings3.calculateMeteringArea(tECameraSettings.mRotation, tECameraSettings.mFacing == 1);
            if (rectCalculateMeteringArea == null) {
                z = false;
                rectCalculateMeteringArea = _calculateFocusRect(this.mFocusSettings.getWidth(), this.mFocusSettings.getHeight(), this.mFocusSettings.getX(), this.mFocusSettings.getY(), this.mCameraSettings.mRotation, 1, this.mFocusSettings.getCoordinatesMode());
            } else {
                z = false;
            }
            Rect rect2 = rectCalculateMeteringArea;
            if (!TECameraUtils.isValidRect(rect2)) {
                TELogUtils.e(TAG, "meteringRect is not valid!");
                this.mFocusSettings.getFocusCallback().onFocus(-100, this.mCameraSettings.mFacing, "meteringRect is not valid!");
                return -100;
            }
            this.mFocusStrategy.configMeter(this.mCaptureRequestBuilder, rect2);
            if (z3) {
                CaptureRequest.Builder builder = this.mCaptureRequestBuilder;
                updatePreview(builder, this.mFocusStrategy.getMeteringCaptureCallback(builder, z), this.mHandler);
                this.mManualFocusEngaged.set(z);
                return z ? 1 : 0;
            }
            rect = rect2;
            r14 = z;
        } else {
            r14 = 0;
            rect = null;
        }
        if (!(zIsFocusSupported && this.mFocusSettings.isNeedFocus())) {
            return TECameraResult.TER_CAMERA_FOCUS_NOT_SUPPORT;
        }
        TEFocusSettings tEFocusSettings4 = this.mFocusSettings;
        TECameraSettings tECameraSettings2 = this.mCameraSettings;
        Rect rectCalculateFocusArea = tEFocusSettings4.calculateFocusArea(tECameraSettings2.mRotation, tECameraSettings2.mFacing == 1);
        if (rectCalculateFocusArea == null) {
            rectCalculateFocusArea = _calculateFocusRect(this.mFocusSettings.getWidth(), this.mFocusSettings.getHeight(), this.mFocusSettings.getX(), this.mFocusSettings.getY(), this.mCameraSettings.mRotation, 0, this.mFocusSettings.getCoordinatesMode());
        }
        if (!TECameraUtils.isValidRect(rectCalculateFocusArea)) {
            TELogUtils.e(TAG, "focusRect is not valid!");
            this.mFocusSettings.getFocusCallback().onFocus(-100, this.mCameraSettings.mFacing, "focusRect is not valid!");
            return -100;
        }
        this.mManualFocusEngaged.set(true);
        if (this.mCameraLightOn) {
            if (tEFocusSettings.isFromUser()) {
                this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, 3);
                this.mCaptureRequestBuilder.set(CaptureRequest.FLASH_MODE, 1);
            } else {
                this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, 1);
                this.mCaptureRequestBuilder.set(CaptureRequest.FLASH_MODE, Integer.valueOf((int) r14));
            }
        }
        this.mFocusStrategy.configFocus(this.mCaptureRequestBuilder, rectCalculateFocusArea);
        capture(this.mCaptureRequestBuilder);
        this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf((int) r14));
        CaptureRequest.Builder builder2 = this.mCaptureRequestBuilder;
        CaptureRequest.Key key = CaptureRequest.CONTROL_AF_REGIONS;
        MeteringRectangle[] meteringRectangleArr = new MeteringRectangle[1];
        meteringRectangleArr[r14] = new MeteringRectangle(rectCalculateFocusArea, 999);
        builder2.set(key, meteringRectangleArr);
        if (rect != null) {
            CaptureRequest.Builder builder3 = this.mCaptureRequestBuilder;
            CaptureRequest.Key key2 = CaptureRequest.CONTROL_AE_REGIONS;
            MeteringRectangle[] meteringRectangleArr2 = new MeteringRectangle[1];
            meteringRectangleArr2[r14] = new MeteringRectangle(rect, 999);
            builder3.set(key2, meteringRectangleArr2);
        }
        this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf((int) r14));
        CaptureRequest.Builder builder4 = this.mCaptureRequestBuilder;
        Response responseUpdatePreview = updatePreview(builder4, this.mFocusStrategy.getFocusCaptureCallback(builder4, this.mManualFocusEngaged, tEFocusSettings.isLock()), this.mHandler);
        if (responseUpdatePreview.isSuccess) {
            return r14;
        }
        this.mManualFocusEngaged.set(r14);
        TEFocusSettings tEFocusSettings5 = this.mFocusSettings;
        if (tEFocusSettings5 != null) {
            tEFocusSettings5.getFocusCallback().onFocus(-108, this.mCameraSettings.mFacing, responseUpdatePreview.errMsg);
        }
        this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_FOCUS_FAILED, TECameraResult.TER_CAMERA_FOCUS_FAILED, responseUpdatePreview.errMsg, null);
        return -108;
    }

    private void setFPSRange() {
        TECameraHardware2Proxy tECameraHardware2Proxy = this.mDeviceProxy;
        CameraCharacteristics cameraCharacteristics = this.mCameraCharacteristics;
        TECameraSettings tECameraSettings = this.mCameraSettings;
        TEFrameRateRange tEFrameRateRange = tECameraSettings.mFPSRange;
        this.mFpsRange = tECameraHardware2Proxy.getFPSRange(cameraCharacteristics, tEFrameRateRange.min, tEFrameRateRange.max, tECameraSettings.mCameraFrameRateStrategy, tECameraSettings.mFacing);
        TELogUtils.i(TAG, "Set Fps Range: " + this.mFpsRange.toString() + ", strategy: " + this.mCameraSettings.mCameraFrameRateStrategy);
    }

    private void startCameraFaceDetect(CaptureRequest.Builder builder) {
        int[] iArr = this.mFaceDetectSupportMode;
        if (iArr == null) {
            TELogUtils.d(TAG, "FaceDetect is not supported!");
            return;
        }
        if (TECameraUtils.contains(iArr, 1)) {
            builder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, 1);
            builder.set(CaptureRequest.CONTROL_SCENE_MODE, 1);
        } else if (TECameraUtils.contains(this.mFaceDetectSupportMode, 2)) {
            builder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, 2);
            builder.set(CaptureRequest.CONTROL_SCENE_MODE, 1);
        } else if (TECameraUtils.contains(this.mFaceDetectSupportMode, 0)) {
            TELogUtils.w(TAG, "FaceDetect is not supported!");
        }
    }

    public Rect _calculateFocusRect(int i, int i2, float f, float f2, int i3, int i4, TEFocusSettings.CoordinatesMode coordinatesMode) {
        int i5;
        int i6;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        int i7;
        if (this.mCaptureRequest == null) {
            TELogUtils.e(TAG, "_calculateFocusRect, capture request is null, return");
            return null;
        }
        Rect rect = (Rect) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        TELogUtils.d(TAG, "SENSOR_INFO_ACTIVE_ARRAY_SIZE: [left, top, right, bottom] = [" + rect.left + ", " + rect.top + ", " + rect.right + ", " + rect.bottom + "]");
        Size size = (Size) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE);
        StringBuilder sb = new StringBuilder();
        sb.append("mCameraCharacteristics:[width, height]: [");
        sb.append(size.getWidth());
        sb.append(", ");
        sb.append(size.getHeight());
        sb.append("]");
        TELogUtils.i("onAreaTouchEvent", sb.toString());
        TECameraSettings tECameraSettings = this.mCameraSettings;
        TEFrameSizei tEFrameSizei = tECameraSettings.mPreviewSize;
        int i8 = tEFrameSizei.width;
        int i9 = tEFrameSizei.height;
        TEFocusSettings.CoordinatesMode coordinatesMode2 = TEFocusSettings.CoordinatesMode.VIEW;
        if (coordinatesMode == coordinatesMode2 && (90 == (i7 = tECameraSettings.mRotation) || 270 == i7)) {
            i6 = i9;
            i5 = i8;
        } else {
            i5 = i9;
            i6 = i8;
        }
        float f8 = 0.0f;
        if (i5 * i >= i6 * i2) {
            f4 = (i * 1.0f) / i6;
            f5 = ((i5 * f4) - i2) / 2.0f;
            f3 = 0.0f;
        } else {
            float f9 = (i2 * 1.0f) / i5;
            f3 = ((i6 * f9) - i) / 2.0f;
            f4 = f9;
            f5 = 0.0f;
        }
        float f10 = (f + f3) / f4;
        float f11 = (f2 + f5) / f4;
        if (coordinatesMode == coordinatesMode2) {
            if (90 == i3) {
                float f12 = i9 - f10;
                f10 = f11;
                f11 = f12;
            } else if (270 == i3) {
                float f13 = i8 - f11;
                f11 = f10;
                f10 = f13;
            }
        }
        Rect rect2 = (Rect) this.mCaptureRequest.get(CaptureRequest.SCALER_CROP_REGION);
        if (rect2 == null || rect2.isEmpty()) {
            TELogUtils.w(TAG, "can't get crop region");
        } else {
            rect = rect2;
        }
        TELogUtils.d(TAG, "cropRegion Rect: [left, top, right, bottom] = [" + rect.left + ", " + rect.top + ", " + rect.right + ", " + rect.bottom);
        int iWidth = rect.width();
        int iHeight = rect.height();
        TECameraSettings tECameraSettings2 = this.mCameraSettings;
        TEFrameSizei tEFrameSizei2 = tECameraSettings2.mPreviewSize;
        int i10 = tEFrameSizei2.height;
        int i11 = i10 * iWidth;
        int i12 = tEFrameSizei2.width;
        if (i11 > i12 * iHeight) {
            f6 = (iHeight * 1.0f) / i10;
            f8 = (iWidth - (i12 * f6)) / 2.0f;
            f7 = 0.0f;
        } else {
            float f14 = (iWidth * 1.0f) / i12;
            float f15 = (iHeight - (i10 * f14)) / 2.0f;
            f6 = f14;
            f7 = f15;
        }
        float f16 = (f10 * f6) + f8 + rect.left;
        float fHeight = (f11 * f6) + f7 + rect.top;
        if (coordinatesMode == coordinatesMode2 && tECameraSettings2.mFacing == 1) {
            fHeight = rect.height() - fHeight;
        }
        Rect rect3 = new Rect();
        if (i4 == 0) {
            double d = f16;
            rect3.left = (int) (d - (((double) rect.width()) * 0.05d));
            rect3.right = (int) (d + (((double) rect.width()) * 0.05d));
            double d2 = fHeight;
            rect3.top = (int) (d2 - (((double) rect.height()) * 0.05d));
            rect3.bottom = (int) (d2 + (0.05d * ((double) rect.height())));
        } else {
            double d3 = f16;
            rect3.left = (int) (d3 - (((double) rect.width()) * 0.1d));
            rect3.right = (int) (d3 + (((double) rect.width()) * 0.1d));
            double d4 = fHeight;
            rect3.top = (int) (d4 - (((double) rect.height()) * 0.1d));
            rect3.bottom = (int) (d4 + (((double) rect.height()) * 0.1d));
        }
        int i13 = rect3.left;
        if (i13 < 0 || i13 < rect.left) {
            rect3.left = rect.left;
        }
        int i14 = rect3.top;
        if (i14 < 0 || i14 < rect.top) {
            rect3.top = rect.top;
        }
        int i15 = rect3.right;
        if (i15 < 0 || i15 > rect.right) {
            rect3.right = rect.right;
        }
        int i16 = rect3.bottom;
        if (i16 < 0 || i16 > rect.bottom) {
            rect3.bottom = rect.bottom;
        }
        TELogUtils.i(TAG, "Focus Rect: [left, top, right, bottom] = [" + rect3.left + ", " + rect3.top + ", " + rect3.right + ", " + rect3.bottom + "] x: " + f16 + " y: " + fHeight);
        return rect3;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void abortSession() {
        if (this.mCameraSession == null || Build.VERSION.SDK_INT < 28) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            this.mCameraSession.abortCaptures();
        } catch (Exception e) {
            TELogUtils.e(TAG, "abort session failed, e: " + e.getMessage());
        }
        TELogUtils.i(TAG, "abort session...consume = " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public Rect calculateZoomSize(float f) {
        CameraCharacteristics cameraCharacteristics = this.mCameraCharacteristics;
        if (cameraCharacteristics == null || this.mCaptureRequestBuilder == null) {
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_ZOOM_FAILED, "Camera info is null, may be you need reopen camera.", this.mCameraDevice);
            return null;
        }
        float fFloatValue = ((Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
        Rect rect = (Rect) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        int iWidth = rect.width() - ((int) (rect.width() / fFloatValue));
        int iHeight = rect.height() - ((int) (rect.height() / fFloatValue));
        int i = (int) ((iWidth / fFloatValue) * f);
        int i2 = (int) ((iHeight / fFloatValue) * f);
        int i3 = i - (i & 3);
        int i4 = i2 - (i2 & 3);
        return new Rect(i3, i4, rect.width() - i3, rect.height() - i4);
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public Rect calculateZoomSizeV2(float f) {
        Rect rect = this.mActiveArraySize;
        if (rect == null) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: START_ZOOM. Code: -420. Reason: mActiveArraySize is null");
            TELogUtils.e(TAG, "ActiveArraySize == null");
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_ZOOM_FAILED, TECameraResult.TER_CAMERA_ZOOM_FAILED, "ActiveArraySize == null.", this.mCameraDevice);
            return null;
        }
        float f2 = this.mNowZoom;
        if (f2 <= 0.0f || f2 > this.mMaxZoom) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: START_ZOOM. Code: -420. Reason: invalid factor");
            TELogUtils.e(TAG, "factor invalid");
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_ZOOM_FAILED, TECameraResult.TER_CAMERA_ZOOM_FAILED, "factor invalid.", this.mCameraDevice);
            return null;
        }
        float f3 = 1.0f / f2;
        int iWidth = rect.width() - Math.round(this.mActiveArraySize.width() * f3);
        int iHeight = this.mActiveArraySize.height() - Math.round(this.mActiveArraySize.height() * f3);
        int i = iWidth / 2;
        Rect rect2 = this.mActiveArraySize;
        int iClamp = TECameraUtils.clamp(i, rect2.left, rect2.right);
        int i2 = iHeight / 2;
        Rect rect3 = this.mActiveArraySize;
        int iClamp2 = TECameraUtils.clamp(i2, rect3.top, rect3.bottom);
        int iWidth2 = this.mActiveArraySize.width() - i;
        Rect rect4 = this.mActiveArraySize;
        int iClamp3 = TECameraUtils.clamp(iWidth2, rect4.left, rect4.right);
        int iHeight2 = this.mActiveArraySize.height() - i2;
        Rect rect5 = this.mActiveArraySize;
        Rect rect6 = new Rect(iClamp, iClamp2, iClamp3, TECameraUtils.clamp(iHeight2, rect5.top, rect5.bottom));
        CaptureRequest captureRequest = this.mCaptureRequest;
        if (captureRequest != null && rect6.equals((Rect) captureRequest.get(CaptureRequest.SCALER_CROP_REGION))) {
            TELogUtils.i(TAG, "same SCALER_CROP_REGION, no need to set");
        }
        return rect6;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public int cancelFocus() {
        if (this.mCaptureRequestBuilder != null) {
            return this.mFocusStrategy.cancelFocus();
        }
        this.mCameraEvents.onCameraInfo(-100, -100, "rollbackNormalSessionRequest : param is null.", this.mCameraDevice);
        return -100;
    }

    public Response capture(CaptureRequest.Builder builder) {
        return capture(builder, this.mPreviewCaptureCallback, getCameraHandler());
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void captureBurst(BurstRequest burstRequest, int i, TECameraSettings.CaptureBufferFrameCallback captureBufferFrameCallback) {
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void close() {
        if (this.mCameraSettings.mEnableMonitorGyroscope && this.mCameraHolder.getGyro() != null) {
            this.mCameraHolder.getGyro().unregister(this.mGyroListener);
        }
        releaseCameraThread();
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void closePreviewSession() {
        TECameraSettings tECameraSettings;
        if (this.mCameraHolder != null && (tECameraSettings = this.mCameraSettings) != null && tECameraSettings.mUseSyncModeOnCamera2) {
            TELogUtils.i(TAG, "close session process...state = " + this.mCameraHolder.getSessionState());
            if (this.mCameraHolder.getSessionState() == 2) {
                this.mCameraHolder.waitCameraTaskDoneOrTimeout();
            }
        }
        this.mIsActiveCameraSession = false;
        if (getCameraDevice() == null) {
            TELogUtils.e(TAG, "close session process...device is null");
            return;
        }
        if (this.mCameraSession == null) {
            TELogUtils.e(TAG, "close session process...session is null");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            this.mCameraSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mCameraSession = null;
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_2_CLOSE_SESSION_COST, jCurrentTimeMillis2);
        TELogUtils.logMonitorInfo(TECameraMonitor.TE_RECORD_CAMERA_2_CLOSE_SESSION_COST, Long.valueOf(jCurrentTimeMillis2));
        TELogUtils.i(TAG, "close session...consume = " + jCurrentTimeMillis2);
    }

    public CaptureRequest.Builder createCaptureRequestBuilder(int i) {
        if (i > 6 || i < 1) {
            TELogUtils.e(TAG, "createCaptureRequestBuilder, template invalid, must be [1, 6]");
            return null;
        }
        CameraDevice cameraDevice = this.mCameraDevice;
        if (cameraDevice == null) {
            return null;
        }
        try {
            return cameraDevice.createCaptureRequest(i);
        } catch (CameraAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void createSession(List<Surface> list, CameraCaptureSession.StateCallback stateCallback, final Handler handler) throws CameraAccessException {
        List arrayList;
        if (Build.VERSION.SDK_INT < 28) {
            TELogUtils.i(TAG, "createSession by normally");
            this.mCameraDevice.createCaptureSession(list, stateCallback, handler);
            return;
        }
        if (list != null || !this.mCameraSettings.mEnableCamera2DeferredSurface || (arrayList = this.mOutputConfigurations) == null) {
            arrayList = new ArrayList();
            Iterator<Surface> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ds5.a(it.next()));
            }
        }
        es5.a();
        SessionConfiguration sessionConfigurationA = cs5.a(getSessionType(list), arrayList, new Executor() { // from class: com.ss.android.ttvecamera.framework.TECameraModeBase.2
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                Handler handler2 = handler;
                if (handler2 != null) {
                    handler2.post(runnable);
                }
            }
        }, stateCallback);
        sessionConfigurationA.setSessionParameters(this.mCaptureRequestBuilder.build());
        TELogUtils.i(TAG, "createSession by sessionConfiguration");
        this.mCameraDevice.createCaptureSession(sessionConfigurationA);
    }

    public void createSessionByDeferredSurface() throws Exception {
        if (Build.VERSION.SDK_INT < 28 || this.mCameraDevice == null) {
            return;
        }
        this.mOutputConfigurations.clear();
        TECameraSettings tECameraSettings = this.mCameraSettings;
        if (tECameraSettings.mMode == 0 && tECameraSettings.mCameraType == 2) {
            List<OutputConfiguration> list = this.mOutputConfigurations;
            yr5.a();
            list.add(xr5.a(new Size(this.mCameraSettings.getPreviewSize().width, this.mCameraSettings.getPreviewSize().height), SurfaceTexture.class));
            Handler cameraHandler = this.mCameraSettings.mUseSyncModeOnCamera2 ? getCameraHandler() : this.mHandler;
            if (this.mCameraDevice != null) {
                if (this.mCaptureRequestBuilder == null) {
                    if (this.mCameraSettings.mExtParameters.getBoolean("enablePreviewTemplate")) {
                        this.mCaptureRequestBuilder = this.mCameraDevice.createCaptureRequest(1);
                    } else {
                        this.mCaptureRequestBuilder = this.mCameraDevice.createCaptureRequest(3);
                    }
                }
                this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, configFps(new Range<>(Integer.valueOf(this.mFpsRange.min / this.mCameraSettings.mFPSRange.fpsUnitFactor), Integer.valueOf(this.mFpsRange.max / this.mCameraSettings.mFPSRange.fpsUnitFactor))));
                createSession(null, this.mSessionStateCallback, cameraHandler);
            }
        }
        this.mIsSessionFinalized = false;
        this.mIsSurfaceReady = false;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public int enableCaf() {
        CaptureRequest.Builder builder = this.mCaptureRequestBuilder;
        if (builder == null) {
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, -100, "rollbackNormalSessionRequest : param is null.", this.mCameraDevice);
            return -100;
        }
        this.mFocusStrategy.enableCaf(builder);
        updateRequestRepeating(this.mCameraSession, this.mCaptureRequestBuilder);
        return 0;
    }

    public void enableMulticamZoom(boolean z) {
        if (!z && this.mNowZoom != 1.0f) {
            this.mNowZoom = 1.0f;
            if (Build.VERSION.SDK_INT >= 30) {
                if (this.mCaptureRequestBuilder == null || this.mCameraSession == null) {
                    this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, -100, "enableMulticamZoom : Capture Session is null", this.mCameraDevice);
                    return;
                }
                this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_ZOOM_RATIO, Float.valueOf(this.mNowZoom));
                Response responseUpdatePreview = updatePreview(this.mCaptureRequestBuilder);
                if (!responseUpdatePreview.isSuccess) {
                    TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: START_ZOOM. Code: -420. Reason: " + responseUpdatePreview.getErrMsg());
                    this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_ZOOM_FAILED, TECameraResult.TER_CAMERA_ZOOM_FAILED, responseUpdatePreview.errMsg, this.mCameraDevice);
                    return;
                }
            }
            this.mZoomSize = calculateZoomSizeV2(this.mNowZoom);
        }
        this.mEnableMulticamZoom = z;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void fillFeatures() {
        Bundle bundle;
        TETraceUtils.beginSection("TECameraModeBase-fillFeatures");
        if (this.mCameraHolder.getFeatures().containsKey(this.mCameraSettings.mStrCameraID)) {
            bundle = this.mCameraHolder.getFeatures().get(this.mCameraSettings.mStrCameraID);
        } else {
            bundle = new Bundle();
            this.mCameraHolder.getFeatures().put(this.mCameraSettings.mStrCameraID, bundle);
        }
        bundle.putParcelable(TECameraSettings.Features.CAMERA_PREVIEW_SIZE, this.mCameraSettings.mPreviewSize);
        if (this.mCameraCharacteristics != null && this.mCaptureRequest != null) {
            TEFocusParameters tEFocusParameters = new TEFocusParameters();
            tEFocusParameters.mActiveSize = (Rect) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            tEFocusParameters.mCropSize = (Rect) this.mCaptureRequest.get(CaptureRequest.SCALER_CROP_REGION);
            tEFocusParameters.mMaxRegionsAE = ((Integer) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE)).intValue();
            tEFocusParameters.mMaxRegionsAF = ((Integer) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue();
            bundle.putParcelable(TECameraSettings.Features.CAMERA_FOCUS_PARAMETERS, tEFocusParameters);
        }
        bundle.putInt(TECameraSettings.Features.CAMERA_SENSOR_ORIENTATION, this.mCameraSettings.mRotation);
        TETraceUtils.endSection();
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public int focusAtPoint(int i, int i2, float f, int i3, int i4) {
        return focusAtPoint(new TEFocusSettings(i, i2, i3, i4, f));
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public float[] getApertureRange() {
        if (this.mCaptureRequestBuilder == null || this.mCameraSession == null) {
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_APERTURE_FAILED, TECameraResult.TER_CAMERA_APERTURE_FAILED, "Capture Session is null", this.mCameraDevice);
        }
        float[] fArr = (float[]) this.mCameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_APERTURES);
        return fArr == null ? new float[]{-1.0f, -1.0f} : fArr;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public int[] getCameraCaptureSize() {
        return null;
    }

    public Object getCameraDevice() {
        return this.mCameraDevice;
    }

    public Handler getCameraHandler() {
        if (this.mCameraThread == null) {
            HandlerThread handlerThread = new HandlerThread("camera thread");
            this.mCameraThread = handlerThread;
            handlerThread.start();
            TELogUtils.i(TAG, "getCameraHandler, init camera thread");
        }
        if (this.mCameraThreadHandler == null) {
            this.mCameraThreadHandler = new Handler(this.mCameraThread.getLooper());
        }
        return this.mCameraThreadHandler;
    }

    public int getContinuousFocusMode() {
        return 3;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public float[] getFOV() {
        if (this.mDeviceProxy == null || this.mCaptureRequest == null || this.mCameraSession == null || this.mCaptureRequestBuilder == null) {
            TELogUtils.w(TAG, "Env is null");
            return new float[]{-2.0f, -2.0f};
        }
        float[] fArr = new float[2];
        double[] dArr = new double[2];
        SizeF sizeF = (SizeF) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
        Rect rect = (Rect) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        Size size = (Size) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE);
        Float f = (Float) this.mCaptureRequestBuilder.get(CaptureRequest.LENS_FOCAL_LENGTH);
        int iAbs = StrictMath.abs(rect.right - rect.left);
        int iAbs2 = StrictMath.abs(rect.top - rect.bottom);
        TEFrameSizei tEFrameSizei = this.mCameraSettings.mPreviewSize;
        int i = tEFrameSizei.width;
        if (iAbs * tEFrameSizei.height >= i / iAbs2) {
            dArr[0] = StrictMath.atan(((sizeF.getWidth() * iAbs) / size.getWidth()) / (f.floatValue() * 2.0f)) * 2.0d;
            dArr[1] = StrictMath.atan(((((sizeF.getHeight() * iAbs2) / size.getHeight()) * (i / r9)) / (iAbs / iAbs2)) / (f.floatValue() * 2.0f)) * 2.0d;
        } else {
            dArr[1] = StrictMath.atan(((sizeF.getHeight() * iAbs2) / size.getHeight()) / (f.floatValue() * 2.0f)) * 2.0d;
            dArr[0] = StrictMath.atan(((((sizeF.getWidth() * iAbs) / size.getWidth()) * (r9 / i)) / (iAbs2 / iAbs)) / (f.floatValue() * 2.0f)) * 2.0d;
        }
        fArr[0] = (float) ((dArr[1] * 180.0d) / 3.141592653589793d);
        fArr[1] = (float) ((dArr[0] * 180.0d) / 3.141592653589793d);
        TELogUtils.d(TAG, "Camera2:verticalFOV = " + fArr[0] + ",horizontalFOV = " + fArr[1]);
        return fArr;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public int getFlashMode() {
        return -1;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public int getISO() {
        if (this.mCaptureRequestBuilder == null || this.mCameraSession == null) {
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_ISO_FAILED, TECameraResult.TER_CAMERA_ISO_FAILED, "Capture Session is null", this.mCameraDevice);
        }
        return this.mCurrentIso;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public int[] getISORange() {
        if (this.mCaptureRequestBuilder == null || this.mCameraSession == null) {
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_ISO_FAILED, TECameraResult.TER_CAMERA_ISO_FAILED, "Capture Session is null", this.mCameraDevice);
        }
        Range range = (Range) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE);
        return (range == null || ((Integer) range.getUpper()).intValue() < 800 || ((Integer) range.getLower()).intValue() > 100) ? new int[]{-1, -1} : new int[]{((Integer) range.getUpper()).intValue(), ((Integer) range.getLower()).intValue()};
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public float getManualFocusAbility() {
        if (this.mCaptureRequestBuilder == null || this.mCameraSession == null) {
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_MF_NO_SUPPORT, TECameraResult.TER_CAMERA_MF_NO_SUPPORT, "Capture Session is null", this.mCameraDevice);
        }
        float fFloatValue = this.mCameraCharacteristics.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE) == null ? -1.0f : ((Float) this.mCameraCharacteristics.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE)).floatValue();
        if (fFloatValue >= 0.0f) {
            return fFloatValue;
        }
        this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_MF_NO_SUPPORT, TECameraResult.TER_CAMERA_MF_NO_SUPPORT, "can not get manual focus ability", this.mCameraDevice);
        return -1.0f;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public int[] getPictureSize() {
        return null;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public int[] getPreviewFps() {
        Range range;
        CaptureRequest.Builder builder = this.mCaptureRequestBuilder;
        if (builder == null || (range = (Range) builder.get(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE)) == null) {
            return null;
        }
        return new int[]{((Integer) range.getLower()).intValue(), ((Integer) range.getUpper()).intValue()};
    }

    public int getSessionType(List<Surface> list) {
        return 0;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public long[] getShutterTimeRange() {
        if (this.mCaptureRequestBuilder == null || this.mCameraSession == null) {
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_SHUTTER_TIME_FAILED, TECameraResult.TER_CAMERA_SHUTTER_TIME_FAILED, "Capture Session is null", this.mCameraDevice);
        }
        Range range = (Range) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_EXPOSURE_TIME_RANGE);
        return range == null ? new long[]{-1, -1} : new long[]{((Long) range.getUpper()).longValue(), ((Long) range.getLower()).longValue()};
    }

    public boolean needSetStabilizationParam() {
        return true;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public int openCamera(String str, int i) throws CameraAccessException {
        TETraceUtils.beginSection("TECameraModeBase-openCamera");
        CameraCharacteristics cameraCharacteristics = this.mCameraCharacteristics;
        if (cameraCharacteristics == null) {
            TELogUtils.d(TAG, "open failed, mCameraCharacteristics = null");
            return TECameraResult.TER_CAMERA_INTERNAL_ERROR;
        }
        if (!this.mDeviceProxy.isHardwareLevelSupported(cameraCharacteristics, i)) {
            return TECameraResult.TER_CAMERA_HARDWARE_LEVEL_NOT_SUPPORT;
        }
        this.mCameraSettings.mRotation = ((Integer) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.mCameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        this.mStreamConfigurationMap = streamConfigurationMap;
        if (streamConfigurationMap == null) {
            return TECameraResult.TER_CAMERA_INTERNAL_ERROR;
        }
        TECameraHardware2Proxy tECameraHardware2Proxy = this.mDeviceProxy;
        CameraCharacteristics cameraCharacteristics2 = this.mCameraCharacteristics;
        TECameraSettings tECameraSettings = this.mCameraSettings;
        this.mMaxZoom = tECameraHardware2Proxy.getMaxZoomValue(cameraCharacteristics2, tECameraSettings.mCameraType, tECameraSettings.mCameraZoomLimitFactor);
        TECameraSettings tECameraSettings2 = this.mCameraSettings;
        if (tECameraSettings2.mMaxZoomRatio == -1.0f || tECameraSettings2.mMinZoomRatio == -1.0f) {
            this.mZoomRatioRange = this.mDeviceProxy.getZoomValueRange(this.mCameraCharacteristics);
        } else {
            this.mZoomRatioRange = new Range<>(Float.valueOf(this.mCameraSettings.mMinZoomRatio), Float.valueOf(this.mCameraSettings.mMaxZoomRatio));
        }
        this.mNowZoom = 1.0f;
        this.mActiveArraySize = (Rect) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        setFPSRange();
        this.mUseFaceAE = this.mCameraSettings.mExtParameters.getInt("useCameraFaceDetect");
        this.mFaceDetectSupportMode = (int[]) this.mCameraCharacteristics.get(CameraCharacteristics.STATISTICS_INFO_AVAILABLE_FACE_DETECT_MODES);
        this.mExposureCompensation = 0;
        TETraceUtils.endSection();
        return 0;
    }

    public void openCameraLock() {
        TECamera2 tECamera2 = this.mCameraHolder;
        if (tECamera2 != null) {
            tECamera2.openCameraLock();
            return;
        }
        TELogUtils.d(TAG, "openCameraLock failed, " + TELogUtils.getStackTraceString());
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public int prepareProvider() {
        TETraceUtils.beginSection("TECameraModeBase-prepareProvider");
        TECameraProviderManager providerManager = this.mCameraHolder.getProviderManager();
        if (getCameraDevice() == null || providerManager == null) {
            TELogUtils.e(TAG, "CameraDevice or ProviderManager is null!");
            return -100;
        }
        if (this.mStreamConfigurationMap == null) {
            this.mStreamConfigurationMap = (StreamConfigurationMap) this.mCameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        }
        if (providerManager.getProvider().isPreview()) {
            providerManager.setPreviewSizeCallback(this.mPreviewSizeCallback);
            providerManager.initProvider(this.mStreamConfigurationMap, (TEFrameSizei) null);
            this.mCameraSettings.mPreviewSize = providerManager.getPreviewSize();
            TEFrameSizei tEFrameSizei = this.mCameraSettings.mPreviewSize;
            if (tEFrameSizei != null) {
                this.mCameraEvents.onCameraInfo(50, 0, tEFrameSizei.toString(), this.mCameraDevice);
            }
        } else {
            providerManager.initProvider(this.mStreamConfigurationMap, this.mCameraSettings.mPreviewSize);
            this.mCameraSettings.mPictureSize = providerManager.getPictureSize();
        }
        TELogUtils.i(TAG, "Camera provider type: " + providerManager.getProviderType());
        if (providerManager.getProviderType() == 1 || providerManager.getProviderType() == 16) {
            if (providerManager.getSurfaceTexture() == null) {
                TELogUtils.e(TAG, "SurfaceTexture is null.");
                return -100;
            }
            SurfaceTexture surfaceTexture = providerManager.getSurfaceTexture();
            TEFrameSizei tEFrameSizei2 = this.mCameraSettings.mPreviewSize;
            surfaceTexture.setDefaultBufferSize(tEFrameSizei2.width, tEFrameSizei2.height);
        } else if (providerManager.getProviderType() != 2) {
            if (providerManager.getProviderType() != 8) {
                TELogUtils.e(TAG, "Unsupported camera provider type : " + providerManager.getProviderType());
                return -200;
            }
            SurfaceTexture surfaceTexture2 = providerManager.getSurfaceTexture();
            TEFrameSizei tEFrameSizei3 = this.mCameraSettings.mPreviewSize;
            surfaceTexture2.setDefaultBufferSize(tEFrameSizei3.width, tEFrameSizei3.height);
        }
        TETraceUtils.endSection();
        return 0;
    }

    public void releaseCameraThread() {
        HandlerThread handlerThread = this.mCameraThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.mCameraThread = null;
            this.mCameraThreadHandler = null;
            TELogUtils.i(TAG, "releaseCameraThread");
        }
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void removeFocusSettings() {
        TELogUtils.i(TAG, "removeFocusSettings");
        TEFocusStrategyBase tEFocusStrategyBase = this.mFocusStrategy;
        if (tEFocusStrategyBase != null) {
            tEFocusStrategyBase.setFocusSettings(null);
            this.mFocusSettings = null;
        }
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void reset() {
        this.mZoomSize = null;
        this.mPreviewCapturedFailedCount = 0;
    }

    public int rollbackMeteringSessionRequest() {
        if (this.mCaptureRequestBuilder == null) {
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, -100, "rollbackMeteringSessionRequest : param is null.", this.mCameraDevice);
            return -100;
        }
        useFaceAEStrategy(this.mUseFaceAE);
        this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, 1);
        if (this.mCameraSettings.mEnableMonitorGyroscope) {
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_REGIONS, ITEFocusStrategy.ZERO_WEIGHT_3A_REGION);
        }
        updatePreview(this.mCaptureRequestBuilder);
        TELogUtils.i(TAG, "rollbackMeteringSessionRequest");
        return 0;
    }

    public int rollbackNormalSessionRequest() {
        CaptureRequest.Builder builder = this.mCaptureRequestBuilder;
        if (builder == null) {
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, -100, "rollbackNormalSessionRequest : param is null.", this.mCameraDevice);
            return -100;
        }
        builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
        this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(getContinuousFocusMode()));
        this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, 1);
        if (this.mCameraSettings.mEnableMonitorGyroscope) {
            CaptureRequest.Builder builder2 = this.mCaptureRequestBuilder;
            CaptureRequest.Key key = CaptureRequest.CONTROL_AE_REGIONS;
            MeteringRectangle[] meteringRectangleArr = ITEFocusStrategy.ZERO_WEIGHT_3A_REGION;
            builder2.set(key, meteringRectangleArr);
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr);
        }
        updatePreview(this.mCaptureRequestBuilder);
        TELogUtils.i(TAG, "rollbackNormalSessionRequest");
        return 0;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public String selectCamera(@TECameraSettings.CameraFacing int i) throws CameraAccessException {
        TETraceUtils.beginSection("TECameraModeBase-selectCamera");
        String[] cameraIdList = this.mCameraManager.getCameraIdList();
        String strSelectCamera = null;
        if (cameraIdList == null) {
            TELogUtils.w(TAG, "cameraList is null");
            return null;
        }
        TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_SIZE, cameraIdList.length);
        if (this.mCameraSettings.mExtParameters.getBoolean(TECameraConfigKey.KEY_ENABLE_CAMERA_DEVICES_CACHE)) {
            TELogUtils.i(TAG, "Enable CameraDeviceCache");
            strSelectCamera = this.mCameraDevicesCache.get(Integer.valueOf(i));
        }
        if (strSelectCamera == null || strSelectCamera == "") {
            if (i == 2) {
                if (this.mCameraSettings.mStrCustomizedCameraID.length() <= 0 || this.mCameraSettings.mStrCustomizedCameraID.equals("-1")) {
                    strSelectCamera = this.mCameraSettings.mCameraType == 8 ? this.mCameraHolder.getWideAngleID() : this.mDeviceProxy.getWideAngleID(cameraIdList, this.mCameraManager);
                } else {
                    TELogUtils.i(TAG, "Wide-angle camera id: " + this.mCameraSettings.mStrCustomizedCameraID);
                    if (TECameraUtils.contains(cameraIdList, this.mCameraSettings.mStrCustomizedCameraID)) {
                        strSelectCamera = this.mCameraSettings.mStrCustomizedCameraID;
                    } else {
                        TELogUtils.w(TAG, "Maybe this is not validate camera id: " + this.mCameraSettings.mStrCustomizedCameraID);
                    }
                }
                this.mCameraEvents.onCameraInfo(112, 0, "enable wide angle", this.mCameraDevice);
            } else if (i != 3) {
                if (i >= cameraIdList.length || i < 0) {
                    i = 1;
                }
                TECameraSettings tECameraSettings = this.mCameraSettings;
                tECameraSettings.mFacing = i;
                if (tECameraSettings.mPreferOpenCameraByCameraId && !TextUtils.isEmpty(tECameraSettings.mStrCustomizedCameraID)) {
                    strSelectCamera = this.mCameraSettings.mStrCustomizedCameraID;
                } else if (this.mCameraSettings.mEnableWideFOV && TECameraHardware2.isSSPlatform()) {
                    strSelectCamera = ((TECameraSSProxy) this.mDeviceProxy).selectCamera(this.mCameraManager, i, cameraIdList);
                }
                if (strSelectCamera == null) {
                    int length = cameraIdList.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        String str = cameraIdList[i2];
                        int i3 = ((Integer) this.mCameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING)).intValue() == 1 ? 0 : 1;
                        this.mCameraDevicesCache.put(Integer.valueOf(i3), str);
                        if (i3 == i) {
                            strSelectCamera = str;
                            break;
                        }
                        i2++;
                    }
                }
            } else if (this.mCameraSettings.mCameraType == 2) {
                strSelectCamera = this.mDeviceProxy.getTelephotoID(cameraIdList, this.mCameraManager);
            }
            if (strSelectCamera != null) {
                this.mCameraDevicesCache.put(Integer.valueOf(i), strSelectCamera);
            }
        }
        if (strSelectCamera == null) {
            TELogUtils.w(TAG, "selectCamera: camera tag is null, set 0 for default");
            strSelectCamera = "0";
        }
        TELogUtils.i(TAG, "selectCamera size: " + cameraIdList.length + ", mFacing: " + this.mCameraSettings.mFacing + ", cameraTag: " + strSelectCamera);
        CameraCharacteristics cameraCharacteristics = this.mCameraManager.getCameraCharacteristics(strSelectCamera);
        this.mCameraCharacteristics = cameraCharacteristics;
        if (Build.VERSION.SDK_INT >= 28) {
            TELogUtils.d(TAG, "selectCamera sessionKeys: " + cameraCharacteristics.getAvailableSessionKeys());
        }
        Range range = (Range) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        Rational rational = (Rational) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
        if (range != null && rational != null) {
            this.mCameraSettings.mCameraECInfo.min = ((Integer) range.getLower()).intValue();
            this.mCameraSettings.mCameraECInfo.max = ((Integer) range.getUpper()).intValue();
            this.mCameraSettings.mCameraECInfo.step = (rational.getNumerator() * 1.0f) / rational.getDenominator();
            this.mCameraSettings.mCameraECInfo.exposure = 0;
        }
        TETraceUtils.endSection();
        return strSelectCamera;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void setAperture(float f) {
        if (this.mCaptureRequestBuilder == null || this.mCameraSession == null) {
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_APERTURE_FAILED, TECameraResult.TER_CAMERA_APERTURE_FAILED, "Capture Session is null", this.mCameraDevice);
        }
        if (getApertureRange().length == 1 && !Arrays.asList(getApertureRange()).contains(Float.valueOf(f))) {
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_APERTURE_FAILED, TECameraResult.TER_CAMERA_APERTURE_FAILED, "invalid aperture", this.mCameraDevice);
            return;
        }
        if (!((Integer) this.mCaptureRequestBuilder.get(CaptureRequest.CONTROL_AE_MODE)).equals(0)) {
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, 0);
        }
        if (!((Integer) this.mCaptureRequestBuilder.get(CaptureRequest.CONTROL_MODE)).equals(0)) {
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_MODE, 0);
        }
        this.mCaptureRequestBuilder.set(CaptureRequest.LENS_APERTURE, Float.valueOf(f));
        Response responseUpdatePreview = updatePreview(this.mCaptureRequestBuilder);
        if (responseUpdatePreview.isSuccess) {
            return;
        }
        TELogUtils.e(TAG, "setAperture exception: " + responseUpdatePreview.errMsg);
        this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_APERTURE_FAILED, TECameraResult.TER_CAMERA_APERTURE_FAILED, responseUpdatePreview.errMsg, this.mCameraDevice);
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void setAutoExposureLock(boolean z) {
        if (this.mCaptureRequestBuilder == null || this.mCameraSession == null) {
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, -100, "setExposureCompensation : Capture Session is null", this.mCameraDevice);
            return;
        }
        try {
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.valueOf(z));
            updatePreview(this.mCaptureRequestBuilder);
        } catch (Exception e) {
            e.printStackTrace();
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_AE_LOCK_FAILED, TECameraResult.TER_CAMERA_AE_LOCK_FAILED, e.toString(), this.mCameraDevice);
        }
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void setAutoFocusLock(boolean z) {
        if (this.mCaptureRequestBuilder == null || this.mCameraSession == null) {
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, -100, "setAutoFocusLock : Capture Session is null", this.mCameraDevice);
            return;
        }
        try {
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
            updatePreview(this.mCaptureRequestBuilder);
        } catch (Exception e) {
            e.printStackTrace();
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_AF_LOCK_FAILED, TECameraResult.TER_CAMERA_AF_LOCK_FAILED, e.toString(), this.mCameraDevice);
        }
    }

    public void setCameraCharacteristics(CameraCharacteristics cameraCharacteristics) {
        this.mCameraCharacteristics = cameraCharacteristics;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void setCameraDevice(Object obj) throws ClassCastException {
        this.mCameraDevice = (CameraDevice) obj;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public boolean setExposureCompensation(int i) {
        this.mExposureCompensation = i;
        if (this.mCaptureRequestBuilder == null || this.mCameraSession == null) {
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, -100, "setExposureCompensation : Capture Session is null", this.mCameraDevice);
            return false;
        }
        Integer num = (Integer) this.mCaptureRequestBuilder.get(CaptureRequest.CONTROL_AE_MODE);
        if (num != null && num.intValue() == 0) {
            TELogUtils.w(TAG, "Can't set exposure compensation when ae mode is off.");
            return false;
        }
        if (this.mCameraSettings.mCameraECInfo.exposure == i) {
            TELogUtils.i(TAG, "setExposureCompensation return, no need to set");
            return false;
        }
        this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(i));
        this.mCameraSettings.mCameraECInfo.exposure = i;
        Response responseUpdatePreview = updatePreview(this.mCaptureRequestBuilder);
        if (!responseUpdatePreview.isSuccess) {
            TELogUtils.e(TAG, "setExposureCompensation failed: " + responseUpdatePreview.errMsg);
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_EC_FAILED, TECameraResult.TER_CAMERA_EC_FAILED, responseUpdatePreview.errMsg, this.mCameraDevice);
        }
        return responseUpdatePreview.isSuccess;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void setFpsConfigCallback(TECameraBase.CameraFpsConfigCallback cameraFpsConfigCallback) {
        this.mFpsConfigCallback = cameraFpsConfigCallback;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void setISO(int i) {
        if (this.mCaptureRequestBuilder == null || this.mCameraSession == null) {
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_ISO_FAILED, TECameraResult.TER_CAMERA_ISO_FAILED, "Capture Session is null", this.mCameraDevice);
        }
        if (i > getISORange()[1] || i < getISORange()[0]) {
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_ISO_FAILED, TECameraResult.TER_CAMERA_ISO_FAILED, "invalid iso", this.mCameraDevice);
            return;
        }
        if (!((Integer) this.mCaptureRequestBuilder.get(CaptureRequest.CONTROL_AE_MODE)).equals(0)) {
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, 0);
        }
        if (!((Integer) this.mCaptureRequestBuilder.get(CaptureRequest.CONTROL_MODE)).equals(0)) {
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_MODE, 0);
        }
        this.mCaptureRequestBuilder.set(CaptureRequest.SENSOR_SENSITIVITY, Integer.valueOf(i));
        Response responseUpdatePreview = updatePreview(this.mCaptureRequestBuilder);
        if (responseUpdatePreview.isSuccess) {
            return;
        }
        TELogUtils.e(TAG, "setISO exception: " + responseUpdatePreview.errMsg);
        this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_ISO_FAILED, TECameraResult.TER_CAMERA_ISO_FAILED, responseUpdatePreview.errMsg, this.mCameraDevice);
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void setManualFocusDistance(float f) {
        if (this.mCaptureRequestBuilder == null || this.mCameraSession == null) {
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_MF_FAILED, TECameraResult.TER_CAMERA_MF_FAILED, "Capture Session is null", this.mCameraDevice);
        }
        if (f < 0.0f) {
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_MF_FAILED, TECameraResult.TER_CAMERA_MF_FAILED, "invalid distance", this.mCameraDevice);
            return;
        }
        this.mCaptureRequestBuilder.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(f));
        Response responseUpdatePreview = updatePreview(this.mCaptureRequestBuilder);
        if (responseUpdatePreview.isSuccess) {
            return;
        }
        TELogUtils.e(TAG, "setManualFocusDistance exception: " + responseUpdatePreview.errMsg);
        this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_ISO_FAILED, TECameraResult.TER_CAMERA_ISO_FAILED, responseUpdatePreview.errMsg, this.mCameraDevice);
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public int setPictureSize(int i, int i2) {
        return 0;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void setPictureSizeCallback(TECameraBase.PictureSizeCallBack pictureSizeCallBack) {
        this.mPictureSizeCallback = pictureSizeCallBack;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void setPreviewSizeCallback(TECameraBase.PreviewSizeCallBack previewSizeCallBack) {
        this.mPreviewSizeCallback = previewSizeCallBack;
    }

    public void setSATZoomCallback(TECameraBase.SATZoomCallback sATZoomCallback) {
        this.mSATZoomCallback = sATZoomCallback;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void setShutterTime(long j) {
        if (this.mCaptureRequestBuilder == null || this.mCameraSession == null) {
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_SHUTTER_TIME_FAILED, TECameraResult.TER_CAMERA_SHUTTER_TIME_FAILED, "Capture Session is null", this.mCameraDevice);
        }
        if (j > getShutterTimeRange()[1] || j < getShutterTimeRange()[0]) {
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_SHUTTER_TIME_FAILED, TECameraResult.TER_CAMERA_SHUTTER_TIME_FAILED, "invalid shutter time", this.mCameraDevice);
            return;
        }
        if (!((Integer) this.mCaptureRequestBuilder.get(CaptureRequest.CONTROL_AE_MODE)).equals(0)) {
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, 0);
        }
        if (!((Integer) this.mCaptureRequestBuilder.get(CaptureRequest.CONTROL_MODE)).equals(0)) {
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_MODE, 0);
        }
        this.mCaptureRequestBuilder.set(CaptureRequest.SENSOR_EXPOSURE_TIME, Long.valueOf(j));
        Response responseUpdatePreview = updatePreview(this.mCaptureRequestBuilder);
        if (responseUpdatePreview.isSuccess) {
            return;
        }
        TELogUtils.e(TAG, "setShutterTime exception: " + responseUpdatePreview.errMsg);
        this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_SHUTTER_TIME_FAILED, TECameraResult.TER_CAMERA_SHUTTER_TIME_FAILED, responseUpdatePreview.errMsg, this.mCameraDevice);
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void setWhileBalance(boolean z, String str) {
        if (this.mCaptureRequestBuilder == null || this.mCameraSession == null) {
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_WHILE_BALANCE_NO_SUPPORT, TECameraResult.TER_CAMERA_WHILE_BALANCE_NO_SUPPORT, "Capture Session is null", this.mCameraDevice);
        }
        if (!Arrays.asList((int[]) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES)).contains(Integer.valueOf(this.mWhiteBalanceMap.get(str) == null ? 1 : this.mWhiteBalanceMap.get(str).intValue()))) {
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_WHILE_BALANCE_NO_SUPPORT, TECameraResult.TER_CAMERA_WHILE_BALANCE_NO_SUPPORT, "invalid white balance", this.mCameraDevice);
            return;
        }
        Response responseUpdatePreview = updatePreview(this.mCaptureRequestBuilder);
        if (responseUpdatePreview.isSuccess) {
            return;
        }
        TELogUtils.e(TAG, "setWhiteBalance exception: " + responseUpdatePreview.errMsg);
        this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_WHILE_BALANCE_NO_SUPPORT, TECameraResult.TER_CAMERA_WHILE_BALANCE_NO_SUPPORT, responseUpdatePreview.errMsg, this.mCameraDevice);
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public abstract int startPreview() throws Exception;

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public int startRecording() {
        return 0;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public int startZoom(float f, TECameraSettings.ZoomCallback zoomCallback) {
        CaptureRequest.Builder builder;
        Rect rectCalculateZoomSize = calculateZoomSize(f);
        if (this.mDeviceProxy == null || this.mCaptureRequest == null || this.mCameraSession == null || (builder = this.mCaptureRequestBuilder) == null) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: START_ZOOM. Code: -420. Reason: camera is null");
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_ZOOM_FAILED, TECameraResult.TER_CAMERA_ZOOM_FAILED, "startZoom : Env is null", this.mCameraDevice);
            return -100;
        }
        if (rectCalculateZoomSize == null) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: START_ZOOM. Code: -420. Reason: zoomRect is null");
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_ZOOM_FAILED, TECameraResult.TER_CAMERA_ZOOM_FAILED, "zoom rect is null.", this.mCameraDevice);
            return TECameraResult.TER_CAMERA_ZOOM_FAILED;
        }
        builder.set(CaptureRequest.SCALER_CROP_REGION, rectCalculateZoomSize);
        Response responseUpdatePreview = updatePreview(this.mCaptureRequestBuilder);
        if (responseUpdatePreview.isSuccess) {
            if (zoomCallback != null) {
                zoomCallback.onChange(this.mCameraSettings.mCameraType, f, true);
            }
            fillFeatures();
            return 0;
        }
        TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: START_ZOOM. Code: -420. Reason: " + responseUpdatePreview.getErrMsg());
        this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_ZOOM_FAILED, TECameraResult.TER_CAMERA_ZOOM_FAILED, responseUpdatePreview.errMsg, this.mCameraDevice);
        return TECameraResult.TER_CAMERA_ZOOM_FAILED;
    }

    public void stopCameraFaceDetect(CaptureRequest.Builder builder) {
        if (this.mFaceDetectSupportMode != null) {
            builder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, 0);
        } else {
            TELogUtils.d(TAG, "FaceDetect is not supported!");
        }
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public int stopRecording() {
        return 0;
    }

    public Response stopRepeating() {
        Response response = new Response();
        if (this.mCameraSession == null) {
            response.errMsg = "Capture Session is null";
            TELogUtils.e(TAG, "stopRepeating: " + response.errMsg);
            return response;
        }
        try {
            this.mCameraSession.stopRepeating();
            response.isSuccess = true;
        } catch (CameraAccessException e) {
            e.printStackTrace();
            response.errMsg = e.getMessage();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            response.errMsg = e2.getMessage();
        }
        return response;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void takePicture(int i, int i2, TECameraSettings.PictureCallback pictureCallback) {
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public int toggleTorch(boolean z) {
        CaptureRequest.Builder builder = this.mCaptureRequestBuilder;
        if (builder == null) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: TOGGLE. Code: -100. Reason: mCaptureRequestBuilder is null");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, -100, "toggleTorch : CaptureRequest.Builder is null", this.mCameraDevice);
            this.mCameraEvents.onTorchError(this.mCameraSettings.mCameraType, -100, z ? 1 : 0, "toggleTorch : CaptureRequest.Builder is null", this.mCameraDevice);
            return -100;
        }
        builder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(z ? 2 : 0));
        this.mCameraEvents.onCameraInfo(104, 0, "camera2 will change flash mode " + z, null);
        Response responseUpdatePreview = updatePreview(this.mCaptureRequestBuilder);
        this.mCameraEvents.onCameraInfo(105, 0, "camera2 did change flash mode " + z, null);
        if (responseUpdatePreview.isSuccess) {
            this.mCameraEvents.onTorchSuccess(this.mCameraSettings.mCameraType, 0, z ? 1 : 0, "camera torch success", this.mCameraDevice);
            return 0;
        }
        TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: TOGGLE. Code: -417. Reason: " + responseUpdatePreview.getErrMsg());
        this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_TORCH_FAILED, TECameraResult.TER_CAMERA_TORCH_FAILED, responseUpdatePreview.errMsg, this.mCameraDevice);
        this.mCameraEvents.onTorchError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_TORCH_FAILED, z ? 1 : 0, responseUpdatePreview.errMsg, this.mCameraDevice);
        return TECameraResult.TER_CAMERA_TORCH_FAILED;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public int updateCapture() throws CameraAccessException {
        TETraceUtils.beginSection("TECameraModeBase-updateCapture");
        if (this.mCameraHolder.getProviderManager() == null || this.mCaptureRequestBuilder == null) {
            TELogUtils.e(TAG, "update capture failed");
            return -100;
        }
        if (this.mDeviceProxy.isStabilizationSupported(this.mCameraCharacteristics) && needSetStabilizationParam()) {
            TELogUtils.i(TAG, "Stabilization Supported, toggle = " + this.mCameraSettings.mEnableStabilization);
            if (this.mDeviceProxy.configStabilization(this.mCameraCharacteristics, this.mCaptureRequestBuilder, this.mCameraSettings.mEnableStabilization) == 0 && this.mCameraSettings.mEnableStabilization) {
                this.mCameraEvents.onCameraInfo(113, 1, "enable stablization", this.mCameraDevice);
            }
        }
        this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_MODE, 1);
        setFPSRange();
        Range<Integer> rangeConfigFps = configFps(new Range<>(Integer.valueOf(this.mFpsRange.min / this.mCameraSettings.mFPSRange.fpsUnitFactor), Integer.valueOf(this.mFpsRange.max / this.mCameraSettings.mFPSRange.fpsUnitFactor)));
        this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, rangeConfigFps);
        this.mCameraEvents.onCameraInfo(121, 0, rangeConfigFps.toString(), null);
        this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(this.mExposureCompensation));
        useFaceAEStrategy(this.mUseFaceAE);
        if (Float.compare(this.mCameraSettings.mDefaultZoomRatio, this.mNowZoom) != 0) {
            float fMin = Math.min(this.mCameraSettings.mDefaultZoomRatio, this.mMaxZoom);
            this.mNowZoom = fMin;
            Rect rectCalculateZoomSizeV2 = calculateZoomSizeV2(fMin);
            if (rectCalculateZoomSizeV2 == null) {
                TELogUtils.w(TAG, "calculate default crop_region fail!");
            } else {
                this.mCaptureRequestBuilder.set(CaptureRequest.SCALER_CROP_REGION, rectCalculateZoomSizeV2);
            }
        }
        Response responseUpdatePreview = updatePreview(this.mCaptureRequestBuilder);
        if (!responseUpdatePreview.isSuccess) {
            TELogUtils.e(TAG, "first request failed: " + responseUpdatePreview.errMsg);
        }
        this.mCameraSettings.mRotation = ((Integer) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        this.mCameraHolder.updateSessionState(3);
        fillFeatures();
        TELogUtils.i(TAG, "send capture request..." + this.mCameraSession);
        this.mCameraEvents.onPreviewSuccess(2, 0, 0, "TECamera2 preview", this.mCameraDevice);
        TETraceUtils.endSection();
        return 0;
    }

    public Response updatePreview(CaptureRequest.Builder builder) {
        return updatePreview(builder, this.mPreviewCaptureCallback);
    }

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy.NormalCallbackRequest
    public void updateRequestRepeating(CameraCaptureSession cameraCaptureSession, CaptureRequest.Builder builder) {
        if (cameraCaptureSession != this.mCameraSession || builder != this.mCaptureRequestBuilder) {
            TELogUtils.e(TAG, "updateRequestRepeating failed, session changed...");
            return;
        }
        Response responseUpdatePreview = updatePreview(builder);
        if (responseUpdatePreview.isSuccess) {
            return;
        }
        TELogUtils.e(TAG, "updateRequestRepeating failed: " + responseUpdatePreview.errMsg);
    }

    public void useFaceAEStrategy(int i) {
        if (i == 1) {
            if (this.mCameraSettings.mFacing == 1) {
                startCameraFaceDetect(this.mCaptureRequestBuilder);
                TELogUtils.i(TAG, "use faceae for front");
                return;
            }
            return;
        }
        if (i == 2) {
            if (this.mCameraSettings.mFacing == 0) {
                startCameraFaceDetect(this.mCaptureRequestBuilder);
                TELogUtils.i(TAG, "use faceae for rear");
                return;
            }
            return;
        }
        if (i == 3) {
            startCameraFaceDetect(this.mCaptureRequestBuilder);
            TELogUtils.i(TAG, "use faceae for all");
        }
    }

    public void waitCameraTaskDoneOrTimeout() {
        TECamera2 tECamera2 = this.mCameraHolder;
        if (tECamera2 != null) {
            tECamera2.waitCameraTaskDoneOrTimeout();
            return;
        }
        TELogUtils.d(TAG, "waitCameraTaskDoneOrTimeout failed, " + TELogUtils.getStackTraceString());
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void zoomV2(float f, TECameraSettings.ZoomCallback zoomCallback) {
        if (this.mCameraSession == null || this.mCaptureRequest == null || this.mCaptureRequestBuilder == null) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: START_ZOOM. Code: -420. Reason: camera is null");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_ZOOM_FAILED, "Camera info is null, may be you need reopen camera.", this.mCameraDevice);
            return;
        }
        if (Build.VERSION.SDK_INT >= 30 && this.mEnableMulticamZoom && this.mDeviceProxy.isLogicalMultiCamSupported(this.mCameraCharacteristics)) {
            Range<Float> range = this.mZoomRatioRange;
            if (range != null) {
                Float f2 = (Float) range.getUpper();
                Float f3 = (Float) this.mZoomRatioRange.getLower();
                if (this.mNowZoom * f >= f2.floatValue() && f > 1.0f) {
                    this.mNowZoom = f2.floatValue();
                } else if (this.mNowZoom * f > f3.floatValue() || f > 1.0f) {
                    this.mNowZoom *= f;
                    TELogUtils.e(TAG, "zoom ratio = " + this.mNowZoom);
                } else {
                    this.mNowZoom = f3.floatValue();
                }
            }
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_ZOOM_RATIO, Float.valueOf(this.mNowZoom));
            Response responseUpdatePreview = updatePreview(this.mCaptureRequestBuilder);
            if (!responseUpdatePreview.isSuccess) {
                TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: START_ZOOM. Code: -420. Reason: " + responseUpdatePreview.getErrMsg());
                this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_ZOOM_FAILED, TECameraResult.TER_CAMERA_ZOOM_FAILED, responseUpdatePreview.errMsg, this.mCameraDevice);
                return;
            }
        } else {
            if (this.mNowZoom < this.mMaxZoom || f <= 1.0f) {
                Rect rect = this.mZoomSize;
                if (rect == null || !rect.equals(this.mActiveArraySize) || f > 1.0f) {
                    TELogUtils.d(TAG, "mNowZoom = " + this.mNowZoom);
                    this.mNowZoom = this.mNowZoom * f;
                } else {
                    TELogUtils.d(TAG, "mZoomSize = " + this.mZoomSize + ";mActiveArraySize = " + this.mActiveArraySize + ";factor = " + f);
                    this.mNowZoom = 1.0f;
                }
            } else {
                TELogUtils.d(TAG, "mNowZoom = " + this.mNowZoom + ";mMaxZoom = " + this.mMaxZoom + ";factor = " + f);
                this.mNowZoom = this.mMaxZoom;
            }
            Rect rectCalculateZoomSizeV2 = calculateZoomSizeV2(this.mNowZoom);
            if (rectCalculateZoomSizeV2 == null) {
                return;
            }
            this.mCaptureRequestBuilder.set(CaptureRequest.SCALER_CROP_REGION, rectCalculateZoomSizeV2);
            Response responseUpdatePreview2 = updatePreview(this.mCaptureRequestBuilder);
            if (!responseUpdatePreview2.isSuccess) {
                TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: START_ZOOM. Code: -420. Reason: " + responseUpdatePreview2.getErrMsg());
                this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_ZOOM_FAILED, TECameraResult.TER_CAMERA_ZOOM_FAILED, responseUpdatePreview2.errMsg, this.mCameraDevice);
                return;
            }
            this.mZoomSize = rectCalculateZoomSizeV2;
        }
        if (zoomCallback != null) {
            zoomCallback.onChange(this.mCameraSettings.mCameraType, this.mNowZoom, true);
        }
        fillFeatures();
    }

    public Response capture(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback, Handler handler) {
        Response response = new Response();
        if (captureRequest == null) {
            response.errMsg = "CaptureRequest is null";
            TELogUtils.e(TAG, "capture: " + response.errMsg);
            return response;
        }
        if (this.mCameraSession == null) {
            response.errMsg = "Capture Session is null";
            TELogUtils.e(TAG, "capture: " + response.errMsg);
            return response;
        }
        try {
            this.mCameraSession.capture(captureRequest, captureCallback, handler);
            response.isSuccess = true;
        } catch (CameraAccessException e) {
            e.printStackTrace();
            response.errMsg = e.getMessage();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            response.errMsg = e2.getMessage();
        }
        return response;
    }

    public Response captureBurst(List<CaptureRequest> list, CameraCaptureSession.CaptureCallback captureCallback, Handler handler) {
        Response response = new Response();
        if (this.mCameraSession == null) {
            response.errMsg = "Capture Session is null";
            TELogUtils.e(TAG, "capture: " + response.errMsg);
            return response;
        }
        try {
            this.mCameraSession.captureBurst(list, captureCallback, handler);
            response.isSuccess = true;
        } catch (CameraAccessException e) {
            e.printStackTrace();
            response.errMsg = e.getMessage();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            response.errMsg = e2.getMessage();
        }
        return response;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public int focusAtPoint(TEFocusSettings tEFocusSettings) {
        boolean z;
        if (this.mCameraSettings.mEnableRefactorFocusAndMeter) {
            return doFocusOrMeter(tEFocusSettings);
        }
        this.mFocusSettings = tEFocusSettings;
        this.mFocusStrategy.setFocusSettings(tEFocusSettings);
        this.mFocusStrategy.setCameraSettings(this.mCameraSettings);
        if (this.mDeviceProxy == null || this.mCameraSession == null || this.mCaptureRequestBuilder == null) {
            TELogUtils.w(TAG, "Env is null");
            this.mFocusSettings.getFocusCallback().onFocus(-100, this.mCameraSettings.mFacing, "Env is null");
            return -100;
        }
        boolean zIsMeteringSupported = this.mDeviceProxy.isMeteringSupported(this.mCameraCharacteristics);
        boolean zIsFocusSupported = this.mDeviceProxy.isFocusSupported(this.mCameraCharacteristics);
        if (!zIsFocusSupported && !zIsMeteringSupported) {
            TELogUtils.w(TAG, "do not support MeteringAreaAF!");
            this.mFocusSettings.getFocusCallback().onFocus(TECameraResult.TER_CAMERA_FOCUS_NOT_SUPPORT, this.mCameraSettings.mFacing, "do not support MeteringAreaAF!");
            return TECameraResult.TER_CAMERA_FOCUS_NOT_SUPPORT;
        }
        boolean zIsLock = tEFocusSettings.isLock();
        boolean z2 = this.mManualFocusEngaged.get();
        boolean z3 = (zIsFocusSupported && this.mFocusSettings.isNeedFocus()) ? false : true;
        TELogUtils.d(TAG, "focusAtPoint++");
        if (z2 && !z3) {
            this.mFocusCancelRunnable.run();
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            TELogUtils.d(TAG, "cancel previous touch af..");
        }
        TEFocusSettings tEFocusSettings2 = this.mFocusSettings;
        TECameraSettings tECameraSettings = this.mCameraSettings;
        Rect rectCalculateFocusArea = tEFocusSettings2.calculateFocusArea(tECameraSettings.mRotation, tECameraSettings.mFacing == 1);
        if (rectCalculateFocusArea == null) {
            z = true;
            rectCalculateFocusArea = _calculateFocusRect(this.mFocusSettings.getWidth(), this.mFocusSettings.getHeight(), this.mFocusSettings.getX(), this.mFocusSettings.getY(), this.mCameraSettings.mRotation, 0, this.mFocusSettings.getCoordinatesMode());
        } else {
            z = true;
        }
        TEFocusSettings tEFocusSettings3 = this.mFocusSettings;
        TECameraSettings tECameraSettings2 = this.mCameraSettings;
        Rect rectCalculateMeteringArea = tEFocusSettings3.calculateMeteringArea(tECameraSettings2.mRotation, tECameraSettings2.mFacing == z);
        if (rectCalculateMeteringArea == null) {
            rectCalculateMeteringArea = _calculateFocusRect(this.mFocusSettings.getWidth(), this.mFocusSettings.getHeight(), this.mFocusSettings.getX(), this.mFocusSettings.getY(), this.mCameraSettings.mRotation, 1, this.mFocusSettings.getCoordinatesMode());
        }
        if (!TECameraUtils.isValidRect(rectCalculateFocusArea) || !TECameraUtils.isValidRect(rectCalculateMeteringArea)) {
            TELogUtils.e(TAG, "focusRect or meteringRect is not valid!");
            this.mFocusSettings.getFocusCallback().onFocus(-100, this.mCameraSettings.mFacing, "focusRect or meteringRect is not valid!");
            return -100;
        }
        if (this.mFocusSettings.isNeedMetering() && zIsMeteringSupported) {
            this.mFocusStrategy.configMeter(this.mCaptureRequestBuilder, rectCalculateMeteringArea);
        }
        if (z3) {
            if (zIsMeteringSupported && this.mFocusSettings.isNeedMetering()) {
                CaptureRequest.Builder builder = this.mCaptureRequestBuilder;
                updatePreview(builder, this.mFocusStrategy.getMeteringCaptureCallback(builder, !z3), this.mHandler);
                this.mManualFocusEngaged.set(false);
                if (this.mCameraSettings.mEnableMonitorGyroscope) {
                    this.mCameraHolder.getGyro().register(this.mGyroListener, this.mHandler);
                }
            }
            return TECameraResult.TER_CAMERA_FOCUS_NOT_SUPPORT;
        }
        this.mManualFocusEngaged.set(z);
        this.mFocusStrategy.configFocus(this.mCaptureRequestBuilder, rectCalculateFocusArea);
        if (this.mCameraSettings.mEnableMonitorGyroscope) {
            CaptureRequest.Builder builder2 = this.mCaptureRequestBuilder;
            TELogUtils.i(TAG, "focusAtPoint, capture to trigger focus, response = " + capture(builder2, this.mFocusStrategy.getFocusCaptureCallback(builder2, this.mManualFocusEngaged, zIsLock), this.mHandler).isSuccess);
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
        }
        CaptureRequest.Builder builder3 = this.mCaptureRequestBuilder;
        Response responseUpdatePreview = updatePreview(builder3, this.mFocusStrategy.getFocusCaptureCallback(builder3, this.mManualFocusEngaged, zIsLock), this.mHandler);
        if (!responseUpdatePreview.isSuccess) {
            this.mManualFocusEngaged.set(false);
            this.mFocusSettings.getFocusCallback().onFocus(-108, this.mCameraSettings.mFacing, responseUpdatePreview.errMsg);
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_FOCUS_FAILED, TECameraResult.TER_CAMERA_FOCUS_FAILED, responseUpdatePreview.errMsg, this.mCameraDevice);
            return -108;
        }
        if (this.mCameraSettings.mEnableMonitorGyroscope && !zIsLock) {
            this.mCameraHolder.getGyro().register(this.mGyroListener, this.mHandler);
        }
        TELogUtils.i(TAG, "focusAtPoint, done");
        return 0;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void takePicture(TECameraSettings.PictureCallback pictureCallback, int i) {
        if (this.mCameraLightOn) {
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, 3);
            this.mCaptureRequestBuilder.set(CaptureRequest.FLASH_MODE, 1);
        }
    }

    public Response updatePreview(CaptureRequest.Builder builder, CameraCaptureSession.CaptureCallback captureCallback) {
        return updatePreview(builder, captureCallback, getCameraHandler());
    }

    public Response updatePreview(CaptureRequest.Builder builder, CameraCaptureSession.CaptureCallback captureCallback, Handler handler) {
        TETraceUtils.beginSection("TECameraModeBase-updatePreview");
        Response response = new Response();
        if (builder == null) {
            response.errMsg = "CaptureRequest.Builder is null";
            TELogUtils.e(TAG, "updatePreview: " + response.errMsg);
            return response;
        }
        if (this.mCameraSession == null) {
            response.errMsg = "Capture Session is null";
            TELogUtils.e(TAG, "updatePreview: " + response.errMsg);
            return response;
        }
        CaptureRequest captureRequestBuild = builder.build();
        this.mCaptureRequest = captureRequestBuild;
        try {
            this.mCameraSession.setRepeatingRequest(captureRequestBuild, captureCallback, handler);
            response.isSuccess = true;
            this.mIsActiveCameraSession = true;
        } catch (CameraAccessException e) {
            e.printStackTrace();
            response.errMsg = e.getMessage();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            response.errMsg = e2.getMessage();
        } catch (IllegalStateException e3) {
            e3.printStackTrace();
            response.errMsg = e3.getMessage();
            this.mIsActiveCameraSession = false;
        } catch (SecurityException e4) {
            e4.printStackTrace();
            response.errMsg = e4.getMessage();
        }
        TETraceUtils.endSection();
        return response;
    }

    public Response capture(CaptureRequest.Builder builder, CameraCaptureSession.CaptureCallback captureCallback, Handler handler) {
        Response response = new Response();
        if (builder == null) {
            response.errMsg = "CaptureRequest.Builder is null";
            TELogUtils.e(TAG, "capture: " + response.errMsg);
            return response;
        }
        if (this.mCameraSession == null) {
            response.errMsg = "Capture Session is null";
            TELogUtils.e(TAG, "capture: " + response.errMsg);
            return response;
        }
        try {
            this.mCameraSession.capture(builder.build(), captureCallback, handler);
            response.isSuccess = true;
        } catch (CameraAccessException e) {
            e.printStackTrace();
            response.errMsg = e.getMessage();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            response.errMsg = e2.getMessage();
        }
        return response;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void stopZoom() {
    }

    public Range<Integer> configFps(Range<Integer> range) {
        return range;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void process(TECameraSettings.Operation operation) {
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void setFeatureParameter(Bundle bundle) {
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void setSceneMode(int i) {
    }
}
