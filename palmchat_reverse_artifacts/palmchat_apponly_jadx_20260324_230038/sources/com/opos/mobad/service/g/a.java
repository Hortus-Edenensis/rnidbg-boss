package com.opos.mobad.service.g;

import android.content.Context;
import android.text.TextUtils;
import com.lantern.auth.server.WkParams;
import com.opos.acs.st.STManager;
import com.opos.cmn.i.o;
import com.opos.mobad.provider.statistic.StatisticModelIdentify;
import com.opos.mobad.service.c.a;
import com.opos.mobad.service.g.f;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9239a;
    private String b;
    private int c;
    private int d;
    private String e;
    private com.opos.mobad.provider.statistic.a f;
    private com.opos.mobad.provider.record.a g;
    private long h = 0;

    private static String b(String str) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(o.a(str));
        }
        String string = sb.toString();
        return TextUtils.isEmpty(string) ? "" : o.a(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appId", this.b);
        jSONObject.put("phBrand", com.opos.cmn.an.c.a.a(this.f9239a));
        jSONObject.put("phMaker", com.opos.cmn.an.c.c.e());
        jSONObject.put("aid", com.opos.mobad.service.d.b.a().getAndroidId());
        jSONObject.put("ua", com.opos.cmn.i.e.a());
        jSONObject.put("coverVc", this.d);
        jSONObject.put("extInfo", !TextUtils.isEmpty(this.e) ? this.e : "");
        jSONObject.put("classifyByAge", b());
        jSONObject.put("ouId", com.opos.mobad.service.c.a.a().h());
        jSONObject.put("duId", com.opos.mobad.service.c.a.a().i());
        jSONObject.put("ouidStatus", com.opos.mobad.service.c.a.a().l() ? "1" : "0");
        jSONObject.put("appOuidStatus", com.opos.mobad.service.c.a.a().f() ? "1" : "0");
        a.C0768a c0768aM = com.opos.mobad.service.c.a.a().m();
        if (c0768aM != null) {
            jSONObject.put(WkParams.IMEI, c0768aM.f9210a);
            jSONObject.put("imeiType", String.valueOf(1));
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                jSONObject.put(STManager.KEY_DATA_TYPE, str);
                jSONObject.put("oriDatatype", str);
            } catch (JSONException e) {
                com.opos.cmn.an.f.a.a("StatisticManager", "fillDataType", (Throwable) e);
            }
        }
    }

    public abstract String a();

    public abstract String b();

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                jSONObject.put(STManager.KEY_AD_POS_ID, str);
                jSONObject.put("newPosId", str);
            } catch (JSONException e) {
                com.opos.cmn.an.f.a.a("StatisticManager", "fillSdkPosId", (Throwable) e);
            }
        }
    }

    public f.a c() {
        JSONObject jSONObjectD;
        try {
            jSONObjectD = d();
            try {
                jSONObjectD.put("uSdkVC", this.c + "");
                jSONObjectD.put("pkgName", this.f9239a.getPackageName());
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            jSONObjectD = null;
        }
        return new f.a(this, jSONObjectD);
    }

    public static JSONObject a(JSONObject jSONObject, Map<String, String> map) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (map == null) {
            return jSONObject;
        }
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("StatisticManager", "mapToJson", (Throwable) e);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                jSONObject.put("sdkReqId", str != null ? str : "");
                if (str == null) {
                    str = "";
                }
                jSONObject.put("reqId", str);
            } catch (JSONException e) {
                com.opos.cmn.an.f.a.a("StatisticManager", "fillSdkReqId", (Throwable) e);
            }
        }
    }

    public void b(String str, String str2, int i, long j, String str3, long j2, String str4) {
        a(str, "sdk_serial", str2, i, j, str3, j2, str4);
    }

    public void a(Context context, String str, int i, int i2) {
        this.f9239a = context;
        this.b = str;
        this.c = i;
        this.d = i2;
        this.f = new com.opos.mobad.provider.statistic.a(context, new StatisticModelIdentify(i + "", com.opos.cmn.a.a.a(), com.opos.cmn.a.a.b()));
        this.g = new com.opos.mobad.provider.record.a(context);
    }

    public void b(String str, String str2, int i, long j, String str3, String str4, long j2, String str5) {
        a(str, str4, str2, i, j, str3, j2, str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("uSdkVC", this.c + "");
                jSONObject.put("bizSdkVer", this.c + "");
            } catch (JSONException e) {
                com.opos.cmn.an.f.a.a("StatisticManager", "fillSdk", (Throwable) e);
            }
        }
    }

    public void a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("StatisticManager", "report null");
            return;
        }
        try {
            JSONObject jSONObjectD = d();
            jSONObjectD.put(STManager.KEY_DATA_TYPE, "lm-count");
            jSONObjectD.put(STManager.KEY_AD_POS_ID, str);
            jSONObjectD.put("event", "1:1");
            jSONObjectD.put("uCount", String.valueOf(i));
            jSONObjectD.put("uSdkVC", this.c + "");
            a(jSONObjectD);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "reportAdFilterCount:", e);
        }
    }

    public void a(String str, String str2) {
        try {
            JSONObject jSONObjectD = d();
            e(jSONObjectD, "lm-reward");
            jSONObjectD.put("uSdkVC", this.c + "");
            jSONObjectD.put(STManager.KEY_AD_POS_ID, str);
            jSONObjectD.put("sdkReqId", str2);
            jSONObjectD.put("rewardSource", 2);
            a(jSONObjectD);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "reportUserRewarded", e);
        }
    }

    public void a(String str, String str2, int i, int i2) {
        try {
            JSONObject jSONObjectD = d();
            e(jSONObjectD, "lm-bid-call");
            jSONObjectD.put(STManager.KEY_AD_POS_ID, str);
            jSONObjectD.put("appId", this.b);
            jSONObjectD.put("uSdkVC", this.c + "");
            jSONObjectD.put("accType", 1);
            jSONObjectD.put("sdkReqId", str2);
            jSONObjectD.put("bidResult", -1);
            jSONObjectD.put("returnPrice", i);
            jSONObjectD.put("adSource", i2);
            a(jSONObjectD);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "reportGetEcpm", e);
        }
    }

    public void a(String str, String str2, int i, int i2, int i3) {
        try {
            JSONObject jSONObjectD = d();
            e(jSONObjectD, "lm-bid-call");
            jSONObjectD.put(STManager.KEY_AD_POS_ID, str);
            jSONObjectD.put("appId", this.b);
            jSONObjectD.put("uSdkVC", this.c + "");
            jSONObjectD.put("accType", 1);
            jSONObjectD.put("sdkReqId", str2);
            jSONObjectD.put("bidResult", 0);
            jSONObjectD.put("returnPrice", i2);
            jSONObjectD.put("sspWinPrice", i3);
            jSONObjectD.put("adSource", i);
            a(jSONObjectD);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "reportBiddingSucc", e);
        }
    }

    public void a(String str, String str2, int i, long j, String str3, long j2, String str4) {
        try {
            JSONObject jSONObjectD = d();
            jSONObjectD.put(STManager.KEY_DATA_TYPE, "lm-show");
            jSONObjectD.put(STManager.KEY_AD_POS_ID, str);
            jSONObjectD.put("rt", j);
            jSONObjectD.put("adSource", "sdk_serial");
            jSONObjectD.put("uSdkVC", this.c + "");
            jSONObjectD.put("hitSource", i);
            if (str3 == null) {
                str3 = "";
            }
            jSONObjectD.put("process", a(str3));
            if (str2 == null) {
                str2 = "";
            }
            jSONObjectD.put("sdkReqId", str2);
            jSONObjectD.put("ret", "1");
            jSONObjectD.put("stgVC", j2);
            jSONObjectD.put("cTransport", b(str4));
            a(jSONObjectD);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "error:", e);
        }
    }

    public void a(String str, String str2, int i, long j, String str3, String str4, long j2, String str5) {
        try {
            JSONObject jSONObjectD = d();
            jSONObjectD.put(STManager.KEY_DATA_TYPE, "lm-show");
            jSONObjectD.put(STManager.KEY_AD_POS_ID, str);
            jSONObjectD.put("rt", j);
            jSONObjectD.put("adSource", str4);
            jSONObjectD.put("hitSource", i);
            jSONObjectD.put("uSdkVC", this.c + "");
            if (str3 == null) {
                str3 = "";
            }
            jSONObjectD.put("process", a(str3));
            if (str2 == null) {
                str2 = "";
            }
            jSONObjectD.put("sdkReqId", str2);
            jSONObjectD.put("ret", "1");
            jSONObjectD.put("stgVC", j2);
            jSONObjectD.put("cTransport", b(str5));
            a(jSONObjectD);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "error:", e);
        }
    }

    public void a(String str, String str2, int i, String str3, int i2, int i3, int i4) {
        try {
            JSONObject jSONObjectD = d();
            e(jSONObjectD, "lm-bid-call");
            jSONObjectD.put(STManager.KEY_AD_POS_ID, str);
            jSONObjectD.put("appId", this.b);
            jSONObjectD.put("uSdkVC", this.c + "");
            jSONObjectD.put("accType", 1);
            jSONObjectD.put("sdkReqId", str2);
            jSONObjectD.put("bidResult", i);
            jSONObjectD.put("returnPrice", i3);
            jSONObjectD.put("adSource", i2);
            a(jSONObjectD);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "reportBiddingFail", e);
        }
    }

    private void a(String str, String str2, String str3, int i, long j, String str4, long j2, String str5) {
        try {
            JSONObject jSONObjectD = d();
            jSONObjectD.put(STManager.KEY_DATA_TYPE, "lm-show");
            jSONObjectD.put(STManager.KEY_AD_POS_ID, str);
            jSONObjectD.put("rt", j);
            jSONObjectD.put("adSource", str2);
            jSONObjectD.put("uSdkVC", this.c + "");
            if (str3 == null) {
                str3 = "";
            }
            jSONObjectD.put("sdkReqId", str3);
            jSONObjectD.put("ret", "2");
            jSONObjectD.put("rsCode", "" + i);
            if (str4 == null) {
                str4 = "";
            }
            jSONObjectD.put("process", a(str4));
            jSONObjectD.put("stgVC", j2);
            jSONObjectD.put("cTransport", b(str5));
            a(jSONObjectD);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "error:", e);
        }
    }

    public void a(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.g.a.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObjectD = a.this.d();
                    a.this.e(jSONObjectD, "lm-vip-callback");
                    a.d(jSONObjectD, str);
                    jSONObjectD.put("adSource", str3);
                    jSONObjectD.put("adId", str2);
                    jSONObjectD.put("pTraceId", str4);
                    jSONObjectD.put("platformPkg", a.this.f9239a.getPackageName());
                    a.c(jSONObjectD, str5);
                    a.this.b(jSONObjectD);
                    jSONObjectD.put("token", str7);
                    com.opos.cmn.an.f.a.b("StatisticManager", "recordVIP map=", jSONObjectD);
                    a.this.f.a(str6, jSONObjectD.toString());
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("StatisticManager", "recordVIP", (Throwable) e);
                }
            }
        });
    }

    public void a(String str, Map<String, String> map) {
        try {
            JSONObject jSONObjectD = d();
            jSONObjectD.put(STManager.KEY_DATA_TYPE, str);
            b(jSONObjectD);
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry != null) {
                        jSONObjectD.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            a(jSONObjectD);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "report fail", e);
        }
    }

    public void a(final Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.g.a.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObjectD = a.this.d();
                    a.this.e(jSONObjectD, "lm-show");
                    a.this.b(jSONObjectD);
                    jSONObjectD.put("ret", "6");
                    a.a(jSONObjectD, (Map<String, String>) map);
                    a.this.a(jSONObjectD);
                    com.opos.cmn.an.f.a.b("StatisticManager", "reportAdShow() json=", jSONObjectD);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.d("StatisticManager", "reportAdShow() fail", e);
                }
            }
        });
    }

    public void a(final JSONObject jSONObject) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.g.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f == null) {
                    com.opos.cmn.an.f.a.b("StatisticManager", "do but client null");
                    return;
                }
                try {
                    a.this.f.a(a.this.a(), jSONObject.toString());
                } catch (Exception unused) {
                    com.opos.cmn.an.f.a.b("StatisticManager", "do fail");
                }
            }
        });
    }

    public void a(boolean z, long j, String str) {
        try {
            JSONObject jSONObjectD = d();
            e(jSONObjectD, "lm-fetch");
            jSONObjectD.put("uSdkVC", this.c + "");
            jSONObjectD.put("type", "3");
            jSONObjectD.put("rsCode", z ? "1" : "0");
            jSONObjectD.put("rt", String.valueOf(j));
            if (str == null) {
                str = "";
            }
            jSONObjectD.put("st", str);
            a(jSONObjectD);
            com.opos.cmn.an.f.a.b("StatisticManager", "reportInitSdkResult json=", jSONObjectD);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("StatisticManager", "reportInitSdkResult", e);
        }
    }
}
