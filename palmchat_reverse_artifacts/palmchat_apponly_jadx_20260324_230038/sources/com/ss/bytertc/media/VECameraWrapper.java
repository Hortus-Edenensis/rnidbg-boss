package com.ss.bytertc.media;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.alipay.sdk.m.x.d;
import com.bytedance.realx.base.CalledByNative;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.GlUtil;
import com.bytedance.realx.video.NV21Buffer;
import com.bytedance.realx.video.RXPixelFormat;
import com.bytedance.realx.video.TextureBufferImpl;
import com.bytedance.realx.video.TimestampAligner;
import com.bytedance.realx.video.VideoFrame;
import com.bytedance.realx.video.YuvConverter;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.igexin.push.config.c;
import com.ss.android.ttvecamera.TECameraCapture;
import com.ss.android.ttvecamera.TECameraFrame;
import com.ss.android.ttvecamera.TECameraResult;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.TEFocusSettings;
import com.ss.android.ttvecamera.TEFrameRateRange;
import com.ss.android.ttvecamera.TEFrameSizei;
import com.ss.android.ttvecamera.TELogUtils;
import com.ss.android.ttvecamera.provider.TECameraProvider;
import com.ss.android.ttvecamera.provider.TECameraProviderManager;
import com.ss.bytertc.engine.UIDeviceOrientation;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class VECameraWrapper {
    private long mNativeObj;
    CamParam mParam;
    private EglBase.Context mSharedCtx;
    private Context mContext = null;
    private TECameraCapture mCamera = null;
    private Object mCameraLock = new Object();
    private TECameraSettings mVESettings = null;
    private int mLastDeviceOrientation = 0;
    private int mLastUIOrientation = 0;
    private long mLastDeviceOrientationTS = 0;
    private EventObserver mEventObserver = null;
    private FrameListener mFrameListener = null;
    private int mActWidth = 0;
    private int mActHeight = 0;
    private final int STA_STOPPED = 0;
    private final int STA_STARTING = 1;
    private final int STA_STARTED = 2;
    AtomicInteger mCamState = new AtomicInteger(0);
    private volatile LogCallback mLogger = new LogCallback();
    private final String TAG2SVR = "toSvr";
    private final int CAMERA_BLOCK_THRESHOLD_MS = 2000;
    private boolean mIsExposurePointSupported = true;
    private boolean mIsFocusPointSupported = true;
    private boolean mUseGravitySensor = false;
    private AtomicInteger mGravityOrientation = new AtomicInteger(UIDeviceOrientation.Portrait.value());
    private Camera.CameraInfo mCamInfo = null;
    private Camera.CameraInfo[] mCamInfoList = null;
    private final SensorEventListener mSensorListener = new SensorEventListener() { // from class: com.ss.bytertc.media.VECameraWrapper.2
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float fAbs = Math.abs(f);
            float fAbs2 = Math.abs(f2);
            if (Math.abs(fAbs - fAbs2) < 6.0d) {
                return;
            }
            if (fAbs >= fAbs2) {
                if (f >= 0.0f) {
                    VECameraWrapper.this.mGravityOrientation.set(UIDeviceOrientation.LandscapeRight.value());
                    return;
                } else {
                    VECameraWrapper.this.mGravityOrientation.set(UIDeviceOrientation.LandscapeLeft.value());
                    return;
                }
            }
            if (f2 >= 0.0f) {
                VECameraWrapper.this.mGravityOrientation.set(UIDeviceOrientation.Portrait.value());
            } else {
                VECameraWrapper.this.mGravityOrientation.set(UIDeviceOrientation.PortraitUpsidedown.value());
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public static class CamDevInfo {
        private String id;
        private String name;
        private int pos;

        public CamDevInfo(String str, String str2, int i) {
            this.id = str;
            this.name = str2;
            this.pos = i;
        }

        @CalledByNative("CamDevInfo")
        public String getID() {
            return this.id;
        }

        @CalledByNative("CamDevInfo")
        public String getName() {
            return this.name;
        }

        @CalledByNative("CamDevInfo")
        public int getPosition() {
            return this.pos;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class CamParam {
        public boolean antiShake;
        public boolean camera2;
        public String camid;
        public boolean enable_dynamic_fps;
        public boolean faceAE;
        public int fps;
        public int height;
        public int min_dynamic_fps;
        public int pos;
        public boolean useTexture;
        public boolean wideAngle;
        public int width;

        @CalledByNative("CamParam")
        public CamParam(int i, int i2, int i3, int i4, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i5) {
            this.width = i;
            this.height = i2;
            this.fps = i3;
            this.pos = i4;
            this.camid = str;
            this.useTexture = z;
            this.camera2 = z2;
            this.faceAE = z3;
            this.wideAngle = z4;
            this.antiShake = z5;
            this.enable_dynamic_fps = z6;
            this.min_dynamic_fps = i5;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class EventObserver implements TECameraCapture.CameraObserver {
        public EventObserver() {
        }

        @Override // com.ss.android.ttvecamera.TECameraCapture.CameraObserver
        public void onCaptureStarted(int i, int i2) {
            VECameraWrapper.this.mLogger.Log((byte) 8, "toSvr", "CameraObserver.onCaptureStarted ret = " + i2);
            if (i2 == 0) {
                CamParam camParam = VECameraWrapper.this.mParam;
                TEFrameSizei tEFrameSizei = new TEFrameSizei(camParam.width, camParam.height);
                VECameraWrapper vECameraWrapper = VECameraWrapper.this;
                int iAddCameraProvider = VECameraWrapper.this.mCamera.addCameraProvider(vECameraWrapper.mParam.useTexture ? new TECameraProviderManager.ProviderSettings(tEFrameSizei, (TECameraProvider.CaptureListener) vECameraWrapper.mFrameListener, true, VECameraWrapper.this.mFrameListener.mSurfaceTexture, VECameraWrapper.this.mFrameListener.mTexId) : new TECameraProviderManager.ProviderSettings(tEFrameSizei, (TECameraProvider.CaptureListener) vECameraWrapper.mFrameListener, false, new SurfaceTexture(0), TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_NV21));
                VECameraWrapper.this.mLogger.Log((byte) 8, "", "addCameraProvider rst =" + String.valueOf(iAddCameraProvider));
                VECameraWrapper.this.mCamera.start();
                VECameraWrapper.this.mCamState.set(2);
            }
        }

        @Override // com.ss.android.ttvecamera.TECameraCapture.CameraObserver
        public void onCaptureStopped(int i) {
            VECameraWrapper.this.mLogger.Log((byte) 8, "toSvr", "CameraObserver.onCaptureStopped");
            VECameraWrapper.this.safeNativeOnCaptureStopped();
        }

        @Override // com.ss.android.ttvecamera.TECameraCapture.CameraObserver
        public void onError(int i, String str) {
            VECameraWrapper.this.mLogger.Log((byte) 8, "toSvr", "CameraObserver.onError, err=" + Integer.toString(i) + " msg=" + str);
            VECameraWrapper.this.safeNativeOnCaptureError(i, str);
        }

        @Override // com.ss.android.ttvecamera.TECameraCapture.CameraObserver
        public void onInfo(int i, int i2, String str) {
            VECameraWrapper.this.mLogger.Log((byte) 8, "", "CameraObserver.onInfo, type=" + Integer.toString(i) + " msg=" + str);
            if (i != 1 || VECameraWrapper.this.mCamera == null) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(TECameraSettings.Features.CAMERA_SUPPORT_FPS_RANGE, null);
            VECameraWrapper.this.mCamera.queryFeatures(bundle);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(TECameraSettings.Features.CAMERA_SUPPORT_FPS_RANGE);
            if (parcelableArrayList != null) {
                VECameraWrapper.this.mLogger.Log((byte) 8, "toSvr", parcelableArrayList.toString());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class FrameListener implements TECameraProvider.CaptureListener {
        boolean mIsFirstFrame = true;
        boolean mStopped = false;
        private SurfaceTexture mSurfaceTexture = null;
        private int mTexId = -1;
        private YuvConverter mYuvConverter = null;
        EglBase mEglBase = null;
        private HandlerThread mThread = null;
        private Handler mHandler = null;
        private Matrix mTexMat = null;
        private TimestampAligner mTimestampAligner = new TimestampAligner();
        private Semaphore mFreeTexSema = null;
        private long mSendTexFrameStart = 0;
        private long frameCountReturned = 0;
        private long frameCountSent = 0;
        private final AtomicInteger mISO = new AtomicInteger(-1);
        private final int mISOPeriodMillis = TTAdConstant.STYLE_SIZE_RADIO_3_2;
        private Runnable updateISO = new Runnable() { // from class: com.ss.bytertc.media.VECameraWrapper.FrameListener.6
            @Override // java.lang.Runnable
            public void run() {
                synchronized (VECameraWrapper.this.mCameraLock) {
                    if (VECameraWrapper.this.mCamera != null) {
                        TECameraCapture tECameraCapture = VECameraWrapper.this.mCamera;
                        final AtomicInteger atomicInteger = FrameListener.this.mISO;
                        Objects.requireNonNull(atomicInteger);
                        tECameraCapture.getISO(new TECameraSettings.ISOCallback() { // from class: b96
                            @Override // com.ss.android.ttvecamera.TECameraSettings.ISOCallback
                            public final void getCurrentISO(int i) {
                                atomicInteger.set(i);
                            }
                        });
                    }
                }
                FrameListener.this.mHandler.postDelayed(this, c.j);
            }
        };

        public FrameListener() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void doCleanup() {
            YuvConverter yuvConverter = this.mYuvConverter;
            if (yuvConverter != null) {
                yuvConverter.release();
            }
            int i = this.mTexId;
            if (i > 0) {
                GLES20.glDeleteTextures(1, new int[]{i}, 0);
            }
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
            }
            EglBase eglBase = this.mEglBase;
            if (eglBase != null) {
                eglBase.release();
            }
            this.mYuvConverter = null;
            this.mTexId = 0;
            this.mSurfaceTexture = null;
            this.mEglBase = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void returnRawFrame() {
            this.frameCountReturned++;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void returnTextureFrame() {
            this.frameCountReturned++;
            this.mFreeTexSema.release();
        }

        private void sendRawFrame(TECameraFrame tECameraFrame) {
            VideoFrame videoFrame = new VideoFrame((VideoFrame.Buffer) new NV21Buffer(tECameraFrame.getBufferData(), tECameraFrame.getSize().width, tECameraFrame.getSize().height, new Runnable() { // from class: com.ss.bytertc.media.VECameraWrapper.FrameListener.1
                @Override // java.lang.Runnable
                public void run() {
                    FrameListener.this.returnRawFrame();
                }
            }), VECameraWrapper.this.getFrameOrientation(), System.nanoTime(), false);
            videoFrame.setIso(this.mISO.get());
            VECameraWrapper.this.safeNativeOnFrameCaptured(videoFrame);
            this.frameCountSent++;
            videoFrame.release();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: sendTexFrame, reason: merged with bridge method [inline-methods] */
        public void lambda$sendTexFrame$0(final TECameraFrame tECameraFrame) {
            boolean zTryAcquire;
            if (this.mStopped) {
                return;
            }
            if (this.mSendTexFrameStart != 0 && SystemClock.elapsedRealtime() - this.mSendTexFrameStart > 2000) {
                VECameraWrapper.this.mLogger.Log((byte) 8, "toSvr", "block by other node");
            }
            if (this.mSendTexFrameStart == 0) {
                this.mSendTexFrameStart = SystemClock.elapsedRealtime();
            }
            try {
                zTryAcquire = this.mFreeTexSema.tryAcquire(1, 2000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                VECameraWrapper.this.mLogger.Log((byte) 8, "toSvr", "semaphore interrupted");
                e.printStackTrace();
                zTryAcquire = false;
            }
            if (!zTryAcquire) {
                this.mHandler.post(new Runnable() { // from class: com.ss.bytertc.media.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f10644a.lambda$sendTexFrame$0(tECameraFrame);
                    }
                });
                return;
            }
            this.mSendTexFrameStart = 0L;
            synchronized (EglBase.lock) {
                try {
                    this.mSurfaceTexture.updateTexImage();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    VECameraWrapper.this.mLogger.Log((byte) 8, "", "updateTexImage failed(could be caused by fd leak)");
                }
            }
            Matrix matrix = new Matrix();
            matrix.setValues(new float[]{1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f});
            VideoFrame videoFrame = new VideoFrame(new TextureBufferImpl(tECameraFrame.getSize().width, tECameraFrame.getSize().height, VideoFrame.TextureBuffer.Type.OES, tECameraFrame.getTextureID(), matrix, this.mHandler, this.mYuvConverter, new Runnable() { // from class: com.ss.bytertc.media.VECameraWrapper.FrameListener.2
                @Override // java.lang.Runnable
                public void run() {
                    FrameListener.this.returnTextureFrame();
                }
            }), VECameraWrapper.this.getFrameOrientation(), this.mTimestampAligner.translateTimestamp(this.mSurfaceTexture.getTimestamp()));
            videoFrame.setIso(this.mISO.get());
            VECameraWrapper.this.safeNativeOnFrameCaptured(videoFrame);
            this.frameCountSent++;
            videoFrame.release();
        }

        @Override // com.ss.android.ttvecamera.provider.TECameraProvider.CaptureListener
        public void onFrameCaptured(final TECameraFrame tECameraFrame) {
            VECameraWrapper.this.mActWidth = tECameraFrame.getSize().width;
            VECameraWrapper.this.mActHeight = tECameraFrame.getSize().height;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Math.abs(jCurrentTimeMillis - VECameraWrapper.this.mLastDeviceOrientationTS) > 500) {
                VECameraWrapper.this.mLastDeviceOrientationTS = jCurrentTimeMillis;
                VECameraWrapper vECameraWrapper = VECameraWrapper.this;
                vECameraWrapper.mLastDeviceOrientation = vECameraWrapper.getDeviceOrientation();
                VECameraWrapper vECameraWrapper2 = VECameraWrapper.this;
                vECameraWrapper2.mLastUIOrientation = vECameraWrapper2.updateUIOrientation();
            }
            if (this.mIsFirstFrame) {
                VECameraWrapper.this.safeNativeOnCaptureStarted();
                this.mIsFirstFrame = false;
            }
            if (VECameraWrapper.this.mParam.useTexture) {
                this.mHandler.post(new Runnable() { // from class: com.ss.bytertc.media.VECameraWrapper.FrameListener.3
                    @Override // java.lang.Runnable
                    public void run() {
                        FrameListener.this.lambda$sendTexFrame$0(tECameraFrame);
                    }
                });
            } else {
                sendRawFrame(tECameraFrame);
            }
        }

        @Override // com.ss.android.ttvecamera.provider.TECameraProvider.CaptureListener
        public void onNewSurfaceTexture(SurfaceTexture surfaceTexture) {
            VECameraWrapper.this.mLogger.Log((byte) 8, "", "IFrameListener.onNewSurfaceTexture");
        }

        public void shutdown() {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.mHandler.removeCallbacks(this.updateISO);
            this.mHandler.post(new Runnable() { // from class: com.ss.bytertc.media.VECameraWrapper.FrameListener.5
                @Override // java.lang.Runnable
                public void run() {
                    FrameListener frameListener = FrameListener.this;
                    if (VECameraWrapper.this.mParam.useTexture) {
                        if (frameListener.mFreeTexSema.availablePermits() == 0) {
                            try {
                                FrameListener.this.mFreeTexSema.acquire();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        FrameListener.this.doCleanup();
                    }
                    countDownLatch.countDown();
                    FrameListener.this.mStopped = true;
                }
            });
            try {
                countDownLatch.await();
                this.mHandler.getLooper().quit();
                this.mThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void startup() {
            HandlerThread handlerThread = new HandlerThread("vecam_handler");
            this.mThread = handlerThread;
            handlerThread.start();
            this.mHandler = new Handler(this.mThread.getLooper());
            this.mFreeTexSema = new Semaphore(1);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.mHandler.post(new Runnable() { // from class: com.ss.bytertc.media.VECameraWrapper.FrameListener.4
                @Override // java.lang.Runnable
                public void run() {
                    FrameListener frameListener = FrameListener.this;
                    VECameraWrapper vECameraWrapper = VECameraWrapper.this;
                    if (vECameraWrapper.mParam.useTexture) {
                        try {
                            frameListener.mEglBase = com.bytedance.realx.video.a.c(vECameraWrapper.mSharedCtx, EglBase.CONFIG_PIXEL_BUFFER);
                            FrameListener.this.mEglBase.createDummyPbufferSurface();
                            FrameListener.this.mEglBase.makeCurrent();
                            FrameListener.this.mTexId = GlUtil.generateTexture(36197);
                            FrameListener.this.mSurfaceTexture = new SurfaceTexture(FrameListener.this.mTexId);
                            FrameListener.this.mYuvConverter = new YuvConverter();
                        } catch (RuntimeException unused) {
                            FrameListener.this.doCleanup();
                            VECameraWrapper.this.mParam.useTexture = false;
                        }
                    }
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.mHandler.postDelayed(this.updateISO, c.j);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class LogCallback implements TELogUtils.ILog {
        public LogCallback() {
        }

        @Override // com.ss.android.ttvecamera.TELogUtils.ILog
        public void Log(byte b, String str, String str2) {
            byte[] bArr = {1, 2, 4, 8, 16};
            int i = 0;
            int[] iArr = {4, 3, 2, 1, 0};
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    break;
                }
                if (b == bArr[i2]) {
                    i = iArr[i2];
                    break;
                }
                i2++;
            }
            VECameraWrapper.this.safeNativeOnCaptureLog(i, "VECAM-" + str2, str.endsWith("toSvr"));
        }
    }

    @CalledByNative
    public VECameraWrapper(long j, EglBase.Context context) {
        this.mNativeObj = 0L;
        this.mSharedCtx = null;
        this.mNativeObj = j;
        this.mSharedCtx = context;
    }

    private static boolean DeviceSupportCamera2() {
        if (Build.MANUFACTURER == null) {
            return true;
        }
        return !r0.equals("CVTE");
    }

    private int focusAtPointImpl(float f, float f2, boolean z, boolean z2) {
        int i;
        int i2;
        if (this.mCamState.get() != 2 || (i = this.mActWidth) == 0 || (i2 = this.mActHeight) == 0) {
            return -1;
        }
        TEFocusSettings tEFocusSettings = new TEFocusSettings(i, i2, (int) (i * f), (int) (i2 * f2), 1.0f);
        tEFocusSettings.setCoordinatesMode(TEFocusSettings.CoordinatesMode.ORIGINAL_FRAME);
        tEFocusSettings.setNeedFocus(z);
        tEFocusSettings.setNeedMetering(z2);
        this.mCamera.focusAtPoint(tEFocusSettings);
        return 0;
    }

    @SuppressLint({"DefaultLocale"})
    private String formatParams() {
        return String.format("[w:%d h:%d fr:%d pos:%d tex:%b cam2:%b faceae:%b wideangle:%b antishake:%b vp_dyfps:%b minfps:%d]", Integer.valueOf(this.mParam.width), Integer.valueOf(this.mParam.height), Integer.valueOf(this.mParam.fps), Integer.valueOf(this.mParam.pos), Boolean.valueOf(this.mParam.useTexture), Boolean.valueOf(this.mParam.camera2), Boolean.valueOf(this.mParam.faceAE), Boolean.valueOf(this.mParam.wideAngle), Boolean.valueOf(this.mParam.antiShake), Boolean.valueOf(this.mParam.enable_dynamic_fps), Integer.valueOf(this.mParam.min_dynamic_fps));
    }

    @CalledByNative
    public static CamDevInfo[] getCameraList() {
        if (DeviceSupportCamera2()) {
            return getCameraListByCamera2();
        }
        int numberOfCameras = Camera.getNumberOfCameras();
        CamDevInfo[] camDevInfoArr = new CamDevInfo[numberOfCameras];
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            try {
                Camera.getCameraInfo(i, cameraInfo);
                String str = d.u;
                int i2 = 1;
                if (cameraInfo.facing == 1) {
                    str = "front";
                    i2 = 0;
                }
                String str2 = "Camera " + i + ", Facing " + str + ", Orientation " + cameraInfo.orientation;
                camDevInfoArr[i] = new CamDevInfo(Integer.toString(i), str2, i2);
                RXLogging.w("CameInfo", " camera name: " + str2 + ", camera id: " + i);
            } catch (Exception e) {
                RXLogging.e("CameInfo", "exception: " + e.toString());
                return null;
            }
        }
        return camDevInfoArr;
    }

    private static CamDevInfo[] getCameraListByCamera2() {
        int iIntValue;
        CameraManager cameraManager = (CameraManager) ContextUtils.getApplicationContext().getSystemService("camera");
        CamDevInfo[] camDevInfoArr = null;
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            camDevInfoArr = new CamDevInfo[cameraIdList.length];
            for (int i = 0; i < cameraIdList.length; i++) {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(cameraIdList[i]);
                Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
                if (num == null) {
                    RXLogging.e("CameInfo", "facing is null");
                } else {
                    if (num2 != null) {
                        iIntValue = num2.intValue();
                    } else {
                        RXLogging.e("CameInfo", "orientation is null");
                        iIntValue = 0;
                    }
                    int iIntValue2 = num.intValue();
                    String str = "Camera " + i + ", Facing " + iIntValue2 + ", Orientation " + iIntValue;
                    camDevInfoArr[i] = new CamDevInfo(cameraIdList[i], str, iIntValue2);
                    RXLogging.w("CameInfo", " camera name: " + str + ", camera id: " + cameraIdList[i] + ",Facing: " + num);
                }
            }
        } catch (Exception e) {
            RXLogging.e("CameInfo", "exception: " + e.toString());
        }
        return camDevInfoArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFrameOrientation() {
        int i = this.mLastDeviceOrientation;
        if (this.mUseGravitySensor) {
            i = this.mGravityOrientation.get();
        }
        Camera.CameraInfo cameraInfo = this.mCamInfo;
        if (cameraInfo.facing == 1) {
            i = 360 - i;
        }
        return (cameraInfo.orientation + i) % 360;
    }

    public static boolean isMTKandAndroid12() {
        return Build.HARDWARE.toLowerCase().matches("mt[0-9]*") && Build.VERSION.SDK_INT == 31;
    }

    public static native void nativeOnCaptureError(long j, int i, String str);

    public static native void nativeOnCaptureFormatSelected(long j, int i, int i2, int i3, int i4, int i5);

    public static native void nativeOnCaptureLog(long j, int i, String str, boolean z);

    public static native void nativeOnCaptureStarted(long j);

    public static native void nativeOnCaptureStopped(long j);

    public static native void nativeOnFrameCaptured(long j, VideoFrame videoFrame);

    private ZoomCallback queryZoomAbility() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ZoomCallback zoomCallback = new ZoomCallback(countDownLatch);
        this.mCamera.queryZoomAbility(zoomCallback, false);
        try {
            countDownLatch.await(2000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return zoomCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void safeNativeOnCaptureError(int i, String str) {
        synchronized (this) {
            long j = this.mNativeObj;
            if (j != 0) {
                nativeOnCaptureError(j, i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void safeNativeOnCaptureFormatSelected(int i, int i2, int i3, int i4, int i5) {
        synchronized (this) {
            long j = this.mNativeObj;
            if (j != 0) {
                nativeOnCaptureFormatSelected(j, i, i2, i3, i4, i5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void safeNativeOnCaptureLog(int i, String str, boolean z) {
        synchronized (this) {
            long j = this.mNativeObj;
            if (j != 0) {
                nativeOnCaptureLog(j, i, str, z);
            } else {
                Log.d("VECAM", str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void safeNativeOnCaptureStarted() {
        synchronized (this) {
            long j = this.mNativeObj;
            if (j != 0) {
                nativeOnCaptureStarted(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void safeNativeOnCaptureStopped() {
        synchronized (this) {
            long j = this.mNativeObj;
            if (j != 0) {
                nativeOnCaptureStopped(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void safeNativeOnFrameCaptured(VideoFrame videoFrame) {
        synchronized (this) {
            long j = this.mNativeObj;
            if (j != 0) {
                nativeOnFrameCaptured(j, videoFrame);
            }
        }
    }

    private void updateCameraCharacteristics() {
        int iCamera1FaceingToCamera2 = camera1FaceingToCamera2(this.mParam.pos);
        CameraManager cameraManager = (CameraManager) this.mContext.getSystemService("camera");
        try {
            for (String str : cameraManager.getCameraIdList()) {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                if (((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == iCamera1FaceingToCamera2) {
                    int iIntValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE)).intValue();
                    int iIntValue2 = ((Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue();
                    this.mIsExposurePointSupported = iIntValue > 0;
                    this.mIsFocusPointSupported = iIntValue2 > 0;
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int camera1FaceingToCamera2(int i) {
        return i == 0 ? 1 : 0;
    }

    @CalledByNative
    public int enableCameraTorch(boolean z) {
        if (this.mCamState.get() != 2) {
            return 0;
        }
        this.mCamera.toggleTorch(z);
        return 0;
    }

    @CalledByNative
    public int enableGravitySensor(boolean z) {
        Sensor defaultSensor;
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        if (sensorManager == null || (defaultSensor = sensorManager.getDefaultSensor(9)) == null) {
            return -1;
        }
        if (z) {
            sensorManager.registerListener(this.mSensorListener, defaultSensor, 2);
            this.mUseGravitySensor = true;
        } else {
            sensorManager.unregisterListener(this.mSensorListener);
            this.mUseGravitySensor = false;
        }
        return 0;
    }

    @CalledByNative
    public int getCameraSensorOrientation() {
        return 0;
    }

    @CalledByNative
    public int getCameraSensorOrientations(boolean z) {
        int i = z ? 270 : 90;
        Camera.CameraInfo[] cameraInfoArr = this.mCamInfoList;
        if (cameraInfoArr == null) {
            return i;
        }
        for (Camera.CameraInfo cameraInfo : cameraInfoArr) {
            int i2 = cameraInfo.facing;
            if ((i2 == 1 && z) || (i2 == 0 && !z)) {
                return cameraInfo.orientation;
            }
        }
        return i;
    }

    @CalledByNative
    public float getCameraZoomMaxRatio() {
        if (this.mCamState.get() != 2) {
            return 1.0f;
        }
        return queryZoomAbility().mMaxZoom;
    }

    @CalledByNative
    public int getDeviceOrientation() {
        return this.mUseGravitySensor ? this.mGravityOrientation.get() : getUIOrientation();
    }

    @CalledByNative
    public int getUIOrientation() {
        return this.mLastUIOrientation;
    }

    @CalledByNative
    public boolean isCameraExposurePointSupported() {
        if (this.mCamState.get() != 2) {
            return false;
        }
        return this.mIsExposurePointSupported;
    }

    @CalledByNative
    public boolean isCameraFocusPointSupported() {
        if (this.mCamState.get() != 2) {
            return false;
        }
        return this.mIsFocusPointSupported;
    }

    @CalledByNative
    public boolean isCameraTorchSupported() {
        if (this.mCamState.get() != 2) {
            return false;
        }
        return this.mCamera.isTorchSupported();
    }

    @CalledByNative
    public boolean isCameraZoomSupported() {
        if (this.mCamState.get() != 2) {
            return false;
        }
        return queryZoomAbility().mSupportZoom;
    }

    @CalledByNative
    public int setCameraZoomRatio(float f) {
        if (this.mCamState.get() != 2) {
            return -1;
        }
        this.mCamera.startZoom(f, new ZoomCallback(null));
        return 0;
    }

    @CalledByNative
    public int setExposureCompensation(float f) {
        if (f < -1.0f || f > 1.0f || this.mCamState.get() != 2 || !this.mCamera.isSupportedExposureCompensation()) {
            return -1;
        }
        TECameraSettings.ExposureCompensationInfo cameraECInfo = this.mCamera.getCameraECInfo();
        int iCeil = f < 0.0f ? (int) Math.ceil(-Math.abs(cameraECInfo.min * f)) : 0;
        if (f > 0.0f) {
            iCeil = (int) Math.floor(Math.abs(f * cameraECInfo.max));
        }
        this.mCamera.setExposureCompensation(iCeil);
        return 0;
    }

    @CalledByNative
    public int setExposurePoint(float f, float f2) {
        if (this.mCamState.get() == 2 && this.mIsExposurePointSupported) {
            return focusAtPointImpl(f, f2, false, true);
        }
        return -1;
    }

    @CalledByNative
    public int setFocusPoint(float f, float f2) {
        if (this.mCamState.get() == 2 && this.mIsFocusPointSupported) {
            return focusAtPointImpl(f, f2, true, true);
        }
        return -1;
    }

    @CalledByNative
    public void startCapture(CamParam camParam) {
        if (isMTKandAndroid12()) {
            camParam.useTexture = false;
        }
        if (this.mCamState.get() != 0) {
            return;
        }
        this.mCamState.set(1);
        this.mParam = camParam;
        Context applicationContext = ContextUtils.getApplicationContext();
        this.mContext = applicationContext;
        if (ContextCompat.checkSelfPermission(applicationContext, "android.permission.CAMERA") != 0) {
            safeNativeOnCaptureError(TECameraResult.TER_CAMERA_DISABLED, "camera disabled");
            return;
        }
        this.mLogger.Log((byte) 8, "toSvr", "startCapture - input params " + formatParams());
        this.mCamInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        this.mCamInfoList = new Camera.CameraInfo[numberOfCameras];
        for (int i = 0; i < numberOfCameras; i++) {
            try {
                this.mCamInfoList[i] = new Camera.CameraInfo();
                Camera.getCameraInfo(i, this.mCamInfoList[i]);
                Camera.CameraInfo cameraInfo = this.mCamInfoList[i];
                if (cameraInfo.facing == this.mParam.pos) {
                    this.mCamInfo = cameraInfo;
                }
            } catch (Exception e) {
                Log.d("VECAM", e.toString());
            }
        }
        updateCameraCharacteristics();
        this.mFrameListener = new FrameListener();
        this.mEventObserver = new EventObserver();
        this.mFrameListener.startup();
        CamParam camParam2 = this.mParam;
        if (!camParam2.useTexture) {
            camParam2.camera2 = false;
        }
        this.mLogger.Log((byte) 8, "toSvr", "startCapture - actual params " + formatParams());
        int i2 = this.mParam.camera2 ? 2 : 1;
        Context context = this.mContext;
        CamParam camParam3 = this.mParam;
        TECameraSettings tECameraSettings = new TECameraSettings(context, i2, camParam3.width, camParam3.height);
        this.mVESettings = tECameraSettings;
        CamParam camParam4 = this.mParam;
        tECameraSettings.mFacing = camParam4.pos;
        tECameraSettings.mRetryCnt = 30;
        tECameraSettings.mPreferOpenCameraByCameraId = true;
        int i3 = camParam4.min_dynamic_fps;
        if (i3 <= 0) {
            i3 = 7;
        }
        int iMin = camParam4.enable_dynamic_fps ? Math.min(i3, camParam4.fps) : camParam4.fps;
        TECameraSettings tECameraSettings2 = this.mVESettings;
        tECameraSettings2.mStrCustomizedCameraID = this.mParam.camid;
        tECameraSettings2.mFPSRange = new TEFrameRateRange(iMin, this.mParam.fps);
        this.mLogger.Log((byte) 8, "toSvr", "enable_dynamic_fps:" + this.mParam.enable_dynamic_fps + " fpsRange min:" + iMin + " max:" + this.mParam.fps);
        TECameraSettings tECameraSettings3 = this.mVESettings;
        tECameraSettings3.mEnableManualReleaseCaptureResult = false;
        if (this.mParam.faceAE) {
            tECameraSettings3.mExtParameters.putInt("useCameraFaceDetect", 3);
        }
        TECameraSettings tECameraSettings4 = this.mVESettings;
        tECameraSettings4.mEnableMonitorGyroscope = true;
        tECameraSettings4.mIsCameraOpenCloseSync = true;
        this.mCamera = new TECameraCapture(this.mEventObserver, null);
        TECameraCapture.registerLogOutput(TELogUtils.DEBUG_LEVEL_V, this.mLogger);
        this.mCamera.registerPreviewListener(new TECameraCapture.PreviewSizeCallback() { // from class: com.ss.bytertc.media.VECameraWrapper.1
            @Override // com.ss.android.ttvecamera.TECameraCapture.PreviewSizeCallback
            public TEFrameSizei getPreviewSize(List<TEFrameSizei> list) {
                if (list.size() == 0) {
                    return null;
                }
                VECameraWrapper.this.mLogger.Log((byte) 8, "toSvr", "supportPreviewSizes:" + list.toString());
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < list.size(); i4++) {
                    TEFrameSizei tEFrameSizei = list.get(i4);
                    if (tEFrameSizei.width >= VECameraWrapper.this.mParam.width) {
                        arrayList.add(tEFrameSizei);
                    }
                }
                if (arrayList.size() != 0) {
                    list = arrayList;
                }
                TEFrameSizei tEFrameSizei2 = list.get(0);
                int iAbs = Math.abs(VECameraWrapper.this.mParam.width - tEFrameSizei2.width) + Math.abs(VECameraWrapper.this.mParam.height - tEFrameSizei2.height);
                for (int i5 = 1; i5 < list.size(); i5++) {
                    TEFrameSizei tEFrameSizei3 = list.get(i5);
                    int iAbs2 = Math.abs(VECameraWrapper.this.mParam.width - tEFrameSizei3.width) + Math.abs(VECameraWrapper.this.mParam.height - tEFrameSizei3.height);
                    if (iAbs2 < iAbs) {
                        tEFrameSizei2 = tEFrameSizei3;
                        iAbs = iAbs2;
                    }
                }
                VECameraWrapper vECameraWrapper = VECameraWrapper.this;
                vECameraWrapper.safeNativeOnCaptureFormatSelected(tEFrameSizei2.width, tEFrameSizei2.height, vECameraWrapper.mVESettings.mFPSRange.min, VECameraWrapper.this.mVESettings.mFPSRange.max, (VECameraWrapper.this.mParam.useTexture ? RXPixelFormat.kTextureOES : RXPixelFormat.kNv21).value());
                return tEFrameSizei2;
            }
        });
        this.mCamera.connect(this.mVESettings);
        this.mLastDeviceOrientationTS = System.currentTimeMillis();
        this.mLastUIOrientation = updateUIOrientation();
        this.mLastDeviceOrientation = getDeviceOrientation();
    }

    @CalledByNative
    public void stopCapture() {
        SensorManager sensorManager;
        this.mLogger.Log((byte) 8, "toSvr", "stopCapture...");
        if (this.mUseGravitySensor && (sensorManager = (SensorManager) this.mContext.getSystemService("sensor")) != null) {
            sensorManager.unregisterListener(this.mSensorListener);
        }
        TECameraCapture tECameraCapture = this.mCamera;
        if (tECameraCapture != null) {
            tECameraCapture.stop();
            this.mCamera.disConnect();
            this.mVESettings = null;
            synchronized (this.mCameraLock) {
                this.mCamera = null;
            }
        }
        FrameListener frameListener = this.mFrameListener;
        if (frameListener != null) {
            frameListener.shutdown();
            this.mFrameListener = null;
        }
        this.mEventObserver = null;
        this.mCamState.set(0);
        this.mLogger.Log((byte) 8, "toSvr", "stopCapture done.");
        synchronized (this) {
            this.mNativeObj = 0L;
        }
    }

    public int updateUIOrientation() {
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        return rotation != 1 ? rotation != 2 ? rotation != 3 ? UIDeviceOrientation.Portrait.value() : UIDeviceOrientation.LandscapeLeft.value() : UIDeviceOrientation.PortraitUpsidedown.value() : UIDeviceOrientation.LandscapeRight.value();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class ZoomCallback implements TECameraSettings.ZoomCallback {
        CountDownLatch mSigFinish;
        public boolean mSupportZoom = false;
        public float mMaxZoom = 1.0f;

        public ZoomCallback(CountDownLatch countDownLatch) {
            this.mSigFinish = countDownLatch;
        }

        @Override // com.ss.android.ttvecamera.TECameraSettings.ZoomCallback
        public boolean enableSmooth() {
            return true;
        }

        @Override // com.ss.android.ttvecamera.TECameraSettings.ZoomCallback
        public void onZoomSupport(int i, boolean z, boolean z2, float f, List<Integer> list) {
            this.mSupportZoom = z;
            this.mMaxZoom = f;
            CountDownLatch countDownLatch = this.mSigFinish;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

        @Override // com.ss.android.ttvecamera.TECameraSettings.ZoomCallback
        public void onChange(int i, float f, boolean z) {
        }
    }
}
