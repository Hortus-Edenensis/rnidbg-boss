package com.zenmen.media.crop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.TypedValue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class Thumb {
    private static final int DEFAULT_THUMB_COLOR_NORMAL = -13388315;
    private static final int DEFAULT_THUMB_COLOR_PRESSED = -13388315;
    private static final float DEFAULT_THUMB_RADIUS_DP = 14.0f;
    private static final float MINIMUM_TARGET_RADIUS_DP = 24.0f;
    private final float mHalfHeightNormal;
    private final float mHalfHeightPressed;
    private final float mHalfWidthNormal;
    private final float mHalfWidthPressed;
    private Bitmap mImageNormal;
    private Bitmap mImagePressed;
    private boolean mIsPressed = false;
    private Paint mPaintNormal;
    private Paint mPaintPressed;
    private final float mTargetRadiusPx;
    private int mThumbColorNormal;
    private int mThumbColorPressed;
    private float mThumbRadiusPx;
    private boolean mUseBitmap;
    private float mX;
    private final float mY;

    public Thumb(Context context, float f, int i, int i2, float f2, int i3, int i4) {
        Resources resources = context.getResources();
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(resources, i3);
        this.mImageNormal = zoomImg(bitmapDecodeResource, bitmapDecodeResource.getWidth() / 2, bitmapDecodeResource.getHeight());
        this.mImagePressed = zoomImg(bitmapDecodeResource, bitmapDecodeResource.getWidth() / 2, bitmapDecodeResource.getHeight());
        if (f2 == -1.0f && i == -1 && i2 == -1) {
            this.mUseBitmap = true;
        } else {
            this.mUseBitmap = false;
            if (f2 == -1.0f) {
                this.mThumbRadiusPx = TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics());
            } else {
                this.mThumbRadiusPx = TypedValue.applyDimension(1, f2, resources.getDisplayMetrics());
            }
            if (i == -1) {
                this.mThumbColorNormal = -13388315;
            } else {
                this.mThumbColorNormal = i;
            }
            if (i2 == -1) {
                this.mThumbColorPressed = -13388315;
            } else {
                this.mThumbColorPressed = i2;
            }
            Paint paint = new Paint();
            this.mPaintNormal = paint;
            paint.setColor(this.mThumbColorNormal);
            this.mPaintNormal.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.mPaintPressed = paint2;
            paint2.setColor(this.mThumbColorPressed);
            this.mPaintPressed.setAntiAlias(true);
        }
        float width = this.mImageNormal.getWidth() / 2.0f;
        this.mHalfWidthNormal = width;
        this.mHalfHeightNormal = this.mImageNormal.getHeight() / 2.0f;
        this.mHalfWidthPressed = this.mImagePressed.getWidth() / 2.0f;
        this.mHalfHeightPressed = this.mImagePressed.getHeight() / 2.0f;
        this.mTargetRadiusPx = TypedValue.applyDimension(1, (int) Math.max(MINIMUM_TARGET_RADIUS_DP, f2), resources.getDisplayMetrics());
        this.mX = width;
        this.mY = f;
    }

    public static int getDefaultThumbColorNormal() {
        return -13388315;
    }

    public static int getDefaultThumbColorPressed() {
        return -13388315;
    }

    public static float getDefaultThumbRadiusDp() {
        return 14.0f;
    }

    public static float getMinimumTargetRadiusDp() {
        return MINIMUM_TARGET_RADIUS_DP;
    }

    public static Bitmap zoomImg(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void draw(Canvas canvas) {
        if (!this.mUseBitmap) {
            if (this.mIsPressed) {
                canvas.drawCircle(this.mX, this.mY, this.mThumbRadiusPx, this.mPaintPressed);
                return;
            } else {
                canvas.drawCircle(this.mX, this.mY, this.mThumbRadiusPx, this.mPaintNormal);
                return;
            }
        }
        boolean z = this.mIsPressed;
        Bitmap bitmap = z ? this.mImagePressed : this.mImageNormal;
        if (z) {
            canvas.drawBitmap(bitmap, this.mX - this.mHalfWidthPressed, this.mY - this.mHalfHeightPressed, (Paint) null);
        } else {
            canvas.drawBitmap(bitmap, this.mX - this.mHalfWidthNormal, this.mY - this.mHalfHeightNormal, (Paint) null);
        }
    }

    public float getHalfHeight() {
        return this.mHalfHeightNormal;
    }

    public float getHalfWidth() {
        return this.mHalfWidthNormal;
    }

    public float getX() {
        return this.mX;
    }

    public float getmHalfHeightNormal() {
        return this.mHalfHeightNormal;
    }

    public float getmHalfHeightPressed() {
        return this.mHalfHeightPressed;
    }

    public float getmHalfWidthNormal() {
        return this.mHalfWidthNormal;
    }

    public float getmHalfWidthPressed() {
        return this.mHalfWidthPressed;
    }

    public Bitmap getmImageNormal() {
        return this.mImageNormal;
    }

    public Bitmap getmImagePressed() {
        return this.mImagePressed;
    }

    public Paint getmPaintNormal() {
        return this.mPaintNormal;
    }

    public Paint getmPaintPressed() {
        return this.mPaintPressed;
    }

    public float getmTargetRadiusPx() {
        return this.mTargetRadiusPx;
    }

    public int getmThumbColorNormal() {
        return this.mThumbColorNormal;
    }

    public int getmThumbColorPressed() {
        return this.mThumbColorPressed;
    }

    public float getmThumbRadiusPx() {
        return this.mThumbRadiusPx;
    }

    public float getmX() {
        return this.mX;
    }

    public float getmY() {
        return this.mY;
    }

    public boolean isInTargetZone(float f, float f2) {
        return Math.abs(f - this.mX) <= this.mTargetRadiusPx && Math.abs(f2 - this.mY) <= this.mTargetRadiusPx;
    }

    public boolean isPressed() {
        return this.mIsPressed;
    }

    public boolean ismIsPressed() {
        return this.mIsPressed;
    }

    public boolean ismUseBitmap() {
        return this.mUseBitmap;
    }

    public void press() {
        this.mIsPressed = true;
    }

    public void release() {
        this.mIsPressed = false;
    }

    public void setX(float f) {
        this.mX = f;
    }
}
