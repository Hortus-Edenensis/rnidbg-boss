package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class CircleRippleView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<Integer> f5106a;
    private int b;
    private float fx;
    private int iz;
    private Paint jk;
    private float l;
    private float mv;
    private List<Integer> n;
    private int nr;
    private float pn;
    private int s;
    private Paint t;
    private int u;
    private boolean x;

    public CircleRippleView(Context context) {
        this(context, null);
    }

    private void fx() {
        Paint paint = new Paint();
        this.jk = paint;
        paint.setAntiAlias(true);
        this.jk.setStrokeWidth(this.s);
        this.n.add(255);
        this.f5106a.add(0);
        Paint paint2 = new Paint();
        this.t = paint2;
        paint2.setAntiAlias(true);
        this.t.setColor(Color.parseColor("#0FFFFFFF"));
        this.t.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    public void nr() {
        this.x = false;
        this.f5106a.clear();
        this.n.clear();
        this.n.add(255);
        this.f5106a.add(0);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.jk.setShader(new LinearGradient(this.l, 0.0f, this.mv, getMeasuredHeight(), -1, 16777215, Shader.TileMode.CLAMP));
        int i = 0;
        while (true) {
            if (i >= this.n.size()) {
                break;
            }
            Integer num = this.n.get(i);
            this.jk.setAlpha(num.intValue());
            Integer num2 = this.f5106a.get(i);
            if (this.fx + num2.intValue() < this.pn) {
                canvas.drawCircle(this.l, this.mv, this.fx + num2.intValue(), this.jk);
            }
            if (num.intValue() > 0 && num2.intValue() < this.pn) {
                this.n.set(i, Integer.valueOf(num.intValue() - this.iz > 0 ? num.intValue() - (this.iz * 3) : 1));
                this.f5106a.set(i, Integer.valueOf(num2.intValue() + this.iz));
            }
            i++;
        }
        List<Integer> list = this.f5106a;
        if (list.get(list.size() - 1).intValue() >= this.pn / this.b) {
            this.n.add(255);
            this.f5106a.add(0);
        }
        if (this.f5106a.size() >= 3) {
            this.f5106a.remove(0);
            this.n.remove(0);
        }
        this.jk.setAlpha(255);
        this.jk.setColor(this.nr);
        canvas.drawCircle(this.l, this.mv, this.fx, this.t);
        if (this.x) {
            invalidate();
        }
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
        float f = i / 2.0f;
        this.l = f;
        this.mv = i2 / 2.0f;
        float f2 = f - (this.s / 2.0f);
        this.pn = f2;
        this.fx = f2 / 4.0f;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            invalidate();
        }
    }

    public void setColor(int i) {
        this.u = i;
    }

    public void setCoreColor(int i) {
        this.nr = i;
    }

    public void setCoreRadius(int i) {
        this.fx = i;
    }

    public void setDiffuseSpeed(int i) {
        this.iz = i;
    }

    public void setDiffuseWidth(int i) {
        this.b = i;
    }

    public void setMaxWidth(int i) {
        this.pn = i;
    }

    public void u() {
        this.x = true;
        invalidate();
    }

    public CircleRippleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CircleRippleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.u = -1;
        this.nr = SupportMenu.CATEGORY_MASK;
        this.fx = 18.0f;
        this.b = 3;
        this.pn = 50.0f;
        this.iz = 2;
        this.x = false;
        this.n = new ArrayList();
        this.f5106a = new ArrayList();
        this.s = 24;
        fx();
    }
}
