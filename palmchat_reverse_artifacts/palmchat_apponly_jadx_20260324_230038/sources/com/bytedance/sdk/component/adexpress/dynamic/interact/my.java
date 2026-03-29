package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.SlideRightView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class my implements x {
    private com.bytedance.sdk.component.adexpress.dynamic.fx.x b;
    private DynamicBaseWidget fx;
    private Context nr;
    private SlideRightView u;

    public my(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.fx.x xVar) {
        this.nr = context;
        this.fx = dynamicBaseWidget;
        this.b = xVar;
        b();
    }

    private void b() {
        this.u = new SlideRightView(this.nr);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, (int) com.bytedance.sdk.component.adexpress.b.n.u(this.nr, 120.0f));
        layoutParams.gravity = 17;
        this.u.setLayoutParams(layoutParams);
        this.u.setClipChildren(false);
        this.u.setGuideText(this.b.yd());
        DynamicBaseWidget dynamicBaseWidget = this.fx;
        if (dynamicBaseWidget != null) {
            this.u.setOnClickListener((View.OnClickListener) dynamicBaseWidget.getDynamicClickListener());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.x
    public ViewGroup fx() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.x
    public void nr() {
        SlideRightView slideRightView = this.u;
        if (slideRightView != null) {
            slideRightView.nr();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.x
    public void u() {
        SlideRightView slideRightView = this.u;
        if (slideRightView != null) {
            slideRightView.u();
        }
    }
}
