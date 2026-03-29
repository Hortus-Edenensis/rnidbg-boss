package com.opos.mobad.template.cmn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class z extends com.opos.mobad.template.cmn.baseview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9411a;
    private int b;
    private float c;

    public z(Context context) {
        this(context, null);
    }

    public void a(float f) {
        this.c = f;
        invalidate();
    }

    public void b(int i) {
        this.b = i;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int iSave = canvas.save();
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        Path path = new Path();
        float f = this.c;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        canvas.clipPath(path);
        super.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int i3 = this.f9411a;
        if (i3 != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(size, i3), Integer.MIN_VALUE);
        }
        int i4 = this.b;
        if (i4 != 0) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(size2, i4), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }

    public z(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(int i) {
        this.f9411a = i;
    }

    public z(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9411a = 0;
        this.b = 0;
        this.c = 0.0f;
        setWillNotDraw(false);
    }
}
