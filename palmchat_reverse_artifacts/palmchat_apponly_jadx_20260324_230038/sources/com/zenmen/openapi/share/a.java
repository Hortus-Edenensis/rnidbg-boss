package com.zenmen.openapi.share;

import android.app.Activity;
import android.net.Uri;
import com.zenmen.openapi.OpenApiManager;
import com.zenmen.openapi.share.OpenShare;
import defpackage.b94;
import defpackage.ma3;
import defpackage.n75;
import defpackage.s84;
import defpackage.u84;
import defpackage.v84;
import defpackage.xg;
import defpackage.z84;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a {
    public static boolean a(Activity activity, n75 n75Var) {
        if (n75Var == null) {
            ma3.d("ShareInfo should not be null");
            return false;
        }
        if (n75Var.a() == null) {
            ma3.d("please make sure configNativeApp success before share content!");
            return false;
        }
        if (activity != null) {
            return true;
        }
        ma3.d("share failed activity should not be null");
        return false;
    }

    public static boolean b(Activity activity, n75 n75Var) {
        return c(activity, n75Var, false);
    }

    public static boolean c(Activity activity, n75 n75Var, boolean z) {
        if (!a(activity, n75Var)) {
            return false;
        }
        xg xgVarA = n75Var.a();
        u84 u84Var = new u84();
        u84Var.q(n75Var.d);
        u84Var.n(n75Var.e);
        u84Var.r(n75Var.c);
        if (z) {
            u84Var.p(Uri.parse("zenxin://webapp").buildUpon().appendQueryParameter("url", n75Var.b).appendQueryParameter("appId", xgVarA.f21948a).appendQueryParameter("scene", "share" + n75Var.k).toString());
        } else {
            u84Var.p(n75Var.b);
        }
        u84Var.o(n75Var.f);
        u84Var.v(n75Var.g);
        u84Var.w(n75Var.h);
        u84Var.f(xgVarA.c);
        u84Var.g(xgVarA.b);
        new OpenShare.a().f(xgVarA.f21948a).g(activity).h(0).j(u84Var).e().share();
        return true;
    }

    public static boolean d(Activity activity, n75 n75Var) {
        if (!a(activity, n75Var)) {
            return false;
        }
        xg xgVarA = n75Var.a();
        s84 s84Var = new s84();
        s84Var.q(n75Var.d);
        s84Var.n(n75Var.e);
        s84Var.r(n75Var.b);
        if (n75Var.b.startsWith("zenxin://webapp")) {
            s84Var.p(Uri.parse(n75Var.b).buildUpon().appendQueryParameter("appId", n75Var.f19455a).appendQueryParameter("scene", "share" + n75Var.k).toString());
        }
        s84Var.o(n75Var.f);
        s84Var.f(xgVarA.c);
        s84Var.g(xgVarA.b);
        new OpenShare.a().f(xgVarA.f21948a).g(activity).h(n75Var.k).i(s84Var).e().share();
        return true;
    }

    public static boolean e(Activity activity, n75 n75Var) {
        if (!a(activity, n75Var)) {
            return false;
        }
        xg xgVarA = n75Var.a();
        v84 v84Var = new v84();
        v84Var.p(n75Var.g);
        v84Var.q(n75Var.h);
        v84Var.r(n75Var.i);
        v84Var.t(n75Var.d);
        String str = n75Var.b;
        v84Var.u(str);
        v84Var.s(Uri.parse("zenxin://webapp").buildUpon().appendQueryParameter("url", str).appendQueryParameter("appId", xgVarA.f21948a).appendQueryParameter("scene", "share" + n75Var.k).toString());
        v84Var.f(xgVarA.c);
        v84Var.g(xgVarA.b);
        v84Var.v(n75Var.j);
        new OpenShare.a().g(activity).f(xgVarA.f21948a).h(n75Var.k).k(v84Var).e().share();
        return true;
    }

    public static boolean f(Activity activity, String str, String str2, int i) {
        xg appInfoFromCache = OpenApiManager.getAppInfoFromCache(str);
        if (appInfoFromCache == null) {
            return false;
        }
        z84 z84Var = new z84(str2);
        z84Var.f(appInfoFromCache.c);
        z84Var.g(appInfoFromCache.b);
        new OpenShare.a().f(appInfoFromCache.f21948a).g(activity).h(i).l(z84Var).e().share();
        return true;
    }

    public static boolean g(Activity activity, n75 n75Var) {
        xg appInfoFromCache;
        if (!a(activity, n75Var) || (appInfoFromCache = OpenApiManager.getAppInfoFromCache(n75Var.f19455a)) == null) {
            return false;
        }
        b94 b94Var = new b94();
        b94Var.r(n75Var.b);
        b94Var.q(n75Var.d);
        b94Var.n(n75Var.e);
        b94Var.o(n75Var.f);
        b94Var.f(appInfoFromCache.c);
        b94Var.g(appInfoFromCache.b);
        new OpenShare.a().g(activity).f(appInfoFromCache.f21948a).h(n75Var.k).m(b94Var).e().share();
        return true;
    }

    public static boolean h(Activity activity, n75 n75Var) {
        return c(activity, n75Var, true);
    }
}
