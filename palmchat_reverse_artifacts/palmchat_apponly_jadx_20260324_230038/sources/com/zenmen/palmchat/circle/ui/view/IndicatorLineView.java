package com.zenmen.palmchat.circle.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.R;
import defpackage.fm2;
import defpackage.qs2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class IndicatorLineView extends View implements fm2 {
    protected int height;
    private qs2 indicator;
    protected int radius_indicator;

    public IndicatorLineView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.indicator = new qs2(this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorLineView);
        this.indicator.m(typedArrayObtainStyledAttributes.getDimensionPixelSize(4, dpAdapt(context, 20.0f)));
        this.indicator.l(typedArrayObtainStyledAttributes.getDimensionPixelSize(3, dpAdapt(context, 60.0f)));
        this.indicator.i(typedArrayObtainStyledAttributes.getDimensionPixelSize(1, dpAdapt(context, 3.0f)));
        this.indicator.h(typedArrayObtainStyledAttributes.getColor(0, -1813184));
        setRadius_indicator(typedArrayObtainStyledAttributes.getDimensionPixelSize(2, dpAdapt(context, 2.0f)));
        this.indicator.k(0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public int dpAdapt(Context context, float f) {
        return dpAdapt(context, f, 360.0f);
    }

    @Override // defpackage.fm2
    public qs2 getIndicator() {
        return this.indicator;
    }

    public int getRadius_indicator() {
        return this.radius_indicator;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            float fC = this.indicator.c();
            float fA = this.height - this.indicator.a();
            float fC2 = this.indicator.c() + this.indicator.d();
            float f = this.height;
            int i = this.radius_indicator;
            canvas.drawRoundRect(fC, fA, fC2, f, i, i, this.indicator.b());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.height = getHeight();
    }

    public fm2 setRadius_indicator(int i) {
        this.radius_indicator = i;
        return this;
    }

    public int dpAdapt(Context context, float f, float f2) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        float f3 = displayMetrics.density;
        float f4 = i / f3;
        float f5 = i2 / f3;
        if (f5 <= f4) {
            f4 = f5;
        }
        return (int) ((((f * f4) / f2) * f3) + 0.5f);
    }

    @Override // defpackage.fm2
    public <T extends View> T getView() {
        return this;
    }
}
