package com.bytedance.sdk.openadsdk.l.u;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.nr.u.jk;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.sx;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.cdo.oaps.ad.OapsKey;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u {
    protected String fx;
    protected JSONObject iz;
    protected String nr;
    public com.bytedance.sdk.openadsdk.l.u u;
    protected String x;
    public AtomicBoolean b = new AtomicBoolean(false);
    public AtomicBoolean pn = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.l.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0310u {
        void u(boolean z, Map<String, Object> map);
    }

    public u(com.bytedance.sdk.openadsdk.l.u uVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        this.u = uVar;
        this.nr = str;
        this.x = str4;
        this.fx = str2;
        JSONObject jSONObject2 = new JSONObject();
        this.iz = jSONObject2;
        try {
            if (this instanceof nr) {
                jSONObject2.putOpt("log_extra", str3);
                this.iz.putOpt("resource_type", "union");
                this.iz.putOpt("ts", Long.valueOf(System.currentTimeMillis() / 1000));
            } else if (this instanceof fx) {
                jSONObject2.putOpt("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                this.iz.putOpt(MediationConstant.EXTRA_ADID, jSONObject.optString(MediationConstant.EXTRA_ADID));
                this.iz.putOpt("customer_id", jSONObject.optString("customer_id"));
            }
            this.iz.putOpt("cid", str);
            this.iz.putOpt(OapsKey.KEY_ACTIVE_CODE, Integer.valueOf(o.fx(dw.getContext())));
            this.iz.putOpt("app_name", n.o().q());
            this.iz.putOpt("app_id", n.o().c());
            this.iz.putOpt("app_version", com.bytedance.sdk.openadsdk.core.n.u.b());
            this.iz.putOpt("sdk_version", d.b);
            this.iz.putOpt(PluginConstants.KEY_PLUGIN_VERSION, "7.2.3.2");
            this.iz.putOpt("platform", AnalyticsConstants.SDK_TYPE);
            this.iz.putOpt("device_id", sx.fx());
            this.iz.putOpt("web_url", str4);
        } catch (JSONException unused) {
        }
        u(str, str2);
    }

    public abstract void fx();

    public void nr() {
        u();
    }

    public abstract void nr(Context context, String str, com.bytedance.sdk.openadsdk.l.nr nrVar, WebResourceResponse webResourceResponse, jk jkVar, Map<String, Object> map);

    public abstract void u();

    public abstract void u(Context context, String str, com.bytedance.sdk.openadsdk.l.nr nrVar, WebResourceResponse webResourceResponse, jk jkVar, Map<String, Object> map);

    public abstract void u(com.bytedance.sdk.openadsdk.l.nr nrVar, WebResourceResponse webResourceResponse, jk jkVar, InterfaceC0310u interfaceC0310u);

    public abstract void u(String str);

    public abstract void u(String str, String str2);

    public abstract void u(JSONObject jSONObject, String str, jk jkVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2);

    public abstract boolean u(WebView webView);

    public abstract boolean u(jk jkVar);
}
