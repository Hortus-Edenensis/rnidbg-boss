package com.ss.android.ttvecamera;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.lantern.auth.app.FunDC;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TECameraSettings {
    public static final int CAMERA_FACING_3RD = 4;
    public static final int CAMERA_FACING_BACK = 0;
    public static final int CAMERA_FACING_FRONT = 1;
    public static final int CAMERA_FACING_REAR_MAIN_FRONT_MAIN = 7;
    public static final int CAMERA_FACING_REAR_MAIN_REAR_TELE = 6;
    public static final int CAMERA_FACING_REAR_MAIN_REAR_WIDE = 5;
    public static final int CAMERA_FACING_SAT = 8;
    public static final int CAMERA_FACING_TELEPHOTO = 3;
    public static final int CAMERA_FACING_WIDE_ANGLE = 2;
    public static final int CAMERA_MODE_AR = 2;
    public static final int CAMERA_MODE_BOKEH = 7;
    public static final int CAMERA_MODE_HDR = 3;
    public static final int CAMERA_MODE_IMAGE = 1;
    public static final int CAMERA_MODE_PORTRAIT = 8;
    public static final int CAMERA_MODE_PRO_VIDEO = 6;
    public static final int CAMERA_MODE_SLOW_MOTION = 5;
    public static final int CAMERA_MODE_SUPERNIGHT = 4;
    public static final int CAMERA_MODE_SUPER_SLOW_MOTION = 9;
    public static final int CAMERA_MODE_VIDEO = 0;
    public static final int CAMERA_MODE_VIDEO_SUPERNIGHT = 10;
    public static final int CAMERA_TYPE_1 = 1;
    public static final int CAMERA_TYPE_2 = 2;
    public static final int CAMERA_TYPE_BEWO = 6;
    public static final int CAMERA_TYPE_CamKit = 5;
    public static final int CAMERA_TYPE_GNOB = 9;
    public static final int CAMERA_TYPE_GNOB_MEDIA = 4;
    public static final int CAMERA_TYPE_GNOB_UNIT = 7;
    public static final int CAMERA_TYPE_OGXM = 3;
    public static final int CAMERA_TYPE_OGXM_V2 = 8;
    public static final int CAMERA_TYPE_VENDOR_GNOB = 11;
    public static final int CAMERA_TYPE_VENDOR_RDHW = 10;
    public static final int DYNAMIC_FRAMERATE = 0;
    public static final int DYNAMIC_FRAMERATE_WITHOUT_SELECT = 3;
    public static final int FIXED_FRAMERATE_FOR_ALL = 1;
    public static final int FIXED_FRAMERATE_FOR_REAR = 2;
    public static final int FLASH_AUTO = 3;
    public static final int FLASH_OFF = 0;
    public static final int FLASH_ON = 1;
    public static final int FLASH_RED_EYE = 4;
    public static final int FLASH_TORCH = 2;
    public static final int FLASH_UNKNOW = -1;
    public static final int FPS_120 = 120;
    public static final int FPS_480 = 480;
    public static final int FPS_60 = 60;
    public static final int FPS_90 = 90;
    public static final int FRAMERATE_FOR_USER = 4;
    public static final int FlashOnRealStrategy = 2;
    public static final int FlashOnSimulatedStrategy = 3;
    public static final int HW_CHECK_LEVEL_3 = 3;
    public static final int HW_CHECK_LEVEL_FULL = 2;
    public static final int HW_CHECK_LEVEL_LEGACY = 0;
    public static final int HW_CHECK_LEVEL_LIMITED = 1;
    public static final byte OPTION_FLAG_CaptureSizeNotEqualPreviewSize = 8;
    public static final byte OPTION_FLAG_DEFAULT = 1;
    public static final byte OPTION_FLAG_FPS_RANGE = 2;
    public static final byte OPTION_FLAG_PICTURE_SIZE = 1;
    public static final int OUTPUT_NV21IMAGE = 2;
    public static final int OUTPUT_SURFACETEXTURE = 1;
    public static final int PreAndMainStrategy = 0;
    public static final String SCENE_MODE_ACTION = "action";
    public static final String SCENE_MODE_AUTO = "auto";
    public static final String SCENE_MODE_BARCODE = "barcode";
    public static final String SCENE_MODE_BEACH = "beach";
    public static final String SCENE_MODE_FIREWORKS = "fireworks";
    public static final String SCENE_MODE_NIGHT_PORTRAIT = "night-portrait";
    public static final String SCENE_MODE_SPORTS = "sports";
    public static final String SCENE_MODE_STEADYPHOTO = "steadyphoto";
    public static final String SCENE_MODE_THEATRE = "theatre";
    public static final int TorchFakeStrategy = 1;
    public static final String WHITE_BALANCE_AUTO = "auto";
    public static final String WHITE_BALANCE_CLOUDY_DAYLIGHT = "cloudy-daylight";
    public static final String WHITE_BALANCE_DAYLIGHT = "daylight";
    public static final String WHITE_BALANCE_FLUORESCENT = "fluorescent";
    public static final String WHITE_BALANCE_INCANDESCENT = "incandescent";
    public static final String WHITE_BALANCE_SHADE = "shade";
    public static final String WHITE_BALANCE_TWILIGHT = "twilight";
    public static final String WHITE_BALANCE_WARM_FLUORESCENT = "warm-fluorescent";
    public final int CAMERA2_PREVIEWING_FAILED_COUNT;
    public ARConfig arConfig;

    @WhiteBalanceValue
    public String mAWBValue;
    public boolean mBindSurfaceLifecycleToCamera;
    public int mCamera2RetryCnt;
    public ExposureCompensationInfo mCameraECInfo;

    @CameraFrameRateStrategy
    public int mCameraFrameRateStrategy;
    public int mCameraHardwareSupportLevel;
    public boolean mCameraPreviewIndependent;

    @CameraType
    public int mCameraType;
    public float mCameraZoomLimitFactor;

    @CaptureFlashStrategy
    public int mCaptureFlashStrategy;
    public Context mContext;
    public int mDefaultCameraID;
    public float mDefaultZoomRatio;
    public boolean mEnableAiNightVideo;
    public boolean mEnableBackGroundStrategy;
    public boolean mEnableCamera2DeferredSurface;
    public boolean mEnableCamera2Detect;
    public boolean mEnableCamera2Zsl;
    public boolean mEnableCameraFpsDoubleCheckInImageMode;
    public boolean mEnableCollectCapbilities;
    public boolean mEnableFallBack;
    public int mEnableGcForCameraMetadataThreshold;
    public boolean mEnableManualReleaseCaptureResult;
    public boolean mEnableMonitorGyroscope;
    public boolean mEnableOpenCamera1Crs;
    public boolean mEnableOpenCamera1Opt;
    public boolean mEnablePreviewingFallback;
    public boolean mEnableRecord60Fps;
    public boolean mEnableRecordStream;
    public boolean mEnableRefactorFocusAndMeter;
    public boolean mEnableStabilization;
    public boolean mEnableVBoost;
    public boolean mEnableWideFOV;
    public boolean mEnableYuvBufferCapture;
    public boolean mEnableZsl;
    public Bundle mExtParameters;
    public TEFrameRateRange mFPSRange;

    @CameraFacing
    public int mFacing;
    public int mFlashMode;
    public int mFocusTimeoutMS;
    public boolean mForceApplyPictureSize;
    public boolean mForceSwitchEnable;
    public int mFpsMaxLimit;

    @FPS
    public int mHighFPS;
    public boolean mIgnoreCameraResetTaskOnDisconnected;
    public int mImageFormat;
    public boolean mIsCameraOpenCloseSync;
    public boolean mIsForceCloseCamera;
    public boolean mIsGetMetadata;
    public boolean mIsUseHint;
    public int mMaxWidth;
    public float mMaxWidthTakePictureSizeAccuracy;
    public float mMaxZoomRatio;
    public float mMinZoomRatio;
    public int mMode;
    public boolean mOptCameraSceneFps;
    public byte mOptionFlags;
    public int mOutputType;
    public TEFrameSizei mPictureSize;
    public boolean mPreferOpenCameraByCameraId;
    public TEFrameSizei mPreviewSize;
    public String mRecordStreamFolderPath;
    public int mRequiredCameraLevel;
    public int mRetryCnt;
    public int mRetryStartPreviewCnt;
    public int mRotation;
    public String mSceneMode;
    public boolean mStartRecord;
    public String mStrCameraID;
    public String mStrCustomizedCameraID;
    public boolean mUseMaxWidthTakePicture;
    public boolean mUseSyncModeOnCamera2;
    public int mVBoostTimeoutMS;
    public String mVendorCameraID;
    public TEFrameSizei mVideoSize;
    public static final String SCENE_MODE_PORTRAIT = "portrait";
    public static final String SCENE_MODE_PARTY = "party";
    public static final String SCENE_MODE_SUNSET = "sunset";
    public static final String SCENE_MODE_CANDLELIGHT = "candlelight";
    public static final String SCENE_MODE_NIGHT = "night";
    public static final String SCENE_MODE_HDR = "hdr";
    public static final String SCENE_MODE_LANDSCAPE = "landscape";
    public static final String SCENE_MODE_SNOW = "snow";
    public static final String[] sCameraSceneMode = {"auto", SCENE_MODE_PORTRAIT, SCENE_MODE_PARTY, SCENE_MODE_SUNSET, SCENE_MODE_CANDLELIGHT, SCENE_MODE_NIGHT, SCENE_MODE_HDR, "action", SCENE_MODE_LANDSCAPE, SCENE_MODE_SNOW};
    public static final int[] CameraHWLevelVE2Android = {2, 0, 1, 3};
    public static final int[] CameraHWLevelAndroid2VE = {1, 2, 0, 3};

    /* JADX INFO: compiled from: SearchBox */
    public static final class ARConfig {
        public AugmentedFaceMode augmentedFaceMode = AugmentedFaceMode.DISABLED;
        public CloudAnchorMode cloudAnchorMode = CloudAnchorMode.DISABLED;
        public DepthMode depthMode = DepthMode.DISABLED;
        public FocusMode focusMode = FocusMode.FIXED;
        public LightEstimationMode lightEstimationMode = LightEstimationMode.DISABLED;
        public PlaneFindingMode planeFindingMode = PlaneFindingMode.DISABLED;

        /* JADX INFO: compiled from: SearchBox */
        public enum AugmentedFaceMode {
            DISABLED,
            MESH3D
        }

        /* JADX INFO: compiled from: SearchBox */
        public enum CloudAnchorMode {
            DISABLED,
            ENABLED
        }

        /* JADX INFO: compiled from: SearchBox */
        public enum DepthMode {
            DISABLED,
            AUTOMATIC
        }

        /* JADX INFO: compiled from: SearchBox */
        public enum FocusMode {
            FIXED,
            AUTO
        }

        /* JADX INFO: compiled from: SearchBox */
        public enum LightEstimationMode {
            DISABLED,
            AMBIENT_INTENSITY,
            ENVIRONMENTAL_HDR
        }

        /* JADX INFO: compiled from: SearchBox */
        public enum PlaneFindingMode {
            DISABLED,
            HORIZONTAL,
            VERTICAL,
            HORIZONTAL_AND_VERTICAL
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface ApertureCallback {
        void getApertureRange(float[] fArr);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface CameraCapabilitiesForBytebenchCallback {
        void getCameraCapabilities(JSONObject jSONObject);
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.CLASS)
    public @interface CameraFacing {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.CLASS)
    public @interface CameraFrameRateStrategy {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.CLASS)
    public @interface CameraType {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface CaptureBufferFrameCallback {
        void onBufferFrameArrived(int i, int i2, int i3, @NonNull byte[] bArr);

        void onError(Exception exc);
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.CLASS)
    public @interface CaptureFlashStrategy {
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

        public String toString() {
            return "ExposureCompensationInfo{max = " + this.max + ", exposure = " + this.exposure + ", min = " + this.min + ", step = " + this.step + "}";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface FOVCallback {
        void getFOV(float[] fArr);
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.CLASS)
    public @interface FPS {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class Features {
        public static final String CAMERA_FACING = "facing";
        public static final String CAMERA_FOCUS_PARAMETERS = "camera_focus_parameters";
        public static final String CAMERA_PREVIEW_SIZE = "camera_preview_size";
        public static final String CAMERA_SENSOR_ORIENTATION = "camera_sensor_orientation";
        public static final String CAMERA_SUPPORT_FPS_RANGE = "camera_support_fps_range";
        public static final String CAMERA_TORCH_SUPPORTED = "camera_torch_supported";
        public static final String DEVICE_SHOULD_USE_SHADER_ZOOM = "device_should_use_shader_zoom";
        public static final String DEVICE_SUPPORT_AI_NIGHT_VIDEO = "device_support_ai_night_video";
        public static final String DEVICE_SUPPORT_ANTISHAKE_MODE = "device_support_antishake_mode";
        public static final String DEVICE_SUPPORT_ANTI_SHAKE = "device_support_anti_shake";
        public static final String DEVICE_SUPPORT_CAMERA = "device_support_camera";
        public static final String DEVICE_SUPPORT_MULTICAMERA_ZOOM = "device_support_multicamera_zoom";
        public static final String DEVICE_SUPPORT_SURPER_STABILIZATION = "support_super_stabilization";
        public static final String DEVICE_SUPPORT_WIDE_ANGLE = "device_support_wide_angle";
        public static final String DEVICE_SUPPORT_WIDE_ANGLE_MODE = "device_support_wide_angle_mode";
        public static final String DEVICE_WIDE_ANGLE_CAMERA_ID = "device_wide_angle_camera_id";
        public static final String SUPPORT_ANTI_SHAKE = "support_anti_shake";
        public static final String SUPPORT_BODY_BEAUTY = "support_body_beauty";
        public static final String SUPPORT_FPS_120 = "support_fps_120";
        public static final String SUPPORT_FPS_480 = "support_fps_480";
        public static final String SUPPORT_FPS_60 = "support_fps_60";
        public static final String SUPPORT_LIGHT_SOFT = "support_light_soft";
        public static final String SUPPORT_PICTURE_SIZES = "support_picture_sizes";
        public static final String SUPPORT_PREVIEW_SIZES = "support_preview_sizes";
        public static final String SUPPORT_TELEPHOTO = "support_telephoto";
        public static final String SUPPORT_VIDEO_SIZES = "support_video_sizes";
        public static final String SUPPORT_WIDE_ANGLE = "support_wide_angle";
        private static final Map<String, Class> sKeyFeatureTypes;

        static {
            HashMap map = new HashMap();
            sKeyFeatureTypes = map;
            map.put(CAMERA_FACING, Integer.class);
            map.put(DEVICE_SUPPORT_WIDE_ANGLE_MODE, Integer.class);
            map.put(DEVICE_SUPPORT_ANTISHAKE_MODE, Integer.class);
            map.put(DEVICE_SUPPORT_AI_NIGHT_VIDEO, Integer.class);
            map.put(SUPPORT_LIGHT_SOFT, Boolean.class);
            map.put(DEVICE_SUPPORT_WIDE_ANGLE, Boolean.class);
            map.put(DEVICE_SUPPORT_ANTI_SHAKE, Boolean.class);
            map.put(DEVICE_SUPPORT_CAMERA, Boolean.class);
            map.put(DEVICE_WIDE_ANGLE_CAMERA_ID, String.class);
            map.put(SUPPORT_WIDE_ANGLE, Boolean.class);
            map.put(SUPPORT_TELEPHOTO, Boolean.class);
            map.put(SUPPORT_BODY_BEAUTY, Boolean.class);
            map.put(SUPPORT_ANTI_SHAKE, Boolean.class);
            map.put(SUPPORT_FPS_480, Boolean.class);
            map.put(SUPPORT_FPS_120, Boolean.class);
            map.put(SUPPORT_FPS_60, Boolean.class);
            map.put(SUPPORT_PREVIEW_SIZES, ArrayList.class);
            map.put(SUPPORT_PICTURE_SIZES, ArrayList.class);
            map.put(CAMERA_PREVIEW_SIZE, TEFrameSizei.class);
            map.put(CAMERA_FOCUS_PARAMETERS, TEFocusParameters.class);
            map.put(CAMERA_TORCH_SUPPORTED, Boolean.class);
            map.put(SUPPORT_VIDEO_SIZES, ArrayList.class);
            map.put(CAMERA_SUPPORT_FPS_RANGE, ArrayList.class);
            map.put(DEVICE_SHOULD_USE_SHADER_ZOOM, Boolean.class);
            map.put(DEVICE_SUPPORT_MULTICAMERA_ZOOM, Boolean.class);
        }

        public static Class getFeatureType(String str) {
            Map<String, Class> map = sKeyFeatureTypes;
            if (map.containsKey(str)) {
                return map.get(str);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.CLASS)
    public @interface FlashMode {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface ISOCallback {
        void getCurrentISO(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface ISORangeCallback {
        void getISORange(int[] iArr);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface ManualFocusCallback {
        void getManualFocusAbility(float f);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Operation {
        public static final int SLOW_MOTION_RECORD = 1;
        public static final int UPDATE_CAMERA_ORIENTATION = 2;
        private int mType;

        public Operation(int i) {
            this.mType = i;
        }

        public int getType() {
            return this.mType;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class Parameters {
        public static final String APERTURE = "aperture";
        public static final String BODY_BEAUTY_LEVEL = "body_beauty_level";
        public static final String ENABLE_AI_NIGHT_VIDEO = "enable_ai_night_video";
        public static final String ENABLE_ANTI_SHAKE = "enable_anti_shake";
        public static final String ENABLE_BODY_BEAUTY = "enable_body_beauty";
        public static final String ENABLE_DIM_LIGHT_QUALITY = "enable_dim_light_quality";
        public static final String ENABLE_LIGHT_SOFT = "enable_light_soft";
        public static final String ENABLE_SUPER_STABILIZATION = "enable_super_Stabilization";
        public static final String ENABLE_VIDEO_HDR = "enable_video_hdr";
        public static final String ENABLE_VIDEO_STABILIZATION = "enable_video_stabilization";
        public static final String EXPOSURE_COMPENSATION = "exposure_compensation";
        public static final String FACE_DETECT = "face_detect";
        public static final String FLASH_MODE = "flash_mode";
        public static final String VIDEO_FPS = "video_fps";
        public static final String VIDEO_PATH = "video_path";
        public static final Map<String, Class> sKeySupportTypes;

        static {
            HashMap map = new HashMap();
            sKeySupportTypes = map;
            map.put(ENABLE_BODY_BEAUTY, Boolean.class);
            map.put(ENABLE_LIGHT_SOFT, Boolean.class);
            map.put(ENABLE_ANTI_SHAKE, Boolean.class);
            map.put(VIDEO_PATH, String.class);
            map.put(BODY_BEAUTY_LEVEL, Integer.class);
            map.put(ENABLE_DIM_LIGHT_QUALITY, Boolean.class);
            map.put(ENABLE_AI_NIGHT_VIDEO, Boolean.class);
            map.put(ENABLE_VIDEO_STABILIZATION, Boolean.class);
            map.put(ENABLE_SUPER_STABILIZATION, Boolean.class);
            map.put(ENABLE_VIDEO_HDR, Boolean.class);
            map.put(VIDEO_FPS, int[].class);
            map.put(APERTURE, Float.class);
            map.put(FLASH_MODE, Integer.class);
            map.put(FACE_DETECT, Integer.class);
            map.put(EXPOSURE_COMPENSATION, Integer.class);
        }

        public static boolean isValid(String str, Object obj) {
            Map<String, Class> map = sKeySupportTypes;
            return map.containsKey(str) && (obj == null || obj.getClass() == map.get(str));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface PictureCallback {
        public static final String ERROR_CODE_SPLIT_REGEX = "errorCode=";
        public static final int ERR_CODE_PIC_FAILED = -1000;
        public static final int ERR_CODE_PIC_INVALID_ENV = -1001;
        public static final int FORMAT_JPEG = 256;
        public static final int FORMAT_RGBA = 42;

        void onPictureTaken(TECameraFrame tECameraFrame, TECameraBase tECameraBase);

        void onTakenFail(Exception exc);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface SATZoomCallback {
        void onChange(int i, float f);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface ShaderZoomCallback {
        void getShaderStep(float f);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface ShutterTimeCallback {
        void getShutterTimeRange(long[] jArr);
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.CLASS)
    public @interface WhiteBalanceValue {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface ZoomCallback {
        boolean enableSmooth();

        void onChange(int i, float f, boolean z);

        void onZoomSupport(int i, boolean z, boolean z2, float f, List<Integer> list);
    }

    public TECameraSettings(@NonNull Context context) {
        this.mCameraType = 1;
        this.mFPSRange = new TEFrameRateRange(7, 30);
        this.mFacing = 0;
        this.mRotation = 0;
        this.mDefaultCameraID = -1;
        this.mImageFormat = 17;
        this.mEnableCamera2Zsl = false;
        this.mEnableZsl = false;
        this.mEnableManualReleaseCaptureResult = true;
        this.mUseSyncModeOnCamera2 = false;
        this.mEnableWideFOV = false;
        this.mEnableRefactorFocusAndMeter = false;
        this.mEnableMonitorGyroscope = false;
        this.mStartRecord = false;
        this.mCameraZoomLimitFactor = -1.0f;
        this.mPreviewSize = new TEFrameSizei(1280, 720);
        this.mPictureSize = new TEFrameSizei(TECameraUtils.CAPTURE_NORMAL, FunDC.ID_AUTH_1080);
        this.mVideoSize = new TEFrameSizei(TECameraUtils.CAPTURE_NORMAL, FunDC.ID_AUTH_1080);
        this.mOutputType = 1;
        this.mMaxWidth = 0;
        this.mRetryCnt = 0;
        this.mRetryStartPreviewCnt = 0;
        this.mCamera2RetryCnt = 1;
        this.mMaxWidthTakePictureSizeAccuracy = 0.0f;
        this.mUseMaxWidthTakePicture = false;
        this.mForceApplyPictureSize = false;
        this.mMode = 0;
        this.mCameraHardwareSupportLevel = 1;
        this.mRequiredCameraLevel = 1;
        this.mExtParameters = new Bundle();
        this.mOptionFlags = (byte) 1;
        this.mSceneMode = "auto";
        this.mStrCameraID = "0";
        this.mVendorCameraID = "0";
        this.mStrCustomizedCameraID = "-1";
        this.mCameraECInfo = new ExposureCompensationInfo();
        this.mEnableFallBack = true;
        this.mForceSwitchEnable = false;
        this.mHighFPS = 0;
        this.mCameraFrameRateStrategy = 0;
        this.mIsUseHint = false;
        this.mIsCameraOpenCloseSync = false;
        this.mIsForceCloseCamera = false;
        this.mEnableVBoost = false;
        this.mVBoostTimeoutMS = 50;
        this.mEnableStabilization = false;
        this.mEnableAiNightVideo = false;
        this.mFocusTimeoutMS = 2500;
        this.mEnableGcForCameraMetadataThreshold = 0;
        this.mFpsMaxLimit = 30;
        this.mOptCameraSceneFps = false;
        this.mEnableRecordStream = false;
        this.mEnableRecord60Fps = false;
        this.mRecordStreamFolderPath = "";
        this.mFlashMode = 0;
        this.mAWBValue = "auto";
        this.mCaptureFlashStrategy = 1;
        this.mEnablePreviewingFallback = false;
        this.mEnableBackGroundStrategy = false;
        this.mEnableOpenCamera1Opt = false;
        this.mEnableOpenCamera1Crs = false;
        this.CAMERA2_PREVIEWING_FAILED_COUNT = 5;
        this.mIgnoreCameraResetTaskOnDisconnected = false;
        this.mIsGetMetadata = false;
        this.mEnableCamera2DeferredSurface = false;
        this.mBindSurfaceLifecycleToCamera = false;
        this.mEnableYuvBufferCapture = false;
        this.mCameraPreviewIndependent = false;
        this.mEnableCamera2Detect = false;
        this.mMaxZoomRatio = -1.0f;
        this.mMinZoomRatio = -1.0f;
        this.mEnableCollectCapbilities = false;
        this.mEnableCameraFpsDoubleCheckInImageMode = true;
        this.mDefaultZoomRatio = 1.0f;
        this.arConfig = null;
        this.mContext = context;
    }

    public void clean() {
        this.mContext = null;
        this.mExtParameters.clear();
    }

    public TEFrameSizei getPictureSize() {
        return this.mPictureSize;
    }

    public TEFrameSizei getPreviewSize() {
        return this.mPreviewSize;
    }

    public boolean isValid() {
        return this.mContext != null && this.mPreviewSize.isValid() && this.mPictureSize.isValid() && this.mFPSRange.isValid();
    }

    public void setPictureSize(TEFrameSizei tEFrameSizei) {
        this.mPictureSize = tEFrameSizei;
    }

    public void setPreviewSize(TEFrameSizei tEFrameSizei) {
        this.mPreviewSize = tEFrameSizei;
    }

    public TECameraSettings(@NonNull Context context, int i) {
        this.mCameraType = 1;
        this.mFPSRange = new TEFrameRateRange(7, 30);
        this.mFacing = 0;
        this.mRotation = 0;
        this.mDefaultCameraID = -1;
        this.mImageFormat = 17;
        this.mEnableCamera2Zsl = false;
        this.mEnableZsl = false;
        this.mEnableManualReleaseCaptureResult = true;
        this.mUseSyncModeOnCamera2 = false;
        this.mEnableWideFOV = false;
        this.mEnableRefactorFocusAndMeter = false;
        this.mEnableMonitorGyroscope = false;
        this.mStartRecord = false;
        this.mCameraZoomLimitFactor = -1.0f;
        this.mPreviewSize = new TEFrameSizei(1280, 720);
        this.mPictureSize = new TEFrameSizei(TECameraUtils.CAPTURE_NORMAL, FunDC.ID_AUTH_1080);
        this.mVideoSize = new TEFrameSizei(TECameraUtils.CAPTURE_NORMAL, FunDC.ID_AUTH_1080);
        this.mOutputType = 1;
        this.mMaxWidth = 0;
        this.mRetryCnt = 0;
        this.mRetryStartPreviewCnt = 0;
        this.mCamera2RetryCnt = 1;
        this.mMaxWidthTakePictureSizeAccuracy = 0.0f;
        this.mUseMaxWidthTakePicture = false;
        this.mForceApplyPictureSize = false;
        this.mMode = 0;
        this.mCameraHardwareSupportLevel = 1;
        this.mRequiredCameraLevel = 1;
        this.mExtParameters = new Bundle();
        this.mOptionFlags = (byte) 1;
        this.mSceneMode = "auto";
        this.mStrCameraID = "0";
        this.mVendorCameraID = "0";
        this.mStrCustomizedCameraID = "-1";
        this.mCameraECInfo = new ExposureCompensationInfo();
        this.mEnableFallBack = true;
        this.mForceSwitchEnable = false;
        this.mHighFPS = 0;
        this.mCameraFrameRateStrategy = 0;
        this.mIsUseHint = false;
        this.mIsCameraOpenCloseSync = false;
        this.mIsForceCloseCamera = false;
        this.mEnableVBoost = false;
        this.mVBoostTimeoutMS = 50;
        this.mEnableStabilization = false;
        this.mEnableAiNightVideo = false;
        this.mFocusTimeoutMS = 2500;
        this.mEnableGcForCameraMetadataThreshold = 0;
        this.mFpsMaxLimit = 30;
        this.mOptCameraSceneFps = false;
        this.mEnableRecordStream = false;
        this.mEnableRecord60Fps = false;
        this.mRecordStreamFolderPath = "";
        this.mFlashMode = 0;
        this.mAWBValue = "auto";
        this.mCaptureFlashStrategy = 1;
        this.mEnablePreviewingFallback = false;
        this.mEnableBackGroundStrategy = false;
        this.mEnableOpenCamera1Opt = false;
        this.mEnableOpenCamera1Crs = false;
        this.CAMERA2_PREVIEWING_FAILED_COUNT = 5;
        this.mIgnoreCameraResetTaskOnDisconnected = false;
        this.mIsGetMetadata = false;
        this.mEnableCamera2DeferredSurface = false;
        this.mBindSurfaceLifecycleToCamera = false;
        this.mEnableYuvBufferCapture = false;
        this.mCameraPreviewIndependent = false;
        this.mEnableCamera2Detect = false;
        this.mMaxZoomRatio = -1.0f;
        this.mMinZoomRatio = -1.0f;
        this.mEnableCollectCapbilities = false;
        this.mEnableCameraFpsDoubleCheckInImageMode = true;
        this.mDefaultZoomRatio = 1.0f;
        this.arConfig = null;
        this.mContext = context;
        this.mCameraType = i;
    }

    public TECameraSettings(@NonNull Context context, int i, int i2, int i3) {
        this.mCameraType = 1;
        this.mFPSRange = new TEFrameRateRange(7, 30);
        this.mFacing = 0;
        this.mRotation = 0;
        this.mDefaultCameraID = -1;
        this.mImageFormat = 17;
        this.mEnableCamera2Zsl = false;
        this.mEnableZsl = false;
        this.mEnableManualReleaseCaptureResult = true;
        this.mUseSyncModeOnCamera2 = false;
        this.mEnableWideFOV = false;
        this.mEnableRefactorFocusAndMeter = false;
        this.mEnableMonitorGyroscope = false;
        this.mStartRecord = false;
        this.mCameraZoomLimitFactor = -1.0f;
        this.mPreviewSize = new TEFrameSizei(1280, 720);
        this.mPictureSize = new TEFrameSizei(TECameraUtils.CAPTURE_NORMAL, FunDC.ID_AUTH_1080);
        this.mVideoSize = new TEFrameSizei(TECameraUtils.CAPTURE_NORMAL, FunDC.ID_AUTH_1080);
        this.mOutputType = 1;
        this.mMaxWidth = 0;
        this.mRetryCnt = 0;
        this.mRetryStartPreviewCnt = 0;
        this.mCamera2RetryCnt = 1;
        this.mMaxWidthTakePictureSizeAccuracy = 0.0f;
        this.mUseMaxWidthTakePicture = false;
        this.mForceApplyPictureSize = false;
        this.mMode = 0;
        this.mCameraHardwareSupportLevel = 1;
        this.mRequiredCameraLevel = 1;
        this.mExtParameters = new Bundle();
        this.mOptionFlags = (byte) 1;
        this.mSceneMode = "auto";
        this.mStrCameraID = "0";
        this.mVendorCameraID = "0";
        this.mStrCustomizedCameraID = "-1";
        this.mCameraECInfo = new ExposureCompensationInfo();
        this.mEnableFallBack = true;
        this.mForceSwitchEnable = false;
        this.mHighFPS = 0;
        this.mCameraFrameRateStrategy = 0;
        this.mIsUseHint = false;
        this.mIsCameraOpenCloseSync = false;
        this.mIsForceCloseCamera = false;
        this.mEnableVBoost = false;
        this.mVBoostTimeoutMS = 50;
        this.mEnableStabilization = false;
        this.mEnableAiNightVideo = false;
        this.mFocusTimeoutMS = 2500;
        this.mEnableGcForCameraMetadataThreshold = 0;
        this.mFpsMaxLimit = 30;
        this.mOptCameraSceneFps = false;
        this.mEnableRecordStream = false;
        this.mEnableRecord60Fps = false;
        this.mRecordStreamFolderPath = "";
        this.mFlashMode = 0;
        this.mAWBValue = "auto";
        this.mCaptureFlashStrategy = 1;
        this.mEnablePreviewingFallback = false;
        this.mEnableBackGroundStrategy = false;
        this.mEnableOpenCamera1Opt = false;
        this.mEnableOpenCamera1Crs = false;
        this.CAMERA2_PREVIEWING_FAILED_COUNT = 5;
        this.mIgnoreCameraResetTaskOnDisconnected = false;
        this.mIsGetMetadata = false;
        this.mEnableCamera2DeferredSurface = false;
        this.mBindSurfaceLifecycleToCamera = false;
        this.mEnableYuvBufferCapture = false;
        this.mCameraPreviewIndependent = false;
        this.mEnableCamera2Detect = false;
        this.mMaxZoomRatio = -1.0f;
        this.mMinZoomRatio = -1.0f;
        this.mEnableCollectCapbilities = false;
        this.mEnableCameraFpsDoubleCheckInImageMode = true;
        this.mDefaultZoomRatio = 1.0f;
        this.arConfig = null;
        this.mContext = context;
        this.mCameraType = i;
        TEFrameSizei tEFrameSizei = this.mPreviewSize;
        tEFrameSizei.width = i2;
        tEFrameSizei.height = i3;
    }

    public TECameraSettings(@NonNull Context context, int i, int i2, int i3, int i4, int i5) {
        this(context, i, i2, i3, i4, i5, false);
    }

    public TECameraSettings(@NonNull Context context, int i, int i2, int i3, int i4, int i5, boolean z) {
        this.mCameraType = 1;
        this.mFPSRange = new TEFrameRateRange(7, 30);
        this.mFacing = 0;
        this.mRotation = 0;
        this.mDefaultCameraID = -1;
        this.mImageFormat = 17;
        this.mEnableCamera2Zsl = false;
        this.mEnableZsl = false;
        this.mEnableManualReleaseCaptureResult = true;
        this.mUseSyncModeOnCamera2 = false;
        this.mEnableWideFOV = false;
        this.mEnableRefactorFocusAndMeter = false;
        this.mEnableMonitorGyroscope = false;
        this.mStartRecord = false;
        this.mCameraZoomLimitFactor = -1.0f;
        this.mPreviewSize = new TEFrameSizei(1280, 720);
        this.mPictureSize = new TEFrameSizei(TECameraUtils.CAPTURE_NORMAL, FunDC.ID_AUTH_1080);
        this.mVideoSize = new TEFrameSizei(TECameraUtils.CAPTURE_NORMAL, FunDC.ID_AUTH_1080);
        this.mOutputType = 1;
        this.mMaxWidth = 0;
        this.mRetryCnt = 0;
        this.mRetryStartPreviewCnt = 0;
        this.mCamera2RetryCnt = 1;
        this.mMaxWidthTakePictureSizeAccuracy = 0.0f;
        this.mUseMaxWidthTakePicture = false;
        this.mForceApplyPictureSize = false;
        this.mMode = 0;
        this.mCameraHardwareSupportLevel = 1;
        this.mRequiredCameraLevel = 1;
        this.mExtParameters = new Bundle();
        this.mOptionFlags = (byte) 1;
        this.mSceneMode = "auto";
        this.mStrCameraID = "0";
        this.mVendorCameraID = "0";
        this.mStrCustomizedCameraID = "-1";
        this.mCameraECInfo = new ExposureCompensationInfo();
        this.mEnableFallBack = true;
        this.mForceSwitchEnable = false;
        this.mHighFPS = 0;
        this.mCameraFrameRateStrategy = 0;
        this.mIsUseHint = false;
        this.mIsCameraOpenCloseSync = false;
        this.mIsForceCloseCamera = false;
        this.mEnableVBoost = false;
        this.mVBoostTimeoutMS = 50;
        this.mEnableStabilization = false;
        this.mEnableAiNightVideo = false;
        this.mFocusTimeoutMS = 2500;
        this.mEnableGcForCameraMetadataThreshold = 0;
        this.mFpsMaxLimit = 30;
        this.mOptCameraSceneFps = false;
        this.mEnableRecordStream = false;
        this.mEnableRecord60Fps = false;
        this.mRecordStreamFolderPath = "";
        this.mFlashMode = 0;
        this.mAWBValue = "auto";
        this.mCaptureFlashStrategy = 1;
        this.mEnablePreviewingFallback = false;
        this.mEnableBackGroundStrategy = false;
        this.mEnableOpenCamera1Opt = false;
        this.mEnableOpenCamera1Crs = false;
        this.CAMERA2_PREVIEWING_FAILED_COUNT = 5;
        this.mIgnoreCameraResetTaskOnDisconnected = false;
        this.mIsGetMetadata = false;
        this.mEnableCamera2DeferredSurface = false;
        this.mBindSurfaceLifecycleToCamera = false;
        this.mEnableYuvBufferCapture = false;
        this.mCameraPreviewIndependent = false;
        this.mEnableCamera2Detect = false;
        this.mMaxZoomRatio = -1.0f;
        this.mMinZoomRatio = -1.0f;
        this.mEnableCollectCapbilities = false;
        this.mEnableCameraFpsDoubleCheckInImageMode = true;
        this.mDefaultZoomRatio = 1.0f;
        this.arConfig = null;
        this.mContext = context;
        this.mCameraType = i;
        TEFrameSizei tEFrameSizei = this.mPreviewSize;
        tEFrameSizei.width = i2;
        tEFrameSizei.height = i3;
        tEFrameSizei.width = i4;
        tEFrameSizei.height = i5;
        this.mEnableZsl = z;
    }
}
