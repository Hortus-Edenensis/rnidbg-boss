package com.zm.fda.O52OZ;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Z2500 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f16631a;
    public static String b;
    public static String c;

    static {
        d();
    }

    public static boolean a() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "Harmony".equalsIgnoreCase(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]).toString());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String b() {
        if (c == null && f16631a) {
            c = a("ro.huawei.build.display.id", "");
        }
        return c;
    }

    public static String c() {
        if (b == null && f16631a) {
            b = a("hw_sc.build.platform.version", "");
        }
        return b;
    }

    public static void d() {
        try {
            Class.forName("ohos.aafwk.ability.Ability");
            f16631a = a();
        } catch (Throwable unused) {
        }
    }

    public static boolean e() {
        return f16631a;
    }

    public static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }
}
