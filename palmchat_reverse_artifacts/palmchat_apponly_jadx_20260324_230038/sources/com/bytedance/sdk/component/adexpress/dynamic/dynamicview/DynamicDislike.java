package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;
import com.bytedance.sdk.component.adexpress.widget.DislikeView;
import com.bytedance.sdk.component.utils.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DynamicDislike extends DynamicBaseWidgetImp {
    public DynamicDislike(Context context, DynamicRootView dynamicRootView, n nVar) {
        super(context, dynamicRootView, nVar);
        if (com.bytedance.sdk.component.adexpress.b.u()) {
            this.k = new ImageView(context);
        } else {
            this.k = new DislikeView(context);
        }
        this.k.setTag(3);
        addView(this.k, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.k);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.b
    public boolean n() {
        super.n();
        if (com.bytedance.sdk.component.adexpress.b.u()) {
            Drawable drawableU = com.bytedance.sdk.component.adexpress.b.b.u(getContext(), this.l);
            if (drawableU != null) {
                this.k.setBackground(drawableU);
            }
            int iPn = q.pn(getContext(), "tt_close_btn");
            if (iPn > 0) {
                ((ImageView) this.k).setImageResource(iPn);
            }
            ((ImageView) this.k).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        int iU = (int) com.bytedance.sdk.component.adexpress.b.n.u(this.t, this.l.o());
        View view = this.k;
        if (view instanceof DislikeView) {
            ((DislikeView) view).setRadius((int) com.bytedance.sdk.component.adexpress.b.n.u(this.t, this.l.k()));
            ((DislikeView) this.k).setStrokeWidth(iU);
            ((DislikeView) this.k).setStrokeColor(this.l.my());
            ((DislikeView) this.k).setBgColor(this.l.d());
            ((DislikeView) this.k).setDislikeColor(this.l.x());
            ((DislikeView) this.k).setDislikeWidth((int) com.bytedance.sdk.component.adexpress.b.n.u(this.t, 1.0f));
        }
        return true;
    }
}
