package defpackage;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class w77 {
    public static synchronized void a(Context context, String str, String str2, String str3) {
        if (!xu6.c(str)) {
            if (!xu6.c(str2) && context != null) {
                try {
                    String strB = m37.b(m37.a(), str3);
                    HashMap map = new HashMap();
                    map.put(str2, strB);
                    xa7.b(context, str, map);
                } catch (Throwable unused) {
                }
            }
        }
    }
}
