package com.bytedance.pangle.nr.nr;

import com.bytedance.pangle.log.ZeusLogger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static Method b;
    private static Method fx;
    private static Method nr;
    private static Method u;

    static {
        try {
            u = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            nr = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            fx = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
            b = Class.class.getDeclaredMethod("forName", String.class);
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "DoubleReflectorinit failed", th);
        }
    }

    public static Field u(Class<?> cls, String str) {
        Throwable th;
        Field field;
        Method method = u;
        Field field2 = null;
        if (method != null) {
            try {
                field = (Field) method.invoke(cls, str);
                if (field != null) {
                    try {
                        field.setAccessible(true);
                    } catch (Throwable th2) {
                        th = th2;
                        ZeusLogger.w(ZeusLogger.TAG, "DoubleReflector" + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                field = null;
            }
            field2 = field;
        }
        return field2 != null ? field2 : com.bytedance.pangle.nr.u.u.u(cls, str);
    }

    public static Method u(Class<?> cls, String str, Class<?>... clsArr) {
        Throwable th;
        Method method;
        Method method2 = nr;
        Method method3 = null;
        if (method2 != null) {
            try {
                method = (Method) method2.invoke(cls, str, clsArr);
                if (method != null) {
                    try {
                        method.setAccessible(true);
                    } catch (Throwable th2) {
                        th = th2;
                        ZeusLogger.w(ZeusLogger.TAG, "DoubleReflector" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                method = null;
            }
            method3 = method;
        }
        return method3 != null ? method3 : com.bytedance.pangle.nr.u.u.u(cls, str, clsArr);
    }

    public static Constructor u(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        Method method = fx;
        if (method != null) {
            try {
                constructor = (Constructor) method.invoke(cls, clsArr);
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder("DoubleReflector");
                Object[] objArr = new Object[2];
                objArr[0] = cls.getName();
                objArr[1] = Integer.valueOf(clsArr != null ? clsArr.length : 0);
                sb.append(String.format("getConstructor %s<init>%s failed !!!", objArr));
                ZeusLogger.w(ZeusLogger.TAG, sb.toString(), th);
                constructor = null;
            }
        } else {
            constructor = null;
        }
        return constructor != null ? constructor : com.bytedance.pangle.nr.u.u.u(cls, clsArr);
    }
}
