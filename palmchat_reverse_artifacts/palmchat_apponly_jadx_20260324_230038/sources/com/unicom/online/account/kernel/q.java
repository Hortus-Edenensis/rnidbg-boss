package com.unicom.online.account.kernel;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f11168a = null;

    public final void a(int i, String str) {
        a(i, str, "", "");
    }

    public final void a(int i, String str, String str2, String str3) {
        try {
            if (this.f11168a == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", i);
            jSONObject.put("resultMsg", str);
            jSONObject.put("resultData", str2);
            jSONObject.put("seq", str3);
            this.f11168a.onResult(jSONObject.toString());
            this.f11168a = null;
            if (i < 0) {
                aa.a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
