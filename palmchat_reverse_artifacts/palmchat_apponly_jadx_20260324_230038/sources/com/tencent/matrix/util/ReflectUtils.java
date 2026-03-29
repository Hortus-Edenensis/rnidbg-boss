package com.tencent.matrix.util;

import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ReflectUtils {
    private static final String TAG = "Matrix.ReflectUtils";

    public static <T> T get(Class<?> cls, String str) throws Exception {
        return (T) new ReflectFiled(cls, str).get();
    }

    public static <T> T invoke(Class<?> cls, String str, Object obj, Object... objArr) throws Exception {
        return (T) new ReflectMethod(cls, str, new Class[0]).invoke(obj, objArr);
    }

    public static Method reflectMethod(Object obj, boolean z, String str, Class<?>... clsArr) {
        if (z) {
            try {
                Method method = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class).invoke(obj.getClass(), str, clsArr);
                method.setAccessible(true);
                return method;
            } catch (Exception e) {
                MatrixLog.e(TAG, e.toString() + "isHard=%s\n%s", Boolean.TRUE, MatrixUtil.printException(e));
                return null;
            }
        }
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception e2) {
            MatrixLog.e(TAG, e2.toString() + "isHard=%s\n%s", Boolean.FALSE, MatrixUtil.printException(e2));
            return null;
        }
    }

    public static <T> T reflectObject(Object obj, String str, T t, boolean z) {
        if (obj == null) {
            return t;
        }
        if (z) {
            try {
                Field field = (Field) Class.class.getDeclaredMethod("getDeclaredField", String.class).invoke(obj.getClass(), str);
                field.setAccessible(true);
                return (T) field.get(obj);
            } catch (Exception e) {
                MatrixLog.e(TAG, e.toString() + "isHard=%s\n%s", Boolean.TRUE, MatrixUtil.printException(e));
            }
        } else {
            try {
                Field declaredField = obj.getClass().getDeclaredField(str);
                declaredField.setAccessible(true);
                return (T) declaredField.get(obj);
            } catch (Exception e2) {
                MatrixLog.e(TAG, e2.toString() + "isHard=%s\n%s", Boolean.FALSE, MatrixUtil.printException(e2));
            }
        }
        return t;
    }

    public static boolean set(Class<?> cls, String str, Object obj) throws Exception {
        return new ReflectFiled(cls, str).set(obj);
    }

    public static <T> T get(Class<?> cls, String str, Object obj) throws Exception {
        return (T) new ReflectFiled(cls, str).get(obj);
    }

    public static boolean set(Class<?> cls, String str, Object obj, Object obj2) throws Exception {
        return new ReflectFiled(cls, str).set(obj, obj2);
    }

    public static Method reflectMethod(Object obj, String str, Class<?>... clsArr) {
        return reflectMethod(obj, Build.VERSION.SDK_INT <= 29, str, clsArr);
    }

    public static <T> T reflectObject(Object obj, String str, T t) {
        return (T) reflectObject(obj, str, t, true);
    }
}
