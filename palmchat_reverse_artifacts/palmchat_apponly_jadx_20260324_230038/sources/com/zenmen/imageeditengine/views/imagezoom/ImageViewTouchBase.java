package com.zenmen.imageeditengine.views.imagezoom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import defpackage.et1;
import defpackage.mr0;
import defpackage.vj1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public abstract class ImageViewTouchBase extends ImageView {
    protected static final boolean LOG_ENABLED = false;
    public static final String LOG_TAG = "ImageViewTouchBase";
    public static final float ZOOM_INVALID = -1.0f;
    protected final int DEFAULT_ANIMATION_DURATION;
    protected Matrix mBaseMatrix;
    private boolean mBitmapChanged;
    protected RectF mBitmapRect;
    private PointF mCenter;
    protected RectF mCenterRect;
    protected final Matrix mDisplayMatrix;
    private d mDrawableChangeListener;
    protected vj1 mEasing;
    protected Handler mHandler;
    protected Runnable mLayoutRunnable;
    protected final float[] mMatrixValues;
    private float mMaxZoom;
    private boolean mMaxZoomDefined;
    private float mMinZoom;
    private boolean mMinZoomDefined;
    protected Matrix mNextMatrix;
    private e mOnLayoutChangeListener;
    protected DisplayType mScaleType;
    private boolean mScaleTypeChanged;
    protected RectF mScrollRect;
    protected Matrix mSuppMatrix;
    private int mThisHeight;
    private int mThisWidth;
    protected boolean mUserScaled;

    /* JADX INFO: compiled from: SearchBox */
    public enum DisplayType {
        NONE,
        FIT_TO_SCREEN,
        FIT_IF_BIGGER
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Drawable f11837a;
        public final /* synthetic */ Matrix b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;

        public a(Drawable drawable, Matrix matrix, float f, float f2) {
            this.f11837a = drawable;
            this.b = matrix;
            this.c = f;
            this.d = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageViewTouchBase.this.setImageDrawable(this.f11837a, this.b, this.c, this.d);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public double f11838a = 0.0d;
        public double b = 0.0d;
        public final /* synthetic */ double c;
        public final /* synthetic */ long d;
        public final /* synthetic */ double e;
        public final /* synthetic */ double f;

        public b(double d, long j, double d2, double d3) {
            this.c = d;
            this.d = j;
            this.e = d2;
            this.f = d3;
        }

        @Override // java.lang.Runnable
        public void run() {
            double dMin = Math.min(this.c, System.currentTimeMillis() - this.d);
            double dA = ImageViewTouchBase.this.mEasing.a(dMin, 0.0d, this.e, this.c);
            double dA2 = ImageViewTouchBase.this.mEasing.a(dMin, 0.0d, this.f, this.c);
            ImageViewTouchBase.this.panBy(dA - this.f11838a, dA2 - this.b);
            this.f11838a = dA;
            this.b = dA2;
            if (dMin < this.c) {
                ImageViewTouchBase.this.mHandler.post(this);
                return;
            }
            ImageViewTouchBase imageViewTouchBase = ImageViewTouchBase.this;
            RectF center = imageViewTouchBase.getCenter(imageViewTouchBase.mSuppMatrix, true, true);
            float f = center.left;
            if (f == 0.0f && center.top == 0.0f) {
                return;
            }
            ImageViewTouchBase.this.scrollBy(f, center.top);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f11839a;
        public final /* synthetic */ long b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;
        public final /* synthetic */ float e;
        public final /* synthetic */ float f;

        public c(float f, long j, float f2, float f3, float f4, float f5) {
            this.f11839a = f;
            this.b = j;
            this.c = f2;
            this.d = f3;
            this.e = f4;
            this.f = f5;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMin = Math.min(this.f11839a, System.currentTimeMillis() - this.b);
            ImageViewTouchBase.this.zoomTo(this.d + ((float) ImageViewTouchBase.this.mEasing.b(fMin, 0.0d, this.c, this.f11839a)), this.e, this.f);
            if (fMin < this.f11839a) {
                ImageViewTouchBase.this.mHandler.post(this);
                return;
            }
            ImageViewTouchBase imageViewTouchBase = ImageViewTouchBase.this;
            imageViewTouchBase.onZoomAnimationCompleted(imageViewTouchBase.getScale());
            ImageViewTouchBase.this.center(true, true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
    }

    public ImageViewTouchBase(Context context) {
        super(context);
        this.mEasing = new mr0();
        this.mBaseMatrix = new Matrix();
        this.mSuppMatrix = new Matrix();
        this.mHandler = new Handler();
        this.mLayoutRunnable = null;
        this.mUserScaled = false;
        this.mMaxZoom = -1.0f;
        this.mMinZoom = -1.0f;
        this.mDisplayMatrix = new Matrix();
        this.mMatrixValues = new float[9];
        this.mThisWidth = -1;
        this.mThisHeight = -1;
        this.mCenter = new PointF();
        this.mScaleType = DisplayType.NONE;
        this.DEFAULT_ANIMATION_DURATION = 200;
        this.mBitmapRect = new RectF();
        this.mCenterRect = new RectF();
        this.mScrollRect = new RectF();
        init();
    }

    public void _setImageDrawable(Drawable drawable, Matrix matrix, float f, float f2) {
        if (drawable != null) {
            super.setImageDrawable(drawable);
        } else {
            this.mBaseMatrix.reset();
            super.setImageDrawable(null);
        }
        if (f == -1.0f || f2 == -1.0f) {
            this.mMinZoom = -1.0f;
            this.mMaxZoom = -1.0f;
            this.mMinZoomDefined = false;
            this.mMaxZoomDefined = false;
        } else {
            float fMin = Math.min(f, f2);
            float fMax = Math.max(fMin, f2);
            this.mMinZoom = fMin;
            this.mMaxZoom = fMax;
            this.mMinZoomDefined = true;
            this.mMaxZoomDefined = true;
            DisplayType displayType = this.mScaleType;
            if (displayType == DisplayType.FIT_TO_SCREEN || displayType == DisplayType.FIT_IF_BIGGER) {
                if (fMin >= 1.0f) {
                    this.mMinZoomDefined = false;
                    this.mMinZoom = -1.0f;
                }
                if (fMax <= 1.0f) {
                    this.mMaxZoomDefined = true;
                    this.mMaxZoom = -1.0f;
                }
            }
        }
        if (matrix != null) {
            this.mNextMatrix = new Matrix(matrix);
        }
        this.mBitmapChanged = true;
        requestLayout();
    }

    public void center(boolean z, boolean z2) {
        if (getDrawable() == null) {
            return;
        }
        RectF center = getCenter(this.mSuppMatrix, z, z2);
        float f = center.left;
        if (f == 0.0f && center.top == 0.0f) {
            return;
        }
        postTranslate(f, center.top);
    }

    public void clear() {
        setImageBitmap(null);
    }

    public float computeMaxZoom() {
        if (getDrawable() == null) {
            return 1.0f;
        }
        return Math.max(r0.getIntrinsicWidth() / this.mThisWidth, r0.getIntrinsicHeight() / this.mThisHeight) * 8.0f;
    }

    public float computeMinZoom() {
        if (getDrawable() == null) {
            return 1.0f;
        }
        return Math.min(1.0f, 1.0f / getScale(this.mBaseMatrix));
    }

    public void dispose() {
        clear();
    }

    public RectF getBitmapRect() {
        return getBitmapRect(this.mSuppMatrix);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RectF getCenter(Matrix matrix, boolean z, boolean z2) {
        float f;
        float f2;
        float f3;
        if (getDrawable() == null) {
            return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        }
        this.mCenterRect.set(0.0f, 0.0f, 0.0f, 0.0f);
        RectF bitmapRect = getBitmapRect(matrix);
        float fHeight = bitmapRect.height();
        float fWidth = bitmapRect.width();
        if (z2) {
            int i = this.mThisHeight;
            float f4 = i;
            if (fHeight < f4) {
                f = ((f4 - fHeight) / 2.0f) - bitmapRect.top;
            } else {
                float f5 = bitmapRect.top;
                if (f5 > 0.0f) {
                    f = -f5;
                } else {
                    float f6 = bitmapRect.bottom;
                    f = f6 < f4 ? i - f6 : 0.0f;
                }
            }
        }
        if (z) {
            float f7 = this.mThisWidth;
            if (fWidth < f7) {
                f7 = (f7 - fWidth) / 2.0f;
                f3 = bitmapRect.left;
            } else {
                float f8 = bitmapRect.left;
                if (f8 > 0.0f) {
                    f2 = -f8;
                } else {
                    f3 = bitmapRect.right;
                    if (f3 >= f7) {
                        f2 = 0.0f;
                    }
                }
            }
            f2 = f7 - f3;
        }
        this.mCenterRect.set(f2, f, 0.0f, 0.0f);
        return this.mCenterRect;
    }

    public float getDefaultScale(DisplayType displayType) {
        if (displayType == DisplayType.FIT_TO_SCREEN) {
            return 1.0f;
        }
        return displayType == DisplayType.FIT_IF_BIGGER ? Math.min(1.0f, 1.0f / getScale(this.mBaseMatrix)) : 1.0f / getScale(this.mBaseMatrix);
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(this.mSuppMatrix);
    }

    public DisplayType getDisplayType() {
        return this.mScaleType;
    }

    public Matrix getImageViewMatrix() {
        return getImageViewMatrix(this.mSuppMatrix);
    }

    public float getMaxScale() {
        if (this.mMaxZoom == -1.0f) {
            this.mMaxZoom = computeMaxZoom();
        }
        return this.mMaxZoom;
    }

    public float getMinScale() {
        if (this.mMinZoom == -1.0f) {
            this.mMinZoom = computeMinZoom();
        }
        return this.mMinZoom;
    }

    public void getProperBaseMatrix(Drawable drawable, Matrix matrix) {
        float f = this.mThisWidth;
        float f2 = this.mThisHeight;
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        matrix.reset();
        if (intrinsicWidth > f || intrinsicHeight > f2) {
            float fMin = Math.min(f / intrinsicWidth, f2 / intrinsicHeight);
            matrix.postScale(fMin, fMin);
            matrix.postTranslate((f - (intrinsicWidth * fMin)) / 2.0f, (f2 - (intrinsicHeight * fMin)) / 2.0f);
        } else {
            float fMin2 = Math.min(f / intrinsicWidth, f2 / intrinsicHeight);
            matrix.postScale(fMin2, fMin2);
            matrix.postTranslate((f - (intrinsicWidth * fMin2)) / 2.0f, (f2 - (intrinsicHeight * fMin2)) / 2.0f);
        }
    }

    public void getProperBaseMatrix2(Drawable drawable, Matrix matrix) {
        float f = this.mThisWidth;
        float f2 = this.mThisHeight;
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        matrix.reset();
        float fMin = Math.min(f / intrinsicWidth, f2 / intrinsicHeight);
        matrix.postScale(fMin, fMin);
        matrix.postTranslate((f - (intrinsicWidth * fMin)) / 2.0f, (f2 - (intrinsicHeight * fMin)) / 2.0f);
    }

    @Override // android.view.View
    @SuppressLint({"Override"})
    public float getRotation() {
        return 0.0f;
    }

    public float getScale(Matrix matrix) {
        return getValue(matrix, 0);
    }

    public float getValue(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i];
    }

    public void init() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void onDrawableChanged(Drawable drawable) {
        fireOnDrawableChangeListener(drawable);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        float defaultScale;
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            int i7 = this.mThisWidth;
            int i8 = this.mThisHeight;
            int i9 = i3 - i;
            this.mThisWidth = i9;
            int i10 = i4 - i2;
            this.mThisHeight = i10;
            i5 = i9 - i7;
            i6 = i10 - i8;
            PointF pointF = this.mCenter;
            pointF.x = i9 / 2.0f;
            pointF.y = i10 / 2.0f;
        } else {
            i5 = 0;
            i6 = 0;
        }
        Runnable runnable = this.mLayoutRunnable;
        if (runnable != null) {
            this.mLayoutRunnable = null;
            runnable.run();
        }
        Drawable drawable = getDrawable();
        if (drawable == null) {
            if (this.mBitmapChanged) {
                onDrawableChanged(drawable);
            }
            if (z || this.mBitmapChanged || this.mScaleTypeChanged) {
                onLayoutChanged(i, i2, i3, i4);
            }
            if (this.mBitmapChanged) {
                this.mBitmapChanged = false;
            }
            if (this.mScaleTypeChanged) {
                this.mScaleTypeChanged = false;
                return;
            }
            return;
        }
        if (z || this.mScaleTypeChanged || this.mBitmapChanged) {
            getDefaultScale(this.mScaleType);
            float scale = getScale(this.mBaseMatrix);
            float scale2 = getScale();
            float fMin = Math.min(1.0f, 1.0f / scale);
            getProperBaseMatrix(drawable, this.mBaseMatrix);
            float scale3 = getScale(this.mBaseMatrix);
            if (this.mBitmapChanged || this.mScaleTypeChanged) {
                Matrix matrix = this.mNextMatrix;
                if (matrix != null) {
                    this.mSuppMatrix.set(matrix);
                    this.mNextMatrix = null;
                    defaultScale = getScale();
                } else {
                    this.mSuppMatrix.reset();
                    defaultScale = getDefaultScale(this.mScaleType);
                }
                defaultScale = defaultScale;
                setImageMatrix(getImageViewMatrix());
                if (defaultScale != getScale()) {
                    zoomTo(defaultScale);
                }
            } else if (z) {
                if (!this.mMinZoomDefined) {
                    this.mMinZoom = -1.0f;
                }
                if (!this.mMaxZoomDefined) {
                    this.mMaxZoom = -1.0f;
                }
                setImageMatrix(getImageViewMatrix());
                postTranslate(-i5, -i6);
                if (this.mUserScaled) {
                    defaultScale = ((double) Math.abs(scale2 - fMin)) > 0.001d ? (scale / scale3) * scale2 : 1.0f;
                    zoomTo(defaultScale);
                } else {
                    defaultScale = getDefaultScale(this.mScaleType);
                    zoomTo(defaultScale);
                }
            }
            this.mUserScaled = false;
            if (defaultScale > getMaxScale() || defaultScale < getMinScale()) {
                zoomTo(defaultScale);
            }
            center(true, true);
            if (this.mBitmapChanged) {
                onDrawableChanged(drawable);
            }
            if (z || this.mBitmapChanged || this.mScaleTypeChanged) {
                onLayoutChanged(i, i2, i3, i4);
            }
            if (this.mScaleTypeChanged) {
                this.mScaleTypeChanged = false;
            }
            if (this.mBitmapChanged) {
                this.mBitmapChanged = false;
            }
        }
    }

    public void onLayoutChanged(int i, int i2, int i3, int i4) {
        fireOnLayoutChangeListener(i, i2, i3, i4);
    }

    public void panBy(double d2, double d3) {
        RectF bitmapRect = getBitmapRect();
        this.mScrollRect.set((float) d2, (float) d3, 0.0f, 0.0f);
        updateRect(bitmapRect, this.mScrollRect);
        RectF rectF = this.mScrollRect;
        postTranslate(rectF.left, rectF.top);
        center(true, true);
    }

    public void postScale(float f, float f2, float f3) {
        this.mSuppMatrix.postScale(f, f, f2, f3);
        setImageMatrix(getImageViewMatrix());
    }

    public void postTranslate(float f, float f2) {
        if (f == 0.0f && f2 == 0.0f) {
            return;
        }
        this.mSuppMatrix.postTranslate(f, f2);
        setImageMatrix(getImageViewMatrix());
    }

    public void printMatrix(Matrix matrix) {
        float value = getValue(matrix, 0);
        float value2 = getValue(matrix, 4);
        Log.d(LOG_TAG, "matrix: { x: " + getValue(matrix, 2) + ", y: " + getValue(matrix, 5) + ", scalex: " + value + ", scaley: " + value2 + " }");
    }

    public void resetDisplay() {
        this.mBitmapChanged = true;
        requestLayout();
    }

    public void scrollBy(float f, float f2) {
        panBy(f, f2);
    }

    public void setDisplayType(DisplayType displayType) {
        if (displayType != this.mScaleType) {
            this.mUserScaled = false;
            this.mScaleType = displayType;
            this.mScaleTypeChanged = true;
            requestLayout();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageBitmap(bitmap, null, -1.0f, -1.0f);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        setImageDrawable(drawable, null, -1.0f, -1.0f);
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        Matrix imageMatrix = getImageMatrix();
        boolean z = (matrix == null && !imageMatrix.isIdentity()) || !(matrix == null || imageMatrix.equals(matrix));
        super.setImageMatrix(matrix);
        if (z) {
            onImageMatrixChanged();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        setImageDrawable(getContext().getResources().getDrawable(i));
    }

    public void setMaxScale(float f) {
        this.mMaxZoom = f;
    }

    public void setMinScale(float f) {
        this.mMinZoom = f;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        } else {
            Log.w(LOG_TAG, "Unsupported scaletype. Only MATRIX can be used");
        }
    }

    public void updateRect(RectF rectF, RectF rectF2) {
        if (rectF == null) {
            return;
        }
        if (rectF.top >= 0.0f && rectF.bottom <= this.mThisHeight) {
            rectF2.top = 0.0f;
        }
        if (rectF.left >= 0.0f && rectF.right <= this.mThisWidth) {
            rectF2.left = 0.0f;
        }
        if (rectF2.top + rectF.top >= 0.0f && rectF.bottom > this.mThisHeight) {
            rectF2.top = (int) (0.0f - r0);
        }
        float f = rectF2.top + rectF.bottom;
        int i = this.mThisHeight;
        if (f <= i + 0 && rectF.top < 0.0f) {
            rectF2.top = (int) ((i + 0) - r0);
        }
        if (rectF2.left + rectF.left >= 0.0f) {
            rectF2.left = (int) (0.0f - r0);
        }
        float f2 = rectF2.left + rectF.right;
        int i2 = this.mThisWidth;
        if (f2 <= i2 + 0) {
            rectF2.left = (int) ((i2 + 0) - r6);
        }
    }

    public void zoomTo(float f) {
        if (f > getMaxScale()) {
            f = getMaxScale();
        }
        if (f < getMinScale()) {
            f = getMinScale();
        }
        PointF center = getCenter();
        zoomTo(f, center.x, center.y);
    }

    public RectF getBitmapRect(Matrix matrix) {
        if (getDrawable() == null) {
            return null;
        }
        Matrix imageViewMatrix = getImageViewMatrix(matrix);
        this.mBitmapRect.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        imageViewMatrix.mapRect(this.mBitmapRect);
        return this.mBitmapRect;
    }

    public Matrix getImageViewMatrix(Matrix matrix) {
        this.mDisplayMatrix.set(this.mBaseMatrix);
        this.mDisplayMatrix.postConcat(matrix);
        return this.mDisplayMatrix;
    }

    public float getScale() {
        return getScale(this.mSuppMatrix);
    }

    public void scrollBy(float f, float f2, double d2) {
        this.mHandler.post(new b(d2, System.currentTimeMillis(), f, f2));
    }

    public void setImageBitmap(Bitmap bitmap, Matrix matrix, float f, float f2) {
        if (bitmap != null) {
            setImageDrawable(new et1(bitmap), matrix, f, f2);
        } else {
            setImageDrawable(null, matrix, f, f2);
        }
    }

    public void setImageDrawable(Drawable drawable, Matrix matrix, float f, float f2) {
        if (getWidth() <= 0) {
            this.mLayoutRunnable = new a(drawable, matrix, f, f2);
        } else {
            _setImageDrawable(drawable, matrix, f, f2);
        }
    }

    public void zoomTo(float f, float f2) {
        PointF center = getCenter();
        zoomTo(f, center.x, center.y, f2);
    }

    public void zoomTo(float f, float f2, float f3) {
        if (f > getMaxScale()) {
            f = getMaxScale();
        }
        postScale(f / getScale(), f2, f3);
        onZoom(getScale());
        center(true, true);
    }

    public void zoomTo(float f, float f2, float f3, float f4) {
        if (f > getMaxScale()) {
            f = getMaxScale();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        float scale = getScale();
        Matrix matrix = new Matrix(this.mSuppMatrix);
        matrix.postScale(f, f, f2, f3);
        RectF center = getCenter(matrix, true, true);
        this.mHandler.post(new c(f4, jCurrentTimeMillis, f - scale, scale, f2 + (center.left * f), f3 + (center.top * f)));
    }

    public PointF getCenter() {
        return this.mCenter;
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEasing = new mr0();
        this.mBaseMatrix = new Matrix();
        this.mSuppMatrix = new Matrix();
        this.mHandler = new Handler();
        this.mLayoutRunnable = null;
        this.mUserScaled = false;
        this.mMaxZoom = -1.0f;
        this.mMinZoom = -1.0f;
        this.mDisplayMatrix = new Matrix();
        this.mMatrixValues = new float[9];
        this.mThisWidth = -1;
        this.mThisHeight = -1;
        this.mCenter = new PointF();
        this.mScaleType = DisplayType.NONE;
        this.DEFAULT_ANIMATION_DURATION = 200;
        this.mBitmapRect = new RectF();
        this.mCenterRect = new RectF();
        this.mScrollRect = new RectF();
        init();
    }

    public void onImageMatrixChanged() {
    }

    public void fireOnDrawableChangeListener(Drawable drawable) {
    }

    public void onZoom(float f) {
    }

    public void onZoomAnimationCompleted(float f) {
    }

    public void setOnDrawableChangedListener(d dVar) {
    }

    public void setOnLayoutChangeListener(e eVar) {
    }

    public void fireOnLayoutChangeListener(int i, int i2, int i3, int i4) {
    }
}
