package com.bytedance.sdk.openadsdk.core.y;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class z {
    private static Method fx;
    private static Method nr;
    private static Method u;

    static {
        try {
            u = Class.class.getDeclaredMethod("forName", String.class);
            nr = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            fx = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (NoSuchMethodException | NullPointerException unused) {
        }
    }

    public static Object u(Object obj, String str, String str2, Object obj2) {
        try {
            Field fieldU = u(str, str2);
            if (fieldU == null) {
                return obj2;
            }
            fieldU.setAccessible(true);
            return fieldU.get(obj);
        } catch (IllegalAccessException unused) {
            return obj2;
        }
    }

    public static Field u(String str, String str2) {
        if (!u()) {
            return null;
        }
        try {
            Field field = (Field) fx.invoke((Class) u.invoke(null, str), str2);
            try {
                field.setAccessible(true);
            } catch (Throwable unused) {
            }
            return field;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static boolean u() {
        return (u == null || nr == null || fx == null) ? false : true;
    }
}
