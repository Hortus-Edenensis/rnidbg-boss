package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.HandLongPressView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class t implements x {
    private HandLongPressView u;

    public t(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.fx.x xVar) {
        this.u = new HandLongPressView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.b.n.u(context, 180.0f), (int) com.bytedance.sdk.component.adexpress.b.n.u(context, 180.0f));
        layoutParams.gravity = 17;
        this.u.setLayoutParams(layoutParams);
        this.u.setGuideText(xVar.yd());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.x
    public ViewGroup fx() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.x
    public void nr() {
        this.u.nr();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.x
    public void u() {
        this.u.u();
    }
}
