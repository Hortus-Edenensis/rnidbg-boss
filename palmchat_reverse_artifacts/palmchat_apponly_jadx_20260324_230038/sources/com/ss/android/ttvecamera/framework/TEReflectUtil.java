package com.ss.android.ttvecamera.framework;

import com.ss.android.ttvecamera.TELogUtils;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TEReflectUtil {
    private static final String TAG = "TEReflectUtil";

    private static Method findMethod(Class<? extends Object> cls, String str, Object[] objArr) {
        for (Method method : cls.getDeclaredMethods()) {
            if (method.getName().equals(str) && matches(method.getParameterTypes(), objArr)) {
                return method;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            return findMethod(superclass, str, objArr);
        }
        return null;
    }

    public static <T> T invoke(Object obj, String str, Object[] objArr) {
        try {
            Method methodFindMethod = findMethod(obj.getClass(), str, objArr);
            methodFindMethod.setAccessible(true);
            return (T) methodFindMethod.invoke(obj, objArr);
        } catch (Exception e) {
            TELogUtils.w(TAG, "couldn't invoke " + str + " on " + obj + ", " + e);
            return null;
        }
    }

    public static <T> T invokeStatic(String str, String str2, Object[] objArr) {
        try {
            Method methodFindMethod = findMethod(Class.forName(str), str2, objArr);
            methodFindMethod.setAccessible(true);
            return (T) methodFindMethod.invoke(null, objArr);
        } catch (Exception e) {
            TELogUtils.w(TAG, "couldn't invoke " + str2 + ", " + e);
            return null;
        }
    }

    private static boolean matches(Class<?>[] clsArr, Object[] objArr) {
        if (clsArr == null || clsArr.length == 0) {
            return objArr == null || objArr.length == 0;
        }
        if (objArr == null || clsArr.length != objArr.length) {
            return false;
        }
        for (int i = 0; i < clsArr.length; i++) {
            Object obj = objArr[i];
            if (obj != null && !clsArr[i].isAssignableFrom(obj.getClass())) {
                return false;
            }
        }
        return true;
    }
}
