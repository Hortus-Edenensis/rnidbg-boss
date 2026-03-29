package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
import org.apache.http.HttpHost;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class t extends com.bytedance.adsdk.ugeno.nr.fx<InteractWebView> {
    private Map<String, Object> ki;
    private String u;

    public t(Context context) {
        super(context);
    }

    public void n() {
        if (TextUtils.isEmpty(this.u)) {
            this.u = "https://cdn-tos-cn.bytedance.net/obj/archi/ad/play-comp/playable-component-sdk/dev/index.ecommerce.html";
        }
        ((InteractWebView) this.pn).loadUrl(this.u);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
        Map<String, Object> mapNr = this.f5034a.nr();
        this.ki = mapNr;
        ((InteractWebView) this.pn).setUGenExtraMap(mapNr);
        ((InteractWebView) this.pn).setUGenContext(this.f5034a);
        ((InteractWebView) this.pn).iz();
        ((InteractWebView) this.pn).x();
        JSONObject jSONObjectJk = jk();
        if (jSONObjectJk != null) {
            com.bytedance.sdk.component.widget.nr.u uVar = new com.bytedance.sdk.component.widget.nr.u();
            uVar.u(jSONObjectJk.optInt("meta_hashcode", 0));
            ((InteractWebView) this.pn).setMaterialMeta(uVar);
        }
        n();
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public InteractWebView u() {
        InteractWebView interactWebView = new InteractWebView(this.nr);
        this.pn = interactWebView;
        return interactWebView;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        super.u(str, str2);
        str.hashCode();
        if (str.equals("src")) {
            if (TextUtils.isEmpty(this.u) || !this.u.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.u = "https://cdn-tos-cn.bytedance.net/obj/archi/ad/play-comp/playable-component-sdk/dev/index.ecommerce.html";
            } else {
                this.u = str2;
            }
        }
    }
}
