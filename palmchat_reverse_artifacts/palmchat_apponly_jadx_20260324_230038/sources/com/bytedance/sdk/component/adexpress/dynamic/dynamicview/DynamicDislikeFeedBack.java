package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;
import com.bytedance.sdk.component.utils.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DynamicDislikeFeedBack extends DynamicBaseWidgetImp {
    public DynamicDislikeFeedBack(Context context, DynamicRootView dynamicRootView, n nVar) {
        super(context, dynamicRootView, nVar);
        if (com.bytedance.sdk.component.adexpress.b.u()) {
            ImageView imageView = new ImageView(context);
            this.k = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.x = this.n;
        } else {
            this.k = new TextView(context);
        }
        this.k.setTag(3);
        addView(this.k, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.k);
        if (dynamicRootView.getRenderRequest() != null) {
            if (dynamicRootView.getRenderRequest().t() && dynamicRootView.getRenderRequest().d()) {
                return;
            }
            this.k.setVisibility(8);
            setVisibility(8);
        }
    }

    public String getText() {
        return q.u(com.bytedance.sdk.component.adexpress.b.getContext(), "tt_reward_feedback");
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.b
    public boolean n() {
        super.n();
        if (com.bytedance.sdk.component.adexpress.b.u()) {
            Drawable drawableU = com.bytedance.sdk.component.adexpress.b.b.u(getContext(), this.l);
            if (drawableU != null) {
                ((ImageView) this.k).setBackground(drawableU);
            }
            ((ImageView) this.k).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int iPn = q.pn(getContext(), "tt_reward_full_feedback");
            if (iPn > 0) {
                ((ImageView) this.k).setImageResource(iPn);
            }
            return true;
        }
        ((TextView) this.k).setText(getText());
        this.k.setTextAlignment(this.l.n());
        ((TextView) this.k).setTextColor(this.l.x());
        ((TextView) this.k).setTextSize(this.l.pn());
        this.k.setBackground(getBackgroundDrawable());
        if (this.l.c()) {
            int iQ = this.l.q();
            if (iQ > 0) {
                ((TextView) this.k).setLines(iQ);
                ((TextView) this.k).setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            ((TextView) this.k).setMaxLines(1);
            ((TextView) this.k).setGravity(17);
            ((TextView) this.k).setEllipsize(TextUtils.TruncateAt.END);
        }
        this.k.setPadding((int) com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.l.fx()), (int) com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.l.nr()), (int) com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.l.b()), (int) com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), this.l.u()));
        ((TextView) this.k).setGravity(17);
        return true;
    }
}
