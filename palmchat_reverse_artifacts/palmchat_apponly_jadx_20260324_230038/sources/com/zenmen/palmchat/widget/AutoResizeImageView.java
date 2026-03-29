package com.zenmen.palmchat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class AutoResizeImageView extends ImageView {
    public static final int AiLOCK_NORMAL = 0;
    public static final int AiLOCK_SHOW = 1;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    private int aiLock;
    private Paint mPaint;
    private int mSide;
    int maxHeight;
    int maxWidth;
    private float whratio;

    public AutoResizeImageView(Context context) {
        super(context);
        this.maxWidth = 0;
        this.maxHeight = 0;
        this.mSide = 1;
        this.aiLock = 0;
        this.whratio = -1.0f;
        init(null);
    }

    private void init(AttributeSet attributeSet) {
        int dimensionPixelSize = 0;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ChatItemSide);
            this.mSide = typedArrayObtainStyledAttributes.getInt(3, 0);
            this.aiLock = typedArrayObtainStyledAttributes.getInt(0, 0);
            dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
        if (dimensionPixelSize == 0) {
            this.maxWidth = (int) getContext().getResources().getDimension(R.dimen.chat_image_size);
            this.maxHeight = (int) getContext().getResources().getDimension(R.dimen.chat_image_size);
        } else {
            this.maxWidth = dimensionPixelSize;
            this.maxHeight = dimensionPixelSize;
        }
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setFilterBitmap(true);
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return;
        }
        try {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            int iSave = canvas.save();
            float f = getResources().getDisplayMetrics().density * 8.0f;
            Path path = new Path();
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
            canvas.clipPath(path);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (getHeight() == 0 || height == 0) {
                i = 0;
                i2 = 0;
                i3 = 0;
            } else {
                float width2 = getWidth() / getHeight();
                if (width2 > width / height) {
                    int width3 = (int) (bitmap.getWidth() / width2);
                    int height2 = (bitmap.getHeight() - width3) / 2;
                    int i4 = height2 + width3;
                    i3 = height2;
                    i = width3;
                    height = i4;
                    i2 = 0;
                } else {
                    int height3 = (int) (bitmap.getHeight() * width2);
                    int width4 = (bitmap.getWidth() - height3) / 2;
                    int i5 = width4 + height3;
                    i3 = 0;
                    i = height3;
                    width = i5;
                    i2 = width4;
                }
            }
            Log.i("image scale", "left:" + i2 + " top:" + i3 + " right:" + width + " bottom:" + height + " width:" + bitmap.getWidth() + " height:" + bitmap.getHeight() + " scaled:" + i);
            canvas.drawBitmap(bitmap, new Rect(i2, i3, width, height), rectF, this.mPaint);
            if (this.aiLock == 1) {
                Paint paint = new Paint();
                paint.setColor(Color.argb(128, 0, 0, 0));
                paint.setStyle(Paint.Style.FILL);
                paint.setAntiAlias(true);
                canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), paint);
            }
            canvas.restoreToCount(iSave);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        float f = this.whratio;
        if (f > 0.0f) {
            if (f > 1.0f) {
                int i3 = this.maxWidth;
                setMeasuredDimension(i3, (int) (i3 / f));
                return;
            } else {
                int i4 = this.maxHeight;
                setMeasuredDimension((int) (i4 * f), i4);
                return;
            }
        }
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return;
        }
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        float f2 = width / height;
        if (f2 > 1.0f) {
            int i5 = this.maxWidth;
            setMeasuredDimension(i5, (int) (i5 / f2));
        } else {
            int i6 = this.maxHeight;
            setMeasuredDimension((int) (i6 * f2), i6);
        }
    }

    public void setLeftOrRight(int i) {
        this.mSide = i;
    }

    public void setRatio(float f) {
        this.whratio = f;
        requestLayout();
    }

    public AutoResizeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.maxWidth = 0;
        this.maxHeight = 0;
        this.mSide = 1;
        this.aiLock = 0;
        this.whratio = -1.0f;
        init(attributeSet);
    }

    public AutoResizeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.maxWidth = 0;
        this.maxHeight = 0;
        this.mSide = 1;
        this.aiLock = 0;
        this.whratio = -1.0f;
        init(attributeSet);
    }
}
