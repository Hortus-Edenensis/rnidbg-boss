package com.zm.fda.Z2500.Z0O00.ZZ00Z;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Z25O0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16692a;
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;

    public void a(JSONObject jSONObject) {
        try {
            String str = this.f16692a;
            if (str != null) {
                jSONObject.put("exceptionClassName", str);
            }
            String str2 = this.b;
            if (str2 != null) {
                jSONObject.put("exceptionMessage", str2);
            }
            String str3 = this.c;
            if (str3 != null) {
                jSONObject.put("throwFileName", str3);
            }
            String str4 = this.d;
            if (str4 != null) {
                jSONObject.put("throwClassName", str4);
            }
            String str5 = this.e;
            if (str5 != null) {
                jSONObject.put("throwMethodName", str5);
            }
            jSONObject.put("throwLineNumber", String.valueOf(this.f));
            String str6 = this.g;
            if (str6 != null) {
                jSONObject.put("stackTrace", str6);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
