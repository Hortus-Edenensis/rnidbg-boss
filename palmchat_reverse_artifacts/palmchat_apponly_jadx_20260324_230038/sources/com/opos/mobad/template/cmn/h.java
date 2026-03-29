package com.opos.mobad.template.cmn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class h extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f9390a;
    private LinearGradient b;
    private int[] c;
    private float d;
    private float e;
    private float f;

    public h(Context context, int[] iArr) {
        super(context);
        this.d = 10.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.c = iArr;
        Paint paint = new Paint();
        this.f9390a = paint;
        paint.setAntiAlias(true);
    }

    public h a(float f) {
        this.d = f;
        this.f9390a.setStrokeWidth(f);
        return this;
    }

    public h b(float f) {
        this.e = f;
        return this;
    }

    public h c(float f) {
        this.f = f;
        return this;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.c == null) {
            return;
        }
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredHeight(), this.c, (float[]) null, Shader.TileMode.CLAMP);
        this.b = linearGradient;
        this.f9390a.setShader(linearGradient);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        float f = width;
        float f2 = this.e;
        float f3 = height;
        float f4 = this.f;
        canvas.drawOval(new RectF(f - f2, f3 - f4, f + f2, f3 + f4), this.f9390a);
    }

    public h a(Paint.Style style) {
        this.f9390a.setStyle(style);
        return this;
    }
}
