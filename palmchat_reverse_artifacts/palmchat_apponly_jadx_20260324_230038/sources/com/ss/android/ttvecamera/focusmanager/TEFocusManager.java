package com.ss.android.ttvecamera.focusmanager;

import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.os.Build;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ttvecamera.TEFocusSettings;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TEFocusManager {
    public static final List<String> FOCUS_BLOCK_LIST;
    int mCameraFacing;

    @TECameraSettings.CameraType
    private int mCameraType;
    protected final int FOCUS_RADIUS = 90;
    protected final float FOCUS_AREA_DELTA = 1.0f;
    protected final float METERING_AREA_DELTA = 2.0f;
    private List<Camera.Area> mFocusAreas = new ArrayList();
    private List<Camera.Area> mMeteringAreas = new ArrayList();

    static {
        ArrayList arrayList = new ArrayList();
        FOCUS_BLOCK_LIST = arrayList;
        arrayList.add("multilaser");
        arrayList.add("ms40");
    }

    public TEFocusManager(@TECameraSettings.CameraType int i) {
        this.mCameraType = i;
    }

    public List<Camera.Area> calculateFocusArea(int i, int i2, float f, int i3, int i4, int i5, TEFocusSettings.CoordinatesMode coordinatesMode) {
        Rect rectCalculateTapArea = calculateTapArea(i, i2, f, 90.0f, i3, i4, i5, coordinatesMode);
        if (this.mFocusAreas.size() > 0) {
            this.mFocusAreas.clear();
        }
        this.mFocusAreas.add(new Camera.Area(rectCalculateTapArea, 1000));
        return this.mFocusAreas;
    }

    public List<Camera.Area> calculateMeteringArea(int i, int i2, float f, int i3, int i4, int i5, TEFocusSettings.CoordinatesMode coordinatesMode) {
        Rect rectCalculateTapArea = calculateTapArea(i, i2, f, 180.0f, i3, i4, i5, coordinatesMode);
        if (this.mMeteringAreas.size() > 0) {
            this.mMeteringAreas.clear();
        }
        this.mMeteringAreas.add(new Camera.Area(rectCalculateTapArea, 1000));
        return this.mMeteringAreas;
    }

    public Rect calculateTapArea(int i, int i2, float f, float f2, int i3, int i4, int i5, TEFocusSettings.CoordinatesMode coordinatesMode) {
        int iIntValue = Float.valueOf((f * f2) + 0.5f).intValue();
        int i6 = ((int) (((i3 * 2000) * 1.0f) / i)) - 1000;
        int i7 = ((int) (((i4 * 2000) * 1.0f) / i2)) - 1000;
        if (this.mCameraFacing == 1 && coordinatesMode == TEFocusSettings.CoordinatesMode.VIEW) {
            i6 = -i6;
        }
        int i8 = iIntValue / 2;
        int iClamp = TECameraUtils.clamp(i6 - i8, -1000, 1000);
        int iClamp2 = TECameraUtils.clamp(i7 - i8, -1000, 1000);
        Rect rect = new Rect();
        RectF rectF = new RectF(iClamp, iClamp2, TECameraUtils.clamp(iClamp + iIntValue), TECameraUtils.clamp(iClamp2 + iIntValue));
        Rect rect2 = new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        Rect rect3 = new Rect(-1000, -1000, 1000, 1000);
        if (coordinatesMode == TEFocusSettings.CoordinatesMode.VIEW) {
            TECameraUtils.rotateRectForOrientation(i5, rect3, rect2);
            rect = new Rect(rect2.left - 1000, rect2.top - 1000, rect2.right - 1000, rect2.bottom - 1000);
        } else if (coordinatesMode == TEFocusSettings.CoordinatesMode.ORIGINAL_FRAME) {
            rect = new Rect(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
        rect.left = TECameraUtils.clamp(rect.left);
        rect.right = TECameraUtils.clamp(rect.right);
        rect.top = TECameraUtils.clamp(rect.top);
        rect.bottom = TECameraUtils.clamp(rect.bottom);
        return rect;
    }

    public boolean isSupportedFocus(Camera.Parameters parameters) {
        return (parameters == null || FOCUS_BLOCK_LIST.contains(Build.BRAND.toLowerCase()) || parameters.getMaxNumFocusAreas() <= 0) ? false : true;
    }

    public boolean isSupportedMetering(@TECameraSettings.CameraFacing int i, Camera.Parameters parameters) {
        return parameters != null && parameters.getMaxNumMeteringAreas() > 0;
    }

    public String selectFocusMode(@TECameraSettings.CameraFacing int i, Camera.Parameters parameters, boolean z) {
        String str;
        if (parameters == null) {
            return "";
        }
        this.mCameraFacing = i;
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (i != 1) {
            if (supportedFocusModes.contains("continuous-video")) {
                return "continuous-video";
            }
            str = "continuous-picture";
            if (!supportedFocusModes.contains("continuous-picture")) {
                if (!supportedFocusModes.contains("auto")) {
                    return "";
                }
                return "auto";
            }
            return str;
        }
        if (z && supportedFocusModes.contains("continuous-video")) {
            return "continuous-video";
        }
        str = "macro";
        if (!supportedFocusModes.contains("macro")) {
            if (!supportedFocusModes.contains("auto")) {
                return "";
            }
            return "auto";
        }
        return str;
    }

    public boolean isSupportedFocus(Camera.Parameters parameters, String str) {
        if (isSupportedFocus(parameters)) {
            return parameters.getSupportedFocusModes().contains(str);
        }
        return false;
    }
}
