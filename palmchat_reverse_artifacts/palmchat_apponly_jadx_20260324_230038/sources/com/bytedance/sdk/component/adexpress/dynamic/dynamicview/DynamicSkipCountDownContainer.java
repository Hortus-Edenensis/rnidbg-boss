package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DynamicSkipCountDownContainer extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.fx {
    private int bq;
    private int nr;
    private int u;

    public DynamicSkipCountDownContainer(Context context, DynamicRootView dynamicRootView, n nVar) {
        super(context, dynamicRootView, nVar);
        setTag(Integer.valueOf(getClickArea()));
        dynamicRootView.setTimeOutListener(this);
        a();
    }

    private void a() {
        List<n> listT = this.mv.t();
        if (listT == null || listT.size() <= 0) {
            return;
        }
        for (n nVar : listT) {
            if (nVar.jk().u() == 21) {
                this.u = (int) (this.x - com.bytedance.sdk.component.adexpress.b.n.u(this.t, nVar.n()));
            }
            if (nVar.jk().u() == 20) {
                this.nr = (int) (this.x - com.bytedance.sdk.component.adexpress.b.n.u(this.t, nVar.n()));
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.b
    public boolean n() {
        setBackground(getBackgroundDrawable());
        setPadding((int) com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.l.fx()), (int) com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.l.nr()), (int) com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.l.b()), (int) com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.l.u()));
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.bq == 0) {
            setMeasuredDimension(this.nr, this.n);
        } else {
            setMeasuredDimension(this.u, this.n);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void pn() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i = this.f5081a;
        layoutParams.leftMargin = i;
        layoutParams.topMargin = this.jk;
        layoutParams.setMarginStart(i);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.fx
    public void u(CharSequence charSequence, boolean z, int i, boolean z2) {
        this.bq = i;
    }
}
