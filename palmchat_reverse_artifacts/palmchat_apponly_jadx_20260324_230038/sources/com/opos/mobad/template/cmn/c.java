package com.opos.mobad.template.cmn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f9375a;
    private int[] b;
    private LinearGradient c;

    public c(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, height, this.b, (float[]) null, Shader.TileMode.CLAMP);
        this.c = linearGradient;
        this.f9375a.setShader(linearGradient);
        this.f9375a.setStyle(Paint.Style.FILL);
        float f = width;
        canvas.drawArc(new RectF(0.0f, 0.0f, f, f), 180.0f, 180.0f, false, this.f9375a);
        canvas.drawRect(new Rect(0, width / 2, width, height), this.f9375a);
        super.onDraw(canvas);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new int[]{1728053247, 16777215};
        Paint paint = new Paint();
        this.f9375a = paint;
        paint.setAntiAlias(true);
    }
}
