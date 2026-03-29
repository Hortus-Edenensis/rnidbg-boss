package com.ss.android.ttvecamera.framework;

import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.os.Bundle;
import com.ss.android.ttvecamera.TECameraBase;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.TEFocusSettings;
import com.ss.android.ttvecamera.model.BurstRequest;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ITECameraMode {
    public static final int CAMERA_SCENE_CAPTURE = 0;
    public static final int CAMERA_SCENE_RECORD = 1;

    void abortSession();

    Rect calculateZoomSize(float f);

    Rect calculateZoomSizeV2(float f);

    int cancelFocus();

    void captureBurst(BurstRequest burstRequest, int i, TECameraSettings.CaptureBufferFrameCallback captureBufferFrameCallback);

    void close();

    void closePreviewSession();

    int enableCaf();

    void fillFeatures();

    int focusAtPoint(int i, int i2, float f, int i3, int i4);

    int focusAtPoint(TEFocusSettings tEFocusSettings);

    float[] getApertureRange();

    int[] getCameraCaptureSize();

    float[] getFOV();

    int getFlashMode();

    int getISO();

    int[] getISORange();

    float getManualFocusAbility();

    int[] getPictureSize();

    int[] getPreviewFps();

    long[] getShutterTimeRange();

    int openCamera(String str, int i) throws CameraAccessException;

    int prepareProvider();

    void process(TECameraSettings.Operation operation);

    void removeFocusSettings();

    void reset();

    String selectCamera(@TECameraSettings.CameraFacing int i) throws CameraAccessException;

    void setAperture(float f);

    void setAutoExposureLock(boolean z);

    void setAutoFocusLock(boolean z);

    void setCameraDevice(Object obj) throws ClassCastException;

    boolean setExposureCompensation(int i);

    void setFeatureParameter(Bundle bundle);

    void setFpsConfigCallback(TECameraBase.CameraFpsConfigCallback cameraFpsConfigCallback);

    void setISO(int i);

    void setManualFocusDistance(float f);

    int setPictureSize(int i, int i2);

    void setPictureSizeCallback(TECameraBase.PictureSizeCallBack pictureSizeCallBack);

    void setPreviewSizeCallback(TECameraBase.PreviewSizeCallBack previewSizeCallBack);

    void setSceneMode(int i);

    void setShutterTime(long j);

    void setWhileBalance(boolean z, String str);

    int startPreview() throws Exception;

    int startRecording();

    int startZoom(float f, TECameraSettings.ZoomCallback zoomCallback);

    int stopRecording();

    void stopZoom();

    void switchFlashMode(int i);

    void takePicture(int i, int i2, TECameraSettings.PictureCallback pictureCallback);

    void takePicture(TECameraSettings.PictureCallback pictureCallback, int i);

    int toggleTorch(boolean z);

    int updateCapture() throws CameraAccessException;

    void zoomV2(float f, TECameraSettings.ZoomCallback zoomCallback);
}
