package com.zenmen.palmchat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FileTransferProgressBarRoundCorner extends View {
    private static final int PROGRESS_BG_COLOR = -197380;
    private static final int PROGRESS_COLOR = -5449401;
    private static final int PROGRESS_STROKE_COLOR = -2894893;
    private Paint mPaint;
    private float mProgress;
    private float mRadiusX;
    private float mRadiusY;
    private float mStrokeWith;

    public FileTransferProgressBarRoundCorner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRadiusX = 12.0f;
        this.mRadiusY = 12.0f;
        this.mStrokeWith = 2.0f;
        this.mProgress = 0.0f;
        this.mPaint = new Paint();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setColor(PROGRESS_STROKE_COLOR);
        this.mPaint.setStrokeWidth(this.mStrokeWith);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        canvas.drawRoundRect(rectF, this.mRadiusX, this.mRadiusY, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(PROGRESS_BG_COLOR);
        float f = rectF.left;
        float f2 = this.mStrokeWith;
        rectF.left = f + f2;
        rectF.top += f2;
        rectF.right -= f2;
        rectF.bottom -= f2;
        canvas.drawRoundRect(rectF, this.mRadiusX, this.mRadiusY, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(PROGRESS_COLOR);
        rectF.right *= this.mProgress;
        canvas.drawRoundRect(rectF, this.mRadiusX, this.mRadiusY, this.mPaint);
    }

    public void setProgress(float f) {
        this.mProgress = f;
        invalidate();
    }
}
