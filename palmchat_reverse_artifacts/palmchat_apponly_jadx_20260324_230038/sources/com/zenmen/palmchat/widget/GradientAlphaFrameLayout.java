package com.zenmen.palmchat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.framework.R$styleable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class GradientAlphaFrameLayout extends FrameLayout {
    private Paint mPaint;
    private Shader mShader;
    private int topHeight;

    public GradientAlphaFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        try {
            int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
            super.dispatchDraw(canvas);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.mPaint);
            canvas.restoreToCount(iSaveLayer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = this.topHeight;
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, i2, new int[]{0, -16777216, -16777216}, new float[]{0.0f, (i5 <= 0 || i2 == 0) ? 1.0f : (i5 * 1.0f) / i2, 1.0f}, Shader.TileMode.CLAMP);
        this.mShader = linearGradient;
        this.mPaint.setShader(linearGradient);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public GradientAlphaFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientAlphaFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.topHeight = 80;
        setWillNotDraw(false);
        this.mPaint = new Paint();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.GradientAlphaFrameLayout);
            this.topHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.GradientAlphaFrameLayout_gradientTopHeight, (int) TypedValue.applyDimension(1, 20.0f, getResources().getDisplayMetrics()));
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
