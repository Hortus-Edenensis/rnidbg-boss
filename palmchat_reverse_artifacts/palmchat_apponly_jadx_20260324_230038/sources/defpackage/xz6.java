package defpackage;

import com.alipay.sdk.m.j.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class xz6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f22087a = false;
    public static String b;

    public static String a() {
        c cVarB = c.b(c.CANCELED.b());
        return b(cVarB.b(), cVarB.a(), "");
    }

    public static String b(int i, String str, String str2) {
        return "resultStatus={" + i + "};memo={" + str + "};result={" + str2 + "}";
    }

    public static void c(String str) {
        b = str;
    }

    public static void d(boolean z) {
        f22087a = z;
    }

    public static String e() {
        c cVarB = c.b(c.DOUBLE_REQUEST.b());
        return b(cVarB.b(), cVarB.a(), "");
    }

    public static boolean f() {
        return f22087a;
    }

    public static String g() {
        return b;
    }

    public static String h() {
        c cVarB = c.b(c.PARAMS_ERROR.b());
        return b(cVarB.b(), cVarB.a(), "");
    }
}
