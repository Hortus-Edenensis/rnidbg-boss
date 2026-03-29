package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.b.x;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DynamicTimeOuterContainerWidgetImp extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.fx {
    private int bq;
    private boolean c;
    private int dw;
    boolean nr;
    int u;

    public DynamicTimeOuterContainerWidgetImp(Context context, DynamicRootView dynamicRootView, n nVar) {
        super(context, dynamicRootView, nVar);
        this.dw = 0;
        setTag(Integer.valueOf(getClickArea()));
        a();
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().d()) {
            return;
        }
        View view = this.k;
        if (view != null) {
            view.setVisibility(8);
        }
        setVisibility(8);
    }

    private void a() {
        List<n> listT = this.mv.t();
        if (listT == null || listT.size() <= 0) {
            return;
        }
        Iterator<n> it = listT.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (TextUtils.equals("skip-with-time-skip-btn", next.jk().getType())) {
                int iU = (int) com.bytedance.sdk.component.adexpress.b.n.u(this.t, next.n() + (com.bytedance.sdk.component.adexpress.b.u() ? next.mv() : 0));
                this.bq = iU;
                this.u = this.x - iU;
            }
        }
        this.dw = this.x - this.u;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.b
    public boolean n() {
        if (x.nr(this.s.getRenderRequest().iz())) {
            return true;
        }
        super.n();
        setPadding((int) com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.l.fx()), (int) com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.l.nr()), (int) com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.l.b()), (int) com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.l.u()));
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.c && this.l != null) {
            setMeasuredDimension(this.bq + ((int) com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.l.fx())) + ((int) com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.l.b())), this.n);
        } else if (this.nr) {
            setMeasuredDimension(this.x, this.n);
        } else {
            setMeasuredDimension(this.u, this.n);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void pn() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.nr) {
            layoutParams.leftMargin = this.f5081a;
        } else {
            layoutParams.leftMargin = this.f5081a + this.dw;
        }
        if (this.c && this.l != null) {
            layoutParams.leftMargin = ((this.f5081a + this.dw) - ((int) com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.l.fx()))) - ((int) com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.l.b()));
        }
        if (com.bytedance.sdk.component.adexpress.b.u()) {
            layoutParams.topMargin = this.jk - ((int) com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.l.nr()));
        } else {
            layoutParams.topMargin = this.jk;
        }
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.fx
    public void u(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (z2 && this.c != z2) {
            this.c = z2;
            pn();
            return;
        }
        if (z && this.nr != z) {
            this.nr = z;
            pn();
        }
        this.nr = z;
    }
}
