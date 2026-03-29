package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;
import com.bytedance.sdk.component.utils.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DynamicLogoUnion extends DynamicBaseWidgetImp {
    public DynamicLogoUnion(Context context, DynamicRootView dynamicRootView, n nVar) {
        super(context, dynamicRootView, nVar);
        ImageView imageView = new ImageView(context);
        this.k = imageView;
        imageView.setTag(Integer.valueOf(getClickArea()));
        if (com.bytedance.sdk.component.adexpress.b.u()) {
            this.n = Math.max(dynamicRootView.getLogoUnionHeight(), this.n);
        }
        addView(this.k, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.b
    public boolean n() {
        super.n();
        if (com.bytedance.sdk.component.adexpress.b.u()) {
            ((ImageView) this.k).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        ((ImageView) this.k).setImageResource(q.pn(getContext(), "tt_ad_logo"));
        ((ImageView) this.k).setColorFilter(this.l.x(), PorterDuff.Mode.SRC_IN);
        return true;
    }
}
