package com.bytedance.sdk.openadsdk.core.ja.u;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.a.nr.b;
import com.bytedance.sdk.component.a.nr.pn;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.y.jk;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.huawei.openalliance.ad.constant.az;
import com.lantern.auth.server.WkParams;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends a {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ja.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0263u {
        private static final u u = new u();
    }

    private JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectWq = n.o().wq();
        boolean zZu = dw.nr().zu();
        if (jSONObjectWq != null) {
            Iterator<String> itKeys = jSONObjectWq.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next)) {
                    JSONObject jSONObjectOptJSONObject = jSONObjectWq.optJSONObject(next);
                    if (jSONObjectOptJSONObject != null) {
                        jSONObjectOptJSONObject.put("plugin_update_network", n.o().z().u(next));
                    }
                    if (zZu && next.equals("com.byted.live.lite")) {
                        jSONObject.putOpt(nr.nr(), jSONObjectOptJSONObject);
                    } else {
                        jSONObject.putOpt(next, jSONObjectOptJSONObject);
                    }
                }
            }
        }
        return jSONObject;
    }

    private JSONObject fx() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oaid", jk.fx(false));
            jSONObject.put("conn_type", o.nr(dw.getContext()));
            jSONObject.put("os", 1);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("sdk_version", d.b);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.2.3.2");
            jSONObject.put("package_name", jp.a());
            jSONObject.put("app_version", jp.t());
            jSONObject.put("app_code", jp.jk());
            jSONObject.put("vendor", Build.MANUFACTURER);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            String strC = n.o().c();
            jSONObject.put("ts", jCurrentTimeMillis);
            jSONObject.put("app_id", strC);
            jSONObject.put("req_sign", x.nr(strC != null ? strC.concat(String.valueOf(jCurrentTimeMillis)).concat(d.b) : ""));
            jSONObject.put("channel", d.x);
            jSONObject.put("applog_did", jk.o());
            jSONObject.put(WkParams.IMEI, jk.n());
            jSONObject.put(az.at, 1);
            jSONObject.put("device_abi", Build.SUPPORTED_ABIS[0]);
            jSONObject.put("plugins", b());
            jSONObject.put("csj_type", n.o().xw() ? 1 : 0);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static u u() {
        return C0263u.u;
    }

    public void nr() {
        if (o.u(dw.getContext())) {
            com.bytedance.sdk.component.jk.x.nr(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        pn pnVarNr = com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().nr();
        pnVarNr.u(jp.n("/api/ad/union/sdk/settings/plugins"));
        pnVarNr.nr("User-Agent", jk.mv());
        pnVarNr.u(com.bytedance.sdk.component.utils.u.u(fx()));
        pnVarNr.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.core.ja.u.u.1
            @Override // com.bytedance.sdk.component.a.u.u
            public void u(b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                if (nrVar == null || !nrVar.a() || TextUtils.isEmpty(nrVar.pn())) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(nrVar.pn());
                    if (jSONObject.optInt("cypher") == 3) {
                        String strFx = com.bytedance.sdk.component.utils.u.fx(jSONObject.optString("message"));
                        if (TextUtils.isEmpty(strFx)) {
                            return;
                        }
                        nr.u().u(new JSONObject(strFx).optJSONArray("plugins"));
                    }
                } catch (JSONException unused) {
                }
            }

            @Override // com.bytedance.sdk.component.a.u.u
            public void u(b bVar, IOException iOException) {
                try {
                    Iterator<String> itKeys = n.o().wq().keys();
                    while (itKeys.hasNext()) {
                        nr.u().u(itKeys.next(), 1007);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private u() {
        super("PluginSettingsFetchTask");
    }
}
