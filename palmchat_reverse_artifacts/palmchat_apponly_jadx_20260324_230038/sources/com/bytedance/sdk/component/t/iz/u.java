package com.bytedance.sdk.component.t.iz;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends nr {
    private u() {
    }

    public static u u() {
        if (nr.u != null) {
            return nr.u;
        }
        synchronized (u.class) {
            if (nr.u != null) {
                return nr.u;
            }
            u uVar = new u();
            nr.u = uVar;
            return uVar;
        }
    }

    public com.bytedance.sdk.component.t.u.u.u u(com.bytedance.sdk.component.t.u.u.u uVar) {
        try {
            Class<?> cls = uVar.getClass();
            return (cls.isAnnotationPresent(com.bytedance.sdk.component.t.nr.nr.class) && !"SINGLETON".equals(((com.bytedance.sdk.component.t.nr.nr) cls.getAnnotation(com.bytedance.sdk.component.t.nr.nr.class)).u())) ? (com.bytedance.sdk.component.t.u.u.u) cls.newInstance() : uVar;
        } catch (Throwable unused) {
            return uVar;
        }
    }

    public void u(Object obj, Map<String, Object> map) {
        if (obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls.isAnnotationPresent(com.bytedance.sdk.component.t.nr.nr.class)) {
            u(obj, map, cls);
        }
    }

    private static void u(Object obj, Map<String, Object> map, Class<?> cls) {
        com.bytedance.sdk.component.t.nr.u uVar;
        for (Field field : u(cls)) {
            if (field != null && field.isAnnotationPresent(com.bytedance.sdk.component.t.nr.u.class) && (uVar = (com.bytedance.sdk.component.t.nr.u) field.getAnnotation(com.bytedance.sdk.component.t.nr.u.class)) != null) {
                field.setAccessible(true);
                String strU = uVar.u();
                if (TextUtils.isEmpty(strU)) {
                    strU = com.bytedance.sdk.component.t.n.u.u(field.getName(), true);
                }
                if (!TextUtils.isEmpty(strU)) {
                    com.bytedance.sdk.component.t.pn.u.nr.u(obj, map, field, strU);
                }
            }
        }
    }

    public static Field[] u(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null && cls != Object.class) {
            arrayList.addAll(new ArrayList(Arrays.asList(cls.getDeclaredFields())));
            cls = cls.getSuperclass();
        }
        return (Field[]) arrayList.toArray(new Field[arrayList.size()]);
    }
}
