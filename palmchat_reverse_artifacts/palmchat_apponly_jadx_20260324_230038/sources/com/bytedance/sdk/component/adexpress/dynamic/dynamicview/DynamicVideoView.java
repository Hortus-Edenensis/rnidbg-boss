package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DynamicVideoView extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.pn {
    boolean bq;
    FrameLayout nr;
    TextView u;

    public DynamicVideoView(Context context, DynamicRootView dynamicRootView, n nVar) {
        super(context, dynamicRootView, nVar);
        this.bq = false;
        View view = new View(context);
        this.k = view;
        view.setTag(Integer.valueOf(getClickArea()));
        this.u = new TextView(context);
        this.nr = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.b.n.u(context, 40.0f), (int) com.bytedance.sdk.component.adexpress.b.n.u(context, 15.0f));
        layoutParams.gravity = 8388693;
        layoutParams.rightMargin = 20;
        layoutParams.bottomMargin = 20;
        this.u.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(25.0f);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.u.setBackground(gradientDrawable);
        this.u.setTextSize(10.0f);
        this.u.setGravity(17);
        this.u.setTextColor(-1);
        this.u.setVisibility(8);
        if (com.bytedance.sdk.component.adexpress.b.u()) {
            addView(this.nr, new FrameLayout.LayoutParams(-1, -1));
        }
        addView(this.u);
        addView(this.k, getWidgetLayoutParams());
        if (!com.bytedance.sdk.component.adexpress.b.u()) {
            addView(this.nr, getWidgetLayoutParams());
        }
        dynamicRootView.fx = this.nr;
        dynamicRootView.setVideoListener(this);
    }

    private void fx(View view) {
        if (view == this.u || view == ((DynamicBaseWidgetImp) this).bg) {
            return;
        }
        try {
            if (((Integer) view.getTag(com.bytedance.sdk.component.adexpress.dynamic.u.iz)).intValue() == 1) {
                return;
            }
        } catch (Throwable unused) {
        }
        int i = 0;
        view.setVisibility(0);
        if (!(view instanceof ViewGroup)) {
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            fx(viewGroup.getChildAt(i));
            i++;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public boolean b() {
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.b
    public boolean n() {
        super.n();
        double dPn = 0.0d;
        double dB = 0.0d;
        for (n nVarL = this.mv; nVarL != null; nVarL = nVarL.l()) {
            double dIz = dB + ((double) nVarL.iz());
            double dX = dPn + ((double) nVarL.x());
            dB = dIz - ((double) nVarL.b());
            dPn = dX - ((double) nVarL.pn());
        }
        try {
            float f = (float) dB;
            int iU = (int) com.bytedance.sdk.component.adexpress.b.n.u(getContext(), f);
            int iU2 = (int) com.bytedance.sdk.component.adexpress.b.n.u(getContext(), f + this.pn);
            if (com.bytedance.sdk.component.adexpress.b.fx.u(getContext())) {
                int dynamicWidth = ((DynamicRoot) this.s.getChildAt(0)).getDynamicWidth();
                int i = dynamicWidth - iU2;
                iU2 = dynamicWidth - iU;
                iU = i;
            }
            if ("open_ad".equals(this.s.getRenderRequest().iz())) {
                this.s.fx = this.nr;
            } else {
                float f2 = (float) dPn;
                ((DynamicRoot) this.s.getChildAt(0)).u.update(iU, (int) com.bytedance.sdk.component.adexpress.b.n.u(getContext(), f2), iU2, (int) com.bytedance.sdk.component.adexpress.b.n.u(getContext(), f2 + this.iz));
            }
        } catch (Exception unused) {
        }
        this.s.u(dB, dPn, this.pn, this.iz, this.l.k());
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.pn
    public void setTimeUpdate(int i) {
        if (!this.mv.jk().pn().wj() || i <= 0 || this.bq) {
            this.bq = true;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                fx(getChildAt(i2));
            }
            this.u.setVisibility(8);
            return;
        }
        String str = (i >= 60 ? "0" + (i / 60) : "00") + ":";
        int i3 = i % 60;
        this.u.setText(i3 > 9 ? str + i3 : str + "0" + i3);
        this.u.setVisibility(0);
    }
}
