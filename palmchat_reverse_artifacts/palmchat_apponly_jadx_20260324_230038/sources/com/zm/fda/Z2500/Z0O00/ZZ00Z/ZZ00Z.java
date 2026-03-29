package com.zm.fda.Z2500.Z0O00.ZZ00Z;

import android.content.Context;
import com.zm.fda.busi.IPubParams;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZZ00Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f16693a;
    public long b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    public ZZ00Z(Context context, com.zm.fda.Z0225.Z200O z200o) {
        if (z200o != null && z200o.i() != null) {
            this.f16693a = z200o.o();
            this.c = z200o.p();
            IPubParams iPubParamsI = z200o.i();
            this.b = iPubParamsI.getProjectVerCode();
            this.d = iPubParamsI.getProjectVerName();
        }
        if (context != null) {
            this.g = com.zm.fda.O52OZ.ZZ00Z.a(context);
            this.e = context.getPackageName();
            this.f = com.zm.fda.O52OZ.ZZ00Z.b(context);
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            jSONObject.put("versioncode", this.f16693a);
            String str = this.c;
            if (str != null) {
                jSONObject.put("versionName", str);
            }
            jSONObject.put(com.zm.fda.Z2500.ZZ00Z.v, this.b);
            String str2 = this.d;
            if (str2 != null) {
                jSONObject.put(com.zm.fda.Z2500.ZZ00Z.w, str2);
            }
            String str3 = this.g;
            if (str3 != null) {
                jSONObject.put("name", str3);
            }
            String str4 = this.e;
            if (str4 != null) {
                jSONObject.put("packageName", str4);
            }
            String str5 = this.f;
            if (str5 != null) {
                jSONObject.put("processName", str5);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
