package com.lantern.daemon.dp3.utils;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class Reflection {
    private static final String TAG = "Reflection";
    private static Object sVmRuntime;
    private static Method setHiddenApiExemptions;

    static {
        if (Build.VERSION.SDK_INT >= 27) {
            try {
                Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
                Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
                Method method = (Method) declaredMethod2.invoke(cls, "getRuntime", null);
                setHiddenApiExemptions = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
                sVmRuntime = method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                Log.w(TAG, "reflect bootstrap failed:", th);
            }
        }
    }

    public static boolean exempt(String str) {
        return exempt(str);
    }

    public static boolean exemptAll() {
        return exempt("L");
    }

    public static int unseal(Context context) {
        return (Build.VERSION.SDK_INT >= 28 && !exemptAll()) ? -1 : 0;
    }

    public static boolean exempt(String... strArr) {
        Method method;
        Object obj = sVmRuntime;
        if (obj != null && (method = setHiddenApiExemptions) != null) {
            try {
                method.invoke(obj, strArr);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
