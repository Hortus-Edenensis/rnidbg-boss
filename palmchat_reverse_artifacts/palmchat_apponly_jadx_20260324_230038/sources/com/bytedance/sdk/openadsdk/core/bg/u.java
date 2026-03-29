package com.bytedance.sdk.openadsdk.core.bg;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bq;
import com.bytedance.sdk.openadsdk.core.kj.iz;
import com.bytedance.sdk.openadsdk.core.kj.jw;
import com.bytedance.sdk.openadsdk.core.kj.my;
import com.bytedance.sdk.openadsdk.core.kj.pn;
import com.bytedance.sdk.openadsdk.core.kj.rh;
import com.bytedance.sdk.openadsdk.core.l.fx.jk;
import com.bytedance.sdk.openadsdk.core.l.n;
import com.bytedance.sdk.openadsdk.core.l.nr.b;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.huawei.openalliance.ad.constant.az;
import com.wifi.ad.core.config.EventParams;
import com.wifi.adsdk.download.LxAdDLManager;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements fx {
    private boolean fx;
    private com.bytedance.sdk.openadsdk.core.l.nr.u iz;
    private final nr nr;
    private final bc u;
    private final Map<String, com.bytedance.sdk.openadsdk.core.l.nr.b> b = new HashMap();
    private boolean pn = true;
    private boolean x = false;

    private u(nr nrVar, bc bcVar, boolean z) {
        this.nr = nrVar;
        this.u = bcVar;
        this.fx = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bg.fx
    public void fx() {
        nr();
        for (com.bytedance.sdk.openadsdk.core.l.nr.b bVar : this.b.values()) {
            if (bVar != null) {
                bVar.nr();
            }
        }
        this.b.clear();
    }

    public static u u(nr nrVar, bc bcVar, boolean z) {
        return new u(nrVar, bcVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bg.fx
    public void nr() {
        Iterator<com.bytedance.sdk.openadsdk.core.l.nr.b> it = this.b.values().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.bg.fx
    public void nr(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || this.nr == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.l.nr.b bVar = this.b.get(u(this.u, jSONObjectOptJSONObject, (String) null).pu().nr());
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.bg.fx
    public void u() {
        for (com.bytedance.sdk.openadsdk.core.l.nr.b bVar : this.b.values()) {
            if (bVar != null) {
                bVar.u();
            }
        }
    }

    public static bc u(bc bcVar, JSONObject jSONObject, String str) {
        String strOptString;
        boolean z;
        bc bcVarU;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        if (jSONObject != null) {
            strOptString = jSONObject.optString(WfConstant.EXTRA_KEY_DOWNLOAD_URL);
            z = true;
        } else {
            strOptString = "";
            z = false;
        }
        if (TextUtils.isEmpty(strOptString)) {
            z = false;
        }
        boolean z2 = (bcVar.pu() == null || bcVar.pu().nr() == null || !bcVar.pu().nr().equals(strOptString)) ? z : false;
        if (jSONObject != null && (jSONObjectOptJSONObject2 = jSONObject.optJSONObject("download_config_json")) != null && !jSONObjectOptJSONObject2.optBoolean("has_valid_download_url", true)) {
            z2 = true;
        }
        if (z2) {
            bcVarU = new bc();
            bcVarU.pn(bcVar.n());
            bcVarU.rh(bcVar.zn());
            bcVarU.h(bcVar.xh());
            bcVarU.rh(jSONObject.optInt("lp_down_rule"));
            bcVarU.pb(4);
            bcVarU.c(jSONObject.optString("id"));
            bcVarU.k(jSONObject.optString(az.at));
            pn pnVar = new pn();
            pnVar.b(jSONObject.optString("pkg_name"));
            pnVar.fx(jSONObject.optString("name"));
            pnVar.nr(strOptString);
            bcVarU.u(pnVar);
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("download_config_json");
            if (jSONObjectOptJSONObject3 != null) {
                bcVarU.u(new bq(jSONObjectOptJSONObject3));
                if (!jSONObjectOptJSONObject3.optBoolean("has_valid_download_url", true)) {
                    bcVarU.jk(true);
                }
            }
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("app_manage_json");
            if (jSONObjectOptJSONObject4 != null) {
                iz izVarHm = bcVarU.hm();
                if (izVarHm == null) {
                    izVarHm = new iz();
                }
                izVarHm.u(jSONObjectOptJSONObject4.optInt("score"));
                izVarHm.u(jSONObjectOptJSONObject4.optJSONArray("creative_tags"));
                bcVarU.u(izVarHm);
                bcVarU.s(jSONObjectOptJSONObject4.toString());
                rh rhVarDd = bcVarU.dd();
                if (rhVarDd == null) {
                    rhVarDd = new rh();
                }
                rhVarDd.u(jSONObjectOptJSONObject4.optString("icon_url"));
                bcVarU.u(rhVarDd);
                bcVarU.bq(jSONObjectOptJSONObject4.optString(LxAdDLManager.ITEM_DESC));
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("app_manage_type_json");
            if (jSONObjectOptJSONObject5 != null) {
                bcVarU.h(jSONObjectOptJSONObject5.optInt("app_manage_type"));
            }
            int iOptInt = jSONObject.optInt("live_interaction_type");
            String strOptString2 = jSONObject.optString("live_room_id");
            if (iOptInt > 0 && !TextUtils.isEmpty(strOptString2)) {
                bcVarU.nb(iOptInt);
                bcVarU.xg(strOptString2);
            }
            bcVarU.lf(jSONObject.optInt(EventParams.KEY_PARAM_ADTYPE));
            jw jwVarU = jw.u(jSONObject.optJSONObject("wc_miniapp_info"));
            if (jwVarU != null) {
                bcVarU.u(jwVarU);
            }
            String strOptString3 = jSONObject.optString("quick_app_url");
            if (!TextUtils.isEmpty(strOptString3)) {
                pn pnVarPu = bcVarU.pu() != null ? bcVarU.pu() : new pn();
                pnVarPu.u(strOptString3);
                bcVarU.u(pnVarPu);
            }
        } else {
            bcVarU = com.bytedance.sdk.openadsdk.core.u.u(bcVar.et());
        }
        if (!TextUtils.isEmpty(str)) {
            bcVarU.q(str);
        }
        if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject("deep_link")) != null) {
            my myVar = new my();
            if (bcVar.kv() != null) {
                myVar.u(bcVar.kv());
            }
            myVar.u(new my(jSONObjectOptJSONObject));
            bcVarU.u(myVar);
        }
        return bcVarU;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.bg.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0239u {
        private static ConcurrentHashMap<String, JSONObject> u = new ConcurrentHashMap<>();

        public static synchronized JSONObject u(String str) {
            if (TextUtils.isEmpty(str)) {
                return new JSONObject();
            }
            ConcurrentHashMap<String, JSONObject> concurrentHashMap = u;
            if (concurrentHashMap == null) {
                return new JSONObject();
            }
            JSONObject jSONObject = concurrentHashMap.get(str);
            if (jSONObject != null) {
                return jSONObject;
            }
            return new JSONObject();
        }

        public static synchronized void u(String str, int i, int i2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (u == null) {
                u = new ConcurrentHashMap<>();
            }
            JSONObject jSONObject = u.get(str);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
                u.put(str, jSONObject);
            }
            try {
                jSONObject.put("downloadStatus", i);
                jSONObject.put("downloadProcessRate", i2);
                jSONObject.put("code", 0);
                jSONObject.put("codeMsg", "get ad_down_load_id success");
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.bg.fx
    public void nr(boolean z) {
        this.x = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bg.fx
    public void u(Context context, JSONObject jSONObject, String str, int i, boolean z, boolean z2) {
        JSONObject jSONObjectOptJSONObject;
        if (context == null || jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        bc bcVarU = u(this.u, jSONObjectOptJSONObject, u(jSONObjectOptJSONObject, str));
        u(context, bcVarU, jSONObjectOptJSONObject, i, z ? jk.u(bcVarU) : 0, z2);
    }

    private void u(Context context, bc bcVar, JSONObject jSONObject, int i, int i2, boolean z) {
        if (context == null || bcVar == null || bcVar.pu() == null || jSONObject == null || this.nr == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.l.nr.b bVar = this.b.get(bcVar.pu().nr());
        if (bVar != null) {
            bVar.u(i2);
            return;
        }
        String strU = jp.u(i);
        if (TextUtils.isEmpty(strU)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.l.nr.b bVarU = u(context, bcVar, jSONObject, strU);
        bVarU.u(i2);
        if (bVarU instanceof com.bytedance.sdk.openadsdk.core.l.fx.b) {
            ((com.bytedance.sdk.openadsdk.core.l.fx.b) bVarU).iz(z);
        }
        this.b.put(bcVar.pu().nr(), bVarU);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bg.fx
    public void u(Context context, JSONObject jSONObject, String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        if (context == null || jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        u(context, u(this.u, jSONObjectOptJSONObject, u(jSONObjectOptJSONObject, str2)), str);
    }

    private String u(JSONObject jSONObject, String str) {
        String strOptString = jSONObject != null ? jSONObject.optString("ext") : null;
        return TextUtils.isEmpty(strOptString) ? str : strOptString;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void u(Context context, bc bcVar, String str) {
        if (context == 0 || bcVar == null) {
            return;
        }
        if (bcVar.pu() == null) {
            com.bytedance.sdk.openadsdk.core.l.nr.fx fxVarNr = n.nr(context, bcVar, str, false);
            if (fxVarNr instanceof com.bytedance.sdk.openadsdk.core.l.fx.pn) {
                ((com.bytedance.sdk.openadsdk.core.l.fx.pn) fxVarNr).iz(this.fx);
            }
            fxVarNr.u(bcVar, false);
        } else {
            final String strLk = bcVar.lk();
            com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = (com.bytedance.sdk.openadsdk.core.l.nr.b) this.b.get(bcVar.pu().nr());
            if (fxVar != null) {
                fxVar.fx(this.x);
                if (fxVar instanceof com.bytedance.sdk.openadsdk.core.l.fx.pn) {
                    ((com.bytedance.sdk.openadsdk.core.l.fx.pn) fxVar).n().u(this.pn);
                } else if (fxVar instanceof com.bytedance.sdk.openadsdk.core.l.fx.n) {
                    ((com.bytedance.sdk.openadsdk.core.l.fx.n) fxVar).iz().u(this.pn);
                }
                fxVar.u(bcVar, false);
                fxVar.u(new com.bytedance.sdk.openadsdk.core.l.nr.u() { // from class: com.bytedance.sdk.openadsdk.core.bg.u.1
                    @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
                    public void fx(long j, long j2, String str2, String str3) {
                        if (j > 0) {
                            C0239u.u(strLk, 4, (int) ((j2 * 100) / j));
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
                    public void nr(long j, long j2, String str2, String str3) {
                        if (j > 0) {
                            C0239u.u(strLk, 2, (int) ((j2 * 100) / j));
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
                    public void u() {
                        C0239u.u(strLk, 1, 0);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
                    public void u(long j, long j2, String str2, String str3) {
                        if (j > 0) {
                            C0239u.u(strLk, 3, (int) ((j2 * 100) / j));
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
                    public void u(long j, String str2, String str3) {
                        C0239u.u(strLk, 5, 100);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
                    public void u(String str2, String str3) {
                        C0239u.u(strLk, 6, 100);
                    }
                });
            }
        }
        if (context instanceof com.bytedance.sdk.openadsdk.core.n.nr) {
            ((com.bytedance.sdk.openadsdk.core.n.nr) context).u(1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.bg.fx
    public void u(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        u(u(this.u, jSONObjectOptJSONObject, (String) null), jSONObjectOptJSONObject);
    }

    private void u(bc bcVar, JSONObject jSONObject) {
        if (this.nr == null || bcVar == null || bcVar.pu() == null) {
            return;
        }
        String strNr = bcVar.pu().nr();
        if (this.b.containsKey(strNr)) {
            com.bytedance.sdk.openadsdk.core.l.nr.b bVarRemove = this.b.remove(strNr);
            if (bVarRemove != null) {
                try {
                    bVarRemove.nr();
                } catch (JSONException unused) {
                    return;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("message", "success");
            jSONObject2.put("status", "unsubscribed");
            jSONObject2.put("appad", jSONObject);
            this.nr.nr("app_ad_event", jSONObject2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.bg.fx
    public void u(boolean z) {
        this.pn = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bg.fx
    public void u(String str, boolean z) {
        com.bytedance.sdk.openadsdk.core.l.nr.b bVar;
        if (TextUtils.isEmpty(str) || (bVar = this.b.get(str)) == null) {
            return;
        }
        bVar.nr(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.bytedance.sdk.openadsdk.core.l.nr.b u(Context context, bc bcVar, final JSONObject jSONObject, String str) {
        com.bytedance.sdk.openadsdk.core.l.nr.b bVarNr = n.nr(context, bcVar, str, false);
        if (bVarNr instanceof com.bytedance.sdk.openadsdk.core.l.fx.pn) {
            ((com.bytedance.sdk.openadsdk.core.l.fx.pn) bVarNr).iz(this.fx);
        }
        bVarNr.u(new com.bytedance.sdk.openadsdk.core.l.nr.u() { // from class: com.bytedance.sdk.openadsdk.core.bg.u.2
            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void fx(long j, long j2, String str2, String str3) {
                u("status", "download_failed", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
                if (u.this.iz == null) {
                    return;
                }
                u.this.iz.fx(j, j2, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void nr(long j, long j2, String str2, String str3) {
                u("status", "download_paused", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
                if (u.this.iz == null) {
                    return;
                }
                u.this.iz.nr(j, j2, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void u() {
                u("status", "idle");
                if (u.this.iz == null) {
                    return;
                }
                u.this.iz.u();
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void u(long j, long j2, String str2, String str3) {
                u("status", "download_active", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
                if (u.this.iz == null) {
                    return;
                }
                u.this.iz.u(j, j2, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void u(long j, String str2, String str3) {
                u("status", "download_finished", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j));
                if (u.this.iz == null) {
                    return;
                }
                u.this.iz.u(j, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void u(String str2, String str3) {
                u("status", "installed");
                if (u.this.iz == null) {
                    return;
                }
                u.this.iz.u(str2, str3);
            }

            private void u(String... strArr) {
                if (strArr == null || strArr.length % 2 != 0) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("message", "success");
                    jSONObject2.put("appad", jSONObject);
                    for (int i = 0; i < strArr.length; i += 2) {
                        jSONObject2.put(strArr[i], strArr[i + 1]);
                    }
                    u.this.nr.nr("app_ad_event", jSONObject2);
                } catch (JSONException unused) {
                }
            }
        });
        bVarNr.u(new b.u() { // from class: com.bytedance.sdk.openadsdk.core.bg.u.3
        });
        return bVarNr;
    }
}
