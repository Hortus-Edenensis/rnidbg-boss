package com.zenmen.imageeditengine.views.cropimage;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.zenmen.imageeditengine.views.cropimage.CropImageView;
import com.zenmen.imageeditengine.views.cropimage.CropWindowMoveHandler;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class CropOverlayView extends View {
    private float boffset;
    private boolean initializedCropWindow;
    private int mAspectRatioX;
    private int mAspectRatioY;
    private Paint mBackgroundPaint;
    private float mBorderCornerLength;
    private float mBorderCornerOffset;
    private Paint mBorderCornerPaint;
    private Paint mBorderPaint;
    private final float[] mBoundsPoints;
    private final RectF mCalcBounds;
    private CropImageView.CropShape mCropShape;
    private b mCropWindowChangeListener;
    private final com.zenmen.imageeditengine.views.cropimage.d mCropWindowHandler;
    private final RectF mDrawRect;
    private boolean mFixAspectRatio;
    private ScaleGestureDetector.SimpleOnScaleGestureListener mGestureListener;
    private Paint mGuidelinePaint;
    private CropImageView.Guidelines mGuidelines;
    private float[] mInitBoundsPoints;
    private float mInitialCropWindowPaddingRatio;
    private final Rect mInitialCropWindowRect;
    private CropWindowMoveHandler mMoveHandler;
    private RectF mMoveOffsetRect;
    private boolean mMultiTouchEnabled;
    private c mOnMoveCallback;
    private Integer mOriginalLayerType;
    private Path mPath;
    private ScaleGestureDetector mScaleDetector;
    private float mSnapRadius;
    private float mTargetAspectRatio;
    private float mTouchRadius;
    private int mViewHeight;
    private int mViewWidth;
    private float xoffset;
    private float yoffset;

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(boolean z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void onTouchMove(float f, float f2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public d() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        @TargetApi(11)
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            RectF rectFH = CropOverlayView.this.mCropWindowHandler.h();
            float focusX = scaleGestureDetector.getFocusX();
            float focusY = scaleGestureDetector.getFocusY();
            float currentSpanY = scaleGestureDetector.getCurrentSpanY() / 2.0f;
            float currentSpanX = scaleGestureDetector.getCurrentSpanX() / 2.0f;
            float f = focusY - currentSpanY;
            float f2 = focusX - currentSpanX;
            float f3 = focusX + currentSpanX;
            float f4 = focusY + currentSpanY;
            if (f2 >= f3 || f > f4 || f2 < 0.0f || f3 > CropOverlayView.this.mCropWindowHandler.c() || f < 0.0f || f4 > CropOverlayView.this.mCropWindowHandler.b()) {
                return true;
            }
            rectFH.set(f2, f, f3, f4);
            CropOverlayView.this.mCropWindowHandler.r(rectFH);
            CropOverlayView.this.invalidate();
            return true;
        }
    }

    public CropOverlayView(Context context) {
        this(context, null);
    }

    private boolean calculateBounds(RectF rectF) {
        float f;
        float f2;
        float fU = com.zenmen.imageeditengine.views.cropimage.c.u(this.mBoundsPoints);
        float fW = com.zenmen.imageeditengine.views.cropimage.c.w(this.mBoundsPoints);
        float fV = com.zenmen.imageeditengine.views.cropimage.c.v(this.mBoundsPoints);
        float fP = com.zenmen.imageeditengine.views.cropimage.c.p(this.mBoundsPoints);
        if (!isNonStraightAngleRotated()) {
            this.mCalcBounds.set(fU, fW, fV, fP);
            return false;
        }
        float[] fArr = this.mBoundsPoints;
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[4];
        float f6 = fArr[5];
        float f7 = fArr[6];
        float f8 = fArr[7];
        if (f8 < f4) {
            float f9 = fArr[3];
            if (f4 < f9) {
                float f10 = fArr[2];
                f4 = f6;
                f2 = f7;
                f6 = f9;
                f = f8;
                f5 = f10;
                f3 = f5;
            } else {
                f3 = fArr[2];
                f2 = f5;
                f5 = f3;
                f6 = f4;
                f4 = f9;
                f = f6;
            }
        } else {
            f = fArr[3];
            if (f4 > f) {
                f2 = fArr[2];
                f5 = f7;
                f6 = f8;
            } else {
                f2 = f3;
                f = f4;
                f3 = f7;
                f4 = f8;
            }
        }
        float f11 = (f4 - f) / (f3 - f2);
        float f12 = (-1.0f) / f11;
        float f13 = f - (f11 * f2);
        float f14 = f - (f2 * f12);
        float f15 = f6 - (f11 * f5);
        float f16 = f6 - (f5 * f12);
        float fCenterY = rectF.centerY() - rectF.top;
        float fCenterX = rectF.centerX();
        float f17 = rectF.left;
        float f18 = fCenterY / (fCenterX - f17);
        float f19 = -f18;
        float f20 = rectF.top;
        float f21 = f20 - (f17 * f18);
        float f22 = rectF.right;
        float f23 = f20 - (f19 * f22);
        float f24 = f11 - f18;
        float f25 = (f21 - f13) / f24;
        float fMax = Math.max(fU, f25 < f22 ? f25 : fU);
        float f26 = (f21 - f14) / (f12 - f18);
        if (f26 >= rectF.right) {
            f26 = fMax;
        }
        float fMax2 = Math.max(fMax, f26);
        float f27 = f12 - f19;
        float f28 = (f23 - f16) / f27;
        if (f28 >= rectF.right) {
            f28 = fMax2;
        }
        float fMax3 = Math.max(fMax2, f28);
        float f29 = (f23 - f14) / f27;
        if (f29 <= rectF.left) {
            f29 = fV;
        }
        float fMin = Math.min(fV, f29);
        float f30 = (f23 - f15) / (f11 - f19);
        if (f30 <= rectF.left) {
            f30 = fMin;
        }
        float fMin2 = Math.min(fMin, f30);
        float f31 = (f21 - f15) / f24;
        if (f31 <= rectF.left) {
            f31 = fMin2;
        }
        float fMin3 = Math.min(fMin2, f31);
        float fMax4 = Math.max(fW, Math.max((f11 * fMax3) + f13, (f12 * fMin3) + f14));
        float fMin4 = Math.min(fP, Math.min((f12 * fMax3) + f16, (f11 * fMin3) + f15));
        RectF rectF2 = this.mCalcBounds;
        rectF2.left = fMax3;
        rectF2.top = fMax4;
        rectF2.right = fMin3;
        rectF2.bottom = fMin4;
        return true;
    }

    private void callOnCropWindowChanged(boolean z) {
        try {
            b bVar = this.mCropWindowChangeListener;
            if (bVar != null) {
                bVar.a(z);
            }
        } catch (Exception e) {
            Log.e("AIC", "Exception in crop window changed", e);
        }
    }

    private void drawBackground(Canvas canvas) {
        RectF rectFH = this.mCropWindowHandler.h();
        float fMax = Math.max(com.zenmen.imageeditengine.views.cropimage.c.u(this.mBoundsPoints), 0.0f);
        float fMax2 = Math.max(com.zenmen.imageeditengine.views.cropimage.c.w(this.mBoundsPoints), 0.0f);
        float fMin = Math.min(com.zenmen.imageeditengine.views.cropimage.c.v(this.mBoundsPoints), getWidth());
        float fMin2 = Math.min(com.zenmen.imageeditengine.views.cropimage.c.p(this.mBoundsPoints), getHeight());
        if (this.mCropShape != CropImageView.CropShape.RECTANGLE) {
            this.mPath.reset();
            this.mDrawRect.set(rectFH.left, rectFH.top, rectFH.right, rectFH.bottom);
            this.mPath.addOval(this.mDrawRect, Path.Direction.CW);
            canvas.save();
            canvas.clipPath(this.mPath, Region.Op.XOR);
            canvas.drawRect(fMax, fMax2, fMin, fMin2, this.mBackgroundPaint);
            canvas.restore();
            return;
        }
        if (!isNonStraightAngleRotated()) {
            canvas.drawRect(fMax, fMax2, fMin, rectFH.top, this.mBackgroundPaint);
            canvas.drawRect(fMax, rectFH.bottom, fMin, fMin2, this.mBackgroundPaint);
            canvas.drawRect(fMax, rectFH.top, rectFH.left, rectFH.bottom, this.mBackgroundPaint);
            canvas.drawRect(rectFH.right, rectFH.top, fMin, rectFH.bottom, this.mBackgroundPaint);
            return;
        }
        this.mPath.reset();
        Path path = this.mPath;
        float[] fArr = this.mBoundsPoints;
        path.moveTo(fArr[0], fArr[1]);
        Path path2 = this.mPath;
        float[] fArr2 = this.mBoundsPoints;
        path2.lineTo(fArr2[2], fArr2[3]);
        Path path3 = this.mPath;
        float[] fArr3 = this.mBoundsPoints;
        path3.lineTo(fArr3[4], fArr3[5]);
        Path path4 = this.mPath;
        float[] fArr4 = this.mBoundsPoints;
        path4.lineTo(fArr4[6], fArr4[7]);
        this.mPath.close();
        canvas.save();
        canvas.clipPath(this.mPath, Region.Op.INTERSECT);
        canvas.clipRect(rectFH, Region.Op.XOR);
        canvas.drawRect(fMax, fMax2, fMin, fMin2, this.mBackgroundPaint);
        canvas.restore();
    }

    private void drawBorders(Canvas canvas) {
        Paint paint = this.mBorderPaint;
        if (paint != null) {
            float strokeWidth = paint.getStrokeWidth();
            RectF rectFH = this.mCropWindowHandler.h();
            float f = strokeWidth / 2.0f;
            rectFH.inset(f, f);
            if (this.mCropShape == CropImageView.CropShape.RECTANGLE) {
                canvas.drawRect(rectFH, this.mBorderPaint);
            } else {
                canvas.drawOval(rectFH, this.mBorderPaint);
            }
        }
    }

    private void drawCorners(Canvas canvas) {
        if (this.mBorderCornerPaint != null) {
            Paint paint = this.mBorderPaint;
            float strokeWidth = paint != null ? paint.getStrokeWidth() : 0.0f;
            float strokeWidth2 = this.mBorderCornerPaint.getStrokeWidth();
            float f = strokeWidth2 / 2.0f;
            float f2 = (this.mCropShape == CropImageView.CropShape.RECTANGLE ? this.mBorderCornerOffset : 0.0f) + f;
            RectF rectFH = this.mCropWindowHandler.h();
            rectFH.inset(f2, f2);
            float f3 = (strokeWidth2 - strokeWidth) / 2.0f;
            float f4 = f + f3;
            float f5 = rectFH.left;
            float f6 = rectFH.top;
            canvas.drawLine(f5 - f3, f6 - f4, f5 - f3, f6 + this.mBorderCornerLength, this.mBorderCornerPaint);
            float f7 = rectFH.left;
            float f8 = rectFH.top;
            canvas.drawLine(f7 - f4, f8 - f3, f7 + this.mBorderCornerLength, f8 - f3, this.mBorderCornerPaint);
            float f9 = rectFH.right;
            float f10 = rectFH.top;
            canvas.drawLine(f9 + f3, f10 - f4, f9 + f3, f10 + this.mBorderCornerLength, this.mBorderCornerPaint);
            float f11 = rectFH.right;
            float f12 = rectFH.top;
            canvas.drawLine(f11 + f4, f12 - f3, f11 - this.mBorderCornerLength, f12 - f3, this.mBorderCornerPaint);
            float f13 = rectFH.left;
            float f14 = rectFH.bottom;
            canvas.drawLine(f13 - f3, f14 + f4, f13 - f3, f14 - this.mBorderCornerLength, this.mBorderCornerPaint);
            float f15 = rectFH.left;
            float f16 = rectFH.bottom;
            canvas.drawLine(f15 - f4, f16 + f3, f15 + this.mBorderCornerLength, f16 + f3, this.mBorderCornerPaint);
            float f17 = rectFH.right;
            float f18 = rectFH.bottom;
            canvas.drawLine(f17 + f3, f18 + f4, f17 + f3, f18 - this.mBorderCornerLength, this.mBorderCornerPaint);
            float f19 = rectFH.right;
            float f20 = rectFH.bottom;
            canvas.drawLine(f19 + f4, f20 + f3, f19 - this.mBorderCornerLength, f20 + f3, this.mBorderCornerPaint);
        }
    }

    private void drawGuidelines(Canvas canvas) {
        if (this.mGuidelinePaint != null) {
            Paint paint = this.mBorderPaint;
            float strokeWidth = paint != null ? paint.getStrokeWidth() : 0.0f;
            RectF rectFH = this.mCropWindowHandler.h();
            rectFH.inset(strokeWidth, strokeWidth);
            float fWidth = rectFH.width() / 3.0f;
            float fHeight = rectFH.height() / 3.0f;
            if (this.mCropShape != CropImageView.CropShape.OVAL) {
                float f = rectFH.left + fWidth;
                float f2 = rectFH.right - fWidth;
                canvas.drawLine(f, rectFH.top, f, rectFH.bottom, this.mGuidelinePaint);
                canvas.drawLine(f2, rectFH.top, f2, rectFH.bottom, this.mGuidelinePaint);
                float f3 = rectFH.top + fHeight;
                float f4 = rectFH.bottom - fHeight;
                canvas.drawLine(rectFH.left, f3, rectFH.right, f3, this.mGuidelinePaint);
                canvas.drawLine(rectFH.left, f4, rectFH.right, f4, this.mGuidelinePaint);
                return;
            }
            float fWidth2 = (rectFH.width() / 2.0f) - strokeWidth;
            float fHeight2 = (rectFH.height() / 2.0f) - strokeWidth;
            float f5 = rectFH.left + fWidth;
            float f6 = rectFH.right - fWidth;
            float fSin = (float) (((double) fHeight2) * Math.sin(Math.acos((fWidth2 - fWidth) / fWidth2)));
            canvas.drawLine(f5, (rectFH.top + fHeight2) - fSin, f5, (rectFH.bottom - fHeight2) + fSin, this.mGuidelinePaint);
            canvas.drawLine(f6, (rectFH.top + fHeight2) - fSin, f6, (rectFH.bottom - fHeight2) + fSin, this.mGuidelinePaint);
            float f7 = rectFH.top + fHeight;
            float f8 = rectFH.bottom - fHeight;
            float fCos = (float) (((double) fWidth2) * Math.cos(Math.asin((fHeight2 - fHeight) / fHeight2)));
            canvas.drawLine((rectFH.left + fWidth2) - fCos, f7, (rectFH.right - fWidth2) + fCos, f7, this.mGuidelinePaint);
            canvas.drawLine((rectFH.left + fWidth2) - fCos, f8, (rectFH.right - fWidth2) + fCos, f8, this.mGuidelinePaint);
        }
    }

    private static Paint getNewPaint(int i) {
        Paint paint = new Paint();
        paint.setColor(i);
        return paint;
    }

    private static Paint getNewPaintOrNull(float f, int i) {
        if (f <= 0.0f) {
            return null;
        }
        Paint paint = new Paint();
        paint.setColor(i);
        paint.setStrokeWidth(f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }

    private void initCropWindow() {
        for (float f : this.mBoundsPoints) {
            Log.e("rxx", "mBoundsPoints: " + f);
        }
        float fU = com.zenmen.imageeditengine.views.cropimage.c.u(this.mBoundsPoints);
        float fW = com.zenmen.imageeditengine.views.cropimage.c.w(this.mBoundsPoints);
        float fV = com.zenmen.imageeditengine.views.cropimage.c.v(this.mBoundsPoints);
        float fP = com.zenmen.imageeditengine.views.cropimage.c.p(this.mBoundsPoints);
        if (fV <= fU || fP <= fW) {
            return;
        }
        RectF rectF = new RectF();
        this.initializedCropWindow = true;
        float f2 = this.mInitialCropWindowPaddingRatio;
        float f3 = fV - fU;
        float f4 = f2 * f3;
        float f5 = fP - fW;
        float f6 = f2 * f5;
        if (this.mInitialCropWindowRect.width() > 0 && this.mInitialCropWindowRect.height() > 0) {
            rectF.left = Math.max(fU, this.mInitialCropWindowRect.left);
            rectF.top = Math.max(fW, this.mInitialCropWindowRect.top);
            rectF.right = Math.min(fV, this.mInitialCropWindowRect.right);
            rectF.bottom = Math.min(fP, this.mInitialCropWindowRect.bottom);
        } else if (!this.mFixAspectRatio || fV <= fU || fP <= fW) {
            rectF.left = fU + f4;
            rectF.top = fW + f6;
            rectF.right = fV - f4;
            rectF.bottom = fP - f6;
        } else if (f3 / f5 > this.mTargetAspectRatio) {
            rectF.top = fW + f6;
            rectF.bottom = fP - f6;
            float width = getWidth() / 2.0f;
            this.mTargetAspectRatio = this.mAspectRatioX / this.mAspectRatioY;
            float fMax = Math.max(this.mCropWindowHandler.e(), rectF.height() * this.mTargetAspectRatio) / 2.0f;
            rectF.left = width - fMax;
            rectF.right = width + fMax;
        } else {
            rectF.left = fU + f4;
            rectF.right = fV - f4;
            float height = getHeight() / 2.0f;
            float fMax2 = Math.max(this.mCropWindowHandler.d(), rectF.width() / this.mTargetAspectRatio) / 2.0f;
            rectF.top = height - fMax2;
            rectF.bottom = height + fMax2;
        }
        fixCropWindowRectByRules(rectF);
        Log.e("rxx", "fixCurrentCropWindowRect cropRect:" + rectF);
        this.mCropWindowHandler.r(rectF);
        callOnCropWindowChanged(false);
    }

    private boolean isNonStraightAngleRotated() {
        float[] fArr = this.mBoundsPoints;
        return (fArr[0] == fArr[6] || fArr[1] == fArr[7]) ? false : true;
    }

    private void onActionDown(float f, float f2) {
        CropWindowMoveHandler cropWindowMoveHandlerF = this.mCropWindowHandler.f(f, f2, this.mTouchRadius, this.mCropShape);
        this.mMoveHandler = cropWindowMoveHandlerF;
        if (cropWindowMoveHandlerF != null) {
            invalidate();
        }
    }

    private void onActionMove(float f, float f2) {
        if (this.mMoveHandler != null) {
            float f3 = this.mSnapRadius;
            RectF rectFH = this.mCropWindowHandler.h();
            float f4 = calculateBounds(rectFH) ? 0.0f : f3;
            if (this.mMoveHandler.m() != CropWindowMoveHandler.Type.CENTER) {
                this.mMoveHandler.n(rectFH, f, f2, this.mCalcBounds, this.mViewWidth, this.mViewHeight, f4, this.mFixAspectRatio, this.mTargetAspectRatio);
                this.mCropWindowHandler.r(rectFH);
                callOnCropWindowChanged(true);
                invalidate();
                return;
            }
            RectF rectF = new RectF();
            if (this.mMoveOffsetRect.width() == 0.0f && this.mMoveOffsetRect.height() == 0.0f) {
                this.mMoveOffsetRect.set(rectFH);
                rectF.set(rectFH);
            } else {
                rectF.set(this.mMoveOffsetRect);
            }
            this.mMoveHandler.n(rectF, f, f2, this.mCalcBounds, this.mViewWidth, this.mViewHeight, f4, this.mFixAspectRatio, this.mTargetAspectRatio);
            float fCenterX = rectF.centerX() - this.mMoveOffsetRect.centerX();
            float fCenterY = rectF.centerY() - this.mMoveOffsetRect.centerY();
            this.mMoveOffsetRect.set(rectF);
            Log.e("rxx", "dx :" + fCenterX + "  dy:" + fCenterY);
            this.mOnMoveCallback.onTouchMove(fCenterX, fCenterY);
        }
    }

    private void onActionUp() {
        if (this.mMoveHandler != null) {
            this.mMoveHandler = null;
            callOnCropWindowChanged(false);
            invalidate();
        }
    }

    public void fixCurrentCropWindowRect() {
        RectF cropWindowRect = getCropWindowRect();
        fixCropWindowRectByRules(cropWindowRect);
        Log.e("rxx", "initCropWindow cropRect:" + cropWindowRect);
        this.mCropWindowHandler.r(cropWindowRect);
    }

    public int getAspectRatioX() {
        return this.mAspectRatioX;
    }

    public int getAspectRatioY() {
        return this.mAspectRatioY;
    }

    public CropImageView.CropShape getCropShape() {
        return this.mCropShape;
    }

    public RectF getCropWindowLimitRect(int i, int i2) {
        initDrawBounds(i, i2);
        return new RectF(com.zenmen.imageeditengine.views.cropimage.c.u(this.mInitBoundsPoints), com.zenmen.imageeditengine.views.cropimage.c.w(this.mInitBoundsPoints), com.zenmen.imageeditengine.views.cropimage.c.v(this.mInitBoundsPoints), com.zenmen.imageeditengine.views.cropimage.c.p(this.mInitBoundsPoints));
    }

    public RectF getCropWindowRect() {
        return this.mCropWindowHandler.h();
    }

    public RectF getDisplayRect(int i, int i2) {
        return getDisplayRectF(i / i2, i, i2);
    }

    public RectF getDisplayRectF(float f, int i, int i2) {
        float f2;
        float f3;
        float fMax = Math.max(com.zenmen.imageeditengine.views.cropimage.c.u(this.mInitBoundsPoints), 0.0f);
        float fMax2 = Math.max(com.zenmen.imageeditengine.views.cropimage.c.w(this.mInitBoundsPoints), 0.0f);
        float fMin = Math.min(com.zenmen.imageeditengine.views.cropimage.c.v(this.mInitBoundsPoints), getWidth()) - fMax;
        float fMin2 = Math.min(com.zenmen.imageeditengine.views.cropimage.c.p(this.mInitBoundsPoints), getHeight()) - fMax2;
        if (f > fMin / fMin2) {
            f3 = (i2 * fMin) / i;
            f2 = fMin;
        } else {
            f2 = (i / i2) * fMin2;
            f3 = fMin2;
        }
        float f4 = fMax + ((fMin - f2) / 2.0f);
        float f5 = fMax2 + ((fMin2 - f3) / 2.0f);
        return new RectF(f4, f5, f2 + f4, f3 + f5);
    }

    public CropImageView.Guidelines getGuidelines() {
        return this.mGuidelines;
    }

    public Rect getInitialCropWindowRect() {
        return this.mInitialCropWindowRect;
    }

    public void initDrawBounds(int i, int i2) {
        float[] fArr = this.mInitBoundsPoints;
        float f = this.xoffset;
        fArr[0] = f;
        float f2 = this.yoffset;
        fArr[1] = f2;
        float f3 = i;
        fArr[2] = f3 - f;
        fArr[3] = f2;
        fArr[4] = f3 - f;
        float f4 = i2;
        float f5 = this.boffset;
        fArr[5] = (f4 - f2) - f5;
        fArr[6] = f;
        fArr[7] = (f4 - f2) - f5;
    }

    public boolean isFixAspectRatio() {
        return this.mFixAspectRatio;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initDrawBounds(getWidth(), getHeight());
        drawBackground(canvas);
        if (this.mCropWindowHandler.s()) {
            CropImageView.Guidelines guidelines = this.mGuidelines;
            if (guidelines == CropImageView.Guidelines.ON) {
                drawGuidelines(canvas);
            } else if (guidelines == CropImageView.Guidelines.ON_TOUCH && this.mMoveHandler != null) {
                drawGuidelines(canvas);
            }
        }
        drawBorders(canvas);
        drawCorners(canvas);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        if (this.mMultiTouchEnabled) {
            this.mScaleDetector.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mMoveOffsetRect.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.mBackgroundPaint.setColor(Color.argb(129, 0, 0, 0));
            onActionDown(motionEvent.getX(), motionEvent.getY());
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                onActionMove(motionEvent.getX(), motionEvent.getY());
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            if (action != 3) {
                return false;
            }
        }
        this.mBackgroundPaint.setColor(Color.argb(255, 0, 0, 0));
        this.mMoveOffsetRect.set(0.0f, 0.0f, 0.0f, 0.0f);
        getParent().requestDisallowInterceptTouchEvent(false);
        onActionUp();
        return true;
    }

    public void resetCropOverlayView() {
        if (this.initializedCropWindow) {
            setCropWindowRect(com.zenmen.imageeditengine.views.cropimage.c.b);
            initCropWindow();
            invalidate();
        }
    }

    public void resetCropWindowRect() {
        if (this.initializedCropWindow) {
            initCropWindow();
            invalidate();
            callOnCropWindowChanged(false);
        }
    }

    public void setAspectRatioX(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        if (this.mAspectRatioX != i) {
            this.mAspectRatioX = i;
            this.mTargetAspectRatio = i / this.mAspectRatioY;
            if (this.initializedCropWindow) {
                initCropWindow();
                invalidate();
            }
        }
    }

    public void setAspectRatioY(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        if (this.mAspectRatioY != i) {
            this.mAspectRatioY = i;
            this.mTargetAspectRatio = this.mAspectRatioX / i;
            if (this.initializedCropWindow) {
                initCropWindow();
                invalidate();
            }
        }
    }

    public void setBounds(float[] fArr, int i, int i2) {
        if (fArr == null || !Arrays.equals(this.mBoundsPoints, fArr)) {
            if (fArr == null) {
                Arrays.fill(this.mBoundsPoints, 0.0f);
            } else {
                System.arraycopy(fArr, 0, this.mBoundsPoints, 0, fArr.length);
            }
            this.mViewWidth = i;
            this.mViewHeight = i2;
            RectF rectFH = this.mCropWindowHandler.h();
            if (rectFH.width() == 0.0f || rectFH.height() == 0.0f) {
                initCropWindow();
            }
        }
    }

    public void setCropShape(CropImageView.CropShape cropShape) {
        if (this.mCropShape != cropShape) {
            this.mCropShape = cropShape;
            invalidate();
        }
    }

    public void setCropWindowChangeListener(b bVar) {
        this.mCropWindowChangeListener = bVar;
    }

    public void setCropWindowLimits(float f, float f2, float f3, float f4) {
        this.mCropWindowHandler.n(f, f2, f3, f4);
    }

    public void setCropWindowRect(RectF rectF) {
        this.mCropWindowHandler.r(rectF);
    }

    public void setFixedAspectRatio(boolean z) {
        if (this.mFixAspectRatio != z) {
            this.mFixAspectRatio = z;
            if (this.initializedCropWindow) {
                initCropWindow();
                invalidate();
            }
        }
    }

    public void setGuidelines(CropImageView.Guidelines guidelines) {
        if (this.mGuidelines != guidelines) {
            this.mGuidelines = guidelines;
            if (this.initializedCropWindow) {
                invalidate();
            }
        }
    }

    public void setInitialAttributeValues(CropImageOptions cropImageOptions) {
        this.mCropWindowHandler.o(cropImageOptions);
        setCropShape(cropImageOptions.cropShape);
        setSnapRadius(cropImageOptions.snapRadius);
        setGuidelines(cropImageOptions.guidelines);
        setFixedAspectRatio(cropImageOptions.fixAspectRatio);
        setAspectRatioX(cropImageOptions.aspectRatioX);
        setAspectRatioY(cropImageOptions.aspectRatioY);
        setMultiTouchEnabled(cropImageOptions.multiTouchEnabled, null);
        this.mTouchRadius = cropImageOptions.touchRadius;
        this.mInitialCropWindowPaddingRatio = cropImageOptions.initialCropWindowPaddingRatio;
        this.mBorderPaint = getNewPaintOrNull(cropImageOptions.borderLineThickness, cropImageOptions.borderLineColor);
        this.mBorderCornerOffset = cropImageOptions.borderCornerOffset;
        this.mBorderCornerLength = cropImageOptions.borderCornerLength;
        this.mBorderCornerPaint = getNewPaintOrNull(cropImageOptions.borderCornerThickness, cropImageOptions.borderCornerColor);
        this.mGuidelinePaint = getNewPaintOrNull(cropImageOptions.guidelinesThickness, cropImageOptions.guidelinesColor);
        this.mBackgroundPaint = getNewPaint(cropImageOptions.backgroundColor);
    }

    public void setInitialCropWindowRect(Rect rect) {
        Log.e("rxx", "set init rect :" + rect);
        Rect rect2 = this.mInitialCropWindowRect;
        if (rect == null) {
            rect = com.zenmen.imageeditengine.views.cropimage.c.f11831a;
        }
        rect2.set(rect);
        if (this.initializedCropWindow) {
            initCropWindow();
            invalidate();
            callOnCropWindowChanged(false);
        }
    }

    public void setMaxCropResultSize(int i, int i2) {
        this.mCropWindowHandler.p(i, i2);
    }

    public void setMinCropResultSize(int i, int i2) {
        this.mCropWindowHandler.q(i, i2);
    }

    public boolean setMultiTouchEnabled(boolean z, ScaleGestureDetector.SimpleOnScaleGestureListener simpleOnScaleGestureListener) {
        this.mGestureListener = simpleOnScaleGestureListener;
        if (this.mMultiTouchEnabled == z) {
            return false;
        }
        this.mMultiTouchEnabled = z;
        if (!z || this.mScaleDetector != null) {
            return true;
        }
        Context context = getContext();
        ScaleGestureDetector.OnScaleGestureListener dVar = this.mGestureListener;
        if (dVar == null) {
            dVar = new d();
        }
        this.mScaleDetector = new ScaleGestureDetector(context, dVar);
        return true;
    }

    public void setOnMoveCallback(c cVar) {
        this.mOnMoveCallback = cVar;
    }

    public void setSnapRadius(float f) {
        this.mSnapRadius = f;
    }

    public void transferInitCropWindow(Matrix matrix) {
        if (matrix == null || this.mInitialCropWindowRect.width() <= 0 || this.mInitialCropWindowRect.height() <= 0) {
            return;
        }
        RectF rectF = new RectF();
        rectF.set(this.mInitialCropWindowRect);
        RectF rectF2 = new RectF();
        matrix.mapRect(rectF2, rectF);
        Log.e("rxx", "tmp:" + rectF + " target :" + rectF2);
        this.mInitialCropWindowRect.set((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom);
    }

    public CropOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCropWindowHandler = new com.zenmen.imageeditengine.views.cropimage.d();
        this.mDrawRect = new RectF();
        this.mPath = new Path();
        this.mBoundsPoints = new float[8];
        this.mCalcBounds = new RectF();
        this.mTargetAspectRatio = this.mAspectRatioX / this.mAspectRatioY;
        this.mInitialCropWindowRect = new Rect();
        this.xoffset = 100.0f;
        this.yoffset = 100.0f;
        this.boffset = 50.0f;
        this.mInitBoundsPoints = new float[8];
        this.mMoveOffsetRect = new RectF();
    }

    private void fixCropWindowRectByRules(RectF rectF) {
    }
}
