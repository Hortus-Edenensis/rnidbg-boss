package com.opos.cmn.module.ui.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c extends f {
    private float c;

    public c(Context context, float f) {
        super(context);
        this.c = f;
    }

    @Override // com.opos.cmn.module.ui.a.f
    public void a(Canvas canvas, int i, int i2) {
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float f = this.c;
        canvas.drawRoundRect(rectF, f, f, this.f8050a);
    }
}
