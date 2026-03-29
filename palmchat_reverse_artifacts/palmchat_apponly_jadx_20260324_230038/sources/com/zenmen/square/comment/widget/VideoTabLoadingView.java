package com.zenmen.square.comment.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.zenmen.square.R$color;
import com.zenmen.square.R$styleable;
import defpackage.pe6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class VideoTabLoadingView extends View {
    private static final int DURATION = 350;
    private static final int LEFT_COLOR = -49088;
    private static final float LTR_SCALR = 1.3f;
    private static int MIX_COLOR = 0;
    private static final int PAUSE_DUARTION = 80;
    private static final int RIGHT_COLOR = -16716050;
    private static final float RTL_SCALE = 0.7f;
    private static final float SCALE_END_FRACTION = 0.8f;
    private static final float SCALE_START_FRACTION = 0.2f;
    private static final String TAG = "VideoTabLoadingView";
    private final float GAP;
    private final float RADIUS;
    private ValueAnimator mAnim;
    private float mBallGap;
    private int mInitialLeftColor;
    private Paint mInitialLeftPaint;
    private float mInitialLeftRadius;
    private int mInitialRightColor;
    private Paint mInitialRightPaint;
    private float mInitialRightRadius;
    boolean mIsAnimCanceled;
    boolean mIsLtr;
    private Path mLtrPath;
    private float mLtrScale;
    private int mMixColor;
    private Paint mMixPaint;
    private Path mMixPath;
    private float mMoveDistance;
    private int mMoveDuration;
    private int mPauseDuration;
    private float mProgressFraction;
    private Path mRtlPath;
    private float mRtlScale;
    private float mScaleEndFraction;
    private float mScaleStartFraction;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            VideoTabLoadingView.this.mProgressFraction = valueAnimator.getAnimatedFraction();
            VideoTabLoadingView.this.invalidate();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            VideoTabLoadingView.this.mIsAnimCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (VideoTabLoadingView.this.getVisibility() == 0) {
                VideoTabLoadingView videoTabLoadingView = VideoTabLoadingView.this;
                if (videoTabLoadingView.mIsAnimCanceled || videoTabLoadingView.mAnim == null || VideoTabLoadingView.this.mAnim.isRunning()) {
                    return;
                }
                VideoTabLoadingView.this.mAnim.start();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            VideoTabLoadingView.this.mIsLtr = !r2.mIsLtr;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            VideoTabLoadingView.this.mIsLtr = !r2.mIsLtr;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoTabLoadingView videoTabLoadingView = VideoTabLoadingView.this;
            videoTabLoadingView.mIsAnimCanceled = false;
            videoTabLoadingView.mIsLtr = false;
            if (videoTabLoadingView.mAnim == null || VideoTabLoadingView.this.mAnim.isRunning()) {
                return;
            }
            VideoTabLoadingView.this.mAnim.start();
        }
    }

    public VideoTabLoadingView(Context context) {
        this(context, null);
    }

    private void checkAttr() {
        float f = this.mInitialLeftRadius;
        if (f <= 0.0f) {
            f = this.RADIUS;
        }
        this.mInitialLeftRadius = f;
        float f2 = this.mInitialRightRadius;
        if (f2 <= 0.0f) {
            f2 = this.RADIUS;
        }
        this.mInitialRightRadius = f2;
        float f3 = this.mBallGap;
        if (f3 < 0.0f) {
            f3 = this.GAP;
        }
        this.mBallGap = f3;
        float f4 = this.mRtlScale;
        if (f4 < 0.0f) {
            f4 = 0.7f;
        }
        this.mRtlScale = f4;
        float f5 = this.mLtrScale;
        if (f5 < 0.0f) {
            f5 = 1.3f;
        }
        this.mLtrScale = f5;
        int i = this.mMoveDuration;
        if (i <= 0) {
            i = DURATION;
        }
        this.mMoveDuration = i;
        int i2 = this.mPauseDuration;
        if (i2 < 0) {
            i2 = 80;
        }
        this.mPauseDuration = i2;
        float f6 = this.mScaleStartFraction;
        if (f6 < 0.0f || f6 > 0.5f) {
            this.mScaleStartFraction = 0.2f;
        }
        float f7 = this.mScaleEndFraction;
        if (f7 < 0.5d || f7 > 1.0f) {
            this.mScaleEndFraction = 0.8f;
        }
    }

    private float dp2px(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private void initAnim() {
        this.mProgressFraction = 0.0f;
        stopAnimation();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mAnim = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.mMoveDuration);
        int i = this.mPauseDuration;
        if (i > 0) {
            this.mAnim.setStartDelay(i);
            this.mAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        } else {
            this.mAnim.setRepeatCount(-1);
            this.mAnim.setRepeatMode(1);
            this.mAnim.setInterpolator(new LinearInterpolator());
        }
        this.mAnim.addUpdateListener(new a());
        this.mAnim.addListener(new b());
    }

    private void initDraw() {
        this.mInitialLeftPaint = new Paint(1);
        this.mInitialRightPaint = new Paint(1);
        this.mMixPaint = new Paint(1);
        this.mInitialLeftPaint.setColor(this.mInitialLeftColor);
        this.mInitialRightPaint.setColor(this.mInitialRightColor);
        this.mMixPaint.setColor(this.mMixColor);
        this.mLtrPath = new Path();
        this.mRtlPath = new Path();
        this.mMixPath = new Path();
    }

    public float getBallGap() {
        return this.mBallGap;
    }

    public int getInitialLeftColor() {
        return this.mInitialLeftColor;
    }

    public float getInitialLeftRadius() {
        return this.mInitialLeftRadius;
    }

    public int getInitialRightColor() {
        return this.mInitialRightColor;
    }

    public float getInitialRightRadius() {
        return this.mInitialRightRadius;
    }

    public float getLtrScale() {
        return this.mLtrScale;
    }

    public int getMixColor() {
        return this.mMixColor;
    }

    public int getMoveDuration() {
        return this.mMoveDuration;
    }

    public int getPauseDuration() {
        return this.mPauseDuration;
    }

    public float getRtlScale() {
        return this.mRtlScale;
    }

    public float getScaleEndFraction() {
        return this.mScaleEndFraction;
    }

    public float getScaleStartFraction() {
        return this.mScaleStartFraction;
    }

    public boolean isAnimating() {
        ValueAnimator valueAnimator = this.mAnim;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        stopAnimation();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        Paint paint;
        Paint paint2;
        float f3;
        float f4;
        float f5;
        super.onDraw(canvas);
        float measuredHeight = getMeasuredHeight() / 2.0f;
        if (this.mIsLtr) {
            f = this.mInitialLeftRadius;
            f2 = this.mInitialRightRadius;
            paint = this.mInitialLeftPaint;
            paint2 = this.mInitialRightPaint;
        } else {
            f = this.mInitialRightRadius;
            f2 = this.mInitialLeftRadius;
            paint = this.mInitialRightPaint;
            paint2 = this.mInitialLeftPaint;
        }
        float f6 = this.mMoveDistance;
        float measuredWidth = ((getMeasuredWidth() / 2.0f) - (f6 / 2.0f)) + (f6 * this.mProgressFraction);
        float f7 = this.mMoveDistance;
        float f8 = this.mProgressFraction;
        float measuredWidth2 = ((getMeasuredWidth() / 2.0f) + (f7 / 2.0f)) - (f7 * f8);
        float f9 = this.mScaleStartFraction;
        if (f8 <= f9) {
            float f10 = (1.0f / f9) * f8;
            f3 = f * (((this.mLtrScale - 1.0f) * f10) + 1.0f);
            f4 = ((this.mRtlScale - 1.0f) * f10) + 1.0f;
        } else {
            float f11 = this.mScaleEndFraction;
            if (f8 >= f11) {
                float f12 = (f8 - 1.0f) / (f11 - 1.0f);
                f3 = f * (((this.mLtrScale - 1.0f) * f12) + 1.0f);
                f5 = f2 * (((this.mRtlScale - 1.0f) * f12) + 1.0f);
                this.mLtrPath.reset();
                this.mLtrPath.addCircle(measuredWidth, measuredHeight, f3, Path.Direction.CW);
                this.mRtlPath.reset();
                this.mRtlPath.addCircle(measuredWidth2, measuredHeight, f5, Path.Direction.CW);
                this.mMixPath.op(this.mLtrPath, this.mRtlPath, Path.Op.INTERSECT);
                canvas.drawPath(this.mLtrPath, paint);
                canvas.drawPath(this.mRtlPath, paint2);
            }
            f3 = f * this.mLtrScale;
            f4 = this.mRtlScale;
        }
        f5 = f2 * f4;
        this.mLtrPath.reset();
        this.mLtrPath.addCircle(measuredWidth, measuredHeight, f3, Path.Direction.CW);
        this.mRtlPath.reset();
        this.mRtlPath.addCircle(measuredWidth2, measuredHeight, f5, Path.Direction.CW);
        this.mMixPath.op(this.mLtrPath, this.mRtlPath, Path.Op.INTERSECT);
        canvas.drawPath(this.mLtrPath, paint);
        canvas.drawPath(this.mRtlPath, paint2);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        float fMax = Math.max(Math.max(this.mRtlScale, this.mLtrScale), 1.0f);
        if (mode != 1073741824) {
            size = (int) (this.mBallGap + (((this.mInitialLeftRadius * 2.0f) + (this.mInitialRightRadius * 2.0f)) * fMax) + dp2px(1.0f));
        }
        if (mode2 != 1073741824) {
            size2 = (int) ((Math.max(this.mInitialLeftRadius, this.mInitialRightRadius) * 2.0f * fMax) + dp2px(1.0f));
        }
        setMeasuredDimension(size, size2);
    }

    public void setColors(int i, int i2, int i3) {
        this.mInitialLeftColor = i;
        this.mInitialRightColor = i2;
        this.mMixColor = i2;
        checkAttr();
        this.mInitialLeftPaint.setColor(i);
        this.mInitialRightPaint.setColor(i2);
        this.mMixPaint.setColor(i3);
        invalidate();
    }

    public void setDuration(int i, int i2) {
        this.mMoveDuration = i;
        this.mPauseDuration = i2;
        checkAttr();
        initAnim();
    }

    public void setRadius(float f, float f2, float f3) {
        stopAnimation();
        this.mInitialLeftRadius = f;
        this.mInitialRightRadius = f2;
        this.mBallGap = f3;
        checkAttr();
        this.mMoveDistance = f3 + f + f2;
        requestLayout();
    }

    public void setScales(float f, float f2) {
        stopAnimation();
        this.mLtrScale = f;
        this.mRtlScale = f2;
        checkAttr();
        requestLayout();
    }

    public void setStartEndFraction(float f, float f2) {
        this.mScaleStartFraction = f;
        this.mScaleEndFraction = f2;
        checkAttr();
        invalidate();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            startAnimation();
        } else {
            stopAnimation();
        }
    }

    public void startAnimation() {
        if (this.mAnim == null) {
            initAnim();
        }
        if (this.mAnim.isRunning()) {
            this.mAnim.cancel();
        }
        post(new c());
    }

    public void stopAnimation() {
        ValueAnimator valueAnimator = this.mAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mAnim = null;
        }
    }

    public VideoTabLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoTabLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        float fDp2px = dp2px(5.0f);
        this.RADIUS = fDp2px;
        float fDp2px2 = dp2px(4.0f);
        this.GAP = fDp2px2;
        this.mIsAnimCanceled = false;
        this.mIsLtr = true;
        MIX_COLOR = pe6.b(context, R$color.square_full_black);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SquareCommentLoadingView);
        this.mInitialLeftRadius = typedArrayObtainStyledAttributes.getDimension(R$styleable.SquareCommentLoadingView_square_initial_left_radius, fDp2px);
        this.mInitialRightRadius = typedArrayObtainStyledAttributes.getDimension(R$styleable.SquareCommentLoadingView_square_initial_right_radius, fDp2px);
        this.mBallGap = typedArrayObtainStyledAttributes.getDimension(R$styleable.SquareCommentLoadingView_square_gap, fDp2px2);
        this.mRtlScale = typedArrayObtainStyledAttributes.getFloat(R$styleable.SquareCommentLoadingView_square_rtlScale, 0.7f);
        this.mLtrScale = typedArrayObtainStyledAttributes.getFloat(R$styleable.SquareCommentLoadingView_square_ltrScale, 1.3f);
        this.mInitialLeftColor = typedArrayObtainStyledAttributes.getColor(R$styleable.SquareCommentLoadingView_square_initial_left_color, LEFT_COLOR);
        this.mInitialRightColor = typedArrayObtainStyledAttributes.getColor(R$styleable.SquareCommentLoadingView_square_initial_right_color, RIGHT_COLOR);
        this.mMixColor = typedArrayObtainStyledAttributes.getColor(R$styleable.SquareCommentLoadingView_square_mixColor, MIX_COLOR);
        this.mMoveDuration = typedArrayObtainStyledAttributes.getInt(R$styleable.SquareCommentLoadingView_square_duration, DURATION);
        this.mPauseDuration = typedArrayObtainStyledAttributes.getInt(R$styleable.SquareCommentLoadingView_square_pause_duration, 80);
        this.mScaleStartFraction = typedArrayObtainStyledAttributes.getFloat(R$styleable.SquareCommentLoadingView_square_scale_start_fraction, 0.2f);
        this.mScaleEndFraction = typedArrayObtainStyledAttributes.getFloat(R$styleable.SquareCommentLoadingView_square_scale_end_fraction, 0.8f);
        typedArrayObtainStyledAttributes.recycle();
        checkAttr();
        this.mMoveDistance = this.mBallGap + this.mInitialLeftRadius + this.mInitialRightRadius;
        initDraw();
        initAnim();
    }
}
