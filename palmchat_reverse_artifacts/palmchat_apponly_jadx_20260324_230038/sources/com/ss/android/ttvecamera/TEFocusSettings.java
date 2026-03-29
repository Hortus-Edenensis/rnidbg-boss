package com.ss.android.ttvecamera;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.ttvecamera.ITECameraArea;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TEFocusSettings {
    private ITECameraArea.ITECameraFocusArea mCameraFocusArea;
    private ITECameraArea.ITECameraMeteringArea mCameraMeteringArea;
    private CoordinatesMode mCoordinatesMode;
    private final float mDisplayDensity;
    private ITEFocusCallback mFocusCallback;
    private boolean mFromUser;
    private final int mHeight;
    private boolean mIsLock;
    private boolean mNeedFocus;
    private boolean mNeedMetering;
    private long mStartTimeMS;
    private final int mWidth;
    private final int mX;
    private final int mY;

    /* JADX INFO: compiled from: SearchBox */
    public enum CoordinatesMode {
        VIEW,
        ORIGINAL_FRAME
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface ITEFocusCallback {
        void onFocus(int i, int i2, String str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class TEFocusNullCallback implements ITEFocusCallback {
        private TEFocusNullCallback() {
        }

        @Override // com.ss.android.ttvecamera.TEFocusSettings.ITEFocusCallback
        public void onFocus(int i, int i2, String str) {
            if (i > 0) {
                TELogUtils.d("TEFocusNullCallback", "Focus done, cost: " + i + "ms");
            } else {
                TELogUtils.i("TEFocusNullCallback", "Focus failed, error code: " + i + ", msg: " + str);
            }
            TELogUtils.printStackTrace();
        }
    }

    public TEFocusSettings(int i, int i2, int i3, int i4, float f) {
        this.mNeedFocus = true;
        this.mNeedMetering = true;
        this.mIsLock = false;
        this.mFromUser = true;
        this.mCoordinatesMode = CoordinatesMode.VIEW;
        this.mCameraFocusArea = null;
        this.mCameraMeteringArea = null;
        this.mFocusCallback = new TEFocusNullCallback();
        this.mWidth = i;
        this.mHeight = i2;
        this.mX = i3;
        this.mY = i4;
        this.mDisplayDensity = f;
    }

    public Rect calculateFocusArea(int i, boolean z) {
        ITECameraArea.ITECameraFocusArea iTECameraFocusArea = this.mCameraFocusArea;
        if (iTECameraFocusArea != null) {
            return iTECameraFocusArea.calculateArea(this.mWidth, this.mHeight, this.mX, this.mY, i, z).get(0).rect;
        }
        return null;
    }

    public Rect calculateMeteringArea(int i, boolean z) {
        ITECameraArea.ITECameraMeteringArea iTECameraMeteringArea = this.mCameraMeteringArea;
        if (iTECameraMeteringArea != null) {
            return iTECameraMeteringArea.calculateArea(this.mWidth, this.mHeight, this.mX, this.mY, i, z).get(0).rect;
        }
        return null;
    }

    @Nullable
    public ITECameraArea.ITECameraFocusArea getCameraFocusArea() {
        return this.mCameraFocusArea;
    }

    @NonNull
    public ITECameraArea.ITECameraMeteringArea getCameraMeteringArea() {
        return this.mCameraMeteringArea;
    }

    public CoordinatesMode getCoordinatesMode() {
        return this.mCoordinatesMode;
    }

    public float getDisplayDensity() {
        return this.mDisplayDensity;
    }

    public ITEFocusCallback getFocusCallback() {
        return this.mFocusCallback;
    }

    public int getFocusConsumingMS() {
        return (int) (System.currentTimeMillis() - this.mStartTimeMS);
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getX() {
        return this.mX;
    }

    public int getY() {
        return this.mY;
    }

    public boolean isFromUser() {
        return this.mFromUser;
    }

    public boolean isLock() {
        return this.mIsLock;
    }

    public boolean isNeedFocus() {
        return this.mNeedFocus;
    }

    public boolean isNeedMetering() {
        return this.mNeedMetering;
    }

    public void markStartTimeMS() {
        this.mStartTimeMS = System.currentTimeMillis();
    }

    public void setCameraFocusArea(@Nullable ITECameraArea.ITECameraFocusArea iTECameraFocusArea) {
        this.mCameraFocusArea = iTECameraFocusArea;
    }

    public void setCameraMeteringArea(@Nullable ITECameraArea.ITECameraMeteringArea iTECameraMeteringArea) {
        this.mCameraMeteringArea = iTECameraMeteringArea;
    }

    public void setCoordinatesMode(CoordinatesMode coordinatesMode) {
        this.mCoordinatesMode = coordinatesMode;
    }

    public void setFocusCallback(ITEFocusCallback iTEFocusCallback) {
        if (iTEFocusCallback != null) {
            this.mFocusCallback = iTEFocusCallback;
        } else {
            this.mFocusCallback = new TEFocusNullCallback();
        }
    }

    public void setFromUser(boolean z) {
        this.mFromUser = z;
    }

    public void setLock(boolean z) {
        this.mIsLock = z;
    }

    public void setNeedFocus(boolean z) {
        this.mNeedFocus = z;
    }

    public void setNeedMetering(boolean z) {
        this.mNeedMetering = z;
    }

    public String toString() {
        return "TEFocusSettings{width =" + this.mWidth + ", height =" + this.mHeight + ", x =" + this.mX + ", y =" + this.mY + ", need focus =" + this.mNeedFocus + ", need meter =" + this.mNeedMetering + ", lock =" + this.mIsLock + ", from user=" + this.mFromUser + ", CoordinatesMode" + this.mCoordinatesMode + '}';
    }

    public TEFocusSettings(int i, int i2, int i3, int i4, float f, ITEFocusCallback iTEFocusCallback) {
        this.mNeedFocus = true;
        this.mNeedMetering = true;
        this.mIsLock = false;
        this.mFromUser = true;
        this.mCoordinatesMode = CoordinatesMode.VIEW;
        this.mCameraFocusArea = null;
        this.mCameraMeteringArea = null;
        this.mFocusCallback = new TEFocusNullCallback();
        this.mWidth = i;
        this.mHeight = i2;
        this.mX = i3;
        this.mY = i4;
        this.mDisplayDensity = f;
        if (iTEFocusCallback != null) {
            this.mFocusCallback = iTEFocusCallback;
        }
    }
}
