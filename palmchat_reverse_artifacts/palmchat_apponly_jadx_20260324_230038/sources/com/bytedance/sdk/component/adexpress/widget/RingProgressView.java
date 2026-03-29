package com.bytedance.sdk.component.adexpress.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class RingProgressView extends View {
    private float b;
    private RectF fx;
    private int iz;
    private Paint nr;
    private ValueAnimator pn;
    private Context u;
    private boolean x;

    public RingProgressView(Context context) {
        super(context);
        this.iz = TTAdConstant.STYLE_SIZE_RADIO_3_2;
        this.u = context;
        Paint paint = new Paint();
        this.nr = paint;
        paint.setAntiAlias(true);
        this.nr.setStyle(Paint.Style.STROKE);
        this.nr.setStrokeWidth(10.0f);
        this.nr.setColor(Color.parseColor("#80FFFFFF"));
        this.fx = new RectF();
    }

    public void fx() {
        this.x = true;
        invalidate();
    }

    public void nr() {
        ValueAnimator valueAnimator = this.pn;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.x) {
            return;
        }
        canvas.drawArc(this.fx, 270.0f, this.b, false, this.nr);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.fx.set(5.0f, 5.0f, i - 5, i2 - 5);
    }

    public void setDuration(int i) {
        this.iz = i;
    }

    public void u() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.pn = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.iz);
        this.pn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RingProgressView.this.b = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RingProgressView.this.requestLayout();
            }
        });
        this.pn.start();
    }
}
