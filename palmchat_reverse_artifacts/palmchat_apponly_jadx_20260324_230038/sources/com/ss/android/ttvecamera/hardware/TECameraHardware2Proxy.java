package com.ss.android.ttvecamera.hardware;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.ss.android.ttvecamera.TECameraMonitor;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ttvecamera.TEFrameRateRange;
import com.ss.android.ttvecamera.TELogUtils;
import java.text.DecimalFormat;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@RequiresApi(api = 21)
public class TECameraHardware2Proxy {
    private static final String TAG = "TECameraHardware2Proxy";
    public static int mCameraType = 1;
    protected static String mWideCameraID = "-1";
    protected Context mContext;

    public TECameraHardware2Proxy(Context context) {
        this.mContext = context;
    }

    public static TECameraHardware2Proxy getDeviceProxy(Context context, @TECameraSettings.CameraType int i) {
        TECameraHardware2Proxy tECameraHardware2Proxy;
        TELogUtils.i(TAG, "getDeviceProxy, cameraType: " + i);
        mCameraType = i;
        synchronized (TECameraHardware2Proxy.class) {
            if (i == 6) {
                tECameraHardware2Proxy = new TECameraBEWOProxy(context);
            } else if (TECameraHardware2.isSSPlatform()) {
                tECameraHardware2Proxy = new TECameraSSProxy(context);
            } else if (TECameraHardware2.isQCOMPlatform()) {
                tECameraHardware2Proxy = new TECameraQcomProxy(context);
            } else if (TECameraHardware2.isMTKPlatform()) {
                tECameraHardware2Proxy = new TECameraMTKProxy(context);
            } else if (TECameraHardware2.isHWPlatform()) {
                tECameraHardware2Proxy = new TECameraHWProxy(context);
            } else {
                TELogUtils.e(TAG, "Unknown platform");
                tECameraHardware2Proxy = new TECameraHardware2Proxy(context);
            }
        }
        return tECameraHardware2Proxy;
    }

    public int configStabilization(@NonNull CameraCharacteristics cameraCharacteristics, @NonNull CaptureRequest.Builder builder, boolean z) {
        if (cameraCharacteristics == null || builder == null) {
            return -100;
        }
        if (!z) {
            TELogUtils.i(TAG, "configStabilization not toggle");
            builder.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, 0);
            builder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 0);
            return 0;
        }
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
        if (iArr != null) {
            for (int i : iArr) {
                TELogUtils.i(TAG, "EIS mode: " + i);
                if (i == 1) {
                    builder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 1);
                    builder.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, 0);
                    TELogUtils.i(TAG, "Enable EIS");
                    return 0;
                }
            }
        } else {
            TELogUtils.i(TAG, "Don't supported EIS");
        }
        int[] iArr2 = (int[]) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
        if (iArr2 == null) {
            TELogUtils.i(TAG, "Don't supported OIS");
            return -200;
        }
        for (int i2 : iArr2) {
            TELogUtils.i(TAG, "OIS mode: " + i2);
            if (i2 == 1) {
                builder.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, 1);
                builder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 0);
                TELogUtils.i(TAG, "Enable OIS");
                return 0;
            }
        }
        return -200;
    }

    public void fillWideCameraID(int i, CameraManager cameraManager) {
        try {
            mWideCameraID = getWideAngleID(cameraManager.getCameraIdList(), cameraManager);
            TELogUtils.i(TAG, "fillWideCameraID mWideCameraID = " + mWideCameraID);
        } catch (CameraAccessException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public TEFrameRateRange getFPSRange(CameraCharacteristics cameraCharacteristics, int i, int i2, int i3, int i4) {
        Range[] rangeArr;
        TEFrameRateRange tEFrameRateRange = new TEFrameRateRange(i, i2);
        if (cameraCharacteristics == null || (rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES)) == null) {
            return tEFrameRateRange;
        }
        ArrayList arrayList = new ArrayList(rangeArr.length);
        int i5 = tEFrameRateRange.fpsUnitFactor;
        int i6 = 0;
        for (Range range : rangeArr) {
            int[] iArr = {((Integer) range.getLower()).intValue() * i5, ((Integer) range.getUpper()).intValue() * i5};
            arrayList.add(iArr);
            int i7 = iArr[1];
            if (i6 < i7) {
                i6 = i7;
            }
        }
        TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_MAX_FPS, i6);
        int[] fpsRange = TECameraUtils.getFpsRange(i3, i4, tEFrameRateRange.getRealFpsRange(), arrayList);
        tEFrameRateRange.min = fpsRange[0];
        tEFrameRateRange.max = fpsRange[1];
        return tEFrameRateRange;
    }

    public String getFilledWideCameraId() {
        return mWideCameraID;
    }

    public float getMaxZoomValue(@NonNull CameraCharacteristics cameraCharacteristics, int i, float f) {
        Float f2 = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f2 == null) {
            return 0.0f;
        }
        float fFloatValue = f2.floatValue();
        return f == -1.0f ? i != 6 ? fFloatValue / 2.0f : fFloatValue : fFloatValue * f;
    }

    public float getShaderZoomStep(@NonNull CameraCharacteristics cameraCharacteristics) {
        float fFloatValue = ((Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
        Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        try {
            return Float.valueOf(new DecimalFormat("0.00").format(((rect.width() - ((int) (rect.width() / fFloatValue))) / fFloatValue) / rect.width()).trim()).floatValue();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0.01f;
        }
    }

    public String getTelephotoID() {
        CameraManager cameraManager = (CameraManager) this.mContext.getSystemService("camera");
        try {
            return getTelephotoID(cameraManager.getCameraIdList(), cameraManager);
        } catch (CameraAccessException | IllegalArgumentException e) {
            e.printStackTrace();
            return "0";
        }
    }

    public String getWideAngleID() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        CameraManager cameraManager = (CameraManager) this.mContext.getSystemService("camera");
        try {
            String wideAngleID = getWideAngleID(cameraManager.getCameraIdList(), cameraManager);
            TELogUtils.i(TAG, "getWideAngleID, cost time = " + (System.currentTimeMillis() - jCurrentTimeMillis));
            return wideAngleID;
        } catch (Throwable th) {
            TELogUtils.e(TAG, "exception occurs when getWideAngleID", th);
            return "0";
        }
    }

    public Range<Float> getZoomValueRange(@NonNull CameraCharacteristics cameraCharacteristics) {
        Range<Float> range;
        return (Build.VERSION.SDK_INT < 30 || (range = (Range) cameraCharacteristics.get(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE)) == null) ? new Range<>(Float.valueOf(0.0f), (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)) : range;
    }

    public boolean isARCoreSupported() {
        return false;
    }

    public boolean isEISSupported(@NonNull CameraCharacteristics cameraCharacteristics) {
        int[] iArr;
        return (cameraCharacteristics == null || (iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES)) == null || iArr.length <= 0) ? false : true;
    }

    public boolean isFocusSupported(@NonNull CameraCharacteristics cameraCharacteristics) {
        return cameraCharacteristics != null && ((Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() >= 1;
    }

    public boolean isHardwareLevelSupported(CameraCharacteristics cameraCharacteristics, int i) {
        if (cameraCharacteristics == null) {
            return false;
        }
        Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        int iIntValue = num != null ? num.intValue() : -1;
        if (iIntValue < 0 || iIntValue > 4) {
            TELogUtils.e(TAG, "Invalid hardware level = " + iIntValue);
            return false;
        }
        int i2 = TECameraHardware2.CameraHWLevelAndroid2VE[iIntValue];
        TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_HARDWARE_LEVEL, i2);
        if (Build.VERSION.SDK_INT < 22 && iIntValue == 2) {
            return false;
        }
        if (i2 >= i) {
            TELogUtils.i(TAG, "Camera hardware level supported, deviceLevel = " + i2 + ", require = " + i);
            return true;
        }
        TELogUtils.e(TAG, "Camera hardware level not supported, deviceLevel = " + i2 + ", require = " + i);
        return false;
    }

    public boolean isLogicalMultiCamSupported(@NonNull CameraCharacteristics cameraCharacteristics) {
        if (cameraCharacteristics == null) {
            return false;
        }
        for (int i : (int[]) cameraCharacteristics.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES)) {
            if (i == 11) {
                return true;
            }
        }
        return false;
    }

    public boolean isMeteringSupported(@NonNull CameraCharacteristics cameraCharacteristics) {
        return cameraCharacteristics != null && ((Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE)).intValue() >= 1;
    }

    public boolean isOISSupported(@NonNull CameraCharacteristics cameraCharacteristics) {
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
        if (iArr != null) {
            for (int i : iArr) {
                if (i == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public boolean isStabilizationSupported(@NonNull CameraCharacteristics cameraCharacteristics) {
        boolean zIsEISSupported = isEISSupported(cameraCharacteristics);
        ?? r0 = zIsEISSupported;
        if (isOISSupported(cameraCharacteristics)) {
            r0 = (zIsEISSupported ? 1 : 0) | 2;
        }
        TELogUtils.i(TAG, "Stabilization type: " + Integer.toBinaryString(r0));
        TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_STABILIZATION, (long) r0);
        return r0 > 0;
    }

    public boolean isSupportAntiShake(int i) {
        return false;
    }

    public boolean isSupportHDR(CameraCharacteristics cameraCharacteristics, int i) {
        return false;
    }

    public boolean isSupportHighFPS(CameraCharacteristics cameraCharacteristics) {
        return false;
    }

    public boolean isSupportTelephoto(CameraCharacteristics cameraCharacteristics) {
        return false;
    }

    public boolean isSupportWideAngle(CameraCharacteristics cameraCharacteristics) {
        return false;
    }

    public boolean isTorchSupported(CameraCharacteristics cameraCharacteristics) {
        return ((Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)).booleanValue();
    }

    public boolean isSupportTelephoto() {
        return !getTelephotoID().equals("0");
    }

    public boolean isSupportWideAngle() {
        return !getWideAngleID().equals("0");
    }

    public String getTelephotoID(String[] strArr, CameraManager cameraManager) {
        String str = "0";
        try {
            float f = Float.MIN_VALUE;
            for (String str2 : strArr) {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str2);
                Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                if (num == null || num.intValue() != 0) {
                    float[] fArr = (float[]) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
                    if (fArr == null || fArr.length == 0) {
                        fArr = new float[]{0.0f};
                    }
                    float f2 = fArr[0];
                    if (f2 > f) {
                        str = str2;
                        f = f2;
                    }
                }
            }
        } catch (CameraAccessException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        return str;
    }

    public String getWideAngleID(String[] strArr, CameraManager cameraManager) {
        String str = "0";
        try {
            float f = Float.MAX_VALUE;
            for (String str2 : strArr) {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str2);
                Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                if (num == null || num.intValue() != 0) {
                    float[] fArr = (float[]) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
                    float f2 = (fArr == null || fArr.length <= 0) ? -1.0f : fArr[0];
                    if (f2 != -1.0f && f2 <= f) {
                        str = str2;
                        f = f2;
                    }
                }
            }
            return str;
        } catch (Throwable th) {
            TELogUtils.e(TAG, "exception occurs when getWideAngleID: ", th);
            return str;
        }
    }
}
