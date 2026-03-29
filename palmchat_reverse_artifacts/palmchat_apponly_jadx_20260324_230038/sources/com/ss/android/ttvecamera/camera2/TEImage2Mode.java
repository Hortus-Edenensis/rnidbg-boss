package com.ss.android.ttvecamera.camera2;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.SessionConfiguration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.ss.android.ttvecamera.TECamera2;
import com.ss.android.ttvecamera.TECameraFrame;
import com.ss.android.ttvecamera.TECameraMonitor;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ttvecamera.TEFocusSettings;
import com.ss.android.ttvecamera.TEFrameSizei;
import com.ss.android.ttvecamera.TELogUtils;
import com.ss.android.ttvecamera.TEPlane;
import com.ss.android.ttvecamera.TETraceUtils;
import com.ss.android.ttvecamera.focusmanager.TEImageFocus;
import com.ss.android.ttvecamera.focusmanager.TEImageFocusAndMeterStrategy;
import com.ss.android.ttvecamera.framework.TECameraModeBase;
import com.ss.android.ttvecamera.hardware.TECameraHardware2Proxy;
import com.ss.android.ttvecamera.model.BurstRequest;
import com.ss.android.ttvecamera.provider.TECameraProviderManager;
import defpackage.cs5;
import defpackage.ds5;
import defpackage.es5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@TargetApi(21)
public class TEImage2Mode extends TECameraModeBase {
    private static final long AF_AE_CONVERGE_TIME_OUT_MS_FOR_FLASH_OFF = 800;
    private static final long AF_AE_CONVERGE_TIME_OUT_MS_FOR_FLASH_ON = 1600;
    private static final String CAPTURE_REQUEST_TAG_FOR_SHOT = "CAPTURE_REQUEST_TAG_FOR_SHOT";
    private static final int FPS_MAX_LIMIT_DEFAULT = 30;
    private static final int FPS_MIN_LIMIT_DEFAULT = 5;
    private static final int MSG_AF_AE_CONVERGE_TIME_OUT = 1001;
    private static final int MSG_AF_AE_CONVERGE_TIME_OUT_OLD = 1007;
    private static final int MSG_CANCEL_AF_TRIGGER = 1005;
    private static final int MSG_CAPTURE = 1000;
    private static final int MSG_CAPTURE_FAILED = 1003;
    private static final int MSG_CAPTURE_OLD = 1006;
    private static final int MSG_RESET_PREVIEW_AFTER_FLASH_CAPTURE = 1002;
    private static final int MSG_UPDATE_PREVIEW = 1004;
    private static final int STATE_PREVIEW = 0;
    private static final int STATE_WAITING_AF_AE_CONVERGE_FOR_CAPTURE = 2;
    private static final int STATE_WAITING_CAPTURE = 1;
    public static final String TAG = "TEImage2Mode";
    private static final int ZSL_MAX_CACHE_META_DATA = 5;
    private static final int ZSL_MAX_WIDTH_LIMIT = 4096;
    private boolean isAEPreCaptureTriggerStart;
    private List<CaptureRequest.Key<?>> mAvailableSessionKeys;
    private TECameraSettings.PictureCallback mCallback;
    private int mCameraFacing;
    private TECameraSettings.CaptureBufferFrameCallback mCaptureBufferFrameCallback;
    private TotalCaptureResult mCaptureResultCache;
    private long mCaptureStartTimestamp;
    private ConditionVariable mConditionVariable;
    private int mCountCaptureFrame;
    private int mCurrentCameraScene;
    private int mCurrentFlashMode;
    private int mCurrentZslMetadataCacheIndex;
    private int mEnableGcForCameraMetadataThreshold;
    private long mFrameArrivedTimestamp;
    private int mFrameCountPerSec;
    private final HandlerHelper mHandHelper;
    protected ImageReader mImageReader;
    private boolean mIsAfConvergeOnPreview;
    private volatile boolean mIsCanUseZslBufferForCapture;
    private boolean mIsShotCanDoOnAfAeConverge;
    private int mState;
    private boolean mSupportAutoFocus;
    private final Handler mUiHandler;
    private long mWaitingAfAeConvergeStartTimestamp;
    private TotalCaptureResult[] mZslBufferMetadataCache;
    protected ImageReader mZslImageReader;

    /* JADX INFO: compiled from: SearchBox */
    public class HandlerHelper extends Handler {
        public HandlerHelper(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            super.dispatchMessage(message);
            TELogUtils.i(TEImage2Mode.TAG, "dispatch msg = " + message.what);
            switch (message.what) {
                case 1000:
                case 1001:
                    TEImage2Mode.this.doCaptureOnReady();
                    break;
                case 1002:
                    TEImage2Mode.this.resetPreviewAfterFlashCapture();
                    break;
                case 1003:
                    TEImage2Mode.this.onCaptureFailed((Exception) message.obj, -1000);
                    break;
                case 1004:
                    TEImage2Mode tEImage2Mode = TEImage2Mode.this;
                    tEImage2Mode.updatePreview(((TECameraModeBase) tEImage2Mode).mCaptureRequestBuilder);
                    break;
                case 1005:
                    TEImage2Mode.this.cancelAFTrigger();
                    break;
                case 1006:
                case 1007:
                    TEImage2Mode.this.captureStillPicture();
                    break;
            }
        }
    }

    public TEImage2Mode(TECamera2 tECamera2, Context context, CameraManager cameraManager, Handler handler) {
        super(tECamera2, context, handler);
        this.mWaitingAfAeConvergeStartTimestamp = 0L;
        this.mUiHandler = new Handler(Looper.getMainLooper());
        this.mZslImageReader = null;
        this.mCurrentZslMetadataCacheIndex = -1;
        this.mCaptureResultCache = null;
        this.mIsCanUseZslBufferForCapture = false;
        this.mAvailableSessionKeys = null;
        this.mState = 0;
        this.mSupportAutoFocus = false;
        this.isAEPreCaptureTriggerStart = false;
        this.mIsShotCanDoOnAfAeConverge = false;
        this.mIsAfConvergeOnPreview = false;
        this.mCountCaptureFrame = 0;
        this.mEnableGcForCameraMetadataThreshold = 0;
        this.mCaptureStartTimestamp = 0L;
        this.mConditionVariable = null;
        this.mCurrentFlashMode = -1;
        this.mCurrentCameraScene = 0;
        this.mCaptureBufferFrameCallback = null;
        this.mFrameCountPerSec = 0;
        this.mFrameArrivedTimestamp = 0L;
        this.mCameraManager = cameraManager;
        if (this.mCameraSettings.mEnableRefactorFocusAndMeter) {
            this.mFocusStrategy = new TEImageFocusAndMeterStrategy(this);
        } else {
            this.mFocusStrategy = new TEImageFocus(this);
        }
        this.mHandHelper = new HandlerHelper(handler.getLooper());
        initPreviewCaptureCallback();
    }

    public static /* synthetic */ int access$1408(TEImage2Mode tEImage2Mode) {
        int i = tEImage2Mode.mCountCaptureFrame;
        tEImage2Mode.mCountCaptureFrame = i + 1;
        return i;
    }

    public static /* synthetic */ int access$1608(TEImage2Mode tEImage2Mode) {
        int i = tEImage2Mode.mCurrentZslMetadataCacheIndex;
        tEImage2Mode.mCurrentZslMetadataCacheIndex = i + 1;
        return i;
    }

    public static /* synthetic */ int access$808(TEImage2Mode tEImage2Mode) {
        int i = tEImage2Mode.mFrameCountPerSec;
        tEImage2Mode.mFrameCountPerSec = i + 1;
        return i;
    }

    private void applyCaptureScene() {
        CameraCharacteristics cameraCharacteristics;
        if (this.mCameraSettings.mOptCameraSceneFps && (cameraCharacteristics = this.mCameraCharacteristics) != null) {
            Range<Integer> maxDistanceFpsRange = getMaxDistanceFpsRange((Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
            CaptureRequest.Builder builder = this.mCaptureRequestBuilder;
            if (builder != null && maxDistanceFpsRange != null) {
                builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, maxDistanceFpsRange);
                updatePreview(this.mCaptureRequestBuilder);
                TELogUtils.i(TAG, "apply capture scene: " + maxDistanceFpsRange);
            }
        }
        attachZslBuffer();
    }

    private void applyRecordScene() {
        CameraCharacteristics cameraCharacteristics;
        if (this.mCameraSettings.mOptCameraSceneFps && (cameraCharacteristics = this.mCameraCharacteristics) != null) {
            Range<Integer> maxFixFpsRange = getMaxFixFpsRange((Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
            CaptureRequest.Builder builder = this.mCaptureRequestBuilder;
            if (builder != null && maxFixFpsRange != null) {
                builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, maxFixFpsRange);
                updatePreview(this.mCaptureRequestBuilder);
                TELogUtils.i(TAG, "apply record scene: " + maxFixFpsRange);
            }
        }
        detachZslBuffer();
    }

    private void attachZslBuffer() {
        Surface surface;
        ImageReader imageReader = this.mZslImageReader;
        if (imageReader == null || (surface = imageReader.getSurface()) == null || !surface.isValid()) {
            return;
        }
        CaptureRequest.Builder builder = this.mCaptureRequestBuilder;
        if (builder != null) {
            try {
                builder.removeTarget(surface);
                this.mCaptureRequestBuilder.addTarget(surface);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        updatePreview(this.mCaptureRequestBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void captureStillPicture() {
        this.mCaptureStartTimestamp = System.currentTimeMillis();
        this.mState = 0;
        CaptureRequest.Builder builderCreateCaptureRequestBuilder = createCaptureRequestBuilder(2);
        if (builderCreateCaptureRequestBuilder == null) {
            onCaptureFailed(new Exception("capture build is null"), -1001);
            return;
        }
        ImageReader imageReader = this.mImageReader;
        if (imageReader == null) {
            onCaptureFailed(new Exception("image reader is null"), -1001);
            return;
        }
        builderCreateCaptureRequestBuilder.addTarget(imageReader.getSurface());
        syncPreviewParam(builderCreateCaptureRequestBuilder);
        TECameraModeBase.Response responseCapture = capture(builderCreateCaptureRequestBuilder, new CameraCaptureSession.CaptureCallback() { // from class: com.ss.android.ttvecamera.camera2.TEImage2Mode.3
            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
                if (((TECameraModeBase) TEImage2Mode.this).mCaptureRequestBuilder == null) {
                    return;
                }
                TEImage2Mode.this.mCaptureResultCache = totalCaptureResult;
                Integer num = (Integer) ((TECameraModeBase) TEImage2Mode.this).mCaptureRequestBuilder.get(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER);
                Integer num2 = (Integer) ((TECameraModeBase) TEImage2Mode.this).mCaptureRequestBuilder.get(CaptureRequest.CONTROL_AF_TRIGGER);
                if ((num != null && num.intValue() == 1) || (num2 != null && num2.intValue() == 1)) {
                    TELogUtils.i(TEImage2Mode.TAG, "need cancel ae af trigger");
                    if (Build.VERSION.SDK_INT >= 23) {
                        ((TECameraModeBase) TEImage2Mode.this).mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 2);
                    }
                    ((TECameraModeBase) TEImage2Mode.this).mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                    TEImage2Mode tEImage2Mode = TEImage2Mode.this;
                    TECameraModeBase.Response responseCapture2 = tEImage2Mode.capture(((TECameraModeBase) tEImage2Mode).mCaptureRequestBuilder, (CameraCaptureSession.CaptureCallback) null, (Handler) null);
                    if (!responseCapture2.isSuccess()) {
                        TELogUtils.w(TEImage2Mode.TAG, "onCaptureSequenceCompleted: error = " + responseCapture2.getErrMsg());
                        return;
                    }
                    ((TECameraModeBase) TEImage2Mode.this).mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 0);
                    ((TECameraModeBase) TEImage2Mode.this).mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
                }
                TEImage2Mode tEImage2Mode2 = TEImage2Mode.this;
                tEImage2Mode2.updatePreview(((TECameraModeBase) tEImage2Mode2).mCaptureRequestBuilder);
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
                super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                TELogUtils.e(TEImage2Mode.TAG, "captureStillPicture, capture failed");
                if (((TECameraModeBase) TEImage2Mode.this).mCameraSettings.mEnableYuvBufferCapture) {
                    ((TECameraModeBase) TEImage2Mode.this).mCameraSettings.mEnableYuvBufferCapture = false;
                }
                if (((TECameraModeBase) TEImage2Mode.this).mCameraSettings.mEnableCamera2Zsl) {
                    ((TECameraModeBase) TEImage2Mode.this).mCameraSettings.mEnableCamera2Zsl = false;
                }
                TEImage2Mode.this.mHandHelper.sendMessage(TEImage2Mode.this.mHandHelper.obtainMessage(1003, new Exception("Capture failed: " + captureFailure.getReason())));
                TEImage2Mode.this.mHandHelper.sendEmptyMessage(1002);
            }
        }, this.mHandler);
        if (responseCapture.isSuccess()) {
            return;
        }
        onCaptureFailed(responseCapture.getException(), -1001);
    }

    private void detachZslBuffer() {
        Surface surface;
        ImageReader imageReader = this.mZslImageReader;
        if (imageReader == null || (surface = imageReader.getSurface()) == null || !surface.isValid()) {
            return;
        }
        CaptureRequest.Builder builder = this.mCaptureRequestBuilder;
        if (builder != null) {
            try {
                builder.removeTarget(surface);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        updatePreview(this.mCaptureRequestBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCaptureOnReady() {
        this.mCaptureStartTimestamp = System.currentTimeMillis();
        this.mState = 0;
        CaptureRequest.Builder builderCreateCaptureRequestBuilder = createCaptureRequestBuilder(2);
        if (builderCreateCaptureRequestBuilder == null) {
            onCaptureFailed(new Exception("capture build is null"), -1001);
            return;
        }
        ImageReader imageReader = this.mImageReader;
        if (imageReader == null) {
            onCaptureFailed(new Exception("image reader is null"), -1001);
            return;
        }
        builderCreateCaptureRequestBuilder.addTarget(imageReader.getSurface());
        syncPreviewParam(builderCreateCaptureRequestBuilder);
        TECameraModeBase.Response responseCapture = capture(builderCreateCaptureRequestBuilder, new CameraCaptureSession.CaptureCallback() { // from class: com.ss.android.ttvecamera.camera2.TEImage2Mode.4
            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
                TELogUtils.d(TEImage2Mode.TAG, "onCaptureCompleted, do capture done");
                TEImage2Mode.this.mHandHelper.sendEmptyMessage(1002);
                TEImage2Mode.this.mCaptureResultCache = totalCaptureResult;
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
                TELogUtils.e(TEImage2Mode.TAG, "onCaptureCompleted, do capture failed");
                if (((TECameraModeBase) TEImage2Mode.this).mCameraSettings.mEnableYuvBufferCapture) {
                    ((TECameraModeBase) TEImage2Mode.this).mCameraSettings.mEnableYuvBufferCapture = false;
                }
                if (((TECameraModeBase) TEImage2Mode.this).mCameraSettings.mEnableCamera2Zsl) {
                    ((TECameraModeBase) TEImage2Mode.this).mCameraSettings.mEnableCamera2Zsl = false;
                }
                TEImage2Mode.this.mHandHelper.sendMessage(TEImage2Mode.this.mHandHelper.obtainMessage(1003, new Exception("Capture failed: " + captureFailure.getReason())));
                TEImage2Mode.this.mHandHelper.sendEmptyMessage(1002);
            }
        }, (Handler) null);
        if (responseCapture.isSuccess()) {
            return;
        }
        onCaptureFailed(responseCapture.getException(), -1001);
    }

    private Range<Integer> getMaxDistanceFpsRange(Range<Integer>[] rangeArr) {
        int i;
        int i2;
        Range<Integer> range = null;
        if (rangeArr != null) {
            TECameraSettings tECameraSettings = this.mCameraSettings;
            if (tECameraSettings == null || (i = tECameraSettings.mFpsMaxLimit) < 30) {
                i = 30;
            }
            int i3 = 0;
            int i4 = 0;
            for (Range<Integer> range2 : rangeArr) {
                TELogUtils.d(TAG, "fps: " + range2.toString());
                int iIntValue = ((Integer) range2.getUpper()).intValue();
                int iIntValue2 = ((Integer) range2.getLower()).intValue();
                if (iIntValue2 < 5) {
                    TELogUtils.i(TAG, "discard fps: " + range2.toString());
                } else {
                    if (iIntValue > i3) {
                        i3 = iIntValue;
                    }
                    if (iIntValue <= i && (i2 = iIntValue - iIntValue2) > i4) {
                        range = range2;
                        i4 = i2;
                    }
                }
            }
            if (i3 > 30) {
                TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_MAX_FPS, i3);
            }
        }
        return range;
    }

    private Range<Integer> getMaxFixFpsRange(Range<Integer>[] rangeArr) {
        int i;
        Range<Integer> range = null;
        if (rangeArr != null) {
            TECameraSettings tECameraSettings = this.mCameraSettings;
            int i2 = 30;
            if (tECameraSettings != null && (i = tECameraSettings.mFpsMaxLimit) >= 30) {
                i2 = i;
            }
            int i3 = 0;
            int i4 = 0;
            for (Range<Integer> range2 : rangeArr) {
                TELogUtils.d(TAG, "fps: " + range2.toString());
                int iIntValue = ((Integer) range2.getUpper()).intValue();
                if (iIntValue > i3) {
                    i3 = iIntValue;
                }
                if (iIntValue <= i2 && iIntValue == ((Integer) range2.getLower()).intValue() && iIntValue > i4) {
                    range = range2;
                    i4 = iIntValue;
                }
            }
        }
        return range;
    }

    private void initPreviewCaptureCallback() {
        this.mPreviewCaptureCallback = new CameraCaptureSession.CaptureCallback() { // from class: com.ss.android.ttvecamera.camera2.TEImage2Mode.1
            private Integer mAfMode = -1;
            private Integer mAfState = -1;
            private Integer mAeMode = -1;
            private Integer mAeState = -1;

            private void process(CaptureResult captureResult) {
                Integer num;
                int i = TEImage2Mode.this.mState;
                boolean z = true;
                if (i == 0) {
                    Integer num2 = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
                    Integer numValueOf = Integer.valueOf(num2 != null ? num2.intValue() : -1);
                    TEImage2Mode.this.mIsAfConvergeOnPreview = numValueOf.intValue() == -1 || numValueOf.intValue() == 2 || numValueOf.intValue() == 4;
                    CaptureRequest.Builder builder = ((TECameraModeBase) TEImage2Mode.this).mCaptureRequestBuilder;
                    if (builder == null || (num = (Integer) builder.get(CaptureRequest.CONTROL_AF_TRIGGER)) == null || num.intValue() != 1) {
                        return;
                    }
                    if (4 == numValueOf.intValue() || 5 == numValueOf.intValue() || -1 == numValueOf.intValue()) {
                        builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                        if (TEImage2Mode.this.mHandHelper != null) {
                            TEImage2Mode.this.mHandHelper.sendEmptyMessage(1004);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i != 1) {
                    return;
                }
                Integer num3 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER);
                Integer num4 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num3 != null && num3.intValue() == 1) {
                    TEImage2Mode.this.isAEPreCaptureTriggerStart = true;
                    TELogUtils.i(TEImage2Mode.TAG, "ae trigger start...");
                }
                if (TEImage2Mode.this.isAEPreCaptureTriggerStart) {
                    if (num4 == null || num4.intValue() == 2 || num4.intValue() == 4) {
                        TEImage2Mode.this.isAEPreCaptureTriggerStart = false;
                        TELogUtils.i(TEImage2Mode.TAG, "ae converge, is shot can do");
                    } else {
                        z = false;
                    }
                    if (!this.mAeState.equals(num4)) {
                        TELogUtils.i(TEImage2Mode.TAG, "ae state:" + num4);
                    }
                    this.mAeState = num4;
                } else {
                    z = false;
                }
                if (z) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - TEImage2Mode.this.mWaitingAfAeConvergeStartTimestamp;
                    TEImage2Mode.this.mState = 0;
                    TEImage2Mode.this.isAEPreCaptureTriggerStart = false;
                    if (TEImage2Mode.this.mHandHelper != null) {
                        TEImage2Mode.this.mHandHelper.removeMessages(1007);
                        TEImage2Mode.this.mHandHelper.sendEmptyMessage(1006);
                        TEImage2Mode.this.mHandHelper.sendEmptyMessage(1005);
                    }
                    TELogUtils.i(TEImage2Mode.TAG, "send-capture-command consume = " + jCurrentTimeMillis);
                }
            }

            private void processForCaptureOnAeAfConverge(CaptureResult captureResult) {
                Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_MODE);
                Integer num2 = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
                Integer num3 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_MODE);
                Integer num4 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : -1);
                Integer numValueOf2 = Integer.valueOf(num2 != null ? num2.intValue() : -1);
                Integer numValueOf3 = Integer.valueOf(num3 != null ? num3.intValue() : -1);
                Integer numValueOf4 = Integer.valueOf(num4 != null ? num4.intValue() : -1);
                if (!this.mAfMode.equals(numValueOf) || !this.mAfState.equals(numValueOf2) || !this.mAeMode.equals(numValueOf3) || !this.mAeState.equals(numValueOf4)) {
                    TELogUtils.d(TEImage2Mode.TAG, "[afMode=" + numValueOf + ", afState=" + numValueOf2 + ",aeMode=" + numValueOf3 + ", aeState=" + numValueOf4 + "]");
                }
                this.mAfMode = numValueOf;
                this.mAfState = numValueOf2;
                this.mAeMode = numValueOf3;
                this.mAeState = numValueOf4;
                boolean z = true;
                if (TEImage2Mode.CAPTURE_REQUEST_TAG_FOR_SHOT.equals(captureResult.getRequest().getTag())) {
                    TEImage2Mode.this.mIsShotCanDoOnAfAeConverge = true;
                    TELogUtils.i(TEImage2Mode.TAG, "is shot can do");
                }
                if (!TEImage2Mode.this.mIsShotCanDoOnAfAeConverge) {
                    TELogUtils.d(TEImage2Mode.TAG, "discard previous callback");
                    return;
                }
                if (numValueOf2.intValue() == -1 || numValueOf2.intValue() == 4 || numValueOf2.intValue() == 5 || numValueOf2.intValue() == 2) {
                    if (numValueOf4.intValue() != -1 && numValueOf4.intValue() != 4 && numValueOf4.intValue() != 2) {
                        z = false;
                    }
                    if (z) {
                        long jCurrentTimeMillis = System.currentTimeMillis() - TEImage2Mode.this.mWaitingAfAeConvergeStartTimestamp;
                        TEImage2Mode.this.mHandHelper.removeMessages(1001);
                        TEImage2Mode.this.mHandHelper.sendEmptyMessage(1000);
                        TEImage2Mode.this.mIsShotCanDoOnAfAeConverge = false;
                        TELogUtils.i(TEImage2Mode.TAG, "send-capture-command consume = " + jCurrentTimeMillis);
                        TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_SEND_CAPTURE_COMMAND_COST, jCurrentTimeMillis);
                    }
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureBufferLost(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Surface surface, long j) {
                if (TEImage2Mode.this.mState == 2 && TEImage2Mode.CAPTURE_REQUEST_TAG_FOR_SHOT.equals(captureRequest.getTag())) {
                    TEImage2Mode.this.mIsShotCanDoOnAfAeConverge = true;
                    TELogUtils.e(TEImage2Mode.TAG, "onCaptureBufferLost: ");
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - TEImage2Mode.this.mFrameArrivedTimestamp > 1000) {
                    TELogUtils.d(TEImage2Mode.TAG, "on frame arrived fps: " + TEImage2Mode.this.mFrameCountPerSec);
                    TEImage2Mode.this.mFrameCountPerSec = 0;
                    TEImage2Mode.this.mFrameArrivedTimestamp = jCurrentTimeMillis;
                } else {
                    TEImage2Mode.access$808(TEImage2Mode.this);
                }
                process(totalCaptureResult);
                if (!((TECameraModeBase) TEImage2Mode.this).mIsFirstPreviewFrameArrived) {
                    TEImage2Mode.this.openCameraLock();
                    ((TECameraModeBase) TEImage2Mode.this).mIsFirstPreviewFrameArrived = true;
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - ((TECameraModeBase) TEImage2Mode.this).mFirstRepeatingRequestStartTimestamp;
                    TELogUtils.i(TEImage2Mode.TAG, "first preview frame callback arrived! consume = " + jCurrentTimeMillis2 + ", session consume: " + ((TECameraModeBase) TEImage2Mode.this).mCreateSessionConsume);
                    TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_2_SET_REPEATING_REQUEST_COST, jCurrentTimeMillis2);
                    TELogUtils.logMonitorInfo(TECameraMonitor.TE_RECORD_CAMERA_2_SET_REPEATING_REQUEST_COST, Long.valueOf(jCurrentTimeMillis2));
                }
                if (TEImage2Mode.this.mState == 2) {
                    processForCaptureOnAeAfConverge(totalCaptureResult);
                }
                TEImage2Mode.access$1408(TEImage2Mode.this);
                if (TEImage2Mode.this.mEnableGcForCameraMetadataThreshold != 0 && TEImage2Mode.this.mCountCaptureFrame > TEImage2Mode.this.mEnableGcForCameraMetadataThreshold) {
                    TEImage2Mode.this.mCountCaptureFrame = 0;
                    Runtime.getRuntime().gc();
                }
                TEImage2Mode.access$1608(TEImage2Mode.this);
                if (TEImage2Mode.this.mCurrentZslMetadataCacheIndex % 5 == 0) {
                    TEImage2Mode.this.mCurrentZslMetadataCacheIndex = 0;
                }
                if (TEImage2Mode.this.mZslBufferMetadataCache != null) {
                    TEImage2Mode.this.mZslBufferMetadataCache[TEImage2Mode.this.mCurrentZslMetadataCacheIndex] = totalCaptureResult;
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
                if (TEImage2Mode.this.mState == 2 && TEImage2Mode.CAPTURE_REQUEST_TAG_FOR_SHOT.equals(captureRequest.getTag())) {
                    TEImage2Mode.this.mIsShotCanDoOnAfAeConverge = true;
                    TELogUtils.e(TEImage2Mode.TAG, "onCaptureFailed: ");
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
                process(captureResult);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCaptureFailed(Exception exc, int i) {
        if (this.mCallback != null) {
            TECamera2 tECamera2 = this.mCameraHolder;
            if (tECamera2 != null) {
                exc = tECamera2.createException(exc, i);
            }
            this.mCallback.onTakenFail(exc);
        }
        this.mState = 0;
        TELogUtils.w(TAG, "onCaptureFailed, err = " + exc + ", errCode = " + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processCaptureFrame(Image image, TotalCaptureResult totalCaptureResult) {
        int width = image.getWidth();
        int height = image.getHeight();
        int i = this.mCameraFacing == 1 ? 270 : 90;
        TELogUtils.i(TAG, "on image available, consume: " + (System.currentTimeMillis() - this.mCaptureStartTimestamp) + ", size: " + width + "x" + height + ", format: " + image.getFormat() + ", rotation: " + i);
        if (this.mCallback != null) {
            TECameraFrame tECameraFrame = new TECameraFrame(new TEPlane(image.getPlanes()), image.getFormat() == 256 ? TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_JPEG : TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_YUV420, width, height, i);
            if (image.getFormat() == 35) {
                TECameraFrame.Metadata metadata = new TECameraFrame.Metadata();
                metadata.timestamp = System.currentTimeMillis();
                metadata.captureResult = totalCaptureResult;
                tECameraFrame.setMetadata(metadata);
                byte[] bArr = new byte[((width * height) * 3) / 2];
                if (TECameraUtils.imageToNV21(image, bArr)) {
                    tECameraFrame = new TECameraFrame(bArr, TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_NV21, width, height, i);
                } else {
                    TELogUtils.w(TAG, "convert nv21 failed");
                }
            }
            this.mCallback.onPictureTaken(tECameraFrame, this.mCameraHolder);
        }
        if (this.mCaptureBufferFrameCallback != null) {
            byte[] bArr2 = new byte[((width * height) * 3) / 2];
            if (TECameraUtils.imageToNV21(image, bArr2)) {
                this.mCaptureBufferFrameCallback.onBufferFrameArrived(width, height, i, bArr2);
            } else {
                this.mCaptureBufferFrameCallback.onBufferFrameArrived(width, height, i, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetPreviewAfterFlashCapture() {
        TECameraSettings tECameraSettings = this.mCameraSettings;
        if (tECameraSettings.mFacing != 0) {
            return;
        }
        CaptureRequest.Builder builder = this.mCaptureRequestBuilder;
        if (builder == null) {
            TELogUtils.e(TAG, "resetPreviewAfterFlashCapture failed, no builder");
            return;
        }
        int i = tECameraSettings.mCaptureFlashStrategy;
        if (i == 3) {
            if (this.mCameraLightOn) {
                builder.set(CaptureRequest.CONTROL_AE_MODE, 3);
                this.mCaptureRequestBuilder.set(CaptureRequest.FLASH_MODE, 1);
            }
        } else if (i == 2 && this.mSupportAutoFocus) {
            builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
            capture(this.mCaptureRequestBuilder, (CameraCaptureSession.CaptureCallback) null, (Handler) null);
        }
        if (this.mSupportAutoFocus) {
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
        }
        this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, 4);
        this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 0);
        updatePreview(this.mCaptureRequestBuilder);
    }

    private TEFrameSizei selectPictureSize(int i, int i2, int i3, int i4) {
        TECameraSettings tECameraSettings = this.mCameraSettings;
        if (tECameraSettings.mForceApplyPictureSize) {
            tECameraSettings.mForceApplyPictureSize = false;
            return tECameraSettings.mPictureSize;
        }
        if (this.mStreamConfigurationMap == null) {
            this.mStreamConfigurationMap = (StreamConfigurationMap) this.mCameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        }
        StreamConfigurationMap streamConfigurationMap = this.mStreamConfigurationMap;
        TEFrameSizei pictureSize = null;
        if (streamConfigurationMap == null) {
            TELogUtils.e(TAG, "no stream configuration map...");
            return null;
        }
        if (!streamConfigurationMap.isOutputSupportedFor(i)) {
            TELogUtils.e(TAG, "Output format is not supported");
            return null;
        }
        Size[] outputSizes = this.mStreamConfigurationMap.getOutputSizes(i);
        ArrayList arrayList = new ArrayList();
        for (Size size : outputSizes) {
            arrayList.add(new TEFrameSizei(size.getWidth(), size.getHeight()));
        }
        TECameraSettings tECameraSettings2 = this.mCameraSettings;
        if (tECameraSettings2.mUseMaxWidthTakePicture) {
            return TECameraUtils.getClosestSupportedSize(arrayList, tECameraSettings2.getPreviewSize(), i4, this.mCameraSettings.mMaxWidthTakePictureSizeAccuracy);
        }
        if (this.mPictureSizeCallback != null) {
            if (!StreamConfigurationMap.isOutputSupportedFor(SurfaceTexture.class)) {
                TELogUtils.e(TAG, "Output SurfaceTexture is not supported");
                return null;
            }
            Size[] outputSizes2 = this.mStreamConfigurationMap.getOutputSizes(SurfaceTexture.class);
            ArrayList arrayList2 = new ArrayList();
            for (Size size2 : outputSizes2) {
                arrayList2.add(new TEFrameSizei(size2.getWidth(), size2.getHeight()));
            }
            try {
                pictureSize = this.mPictureSizeCallback.getPictureSize(arrayList, arrayList2);
            } catch (Exception e) {
                TELogUtils.e(TAG, "select pic size from client err: " + e.getMessage());
            }
        }
        if (pictureSize != null) {
            return pictureSize;
        }
        TEFrameSizei closestSupportedSize = TECameraUtils.getClosestSupportedSize(arrayList, this.mCameraSettings.getPreviewSize(), new TEFrameSizei(i2, i3));
        TELogUtils.i(TAG, "select pic size is null, get closest size: " + closestSupportedSize);
        return closestSupportedSize;
    }

    private void syncPreviewParam(CaptureRequest.Builder builder) {
        if (builder == null) {
            TELogUtils.e(TAG, "syncPreviewParam failed, no capture builder");
            return;
        }
        CaptureRequest.Builder builder2 = this.mCaptureRequestBuilder;
        if (builder2 == null) {
            TELogUtils.e(TAG, "syncPreviewParam failed, no preview builder");
            return;
        }
        Integer num = (Integer) builder2.get(CaptureRequest.CONTROL_AF_MODE);
        if (num != null) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, num);
            TELogUtils.d(TAG, "sync afMode: " + num);
        }
        MeteringRectangle[] meteringRectangleArr = (MeteringRectangle[]) this.mCaptureRequestBuilder.get(CaptureRequest.CONTROL_AE_REGIONS);
        if (meteringRectangleArr != null) {
            builder.set(CaptureRequest.CONTROL_AE_REGIONS, meteringRectangleArr);
            TELogUtils.d(TAG, "sync aeRect: " + Arrays.toString(meteringRectangleArr));
        }
        MeteringRectangle[] meteringRectangleArr2 = (MeteringRectangle[]) this.mCaptureRequestBuilder.get(CaptureRequest.CONTROL_AF_REGIONS);
        if (meteringRectangleArr != null) {
            builder.set(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr2);
            TELogUtils.d(TAG, "sync afRect: " + Arrays.toString(meteringRectangleArr2));
        }
        setTakingPictureFlashMode(this.mCaptureRequestBuilder, builder);
        Range range = (Range) this.mCaptureRequestBuilder.get(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE);
        if (range != null) {
            builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
            TELogUtils.d(TAG, "sync fpsRange: " + range);
        }
        Rect rect = this.mZoomSize;
        if (rect != null) {
            builder.set(CaptureRequest.SCALER_CROP_REGION, rect);
            TELogUtils.d(TAG, "sync crop region: " + this.mZoomSize);
        }
        TECameraHardware2Proxy tECameraHardware2Proxy = this.mDeviceProxy;
        if (tECameraHardware2Proxy != null) {
            tECameraHardware2Proxy.configStabilization(this.mCameraCharacteristics, builder, false);
        }
        builder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(this.mExposureCompensation));
    }

    public void cancelAFTrigger() {
        Integer num = (Integer) this.mCaptureRequestBuilder.get(CaptureRequest.CONTROL_AF_TRIGGER);
        if (num == null || num.intValue() != 1) {
            return;
        }
        TELogUtils.i(TAG, "need cancel af trigger");
        this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
        capture(this.mCaptureRequestBuilder, (CameraCaptureSession.CaptureCallback) null, (Handler) null);
        this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
        updatePreview(this.mCaptureRequestBuilder);
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase, com.ss.android.ttvecamera.framework.ITECameraMode
    public void captureBurst(BurstRequest burstRequest, int i, TECameraSettings.CaptureBufferFrameCallback captureBufferFrameCallback) {
        int i2;
        int i3;
        int i4 = burstRequest.imageWidth;
        if ((i4 != 0 && i4 != this.mImageReader.getWidth()) || ((i2 = burstRequest.imageHeight) != 0 && i2 != this.mImageReader.getHeight())) {
            TELogUtils.e(TAG, "restart preview for burst capture");
            this.mCameraSettings.mUseSyncModeOnCamera2 = true;
            setPictureSize(burstRequest.imageWidth, burstRequest.imageHeight);
        }
        this.mCallback = null;
        this.mCaptureBufferFrameCallback = captureBufferFrameCallback;
        this.mCameraFacing = i;
        this.mCaptureStartTimestamp = System.currentTimeMillis();
        final int width = this.mImageReader.getWidth();
        final int height = this.mImageReader.getHeight();
        List<Integer> list = burstRequest.aeExposureValues;
        CameraCaptureSession.CaptureCallback captureCallback = new CameraCaptureSession.CaptureCallback() { // from class: com.ss.android.ttvecamera.camera2.TEImage2Mode.2
            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureBufferLost(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Surface surface, long j) {
                TELogUtils.i(TEImage2Mode.TAG, "capture burst buffer last...");
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
                TELogUtils.i(TEImage2Mode.TAG, "onCaptureCompleted, aeExposure: " + ((Integer) totalCaptureResult.get(TotalCaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION)) + ", iso: " + ((Integer) totalCaptureResult.get(TotalCaptureResult.SENSOR_SENSITIVITY)) + ", exposureTime: " + ((Long) totalCaptureResult.get(TotalCaptureResult.SENSOR_EXPOSURE_TIME)));
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
                String str = "capture burst failed: " + captureFailure.getReason();
                TEImage2Mode.this.mCaptureBufferFrameCallback.onBufferFrameArrived(width, height, TEImage2Mode.this.mCameraFacing == 1 ? 270 : 90, null);
                TELogUtils.i(TEImage2Mode.TAG, str);
            }
        };
        int i5 = burstRequest.burstType;
        if (i5 == 1) {
            ArrayList arrayList = new ArrayList(list.size());
            for (Integer num : list) {
                CaptureRequest.Builder builderCreateCaptureRequestBuilder = createCaptureRequestBuilder(2);
                syncPreviewParam(builderCreateCaptureRequestBuilder);
                builderCreateCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, num);
                builderCreateCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.TRUE);
                builderCreateCaptureRequestBuilder.addTarget(this.mImageReader.getSurface());
                arrayList.add(builderCreateCaptureRequestBuilder.build());
            }
            captureBurst(arrayList, captureCallback, (Handler) null);
            return;
        }
        if (i5 == 0) {
            if (burstRequest.canStopRepeating) {
                stopRepeating();
            }
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                Integer num2 = list.get(i6);
                CaptureRequest.Builder builderCreateCaptureRequestBuilder2 = createCaptureRequestBuilder(2);
                syncPreviewParam(builderCreateCaptureRequestBuilder2);
                builderCreateCaptureRequestBuilder2.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, num2);
                builderCreateCaptureRequestBuilder2.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.TRUE);
                builderCreateCaptureRequestBuilder2.addTarget(this.mImageReader.getSurface());
                capture(builderCreateCaptureRequestBuilder2.build(), captureCallback, (Handler) null);
                if (i6 > 0 && i6 < size - 1 && (i3 = burstRequest.frameInterval) > 0) {
                    try {
                        Thread.sleep(i3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (burstRequest.canStopRepeating) {
                updatePreview(this.mCaptureRequestBuilder);
            }
        }
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase, com.ss.android.ttvecamera.framework.ITECameraMode
    public void closePreviewSession() {
        this.mState = 0;
        this.mHandHelper.removeCallbacksAndMessages(null);
        Handler handler = this.mCameraThreadHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mWaitingAfAeConvergeStartTimestamp = 0L;
        this.mIsShotCanDoOnAfAeConverge = false;
        this.mCountCaptureFrame = 0;
        this.mCurrentFlashMode = -1;
        this.mCaptureResultCache = null;
        this.mCameraLightOn = false;
        ImageReader imageReader = this.mImageReader;
        if (imageReader != null) {
            imageReader.close();
            this.mImageReader = null;
        }
        ImageReader imageReader2 = this.mZslImageReader;
        if (imageReader2 != null) {
            imageReader2.close();
            this.mZslImageReader = null;
        }
        this.mZslBufferMetadataCache = null;
        this.mCallback = null;
        this.mCaptureBufferFrameCallback = null;
        this.mCaptureRequestBuilder = null;
        super.closePreviewSession();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Range<Integer> configFps(Range<Integer> range) {
        CameraCharacteristics cameraCharacteristics = this.mCameraCharacteristics;
        if (cameraCharacteristics != null && range != null && this.mCameraSettings.mEnableCameraFpsDoubleCheckInImageMode) {
            Range<Integer>[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
            if (rangeArr == null) {
                return range;
            }
            Range<Integer> maxFixFpsRange = null;
            int i = 0;
            if (this.mFpsConfigCallback != null) {
                ArrayList arrayList = new ArrayList(rangeArr.length);
                for (Range<Integer> range2 : rangeArr) {
                    arrayList.add(new int[]{((Integer) range2.getLower()).intValue(), ((Integer) range2.getUpper()).intValue()});
                }
                int[] iArrConfig = this.mFpsConfigCallback.config(arrayList);
                Range<Integer> range3 = iArrConfig != null ? new Range<>(Integer.valueOf(iArrConfig[0]), Integer.valueOf(iArrConfig[1])) : null;
                if (range3 != null) {
                    TELogUtils.i(TAG, "select fps from user callback: " + range3);
                    return range3;
                }
                if (this.mCameraSettings.mCameraFrameRateStrategy == 4) {
                    Range<Integer> range4 = new Range<>(Integer.valueOf(this.mCameraSettings.mFPSRange.min), Integer.valueOf(this.mCameraSettings.mFPSRange.max));
                    int length = rangeArr.length;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        if (range4.equals(rangeArr[i])) {
                            range3 = range4;
                            break;
                        }
                        i++;
                    }
                }
                if (range3 != null) {
                    TELogUtils.i(TAG, "select fps from user direct set: " + range3);
                    return range3;
                }
                int i2 = this.mCurrentCameraScene;
                if (i2 == 0) {
                    maxFixFpsRange = getMaxDistanceFpsRange(rangeArr);
                } else if (i2 == 1) {
                    maxFixFpsRange = getMaxFixFpsRange(rangeArr);
                }
                if (maxFixFpsRange != null) {
                    range3 = maxFixFpsRange;
                }
                if (range3 != null) {
                    range = range3;
                }
                TELogUtils.i(TAG, "select fps: " + range);
            }
        }
        return range;
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase
    public void createSession(List<Surface> list, CameraCaptureSession.StateCallback stateCallback, final Handler handler) throws CameraAccessException {
        TETraceUtils.beginSection("TEImage2Mode-createSession");
        if (Build.VERSION.SDK_INT >= 28) {
            ArrayList arrayList = new ArrayList();
            Iterator<Surface> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ds5.a(it.next()));
            }
            es5.a();
            SessionConfiguration sessionConfigurationA = cs5.a(getSessionType(list), arrayList, new Executor() { // from class: com.ss.android.ttvecamera.camera2.TEImage2Mode.5
                @Override // java.util.concurrent.Executor
                public void execute(Runnable runnable) {
                    Handler handler2 = handler;
                    if (handler2 != null) {
                        handler2.post(runnable);
                    } else {
                        TELogUtils.e(TEImage2Mode.TAG, "executor run, handler is null");
                    }
                }
            }, stateCallback);
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, configFps(new Range<>(Integer.valueOf(this.mFpsRange.min / this.mCameraSettings.mFPSRange.fpsUnitFactor), Integer.valueOf(this.mFpsRange.max / this.mCameraSettings.mFPSRange.fpsUnitFactor))));
            updateFlashModeParam(this.mCurrentFlashMode);
            sessionConfigurationA.setSessionParameters(this.mCaptureRequestBuilder.build());
            TELogUtils.i(TAG, "createSession by sessionConfiguration");
            this.mCameraDevice.createCaptureSession(sessionConfigurationA);
        } else {
            TELogUtils.i(TAG, "createSession by normally");
            this.mCameraDevice.createCaptureSession(list, stateCallback, handler);
        }
        TETraceUtils.endSection();
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase, com.ss.android.ttvecamera.framework.ITECameraMode
    public int focusAtPoint(TEFocusSettings tEFocusSettings) {
        if (this.mState == 0) {
            return super.focusAtPoint(tEFocusSettings);
        }
        TELogUtils.e(TAG, "focus action discard, state = " + this.mState);
        return -108;
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase, com.ss.android.ttvecamera.framework.ITECameraMode
    public int[] getCameraCaptureSize() {
        ImageReader imageReader = this.mImageReader;
        if (imageReader == null) {
            return null;
        }
        int width = imageReader.getWidth();
        int height = this.mImageReader.getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        return new int[]{width, height};
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase
    public int getContinuousFocusMode() {
        return 4;
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase, com.ss.android.ttvecamera.framework.ITECameraMode
    public int getFlashMode() {
        return this.mCurrentFlashMode;
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase, com.ss.android.ttvecamera.framework.ITECameraMode
    public int[] getPictureSize() {
        ImageReader imageReader = this.mImageReader;
        if (imageReader == null) {
            return null;
        }
        return new int[]{imageReader.getWidth(), this.mImageReader.getHeight()};
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase, com.ss.android.ttvecamera.framework.ITECameraMode
    public int openCamera(String str, int i) throws CameraAccessException {
        this.mCurrentCameraScene = 0;
        this.mAvailableSessionKeys = null;
        if (this.mCurrentFlashMode == -1) {
            this.mCurrentFlashMode = 0;
        }
        return super.openCamera(str, i);
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase, com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy.NormalCallbackRequest
    public int rollbackMeteringSessionRequest() {
        CaptureRequest.Builder builder = this.mCaptureRequestBuilder;
        if (builder == null) {
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, -100, "rollbackMeteringSessionRequest : param is null.", this.mCameraDevice);
            return -100;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            builder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 2);
        }
        return super.rollbackMeteringSessionRequest();
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase, com.ss.android.ttvecamera.framework.ITECameraMode
    public int setPictureSize(int i, int i2) {
        TECameraSettings tECameraSettings = this.mCameraSettings;
        tECameraSettings.mForceApplyPictureSize = true;
        TEFrameSizei tEFrameSizei = tECameraSettings.mPictureSize;
        tEFrameSizei.width = i;
        tEFrameSizei.height = i2;
        closePreviewSession();
        try {
            return startPreview();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase, com.ss.android.ttvecamera.framework.ITECameraMode
    public void setSceneMode(int i) {
        this.mCurrentCameraScene = i;
        TELogUtils.i(TAG, "setSceneMode: " + i);
        if (i == 0) {
            applyCaptureScene();
        } else {
            if (i != 1) {
                throw new IllegalArgumentException("un support scene");
            }
            applyRecordScene();
        }
    }

    public void setTakingPictureFlashMode(CaptureRequest.Builder builder, CaptureRequest.Builder builder2) {
        Integer num;
        Integer num2 = (Integer) builder.get(CaptureRequest.CONTROL_AE_MODE);
        if (num2 != null && num2.intValue() == 3) {
            builder2.set(CaptureRequest.CONTROL_AE_MODE, 3);
            builder2.set(CaptureRequest.FLASH_MODE, 1);
        } else {
            if (num2 == null || num2.intValue() != 1 || (num = (Integer) builder.get(CaptureRequest.FLASH_MODE)) == null || num.intValue() != 2) {
                return;
            }
            builder2.set(CaptureRequest.CONTROL_AE_MODE, 1);
            builder2.set(CaptureRequest.FLASH_MODE, 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setupImageReader(int i, int i2) {
        boolean z;
        Size size;
        TECameraSettings tECameraSettings = this.mCameraSettings;
        int i3 = 256;
        int i4 = (tECameraSettings.mEnableYuvBufferCapture || tECameraSettings.mEnableCamera2Zsl) ? 35 : 256;
        TEFrameSizei tEFrameSizeiSelectPictureSize = selectPictureSize(i4, i, i2, tECameraSettings.mMaxWidth);
        if (tEFrameSizeiSelectPictureSize == null) {
            TELogUtils.e(TAG, "select picture size failed...format: " + i4);
            return;
        }
        TECameraSettings tECameraSettings2 = this.mCameraSettings;
        tECameraSettings2.mPictureSize = tEFrameSizeiSelectPictureSize;
        int width = tEFrameSizeiSelectPictureSize.width;
        int height = tEFrameSizeiSelectPictureSize.height;
        if (tECameraSettings2.mEnableCamera2Zsl && width <= 4096 && i4 == 35) {
            this.mZslBufferMetadataCache = new TotalCaptureResult[5];
            ImageReader imageReaderNewInstance = ImageReader.newInstance(width, height, i4, 3);
            this.mZslImageReader = imageReaderNewInstance;
            imageReaderNewInstance.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: com.ss.android.ttvecamera.camera2.TEImage2Mode.6
                @Override // android.media.ImageReader.OnImageAvailableListener
                public void onImageAvailable(ImageReader imageReader) {
                    TotalCaptureResult totalCaptureResult;
                    Image imageAcquireNextImage = imageReader.acquireNextImage();
                    if (TEImage2Mode.this.mIsCanUseZslBufferForCapture) {
                        int i5 = 0;
                        TEImage2Mode.this.mIsCanUseZslBufferForCapture = false;
                        if (imageAcquireNextImage != null) {
                            long timestamp = imageAcquireNextImage.getTimestamp();
                            TotalCaptureResult[] totalCaptureResultArr = TEImage2Mode.this.mZslBufferMetadataCache;
                            int length = totalCaptureResultArr.length;
                            while (true) {
                                if (i5 >= length) {
                                    totalCaptureResult = null;
                                    break;
                                }
                                totalCaptureResult = totalCaptureResultArr[i5];
                                Long l = (Long) totalCaptureResult.get(TotalCaptureResult.SENSOR_TIMESTAMP);
                                if (l != null && timestamp >= l.longValue()) {
                                    break;
                                } else {
                                    i5++;
                                }
                            }
                            TEImage2Mode.this.processCaptureFrame(imageAcquireNextImage, totalCaptureResult);
                        } else {
                            TEImage2Mode.this.onCaptureFailed(new Exception("no image data"), -1000);
                        }
                    }
                    if (imageAcquireNextImage != null) {
                        imageAcquireNextImage.close();
                    }
                }
            }, this.mUiHandler);
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Size[] outputSizes = this.mStreamConfigurationMap.getOutputSizes(256);
            if (outputSizes != null) {
                int length = outputSizes.length;
                for (int i5 = 0; i5 < length; i5++) {
                    size = outputSizes[i5];
                    if (size.getWidth() == width && size.getHeight() == height) {
                        break;
                    }
                }
                size = null;
                if (size != null) {
                    this.mZslBufferMetadataCache = null;
                    this.mZslImageReader.setOnImageAvailableListener(null, null);
                    this.mZslImageReader.close();
                    this.mZslImageReader = null;
                    i3 = i4;
                } else {
                    width = size.getWidth();
                    height = size.getHeight();
                }
            } else {
                size = null;
                if (size != null) {
                }
            }
        } else {
            i3 = i4;
        }
        this.mImageReader = ImageReader.newInstance(width, height, i3, 1);
        TELogUtils.i(TAG, "image reader width: " + this.mImageReader.getWidth() + ", height = " + this.mImageReader.getHeight() + ", format: " + i3 + ", maxWidth: " + this.mCameraSettings.mMaxWidth + ", hasZslYuvSurface: " + z);
        this.mImageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: com.ss.android.ttvecamera.camera2.TEImage2Mode.7
            @Override // android.media.ImageReader.OnImageAvailableListener
            public void onImageAvailable(ImageReader imageReader) {
                Image imageAcquireNextImage = imageReader.acquireNextImage();
                if (imageAcquireNextImage == null) {
                    TEImage2Mode.this.onCaptureFailed(new Exception("no image data"), -1000);
                    return;
                }
                TEImage2Mode.this.processCaptureFrame(imageAcquireNextImage, imageAcquireNextImage.getFormat() != 256 ? TEImage2Mode.this.mCaptureResultCache : null);
                TEImage2Mode.this.mCaptureResultCache = null;
                imageAcquireNextImage.close();
            }
        }, this.mUiHandler);
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase, com.ss.android.ttvecamera.framework.ITECameraMode
    public int startPreview() throws Exception {
        TETraceUtils.beginSection("TEImage2Mode-startPreview");
        this.mCameraLightOn = false;
        Float f = (Float) this.mCameraCharacteristics.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
        int iIntValue = f == null ? 0 : f.intValue();
        TELogUtils.d(TAG, "lensInfoMinFocusDistance = " + iIntValue);
        boolean z = true;
        this.mSupportAutoFocus = iIntValue != 0;
        TECameraProviderManager providerManager = this.mCameraHolder.getProviderManager();
        if (this.mCameraDevice == null || providerManager == null) {
            TELogUtils.e(TAG, "CameraDevice or ProviderManager is null!");
            return -100;
        }
        if (this.mCameraSettings.mBindSurfaceLifecycleToCamera) {
            if (providerManager.getProvider() != null) {
                providerManager.getProvider().reAllocateSurfaceTexture();
                TELogUtils.i(TAG, "reallocate st...");
            } else {
                TELogUtils.e(TAG, "reallocate st...err");
            }
        }
        int iPrepareProvider = super.prepareProvider();
        if (iPrepareProvider != 0) {
            return iPrepareProvider;
        }
        TEFrameSizei tEFrameSizei = this.mCameraSettings.mPictureSize;
        setupImageReader(tEFrameSizei.width, tEFrameSizei.height);
        CaptureRequest.Builder builderCreateCaptureRequest = this.mCameraDevice.createCaptureRequest(1);
        this.mCaptureRequestBuilder = builderCreateCaptureRequest;
        Rect rect = this.mZoomSize;
        if (rect != null) {
            builderCreateCaptureRequest.set(CaptureRequest.SCALER_CROP_REGION, rect);
        }
        ArrayList arrayList = new ArrayList();
        if (providerManager.getProvider().getType() == 8) {
            arrayList.addAll(Arrays.asList(providerManager.getPreviewSurfaces()));
        } else {
            arrayList.add(providerManager.getPreviewSurface());
        }
        ImageReader imageReader = this.mZslImageReader;
        if (imageReader != null) {
            arrayList.add(imageReader.getSurface());
        }
        Iterator<Surface> it = arrayList.iterator();
        while (it.hasNext()) {
            this.mCaptureRequestBuilder.addTarget(it.next());
        }
        ImageReader imageReader2 = this.mImageReader;
        if (imageReader2 != null) {
            arrayList.add(imageReader2.getSurface());
        }
        this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, 4);
        TECameraSettings tECameraSettings = this.mCameraSettings;
        if (tECameraSettings.mOptCameraSceneFps) {
            if (Build.VERSION.SDK_INT >= 28) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                CameraCharacteristics cameraCharacteristics = this.mCameraCharacteristics;
                if (cameraCharacteristics != null && this.mAvailableSessionKeys == null) {
                    this.mAvailableSessionKeys = cameraCharacteristics.getAvailableSessionKeys();
                }
                List<CaptureRequest.Key<?>> list = this.mAvailableSessionKeys;
                if (list != null) {
                    Iterator<CaptureRequest.Key<?>> it2 = list.iterator();
                    while (it2.hasNext()) {
                        if (CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE.getName().equals(it2.next().getName())) {
                            this.mCameraSettings.mOptCameraSceneFps = false;
                            break;
                        }
                    }
                    z = false;
                    TELogUtils.i(TAG, "check aeTargetFpsRange is session key: " + z + ", consume: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                } else {
                    z = false;
                    TELogUtils.i(TAG, "check aeTargetFpsRange is session key: " + z + ", consume: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                }
            } else {
                tECameraSettings.mOptCameraSceneFps = false;
            }
        }
        this.mFrameArrivedTimestamp = 0L;
        this.mFrameCountPerSec = 0;
        this.mCountCaptureFrame = 0;
        this.mCurrentZslMetadataCacheIndex = -1;
        int i = this.mCameraSettings.mEnableGcForCameraMetadataThreshold;
        this.mEnableGcForCameraMetadataThreshold = i;
        if (i > 0) {
            TELogUtils.i(TAG, "release camera metadata threshold: " + this.mEnableGcForCameraMetadataThreshold);
        }
        this.mIsAfConvergeOnPreview = false;
        this.mState = 0;
        this.mCreateSessionStartTimestamp = System.currentTimeMillis();
        Handler cameraHandler = this.mCameraSettings.mUseSyncModeOnCamera2 ? getCameraHandler() : this.mHandler;
        this.mCameraSession = null;
        createSession(arrayList, this.mSessionStateCallback, cameraHandler);
        if (this.mCameraSession == null) {
            waitCameraTaskDoneOrTimeout();
        }
        TETraceUtils.endSection();
        return 0;
    }

    @Override // com.ss.android.ttvecamera.framework.ITECameraMode
    public void switchFlashMode(int i) {
        TECameraModeBase.Response responseUpdatePreview;
        if (this.mCaptureRequestBuilder == null) {
            TELogUtils.e(TAG, "switchFlashMode failed, mode: " + i);
            return;
        }
        int i2 = this.mCurrentFlashMode;
        boolean z = (i2 == -1 || i2 == 0 || i != 0) ? false : true;
        updateFlashModeParam(i);
        if (z) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.mConditionVariable == null) {
                this.mConditionVariable = new ConditionVariable();
            }
            this.mConditionVariable.close();
            responseUpdatePreview = updatePreview(this.mCaptureRequestBuilder, new CameraCaptureSession.CaptureCallback() { // from class: com.ss.android.ttvecamera.camera2.TEImage2Mode.8
                @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
                public void onCaptureBufferLost(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Surface surface, long j) {
                    TEImage2Mode.this.mConditionVariable.open();
                    TELogUtils.e(TEImage2Mode.TAG, "set flash request abort");
                }

                @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
                public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
                    TEImage2Mode.this.mConditionVariable.open();
                    TELogUtils.i(TEImage2Mode.TAG, "onCaptureCompleted");
                }

                @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
                public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
                    TEImage2Mode.this.mConditionVariable.open();
                    TELogUtils.e(TEImage2Mode.TAG, "set flash failed");
                }
            }, this.mUiHandler);
            if (!this.mConditionVariable.block(33L)) {
                TELogUtils.i(TAG, "close flash: " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
            }
            updatePreview(this.mCaptureRequestBuilder);
        } else {
            responseUpdatePreview = updatePreview(this.mCaptureRequestBuilder);
        }
        if (responseUpdatePreview.isSuccess()) {
            return;
        }
        TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: TOGGLE_TORCH. Code: -100. Reason: " + responseUpdatePreview.getErrMsg());
        this.mCameraEvents.onCameraInfo(-100, -100, responseUpdatePreview.getErrMsg(), this.mCameraDevice);
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase, com.ss.android.ttvecamera.framework.ITECameraMode
    public void takePicture(int i, int i2, TECameraSettings.PictureCallback pictureCallback) {
        takePicture(pictureCallback, this.mCameraSettings.mFacing);
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase, com.ss.android.ttvecamera.framework.ITECameraMode
    public int toggleTorch(boolean z) {
        switchFlashMode(z ? 2 : 0);
        return 0;
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase, com.ss.android.ttvecamera.framework.ITECameraMode
    public int updateCapture() throws CameraAccessException {
        updateFlashModeParam(this.mCurrentFlashMode);
        return super.updateCapture();
    }

    public void updateFlashModeParam(int i) {
        TELogUtils.i(TAG, "updateFlashModeParam: " + i);
        this.mCurrentFlashMode = i;
        CaptureRequest.Builder builder = this.mCaptureRequestBuilder;
        if (builder == null) {
            TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: TOGGLE_TORCH. Code: -100. Reason: mCaptureRequestBuilder is null");
            this.mCameraEvents.onCameraError(this.mCameraSettings.mCameraType, -100, "switchFlashMode : CaptureRequest.Builder is null", this.mCameraDevice);
            return;
        }
        Integer num = (Integer) builder.get(CaptureRequest.FLASH_MODE);
        int iIntValue = num == null ? 0 : num.intValue();
        if (i == 1) {
            if (this.mCameraSettings.mFacing == 1) {
                TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: TOGGLE_TORCH. Code: -416. Reason: not support torch");
                TELogUtils.w(TAG, "flash on is not supported in front camera!");
                return;
            } else {
                this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, 3);
                this.mCaptureRequestBuilder.set(CaptureRequest.FLASH_MODE, 1);
                this.mCameraLightOn = true;
                return;
            }
        }
        if (i == 0) {
            this.mCameraLightOn = false;
            if (iIntValue == 0) {
                TELogUtils.i(TAG, "switchFlashMode flashStatus == FLASH_MODE_OFF");
                return;
            } else {
                this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, 1);
                this.mCaptureRequestBuilder.set(CaptureRequest.FLASH_MODE, 0);
                return;
            }
        }
        if (i == 2) {
            this.mCameraLightOn = false;
            if (iIntValue == 2) {
                TELogUtils.i(TAG, "switchFlashMode flashStatus == FLASH_MODE_TORCH");
                return;
            } else {
                this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, 1);
                this.mCaptureRequestBuilder.set(CaptureRequest.FLASH_MODE, 2);
                return;
            }
        }
        TELogUtils.e(TAG, "[VE_UI_TEST]Failed event: TOGGLE_TORCH. Code: -416. Reason: not support flash mode " + i);
        TELogUtils.e(TAG, "not support flash mode: " + i);
    }

    @Override // com.ss.android.ttvecamera.framework.TECameraModeBase, com.ss.android.ttvecamera.framework.ITECameraMode
    public void takePicture(TECameraSettings.PictureCallback pictureCallback, int i) {
        super.takePicture(pictureCallback, i);
        this.mCallback = pictureCallback;
        this.mCaptureBufferFrameCallback = null;
        this.mCameraFacing = i;
        this.mIsShotCanDoOnAfAeConverge = false;
        this.mCaptureStartTimestamp = System.currentTimeMillis();
        if (this.mZslImageReader != null && !this.mCameraLightOn) {
            this.mState = 1;
            this.mIsCanUseZslBufferForCapture = true;
            TELogUtils.i(TAG, "takePicture...use zsl buffer");
            return;
        }
        TELogUtils.i(TAG, "takePicture...flash strategy: " + this.mCameraSettings.mCaptureFlashStrategy);
        boolean z = this.mCameraLightOn;
        long j = z ? AF_AE_CONVERGE_TIME_OUT_MS_FOR_FLASH_ON : 800L;
        TECameraSettings tECameraSettings = this.mCameraSettings;
        if (tECameraSettings.mFacing != 0) {
            this.mState = 1;
            doCaptureOnReady();
            return;
        }
        int i2 = tECameraSettings.mCaptureFlashStrategy;
        if (i2 == 3) {
            if (!z) {
                doCaptureOnReady();
                return;
            }
            this.mWaitingAfAeConvergeStartTimestamp = System.currentTimeMillis();
            this.mState = 2;
            this.mHandHelper.sendEmptyMessageDelayed(1001, j);
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, 1);
            this.mCaptureRequestBuilder.set(CaptureRequest.FLASH_MODE, 2);
            if (!this.mSupportAutoFocus) {
                this.mHandHelper.sendEmptyMessageDelayed(1000, 300L);
                return;
            }
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, 1);
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
            this.mCaptureRequestBuilder.setTag(CAPTURE_REQUEST_TAG_FOR_SHOT);
            capture(this.mCaptureRequestBuilder);
            this.mCaptureRequestBuilder.setTag(null);
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 0);
            updatePreview(this.mCaptureRequestBuilder);
            TECameraModeBase.Response responseUpdatePreview = updatePreview(this.mCaptureRequestBuilder);
            if (responseUpdatePreview.isSuccess()) {
                return;
            }
            HandlerHelper handlerHelper = this.mHandHelper;
            handlerHelper.sendMessage(handlerHelper.obtainMessage(1003, responseUpdatePreview.getException()));
            return;
        }
        if (i2 == 2) {
            if (!z && this.mIsAfConvergeOnPreview) {
                TELogUtils.i(TAG, "af converge, do capture...");
                doCaptureOnReady();
                return;
            }
            this.mWaitingAfAeConvergeStartTimestamp = System.currentTimeMillis();
            this.mState = 2;
            this.mHandHelper.sendEmptyMessageDelayed(1001, j);
            if (this.mSupportAutoFocus) {
                this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
            }
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
            this.mCaptureRequestBuilder.setTag(CAPTURE_REQUEST_TAG_FOR_SHOT);
            capture(this.mCaptureRequestBuilder);
            this.mCaptureRequestBuilder.setTag(null);
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 0);
            TECameraModeBase.Response responseUpdatePreview2 = updatePreview(this.mCaptureRequestBuilder);
            if (responseUpdatePreview2.isSuccess()) {
                return;
            }
            HandlerHelper handlerHelper2 = this.mHandHelper;
            handlerHelper2.sendMessage(handlerHelper2.obtainMessage(1003, responseUpdatePreview2.getException()));
            return;
        }
        if (i2 != 0) {
            if (i2 != 1) {
                this.mState = 1;
                doCaptureOnReady();
                return;
            }
            this.mState = 1;
            if (z) {
                this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, 1);
                this.mCaptureRequestBuilder.set(CaptureRequest.FLASH_MODE, 2);
            }
            captureStillPicture();
            return;
        }
        if (!z && this.mIsAfConvergeOnPreview) {
            TELogUtils.i(TAG, "af converge, do capture...");
            captureStillPicture();
            return;
        }
        this.mWaitingAfAeConvergeStartTimestamp = System.currentTimeMillis();
        this.mState = 1;
        this.mHandHelper.sendEmptyMessageDelayed(1007, j);
        if (this.mSupportAutoFocus) {
            this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        }
        this.mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
        TECameraModeBase.Response responseCapture = capture(this.mCaptureRequestBuilder, this.mPreviewCaptureCallback, this.mHandler);
        if (responseCapture.isSuccess()) {
            return;
        }
        HandlerHelper handlerHelper3 = this.mHandHelper;
        handlerHelper3.sendMessage(handlerHelper3.obtainMessage(1003, responseCapture.getException()));
    }
}
