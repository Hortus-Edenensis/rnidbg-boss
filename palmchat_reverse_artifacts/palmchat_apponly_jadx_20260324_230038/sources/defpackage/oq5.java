package defpackage;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class oq5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f19813a;

    public static boolean a(String str) {
        if (f19813a == null) {
            f19813a = Boolean.valueOf(Log.isLoggable("lx_log" + str, 2));
        }
        return f19813a.booleanValue();
    }
}
