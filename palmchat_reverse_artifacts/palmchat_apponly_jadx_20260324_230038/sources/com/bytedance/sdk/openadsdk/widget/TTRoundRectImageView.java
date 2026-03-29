package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class TTRoundRectImageView extends ImageView {
    private Matrix b;
    private int fx;
    private int nr;
    private Paint u;

    public TTRoundRectImageView(Context context) {
        this(context, null);
    }

    private Bitmap u(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onDraw(canvas);
            return;
        }
        Bitmap bitmapU = u(drawable);
        if (bitmapU == null) {
            super.onDraw(canvas);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        BitmapShader bitmapShader = new BitmapShader(bitmapU, tileMode, tileMode);
        float fMax = (bitmapU.getWidth() == getWidth() && bitmapU.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / bitmapU.getWidth(), (getHeight() * 1.0f) / bitmapU.getHeight());
        this.b.setScale(fMax, fMax);
        bitmapShader.setLocalMatrix(this.b);
        this.u.setShader(bitmapShader);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.nr, this.fx, this.u);
    }

    public void setXRound(int i) {
        this.nr = i;
        postInvalidate();
    }

    public void setYRound(int i) {
        this.fx = i;
        postInvalidate();
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nr = 25;
        this.fx = 25;
        Paint paint = new Paint();
        this.u = paint;
        paint.setAntiAlias(true);
        this.u.setFilterBitmap(true);
        this.b = new Matrix();
    }

    public TTRoundRectImageView(Context context, int i, int i2) {
        this(context);
        this.nr = i;
        this.fx = i2;
    }
}
