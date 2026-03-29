package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.component.sdk.annotation.ColorInt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends GradientDrawable {
    private final Paint nr;
    protected Path u;

    public nr() {
        this.u = new Path();
        Paint paint = new Paint(1);
        this.nr = paint;
        paint.setColor(-1);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Path path = this.u;
        if (path == null || path.isEmpty()) {
            u(canvas);
            return;
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.nr, 31);
        u(canvas);
        this.nr.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPath(this.u, this.nr);
        this.nr.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    public void u(Canvas canvas) {
        super.draw(canvas);
    }

    public void update(int i, int i2, int i3, int i4) {
        this.u.addRect(i, i2, i3, i4, Path.Direction.CW);
        invalidateSelf();
    }

    public nr(GradientDrawable.Orientation orientation, @ColorInt int[] iArr) {
        super(orientation, iArr);
        this.u = new Path();
        Paint paint = new Paint(1);
        this.nr = paint;
        paint.setColor(-1);
    }
}
