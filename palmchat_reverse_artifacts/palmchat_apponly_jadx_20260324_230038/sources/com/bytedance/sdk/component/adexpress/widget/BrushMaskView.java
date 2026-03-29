package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.bytedance.component.sdk.annotation.RequiresApi;
import com.bytedance.sdk.component.utils.k;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class BrushMaskView extends View {
    private static final String u = "BrushMaskView";
    private Canvas b;
    private Bitmap fx;
    private BitmapDrawable iz;
    private Paint n;
    private Paint nr;
    private Paint pn;
    private Paint x;

    private void u(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.fx = bitmapCreateBitmap;
            Canvas canvas = this.b;
            if (canvas == null) {
                this.b = new Canvas(this.fx);
            } else {
                canvas.setBitmap(bitmapCreateBitmap);
            }
            this.b.drawRoundRect(new RectF(0.0f, 0.0f, i, i2), 120.0f, 120.0f, this.nr);
            if (this.iz != null) {
                this.iz.setBounds(new Rect(0, 0, i, i2));
                this.iz.draw(this.b);
            }
        } catch (Exception e) {
            k.nr(u, e.getMessage());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.fx;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.pn);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(u(i), u(i2));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        u(i, i2);
    }

    public void setEraserSize(float f) {
        this.x.setStrokeWidth(f);
        this.n.setStrokeWidth(f);
    }

    public void setMaskColor(int i) {
        this.nr.setColor(i);
    }

    @RequiresApi(api = 21)
    public void setWatermark(int i) {
        if (i == -1) {
            this.iz = null;
        } else {
            this.iz = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), i));
        }
    }

    private int u(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(0, size);
        }
        return 0;
    }
}
