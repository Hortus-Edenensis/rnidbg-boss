package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class TTLoadingProgressBar extends LinearLayout {
    private View fx;
    private ImageView nr;
    private View u;

    private int u(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public View getProgressBar() {
        return this.u;
    }

    public ImageView getProgressIcon() {
        return this.nr;
    }

    public void setProgress(int i) {
        if (this.nr.getVisibility() == 0 && i > 3) {
            ((LinearLayout.LayoutParams) this.nr.getLayoutParams()).leftMargin = u(this.u.getContext(), -7.0f);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.u.getLayoutParams();
        float f = i / 100.0f;
        layoutParams.weight = f;
        this.u.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fx.getLayoutParams();
        layoutParams2.weight = 1.0f - f;
        this.fx.setLayoutParams(layoutParams2);
        requestLayout();
    }
}
