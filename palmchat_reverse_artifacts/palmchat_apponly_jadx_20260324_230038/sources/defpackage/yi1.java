package defpackage;

import com.zenmen.palmchat.framework.config.DynamicVo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class yi1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static pl2 f22204a;

    public static DynamicVo a(String str) {
        pl2 pl2Var = f22204a;
        if (pl2Var != null) {
            return pl2Var.e(str);
        }
        return null;
    }

    public static boolean b() {
        pl2 pl2Var = f22204a;
        if (pl2Var != null) {
            return pl2Var.c();
        }
        return false;
    }

    public static String c() {
        pl2 pl2Var = f22204a;
        if (pl2Var != null) {
            return pl2Var.a();
        }
        return null;
    }

    public static boolean d() {
        pl2 pl2Var = f22204a;
        if (pl2Var != null) {
            return pl2Var.b();
        }
        return false;
    }

    public static String e() {
        pl2 pl2Var = f22204a;
        return pl2Var != null ? pl2Var.d() : "";
    }

    public static void f(pl2 pl2Var) {
        f22204a = pl2Var;
    }
}
