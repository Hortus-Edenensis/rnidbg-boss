package com.zenmen.palmchat.circle.app.keep.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.R;
import defpackage.b5;
import defpackage.gm2;
import defpackage.k36;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@SuppressLint({"AppCompatCustomView"})
public class KeepMotionCountView extends TextView {
    public static final int DEFAULT_MOTION_COUNT = 10;
    public static final int STATE_DEFAULT = 2;
    public static final int STATE_FINISH = 1;
    public static final int STATE_PLAYING = 3;
    private static final String TAG = "com.zenmen.palmchat.circle.app.keep.widget.KeepMotionCountView";
    private b5 action0;
    private int actionFlag;
    private int curDoneMotion;
    private gm2 keepProgress;
    private TimerTask motionCalTask;
    private int motionTotals;
    private Timer timer;
    public int v;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends TimerTask {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            float progress = (KeepMotionCountView.this.keepProgress.getProgress() * 1.0f) / KeepMotionCountView.this.keepProgress.a();
            if (progress <= 0.0f) {
                return;
            }
            Log.d(KeepMotionCountView.TAG, "p%:" + (((KeepMotionCountView.this.motionTotals * progress) - 0.2f) * 100.0f));
            KeepMotionCountView keepMotionCountView = KeepMotionCountView.this;
            keepMotionCountView.curDoneMotion = Math.round((((float) keepMotionCountView.motionTotals) * progress) - 0.2f);
            Log.d(KeepMotionCountView.TAG, "curDoneMotion:" + KeepMotionCountView.this.curDoneMotion + ",motionTotals:" + KeepMotionCountView.this.motionTotals);
            if (KeepMotionCountView.this.curDoneMotion >= KeepMotionCountView.this.motionTotals) {
                KeepMotionCountView.this.stopTimer();
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            KeepMotionCountView.this.post(new Runnable() { // from class: lz2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19108a.b();
                }
            });
        }
    }

    public KeepMotionCountView(Context context) {
        super(context);
        this.motionTotals = 10;
        this.curDoneMotion = 0;
        this.timer = new Timer();
    }

    public void attachProgress(gm2 gm2Var) {
        this.keepProgress = gm2Var;
    }

    public void motionUpdate(int i, int i2) {
        if (i == 1) {
            setText("完成");
            setTextSize(40.0f);
            return;
        }
        if (i == 2) {
            if (this.actionFlag == 2) {
                setText(getContext().getString(R.string.keep_motion_default_left_sec, "" + this.motionTotals));
            } else {
                setText(getContext().getString(R.string.keep_motion_default_left, "" + this.motionTotals));
            }
            setTextSize(16.0f);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getText().toString());
            spannableStringBuilder.setSpan(new TextAppearanceSpan(null, 1, k36.j(40.0f), null, null), 4, String.valueOf(this.motionTotals).length() + 4, 33);
            setText(spannableStringBuilder);
            return;
        }
        if (i != 3) {
            return;
        }
        if (this.actionFlag == 2) {
            setText(getContext().getString(R.string.keep_motion_play_left_sec, "" + (this.motionTotals - i2)));
        } else {
            setText(getContext().getString(R.string.keep_motion_play_left, "" + (this.motionTotals - i2)));
        }
        setTextSize(16.0f);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(getText().toString());
        spannableStringBuilder2.setSpan(new TextAppearanceSpan(null, 1, k36.j(40.0f), null, null), 2, String.valueOf(this.motionTotals - i2).length() + 2, 33);
        setText(spannableStringBuilder2);
    }

    public void reset() {
        stopTimer();
        this.curDoneMotion = 0;
        motionUpdate(2, 0);
    }

    public void setActionFlag(int i) {
        this.actionFlag = i;
    }

    public void setTotalMotion(int i) {
        this.motionTotals = i;
    }

    public void startTimer() {
        if (this.curDoneMotion >= this.motionTotals) {
            stopTimer();
            return;
        }
        if (this.motionCalTask != null) {
            return;
        }
        if (this.timer == null) {
            this.timer = new Timer();
        }
        if (this.motionCalTask == null) {
            this.motionCalTask = new a();
        }
        this.timer.scheduleAtFixedRate(this.motionCalTask, 0L, 200L);
    }

    public void stopTimer() {
        TimerTask timerTask = this.motionCalTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
        this.motionCalTask = null;
        this.timer = null;
    }

    public KeepMotionCountView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.motionTotals = 10;
        this.curDoneMotion = 0;
        this.timer = new Timer();
    }

    public KeepMotionCountView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.motionTotals = 10;
        this.curDoneMotion = 0;
        this.timer = new Timer();
    }
}
