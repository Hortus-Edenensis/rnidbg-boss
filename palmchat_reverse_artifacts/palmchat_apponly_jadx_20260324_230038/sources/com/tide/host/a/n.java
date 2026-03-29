package com.tide.host.a;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f10795a;
    public static String b;

    static {
        try {
            Class.forName("ohos.aafwk.ability.Ability");
            boolean zEqualsIgnoreCase = false;
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                zEqualsIgnoreCase = "Harmony".equalsIgnoreCase(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]).toString());
            } catch (Throwable unused) {
            }
            f10795a = zEqualsIgnoreCase;
        } catch (Throwable unused2) {
        }
    }

    public static String a() {
        String str;
        if (b == null && f10795a) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "hw_sc.build.platform.version");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            b = str;
        }
        return b;
    }
}
