package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.b.t;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;
import com.bytedance.sdk.component.utils.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DynamicLogoAd extends DynamicBaseWidgetImp {
    public DynamicLogoAd(Context context, DynamicRootView dynamicRootView, n nVar) {
        super(context, dynamicRootView, nVar);
        TextView textView = new TextView(context);
        this.k = textView;
        textView.setTag(Integer.valueOf(getClickArea()));
        addView(this.k, getWidgetLayoutParams());
    }

    private boolean a() {
        if (com.bytedance.sdk.component.adexpress.b.u()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.l.nr) && this.l.nr.contains("adx:")) || t.nr();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.b
    public boolean n() {
        super.n();
        this.k.setTextAlignment(this.l.n());
        ((TextView) this.k).setTextColor(this.l.x());
        ((TextView) this.k).setTextSize(this.l.pn());
        if (com.bytedance.sdk.component.adexpress.b.u()) {
            ((TextView) this.k).setIncludeFontPadding(false);
            ((TextView) this.k).setTextSize(Math.min(((com.bytedance.sdk.component.adexpress.b.n.nr(com.bytedance.sdk.component.adexpress.b.getContext(), this.n) - this.l.nr()) - this.l.u()) - 0.5f, this.l.pn()));
            ((TextView) this.k).setText(q.u(getContext(), "tt_logo_en"));
            return true;
        }
        if (!a()) {
            ((TextView) this.k).setText(q.nr(getContext(), "tt_logo_cn"));
            return true;
        }
        if (t.nr()) {
            ((TextView) this.k).setText(t.u());
            return true;
        }
        ((TextView) this.k).setText(t.u(this.l.nr));
        return true;
    }
}
