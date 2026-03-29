package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class k63 {
    public static void a(String str, String str2) {
        c63.b("JCore", str, true, 3, str2, null);
    }

    public static void b(String str, String str2) {
        c63.b("JCore", str, false, 3, str2, null);
    }

    public static void c(String str, String str2) {
        c63.b("JCore", str, true, 6, str2, null);
    }

    public static void d(String str, String str2, Throwable th) {
        c63.b("JCore", str, true, 6, str2, th);
    }

    public static void e(String str, String str2) {
        c63.b("JCore", str, false, 6, str2, null);
    }

    public static void f(String str, String str2, Throwable th) {
        c63.b("JCore", str, false, 6, str2, th);
    }

    public static void g(String str, String str2) {
        c63.b("JCore", str, true, 4, str2, null);
    }

    public static void h(String str, String str2) {
        c63.b("JCore", str, false, 4, str2, null);
    }

    public static void i(String str, String str2, Throwable th) {
        f(str, str2, th);
        if (tv2.f) {
            throw new RuntimeException(th);
        }
    }

    public static void j(String str, String str2) {
        c63.b("JCore", str, true, 2, str2, null);
    }

    public static void k(String str, String str2) {
        c63.b("JCore", str, false, 2, str2, null);
    }

    public static void l(String str, String str2) {
        c63.b("JCore", str, true, 5, str2, null);
    }

    public static void m(String str, String str2, Throwable th) {
        c63.b("JCore", str, true, 5, str2, th);
    }

    public static void n(String str, String str2) {
        c63.b("JCore", str, false, 5, str2, null);
    }

    public static void o(String str, String str2, Throwable th) {
        c63.b("JCore", str, false, 5, str2, th);
    }
}
