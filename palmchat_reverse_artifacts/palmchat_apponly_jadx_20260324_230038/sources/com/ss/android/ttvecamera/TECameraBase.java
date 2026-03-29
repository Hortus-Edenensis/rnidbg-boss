package com.ss.android.ttvecamera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.bytedance.bpea.basics.Cert;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.cameraalgorithm.TECameraAlgorithmInterface;
import com.ss.android.ttvecamera.cameraalgorithm.TECameraAlgorithmParam;
import com.ss.android.ttvecamera.cameracapabilitycollector.TECameraCapabilityCollector;
import com.ss.android.ttvecamera.cameracapabilitycollector.TECameraCapabilityKBUpload;
import com.ss.android.ttvecamera.model.BurstRequest;
import com.ss.android.ttvecamera.provider.TECameraProviderManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class TECameraBase {
    public static final int CAMERA_FACING_BACK = 0;
    public static final int CAMERA_FACING_FRONT = 1;
    public static final int CAMERA_FACING_WIDE_ANGLE = 2;
    public static final int CAMERA_TYPE_1 = 1;
    public static final int CAMERA_TYPE_2 = 2;
    public static final int HW_CHECK_LEVEL_3 = 3;
    public static final int HW_CHECK_LEVEL_FULL = 2;
    public static final int HW_CHECK_LEVEL_LEGACY = 0;
    public static final int HW_CHECK_LEVEL_LIMITED = 1;
    private static final String TAG = "TECameraBase";
    protected CameraEvents mCameraEvents;
    protected TECameraSettings mCameraSettings;
    protected Context mContext;
    protected int mFacing;
    protected Handler mHandler;
    protected float mMaxZoom;
    protected int mNewFacing;
    protected PictureSizeCallBack mPictureSizeCallback;
    protected TECameraProviderManager mProviderMgr;
    protected SATZoomCallback mSATZoomCallback;
    protected SurfaceTexture mSurfaceTexture;
    public boolean mZslSupport = false;
    protected boolean mIsRunning = false;
    protected int mCameraRotation = -1;
    protected int mDeviceRotation = -1;
    protected int mRetryStartPreviewCount = 0;
    protected PreviewSizeCallBack mPreviewSizeCallback = null;
    protected CameraFpsConfigCallback mFpsConfigCallback = null;
    private AtomicBoolean mUpdateCameraOrientation = new AtomicBoolean(false);
    protected Map<String, Bundle> mFeatures = new HashMap();
    protected Map<Integer, Bundle> mAllDevicesFeatures = new HashMap();
    protected Cert openPrivacyCert = null;
    protected TECameraCapabilityCollector mCapabilityCollector = new TECameraCapabilityCollector();
    public JSONObject mCameraCapabilitiesMap = new JSONObject();
    protected boolean mHaveCollectedCapbilities = false;
    public TECameraAlgorithmInterface mAlgorithmInterface = null;

    /* JADX INFO: compiled from: SearchBox */
    public interface CameraEvents {
        void onCameraClosed(int i, TECameraBase tECameraBase, Object obj);

        void onCameraError(int i, int i2, String str, Object obj);

        void onCameraInfo(int i, int i2, String str, Object obj);

        void onCameraOpened(int i, int i2, TECameraBase tECameraBase, Object obj);

        void onPreviewError(int i, int i2, String str, Object obj);

        void onPreviewStopped(int i, int i2, int i3, String str, Object obj);

        void onPreviewSuccess(int i, int i2, int i3, String str, Object obj);

        void onTorchError(int i, int i2, int i3, String str, Object obj);

        void onTorchSuccess(int i, int i2, int i3, String str, Object obj);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface CameraFpsConfigCallback {
        int[] config(List<int[]> list);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface CameraKitStateCallback {
        void onPause();

        void onResume();

        void onStart();

        void onStop();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class ExposureCompensationInfo {
        public int max = 0;
        public int exposure = 0;
        public int min = 0;
        public float step = 0.0f;

        public boolean isSupportExposureCompensation() {
            return this.max > this.min && this.step > 0.001f;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface PictureSizeCallBack {
        TEFrameSizei getPictureSize(List<TEFrameSizei> list, List<TEFrameSizei> list2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface PreviewSizeCallBack {
        TEFrameSizei getPreviewSize(List<TEFrameSizei> list);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface SATZoomCallback {
        void onChange(int i, float f);
    }

    public TECameraBase(Context context, CameraEvents cameraEvents, Handler handler) {
        this.mContext = context;
        this.mCameraEvents = cameraEvents;
        this.mHandler = handler;
        this.mCapabilityCollector.init(new TECameraCapabilityKBUpload());
    }

    public abstract void cancelFocus();

    public void captureBurst(BurstRequest burstRequest, TECameraSettings.CaptureBufferFrameCallback captureBufferFrameCallback) {
        captureBufferFrameCallback.onError(new UnsupportedOperationException("unsupport capture burst, camera type:" + getCameraType()));
    }

    public void close(Cert cert) {
        TELogUtils.d(TAG, "close...");
    }

    public Exception createException(Exception exc, int i) {
        String message = exc.getMessage();
        if (message == null) {
            message = "Exception message";
        }
        return new Exception(message + ", errorCode=" + i);
    }

    public void destroy() {
        TECameraAlgorithmInterface tECameraAlgorithmInterface = this.mAlgorithmInterface;
        if (tECameraAlgorithmInterface != null) {
            tECameraAlgorithmInterface.destroy();
        }
    }

    public abstract void enableCaf();

    public Bundle fillFeatures() {
        Bundle bundle;
        if (this.mFeatures.containsKey(this.mCameraSettings.mStrCameraID)) {
            bundle = this.mFeatures.get(this.mCameraSettings.mStrCameraID);
        } else {
            bundle = new Bundle();
            this.mFeatures.put(this.mCameraSettings.mStrCameraID, bundle);
        }
        if (bundle != null) {
            bundle.putInt(TECameraSettings.Features.CAMERA_FACING, this.mCameraSettings.mFacing);
        }
        return bundle;
    }

    public abstract void focusAtPoint(TEFocusSettings tEFocusSettings);

    public float[] getApertureRange() {
        return new float[]{-1.0f, -1.0f};
    }

    public abstract TEFrameSizei getBestPreviewSize(float f, TEFrameSizei tEFrameSizei);

    public JSONObject getCameraCapbilitiesForBytebench() {
        return null;
    }

    public int[] getCameraCaptureSize() {
        return null;
    }

    public TECameraSettings.ExposureCompensationInfo getCameraECInfo() {
        return this.mCameraSettings.mCameraECInfo;
    }

    public CameraEvents getCameraEvents() {
        return this.mCameraEvents;
    }

    public TECameraSettings getCameraSettings() {
        return this.mCameraSettings;
    }

    public abstract int getCameraType();

    public Context getContext() {
        return this.mContext;
    }

    public int getExposureCompensation() {
        TECameraSettings.ExposureCompensationInfo exposureCompensationInfo = this.mCameraSettings.mCameraECInfo;
        if (exposureCompensationInfo != null) {
            return exposureCompensationInfo.exposure;
        }
        return 0;
    }

    public abstract float[] getFOV();

    public int getFacing() {
        return this.mFacing;
    }

    public Map<String, Bundle> getFeatures() {
        return this.mFeatures;
    }

    public int getFlashMode() {
        return -1;
    }

    public abstract int getFrameOrientation();

    public int getFrameRotation() {
        if (this.mUpdateCameraOrientation.getAndSet(false)) {
            getFrameOrientation();
        }
        return this.mCameraRotation;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public int getISO() {
        return -1;
    }

    public int[] getISORange() {
        return new int[]{-1, -1};
    }

    public float getManualFocusAbility() {
        return -1.0f;
    }

    public int[] getPictureSize() {
        TEFrameSizei tEFrameSizei = this.mCameraSettings.mPictureSize;
        return new int[]{tEFrameSizei.width, tEFrameSizei.height};
    }

    public int[] getPreviewFps() {
        return null;
    }

    public TECameraProviderManager getProviderManager() {
        return this.mProviderMgr;
    }

    public int getRetryStartPreviewCount() {
        return this.mRetryStartPreviewCount;
    }

    public long[] getShutterTimeRange() {
        return new long[]{-1, -1};
    }

    public List<TEFrameSizei> getSupportedPictureSizes() {
        TELogUtils.e(TAG, "getSupportedPictureSizes error");
        return null;
    }

    public List<TEFrameSizei> getSupportedPreviewSizes() {
        TELogUtils.e(TAG, "getSupportedPreviewSizes error");
        return null;
    }

    public String getWideAngleID() {
        return null;
    }

    public abstract boolean isAutoExposureLockSupported();

    public boolean isAutoFocusLockSupported() {
        return false;
    }

    public boolean isNeedCollectCameraCapabilities() {
        return this.mCameraSettings.mEnableCollectCapbilities && !this.mHaveCollectedCapbilities;
    }

    public abstract boolean isSupportWhileBalance();

    public boolean isSupportedExposureCompensation() {
        TECameraSettings.ExposureCompensationInfo exposureCompensationInfo = this.mCameraSettings.mCameraECInfo;
        return exposureCompensationInfo != null && exposureCompensationInfo.isSupportExposureCompensation();
    }

    public abstract boolean isTorchSupported();

    public abstract int open(int i, int i2, int i3, int i4, int i5, boolean z, Cert cert);

    public int open(TECameraSettings tECameraSettings, Cert cert) {
        this.mRetryStartPreviewCount = tECameraSettings.mRetryStartPreviewCnt;
        TELogUtils.i(TAG, "set start preview retry count: " + this.mRetryStartPreviewCount);
        return 0;
    }

    public void process(TECameraSettings.Operation operation) {
        if (operation == null || operation.getType() != 2) {
            return;
        }
        this.mUpdateCameraOrientation.set(true);
    }

    public TECameraFrame processAlgorithm(TECameraFrame tECameraFrame) {
        TECameraAlgorithmInterface tECameraAlgorithmInterface = this.mAlgorithmInterface;
        if (tECameraAlgorithmInterface != null) {
            return tECameraAlgorithmInterface.processAlgorithm(tECameraFrame);
        }
        return null;
    }

    public abstract void queryShaderZoomStep(TECameraSettings.ShaderZoomCallback shaderZoomCallback);

    public abstract void queryZoomAbility(TECameraSettings.ZoomCallback zoomCallback, boolean z);

    public void registerFpsConfigListener(CameraFpsConfigCallback cameraFpsConfigCallback) {
        this.mFpsConfigCallback = cameraFpsConfigCallback;
    }

    public void registerPreviewListener(PreviewSizeCallBack previewSizeCallBack) {
        this.mPreviewSizeCallback = previewSizeCallBack;
    }

    public void resetRetryStartPreviewCount() {
        this.mRetryStartPreviewCount = this.mCameraSettings.mRetryStartPreviewCnt;
    }

    public void retryStartPreviewOnce() {
        int i = this.mRetryStartPreviewCount;
        if (i > 0) {
            this.mRetryStartPreviewCount = i - 1;
        }
    }

    public abstract void setAutoExposureLock(boolean z);

    public void setDeviceRotation(int i) {
        this.mDeviceRotation = i;
        this.mUpdateCameraOrientation.set(true);
    }

    public abstract boolean setExposureCompensation(int i);

    public void setProviderManager(@NonNull TECameraProviderManager tECameraProviderManager) {
        this.mProviderMgr = tECameraProviderManager;
    }

    public void setSceneMode(int i) {
        TELogUtils.i(TAG, "scene mode: " + i);
    }

    public abstract void setWhileBalance(boolean z, String str);

    public abstract void startCapture();

    public int startRecording() {
        return -1;
    }

    public abstract void startZoom(float f, TECameraSettings.ZoomCallback zoomCallback);

    public abstract void stopCapture();

    public int stopRecording() {
        return -1;
    }

    public void stopRetryStartPreview() {
        this.mRetryStartPreviewCount = 0;
    }

    public abstract void stopZoom(TECameraSettings.ZoomCallback zoomCallback);

    public abstract void switchCameraMode(int i);

    public abstract void switchFlashMode(@TECameraSettings.FlashMode int i);

    public abstract void takePicture(int i, int i2, TECameraSettings.PictureCallback pictureCallback);

    public abstract void takePicture(TECameraSettings.PictureCallback pictureCallback);

    public abstract void toggleTorch(boolean z);

    public abstract void zoomV2(float f, TECameraSettings.ZoomCallback zoomCallback);

    public Bundle getFeatures(String str) {
        return this.mFeatures.get(str);
    }

    public TECameraBase(Context context, CameraEvents cameraEvents, Handler handler, PictureSizeCallBack pictureSizeCallBack) {
        this.mContext = context;
        this.mCameraEvents = cameraEvents;
        this.mHandler = handler;
        this.mPictureSizeCallback = pictureSizeCallBack;
        this.mCapabilityCollector.init(new TECameraCapabilityKBUpload());
    }

    public void abortSession() {
    }

    public void collectCameraCapabilities() {
    }

    public void setPreviewFpsRange() {
    }

    public void stopCameraFaceDetect() {
    }

    public void addCameraAlgorithm(TECameraAlgorithmParam tECameraAlgorithmParam) {
    }

    public void enableMulticamZoom(boolean z) {
    }

    public void forceCloseCamera(Cert cert) {
    }

    public void removeCameraAlgorithm(int i) {
    }

    public void setAperture(float f) {
    }

    public void setAutoFocusLock(boolean z) {
    }

    public void setFeatureParameters(Bundle bundle) {
    }

    public void setISO(int i) {
    }

    public void setManualFocusDistance(float f) {
    }

    public void setSATZoomCallback(SATZoomCallback sATZoomCallback) {
    }

    public void setShutterTime(long j) {
    }

    public void updateCameraAlgorithmParam(TECameraAlgorithmParam tECameraAlgorithmParam) {
    }

    public void useFaceAEStrategy(int i) {
    }

    public void changeRecorderState(int i, CameraKitStateCallback cameraKitStateCallback) {
    }

    public void setPictureSize(int i, int i2) {
    }
}
