package cn.fly.verify;

import android.os.Looper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class bc {
    public static <T> T a(bd bdVar, String str, Class<T> cls, T t) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            en.a().b("WARNING: gt mta in main: key = " + str);
        }
        Object objA = ec.a(str, cls, bdVar);
        if (objA == null) {
            objA = ec.a(str);
        }
        return objA == null ? t : (T) objA;
    }
}
