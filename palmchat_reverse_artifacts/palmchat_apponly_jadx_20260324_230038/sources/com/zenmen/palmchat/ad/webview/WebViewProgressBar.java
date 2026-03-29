package com.zenmen.palmchat.ad.webview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class WebViewProgressBar extends View {
    public static final float MAX_PROGRESS = 100.0f;
    private static final int PROGRESS_BG_COLOR = 16777215;
    private static final int PROGRESS_COLOR = -12206054;
    private static final float PROGRESS_INTERVAL = 2.0f;
    private static final String TAG = "WebViewProgressBar";
    private float currentProgress;
    private Paint mPaint;
    private float mProgress;

    public WebViewProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = 0.0f;
        this.currentProgress = 0.0f;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(PROGRESS_COLOR);
        setBackgroundColor(16777215);
    }

    private void drawRect(Canvas canvas, float f) {
        canvas.drawRect(new RectF(0.0f, 0.0f, (getWidth() * f) / 100.0f, getHeight()), this.mPaint);
        if (this.currentProgress <= this.mProgress) {
            postInvalidate();
        }
    }

    private void updateProgress() {
        float f = this.currentProgress;
        float f2 = f + (f < 60.0f ? 0.5f + ((2.5f * (60.0f - f)) / 100.0f) : 0.5f);
        this.currentProgress = f2;
        float f3 = this.mProgress;
        if (f2 > f3) {
            this.currentProgress = f3;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.mProgress;
        if (f == 0.0f || f > 100.0f) {
            return;
        }
        float f2 = this.currentProgress;
        if (f2 == 100.0f) {
            setVisibility(8);
        } else {
            drawRect(canvas, f2);
            updateProgress();
        }
    }

    public void setProgress(float f) {
        if (f >= this.mProgress) {
            this.mProgress = f;
        }
        postInvalidate();
    }

    public void start() {
        this.currentProgress = 0.0f;
        this.mProgress = 85.0f;
        setVisibility(0);
        postInvalidate();
    }

    public void stop() {
        setProgress(100.0f);
        postInvalidate();
    }
}
