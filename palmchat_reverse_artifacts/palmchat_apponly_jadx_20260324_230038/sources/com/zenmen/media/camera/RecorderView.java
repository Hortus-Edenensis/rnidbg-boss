package com.zenmen.media.camera;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.oplus.tblplayer.processor.util.EffectConstants;
import com.ss.android.ttvecamera.TECameraSettings;
import com.zenmen.media.camera.NativeWrap;
import com.zenmen.media.player.LogWrapper;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.media.AudioController;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.g13;
import defpackage.l50;
import defpackage.l84;
import defpackage.me1;
import defpackage.nl0;
import defpackage.pu1;
import defpackage.x86;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class RecorderView extends FrameLayout implements Camera.PreviewCallback {
    public static final int CAMERA_BACK = 1;
    public static final int CAMERA_FRONT = 0;
    public static final int OPEN_AUDIO_FAILT = -2;
    public static final int OPEN_CAMERA_FAILT = -1;
    public static final int OPEN_CAMERA_OK = 0;
    private static String TAG = "RecorderCameraView";
    private int channel;
    private boolean firstFrame;
    private boolean isTakePhoto;
    int mActualFramerate;
    private AudioRecordClient mAudio;
    private boolean mAutoFocus;
    int mBitrate;
    private Camera mCamera;
    private CameraHandler mCameraHandler;
    private OnCameraListener mCameraListener;
    private OnLogListener mCameraLogListener;
    private float mCameraViewTouchPosX;
    private float mCameraViewTouchPosY;
    private Context mContext;
    private CollectionControl mControl;
    private int mCurrentOrientation;
    private int mDefaultOritation;
    private int mDisaplayOritation;
    private ArrayList<Runnable> mEventQueue;
    private ImageView mFocusView;
    private int mFocusViewHeight;
    private final String mFocusViewTag;
    private int mFocusViewWidth;
    int mFramerate;
    private Handler mHandler;
    private AtomicBoolean mIsRecording;
    private boolean mIsSupportZoom;
    private NativeWrap.OnMediaNotifyLogListener mLogListener;
    private NativeWrap mNative;
    private NativeWrap.OnMediaNotifyEventListener mNotifyEventListener;
    private PictureCallback mPictureCallback;
    private boolean mPreviewRunning;
    private String mRecordVideoFilePath;
    private boolean mSetCallback;
    private boolean mSupport;
    private SurfaceTexture mSurfaceTexture;
    private GLES20View mSurfaceView;
    private long mVideoCount;
    private boolean mZoomIn;
    private boolean mZoomed;
    private int m_CameraType;
    private int prevideoHeight;
    private int prevideoWidth;
    private int sampleRate;
    private boolean saveCover;
    private boolean stopAfterTakingPicture;
    private int videoHight;
    private int videoWidth;

    /* JADX INFO: compiled from: SearchBox */
    public static class CameraHandler extends Handler {
        public static final int MSG_SET_SURFACE_TEXTURE = 0;
        private WeakReference<RecorderView> mWeakInst;

        public CameraHandler(RecorderView recorderView) {
            this.mWeakInst = new WeakReference<>(recorderView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Log.d(RecorderView.TAG, "CameraHandler [" + this + "]: what=" + i);
            RecorderView recorderView = this.mWeakInst.get();
            if (recorderView == null) {
                Log.w(RecorderView.TAG, "CameraHandler.handleMessage: activity is null");
            } else {
                if (i == 0) {
                    recorderView.handleSetSurfaceTexture((SurfaceTexture) message.obj);
                    return;
                }
                throw new RuntimeException("unknown msg " + i);
            }
        }

        public void invalidateHandler() {
            this.mWeakInst.clear();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class ChangeFacingRunnable implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                RecorderView.this.swap();
                if (RecorderView.this.mControl != null) {
                    RecorderView.this.mControl.swap();
                }
            } catch (Exception unused) {
            }
        }

        private ChangeFacingRunnable() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface PictureCallback {
        void onPictureTaken(int i, int i2);
    }

    public RecorderView(Context context, int i, int i2) {
        super(context);
        this.mSurfaceView = null;
        this.mControl = null;
        this.mNative = null;
        this.mAudio = null;
        this.mCamera = null;
        this.mPreviewRunning = false;
        this.m_CameraType = 1;
        this.mSetCallback = true;
        this.mDisaplayOritation = 90;
        this.mDefaultOritation = 0;
        this.mVideoCount = 0L;
        this.mSupport = false;
        this.mAutoFocus = false;
        this.mIsSupportZoom = false;
        this.mZoomIn = true;
        this.sampleRate = 44100;
        this.channel = 2;
        this.videoWidth = 960;
        this.videoHight = TECameraSettings.FPS_480;
        this.prevideoWidth = 1280;
        this.prevideoHeight = 720;
        this.mFramerate = 30;
        this.mActualFramerate = 30;
        this.mBitrate = 30 * ErrorCode.REASON_DS_OUT_OF_RANGE;
        this.mRecordVideoFilePath = null;
        this.mCameraListener = null;
        this.mCameraLogListener = null;
        this.mFocusViewTag = "FocusViewTag";
        this.mIsRecording = new AtomicBoolean(false);
        this.mZoomed = false;
        this.firstFrame = false;
        this.saveCover = false;
        this.stopAfterTakingPicture = true;
        this.mCurrentOrientation = 0;
        this.mEventQueue = new ArrayList<>();
        this.mNotifyEventListener = new NativeWrap.OnMediaNotifyEventListener() { // from class: com.zenmen.media.camera.RecorderView.7
            @Override // com.zenmen.media.camera.NativeWrap.OnMediaNotifyEventListener
            public void onMediaNotify(int i3, int i4, int i5) {
                Log.e(RecorderView.TAG, "aMsgId = " + i3);
                if (i3 == 20) {
                    RecorderView.this.mControl.setDisplayWXH(i4, i5);
                }
                if (i3 == 80) {
                    Log.e(RecorderView.TAG, "masque NativeWrap.ENotifyPictureTaken");
                    if (RecorderView.this.mCamera != null && RecorderView.this.stopAfterTakingPicture) {
                        try {
                            RecorderView.this.mCamera.stopPreview();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (RecorderView.this.mPictureCallback != null) {
                        RecorderView.this.mPictureCallback.onPictureTaken(i4, i5);
                        return;
                    }
                    return;
                }
                switch (i3) {
                    case 13:
                        if (RecorderView.this.mCameraListener != null) {
                            RecorderView.this.mCameraListener.onRecordFinish();
                        }
                        break;
                    case 14:
                        if (RecorderView.this.mCameraListener != null) {
                            RecorderView.this.mCameraListener.onRecordFileOpenSucess();
                        }
                        break;
                    case 15:
                        if (RecorderView.this.mCameraListener != null) {
                            RecorderView.this.mCameraListener.onRecordFileOpenFail();
                        }
                        break;
                    case 16:
                        if (RecorderView.this.mCameraListener != null) {
                            RecorderView.this.mCameraListener.onRecordStart();
                        }
                        Bitmap bitmapGetLastPicture = RecorderView.this.mControl.GetLastPicture(false);
                        Matrix matrix = new Matrix();
                        matrix.postRotate(RecorderView.this.mCurrentOrientation);
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapGetLastPicture, 0, 0, bitmapGetLastPicture.getWidth(), bitmapGetLastPicture.getHeight(), matrix, true);
                        RecorderView.this.saveAsImage(bitmapCreateBitmap, RecorderView.this.mRecordVideoFilePath + ".thumbnail");
                        break;
                }
            }
        };
        this.mLogListener = new NativeWrap.OnMediaNotifyLogListener() { // from class: com.zenmen.media.camera.RecorderView.8
            @Override // com.zenmen.media.camera.NativeWrap.OnMediaNotifyLogListener
            public void onMediaNotifyLog(int i3, Object obj, Object obj2) {
                LogWrapper.log(i3, (String) obj, (String) obj2);
            }
        };
        this.mContext = context;
        init(i, i2);
        this.mHandler = new Handler(Looper.myLooper()) { // from class: com.zenmen.media.camera.RecorderView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    Runnable runnable = null;
                    while (!RecorderView.this.mEventQueue.isEmpty()) {
                        runnable = (Runnable) RecorderView.this.mEventQueue.remove(0);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            }
        };
    }

    public static String GetSDKVersion() {
        return NativeWrap.GetSDKVersion();
    }

    private void InitCamera() throws RuntimeException {
        boolean z;
        if (this.mPreviewRunning) {
            this.mCamera.stopPreview();
        }
        Camera camera = this.mCamera;
        if (camera == null) {
            return;
        }
        int i = this.prevideoWidth;
        int i2 = this.prevideoHeight;
        List<Camera.Size> supportedPreviewSizes = camera.getParameters().getSupportedPreviewSizes();
        if (supportedPreviewSizes.size() > 1) {
            for (Camera.Size size : supportedPreviewSizes) {
                Log.e(TAG, "cw = " + size.width + "ch = " + size.height);
                if (i == size.width && i2 == size.height) {
                    z = true;
                    break;
                }
            }
            z = false;
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
        Camera.Parameters parameters = this.mCamera.getParameters();
        parameters.setPreviewSize(i, i2);
        parameters.setPreviewFormat(17);
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        int[] iArr = new int[2];
        int i3 = 65535;
        for (int i4 = 0; i4 < supportedPreviewFpsRange.size(); i4++) {
            int[] iArr2 = supportedPreviewFpsRange.get(i4);
            Log.e(TAG, "< " + i4 + " > Min = " + iArr2[0] + "  Max = " + iArr2[1]);
            int i5 = iArr2[0];
            int i6 = this.mFramerate;
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
                iArr[0] = i5;
                iArr[1] = iArr2[1];
                i3 = i9;
            }
        }
        int i10 = iArr[1] / 1000;
        this.mActualFramerate = i10;
        if (i10 > 30) {
            this.mActualFramerate = 30;
        }
        this.mFramerate = this.mActualFramerate;
        Log.e(TAG, "m_actualframerate:FrameRate range  MinPreRange[0]:" + iArr[0] + "  MinPreRange[1]:" + iArr[1]);
        this.mIsSupportZoom = parameters.isZoomSupported();
        parameters.getMaxZoom();
        parameters.getZoom();
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
        this.mCamera.setParameters(parameters);
        this.mCamera.addCallbackBuffer(new byte[((i * i2) * 3) / 2]);
        this.mCamera.setPreviewCallbackWithBuffer(this);
        this.mSetCallback = true;
        this.mCamera.startPreview();
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.mPreviewRunning = true;
        cancelAutoFocus();
    }

    private void calOritation(Camera.CameraInfo cameraInfo) {
        int rotation = ((Activity) this.mContext).getWindowManager().getDefaultDisplay().getRotation();
        this.mDefaultOritation = rotation;
        int i = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i = 90;
            } else if (rotation == 2) {
                i = EffectConstants.ROTATION_DEGREES_180;
            } else if (rotation == 3) {
                i = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            this.mDefaultOritation = (cameraInfo.orientation + i) % 360;
            this.mDefaultOritation = ((360 - this.mDisaplayOritation) & 65535) % 360;
            Log.i("TAG", "mDisaplayOritation:CAMERA_FACING_FRONT:" + this.mDisaplayOritation + " info.orientation:" + cameraInfo.orientation);
        } else {
            this.mDefaultOritation = ((cameraInfo.orientation - i) + 360) % 360;
            Log.i("TAG", "mDisaplayOritation:CAMERA_FACING_BACK:" + this.mDisaplayOritation + " info.orientation:" + cameraInfo.orientation);
        }
        if (cameraInfo.facing == 0) {
            this.mDisaplayOritation = cameraInfo.orientation | 65536;
        } else {
            this.mDisaplayOritation = cameraInfo.orientation;
        }
        Log.i("TAG", " info.orientation:" + cameraInfo.orientation);
    }

    private void cancelAutoFocus() {
        if (this.mAutoFocus) {
            try {
                this.mCamera.cancelAutoFocus();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void closeCamera() {
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                try {
                    if (this.mSetCallback) {
                        camera.setPreviewCallback(null);
                        this.mSetCallback = false;
                    }
                    this.mCamera.stopPreview();
                    this.mCamera.release();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            } finally {
                this.mPreviewRunning = false;
                this.mCamera = null;
            }
        }
    }

    private boolean createAudioRec() {
        if (this.mAudio != null) {
            freeAudioRec();
            this.mAudio = null;
        }
        AudioRecordClient audioRecordClient = new AudioRecordClient();
        this.mAudio = audioRecordClient;
        audioRecordClient.setControlObj(this.mControl);
        boolean zInit = this.mAudio.init(this.sampleRate, this.channel);
        if (!zInit) {
            return zInit;
        }
        this.mAudio.start();
        return true;
    }

    private boolean createCamera() {
        if (this.mCamera != null) {
            closeCamera();
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        if (Camera.getNumberOfCameras() == 1) {
            Camera.getCameraInfo(0, cameraInfo);
            this.m_CameraType = cameraInfo.facing == 1 ? 0 : 1;
        }
        int i = 0;
        while (true) {
            if (i >= Camera.getNumberOfCameras()) {
                break;
            }
            Camera.getCameraInfo(i, cameraInfo);
            int i2 = cameraInfo.facing;
            if (i2 == 1 && this.m_CameraType == 0) {
                try {
                    this.mCamera = Camera.open(i);
                    break;
                } catch (Exception e) {
                    AudioController.b0().Z().i(new l84());
                    e.printStackTrace();
                }
            } else if (i2 == 0 && this.m_CameraType == 1) {
                try {
                    this.mCamera = Camera.open(i);
                    break;
                } catch (Exception e2) {
                    AudioController.b0().Z().i(new l84());
                    e2.printStackTrace();
                }
            } else {
                i++;
            }
        }
        Camera camera = this.mCamera;
        if (camera == null) {
            Log.i("TAG", "could not open an camera");
            this.mSupport = false;
            AudioController.b0().Z().i(new l84());
            return false;
        }
        try {
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                camera.setPreviewTexture(surfaceTexture);
            }
        } catch (Exception unused) {
        }
        calOritation(cameraInfo);
        try {
            InitCamera();
            this.mSupport = true;
            return true;
        } catch (RuntimeException e3) {
            e3.printStackTrace();
            AudioController.b0().Z().i(new l84());
            this.mSupport = false;
            return false;
        }
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
        String strB = x86.b();
        String strC = x86.c();
        if (strB.equals("Samsung SM-N9008S") && strC.equals("5.0")) {
            closeCamera();
            openCamera();
        }
        startPreview();
    }

    private void initControl() {
        this.mControl.setAudioInfo(this.sampleRate, this.channel);
        this.mControl.setPreViewInfo(this.prevideoWidth, this.prevideoHeight, this.mDisaplayOritation);
        this.mControl.setVideoInfo(this.videoWidth, this.videoHight);
        setControlUseHardEncoder();
        this.mControl.setVideoFrameRate(this.mFramerate, this.mActualFramerate);
        this.mControl.setVideoBitRate(this.mBitrate);
        this.mControl.setNotifyEventListener(this.mNotifyEventListener);
        this.mControl.SetPicNum(20);
        this.mControl.init();
    }

    private void setControlUseHardEncoder() {
        if (x86.b().equals("Vivo V1936A")) {
            this.mControl.setUseHardEncode(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFocusAnimation(final View view) {
        view.setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(400L);
        view.startAnimation(scaleAnimation);
        view.postDelayed(new Runnable() { // from class: com.zenmen.media.camera.RecorderView.2
            @Override // java.lang.Runnable
            public void run() {
                view.setVisibility(8);
            }
        }, 800L);
    }

    private void startPreview() {
        Camera camera;
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null || (camera = this.mCamera) == null) {
            return;
        }
        try {
            camera.setPreviewTexture(surfaceTexture);
            this.mCamera.startPreview();
            this.mPreviewRunning = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        cancelAutoFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void swap() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        if (this.m_CameraType == 0) {
            for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 0) {
                    try {
                        this.mCamera = Camera.open(i);
                    } catch (Exception e) {
                        this.mCamera = null;
                        e.printStackTrace();
                    }
                    Camera camera = this.mCamera;
                    if (camera == null) {
                        this.m_CameraType = 1;
                        return;
                    }
                    try {
                        camera.setPreviewTexture(this.mSurfaceTexture);
                    } catch (Exception unused) {
                    }
                    calOritation(cameraInfo);
                    this.mCamera.setDisplayOrientation(this.mDefaultOritation & 65535);
                    this.mControl.setPreViewInfo(this.prevideoWidth, this.prevideoHeight, this.mDisaplayOritation);
                    this.mControl.setVideoFrameRate(this.mFramerate, this.mActualFramerate);
                    this.m_CameraType = 1;
                    InitCamera();
                    return;
                }
            }
            return;
        }
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == 1) {
                try {
                    this.mCamera = Camera.open(i2);
                } catch (Exception e2) {
                    this.mCamera = null;
                    e2.printStackTrace();
                }
                Camera camera2 = this.mCamera;
                if (camera2 == null) {
                    this.m_CameraType = 0;
                    return;
                }
                try {
                    camera2.setPreviewTexture(this.mSurfaceTexture);
                } catch (Exception unused2) {
                }
                calOritation(cameraInfo);
                this.mCamera.setDisplayOrientation(this.mDefaultOritation & 65535);
                this.mControl.setPreViewInfo(this.prevideoWidth, this.prevideoHeight, this.mDisaplayOritation);
                this.mControl.setVideoFrameRate(this.mFramerate, this.mActualFramerate);
                this.m_CameraType = 0;
                InitCamera();
                return;
            }
        }
    }

    public Bitmap GetPicture() {
        CollectionControl collectionControl = this.mControl;
        if (collectionControl != null) {
            return collectionControl.GetPicture();
        }
        return null;
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
        if (this.mAudio != null) {
            freeAudioRec();
            this.mAudio = null;
        }
        closeCamera();
        NativeWrap nativeWrap = this.mNative;
        if (nativeWrap != null) {
            nativeWrap.release();
            this.mNative = null;
        }
        CameraHandler cameraHandler = this.mCameraHandler;
        if (cameraHandler != null) {
            cameraHandler.invalidateHandler();
        }
    }

    public void doAutoFocus() {
        Camera.Parameters parameters = this.mCamera.getParameters();
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes == null || !supportedFocusModes.contains("continuous-picture")) {
            return;
        }
        parameters.setFocusMode("continuous-picture");
        this.mCamera.autoFocus(new Camera.AutoFocusCallback() { // from class: com.zenmen.media.camera.RecorderView.5
            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z, Camera camera) {
            }
        });
    }

    public void focusOnTouch(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        GLES20View gLES20View = this.mSurfaceView;
        if (gLES20View == null || this.mCamera == null) {
            return;
        }
        gLES20View.getLocationOnScreen(iArr);
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
        try {
            this.mCamera.cancelAutoFocus();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            this.mCamera.autoFocus(new Camera.AutoFocusCallback() { // from class: com.zenmen.media.camera.RecorderView.6
                @Override // android.hardware.Camera.AutoFocusCallback
                public void onAutoFocus(boolean z, Camera camera) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("focusOn: AutoFocus:");
                    sb.append(z ? "Succeeded" : "Failed");
                    Log.i("TAG", sb.toString());
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void freeAudioRec() {
        AudioRecordClient audioRecordClient = this.mAudio;
        if (audioRecordClient != null) {
            audioRecordClient.free();
            this.mAudio = null;
        }
    }

    public int getCameraType() {
        return this.m_CameraType;
    }

    public Bitmap getLastPicture() {
        CollectionControl collectionControl = this.mControl;
        if (collectionControl != null) {
            return collectionControl.GetLastPicture(false);
        }
        return null;
    }

    public int getNumberOfCameras() {
        return nl0.g() ? Math.min(Camera.getNumberOfCameras(), 1) : Camera.getNumberOfCameras();
    }

    public void init(int i, int i2) {
        this.videoWidth = i;
        this.videoHight = i2;
        this.mBitrate = i * i2 * 2;
        this.mFramerate = CollectionControl.initCpuInfo(this.mFramerate);
        this.mCameraHandler = new CameraHandler(this);
        this.mNative = new NativeWrap();
        CollectionControl collectionControl = new CollectionControl(this.mNative);
        this.mControl = collectionControl;
        collectionControl.setNotifyLogListener(this.mLogListener);
        this.mSurfaceView = GLES20View.CreateRenderer(getContext(), this.mCameraHandler, this.mNative);
        int width = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        addView(this.mSurfaceView, new FrameLayout.LayoutParams(width, (this.videoHight * width) / this.videoWidth, 17));
        this.mNative.GenerateGLRender(this.mSurfaceView);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.zenmen.media.camera.RecorderView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (RecorderView.this.mFocusView == null) {
                    return false;
                }
                int action = motionEvent.getAction() & 255;
                if (action == 0) {
                    RecorderView.this.mCameraViewTouchPosX = motionEvent.getX();
                    RecorderView.this.mCameraViewTouchPosY = motionEvent.getY();
                    return true;
                }
                if (action == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(RecorderView.this.mFocusView.getLayoutParams());
                    layoutParams.setMargins(((int) RecorderView.this.mCameraViewTouchPosX) - (RecorderView.this.mFocusView.getWidth() / 2), ((int) RecorderView.this.mCameraViewTouchPosY) - (RecorderView.this.mFocusView.getHeight() / 2), 0, 0);
                    if (l50.a()) {
                        Log.i(RecorderView.TAG, "setZoom double click");
                        if (RecorderView.this.m_CameraType == 0) {
                            RecorderView recorderView = RecorderView.this;
                            recorderView.setZoom(130, recorderView.mZoomed);
                        } else {
                            RecorderView recorderView2 = RecorderView.this;
                            recorderView2.setZoom(200, recorderView2.mZoomed);
                        }
                        RecorderView.this.mZoomed = !r7.mZoomed;
                    } else {
                        RecorderView.this.mFocusView.setLayoutParams(layoutParams);
                        Log.d(RecorderView.TAG, "mCameraViewTouchPosX = " + RecorderView.this.mCameraViewTouchPosX + "mCameraViewTouchPosY = " + RecorderView.this.mCameraViewTouchPosY + " mFocusView.getWidth()" + RecorderView.this.mFocusView.getWidth() + "mFocusView.getHeight() = " + RecorderView.this.mFocusView.getHeight());
                        new Rect((int) RecorderView.this.mCameraViewTouchPosX, (int) RecorderView.this.mCameraViewTouchPosY, RecorderView.this.mFocusView.getWidth() + ((int) RecorderView.this.mCameraViewTouchPosX), RecorderView.this.mFocusView.getHeight() + ((int) RecorderView.this.mCameraViewTouchPosY));
                        try {
                            RecorderView.this.focusOnTouch(motionEvent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        RecorderView recorderView3 = RecorderView.this;
                        recorderView3.startFocusAnimation(recorderView3.mFocusView);
                    }
                }
                return false;
            }
        });
    }

    public void initSmallPreviewSize() {
        this.prevideoWidth = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
        this.prevideoHeight = TECameraSettings.FPS_480;
    }

    public boolean isRecording() {
        return this.mIsRecording.get();
    }

    public void mute(boolean z) {
        CollectionControl collectionControl = this.mControl;
        if (collectionControl != null) {
            collectionControl.mute(z);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
            if (getResources().getConfiguration().orientation == 2) {
                return;
            }
            int i = getResources().getConfiguration().orientation;
        } catch (Exception unused) {
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Bitmap bitmapGetLastPicture;
        if (bArr != null) {
            camera.addCallbackBuffer(bArr);
        }
        if (this.isTakePhoto) {
            this.mControl.feedPictureData(bArr);
            this.isTakePhoto = false;
            return;
        }
        if (bArr == null) {
            Camera.Parameters parameters = camera.getParameters();
            Camera.Size previewSize = parameters.getPreviewSize();
            int bitsPerPixel = ((previewSize.width * previewSize.height) * ImageFormat.getBitsPerPixel(parameters.getPreviewFormat())) / 8;
            camera.addCallbackBuffer(new byte[bitsPerPixel + (bitsPerPixel / 20)]);
        } else {
            CollectionControl collectionControl = this.mControl;
            if (collectionControl != null) {
                collectionControl.feedVideoData(bArr);
                if (this.saveCover && this.firstFrame && isRecording() && (bitmapGetLastPicture = this.mControl.GetLastPicture(true)) != null) {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(this.mCurrentOrientation);
                    saveAsImage(Bitmap.createBitmap(bitmapGetLastPicture, 0, 0, bitmapGetLastPicture.getWidth(), bitmapGetLastPicture.getHeight(), matrix, true), this.mRecordVideoFilePath + ".cover");
                }
                this.firstFrame = false;
            }
        }
        this.mVideoCount++;
    }

    public int openCamera() {
        if (!createCamera()) {
            return -1;
        }
        boolean zCreateAudioRec = createAudioRec();
        initControl();
        startPreview();
        if (!zCreateAudioRec) {
            return -2;
        }
        if (((ImageView) findViewWithTag("FocusViewTag")) == null) {
            ImageView imageView = new ImageView(this.mContext);
            this.mFocusView = imageView;
            imageView.setTag("FocusViewTag");
            this.mFocusViewWidth = me1.b(this.mContext, 120);
            this.mFocusViewHeight = me1.b(this.mContext, 120);
            ImageView imageView2 = this.mFocusView;
            int i = this.mFocusViewWidth;
            imageView2.setPadding(i / 4, i / 4, i / 4, i / 4);
            addView(this.mFocusView);
        }
        this.mFocusView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.mFocusView.setImageResource(R.drawable.focus_icon);
        ImageView imageView3 = this.mFocusView;
        int i2 = this.mFocusViewWidth;
        imageView3.setPadding(i2 / 4, i2 / 4, i2 / 4, i2 / 4);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mFocusView.getLayoutParams();
        layoutParams.width = this.mFocusViewWidth;
        layoutParams.height = this.mFocusViewHeight;
        layoutParams.gravity = 17;
        this.mFocusView.setLayoutParams(layoutParams);
        this.mFocusView.setVisibility(4);
        return 0;
    }

    public void saveAsImage(final Bitmap bitmap, final String str) {
        LogUtil.d(TAG, "saveAsImage fileNAme = " + str);
        new g13(new Runnable() { // from class: com.zenmen.media.camera.RecorderView.4
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Type inference failed for: r1v0, types: [java.io.OutputStream] */
            /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r1v6 */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() throws Throwable {
                ?? r1;
                Throwable th;
                BufferedOutputStream bufferedOutputStream;
                FileNotFoundException e;
                try {
                    try {
                        try {
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
                            try {
                                bitmap.compress(Bitmap.CompressFormat.JPEG, 30, bufferedOutputStream);
                                bitmap.recycle();
                                bufferedOutputStream.close();
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                e.printStackTrace();
                                if (bufferedOutputStream != null) {
                                    bufferedOutputStream.close();
                                }
                                String str2 = RecorderView.TAG;
                                r1 = "Saved frame as '" + str;
                                Log.d(str2, r1);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (r1 != 0) {
                                try {
                                    r1.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e4) {
                        bufferedOutputStream = null;
                        e = e4;
                    } catch (Throwable th3) {
                        r1 = 0;
                        th = th3;
                        if (r1 != 0) {
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                String str22 = RecorderView.TAG;
                r1 = "Saved frame as '" + str;
                Log.d(str22, r1);
            }
        }).start();
    }

    public void setOnCameraChangeListener(OnCameraListener onCameraListener) {
        this.mCameraListener = onCameraListener;
    }

    public void setOnLogChangeListener(OnLogListener onLogListener) {
        this.mCameraLogListener = onLogListener;
    }

    public void setSaveCover(boolean z) {
        this.saveCover = z;
    }

    public void setUseHardEncode(boolean z) {
        if (this.mNative != null) {
            this.mControl.setUseHardEncode(z);
        }
    }

    public void setVideoBitrate(int i) {
        this.mBitrate = i;
    }

    public void setZoom(int i, boolean z) {
        if (this.mIsSupportZoom) {
            try {
                Camera.Parameters parameters = this.mCamera.getParameters();
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

    public String startRecord(int i) {
        this.mIsRecording.set(true);
        this.firstFrame = true;
        pu1.t();
        File file = new File(pu1.j);
        if (!file.exists()) {
            file.mkdir();
        }
        this.isTakePhoto = false;
        String str = pu1.j + File.separator + UUID.randomUUID().toString().replace("-", "") + ".mp4";
        this.mRecordVideoFilePath = str;
        CollectionControl collectionControl = this.mControl;
        if (collectionControl == null) {
            return null;
        }
        collectionControl.setSinkFilePath(str, 0);
        this.mCurrentOrientation = i;
        this.mControl.startRecord(i);
        Log.e(TAG, "mRecordVideoFilePath =" + this.mRecordVideoFilePath);
        return this.mRecordVideoFilePath;
    }

    public void stopCamera() {
        if (this.mAudio != null) {
            freeAudioRec();
            this.mAudio = null;
        }
        closeCamera();
        this.isTakePhoto = false;
    }

    public void stopPreview() {
        if (this.mAudio != null) {
            freeAudioRec();
            this.mAudio = null;
        }
        closeCamera();
    }

    public void stopRecord() {
        CollectionControl collectionControl = this.mControl;
        if (collectionControl != null) {
            collectionControl.stopRecord();
        }
        this.mIsRecording.set(false);
    }

    public void switchCamera() {
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.setPreviewCallback(null);
            this.mCamera.stopPreview();
            this.mCamera.release();
            this.mCamera = null;
        }
        this.mEventQueue.add(new ChangeFacingRunnable());
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        this.mHandler.sendMessageDelayed(messageObtain, 30L);
    }

    public void takePicture(boolean z, PictureCallback pictureCallback) {
        this.stopAfterTakingPicture = z;
        this.isTakePhoto = true;
        this.mPictureCallback = pictureCallback;
    }

    public String startRecord(String str, int i) {
        this.mIsRecording.set(true);
        this.firstFrame = true;
        this.isTakePhoto = false;
        this.mRecordVideoFilePath = str;
        CollectionControl collectionControl = this.mControl;
        if (collectionControl == null) {
            return null;
        }
        collectionControl.setSinkFilePath(str, 0);
        this.mCurrentOrientation = i;
        this.mControl.startRecord(i);
        Log.e(TAG, "mRecordVideoFilePath =" + this.mRecordVideoFilePath);
        return this.mRecordVideoFilePath;
    }
}
