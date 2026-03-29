package com.zm.fda.Z2500.Z0O00.ZZ00Z;

import android.app.ApplicationErrorReport;
import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Z0225 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16689a;
    public long b;
    public ZZ00Z c;
    public O022Z d = new O022Z();
    public Z2500 e;
    public Z200O f;
    public Z25O0 g;
    public OO22Z h;

    public Z0225(Context context, com.zm.fda.Z0225.Z200O z200o, ApplicationErrorReport applicationErrorReport) {
        this.f16689a = applicationErrorReport.type;
        this.b = applicationErrorReport.time;
        this.c = new ZZ00Z(context, z200o);
        if (applicationErrorReport.crashInfo != null) {
            Z25O0 z25o0 = new Z25O0();
            this.g = z25o0;
            ApplicationErrorReport.CrashInfo crashInfo = applicationErrorReport.crashInfo;
            z25o0.f16692a = crashInfo.exceptionClassName;
            z25o0.b = crashInfo.exceptionMessage;
            z25o0.c = crashInfo.throwFileName;
            z25o0.d = crashInfo.throwClassName;
            z25o0.e = crashInfo.throwMethodName;
            z25o0.f = crashInfo.throwLineNumber;
            z25o0.g = crashInfo.stackTrace;
        }
        if (applicationErrorReport.anrInfo != null) {
            OO22Z oo22z = new OO22Z();
            this.h = oo22z;
            ApplicationErrorReport.AnrInfo anrInfo = applicationErrorReport.anrInfo;
            oo22z.f16688a = anrInfo.activity;
            oo22z.b = anrInfo.cause;
            oo22z.c = anrInfo.info;
        }
    }

    public String toString() {
        OO22Z oo22z;
        Z25O0 z25o0;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", String.valueOf(this.f16689a));
            jSONObject.put("time", String.valueOf(this.b));
            ZZ00Z zz00z = this.c;
            if (zz00z != null) {
                zz00z.a(jSONObject);
            }
            O022Z o022z = this.d;
            if (o022z != null) {
                o022z.a(jSONObject);
            }
            int i = this.f16689a;
            if (i == 1 && (z25o0 = this.g) != null) {
                z25o0.a(jSONObject);
            } else if (i == 2 && (oo22z = this.h) != null) {
                oo22z.a(jSONObject);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }
}
