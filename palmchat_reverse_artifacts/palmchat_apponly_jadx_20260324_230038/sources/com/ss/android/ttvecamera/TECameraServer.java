package com.ss.android.ttvecamera;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.bytedance.bpea.basics.Cert;
import com.igexin.push.config.c;
import com.ss.android.ttvecamera.TECameraBase;
import com.ss.android.ttvecamera.TECameraCapture;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.cameraalgorithm.TECameraAlgorithmParam;
import com.ss.android.ttvecamera.model.BurstRequest;
import com.ss.android.ttvecamera.provider.TECameraProviderManager;
import com.ss.android.ttvecamera.systemresmanager.TESystemResManager;
import com.ss.android.ttvecamera.systemresmanager.TEVBoostStrategy;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum TECameraServer {
    INSTANCE;

    private static final String TAG = "TECameraServer";

    @GuardedBy("mLock")
    private TECameraCapture mCameraClient;
    private volatile TECameraBase mCameraInstance;
    private TECameraSettings mCameraSettings;
    private Runnable mCheckCloseTask;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private volatile boolean mIsCameraPendingClose;
    private volatile boolean mIsCameraProviderChanged;
    private volatile boolean mIsInitialized;
    private TECameraCapture.PictureSizeCallBack mPictureSizeCallback;
    TECameraProviderManager mProviderManager;
    private TECameraProviderManager.ProviderSettings mProviderSettings;
    private TECameraSettings.SATZoomCallback mSATZoomCallback;
    private TESystemResManager mSystemResManager;
    private volatile boolean mHandlerDestroyed = true;
    private float mCurrentZoom = 0.0f;
    private TECameraCapture.CameraObserver mCameraObserver = new TECameraCapture.NullCameraObserver();
    private TECameraCapture.PreviewSizeCallback mPreviewSizeCallback = null;
    private TECameraCapture.CameraFpsConfigCallback mFpsConfigCallback = null;
    private final Object mStateLock = new Object();

    @GuardedBy("mStateLock")
    private volatile int mCurrentCameraState = 0;
    private final Object mLock = new Object();

    @GuardedBy("this")
    private volatile int sClientCount = 0;
    private long mOpenTime = 0;
    private long mBeginTime = 0;
    private int mRetryCnt = -1;
    private boolean mStartPreviewError = false;
    private final ConditionVariable mCameraClientCondition = new ConditionVariable();
    private final ConcurrentHashMap<String, String> mOpenInfoMap = new ConcurrentHashMap<>();
    private Handler mMainHandler = new Handler(Looper.getMainLooper());
    private Cert cachedOpenPrivacyCert = null;
    private Cert cachedClosePrivacyCert = null;
    private boolean mOnBackGround = false;
    private boolean mFirstEC = true;
    private boolean mFirstZoom = true;
    private boolean mEnableVBoost = false;
    private int mVBoostTimeoutMS = 0;
    private boolean mIsForegroundVisible = false;
    private int mCameraCloseTaskHandlerId = -1;
    private volatile boolean mIsCameraSwitchState = false;
    private TECameraBase.CameraEvents mCameraEvent = new TECameraBase.CameraEvents() { // from class: com.ss.android.ttvecamera.TECameraServer.46
        @Override // com.ss.android.ttvecamera.TECameraBase.CameraEvents
        public void onCameraClosed(int i, TECameraBase tECameraBase, Object obj) {
            TELogUtils.i(TECameraServer.TAG, "onCameraClosed, CameraState = " + TECameraServer.this.mCurrentCameraState);
            if (tECameraBase == TECameraServer.this.mCameraInstance) {
                synchronized (TECameraServer.this.mStateLock) {
                    TECameraServer.this.updateCameraState(0);
                }
                TECameraServer.this.mCameraObserver.onCaptureStopped(0);
            }
        }

        @Override // com.ss.android.ttvecamera.TECameraBase.CameraEvents
        public void onCameraError(int i, int i2, String str, Object obj) {
            TELogUtils.e(TECameraServer.TAG, "onCameraError: code = " + i2 + ", msg = " + str);
            TECameraServer.this.mCameraObserver.onError(i2, "Open camera failed @" + TECameraServer.this.mCameraSettings.mCameraType + ",face:" + TECameraServer.this.mCameraSettings.mFacing + " " + TECameraServer.this.mCameraSettings.mPreviewSize.toString() + " " + str);
        }

        @Override // com.ss.android.ttvecamera.TECameraBase.CameraEvents
        public void onCameraInfo(int i, int i2, String str, Object obj) {
            TELogUtils.d(TECameraServer.TAG, "onCameraInfo: " + i + ", ext: " + i2 + " msg: " + str);
            if (i == 108) {
                TECameraServer.this.updateCameraState(4);
            } else if (i == 109) {
                TECameraServer.this.updateCameraState(0);
            }
            TECameraServer.this.mCameraObserver.onInfo(i, i2, str);
        }

        @Override // com.ss.android.ttvecamera.TECameraBase.CameraEvents
        public void onCameraOpened(int i, int i2, TECameraBase tECameraBase, Object obj) {
            TETraceUtils.beginSection("TECameraServer-onCameraOpened: cameraType " + i + ", ret " + i2);
            TECameraServer.this.mOpenTime = System.currentTimeMillis() - TECameraServer.this.mBeginTime;
            TELogUtils.i(TECameraServer.TAG, "onCameraOpened: CameraType = " + TECameraServer.this.mCameraSettings.mCameraType + ", Ret = " + i2 + ",retryCnt = " + TECameraServer.this.mRetryCnt);
            ConcurrentHashMap concurrentHashMap = TECameraServer.this.mOpenInfoMap;
            StringBuilder sb = new StringBuilder();
            sb.append("CamType");
            sb.append(TECameraServer.this.mRetryCnt);
            concurrentHashMap.put(sb.toString(), String.valueOf(TECameraServer.this.mCameraSettings.mCameraType));
            TECameraServer.this.mOpenInfoMap.put("Ret" + TECameraServer.this.mRetryCnt, String.valueOf(i2));
            TECameraServer.this.mOpenInfoMap.put("OpenTime" + TECameraServer.this.mRetryCnt, String.valueOf(TECameraServer.this.mOpenTime));
            if (i2 == 0) {
                TECameraServer tECameraServer = TECameraServer.this;
                tECameraServer.mRetryCnt = tECameraServer.mCameraSettings.mRetryCnt;
                synchronized (TECameraServer.this.mStateLock) {
                    if (TECameraServer.this.mCurrentCameraState != 1) {
                        TELogUtils.w(TECameraServer.TAG, "Open camera error ? May be closed now!!, state = " + TECameraServer.this.mCurrentCameraState);
                        return;
                    }
                    TECameraServer.this.updateCameraState(2);
                    TECameraServer.this.mCameraObserver.onCaptureStarted(i, i2);
                    int i3 = TECameraServer.this.mCameraSettings.mRetryCnt - TECameraServer.this.mRetryCnt;
                    TECameraServer.this.mCameraObserver.onInfo(120, i3, "Retry open camera times = " + i3);
                    TECameraServer.this.mOpenInfoMap.put("ResultType", "Open Success");
                    TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_OPEN_RET, (long) i2);
                    TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_OPEN_COST, TECameraServer.this.mOpenTime);
                    TECameraMonitor.perfString(TECameraMonitor.TE_RECORD_CAMERA_OPEN_INFO, TECameraServer.this.mOpenInfoMap.toString());
                    TELogUtils.i("VESDKCOST", "TE_RECORD_CAMERA_OPEN_COST " + TECameraServer.this.mOpenTime);
                    TECameraServer.this.mOpenInfoMap.clear();
                }
            } else if (TECameraServer.this.mCameraSettings.mCameraType == 11 && i2 == -428) {
                TELogUtils.i(TECameraServer.TAG, "CameraUnit auth failed, fall back to camera2");
                TECameraServer tECameraServer2 = TECameraServer.this;
                tECameraServer2.mRetryCnt = tECameraServer2.mCameraSettings.mRetryCnt;
                synchronized (TECameraServer.this.mStateLock) {
                    if (TECameraServer.this.mCurrentCameraState == 0) {
                        TELogUtils.w(TECameraServer.TAG, "onCameraOpened, no need to close camera, state: " + TECameraServer.this.mCurrentCameraState);
                        TECameraServer.this.mCameraInstance = null;
                    } else {
                        TECameraServer.this.updateCameraState(4);
                        if (TECameraServer.this.mCameraInstance != null) {
                            TECameraServer.this.mCameraInstance.close(TECameraServer.this.cachedOpenPrivacyCert);
                            TECameraServer.this.mCameraInstance = null;
                        }
                        TECameraServer.this.updateCameraState(0);
                    }
                }
                TECameraServer.this.mCameraSettings.mCameraType = 2;
                TECameraServer.INSTANCE.open(TECameraServer.this.mCameraClient, TECameraServer.this.mCameraSettings, TECameraServer.this.cachedOpenPrivacyCert);
                TECameraServer.this.mOpenInfoMap.put("ResultType", "fallback to Camera2");
                TECameraMonitor.perfString(TECameraMonitor.TE_RECORD_CAMERA_OPEN_INFO, TECameraServer.this.mOpenInfoMap.toString());
                TECameraServer.this.mOpenInfoMap.clear();
            } else if (i2 != -403 && i2 != -408 && TECameraServer.this.mRetryCnt > 0 && TECameraServer.this.isCameraPermitted()) {
                TECameraServer.this.mCameraObserver.onError(TECameraResult.TER_CAMERA_TRY_OPEN_FAILED, "Retry to Open Camera Failed @" + TECameraServer.this.mCameraSettings.mCameraType + ",face:" + TECameraServer.this.mCameraSettings.mFacing + " " + TECameraServer.this.mCameraSettings.mPreviewSize.toString());
                if (TECameraServer.this.mIsCameraPendingClose) {
                    TECameraServer.this.mIsCameraPendingClose = false;
                    TELogUtils.e(TECameraServer.TAG, "retry to open camera, but camera close was called");
                    TECameraServer.this.mRetryCnt = -1;
                    TECameraServer.this.mOpenInfoMap.put("ResultType" + TECameraServer.this.mRetryCnt, "retry to open camera");
                    TECameraMonitor.perfString(TECameraMonitor.TE_RECORD_CAMERA_OPEN_INFO, TECameraServer.this.mOpenInfoMap.toString());
                    return;
                }
                if (TECameraServer.this.mCameraSettings.mContext == null) {
                    TECameraServer.this.mRetryCnt = -1;
                    TELogUtils.e(TECameraServer.TAG, "abort retry to open camera, no context: " + TECameraServer.this.mCameraSettings);
                    return;
                }
                if (i == 2 && TECameraServer.this.mRetryCnt == TECameraServer.this.mCameraSettings.mRetryCnt && (i2 == 4 || i2 == 5 || i2 == 1)) {
                    TELogUtils.i(TECameraServer.TAG, "camera2 is not available");
                    TECameraServer tECameraServer3 = TECameraServer.this;
                    tECameraServer3.mRetryCnt = tECameraServer3.mCameraSettings.mCamera2RetryCnt;
                }
                try {
                    Thread.sleep(30L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                TELogUtils.i(TECameraServer.TAG, "retry to open camera, mRetryCnt = " + TECameraServer.this.mRetryCnt);
                synchronized (TECameraServer.this.mStateLock) {
                    if (TECameraServer.this.mCurrentCameraState == 0) {
                        TELogUtils.w(TECameraServer.TAG, "onCameraOpened, no need to close camera, state: " + TECameraServer.this.mCurrentCameraState);
                        TECameraServer.this.mCameraInstance = null;
                    } else {
                        TECameraServer.this.updateCameraState(4);
                        if (TECameraServer.this.mCameraInstance != null) {
                            TECameraServer.this.mCameraInstance.close(TECameraServer.this.cachedOpenPrivacyCert);
                            TECameraServer.this.mCameraInstance = null;
                        }
                        TECameraServer.this.updateCameraState(0);
                    }
                }
                TECameraServer.access$1810(TECameraServer.this);
                TECameraServer.INSTANCE.open(TECameraServer.this.mCameraClient, TECameraServer.this.mCameraSettings, TECameraServer.this.cachedOpenPrivacyCert);
                TECameraServer.this.mOpenInfoMap.put("ResultType" + TECameraServer.this.mRetryCnt, "retry to open camera");
                TECameraMonitor.perfString(TECameraMonitor.TE_RECORD_CAMERA_OPEN_INFO, TECameraServer.this.mOpenInfoMap.toString());
            } else if ((!TECameraServer.this.mCameraSettings.mEnableFallBack || i == 1 || i2 == -408) && i2 != -403) {
                TECameraServer.this.mCameraObserver.onCaptureStarted(i, i2);
                TELogUtils.i(TECameraServer.TAG, "finally go to the error.");
                TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_OPEN_RET, i2);
                TECameraServer.this.mCameraObserver.onError(i2, "Open camera failed @" + TECameraServer.this.mCameraSettings.mCameraType + ",face:" + TECameraServer.this.mCameraSettings.mFacing + " " + TECameraServer.this.mCameraSettings.mPreviewSize.toString());
                TECameraServer.INSTANCE.close(TECameraServer.this.cachedOpenPrivacyCert);
                TECameraServer.this.mRetryCnt = -1;
                TECameraMonitor.perfString(TECameraMonitor.TE_RECORD_CAMERA_OPEN_INFO, TECameraServer.this.mOpenInfoMap.toString());
                TECameraServer.this.mOpenInfoMap.clear();
            } else {
                TELogUtils.i(TECameraServer.TAG, "Open camera failed, fall back to camera1");
                TECameraServer tECameraServer4 = TECameraServer.this;
                tECameraServer4.mRetryCnt = tECameraServer4.mCameraSettings.mRetryCnt;
                synchronized (TECameraServer.this.mStateLock) {
                    if (TECameraServer.this.mCurrentCameraState == 0) {
                        TELogUtils.w(TECameraServer.TAG, "onCameraOpened, no need to close camera, state: " + TECameraServer.this.mCurrentCameraState);
                        TECameraServer.this.mCameraInstance = null;
                    } else {
                        TECameraServer.this.updateCameraState(4);
                        if (TECameraServer.this.mCameraInstance != null) {
                            TECameraServer.this.mCameraInstance.close(TECameraServer.this.cachedOpenPrivacyCert);
                            TECameraServer.this.mCameraInstance = null;
                        }
                        TECameraServer.this.updateCameraState(0);
                    }
                }
                TECameraServer.this.mCameraSettings.mCameraType = 1;
                TECameraServer.this.mCameraEvent.onCameraInfo(51, 0, "need recreate surfacetexture", null);
                TECameraServer.INSTANCE.open(TECameraServer.this.mCameraClient, TECameraServer.this.mCameraSettings, TECameraServer.this.cachedOpenPrivacyCert);
                TECameraServer.this.mOpenInfoMap.put("ResultType", "fallback to Camera1");
                TECameraMonitor.perfString(TECameraMonitor.TE_RECORD_CAMERA_OPEN_INFO, TECameraServer.this.mOpenInfoMap.toString());
            }
            TETraceUtils.endSection();
        }

        @Override // com.ss.android.ttvecamera.TECameraBase.CameraEvents
        public void onPreviewError(int i, int i2, String str, Object obj) {
            if (TECameraServer.this.mCameraSettings.mEnablePreviewingFallback && i2 == -437) {
                TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_PREVIEW_RET, i2);
                Handler handler = TECameraServer.this.mHandler;
                if (handler == null) {
                    return;
                }
                handler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TECameraServer.this.handlePreviewingFallback();
                    }
                });
                return;
            }
            synchronized (TECameraServer.this.mStateLock) {
                if (TECameraServer.this.mCameraInstance == null || TECameraServer.this.mCameraInstance.getRetryStartPreviewCount() <= 0) {
                    onCameraError(i, i2, str, obj);
                    TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_PREVIEW_RET, i2);
                } else {
                    TECameraServer.this.mStartPreviewError = true;
                    TELogUtils.w(TECameraServer.TAG, "Retry to startPreview. " + TECameraServer.this.mCameraInstance.getRetryStartPreviewCount() + " times is waiting to retry.");
                    TECameraServer.this.mCameraInstance.retryStartPreviewOnce();
                    Handler handler2 = TECameraServer.this.mHandler;
                    if (handler2 == null) {
                    } else {
                        handler2.postDelayed(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.46.2
                            @Override // java.lang.Runnable
                            public void run() {
                                TECameraServer tECameraServer = TECameraServer.this;
                                tECameraServer.start(tECameraServer.mCameraClient);
                            }
                        }, 100L);
                    }
                }
            }
        }

        @Override // com.ss.android.ttvecamera.TECameraBase.CameraEvents
        public void onPreviewStopped(int i, int i2, int i3, String str, Object obj) {
            TELogUtils.i(TECameraServer.TAG, "stopCapture success!");
            onCameraInfo(i2, i3, str, obj);
        }

        @Override // com.ss.android.ttvecamera.TECameraBase.CameraEvents
        public void onPreviewSuccess(int i, int i2, int i3, String str, Object obj) {
            TELogUtils.i(TECameraServer.TAG, "startCapture success!");
            TECameraServer.this.mStartPreviewError = false;
            if (TECameraServer.this.mCameraSettings == null || TECameraServer.this.mCameraInstance == null) {
                onCameraInfo(i2, i3, str, obj);
            } else {
                int retryStartPreviewCount = TECameraServer.this.mCameraSettings.mRetryStartPreviewCnt - TECameraServer.this.mCameraInstance.getRetryStartPreviewCount();
                onCameraInfo(i2, retryStartPreviewCount, str + ", Retry preview times = " + retryStartPreviewCount, obj);
                TECameraServer.this.mCameraInstance.collectCameraCapabilities();
            }
            TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_PREVIEW_RET, 0L);
        }

        @Override // com.ss.android.ttvecamera.TECameraBase.CameraEvents
        public void onTorchError(int i, int i2, int i3, String str, Object obj) {
            StringBuilder sb = new StringBuilder();
            sb.append("onTorchError ");
            sb.append(str);
            sb.append(i3 == 0 ? " close" : " open");
            TELogUtils.i(TECameraServer.TAG, sb.toString());
        }

        @Override // com.ss.android.ttvecamera.TECameraBase.CameraEvents
        public void onTorchSuccess(int i, int i2, int i3, String str, Object obj) {
            StringBuilder sb = new StringBuilder();
            sb.append("onTorchSuccess ");
            sb.append(str);
            sb.append(i3 == 0 ? " close" : " open");
            TELogUtils.i(TECameraServer.TAG, sb.toString());
        }
    };
    private final TECameraBase.CameraFpsConfigCallback mFpsConfigCallbackProxy = new TECameraBase.CameraFpsConfigCallback() { // from class: com.ss.android.ttvecamera.TECameraServer.47
        @Override // com.ss.android.ttvecamera.TECameraBase.CameraFpsConfigCallback
        public int[] config(List<int[]> list) {
            if (TECameraServer.this.mFpsConfigCallback != null) {
                return TECameraServer.this.mFpsConfigCallback.config(list);
            }
            return null;
        }
    };
    private final TECameraBase.PictureSizeCallBack mPictureSizeCallBack = new TECameraBase.PictureSizeCallBack() { // from class: com.ss.android.ttvecamera.TECameraServer.48
        @Override // com.ss.android.ttvecamera.TECameraBase.PictureSizeCallBack
        public TEFrameSizei getPictureSize(List<TEFrameSizei> list, List<TEFrameSizei> list2) {
            if (TECameraServer.this.mPictureSizeCallback != null) {
                return TECameraServer.this.mPictureSizeCallback.getPictureSize(list, list2);
            }
            return null;
        }
    };
    private final TECameraBase.PreviewSizeCallBack mBasePreviewSizeCallback = new TECameraBase.PreviewSizeCallBack() { // from class: com.ss.android.ttvecamera.TECameraServer.49
        @Override // com.ss.android.ttvecamera.TECameraBase.PreviewSizeCallBack
        public TEFrameSizei getPreviewSize(List<TEFrameSizei> list) {
            if (TECameraServer.this.mPreviewSizeCallback == null) {
                return null;
            }
            try {
                return TECameraServer.this.mPreviewSizeCallback.getPreviewSize(list);
            } catch (Exception e) {
                TELogUtils.e(TECameraServer.TAG, "select preview size from client err: " + e.getMessage());
                return null;
            }
        }
    };
    private TECameraBase.SATZoomCallback satZoomCallback = new TECameraBase.SATZoomCallback() { // from class: com.ss.android.ttvecamera.TECameraServer.50
        @Override // com.ss.android.ttvecamera.TECameraBase.SATZoomCallback
        public void onChange(int i, float f) {
            if (TECameraServer.this.mSATZoomCallback != null) {
                TECameraServer.this.mSATZoomCallback.onChange(i, f);
            }
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public static class HandlerCallback implements Handler.Callback {
        public static final int MSG_NONE = 0;
        public static final int MSG_START_ZOOM = 1;
        public static final int MSG_STOP_ZOOM = 2;
        private WeakReference<TECameraServer> mWeakServer;

        public HandlerCallback(TECameraServer tECameraServer) {
            this.mWeakServer = new WeakReference<>(tECameraServer);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            TECameraServer tECameraServer = this.mWeakServer.get();
            if (i == 1) {
                TELogUtils.d(TECameraServer.TAG, "startZoom...");
                synchronized (tECameraServer.mStateLock) {
                    if (tECameraServer.mCameraInstance != null) {
                        tECameraServer.mCameraInstance.startZoom(message.arg1 / 100.0f, (TECameraSettings.ZoomCallback) obj);
                    }
                    if (tECameraServer.mFirstZoom) {
                        tECameraServer.mCameraEvent.onCameraInfo(114, 0, "startzoom", tECameraServer.mCameraInstance);
                        tECameraServer.mFirstZoom = false;
                    }
                }
            }
            return false;
        }
    }

    TECameraServer() {
    }

    public static /* synthetic */ int access$1810(TECameraServer tECameraServer) {
        int i = tECameraServer.mRetryCnt;
        tECameraServer.mRetryCnt = i - 1;
        return i;
    }

    private boolean assertClient(TECameraCapture tECameraCapture) {
        synchronized (this.mLock) {
            TECameraCapture tECameraCapture2 = this.mCameraClient;
            if (tECameraCapture2 == tECameraCapture) {
                return true;
            }
            if (tECameraCapture2 == null) {
                TELogUtils.w(TAG, "Internal CameraClient is null. Must call connect first!");
            } else {
                TELogUtils.w(TAG, "Invalid CameraClient, need : " + this.mCameraClient);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int close(Cert cert) {
        return close(true, cert);
    }

    @Nullable
    private TECameraBase createCameraInstance() {
        TECameraBase tECameraBaseCreateCameraInstanceCore = createCameraInstanceCore();
        if (tECameraBaseCreateCameraInstanceCore != null) {
            tECameraBaseCreateCameraInstanceCore.registerPreviewListener(this.mPreviewSizeCallback != null ? this.mBasePreviewSizeCallback : null);
            tECameraBaseCreateCameraInstanceCore.registerFpsConfigListener(this.mFpsConfigCallback != null ? this.mFpsConfigCallbackProxy : null);
        }
        return tECameraBaseCreateCameraInstanceCore;
    }

    private TECameraBase createCameraInstanceCore() {
        int i = Build.VERSION.SDK_INT;
        if (i < 24) {
            return TECamera1.create(this.mCameraSettings.mContext, this.mCameraEvent, this.mHandler, this.mPictureSizeCallBack);
        }
        TECameraSettings tECameraSettings = this.mCameraSettings;
        boolean z = !tECameraSettings.mEnableCamera2Detect || TECameraUtils.isSupportsCamera2(tECameraSettings.mContext);
        TECameraSettings tECameraSettings2 = this.mCameraSettings;
        int i2 = tECameraSettings2.mCameraType;
        if (i2 == 1) {
            return TECamera1.create(tECameraSettings2.mContext, this.mCameraEvent, this.mHandler, this.mPictureSizeCallBack);
        }
        if ((10 != i2 && 11 != i2) || i < 28) {
            if (!z) {
                tECameraSettings2.mCameraType = 1;
                return TECamera1.create(tECameraSettings2.mContext, this.mCameraEvent, this.mHandler, this.mPictureSizeCallBack);
            }
            TECameraBase tECameraBaseCreateVendorCamera2Instance = createVendorCamera2Instance(i2, tECameraSettings2.mContext, this.mCameraEvent, this.mHandler, this.mPictureSizeCallBack);
            if (tECameraBaseCreateVendorCamera2Instance != null) {
                return tECameraBaseCreateVendorCamera2Instance;
            }
            TECameraSettings tECameraSettings3 = this.mCameraSettings;
            tECameraSettings3.mCameraType = 2;
            return TECamera2.create(2, tECameraSettings3.mContext, this.mCameraEvent, this.mHandler, this.mPictureSizeCallBack);
        }
        TECameraBase tECameraBase = (TECameraBase) TECameraUtils.createCameraInstance("com.ss.android.ttvecamera.TEVendorCamera", i2, tECameraSettings2.mContext, this.mCameraEvent, this.mHandler, this.mPictureSizeCallBack);
        if (tECameraBase != null) {
            TELogUtils.i(TAG, "createCameraInstance TEVendorCamera");
            return tECameraBase;
        }
        if (z) {
            TECameraSettings tECameraSettings4 = this.mCameraSettings;
            tECameraSettings4.mCameraType = 2;
            return TECamera2.create(2, tECameraSettings4.mContext, this.mCameraEvent, this.mHandler, this.mPictureSizeCallBack);
        }
        TECameraSettings tECameraSettings5 = this.mCameraSettings;
        tECameraSettings5.mCameraType = 1;
        return TECamera1.create(tECameraSettings5.mContext, this.mCameraEvent, this.mHandler, this.mPictureSizeCallBack);
    }

    private Handler createHandler(boolean z, String str) {
        if (z) {
            try {
                HandlerThread handlerThread = this.mHandlerThread;
                if (handlerThread != null) {
                    handlerThread.quit();
                }
                HandlerThread handlerThread2 = new HandlerThread(str);
                handlerThread2.start();
                handlerThread2.getLooper().setMessageLogging(new Printer() { // from class: com.ss.android.ttvecamera.TECameraServer.45
                    private static final int MAX_LAG_EDGE = 1000;
                    private static final String TASK_END_PREFIX = "<<<<< Finished to Handler";
                    private static final String TASK_START_PREFIX = ">>>>> Dispatching to Handler";
                    private long startWorkTimeMillis = 0;
                    private int taskTimeOutCount = 0;
                    private long maxLagMillis = 0;

                    @Override // android.util.Printer
                    public void println(String str2) {
                        if (str2.startsWith(TASK_START_PREFIX)) {
                            this.startWorkTimeMillis = System.currentTimeMillis();
                            return;
                        }
                        if (str2.startsWith(TASK_END_PREFIX)) {
                            long jCurrentTimeMillis = System.currentTimeMillis() - this.startWorkTimeMillis;
                            if (jCurrentTimeMillis > 1000) {
                                int i = this.taskTimeOutCount + 1;
                                this.taskTimeOutCount = i;
                                TECameraMonitor.perfLong("te_record_camera_task_time_out_count", i);
                                if (jCurrentTimeMillis > this.maxLagMillis) {
                                    this.maxLagMillis = jCurrentTimeMillis;
                                    TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_MAX_LAG_TASK_COST, jCurrentTimeMillis);
                                    TELogUtils.i(TECameraServer.TAG, "task: " + str2 + ", cost: " + jCurrentTimeMillis + "ms");
                                }
                            }
                        }
                    }
                });
                this.mHandlerThread = handlerThread2;
                return new Handler(handlerThread2.getLooper(), new HandlerCallback(this));
            } catch (Exception e) {
                TELogUtils.e(TAG, "CreateHandler failed!: " + e.toString());
            }
        }
        return new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
    }

    private Message createMessage(int i, boolean z, Handler handler) {
        Message messageObtainMessage;
        if (z && handler.hasMessages(i)) {
            handler.removeMessages(i);
            messageObtainMessage = new Message();
        } else {
            messageObtainMessage = handler.obtainMessage();
        }
        messageObtainMessage.what = i;
        return messageObtainMessage;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047 A[RETURN] */
    @RequiresApi(api = 21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private TECameraBase createVendorCamera2Instance(@TECameraSettings.CameraType int i, Context context, TECameraBase.CameraEvents cameraEvents, Handler handler, TECameraBase.PictureSizeCallBack pictureSizeCallBack) {
        String str;
        String str2;
        if (i == 4) {
            str2 = "com.ss.android.ttvecamera.TEOpMediaCamera";
        } else if (i == 6) {
            str2 = "com.ss.android.ttvecamera.TEVoCamera";
        } else if (i == 8 && Build.VERSION.SDK_INT >= 28) {
            str2 = "com.ss.android.ttvecamera.TEXmV2Camera";
        } else {
            if (i != 9) {
                str = null;
                if (str != null) {
                    return null;
                }
                TECamera2 tECamera2 = (TECamera2) TECameraUtils.createCameraInstance(str, i, context, cameraEvents, handler, pictureSizeCallBack);
                TELogUtils.i(TAG, "create, vendorCamera2 = " + tECamera2);
                return tECamera2;
            }
            str2 = "com.ss.android.ttvecamera.TEOpCamera";
        }
        str = str2;
        if (str != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int decreaseClientCount() {
        this.sClientCount--;
        TELogUtils.d(TAG, "sClientCount = " + this.sClientCount);
        if (this.sClientCount < 0) {
            TELogUtils.w(TAG, "Invalid ClientCount = " + this.sClientCount);
            this.sClientCount = 0;
        }
        return this.sClientCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int destroy() {
        TELogUtils.i(TAG, "destroy...start");
        this.mIsInitialized = false;
        this.mCheckCloseTask = null;
        this.mCameraClient = null;
        this.mPictureSizeCallback = null;
        this.mPreviewSizeCallback = null;
        this.mFpsConfigCallback = null;
        this.cachedClosePrivacyCert = null;
        this.cachedOpenPrivacyCert = null;
        this.mProviderSettings = null;
        if (this.mCameraInstance != null) {
            this.mCameraInstance.destroy();
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.1
                @Override // java.lang.Runnable
                public void run() {
                    TECameraServer.this.mProviderManager.removeProvider();
                    TELogUtils.i(TECameraServer.TAG, "provider release...");
                }
            });
        }
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.mHandlerThread = null;
            this.mHandlerDestroyed = true;
            this.mHandler = null;
        }
        this.mCameraObserver = TECameraCapture.NullCameraObserver.getInstance();
        TELogUtils.i(TAG, "destroy...end");
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePreviewingFallback() {
        boolean z;
        if (this.mCameraSettings.mCameraType == 1) {
            return;
        }
        synchronized (this.mStateLock) {
            if (this.mCurrentCameraState == 3) {
                if (this.mCameraInstance != null) {
                    this.mCameraInstance.stopCapture();
                    updateCameraState(4);
                    this.mCameraInstance.close(this.cachedOpenPrivacyCert);
                    this.mCameraInstance = null;
                    updateCameraState(0);
                }
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            this.mCameraSettings.mCameraType = 1;
            this.mCameraEvent.onCameraInfo(51, 0, "need recreate surfacetexture", null);
            INSTANCE.open(this.mCameraClient, this.mCameraSettings, this.cachedOpenPrivacyCert);
        }
    }

    private synchronized int increaseClientCount() {
        this.sClientCount++;
        TELogUtils.d(TAG, "sClientCount = " + this.sClientCount);
        return this.sClientCount;
    }

    private synchronized void init(boolean z) {
        TELogUtils.i(TAG, "init...start");
        if (this.mIsInitialized) {
            return;
        }
        this.mHandler = createHandler(z, TAG);
        this.mHandlerDestroyed = false;
        this.mProviderManager = new TECameraProviderManager();
        this.mIsInitialized = true;
        this.mCurrentZoom = 0.0f;
        this.mOnBackGround = false;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mSystemResManager = new TESystemResManager();
        TELogUtils.i(TAG, "init...end");
    }

    private boolean isARConfigNotEqual(TECameraSettings tECameraSettings) {
        TECameraSettings tECameraSettings2 = this.mCameraSettings;
        if (tECameraSettings2 == null) {
            return true;
        }
        if (tECameraSettings.mMode != 2) {
            return false;
        }
        TECameraSettings.ARConfig aRConfig = tECameraSettings2.arConfig;
        return (aRConfig != null && aRConfig.augmentedFaceMode.ordinal() == tECameraSettings.arConfig.augmentedFaceMode.ordinal() && this.mCameraSettings.arConfig.cloudAnchorMode.ordinal() == tECameraSettings.arConfig.cloudAnchorMode.ordinal() && this.mCameraSettings.arConfig.depthMode.ordinal() == tECameraSettings.arConfig.depthMode.ordinal() && this.mCameraSettings.arConfig.focusMode.ordinal() == tECameraSettings.arConfig.focusMode.ordinal() && this.mCameraSettings.arConfig.lightEstimationMode.ordinal() == tECameraSettings.arConfig.lightEstimationMode.ordinal() && this.mCameraSettings.arConfig.planeFindingMode.ordinal() == tECameraSettings.arConfig.planeFindingMode.ordinal()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCameraPermitted() {
        boolean z = true;
        try {
            if (ContextCompat.checkSelfPermission(this.mCameraSettings.mContext, "android.permission.CAMERA") != 0) {
                z = false;
            }
        } catch (Exception e) {
            TELogUtils.e(TAG, "test camera permission failed!: " + e.toString());
        }
        this.mOpenInfoMap.put("CamPerm" + this.mRetryCnt, String.valueOf(z));
        return z;
    }

    private boolean onlySwitchSession(TECameraSettings tECameraSettings) {
        int i;
        TECameraSettings tECameraSettings2 = this.mCameraSettings;
        if (tECameraSettings2 == null || tECameraSettings2.mFacing != 0 || tECameraSettings.mFacing != 0 || (i = tECameraSettings2.mCameraType) != 11 || i != tECameraSettings.mCameraType) {
            return false;
        }
        TEFrameSizei tEFrameSizei = tECameraSettings2.mPreviewSize;
        int i2 = tEFrameSizei.width;
        TEFrameSizei tEFrameSizei2 = tECameraSettings.mPreviewSize;
        if (i2 != tEFrameSizei2.width || tEFrameSizei.height != tEFrameSizei2.height || tECameraSettings2.mHighFPS != tECameraSettings.mHighFPS || tECameraSettings2.mRequiredCameraLevel != tECameraSettings.mRequiredCameraLevel || tECameraSettings2.mMaxWidth != tECameraSettings.mMaxWidth || tECameraSettings2.mUseMaxWidthTakePicture != tECameraSettings.mUseMaxWidthTakePicture || tECameraSettings2.mEnableStabilization == tECameraSettings.mEnableStabilization || tECameraSettings2.mEnableAiNightVideo == tECameraSettings.mEnableAiNightVideo) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(TECameraSettings.Parameters.ENABLE_VIDEO_STABILIZATION, tECameraSettings.mEnableStabilization);
        bundle.putBoolean(TECameraSettings.Parameters.ENABLE_AI_NIGHT_VIDEO, tECameraSettings.mEnableAiNightVideo);
        this.mCameraInstance.setFeatureParameters(bundle);
        this.mCameraSettings = tECameraSettings;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int open(@NonNull final TECameraCapture tECameraCapture, final TECameraSettings tECameraSettings, final Cert cert) {
        int iOpen;
        if (!assertClient(tECameraCapture)) {
            return -108;
        }
        if (this.mIsCameraPendingClose) {
            TELogUtils.e(TAG, "pending close");
            return -105;
        }
        if (tECameraSettings.mEnableBackGroundStrategy && this.mOnBackGround) {
            TELogUtils.e(TAG, "in background");
            return -105;
        }
        Handler handler = this.mHandler;
        if (handler == null) {
            TELogUtils.e(TAG, "open, mHandler is null!");
            return TECameraResult.TER_INVALID_HANDLER;
        }
        if (this.mIsCameraPendingClose) {
            TELogUtils.e(TAG, "had called disConnect(), abandon open camera!");
            return TECameraResult.TER_CLOSE_CALLED;
        }
        if (this.mHandlerDestroyed || Looper.myLooper() == handler.getLooper()) {
            TETraceUtils.beginSection("TECameraServer-open");
            this.mCameraSettings = tECameraSettings;
            TELogUtils.i(TAG, "is force close camera=" + this.mCameraSettings.mIsForceCloseCamera + ", Camera2Detect=" + this.mCameraSettings.mEnableCamera2Detect);
            this.mCheckCloseTask = new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (TECameraServer.this.mCurrentCameraState <= 1 || TECameraServer.this.mCurrentCameraState >= 4) {
                        if (TECameraServer.this.mCurrentCameraState == 1) {
                            TECameraServer.this.mMainHandler.postDelayed(this, 2000L);
                            return;
                        }
                        return;
                    }
                    TELogUtils.i(TECameraServer.TAG, "close camera in main thread");
                    if (!TECameraServer.this.mCameraSettings.mIsForceCloseCamera || TECameraServer.this.mCameraInstance == null) {
                        TECameraServer tECameraServer = TECameraServer.this;
                        tECameraServer.realCloseCamera(tECameraServer.cachedClosePrivacyCert);
                    } else {
                        TECameraServer.this.updateCameraState(4);
                        TECameraServer.this.mCameraInstance.forceCloseCamera(TECameraServer.this.cachedClosePrivacyCert);
                        TECameraServer.this.updateCameraState(0);
                    }
                    if (TECameraServer.this.decreaseClientCount() == 0) {
                        TECameraServer.this.destroy();
                    }
                }
            };
            this.mCurrentZoom = 0.0f;
            if (this.mRetryCnt < 0) {
                this.mRetryCnt = tECameraSettings.mRetryCnt;
            }
            synchronized (this.mStateLock) {
                if (this.mCurrentCameraState != 0) {
                    TELogUtils.w(TAG, "No need open camera again, state = " + this.mCurrentCameraState);
                    if (this.mCurrentCameraState != 1) {
                        this.mCameraObserver.onInfo(1, 0, "Camera features is ready");
                    }
                    TETraceUtils.endSection();
                    return 0;
                }
                updateCameraState(1);
                if (this.mCameraInstance == null) {
                    this.mCameraInstance = createCameraInstance();
                    if (this.mCameraInstance == null) {
                        if (this.mCameraSettings.mCameraType == 11) {
                            updateCameraState(0);
                            this.mCameraEvent.onCameraOpened(this.mCameraSettings.mCameraType, TECameraResult.TER_CAMERA_VENDOR_AUTH_FAILED, null, null);
                        } else {
                            updateCameraState(0);
                            this.mCameraObserver.onError(-100, "open : mCameraInstance is null.");
                        }
                        return -1;
                    }
                    this.mCameraInstance.setSATZoomCallback(this.satZoomCallback);
                }
                this.mBeginTime = System.currentTimeMillis();
                if (this.mEnableVBoost) {
                    this.mSystemResManager.startAction(new TESystemResManager.Action(TESystemResManager.ActionType.BOOST_CPU, this.mVBoostTimeoutMS));
                    iOpen = this.mCameraInstance.open(this.mCameraSettings, cert);
                    this.mSystemResManager.startAction(new TESystemResManager.Action(TESystemResManager.ActionType.RESTORE_CPU));
                } else {
                    iOpen = this.mCameraInstance.open(this.mCameraSettings, cert);
                }
                if (iOpen != 0) {
                    TELogUtils.w(TAG, "Open camera failed, ret = " + iOpen);
                }
                TETraceUtils.endSection();
            }
        } else {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            handler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.2
                @Override // java.lang.Runnable
                public void run() {
                    TELogUtils.d(TECameraServer.TAG, "Push open task cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                    TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_PUSH_OPEN_TASK_TIME, System.currentTimeMillis() - jCurrentTimeMillis);
                    TECameraServer.this.open(tECameraCapture, tECameraSettings, cert);
                    TELogUtils.i(TECameraServer.TAG, "Camera open cost: " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
                }
            });
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realCloseCamera(Cert cert) {
        synchronized (this.mStateLock) {
            if (this.mCurrentCameraState == 0) {
                TELogUtils.w(TAG, "realCloseCamera, no need to close camera, state: " + this.mCurrentCameraState);
            } else {
                updateCameraState(4);
                if (this.mCameraInstance != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    this.mCameraInstance.close(cert);
                    TELogUtils.i(TAG, "system call close() cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                }
                updateCameraState(0);
            }
            if (this.mCameraInstance != null) {
                this.mCameraInstance.destroy();
                this.mCameraInstance = null;
            }
        }
    }

    private void setAsyncCloseCheckMsg() {
        this.mMainHandler.removeCallbacks(this.mCheckCloseTask);
        this.mMainHandler.postDelayed(this.mCheckCloseTask, 2000L);
    }

    private boolean shouldReOpenCamera(TECameraSettings tECameraSettings) {
        TECameraSettings tECameraSettings2 = this.mCameraSettings;
        if (tECameraSettings2 != null) {
            if (tECameraSettings2.mCameraType == tECameraSettings.mCameraType) {
                TEFrameSizei tEFrameSizei = tECameraSettings2.mPreviewSize;
                int i = tEFrameSizei.width;
                TEFrameSizei tEFrameSizei2 = tECameraSettings.mPreviewSize;
                if (i != tEFrameSizei2.width || tEFrameSizei.height != tEFrameSizei2.height || tECameraSettings2.mFacing != tECameraSettings.mFacing || tECameraSettings2.mHighFPS != tECameraSettings.mHighFPS || tECameraSettings2.mEnableStabilization != tECameraSettings.mEnableStabilization || tECameraSettings2.mRequiredCameraLevel != tECameraSettings.mRequiredCameraLevel || tECameraSettings2.mMaxWidth != tECameraSettings.mMaxWidth || tECameraSettings2.mUseMaxWidthTakePicture != tECameraSettings.mUseMaxWidthTakePicture || tECameraSettings2.mMode != tECameraSettings.mMode || isARConfigNotEqual(tECameraSettings)) {
                }
            }
            return true;
        }
        return false;
    }

    public int abortSession(TECameraCapture tECameraCapture) {
        if (!assertClient(tECameraCapture)) {
            return -108;
        }
        Handler handler = this.mHandler;
        if (handler == null) {
            TELogUtils.e(TAG, "abortSession, mHandler is null!");
            return TECameraResult.TER_INVALID_HANDLER;
        }
        handler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.8
            @Override // java.lang.Runnable
            public void run() {
                if (TECameraServer.this.mCameraInstance != null) {
                    TECameraServer.this.mCameraInstance.abortSession();
                }
            }
        });
        return 0;
    }

    public void addCameraAlgorithm(TECameraAlgorithmParam tECameraAlgorithmParam) {
        if (this.mCameraInstance == null) {
            TELogUtils.e(TAG, "addCameraAlgorithm failed mCameraInstance is null!");
        } else {
            this.mCameraInstance.addCameraAlgorithm(tECameraAlgorithmParam);
        }
    }

    public int addCameraProvider(final TECameraCapture tECameraCapture, final TECameraProviderManager.ProviderSettings providerSettings) {
        TECameraProviderManager.ProviderSettings providerSettings2;
        if (!assertClient(tECameraCapture)) {
            return -108;
        }
        if (this.mHandlerDestroyed || Looper.myLooper() == this.mHandler.getLooper()) {
            TELogUtils.i(TAG, "addCameraProvider");
            synchronized (this.mStateLock) {
                if (this.mCameraInstance == null) {
                    this.mCameraObserver.onError(-100, "Invalidate Camera Instance!!");
                    return -100;
                }
                TELogUtils.i(TAG, "addCameraProvider, mProviderSettings = " + this.mProviderSettings + ", providerSettings = " + providerSettings);
                if (this.mProviderSettings == null || this.mCameraInstance.getProviderManager() == null || !((providerSettings2 = this.mProviderSettings) == null || providerSettings2.isSame(providerSettings))) {
                    this.mProviderManager.createProvider(providerSettings, this.mCameraInstance);
                    this.mIsCameraProviderChanged = true;
                    TECameraProviderManager.ProviderSettings providerSettings3 = this.mProviderSettings;
                    if (providerSettings3 == null) {
                        this.mProviderSettings = new TECameraProviderManager.ProviderSettings(providerSettings);
                    } else {
                        providerSettings3.copyFrom(providerSettings);
                    }
                } else {
                    this.mIsCameraProviderChanged = false;
                }
            }
        } else {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.5
                @Override // java.lang.Runnable
                public void run() {
                    TECameraServer.this.addCameraProvider(tECameraCapture, providerSettings);
                }
            });
        }
        return 0;
    }

    public void appLifeCycleChanged(boolean z) {
        this.mOnBackGround = z;
    }

    public int cancelFocus(final TECameraCapture tECameraCapture) {
        if (!assertClient(tECameraCapture)) {
            return -108;
        }
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.18
                @Override // java.lang.Runnable
                public void run() {
                    TECameraServer.this.cancelFocus(tECameraCapture);
                }
            });
            return 0;
        }
        TELogUtils.i(TAG, "cancelFocus...");
        synchronized (this.mStateLock) {
            this.mCameraInstance.cancelFocus();
        }
        return 0;
    }

    public int captureBurst(TECameraCapture tECameraCapture, final TECameraSettings.CaptureBufferFrameCallback captureBufferFrameCallback, final BurstRequest burstRequest) {
        if (!assertClient(tECameraCapture)) {
            return -108;
        }
        this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.14
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TECameraServer.this.mStateLock) {
                    if (TECameraServer.this.mCurrentCameraState == 3) {
                        if (TECameraServer.this.mCameraSettings.mCameraType == 1) {
                            TECameraServer.this.updateCameraState(2);
                        }
                        TECameraServer.this.mCameraInstance.captureBurst(burstRequest, captureBufferFrameCallback);
                        return;
                    }
                    String str = "Can not takePicture on state : " + TECameraServer.this.mCurrentCameraState;
                    TECameraServer.this.mCameraObserver.onError(-105, str);
                    TELogUtils.e(TECameraServer.TAG, str);
                    TECameraSettings.CaptureBufferFrameCallback captureBufferFrameCallback2 = captureBufferFrameCallback;
                    if (captureBufferFrameCallback2 != null) {
                        captureBufferFrameCallback2.onError(new Exception(str));
                    }
                }
            }
        });
        return 0;
    }

    public int changeRecorderState(final TECameraCapture tECameraCapture, final int i, final TECameraBase.CameraKitStateCallback cameraKitStateCallback) {
        if (!assertClient(tECameraCapture)) {
            return -108;
        }
        if (!this.mHandlerDestroyed && Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.51
                @Override // java.lang.Runnable
                public void run() {
                    TECameraServer.this.changeRecorderState(tECameraCapture, i, cameraKitStateCallback);
                }
            });
            return 0;
        }
        synchronized (this.mStateLock) {
            if (this.mCameraInstance == null) {
                this.mCameraObserver.onError(-100, "Invalidate Camera Instance!!");
                return -100;
            }
            this.mCameraInstance.changeRecorderState(i, cameraKitStateCallback);
            return 0;
        }
    }

    public int connect(@NonNull TECameraCapture tECameraCapture, @NonNull TECameraCapture.CameraObserver cameraObserver, @NonNull TECameraSettings tECameraSettings, TECameraCapture.PictureSizeCallBack pictureSizeCallBack, Cert cert) {
        TELogUtils.i(TAG, "connect with client: " + tECameraCapture);
        if (tECameraCapture == null) {
            throw new IllegalArgumentException("client must not be null");
        }
        if (cameraObserver == null) {
            throw new IllegalArgumentException("observer must not be null");
        }
        if (tECameraSettings == null) {
            throw new IllegalArgumentException("mParams must not be null");
        }
        this.mMainHandler.removeCallbacks(this.mCheckCloseTask);
        synchronized (this.mLock) {
            boolean zShouldReOpenCamera = shouldReOpenCamera(tECameraSettings);
            if (tECameraCapture == this.mCameraClient && !zShouldReOpenCamera) {
                TELogUtils.w(TAG, "No need reconnect.");
                return 0;
            }
            if (!this.mIsInitialized) {
                init(true);
                zShouldReOpenCamera = false;
            }
            this.mCameraClient = tECameraCapture;
            this.mCameraObserver = cameraObserver;
            this.mPictureSizeCallback = pictureSizeCallBack;
            boolean z = tECameraSettings.mEnableVBoost;
            this.mEnableVBoost = z;
            this.mRetryCnt = -1;
            if (z) {
                this.mVBoostTimeoutMS = tECameraSettings.mVBoostTimeoutMS;
                this.mSystemResManager.setStrategy(new TEVBoostStrategy());
                this.mSystemResManager.initStrategy(tECameraSettings.mContext);
            }
            increaseClientCount();
            if (zShouldReOpenCamera) {
                TELogUtils.i(TAG, "reopen camera.");
                close(cert);
            }
            this.mIsCameraPendingClose = false;
            this.cachedOpenPrivacyCert = cert;
            return open(tECameraCapture, tECameraSettings, cert);
        }
    }

    public boolean couldForwardState(int i) {
        if (i == this.mCurrentCameraState) {
            TELogUtils.w(TAG, "No need this");
        }
        if (i != 0) {
            if (i != 1) {
                if (i == 2 || i == 3) {
                    return this.mCurrentCameraState == 1;
                }
                TELogUtils.e(TAG, "Invalidate camera state = " + i);
                return false;
            }
            if (this.mCurrentCameraState != 0) {
                TELogUtils.w(TAG, "No need open camera again, state = " + this.mCurrentCameraState);
            }
        }
        return true;
    }

    public int disConnect(TECameraCapture tECameraCapture, Cert cert) {
        return disConnect(tECameraCapture, true, cert);
    }

    public void downExposureCompensation(final TECameraCapture tECameraCapture) {
        if (assertClient(tECameraCapture)) {
            if (Looper.myLooper() != this.mHandler.getLooper()) {
                this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.32
                    @Override // java.lang.Runnable
                    public void run() {
                        TECameraServer.this.downExposureCompensation(tECameraCapture);
                    }
                });
                return;
            }
            TELogUtils.i(TAG, "downExposureCompensation...");
            synchronized (this.mStateLock) {
                if (this.mCurrentCameraState == 3 || this.mCurrentCameraState == 2) {
                    if (this.mCameraInstance.getCameraECInfo() == null) {
                        this.mCameraObserver.onError(TECameraResult.TER_INVALID_HANDLER, "downExposureCompensation get ec info failed");
                        return;
                    } else {
                        this.mCameraInstance.setExposureCompensation(r0.exposure - 1);
                        return;
                    }
                }
                this.mCameraObserver.onError(-105, "Can not set ec on state : " + this.mCurrentCameraState);
            }
        }
    }

    public int enableCaf(final TECameraCapture tECameraCapture) {
        if (!assertClient(tECameraCapture)) {
            return -108;
        }
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.19
                @Override // java.lang.Runnable
                public void run() {
                    TECameraServer.this.enableCaf(tECameraCapture);
                }
            });
            return 0;
        }
        TELogUtils.i(TAG, "enableCaf...");
        synchronized (this.mStateLock) {
            if (this.mCameraInstance != null) {
                this.mCameraInstance.enableCaf();
            }
        }
        return 0;
    }

    public int enableMulticamZoom(final TECameraCapture tECameraCapture, final boolean z) {
        if (!assertClient(tECameraCapture)) {
            return -108;
        }
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.52
                @Override // java.lang.Runnable
                public void run() {
                    TECameraServer.this.enableMulticamZoom(tECameraCapture, z);
                }
            });
            return 0;
        }
        TELogUtils.i(TAG, "enableMulticamZoom: " + z);
        synchronized (this.mStateLock) {
            if (this.mCameraInstance != null) {
                this.mCameraInstance.enableMulticamZoom(z);
            }
        }
        return 0;
    }

    public int focusAtPoint(final TECameraCapture tECameraCapture, final TEFocusSettings tEFocusSettings) {
        if (!assertClient(tECameraCapture)) {
            return -108;
        }
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.17
                @Override // java.lang.Runnable
                public void run() {
                    int iFocusAtPoint = TECameraServer.this.focusAtPoint(tECameraCapture, tEFocusSettings);
                    if (iFocusAtPoint == 0 || tEFocusSettings.getFocusCallback() == null) {
                        return;
                    }
                    tEFocusSettings.getFocusCallback().onFocus(iFocusAtPoint, TECameraServer.this.mCameraSettings.mFacing, "");
                }
            });
            return 0;
        }
        TELogUtils.i(TAG, "focusAtPoint at: " + tEFocusSettings);
        synchronized (this.mStateLock) {
            if (this.mCurrentCameraState == 3) {
                this.mCameraInstance.focusAtPoint(tEFocusSettings);
                return 0;
            }
            String str = "Can not set focus on state : " + this.mCurrentCameraState;
            TELogUtils.w(TAG, str);
            this.mCameraObserver.onError(-105, str);
            return -105;
        }
    }

    public float[] getApertureRange(final TECameraCapture tECameraCapture, final TECameraSettings.ApertureCallback apertureCallback) {
        float[] apertureRange = {0.0f};
        if (!assertClient(tECameraCapture)) {
            return new float[]{-1.0f, -1.0f};
        }
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.41
                @Override // java.lang.Runnable
                public void run() {
                    float[] apertureRange2 = TECameraServer.this.getApertureRange(tECameraCapture, apertureCallback);
                    if (apertureRange2 != null) {
                        apertureCallback.getApertureRange(apertureRange2);
                    }
                }
            });
        } else {
            synchronized (this.mStateLock) {
                if (this.mCameraInstance != null) {
                    apertureRange = this.mCameraInstance.getApertureRange();
                }
            }
        }
        return apertureRange;
    }

    public TEFrameSizei getBestPreviewSize(TECameraCapture tECameraCapture, float f, TEFrameSizei tEFrameSizei) {
        if (!assertClient(tECameraCapture) || this.mCurrentCameraState == 0 || this.mCurrentCameraState == 1) {
            return null;
        }
        return this.mCameraInstance.getBestPreviewSize(f, tEFrameSizei);
    }

    public JSONObject getCameraCapbilitiesForBytebench(final TECameraCapture tECameraCapture, final TECameraSettings.CameraCapabilitiesForBytebenchCallback cameraCapabilitiesForBytebenchCallback) {
        JSONObject jSONObject = new JSONObject();
        if (!assertClient(tECameraCapture)) {
            return null;
        }
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.53
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject cameraCapbilitiesForBytebench = TECameraServer.this.getCameraCapbilitiesForBytebench(tECameraCapture, cameraCapabilitiesForBytebenchCallback);
                    TECameraSettings.CameraCapabilitiesForBytebenchCallback cameraCapabilitiesForBytebenchCallback2 = cameraCapabilitiesForBytebenchCallback;
                    if (cameraCapabilitiesForBytebenchCallback2 != null) {
                        cameraCapabilitiesForBytebenchCallback2.getCameraCapabilities(cameraCapbilitiesForBytebench);
                    }
                }
            });
        } else {
            TELogUtils.i(TAG, "getCameraCapbilitiesForBytebench");
            synchronized (this.mStateLock) {
                if (this.mCameraInstance != null) {
                    jSONObject = this.mCameraInstance.getCameraCapbilitiesForBytebench();
                }
            }
        }
        return jSONObject;
    }

    public int[] getCameraCaptureSize() {
        if (this.mCameraInstance == null) {
            return null;
        }
        return this.mCameraInstance.getCameraCaptureSize();
    }

    public TECameraSettings.ExposureCompensationInfo getCameraECInfo(TECameraCapture tECameraCapture) {
        if (assertClient(tECameraCapture) && this.mCameraInstance != null) {
            return this.mCameraInstance.getCameraECInfo();
        }
        return null;
    }

    public int getCameraState() {
        return getCameraState(false);
    }

    public int getExposureCompensation(TECameraCapture tECameraCapture) {
        if (!assertClient(tECameraCapture)) {
            throw new RuntimeException("Client is not connected!!!");
        }
        synchronized (this.mStateLock) {
            if (this.mCurrentCameraState == 3 || this.mCurrentCameraState == 2) {
                return this.mCameraInstance.getExposureCompensation();
            }
            this.mCameraObserver.onError(-105, "Can not get ec on state : " + this.mCurrentCameraState);
            return -105;
        }
    }

    public float[] getFOV(final TECameraCapture tECameraCapture, final TECameraSettings.FOVCallback fOVCallback) {
        float[] fov = new float[2];
        if (!assertClient(tECameraCapture)) {
            return new float[]{-2.0f, -2.0f};
        }
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.13
                @Override // java.lang.Runnable
                public void run() {
                    float[] fov2 = TECameraServer.this.getFOV(tECameraCapture, fOVCallback);
                    TECameraSettings.FOVCallback fOVCallback2 = fOVCallback;
                    if (fOVCallback2 != null) {
                        fOVCallback2.getFOV(fov2);
                    }
                }
            });
        } else {
            TELogUtils.i(TAG, "getFOV");
            synchronized (this.mStateLock) {
                if (this.mCurrentCameraState != 3) {
                    this.mCameraObserver.onError(-105, "Can not getFOV on state : " + this.mCurrentCameraState);
                    return new float[]{-2.0f, -2.0f};
                }
                fov = this.mCameraInstance.getFOV();
            }
        }
        return fov;
    }

    public int getFlashMode(TECameraCapture tECameraCapture) {
        if (this.mCameraInstance == null) {
            return -1;
        }
        return this.mCameraInstance.getFlashMode();
    }

    public int getISO(final TECameraCapture tECameraCapture, final TECameraSettings.ISOCallback iSOCallback) {
        if (!assertClient(tECameraCapture)) {
            return -1;
        }
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.38
                @Override // java.lang.Runnable
                public void run() {
                    int iso = TECameraServer.this.getISO(tECameraCapture, iSOCallback);
                    if (iso >= 0) {
                        iSOCallback.getCurrentISO(iso);
                    }
                }
            });
        } else {
            synchronized (this.mStateLock) {
                iso = this.mCameraInstance != null ? this.mCameraInstance.getISO() : -1;
            }
        }
        return iso;
    }

    public int[] getISORange(final TECameraCapture tECameraCapture, final TECameraSettings.ISORangeCallback iSORangeCallback) {
        int[] iSORange = new int[2];
        if (!assertClient(tECameraCapture)) {
            return new int[]{-1, -1};
        }
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.36
                @Override // java.lang.Runnable
                public void run() {
                    int[] iSORange2 = TECameraServer.this.getISORange(tECameraCapture, iSORangeCallback);
                    if (iSORange2 != null) {
                        iSORangeCallback.getISORange(iSORange2);
                    }
                }
            });
        } else {
            synchronized (this.mStateLock) {
                if (this.mCameraInstance != null) {
                    iSORange = this.mCameraInstance.getISORange();
                }
            }
        }
        return iSORange;
    }

    public float getManualFocusAbility(final TECameraCapture tECameraCapture, final TECameraSettings.ManualFocusCallback manualFocusCallback) {
        if (!assertClient(tECameraCapture)) {
            return -1.0f;
        }
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.20
                @Override // java.lang.Runnable
                public void run() {
                    float manualFocusAbility = TECameraServer.this.getManualFocusAbility(tECameraCapture, manualFocusCallback);
                    if (manualFocusAbility >= 0.0f) {
                        manualFocusCallback.getManualFocusAbility(manualFocusAbility);
                    }
                }
            });
        } else {
            synchronized (this.mStateLock) {
                manualFocusAbility = this.mCameraInstance != null ? this.mCameraInstance.getManualFocusAbility() : -1.0f;
            }
        }
        return manualFocusAbility;
    }

    public int[] getPictureSize(TECameraCapture tECameraCapture) {
        if (assertClient(tECameraCapture) && this.mCameraInstance != null) {
            return this.mCameraInstance.getPictureSize();
        }
        return null;
    }

    public int[] getPreviewFps() {
        if (this.mCameraInstance == null) {
            return null;
        }
        return this.mCameraInstance.getPreviewFps();
    }

    public long[] getShutterTimeRange(final TECameraCapture tECameraCapture, final TECameraSettings.ShutterTimeCallback shutterTimeCallback) {
        long[] shutterTimeRange = new long[2];
        if (!assertClient(tECameraCapture)) {
            return new long[]{-1, -1};
        }
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.39
                @Override // java.lang.Runnable
                public void run() {
                    long[] shutterTimeRange2 = TECameraServer.this.getShutterTimeRange(tECameraCapture, shutterTimeCallback);
                    if (shutterTimeRange2 != null) {
                        shutterTimeCallback.getShutterTimeRange(shutterTimeRange2);
                    }
                }
            });
        } else {
            synchronized (this.mStateLock) {
                if (this.mCameraInstance != null) {
                    shutterTimeRange = this.mCameraInstance.getShutterTimeRange();
                }
            }
        }
        return shutterTimeRange;
    }

    public List<TEFrameSizei> getSupportedPictureSizes(TECameraCapture tECameraCapture) {
        if (!assertClient(tECameraCapture) || this.mCameraInstance == null) {
            return null;
        }
        try {
            return this.mCameraInstance.getSupportedPictureSizes();
        } catch (Exception e) {
            TELogUtils.w(TAG, "getSupportedPictureSizes, exception occured.", e);
            return null;
        }
    }

    public List<TEFrameSizei> getSupportedPreviewSizes(TECameraCapture tECameraCapture) {
        if (!assertClient(tECameraCapture) || this.mCameraInstance == null) {
            return null;
        }
        try {
            return this.mCameraInstance.getSupportedPreviewSizes();
        } catch (Exception e) {
            TELogUtils.w(TAG, "getSupportedPreviewSizes, exception occured.", e);
            return null;
        }
    }

    public boolean isAutoExposureLockSupported(TECameraCapture tECameraCapture) {
        if (!assertClient(tECameraCapture)) {
            return false;
        }
        synchronized (this.mStateLock) {
            if (this.mCurrentCameraState == 3 || this.mCurrentCameraState == 2) {
                return this.mCameraInstance.isAutoExposureLockSupported();
            }
            TELogUtils.w(TAG, "Can not get ae lock supported on state : " + this.mCurrentCameraState);
            return false;
        }
    }

    public boolean isAutoFocusLockSupported(TECameraCapture tECameraCapture) {
        if (!assertClient(tECameraCapture)) {
            return false;
        }
        synchronized (this.mStateLock) {
            if (this.mCurrentCameraState == 3 || this.mCurrentCameraState == 2) {
                return this.mCameraInstance.isAutoFocusLockSupported();
            }
            TELogUtils.w(TAG, "Can not get ae lock supported on state : " + this.mCurrentCameraState);
            return false;
        }
    }

    public boolean isCameraSwitchState() {
        return this.mIsCameraSwitchState;
    }

    public boolean isSupportWhileBalance(TECameraCapture tECameraCapture) {
        boolean z = false;
        if (!assertClient(tECameraCapture)) {
            return false;
        }
        synchronized (this.mStateLock) {
            if (this.mCameraInstance != null && this.mCameraInstance.isSupportWhileBalance()) {
                z = true;
            }
        }
        return z;
    }

    public boolean isSupportedExposureCompensation(TECameraCapture tECameraCapture) {
        if (!assertClient(tECameraCapture)) {
            return false;
        }
        if (this.mCurrentCameraState == 3 || this.mCurrentCameraState == 2) {
            return this.mCameraInstance.isSupportedExposureCompensation();
        }
        TELogUtils.w(TAG, "Can not set ec on state : " + this.mCurrentCameraState);
        return false;
    }

    public boolean isTorchSupported(TECameraCapture tECameraCapture) {
        TECameraBase tECameraBase;
        return assertClient(tECameraCapture) && (tECameraBase = this.mCameraInstance) != null && tECameraBase.isTorchSupported();
    }

    public void notifyHostForegroundVisible(TECameraCapture tECameraCapture, boolean z) {
        if (assertClient(tECameraCapture)) {
            this.mIsForegroundVisible = z;
            TELogUtils.i(TAG, "is foreground visible: " + z);
        }
    }

    public int process(final TECameraCapture tECameraCapture, final TECameraSettings.Operation operation) {
        if (!assertClient(tECameraCapture)) {
            return -108;
        }
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.29
                @Override // java.lang.Runnable
                public void run() {
                    TECameraServer.this.process(tECameraCapture, operation);
                }
            });
            return 0;
        }
        TELogUtils.i(TAG, "setFeatureParameters...");
        synchronized (this.mStateLock) {
            if (this.mCameraInstance != null) {
                this.mCameraInstance.process(operation);
            }
        }
        return 0;
    }

    public TECameraFrame processAlgorithm(TECameraFrame tECameraFrame) {
        if (this.mCameraInstance != null) {
            return this.mCameraInstance.processAlgorithm(tECameraFrame);
        }
        TELogUtils.e(TAG, "processAlgorithm failed mCameraInstance is null!");
        return null;
    }

    public void queryFeatures(String str, Bundle bundle) {
        if (this.mCameraInstance == null) {
            TELogUtils.e(TAG, "queryFeatures: camera instance null");
            return;
        }
        Bundle features = this.mCameraInstance.getFeatures(str);
        if (features == null) {
            TELogUtils.e(TAG, "queryFeatures: getFeatures is null");
            return;
        }
        for (String str2 : bundle.keySet()) {
            if (features.containsKey(str2)) {
                Class featureType = TECameraSettings.Features.getFeatureType(str2);
                if (featureType == Boolean.class) {
                    bundle.putBoolean(str2, features.getBoolean(str2));
                } else if (featureType == Integer.class) {
                    bundle.putInt(str2, features.getInt(str2));
                } else if (featureType == Long.class) {
                    bundle.putLong(str2, features.getLong(str2));
                } else if (featureType == Float.class) {
                    bundle.putFloat(str2, features.getFloat(str2));
                } else if (featureType == Double.class) {
                    bundle.putDouble(str2, features.getDouble(str2));
                } else if (featureType == String.class) {
                    bundle.putString(str2, features.getString(str2));
                } else if (featureType == ArrayList.class) {
                    bundle.putParcelableArrayList(str2, features.getParcelableArrayList(str2));
                } else if (featureType == TEFrameSizei.class) {
                    bundle.putParcelable(str2, features.getParcelable(str2));
                } else if (featureType == TEFocusParameters.class) {
                    bundle.putParcelable(str2, features.getParcelable(str2));
                } else {
                    TELogUtils.w(TAG, "Not supported key:" + str2);
                }
            }
        }
    }

    public float queryShaderZoomStep(final TECameraCapture tECameraCapture, final TECameraSettings.ShaderZoomCallback shaderZoomCallback) {
        if (!assertClient(tECameraCapture)) {
            return -108.0f;
        }
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.25
                @Override // java.lang.Runnable
                public void run() {
                    TECameraServer.this.queryShaderZoomStep(tECameraCapture, shaderZoomCallback);
                }
            });
            return 0.0f;
        }
        TELogUtils.i(TAG, "queryShaderZoomStep...");
        synchronized (this.mStateLock) {
            if (this.mCameraInstance != null) {
                this.mCameraInstance.queryShaderZoomStep(shaderZoomCallback);
            }
        }
        return 0.0f;
    }

    public int queryZoomAbility(final TECameraCapture tECameraCapture, final TECameraSettings.ZoomCallback zoomCallback, final boolean z) {
        if (!assertClient(tECameraCapture)) {
            return -108;
        }
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.24
                @Override // java.lang.Runnable
                public void run() {
                    TECameraServer.this.queryZoomAbility(tECameraCapture, zoomCallback, z);
                }
            });
            return 0;
        }
        TELogUtils.i(TAG, "queryZoomAbility...");
        synchronized (this.mStateLock) {
            if (this.mCameraInstance != null) {
                this.mCameraInstance.queryZoomAbility(zoomCallback, z);
            }
        }
        return 0;
    }

    public void registerFpsConfigListener(TECameraCapture.CameraFpsConfigCallback cameraFpsConfigCallback) {
        this.mFpsConfigCallback = cameraFpsConfigCallback;
    }

    public void registerPreviewSizeListener(TECameraCapture.PreviewSizeCallback previewSizeCallback) {
        this.mPreviewSizeCallback = previewSizeCallback;
    }

    public void removeCameraAlgorithm(int i) {
        if (this.mCameraInstance == null) {
            TELogUtils.e(TAG, "removeCameraAlgorithm failed mCameraInstance is null!");
        } else {
            this.mCameraInstance.removeCameraAlgorithm(i);
        }
    }

    public int removeCameraProvider(final TECameraCapture tECameraCapture) {
        if (!assertClient(tECameraCapture)) {
            return -108;
        }
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.6
                @Override // java.lang.Runnable
                public void run() {
                    TECameraServer.this.removeCameraProvider(tECameraCapture);
                }
            });
            return 0;
        }
        TELogUtils.i(TAG, "removeCameraProvider");
        synchronized (this.mStateLock) {
            this.mProviderManager.removeProvider();
        }
        return 0;
    }

    public void setAperture(final TECameraCapture tECameraCapture, final float f) {
        if (assertClient(tECameraCapture)) {
            if (Looper.myLooper() != this.mHandler.getLooper()) {
                this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.42
                    @Override // java.lang.Runnable
                    public void run() {
                        TECameraServer.this.setAperture(tECameraCapture, f);
                    }
                });
                return;
            }
            synchronized (this.mStateLock) {
                if (this.mCameraInstance != null) {
                    this.mCameraInstance.setAperture(f);
                }
            }
        }
    }

    public void setAutoExposureLock(final TECameraCapture tECameraCapture, final boolean z) {
        if (assertClient(tECameraCapture)) {
            if (Looper.myLooper() != this.mHandler.getLooper()) {
                this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.33
                    @Override // java.lang.Runnable
                    public void run() {
                        TECameraServer.this.setAutoExposureLock(tECameraCapture, z);
                    }
                });
                return;
            }
            TELogUtils.i(TAG, "setAutoExposureLock...");
            synchronized (this.mStateLock) {
                if (this.mCurrentCameraState == 3 || this.mCurrentCameraState == 2) {
                    this.mCameraInstance.setAutoExposureLock(z);
                    return;
                }
                this.mCameraObserver.onError(-105, "Can not set auto exposure lock on state : " + this.mCurrentCameraState);
            }
        }
    }

    public void setAutoFocusLock(final TECameraCapture tECameraCapture, final boolean z) {
        if (assertClient(tECameraCapture)) {
            if (Looper.myLooper() != this.mHandler.getLooper()) {
                this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.34
                    @Override // java.lang.Runnable
                    public void run() {
                        TECameraServer.this.setAutoFocusLock(tECameraCapture, z);
                    }
                });
                return;
            }
            TELogUtils.d(TAG, "setAutoExposureLock...");
            synchronized (this.mStateLock) {
                if (this.mCurrentCameraState == 3 || this.mCurrentCameraState == 2) {
                    this.mCameraInstance.setAutoFocusLock(z);
                    return;
                }
                this.mCameraObserver.onError(-105, "Can not set auto exposure lock on state : " + this.mCurrentCameraState);
            }
        }
    }

    public void setDeviceRotation(int i) {
        if (this.mCameraInstance != null) {
            this.mCameraInstance.setDeviceRotation(i);
        }
    }

    public void setExposureCompensation(TECameraCapture tECameraCapture, final int i) {
        Handler handler;
        if (!assertClient(tECameraCapture) || (handler = this.mHandler) == null) {
            TELogUtils.e(TAG, "setExposureCompensation failed");
        } else {
            handler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.30
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (TECameraServer.this.mStateLock) {
                        if (TECameraServer.this.mCameraInstance == null) {
                            return;
                        }
                        boolean exposureCompensation = TECameraServer.this.mCameraInstance.setExposureCompensation(i);
                        if (TECameraServer.this.mFirstEC && exposureCompensation) {
                            TECameraServer.this.mCameraEvent.onCameraInfo(115, 0, "exposure compensation", TECameraServer.this.mCameraInstance);
                            TECameraServer.this.mFirstEC = false;
                        }
                    }
                }
            });
        }
    }

    public int setFeatureParameters(final TECameraCapture tECameraCapture, final Bundle bundle) {
        if (!assertClient(tECameraCapture)) {
            return -108;
        }
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.28
                @Override // java.lang.Runnable
                public void run() {
                    TECameraServer.this.setFeatureParameters(tECameraCapture, bundle);
                }
            });
            return 0;
        }
        TELogUtils.i(TAG, "setFeatureParameters...");
        synchronized (this.mStateLock) {
            if (this.mCameraInstance != null) {
                this.mCameraInstance.setFeatureParameters(bundle);
            }
        }
        return 0;
    }

    public void setISO(final TECameraCapture tECameraCapture, final int i) {
        if (assertClient(tECameraCapture)) {
            if (Looper.myLooper() != this.mHandler.getLooper()) {
                this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.37
                    @Override // java.lang.Runnable
                    public void run() {
                        TECameraServer.this.setISO(tECameraCapture, i);
                    }
                });
                return;
            }
            synchronized (this.mStateLock) {
                if (this.mCameraInstance != null) {
                    this.mCameraInstance.setISO(i);
                }
            }
        }
    }

    public void setManualFocusDistance(final TECameraCapture tECameraCapture, final float f) {
        if (assertClient(tECameraCapture)) {
            if (Looper.myLooper() != this.mHandler.getLooper()) {
                this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.21
                    @Override // java.lang.Runnable
                    public void run() {
                        TECameraServer.this.setManualFocusDistance(tECameraCapture, f);
                    }
                });
                return;
            }
            synchronized (this.mStateLock) {
                if (this.mCameraInstance != null) {
                    this.mCameraInstance.setManualFocusDistance(f);
                }
            }
        }
    }

    public void setPictureSize(TECameraCapture tECameraCapture, final int i, final int i2) {
        if (assertClient(tECameraCapture)) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.22
                    @Override // java.lang.Runnable
                    public void run() {
                        if (TECameraServer.this.mCurrentCameraState == 3) {
                            TECameraServer.this.mCameraInstance.setPictureSize(i, i2);
                            return;
                        }
                        TELogUtils.e(TECameraServer.TAG, "set picture size failed, w: " + i + ", h: " + i2 + ", state: " + TECameraServer.this.mCurrentCameraState);
                    }
                });
                return;
            }
            return;
        }
        TELogUtils.w(TAG, "set picture size failed, w: " + i + ", h: " + i2);
    }

    public void setPreviewFpsRange(TEFrameRateRange tEFrameRateRange) {
        if (this.mCameraSettings == null || this.mCameraInstance == null) {
            return;
        }
        TECameraSettings tECameraSettings = this.mCameraSettings;
        tECameraSettings.mFPSRange = tEFrameRateRange;
        tECameraSettings.mCameraFrameRateStrategy = 1;
        if (tECameraSettings.mMode == 1) {
            tECameraSettings.mCameraFrameRateStrategy = 4;
            tECameraSettings.mOptCameraSceneFps = false;
        }
        this.mCameraInstance.setPreviewFpsRange();
    }

    public void setSATZoomCallback(TECameraSettings.SATZoomCallback sATZoomCallback) {
        this.mSATZoomCallback = sATZoomCallback;
    }

    public void setSceneMode(TECameraCapture tECameraCapture, final int i) {
        if (assertClient(tECameraCapture)) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.23
                    @Override // java.lang.Runnable
                    public void run() {
                        if (TECameraServer.this.mCameraInstance != null) {
                            TECameraServer.this.mCameraInstance.setSceneMode(i);
                        }
                    }
                });
                return;
            }
            return;
        }
        TELogUtils.w(TAG, "set scnen failed: " + i);
    }

    public void setShutterTime(final TECameraCapture tECameraCapture, final long j) {
        if (assertClient(tECameraCapture)) {
            if (Looper.myLooper() != this.mHandler.getLooper()) {
                this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.40
                    @Override // java.lang.Runnable
                    public void run() {
                        TECameraServer.this.setShutterTime(tECameraCapture, j);
                    }
                });
                return;
            }
            synchronized (this.mStateLock) {
                if (this.mCameraInstance != null) {
                    this.mCameraInstance.setShutterTime(j);
                }
            }
        }
    }

    public void setWhileBalance(final TECameraCapture tECameraCapture, final boolean z, final String str) {
        if (assertClient(tECameraCapture)) {
            if (Looper.myLooper() != this.mHandler.getLooper()) {
                this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.35
                    @Override // java.lang.Runnable
                    public void run() {
                        TECameraServer.this.setWhileBalance(tECameraCapture, z, str);
                    }
                });
                return;
            }
            synchronized (this.mStateLock) {
                TELogUtils.i(TAG, "setWhileBalance...");
                if (this.mCameraInstance != null) {
                    this.mCameraInstance.setWhileBalance(z, str);
                }
            }
        }
    }

    public int start(final TECameraCapture tECameraCapture) {
        TELogUtils.i(TAG, "start: client " + tECameraCapture);
        if (!assertClient(tECameraCapture)) {
            return -108;
        }
        TECameraSettings tECameraSettings = this.mCameraSettings;
        if (tECameraSettings == null || tECameraSettings.mContext == null) {
            TELogUtils.e(TAG, "mCameraSettings has some error");
            return -100;
        }
        Handler handler = this.mHandler;
        if (handler == null) {
            TELogUtils.e(TAG, "start, mHandler is null!");
            return TECameraResult.TER_INVALID_HANDLER;
        }
        if (Looper.myLooper() != handler.getLooper()) {
            handler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.7
                @Override // java.lang.Runnable
                public void run() {
                    TECameraServer.this.start(tECameraCapture);
                    if (TECameraServer.this.mCameraSettings.mUseSyncModeOnCamera2) {
                        TECameraServer.this.mCameraClientCondition.open();
                    }
                }
            });
            if (this.mCameraSettings.mUseSyncModeOnCamera2) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.mCameraClientCondition.close();
                this.mCameraClientCondition.block(2000L);
                TELogUtils.i(TAG, "Camera start cost: " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
            }
        } else {
            synchronized (this.mStateLock) {
                if (this.mCurrentCameraState == 3) {
                    TELogUtils.w(TAG, "start, no need to start capture, state: " + this.mCurrentCameraState);
                    if (!this.mIsCameraProviderChanged && !this.mStartPreviewError) {
                        return 0;
                    }
                    this.mCameraInstance.stopCapture();
                    updateCameraState(2);
                    this.mIsCameraProviderChanged = false;
                }
                if (this.mCurrentCameraState != 2) {
                    this.mCameraObserver.onError(-105, "Invalidate state: " + this.mCurrentCameraState + " ==> 3");
                    return -105;
                }
                this.mCameraObserver.onInfo(3, this.mCurrentCameraState, "Camera state: opened");
                this.mCameraInstance.startCapture();
                updateCameraState(3);
                TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_TYPE, this.mCameraInstance.getCameraType());
                TECameraMonitor.perfString(TECameraMonitor.TE_PREVIEW_CAMERA_RESOLUTION, this.mCameraSettings.mPreviewSize.width + "*" + this.mCameraSettings.mPreviewSize.height);
                TECameraMonitor.perfDouble(TECameraMonitor.TE_RECORD_CAMERA_FRAME_RATE, (double) this.mCameraSettings.mFPSRange.max);
                TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_DIRECTION, (long) this.mCameraSettings.mFacing);
            }
        }
        return 0;
    }

    public int startRecording() {
        return this.mCameraInstance.startRecording();
    }

    public int startZoom(TECameraCapture tECameraCapture, float f, TECameraSettings.ZoomCallback zoomCallback) {
        if (!assertClient(tECameraCapture)) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: START_ZOOM. Code: -108. Reason: invalid CameraClient");
            return -108;
        }
        Looper.myLooper();
        this.mHandler.getLooper();
        TECameraBase tECameraBase = this.mCameraInstance;
        if (tECameraBase == null) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: START_ZOOM. Code: -105. Reason: mCameraInstance is null");
            TELogUtils.w(TAG, "camera is null, no need to start zoom");
            return -105;
        }
        float fAbs = Math.abs(f - this.mCurrentZoom);
        if (Math.abs(f - tECameraBase.mMaxZoom) < 0.1f) {
            f = tECameraBase.mMaxZoom;
        } else if (Math.abs(f) < 0.1f) {
            f = 0.0f;
        } else if (fAbs < 0.1f) {
            return 0;
        }
        this.mCurrentZoom = f;
        Message messageCreateMessage = createMessage(1, true, this.mHandler);
        messageCreateMessage.arg1 = (int) (f * 100.0f);
        messageCreateMessage.obj = zoomCallback;
        this.mHandler.sendMessage(messageCreateMessage);
        return 0;
    }

    public int stop(final TECameraCapture tECameraCapture, final boolean z) {
        TELogUtils.i(TAG, "stop: client " + tECameraCapture);
        if (!assertClient(tECameraCapture)) {
            return -108;
        }
        Handler handler = this.mHandler;
        if (handler == null) {
            TELogUtils.e(TAG, "stop, mHandler is null!");
            return TECameraResult.TER_INVALID_HANDLER;
        }
        if (Looper.myLooper() != handler.getLooper()) {
            if (z) {
                this.mCameraClientCondition.close();
            }
            handler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.9
                @Override // java.lang.Runnable
                public void run() {
                    TECameraServer.this.stop(tECameraCapture, z);
                    if (z) {
                        TECameraServer.this.mCameraClientCondition.open();
                    }
                }
            });
            if (z && (!this.mCameraClientCondition.block(c.j))) {
                TELogUtils.e(TAG, "Camera stop timeout!");
            }
        } else {
            synchronized (this.mStateLock) {
                if (this.mCurrentCameraState == 2) {
                    TELogUtils.w(TAG, "stop, no need to stop capture, state: " + this.mCurrentCameraState);
                    return 0;
                }
                if (this.mCurrentCameraState != 3) {
                    this.mCameraObserver.onError(-105, "Invalidate state: " + this.mCurrentCameraState + " ==> 2");
                    return -105;
                }
                updateCameraState(2);
                this.mCameraInstance.stopCapture();
            }
        }
        return 0;
    }

    public int stopRecording() {
        return this.mCameraInstance.stopRecording();
    }

    public int stopZoom(final TECameraCapture tECameraCapture, final TECameraSettings.ZoomCallback zoomCallback) {
        if (!assertClient(tECameraCapture)) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: STOP_ZOOM. Code: -108. Reason: invalid CameraClient");
            return -108;
        }
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.26
                @Override // java.lang.Runnable
                public void run() {
                    TECameraServer.this.stopZoom(tECameraCapture, zoomCallback);
                }
            });
            return 0;
        }
        TELogUtils.i(TAG, "stopZoom...");
        synchronized (this.mStateLock) {
            if (this.mCameraInstance != null) {
                this.mCameraInstance.stopZoom(zoomCallback);
            }
        }
        return 0;
    }

    public int switchCamera(final TECameraCapture tECameraCapture, final int i, final Cert cert) {
        TELogUtils.i(TAG, "switchCamera: " + i);
        if (!assertClient(tECameraCapture)) {
            return -108;
        }
        TECameraSettings tECameraSettings = this.mCameraSettings;
        if (tECameraSettings == null) {
            TELogUtils.e(TAG, "switchCamera failed: " + i);
            return -108;
        }
        if (tECameraSettings.mFacing == i) {
            return TECameraResult.TER_CAMERA_DUPLICATE_OPERATION;
        }
        this.mIsCameraSwitchState = true;
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.11
                @Override // java.lang.Runnable
                public void run() {
                    TECameraServer.this.switchCamera(tECameraCapture, i, cert);
                }
            });
        } else {
            synchronized (this.mStateLock) {
                if (this.mCurrentCameraState == 1) {
                    this.mIsCameraSwitchState = false;
                    this.mCameraObserver.onError(-105, "Camera is opening, ignore this switch request.");
                    return -105;
                }
                this.mCameraSettings.mFacing = i;
                this.mCurrentZoom = 0.0f;
                if (this.mCameraInstance == null) {
                    this.mCameraInstance = createCameraInstance();
                    if (this.mCameraInstance == null) {
                        this.mCurrentCameraState = 0;
                        int i2 = this.mCameraSettings.mCameraType;
                        if (i2 == 11) {
                            this.mCameraEvent.onCameraOpened(i2, TECameraResult.TER_CAMERA_VENDOR_AUTH_FAILED, null, null);
                        } else {
                            this.mCameraObserver.onError(-100, "open : mCameraInstance is null.");
                        }
                        this.mIsCameraSwitchState = false;
                        return -1;
                    }
                }
                if (this.mCurrentCameraState != 0) {
                    updateCameraState(4);
                    this.mCameraInstance.close(cert);
                    updateCameraState(0);
                }
                updateCameraState(1);
                this.mIsCameraSwitchState = false;
                if (this.mRetryCnt < 0) {
                    this.mRetryCnt = this.mCameraSettings.mRetryCnt;
                }
                this.mBeginTime = System.currentTimeMillis();
                int iOpen = this.mCameraInstance.open(this.mCameraSettings, cert);
                if (iOpen != 0) {
                    this.mCameraObserver.onError(iOpen, "Switch camera failed @" + this.mCameraSettings.mCameraType + ",face:" + this.mCameraSettings.mFacing + " " + this.mCameraSettings.mPreviewSize.toString());
                }
            }
        }
        return 0;
    }

    public int switchCameraMode(final TECameraCapture tECameraCapture, final int i) {
        if (!assertClient(tECameraCapture)) {
            return -108;
        }
        TECameraSettings tECameraSettings = tECameraCapture.mCameraSettings;
        if (tECameraSettings.mCameraType == 1) {
            return -100;
        }
        if (i != 1 && i != 0 && i != 2) {
            return -100;
        }
        if (tECameraSettings.mMode == i) {
            return 0;
        }
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.4
                @Override // java.lang.Runnable
                public void run() {
                    TECameraServer.this.switchCameraMode(tECameraCapture, i);
                }
            });
        } else {
            TELogUtils.i(TAG, "switchCameraMode");
            synchronized (this.mStateLock) {
                if (this.mCurrentCameraState != 3) {
                    this.mCameraObserver.onError(-105, "Invalidate state: " + this.mCurrentCameraState + " ==> 3");
                    return -105;
                }
                this.mCameraInstance.switchCameraMode(i);
            }
        }
        return 0;
    }

    public int switchFlashMode(final TECameraCapture tECameraCapture, @TECameraSettings.FlashMode final int i) {
        if (!assertClient(tECameraCapture)) {
            return -108;
        }
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.44
                @Override // java.lang.Runnable
                public void run() {
                    TECameraServer.this.switchFlashMode(tECameraCapture, i);
                }
            });
            return 0;
        }
        TELogUtils.i(TAG, "switchFlashMode: " + i);
        synchronized (this.mStateLock) {
            if (this.mCameraInstance != null) {
                this.mCameraInstance.switchFlashMode(i);
                this.mCameraEvent.onCameraInfo(116, i, "", this.mCameraInstance);
            }
        }
        return 0;
    }

    public int takePicture(TECameraCapture tECameraCapture, final int i, final int i2, final TECameraSettings.PictureCallback pictureCallback) {
        if (!assertClient(tECameraCapture)) {
            return -108;
        }
        this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.15
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TECameraServer.this.mStateLock) {
                    if (TECameraServer.this.mCurrentCameraState == 3) {
                        if (TECameraServer.this.mCameraSettings.mCameraType == 1) {
                            TECameraServer.this.updateCameraState(2);
                        }
                        TECameraServer.this.mCameraInstance.takePicture(i, i2, pictureCallback);
                        return;
                    }
                    String str = "Can not takePicture on state : " + TECameraServer.this.mCurrentCameraState;
                    TECameraServer.this.mCameraObserver.onError(-105, str);
                    TELogUtils.e(TECameraServer.TAG, str);
                    TECameraSettings.PictureCallback pictureCallback2 = pictureCallback;
                    if (pictureCallback2 != null) {
                        pictureCallback2.onTakenFail(new Exception(str));
                    }
                }
            }
        });
        return 0;
    }

    public int toggleTorch(final TECameraCapture tECameraCapture, final boolean z) {
        if (!assertClient(tECameraCapture)) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: TOGGLE_TORCH. Code: -108. Reason: invalid CameraClient");
            return -108;
        }
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.43
                @Override // java.lang.Runnable
                public void run() {
                    TECameraServer.this.toggleTorch(tECameraCapture, z);
                }
            });
            return 0;
        }
        TELogUtils.i(TAG, "toggleTorch: " + z);
        synchronized (this.mStateLock) {
            if (this.mCameraInstance != null) {
                this.mCameraInstance.toggleTorch(z);
            }
        }
        return 0;
    }

    public void upExposureCompensation(final TECameraCapture tECameraCapture) {
        if (assertClient(tECameraCapture)) {
            if (Looper.myLooper() != this.mHandler.getLooper()) {
                this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.31
                    @Override // java.lang.Runnable
                    public void run() {
                        TECameraServer.this.upExposureCompensation(tECameraCapture);
                    }
                });
                return;
            }
            TELogUtils.i(TAG, "upExposureCompensation...");
            synchronized (this.mStateLock) {
                if (this.mCurrentCameraState == 3 || this.mCurrentCameraState == 2) {
                    TECameraSettings.ExposureCompensationInfo cameraECInfo = this.mCameraInstance.getCameraECInfo();
                    if (cameraECInfo == null) {
                        this.mCameraObserver.onError(TECameraResult.TER_INVALID_HANDLER, "upExposureCompensation get ec info failed");
                        return;
                    } else {
                        this.mCameraInstance.setExposureCompensation(cameraECInfo.exposure + 1);
                        return;
                    }
                }
                this.mCameraObserver.onError(-105, "Can not set ec on state : " + this.mCurrentCameraState);
            }
        }
    }

    public void updateCameraAlgorithmParam(TECameraAlgorithmParam tECameraAlgorithmParam) {
        if (this.mCameraInstance == null) {
            TELogUtils.e(TAG, "updateCameraAlgorithmParam failed mCameraInstance is null!");
        } else {
            this.mCameraInstance.updateCameraAlgorithmParam(tECameraAlgorithmParam);
        }
    }

    public void updateCameraState(int i) {
        if (this.mCurrentCameraState == i) {
            TELogUtils.w(TAG, "No need update state: " + i);
            return;
        }
        TELogUtils.i(TAG, "[updateCameraState]: " + this.mCurrentCameraState + " -> " + i);
        this.mCurrentCameraState = i;
    }

    public int zoomV2(final TECameraCapture tECameraCapture, final float f, final TECameraSettings.ZoomCallback zoomCallback) {
        if (!assertClient(tECameraCapture)) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: START_ZOOM. Code: -108. Reason: invalid CameraClient");
            return -108;
        }
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.27
                @Override // java.lang.Runnable
                public void run() {
                    TECameraServer.this.zoomV2(tECameraCapture, f, zoomCallback);
                }
            });
        } else {
            TELogUtils.i(TAG, "zoomV2...");
            synchronized (this.mStateLock) {
                if (this.mCameraInstance != null) {
                    this.mCameraInstance.zoomV2(f, zoomCallback);
                }
                if (this.mFirstZoom) {
                    this.mCameraEvent.onCameraInfo(114, 0, "zoomV2", this.mCameraInstance);
                    this.mFirstZoom = false;
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int close(final boolean z, final Cert cert) {
        Handler handler = this.mHandler;
        if (handler == null) {
            this.mCameraCloseTaskHandlerId = -1;
            updateCameraState(4);
            if (this.mCameraInstance != null) {
                TELogUtils.e(TAG, "call camera close process, handler is null");
                this.mCameraInstance.forceCloseCamera(this.cachedClosePrivacyCert);
                TELogUtils.w(TAG, "call camera close process, handler is null, force close done");
            }
            updateCameraState(0);
            return TECameraResult.TER_INVALID_HANDLER;
        }
        TELogUtils.i(TAG, "call camera close process...sync: " + z + ", handler: " + handler);
        if (this.mHandlerDestroyed || Looper.myLooper() == handler.getLooper()) {
            this.mCameraCloseTaskHandlerId = -1;
            if (this.mEnableVBoost) {
                this.mSystemResManager.startAction(new TESystemResManager.Action(TESystemResManager.ActionType.BOOST_CPU, this.mVBoostTimeoutMS));
                realCloseCamera(cert);
                this.mSystemResManager.startAction(new TESystemResManager.Action(TESystemResManager.ActionType.RESTORE_CPU));
            } else {
                realCloseCamera(cert);
            }
            this.mMainHandler.removeCallbacks(this.mCheckCloseTask);
            if (!z && decreaseClientCount() == 0) {
                return destroy();
            }
        } else {
            int iHashCode = handler.hashCode();
            int i = this.mCameraCloseTaskHandlerId;
            if (i != -1 && i != iHashCode) {
                this.mCameraCloseTaskHandlerId = -1;
                TELogUtils.e(TAG, "camera close task discard...handler id has changed");
                return 0;
            }
            this.mCameraCloseTaskHandlerId = iHashCode;
            final long jCurrentTimeMillis = System.currentTimeMillis();
            if (z) {
                this.mCameraClientCondition.close();
            }
            this.mIsCameraPendingClose = true;
            handler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.10
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    TELogUtils.i(TECameraServer.TAG, "Push close task cost: " + jCurrentTimeMillis2);
                    TECameraServer.this.close(z, cert);
                    TECameraServer.this.mIsCameraPendingClose = false;
                    if (z) {
                        TECameraServer.this.mCameraClientCondition.open();
                    }
                    long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                    TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_PUSH_CLOSE_TASK_TIME, jCurrentTimeMillis2);
                    TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_CLOSE_COST, jCurrentTimeMillis3);
                    TELogUtils.logMonitorInfo(TECameraMonitor.TE_RECORD_CAMERA_CLOSE_COST, Long.valueOf(jCurrentTimeMillis3));
                }
            });
            if (z) {
                boolean z2 = !this.mCameraClientCondition.block(c.j);
                this.mIsCameraPendingClose = false;
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                if (z2) {
                    this.mCameraCloseTaskHandlerId = -1;
                    TELogUtils.e(TAG, "Camera close timeout, mCurrentCameraState " + this.mCurrentCameraState);
                    updateCameraState(4);
                    if (this.mCameraInstance != null) {
                        this.mCameraInstance.forceCloseCamera(this.cachedClosePrivacyCert);
                    }
                    updateCameraState(0);
                } else {
                    TELogUtils.i(TAG, "Camera close cost: " + jCurrentTimeMillis2 + "ms");
                }
            }
        }
        return 0;
    }

    public int disConnect(TECameraCapture tECameraCapture, boolean z, Cert cert) {
        TELogUtils.i(TAG, "disConnect with client: " + tECameraCapture);
        this.mIsCameraSwitchState = false;
        synchronized (this.mLock) {
            TECameraCapture tECameraCapture2 = this.mCameraClient;
            if (tECameraCapture2 != tECameraCapture || tECameraCapture2 == null) {
                return -100;
            }
            this.mCameraClient = null;
            this.mHandler.removeCallbacksAndMessages(null);
            this.cachedClosePrivacyCert = cert;
            close(z, cert);
            if (!z) {
                setAsyncCloseCheckMsg();
            } else if (decreaseClientCount() == 0) {
                return destroy();
            }
            return 0;
        }
    }

    public int getCameraState(boolean z) {
        int i;
        if (!z) {
            return this.mCurrentCameraState;
        }
        synchronized (this.mStateLock) {
            i = this.mCurrentCameraState;
        }
        return i;
    }

    public int takePicture(TECameraCapture tECameraCapture, final TECameraSettings.PictureCallback pictureCallback) {
        if (!assertClient(tECameraCapture)) {
            return -108;
        }
        this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.16
            @Override // java.lang.Runnable
            public void run() {
                TELogUtils.i(TECameraServer.TAG, "takePicture");
                synchronized (TECameraServer.this.mStateLock) {
                    if (TECameraServer.this.mCurrentCameraState == 3) {
                        if (TECameraServer.this.mCameraSettings.mCameraType == 1) {
                            TECameraServer.this.updateCameraState(2);
                        }
                        TECameraServer.this.mCameraInstance.takePicture(pictureCallback);
                        return;
                    }
                    String str = "Can not takePicture on state : " + TECameraServer.this.mCurrentCameraState;
                    TECameraServer.this.mCameraObserver.onError(-105, str);
                    TELogUtils.e(TECameraServer.TAG, str);
                    TECameraSettings.PictureCallback pictureCallback2 = pictureCallback;
                    if (pictureCallback2 != null) {
                        pictureCallback2.onTakenFail(new Exception(str));
                    }
                }
            }
        });
        return 0;
    }

    public int stop(TECameraCapture tECameraCapture) {
        return stop(tECameraCapture, false);
    }

    public void changeCaptureFormat() {
    }

    public int switchCamera(final TECameraCapture tECameraCapture, final TECameraSettings tECameraSettings, final Cert cert) {
        TELogUtils.i(TAG, "switchCamera: " + tECameraSettings);
        if (!assertClient(tECameraCapture)) {
            return -108;
        }
        if (!shouldReOpenCamera(tECameraSettings)) {
            return TECameraResult.TER_CAMERA_DUPLICATE_OPERATION;
        }
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.ss.android.ttvecamera.TECameraServer.12
                @Override // java.lang.Runnable
                public void run() {
                    TECameraServer.this.switchCamera(tECameraCapture, tECameraSettings, cert);
                }
            });
        } else {
            synchronized (this.mStateLock) {
                if (onlySwitchSession(tECameraSettings)) {
                    return 0;
                }
                boolean z = this.mCameraSettings.mMode != tECameraSettings.mMode;
                if (this.mCurrentCameraState == 1 && !z) {
                    this.mCameraObserver.onError(-105, "Camera is opening, ignore this switch request...");
                    TELogUtils.i(TAG, "Camera is opening, ignore this switch request...");
                    return -105;
                }
                TECameraSettings tECameraSettings2 = this.mCameraSettings;
                if (tECameraSettings2.mCameraType == tECameraSettings.mCameraType && tECameraSettings2.mMode == tECameraSettings.mMode) {
                    if (this.mCameraInstance == null) {
                        TELogUtils.i(TAG, "switch camera, create instance...");
                        this.mCameraInstance = createCameraInstance();
                        if (this.mCameraInstance == null) {
                            this.mCurrentCameraState = 0;
                            int i = this.mCameraSettings.mCameraType;
                            if (i == 11) {
                                this.mCameraEvent.onCameraOpened(i, TECameraResult.TER_CAMERA_VENDOR_AUTH_FAILED, null, null);
                            } else {
                                this.mCameraObserver.onError(-100, "open : mCameraInstance is null.");
                            }
                            return -1;
                        }
                        this.mCameraInstance.setSATZoomCallback(this.satZoomCallback);
                    }
                    if (this.mCurrentCameraState != 0) {
                        updateCameraState(4);
                        this.mCameraInstance.close(cert);
                        updateCameraState(0);
                    }
                    this.mCameraSettings = tECameraSettings;
                    this.mCurrentZoom = 0.0f;
                    updateCameraState(1);
                    if (this.mRetryCnt < 0) {
                        this.mRetryCnt = this.mCameraSettings.mRetryCnt;
                    }
                    this.mBeginTime = System.currentTimeMillis();
                    TELogUtils.d(TAG, "switch mode = " + this.mCameraSettings.mMode);
                    int iOpen = this.mCameraInstance.open(this.mCameraSettings, cert);
                    if (iOpen != 0) {
                        this.mCameraObserver.onError(iOpen, "Switch camera failed @" + this.mCameraSettings.mCameraType + ",face:" + this.mCameraSettings.mFacing + " " + this.mCameraSettings.mPreviewSize.toString());
                    }
                    return 0;
                }
                close(cert);
                open(tECameraCapture, tECameraSettings, cert);
            }
        }
        return 0;
    }
}
