package com.bytedance.adsdk.ugeno.widget.dislike;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.adsdk.ugeno.fx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class DislikeView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5051a;
    private RectF b;
    private int fx;
    private Paint iz;
    private Paint n;
    private int nr;
    private Paint pn;
    private fx u;
    private float x;

    public DislikeView(Context context) {
        super(context);
        u();
    }

    private void u() {
        Paint paint = new Paint();
        this.pn = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.n = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.iz = paint3;
        paint3.setAntiAlias(true);
        setBackgroundColor(0);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.pn();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.iz();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundColor(0);
        RectF rectF = this.b;
        float f = this.x;
        canvas.drawRoundRect(rectF, f, f, this.iz);
        RectF rectF2 = this.b;
        float f2 = this.x;
        canvas.drawRoundRect(rectF2, f2, f2, this.pn);
        int i = this.nr;
        int i2 = this.fx;
        canvas.drawLine(i * 0.3f, i2 * 0.3f, i * 0.7f, i2 * 0.7f, this.n);
        int i3 = this.nr;
        int i4 = this.fx;
        canvas.drawLine(i3 * 0.7f, i4 * 0.3f, i3 * 0.3f, i4 * 0.7f, this.n);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.u(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        fx fxVar = this.u;
        if (fxVar != null) {
            int[] iArrU = fxVar.u(i, i2);
            super.onMeasure(iArrU[0], iArrU[1]);
        } else {
            super.onMeasure(i, i2);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.nr = i;
        this.fx = i2;
        int i5 = this.f5051a;
        this.b = new RectF(i5, i5, this.nr - i5, this.fx - i5);
        fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.nr(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.u(z);
        }
    }

    public void setBgColor(int i) {
        this.iz.setStyle(Paint.Style.FILL);
        this.iz.setColor(i);
    }

    public void setDislikeColor(int i) {
        this.n.setColor(i);
    }

    public void setDislikeWidth(int i) {
        this.n.setStrokeWidth(i);
    }

    public void setRadius(float f) {
        this.x = f;
    }

    public void setStrokeColor(int i) {
        this.pn.setStyle(Paint.Style.STROKE);
        this.pn.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.pn.setStrokeWidth(i);
        this.f5051a = i;
    }

    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        this.u = fxVar;
    }
}
