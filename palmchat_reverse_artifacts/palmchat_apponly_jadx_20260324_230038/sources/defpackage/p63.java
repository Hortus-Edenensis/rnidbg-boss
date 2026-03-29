package defpackage;

import cn.jiguang.api.JCoreManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class p63 {
    public static void a(String str, String str2) {
        e(3, true, str, str2, null);
    }

    public static void b(String str, String str2) {
        e(3, false, str, str2, null);
    }

    public static void c(String str, String str2) {
        e(6, true, str, str2, null);
    }

    public static void d(String str, String str2) {
        e(4, true, str, str2, null);
    }

    public static void e(int i, boolean z, String str, String str2, Throwable th) {
        JCoreManager.onEvent(null, "JCommon", 18, str, null, Integer.valueOf(i), Boolean.valueOf(z), str2, th);
    }

    public static void f(String str, String str2) {
        e(5, true, str, str2, null);
    }

    public static void g(String str, String str2) {
        e(5, false, str, str2, null);
    }
}
