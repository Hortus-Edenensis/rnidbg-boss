package com.bytedance.adsdk.ugeno.widget.progressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.fx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class UGProgressBar extends FrameLayout {
    private TextView b;
    private View fx;
    private View nr;
    private int pn;
    private fx u;

    public UGProgressBar(Context context) {
        super(context);
        u(context);
    }

    private void u(Context context) {
        this.nr = new View(context);
        this.fx = new View(context);
        addView(this.nr);
        addView(this.fx);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nr.getLayoutParams();
        layoutParams.width = 0;
        layoutParams.height = -1;
        layoutParams.gravity = 3;
        this.nr.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fx.getLayoutParams();
        layoutParams2.width = this.pn;
        layoutParams2.gravity = 5;
        this.fx.setLayoutParams(layoutParams2);
        TextView textView = new TextView(context);
        this.b = textView;
        textView.setTextColor(-1);
        this.b.setTextSize(16.0f);
        this.b.setGravity(17);
        addView(this.b);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.pn();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
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
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.u(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.u(i, i2);
        }
        super.onMeasure(i, i2);
        this.pn = u(0, i);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.pn = i;
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

    public void setProgress(float f) {
        int width = getWidth();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nr.getLayoutParams();
        float f2 = width;
        float f3 = (f / 100.0f) * f2;
        layoutParams.width = (int) f3;
        this.nr.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fx.getLayoutParams();
        layoutParams2.width = (int) (f2 - f3);
        this.fx.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams3.width = width;
        layoutParams3.gravity = 17;
        requestLayout();
    }

    public void setProgressBgColor(int i) {
        this.fx.setBackgroundColor(i);
    }

    public void setProgressColor(int i) {
        this.nr.setBackgroundColor(i);
    }

    public void setText(String str) {
        this.b.setText(str);
    }

    public void setTextColor(int i) {
        this.b.setTextColor(i);
    }

    private int u(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i, size) : i;
    }

    public void u(fx fxVar) {
        this.u = fxVar;
    }
}
