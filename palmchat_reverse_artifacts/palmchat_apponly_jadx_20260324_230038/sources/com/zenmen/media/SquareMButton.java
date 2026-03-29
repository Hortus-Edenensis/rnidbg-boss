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
public class SquareMButton extends View {
    private static final int COUNT_DOWN_FINISH = 4;
    private static final float INNER_CIRCLE_SCALE_BEGIN = 0.7f;
    private static final float INNER_CIRCLE_SCALE_END = 0.35f;
    private static final String INNER_COLOR = "#FFFFFF";
    private static final int MIN_RECORD_TIME = 2;
    private static final int MOTION_EVENT_DOWN = 1;
    private static final int MOTION_EVENT_MOVE = 5;
    private static final int MOTION_EVENT_UP = 2;
    private static final float OUTER_CIRCLE_SCALE_BEGIN = 0.8f;
    private static final float OUTER_CIRCLE_SCALE_END = 1.0f;
    private static final String OUTER_COLOR = "#cccccc";
    private static final String TAG = "MButton";
    private static final int UPDATE_ANGLE = 3;
    private int angle;
    private int downY;
    private int innerColorBegin;
    private int innerColorEnd;
    private boolean isCDCancel;
    private boolean isLongPress;
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
    private float progress;
    int radius;
    private long time_action_down;
    private long time_action_up;
    ValueAnimator va;
    private static final float MAX_PRESS_TIME_CALLBACK = wv.a();
    private static final float MAX_PRESS_TIME = wv.a() + CompensateDelayTime();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Handler {

        /* JADX INFO: renamed from: com.zenmen.media.SquareMButton$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0931a extends TimerTask {
            public C0931a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Message messageObtain = Message.obtain();
                messageObtain.what = 3;
                SquareMButton.this.mHandler.sendMessage(messageObtain);
            }
        }

        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                SquareMButton.this.isCDCancel = false;
                if (SquareMButton.this.time_action_up >= SquareMButton.this.time_action_down) {
                    SquareMButton.this.isLongPress = false;
                    SquareMButton.g(SquareMButton.this);
                    return;
                }
                SquareMButton.this.isLongPress = true;
                if (SquareMButton.this.onlyTakePickture) {
                    return;
                }
                SquareMButton.g(SquareMButton.this);
                SquareMButton.this.mTimer = new Timer();
                SquareMButton.this.mTimer.schedule(new C0931a(), 100L, (int) ((SquareMButton.MAX_PRESS_TIME * 1000.0f) / 360.0f));
                return;
            }
            if (i == 2) {
                Log.e(SquareMButton.TAG, "MOTION_EVENT_UP" + SquareMButton.this.isLongPress);
                if (SquareMButton.this.mTimer != null) {
                    SquareMButton.this.mTimer.cancel();
                }
                if (SquareMButton.this.isLongPress) {
                    SquareMButton.g(SquareMButton.this);
                }
                SquareMButton.this.angle = 0;
                SquareMButton.this.invalidate();
                return;
            }
            if (i == 3) {
                Log.e(SquareMButton.TAG, "UPDATE_ANGLE" + SquareMButton.this.angle);
                if (SquareMButton.this.onlyTakePickture || !SquareMButton.this.isTouch) {
                    return;
                }
                SquareMButton.this.angle++;
                SquareMButton.this.invalidate();
                return;
            }
            if (i != 4) {
                if (i == 5 && SquareMButton.this.isLongPress) {
                    SquareMButton.g(SquareMButton.this);
                    return;
                }
                return;
            }
            Log.e(SquareMButton.TAG, "COUNT_DOWN_FINISH" + SquareMButton.this.isCDCancel);
            if (SquareMButton.this.onlyTakePickture) {
                return;
            }
            SquareMButton.g(SquareMButton.this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SquareMButton.this.progress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SquareMButton.this.invalidate();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SquareMButton.this.progress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SquareMButton.this.invalidate();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
    }

    public SquareMButton(Context context) {
        this(context, null);
    }

    private static float CompensateDelayTime() {
        return x86.b().equals("Vivo X9") ? 0.5f : 0.0f;
    }

    public static /* bridge */ /* synthetic */ d g(SquareMButton squareMButton) {
        squareMButton.getClass();
        return null;
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
        this.mPaint.setColor(getCurrentColor(this.progress, this.outerColorBegin, this.outerColorEnd));
        this.mPaint.setStyle(Paint.Style.FILL);
        int i = this.measuredWidth;
        canvas.drawCircle(i, i, this.radius * ((this.progress * 0.19999999f) + 0.8f), this.mPaint);
        this.mPaint.setColor(getCurrentColor(this.progress, this.innerColorBegin, this.innerColorEnd));
        this.mPaint.setStyle(Paint.Style.FILL);
        int i2 = this.measuredWidth;
        canvas.drawCircle(i2, i2, this.radius * ((this.progress * (-0.35f)) + 0.7f), this.mPaint);
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
            this.downY = (int) motionEvent.getY();
            this.isTouch = true;
            this.time_action_down = System.currentTimeMillis();
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            this.mHandler.sendMessageDelayed(messageObtain, 300L);
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
            this.va = duration;
            duration.addUpdateListener(new b());
            this.va.setInterpolator(new DecelerateInterpolator());
            this.va.start();
            Message messageObtain2 = Message.obtain();
            messageObtain2.what = 4;
            this.mHandler.removeMessages(4);
            this.mHandler.sendMessageDelayed(messageObtain2, (long) ((MAX_PRESS_TIME * 1000.0f) + 400.0f));
        } else if (action == 1) {
            this.isTouch = false;
            Message messageObtain3 = Message.obtain();
            messageObtain3.what = 2;
            messageObtain3.arg1 = (int) motionEvent.getY();
            this.mHandler.sendMessage(messageObtain3);
            this.time_action_up = System.currentTimeMillis();
            ValueAnimator duration2 = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(300L);
            this.va = duration2;
            duration2.addUpdateListener(new c());
            this.va.setInterpolator(new AccelerateInterpolator());
            this.va.start();
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

    public SquareMButton(Context context, AttributeSet attributeSet) {
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
        this.radius = 0;
        this.measuredWidth = 0;
        this.mRect = new RectF();
        init();
    }

    public void setTouchEventListener(d dVar) {
    }
}
