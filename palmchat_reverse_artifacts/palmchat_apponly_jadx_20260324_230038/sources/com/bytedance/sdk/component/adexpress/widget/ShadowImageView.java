package com.bytedance.sdk.component.adexpress.widget;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@SuppressLint({"AppCompatCustomView"})
public class ShadowImageView extends ImageView {
    private RectF nr;
    private Paint u;

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
