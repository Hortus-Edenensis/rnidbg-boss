package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;
import com.bytedance.sdk.component.utils.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DynamicTimeOuterSkip extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.fx {
    private boolean u;

    public DynamicTimeOuterSkip(Context context, DynamicRootView dynamicRootView, n nVar) {
        super(context, dynamicRootView, nVar);
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() != null) {
            this.u = dynamicRootView.getRenderRequest().my();
        }
    }

    private String u(boolean z) {
        String strU = q.u(com.bytedance.sdk.component.adexpress.b.getContext(), "tt_reward_screen_skip_tx");
        if (!"skip-with-time-skip-btn".equals(this.mv.jk().getType())) {
            return strU;
        }
        if (com.bytedance.sdk.component.adexpress.b.u() && this.u) {
            strU = "X";
        }
        return z ? strU : "| ".concat(String.valueOf(strU));
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.b
    public boolean n() {
        super.n();
        if (!TextUtils.equals(this.mv.jk().getType(), "skip-with-time-skip-btn")) {
            return true;
        }
        ((TextView) this.k).setText("");
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.k).getText())) {
            setMeasuredDimension(0, this.n);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void pn() {
        if (TextUtils.equals("skip-with-time-skip-btn", this.mv.jk().getType())) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.x, this.n);
            layoutParams.gravity = 8388629;
            setLayoutParams(layoutParams);
            this.k.setTextAlignment(1);
            ((TextView) this.k).setGravity(17);
        } else {
            super.pn();
        }
        if (!"skip-with-time-skip-btn".equals(this.mv.jk().getType())) {
            this.k.setTextAlignment(1);
            ((TextView) this.k).setGravity(17);
        }
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.fx
    public void u(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2 = 0;
        if (z) {
            ((TextView) this.k).setText(u(z2));
        } else {
            if (z2) {
                ((TextView) this.k).setText(u(z2));
            }
            if (!z2) {
                i2 = 8;
            }
        }
        setVisibility(i2);
    }
}
