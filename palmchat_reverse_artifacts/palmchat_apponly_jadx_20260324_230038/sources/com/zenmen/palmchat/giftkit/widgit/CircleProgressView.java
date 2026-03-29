package com.zenmen.palmchat.giftkit.widgit;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import com.zenmen.giftkit.R$styleable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class CircleProgressView extends View {
    private int locationStart;
    private ValueAnimator mAnimator;
    private Paint mBgPaint;
    private int mCurrent;
    private c mOnAnimProgressListener;
    private int mProgressColor;
    private Paint mProgressPaint;
    private float mProgressWidth;
    private float startAngle;
    private int tCurrent;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (CircleProgressView.this.tCurrent != iIntValue) {
                CircleProgressView.this.tCurrent = iIntValue;
                CircleProgressView.this.setCurrent(iIntValue);
                if (CircleProgressView.this.mOnAnimProgressListener != null) {
                    CircleProgressView.this.mOnAnimProgressListener.a(iIntValue);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (CircleProgressView.this.tCurrent != iIntValue) {
                CircleProgressView.this.tCurrent = iIntValue;
                CircleProgressView.this.setCurrent(iIntValue);
                if (CircleProgressView.this.mOnAnimProgressListener != null) {
                    CircleProgressView.this.mOnAnimProgressListener.a(iIntValue);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(int i);
    }

    public CircleProgressView(Context context) {
        this(context, null);
    }

    public static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CircleProgressView);
        this.locationStart = typedArrayObtainStyledAttributes.getInt(R$styleable.CircleProgressView_location_start, 1);
        this.mProgressWidth = typedArrayObtainStyledAttributes.getDimension(R$styleable.CircleProgressView_progress_width, dp2px(context, 4.0f));
        this.mProgressColor = typedArrayObtainStyledAttributes.getColor(R$styleable.CircleProgressView_progress_color, this.mProgressColor);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.mBgPaint = paint;
        paint.setAntiAlias(true);
        this.mBgPaint.setStrokeWidth(this.mProgressWidth);
        this.mBgPaint.setStyle(Paint.Style.STROKE);
        this.mBgPaint.setColor(Color.parseColor("#00000000"));
        this.mBgPaint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.mProgressPaint = paint2;
        paint2.setAntiAlias(true);
        this.mProgressPaint.setStyle(Paint.Style.STROKE);
        this.mProgressPaint.setStrokeWidth(this.mProgressWidth);
        this.mProgressPaint.setColor(this.mProgressColor);
        this.mProgressPaint.setStrokeCap(Paint.Cap.ROUND);
        int i = this.locationStart;
        if (i == 1) {
            this.startAngle = -180.0f;
            return;
        }
        if (i == 2) {
            this.startAngle = -90.0f;
        } else if (i == 3) {
            this.startAngle = 0.0f;
        } else if (i == 4) {
            this.startAngle = 90.0f;
        }
    }

    public void cancelAnimProgress() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void destroy() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public int getCurrent() {
        return this.mCurrent;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f = this.mProgressWidth;
        RectF rectF = new RectF(f / 2.0f, f / 2.0f, getWidth() - (this.mProgressWidth / 2.0f), getHeight() - (this.mProgressWidth / 2.0f));
        canvas.drawArc(rectF, 0.0f, 360.0f, false, this.mBgPaint);
        canvas.drawArc(rectF, this.startAngle, (this.mCurrent * 360) / 100, false, this.mProgressPaint);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (size >= size2) {
            size = size2;
        }
        setMeasuredDimension(size, size);
    }

    public void setCurrent(int i) {
        this.mCurrent = i;
        invalidate();
    }

    public void setOnAnimProgressListener(c cVar) {
        this.mOnAnimProgressListener = cVar;
    }

    public void startAnimProgress(int i, int i2) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, i);
        this.mAnimator = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(i2);
        this.mAnimator.setInterpolator(new LinearInterpolator());
        this.mAnimator.addUpdateListener(new a());
        this.mAnimator.start();
    }

    public void startReverseAnimProgress(int i, int i2) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, 0);
        this.mAnimator = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(i2);
        this.mAnimator.setInterpolator(new LinearInterpolator());
        this.mAnimator.addUpdateListener(new b());
        this.mAnimator.start();
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgressColor = SupportMenu.CATEGORY_MASK;
        this.tCurrent = -1;
        init(context, attributeSet);
    }
}
