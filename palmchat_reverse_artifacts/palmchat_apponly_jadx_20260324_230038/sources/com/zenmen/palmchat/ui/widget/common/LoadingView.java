package com.zenmen.palmchat.ui.widget.common;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class LoadingView extends View {
    private static final int DEFAULT_COLOR = -14366724;
    private static final long DEFAULT_DURATION = 1080;
    private static final int DEFAULT_STROKE_WIDTH = 2;
    private static final float DYNAMIC_DEGREE_VALUE = (float) Math.asin(1.0d);
    private static final String TAG = "LoadingView";
    private int bigCircleSize;
    private Rect bounds;
    private Paint circlePaint;
    private float currentDegree;
    private Interpolator defaultInterpolator;
    private boolean isAnimaed;
    private int sideMargin;
    private int smallCircleSize;
    private Paint strokePaint;
    private ValueAnimator valueAnimator;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            LoadingView.this.currentDegree = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            LoadingView.this.invalidate();
        }
    }

    public LoadingView(Context context) {
        this(context, null);
    }

    private ValueAnimator createAnimator(Interpolator interpolator, long j) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 180.0f);
        if (interpolator == null) {
            interpolator = this.defaultInterpolator;
        }
        valueAnimatorOfFloat.setInterpolator(interpolator);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        if (j == 0) {
            j = DEFAULT_DURATION;
        }
        valueAnimatorOfFloat.setDuration(j);
        valueAnimatorOfFloat.addUpdateListener(new a());
        return valueAnimatorOfFloat;
    }

    private void init() {
        initPaint();
        this.isAnimaed = false;
        this.bounds = new Rect();
    }

    private void initPaint() {
        Paint paint = new Paint(1);
        this.strokePaint = paint;
        paint.setColor(0);
        this.strokePaint.setStyle(Paint.Style.STROKE);
        this.strokePaint.setStrokeWidth(2.0f);
        Paint paint2 = new Paint(1);
        this.circlePaint = paint2;
        paint2.setColor(DEFAULT_COLOR);
        this.circlePaint.setStyle(Paint.Style.FILL);
    }

    public int getBigCircleSize() {
        return this.bigCircleSize;
    }

    public int getCircleColor() {
        Paint paint = this.circlePaint;
        if (paint == null) {
            return 0;
        }
        return paint.getColor();
    }

    public int getSmallCircleSize() {
        return this.smallCircleSize;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.bigCircleSize;
        if (i == 0 || i > this.bounds.width()) {
            this.bigCircleSize = this.bounds.width() >> 3;
        }
        int i2 = this.smallCircleSize;
        if (i2 == 0 || i2 > this.bounds.width()) {
            this.smallCircleSize = this.bounds.width() >> 5;
        }
        if (this.sideMargin == 0) {
            this.sideMargin = this.bounds.width() >> 2;
        }
        Rect rect = this.bounds;
        int i3 = rect.right;
        int i4 = this.bigCircleSize;
        int i5 = this.sideMargin;
        int i6 = ((i3 - (i4 / 2)) - 2) - i5;
        int i7 = rect.top + (i4 / 2) + 2 + i5;
        int i8 = rect.left + (i4 / 2) + 2 + i5;
        int i9 = ((rect.bottom - (i4 / 2)) - 2) - i5;
        double d = i4;
        double d2 = i4 - this.smallCircleSize;
        float f = this.currentDegree;
        float f2 = DYNAMIC_DEGREE_VALUE;
        float fAbs = (float) (d - (d2 * Math.abs(Math.sin((f * f2) / 180.0f))));
        int i10 = this.smallCircleSize;
        if (fAbs < i10) {
            fAbs = i10;
        }
        float fAbs2 = (float) (((double) i10) + (((double) (this.bigCircleSize - i10)) * Math.abs(Math.sin((this.currentDegree * f2) / 180.0f))));
        int i11 = this.bigCircleSize;
        if (fAbs2 > i11) {
            fAbs2 = i11;
        }
        canvas.save();
        canvas.rotate(this.currentDegree, this.bounds.centerX(), this.bounds.centerY());
        float f3 = i6;
        float f4 = i7;
        canvas.drawCircle(f3, f4, fAbs, this.circlePaint);
        canvas.drawCircle(f3, f4, fAbs + this.strokePaint.getStrokeWidth(), this.strokePaint);
        float f5 = i8;
        float f6 = i9;
        canvas.drawCircle(f5, f6, fAbs2, this.circlePaint);
        canvas.drawCircle(f5, f6, fAbs2 + this.strokePaint.getStrokeWidth(), this.strokePaint);
        canvas.restore();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.bounds.set(getPaddingLeft(), getPaddingTop(), View.MeasureSpec.getSize(i) - getPaddingRight(), View.MeasureSpec.getSize(i2) - getPaddingBottom());
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.bounds.set(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), i2 - getPaddingBottom());
    }

    public void setBigCircleSize(int i) {
        this.bigCircleSize = i;
    }

    public void setCircleColor(int i) {
        Paint paint = this.circlePaint;
        if (paint != null) {
            paint.setColor(i);
        }
    }

    public void setSmallCircleSize(int i) {
        this.smallCircleSize = i;
    }

    public void setStrokeColor(int i) {
        this.strokePaint.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.strokePaint.setStrokeWidth(i);
    }

    public void start() {
        start(this.defaultInterpolator, DEFAULT_DURATION);
    }

    public void stop() {
        this.isAnimaed = false;
        ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.currentDegree = 0.0f;
        clearAnimation();
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void start(@Nullable Interpolator interpolator, long j) {
        if (this.isAnimaed) {
            return;
        }
        if (j % 180 != 0) {
            j = (long) (Math.floor(j / 180.0f) * 180.0d);
        }
        this.isAnimaed = true;
        clearAnimation();
        if (this.valueAnimator == null) {
            this.valueAnimator = createAnimator(interpolator, j);
        }
        this.valueAnimator.cancel();
        this.valueAnimator.start();
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.defaultInterpolator = new LinearInterpolator();
        init();
    }
}
