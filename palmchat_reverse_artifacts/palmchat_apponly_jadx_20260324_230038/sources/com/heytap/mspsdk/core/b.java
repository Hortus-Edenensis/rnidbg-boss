package com.heytap.mspsdk.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6385a;
    private final String b;
    private final String c;

    public b(String str, String str2, int i) {
        this.c = str;
        this.b = str2;
        this.f6385a = i;
    }

    public static b a(Context context) {
        if (!h()) {
            PackageInfo packageInfoA = com.heytap.mspsdk.util.a.a(context);
            return packageInfoA != null ? new b(packageInfoA.packageName, packageInfoA.versionName, packageInfoA.versionCode) : i();
        }
        ApplicationInfo applicationInfoB = com.heytap.mspsdk.util.a.b(context);
        if (applicationInfoB == null) {
            return i();
        }
        String string = applicationInfoB.metaData.getString("mspCoreName");
        if (string == null) {
            string = "";
        }
        return new b(applicationInfoB.packageName, string, applicationInfoB.metaData.getInt("mspCoreCode"));
    }

    public static boolean g() {
        if (com.heytap.mspsdk.util.e.e()) {
            return (com.heytap.mspsdk.util.e.d() || com.heytap.mspsdk.util.b.a()) ? false : true;
        }
        return true;
    }

    private static boolean h() {
        return com.heytap.mspsdk.util.e.e() && com.heytap.mspsdk.util.e.d() && (com.heytap.mspsdk.util.e.b() || !com.heytap.mspsdk.util.b.a());
    }

    private static b i() {
        return new b("", "", 0);
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.c);
    }

    public boolean c() {
        return b() ? "com.heytap.htms".equals(this.c) : !h();
    }

    public String d() {
        return this.b;
    }

    public int e() {
        return this.f6385a;
    }

    public String f() {
        return this.c;
    }

    public boolean a() {
        return this.f6385a >= 2000000;
    }
}
