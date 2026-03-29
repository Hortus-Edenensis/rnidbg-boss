package com.zenmen.square.show;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.zenmen.square.R$drawable;
import defpackage.me1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class DYPageIndicator extends LinearLayout {
    private int currentSize;

    public DYPageIndicator(Context context) {
        super(context);
        this.currentSize = 0;
    }

    public void updateIndex(int i, int i2) {
        if (i > 1) {
            if (this.currentSize != i) {
                this.currentSize = i;
                removeAllViews();
                setOrientation(0);
                for (int i3 = 0; i3 < i; i3++) {
                    ImageView imageView = new ImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
                    layoutParams.weight = 1.0f;
                    layoutParams.setMargins(me1.b(getContext(), 3), 0, me1.b(getContext(), 3), 0);
                    imageView.setImageResource(R$drawable.dy_page_selector);
                    imageView.setLayoutParams(layoutParams);
                    addView(imageView);
                }
            }
            for (int i4 = 0; i4 < i; i4++) {
                View childAt = getChildAt(i4);
                if (i4 <= i2) {
                    childAt.setSelected(true);
                } else {
                    childAt.setSelected(false);
                }
            }
        }
    }

    public DYPageIndicator(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentSize = 0;
    }

    public DYPageIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentSize = 0;
    }

    public DYPageIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.currentSize = 0;
    }
}
