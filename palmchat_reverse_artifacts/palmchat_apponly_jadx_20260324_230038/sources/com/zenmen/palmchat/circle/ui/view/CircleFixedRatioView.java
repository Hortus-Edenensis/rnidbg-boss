package com.zenmen.palmchat.circle.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleFixedRatioView extends View {
    private int mMaxHeight;
    private int mProportionHeight;
    private int mProportionWidth;

    public CircleFixedRatioView(Context context) {
        this(context, null);
    }

    private void initCustomAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleFixedRatioView);
        this.mProportionWidth = typedArrayObtainStyledAttributes.getInt(2, 0);
        this.mProportionHeight = typedArrayObtainStyledAttributes.getInt(1, 0);
        this.mMaxHeight = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int i4 = this.mProportionWidth;
        if (i4 == 0 || (i3 = this.mProportionHeight) == 0) {
            return;
        }
        int i5 = (int) (((((double) size) * 1.0d) / ((double) i4)) * ((double) i3));
        int i6 = this.mMaxHeight;
        if (i6 != 0 && i5 > i6) {
            i5 = i6;
        }
        setMeasuredDimension(size, i5);
    }

    public void setMaxHeight(int i) {
        this.mMaxHeight = i;
    }

    public void setProportionHeight(int i) {
        this.mProportionHeight = i;
    }

    public void setProportionWidth(int i) {
        this.mProportionWidth = i;
    }

    public CircleFixedRatioView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleFixedRatioView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initCustomAttrs(context, attributeSet);
    }
}
