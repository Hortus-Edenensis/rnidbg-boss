package com.zenmen.palmchat.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SectionItemWrapperLinearLayout extends LinearLayout {
    public SectionItemWrapperLinearLayout(Context context) {
        super(context);
    }

    public void updateSeperator() {
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= getChildCount()) {
                break;
            }
            View childAt = getChildAt(i);
            if (childAt instanceof ViewGroup) {
                if (childAt.getVisibility() == 0) {
                    i2 = i;
                }
            }
            i++;
        }
        boolean z = false;
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt2 = getChildAt(i4);
            boolean z2 = childAt2 instanceof ViewGroup;
            boolean z3 = childAt2.getVisibility() == 0;
            if (z2) {
                if (z3) {
                    i3 = i4 + 1;
                    z = true;
                }
            } else if ((i4 == i3 && i4 < i2) || i4 == 0 || i4 == getChildCount() - 1) {
                childAt2.setVisibility(0);
            } else {
                childAt2.setVisibility(8);
            }
        }
        if (z) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    public SectionItemWrapperLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SectionItemWrapperLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public SectionItemWrapperLinearLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
