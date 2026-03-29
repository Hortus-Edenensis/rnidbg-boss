package com.bytedance.sdk.openadsdk.core.component.reward.view.ugen;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.fx.k;
import com.bytedance.adsdk.ugeno.fx.my;
import com.bytedance.adsdk.ugeno.fx.sx;
import com.bytedance.adsdk.ugeno.nr.fx;
import com.bytedance.adsdk.ugeno.pn.iz;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bg;
import com.bytedance.sdk.openadsdk.core.nr.nr;
import com.bytedance.sdk.openadsdk.core.ugeno.n.pn;
import com.bytedance.sdk.openadsdk.core.y.y;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class UgenBanner extends FrameLayout {
    private final AtomicBoolean b;
    private boolean fx;
    private int iz;
    private View nr;
    private WeakReference<ObjectAnimator> pn;
    private k u;

    public UgenBanner(Context context) {
        super(context);
        this.b = new AtomicBoolean(false);
    }

    public void nr() {
        View view = this.nr;
        if (view == null || this.fx) {
            return;
        }
        FrameLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParamsGenerateDefaultLayoutParams == null) {
            layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        }
        layoutParamsGenerateDefaultLayoutParams.topMargin = this.iz;
        addView(this.nr, layoutParamsGenerateDefaultLayoutParams);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.nr, "translationY", -400.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(600L);
        objectAnimatorOfFloat.start();
        this.pn = new WeakReference<>(objectAnimatorOfFloat);
    }

    public void setTopMargin(int i) {
        this.iz = i;
    }

    public void u(bc bcVar, nr nrVar) {
        if (bcVar.pu() == null || TextUtils.isEmpty(bcVar.pu().fx())) {
            return;
        }
        u(bg.l(bcVar), bcVar, nrVar, bcVar.pu().fx(), bcVar.wf(), TextUtils.isEmpty(bcVar.yb()) ? "立即下载" : bcVar.yb(), false);
    }

    public void u(com.bytedance.sdk.openadsdk.core.ugeno.x.u uVar, final bc bcVar, final nr nrVar, final String str, final String str2, final String str3, final boolean z) {
        if (uVar == null || this.b.getAndSet(true) || bcVar.dd() == null || TextUtils.isEmpty(bcVar.dd().u())) {
            return;
        }
        pn.u(uVar, new pn.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.pn.u
            public void u(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("icon", bcVar.dd().u());
                    jSONObject2.put("app_name", str);
                    jSONObject2.put("title", str2);
                    jSONObject2.put("button_text", str3);
                } catch (JSONException unused) {
                }
                UgenBanner ugenBanner = UgenBanner.this;
                ugenBanner.nr = ugenBanner.u(jSONObject, jSONObject2, new sx() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner.1.1
                    @Override // com.bytedance.adsdk.ugeno.fx.sx
                    public void u(fx fxVar, String str4, iz.u uVar2) {
                    }

                    @Override // com.bytedance.adsdk.ugeno.fx.sx
                    public void u(my myVar, sx.nr nrVar2, sx.u uVar2) {
                        if (myVar.fx() != null && "banner_click".equals(myVar.fx().optString("type"))) {
                            UgenBanner.this.nr.setTag(2114387594, Boolean.TRUE);
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            nrVar.u(UgenBanner.this.nr, null);
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            if (z) {
                                UgenBanner.this.u();
                            }
                        }
                    }
                });
            }
        });
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner.2
            @Override // java.lang.Runnable
            public void run() {
                UgenBanner.this.nr();
            }
        }, 3000L);
    }

    public void u() {
        ObjectAnimator objectAnimator;
        this.fx = true;
        View view = this.nr;
        if (view != null) {
            view.setVisibility(8);
        }
        WeakReference<ObjectAnimator> weakReference = this.pn;
        if (weakReference == null || (objectAnimator = weakReference.get()) == null) {
            return;
        }
        objectAnimator.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View u(JSONObject jSONObject, JSONObject jSONObject2, sx sxVar) {
        k kVar = new k(getContext());
        this.u = kVar;
        fx<View> fxVarU = kVar.u(jSONObject);
        this.u.u(sxVar);
        this.u.nr(jSONObject2);
        if (fxVarU == null) {
            return null;
        }
        View viewA = fxVarU.a();
        if (viewA != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(fxVarU.wq(), fxVarU.pb());
            layoutParams.leftMargin = y.fx(getContext(), 16.0f);
            layoutParams.rightMargin = y.fx(getContext(), 16.0f);
            viewA.setLayoutParams(layoutParams);
        }
        return viewA;
    }
}
