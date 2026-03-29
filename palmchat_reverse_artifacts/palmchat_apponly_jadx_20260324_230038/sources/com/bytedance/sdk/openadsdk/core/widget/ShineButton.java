package com.bytedance.sdk.openadsdk.core.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ShineButton extends Button {
    private float b;
    private Matrix fx;
    private float iz;
    private LinearGradient nr;
    private ValueAnimator pn;
    private Paint u;

    public ShineButton(Context context) {
        super(context);
        this.u = new Paint(1);
        this.fx = new Matrix();
        this.b = 0.0f;
        this.iz = 0.3f;
        u(context);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.pn;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.pn.removeAllListeners();
            this.pn.removeAllUpdateListeners();
            this.pn = null;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Matrix matrix = this.fx;
        float f = this.b;
        matrix.setTranslate(f, f);
        this.nr.setLocalMatrix(this.fx);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.u);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i2 * this.iz;
        float f2 = -f;
        LinearGradient linearGradient = new LinearGradient(f2, f2, f, f, new int[]{0, Color.parseColor("#88ffffff"), Color.parseColor("#88ffffff"), 0}, new float[]{0.0f, 0.2f, 0.8f, 1.0f}, Shader.TileMode.CLAMP);
        this.nr = linearGradient;
        this.u.setShader(linearGradient);
        u();
    }

    private void u(Context context) {
        this.u.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        this.u.setColor(-1);
    }

    private void u() {
        ValueAnimator valueAnimator = this.pn;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.pn.removeAllListeners();
            this.pn.removeAllUpdateListeners();
            this.pn = null;
        }
        float fSqrt = (float) Math.sqrt((getWidth() * getWidth()) + (getHeight() * getHeight()));
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(-fSqrt, fSqrt);
        this.pn = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(2000L);
        this.pn.setRepeatCount(-1);
        this.pn.setInterpolator(new LinearInterpolator());
        this.pn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ShineButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ShineButton.this.b = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                ShineButton.this.invalidate();
            }
        });
        this.pn.start();
    }
}
