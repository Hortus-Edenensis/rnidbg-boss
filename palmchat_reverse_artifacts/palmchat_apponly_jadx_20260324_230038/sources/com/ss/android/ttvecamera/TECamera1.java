package com.ss.android.ttvecamera;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.SurfaceHolder;
import androidx.annotation.RequiresApi;
import com.bytedance.bpea.basics.Cert;
import com.huawei.hms.framework.common.ContainerUtils;
import com.oplus.tblplayer.processor.util.EffectConstants;
import com.ss.android.ttvecamera.ITECameraArea;
import com.ss.android.ttvecamera.TECameraBase;
import com.ss.android.ttvecamera.TECameraFrame;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.cameracapabilitycollector.TECameraCapabilityCollector;
import com.ss.android.ttvecamera.focusmanager.TEFocusManager;
import com.ss.android.ttvecamera.framework.TECameraFeature;
import com.ss.android.ttvecamera.provider.TECallbackWithBufferProvider;
import com.ss.android.ttvecamera.provider.TECameraProviderManager;
import com.wifi.ad.core.interactive.WkInteractiveManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TECamera1 extends TECameraBase {
    private static final int MIN_GAP_TIME = 200;
    private static final String TAG = "TECamera1";
    Camera mCameraDevice;
    private boolean mCameraLightOn;
    private String mDefaultFocusMode;
    private int mExposureCompensation;
    private TEFocusManager mFocusManager;
    private AtomicBoolean mHasPreviewBufferFlag;
    private int mNumberOfCameras;
    private Camera.Parameters mParams;
    private long mStartPreviewTime;
    private List<TEFrameSizei> mSupportedPictureSizes;
    private List<TEFrameSizei> mSupportedPreviewSizes;
    private List<TEFrameSizei> mSupportedVideoSizes;
    SurfaceHolder mSurfaceHolder;
    private int mUseFaceAE;
    private List<Integer> mZoomRatios;
    private float mZoomValue;

    private TECamera1(Context context, TECameraBase.CameraEvents cameraEvents, Handler handler, TECameraBase.PictureSizeCallBack pictureSizeCallBack) {
        super(context, cameraEvents, handler, pictureSizeCallBack);
        this.mDefaultFocusMode = "";
        this.mNumberOfCameras = 0;
        this.mSupportedPreviewSizes = new ArrayList();
        this.mSupportedPictureSizes = new ArrayList();
        this.mSupportedVideoSizes = new ArrayList();
        this.mZoomRatios = null;
        this.mZoomValue = 100.0f;
        this.mExposureCompensation = 0;
        this.mHasPreviewBufferFlag = new AtomicBoolean(false);
        this.mStartPreviewTime = 0L;
        this.mUseFaceAE = 0;
        this.mCameraLightOn = false;
        this.mCameraSettings = new TECameraSettings(context, 1);
        this.mFocusManager = new TEFocusManager(1);
        this.openPrivacyCert = null;
    }

    private void applyCaptureScene() {
        if (this.mCameraSettings.mOptCameraSceneFps) {
            try {
                this.mParams.setRecordingHint(false);
                this.mCameraDevice.setParameters(this.mParams);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void applyRecordScene() {
        if (this.mCameraSettings.mOptCameraSceneFps) {
            try {
                this.mParams.setRecordingHint(true);
                this.mCameraDevice.setParameters(this.mParams);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static List<TEFrameRateRange> convertRanges(List<int[]> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int[] iArr : list) {
            arrayList.add(new TEFrameRateRange(iArr[0], iArr[1]));
        }
        return arrayList;
    }

    public static List<TEFrameSizei> convertSizes(List<Camera.Size> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Camera.Size size : list) {
            arrayList.add(new TEFrameSizei(size.width, size.height));
        }
        return arrayList;
    }

    public static TECamera1 create(Context context, TECameraBase.CameraEvents cameraEvents, Handler handler, TECameraBase.PictureSizeCallBack pictureSizeCallBack) {
        return new TECamera1(context, cameraEvents, handler, pictureSizeCallBack);
    }

    private int getNearestZoomIndex(int i) {
        int size = this.mZoomRatios.size() - 1;
        int i2 = 0;
        while (size - i2 > 1) {
            int i3 = (i2 + size) / 2;
            if (i > this.mZoomRatios.get(i3).intValue()) {
                i2 = i3;
            } else {
                size = i3;
            }
        }
        return Math.abs(i - this.mZoomRatios.get(i2).intValue()) > Math.abs(i - this.mZoomRatios.get(size).intValue()) ? size : i2;
    }

    private List<TEFrameRateRange> getSupportedFpsRanges() {
        Camera.Parameters parameters = this.mParams;
        if (parameters == null) {
            return null;
        }
        return convertRanges(parameters.getSupportedPreviewFpsRange());
    }

    private List<TEFrameSizei> getSupportedVideoSizes() {
        Camera.Parameters parameters = this.mParams;
        if (parameters == null || parameters.getSupportedVideoSizes() == null) {
            this.mSupportedVideoSizes.clear();
            return this.mSupportedVideoSizes;
        }
        List<TEFrameSizei> listConvertSizes = convertSizes(this.mParams.getSupportedVideoSizes());
        this.mSupportedVideoSizes = listConvertSizes;
        return listConvertSizes;
    }

    private int initCamera() {
        int[] fpsRange;
        TEFrameSizei pictureSize;
        Camera camera = this.mCameraDevice;
        if (camera == null) {
            TELogUtils.e(TAG, "initCamera: Camera is not opened!");
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_OPEN_FAILED, "initCamera: Camera is not opened!", this.mCameraDevice);
            return TECameraResult.TER_CAMERA_OPEN_FAILED;
        }
        Camera.Parameters parameters = camera.getParameters();
        this.mParams = parameters;
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        if (this.mFpsConfigCallback != null) {
            int size = supportedPreviewFpsRange.size();
            ArrayList arrayList = new ArrayList(size);
            int i = 0;
            boolean z = true;
            while (i < size) {
                int[] iArr = supportedPreviewFpsRange.get(i);
                int i2 = iArr[0];
                boolean z2 = i2 >= 1000;
                int[] iArr2 = new int[2];
                if (i2 >= 1000) {
                    i2 /= 1000;
                }
                iArr2[0] = i2;
                int i3 = iArr[1];
                if (i3 >= 1000) {
                    i3 /= 1000;
                }
                iArr2[1] = i3;
                arrayList.add(iArr2);
                i++;
                z = z2;
            }
            fpsRange = this.mFpsConfigCallback.config(arrayList);
            if (z && fpsRange != null) {
                fpsRange[0] = fpsRange[0] * 1000;
                fpsRange[1] = fpsRange[1] * 1000;
            }
        } else {
            fpsRange = null;
        }
        if (fpsRange == null) {
            int fpsUnitFactor = TEFrameRateRange.getFpsUnitFactor(supportedPreviewFpsRange);
            TECameraSettings tECameraSettings = this.mCameraSettings;
            fpsRange = TECameraUtils.getFpsRange(tECameraSettings.mCameraFrameRateStrategy, tECameraSettings.mFacing, tECameraSettings.mFPSRange.mulFactor(fpsUnitFactor), supportedPreviewFpsRange);
            if (fpsRange == null && supportedPreviewFpsRange.size() > 0) {
                fpsRange = supportedPreviewFpsRange.get(supportedPreviewFpsRange.size() - 1);
            }
        }
        if (fpsRange == null) {
            throw new IllegalStateException("fps config failed");
        }
        TELogUtils.i(TAG, "Selected FPS Range: " + fpsRange[0] + "," + fpsRange[1]);
        this.mCameraEvents.onCameraInfo(121, 0, new TEFrameRateRange(fpsRange[0], fpsRange[1]).toString(), null);
        TECameraBase.PreviewSizeCallBack previewSizeCallBack = this.mPreviewSizeCallback;
        if (previewSizeCallBack != null) {
            TEFrameSizei previewSize = previewSizeCallBack.getPreviewSize(getSupportedPreviewSizes());
            if (previewSize != null) {
                this.mCameraSettings.mPreviewSize = previewSize;
            } else {
                this.mCameraSettings.mPreviewSize = TECameraUtils.calcPreviewSize(getSupportedPreviewSizes(), this.mCameraSettings.mPreviewSize);
            }
        } else {
            this.mCameraSettings.mPreviewSize = TECameraUtils.calcPreviewSize(getSupportedPreviewSizes(), this.mCameraSettings.mPreviewSize);
        }
        TELogUtils.i(TAG, "Preview Size:" + this.mCameraSettings.mPreviewSize);
        List<Integer> supportedPictureFormats = this.mParams.getSupportedPictureFormats();
        int i4 = (this.mCameraSettings.mEnableYuvBufferCapture && supportedPictureFormats != null && supportedPictureFormats.contains(17)) ? 17 : 256;
        this.mParams.setPictureFormat(i4);
        if (i4 == 256) {
            this.mParams.setJpegQuality(100);
        }
        TECameraSettings tECameraSettings2 = this.mCameraSettings;
        if (tECameraSettings2.mUseMaxWidthTakePicture) {
            List<TEFrameSizei> listConvertSizes = convertSizes(this.mParams.getSupportedPictureSizes());
            TEFrameSizei previewSize2 = this.mCameraSettings.getPreviewSize();
            TECameraSettings tECameraSettings3 = this.mCameraSettings;
            tECameraSettings2.mPictureSize = TECameraUtils.getClosestSupportedSize(listConvertSizes, previewSize2, tECameraSettings3.mMaxWidth, tECameraSettings3.mMaxWidthTakePictureSizeAccuracy);
        } else {
            if (this.mPictureSizeCallback != null) {
                List<TEFrameSizei> listConvertSizes2 = convertSizes(this.mParams.getSupportedPictureSizes());
                ArrayList arrayList2 = new ArrayList();
                if (i4 == 17 && listConvertSizes2 != null) {
                    for (TEFrameSizei tEFrameSizei : listConvertSizes2) {
                        if (tEFrameSizei.width % 16 == 0 && tEFrameSizei.height % 16 == 0) {
                            arrayList2.add(tEFrameSizei);
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        TELogUtils.e(TAG, "final pic sizes is empty...");
                    }
                }
                if (arrayList2.isEmpty()) {
                    arrayList2.addAll(listConvertSizes2);
                }
                pictureSize = this.mPictureSizeCallback.getPictureSize(arrayList2, convertSizes(this.mParams.getSupportedPreviewSizes()));
            } else {
                pictureSize = null;
            }
            if (pictureSize != null) {
                this.mCameraSettings.mPictureSize = pictureSize;
            } else {
                TECameraSettings tECameraSettings4 = this.mCameraSettings;
                List<TEFrameSizei> supportedPictureSizes = getSupportedPictureSizes();
                TECameraSettings tECameraSettings5 = this.mCameraSettings;
                tECameraSettings4.mPictureSize = TECameraUtils.getClosestSupportedSize(supportedPictureSizes, tECameraSettings5.mPreviewSize, tECameraSettings5.mPictureSize);
            }
        }
        TEFrameSizei tEFrameSizei2 = this.mCameraSettings.mPictureSize;
        if (tEFrameSizei2 != null) {
            this.mParams.setPictureSize(tEFrameSizei2.width, tEFrameSizei2.height);
            TELogUtils.i(TAG, "Picture Size:" + this.mCameraSettings.mPictureSize);
        } else {
            TELogUtils.e(TAG, "No closest supported picture size");
        }
        Camera.Parameters parameters2 = this.mParams;
        TEFrameSizei tEFrameSizei3 = this.mCameraSettings.mPreviewSize;
        parameters2.setPreviewSize(tEFrameSizei3.width, tEFrameSizei3.height);
        Bundle bundle = this.mCameraSettings.mExtParameters;
        if (bundle == null || !bundle.getBoolean(TECameraSettings.Parameters.ENABLE_DIM_LIGHT_QUALITY) || fpsRange[0] <= fpsRange[1]) {
            this.mParams.setPreviewFpsRange(fpsRange[0], fpsRange[1]);
            if (this.mCameraSettings.mIsUseHint) {
                TELogUtils.d(TAG, "use setRecordingHint");
                this.mParams.setRecordingHint(true);
            }
        }
        this.mParams.setWhiteBalance("auto");
        this.mParams.setSceneMode("auto");
        this.mParams.setPreviewFormat(this.mCameraSettings.mImageFormat);
        this.mParams.setExposureCompensation(this.mExposureCompensation);
        if (this.mCameraSettings.mEnableStabilization) {
            if (this.mParams.isVideoStabilizationSupported()) {
                this.mParams.setVideoStabilization(true);
                TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_STABILIZATION, 1L);
                this.mCameraEvents.onCameraInfo(113, 1, "", this.mCameraDevice);
            } else {
                TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_STABILIZATION, 0L);
            }
        }
        TEFocusManager tEFocusManager = this.mFocusManager;
        TECameraSettings tECameraSettings6 = this.mCameraSettings;
        String strSelectFocusMode = tEFocusManager.selectFocusMode(tECameraSettings6.mFacing, this.mParams, tECameraSettings6.mExtParameters.getBoolean("enableFrontFacingVideoContinueFocus"));
        this.mDefaultFocusMode = strSelectFocusMode;
        if (strSelectFocusMode != "") {
            this.mParams.setFocusMode(strSelectFocusMode);
        } else {
            TELogUtils.w(TAG, "No Supported Focus Mode for Facing" + this.mCameraSettings.mFacing);
        }
        this.mCameraSettings.mCameraECInfo.max = this.mParams.getMaxExposureCompensation();
        this.mCameraSettings.mCameraECInfo.min = this.mParams.getMinExposureCompensation();
        this.mCameraSettings.mCameraECInfo.step = this.mParams.getExposureCompensationStep();
        this.mCameraSettings.mCameraECInfo.exposure = this.mParams.getExposureCompensation();
        if (this.mCameraSettings.mEnableZsl) {
            String str = this.mParams.get("zsl-values");
            if (WkInteractiveManager.TimingTypeOff.equals(this.mParams.get(TECameraFeature.KEY_ZSL)) && str != null && str.contains(BuildConfig.USE_CLOUD_CONFIG)) {
                this.mParams.set(TECameraFeature.KEY_ZSL, BuildConfig.USE_CLOUD_CONFIG);
            }
            boolean zEquals = BuildConfig.USE_CLOUD_CONFIG.equals(this.mParams.get(TECameraFeature.KEY_ZSL));
            this.mZslSupport = zEquals;
            if (!zEquals && this.mCameraSettings.mEnableZsl && TextUtils.isEmpty(str) && TECamera1MTKUtils.isMTKPlatform() && TECamera1MTKUtils.isSupportZsdMode()) {
                String str2 = this.mParams.get("zsd-mode-values");
                if (WkInteractiveManager.TimingTypeOff.equals(this.mParams.get("zsd-mode")) && str2 != null && str2.contains(BuildConfig.USE_CLOUD_CONFIG)) {
                    this.mParams.set("zsd-mode", BuildConfig.USE_CLOUD_CONFIG);
                }
                this.mZslSupport = BuildConfig.USE_CLOUD_CONFIG.equals(this.mParams.get("zsd-mode"));
            }
        }
        Object[] objArr = new Object[1];
        objArr[0] = this.mZslSupport ? "Enable" : "Disable";
        TELogUtils.i(TAG, String.format("%s zsl", objArr));
        this.mZoomRatios = null;
        if (this.mParams.isZoomSupported()) {
            this.mZoomRatios = this.mParams.getZoomRatios();
            this.mMaxZoom = this.mParams.getMaxZoom();
            Collections.sort(this.mZoomRatios);
            this.mZoomValue = 100.0f;
        } else {
            TELogUtils.e(TAG, "camera don't support zoom");
        }
        if (this.mCameraSettings.mExtParameters.containsKey("enableShutterSound")) {
            try {
                this.mCameraDevice.enableShutterSound(this.mCameraSettings.mExtParameters.getBoolean("enableShutterSound"));
            } catch (Exception e) {
                TELogUtils.e(TAG, "unsupport enableShutterSound, " + e.getMessage());
            }
        }
        this.mCameraDevice.setParameters(this.mParams);
        try {
            this.mCameraDevice.setDisplayOrientation(0);
        } catch (Throwable unused) {
        }
        this.mCameraLightOn = false;
        return 0;
    }

    private int innerOpen(Cert cert) {
        Exception e;
        int iInitCamera;
        TETraceUtils.beginSection("TECamera1-innerOpen");
        this.mExposureCompensation = 0;
        this.openPrivacyCert = cert;
        int i = TECameraResult.TER_CAMERA_OPEN_FAILED;
        try {
            TECameraSettings tECameraSettings = this.mCameraSettings;
            if (!tECameraSettings.mPreferOpenCameraByCameraId || TextUtils.isEmpty(tECameraSettings.mStrCustomizedCameraID)) {
                int numberOfCameras = Camera.getNumberOfCameras();
                this.mNumberOfCameras = numberOfCameras;
                TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_SIZE, numberOfCameras);
                TELogUtils.i(TAG, "innerOpen mNumberOfCameras: " + this.mNumberOfCameras + ", current mDefaultCameraID:" + this.mCameraSettings.mDefaultCameraID);
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                int i2 = 0;
                while (true) {
                    if (i2 >= this.mNumberOfCameras) {
                        break;
                    }
                    Camera.getCameraInfo(i2, cameraInfo);
                    TELogUtils.i(TAG, "innerOpen cameraInfo facing: " + cameraInfo.facing + ", mCameraSettings.mFacing:" + this.mCameraSettings.mFacing);
                    int i3 = cameraInfo.facing;
                    TECameraSettings tECameraSettings2 = this.mCameraSettings;
                    if (i3 == tECameraSettings2.mFacing) {
                        tECameraSettings2.mDefaultCameraID = i2;
                        break;
                    }
                    i2++;
                }
            } else {
                Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
                int i4 = Integer.parseInt(this.mCameraSettings.mStrCustomizedCameraID);
                Camera.getCameraInfo(i4, cameraInfo2);
                TECameraSettings tECameraSettings3 = this.mCameraSettings;
                tECameraSettings3.mDefaultCameraID = i4;
                this.mNewFacing = tECameraSettings3.mFacing;
            }
            TECameraSettings tECameraSettings4 = this.mCameraSettings;
            int i5 = tECameraSettings4.mDefaultCameraID;
            if (i5 == -1 && this.mNumberOfCameras > 0 && tECameraSettings4.mEnableOpenCamera1Crs) {
                TELogUtils.w(TAG, "innerOpen: camera info check error");
                throw new RuntimeException("CameraIDError");
            }
            if (i5 == -1 && this.mNumberOfCameras > 0 && tECameraSettings4.mEnableOpenCamera1Opt) {
                TELogUtils.w(TAG, "innerOpen: camera info check, set CameraID to 0");
                this.mCameraSettings.mDefaultCameraID = 0;
            }
            TELogUtils.i(TAG, "innerOpen: " + this.mCameraSettings.mDefaultCameraID);
            this.mCameraEvents.onCameraInfo(106, 0, "will start camera1", null);
            TETraceUtils.beginSection("TECamera1-innerOpen-openCamera");
            int i6 = this.mCameraSettings.mDefaultCameraID;
            if (i6 < 0) {
                this.mCameraDevice = TECamera1PolicyAdapter.openCamera(cert, i6);
                this.mCameraSettings.mFacing = 0;
                this.mNewFacing = 0;
                Camera.CameraInfo cameraInfo3 = new Camera.CameraInfo();
                int i7 = 0;
                while (true) {
                    if (i7 >= this.mNumberOfCameras) {
                        break;
                    }
                    Camera.getCameraInfo(i7, cameraInfo3);
                    if (cameraInfo3.facing == this.mNewFacing) {
                        this.mCameraSettings.mDefaultCameraID = i7;
                        break;
                    }
                    i7++;
                }
            } else {
                this.mCameraDevice = TECamera1PolicyAdapter.openCamera(cert, i6);
            }
            TETraceUtils.endSection();
            TELogUtils.i(TAG, "innerOpen mNewFacing: " + this.mNewFacing);
            TELogUtils.i(TAG, "innerOpen mCameraSettings.mDefaultCameraID: " + this.mCameraSettings.mDefaultCameraID);
            this.mCameraEvents.onCameraInfo(107, 0, "did start camera1", null);
            if (this.mCameraDevice == null) {
                TELogUtils.e(TAG, "Open Camera Failed with ID:" + this.mCameraSettings.mDefaultCameraID);
                if (this.mCameraSettings.mDefaultCameraID == -1) {
                    i = TECameraResult.TER_CAMERA_INVALID_CAMERA_ID;
                }
                this.mCameraEvents.onCameraOpened(1, i, null, this.mCameraDevice);
                return i;
            }
            try {
                TETraceUtils.beginSection("TECamera1-initCamera");
                iInitCamera = initCamera();
            } catch (Exception e2) {
                e = e2;
                iInitCamera = 0;
            }
            try {
                TETraceUtils.endSection();
                TETraceUtils.beginSection("TECamera1-fillFeatures");
                fillFeatures();
                TETraceUtils.endSection();
                this.mCameraEvents.onCameraInfo(1, 0, "TECamera1 features is ready", this.mCameraDevice);
            } catch (Exception e3) {
                e = e3;
                TELogUtils.e(TAG, "Open init Camera Failed!: " + Log.getStackTraceString(e));
                TECameraExceptionMonitor.monitorException(e);
            }
            this.mCameraEvents.onCameraOpened(1, iInitCamera, this, this.mCameraDevice);
            TETraceUtils.endSection();
            return iInitCamera;
        } catch (RuntimeException e4) {
            TELogUtils.e(TAG, "Open Camera Failed!: " + Log.getStackTraceString(e4));
            if (e4.getMessage() != null) {
                if (e4.getMessage().equals("Fail to connect to camera service")) {
                    i = TECameraResult.TER_CAMERA_DEVICE_ERROR;
                } else if (e4.getMessage().equals("Camera initialization failed")) {
                    i = TECameraResult.TER_CAMERA_SERVER_ERROR;
                }
            }
            TECameraExceptionMonitor.monitorException(e4);
            this.mCameraEvents.onCameraOpened(1, i, null, this.mCameraDevice);
            this.mCameraDevice = null;
            return i;
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void cancelFocus() {
        TELogUtils.d(TAG, "cancelFocus...");
        Camera camera = this.mCameraDevice;
        if (camera != null) {
            try {
                camera.cancelAutoFocus();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void close(Cert cert) {
        this.mCameraLightOn = false;
        TELogUtils.i(TAG, "Camera close start...");
        if (this.mCameraDevice != null) {
            if (this.mIsRunning) {
                try {
                    TELogUtils.i(TAG, "Camera close torch...");
                    Camera.Parameters parameters = this.mCameraDevice.getParameters();
                    this.mParams = parameters;
                    parameters.setFlashMode(WkInteractiveManager.TimingTypeOff);
                    this.mCameraDevice.setParameters(this.mParams);
                    TELogUtils.i(TAG, "Camera stopPreview...");
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    this.mCameraDevice.stopPreview();
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    TELogUtils.i(TAG, "Camera stopPreview end...");
                    TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_1_STOP_PREVIEW_COST, jCurrentTimeMillis2);
                    TELogUtils.logMonitorInfo(TECameraMonitor.TE_RECORD_CAMERA_1_STOP_PREVIEW_COST, Long.valueOf(jCurrentTimeMillis2));
                    if (this.mProviderMgr.getProviderType() == 1) {
                        this.mProviderMgr.getSurfaceTexture().setOnFrameAvailableListener(null, null);
                    } else if (this.mProviderMgr.getProviderType() == 4) {
                        this.mCameraDevice.setPreviewCallbackWithBuffer(null);
                    }
                } catch (Exception e) {
                    TELogUtils.e(TAG, "Close camera failed: " + e.getMessage());
                }
                this.mIsRunning = false;
            }
            try {
                this.mCameraDevice.setErrorCallback(null);
                this.mCameraEvents.onCameraInfo(108, 0, "will close camera1", null);
                TECamera1PolicyAdapter.closeCamera(cert, this.mCameraDevice);
                this.mCameraEvents.onCameraInfo(109, 0, "did close camera1", null);
            } catch (Exception e2) {
                TELogUtils.e(TAG, "Camera release failed: " + e2.getMessage());
            }
            this.mHasPreviewBufferFlag.set(false);
            this.mCameraDevice = null;
            TELogUtils.i(TAG, "Camera closed end!");
            this.mCameraEvents.onCameraClosed(1, this, this.mCameraDevice);
        }
        this.openPrivacyCert = null;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void collectCameraCapabilities() {
        TETraceUtils.beginSection("TECamera1-collectCameraCapabilities");
        if (!isNeedCollectCameraCapabilities()) {
            TETraceUtils.endSection();
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            if (this.mParams != null) {
                this.mCameraCapabilitiesMap.putOpt("camera_id", Integer.valueOf(this.mCameraSettings.mDefaultCameraID));
                if (this.mParams.isZoomSupported()) {
                    this.mCameraCapabilitiesMap.putOpt("camera_zoom_max_ability", Integer.valueOf(this.mParams.getMaxZoom()));
                }
                List<TEFrameSizei> supportedPreviewSizes = getSupportedPreviewSizes();
                if (supportedPreviewSizes != null) {
                    this.mCapabilityCollector.addCapability(new TECameraCapabilityCollector.CapabilityDescription(TECameraCapabilityCollector.Capability.PREVIEW_SIZE, TECameraCapabilityCollector.DataType.STRING, this.mCameraSettings.mStrCameraID + ContainerUtils.KEY_VALUE_DELIMITER + supportedPreviewSizes.toString()));
                    JSONArray jSONArray = new JSONArray();
                    for (TEFrameSizei tEFrameSizei : supportedPreviewSizes) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.putOpt("width", Integer.valueOf(tEFrameSizei.width));
                        jSONObject.putOpt("height", Integer.valueOf(tEFrameSizei.height));
                        jSONArray.put(jSONObject);
                    }
                    this.mCameraCapabilitiesMap.putOpt("preview_size_lit", jSONArray);
                }
            }
        } catch (Exception unused) {
        }
        List<int[]> supportedPreviewFpsRange = this.mParams.getSupportedPreviewFpsRange();
        StringBuilder sb = new StringBuilder(this.mCameraSettings.mStrCameraID + ContainerUtils.KEY_VALUE_DELIMITER);
        try {
            JSONArray jSONArray2 = new JSONArray();
            if (supportedPreviewFpsRange != null) {
                for (int[] iArr : supportedPreviewFpsRange) {
                    sb.append("[");
                    sb.append(iArr[0] / 1000);
                    sb.append(",");
                    sb.append(iArr[1] / 1000);
                    sb.append("]");
                    if (supportedPreviewFpsRange.indexOf(iArr) != supportedPreviewFpsRange.size() - 1) {
                        sb.append(", ");
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("fps_min", Integer.valueOf(iArr[0] / 1000));
                    jSONObject2.putOpt("fps_max", Integer.valueOf(iArr[1] / 1000));
                    jSONArray2.put(jSONObject2);
                }
                this.mCapabilityCollector.addCapability(new TECameraCapabilityCollector.CapabilityDescription(TECameraCapabilityCollector.Capability.FPS_RANGE, TECameraCapabilityCollector.DataType.STRING, sb.toString()));
                this.mCameraCapabilitiesMap.putOpt("fps_range_list", jSONArray2);
            }
        } catch (Exception unused2) {
        }
        this.mCapabilityCollector.upload();
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        TELogUtils.i(TAG, "collectCameraCapabilities consume: " + jCurrentTimeMillis2);
        TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_COLLECT_CAPBILITIES_COST, jCurrentTimeMillis2);
        this.mHaveCollectedCapbilities = true;
        TETraceUtils.endSection();
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void enableCaf() {
        if (this.mCameraDevice == null || this.mParams == null) {
            return;
        }
        TELogUtils.d(TAG, "enableCaf...");
        try {
            if (this.mParams.getSupportedFocusModes().contains("continuous-video")) {
                this.mCameraDevice.cancelAutoFocus();
                this.mParams.setFocusMode("continuous-video");
                this.mCameraDevice.setParameters(this.mParams);
            }
        } catch (Throwable th) {
            String str = "Error: focusAtPoint failed: " + th.toString();
            TELogUtils.e(TAG, str);
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_FOCUS_FAILED, str, this.mCameraDevice);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    @RequiresApi(api = 21)
    public Bundle fillFeatures() {
        Camera.Parameters parameters;
        this.mCameraSettings.mStrCameraID = this.mCameraSettings.mFacing + "";
        Bundle bundleFillFeatures = super.fillFeatures();
        if (bundleFillFeatures != null) {
            bundleFillFeatures.putParcelableArrayList(TECameraSettings.Features.SUPPORT_PREVIEW_SIZES, (ArrayList) getSupportedPreviewSizes());
            bundleFillFeatures.putParcelableArrayList(TECameraSettings.Features.SUPPORT_PICTURE_SIZES, (ArrayList) getSupportedPictureSizes());
            bundleFillFeatures.putParcelableArrayList(TECameraSettings.Features.SUPPORT_VIDEO_SIZES, (ArrayList) getSupportedVideoSizes());
            bundleFillFeatures.putParcelableArrayList(TECameraSettings.Features.CAMERA_SUPPORT_FPS_RANGE, (ArrayList) getSupportedFpsRanges());
            bundleFillFeatures.putParcelable(TECameraSettings.Features.CAMERA_PREVIEW_SIZE, this.mCameraSettings.mPreviewSize);
            try {
                bundleFillFeatures.putBoolean(TECameraSettings.Features.CAMERA_TORCH_SUPPORTED, (this.mCameraDevice == null || (parameters = this.mParams) == null || parameters.getSupportedFlashModes() == null) ? false : true);
            } catch (Exception e) {
                TELogUtils.e(TAG, "Get camera torch information failed: " + e.toString());
                bundleFillFeatures.putBoolean(TECameraSettings.Features.CAMERA_TORCH_SUPPORTED, false);
            }
        }
        return bundleFillFeatures;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void focusAtPoint(final TEFocusSettings tEFocusSettings) {
        Camera.Parameters parameters;
        Camera camera = this.mCameraDevice;
        if (camera == null) {
            TELogUtils.e(TAG, "focusAtPoint: camera is null.");
            tEFocusSettings.getFocusCallback().onFocus(TECameraResult.TER_CAMERA_INTERNAL_ERROR, this.mCameraSettings.mFacing, "focusAtPoint: camera is null.");
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "focusAtPoint: camera is null.", this.mCameraDevice);
            return;
        }
        boolean z = false;
        try {
            parameters = camera.getParameters();
            this.mParams = parameters;
        } catch (Exception e) {
            String str = "Error: focusAtPoint failed: " + e.toString();
            TELogUtils.e(TAG, str);
            tEFocusSettings.getFocusCallback().onFocus(TECameraResult.TER_CAMERA_FOCUS_FAILED, this.mCameraSettings.mFacing, str);
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_FOCUS_FAILED, str, this.mCameraDevice);
        }
        if (!this.mFocusManager.isSupportedFocus(parameters, this.mDefaultFocusMode)) {
            TELogUtils.e(TAG, "Error: not support focus.");
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_FOCUS_NOT_SUPPORT, TECameraResult.TER_CAMERA_FOCUS_NOT_SUPPORT, "Error: not support focus.", this.mCameraDevice);
            if (!this.mFocusManager.isSupportedMetering(this.mCameraSettings.mFacing, this.mParams) || !tEFocusSettings.isNeedMetering()) {
                tEFocusSettings.getFocusCallback().onFocus(TECameraResult.TER_CAMERA_FOCUS_NOT_SUPPORT, this.mCameraSettings.mFacing, "Error: not support focus.");
                return;
            }
            if (tEFocusSettings.getCameraMeteringArea() != null) {
                Camera.Parameters parameters2 = this.mParams;
                ITECameraArea.ITECameraMeteringArea cameraMeteringArea = tEFocusSettings.getCameraMeteringArea();
                int width = tEFocusSettings.getWidth();
                int height = tEFocusSettings.getHeight();
                int x = tEFocusSettings.getX();
                int y = tEFocusSettings.getY();
                TECameraSettings tECameraSettings = this.mCameraSettings;
                parameters2.setMeteringAreas(cameraMeteringArea.calculateArea(width, height, x, y, tECameraSettings.mRotation, tECameraSettings.mFacing == 1));
            } else {
                this.mParams.setMeteringAreas(this.mFocusManager.calculateMeteringArea(tEFocusSettings.getWidth(), tEFocusSettings.getHeight(), tEFocusSettings.getDisplayDensity(), tEFocusSettings.getX(), tEFocusSettings.getY(), this.mCameraSettings.mRotation, tEFocusSettings.getCoordinatesMode()));
            }
            this.mCameraDevice.setParameters(this.mParams);
            return;
        }
        if (tEFocusSettings.isNeedMetering() && this.mFocusManager.isSupportedMetering(this.mCameraSettings.mFacing, this.mParams)) {
            if (tEFocusSettings.getCameraMeteringArea() != null) {
                Camera.Parameters parameters3 = this.mParams;
                ITECameraArea.ITECameraMeteringArea cameraMeteringArea2 = tEFocusSettings.getCameraMeteringArea();
                int width2 = tEFocusSettings.getWidth();
                int height2 = tEFocusSettings.getHeight();
                int x2 = tEFocusSettings.getX();
                int y2 = tEFocusSettings.getY();
                TECameraSettings tECameraSettings2 = this.mCameraSettings;
                parameters3.setMeteringAreas(cameraMeteringArea2.calculateArea(width2, height2, x2, y2, tECameraSettings2.mRotation, tECameraSettings2.mFacing == 1));
            } else {
                this.mParams.setMeteringAreas(this.mFocusManager.calculateMeteringArea(tEFocusSettings.getWidth(), tEFocusSettings.getHeight(), tEFocusSettings.getDisplayDensity(), tEFocusSettings.getX(), tEFocusSettings.getY(), this.mCameraSettings.mRotation, tEFocusSettings.getCoordinatesMode()));
            }
        }
        if (!tEFocusSettings.isNeedFocus()) {
            this.mCameraDevice.setParameters(this.mParams);
            TELogUtils.i(TAG, "focus is not enable!");
            return;
        }
        if (tEFocusSettings.getCameraFocusArea() != null) {
            Camera.Parameters parameters4 = this.mParams;
            ITECameraArea.ITECameraFocusArea cameraFocusArea = tEFocusSettings.getCameraFocusArea();
            int width3 = tEFocusSettings.getWidth();
            int height3 = tEFocusSettings.getHeight();
            int x3 = tEFocusSettings.getX();
            int y3 = tEFocusSettings.getY();
            TECameraSettings tECameraSettings3 = this.mCameraSettings;
            parameters4.setFocusAreas(cameraFocusArea.calculateArea(width3, height3, x3, y3, tECameraSettings3.mRotation, tECameraSettings3.mFacing == 1));
        } else {
            this.mParams.setFocusAreas(this.mFocusManager.calculateFocusArea(tEFocusSettings.getWidth(), tEFocusSettings.getHeight(), tEFocusSettings.getDisplayDensity(), tEFocusSettings.getX(), tEFocusSettings.getY(), this.mCameraSettings.mRotation, tEFocusSettings.getCoordinatesMode()));
        }
        this.mCameraDevice.cancelAutoFocus();
        this.mParams.setFocusMode("auto");
        if (this.mCameraLightOn && !tEFocusSettings.isFromUser()) {
            this.mParams.setFlashMode(WkInteractiveManager.TimingTypeOff);
            z = true;
        }
        this.mCameraDevice.setParameters(this.mParams);
        this.mCameraDevice.autoFocus(new Camera.AutoFocusCallback() { // from class: com.ss.android.ttvecamera.TECamera1.4
            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z2, Camera camera2) {
                String str2;
                if (z2) {
                    str2 = "Camera Focus Succeed!";
                    tEFocusSettings.getFocusCallback().onFocus(tEFocusSettings.getFocusConsumingMS(), TECamera1.this.mCameraSettings.mFacing, "Camera Focus Succeed!");
                } else {
                    str2 = "Camera Focus Failed!";
                    tEFocusSettings.getFocusCallback().onFocus(-1, TECamera1.this.mCameraSettings.mFacing, "Camera Focus Failed!");
                }
                TELogUtils.i(TECamera1.TAG, str2);
                if (tEFocusSettings.isLock() && z2) {
                    return;
                }
                try {
                    Camera.Parameters parameters5 = camera2.getParameters();
                    parameters5.setFocusMode("continuous-video");
                    camera2.setParameters(parameters5);
                    TECamera1 tECamera1 = TECamera1.this;
                    tECamera1.useFaceAEStrategy(tECamera1.mUseFaceAE);
                } catch (Exception e2) {
                    String str3 = "Error: focusAtPoint failed: " + e2.toString();
                    TELogUtils.e(TECamera1.TAG, str3);
                    TECamera1 tECamera12 = TECamera1.this;
                    tECamera12.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_FOCUS_FAILED, str3, tECamera12.mCameraDevice);
                }
            }
        });
        if (z) {
            try {
                this.mParams.setFlashMode(BuildConfig.USE_CLOUD_CONFIG);
                this.mCameraDevice.setParameters(this.mParams);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void forceCloseCamera(Cert cert) {
        super.forceCloseCamera(cert);
        TELogUtils.i(TAG, "force close camera: " + this.mCameraDevice);
        try {
            Camera camera = this.mCameraDevice;
            if (camera != null) {
                TECamera1PolicyAdapter.closeCamera(cert, camera);
                this.mCameraDevice = null;
            }
        } catch (Exception unused) {
            TELogUtils.e(TAG, "force close camera failed");
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public TEFrameSizei getBestPreviewSize(float f, TEFrameSizei tEFrameSizei) {
        Camera camera = this.mCameraDevice;
        if (camera == null) {
            TELogUtils.e(TAG, "getBestPreviewSize: Camera is not opened!");
            return null;
        }
        if (this.mParams == null) {
            this.mParams = camera.getParameters();
        }
        return tEFrameSizei != null ? TECameraUtils.calcPreviewSize(getSupportedPreviewSizes(), tEFrameSizei) : TECameraUtils.calcPreviewSizeByRadio(getSupportedPreviewSizes(), f);
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public JSONObject getCameraCapbilitiesForBytebench() {
        return this.mCameraCapabilitiesMap;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public int[] getCameraCaptureSize() {
        Camera camera = this.mCameraDevice;
        if (camera == null) {
            return null;
        }
        try {
            Camera.Size previewSize = camera.getParameters().getPreviewSize();
            return new int[]{previewSize.width, previewSize.height};
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public int getCameraType() {
        return 1;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public float[] getFOV() {
        float[] fArr = new float[2];
        Camera camera = this.mCameraDevice;
        if (camera == null) {
            TELogUtils.e(TAG, "getFOV: camera device is null.");
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "getFOV: camera device is null.", this.mCameraDevice);
            return new float[]{-2.0f, -2.0f};
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            this.mParams = parameters;
            fArr[0] = parameters.getVerticalViewAngle();
            fArr[1] = this.mParams.getHorizontalViewAngle();
            TELogUtils.d(TAG, "Camera1:verticalFOV = " + fArr[0] + ",horizontalFOV = " + fArr[1]);
            return fArr;
        } catch (Exception e) {
            e.printStackTrace();
            return new float[]{-2.0f, -2.0f};
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public int getFlashMode() {
        String flashMode;
        Camera camera = this.mCameraDevice;
        if (camera != null) {
            try {
                flashMode = camera.getParameters().getFlashMode();
            } catch (Exception e) {
                e.printStackTrace();
                flashMode = null;
            }
            if (BuildConfig.USE_CLOUD_CONFIG.equals(flashMode)) {
                return 1;
            }
            if ("auto".equals(flashMode)) {
                return 3;
            }
            if (WkInteractiveManager.TimingTypeOff.equals(flashMode)) {
                return 0;
            }
            if ("torch".equals(flashMode)) {
                return 2;
            }
            if ("red-eye".equals(flashMode)) {
                return 4;
            }
        }
        return -1;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public int getFrameOrientation() {
        int deviceOrientation = this.mDeviceRotation;
        if (deviceOrientation < 0) {
            deviceOrientation = TECameraUtils.getDeviceOrientation(this.mContext);
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        this.mFacing = this.mNewFacing;
        try {
            Camera.getCameraInfo(this.mCameraSettings.mDefaultCameraID, cameraInfo);
            if (this.mFacing == 1) {
                int i = (cameraInfo.orientation + deviceOrientation) % 360;
                this.mCameraRotation = i;
                this.mCameraRotation = ((360 - i) + EffectConstants.ROTATION_DEGREES_180) % 360;
            } else {
                this.mCameraRotation = ((cameraInfo.orientation - deviceOrientation) + 360) % 360;
            }
            return this.mCameraRotation;
        } catch (Exception e) {
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_INVALID_CAMERA_ID, "getFrameOrientation :" + e.getMessage(), this.mCameraDevice);
            return 0;
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public int[] getPictureSize() {
        Camera.Size pictureSize;
        Camera camera = this.mCameraDevice;
        if (camera != null) {
            try {
                pictureSize = camera.getParameters().getPictureSize();
            } catch (Exception e) {
                e.printStackTrace();
                pictureSize = null;
            }
        } else {
            pictureSize = null;
        }
        if (pictureSize == null) {
            return null;
        }
        return new int[]{pictureSize.width, pictureSize.height};
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public int[] getPreviewFps() {
        Camera camera = this.mCameraDevice;
        if (camera == null) {
            return null;
        }
        try {
            int[] iArr = new int[2];
            camera.getParameters().getPreviewFpsRange(iArr);
            iArr[0] = iArr[0] / 1000;
            iArr[1] = iArr[1] / 1000;
            return iArr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public List<TEFrameSizei> getSupportedPictureSizes() {
        Camera.Parameters parameters = this.mParams;
        if (parameters == null) {
            this.mSupportedPictureSizes.clear();
            return this.mSupportedPictureSizes;
        }
        List<TEFrameSizei> listConvertSizes = convertSizes(parameters.getSupportedPictureSizes());
        this.mSupportedPictureSizes = listConvertSizes;
        return listConvertSizes;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public List<TEFrameSizei> getSupportedPreviewSizes() {
        Camera.Parameters parameters = this.mParams;
        if (parameters == null) {
            this.mSupportedPreviewSizes.clear();
            return this.mSupportedPreviewSizes;
        }
        List<TEFrameSizei> listConvertSizes = convertSizes(parameters.getSupportedPreviewSizes());
        this.mSupportedPreviewSizes = listConvertSizes;
        return listConvertSizes;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public boolean isAutoExposureLockSupported() {
        Camera.Parameters parameters;
        TELogUtils.i(TAG, "isAutoExposureLockSupported...");
        if (this.mCameraDevice == null || (parameters = this.mParams) == null || !this.mIsRunning) {
            return false;
        }
        return parameters.isAutoExposureLockSupported();
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public boolean isAutoFocusLockSupported() {
        Camera.Parameters parameters;
        TELogUtils.i(TAG, "isAutoFocusLockSupported...");
        Camera camera = this.mCameraDevice;
        if (camera == null || (parameters = this.mParams) == null || !this.mIsRunning) {
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "setAutoFocusLock failed. ： Camera is null.", camera);
            return false;
        }
        try {
            return parameters.getSupportedFocusModes().contains("fixed");
        } catch (Exception unused) {
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_AF_LOCK_NO_SUPPORT, TECameraResult.TER_CAMERA_AF_LOCK_NO_SUPPORT, "isAutoFocusLockSupported failed", this.mCameraDevice);
            return false;
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public boolean isSupportWhileBalance() {
        Camera.Parameters parameters;
        try {
            if (this.mCameraDevice == null || (parameters = this.mParams) == null || parameters.getSupportedWhiteBalance() == null) {
                return false;
            }
            return this.mParams.isAutoWhiteBalanceLockSupported();
        } catch (Exception e) {
            TELogUtils.e(TAG, "Unsupported whileBalance!: " + e.toString());
            return false;
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public boolean isSupportedExposureCompensation() {
        TELogUtils.i(TAG, "isSupportedExposureCompensation...");
        if (this.mCameraDevice == null || this.mParams == null || !this.mIsRunning) {
            return false;
        }
        return this.mCameraSettings.mCameraECInfo.isSupportExposureCompensation();
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public boolean isTorchSupported() {
        Bundle bundle = getFeatures().get(this.mCameraSettings.mStrCameraID);
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(TECameraSettings.Features.CAMERA_TORCH_SUPPORTED, false);
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public int open(int i, int i2, int i3, int i4, int i5, boolean z, Cert cert) {
        TELogUtils.d(TAG, "Open camera facing = " + i);
        TECameraSettings tECameraSettings = this.mCameraSettings;
        tECameraSettings.mFacing = i;
        TEFrameSizei tEFrameSizei = tECameraSettings.mPreviewSize;
        tEFrameSizei.width = i2;
        tEFrameSizei.height = i3;
        tECameraSettings.mFPSRange.max = i4;
        tECameraSettings.mRequiredCameraLevel = i5;
        return innerOpen(cert);
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void queryShaderZoomStep(TECameraSettings.ShaderZoomCallback shaderZoomCallback) {
        if (shaderZoomCallback == null) {
            TELogUtils.e(TAG, "ShaderZoomCallback is null, do nothing!");
            return;
        }
        Camera camera = this.mCameraDevice;
        if (camera == null) {
            TELogUtils.e(TAG, "queryShaderZoomStep : Camera is null!");
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "queryShaderZoomStep : Camera is null!", this.mCameraDevice);
            return;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters != null && parameters.isZoomSupported()) {
                int maxZoom = parameters.getMaxZoom();
                if (maxZoom > 99) {
                    maxZoom = 99;
                }
                List<Integer> zoomRatios = parameters.getZoomRatios();
                if (maxZoom <= 0) {
                    shaderZoomCallback.getShaderStep(0.0f);
                } else {
                    shaderZoomCallback.getShaderStep(((float) Math.pow(((zoomRatios.get(1).intValue() - zoomRatios.get(0).intValue()) / 100.0f) + 1.0f, 0.5d)) - 1.0f);
                }
            }
        } catch (Exception e) {
            String str = "Query shader zoom step failed : " + e.toString();
            TELogUtils.e(TAG, str);
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_ZOOM_FAILED, str, this.mCameraDevice);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void queryZoomAbility(TECameraSettings.ZoomCallback zoomCallback, boolean z) {
        if (zoomCallback == null) {
            TELogUtils.e(TAG, "ZoomCallback is null, do nothing!");
            return;
        }
        Camera camera = this.mCameraDevice;
        if (camera == null) {
            TELogUtils.e(TAG, "queryZoomAbility : Camera is null!");
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "queryZoomAbility : Camera is null!", this.mCameraDevice);
            return;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            this.mMaxZoom = parameters.getMaxZoom();
            if (z) {
                zoomCallback.onZoomSupport(1, parameters.isZoomSupported(), parameters.isSmoothZoomSupported(), this.mZoomRatios.get((int) r3).intValue() / 100.0f, parameters.getZoomRatios());
            } else {
                zoomCallback.onZoomSupport(1, parameters.isZoomSupported(), parameters.isSmoothZoomSupported(), parameters.getMaxZoom(), parameters.getZoomRatios());
            }
        } catch (Exception e) {
            String str = "Query zoom ability failed : " + e.toString();
            TELogUtils.e(TAG, str);
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_ZOOM_FAILED, str, this.mCameraDevice);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void setAutoExposureLock(boolean z) {
        Camera.Parameters parameters;
        TELogUtils.i(TAG, "setAutoExposureLock...");
        Camera camera = this.mCameraDevice;
        if (camera == null || (parameters = this.mParams) == null || !this.mIsRunning) {
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "setAutoExposureLock failed. ： Camera is null.", camera);
            return;
        }
        if (!parameters.isAutoExposureLockSupported()) {
            TELogUtils.w(TAG, "Current camera doesn't support ae lock.");
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_AE_LOCK_NO_SUPPORT, TECameraResult.TER_CAMERA_AE_LOCK_NO_SUPPORT, "Current camera doesn't support ae lock.", this.mCameraDevice);
            return;
        }
        try {
            this.mParams.setAutoExposureLock(z);
            this.mCameraDevice.setParameters(this.mParams);
        } catch (Exception e) {
            String str = "Error: setAutoExposureLock failed: " + e.toString();
            TELogUtils.e(TAG, str);
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_AE_LOCK_FAILED, TECameraResult.TER_CAMERA_AE_LOCK_FAILED, str, this.mCameraDevice);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void setAutoFocusLock(boolean z) {
        TELogUtils.i(TAG, "setAutoFocusLock...");
        Camera camera = this.mCameraDevice;
        if (camera == null || this.mParams == null || !this.mIsRunning) {
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "setAutoFocusLock failed. ： Camera is null.", camera);
            return;
        }
        if (!isAutoFocusLockSupported()) {
            TELogUtils.w(TAG, "Current camera doesn't support af lock.");
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_AF_LOCK_NO_SUPPORT, TECameraResult.TER_CAMERA_AF_LOCK_NO_SUPPORT, "Current camera doesn't support af lock.", this.mCameraDevice);
            return;
        }
        try {
            if (z) {
                this.mParams.setFocusMode("fixed");
            } else {
                this.mParams.setFocusMode("continuous-video");
            }
            this.mCameraDevice.setParameters(this.mParams);
        } catch (Exception e) {
            String str = "Error: setAutoFocusLock failed: " + e.toString();
            TELogUtils.e(TAG, str);
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_AE_LOCK_FAILED, TECameraResult.TER_CAMERA_AE_LOCK_FAILED, str, this.mCameraDevice);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public boolean setExposureCompensation(int i) {
        String str;
        int i2;
        this.mExposureCompensation = i;
        TELogUtils.i(TAG, "setExposureCompensation... value: " + i);
        Camera camera = this.mCameraDevice;
        int i3 = TECameraResult.TER_CAMERA_EC_FAILED;
        if (camera == null || this.mParams == null || !this.mIsRunning || !this.mCameraSettings.mCameraECInfo.isSupportExposureCompensation()) {
            Camera camera2 = this.mCameraDevice;
            if (camera2 == null || this.mParams == null || !this.mIsRunning) {
                this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "setExposureCompensation ： Camera is null.", camera2);
                str = "setExposureCompensation ： Camera is null.";
            } else {
                i3 = TECameraResult.TER_CAMERA_EC_NOT_SUPPORT;
                str = "Unsupported exposure compensation!";
            }
            this.mCameraEvents.onCameraError(1, i3, str, this.mCameraDevice);
            i2 = i3;
        } else {
            TECameraSettings.ExposureCompensationInfo exposureCompensationInfo = this.mCameraSettings.mCameraECInfo;
            if (i > exposureCompensationInfo.max || i < exposureCompensationInfo.min) {
                this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_EC_OUT_OF_RANGE, "Invalid exposure: " + i, this.mCameraDevice);
                return false;
            }
            try {
                this.mParams.setExposureCompensation(i);
                this.mCameraDevice.setParameters(this.mParams);
                this.mCameraSettings.mCameraECInfo.exposure = this.mParams.getExposureCompensation();
                StringBuilder sb = new StringBuilder();
                sb.append("EC = ");
                sb.append(this.mCameraSettings.mCameraECInfo.exposure);
                sb.append(", EV = ");
                sb.append(r0.exposure * this.mCameraSettings.mCameraECInfo.step);
                TELogUtils.d(TAG, sb.toString());
                str = null;
                i2 = 0;
            } catch (Exception e) {
                str = "Error: setExposureCompensation failed: " + e.toString();
                this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_EC_FAILED, str, this.mCameraDevice);
                i2 = -1;
            }
        }
        boolean z = i2 == 0;
        if (!z) {
            TELogUtils.e(TAG, "setExposureCompensation failed: " + str);
        }
        return z;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void setFeatureParameters(Bundle bundle) {
        super.setFeatureParameters(bundle);
        if (bundle == null) {
            return;
        }
        Bundle bundle2 = this.mFeatures.get(this.mCameraSettings.mStrCameraID);
        for (String str : bundle.keySet()) {
            if (TECameraSettings.Parameters.isValid(str, bundle.get(str)) && TextUtils.equals(str, TECameraSettings.Features.SUPPORT_LIGHT_SOFT)) {
                bundle2.putBoolean(TECameraSettings.Features.SUPPORT_LIGHT_SOFT, bundle.getBoolean(TECameraSettings.Features.SUPPORT_LIGHT_SOFT));
            }
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void setPictureSize(int i, int i2) {
        TECameraSettings tECameraSettings = this.mCameraSettings;
        tECameraSettings.mForceApplyPictureSize = true;
        TEFrameSizei tEFrameSizei = tECameraSettings.mPictureSize;
        tEFrameSizei.width = i;
        tEFrameSizei.height = i2;
        stopCapture();
        startCapture();
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void setPreviewFpsRange() {
        Camera.Parameters parameters = this.mParams;
        if (parameters == null) {
            return;
        }
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        int fpsUnitFactor = TEFrameRateRange.getFpsUnitFactor(supportedPreviewFpsRange);
        TECameraSettings tECameraSettings = this.mCameraSettings;
        int[] fpsRange = TECameraUtils.getFpsRange(tECameraSettings.mCameraFrameRateStrategy, tECameraSettings.mFacing, tECameraSettings.mFPSRange.mulFactor(fpsUnitFactor), supportedPreviewFpsRange);
        this.mParams.setPreviewFpsRange(fpsRange[0], fpsRange[1]);
        this.mCameraEvents.onCameraInfo(121, 0, new TEFrameRateRange(fpsRange[0], fpsRange[1]).toString(), null);
        this.mCameraDevice.setParameters(this.mParams);
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void setSceneMode(int i) {
        super.setSceneMode(i);
        if (i == 0) {
            applyCaptureScene();
        } else {
            if (i != 1) {
                throw new IllegalArgumentException("un support scene");
            }
            applyRecordScene();
        }
    }

    public void setSurface(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void setWhileBalance(boolean z, String str) {
        Camera camera = this.mCameraDevice;
        if (camera == null || !this.mIsRunning) {
            TELogUtils.e(TAG, "setWhileBalance : Camera is null!");
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "setWhileBalance : Camera is null!", this.mCameraDevice);
            return;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            this.mParams = parameters;
            List<String> supportedWhiteBalance = parameters.getSupportedWhiteBalance();
            if (supportedWhiteBalance == null || !supportedWhiteBalance.contains(str)) {
                String str2 = "SupportWBList has no value: " + str;
                TELogUtils.e(TAG, str2);
                this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_WHILE_BALANCE_NO_SUPPORT, str2, this.mCameraDevice);
            } else {
                this.mParams.setWhiteBalance(str);
                this.mCameraDevice.setParameters(this.mParams);
            }
        } catch (Exception e) {
            String str3 = "Set WhileBalance failed: " + e.toString();
            TELogUtils.e(TAG, str3);
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_WHILE_BALANCE_NO_SUPPORT, str3, this.mCameraDevice);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02db A[Catch: Exception -> 0x02f5, TRY_LEAVE, TryCatch #0 {Exception -> 0x02f5, blocks: (B:87:0x02d7, B:89:0x02db), top: B:99:0x02d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02fd  */
    @Override // com.ss.android.ttvecamera.TECameraBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void startCapture() {
        int i;
        TETraceUtils.beginSection("TECamera1-startCapture");
        TELogUtils.i(TAG, "Camera startPreview...");
        if (this.mIsRunning) {
            TELogUtils.w(TAG, "Camera is previewing...");
            return;
        }
        if (this.mCameraDevice != null) {
            try {
                TECameraProviderManager tECameraProviderManager = this.mProviderMgr;
                if (tECameraProviderManager == null) {
                    throw new AndroidRuntimeException("ProviderManager is null");
                }
                TECameraBase.PreviewSizeCallBack previewSizeCallBack = this.mPreviewSizeCallback;
                if (previewSizeCallBack != null) {
                    tECameraProviderManager.setPreviewSizeCallback(previewSizeCallBack);
                }
                if (this.mParams == null) {
                    this.mParams = this.mCameraDevice.getParameters();
                }
                int iInitProvider = this.mProviderMgr.initProvider(convertSizes(this.mParams.getSupportedPreviewSizes()), this.mCameraSettings.mPreviewSize);
                if (iInitProvider != 0) {
                    TELogUtils.e(TAG, "Init provider failed, ret = " + iInitProvider);
                    return;
                }
                if (this.mProviderMgr.getProviderType() == 1) {
                    if (this.mProviderMgr.getSurfaceTexture() == null) {
                        TELogUtils.e(TAG, "SurfaceTexture is null");
                        throw new AndroidRuntimeException("SurfaceTexture is null");
                    }
                    this.mCameraDevice.setPreviewTexture(this.mProviderMgr.getSurfaceTexture());
                } else {
                    if (this.mProviderMgr.getProviderType() != 4) {
                        TELogUtils.e(TAG, "Unsupported camera provider type : " + this.mProviderMgr.getProviderType());
                        return;
                    }
                    TECallbackWithBufferProvider tECallbackWithBufferProvider = (TECallbackWithBufferProvider) this.mProviderMgr.getProvider();
                    if (tECallbackWithBufferProvider == null) {
                        throw new AndroidRuntimeException("Provider is null");
                    }
                    if (this.mHasPreviewBufferFlag.compareAndSet(false, true)) {
                        for (byte[] bArr : tECallbackWithBufferProvider.getBuffers(3)) {
                            this.mCameraDevice.addCallbackBuffer(bArr);
                        }
                    }
                    this.mCameraDevice.setPreviewCallbackWithBuffer(tECallbackWithBufferProvider.getPreviewCallback());
                    if (this.mProviderMgr.getSurfaceTexture() != null) {
                        this.mCameraDevice.setPreviewTexture(this.mProviderMgr.getSurfaceTexture());
                    }
                }
                if (this.mZoomRatios != null && Float.compare(this.mCameraSettings.mDefaultZoomRatio, 1.0f) != 0) {
                    float f = this.mZoomValue * this.mCameraSettings.mDefaultZoomRatio;
                    this.mZoomValue = f;
                    if (f < this.mZoomRatios.get(0).intValue()) {
                        this.mZoomValue = this.mZoomRatios.get(0).intValue();
                    } else {
                        float f2 = this.mZoomValue;
                        List<Integer> list = this.mZoomRatios;
                        if (f2 > list.get(list.size() - 1).intValue()) {
                            List<Integer> list2 = this.mZoomRatios;
                            this.mZoomValue = list2.get(list2.size() - 1).intValue();
                        }
                    }
                    this.mParams.setZoom(getNearestZoomIndex((int) this.mZoomValue));
                    this.mCameraDevice.setParameters(this.mParams);
                }
                TEFrameSizei previewSize = this.mProviderMgr.getPreviewSize();
                if (previewSize != null) {
                    if (this.mParams.getPreviewSize().width != previewSize.width || this.mParams.getPreviewSize().height != previewSize.height) {
                        this.mParams.setPreviewSize(previewSize.width, previewSize.height);
                        TECameraSettings tECameraSettings = this.mCameraSettings;
                        if (tECameraSettings.mUseMaxWidthTakePicture) {
                            if (tECameraSettings.mForceApplyPictureSize) {
                                tECameraSettings.mForceApplyPictureSize = false;
                            } else {
                                List<TEFrameSizei> listConvertSizes = convertSizes(this.mParams.getSupportedPictureSizes());
                                TECameraSettings tECameraSettings2 = this.mCameraSettings;
                                tECameraSettings.mPictureSize = TECameraUtils.getClosestSupportedSize(listConvertSizes, previewSize, tECameraSettings2.mMaxWidth, tECameraSettings2.mMaxWidthTakePictureSizeAccuracy);
                            }
                            Camera.Parameters parameters = this.mParams;
                            TEFrameSizei tEFrameSizei = this.mCameraSettings.mPictureSize;
                            parameters.setPictureSize(tEFrameSizei.width, tEFrameSizei.height);
                        }
                        this.mCameraDevice.setParameters(this.mParams);
                    }
                    this.mCameraEvents.onCameraInfo(50, 0, previewSize.toString(), this.mCameraDevice);
                }
                TECameraSettings tECameraSettings3 = this.mCameraSettings;
                if (tECameraSettings3.mForceApplyPictureSize) {
                    tECameraSettings3.mForceApplyPictureSize = false;
                    Camera.Parameters parameters2 = this.mParams;
                    TEFrameSizei tEFrameSizei2 = tECameraSettings3.mPictureSize;
                    parameters2.setPictureSize(tEFrameSizei2.width, tEFrameSizei2.height);
                    this.mCameraDevice.setParameters(this.mParams);
                    TELogUtils.i(TAG, "force set picture size: " + this.mCameraSettings.mPictureSize.width + "x" + this.mCameraSettings.mPictureSize.height);
                }
                this.mCameraDevice.setErrorCallback(new Camera.ErrorCallback() { // from class: com.ss.android.ttvecamera.TECamera1.1
                    @Override // android.hardware.Camera.ErrorCallback
                    public void onError(int i2, Camera camera) {
                        String str;
                        int i3;
                        TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_ERR_RET, i2);
                        if (i2 == 100) {
                            str = "Camera server died!";
                            i3 = TECameraResult.TER_CAMERA_SERVER_ERROR;
                        } else if (Build.VERSION.SDK_INT >= 23 && i2 == 2) {
                            str = "Camera disconnected: " + i2;
                            i3 = TECameraResult.TER_CAMERA_DISCONNECTED;
                        } else {
                            if (i2 != 1) {
                                TELogUtils.w(TECamera1.TAG, "Ignore camera error here: " + i2);
                                return;
                            }
                            str = "Camera unknown error: " + i2;
                            i3 = TECameraResult.TER_CAMERA_DEVICE_ERROR;
                        }
                        TELogUtils.e(TECamera1.TAG, str);
                        TECamera1 tECamera1 = TECamera1.this;
                        tECamera1.close(tECamera1.openPrivacyCert);
                        TECamera1.this.stopRetryStartPreview();
                        TECamera1 tECamera12 = TECamera1.this;
                        TECameraBase.CameraEvents cameraEvents = tECamera12.mCameraEvents;
                        if (cameraEvents != null) {
                            cameraEvents.onPreviewError(1, i3, str, tECamera12.mCameraDevice);
                        }
                    }
                });
                this.mCameraSettings.mRotation = getFrameOrientation();
                TELogUtils.d(TAG, "Camera rotation = " + this.mCameraSettings.mRotation);
                long jCurrentTimeMillis = System.currentTimeMillis();
                TELogUtils.i(TAG, "Camera startPreview start");
                this.mCameraDevice.startPreview();
                TELogUtils.i(TAG, "Camera startPreview end");
                int i2 = this.mCameraSettings.mExtParameters.getInt("useCameraFaceDetect");
                this.mUseFaceAE = i2;
                useFaceAEStrategy(i2);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                this.mStartPreviewTime = jCurrentTimeMillis2;
                long j = jCurrentTimeMillis2 - jCurrentTimeMillis;
                TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_1_START_PREVIEW_COST, j);
                TELogUtils.logMonitorInfo(TECameraMonitor.TE_RECORD_CAMERA_1_START_PREVIEW_COST, Long.valueOf(j));
                this.mIsRunning = true;
                this.mCameraEvents.onPreviewSuccess(1, 0, 0, "TECamera1 preview", this.mCameraDevice);
            } catch (Exception e) {
                TELogUtils.e(TAG, "startPreview: Error " + e.getMessage());
                if (e.getMessage() == null) {
                    i = TECameraResult.TER_CAMERA_PREVIEW_FAILED;
                    TECameraExceptionMonitor.monitorException(e);
                    this.mIsRunning = false;
                    try {
                        if (this.mRetryStartPreviewCount == 0) {
                            this.mCameraEvents.onCameraInfo(108, 0, "preview error will close camera1", null);
                            TECamera1PolicyAdapter.closeCamera(this.openPrivacyCert, this.mCameraDevice);
                            this.mCameraEvents.onCameraInfo(109, 0, "preview error did close camera1", null);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (this.mRetryStartPreviewCount == 0) {
                        this.mCameraDevice = null;
                    }
                    this.mCameraEvents.onPreviewError(1, i, e.getMessage(), this.mCameraDevice);
                } else {
                    if (e.getMessage().equals("setParameters failed")) {
                        i = TECameraResult.TER_CAMERA_SET_PARAMS_FAILED;
                    } else if (e.getMessage().equals("startPreview failed")) {
                        i = TECameraResult.TER_CAMERA_DEVICE_ERROR;
                    }
                    TECameraExceptionMonitor.monitorException(e);
                    this.mIsRunning = false;
                    if (this.mRetryStartPreviewCount == 0) {
                    }
                    if (this.mRetryStartPreviewCount == 0) {
                    }
                    this.mCameraEvents.onPreviewError(1, i, e.getMessage(), this.mCameraDevice);
                }
            }
        }
        TETraceUtils.endSection();
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void startZoom(float f, final TECameraSettings.ZoomCallback zoomCallback) {
        Camera camera = this.mCameraDevice;
        if (camera == null) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: START_ZOOM. Code: -439. Reason: mCameraDevice is null");
            TELogUtils.e(TAG, "startZoom : Camera is null!");
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "startZoom : Camera is null!", this.mCameraDevice);
            return;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            this.mParams = parameters;
            if (!parameters.isZoomSupported() && !this.mParams.isSmoothZoomSupported()) {
                TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: START_ZOOM. Code: -421. Reason: camera is not support zoom");
                TELogUtils.e(TAG, "Camera is not support zoom!");
                this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_ZOOM_NO_SUPPORT, "Camera is not support zoom!", this.mCameraDevice);
                return;
            }
            int iMin = (int) Math.min(this.mParams.getMaxZoom(), f);
            if (this.mParams.isSmoothZoomSupported() && zoomCallback != null && zoomCallback.enableSmooth()) {
                this.mCameraDevice.startSmoothZoom(iMin);
                this.mCameraDevice.setZoomChangeListener(new Camera.OnZoomChangeListener() { // from class: com.ss.android.ttvecamera.TECamera1.6
                    @Override // android.hardware.Camera.OnZoomChangeListener
                    public void onZoomChange(int i, boolean z, Camera camera2) {
                        TECameraSettings.ZoomCallback zoomCallback2 = zoomCallback;
                        if (zoomCallback2 != null) {
                            zoomCallback2.onChange(1, i, z);
                        }
                    }
                });
                return;
            }
            this.mParams.setZoom(iMin);
            this.mCameraDevice.setParameters(this.mParams);
            if (zoomCallback != null) {
                zoomCallback.onChange(1, iMin, true);
            }
        } catch (Exception e) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: START_ZOOM. Code: -420. Reason: " + e);
            String str = "Start zoom failed : " + e.toString();
            TELogUtils.e(TAG, str);
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_ZOOM_FAILED, str, this.mCameraDevice);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void stopCameraFaceDetect() {
        Camera camera;
        if (!this.mIsRunning || (camera = this.mCameraDevice) == null) {
            return;
        }
        try {
            camera.stopFaceDetection();
        } catch (Exception unused) {
            TELogUtils.e(TAG, "camera stop face detect failed");
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void stopCapture() {
        TELogUtils.d(TAG, "Camera stopPreview...");
        if (!this.mIsRunning || this.mCameraDevice == null) {
            return;
        }
        this.mIsRunning = false;
        this.mHasPreviewBufferFlag.set(false);
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.mCameraDevice.stopPreview();
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_1_STOP_PREVIEW_COST, jCurrentTimeMillis2);
            TELogUtils.logMonitorInfo(TECameraMonitor.TE_RECORD_CAMERA_1_STOP_PREVIEW_COST, Long.valueOf(jCurrentTimeMillis2));
        } catch (Exception e) {
            TELogUtils.e(TAG, "camera stopcapture failed: " + e.getMessage());
        }
        this.mStartPreviewTime = 0L;
        TELogUtils.i(TAG, "Camera preview stopped!");
        this.mCameraEvents.onPreviewStopped(1, 4, 0, "TECamera1 preview stoped", this.mCameraDevice);
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void stopZoom(TECameraSettings.ZoomCallback zoomCallback) {
        Camera camera = this.mCameraDevice;
        if (camera == null) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: STOP_ZOOM. Code: -439. Reason: mCameraDevice is null");
            TELogUtils.e(TAG, "stopZoom : Camera is null!");
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "stopZoom : Camera is null!", this.mCameraDevice);
            return;
        }
        try {
            if (camera.getParameters().isSmoothZoomSupported() && zoomCallback != null && zoomCallback.enableSmooth()) {
                this.mCameraDevice.stopSmoothZoom();
            }
        } catch (Exception e) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: STOP_ZOOM. Code: -420. Reason: " + e);
            String str = "Stop zoom failed : " + e.toString();
            TELogUtils.e(TAG, str);
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_ZOOM_FAILED, str, this.mCameraDevice);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void switchCameraMode(int i) {
        TELogUtils.w(TAG, "Does not support switch mode for camera1");
        this.mCameraEvents.onCameraInfo(-200, -200, "Does not support switch mode for camera1", this.mCameraDevice);
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void switchFlashMode(@TECameraSettings.FlashMode final int i) {
        String str;
        String str2;
        Handler handler;
        if (this.mCameraDevice == null) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: TOGGLE_TORCH. Code: -439. Reason: mCameraDevice is null");
            TELogUtils.e(TAG, "switchFlashMode failed: Camera is not ready!");
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "switchFlashMode failed: Camera is not ready!", this.mCameraDevice);
            this.mCameraEvents.onTorchError(1, TECameraResult.TER_CAMERA_INTERNAL_ERROR, i == 0 ? 0 : 1, "switchFlashMode failed: Camera is not ready!", this.mCameraDevice);
            return;
        }
        if (this.mStartPreviewTime != 0 && System.currentTimeMillis() - this.mStartPreviewTime < 200 && (handler = this.mHandler) != null) {
            handler.postDelayed(new Runnable() { // from class: com.ss.android.ttvecamera.TECamera1.5
                @Override // java.lang.Runnable
                public void run() {
                    TECamera1.this.switchFlashMode(i);
                }
            }, 200L);
            return;
        }
        this.mCameraLightOn = false;
        try {
            Camera.Parameters parameters = this.mCameraDevice.getParameters();
            this.mParams = parameters;
            List<String> supportedFlashModes = parameters.getSupportedFlashModes();
            if (supportedFlashModes != null) {
                if (i == 0) {
                    str2 = WkInteractiveManager.TimingTypeOff;
                } else if (i != 1) {
                    str2 = i != 2 ? i != 3 ? i != 4 ? null : "red-eye" : "auto" : "torch";
                } else {
                    str2 = BuildConfig.USE_CLOUD_CONFIG;
                    this.mCameraLightOn = true;
                }
                if (str2 != null && supportedFlashModes.contains(str2)) {
                    this.mCameraEvents.onCameraInfo(104, 0, "camera1 will change flash mode " + str2, null);
                    this.mParams.setFlashMode(str2);
                    this.mCameraDevice.setParameters(this.mParams);
                    if (WkInteractiveManager.TimingTypeOff.equalsIgnoreCase(str2) && this.mCameraSettings.mExtParameters.getBoolean("enableSwitchFlashSleepToTakeEffect")) {
                        try {
                            Thread.sleep(200L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    this.mCameraEvents.onCameraInfo(105, 0, "camera1 did change flash mode " + str2, null);
                    this.mCameraEvents.onTorchSuccess(1, 0, i == 0 ? 0 : 1, "torch success", this.mCameraDevice);
                    return;
                }
            }
            if (supportedFlashModes != null) {
                str = "Camera does not support flash mode: " + i + "support list: " + supportedFlashModes.toString();
            } else {
                str = "Camera does not support flash mode: " + i;
            }
            String str3 = str;
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: TOGGLE_TORCH. Code: -419. Reason: not support flash mode " + i);
            TELogUtils.e(TAG, str3);
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_SWITCH_FLASH_NO_SUPPORT, str3, this.mCameraDevice);
            this.mCameraEvents.onTorchError(1, TECameraResult.TER_CAMERA_SWITCH_FLASH_NO_SUPPORT, i == 0 ? 0 : 1, str3, this.mCameraDevice);
        } catch (Exception e2) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: TOGGLE_TORCH. Code: -419. Reason: " + e2);
            String str4 = "Switch flash mode failed: " + e2.toString();
            TELogUtils.e(TAG, str4);
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_SWITCH_FLASH_FAILED, str4, this.mCameraDevice);
            this.mCameraEvents.onTorchError(1, TECameraResult.TER_CAMERA_SWITCH_FLASH_FAILED, i == 0 ? 0 : 1, str4, this.mCameraDevice);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void takePicture(int i, int i2, final TECameraSettings.PictureCallback pictureCallback) {
        Camera camera = this.mCameraDevice;
        if (camera == null) {
            TELogUtils.e(TAG, "takePicture : camera is null");
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "takePicture : camera is null", this.mCameraDevice);
            return;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            this.mParams = parameters;
            if (parameters.getPictureSize().width != i || this.mParams.getPictureSize().height != i2) {
                TEFrameSizei closestSupportedSize = TECameraUtils.getClosestSupportedSize(convertSizes(this.mParams.getSupportedPictureSizes()), this.mCameraSettings.getPreviewSize(), new TEFrameSizei(i, i2));
                this.mParams.setPictureSize(closestSupportedSize.width, closestSupportedSize.height);
                List<Integer> supportedPictureFormats = this.mParams.getSupportedPictureFormats();
                if (this.mCameraSettings.mEnableYuvBufferCapture && supportedPictureFormats != null && supportedPictureFormats.contains(17)) {
                    this.mParams.setPictureFormat(17);
                } else {
                    this.mParams.setPictureFormat(256);
                    this.mParams.setJpegQuality(100);
                }
                this.mCameraDevice.setParameters(this.mParams);
            }
            this.mIsRunning = false;
            this.mCameraDevice.takePicture(null, null, new Camera.PictureCallback() { // from class: com.ss.android.ttvecamera.TECamera1.2
                @Override // android.hardware.Camera.PictureCallback
                public void onPictureTaken(byte[] bArr, Camera camera2) {
                    if (pictureCallback != null) {
                        int pictureFormat = TECamera1.this.mParams.getPictureFormat();
                        Camera.Size pictureSize = TECamera1.this.mParams.getPictureSize();
                        int i3 = pictureSize.width;
                        int i4 = pictureSize.height;
                        TELogUtils.i(TECamera1.TAG, "take picture format: " + pictureFormat + ", w: " + i3 + ", h: " + i4);
                        pictureCallback.onPictureTaken(new TECameraFrame(bArr, pictureFormat == 17 ? TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_NV21 : TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_JPEG, i3, i4, TECamera1.this.mNewFacing == 1 ? 270 : 90), TECamera1.this);
                    }
                }
            });
        } catch (Exception e) {
            TECameraExceptionMonitor.monitorException(e);
            if (pictureCallback != null) {
                pictureCallback.onTakenFail(createException(e, -1000));
            }
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void toggleTorch(boolean z) {
        this.mCameraLightOn = false;
        if (this.mCameraDevice == null) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: TOGGLE_TORCH. Code: -439. Reason: mCameraDevice is null");
            TELogUtils.e(TAG, "toggleTorch : Camera is not ready!");
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "toggleTorch : Camera is not ready!", this.mCameraDevice);
            this.mCameraEvents.onTorchError(1, TECameraResult.TER_CAMERA_INTERNAL_ERROR, z ? 1 : 0, "toggleTorch : Camera is not ready!", this.mCameraDevice);
            return;
        }
        if (this.mCameraSettings.mFacing == 1) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: TOGGLE_TORCH. Code: -416. Reason: not support torch");
            TELogUtils.w(TAG, "Front camera does not support torch!");
            this.mCameraEvents.onCameraInfo(TECameraResult.TER_CAMERA_TORCH_NO_SUPPORT, TECameraResult.TER_CAMERA_TORCH_NO_SUPPORT, "Front camera does not support torch!", this.mCameraDevice);
            this.mCameraEvents.onTorchError(1, TECameraResult.TER_CAMERA_TORCH_NO_SUPPORT, z ? 1 : 0, "Front camera does not support torch!", this.mCameraDevice);
            return;
        }
        try {
            this.mCameraEvents.onCameraInfo(104, 0, "camera1 will change flash mode " + z, null);
            Camera.Parameters parameters = this.mCameraDevice.getParameters();
            this.mParams = parameters;
            parameters.setFlashMode(z ? "torch" : WkInteractiveManager.TimingTypeOff);
            this.mCameraDevice.setParameters(this.mParams);
            this.mCameraEvents.onCameraInfo(105, 0, "camera1 did change flash mode " + z, null);
            this.mCameraEvents.onTorchSuccess(1, 0, z ? 1 : 0, "toggleTorch " + z, this.mCameraDevice);
        } catch (Exception e) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: TOGGLE_TORCH. Code: -417. Reason: " + e);
            String str = "Toggle torch failed: " + e.toString();
            TELogUtils.e(TAG, str);
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_TORCH_FAILED, str, this.mCameraDevice);
            this.mCameraEvents.onTorchError(1, TECameraResult.TER_CAMERA_TORCH_FAILED, z ? 1 : 0, str, this.mCameraDevice);
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void useFaceAEStrategy(int i) {
        TELogUtils.d(TAG, "Camera start face detect");
        if (!this.mIsRunning || this.mCameraDevice == null || this.mParams.getMaxNumDetectedFaces() <= 0) {
            return;
        }
        try {
            if (i == 1) {
                if (this.mFacing == 1) {
                    this.mCameraDevice.startFaceDetection();
                    TELogUtils.i(TAG, "use faceae for front");
                }
            } else if (i == 2) {
                if (this.mFacing == 0) {
                    this.mCameraDevice.startFaceDetection();
                    TELogUtils.i(TAG, "use faceae for rear");
                }
            } else {
                if (i != 3) {
                    return;
                }
                this.mCameraDevice.startFaceDetection();
                TELogUtils.i(TAG, "use faceae for all");
            }
        } catch (Exception unused) {
            TELogUtils.e(TAG, "camera start face detect failed");
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void zoomV2(float f, TECameraSettings.ZoomCallback zoomCallback) {
        if (this.mZoomRatios == null || this.mCameraDevice == null) {
            return;
        }
        float f2 = this.mZoomValue * f;
        this.mZoomValue = f2;
        try {
            if (f2 < r1.get(0).intValue()) {
                this.mZoomValue = this.mZoomRatios.get(0).intValue();
            }
            float f3 = this.mZoomValue;
            List<Integer> list = this.mZoomRatios;
            if (f3 > list.get(list.size() - 1).intValue()) {
                List<Integer> list2 = this.mZoomRatios;
                this.mZoomValue = list2.get(list2.size() - 1).intValue();
            }
            Camera.Parameters parameters = this.mCameraDevice.getParameters();
            if (parameters == null || !parameters.isZoomSupported()) {
                TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: SET_ZOOM. Code: -420. Reason: getParameters is null");
                TELogUtils.e(TAG, "setZoom failed for getParameters null");
                return;
            }
            int nearestZoomIndex = getNearestZoomIndex((int) this.mZoomValue);
            if (parameters.getZoom() != nearestZoomIndex) {
                parameters.setZoom(nearestZoomIndex);
                this.mCameraDevice.setParameters(parameters);
                if (zoomCallback != null) {
                    zoomCallback.onChange(1, this.mZoomRatios.get(nearestZoomIndex).intValue() / 100.0f, true);
                }
            }
        } catch (Exception e) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: SET_ZOOM. Code: -420. Reason: " + e);
            TELogUtils.e(TAG, "setZoom failed, " + e.getMessage());
        }
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public int open(TECameraSettings tECameraSettings, Cert cert) {
        super.open(tECameraSettings, cert);
        this.mCameraSettings = tECameraSettings;
        this.mNewFacing = tECameraSettings.mFacing;
        return innerOpen(cert);
    }

    @Override // com.ss.android.ttvecamera.TECameraBase
    public void takePicture(final TECameraSettings.PictureCallback pictureCallback) {
        if (this.mCameraDevice == null) {
            TELogUtils.e(TAG, "takePicture: camera is null.");
            this.mCameraEvents.onCameraError(1, TECameraResult.TER_CAMERA_INTERNAL_ERROR, "takePicture: camera is null.", this.mCameraDevice);
            return;
        }
        try {
            this.mIsRunning = false;
            TELogUtils.i(TAG, "takePicture size: " + this.mCameraSettings.mPictureSize.toString());
            final long jCurrentTimeMillis = System.currentTimeMillis();
            this.mCameraDevice.takePicture(null, null, new Camera.PictureCallback() { // from class: com.ss.android.ttvecamera.TECamera1.3
                @Override // android.hardware.Camera.PictureCallback
                public void onPictureTaken(byte[] bArr, Camera camera) {
                    TELogUtils.i(TECamera1.TAG, "capture data arrive consume: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                    Camera camera2 = TECamera1.this.mCameraDevice;
                    if (camera2 != null) {
                        camera2.stopPreview();
                    }
                    if (pictureCallback != null) {
                        int pictureFormat = TECamera1.this.mParams.getPictureFormat();
                        Camera.Size pictureSize = TECamera1.this.mParams.getPictureSize();
                        int i = pictureSize.width;
                        int i2 = pictureSize.height;
                        TELogUtils.i(TECamera1.TAG, "take picture format: " + pictureFormat + ", w: " + i + ", h: " + i2);
                        pictureCallback.onPictureTaken(new TECameraFrame(bArr, pictureFormat == 17 ? TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_NV21 : TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_JPEG, i, i2, TECamera1.this.mNewFacing == 1 ? 270 : 90), TECamera1.this);
                    }
                }
            });
        } catch (Exception e) {
            TECameraExceptionMonitor.monitorException(e);
            if (pictureCallback != null) {
                pictureCallback.onTakenFail(createException(e, -1000));
            }
        }
    }
}
