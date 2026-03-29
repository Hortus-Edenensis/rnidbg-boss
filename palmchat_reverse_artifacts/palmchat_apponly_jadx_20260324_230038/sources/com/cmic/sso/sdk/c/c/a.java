package com.cmic.sso.sdk.c.c;

import android.os.SystemClock;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.b;
import com.cmic.sso.sdk.c.b.e;
import com.cmic.sso.sdk.c.b.f;
import com.cmic.sso.sdk.c.b.h;
import com.cmic.sso.sdk.e.i;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.m;
import com.cmic.sso.sdk.e.o;
import com.cmic.sso.sdk.e.q;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.wifi.adsdk.download.LxAdDLManager;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f5508a;

    private a() {
    }

    public static a a() {
        if (f5508a == null) {
            synchronized (a.class) {
                if (f5508a == null) {
                    f5508a = new a();
                }
            }
        }
        return f5508a;
    }

    public void a(boolean z, com.cmic.sso.sdk.a aVar, d dVar) {
        com.cmic.sso.sdk.c.b.b bVar = new com.cmic.sso.sdk.c.b.b();
        bVar.b("1.0");
        bVar.c(AnalyticsConstants.SDK_TYPE);
        bVar.d(k.b("AID", ""));
        bVar.e(z ? "1" : "0");
        bVar.f(AuthnHelper.SDK_VERSION);
        bVar.g(aVar.b("appid"));
        bVar.h(bVar.v("iYm0HAnkxQtpvN44"));
        a(new c("https://" + aVar.b().c() + "/client/uniConfig", bVar, "POST", aVar.b("traceId")), dVar, aVar);
    }

    public void a(com.cmic.sso.sdk.a aVar, d dVar) {
        c cVar;
        String strA;
        int iC = aVar.c("networktype");
        h hVar = new h();
        hVar.b("1.0");
        hVar.c(AuthnHelper.SDK_VERSION);
        hVar.d(aVar.b("appid"));
        hVar.e(aVar.b("operatortype"));
        hVar.f(iC + "");
        hVar.g(m.a());
        hVar.h(m.b());
        hVar.i(m.c());
        hVar.j("0");
        hVar.k("3.0");
        hVar.l(q.b());
        hVar.m(o.a());
        hVar.o(aVar.b("apppackage"));
        hVar.p(aVar.b("appsign"));
        hVar.a(k.b("AID", ""));
        if (aVar.c("logintype") != 3 && !aVar.b("isRisk", false)) {
            hVar.x(aVar.b("userCapaid"));
            if (aVar.c("logintype") == 1) {
                hVar.x("200");
            } else {
                hVar.x("50");
            }
            hVar.s("authz");
        } else {
            hVar.s("pre");
        }
        q.a(aVar, "scripAndTokenForHttps");
        com.cmic.sso.sdk.a.a aVarB = aVar.b();
        if (!aVar.b("isCacheScrip", false) && !aVar.b("isGotScrip", false)) {
            e eVar = new e();
            eVar.a(aVar.a(b.a.f5487a));
            eVar.b(aVar.a(b.a.b));
            eVar.a(hVar);
            eVar.a(false);
            aVar.a("isCloseIpv4", aVarB.h());
            aVar.a("isCloseIpv6", aVarB.i());
            String str = "https://" + aVarB.b() + "/unisdk/rs/scripAndTokenForHttps";
            if (aVar.b("use2048PublicKey", false)) {
                com.cmic.sso.sdk.e.c.a("BaseRequest", "使用2对应的编码");
                eVar.b("2");
                strA = i.a().b(aVar.a(b.a.f5487a));
            } else {
                strA = i.a().a(aVar.a(b.a.f5487a));
            }
            eVar.c(strA);
            cVar = new b(str, eVar, "POST", aVar.b("traceId"));
            cVar.a("defendEOF", "1");
            if (iC == 3) {
                cVar.a(true);
                aVar.a("doNetworkSwitch", true);
            } else {
                cVar.a(false);
                aVar.a("doNetworkSwitch", false);
            }
        } else {
            hVar.w(aVar.b("phonescrip"));
            hVar.n(hVar.v(aVar.b("appkey")));
            cVar = new c("https://" + aVarB.a() + "/unisdk/rs/scripAndTokenForHttps", hVar, "POST", aVar.b("traceId"));
            cVar.a("defendEOF", "0");
        }
        cVar.a("interfaceVersion", "3.0");
        a(cVar, dVar, aVar);
    }

    public void a(JSONObject jSONObject, com.cmic.sso.sdk.a aVar, d dVar) {
        f fVar = new f();
        f.a aVar2 = new f.a();
        f.b bVar = new f.b();
        bVar.e(q.b());
        bVar.f(o.a());
        bVar.b("2.0");
        bVar.c(aVar.b("appid", ""));
        bVar.d(bVar.v(""));
        aVar2.a(jSONObject);
        fVar.a(aVar2);
        fVar.a(bVar);
        a(new c("https://" + aVar.b().d() + "/log/logReport", fVar, "POST", aVar.b("traceId")), dVar, aVar);
    }

    private void a(final c cVar, final d dVar, final com.cmic.sso.sdk.a aVar) {
        com.cmic.sso.sdk.c.a.d dVar2 = new com.cmic.sso.sdk.c.a.d();
        com.cmic.sso.sdk.c.a.c cVar2 = new com.cmic.sso.sdk.c.a.c();
        com.cmic.sso.sdk.c.a.a aVar2 = new com.cmic.sso.sdk.c.a.a();
        dVar2.a(cVar2);
        cVar2.a(aVar2);
        cVar.a(SystemClock.elapsedRealtime());
        dVar2.a(cVar, new com.cmic.sso.sdk.c.d.c() { // from class: com.cmic.sso.sdk.c.c.a.1
            @Override // com.cmic.sso.sdk.c.d.c
            public void a(com.cmic.sso.sdk.c.d.b bVar) {
                if (cVar.g()) {
                    try {
                        a();
                        JSONObject jSONObject = new JSONObject(bVar.c());
                        String string = jSONObject.has("resultcode") ? jSONObject.getString("resultcode") : jSONObject.getString("resultCode");
                        q.b(aVar, string);
                        dVar.a(string, jSONObject.optString(LxAdDLManager.ITEM_DESC), jSONObject);
                    } catch (Exception e) {
                        e.printStackTrace();
                        a(com.cmic.sso.sdk.c.d.a.a(102223));
                    }
                }
            }

            @Override // com.cmic.sso.sdk.c.d.c
            public void a(com.cmic.sso.sdk.c.d.a aVar3) {
                if (cVar.g()) {
                    a();
                    q.b(aVar, String.valueOf(aVar3.a()));
                    dVar.a(String.valueOf(aVar3.a()), aVar3.b(), com.cmic.sso.sdk.auth.c.a(String.valueOf(aVar3.a()), aVar3.b()));
                }
            }

            private void a() {
                if (cVar.a().contains("uniConfig")) {
                    return;
                }
                q.c(aVar, String.valueOf(SystemClock.elapsedRealtime() - cVar.i()));
            }
        }, aVar);
    }
}
