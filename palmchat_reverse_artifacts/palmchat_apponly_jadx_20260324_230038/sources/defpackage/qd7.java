package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class qd7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SharedPreferences f20237a;

    public static long a(String str, long j, Context context) {
        return c(context).getLong(str, j);
    }

    public static String b(String str, String str2, Context context) {
        return c(context).getString(str, str2);
    }

    public static synchronized SharedPreferences c(Context context) {
        if (f20237a == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                f20237a = context.createDeviceProtectedStorageContext().getSharedPreferences("aegis", 0);
            } else {
                f20237a = context.getApplicationContext().getSharedPreferences("aegis", 0);
            }
        }
        return f20237a;
    }

    public static void d(String str, long j, Context context) {
        c(context).edit().putLong(str, j).apply();
    }

    public static void e(String str, String str2, Context context) {
        c(context).edit().putString(str, str2).apply();
    }
}
