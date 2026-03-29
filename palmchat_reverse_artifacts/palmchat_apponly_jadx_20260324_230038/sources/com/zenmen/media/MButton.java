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
import com.zenmen.palmchat.R;
import defpackage.wv;
import defpackage.x86;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class MButton extends View {
    private static final int COUNT_DOWN_FINISH = 4;
    private static float INNER_CIRCLE_SCALE = 0.6f;
    private static final String INNER_COLOR = "#FFFFFF";
    private static final int MIN_RECORD_TIME = 2;
    private static final int MOTION_EVENT_DOWN = 1;
    private static final int MOTION_EVENT_UP = 2;
    private static float OUTER_CIRCLE_SCALE = 0.8f;
    private static final String OUTER_COLOR = "#cccccc";
    private static final String TAG = "MButton";
    private static final int UPDATE_ANGLE = 3;
    int angle;
    private boolean canUpdateAngle;
    private boolean isCDCancel;
    private boolean isLongPress;
    private int mCircleColor;
    private Handler mHandler;
    private Paint mPaint;
    private RectF mRect;
    private Timer mTimer;
    private d mTouchEventListener;
    int measuredWidth;
    private boolean onlyTakePickture;
    int radius;
    private long time_action_down;
    private long time_action_up;
    ValueAnimator va;
    private static final float MAX_PRESS_TIME_CALLBACK = wv.a();
    private static final float MAX_PRESS_TIME = wv.a() + CompensateDelayTime();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Handler {

        /* JADX INFO: renamed from: com.zenmen.media.MButton$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0930a extends TimerTask {
            public C0930a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Message messageObtain = Message.obtain();
                messageObtain.what = 3;
                MButton.this.mHandler.sendMessage(messageObtain);
            }
        }

        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                MButton.this.isCDCancel = false;
                if (MButton.this.time_action_up >= MButton.this.time_action_down) {
                    MButton.this.isLongPress = false;
                    if (MButton.this.mTouchEventListener != null) {
                        Log.e(MButton.TAG, "onClickEvent");
                        MButton.this.mTouchEventListener.a();
                        return;
                    }
                    return;
                }
                MButton.this.isLongPress = true;
                if (MButton.this.onlyTakePickture) {
                    return;
                }
                if (MButton.this.mTouchEventListener != null) {
                    Log.e(MButton.TAG, "onLongPressStart");
                    MButton.this.mTouchEventListener.c();
                }
                MButton.this.mTimer = new Timer();
                MButton.this.mTimer.schedule(new C0930a(), 100L, (int) ((MButton.MAX_PRESS_TIME * 1000.0f) / 360.0f));
                return;
            }
            if (i == 2) {
                Log.e(MButton.TAG, "MOTION_EVENT_UP" + MButton.this.isLongPress);
                if (MButton.this.mTimer != null) {
                    MButton.this.mTimer.cancel();
                }
                if (MButton.this.isLongPress && MButton.this.mTouchEventListener != null) {
                    MButton.this.isCDCancel = true;
                    if (MButton.this.onlyTakePickture) {
                        MButton.this.mTouchEventListener.a();
                    } else {
                        MButton.this.mTouchEventListener.d(System.currentTimeMillis() - MButton.this.time_action_down);
                    }
                }
                MButton mButton = MButton.this;
                mButton.angle = 0;
                mButton.invalidate();
                return;
            }
            if (i == 3) {
                Log.e(MButton.TAG, "UPDATE_ANGLE" + MButton.this.angle);
                if (MButton.this.onlyTakePickture || !MButton.this.canUpdateAngle) {
                    return;
                }
                MButton mButton2 = MButton.this;
                mButton2.angle++;
                mButton2.invalidate();
                return;
            }
            if (i != 4) {
                return;
            }
            Log.e(MButton.TAG, "COUNT_DOWN_FINISH" + MButton.this.isCDCancel);
            if (MButton.this.onlyTakePickture || MButton.this.mTouchEventListener == null || MButton.this.isCDCancel) {
                return;
            }
            MButton.this.isLongPress = false;
            MButton.this.mTouchEventListener.b((long) (MButton.MAX_PRESS_TIME_CALLBACK * 1000.0f));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            MButton.OUTER_CIRCLE_SCALE = fFloatValue;
            MButton.INNER_CIRCLE_SCALE = fFloatValue - 0.1f;
            MButton.this.invalidate();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            MButton.OUTER_CIRCLE_SCALE = fFloatValue;
            MButton.INNER_CIRCLE_SCALE = fFloatValue - 0.1f;
            MButton.this.invalidate();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a();

        void b(long j);

        void c();

        void d(long j);
    }

    public MButton(Context context) {
        this(context, null);
    }

    private static float CompensateDelayTime() {
        return x86.b().equals("Vivo X9") ? 0.5f : 0.0f;
    }

    public void init() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mCircleColor = getResources().getColor(R.color.gen_colorPrimary);
        this.mHandler = new a(Looper.getMainLooper());
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setColor(Color.parseColor(OUTER_COLOR));
        this.mPaint.setStyle(Paint.Style.FILL);
        int i = this.measuredWidth;
        canvas.drawCircle(i, i, this.radius * (((0.6f - OUTER_CIRCLE_SCALE) / 2.0f) + 0.9f), this.mPaint);
        this.mPaint.setColor(Color.parseColor(INNER_COLOR));
        this.mPaint.setStyle(Paint.Style.FILL);
        int i2 = this.measuredWidth;
        canvas.drawCircle(i2, i2, this.radius * INNER_CIRCLE_SCALE, this.mPaint);
        this.mPaint.setColor(this.mCircleColor);
        this.mPaint.setStrokeWidth(10.0f);
        this.mPaint.setStyle(Paint.Style.STROKE);
        if (this.angle != 0) {
            RectF rectF = this.mRect;
            int i3 = this.measuredWidth;
            rectF.set(5.0f, 5.0f, (i3 << 1) - 5, (i3 << 1) - 5);
            canvas.drawArc(this.mRect, 270.0f, this.angle, false, this.mPaint);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.radius = getMeasuredHeight() >> 1;
        this.measuredWidth = getMeasuredHeight() >> 1;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.time_action_down = System.currentTimeMillis();
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            this.mHandler.sendMessageDelayed(messageObtain, 300L);
            ValueAnimator duration = ValueAnimator.ofFloat(0.8f, 0.4f).setDuration(300L);
            this.va = duration;
            duration.addUpdateListener(new b());
            this.va.setInterpolator(new DecelerateInterpolator());
            this.va.start();
            Message messageObtain2 = Message.obtain();
            messageObtain2.what = 4;
            this.mHandler.removeMessages(4);
            this.mHandler.sendMessageDelayed(messageObtain2, (long) ((MAX_PRESS_TIME * 1000.0f) + 400.0f));
        } else if (action == 1 || action == 3) {
            Message messageObtain3 = Message.obtain();
            messageObtain3.what = 2;
            this.mHandler.sendMessage(messageObtain3);
            this.time_action_up = System.currentTimeMillis();
            ValueAnimator duration2 = ValueAnimator.ofFloat(0.4f, 0.8f).setDuration(300L);
            this.va = duration2;
            duration2.addUpdateListener(new c());
            this.va.setInterpolator(new AccelerateInterpolator());
            this.va.start();
        }
        return true;
    }

    public void setCanUpdateAngle(boolean z) {
        this.canUpdateAngle = z;
    }

    public void setOnlyTakePickture(boolean z) {
        this.onlyTakePickture = z;
    }

    public void setTouchEventListener(d dVar) {
        this.mTouchEventListener = dVar;
    }

    public MButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.time_action_down = 0L;
        this.time_action_up = 0L;
        this.isLongPress = false;
        this.isCDCancel = false;
        this.angle = 0;
        this.mCircleColor = 0;
        this.radius = 0;
        this.measuredWidth = 0;
        this.mRect = new RectF();
        init();
    }
}
