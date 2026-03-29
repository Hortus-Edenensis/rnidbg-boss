package com.zx.a.I8b7;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.zx.a.I8b7.r2;
import com.zx.module.annotation.Java2C;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class w3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PackageManager f16879a;
    public static a2 b;
    public static HashMap<String, String> c = new HashMap<>();

    @TargetApi(26)
    @Java2C.Method2C
    public static native String a();

    @Java2C.Method2C
    public static native String a(Context context);

    @Java2C.Method2C
    public static native String a(String str);

    public static boolean a(Context context, String str, boolean z) {
        try {
            return c(context).checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            try {
                r2.a.f16855a.f16854a.f16852a.a(4, null, null, th);
                return z;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return z;
            }
        }
    }

    @Java2C.Method2C
    public static native PackageInfo b(String str);

    public static String b() {
        try {
            String str = Build.BRAND;
            return (TextUtils.isEmpty(str) || str.equals("unknown")) ? Build.MANUFACTURER : str;
        } catch (Throwable th) {
            r2.a(th);
            return "";
        }
    }

    @Java2C.Method2C
    public static native String b(Context context);

    public static PackageManager c(Context context) {
        if (f16879a == null) {
            f16879a = context.getPackageManager();
        }
        return f16879a;
    }

    @Java2C.Method2C
    public static native a2 d(Context context);

    @Java2C.Method2C
    public static native String d();

    @Java2C.Method2C
    public static native long e(Context context);

    @Java2C.Method2C
    public static native String e();

    @Java2C.Method2C
    public static native String f();

    @Java2C.Method2C
    private static native boolean f(Context context);

    @Java2C.Method2C
    public static native String g();

    @Java2C.Method2C
    public static native long h();

    @Java2C.Method2C
    public static native boolean i();

    public static String c() {
        String[] strArr = Build.SUPPORTED_ABIS;
        String str = "";
        if (strArr != null && strArr.length > 0) {
            for (String str2 : strArr) {
                str = str + str2 + ",";
            }
        }
        return str;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean a(Context context, boolean z) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isAvailable()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return z;
        }
    }

    public static String a(HashMap<String, String> map, String str) {
        return map.containsKey(str) ? map.get(str) : "";
    }
}
