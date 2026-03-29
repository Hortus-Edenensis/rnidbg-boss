package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;
import com.bytedance.sdk.component.utils.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DynamicSkipCountDownBtn extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.fx {
    private int bq;
    private int nr;
    private int[] u;

    public DynamicSkipCountDownBtn(Context context, DynamicRootView dynamicRootView, n nVar) {
        super(context, dynamicRootView, nVar);
        dynamicRootView.setTimeOutListener(this);
    }

    private void a() {
        int iU = (int) com.bytedance.sdk.component.adexpress.b.n.u(this.t, this.l.pn());
        this.nr = ((this.n - iU) / 2) - this.l.u();
        this.bq = 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.b
    public boolean n() {
        super.n();
        ((TextView) this.k).setText("");
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.k).getText())) {
            setMeasuredDimension(0, this.n);
        } else {
            setMeasuredDimension(this.x, this.n);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void pn() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.x, this.n);
        layoutParams.gravity = 8388629;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.fx
    @SuppressLint({"SetTextI18n"})
    public void u(CharSequence charSequence, boolean z, int i, boolean z2) {
        String strU = q.u(com.bytedance.sdk.component.adexpress.b.getContext(), "tt_reward_screen_skip_tx");
        if (i == 0) {
            this.k.setVisibility(0);
            ((TextView) this.k).setText("| ".concat(String.valueOf(strU)));
            this.k.measure(-2, -2);
            this.u = new int[]{this.k.getMeasuredWidth() + 1, this.k.getMeasuredHeight()};
            View view = this.k;
            int[] iArr = this.u;
            view.setLayoutParams(new FrameLayout.LayoutParams(iArr[0], iArr[1]));
            ((TextView) this.k).setGravity(17);
            ((TextView) this.k).setIncludeFontPadding(false);
            a();
            this.k.setPadding(this.l.fx(), this.nr, this.l.b(), this.bq);
        }
        requestLayout();
    }
}
