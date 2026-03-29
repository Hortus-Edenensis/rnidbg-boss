package defpackage;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class z53 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f22353a = true;

    public static int a(String str, String str2) {
        if (!f22353a || str2 == null) {
            return -1;
        }
        return Log.d(str, str2);
    }

    public static int b(String str, String str2) {
        if (!f22353a || str2 == null) {
            return -1;
        }
        return Log.e(str, str2);
    }

    public static int c(String str, String str2, Throwable th) {
        if (!f22353a || str2 == null) {
            return -1;
        }
        return Log.e(str, str2, th);
    }

    public static int d(String str, String str2) {
        if (!f22353a || str2 == null) {
            return -1;
        }
        return Log.i(str, str2);
    }
}
