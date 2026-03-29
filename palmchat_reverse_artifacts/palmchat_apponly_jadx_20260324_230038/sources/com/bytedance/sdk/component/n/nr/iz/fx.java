package com.bytedance.sdk.component.n.nr.iz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.wifi.adsdk.entity.LxEventReplace;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements nr {
    private com.bytedance.sdk.component.n.u.pn fx;
    private final pn nr;
    private final Context u;

    /* JADX INFO: compiled from: SearchBox */
    @SuppressLint({"StaticFieldLeak"})
    public class u extends com.bytedance.sdk.component.n.nr.pn.nr {
        private final Map<String, String> b;
        private final String fx;
        private final b nr;

        private String fx(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.contains("{TS}") || str.contains(LxEventReplace.__TS__)) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                str = str.replace("{TS}", String.valueOf(jCurrentTimeMillis)).replace(LxEventReplace.__TS__, String.valueOf(jCurrentTimeMillis));
            }
            return ((str.contains("{UID}") || str.contains("__UID__")) && !TextUtils.isEmpty(this.fx)) ? str.replace("{UID}", this.fx).replace("__UID__", this.fx) : str;
        }

        public String nr(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                return str.replace("[ss_random]", String.valueOf(fx.nr().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
            } catch (Exception unused) {
                return str;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.component.n.u.u.pn pnVarU;
            com.bytedance.sdk.component.n.u.b bVarB = fx.this.fx.b();
            if (bVarB == null || fx.this.fx.getContext() == null || !bVarB.pn()) {
                return;
            }
            if (!u(this.nr.fx())) {
                b bVar = this.nr;
                u(null, bVarB, bVar, bVar.fx(), "not http url");
                return;
            }
            if (this.nr.pn() == 0) {
                fx.this.nr.delete(this.nr);
                b bVar2 = this.nr;
                u(null, bVarB, bVar2, bVar2.fx(), "retry max");
                return;
            }
            try {
                if (this.nr.pn() == 5) {
                    fx.this.nr.insert(this.nr);
                }
                if (!bVarB.u(fx.this.getContext())) {
                    b bVar3 = this.nr;
                    u(null, bVarB, bVar3, bVar3.fx(), "no net");
                    return;
                }
                System.currentTimeMillis();
                String strFx = this.nr.fx();
                if (bVarB.n() == 0) {
                    strFx = fx(this.nr.fx());
                    if (this.nr.b()) {
                        strFx = nr(strFx);
                    }
                }
                String str = strFx;
                com.bytedance.sdk.component.n.u.u.nr nrVarL = bVarB.l();
                if (nrVarL == null) {
                    u(null, this.nr, str, "no executor");
                    return;
                }
                nrVarL.u("User-Agent", bVarB.t());
                nrVarL.u("csj_client_source_from", "1");
                if (this.b != null) {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.b.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                    nrVarL.u("csj_extra_info", jSONObject.toString());
                }
                nrVarL.u(str);
                try {
                    pnVarU = nrVarL.u();
                } catch (Throwable unused) {
                    pnVarU = null;
                }
                if (pnVarU == null || !pnVarU.u()) {
                    if (pnVarU != null && pnVarU.fx() == 8848) {
                        pnVarU.b();
                        fx.this.nr.delete(this.nr);
                    }
                    com.bytedance.sdk.component.n.u.pn unused2 = fx.this.fx;
                    this.nr.u(r0.pn() - 1);
                    if (this.nr.pn() == 0) {
                        fx.this.nr.delete(this.nr);
                        com.bytedance.sdk.component.n.u.pn unused3 = fx.this.fx;
                    } else {
                        fx.this.nr.update(this.nr);
                    }
                    if (pnVarU != null) {
                        pnVarU.b();
                        System.currentTimeMillis();
                    } else {
                        System.currentTimeMillis();
                    }
                } else {
                    fx.this.nr.delete(this.nr);
                    com.bytedance.sdk.component.n.u.pn unused4 = fx.this.fx;
                    System.currentTimeMillis();
                }
                u(pnVarU, bVarB, this.nr, str, null);
            } catch (Throwable unused5) {
            }
        }

        public boolean u(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("http://") || str.startsWith("https://");
        }

        private u(b bVar, String str, Map<String, String> map) {
            super("AdsStats");
            this.nr = bVar;
            this.fx = str;
            this.b = map;
        }

        private void u(com.bytedance.sdk.component.n.u.u.pn pnVar, com.bytedance.sdk.component.n.u.b bVar, b bVar2, String str, String str2) {
            try {
                bVar.u(this.nr.u(), u(pnVar, bVar2, str, str2));
            } catch (Exception unused) {
            }
        }

        private JSONObject u(com.bytedance.sdk.component.n.u.u.pn pnVar, b bVar, String str, String str2) {
            JSONObject jSONObject = new JSONObject();
            if (bVar == null) {
                return jSONObject;
            }
            try {
                jSONObject.put("retry_count", 5 - bVar.pn());
                JSONObject jSONObjectU = bVar.u();
                if (jSONObjectU != null) {
                    jSONObject.put("track_type", jSONObjectU.optString("track_type", ""));
                }
                jSONObject.put("url", str);
                jSONObject.put("current", System.currentTimeMillis());
                jSONObject.put("error_msg", str2);
                if (pnVar != null) {
                    jSONObject.put("http_code", pnVar.fx());
                    String strNr = pnVar.nr();
                    if (!TextUtils.isEmpty(strNr)) {
                        if (strNr.length() > 5000) {
                            strNr = strNr.substring(0, 5000);
                        }
                        jSONObject.put("http_response", strNr);
                    }
                    jSONObject.put("success", pnVar.u() ? 1 : 0);
                }
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    public fx(pn pnVar, com.bytedance.sdk.component.n.u.pn pnVar2) {
        this.u = pnVar2.getContext();
        this.nr = pnVar;
        this.fx = pnVar2;
    }

    public Context getContext() {
        Context context = this.u;
        return context == null ? this.fx.getContext() : context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Random nr() {
        if (Build.VERSION.SDK_INT < 26) {
            return new SecureRandom();
        }
        try {
            return SecureRandom.getInstanceStrong();
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }

    @Override // com.bytedance.sdk.component.n.nr.iz.nr
    public void u(String str, List<String> list, boolean z, Map<String, String> map, JSONObject jSONObject) {
        com.bytedance.sdk.component.n.u.b bVarB = this.fx.b();
        if (bVarB == null || this.fx.getContext() == null || bVarB.iz() == null || !bVarB.pn() || list == null || list.size() == 0) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            bVarB.iz().execute(new u(new b(UUID.randomUUID().toString() + "_" + System.currentTimeMillis(), it.next(), z, 5, jSONObject, 1), str, map));
        }
    }

    @Override // com.bytedance.sdk.component.n.nr.iz.nr
    public void u(final String str) {
        com.bytedance.sdk.component.n.u.b bVarB = this.fx.b();
        if (bVarB == null || this.fx.getContext() == null || !bVarB.pn()) {
            return;
        }
        com.bytedance.sdk.component.n.nr.pn.nr nrVar = new com.bytedance.sdk.component.n.nr.pn.nr("trackFailedUrls") { // from class: com.bytedance.sdk.component.n.nr.iz.fx.1
            @Override // java.lang.Runnable
            public void run() {
                fx.this.u(fx.this.nr.u(), str);
            }
        };
        nrVar.u(1);
        if (bVarB.iz() != null) {
            bVarB.iz().execute(nrVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(List<b> list, String str) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.bytedance.sdk.component.n.u.b bVarB = this.fx.b();
        for (b bVar : list) {
            if (bVarB != null && bVarB.iz() != null) {
                bVarB.iz().execute(new u(bVar, str, null));
            }
        }
    }
}
