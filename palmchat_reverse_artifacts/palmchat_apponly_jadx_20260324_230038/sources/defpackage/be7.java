package defpackage;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class be7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1703a = false;

    public static void a(String str) {
        if (f1703a) {
            Log.d("IDHelper", str);
        }
    }

    public static void b(String str, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(":");
        sb.append(exc.getMessage() != null ? exc.getMessage() : exc.getLocalizedMessage());
        Log.e("IDHelper", sb.toString());
    }

    public static void c(String str) {
        Log.e("IDHelper", str);
    }
}
