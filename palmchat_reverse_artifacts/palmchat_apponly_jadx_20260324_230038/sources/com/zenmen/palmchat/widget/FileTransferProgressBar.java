package com.zenmen.palmchat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FileTransferProgressBar extends View {
    private static final int PROGRESS_BG_COLOR = -4210753;
    private static final int PROGRESS_COLOR = -12206054;
    private Paint mPaint;
    private float mProgress;

    public FileTransferProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setColor(PROGRESS_BG_COLOR);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.mPaint);
        this.mPaint.setColor(PROGRESS_COLOR);
        canvas.drawRect(0.0f, 0.0f, getWidth() * this.mProgress, getHeight(), this.mPaint);
    }

    public void setProgress(float f) {
        this.mProgress = f;
        invalidate();
    }
}
