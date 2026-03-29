package com.opos.mobad.template.cmn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class n extends y {
    private float c;

    public n(Context context, float f) {
        super(context);
        this.c = f;
    }

    @Override // com.opos.mobad.template.cmn.y
    public void a(Canvas canvas, int i, int i2) {
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float f = this.c;
        canvas.drawRoundRect(rectF, f, f, ((y) this).f9410a);
    }
}
