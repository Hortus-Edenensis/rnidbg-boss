package com.zenmen.square.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.c;
import defpackage.a46;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FindHAlphaFrameLayout extends FrameLayout {
    private Paint mPaint;
    private Shader mShader;
    private int topWidth1;
    private int topWidth2;

    public FindHAlphaFrameLayout(@NonNull Context context) {
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
        float f;
        float f2;
        super.onSizeChanged(i, i2, i3, i4);
        if (i != 0) {
            float f3 = i;
            f = ((i - this.topWidth1) * 1.0f) / f3;
            f2 = ((i - this.topWidth2) * 1.0f) / f3;
        } else {
            f = 1.0f;
            f2 = 1.0f;
        }
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, i, 0.0f, new int[]{-16777216, -16777216, 0, -16777216}, new float[]{0.0f, f, f2, 1.0f}, Shader.TileMode.CLAMP);
        this.mShader = linearGradient;
        this.mPaint.setShader(linearGradient);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public FindHAlphaFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FindHAlphaFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.topWidth1 = a46.b(c.b(), 40.0f);
        this.topWidth2 = a46.b(c.b(), 0.0f);
        setWillNotDraw(false);
        this.mPaint = new Paint();
    }
}
