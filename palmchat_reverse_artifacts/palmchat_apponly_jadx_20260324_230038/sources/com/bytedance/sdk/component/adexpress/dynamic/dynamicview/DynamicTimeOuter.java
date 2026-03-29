package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.b.x;
import com.bytedance.sdk.component.adexpress.dynamic.b.t;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;
import com.bytedance.sdk.component.utils.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DynamicTimeOuter extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.fx {
    private boolean bq;
    private boolean nr;
    private boolean u;

    public DynamicTimeOuter(Context context, DynamicRootView dynamicRootView, n nVar) {
        super(context, dynamicRootView, nVar);
        dynamicRootView.setTimeOutListener(this);
        if ("timedown".equals(nVar.jk().getType())) {
            dynamicRootView.setTimedown(this.n);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.b
    public boolean n() {
        super.n();
        if (x.nr(this.s.getRenderRequest().iz())) {
            setVisibility(8);
        }
        if ("timedown".equals(this.mv.jk().getType())) {
            ((TextView) this.k).setText(String.valueOf((int) Double.parseDouble(this.l.jk())));
            return true;
        }
        ((TextView) this.k).setText(((int) Double.parseDouble(this.l.jk())) + "s");
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
        if (!TextUtils.equals("skip-with-countdowns-video-countdown", this.mv.jk().getType()) && !TextUtils.equals("skip-with-time-countdown", this.mv.jk().getType())) {
            super.pn();
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.x, this.n);
        layoutParams.gravity = 8388627;
        if (com.bytedance.sdk.component.adexpress.b.u()) {
            layoutParams.leftMargin = this.f5081a;
        }
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.fx
    public void u(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (z2 || this.bq) {
            ((TextView) this.k).setText("");
            setVisibility(8);
            return;
        }
        try {
            if (Integer.parseInt((String) charSequence) <= 0) {
                setVisibility(8);
                return;
            }
        } catch (Exception unused) {
        }
        setVisibility(0);
        if (!z && this.s.getRenderRequest().fx() && x.nr(this.s.getRenderRequest().iz())) {
            if (com.bytedance.sdk.component.adexpress.b.u()) {
                ((TextView) this.k).setText(i + "s");
            } else {
                ((TextView) this.k).setText(String.format(q.u(com.bytedance.sdk.component.adexpress.b.getContext(), "tt_reward_full_skip"), Integer.valueOf(i)));
            }
            this.u = true;
            return;
        }
        if (com.bytedance.sdk.component.adexpress.b.u() && !"open_ad".equals(this.s.getRenderRequest().iz()) && this.s.getRenderRequest().fx()) {
            this.bq = true;
            setVisibility(8);
            return;
        }
        if ("timedown".equals(this.mv.jk().getType())) {
            ((TextView) this.k).setText(charSequence);
            return;
        }
        ((TextView) this.k).setText(((Object) charSequence) + "s");
        this.nr = true;
        if (this.u) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (t.nr(((TextView) this.k).getText() != null ? r5.toString() : "", this.l.pn(), true)[0] + com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.l.fx() + this.l.b())), this.n);
            layoutParams.gravity = 8388629;
            this.k.setLayoutParams(layoutParams);
            this.u = false;
            requestLayout();
        }
    }
}
