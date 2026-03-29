package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class s implements k, x<ShakeAnimationView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5090a;
    private DynamicBaseWidget b;
    private Context fx;
    private String iz;
    private boolean n;
    private ShakeAnimationView nr;
    private com.bytedance.sdk.component.adexpress.dynamic.fx.x pn;
    public int u;
    private com.bytedance.sdk.component.adexpress.dynamic.fx.jk x;

    public s(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.fx.x xVar, String str, com.bytedance.sdk.component.adexpress.dynamic.fx.jk jkVar, boolean z, int i, boolean z2) {
        this.fx = context;
        this.b = dynamicBaseWidget;
        this.pn = xVar;
        this.iz = str;
        this.x = jkVar;
        this.n = z;
        this.u = i;
        this.f5090a = z2;
        iz();
    }

    private void iz() {
        final com.bytedance.sdk.component.adexpress.dynamic.pn.u dynamicClickListener = this.b.getDynamicClickListener();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("convertActionType", 1);
            dynamicClickListener.u(jSONObject);
        } catch (Throwable unused) {
        }
        if ("16".equals(this.iz)) {
            Context context = this.fx;
            ShakeAnimationView shakeAnimationView = new ShakeAnimationView(context, com.bytedance.sdk.component.adexpress.fx.u.n(context), this.x, this.n, this.u, this.f5090a);
            this.nr = shakeAnimationView;
            if (shakeAnimationView.getShakeLayout() != null) {
                this.nr.getShakeLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
        } else {
            Context context2 = this.fx;
            this.nr = new ShakeAnimationView(context2, com.bytedance.sdk.component.adexpress.fx.u.x(context2), this.x, this.n, this.u, this.f5090a);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.nr.setGravity(17);
        layoutParams.gravity = 17;
        this.nr.setLayoutParams(layoutParams);
        this.nr.setTranslationY(com.bytedance.sdk.component.adexpress.b.n.u(this.fx, this.pn.f()));
        this.nr.setShakeText(this.pn.yd());
        this.nr.setClipChildren(false);
        this.nr.setOnShakeViewListener(new ShakeAnimationView.u() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.s.1
            @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.u
            public void u(boolean z) {
                com.bytedance.sdk.component.adexpress.dynamic.pn.u uVar = dynamicClickListener;
                if (uVar != null) {
                    uVar.u(z, s.this);
                }
                s.this.nr.setOnClickListener((View.OnClickListener) dynamicClickListener);
                s.this.nr.performClick();
                if (s.this.pn == null || !s.this.pn.eh()) {
                    return;
                }
                s.this.nr.setOnClickListener(null);
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.x
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ShakeAnimationView fx() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.k
    public void pn() {
        if (this.nr.getParent() != null) {
            ((ViewGroup) this.nr.getParent()).setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.x
    public void nr() {
        this.nr.clearAnimation();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.x
    public void u() {
        this.nr.u();
    }
}
