package a.a.c.a.e;

import android.os.SystemProperties;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Object f1123a;

    public final Object a() {
        if (f1123a == null) {
            synchronized (d.class) {
                if (f1123a == null) {
                    try {
                        f1123a = Class.forName("android.os.SystemProperties").newInstance();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
        return f1123a;
    }

    public String a(String str) {
        try {
            return SystemProperties.get(str);
        } catch (Throwable th) {
            th.printStackTrace();
            try {
                Object objA = a();
                return (String) objA.getClass().getMethod("get", String.class).invoke(objA, str);
            } catch (IllegalArgumentException e) {
                throw e;
            } catch (Throwable unused) {
                return "";
            }
        }
    }
}
