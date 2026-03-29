package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.m.j.c;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import defpackage.eg7;
import defpackage.fu6;
import defpackage.i07;
import defpackage.j07;
import defpackage.pu6;
import defpackage.qh7;
import defpackage.ru6;
import defpackage.vt6;
import defpackage.w97;
import defpackage.wt6;
import defpackage.xt6;
import defpackage.xz6;
import defpackage.zd7;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class AuthTask {
    public static final Object c = zd7.class;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f2575a;
    public wt6 b;

    public AuthTask(Activity activity) {
        this.f2575a = activity;
        j07.e().b(this.f2575a);
        this.b = new wt6(activity, "去支付宝授权");
    }

    public synchronized String auth(String str, boolean z) {
        return innerAuth(new ru6(this.f2575a, str, "auth"), str, z);
    }

    public synchronized Map<String, String> authV2(String str, boolean z) {
        ru6 ru6Var;
        ru6Var = new ru6(this.f2575a, str, "authV2");
        return eg7.c(ru6Var, innerAuth(ru6Var, str, z));
    }

    public final String b(Activity activity, String str, ru6 ru6Var) {
        String strB = ru6Var.b(str);
        List<vt6.b> listU = vt6.I().u();
        if (!vt6.I().g || listU == null) {
            listU = fu6.d;
        }
        if (!qh7.v(ru6Var, this.f2575a, listU, true)) {
            xt6.a(ru6Var, "biz", "LogCalledH5");
            return e(activity, strB, ru6Var);
        }
        zd7 zd7Var = new zd7(activity, ru6Var, d());
        String strH = zd7Var.h(strB, false);
        zd7Var.i();
        if (!TextUtils.equals(strH, "failed") && !TextUtils.equals(strH, "scheme_failed")) {
            return TextUtils.isEmpty(strH) ? xz6.a() : strH;
        }
        xt6.a(ru6Var, "biz", "LogBindCalledH5");
        return e(activity, strB, ru6Var);
    }

    public final void c() {
        wt6 wt6Var = this.b;
        if (wt6Var != null) {
            wt6Var.c();
        }
    }

    public final zd7.e d() {
        return new a();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String e(Activity activity, String str, ru6 ru6Var) {
        List<i07> listB;
        int i;
        f();
        c cVarB = null;
        try {
            try {
                listB = i07.b(new pu6().b(ru6Var, activity, str).c().optJSONObject("form").optJSONObject("onload"));
                c();
            } finally {
                c();
            }
        } catch (IOException e) {
            c cVarB2 = c.b(c.NETWORK_ERROR.b());
            xt6.e(ru6Var, TKDownloadReason.KSAD_TK_NET, e);
            cVarB = cVarB2;
        } catch (Throwable th) {
            xt6.c(ru6Var, "biz", "H5AuthDataAnalysisError", th);
        }
        for (i = 0; i < listB.size(); i++) {
            if (listB.get(i).a() == com.alipay.sdk.m.r.a.WapPay) {
                return a(ru6Var, listB.get(i));
            }
            if (cVarB == null) {
                cVarB = c.b(c.FAILED.b());
            }
            return xz6.b(cVarB.b(), cVarB.a(), "");
        }
        c();
        if (cVarB == null) {
        }
        return xz6.b(cVarB.b(), cVarB.a(), "");
    }

    public final void f() {
        wt6 wt6Var = this.b;
        if (wt6Var != null) {
            wt6Var.f();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00c1 A[Catch: all -> 0x0137, DONT_GENERATE, PHI: r9
      0x00c1: PHI (r9v11 java.lang.String) = (r9v2 java.lang.String), (r9v13 java.lang.String) binds: [B:16:0x00bf, B:9:0x006b] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {, blocks: (B:4:0x0003, B:5:0x0006, B:8:0x0020, B:18:0x00ca, B:17:0x00c1, B:21:0x00d6, B:23:0x0123, B:24:0x012c, B:25:0x0136, B:15:0x0074, B:7:0x001a, B:14:0x0071), top: B:31:0x0003, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String innerAuth(ru6 ru6Var, String str, boolean z) {
        String strA;
        if (z) {
            f();
            j07.e().b(this.f2575a);
            strA = xz6.a();
            fu6.b("");
            try {
                try {
                    strA = b(this.f2575a, str, ru6Var);
                    xt6.b(ru6Var, "biz", "PgReturn", "" + SystemClock.elapsedRealtime());
                    xt6.b(ru6Var, "biz", "PgReturnV", eg7.a(strA, "resultStatus") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + eg7.a(strA, "memo"));
                } catch (Exception e) {
                    w97.d(e);
                }
                if (!vt6.I().A()) {
                }
            } finally {
                xt6.b(ru6Var, "biz", "PgReturn", "" + SystemClock.elapsedRealtime());
                xt6.b(ru6Var, "biz", "PgReturnV", eg7.a(strA, "resultStatus") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + eg7.a(strA, "memo"));
                if (!vt6.I().A()) {
                    vt6.I().f(ru6Var, this.f2575a, false, 1);
                }
                c();
                xt6.h(this.f2575a, ru6Var, str, ru6Var.d);
            }
        } else {
            j07.e().b(this.f2575a);
            strA = xz6.a();
            fu6.b("");
            strA = b(this.f2575a, str, ru6Var);
            xt6.b(ru6Var, "biz", "PgReturn", "" + SystemClock.elapsedRealtime());
            xt6.b(ru6Var, "biz", "PgReturnV", eg7.a(strA, "resultStatus") + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + eg7.a(strA, "memo"));
            if (!vt6.I().A()) {
            }
        }
        return strA;
    }

    public final String a(ru6 ru6Var, i07 i07Var) {
        String[] strArrF = i07Var.f();
        Bundle bundle = new Bundle();
        bundle.putString("url", strArrF[0]);
        Intent intent = new Intent(this.f2575a, (Class<?>) H5AuthActivity.class);
        intent.putExtras(bundle);
        ru6.a.c(ru6Var, intent);
        this.f2575a.startActivity(intent);
        Object obj = c;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException unused) {
                return xz6.a();
            }
        }
        String strG = xz6.g();
        return TextUtils.isEmpty(strG) ? xz6.a() : strG;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements zd7.e {
        public a() {
        }

        @Override // zd7.e
        public void a() {
            AuthTask.this.c();
        }

        @Override // zd7.e
        public void b() {
        }
    }
}
