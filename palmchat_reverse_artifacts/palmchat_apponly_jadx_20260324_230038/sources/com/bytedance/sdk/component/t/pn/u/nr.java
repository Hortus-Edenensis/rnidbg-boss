package com.bytedance.sdk.component.t.pn.u;

import com.bytedance.sdk.component.t.pn.u.u.b;
import com.bytedance.sdk.component.t.pn.u.u.fx;
import com.bytedance.sdk.component.t.pn.u.u.iz;
import com.bytedance.sdk.component.t.pn.u.u.n;
import com.bytedance.sdk.component.t.pn.u.u.pn;
import com.bytedance.sdk.component.t.pn.u.u.x;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private static final Map<Class, u> u;

    static {
        HashMap map = new HashMap();
        u = map;
        iz izVar = new iz();
        n nVar = new n();
        x xVar = new x();
        com.bytedance.sdk.component.t.pn.u.u.nr nrVar = new com.bytedance.sdk.component.t.pn.u.u.nr();
        b bVar = new b();
        pn pnVar = new pn();
        com.bytedance.sdk.component.t.pn.u.u.u uVar = new com.bytedance.sdk.component.t.pn.u.u.u();
        fx fxVar = new fx();
        map.put(Integer.class, izVar);
        map.put(Integer.TYPE, izVar);
        map.put(Short.class, nVar);
        map.put(Short.TYPE, nVar);
        map.put(Long.class, xVar);
        map.put(Long.TYPE, xVar);
        map.put(Byte.class, nrVar);
        map.put(Byte.TYPE, nrVar);
        map.put(Double.class, bVar);
        map.put(Double.TYPE, bVar);
        map.put(Float.class, pnVar);
        map.put(Float.TYPE, pnVar);
        map.put(Boolean.class, uVar);
        map.put(Boolean.TYPE, uVar);
        map.put(Character.class, fxVar);
        map.put(Character.TYPE, fxVar);
    }

    public static void u(Object obj, Field field, Object obj2) {
        Object objU;
        if (field == null || obj2 == null) {
            return;
        }
        Class<?> type = field.getType();
        try {
            objU = type.getConstructor(new Class[0]).newInstance(obj2);
        } catch (Throwable unused) {
            objU = u(type, obj2);
        }
        try {
            field.setAccessible(true);
            field.set(obj, objU);
        } catch (Throwable unused2) {
        }
    }

    public static void u(Object obj, Map<String, Object> map, Field field, String str) {
        Object obj2;
        if (field == null || (obj2 = map.get(str)) == null) {
            return;
        }
        field.setAccessible(true);
        try {
            field.set(obj, obj2);
        } catch (Throwable unused) {
            u(obj, field, obj2);
        }
    }

    public static Object u(Class cls, Object obj) {
        String strValueOf = String.valueOf(obj);
        if (String.class.equals(cls)) {
            return strValueOf;
        }
        u uVar = u.get(cls);
        return uVar == null ? obj : uVar.u(cls, strValueOf);
    }
}
