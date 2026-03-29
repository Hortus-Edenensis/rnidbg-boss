package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.heytap.mcssdk.PushService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6357a = "shared_msg_sdk";
    private static final String b = "hasDefaultChannelCreated";
    private static final String c = "decryptTag";
    private Context d;
    private SharedPreferences e;
    private Object f;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static e f6358a = new e();

        private a() {
        }
    }

    private e() {
        this.f = new Object();
        Context context = PushService.getInstance().getContext();
        if (context != null) {
            this.d = a(context);
        }
        Context context2 = this.d;
        if (context2 != null) {
            this.e = context2.getSharedPreferences(f6357a, 0);
        }
    }

    private Context a(Context context) {
        boolean zA = com.heytap.mcssdk.utils.a.a();
        d.b("fbeVersion is " + zA);
        return (!zA || Build.VERSION.SDK_INT < 24) ? context.getApplicationContext() : context.createDeviceProtectedStorageContext();
    }

    public static e c() {
        return a.f6358a;
    }

    private SharedPreferences d() {
        Context context;
        SharedPreferences sharedPreferences = this.e;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        synchronized (this.f) {
            SharedPreferences sharedPreferences2 = this.e;
            if (sharedPreferences2 != null || (context = this.d) == null) {
                return sharedPreferences2;
            }
            SharedPreferences sharedPreferences3 = context.getSharedPreferences(f6357a, 0);
            this.e = sharedPreferences3;
            return sharedPreferences3;
        }
    }

    public String b() {
        SharedPreferences sharedPreferencesD = d();
        return sharedPreferencesD != null ? sharedPreferencesD.getString(c, "DES") : "DES";
    }

    public void a(String str) {
        SharedPreferences sharedPreferencesD = d();
        if (sharedPreferencesD != null) {
            sharedPreferencesD.edit().putString(c, str).commit();
        }
    }

    public void a(boolean z) {
        SharedPreferences sharedPreferencesD = d();
        if (sharedPreferencesD != null) {
            sharedPreferencesD.edit().putBoolean(b, z).commit();
        }
    }

    public boolean a() {
        SharedPreferences sharedPreferencesD = d();
        if (sharedPreferencesD != null) {
            return sharedPreferencesD.getBoolean(b, false);
        }
        return false;
    }
}
