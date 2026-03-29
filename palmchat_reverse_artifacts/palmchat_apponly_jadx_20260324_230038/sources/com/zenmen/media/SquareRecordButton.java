package com.zenmen.media;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import defpackage.me1;
import defpackage.wv;
import defpackage.x86;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SquareRecordButton extends View {
    private static final int COUNT_DOWN_FINISH = 4;
    private static final float INNER_CIRCLE_SCALE_BEGIN = 0.7f;
    private static final float INNER_CIRCLE_SCALE_END = 0.35f;
    private static final String INNER_COLOR = "#FF6262";
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
    private e mTouchEventListener;
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
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Message messageObtain = Message.obtain();
            messageObtain.what = 3;
            SquareRecordButton.this.mHandler.sendMessage(messageObtain);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                SquareRecordButton.this.progress = fFloatValue;
                Log.d("recordbtndraw", "draw outer progress:" + fFloatValue);
                SquareRecordButton.this.invalidate();
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator duration = ValueAnimator.ofFloat(0.8f, 0.0f).setDuration(300L);
            duration.addUpdateListener(new a());
            duration.setInterpolator(new AccelerateInterpolator());
            duration.start();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                SquareRecordButton.this.isCDCancel = false;
                Log.d(SquareRecordButton.TAG, "MOTION_EVENT_DOWN");
                if (SquareRecordButton.this.time_action_up < SquareRecordButton.this.time_action_down) {
                    SquareRecordButton.this.isLongPress = true;
                    if (SquareRecordButton.this.onlyTakePickture) {
                        return;
                    }
                    if (SquareRecordButton.this.mTouchEventListener != null) {
                        SquareRecordButton.this.btn_status = 2;
                        Log.d("MotionEvent", "onLongPressStart btn_status:" + SquareRecordButton.this.btn_status);
                        SquareRecordButton.this.mTouchEventListener.c();
                    }
                    SquareRecordButton.this.startAngle();
                    return;
                }
                SquareRecordButton.this.isLongPress = false;
                if (SquareRecordButton.this.mTouchEventListener != null) {
                    SquareRecordButton.this.mTouchEventListener.a();
                    SquareRecordButton.this.btn_status = 2;
                    Log.d("MotionEvent", "onClickEvent btn_status:" + SquareRecordButton.this.btn_status);
                    SquareRecordButton.this.startAngle();
                    SquareRecordButton.this.mTouchEventListener.c();
                    return;
                }
                return;
            }
            if (i == 2) {
                Log.d(SquareRecordButton.TAG, "MOTION_EVENT_UP" + SquareRecordButton.this.isLongPress + ",isSingleClick:" + SquareRecordButton.this.isSingleClick);
                if (SquareRecordButton.this.mTimer != null) {
                    SquareRecordButton.this.mTimer.cancel();
                }
                if (SquareRecordButton.this.isLongPress) {
                    if (SquareRecordButton.this.mTouchEventListener != null) {
                        SquareRecordButton.this.isCDCancel = true;
                        if (SquareRecordButton.this.onlyTakePickture) {
                            SquareRecordButton.this.mTouchEventListener.a();
                        } else if (message.arg1 < SquareRecordButton.this.downY - me1.b(SquareRecordButton.this.getContext(), 100)) {
                            SquareRecordButton.this.btn_status = 4;
                            SquareRecordButton.this.mHandler.removeCallbacksAndMessages(null);
                            SquareRecordButton.this.mTouchEventListener.e();
                        } else {
                            SquareRecordButton.this.btn_status = 3;
                            SquareRecordButton.this.mHandler.removeCallbacksAndMessages(null);
                            SquareRecordButton.this.mTouchEventListener.d(System.currentTimeMillis() - SquareRecordButton.this.time_action_down);
                        }
                    }
                } else if (message.arg1 < SquareRecordButton.this.downY - me1.b(SquareRecordButton.this.getContext(), 100)) {
                    SquareRecordButton.this.btn_status = 4;
                    SquareRecordButton.this.mHandler.removeCallbacksAndMessages(null);
                    SquareRecordButton.this.mTouchEventListener.e();
                } else {
                    SquareRecordButton.this.btn_status = 3;
                    SquareRecordButton.this.mHandler.removeCallbacksAndMessages(null);
                    SquareRecordButton.this.mTouchEventListener.d(System.currentTimeMillis() - SquareRecordButton.this.time_action_down);
                }
                Log.d(SquareRecordButton.TAG, "MOTION_EVENT_UP btn_status:" + SquareRecordButton.this.btn_status);
                SquareRecordButton.this.angle = 0;
                SquareRecordButton.this.invalidate();
                return;
            }
            if (i == 3) {
                Log.d(SquareRecordButton.TAG, "UPDATE_ANGLE" + SquareRecordButton.this.angle);
                if (SquareRecordButton.this.onlyTakePickture || !SquareRecordButton.this.isTouch) {
                    return;
                }
                SquareRecordButton.this.angle++;
                SquareRecordButton.this.invalidate();
                return;
            }
            if (i == 4) {
                Log.d(SquareRecordButton.TAG, "COUNT_DOWN_FINISH" + SquareRecordButton.this.isCDCancel);
                SquareRecordButton.this.endRecord();
                if (SquareRecordButton.this.onlyTakePickture || SquareRecordButton.this.mTouchEventListener == null || SquareRecordButton.this.isCDCancel) {
                    return;
                }
                SquareRecordButton.this.isLongPress = false;
                SquareRecordButton.this.btn_status = 3;
                SquareRecordButton.this.mTouchEventListener.b((long) (SquareRecordButton.MAX_PRESS_TIME_CALLBACK * 1000.0f));
                return;
            }
            if (i != 5) {
                return;
            }
            Log.d(SquareRecordButton.TAG, "MOTION_EVENT_MOVE");
            if (!SquareRecordButton.this.isLongPress || SquareRecordButton.this.mTouchEventListener == null || SquareRecordButton.this.onlyTakePickture) {
                return;
            }
            int i2 = message.arg1;
            SquareRecordButton.this.btn_status = 2;
            Log.d("MotionEvent", "MOTION_EVENT_MOVE btn_status:" + SquareRecordButton.this.btn_status);
            SquareRecordButton.this.mTouchEventListener.f(i2 < SquareRecordButton.this.downY - me1.b(SquareRecordButton.this.getContext(), 100));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SquareRecordButton.this.progress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SquareRecordButton.this.invalidate();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void a();

        void b(long j);

        void c();

        void d(long j);

        void e();

        void f(boolean z);
    }

    public SquareRecordButton(Context context) {
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
        postDelayed(new b(), 500L);
    }

    private void pressAnim() {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 0.8f).setDuration(300L);
        this.va = duration;
        duration.addUpdateListener(new d());
        this.va.setInterpolator(new DecelerateInterpolator());
        this.va.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAngle() {
        Timer timer = new Timer();
        this.mTimer = timer;
        timer.schedule(new a(), 100L, (int) ((MAX_PRESS_TIME * 1000.0f) / 360.0f));
    }

    public void cancelRecordAnim() {
        e eVar = this.mTouchEventListener;
        if (eVar != null) {
            eVar.e();
        }
        endRecord();
    }

    public void endRecord() {
        this.btn_status = 1;
        leaseAnim();
        this.angle = 0;
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        postInvalidate();
    }

    public void init() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mCircleColor = Color.parseColor(INNER_COLOR);
        this.mHandler = new c(Looper.getMainLooper());
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setColor(getCurrentColor(this.progress, this.outerColorBegin, this.outerColorEnd));
        this.mPaint.setStyle(Paint.Style.STROKE);
        float fB = me1.b(getContext(), 3);
        this.mPaint.setStrokeWidth(fB);
        int i = this.measuredWidth;
        canvas.drawCircle(i, i, this.radius * ((this.progress * 0.19999999f) + 0.8f), this.mPaint);
        this.mPaint.setColor(getCurrentColor(this.progress, this.innerColorBegin, this.innerColorEnd));
        this.mPaint.setStyle(Paint.Style.FILL);
        float f = this.radius * ((this.progress * (-0.35f)) + 0.7f);
        Log.d("recordbtndraw", "draw outer innerRadius:" + f);
        if (this.progress == 0.8f) {
            float fCos = ((float) Math.cos(Math.toRadians(45.0d))) * f;
            float f2 = this.measuredWidth - fCos;
            RectF rectF = this.oval;
            rectF.left = f2;
            rectF.top = f2;
            float f3 = f2 + (fCos * 2.0f);
            rectF.bottom = f3;
            rectF.right = f3;
            canvas.drawRoundRect(rectF, 12.0f, 12.0f, this.mPaint);
        } else {
            int i2 = this.measuredWidth;
            canvas.drawCircle(i2, i2, f, this.mPaint);
        }
        this.mPaint.setColor(this.mCircleColor);
        this.mPaint.setStrokeWidth(fB);
        this.mPaint.setStyle(Paint.Style.STROKE);
        if (this.angle != 0) {
            RectF rectF2 = this.mRect;
            int i3 = this.measuredWidth;
            rectF2.set(5.0f, 5.0f, (i3 << 1) - 5, (i3 << 1) - 5);
            canvas.drawArc(this.mRect, 270.0f, this.angle, false, this.mPaint);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.radius = getMeasuredHeight() >> 1;
        this.measuredWidth = getMeasuredHeight() >> 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            Log.e("MotionEvent", "MotionEvent.ACTION_DOWN btn_status= " + this.btn_status);
            if (this.btn_status != 2) {
                this.downY = (int) motionEvent.getY();
                this.isTouch = true;
                this.time_action_down = System.currentTimeMillis();
                Log.e("MotionEvent", "MotionEvent.ACTION_DOWN = " + this.time_action_down);
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                this.mHandler.sendMessageDelayed(messageObtain, 300L);
                pressAnim();
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 4;
                this.mHandler.removeMessages(4);
                this.mHandler.sendMessageDelayed(messageObtain2, (long) ((MAX_PRESS_TIME * 1000.0f) + 400.0f));
            }
        } else if (action == 1) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.time_action_up = jCurrentTimeMillis;
            if (jCurrentTimeMillis - this.time_action_down >= 200) {
                Log.e("MotionEvent", "MotionEvent.ACTION_UP");
                this.isTouch = false;
                Message messageObtain3 = Message.obtain();
                messageObtain3.what = 2;
                messageObtain3.arg1 = (int) motionEvent.getY();
                this.mHandler.sendMessage(messageObtain3);
                leaseAnim();
                Log.e("MotionEvent", "time_action_up = " + this.time_action_up);
            }
        } else if (action == 2) {
            Message messageObtain4 = Message.obtain();
            messageObtain4.what = 5;
            messageObtain4.arg1 = (int) motionEvent.getY();
            this.mHandler.sendMessage(messageObtain4);
        } else if (action == 3) {
        }
        return true;
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

    public void setOnlyTakePickture(boolean z) {
        this.onlyTakePickture = z;
    }

    public void setOuterColorBegin(int i) {
        this.outerColorBegin = i;
    }

    public void setOuterColorEnd(int i) {
        this.outerColorEnd = i;
    }

    public void setTouchEventListener(e eVar) {
        this.mTouchEventListener = eVar;
    }

    public SquareRecordButton(Context context, AttributeSet attributeSet) {
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
        this.outerColorBegin = Color.parseColor(OUTER_COLOR);
        this.outerColorEnd = Color.parseColor(OUTER_COLOR);
        this.innerColorBegin = Color.parseColor(INNER_COLOR);
        this.innerColorEnd = Color.parseColor(INNER_COLOR);
        this.isSingleClick = false;
        this.radius = 0;
        this.measuredWidth = 0;
        this.mRect = new RectF();
        this.oval = new RectF();
        this.btn_status = 1;
        init();
    }
}
