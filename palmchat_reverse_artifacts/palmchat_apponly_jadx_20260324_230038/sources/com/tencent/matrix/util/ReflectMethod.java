package com.tencent.matrix.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ReflectMethod {
    private static final String TAG = "ReflectFiled";
    private Class<?> mClazz;
    private boolean mInit;
    private Method mMethod;
    private String mMethodName;
    private Class[] mParameterTypes;

    public ReflectMethod(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null || str == null || str.length() == 0) {
            throw new IllegalArgumentException("Both of invoker and fieldName can not be null or nil.");
        }
        this.mClazz = cls;
        this.mMethodName = str;
        this.mParameterTypes = clsArr;
    }

    private synchronized void prepare() {
        if (this.mInit) {
            return;
        }
        for (Class<?> superclass = this.mClazz; superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod(this.mMethodName, this.mParameterTypes);
                declaredMethod.setAccessible(true);
                this.mMethod = declaredMethod;
                break;
            } catch (Exception unused) {
            }
        }
        this.mInit = true;
    }

    public synchronized <T> T invoke(Object obj, Object... objArr) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException, InvocationTargetException {
        return (T) invoke(obj, false, objArr);
    }

    public synchronized <T> T invokeWithoutThrow(Object obj, Object... objArr) {
        try {
            try {
                return (T) invoke(obj, true, objArr);
            } catch (IllegalAccessException e) {
                MatrixLog.e(TAG, "invokeWithoutThrow, exception occur :%s", e);
                return null;
            } catch (NoSuchFieldException e2) {
                MatrixLog.e(TAG, "invokeWithoutThrow, exception occur :%s", e2);
                return null;
            }
        } catch (IllegalArgumentException e3) {
            MatrixLog.e(TAG, "invokeWithoutThrow, exception occur :%s", e3);
            return null;
        } catch (InvocationTargetException e4) {
            MatrixLog.e(TAG, "invokeWithoutThrow, exception occur :%s", e4);
            return null;
        }
    }

    public synchronized <T> T invoke(Object obj, boolean z, Object... objArr) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException, InvocationTargetException {
        prepare();
        Method method = this.mMethod;
        if (method != null) {
            return (T) method.invoke(obj, objArr);
        }
        if (z) {
            MatrixLog.w(TAG, "Field %s is no exists", this.mMethodName);
            return null;
        }
        throw new NoSuchFieldException("Method " + this.mMethodName + " is not exists.");
    }
}
