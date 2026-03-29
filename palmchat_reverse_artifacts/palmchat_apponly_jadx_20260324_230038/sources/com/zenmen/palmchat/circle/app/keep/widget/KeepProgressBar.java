package com.zenmen.palmchat.circle.app.keep.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import defpackage.b5;
import defpackage.gm2;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class KeepProgressBar extends ProgressBar {
    public static final int STATE_DEFAULT = 101;
    public static final int STATE_DOWNLOADING = 102;
    public static final int STATE_DOWNLOAD_FINISH = 104;
    public static final int STATE_PAUSE = 103;
    private static final String TAG = "com.zenmen.palmchat.circle.app.keep.widget.KeepProgressBar";
    private b5 action0;
    public int delayTime;
    private gm2 keepProgress;
    private Context mContext;
    private int mState;
    private int prevProgress;
    private TimerTask progressTask;
    private Timer timer;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends TimerTask {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            int progress = KeepProgressBar.this.keepProgress.getProgress();
            if (progress <= 0) {
                return;
            }
            KeepProgressBar.this.setState(102);
            KeepProgressBar.this.setProgress(progress);
            if (KeepProgressBar.this.getProgress() == KeepProgressBar.this.getMax()) {
                if (KeepProgressBar.this.action0 != null) {
                    KeepProgressBar.this.action0.call();
                }
                KeepProgressBar.this.stopTimer();
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            KeepProgressBar.this.post(new Runnable() { // from class: vz2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21563a.b();
                }
            });
        }
    }

    public KeepProgressBar(Context context) {
        super(context, null, R.attr.progressBarStyleHorizontal);
        this.timer = new Timer();
        this.mContext = context;
        init();
    }

    private void init() {
        setIndeterminate(false);
        setIndeterminateDrawable(ContextCompat.getDrawable(this.mContext, R.drawable.progress_indeterminate_horizontal));
        setProgressDrawable(ContextCompat.getDrawable(this.mContext, com.zenmen.palmchat.R.drawable.keep_motion_shape_g));
        setMax(100);
    }

    public void attachProgress(gm2 gm2Var) {
        this.keepProgress = gm2Var;
    }

    public void reset() {
        this.prevProgress = 0;
        setState(101);
        stopTimer();
        setProgress(0);
    }

    public void setAction0(b5 b5Var) {
        this.action0 = b5Var;
    }

    public void setDelayTime(int i) {
        this.delayTime = i;
    }

    @Override // android.widget.ProgressBar
    public synchronized void setMax(int i) {
        super.setMax(i - this.delayTime);
    }

    public synchronized void setProgress(float f) {
        super.setProgress((int) f);
    }

    public synchronized void setState(int i) {
        this.mState = i;
        invalidate();
    }

    public void startTimer() {
        if (this.progressTask != null) {
            return;
        }
        if (this.timer == null) {
            this.timer = new Timer();
        }
        if (this.progressTask == null) {
            this.progressTask = new a();
        }
        this.timer.scheduleAtFixedRate(this.progressTask, 0L, 10L);
    }

    public void stopTimer() {
        TimerTask timerTask = this.progressTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
        this.progressTask = null;
        this.timer = null;
    }

    public KeepProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.timer = new Timer();
        this.mContext = context;
        init();
    }
}
