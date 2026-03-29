package defpackage;

import cn.jiguang.api.JCoreManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class l63 {
    public static void a(String str, String str2) {
        d(3, true, str, str2, null);
    }

    public static void b(String str, String str2) {
        d(6, true, str, str2, null);
    }

    public static void c(String str, String str2) {
        d(6, false, str, str2, null);
    }

    public static void d(int i, boolean z, String str, String str2, Throwable th) {
        JCoreManager.onEvent(null, "JSupport", 18, str, null, Integer.valueOf(i), Boolean.valueOf(z), str2, th);
    }

    public static void e(String str, String str2) {
        d(2, true, str, str2, null);
    }

    public static void f(String str, String str2) {
        d(5, true, str, str2, null);
    }

    public static void g(String str, String str2) {
        d(5, false, str, str2, null);
    }
}
