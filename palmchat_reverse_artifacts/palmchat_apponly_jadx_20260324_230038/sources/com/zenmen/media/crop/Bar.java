package com.zenmen.media.crop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.TypedValue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class Bar {
    private final float mLeftX;
    private int mNumSegments;
    private final Paint mPaint;
    private final float mRightX;
    private float mTickDistance;
    private final float mTickEndY;
    private final float mTickHeight;
    private final float mTickStartY;
    private final float mY;

    public Bar(Context context, float f, float f2, float f3, int i, float f4, float f5, int i2) {
        this.mLeftX = f;
        this.mRightX = f + f3;
        this.mY = f2;
        int i3 = i - 1;
        this.mNumSegments = i3;
        this.mTickDistance = f3 / i3;
        float fApplyDimension = TypedValue.applyDimension(1, f4, context.getResources().getDisplayMetrics());
        this.mTickHeight = fApplyDimension;
        this.mTickStartY = f2 - (fApplyDimension / 2.0f);
        this.mTickEndY = f2 + (fApplyDimension / 2.0f);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(i2);
        paint.setStrokeWidth(f5);
        paint.setAntiAlias(true);
    }

    private void drawTicks(Canvas canvas) {
        for (int i = 0; i < this.mNumSegments; i++) {
            float f = (i * this.mTickDistance) + this.mLeftX;
            canvas.drawLine(f, this.mTickStartY, f, this.mTickEndY, this.mPaint);
        }
        float f2 = this.mRightX;
        canvas.drawLine(f2, this.mTickStartY, f2, this.mTickEndY, this.mPaint);
    }

    public void draw(Canvas canvas) {
        drawTicks(canvas);
    }

    public float getLeftX() {
        return this.mLeftX;
    }

    public float getNearestTickCoordinate(Thumb thumb) {
        return this.mLeftX + (getNearestTickIndex(thumb) * this.mTickDistance);
    }

    public int getNearestTickIndex(Thumb thumb) {
        float x = thumb.getX() - this.mLeftX;
        float f = this.mTickDistance;
        return (int) ((x + (f / 2.0f)) / f);
    }

    public float getRightX() {
        return this.mRightX;
    }

    public void setTickCount(int i) {
        float f = this.mRightX - this.mLeftX;
        int i2 = i - 1;
        this.mNumSegments = i2;
        this.mTickDistance = f / i2;
    }
}
