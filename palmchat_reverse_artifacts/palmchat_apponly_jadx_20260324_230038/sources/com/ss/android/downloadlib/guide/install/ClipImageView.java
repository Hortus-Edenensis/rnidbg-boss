package com.ss.android.downloadlib.guide.install;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ClipImageView extends ImageView {
    private Paint b;
    private RectF fx;
    private Path nr;
    private float[] pn;
    private boolean u;

    public ClipImageView(Context context) {
        super(context);
        this.u = true;
        u(context);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.u) {
            this.nr.reset();
            this.fx.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.pn;
            if (fArr != null) {
                this.nr.addRoundRect(this.fx, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.nr);
            Paint paint = this.b;
            if (paint != null) {
                canvas.drawPath(this.nr, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.b.setColor(i);
    }

    public void setClip(boolean z) {
        this.u = z;
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.pn = fArr;
    }

    public void setRoundRadius(int i) {
        if (i > 0) {
            float f = i;
            setRadius(new float[]{f, f, f, f, f, f, f, f});
        }
    }

    public void u(Context context) {
        this.nr = new Path();
        this.fx = new RectF();
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.u = true;
        u(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.u = true;
        u(context);
    }
}
