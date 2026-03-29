package com.zenmen.palmchat.ui.widget.photo.newui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.zenmen.palmchat.friendcircle.R$styleable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class RatioRelativeLayout extends RelativeLayout {
    private float mMaxRatio;
    private float mRatio;

    public RatioRelativeLayout(Context context) {
        this(context, null);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getName() + " layout_width must be \"match_parent\"");
        }
        int size = View.MeasureSpec.getSize(i);
        float f = this.mRatio;
        if (f <= 1.0f) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(Math.round(size * f), 1073741824));
            return;
        }
        int iRound = Math.round(size / f);
        setMeasuredDimension(iRound, size);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(iRound, 1073741824), View.MeasureSpec.makeMeasureSpec(size, 1073741824));
    }

    public void setContentSize(int i, int i2) {
        if (i2 <= i || i == 0 || i2 == 0) {
            this.mRatio = Math.max(Math.min(i != 0 ? i2 / i : 1.0f, 1.16667f), 0.3f);
        } else {
            this.mRatio = Math.min(i2 / i, 1.78f);
        }
    }

    public RatioRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RatioRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxRatio = 2.0f;
        this.mRatio = 1.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MultiImageLayout);
        this.mMaxRatio = typedArrayObtainStyledAttributes.getFloat(R$styleable.MultiImageLayout_max_ratio, this.mMaxRatio);
        typedArrayObtainStyledAttributes.recycle();
    }
}
