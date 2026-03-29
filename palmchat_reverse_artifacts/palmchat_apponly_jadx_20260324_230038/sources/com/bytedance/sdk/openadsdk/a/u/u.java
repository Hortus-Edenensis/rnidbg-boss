package com.bytedance.sdk.openadsdk.a.u;

import com.bytedance.sdk.component.u.b;
import com.bytedance.sdk.component.u.o;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.ja;
import com.bytedance.sdk.openadsdk.core.n;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends com.bytedance.sdk.component.u.b<JSONObject, JSONObject> {
    private WeakReference<ja> u;

    public u(ja jaVar) {
        this.u = new WeakReference<>(jaVar);
    }

    public static void u(o oVar, final ja jaVar) {
        oVar.u("interstitial_webview_close", new b.nr() { // from class: com.bytedance.sdk.openadsdk.a.u.u.1
            @Override // com.bytedance.sdk.component.u.b.nr
            public com.bytedance.sdk.component.u.b u() {
                return new u(jaVar);
            }
        });
    }

    @Override // com.bytedance.sdk.component.u.b
    public void u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        n.o().tk();
        k.nr("DoInterstitialWebViewCloseMethod", "DoInterstitialWebViewCloseMethod invoke ");
        ja jaVar = this.u.get();
        if (jaVar == null) {
            k.nr("DoInterstitialWebViewCloseMethod", "invoke error");
            fx();
        } else {
            jaVar.my();
        }
    }

    @Override // com.bytedance.sdk.component.u.b
    public void b() {
    }
}
