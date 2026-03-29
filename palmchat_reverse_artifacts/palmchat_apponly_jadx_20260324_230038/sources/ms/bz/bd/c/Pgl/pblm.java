package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class pblm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f19331a;

    public static String a(Context context) {
        if (context != null) {
            try {
                new DisplayMetrics();
                f19331a = context.getResources().getDisplayMetrics().densityDpi;
            } catch (Throwable unused) {
            }
        }
        return "" + f19331a;
    }
}
