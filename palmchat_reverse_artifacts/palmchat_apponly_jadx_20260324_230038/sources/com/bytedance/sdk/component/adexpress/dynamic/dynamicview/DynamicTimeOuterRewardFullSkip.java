package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;
import com.bytedance.sdk.component.utils.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DynamicTimeOuterRewardFullSkip extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.fx {
    private boolean u;

    public DynamicTimeOuterRewardFullSkip(Context context, DynamicRootView dynamicRootView, n nVar) {
        super(context, dynamicRootView, nVar);
        if (dynamicRootView.getRenderRequest() != null) {
            this.u = dynamicRootView.getRenderRequest().my();
        }
        this.x = this.n;
        ImageView imageView = new ImageView(context);
        this.k = imageView;
        imageView.setTag(Integer.valueOf(getClickArea()));
        addView(this.k, getWidgetLayoutParams());
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().d()) {
            return;
        }
        this.k.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.b
    public boolean n() {
        Drawable drawableFx;
        super.n();
        ((ImageView) this.k).setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable drawableU = com.bytedance.sdk.component.adexpress.b.b.u(getContext(), this.l);
        if (drawableU != null) {
            ((ImageView) this.k).setBackground(drawableU);
        }
        if (this.u) {
            drawableFx = q.fx(getContext(), "tt_close_btn");
        } else {
            drawableFx = q.fx(getContext(), "tt_skip_btn");
            if (drawableFx != null) {
                drawableFx.setAutoMirrored(true);
            }
        }
        if (drawableFx != null) {
            ((ImageView) this.k).setImageDrawable(drawableFx);
        }
        setVisibility(8);
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.fx
    public void u(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2 = 0;
        if (!z && !z2) {
            i2 = 8;
        }
        setVisibility(i2);
    }
}
