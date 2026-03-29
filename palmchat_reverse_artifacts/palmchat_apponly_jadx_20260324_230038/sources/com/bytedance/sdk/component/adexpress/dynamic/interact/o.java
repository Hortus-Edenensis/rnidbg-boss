package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.SlideUpView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class o<E extends SlideUpView> implements x<E> {
    protected com.bytedance.sdk.component.adexpress.dynamic.fx.x b;
    protected DynamicBaseWidget fx;
    protected Context nr;
    protected int pn;
    protected SlideUpView u;

    public o(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.fx.x xVar, int i) {
        this.pn = i;
        this.nr = context;
        this.fx = dynamicBaseWidget;
        this.b = xVar;
        b();
    }

    public void b() {
        this.u = new SlideUpView(this.nr, this.b.xw());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.b.n.u(this.nr, 200.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.b.n.u(this.nr, 100 - this.pn);
        this.u.setLayoutParams(layoutParams);
        try {
            this.u.setGuideText(this.b.yd());
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.x
    /* JADX INFO: renamed from: iz, reason: merged with bridge method [inline-methods] */
    public E fx() {
        return (E) this.u;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.x
    public void nr() {
        this.u.nr();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.x
    public void u() {
        this.u.u();
    }

    public o(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.fx.x xVar) {
        this(context, dynamicBaseWidget, xVar, 0);
    }
}
