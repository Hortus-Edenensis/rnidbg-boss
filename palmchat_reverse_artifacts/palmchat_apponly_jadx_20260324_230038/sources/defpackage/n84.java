package defpackage;

import android.content.Context;
import defpackage.h27;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class n84 {
    public static void a(Context context) {
        gx6.b = h27.b.f17865a.b(context.getApplicationContext());
        gx6.f17832a = true;
    }

    public static boolean b() {
        if (gx6.f17832a) {
            return gx6.b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (gx6.f17832a) {
            return h27.b.f17865a.a(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
