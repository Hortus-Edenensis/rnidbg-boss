package cn.fly.verify;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static gb f2063a;

    static {
        try {
            gb gbVar = new gb(ax.g());
            f2063a = gbVar;
            gbVar.a("Fly_Pure_Cache", 1);
        } catch (Throwable unused) {
        }
    }

    public static String a(String str) {
        return f2063a.a(str);
    }

    public static void b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            f2063a.e(str);
        } else {
            f2063a.a(str, str2);
        }
    }

    public static String a(String str, String str2) {
        return f2063a.b(str, str2);
    }
}
