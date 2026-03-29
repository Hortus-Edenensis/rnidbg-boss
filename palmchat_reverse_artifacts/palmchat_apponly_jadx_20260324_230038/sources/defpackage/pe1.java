package defpackage;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class pe1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f20001a = false;

    public static void a(String str, String str2) {
        if (f20001a) {
            return;
        }
        Log.i(str, str2);
    }

    public static void b(String str, String str2, Exception exc) {
        if (f20001a) {
            return;
        }
        Log.i(str, str2, exc);
    }

    public static boolean c() {
        return !f20001a;
    }

    public static void d(boolean z) {
        f20001a = z;
    }
}
