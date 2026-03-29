package com.opos.exoplayer.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class AspectRatioFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f8442a;
    private int b;

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResizeMode {
    }

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public void a(float f) {
        if (this.f8442a != f) {
            this.f8442a = f;
            requestLayout();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.b == 3 || this.f8442a <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = measuredWidth;
        float f2 = measuredHeight;
        float f3 = (this.f8442a / (f / f2)) - 1.0f;
        if (Math.abs(f3) <= 0.01f) {
            return;
        }
        int i3 = this.b;
        if (i3 == 1 || (i3 != 2 && (i3 == 4 ? f3 <= 0.0f : f3 > 0.0f))) {
            measuredHeight = (int) (f / this.f8442a);
        } else {
            measuredWidth = (int) (f2 * this.f8442a);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
    }

    public void a(int i) {
        if (this.b != i) {
            this.b = i;
            requestLayout();
        }
    }
}
