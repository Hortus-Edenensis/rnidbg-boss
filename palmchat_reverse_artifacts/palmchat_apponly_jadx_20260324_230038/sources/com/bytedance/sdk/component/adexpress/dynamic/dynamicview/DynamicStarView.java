package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;
import com.bytedance.sdk.component.adexpress.widget.TTRatingBar2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DynamicStarView extends DynamicBaseWidgetImp {
    private int u;

    public DynamicStarView(Context context, DynamicRootView dynamicRootView, n nVar) {
        super(context, dynamicRootView, nVar);
        this.u = 0;
        TTRatingBar2 tTRatingBar2 = new TTRatingBar2(context, null);
        this.k = tTRatingBar2;
        tTRatingBar2.setTag(Integer.valueOf(getClickArea()));
        addView(this.k, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        int iU = (int) ((com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.l.pn()) * 5.0f) + com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.l.fx() + com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.l.b())));
        if (this.x > iU && 4 == this.l.n()) {
            this.u = (this.x - iU) / 2;
        }
        this.x = iU;
        return new FrameLayout.LayoutParams(this.x, this.n);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.b
    public boolean n() {
        DynamicRootView dynamicRootView;
        super.n();
        double dMv = this.l.mv();
        if (com.bytedance.sdk.component.adexpress.b.u() && (dMv < 0.0d || dMv > 5.0d || ((dynamicRootView = this.s) != null && dynamicRootView.getRenderRequest() != null && this.s.getRenderRequest().mv() != 4))) {
            this.k.setVisibility(8);
            return true;
        }
        double d = (dMv < 0.0d || dMv > 5.0d) ? 5.0d : dMv;
        this.k.setVisibility(0);
        ((TTRatingBar2) this.k).u(d, this.l.x(), (int) this.l.pn(), ((int) com.bytedance.sdk.component.adexpress.b.n.u(this.t, this.l.nr())) + ((int) com.bytedance.sdk.component.adexpress.b.n.u(this.t, this.l.u())) + ((int) com.bytedance.sdk.component.adexpress.b.n.u(this.t, this.l.pn())));
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void pn() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.x, this.n);
        layoutParams.topMargin = this.jk;
        int i = this.f5081a + this.u;
        layoutParams.leftMargin = i;
        layoutParams.setMarginStart(i);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }
}
