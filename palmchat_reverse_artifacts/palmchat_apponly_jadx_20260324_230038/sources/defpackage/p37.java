package defpackage;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class p37 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static g07 f19933a = null;
    public static boolean b = false;

    public static synchronized String a(Context context) {
        if (context == null) {
            throw new RuntimeException("Context is null");
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        b(context);
        g07 g07Var = f19933a;
        if (g07Var != null) {
            try {
                return g07Var.a(context);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static void b(Context context) {
        if (f19933a != null || b) {
            return;
        }
        synchronized (p37.class) {
            if (f19933a == null && !b) {
                f19933a = cv6.a(context);
                b = true;
            }
        }
    }
}
