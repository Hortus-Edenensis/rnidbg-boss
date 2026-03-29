package com.unicom.xiaowo.account.shield.b;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f11183a;
    final /* synthetic */ c b;

    public b(c cVar, String str) {
        this.b = cVar;
        this.f11183a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject;
        synchronized ("callbackLock") {
            try {
                jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                jSONObject.put("resultMsg", this.f11183a);
                jSONObject.put("resultData", "");
                jSONObject.put("traceId", "");
                jSONObject.put("operatorType", "CU");
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("sendLoginFail error:");
                sb.append(e.getMessage());
                com.unicom.xiaowo.account.shield.c.b.b(sb.toString());
            }
            if (!c.f11184a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("cbresult:");
                sb2.append(jSONObject.toString());
                com.unicom.xiaowo.account.shield.c.b.b(sb2.toString());
                boolean unused = c.f11184a = true;
                this.b.d.onResult(jSONObject.toString());
            }
        }
    }
}
