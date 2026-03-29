package com.bytedance.pangle.nr.u;

import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static Map<String, Field> u = new HashMap();
    private static Map<String, Method> nr = new HashMap();
    private static Map<String, Constructor> fx = new HashMap();
    private static Map<String, Class> b = new HashMap();

    static {
        try {
            FieldUtils.writeField(nr.class, "classLoader", (Object) null);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "HackHelper HackHelperImpl use BootClassLoader");
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "HackHelperinit failed", e);
        }
    }

    private static String nr(Class<?> cls, String str) {
        return cls.getName() + "#" + str;
    }

    public static Field u(Class<?> cls, String str) {
        Field field;
        String strNr = nr(cls, str);
        synchronized (u) {
            field = u.get(strNr);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        try {
            Field fieldU = nr.u(cls, str);
            if (fieldU != null) {
                synchronized (u) {
                    u.put(strNr, fieldU);
                }
            }
            return fieldU;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    private static String nr(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName());
        sb.append("#");
        sb.append(str);
        if (clsArr == null || clsArr.length <= 0) {
            sb.append(Void.class.getName());
        } else {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.getName());
                sb.append("#");
            }
        }
        return sb.toString();
    }

    public static Method u(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        String strNr = nr(cls, str, clsArr);
        synchronized (nr) {
            method = nr.get(strNr);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        try {
            Method methodU = nr.u(cls, str, clsArr);
            if (methodU != null) {
                synchronized (nr) {
                    nr.put(strNr, methodU);
                }
            }
            return methodU;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    public static Constructor u(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        String strNr = nr(cls, "clinit", clsArr);
        synchronized (fx) {
            constructor = fx.get(strNr);
        }
        if (constructor != null) {
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor;
        }
        try {
            Constructor constructorU = nr.u(cls, clsArr);
            if (constructorU != null) {
                synchronized (fx) {
                    fx.put(strNr, constructorU);
                }
            }
            return constructorU;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getConstructor %s failed !!!", cls.getName()), th);
            return null;
        }
    }
}
