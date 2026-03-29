package com.oplus.tblplayer.utils;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ReflectUtil {
    private static final String TAG = "ReflectUtil";

    public static boolean checkIsType(Class<?> cls, Object obj) {
        if (obj == null || cls == null) {
            return false;
        }
        return cls.isAssignableFrom(obj.getClass());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Class] */
    public static <T> T getConstField(String str, Class<T> cls, String str2) {
        try {
            T cls2 = Class.forName(str);
            while (cls2 != 0) {
                try {
                    Field field = ((Class) cls2).getField(str2);
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (obj != null && cls.isInstance(obj)) {
                        cls2 = cls.cast(obj);
                        return cls2;
                    }
                    cls2 = (T) ((Class) cls2).getSuperclass();
                } catch (NoSuchFieldException unused) {
                    cls2 = cls2.getSuperclass();
                } catch (Throwable unused2) {
                    return null;
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "getConstField: " + e.getMessage());
        }
        return null;
    }

    public static Object getDeclaredInstance(Class<?> cls, Class<?>[] clsArr, Object... objArr) {
        try {
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(objArr);
        } catch (Exception e) {
            Log.e(TAG, "getDeclaredInstance: " + e.getMessage());
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    public static <T> T getField(Object obj, Class<T> cls, String str) {
        Class<?> superclass = obj.getClass();
        while (superclass != null) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (obj2 != null && cls.isInstance(obj2)) {
                    obj = cls.cast(obj2);
                    return obj;
                }
                superclass = superclass.getSuperclass();
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
            } catch (Throwable unused2) {
                return null;
            }
        }
        return null;
    }

    public static Object getInstance(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            return Class.forName(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Exception e) {
            Log.e(TAG, "getInstance: " + e.getMessage());
            return null;
        }
    }

    public static Object invoke(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object... objArr) throws Exception {
        Method method = cls.getMethod(str, clsArr);
        method.setAccessible(true);
        return method.invoke(obj, objArr);
    }

    public static Object invokeNoException(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            return invoke(cls, obj, str, clsArr, objArr);
        } catch (Exception e) {
            Log.e(TAG, "invokeNoException: " + e.getMessage());
            return null;
        }
    }

    public static <T> void setField(Object obj, Class<T> cls, String str, Object obj2) {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                declaredField.set(obj, obj2);
                return;
            } catch (NoSuchFieldException unused) {
            } catch (Throwable th) {
                Log.e(TAG, "setField: " + th.getMessage());
                return;
            }
        }
    }

    public static boolean checkIsType(String str, Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return checkIsType(Class.forName(str), obj);
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "checkIsType: " + e.getMessage());
            return false;
        }
    }

    public static Object invoke(String str, Object obj, String str2, Class<?>[] clsArr, Object... objArr) throws Exception {
        return invoke(Class.forName(str), obj, str2, clsArr, objArr);
    }

    public static Object invokeNoException(String str, Object obj, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            return invokeNoException(Class.forName(str), obj, str2, clsArr, objArr);
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "invokeNoException: " + e.getMessage());
            return null;
        }
    }
}
