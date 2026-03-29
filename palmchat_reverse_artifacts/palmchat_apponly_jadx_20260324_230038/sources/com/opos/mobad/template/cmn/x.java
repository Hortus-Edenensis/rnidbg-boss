package com.opos.mobad.template.cmn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class x extends com.opos.mobad.template.cmn.baseview.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f9409a;
    private boolean b;
    private float c;
    private int d;
    private Paint e;

    public x(Context context) {
        this(context, null);
    }

    public void a(float f) {
        this.f9409a = f;
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int iSave = canvas.save();
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        Path path = new Path();
        float f = this.f9409a;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        canvas.clipPath(path);
        super.draw(canvas);
        if (this.b) {
            this.e.setColor(this.d);
            this.e.setStrokeWidth(this.c);
            canvas.drawPath(path, this.e);
        }
        canvas.restoreToCount(iSave);
    }

    public x(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(float f, int i) {
        this.c = f;
        this.d = i;
        this.b = true;
    }

    public x(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9409a = 0.0f;
        this.b = false;
        this.c = 0.0f;
        this.d = 0;
        setWillNotDraw(false);
        Paint paint = new Paint();
        this.e = paint;
        paint.setStyle(Paint.Style.STROKE);
    }
}
