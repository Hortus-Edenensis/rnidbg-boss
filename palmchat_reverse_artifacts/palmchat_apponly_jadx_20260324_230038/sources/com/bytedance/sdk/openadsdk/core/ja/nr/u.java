package com.bytedance.sdk.openadsdk.core.ja.nr;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static Map<String, Field> u = new HashMap();

    private static String nr(Class<?> cls, String str) {
        return cls.toString() + "#" + str;
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
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                synchronized (u) {
                    continue;
                    u.put(strNr, declaredField);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static Object u(Field field, Object obj) throws IllegalAccessException {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    public static Object u(Object obj, String str) throws IllegalAccessException {
        Field fieldU = u(obj.getClass(), str);
        if (fieldU != null) {
            return u(fieldU, obj);
        }
        return null;
    }
}
