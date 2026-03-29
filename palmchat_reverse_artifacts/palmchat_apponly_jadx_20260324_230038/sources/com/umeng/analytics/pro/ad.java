package com.umeng.analytics.pro;

import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ad extends ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10844a;
    private String b;

    public ad(String str, ArrayList<ac> arrayList) {
        super(str, arrayList);
        this.f10844a = "";
        this.b = "";
    }

    @Override // com.umeng.analytics.pro.ab, com.umeng.analytics.pro.aj
    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject jSONObjectA = super.a(str, jSONObject);
        if (jSONObjectA != null) {
            try {
                jSONObjectA.put(com.umeng.ccg.a.y, this.f10844a);
                jSONObjectA.put("action", this.b);
            } catch (Throwable unused) {
            }
        }
        return jSONObjectA;
    }

    @Override // com.umeng.analytics.pro.ab, com.umeng.analytics.pro.aj
    public void b(String str, JSONObject jSONObject) {
        super.b(str, jSONObject);
        if (jSONObject.has("action")) {
            d(jSONObject.optString("action"));
        }
        if (jSONObject.has(com.umeng.ccg.a.y)) {
            c(jSONObject.optString(com.umeng.ccg.a.y));
        }
    }

    public void c(String str) {
        this.f10844a = str;
    }

    public String d() {
        return this.f10844a;
    }

    public String e() {
        return this.b;
    }

    public void d(String str) {
        this.b = str;
    }
}
