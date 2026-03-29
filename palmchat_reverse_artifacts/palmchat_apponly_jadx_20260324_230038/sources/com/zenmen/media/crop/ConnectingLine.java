package com.zenmen.media.crop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.TypedValue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ConnectingLine {
    private final float mConnectingLineWeight;
    private final Paint mPaint;
    private final float mY;

    public ConnectingLine(Context context, float f, float f2, int i) {
        float fApplyDimension = TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
        this.mConnectingLineWeight = fApplyDimension;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(i);
        paint.setStrokeWidth(fApplyDimension);
        paint.setAntiAlias(true);
        this.mY = f;
    }

    public void draw(Canvas canvas, Thumb thumb, Thumb thumb2) {
        canvas.drawLine(thumb.getX(), this.mY, thumb2.getX(), this.mY, this.mPaint);
    }
}
