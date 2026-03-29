package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.embedapplog.pn;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz {
    private AtomicBoolean fx;
    private String nr;
    private volatile String u;

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {
        static final iz u = new iz();
    }

    private void n() {
        final boolean zN = n.o().n();
        boolean zA = n.o().a();
        com.bytedance.embedapplog.u.u(zN && !zA);
        final boolean zT = n.o().t();
        com.bytedance.embedapplog.u.u(new com.bytedance.embedapplog.pn() { // from class: com.bytedance.sdk.openadsdk.core.iz.2
            @Override // com.bytedance.embedapplog.pn
            public void u(pn.u uVar) {
                if (uVar != null) {
                    com.bytedance.sdk.openadsdk.core.y.qq.u(uVar.u);
                }
                if (zT || !zN || iz.this.fx.get()) {
                    return;
                }
                iz.this.u(new com.bytedance.sdk.openadsdk.k.b(uVar));
            }
        });
        if (zA) {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.iz.3
                @Override // java.lang.Runnable
                public void run() {
                    iz.this.u(new com.bytedance.sdk.openadsdk.k.b(com.bytedance.sdk.openadsdk.core.y.qq.fx(com.bytedance.sdk.openadsdk.core.y.jk.fx(false))));
                }
            });
        } else {
            if (zT || !zN) {
                return;
            }
            com.bytedance.sdk.component.utils.jk.u().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.iz.4
                @Override // java.lang.Runnable
                public void run() {
                    if (iz.this.fx.get()) {
                        return;
                    }
                    iz.this.u(new com.bytedance.sdk.openadsdk.k.b(WkAdConfigModel.TAG_TIMEOUT));
                }
            }, 3000L);
        }
    }

    public String b() {
        if (TextUtils.isEmpty(this.nr)) {
            this.nr = com.bytedance.embedapplog.u.t();
        }
        return this.nr;
    }

    public String fx() {
        if (TextUtils.isEmpty(this.u)) {
            this.u = com.bytedance.embedapplog.u.a();
            com.bytedance.sdk.openadsdk.tools.nr.fx(16, this.u);
            com.bytedance.sdk.openadsdk.core.fx.b.u().l(this.u == null ? "" : this.u);
        }
        return this.u;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String iz() {
        return "164362";
    }

    public void nr() {
        com.bytedance.embedapplog.u.u(n.o().n());
        com.bytedance.embedapplog.u.u();
    }

    public String pn() {
        return (String) com.bytedance.embedapplog.u.u("sdk_version_name", "");
    }

    public String x() {
        return "unionser_slardar_applog";
    }

    private iz() {
        this.u = null;
        this.nr = null;
        this.fx = new AtomicBoolean(false);
        u(dw.getContext());
    }

    private void u(Context context) {
        final com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx = n.o().sx();
        com.bytedance.embedapplog.n nVar = new com.bytedance.embedapplog.n("164362", "unionser_slardar_applog");
        if (bVarSx != null) {
            boolean zFx = bVarSx.fx();
            nVar.b(zFx);
            if (!zFx) {
                nVar.nr(bVarSx.jk());
            }
            nVar.fx(bVarSx.b());
            if (d.fx >= 4600) {
                nVar.pn(bVarSx.iz());
                if (d.x() && d.fx >= 4900) {
                    nVar.u(bVarSx.s());
                }
            }
        }
        nVar.iz(!com.bytedance.sdk.openadsdk.core.b.u.fx());
        nVar.u(new com.bytedance.embedapplog.x() { // from class: com.bytedance.sdk.openadsdk.core.iz.1
            @Override // com.bytedance.embedapplog.x
            public boolean b() {
                return com.bytedance.sdk.openadsdk.core.y.my.u();
            }

            @Override // com.bytedance.embedapplog.x
            public boolean fx() {
                return dw.nr().oa();
            }

            @Override // com.bytedance.embedapplog.x
            public Looper iz() {
                return com.bytedance.sdk.component.utils.jk.u().getLooper();
            }

            @Override // com.bytedance.embedapplog.x
            public String nr() {
                return com.bytedance.sdk.openadsdk.core.y.jk.nr();
            }

            @Override // com.bytedance.embedapplog.x
            public Looper pn() {
                return com.bytedance.sdk.component.utils.jk.u().getLooper();
            }

            @Override // com.bytedance.embedapplog.x
            public String u() {
                com.bytedance.sdk.openadsdk.my.fx.fx.b bVar = bVarSx;
                if (bVar == null || bVar.b()) {
                    return com.bytedance.sdk.openadsdk.k.nr.u();
                }
                return null;
            }

            @Override // com.bytedance.embedapplog.x
            public String u(Context context2) {
                return com.bytedance.sdk.component.utils.bq.nr(context2);
            }

            @Override // com.bytedance.embedapplog.x
            public String u(String str) {
                return com.bytedance.sdk.openadsdk.core.y.gi.nr(str);
            }

            @Override // com.bytedance.embedapplog.x
            public JSONObject u(JSONObject jSONObject) {
                if (jSONObject != null) {
                    JSONArray jSONArrayPn = com.bytedance.sdk.openadsdk.core.y.sx.pn();
                    try {
                        if (jSONArrayPn.length() != 0) {
                            jSONObject.put("ipv6_list", jSONArrayPn);
                        }
                    } catch (Exception unused) {
                    }
                }
                return jSONObject;
            }

            @Override // com.bytedance.embedapplog.x
            public void u(String[] strArr, int[] iArr, boolean z) {
                com.bytedance.sdk.openadsdk.core.xw.u.u().u(iArr);
            }
        });
        nVar.nr(dw.nr().ja());
        nVar.u(true);
        nVar.nr(0);
        n();
        com.bytedance.embedapplog.u.u(context, nVar);
        HashMap map = new HashMap();
        String strC = n.o().c();
        map.put("host_appid", TextUtils.isEmpty(strC) ? "164362" : strC);
        map.put("is_plugin", Boolean.valueOf(d.u()));
        map.put("sdk_version", "7.2.3.2");
        map.put(PluginConstants.KEY_PLUGIN_VERSION, "7.2.3.2");
        map.put("sdk_api_version", d.b);
        map.put("channel", d.pn());
        if (dw.nr().kj()) {
            map.put("use_apm_sdk", "1");
        }
        com.bytedance.embedapplog.u.u((HashMap<String, Object>) map);
    }

    public static void nr(String str, JSONObject jSONObject) {
        com.bytedance.embedapplog.u.u(str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.openadsdk.k.b bVar) {
        this.fx.set(true);
        com.bytedance.sdk.openadsdk.core.y.qq.u(bVar);
    }

    public static iz u() {
        return u.u;
    }

    public void u(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        com.bytedance.embedapplog.u.nr(str, jSONObject);
    }
}
