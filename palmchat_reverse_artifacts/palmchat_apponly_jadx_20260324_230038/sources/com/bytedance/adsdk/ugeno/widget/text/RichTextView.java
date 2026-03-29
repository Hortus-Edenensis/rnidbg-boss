package com.bytedance.adsdk.ugeno.widget.text;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.text.Html;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.fx;
import com.bytedance.adsdk.ugeno.u.n;
import com.bytedance.adsdk.ugeno.u.x;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class RichTextView extends TextView implements x {
    private n nr;
    private fx u;

    public RichTextView(Context context) {
        super(context);
        this.nr = new n(this);
    }

    public float getBorderRadius() {
        return this.nr.u();
    }

    @Override // com.bytedance.adsdk.ugeno.u.x
    public float getRipple() {
        return this.nr.getRipple();
    }

    @Override // com.bytedance.adsdk.ugeno.u.x
    public float getRubIn() {
        return this.nr.getRubIn();
    }

    @Override // com.bytedance.adsdk.ugeno.u.x
    public float getShine() {
        return this.nr.getShine();
    }

    @Override // com.bytedance.adsdk.ugeno.u.x
    public float getStretch() {
        return this.nr.getStretch();
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
            fxVar.u(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.u(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.TextView, android.view.View
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
        fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.nr(i, i2, i3, i4);
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
        this.nr.u(i);
    }

    public void setBorderRadius(float f) {
        n nVar = this.nr;
        if (nVar != null) {
            nVar.u(f);
        }
    }

    public void setRichText(String str) {
        setText(Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(str, 0) : Html.fromHtml(str));
    }

    public void setRipple(float f) {
        n nVar = this.nr;
        if (nVar != null) {
            nVar.nr(f);
        }
    }

    public void setRubIn(float f) {
        n nVar = this.nr;
        if (nVar != null) {
            nVar.pn(f);
        }
    }

    public void setShine(float f) {
        n nVar = this.nr;
        if (nVar != null) {
            nVar.fx(f);
        }
    }

    public void setStretch(float f) {
        n nVar = this.nr;
        if (nVar != null) {
            nVar.b(f);
        }
    }

    public void u(fx fxVar) {
        this.u = fxVar;
    }
}
