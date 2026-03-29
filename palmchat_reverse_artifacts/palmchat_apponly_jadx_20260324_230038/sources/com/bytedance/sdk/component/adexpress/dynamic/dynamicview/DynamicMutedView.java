package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.b.a;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;
import com.bytedance.sdk.component.utils.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DynamicMutedView extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.nr {
    public DynamicMutedView(Context context, DynamicRootView dynamicRootView, n nVar) {
        super(context, dynamicRootView, nVar);
        ImageView imageView = new ImageView(context);
        this.k = imageView;
        imageView.setTag(5);
        addView(this.k, getWidgetLayoutParams());
        dynamicRootView.setMuteListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().d()) {
            return;
        }
        this.k.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public boolean b() {
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.b
    public boolean n() {
        super.n();
        if (com.bytedance.sdk.component.adexpress.b.u()) {
            ((ImageView) this.k).setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            ((ImageView) this.k).setScaleType(ImageView.ScaleType.CENTER);
        }
        setSoundMute(this.s.nr);
        if (!com.bytedance.sdk.component.adexpress.b.u()) {
            ((ImageView) this.k).setBackgroundDrawable(a.u(0, Integer.valueOf(this.l.d()), new int[]{this.n / 2}, null, null, null));
            return true;
        }
        Drawable drawableU = com.bytedance.sdk.component.adexpress.b.b.u(getContext(), this.l);
        if (drawableU == null) {
            return true;
        }
        ((ImageView) this.k).setBackground(drawableU);
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.nr
    public void setSoundMute(boolean z) {
        ((ImageView) this.k).setImageResource(com.bytedance.sdk.component.adexpress.b.u() ? z ? q.pn(getContext(), "tt_reward_full_mute") : q.pn(getContext(), "tt_reward_full_unmute") : z ? q.pn(getContext(), "tt_mute") : q.pn(getContext(), "tt_unmute"));
        if (((ImageView) this.k).getDrawable() != null) {
            ((ImageView) this.k).getDrawable().setAutoMirrored(true);
        }
    }
}
