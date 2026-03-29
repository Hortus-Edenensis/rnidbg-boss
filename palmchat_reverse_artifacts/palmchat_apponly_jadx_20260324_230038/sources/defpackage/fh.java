package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class fh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f17529a;

    public static Context a() {
        Context context = f17529a;
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Please init app at first!");
    }

    public static void b(Context context) {
        f17529a = context.getApplicationContext();
    }
}
