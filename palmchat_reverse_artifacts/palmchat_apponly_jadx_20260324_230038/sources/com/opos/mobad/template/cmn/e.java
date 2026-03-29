package com.opos.mobad.template.cmn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class e extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f9384a;
    private Path b;
    private RectF c;
    private float d;
    private float e;
    private float f;
    private float g;
    private int h;

    public e(Context context, int i) {
        super(context);
        this.h = i;
        a();
    }

    private void a() {
        Paint paint = new Paint(1);
        this.f9384a = paint;
        paint.setColor(this.h);
        this.f9384a.setStyle(Paint.Style.FILL);
        this.f9384a.setAntiAlias(true);
        this.b = new Path();
        this.c = new RectF();
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth();
        float height = getHeight();
        this.c.set(0.0f, 0.0f, width, height);
        this.b.reset();
        this.b.moveTo(this.d, 0.0f);
        this.b.lineTo(width - this.e, 0.0f);
        this.b.quadTo(width, 0.0f, width, this.e);
        this.b.lineTo(width, height - this.f);
        this.b.quadTo(width, height, width - this.f, height);
        this.b.lineTo(this.g, height);
        this.b.quadTo(0.0f, height, 0.0f, height - this.g);
        this.b.lineTo(0.0f, this.d);
        this.b.quadTo(0.0f, 0.0f, this.d, 0.0f);
        this.b.close();
        canvas.drawPath(this.b, this.f9384a);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.d = f;
        this.e = f2;
        this.f = f3;
        this.g = f4;
        invalidate();
    }
}
