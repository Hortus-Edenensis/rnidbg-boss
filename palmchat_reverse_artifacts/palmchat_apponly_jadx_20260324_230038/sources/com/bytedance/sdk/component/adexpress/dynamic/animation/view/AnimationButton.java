package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class AnimationButton extends TextView implements nr {
    private float b;
    private float fx;
    private float nr;
    private float pn;
    u u;

    public AnimationButton(Context context) {
        super(context);
        this.u = new u();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.nr
    public float getMarqueeValue() {
        return this.b;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.nr
    public float getRippleValue() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.nr
    public float getShineValue() {
        return this.fx;
    }

    public float getStretchValue() {
        return this.pn;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.u.u(canvas, this, this);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.u.u(this, i, i2);
    }

    public void setMarqueeValue(float f) {
        this.b = f;
        postInvalidate();
    }

    public void setRippleValue(float f) {
        this.nr = f;
        postInvalidate();
    }

    public void setShineValue(float f) {
        this.fx = f;
        postInvalidate();
    }

    public void setStretchValue(float f) {
        this.pn = f;
        this.u.u(this, f);
    }
}
