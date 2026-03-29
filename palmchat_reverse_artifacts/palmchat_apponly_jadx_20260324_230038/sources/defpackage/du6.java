package defpackage;

import android.content.Context;
import defpackage.zt6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class du6 {
    public static boolean a() {
        if (yt6.f22277a) {
            return yt6.b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String b(Context context) {
        if (yt6.f22277a) {
            return zt6.b.f22513a.a(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static void c(Context context) {
        yt6.b = zt6.b.f22513a.b(context.getApplicationContext());
        yt6.f22277a = true;
    }
}
