package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView;
import com.bytedance.sdk.component.utils.q;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class bg implements x<WriggleGuideAnimationView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5089a;
    private DynamicBaseWidget b;
    private Context fx;
    private String iz;
    private boolean n;
    private WriggleGuideAnimationView nr;
    private com.bytedance.sdk.component.adexpress.dynamic.fx.x pn;
    public int u;
    private com.bytedance.sdk.component.adexpress.dynamic.fx.jk x;

    public bg(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.fx.x xVar, String str, com.bytedance.sdk.component.adexpress.dynamic.fx.jk jkVar, boolean z, int i, boolean z2) {
        this.fx = context;
        this.b = dynamicBaseWidget;
        this.pn = xVar;
        this.iz = str;
        this.x = jkVar;
        this.n = z;
        this.u = i;
        this.f5089a = z2;
        pn();
    }

    private void pn() {
        int iTk = this.pn.tk();
        final com.bytedance.sdk.component.adexpress.dynamic.pn.u dynamicClickListener = this.b.getDynamicClickListener();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("convertActionType", 2);
            dynamicClickListener.u(jSONObject);
        } catch (Throwable unused) {
        }
        if (BaseWrapper.ENTER_ID_18.equals(this.iz)) {
            Context context = this.fx;
            WriggleGuideAnimationView wriggleGuideAnimationView = new WriggleGuideAnimationView(context, com.bytedance.sdk.component.adexpress.fx.u.a(context), this.x, this.n, this.u, this.f5089a);
            this.nr = wriggleGuideAnimationView;
            if (wriggleGuideAnimationView.getWriggleLayout() != null) {
                this.nr.getWriggleLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
            if (this.nr.getTopTextView() != null) {
                if (TextUtils.isEmpty(this.pn.za())) {
                    this.nr.getTopTextView().setText(q.nr(this.fx, "tt_splash_wriggle_top_text_style_17"));
                } else {
                    this.nr.getTopTextView().setText(this.pn.za());
                }
            }
        } else {
            Context context2 = this.fx;
            this.nr = new WriggleGuideAnimationView(context2, com.bytedance.sdk.component.adexpress.fx.u.a(context2), this.x, this.n, this.u, this.f5089a);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        this.nr.setTranslationY(-((int) com.bytedance.sdk.component.adexpress.b.n.u(this.fx, iTk)));
        this.nr.setLayoutParams(layoutParams);
        this.nr.setShakeText(this.pn.yd());
        this.nr.setClipChildren(false);
        final View wriggleProgressIv = this.nr.getWriggleProgressIv();
        this.nr.setOnShakeViewListener(new WriggleGuideAnimationView.u() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.bg.1
            @Override // com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView.u
            public void u() {
                if (wriggleProgressIv != null) {
                    if (bg.this.nr != null) {
                        bg.this.nr.setOnClickListener((View.OnClickListener) dynamicClickListener);
                        bg.this.nr.performClick();
                    }
                    if (bg.this.pn == null || !bg.this.pn.eh()) {
                        return;
                    }
                    bg.this.nr.setOnClickListener(null);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.x
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public WriggleGuideAnimationView fx() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.x
    public void nr() {
        this.nr.clearAnimation();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.x
    public void u() {
        this.nr.u();
    }
}
