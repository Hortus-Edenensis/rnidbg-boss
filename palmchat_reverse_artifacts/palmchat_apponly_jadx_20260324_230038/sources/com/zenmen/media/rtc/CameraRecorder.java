package com.zenmen.media.rtc;

import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.oplus.tblplayer.processor.util.EffectConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class CameraRecorder implements Camera.PreviewCallback {
    public static final int BIT_RATE = 255000;
    public static final int FRAME_RATE = 15;
    public static final int OPEN_AUDIO_FAILT = -2;
    public static final int OPEN_CAMERA_FAILT = -1;
    public static final int OPEN_CAMERA_OK = 0;
    private static String TAG = "RecorderCameraView";
    private int channel;
    int mActualFramerate;
    private boolean mAutoFocus;
    int mBitrate;
    private Camera mCamera;
    private CameraHandler mCameraHandler;
    private int mDefaultOritation;
    private int mDeviceOritation;
    private int mDisaplayOritation;
    int mFramerate;
    private boolean mIsSupportZoom;
    private boolean mPreviewRunning;
    private String mRecordVideoFilePath;
    private boolean mSetCallback;
    private boolean mSupport;
    private SurfaceTexture mSurfaceTexture;
    public CameraView mSurfaceView;
    private long mVideoCount;
    private ZMRtcSDK mZMRtc;
    private boolean mZoomIn;
    private CAMERA_TYPE m_CameraType;
    private int prevideoHeight;
    private int prevideoWidth;
    private int sampleRate;
    int[] the_default_fps_range;
    int[] the_setting_fps_range;
    private int videoHight;
    private int videoWidth;

    /* JADX INFO: compiled from: SearchBox */
    public enum CAMERA_TYPE {
        CAMERA_FRONT,
        CAMERA_BACK
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class CameraHandler extends Handler {
        public static final int MSG_CHANGED_SURFACE_TEXTURE = 1;
        public static final int MSG_SET_SURFACE_TEXTURE = 0;
        private WeakReference<CameraRecorder> mWeakInst;

        public CameraHandler(CameraRecorder cameraRecorder) {
            this.mWeakInst = new WeakReference<>(cameraRecorder);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Log.d(CameraRecorder.TAG, "CameraHandler [" + this + "]: what=" + i);
            CameraRecorder cameraRecorder = this.mWeakInst.get();
            if (cameraRecorder == null) {
                Log.w(CameraRecorder.TAG, "CameraHandler.handleMessage: activity is null");
                return;
            }
            if (i == 0) {
                cameraRecorder.handleSetSurfaceTexture((SurfaceTexture) message.obj);
            } else {
                if (i == 1) {
                    return;
                }
                throw new RuntimeException("unknown msg " + i);
            }
        }

        public void invalidateHandler() {
            this.mWeakInst.clear();
        }
    }

    public CameraRecorder() {
        this.mSurfaceView = null;
        this.mSurfaceTexture = null;
        this.mCamera = null;
        this.mPreviewRunning = false;
        this.m_CameraType = CAMERA_TYPE.CAMERA_FRONT;
        this.mSetCallback = true;
        this.mDisaplayOritation = 90;
        this.mDeviceOritation = 0;
        this.mDefaultOritation = 0;
        this.mVideoCount = 0L;
        this.mSupport = false;
        this.mAutoFocus = false;
        this.mIsSupportZoom = false;
        this.mZoomIn = true;
        this.sampleRate = 44100;
        this.channel = 1;
        this.videoWidth = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        this.videoHight = 240;
        this.prevideoWidth = 1280;
        this.prevideoHeight = 720;
        this.mFramerate = 15;
        this.mActualFramerate = 30;
        this.mBitrate = 15 * ErrorCode.REASON_DS_OUT_OF_RANGE;
        this.mRecordVideoFilePath = null;
        this.mZMRtc = null;
        this.the_default_fps_range = null;
        this.the_setting_fps_range = null;
        this.mCameraHandler = new CameraHandler(this);
    }

    private void InitCamera(Camera.CameraInfo cameraInfo) {
        boolean z;
        Camera camera = this.mCamera;
        if (camera == null) {
            return;
        }
        if (this.mPreviewRunning) {
            camera.stopPreview();
            this.mPreviewRunning = false;
        }
        int i = this.prevideoWidth;
        int i2 = this.prevideoHeight;
        try {
            List<Camera.Size> supportedPreviewSizes = this.mCamera.getParameters().getSupportedPreviewSizes();
            if (supportedPreviewSizes.size() > 1) {
                z = false;
                for (Camera.Size size : supportedPreviewSizes) {
                    Log.e(TAG, "cw = " + size.width + "ch = " + size.height);
                    if (i == size.width && i2 == size.height) {
                        z = true;
                    }
                }
            } else {
                z = false;
            }
            if (!z) {
                Camera.Size optimalPreviewSize = getOptimalPreviewSize(supportedPreviewSizes, i, i2);
                i = optimalPreviewSize.width;
                i2 = optimalPreviewSize.height;
            }
            this.prevideoWidth = i;
            this.prevideoHeight = i2;
            this.videoWidth = (this.videoHight * i2) / i;
            Log.i("TAG", "prevideoWidth = " + this.prevideoWidth + "  prevideoHeight：" + this.prevideoHeight);
            calOritation(cameraInfo);
            Camera.Parameters parameters = this.mCamera.getParameters();
            parameters.setPreviewSize(i, i2);
            parameters.setPreviewFormat(17);
            if (this.the_default_fps_range == null) {
                int[] iArr = new int[2];
                this.the_default_fps_range = iArr;
                parameters.getPreviewFpsRange(iArr);
            }
            List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
            int[] iArr2 = new int[2];
            int i3 = 65535;
            for (int i4 = 0; i4 < supportedPreviewFpsRange.size(); i4++) {
                int[] iArr3 = supportedPreviewFpsRange.get(i4);
                Log.e(TAG, "< " + i4 + " > Min = " + iArr3[0] + "  Max = " + iArr3[1]);
                int i5 = iArr3[0];
                int i6 = this.mActualFramerate;
                int i7 = i5 - (i6 * 1000);
                if (i7 < 0) {
                    i7 = -i7;
                }
                int i8 = i5 - (i6 * 1000);
                if (i8 < 0) {
                    i8 = -i8;
                }
                int i9 = i7 + i8;
                if (i9 < i3) {
                    iArr2[0] = i5;
                    iArr2[1] = iArr3[1];
                    i3 = i9;
                }
            }
            int i10 = iArr2[1];
            int i11 = i10 / 1000;
            this.mActualFramerate = i11;
            if (i11 > 30) {
                this.mActualFramerate = 30;
            }
            this.the_setting_fps_range = new int[]{iArr2[0], i10};
            this.mIsSupportZoom = parameters.isZoomSupported();
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null) {
                if (supportedFocusModes.contains("continuous-picture")) {
                    parameters.setFocusMode("continuous-picture");
                    this.mAutoFocus = true;
                } else if (supportedFocusModes.contains("auto")) {
                    parameters.setFocusMode("auto");
                    this.mAutoFocus = true;
                }
            }
            List<String> supportedWhiteBalance = parameters.getSupportedWhiteBalance();
            if (supportedWhiteBalance != null && supportedWhiteBalance.contains("auto")) {
                parameters.setWhiteBalance("auto");
            }
            parameters.setAutoExposureLock(false);
            this.mCamera.setParameters(parameters);
            try {
                int maxExposureCompensation = (parameters.getMaxExposureCompensation() - parameters.getMinExposureCompensation()) / 3;
                this.mCamera.setParameters(parameters);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            this.mCamera.setDisplayOrientation(this.mDefaultOritation);
            this.mCamera.addCallbackBuffer(new byte[((i * i2) * 3) / 2]);
            this.mCamera.setPreviewCallbackWithBuffer(this);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        this.mSetCallback = true;
        ZMRtcSDK zMRtcSDK = this.mZMRtc;
        if (zMRtcSDK != null) {
            zMRtcSDK.setVideoCaptureInfo(this.prevideoWidth, this.prevideoHeight, this.videoWidth, this.videoHight, this.mDisaplayOritation);
        }
    }

    private void calOritation(Camera.CameraInfo cameraInfo) {
        int i = this.mDeviceOritation;
        int i2 = 0;
        if (i != 0) {
            if (i == 1) {
                i2 = 90;
            } else if (i == 2) {
                i2 = EffectConstants.ROTATION_DEGREES_180;
            } else if (i == 3) {
                i2 = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            int i3 = (cameraInfo.orientation + i2) % 360;
            this.mDefaultOritation = i3;
            this.mDefaultOritation = (360 - i3) % 360;
        } else {
            this.mDefaultOritation = ((cameraInfo.orientation - i2) + 360) % 360;
        }
        int i4 = cameraInfo.orientation;
        this.mDisaplayOritation = i4;
        this.mSurfaceView.setWidthHeight(this.prevideoWidth, this.prevideoHeight, i4);
    }

    private void cancelAutoFocus() {
        Camera camera = this.mCamera;
        if (camera == null) {
            return;
        }
        try {
            if (this.mAutoFocus) {
                camera.cancelAutoFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closeCamera() {
        try {
            Camera camera = this.mCamera;
            if (camera != null) {
                if (this.mSetCallback) {
                    camera.setPreviewCallback(null);
                    this.mSetCallback = false;
                }
                this.mCamera.stopPreview();
                this.mPreviewRunning = false;
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean createCamera() {
        if (this.mCamera != null) {
            closeCamera();
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        if (Camera.getNumberOfCameras() == 1) {
            try {
                Camera.getCameraInfo(0, cameraInfo);
                this.m_CameraType = cameraInfo.facing == 1 ? CAMERA_TYPE.CAMERA_FRONT : CAMERA_TYPE.CAMERA_BACK;
            } catch (Exception unused) {
                return false;
            }
        }
        for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
            try {
                Camera.getCameraInfo(i, cameraInfo);
                int i2 = cameraInfo.facing;
                try {
                    if (i2 == 1 && this.m_CameraType == CAMERA_TYPE.CAMERA_FRONT) {
                        Log.i("TAG", "open an front camera");
                        this.mCamera = Camera.open(i);
                    } else if (i2 == 0 && this.m_CameraType == CAMERA_TYPE.CAMERA_BACK) {
                        Log.i("TAG", "open an back camera");
                        this.mCamera = Camera.open(i);
                    }
                    break;
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                return false;
            }
        }
        if (this.mCamera == null) {
            Log.i("TAG", "could not open an camera");
            this.mSupport = false;
            return false;
        }
        InitCamera(cameraInfo);
        this.mSupport = true;
        return true;
    }

    private Camera.Size getOptimalPreviewSize(List<Camera.Size> list, int i, int i2) {
        double d = ((double) i2) / ((double) i);
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        double dAbs = Double.MAX_VALUE;
        double dAbs2 = Double.MAX_VALUE;
        for (Camera.Size size2 : list) {
            if (Math.abs((((double) size2.width) / ((double) size2.height)) - d) <= 0.1d && Math.abs(size2.height - i2) < dAbs2) {
                dAbs2 = Math.abs(size2.height - i2);
                size = size2;
            }
        }
        if (size == null) {
            for (Camera.Size size3 : list) {
                if (Math.abs(size3.height - i2) < dAbs) {
                    dAbs = Math.abs(size3.height - i2);
                    size = size3;
                }
            }
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSetSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.mSurfaceTexture = surfaceTexture;
        startPreview();
    }

    private void setCameraFpsRange(int i, int i2) {
        Camera.Parameters parameters = this.mCamera.getParameters();
        parameters.setPreviewFpsRange(i, i2);
        this.mCamera.setParameters(parameters);
    }

    private void startPreview() {
        Camera camera;
        Log.i("TAG", "CameraView startPreview");
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null || (camera = this.mCamera) == null || this.mPreviewRunning) {
            return;
        }
        try {
            camera.setPreviewTexture(surfaceTexture);
            this.mCamera.startPreview();
        } catch (Exception unused) {
        }
        this.mPreviewRunning = true;
        cancelAutoFocus();
    }

    private void swap() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i = 0;
        if (this.m_CameraType != CAMERA_TYPE.CAMERA_FRONT) {
            while (true) {
                if (i >= Camera.getNumberOfCameras()) {
                    break;
                }
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 1) {
                    Camera camera = this.mCamera;
                    if (camera != null) {
                        camera.stopPreview();
                        this.mCamera.release();
                        this.mCamera = null;
                    }
                    try {
                        this.mCamera = Camera.open(i);
                    } catch (Exception unused) {
                    }
                    if (this.mCamera == null) {
                        Log.e(TAG, "Open camera fail");
                        return;
                    } else {
                        this.m_CameraType = CAMERA_TYPE.CAMERA_FRONT;
                        InitCamera(cameraInfo);
                        startPreview();
                    }
                } else {
                    i++;
                }
            }
        } else {
            while (true) {
                if (i >= Camera.getNumberOfCameras()) {
                    break;
                }
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 0) {
                    Camera camera2 = this.mCamera;
                    if (camera2 != null) {
                        camera2.stopPreview();
                        this.mCamera.release();
                        this.mCamera = null;
                    }
                    try {
                        this.mCamera = Camera.open(i);
                    } catch (Exception unused2) {
                    }
                    if (this.mCamera == null) {
                        Log.e(TAG, "Open camera fail");
                        return;
                    } else {
                        this.m_CameraType = CAMERA_TYPE.CAMERA_BACK;
                        InitCamera(cameraInfo);
                        startPreview();
                    }
                } else {
                    i++;
                }
            }
        }
        ZMRtcSDK zMRtcSDK = this.mZMRtc;
        if (zMRtcSDK != null) {
            zMRtcSDK.resetVideoCapture(this.videoWidth, this.videoHight, this.mDisaplayOritation);
        }
    }

    public Rect calculateTapArea(int i, int i2, float f, float f2, float f3, int i3, int i4, int i5, int i6) {
        int i7 = (int) (i * f);
        int i8 = (int) (i2 * f);
        double d = (((double) i4) - ((double) i3)) / 2000.0d;
        double d2 = (((double) i6) - ((double) i5)) / 2000.0d;
        int iClamp = clamp((int) (((double) ((f2 - (i7 / 2)) - ((i3 + i4) / 2))) / d), -1000, 1000);
        int iClamp2 = clamp((int) (((double) ((f3 - (i8 / 2)) - ((i5 + i6) / 2))) / d2), -1000, 1000);
        return new Rect(iClamp, iClamp2, clamp((int) (((double) iClamp) + (((double) i7) / d)), -1000, 1000), clamp((int) (((double) iClamp2) + (((double) i8) / d2)), -1000, 1000));
    }

    public int clamp(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    public void destroy() {
        this.mSurfaceView = null;
        closeCamera();
        CameraHandler cameraHandler = this.mCameraHandler;
        if (cameraHandler != null) {
            cameraHandler.invalidateHandler();
        }
    }

    public void doAutoFocus() {
        Camera.Parameters parameters;
        List<String> supportedFocusModes;
        Camera camera = this.mCamera;
        if (camera == null || (supportedFocusModes = (parameters = camera.getParameters()).getSupportedFocusModes()) == null || !supportedFocusModes.contains("continuous-picture")) {
            return;
        }
        parameters.setFocusMode("continuous-picture");
        this.mCamera.autoFocus(new Camera.AutoFocusCallback() { // from class: com.zenmen.media.rtc.CameraRecorder.1
            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z, Camera camera2) {
            }
        });
    }

    public void focusOnTouch(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        CameraView cameraView = this.mSurfaceView;
        if (cameraView == null || this.mCamera == null) {
            return;
        }
        cameraView.getLocationOnScreen(iArr);
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int i = iArr[0];
        int width = i + this.mSurfaceView.getWidth();
        int i2 = iArr[1];
        Rect rectCalculateTapArea = calculateTapArea(80, 80, 1.0f, rawX, rawY, i, width, i2, i2 + this.mSurfaceView.getHeight());
        float rawX2 = motionEvent.getRawX();
        float rawY2 = motionEvent.getRawY();
        int i3 = iArr[0];
        int width2 = i3 + this.mSurfaceView.getWidth();
        int i4 = iArr[1];
        Rect rectCalculateTapArea2 = calculateTapArea(80, 80, 1.5f, rawX2, rawY2, i3, width2, i4, i4 + this.mSurfaceView.getHeight());
        this.mCamera.cancelAutoFocus();
        Camera.Parameters parameters = this.mCamera.getParameters();
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes != null && supportedFocusModes.contains("auto")) {
            parameters.setFocusMode("auto");
            this.mAutoFocus = true;
        }
        if (parameters.getMaxNumFocusAreas() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Camera.Area(rectCalculateTapArea, 1000));
            parameters.setFocusAreas(arrayList);
        }
        if (parameters.getMaxNumMeteringAreas() > 0) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new Camera.Area(rectCalculateTapArea2, 1000));
            parameters.setMeteringAreas(arrayList2);
        }
        try {
            this.mCamera.setParameters(parameters);
        } catch (Exception unused) {
        }
        this.mCamera.autoFocus(new Camera.AutoFocusCallback() { // from class: com.zenmen.media.rtc.CameraRecorder.2
            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z, Camera camera) {
                StringBuilder sb = new StringBuilder();
                sb.append("focusOn: AutoFocus:");
                sb.append(z ? "Succeeded" : "Failed");
                Log.i("TAG", sb.toString());
            }
        });
    }

    public CameraHandler getCameraHandler() {
        return this.mCameraHandler;
    }

    public int getVideoHight() {
        return this.videoHight;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public void increaseCameraExposure(boolean z) {
        if (z) {
            int[] iArr = this.the_default_fps_range;
            if (iArr != null) {
                setCameraFpsRange(iArr[0], iArr[1]);
                return;
            }
            return;
        }
        int[] iArr2 = this.the_setting_fps_range;
        if (iArr2 != null) {
            setCameraFpsRange(iArr2[0], iArr2[1]);
        }
    }

    public void init(int i, int i2, CameraView cameraView, int i3) {
        this.videoWidth = i;
        this.videoHight = i2;
        this.mBitrate = (((i * i2) * 4) * this.mFramerate) / this.mActualFramerate;
        this.mSurfaceView = cameraView;
        this.mDeviceOritation = i3;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (bArr == null) {
            Camera.Parameters parameters = camera.getParameters();
            Camera.Size previewSize = parameters.getPreviewSize();
            int bitsPerPixel = ((previewSize.width * previewSize.height) * ImageFormat.getBitsPerPixel(parameters.getPreviewFormat())) / 8;
            camera.addCallbackBuffer(new byte[bitsPerPixel + (bitsPerPixel / 20)]);
        } else {
            ZMRtcSDK zMRtcSDK = this.mZMRtc;
            if (zMRtcSDK != null) {
                zMRtcSDK.ProvideCameraFrame(bArr, bArr.length, 0, 0L);
            }
            camera.addCallbackBuffer(bArr);
        }
        this.mVideoCount++;
    }

    public int openCamera() {
        if (!createCamera()) {
            return -1;
        }
        startPreview();
        return 0;
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.mSurfaceTexture = surfaceTexture;
    }

    public void setVideoBitrate(int i) {
        this.mBitrate = i;
    }

    public void setZoom(int i, boolean z) {
        Camera camera = this.mCamera;
        if (camera != null && this.mIsSupportZoom) {
            try {
                Camera.Parameters parameters = camera.getParameters();
                int maxZoom = parameters.getMaxZoom();
                if (maxZoom == 0) {
                    return;
                }
                int i2 = 0;
                if (z) {
                    Iterator<Integer> it = parameters.getZoomRatios().iterator();
                    while (it.hasNext() && it.next().intValue() <= i) {
                        i2++;
                    }
                    if (i2 < maxZoom) {
                        maxZoom = i2;
                    }
                    i2 = maxZoom;
                }
                parameters.setZoom(i2);
                this.mCamera.setParameters(parameters);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setZoomRatio(int i) {
        Camera camera = this.mCamera;
        if (camera == null || !this.mIsSupportZoom) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        int maxZoom = parameters.getMaxZoom();
        List<Integer> zoomRatios = parameters.getZoomRatios();
        int i2 = 0;
        while (true) {
            if (i2 >= zoomRatios.size()) {
                i2 = -1;
                break;
            }
            Log.e(TAG, "zRatios: " + zoomRatios.get(i2));
            if (zoomRatios.get(i2).intValue() >= i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            maxZoom = i2;
        }
        parameters.setZoom(maxZoom);
        this.mCamera.setParameters(parameters);
    }

    public void stopCamera() {
        closeCamera();
    }

    public void switchCamera() {
        swap();
    }

    public CameraRecorder(ZMRtcSDK zMRtcSDK, CAMERA_TYPE camera_type) {
        this.mSurfaceView = null;
        this.mSurfaceTexture = null;
        this.mCamera = null;
        this.mPreviewRunning = false;
        CAMERA_TYPE camera_type2 = CAMERA_TYPE.CAMERA_FRONT;
        this.mSetCallback = true;
        this.mDisaplayOritation = 90;
        this.mDeviceOritation = 0;
        this.mDefaultOritation = 0;
        this.mVideoCount = 0L;
        this.mSupport = false;
        this.mAutoFocus = false;
        this.mIsSupportZoom = false;
        this.mZoomIn = true;
        this.sampleRate = 44100;
        this.channel = 1;
        this.videoWidth = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        this.videoHight = 240;
        this.prevideoWidth = 1280;
        this.prevideoHeight = 720;
        this.mFramerate = 15;
        this.mActualFramerate = 30;
        this.mBitrate = 15 * ErrorCode.REASON_DS_OUT_OF_RANGE;
        this.mRecordVideoFilePath = null;
        this.the_default_fps_range = null;
        this.the_setting_fps_range = null;
        this.mZMRtc = zMRtcSDK;
        this.m_CameraType = camera_type;
        this.mCameraHandler = new CameraHandler(this);
    }
}
