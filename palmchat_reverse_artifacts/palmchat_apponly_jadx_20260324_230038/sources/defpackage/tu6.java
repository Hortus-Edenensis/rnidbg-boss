package defpackage;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class tu6 {
    public static String a(Context context, String str, String str2) {
        synchronized (tu6.class) {
            String strE = null;
            if (context != null) {
                try {
                    if (!xu6.c(str) && !xu6.c(str2)) {
                        try {
                            String strA = xa7.a(context, str, str2, "");
                            if (xu6.c(strA)) {
                                return null;
                            }
                            strE = m37.e(m37.a(), strA);
                        } catch (Throwable unused) {
                        }
                        return strE;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return null;
        }
    }

    public static void b(Context context, String str, String str2, String str3) {
        synchronized (tu6.class) {
            if (xu6.c(str) || xu6.c(str2) || context == null) {
                return;
            }
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
