package com.bytedance.adsdk.ugeno.u;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class n implements x {
    private float b;
    private float fx;
    private float iz;
    private float nr;
    private float pn;
    private View u;

    public n(View view) {
        this.u = view;
    }

    public void b(float f) {
        this.pn = f;
        this.u.postInvalidate();
    }

    public void fx(float f) {
        View view = this.u;
        if (view == null) {
            return;
        }
        this.b = f;
        view.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.u.x
    public float getRipple() {
        return this.fx;
    }

    @Override // com.bytedance.adsdk.ugeno.u.x
    public float getRubIn() {
        return this.iz;
    }

    @Override // com.bytedance.adsdk.ugeno.u.x
    public float getShine() {
        return this.b;
    }

    @Override // com.bytedance.adsdk.ugeno.u.x
    public float getStretch() {
        return this.pn;
    }

    public void nr(float f) {
        View view = this.u;
        if (view == null) {
            return;
        }
        this.fx = f;
        view.postInvalidate();
    }

    public void pn(float f) {
        this.iz = f;
        this.u.postInvalidate();
    }

    public void u(float f) {
        View view = this.u;
        if (view == null) {
            return;
        }
        this.nr = f;
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setCornerRadius(f);
        }
    }

    public float u() {
        return this.nr;
    }

    public void u(int i) {
        View view = this.u;
        if (view == null) {
            return;
        }
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(i);
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background.mutate()).setColor(i);
        }
    }
}
