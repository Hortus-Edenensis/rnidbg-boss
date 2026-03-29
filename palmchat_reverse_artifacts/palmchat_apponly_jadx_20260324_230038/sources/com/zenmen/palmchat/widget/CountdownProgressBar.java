package com.zenmen.palmchat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class CountdownProgressBar extends View {
    private static final long DEFAULT_DURATION = 6000;
    private a mCallback;
    private int mColor;
    private long mDuration;
    private float mLeft;
    private Paint mPaint;
    private long mProgress;
    private float mRight;
    private long mStartTime;
    private boolean mStarted;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
    }

    public CountdownProgressBar(Context context) {
        super(context);
        this.mDuration = DEFAULT_DURATION;
        this.mColor = -16711936;
        this.mStartTime = -1L;
        this.mStarted = false;
        this.mProgress = 0L;
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    public long getDuration() {
        return this.mDuration;
    }

    public long getProgress() {
        return this.mProgress;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mStarted) {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
                this.mLeft = 0.0f;
                this.mRight = canvas.getWidth();
            }
            this.mPaint.setColor(this.mColor);
            canvas.drawRect(this.mLeft, 0.0f, this.mRight, canvas.getHeight(), this.mPaint);
            long jCurrentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.mProgress = jCurrentTimeMillis;
            if (jCurrentTimeMillis <= this.mDuration) {
                float width = canvas.getWidth() * (1.0f - (this.mProgress / this.mDuration));
                this.mLeft = (canvas.getWidth() - width) / 2.0f;
                this.mRight = (canvas.getWidth() + width) / 2.0f;
            } else {
                this.mStarted = false;
            }
            invalidate();
        }
    }

    public void resetProgress() {
        this.mProgress = 0L;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public void setDuration(long j) {
        if (j >= 0) {
            this.mDuration = j;
        }
    }

    public void start() {
        this.mStartTime = -1L;
        this.mStarted = true;
        this.mProgress = 0L;
        invalidate();
    }

    public void stop() {
        this.mStarted = false;
        invalidate();
    }

    public CountdownProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDuration = DEFAULT_DURATION;
        this.mColor = -16711936;
        this.mStartTime = -1L;
        this.mStarted = false;
        this.mProgress = 0L;
        init();
    }

    public CountdownProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDuration = DEFAULT_DURATION;
        this.mColor = -16711936;
        this.mStartTime = -1L;
        this.mStarted = false;
        this.mProgress = 0L;
        init();
    }

    public void setCallback(a aVar) {
    }
}
