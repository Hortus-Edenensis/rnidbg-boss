package defpackage;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class h87 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f17895a = false;

    public static void a() {
        f17895a = true;
    }

    public static void b(String str, String str2) {
        if (f17895a) {
            Log.d(str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        String str3;
        StringBuilder sb;
        String message;
        if (th != null) {
            if (f17895a) {
                sb = new StringBuilder();
                sb.append(str2);
                sb.append("##Throwable##");
                message = Log.getStackTraceString(th);
            } else {
                sb = new StringBuilder();
                sb.append(str2);
                message = th.getMessage();
            }
            sb.append(message);
            Log.d(str, sb.toString());
            str3 = null;
        } else {
            str3 = "throwable is null";
        }
        f(str, str2 + str3);
    }

    public static void d(String str, Throwable th) {
        c(str, "", th);
    }

    public static void e(String str, String str2) {
        if (f17895a) {
            Log.i(str, str2);
        }
    }

    public static void f(String str, String str2) {
        Log.e(str, str2);
    }
}
