package com.qq.e.comm.managers.plugin;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f10438a = null;
    private static boolean b = false;

    private static void a(Throwable th) throws Throwable {
        if (b) {
            return;
        }
        if (f10438a == null) {
            Method declaredMethod = Class.forName("com.tencent.bugly.crashreport.CrashReport").getDeclaredMethod("postCatchedException", Throwable.class);
            f10438a = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        f10438a.invoke(null, th);
    }

    public static void a(Throwable th, String str) {
        try {
            a(new Exception("插件错误：" + str, th));
        } catch (Throwable unused) {
            b = true;
        }
    }
}
