package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ct implements Serializable {
    private static Map<Class<? extends ch>, Map<? extends co, ct>> d = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10913a;
    public final byte b;
    public final cu c;

    public ct(String str, byte b, cu cuVar) {
        this.f10913a = str;
        this.b = b;
        this.c = cuVar;
    }

    public static void a(Class<? extends ch> cls, Map<? extends co, ct> map) {
        d.put(cls, map);
    }

    public static Map<? extends co, ct> a(Class<? extends ch> cls) {
        if (!d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (IllegalAccessException e) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e.getMessage());
            } catch (InstantiationException e2) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e2.getMessage());
            }
        }
        return d.get(cls);
    }
}
