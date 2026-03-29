package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static r f11769a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f1007a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<String> f1008a = new ArrayList();
    private final List<String> b = new ArrayList();
    private final List<String> c = new ArrayList();

    private r(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f1007a = applicationContext;
        if (applicationContext == null) {
            this.f1007a = context;
        }
        SharedPreferences sharedPreferences = this.f1007a.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(",")) {
            if (TextUtils.isEmpty(str)) {
                this.f1008a.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(",")) {
            if (!TextUtils.isEmpty(str2)) {
                this.b.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(",")) {
            if (!TextUtils.isEmpty(str3)) {
                this.c.add(str3);
            }
        }
    }

    public static r a(Context context) {
        if (f11769a == null) {
            f11769a = new r(context);
        }
        return f11769a;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m770b(String str) {
        boolean zContains;
        synchronized (this.b) {
            zContains = this.b.contains(str);
        }
        return zContains;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m771c(String str) {
        boolean zContains;
        synchronized (this.c) {
            zContains = this.c.contains(str);
        }
        return zContains;
    }

    public void d(String str) {
        synchronized (this.f1008a) {
            if (this.f1008a.contains(str)) {
                this.f1008a.remove(str);
                this.f1007a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bb.a(this.f1008a, ",")).commit();
            }
        }
    }

    public void e(String str) {
        synchronized (this.b) {
            if (this.b.contains(str)) {
                this.b.remove(str);
                this.f1007a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bb.a(this.b, ",")).commit();
            }
        }
    }

    public void f(String str) {
        synchronized (this.c) {
            if (this.c.contains(str)) {
                this.c.remove(str);
                this.f1007a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bb.a(this.c, ",")).commit();
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m769a(String str) {
        boolean zContains;
        synchronized (this.f1008a) {
            zContains = this.f1008a.contains(str);
        }
        return zContains;
    }

    public void b(String str) {
        synchronized (this.b) {
            if (!this.b.contains(str)) {
                this.b.add(str);
                this.f1007a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bb.a(this.b, ",")).commit();
            }
        }
    }

    public void c(String str) {
        synchronized (this.c) {
            if (!this.c.contains(str)) {
                this.c.add(str);
                this.f1007a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bb.a(this.c, ",")).commit();
            }
        }
    }

    public void a(String str) {
        synchronized (this.f1008a) {
            if (!this.f1008a.contains(str)) {
                this.f1008a.add(str);
                this.f1007a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bb.a(this.f1008a, ",")).commit();
            }
        }
    }
}
