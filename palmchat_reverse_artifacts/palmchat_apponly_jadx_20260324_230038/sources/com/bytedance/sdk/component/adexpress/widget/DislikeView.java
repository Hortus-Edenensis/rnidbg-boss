package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DislikeView extends View {
    private Paint b;
    private final RectF fx;
    private int iz;
    private int n;
    private int nr;
    private Paint pn;
    private int u;
    private Paint x;

    public DislikeView(Context context) {
        super(context);
        this.fx = new RectF();
        u();
    }

    private void u() {
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.x = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.pn = paint3;
        paint3.setAntiAlias(true);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.fx;
        int i = this.iz;
        canvas.drawRoundRect(rectF, i, i, this.pn);
        RectF rectF2 = this.fx;
        int i2 = this.iz;
        canvas.drawRoundRect(rectF2, i2, i2, this.b);
        int i3 = this.u;
        int i4 = this.nr;
        canvas.drawLine(i3 * 0.3f, i4 * 0.3f, i3 * 0.7f, i4 * 0.7f, this.x);
        int i5 = this.u;
        int i6 = this.nr;
        canvas.drawLine(i5 * 0.7f, i6 * 0.3f, i5 * 0.3f, i6 * 0.7f, this.x);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.u = i;
        this.nr = i2;
        RectF rectF = this.fx;
        int i5 = this.n;
        rectF.set(i5, i5, i - i5, i2 - i5);
    }

    public void setBgColor(int i) {
        this.pn.setStyle(Paint.Style.FILL);
        this.pn.setColor(i);
    }

    public void setDislikeColor(int i) {
        this.x.setColor(i);
    }

    public void setDislikeWidth(int i) {
        this.x.setStrokeWidth(i);
    }

    public void setRadius(int i) {
        this.iz = i;
    }

    public void setStrokeColor(int i) {
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.b.setStrokeWidth(i);
        this.n = i;
    }
}
