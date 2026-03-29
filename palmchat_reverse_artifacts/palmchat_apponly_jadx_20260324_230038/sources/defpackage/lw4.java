package defpackage;

import android.app.ApplicationErrorReport;
import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class lw4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public jw4 f19090a;
    public Context b;

    public lw4(Context context, ApplicationErrorReport applicationErrorReport) {
        this.b = context;
        this.f19090a = b(applicationErrorReport);
    }

    public String a() {
        jw4 jw4Var = this.f19090a;
        return jw4Var != null ? jw4Var.a() : "{}";
    }

    public jw4 b(ApplicationErrorReport applicationErrorReport) {
        jw4 jw4Var = new jw4();
        jw4Var.c = xn1.h().e().f();
        jw4Var.f18526a = applicationErrorReport.type;
        jw4Var.b = applicationErrorReport.time;
        if (xn1.h().m()) {
            v.a("77189::已同意用户协议，带上设备信息", new Object[0]);
            av avVar = new av();
            jw4Var.f = avVar;
            u86.c(this.b, avVar);
        } else {
            v.a("77189::未同意用户协议，不带上设备信息", new Object[0]);
        }
        du5 du5Var = new du5();
        jw4Var.g = du5Var;
        u86.e(this.b, du5Var);
        zg zgVarB = u86.b(this.b, applicationErrorReport.packageName);
        jw4Var.e = zgVarB;
        zgVarB.h = applicationErrorReport.installerPackageName;
        if (applicationErrorReport.crashInfo != null) {
            wq0 wq0Var = new wq0();
            jw4Var.h = wq0Var;
            ApplicationErrorReport.CrashInfo crashInfo = applicationErrorReport.crashInfo;
            wq0Var.f21773a = crashInfo.exceptionClassName;
            wq0Var.b = crashInfo.exceptionMessage;
            wq0Var.c = crashInfo.throwFileName;
            wq0Var.d = crashInfo.throwClassName;
            wq0Var.e = crashInfo.throwMethodName;
            wq0Var.f = crashInfo.throwLineNumber;
            wq0Var.g = crashInfo.stackTrace;
        }
        if (applicationErrorReport.anrInfo != null) {
            ke keVar = new ke();
            jw4Var.i = keVar;
            ApplicationErrorReport.AnrInfo anrInfo = applicationErrorReport.anrInfo;
            keVar.f18670a = anrInfo.activity;
            keVar.b = anrInfo.cause;
            keVar.c = anrInfo.info;
        }
        return jw4Var;
    }

    public JSONObject c() {
        jw4 jw4Var = this.f19090a;
        if (jw4Var != null) {
            return jw4Var.b();
        }
        return null;
    }
}
