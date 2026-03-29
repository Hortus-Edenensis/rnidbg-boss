package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;
import com.bytedance.sdk.component.adexpress.dynamic.interact.k;
import com.bytedance.sdk.component.adexpress.nr.t;
import com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@SuppressLint({"ViewConstructor"})
public class DynamicImageFlipSlide extends DynamicImageView {
    private final nr nr;
    private final ImageFlipSlideGroup u;

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        void u(u uVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u();
    }

    public DynamicImageFlipSlide(Context context, DynamicRootView dynamicRootView, n nVar) {
        super(context, dynamicRootView, nVar);
        this.nr = new nr() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.1
            @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.nr
            public void u(u uVar) {
                if (DynamicImageFlipSlide.this.u != null) {
                    DynamicImageFlipSlide.this.u.u(uVar);
                }
            }
        };
        ImageFlipSlideGroup imageFlipSlideGroup = new ImageFlipSlideGroup(getContext(), TextUtils.equals(getDynamicLayoutBrickValue().ky(), "slide"));
        this.u = imageFlipSlideGroup;
        addView(imageFlipSlideGroup, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public com.bytedance.sdk.component.adexpress.dynamic.pn.u getDynamicClickListener() {
        com.bytedance.sdk.component.adexpress.dynamic.pn.u dynamicClickListener = this.s.getDynamicClickListener();
        return this.l.dc() ? new fx(dynamicClickListener, this.nr) : dynamicClickListener;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.b
    public boolean n() {
        super.n();
        this.u.u(this.l.t(), nr(this.l.t()));
        this.u.nr(this.l.uq(), nr(this.l.uq()));
        this.u.setFilterColors(this.l.rg());
        this.u.fx();
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.u.u();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.u.nr();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class fx implements View.OnClickListener, View.OnTouchListener, com.bytedance.sdk.component.adexpress.dynamic.pn.u {
        nr nr;
        com.bytedance.sdk.component.adexpress.dynamic.pn.u u;

        public fx(com.bytedance.sdk.component.adexpress.dynamic.pn.u uVar, nr nrVar) {
            this.u = uVar;
            this.nr = nrVar;
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.pn.u
        public void nr(View view) {
            com.bytedance.sdk.component.adexpress.dynamic.pn.u uVar = this.u;
            if (uVar != null) {
                uVar.nr(view);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            nr nrVar = this.nr;
            if (nrVar != null) {
                nrVar.u(new u() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.fx.1
                    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.u
                    public void u() {
                        com.bytedance.sdk.component.adexpress.dynamic.pn.u uVar = fx.this.u;
                        if (uVar instanceof View.OnClickListener) {
                            ((View.OnClickListener) uVar).onClick(view);
                        }
                    }
                });
                return;
            }
            com.bytedance.sdk.component.adexpress.dynamic.pn.u uVar = this.u;
            if (uVar instanceof View.OnClickListener) {
                ((View.OnClickListener) uVar).onClick(view);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            com.bytedance.sdk.component.adexpress.dynamic.pn.u uVar = this.u;
            if (uVar instanceof View.OnTouchListener) {
                return ((View.OnTouchListener) uVar).onTouch(view, motionEvent);
            }
            return false;
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.pn.u
        public void u(View view) {
            com.bytedance.sdk.component.adexpress.dynamic.pn.u uVar = this.u;
            if (uVar != null) {
                uVar.u(view);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.pn.u
        public void u(t tVar) {
            com.bytedance.sdk.component.adexpress.dynamic.pn.u uVar = this.u;
            if (uVar != null) {
                uVar.u(tVar);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.pn.u
        public void u(boolean z, k kVar) {
            com.bytedance.sdk.component.adexpress.dynamic.pn.u uVar = this.u;
            if (uVar != null) {
                uVar.u(z, kVar);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.pn.u
        public void u(JSONObject jSONObject) {
            com.bytedance.sdk.component.adexpress.dynamic.pn.u uVar = this.u;
            if (uVar != null) {
                uVar.u(jSONObject);
            }
        }
    }
}
