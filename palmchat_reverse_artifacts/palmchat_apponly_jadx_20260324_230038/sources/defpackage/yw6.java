package defpackage;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class yw6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f22295a = "yw6";
    public static boolean b = false;

    public static void a(String str) {
        if (b) {
            Log.d(f22295a, str);
        }
    }

    public static void b(String str) {
        if (b) {
            Log.e(f22295a, str);
        }
    }
}
