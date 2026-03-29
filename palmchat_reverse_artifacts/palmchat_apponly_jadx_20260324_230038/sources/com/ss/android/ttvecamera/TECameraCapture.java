package com.ss.android.ttvecamera;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.bytedance.bpea.basics.Cert;
import com.ss.android.ttvecamera.TECameraBase;
import com.ss.android.ttvecamera.TECameraExceptionMonitor;
import com.ss.android.ttvecamera.TECameraMonitor;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.TELogUtils;
import com.ss.android.ttvecamera.cameraalgorithm.TECameraAlgorithmParam;
import com.ss.android.ttvecamera.hardware.TECameraHardware2Proxy;
import com.ss.android.ttvecamera.model.BurstRequest;
import com.ss.android.ttvecamera.provider.TECameraProviderManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@TargetApi(21)
public class TECameraCapture {
    public static final int CAMERA_STATE_CLOSING = 4;
    public static final int CAMERA_STATE_IDLE = 0;
    public static final int CAMERA_STATE_OPENED = 2;
    public static final int CAMERA_STATE_OPENING = 1;
    public static final int CAMERA_STATE_RUNNING = 3;
    private static final String TAG = "TECameraCapture";
    protected CameraFpsConfigCallback mCameraFpsConfigCallback;
    protected CameraObserver mCameraObserver;
    protected TECameraSettings mCameraSettings;
    protected PictureSizeCallBack mPictureSizeCallback;
    protected PreviewSizeCallback mPreviewSizeCallback = null;
    protected Map<String, Bundle> mAllDevicesFeatures = new HashMap();

    /* JADX INFO: compiled from: SearchBox */
    public interface CameraFpsConfigCallback {
        int[] config(List<int[]> list);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface CameraObserver {
        void onCaptureStarted(int i, int i2);

        void onCaptureStopped(int i);

        void onError(int i, String str);

        void onInfo(int i, int i2, String str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface PictureSizeCallBack {
        TEFrameSizei getPictureSize(List<TEFrameSizei> list, List<TEFrameSizei> list2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface PreviewSizeCallback {
        TEFrameSizei getPreviewSize(List<TEFrameSizei> list);
    }

    public TECameraCapture(@NonNull CameraObserver cameraObserver, PictureSizeCallBack pictureSizeCallBack) {
        this.mCameraObserver = NullCameraObserver.getInstance();
        this.mCameraObserver = cameraObserver;
        this.mPictureSizeCallback = pictureSizeCallBack;
        TETraceUtils.init(false);
    }

    private static int convertFacing(int i) {
        return i == 0 ? 1 : 0;
    }

    private static void fillCameraFeatures(Context context, int i, Bundle bundle) {
        if (i != 4) {
            return;
        }
        try {
            CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
            HashMap map = null;
            for (String str : cameraManager.getCameraIdList()) {
                Integer num = (Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING);
                if (num == null || num.intValue() == 0 || num.intValue() == 1) {
                    Iterator<String> it = bundle.keySet().iterator();
                    while (it.hasNext()) {
                        if (TECameraSettings.Features.SUPPORT_ANTI_SHAKE.equals(it.next()) && i == 4) {
                            if (map == null) {
                                map = new HashMap();
                            }
                            map.put(Integer.valueOf(convertFacing(num.intValue())), Boolean.TRUE);
                            bundle.putSerializable(TECameraSettings.Features.SUPPORT_ANTI_SHAKE, map);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void fillDeviceAntiShakeFeature(Context context, int i, Bundle bundle) {
        if (i != 4) {
            return;
        }
        try {
            CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
            HashMap map = null;
            for (String str : cameraManager.getCameraIdList()) {
                Integer num = (Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING);
                if (num == null || num.intValue() == 0 || num.intValue() == 1) {
                    Iterator<String> it = bundle.keySet().iterator();
                    while (it.hasNext()) {
                        if (TECameraSettings.Features.DEVICE_SUPPORT_ANTI_SHAKE.equals(it.next()) && i == 4) {
                            if (map == null) {
                                map = new HashMap();
                            }
                            map.put(Integer.valueOf(convertFacing(num.intValue())), Boolean.TRUE);
                            bundle.putSerializable(TECameraSettings.Features.DEVICE_SUPPORT_ANTI_SHAKE, map);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean fillDeviceFeatures(Context context, int i, Bundle bundle) {
        boolean z = false;
        for (String str : bundle.keySet()) {
            if (TECameraSettings.Features.DEVICE_SUPPORT_CAMERA.equals(str)) {
                bundle.putBoolean(TECameraSettings.Features.DEVICE_SUPPORT_CAMERA, isCameraSupport(context, i));
            } else if (!TECameraSettings.Features.DEVICE_SUPPORT_WIDE_ANGLE.equals(str) || i == 1) {
                z = true;
            } else {
                Long lValueOf = Long.valueOf(System.currentTimeMillis());
                bundle.putBoolean(TECameraSettings.Features.DEVICE_SUPPORT_WIDE_ANGLE, TECameraHardware2Proxy.getDeviceProxy(context, i).isSupportWideAngle());
                TELogUtils.d(TAG, "Get wide angle info cost " + (System.currentTimeMillis() - lValueOf.longValue()) + "ms");
            }
        }
        return z;
    }

    private List<TEFrameSizei> getSupportedPictureSizes() {
        return TECameraServer.INSTANCE.getSupportedPictureSizes(this);
    }

    private List<TEFrameSizei> getSupportedPreviewSizes() {
        return TECameraServer.INSTANCE.getSupportedPreviewSizes(this);
    }

    private static boolean isCameraSupport(Context context, int i) {
        return true;
    }

    public static void queryDeviceFeatures(Context context, int i, Bundle bundle) {
        if (isCameraSupport(context, i) && fillDeviceFeatures(context, i, bundle)) {
            fillCameraFeatures(context, i, bundle);
        }
    }

    public static void registerException(TECameraExceptionMonitor.IExceptionMonitor iExceptionMonitor) {
        TECameraExceptionMonitor.register(iExceptionMonitor);
    }

    public static void registerLogOutput(byte b, TELogUtils.ILog iLog) {
        TELogUtils.register(iLog);
        TELogUtils.setUp("VESDK", b);
    }

    public static void registerMonitor(TECameraMonitor.IMonitor iMonitor) {
        TECameraMonitor.register(iMonitor);
    }

    public int abortSession() {
        return TECameraServer.INSTANCE.abortSession(this);
    }

    public void addCameraAlgorithm(TECameraAlgorithmParam tECameraAlgorithmParam) {
        TECameraServer.INSTANCE.addCameraAlgorithm(tECameraAlgorithmParam);
    }

    public int addCameraProvider(TECameraProviderManager.ProviderSettings providerSettings) {
        return TECameraServer.INSTANCE.addCameraProvider(this, providerSettings);
    }

    public int cancelFocus() {
        return TECameraServer.INSTANCE.cancelFocus(this);
    }

    public int captureBurst(TECameraSettings.CaptureBufferFrameCallback captureBufferFrameCallback, BurstRequest burstRequest) {
        return TECameraServer.INSTANCE.captureBurst(this, captureBufferFrameCallback, burstRequest);
    }

    public void changeAppLifeCycle(boolean z) {
        TECameraServer.INSTANCE.appLifeCycleChanged(z);
    }

    public void changeRecorderState(int i, TECameraBase.CameraKitStateCallback cameraKitStateCallback) {
        TECameraServer.INSTANCE.changeRecorderState(this, i, cameraKitStateCallback);
    }

    public int connect(TECameraSettings tECameraSettings) {
        return connect(tECameraSettings, null);
    }

    public int disConnect() {
        return disConnect((Cert) null);
    }

    public void downExposureCompensation() {
        TECameraServer.INSTANCE.downExposureCompensation(this);
    }

    public int enableCaf() {
        return TECameraServer.INSTANCE.enableCaf(this);
    }

    public void enableMulticamZoom(boolean z) {
        TECameraServer.INSTANCE.enableMulticamZoom(this, z);
    }

    public int focusAtPoint(int i, int i2, float f, int i3, int i4) {
        return focusAtPoint(new TEFocusSettings(i, i2, i3, i4, f));
    }

    public float[] getApertureRange(TECameraSettings.ApertureCallback apertureCallback) {
        return TECameraServer.INSTANCE.getApertureRange(this, apertureCallback);
    }

    public TEFrameSizei getBestPreviewSize(float f, TEFrameSizei tEFrameSizei) {
        return TECameraServer.INSTANCE.getBestPreviewSize(this, f, tEFrameSizei);
    }

    public synchronized void getCameraAllFeatures(Context context, Bundle bundle) {
        if (this.mCameraSettings != null) {
            if (this.mAllDevicesFeatures.containsKey(this.mCameraSettings.mCameraType + "_" + this.mCameraSettings.mFacing)) {
                Bundle bundle2 = this.mAllDevicesFeatures.get(this.mCameraSettings.mCameraType + "_" + this.mCameraSettings.mFacing);
                if (bundle2 != null) {
                    bundle.putAll(bundle2);
                }
            } else {
                getCameraAllFeatures(context, this.mCameraSettings.mCameraType, bundle);
                this.mAllDevicesFeatures.put(this.mCameraSettings.mCameraType + "_" + this.mCameraSettings.mFacing, bundle);
            }
        }
    }

    public JSONObject getCameraCapabilitiesForBytebench(TECameraSettings.CameraCapabilitiesForBytebenchCallback cameraCapabilitiesForBytebenchCallback) {
        return TECameraServer.INSTANCE.getCameraCapbilitiesForBytebench(this, cameraCapabilitiesForBytebenchCallback);
    }

    public int[] getCameraCaptureSize() {
        return TECameraServer.INSTANCE.getCameraCaptureSize();
    }

    public TECameraSettings.ExposureCompensationInfo getCameraECInfo() {
        return TECameraServer.INSTANCE.getCameraECInfo(this);
    }

    public int getCameraState() {
        return TECameraServer.INSTANCE.getCameraState();
    }

    public int getExposureCompensation() {
        return TECameraServer.INSTANCE.getExposureCompensation(this);
    }

    public float[] getFOV(TECameraSettings.FOVCallback fOVCallback) {
        return TECameraServer.INSTANCE.getFOV(this, fOVCallback);
    }

    public int getFlashMode() {
        return TECameraServer.INSTANCE.getFlashMode(this);
    }

    public int getISO(TECameraSettings.ISOCallback iSOCallback) {
        return TECameraServer.INSTANCE.getISO(this, iSOCallback);
    }

    public int[] getISORange(TECameraSettings.ISORangeCallback iSORangeCallback) {
        return TECameraServer.INSTANCE.getISORange(this, iSORangeCallback);
    }

    public float getManualFocusAbility(TECameraSettings.ManualFocusCallback manualFocusCallback) {
        return TECameraServer.INSTANCE.getManualFocusAbility(this, manualFocusCallback);
    }

    public int[] getPictureSize() {
        return TECameraServer.INSTANCE.getPictureSize(this);
    }

    public int[] getPreviewFps() {
        return TECameraServer.INSTANCE.getPreviewFps();
    }

    public long[] getShutterTimeRange(TECameraSettings.ShutterTimeCallback shutterTimeCallback) {
        return TECameraServer.INSTANCE.getShutterTimeRange(this, shutterTimeCallback);
    }

    public boolean isARCoreSupported(Context context) {
        return TECameraHardware2Proxy.getDeviceProxy(context, 2).isARCoreSupported();
    }

    public boolean isAutoExposureLockSupported() {
        return TECameraServer.INSTANCE.isAutoExposureLockSupported(this);
    }

    public boolean isAutoFocuseLockSupported() {
        return TECameraServer.INSTANCE.isAutoFocusLockSupported(this);
    }

    public boolean isCameraSwitchState() {
        return TECameraServer.INSTANCE.isCameraSwitchState();
    }

    public boolean isSupportWhileBalance() {
        return TECameraServer.INSTANCE.isSupportWhileBalance(this);
    }

    public boolean isSupportedExposureCompensation() {
        return TECameraServer.INSTANCE.isSupportedExposureCompensation(this);
    }

    public boolean isTorchSupported() {
        return TECameraServer.INSTANCE.isTorchSupported(this);
    }

    public void notifyHostForegroundVisible(boolean z) {
        TECameraServer.INSTANCE.notifyHostForegroundVisible(this, z);
    }

    public void process(TECameraSettings.Operation operation) {
        TECameraServer.INSTANCE.process(this, operation);
    }

    public TECameraFrame processAlgorithm(TECameraFrame tECameraFrame) {
        return TECameraServer.INSTANCE.processAlgorithm(tECameraFrame);
    }

    public void queryFeatures(Bundle bundle) {
        TECameraSettings tECameraSettings = this.mCameraSettings;
        if (tECameraSettings == null) {
            TELogUtils.e(TAG, "query features failed, maybe not connet");
        } else {
            queryFeatures(tECameraSettings.mStrCameraID, bundle);
        }
    }

    public float queryShaderZoomAbility(TECameraSettings.ShaderZoomCallback shaderZoomCallback) {
        return TECameraServer.INSTANCE.queryShaderZoomStep(this, shaderZoomCallback);
    }

    public int queryZoomAbility(TECameraSettings.ZoomCallback zoomCallback, boolean z) {
        return TECameraServer.INSTANCE.queryZoomAbility(this, zoomCallback, z);
    }

    public void registerFpsConfigListener(CameraFpsConfigCallback cameraFpsConfigCallback) {
        this.mCameraFpsConfigCallback = cameraFpsConfigCallback;
    }

    public void registerPreviewListener(PreviewSizeCallback previewSizeCallback) {
        this.mPreviewSizeCallback = previewSizeCallback;
    }

    public void removeCameraAlgorithm(int i) {
        TECameraServer.INSTANCE.removeCameraAlgorithm(i);
    }

    public int removeCameraProvider() {
        return TECameraServer.INSTANCE.removeCameraProvider(this);
    }

    public void setAperture(float f) {
        TECameraServer.INSTANCE.setAperture(this, f);
    }

    public void setAutoExposureLock(boolean z) {
        TECameraServer.INSTANCE.setAutoExposureLock(this, z);
    }

    public void setAutoFocusLock(boolean z) {
        TECameraServer.INSTANCE.setAutoFocusLock(this, z);
    }

    public void setDeviceRotation(int i) {
        TECameraServer.INSTANCE.setDeviceRotation(i);
    }

    public void setExposureCompensation(int i) {
        TECameraServer.INSTANCE.setExposureCompensation(this, i);
    }

    public void setFeatureParameters(Bundle bundle) {
        TECameraServer.INSTANCE.setFeatureParameters(this, bundle);
    }

    public void setISO(int i) {
        TECameraServer.INSTANCE.setISO(this, i);
    }

    public void setManualFocusDistance(float f) {
        TECameraServer.INSTANCE.setManualFocusDistance(this, f);
    }

    public void setPictureSize(int i, int i2) {
        TECameraServer.INSTANCE.setPictureSize(this, i, i2);
    }

    public void setPreviewFpsRange(TEFrameRateRange tEFrameRateRange) {
        TECameraServer.INSTANCE.setPreviewFpsRange(tEFrameRateRange);
    }

    public void setSATZoomCallback(TECameraSettings.SATZoomCallback sATZoomCallback) {
        TECameraServer.INSTANCE.setSATZoomCallback(sATZoomCallback);
    }

    public void setSceneMode(int i) {
        TECameraServer.INSTANCE.setSceneMode(this, i);
    }

    public void setShutterTime(long j) {
        TECameraServer.INSTANCE.setShutterTime(this, j);
    }

    public void setWhileBalance(boolean z, @TECameraSettings.WhiteBalanceValue String str) {
        TECameraServer.INSTANCE.setWhileBalance(this, z, str);
    }

    public int start() {
        return TECameraServer.INSTANCE.start(this);
    }

    public int startRecording() {
        return TECameraServer.INSTANCE.startRecording();
    }

    public int startZoom(float f, TECameraSettings.ZoomCallback zoomCallback) {
        return TECameraServer.INSTANCE.startZoom(this, f, zoomCallback);
    }

    public int stop() {
        return stop(false);
    }

    public int stopRecording() {
        return TECameraServer.INSTANCE.stopRecording();
    }

    public int stopZoom(TECameraSettings.ZoomCallback zoomCallback) {
        return TECameraServer.INSTANCE.stopZoom(this, zoomCallback);
    }

    public int switchCamera(int i) {
        return switchCamera(i, (Cert) null);
    }

    public int switchCameraMode(int i, TECameraSettings tECameraSettings) {
        if (tECameraSettings != null) {
            this.mCameraSettings = tECameraSettings;
        }
        return TECameraServer.INSTANCE.switchCameraMode(this, i);
    }

    public int switchFlashMode(@TECameraSettings.FlashMode int i) {
        return TECameraServer.INSTANCE.switchFlashMode(this, i);
    }

    public int takePicture(int i, int i2, TECameraSettings.PictureCallback pictureCallback) {
        return TECameraServer.INSTANCE.takePicture(this, i, i2, pictureCallback);
    }

    public int toggleTorch(boolean z) {
        return TECameraServer.INSTANCE.toggleTorch(this, z);
    }

    public void upExposureCompensation() {
        TECameraServer.INSTANCE.upExposureCompensation(this);
    }

    public void updateAllCameraFeatures(Bundle bundle) {
        TECameraSettings tECameraSettings = this.mCameraSettings;
        if (tECameraSettings != null) {
            updateAllCameraFeatures(tECameraSettings.mCameraType, bundle);
            if (!this.mAllDevicesFeatures.containsKey(this.mCameraSettings.mCameraType + "_" + this.mCameraSettings.mFacing)) {
                this.mAllDevicesFeatures.put(this.mCameraSettings.mCameraType + "_" + this.mCameraSettings.mFacing, bundle);
                return;
            }
            Bundle bundle2 = this.mAllDevicesFeatures.get(this.mCameraSettings.mCameraType + "_" + this.mCameraSettings.mFacing);
            if (bundle2 != null) {
                bundle2.putAll(bundle);
            }
        }
    }

    public void updateCameraAlgorithmParam(TECameraAlgorithmParam tECameraAlgorithmParam) {
        TECameraServer.INSTANCE.updateCameraAlgorithmParam(tECameraAlgorithmParam);
    }

    public int zoomV2(float f, TECameraSettings.ZoomCallback zoomCallback) {
        return TECameraServer.INSTANCE.zoomV2(this, f, zoomCallback);
    }

    public int connect(TECameraSettings tECameraSettings, Cert cert) {
        this.mCameraSettings = tECameraSettings;
        TECameraServer tECameraServer = TECameraServer.INSTANCE;
        tECameraServer.registerFpsConfigListener(this.mCameraFpsConfigCallback);
        tECameraServer.registerPreviewSizeListener(this.mPreviewSizeCallback);
        return tECameraServer.connect(this, this.mCameraObserver, this.mCameraSettings, this.mPictureSizeCallback, cert);
    }

    public int disConnect(boolean z) {
        return disConnect(z, null);
    }

    public int focusAtPoint(TEFocusSettings tEFocusSettings) {
        tEFocusSettings.markStartTimeMS();
        return TECameraServer.INSTANCE.focusAtPoint(this, tEFocusSettings);
    }

    public int getCameraState(boolean z) {
        return TECameraServer.INSTANCE.getCameraState(z);
    }

    @Deprecated
    public int start(SurfaceTexture surfaceTexture, int i) {
        TELogUtils.e(TAG, "Do not use this interface!!");
        return start();
    }

    public int stop(boolean z) {
        return TECameraServer.INSTANCE.stop(this, z);
    }

    public int switchCamera(TECameraSettings tECameraSettings) {
        return switchCamera(tECameraSettings, (Cert) null);
    }

    public int takePicture(TECameraSettings.PictureCallback pictureCallback) {
        return TECameraServer.INSTANCE.takePicture(this, pictureCallback);
    }

    public int disConnect(Cert cert) {
        TECameraServer tECameraServer = TECameraServer.INSTANCE;
        tECameraServer.registerFpsConfigListener(null);
        return tECameraServer.disConnect(this, cert);
    }

    public int switchCamera(int i, Cert cert) {
        return TECameraServer.INSTANCE.switchCamera(this, i, cert);
    }

    public void queryFeatures(String str, Bundle bundle) {
        TECameraServer.INSTANCE.queryFeatures(str, bundle);
    }

    public int switchCamera(TECameraSettings tECameraSettings, Cert cert) {
        this.mCameraSettings = tECameraSettings;
        return TECameraServer.INSTANCE.switchCamera(this, tECameraSettings, cert);
    }

    public int disConnect(boolean z, Cert cert) {
        TECameraServer tECameraServer = TECameraServer.INSTANCE;
        tECameraServer.registerFpsConfigListener(null);
        return tECameraServer.disConnect(this, z, cert);
    }

    private void updateAllCameraFeatures(int i, Bundle bundle) {
        TELogUtils.i(TAG, "updateAllCameraFeatures with camera type: " + i);
        Bundle bundle2 = new Bundle();
        String str = this.mCameraSettings.mStrCameraID;
        boolean z = false;
        if (11 == i) {
            bundle2.putInt(TECameraSettings.Features.DEVICE_SUPPORT_AI_NIGHT_VIDEO, 0);
            str = this.mCameraSettings.mCameraType + "_" + this.mCameraSettings.mFacing;
        } else if (10 == i) {
            bundle2.putBoolean(TECameraSettings.Features.DEVICE_SHOULD_USE_SHADER_ZOOM, false);
            str = this.mCameraSettings.mCameraType + "_" + this.mCameraSettings.mFacing;
        } else if (2 == i) {
            bundle2.putBoolean(TECameraSettings.Features.DEVICE_SUPPORT_MULTICAMERA_ZOOM, false);
            str = this.mCameraSettings.mStrCameraID;
        }
        bundle2.putInt(TECameraSettings.Features.DEVICE_SUPPORT_WIDE_ANGLE_MODE, 0);
        queryFeatures(str, bundle2);
        if (11 == i) {
            bundle.putInt(TECameraSettings.Features.DEVICE_SUPPORT_AI_NIGHT_VIDEO, (bundle2.getInt(TECameraSettings.Features.DEVICE_SUPPORT_AI_NIGHT_VIDEO) <= 0 || bundle.getInt(TECameraSettings.Features.DEVICE_SUPPORT_AI_NIGHT_VIDEO) <= 0) ? 0 : 1);
        }
        bundle.putInt(TECameraSettings.Features.DEVICE_SUPPORT_WIDE_ANGLE_MODE, (bundle2.getInt(TECameraSettings.Features.DEVICE_SUPPORT_WIDE_ANGLE_MODE) <= 0 || bundle.getInt(TECameraSettings.Features.DEVICE_SUPPORT_WIDE_ANGLE_MODE) <= 0) ? 0 : 1);
        if (10 == i) {
            bundle.putBoolean(TECameraSettings.Features.DEVICE_SHOULD_USE_SHADER_ZOOM, bundle2.getBoolean(TECameraSettings.Features.DEVICE_SHOULD_USE_SHADER_ZOOM));
        }
        if (2 == i) {
            boolean z2 = bundle2.getBoolean(TECameraSettings.Features.DEVICE_SUPPORT_MULTICAMERA_ZOOM);
            boolean z3 = bundle.getBoolean(TECameraSettings.Features.DEVICE_SUPPORT_MULTICAMERA_ZOOM);
            if (z2 && z3) {
                z = true;
            }
            bundle.putBoolean(TECameraSettings.Features.DEVICE_SUPPORT_MULTICAMERA_ZOOM, z);
        }
        List<TEFrameSizei> supportedPreviewSizes = getSupportedPreviewSizes();
        List<TEFrameSizei> supportedPictureSizes = getSupportedPictureSizes();
        if (supportedPreviewSizes != null) {
            bundle.putParcelableArrayList(TECameraSettings.Features.SUPPORT_PREVIEW_SIZES, (ArrayList) supportedPreviewSizes);
        }
        if (supportedPictureSizes != null) {
            bundle.putParcelableArrayList(TECameraSettings.Features.SUPPORT_PICTURE_SIZES, (ArrayList) supportedPictureSizes);
        }
        TELogUtils.i(TAG, "updateAllCameraFeatures, feature bundle = " + bundle);
    }

    public TECameraCapture(@NonNull CameraObserver cameraObserver) {
        this.mCameraObserver = NullCameraObserver.getInstance();
        this.mCameraObserver = cameraObserver;
    }

    private void getCameraAllFeatures(Context context, int i, Bundle bundle) {
        TELogUtils.i(TAG, "getCameraAllFeatures with camera type: " + i);
        if (i == 1) {
            bundle.putBoolean(TECameraSettings.Features.DEVICE_SUPPORT_WIDE_ANGLE, false);
        } else if (11 != i) {
            String filledWideCameraId = TECameraHardware2Proxy.getDeviceProxy(context, i).getFilledWideCameraId();
            TELogUtils.i(TAG, "getCameraAllFeatures, filledWideCameraId: " + filledWideCameraId);
            if ("-1".equals(filledWideCameraId)) {
                boolean zIsSupportWideAngle = TECameraHardware2Proxy.getDeviceProxy(context, i).isSupportWideAngle();
                bundle.putBoolean(TECameraSettings.Features.DEVICE_SUPPORT_WIDE_ANGLE, zIsSupportWideAngle);
                if (zIsSupportWideAngle) {
                    bundle.putString(TECameraSettings.Features.DEVICE_WIDE_ANGLE_CAMERA_ID, TECameraHardware2Proxy.getDeviceProxy(context, i).getWideAngleID());
                }
            } else if (filledWideCameraId.equals("0")) {
                bundle.putBoolean(TECameraSettings.Features.DEVICE_SUPPORT_WIDE_ANGLE, false);
            } else {
                bundle.putBoolean(TECameraSettings.Features.DEVICE_SUPPORT_WIDE_ANGLE, true);
                bundle.putString(TECameraSettings.Features.DEVICE_WIDE_ANGLE_CAMERA_ID, filledWideCameraId);
            }
        }
        if (10 == i) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean(TECameraSettings.Features.DEVICE_SHOULD_USE_SHADER_ZOOM, false);
            queryFeatures(this.mCameraSettings.mCameraType + "_" + this.mCameraSettings.mFacing, bundle2);
            bundle.putBoolean(TECameraSettings.Features.DEVICE_SHOULD_USE_SHADER_ZOOM, bundle2.getBoolean(TECameraSettings.Features.DEVICE_SHOULD_USE_SHADER_ZOOM));
            TELogUtils.i(TAG, "getCameraAllFeatures, vendor rdhw type, feature bundle = " + bundle);
        }
        Bundle bundle3 = new Bundle();
        bundle3.putSerializable(TECameraSettings.Features.DEVICE_SUPPORT_ANTI_SHAKE, null);
        fillDeviceAntiShakeFeature(context, i, bundle3);
        if (bundle3.size() > 0) {
            bundle.putAll(bundle3);
        }
        TELogUtils.i(TAG, "getCameraAllFeatures, features = " + bundle);
    }

    public void changeCaptureFormat() {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class NullCameraObserver implements CameraObserver {
        private static volatile NullCameraObserver INSTANCE;

        public static NullCameraObserver getInstance() {
            NullCameraObserver nullCameraObserver;
            synchronized (NullCameraObserver.class) {
                if (INSTANCE == null) {
                    synchronized (NullCameraObserver.class) {
                        INSTANCE = new NullCameraObserver();
                    }
                }
                nullCameraObserver = INSTANCE;
            }
            return nullCameraObserver;
        }

        @Override // com.ss.android.ttvecamera.TECameraCapture.CameraObserver
        public void onCaptureStopped(int i) {
        }

        @Override // com.ss.android.ttvecamera.TECameraCapture.CameraObserver
        public void onCaptureStarted(int i, int i2) {
        }

        @Override // com.ss.android.ttvecamera.TECameraCapture.CameraObserver
        public void onError(int i, String str) {
        }

        @Override // com.ss.android.ttvecamera.TECameraCapture.CameraObserver
        public void onInfo(int i, int i2, String str) {
        }
    }
}
