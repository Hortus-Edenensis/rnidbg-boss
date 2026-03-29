package com.opos.mobad.template.cmn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.widget.ImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class v extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f9407a;

    public v(Context context, float f) {
        super(context);
        this.f9407a = f;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        float width = getWidth();
        float height = getHeight();
        Path path = new Path();
        path.moveTo(this.f9407a, 0.0f);
        path.lineTo(width - this.f9407a, 0.0f);
        path.quadTo(width, 0.0f, width, this.f9407a);
        path.lineTo(width, height - this.f9407a);
        path.quadTo(width, height, width - this.f9407a, height);
        path.lineTo(this.f9407a, height);
        path.quadTo(0.0f, height, 0.0f, height - this.f9407a);
        path.lineTo(0.0f, this.f9407a);
        path.quadTo(0.0f, 0.0f, this.f9407a, 0.0f);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}
