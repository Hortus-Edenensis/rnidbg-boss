package com.cmic.sso.sdk.d;

import android.content.Context;
import android.text.TextUtils;
import com.cmic.sso.sdk.c.c.d;
import com.cmic.sso.sdk.e.c;
import com.cmic.sso.sdk.e.f;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.m;
import com.tencent.matrix.trace.config.SharePluginInfo;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.cmic.sso.sdk.a f5515a;

    private static void a(a aVar, com.cmic.sso.sdk.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return;
        }
        aVar.b(aVar2.b("appid", ""));
        aVar.e(m.a());
        aVar.h(aVar2.b("interfaceType", ""));
        aVar.g(aVar2.b("interfaceCode", ""));
        aVar.f(aVar2.b("interfaceElasped", ""));
        aVar.k(aVar2.b("timeOut"));
        aVar.r(aVar2.b("traceId"));
        aVar.m(aVar2.b("simCardNum"));
        aVar.n(aVar2.b("operatortype"));
        aVar.o(m.b());
        aVar.p(m.c());
        aVar.w(String.valueOf(aVar2.b("networktype", 0)));
        aVar.s(aVar2.b("starttime"));
        aVar.t(aVar2.b("endtime"));
        aVar.l(String.valueOf(aVar2.b("systemEndTime", 0L) - aVar2.b("systemStartTime", 0L)));
        aVar.c(aVar2.b("imsiState"));
        aVar.x(k.b("AID", ""));
        aVar.y(aVar2.b("operatortype"));
        aVar.z(aVar2.b("scripType"));
        aVar.A(aVar2.b("networkTypeByAPI"));
        c.a("SendLog", "traceId" + aVar2.b("traceId"));
    }

    public void a(Context context, String str, com.cmic.sso.sdk.a aVar) {
        JSONArray jSONArray;
        String str2 = "";
        try {
            a aVarA = aVar.a();
            String strB = f.b(context);
            aVarA.d(str);
            aVarA.u(aVar.b("loginMethod", ""));
            if (aVar.b("isCacheScrip", false)) {
                aVarA.q("scrip");
            } else {
                aVarA.q("pgw");
            }
            aVarA.i(f.a(context));
            if (!TextUtils.isEmpty(strB)) {
                str2 = strB;
            }
            aVarA.j(str2);
            a(aVarA, aVar);
            if (aVarA.f5514a.size() > 0) {
                jSONArray = new JSONArray();
                for (Throwable th : aVarA.f5514a) {
                    StringBuffer stringBuffer = new StringBuffer();
                    JSONObject jSONObject = new JSONObject();
                    for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                        stringBuffer.append("\n");
                        stringBuffer.append(stackTraceElement.toString());
                    }
                    jSONObject.put("message", th.toString());
                    jSONObject.put(SharePluginInfo.ISSUE_TRACE_STACK, stringBuffer.toString());
                    jSONArray.put(jSONObject);
                }
                aVarA.f5514a.clear();
            } else {
                jSONArray = null;
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                aVarA.a(jSONArray);
            }
            c.a("SendLog", "登录日志");
            a(aVarA.b(), aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(JSONObject jSONObject, com.cmic.sso.sdk.a aVar) {
        this.f5515a = aVar;
        a(jSONObject);
    }

    private void a(JSONObject jSONObject) {
        com.cmic.sso.sdk.c.c.a.a().a(jSONObject, this.f5515a, new d() { // from class: com.cmic.sso.sdk.d.b.1
            @Override // com.cmic.sso.sdk.c.c.d
            public void a(String str, String str2, JSONObject jSONObject2) {
                com.cmic.sso.sdk.a.a aVarB = b.this.f5515a.b();
                HashMap map = new HashMap();
                if (str.equals("103000")) {
                    map.put("logFailTimes", 0);
                    map.put("logCloseTime", 0L);
                } else if (aVarB.l() != 0 && aVarB.k() != 0) {
                    int iA = k.a("logFailTimes", 0) + 1;
                    if (iA >= aVarB.k()) {
                        map.put("logFailTimes", 0);
                        map.put("logCloseTime", Long.valueOf(System.currentTimeMillis()));
                    } else {
                        map.put("logFailTimes", Integer.valueOf(iA));
                    }
                }
                k.a(map);
            }
        });
    }
}
