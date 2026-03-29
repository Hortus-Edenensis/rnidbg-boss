package com.zm.fda.Z2500;

import android.app.ApplicationErrorReport;
import android.content.Context;
import android.text.TextUtils;
import com.zm.fda.O52OZ.O2O5Z;
import com.zm.fda.Z0225.Z200O;
import com.zm.fda.Z0O00.Z2500.OO22Z;
import com.zm.fda.Z0O00.Z2500.ZZ00Z;
import com.zm.fda.Z200O.ZZ00Z;
import com.zm.fda.busi.IPubParams;
import com.zm.fda.utils.EventLog;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OO22Z {
    public static final String f = "fda_crash_CC";
    public static OO22Z g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f16683a;
    public com.zm.fda.Z2500.Z0O00.OO22Z b;
    public com.zm.fda.Z2500.Z200O.OO22Z c;
    public com.zm.fda.Z2500.Z2500.OO22Z d;
    public AtomicBoolean e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.zm.fda.Z2500.OO22Z$OO22Z, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1171OO22Z extends com.zm.fda.Z0225.OO22Z {
        public C1171OO22Z() {
        }

        @Override // com.zm.fda.Z0225.OO22Z
        public void a() {
            if (com.zm.fda.O022Z.b()) {
                OO22Z.this.d();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class ZZ00Z implements Runnable {
        public ZZ00Z() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.zm.fda.OOZ20.O022Z.a().a(ZZ00Z.C1170ZZ00Z.a(), OO22Z.this.b);
        }
    }

    public void b(Throwable th, Z200O z200o) {
        int i = th instanceof com.zm.fda.Z2500.Z200O.ZZ00Z ? 2 : 1;
        EventLog.d(f, "handlerCrash type:", Integer.valueOf(i));
        if (this.b != null) {
            com.zm.fda.Z2500.ZZ00Z zz00z = new com.zm.fda.Z2500.ZZ00Z(th, i, this.f16683a, z200o);
            this.b.a(zz00z.d(), i);
            this.b.a(a(z200o, zz00z.b(), i), i);
        }
    }

    public void c() {
        try {
            com.zm.fda.Z2500.Z2500.OO22Z oo22z = this.d;
            if (oo22z != null) {
                oo22z.a();
            }
            com.zm.fda.Z2500.Z200O.OO22Z oo22z2 = this.c;
            if (oo22z2 != null) {
                oo22z2.a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void d() {
        com.zm.fda.Z2500.Z0O00.OO22Z oo22z = this.b;
        if (oo22z == null) {
            return;
        }
        com.zm.fda.OOZ20.Z25O0.a((Runnable) new O022Z(1, oo22z), (com.zm.fda.OOZ20.Z0225.OO22Z) null);
        com.zm.fda.OOZ20.Z25O0.a((Runnable) new O022Z(2, this.b), (com.zm.fda.OOZ20.Z0225.OO22Z) null);
        com.zm.fda.OOZ20.Z25O0.a((Runnable) new ZZ00Z(), (com.zm.fda.OOZ20.Z0225.OO22Z) null);
    }

    public static OO22Z a() {
        if (g == null) {
            synchronized (OO22Z.class) {
                if (g == null) {
                    g = new OO22Z();
                }
            }
        }
        return g;
    }

    private void b() {
        try {
            com.zm.fda.Z0225.ZZ00Z.a().a(new C1171OO22Z());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(Context context, Z0225 z0225) {
        if (this.e.get()) {
            return;
        }
        this.e.set(true);
        EventLog.d(f, "crash module init");
        if (context != null) {
            context = context.getApplicationContext();
        }
        if (context == null) {
            return;
        }
        this.f16683a = context;
        this.b = new com.zm.fda.Z2500.Z0O00.OO22Z(context);
        b();
        com.zm.fda.Z2500.Z2500.OO22Z oo22z = new com.zm.fda.Z2500.Z2500.OO22Z();
        this.d = oo22z;
        oo22z.a(z0225);
        com.zm.fda.Z2500.Z200O.OO22Z oo22z2 = new com.zm.fda.Z2500.Z200O.OO22Z(context.getApplicationContext());
        this.c = oo22z2;
        oo22z2.a(z0225);
        EventLog.d(f, "start exception anr collect");
    }

    public boolean a(Throwable th, Z200O z200o) {
        if (z200o != null && z200o.i() != null && !TextUtils.isEmpty(z200o.i().getAppId())) {
            IPubParams iPubParamsI = z200o.i();
            if (!iPubParamsI.collectCrash()) {
                EventLog.d(f, "can not collect return");
                return false;
            }
            List<String> crashKeyword = iPubParamsI.getCrashKeyword();
            EventLog.d(f, "keywordList :", crashKeyword);
            if (crashKeyword == null) {
                return true;
            }
            String strA = a(th);
            if (TextUtils.isEmpty(strA)) {
                return true;
            }
            for (String str : crashKeyword) {
                if (!TextUtils.isEmpty(str)) {
                    if (strA.contains(str)) {
                        EventLog.d(f, "errorMsg :", strA, ", error中含有error，符合上传条件");
                        return true;
                    }
                    EventLog.d(f, "errorMsg :", strA, ", 不包含包名");
                }
            }
        }
        return false;
    }

    private String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        return stringWriter.toString();
    }

    private com.zm.fda.Z0O00.Z2500.ZZ00Z a(Z200O z200o, ApplicationErrorReport applicationErrorReport, int i) {
        OO22Z.ZZ00Z zz00zA = new OO22Z.ZZ00Z().b(com.zm.fda.OOZ20.ZZ00Z.b()).n(z200o.d()).u(z200o.f()).t(new com.zm.fda.Z2500.Z0O00.ZZ00Z.Z0225(this.f16683a, z200o, applicationErrorReport).toString()).D(z200o.o() + "").i("005011").a(i).x(com.zm.fda.Z200O.ZZ00Z.x).c(z200o.j()).y(z200o.g()).z(z200o.h()).k(z200o.c()).s(z200o.e()).d(z200o.a()).a(System.currentTimeMillis());
        if (z200o.i() != null) {
            zz00zA.h(z200o.i().getChanId()).m(z200o.i().getIMEI()).q(z200o.i().getMac()).p(z200o.i().getLongi()).o(z200o.i().getLati()).j(z200o.i().getDHID()).v(com.zm.fda.Z25O0.a(z200o.i())).a(z200o.i().getAndroidId()).B(String.valueOf(z200o.i().getProjectVerCode())).A(z200o.i().getProjectId()).l(z200o.b());
        }
        return new ZZ00Z.C1169ZZ00Z().b(O2O5Z.a()).a(com.zm.fda.OOZ20.ZZ00Z.b()).a(zz00zA.a()).a(System.currentTimeMillis()).a(i).a();
    }
}
