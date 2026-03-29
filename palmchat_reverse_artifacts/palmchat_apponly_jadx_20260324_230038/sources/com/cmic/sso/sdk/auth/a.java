package com.cmic.sso.sdk.auth;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.cmic.sso.sdk.b;
import com.cmic.sso.sdk.c.c.d;
import com.cmic.sso.sdk.e.h;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.l;
import com.huawei.hms.ads.ex;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    @SuppressLint({"StaticFieldLeak"})
    private static a c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.cmic.sso.sdk.c.c.a f5484a = com.cmic.sso.sdk.c.c.a.a();
    private final Context b;

    private a(Context context) {
        this.b = context.getApplicationContext();
    }

    private void b(final com.cmic.sso.sdk.a aVar, final b bVar) {
        com.cmic.sso.sdk.e.c.b("AuthnBusiness", "getScripAndToken start");
        boolean zB = aVar.b("isGotScrip", false);
        com.cmic.sso.sdk.e.c.b("AuthnBusiness", "isGotScrip = " + zB);
        if (!zB) {
            a(aVar);
            if (!aVar.b("isCacheScrip", false)) {
                b(aVar);
                if (aVar.c("networktype") == 3 && aVar.c("logintype") != 3) {
                    aVar.a("isRisk", true);
                }
            }
            if (aVar.c("logintype") == 1) {
                aVar.a("userCapaid", "200");
            } else if (aVar.c("logintype") == 0) {
                aVar.a("userCapaid", "50");
            }
        }
        this.f5484a.a(aVar, new d() { // from class: com.cmic.sso.sdk.auth.a.1
            @Override // com.cmic.sso.sdk.c.c.d
            public void a(String str, String str2, JSONObject jSONObject) {
                a.this.a(aVar, bVar, str, str2, jSONObject);
            }
        });
    }

    public static a a(Context context) {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a(context);
                }
            }
        }
        return c;
    }

    public void a(com.cmic.sso.sdk.a aVar, b bVar) {
        com.cmic.sso.sdk.e.c.b("AuthnBusiness", "LoginCheck method start");
        int iC = aVar.c("logintype");
        if (aVar.b("isCacheScrip", false)) {
            String strB = aVar.b("securityphone", "");
            if (iC == 3) {
                bVar.a("103000", ex.Code, aVar, c.a(strB));
                return;
            } else {
                b(aVar, bVar);
                return;
            }
        }
        b(aVar, bVar);
    }

    private void b(com.cmic.sso.sdk.a aVar) {
        byte[] bytes = new byte[0];
        if (aVar.b("use2048PublicKey", false)) {
            com.cmic.sso.sdk.e.c.a("AuthnBusiness", "使用2048公钥对应的对称秘钥生成方式");
            bytes = com.cmic.sso.sdk.e.a.a();
        } else {
            com.cmic.sso.sdk.e.c.a("AuthnBusiness", "使用1024公钥对应的对称秘钥生成方式");
            try {
                bytes = UUID.randomUUID().toString().substring(0, 16).getBytes("utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        byte[] bArrA = com.cmic.sso.sdk.e.a.a();
        aVar.a(b.a.f5487a, bytes);
        aVar.a(b.a.b, bArrA);
        aVar.a("authType", "3");
    }

    private void a(com.cmic.sso.sdk.a aVar) {
        String packageName = this.b.getPackageName();
        String strA = com.cmic.sso.sdk.e.d.a(l.a(this.b, packageName));
        aVar.a("apppackage", packageName);
        aVar.a("appsign", strA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.cmic.sso.sdk.a aVar, b bVar, String str, String str2, JSONObject jSONObject) {
        String strB;
        JSONException jSONException;
        String str3;
        String strOptString;
        String strOptString2;
        JSONObject jSONObject2;
        if ("103000".equals(str)) {
            String strOptString3 = jSONObject.optString("resultdata");
            if (TextUtils.isEmpty(strOptString3)) {
                strB = jSONObject.toString();
            } else {
                strB = com.cmic.sso.sdk.e.a.b(aVar.a(b.a.f5487a), strOptString3, aVar.a(b.a.b));
            }
            JSONObject jSONObject3 = null;
            String strOptString4 = null;
            try {
                jSONObject2 = new JSONObject(strB);
                try {
                    strOptString = jSONObject2.optString("phonescrip");
                    try {
                        strOptString2 = jSONObject2.optString("securityphone");
                        try {
                            strOptString4 = jSONObject2.optString("openId");
                            if (TextUtils.isEmpty(strOptString4)) {
                                strOptString4 = jSONObject2.optString("pcid");
                            }
                            k.a("securityphone", strOptString2);
                        } catch (JSONException e) {
                            jSONException = e;
                            str3 = strOptString4;
                            jSONObject3 = jSONObject2;
                            jSONException.printStackTrace();
                            jSONObject2 = jSONObject3;
                            strOptString4 = str3;
                        }
                    } catch (JSONException e2) {
                        e = e2;
                        strOptString2 = null;
                        jSONObject3 = jSONObject2;
                        jSONException = e;
                        str3 = strOptString2;
                        jSONException.printStackTrace();
                        jSONObject2 = jSONObject3;
                        strOptString4 = str3;
                        String str4 = strOptString2;
                        String str5 = strOptString;
                        com.cmic.sso.sdk.e.c.b("AuthnBusiness", "securityPhone  = " + str4);
                        aVar.a("openId", strOptString4);
                        aVar.a("phonescrip", str5);
                        aVar.a("securityphone", str4);
                        if (jSONObject2 == null) {
                        }
                    }
                } catch (JSONException e3) {
                    e = e3;
                    strOptString = null;
                    strOptString2 = null;
                }
            } catch (JSONException e4) {
                jSONException = e4;
                str3 = null;
                strOptString = null;
                strOptString2 = null;
            }
            String str42 = strOptString2;
            String str52 = strOptString;
            com.cmic.sso.sdk.e.c.b("AuthnBusiness", "securityPhone  = " + str42);
            aVar.a("openId", strOptString4);
            aVar.a("phonescrip", str52);
            aVar.a("securityphone", str42);
            if (jSONObject2 == null) {
                if (!aVar.b("isRisk", false)) {
                    h.a(this.b, str52, Long.parseLong(jSONObject2.optString("scripExpiresIn", "0")), aVar.b("scripKey", ""), aVar.b("scripType", ""));
                }
                if (aVar.c("logintype") == 3) {
                    bVar.a(str, ex.Code, aVar, c.a(str42));
                    return;
                } else {
                    if (aVar.b("isRisk", false)) {
                        aVar.a("isRisk", false);
                        aVar.a("isGotScrip", true);
                        b(aVar, bVar);
                        return;
                    }
                    bVar.a(str, str2, aVar, jSONObject2);
                    return;
                }
            }
            com.cmic.sso.sdk.e.c.a("AuthnBusiness", "返回103000，但是数据解析出错");
            bVar.a(String.valueOf(102223), "数据解析异常", aVar, c.a(String.valueOf(102223), "数据解析异常"));
            return;
        }
        if (aVar.c("logintype") == 3) {
            bVar.a(str, ex.Code, aVar, c.b(str, str2));
        } else {
            bVar.a(str, str2, aVar, jSONObject);
        }
    }
}
