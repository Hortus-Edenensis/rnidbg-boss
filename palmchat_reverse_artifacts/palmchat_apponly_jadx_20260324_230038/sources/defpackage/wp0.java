package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class wp0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f21768a;

    public static Context a() {
        return f21768a;
    }

    public static void b(Context context) {
        if (context == null || f21768a != null) {
            return;
        }
        f21768a = context.getApplicationContext();
    }
}
