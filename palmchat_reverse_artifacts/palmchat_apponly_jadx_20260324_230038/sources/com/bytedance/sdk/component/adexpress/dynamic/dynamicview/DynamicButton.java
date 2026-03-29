package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.AnimationButton;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DynamicButton extends DynamicBaseWidgetImp {
    public DynamicButton(Context context, DynamicRootView dynamicRootView, n nVar) {
        super(context, dynamicRootView, nVar);
        AnimationButton animationButton = new AnimationButton(context);
        this.k = animationButton;
        animationButton.setTag(Integer.valueOf(getClickArea()));
        addView(this.k, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        if (!com.bytedance.sdk.component.adexpress.b.u() || !"fillButton".equals(this.mv.jk().getType())) {
            return super.getWidgetLayoutParams();
        }
        ((TextView) this.k).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView) this.k).setMaxLines(1);
        FrameLayout.LayoutParams widgetLayoutParams = super.getWidgetLayoutParams();
        widgetLayoutParams.width -= this.l.sx() * 2;
        widgetLayoutParams.height -= this.l.sx() * 2;
        widgetLayoutParams.topMargin += this.l.sx();
        int iSx = widgetLayoutParams.leftMargin + this.l.sx();
        widgetLayoutParams.leftMargin = iSx;
        widgetLayoutParams.setMarginStart(iSx);
        widgetLayoutParams.setMarginEnd(widgetLayoutParams.rightMargin);
        return widgetLayoutParams;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.b
    public boolean n() {
        super.n();
        if (TextUtils.equals("download-progress-button", this.mv.jk().getType()) && TextUtils.isEmpty(this.l.jk())) {
            this.k.setVisibility(4);
            return true;
        }
        this.k.setTextAlignment(this.l.n());
        ((TextView) this.k).setText(this.l.jk());
        ((TextView) this.k).setTextColor(this.l.x());
        ((TextView) this.k).setTextSize(this.l.pn());
        ((TextView) this.k).setGravity(17);
        ((TextView) this.k).setIncludeFontPadding(false);
        if ("fillButton".equals(this.mv.jk().getType())) {
            this.k.setPadding(0, 0, 0, 0);
        } else {
            this.k.setPadding(this.l.fx(), this.l.nr(), this.l.b(), this.l.u());
        }
        return true;
    }
}
