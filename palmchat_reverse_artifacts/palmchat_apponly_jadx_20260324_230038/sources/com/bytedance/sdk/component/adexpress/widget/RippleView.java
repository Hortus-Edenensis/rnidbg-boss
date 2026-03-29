package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class RippleView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animator.AnimatorListener f5110a;
    private ValueAnimator b;
    private ValueAnimator fx;
    private long iz;
    private int jk;
    private float n;
    private float nr;
    private Paint pn;
    private float u;
    private float x;

    public RippleView(Context context, int i) {
        super(context);
        this.iz = 300L;
        this.x = 0.0f;
        this.jk = i;
        u();
    }

    public void fx() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.n, 0.0f);
        this.b = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.iz);
        this.b.setInterpolator(new LinearInterpolator());
        this.b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RippleView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleView.this.x = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        Animator.AnimatorListener animatorListener = this.f5110a;
        if (animatorListener != null) {
            this.b.addListener(animatorListener);
        }
        this.b.start();
    }

    public void nr() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, this.n);
        this.fx = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.iz);
        this.fx.setInterpolator(new LinearInterpolator());
        this.fx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RippleView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleView.this.x = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        this.fx.start();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.u, this.nr, this.x, this.pn);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.u = i / 2.0f;
        this.nr = i2 / 2.0f;
        this.n = (float) (Math.hypot(i, i2) / 2.0d);
    }

    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        this.f5110a = animatorListener;
    }

    public void u() {
        Paint paint = new Paint(1);
        this.pn = paint;
        paint.setStyle(Paint.Style.FILL);
        this.pn.setColor(this.jk);
    }
}
