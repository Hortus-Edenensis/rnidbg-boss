package com.zenmen.palmchat.ui.widget.photo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.zenmen.palmchat.friendcircle.R$styleable;
import defpackage.me1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class RatioImageView extends AppCompatImageView {
    private BitmapShader mBitmapShader;
    private int mBorderRadius;
    private Matrix mMatrix;
    private Paint mPaint;
    private float mRatio;

    public RatioImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRatio = 0.0f;
        this.mMatrix = new Matrix();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
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
        this.mBorderRadius = me1.b(getContext(), 4);
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        int i = this.mBorderRadius;
        canvas.drawRoundRect(rectF, i, i, this.mPaint);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        float f = this.mRatio;
        if (f != 0.0f) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) (size / f), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable drawable;
        int action = motionEvent.getAction();
        if (action == 0) {
            Drawable drawable2 = getDrawable();
            if (drawable2 != null) {
                drawable2.mutate().setColorFilter(-7829368, PorterDuff.Mode.MULTIPLY);
            }
        } else if ((action == 1 || action == 3) && (drawable = getDrawable()) != null) {
            drawable.mutate().clearColorFilter();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setRatio(float f) {
        this.mRatio = f;
    }

    public RatioImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRatio = 0.0f;
        this.mMatrix = new Matrix();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RatioImageView);
        this.mRatio = typedArrayObtainStyledAttributes.getFloat(R$styleable.RatioImageView_ratio, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    public RatioImageView(Context context) {
        super(context);
        this.mRatio = 0.0f;
        this.mMatrix = new Matrix();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
    }
}
