package defpackage;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class w97 {
    public static String a(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return String.format("[%s][%s]", str, str2);
    }

    public static void c(String str, String str2, Throwable th) {
        b(a(str, str2) + " " + e(th));
    }

    public static void d(Throwable th) {
        if (th == null) {
            return;
        }
        try {
            b(e(th));
        } catch (Throwable unused) {
        }
    }

    public static String e(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void f(String str, String str2) {
        b(a(str, str2));
    }

    public static void g(String str, String str2) {
        b(a(str, str2));
    }

    public static void h(String str, String str2) {
        b(a(str, str2));
    }

    public static void i(String str, String str2) {
        b(a(str, str2));
    }

    public static void b(String str) {
    }
}
