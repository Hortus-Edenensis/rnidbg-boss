package com.zenmen.palmchat.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class DownloadProgressBar extends View {
    private static final float START_ANGLE = -90.0f;
    private Paint mBackgroundPaint;
    private RectF mBackgroundRect;
    private Paint mBorderPaint;
    private RectF mBorderRect;
    private int mPadding;
    private int mProgress;
    private Paint mProgressPaint;
    private RectF mProgressRect;

    public DownloadProgressBar(Context context) {
        super(context);
        this.mProgress = 0;
        this.mBorderRect = new RectF();
        this.mBackgroundRect = new RectF();
        this.mProgressRect = new RectF();
        this.mPadding = 0;
        init();
    }

    private void init() {
        this.mPadding = (int) (getContext().getResources().getDisplayMetrics().density * 1.0f);
        Paint paint = new Paint();
        this.mBorderPaint = paint;
        paint.setColor(-1);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setStrokeWidth(this.mPadding);
        Paint paint2 = new Paint();
        this.mBackgroundPaint = paint2;
        paint2.setColor(-1);
        this.mBackgroundPaint.setAntiAlias(true);
        this.mBackgroundPaint.setAlpha(200);
        this.mBackgroundPaint.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint();
        this.mProgressPaint = paint3;
        paint3.setColor(-1);
        this.mProgressPaint.setAntiAlias(true);
        this.mProgressPaint.setStyle(Paint.Style.FILL);
    }

    public int getProgress() {
        return this.mProgress;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.mBackgroundRect;
        int i = this.mPadding;
        rectF.set(i, i, canvas.getWidth() - this.mPadding, canvas.getHeight() - this.mPadding);
        canvas.drawArc(this.mBackgroundRect, -90.0f, 360.0f, false, this.mBorderPaint);
        RectF rectF2 = this.mBorderRect;
        int i2 = this.mPadding;
        rectF2.set(i2, i2, canvas.getWidth() - this.mPadding, canvas.getHeight() - this.mPadding);
        canvas.drawArc(this.mBorderRect, -90.0f, 360.0f, false, this.mBorderPaint);
        RectF rectF3 = this.mProgressRect;
        int i3 = this.mPadding;
        rectF3.set(i3 * 2.5f, i3 * 2.5f, canvas.getWidth() - (this.mPadding * 2.5f), canvas.getHeight() - (this.mPadding * 2.5f));
        canvas.drawArc(this.mProgressRect, -90.0f, (this.mProgress / 100.0f) * 360.0f, true, this.mProgressPaint);
    }

    public void setProgress(int i) {
        this.mProgress = i;
        invalidate();
    }

    public DownloadProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0;
        this.mBorderRect = new RectF();
        this.mBackgroundRect = new RectF();
        this.mProgressRect = new RectF();
        this.mPadding = 0;
        init();
    }

    public DownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mBorderRect = new RectF();
        this.mBackgroundRect = new RectF();
        this.mProgressRect = new RectF();
        this.mPadding = 0;
        init();
    }

    @TargetApi(21)
    public DownloadProgressBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mProgress = 0;
        this.mBorderRect = new RectF();
        this.mBackgroundRect = new RectF();
        this.mProgressRect = new RectF();
        this.mPadding = 0;
        init();
    }
}
