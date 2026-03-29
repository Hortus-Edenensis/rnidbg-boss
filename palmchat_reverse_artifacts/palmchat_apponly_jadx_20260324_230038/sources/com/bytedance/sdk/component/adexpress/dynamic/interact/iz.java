package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpShakeView;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import com.bytedance.sdk.component.adexpress.widget.ShakeClickView;
import com.bytedance.sdk.component.adexpress.widget.SlideUpView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz extends o<ClickSlideUpShakeView> implements k {
    public iz(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.fx.x xVar, com.bytedance.sdk.component.adexpress.dynamic.fx.jk jkVar, boolean z, int i, boolean z2) {
        super(context, dynamicBaseWidget, xVar);
        this.nr = context;
        this.b = xVar;
        this.fx = dynamicBaseWidget;
        u(jkVar, xVar, z, i, z2);
    }

    private void u(com.bytedance.sdk.component.adexpress.dynamic.fx.jk jkVar, com.bytedance.sdk.component.adexpress.dynamic.fx.x xVar, boolean z, int i, boolean z2) {
        this.u = new ClickSlideUpShakeView(this.nr, jkVar, z, i, z2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.b.n.u(this.nr, 300.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.b.n.u(this.nr, xVar.tk() > 0 ? xVar.tk() : com.bytedance.sdk.component.adexpress.b.u() ? 0 : 120);
        this.u.setLayoutParams(layoutParams);
        this.u.setClipChildren(false);
        this.u.setSlideText(this.b.yd());
        SlideUpView slideUpView = this.u;
        if (slideUpView instanceof ClickSlideUpShakeView) {
            ((ClickSlideUpShakeView) slideUpView).setShakeText(this.b.v());
            final ShakeClickView shakeView = ((ClickSlideUpShakeView) this.u).getShakeView();
            if (shakeView != null) {
                shakeView.setOnShakeViewListener(new ShakeAnimationView.u() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.iz.1
                    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.u
                    public void u(boolean z3) {
                        if (iz.this.fx.getDynamicClickListener() != null) {
                            iz.this.fx.getDynamicClickListener().u(z3, iz.this);
                        }
                        shakeView.performClick();
                    }
                });
                shakeView.setOnClickListener((View.OnClickListener) this.fx.getDynamicClickListener());
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.k
    public void pn() {
        if (this.u.getParent() != null) {
            ((ViewGroup) this.u.getParent()).setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.o
    public void b() {
    }
}
