package defpackage;

import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class kf7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f18683a = "ReflectHelp";
    public static boolean b = false;

    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable th) {
            if (b) {
                Log.w(f18683a, "reflect:" + th.getMessage());
            }
            return null;
        }
    }

    public static Object b(Class cls, String str, Class[] clsArr, Object[] objArr) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            try {
                Method methodC = c(cls, str, clsArr);
                if (methodC != null) {
                    methodC.setAccessible(true);
                    return methodC.invoke(null, objArr);
                }
            } catch (Throwable th) {
                if (b) {
                    Log.w(f18683a, "reflect:" + th.getMessage());
                }
            }
        }
        return null;
    }

    public static Method c(Class cls, String str, Class[] clsArr) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            try {
                try {
                    return cls.getDeclaredMethod(str, clsArr);
                } catch (Exception unused) {
                    return cls.getMethod(str, clsArr);
                }
            } catch (Exception unused2) {
                if (cls.getSuperclass() != null) {
                    return c(cls.getSuperclass(), str, clsArr);
                }
            }
        }
        return null;
    }
}
