package com.ss.android.downloadlib.addownload.compliance;

import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.downloadlib.x.mv;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10584a;
    private int b;
    private int fx;
    private int iz;
    private String jk;
    private String k;
    private String l;
    private String mv;
    private String n;
    private u nr;
    private int pn = 15;
    private nr s;
    private long t;
    private boolean u;
    private String x;

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        private String nr;
        private int u;

        public void u(int i) {
            this.u = i;
        }

        public void u(String str) {
            this.nr = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f10585a;
        private long b;
        private long fx;
        private String iz;
        private String jk;
        private String l;
        private String n;
        private String nr;
        private String pn;
        private String t;
        private String u;
        private List<C0842u> x;

        /* JADX INFO: renamed from: com.ss.android.downloadlib.addownload.compliance.pn$u$u, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0842u {
            private String nr;
            private String u;

            public void nr(String str) {
                this.nr = str;
            }

            public void u(String str) {
                this.u = str;
            }
        }

        public void a(String str) {
            this.l = str;
        }

        public void b(String str) {
            this.iz = str;
        }

        public void fx(String str) {
            this.pn = str;
        }

        public void iz(String str) {
            this.f10585a = str;
        }

        public void n(String str) {
            this.t = str;
        }

        public void nr(String str) {
            this.nr = str;
        }

        public void pn(String str) {
            this.n = str;
        }

        public void u(String str) {
            this.u = str;
        }

        public void x(String str) {
            this.jk = str;
        }

        public void nr(long j) {
            this.b = j;
        }

        public void u(long j) {
            this.fx = j;
        }

        public void u(List<C0842u> list) {
            this.x = list;
        }
    }

    public static pn x(String str) {
        pn pnVar = new pn();
        try {
            JSONObject jSONObject = new JSONObject(str);
            u uVarU = u(jSONObject);
            nr nrVarNr = nr(jSONObject);
            pnVar.u(uVarU);
            pnVar.u(nrVarNr);
            pnVar.u(jSONObject.optInt("show_auth", 0) == 1);
            pnVar.u(jSONObject.optInt("download_permit"));
            pnVar.nr(jSONObject.optInt("appstore_permit"));
            pnVar.fx(jSONObject.optInt("market_online_status", 15));
            pnVar.b(jSONObject.optInt("hijack_permit"));
            pnVar.u(jSONObject.optString("package_name"));
            pnVar.nr(jSONObject.optString("hijack_url"));
            pnVar.pn(jSONObject.optInt("code"));
            pnVar.fx(jSONObject.optString("message"));
            pnVar.u(jSONObject.optLong("request_duration", 0L));
            pnVar.b(jSONObject.optString("back_web_url"));
            pnVar.pn(jSONObject.optString("hw_app_id"));
            pnVar.iz(jSONObject.optString("deep_link"));
        } catch (Exception e) {
            com.ss.android.downloadlib.pn.fx.u().u(e, "ComplianceResult fromJson");
        }
        return pnVar;
    }

    public void b(int i) {
        this.iz = i;
    }

    public void fx(int i) {
        this.pn = i;
    }

    public void iz(String str) {
        this.mv = str;
    }

    public void nr(int i) {
        this.b = i;
    }

    public void pn(int i) {
        this.f10584a = i;
    }

    public String toString() {
        return u(this);
    }

    public void u(boolean z) {
        this.u = z;
    }

    public void b(String str) {
        this.k = str;
    }

    public void fx(String str) {
        this.jk = str;
    }

    public void nr(String str) {
        this.n = str;
    }

    public void pn(String str) {
        this.l = str;
    }

    public void u(u uVar) {
        this.nr = uVar;
    }

    private static JSONArray fx(u uVar) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        List<u.C0842u> list = uVar.x;
        if (list != null && list.size() > 0) {
            for (u.C0842u c0842u : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("permission_name", c0842u.u);
                jSONObject.putOpt("permission_desc", c0842u.nr);
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    public String nr() {
        return this.mv;
    }

    public void u(int i) {
        this.fx = i;
    }

    private static JSONObject nr(u uVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (uVar != null) {
            jSONObject.putOpt("app_name", uVar.u);
            jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, uVar.nr);
            jSONObject.putOpt("update_time", Long.valueOf(uVar.fx));
            jSONObject.putOpt("size", Long.valueOf(uVar.b));
            jSONObject.putOpt(WfConstant.EXTRA_KEY_DEVELOPER_NAME, uVar.pn);
            jSONObject.putOpt("policy_url", uVar.f10585a);
            jSONObject.putOpt("icon_url", uVar.jk);
            jSONObject.putOpt(WfConstant.EXTRA_KEY_DOWNLOAD_URL, uVar.t);
            jSONObject.putOpt("permissions", fx(uVar));
            jSONObject.putOpt("permission_classify_url", uVar.n);
            jSONObject.putOpt("desc_url", uVar.l);
        }
        return jSONObject;
    }

    public void u(String str) {
        this.x = str;
    }

    public int u() {
        return this.f10584a;
    }

    public void u(long j) {
        this.t = j;
    }

    public void u(nr nrVar) {
        this.s = nrVar;
    }

    public static String u(pn pnVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_auth", Integer.valueOf(pnVar.u ? 1 : 0));
            jSONObject.putOpt("download_permit", Integer.valueOf(pnVar.fx));
            jSONObject.putOpt("appstore_permit", Integer.valueOf(pnVar.b));
            jSONObject.putOpt("market_online_status", Integer.valueOf(pnVar.pn));
            jSONObject.putOpt("hijack_permit", Integer.valueOf(pnVar.iz));
            jSONObject.putOpt("package_name", pnVar.x);
            jSONObject.putOpt("hijack_url", pnVar.n);
            jSONObject.putOpt("code", Integer.valueOf(pnVar.f10584a));
            jSONObject.putOpt("message", pnVar.jk);
            jSONObject.putOpt("request_duration", Long.valueOf(pnVar.t));
            jSONObject.putOpt("auth_info", nr(pnVar.nr));
            jSONObject.putOpt("status", nr(pnVar.s));
            jSONObject.putOpt("back_web_url", pnVar.k);
            jSONObject.putOpt("hw_app_id", pnVar.l);
            jSONObject.putOpt("deep_link", pnVar.mv);
        } catch (JSONException e) {
            com.ss.android.downloadlib.pn.fx.u().u(e, "ComplianceResult toJson");
        }
        return jSONObject.toString();
    }

    private static nr nr(JSONObject jSONObject) {
        nr nrVar = new nr();
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("status");
            if (jSONObjectOptJSONObject != null) {
                nrVar.u(jSONObjectOptJSONObject.optInt("status"));
                nrVar.u(jSONObjectOptJSONObject.optString("message"));
            }
        } catch (Exception e) {
            com.ss.android.downloadlib.pn.fx.u().u(e, "ComplianceResult getStatus");
        }
        return nrVar;
    }

    private static JSONObject nr(nr nrVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (nrVar != null) {
            jSONObject.putOpt("status", Integer.valueOf(nrVar.u));
            jSONObject.putOpt("message", nrVar.nr);
        }
        return jSONObject;
    }

    private static u u(JSONObject jSONObject) {
        u uVar = new u();
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("auth_info");
            if (jSONObjectOptJSONObject != null) {
                uVar.u(jSONObjectOptJSONObject.optString("app_name"));
                uVar.nr(jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
                uVar.u(mv.u(jSONObjectOptJSONObject, "update_time"));
                uVar.nr(mv.u(jSONObjectOptJSONObject, "size"));
                uVar.fx(jSONObjectOptJSONObject.optString(WfConstant.EXTRA_KEY_DEVELOPER_NAME));
                uVar.b(jSONObjectOptJSONObject.optString("package_name"));
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions");
                if (jSONArrayOptJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    u(jSONArrayOptJSONArray, arrayList);
                    uVar.u(arrayList);
                }
                uVar.pn(jSONObjectOptJSONObject.optString("permission_classify_url"));
                uVar.iz(jSONObjectOptJSONObject.optString("policy_url"));
                uVar.x(jSONObjectOptJSONObject.optString("icon_url"));
                uVar.n(jSONObjectOptJSONObject.optString(WfConstant.EXTRA_KEY_DOWNLOAD_URL));
                uVar.a(jSONObjectOptJSONObject.optString("desc_url"));
            }
        } catch (Exception e) {
            com.ss.android.downloadlib.pn.fx.u().u(e, "ComplianceResult getAuthInfo");
        }
        return uVar;
    }

    private static void u(JSONArray jSONArray, List<u.C0842u> list) {
        if (jSONArray == null || list == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                u.C0842u c0842u = new u.C0842u();
                c0842u.u(jSONObjectOptJSONObject.optString("permission_name"));
                c0842u.nr(jSONObjectOptJSONObject.optString("permission_desc"));
                list.add(c0842u);
            }
        }
    }
}
