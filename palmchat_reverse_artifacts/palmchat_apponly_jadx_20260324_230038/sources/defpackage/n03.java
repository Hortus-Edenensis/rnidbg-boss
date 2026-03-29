package defpackage;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class n03 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f19404a = true;

    public static void a(Throwable th) {
        b(6, th, null, new Object[0]);
    }

    public static void b(int i, Throwable th, String str, Object... objArr) {
        if (f19404a) {
            if (objArr.length > 0) {
                str = String.format(str, objArr);
            }
            if (th != null) {
                if (str == null) {
                    str = th.getMessage();
                }
                str = String.format("%1$s\n%2$s", str, Log.getStackTraceString(th));
            }
            Log.println(i, gr2.b, str);
        }
    }
}
