package com.opos.mobad.template.i;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class h extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f10125a;
    private LinearGradient b;
    private int[] c;
    private float[] d;

    public h(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f10125a = paint;
        paint.setAntiAlias(true);
    }

    public h a(Paint.Style style) {
        this.f10125a.setStyle(style);
        return this;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.c == null || this.d == null) {
            return;
        }
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredHeight(), this.c, this.d, Shader.TileMode.CLAMP);
        this.b = linearGradient;
        this.f10125a.setShader(linearGradient);
        canvas.drawCircle(0.0f, com.opos.cmn.an.h.f.a.a(getContext(), 180.0f), com.opos.cmn.an.h.f.a.a(getContext(), 30.0f) + r0, this.f10125a);
        LinearGradient linearGradient2 = new LinearGradient(getMeasuredWidth(), getMeasuredHeight(), 0.0f, 0.0f, this.c, this.d, Shader.TileMode.CLAMP);
        this.b = linearGradient2;
        this.f10125a.setShader(linearGradient2);
        canvas.drawCircle(getMeasuredWidth(), getMeasuredHeight() - r0, r0 + com.opos.cmn.an.h.f.a.a(getContext(), 30.0f), this.f10125a);
    }

    public void a(int[] iArr, float[] fArr) {
        this.c = iArr;
        this.d = fArr;
    }
}
