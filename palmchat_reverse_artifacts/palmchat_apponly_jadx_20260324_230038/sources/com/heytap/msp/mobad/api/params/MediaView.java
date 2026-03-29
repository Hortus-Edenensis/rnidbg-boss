package com.heytap.msp.mobad.api.params;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class MediaView extends FrameLayout {
    private static final int DEFAULT_HEIGHT = 1;
    private static final int DEFAULT_WIDTH = 1;
    private int heightRate;
    private int widthRate;

    public MediaView(Context context) {
        super(context);
        this.widthRate = 1;
        this.heightRate = 1;
        setBackgroundColor(-16777216);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = this.heightRate;
        int i4 = this.widthRate;
        int i5 = (size * i3) / i4;
        int i6 = (i4 * size2) / i3;
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (mode == 1073741824) {
                i2 = mode2 == Integer.MIN_VALUE ? View.MeasureSpec.makeMeasureSpec(Math.min(i5, size2), 1073741824) : View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
            } else {
                if (mode2 == 1073741824) {
                    if (mode == Integer.MIN_VALUE) {
                        i = View.MeasureSpec.makeMeasureSpec(Math.min(i6, size), 1073741824);
                    }
                } else if (mode != Integer.MIN_VALUE ? mode2 != Integer.MIN_VALUE : mode2 != Integer.MIN_VALUE || size2 / 1 > size / 1) {
                    i = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                } else {
                    i2 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
                }
                i = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
            }
        }
        super.onMeasure(i, i2);
    }

    public void setWidthHeightRate(int i, int i2) {
        if (i * i2 > 0) {
            this.widthRate = i;
            this.heightRate = i2;
        }
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.widthRate = 1;
        this.heightRate = 1;
        setBackgroundColor(-16777216);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.widthRate = 1;
        this.heightRate = 1;
        setBackgroundColor(-16777216);
    }

    @TargetApi(21)
    public MediaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.widthRate = 1;
        this.heightRate = 1;
        setBackgroundColor(-16777216);
    }
}
