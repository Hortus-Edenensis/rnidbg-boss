package com.zenmen.palmchat;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.zenmen.palmchat.framework.modulebadge.ModuleBadgeManager;
import com.zenmen.palmchat.router.PagerRouterManager;
import defpackage.ac1;
import defpackage.ap3;
import defpackage.bs3;
import defpackage.bu5;
import defpackage.dn0;
import defpackage.fs3;
import defpackage.go0;
import defpackage.ju4;
import defpackage.l16;
import defpackage.lf5;
import defpackage.n5;
import defpackage.nl0;
import defpackage.om1;
import defpackage.ou1;
import defpackage.qa6;
import defpackage.r75;
import defpackage.rs0;
import defpackage.tk3;
import defpackage.v4;
import defpackage.vj6;
import defpackage.vs0;
import defpackage.yi1;
import defpackage.zs1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f12495a = null;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = false;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        Application getApplication();

        int getStatusBarColor();

        l16 getTrayPreferences();

        void initMessagingService(String str);

        boolean isBackground();

        boolean isDataStorageFull();

        boolean isSDCardStorageFull();

        void logoutAndExitApp();

        void onInitPermissionDenied();

        void onKickOutConfirmed();

        void onNewVersionChecked(Activity activity);
    }

    public static a a() {
        return f12495a;
    }

    public static Application b() {
        a aVar = f12495a;
        if (aVar == null) {
            return null;
        }
        return aVar.getApplication();
    }

    public static String c() {
        return "com.zenmen.palmchat";
    }

    public static String d(Context context, String str) {
        String strI;
        if (!"release".equals(str)) {
            strI = r75.i(context, "sp_setting_servertype");
            if (TextUtils.isEmpty(strI)) {
                return str;
            }
        } else {
            if (!ac1.E(context)) {
                return str;
            }
            strI = r75.i(context, "sp_setting_servertype");
            if (TextUtils.isEmpty(strI)) {
                return str;
            }
        }
        return strI;
    }

    @Deprecated
    public static l16 e() {
        return f12495a.getTrayPreferences();
    }

    public static void f(b bVar) {
        f12495a = bVar.d();
        nl0.d(d(bVar.d().getApplication(), bVar.z()));
        d = bVar.G();
        c = bVar.F();
        b = bVar.E();
        dn0.c(bVar.e());
        om1.g(bVar.j());
        zs1.c(bVar.c());
        v4.g(f12495a.getApplication(), bVar.a());
        ou1.a(bVar.l());
        vj6.b(bVar.D());
        n5.d(bVar.b(), bVar.x(), bVar.k(), bVar.o(), bVar.s(), bVar.u(), bVar.w(), bVar.m());
        tk3.d(bVar.p());
        fs3.a(bVar.t());
        rs0.b(bVar.h());
        yi1.f(bVar.i());
        vs0.b(bVar.g());
        ap3.f(bVar.q());
        ModuleBadgeManager.c(bVar.r());
        qa6.a(bVar.C());
        bs3.c(bVar.n());
        go0.k(bVar.f());
        ju4.a(bVar.y());
        lf5.d(bVar.A());
        PagerRouterManager.init(bVar.v());
        bu5.a(bVar.B());
    }

    public static boolean g() {
        return f12495a.isBackground();
    }
}
