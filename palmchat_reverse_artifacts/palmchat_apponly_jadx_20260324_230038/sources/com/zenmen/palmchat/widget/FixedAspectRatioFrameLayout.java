package com.zenmen.palmchat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FixedAspectRatioFrameLayout extends FrameLayout {
    private int mAspectRatioHeight;
    private int mAspectRatioWidth;

    public FixedAspectRatioFrameLayout(Context context) {
        super(context);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FixedAspectRatioFrameLayout);
        this.mAspectRatioWidth = typedArrayObtainStyledAttributes.getInt(1, 0);
        this.mAspectRatioHeight = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mAspectRatioWidth <= 0 || this.mAspectRatioHeight <= 0) {
            super.onMeasure(i, i2);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = this.mAspectRatioHeight;
        int i4 = this.mAspectRatioWidth;
        int i5 = (size * i3) / i4;
        if (size2 <= 0 || i5 <= size2) {
            size2 = i5;
        } else {
            size = (i4 * size2) / i3;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    public void setAspectRatio(int i, int i2) {
        this.mAspectRatioWidth = i;
        this.mAspectRatioHeight = i2;
    }

    public FixedAspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public FixedAspectRatioFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}
