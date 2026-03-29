package com.bytedance.pangle.fragment;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import com.bytedance.sdk.openadsdk.api.iz;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class u {
    public static void u(Class cls) {
        try {
            if (Fragment.class.getName().contains("support")) {
                ((SimpleArrayMap) u(Fragment.class, "sClassMap").get(null)).put(cls.getName(), cls);
                return;
            }
            Field fieldU = u(Fragment.class, "sClassMap");
            if (fieldU != null) {
                ((SimpleArrayMap) fieldU.get(null)).put(cls.getName(), cls);
                return;
            }
            Class clsU = u("androidx.fragment.app.FragmentFactory");
            if (clsU == null) {
                return;
            }
            Field fieldU2 = u(clsU, "sClassMap");
            if (fieldU2 != null) {
                ((SimpleArrayMap) fieldU2.get(null)).put(cls.getName(), cls);
                return;
            }
            Field fieldU3 = u(clsU, "sClassCacheMap");
            if (fieldU3 != null) {
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) fieldU3.get(null);
                SimpleArrayMap simpleArrayMap2 = new SimpleArrayMap();
                simpleArrayMap2.put(cls.getName(), cls);
                simpleArrayMap.put(cls.getClassLoader(), simpleArrayMap2);
            }
        } catch (Exception e) {
            iz.u(e);
        }
    }

    private static Field u(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            return declaredField;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    private static Class u(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
