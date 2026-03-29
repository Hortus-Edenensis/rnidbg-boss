package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView2;
import com.bytedance.sdk.component.adexpress.widget.SlideUpView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends o<ClickSlideUpView> {
    public pn(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.fx.x xVar) {
        super(context, dynamicBaseWidget, xVar);
        u(xVar);
    }

    private void u(com.bytedance.sdk.component.adexpress.dynamic.fx.x xVar) {
        this.u = new ClickSlideUpView2(this.nr);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 81;
        this.u.setLayoutParams(layoutParams);
        SlideUpView slideUpView = this.u;
        if (slideUpView instanceof ClickSlideUpView2) {
            ((ClickSlideUpView2) slideUpView).setButtonText(this.b.yd());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.o, com.bytedance.sdk.component.adexpress.dynamic.interact.x
    public void nr() {
        this.u.nr();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.o, com.bytedance.sdk.component.adexpress.dynamic.interact.x
    public void u() {
        this.u.u();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.o
    public void b() {
    }
}
