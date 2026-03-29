package com.zenmen.media;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.zenmen.palmchat.R;
import defpackage.me1;
import defpackage.wv;
import defpackage.x86;
import java.util.Timer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SquarePhotoButton extends View {
    private static final int COUNT_DOWN_FINISH = 4;
    private static final float INNER_CIRCLE_SCALE_BEGIN = 0.7f;
    private static final float INNER_CIRCLE_SCALE_END = 0.55f;
    private static final String INNER_COLOR = "#FFFFFF";
    private static final int MIN_RECORD_TIME = 2;
    private static final int MOTION_EVENT_DOWN = 1;
    private static final int MOTION_EVENT_MOVE = 5;
    private static final int MOTION_EVENT_UP = 2;
    private static final float OUTER_CIRCLE_SCALE_BEGIN = 0.8f;
    private static final float OUTER_CIRCLE_SCALE_END = 1.0f;
    private static final String OUTER_COLOR = "#FFFFFF";
    private static final String TAG = "SquareRecordButton";
    private static final int UPDATE_ANGLE = 3;
    private int angle;
    private int btn_status;
    private int downY;
    private int innerColorBegin;
    private int innerColorEnd;
    private boolean isCDCancel;
    private boolean isLongPress;
    private boolean isSingleClick;
    private boolean isTouch;
    private int mCircleColor;
    private Handler mHandler;
    private Paint mPaint;
    private RectF mRect;
    private Timer mTimer;
    private d mTouchEventListener;
    int measuredWidth;
    private boolean onlyTakePickture;
    private int outerColorBegin;
    private int outerColorEnd;
    private RectF oval;
    private float progress;
    int radius;
    private long time_action_down;
    private long time_action_up;
    ValueAnimator va;
    private static final float MAX_PRESS_TIME_CALLBACK = wv.a();
    private static final float MAX_PRESS_TIME = wv.a() + CompensateDelayTime();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SquarePhotoButton.this.progress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SquarePhotoButton.this.invalidate();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SquarePhotoButton.this.progress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SquarePhotoButton.this.invalidate();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a();
    }

    public SquarePhotoButton(Context context) {
        this(context, null);
    }

    private static float CompensateDelayTime() {
        return x86.b().equals("Vivo X9") ? 0.5f : 0.0f;
    }

    private static int getCurrentColor(float f, int i, int i2) {
        int iRed = Color.red(i);
        int iBlue = Color.blue(i);
        int iGreen = Color.green(i);
        int iAlpha = Color.alpha(i);
        int iRed2 = Color.red(i2);
        int iBlue2 = Color.blue(i2);
        return Color.argb((int) (iAlpha + (f * (Color.alpha(i2) - iAlpha))), (int) (iRed + ((iRed2 - iRed) * f)), (int) (iGreen + ((Color.green(i2) - iGreen) * f)), (int) (iBlue + ((iBlue2 - iBlue) * f)));
    }

    private void leaseAnim() {
        ValueAnimator duration = ValueAnimator.ofFloat(0.8f, 0.0f).setDuration(50L);
        this.va = duration;
        duration.addUpdateListener(new a());
        this.va.addListener(new b());
        this.va.start();
    }

    public void init() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mCircleColor = getResources().getColor(R.color.gen_colorPrimary);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setColor(getCurrentColor(this.progress, this.outerColorBegin, this.outerColorEnd));
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(me1.b(getContext(), 3));
        int i = this.measuredWidth;
        canvas.drawCircle(i, i, this.radius * 0.8f, this.mPaint);
        this.mPaint.setColor(getCurrentColor(this.progress, this.innerColorBegin, this.innerColorEnd));
        this.mPaint.setStyle(Paint.Style.FILL);
        float f = this.radius * ((this.progress * (-0.14999998f)) + 0.7f);
        int i2 = this.measuredWidth;
        canvas.drawCircle(i2, i2, f, this.mPaint);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.radius = getMeasuredHeight() >> 1;
        this.measuredWidth = getMeasuredHeight() >> 1;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            Log.e("MotionEvent", "MotionEvent.ACTION_DOWN btn_status= " + this.btn_status);
            this.downY = (int) motionEvent.getY();
            this.isTouch = true;
            pressAnim();
        } else if (action == 1 || action == 3) {
            Log.e("MotionEvent", "MotionEvent.ACTION_UP");
            this.isTouch = false;
            leaseAnim();
        }
        return true;
    }

    public void pressAnim() {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 0.8f).setDuration(50L);
        this.va = duration;
        duration.addUpdateListener(new c());
        this.va.setInterpolator(new DecelerateInterpolator());
        this.va.start();
    }

    public void setCircleColor(int i) {
        this.mCircleColor = i;
    }

    public void setInnerColorBegin(int i) {
        this.innerColorBegin = i;
    }

    public void setInnerColorEnd(int i) {
        this.innerColorEnd = i;
    }

    public void setOuterColorBegin(int i) {
        this.outerColorBegin = i;
    }

    public void setOuterColorEnd(int i) {
        this.outerColorEnd = i;
    }

    public void setTouchEventListener(d dVar) {
        this.mTouchEventListener = dVar;
    }

    public SquarePhotoButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.time_action_down = 0L;
        this.time_action_up = 0L;
        this.isLongPress = false;
        this.isCDCancel = false;
        this.isTouch = false;
        this.downY = -1;
        this.angle = 0;
        this.progress = 0.0f;
        this.mCircleColor = 0;
        this.outerColorBegin = Color.parseColor("#FFFFFF");
        this.outerColorEnd = Color.parseColor("#FFFFFF");
        this.innerColorBegin = Color.parseColor("#FFFFFF");
        this.innerColorEnd = Color.parseColor("#FFFFFF");
        this.isSingleClick = false;
        this.radius = 0;
        this.measuredWidth = 0;
        this.mRect = new RectF();
        this.oval = new RectF();
        this.btn_status = 1;
        init();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (SquarePhotoButton.this.mTouchEventListener != null) {
                SquarePhotoButton.this.mTouchEventListener.a();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
