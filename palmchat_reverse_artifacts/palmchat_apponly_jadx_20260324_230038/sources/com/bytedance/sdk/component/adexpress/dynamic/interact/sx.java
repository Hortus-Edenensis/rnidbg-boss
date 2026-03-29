package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class sx implements x<DynamicUnlockView> {
    private final DynamicUnlockView u;

    public sx(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.fx.x xVar) {
        DynamicUnlockView dynamicUnlockView = new DynamicUnlockView(context);
        this.u = dynamicUnlockView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.b.n.u(context, xVar.tk() > 0 ? xVar.tk() : com.bytedance.sdk.component.adexpress.b.u() ? 0 : 120);
        dynamicUnlockView.setLayoutParams(layoutParams);
        dynamicUnlockView.setClipChildren(false);
        dynamicUnlockView.setText(xVar.yd());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.x
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public DynamicUnlockView fx() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.x
    public void nr() {
        DynamicUnlockView dynamicUnlockView = this.u;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.nr();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.x
    public void u() {
        DynamicUnlockView dynamicUnlockView = this.u;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.u();
        }
    }
}
