package com.zenmen.palmchat.chat;

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
import androidx.appcompat.widget.AppCompatImageView;
import defpackage.me1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MediaPickSquareImageView extends AppCompatImageView {
    private BitmapShader mBitmapShader;
    private int mBorderRadius;
    private Matrix mMatrix;
    private Paint mPaint;

    public MediaPickSquareImageView(Context context) {
        this(context, null);
    }

    private Bitmap drawableToBitamp(Drawable drawable) {
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
        if (getDrawable() == null) {
            return;
        }
        Bitmap bitmapDrawableToBitamp = drawableToBitamp(getDrawable());
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.mBitmapShader = new BitmapShader(bitmapDrawableToBitamp, tileMode, tileMode);
        float fMax = (bitmapDrawableToBitamp.getWidth() == getWidth() && bitmapDrawableToBitamp.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / bitmapDrawableToBitamp.getWidth(), (getHeight() * 1.0f) / bitmapDrawableToBitamp.getHeight());
        this.mMatrix.setScale(fMax, fMax);
        this.mBitmapShader.setLocalMatrix(this.mMatrix);
        this.mPaint.setShader(this.mBitmapShader);
        this.mBorderRadius = me1.b(getContext(), 8);
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        int i = this.mBorderRadius;
        canvas.drawRoundRect(rectF, i, i, this.mPaint);
    }

    public MediaPickSquareImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaPickSquareImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
    }
}
