package com.bytedance.adsdk.ugeno.widget.text;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.fx;
import com.bytedance.adsdk.ugeno.fx.pn;
import com.bytedance.adsdk.ugeno.u.n;
import com.bytedance.adsdk.ugeno.u.x;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class UGTextView extends TextView implements pn, x {
    private float b;
    private n fx;
    private float iz;
    private float nr;
    private float pn;
    private fx u;
    private float x;

    public UGTextView(Context context) {
        super(context);
        this.b = -1.0f;
        this.iz = 1.0f;
        this.x = 0.0f;
        this.fx = new n(this);
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.nr(canvas);
        }
    }

    public float getBorderRadius() {
        return this.fx.u();
    }

    @Override // com.bytedance.adsdk.ugeno.fx.pn, com.bytedance.adsdk.ugeno.u.x
    public float getRipple() {
        return this.nr;
    }

    @Override // com.bytedance.adsdk.ugeno.u.x
    public float getRubIn() {
        return this.fx.getRubIn();
    }

    @Override // com.bytedance.adsdk.ugeno.u.x
    public float getShine() {
        return this.fx.getShine();
    }

    @Override // com.bytedance.adsdk.ugeno.u.x
    public float getStretch() {
        return this.fx.getStretch();
    }

    @Override // android.widget.TextView, android.view.View
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

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.u(canvas, this);
            this.u.u(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.u(i, i2, i3, i4);
        }
        if (z && this.b > 0.0f) {
            u(((i3 - i) - getCompoundPaddingLeft()) - getCompoundPaddingRight(), ((i4 - i2) - getCompoundPaddingBottom()) - getCompoundPaddingTop());
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        fx fxVar = this.u;
        if (fxVar == null) {
            super.onMeasure(i, i2);
        } else {
            int[] iArrU = fxVar.u(i, i2);
            super.onMeasure(iArrU[0], iArrU[1]);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.nr(i, i2, i3, i3);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.u(z);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.fx.u(i);
    }

    public void setBorderRadius(float f) {
        n nVar = this.fx;
        if (nVar != null) {
            nVar.u(f);
        }
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.iz = f2;
        this.x = f;
    }

    public void setMinTextSize(float f) {
        this.b = f;
    }

    public void setRipple(float f) {
        this.nr = f;
        n nVar = this.fx;
        if (nVar != null) {
            nVar.nr(f);
        }
        postInvalidate();
    }

    public void setRubIn(float f) {
        n nVar = this.fx;
        if (nVar != null) {
            nVar.pn(f);
        }
    }

    public void setShine(float f) {
        n nVar = this.fx;
        if (nVar != null) {
            nVar.fx(f);
        }
    }

    public void setStretch(float f) {
        n nVar = this.fx;
        if (nVar != null) {
            nVar.b(f);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(float f) {
        super.setTextSize(f);
        this.pn = getTextSize();
    }

    public void u(fx fxVar) {
        this.u = fxVar;
    }

    private void u(int i, int i2) {
        CharSequence text = getText();
        if (text == null || text.length() == 0 || i2 <= 0 || i <= 0 || this.pn == 0.0f) {
            return;
        }
        TextPaint paint = getPaint();
        float fMax = this.pn;
        int iU = u(text, paint, i, fMax);
        while (iU > i2) {
            float f = this.b;
            if (fMax <= f) {
                break;
            }
            fMax = Math.max(fMax - 1.0f, f);
            iU = u(text, paint, i, fMax);
        }
        setTextSize(0, fMax);
        setLineSpacing(this.x, this.iz);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        this.pn = getTextSize();
    }

    private int u(CharSequence charSequence, TextPaint textPaint, int i, float f) {
        TextPaint textPaint2 = new TextPaint(textPaint);
        textPaint2.setTextSize(f);
        return new StaticLayout(charSequence, textPaint2, i, Layout.Alignment.ALIGN_NORMAL, this.iz, this.x, true).getHeight();
    }
}
