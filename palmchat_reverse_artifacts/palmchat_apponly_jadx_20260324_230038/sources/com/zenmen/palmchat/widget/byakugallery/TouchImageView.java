package com.zenmen.palmchat.widget.byakugallery;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.zenmen.palmchat.widget.byakugallery.a;
import defpackage.sx1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class TouchImageView extends ImageView {
    private static final int DOUBLE_TAP_ANIMATION_DURATION = 300;
    private static final int SCALE_END_ANIMATION_DURATION = 200;
    private Drawable mDrawable;
    private int mDrawableIntrinsicHeight;
    private int mDrawableIntrinsicWidth;
    private final sx1 mFlingScroller;
    private boolean mIsAnimatingBack;
    private Float mLastFocusX;
    private Float mLastFocusY;
    private final Matrix mMatrix;
    private final float[] mMatrixValues;
    private float mScale;
    private final com.zenmen.palmchat.widget.byakugallery.a mTouchGestureDetector;
    private float mTranslationX;
    private float mTranslationY;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends a.AbstractGestureDetectorOnGestureListenerC1145a {
        public a() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            TouchImageView.this.loadMatrixValues();
            float minScale = TouchImageView.this.getMinScale();
            if (TouchImageView.this.mScale <= minScale) {
                minScale = TouchImageView.this.getMaxScale();
            }
            float x = motionEvent.getX() - ((motionEvent.getX() - TouchImageView.this.mTranslationX) * (minScale / TouchImageView.this.mScale));
            float y = motionEvent.getY() - ((motionEvent.getY() - TouchImageView.this.mTranslationY) * (minScale / TouchImageView.this.mScale));
            float fComputeTranslation = x + TouchImageView.computeTranslation(TouchImageView.this.getMeasuredWidth(), TouchImageView.this.mDrawableIntrinsicWidth * minScale, x, 0.0f);
            float fComputeTranslation2 = y + TouchImageView.computeTranslation(TouchImageView.this.getMeasuredHeight(), TouchImageView.this.mDrawableIntrinsicHeight * minScale, y, 0.0f);
            TouchImageView.this.clearAnimation();
            c cVar = TouchImageView.this.new c(minScale, fComputeTranslation, fComputeTranslation2);
            cVar.setDuration(300L);
            TouchImageView.this.startAnimation(cVar);
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (TouchImageView.this.mIsAnimatingBack) {
                return false;
            }
            TouchImageView.this.loadMatrixValues();
            float measuredWidth = (TouchImageView.this.getMeasuredWidth() - (TouchImageView.this.mDrawableIntrinsicWidth * TouchImageView.this.mScale)) / 2.0f;
            float measuredWidth2 = measuredWidth > 0.0f ? measuredWidth : TouchImageView.this.getMeasuredWidth() - (TouchImageView.this.mDrawableIntrinsicWidth * TouchImageView.this.mScale);
            if (measuredWidth <= 0.0f) {
                measuredWidth = 0.0f;
            }
            float measuredHeight = (TouchImageView.this.getMeasuredHeight() - (TouchImageView.this.mDrawableIntrinsicHeight * TouchImageView.this.mScale)) / 2.0f;
            TouchImageView.this.mFlingScroller.b(Math.round(TouchImageView.this.mTranslationX), Math.round(TouchImageView.this.mTranslationY), Math.round(f), Math.round(f2), Math.round(measuredWidth2), Math.round(measuredWidth), Math.round(measuredHeight > 0.0f ? measuredHeight : TouchImageView.this.getMeasuredHeight() - (TouchImageView.this.mDrawableIntrinsicHeight * TouchImageView.this.mScale)), Math.round(measuredHeight > 0.0f ? measuredHeight : 0.0f));
            TouchImageView.this.clearAnimation();
            b bVar = new b();
            bVar.setDuration(TouchImageView.this.mFlingScroller.e());
            bVar.setInterpolator(new LinearInterpolator());
            TouchImageView.this.startAnimation(bVar);
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            TouchImageView.this.performLongClick();
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            TouchImageView.this.loadMatrixValues();
            float f = TouchImageView.this.mDrawableIntrinsicWidth * TouchImageView.this.mScale;
            float f2 = TouchImageView.this.mDrawableIntrinsicHeight * TouchImageView.this.mScale;
            float fComputeFocus = TouchImageView.computeFocus(TouchImageView.this.getMeasuredWidth(), f, TouchImageView.this.mTranslationX, scaleGestureDetector.getFocusX());
            float fComputeFocus2 = TouchImageView.computeFocus(TouchImageView.this.getMeasuredHeight(), f2, TouchImageView.this.mTranslationY, scaleGestureDetector.getFocusY());
            if (TouchImageView.this.mLastFocusX != null && TouchImageView.this.mLastFocusY != null) {
                float fComputeScaleTranslation = TouchImageView.computeScaleTranslation(TouchImageView.this.getMeasuredWidth(), f, TouchImageView.this.mTranslationX, fComputeFocus - TouchImageView.this.mLastFocusX.floatValue());
                float fComputeScaleTranslation2 = TouchImageView.computeScaleTranslation(TouchImageView.this.getMeasuredHeight(), f2, TouchImageView.this.mTranslationY, fComputeFocus2 - TouchImageView.this.mLastFocusY.floatValue());
                if (fComputeScaleTranslation != 0.0f || fComputeScaleTranslation2 != 0.0f) {
                    TouchImageView.this.mMatrix.postTranslate(fComputeScaleTranslation, fComputeScaleTranslation2);
                }
            }
            float fComputeScale = TouchImageView.computeScale(TouchImageView.this.getMinScale(), TouchImageView.this.getMaxScale(), TouchImageView.this.mScale, scaleGestureDetector.getScaleFactor());
            TouchImageView.this.mMatrix.postScale(fComputeScale, fComputeScale, fComputeFocus, fComputeFocus2);
            TouchImageView.this.mLastFocusX = Float.valueOf(fComputeFocus);
            TouchImageView.this.mLastFocusY = Float.valueOf(fComputeFocus2);
            TouchImageView.this.clearAnimation();
            ViewCompat.postInvalidateOnAnimation(TouchImageView.this);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            TouchImageView.this.mLastFocusX = null;
            TouchImageView.this.mLastFocusY = null;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            TouchImageView.this.loadMatrixValues();
            float f = TouchImageView.this.mDrawableIntrinsicWidth * TouchImageView.this.mScale;
            float f2 = TouchImageView.this.mDrawableIntrinsicHeight * TouchImageView.this.mScale;
            float fComputeTranslation = TouchImageView.computeTranslation(TouchImageView.this.getMeasuredWidth(), f, TouchImageView.this.mTranslationX, 0.0f);
            float fComputeTranslation2 = TouchImageView.computeTranslation(TouchImageView.this.getMeasuredHeight(), f2, TouchImageView.this.mTranslationY, 0.0f);
            if (Math.abs(fComputeTranslation) >= 1.0f || Math.abs(fComputeTranslation2) >= 1.0f) {
                float f3 = TouchImageView.this.mTranslationX + fComputeTranslation;
                float f4 = TouchImageView.this.mTranslationY + fComputeTranslation2;
                TouchImageView.this.clearAnimation();
                TouchImageView touchImageView = TouchImageView.this;
                c cVar = touchImageView.new c(touchImageView.mScale, f3, f4);
                cVar.setDuration(200L);
                TouchImageView.this.startAnimation(cVar);
                TouchImageView.this.mIsAnimatingBack = true;
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (TouchImageView.this.mIsAnimatingBack) {
                return false;
            }
            TouchImageView.this.loadMatrixValues();
            TouchImageView.this.mMatrix.postTranslate(TouchImageView.computeTranslation(TouchImageView.this.getMeasuredWidth(), TouchImageView.this.mDrawableIntrinsicWidth * TouchImageView.this.mScale, TouchImageView.this.mTranslationX, -f), TouchImageView.computeTranslation(TouchImageView.this.getMeasuredHeight(), TouchImageView.this.mDrawableIntrinsicHeight * TouchImageView.this.mScale, TouchImageView.this.mTranslationY, -f2));
            TouchImageView.this.clearAnimation();
            ViewCompat.postInvalidateOnAnimation(TouchImageView.this);
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return TouchImageView.this.performClick();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends Animation {
        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            TouchImageView.this.mFlingScroller.a(f);
            TouchImageView.this.loadMatrixValues();
            TouchImageView.this.mMatrix.postTranslate(TouchImageView.this.mFlingScroller.c() - TouchImageView.this.mTranslationX, TouchImageView.this.mFlingScroller.d() - TouchImageView.this.mTranslationY);
            ViewCompat.postInvalidateOnAnimation(TouchImageView.this);
        }

        public b() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f16023a;
        public float b;
        public float c;
        public float d;
        public float e;
        public float f;

        public c(float f, float f2, float f3) {
            TouchImageView.this.loadMatrixValues();
            this.f16023a = TouchImageView.this.mScale;
            this.b = TouchImageView.this.mTranslationX;
            this.c = TouchImageView.this.mTranslationY;
            this.d = f;
            this.e = f2;
            this.f = f3;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            TouchImageView.this.loadMatrixValues();
            if (f >= 1.0f) {
                TouchImageView.this.mMatrix.getValues(TouchImageView.this.mMatrixValues);
                TouchImageView.this.mMatrixValues[0] = this.d;
                TouchImageView.this.mMatrixValues[4] = this.d;
                TouchImageView.this.mMatrixValues[2] = this.e;
                TouchImageView.this.mMatrixValues[5] = this.f;
                TouchImageView.this.mMatrix.setValues(TouchImageView.this.mMatrixValues);
            } else {
                float f2 = this.f16023a;
                float f3 = (f2 + ((this.d - f2) * f)) / TouchImageView.this.mScale;
                TouchImageView.this.mMatrix.postScale(f3, f3);
                TouchImageView.this.mMatrix.getValues(TouchImageView.this.mMatrixValues);
                float f4 = TouchImageView.this.mMatrixValues[2];
                float f5 = TouchImageView.this.mMatrixValues[5];
                float f6 = this.b;
                float f7 = (f6 + ((this.e - f6) * f)) - f4;
                float f8 = this.c;
                TouchImageView.this.mMatrix.postTranslate(f7, (f8 + (f * (this.f - f8))) - f5);
            }
            ViewCompat.postInvalidateOnAnimation(TouchImageView.this);
        }
    }

    public TouchImageView(Context context) {
        this(context, null);
    }

    private static boolean canScroll(float f, float f2, float f3, int i) {
        return i > 0 ? Math.round(f3) < 0 : i < 0 && ((float) Math.round(f3)) > f - ((float) Math.round(f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float computeFocus(float f, float f2, float f3, float f4) {
        if (f3 > 0.0f && f4 < f3) {
            return f3;
        }
        if (f3 < f - f2) {
            float f5 = f3 + f2;
            if (f4 > f5) {
                return f5;
            }
        }
        return f4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float computeScale(float f, float f2, float f3, float f4) {
        float f5 = f3 * f4;
        return f5 < f ? f / f3 : f5 > f2 ? f2 / f3 : f4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float computeScaleTranslation(float f, float f2, float f3, float f4) {
        float f5 = f > f2 ? 0.0f : f - f2;
        float f6 = f > f2 ? f - f2 : 0.0f;
        if (f3 < f5 && f4 > 0.0f) {
            return f3 + f4 > f6 ? f6 - f3 : f4;
        }
        if (f3 > f6 && f4 < 0.0f) {
            return f3 + f4 < f5 ? f5 - f3 : f4;
        }
        if (f3 <= f5 || f3 >= f6) {
            return 0.0f;
        }
        float f7 = f3 + f4;
        return f7 < f5 ? f5 - f3 : f7 > f6 ? f6 - f3 : f4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float computeTranslation(float f, float f2, float f3, float f4) {
        float f5 = f - f2;
        float f6 = f5 / 2.0f;
        if (f6 > 0.0f) {
            return f6 - f3;
        }
        float f7 = f3 + f4;
        return f7 > 0.0f ? -f3 : f7 < f5 ? f5 - f3 : f4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getMaxScale() {
        return Math.max(getMinScale() * 1.5f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getMinScale() {
        return getMeasuredWidth() / this.mDrawableIntrinsicWidth;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadMatrixValues() {
        this.mMatrix.getValues(this.mMatrixValues);
        float[] fArr = this.mMatrixValues;
        this.mScale = fArr[0];
        this.mTranslationX = fArr[2];
        this.mTranslationY = fArr[5];
    }

    private void resetToInitialState() {
        this.mMatrix.reset();
        float minScale = getMinScale();
        this.mMatrix.postScale(minScale, minScale);
        this.mMatrix.getValues(new float[9]);
        this.mMatrix.postTranslate((getMeasuredWidth() - (this.mDrawableIntrinsicWidth * minScale)) / 2.0f, Math.max(0.0f, (getMeasuredHeight() - (this.mDrawableIntrinsicHeight * minScale)) / 2.0f));
        invalidate();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        loadMatrixValues();
        return canScroll(getMeasuredWidth(), this.mDrawableIntrinsicWidth * this.mScale, this.mTranslationX, i);
    }

    @Override // android.view.View
    @TargetApi(14)
    public boolean canScrollVertically(int i) {
        loadMatrixValues();
        return canScroll(getMeasuredHeight(), this.mDrawableIntrinsicHeight * this.mScale, this.mTranslationY, i);
    }

    @Override // android.view.View
    public void clearAnimation() {
        super.clearAnimation();
        this.mIsAnimatingBack = false;
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.mMatrix;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.setImageMatrix(this.mMatrix);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        super.onMeasure(i, i2);
        if (measuredWidth == getMeasuredWidth() && measuredHeight == getMeasuredHeight()) {
            return;
        }
        resetToInitialState();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mTouchGestureDetector.a(motionEvent);
        return true;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.mDrawable != drawable) {
            this.mDrawable = drawable;
            if (drawable == null) {
                this.mDrawableIntrinsicWidth = 0;
                this.mDrawableIntrinsicHeight = 0;
            } else {
                this.mDrawableIntrinsicWidth = drawable.getIntrinsicWidth();
                this.mDrawableIntrinsicHeight = drawable.getIntrinsicHeight();
                resetToInitialState();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        if (matrix == null) {
            matrix = new Matrix();
        }
        if (this.mMatrix.equals(matrix)) {
            return;
        }
        this.mMatrix.set(matrix);
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != ImageView.ScaleType.MATRIX) {
            throw new IllegalArgumentException("Unsupported scaleType. Only ScaleType.MATRIX is allowed.");
        }
        super.setScaleType(scaleType);
    }

    public TouchImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TouchImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mMatrixValues = new float[9];
        this.mFlingScroller = new sx1();
        this.mTouchGestureDetector = new com.zenmen.palmchat.widget.byakugallery.a(context, new a());
        super.setScaleType(ImageView.ScaleType.MATRIX);
    }
}
