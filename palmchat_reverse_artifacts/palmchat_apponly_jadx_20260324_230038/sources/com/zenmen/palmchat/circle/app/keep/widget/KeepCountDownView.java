package com.zenmen.palmchat.circle.app.keep.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import defpackage.b5;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@SuppressLint({"AppCompatCustomView"})
public class KeepCountDownView extends TextView {
    private static final int COUNT_DOWN_NUM = 3;
    private static final String TAG = "com.zenmen.palmchat.circle.app.keep.widget.KeepCountDownView";
    private b5 action0;
    private TimerTask countDownTask;
    private int curCountDownNum;
    private boolean goToRun;
    private Timer timer;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends TimerTask {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            if (KeepCountDownView.this.curCountDownNum <= 0) {
                KeepCountDownView.this.countDownEnd();
                return;
            }
            if (KeepCountDownView.this.goToRun) {
                Log.d(KeepCountDownView.TAG, "curCountDownNum:" + KeepCountDownView.this.curCountDownNum);
                KeepCountDownView keepCountDownView = KeepCountDownView.this;
                StringBuilder sb = new StringBuilder();
                sb.append("");
                KeepCountDownView keepCountDownView2 = KeepCountDownView.this;
                int i = keepCountDownView2.curCountDownNum;
                keepCountDownView2.curCountDownNum = i - 1;
                sb.append(i);
                keepCountDownView.setText(sb.toString());
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            KeepCountDownView.this.post(new Runnable() { // from class: fz2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17625a.b();
                }
            });
        }
    }

    public KeepCountDownView(Context context) {
        super(context);
        this.curCountDownNum = 3;
        this.timer = new Timer();
        this.goToRun = false;
        init();
    }

    private void ThrowException() {
        Log.d(TAG, Log.getStackTraceString(new Throwable()));
        new Exception("this is a log").printStackTrace();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            Log.i(TAG, stackTraceElement.toString());
        }
        RuntimeException runtimeException = new RuntimeException();
        runtimeException.fillInStackTrace();
        String str = TAG;
        Log.i(str, "stackTrace", runtimeException);
        try {
            Log.i(str, "--------------------------------NullPointerException-----------1");
            throw new NullPointerException();
        } catch (NullPointerException e) {
            String str2 = TAG;
            Log.i(str2, "--------------------------------NullPointerException");
            Log.e(str2, Log.getStackTraceString(e));
            Log.i(str2, "--------------------------------NullPointerException-----------end");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void countDownEnd() {
        b5 b5Var = this.action0;
        if (b5Var != null) {
            b5Var.call();
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        stopTimer();
    }

    private void init() {
        setTextColor(Color.parseColor("#14CD64"));
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(160.0f);
    }

    public boolean isFinishCountDown() {
        return this.curCountDownNum <= 0;
    }

    public boolean isRunning() {
        return this.countDownTask != null;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        stopTimer();
        super.onDetachedFromWindow();
    }

    public void setAction0(b5 b5Var) {
        this.action0 = b5Var;
    }

    public void startTimer() {
        Log.d(TAG, "start timer");
        if (this.countDownTask != null) {
            return;
        }
        if (this.curCountDownNum <= 0) {
            countDownEnd();
            return;
        }
        this.goToRun = true;
        if (this.timer == null) {
            this.timer = new Timer();
        }
        if (this.countDownTask == null) {
            this.countDownTask = new a();
        }
        this.timer.scheduleAtFixedRate(this.countDownTask, 0L, 1000L);
    }

    public void stopTimer() {
        this.goToRun = false;
        Log.d(TAG, "stop task");
        TimerTask timerTask = this.countDownTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
        this.countDownTask = null;
        this.timer = null;
    }

    public KeepCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.curCountDownNum = 3;
        this.timer = new Timer();
        this.goToRun = false;
        init();
    }

    public KeepCountDownView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.curCountDownNum = 3;
        this.timer = new Timer();
        this.goToRun = false;
        init();
    }
}
