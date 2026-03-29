package com.bytedance.sdk.openadsdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@SuppressLint({"AppCompatCustomView"})
public class ShadowImageView extends ImageView {
    private RectF nr;
    private Paint u;

    public ShadowImageView(Context context) {
        super(context);
        u();
    }

    private void u() {
        Paint paint = new Paint();
        this.u = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.u.setColor(Color.parseColor("#99333333"));
        this.u.setAntiAlias(true);
        this.u.setStrokeWidth(0.0f);
        this.nr = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.nr;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, rectF.bottom / 2.0f, this.u);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.nr.right == getMeasuredWidth() && this.nr.bottom == getMeasuredHeight()) {
            return;
        }
        this.nr.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }
}
