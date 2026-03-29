package com.zx.a.I8b7;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<Class<? extends b>, b> f16845a = new HashMap();

    public static void a(Context context, Class<? extends b> cls, Class<? extends c>... clsArr) throws IllegalAccessException, InstantiationException {
        Context applicationContext = context.getApplicationContext();
        b bVarNewInstance = (b) ((HashMap) f16845a).get(cls);
        if (bVarNewInstance == null) {
            bVarNewInstance = cls.newInstance();
            ((HashMap) f16845a).put(cls, bVarNewInstance);
        }
        for (Class<? extends c> cls2 : clsArr) {
            c cVarNewInstance = bVarNewInstance.f16776a.get(cls2);
            if (cVarNewInstance == null) {
                cVarNewInstance = cls2.newInstance();
                bVarNewInstance.f16776a.put(cls2, cVarNewInstance);
            }
            cVarNewInstance.f16785a = bVarNewInstance;
        }
        if (bVarNewInstance.c.getAndSet(true)) {
            return;
        }
        bVarNewInstance.b = new a(bVarNewInstance, applicationContext, bVarNewInstance.a(), null, bVarNewInstance.c());
        Iterator<Class<? extends c>> it = bVarNewInstance.f16776a.keySet().iterator();
        while (it.hasNext()) {
            bVarNewInstance.f16776a.get(it.next()).getClass();
        }
    }

    public static <T extends c> T a(Class<? extends b> cls, Class<T> cls2) {
        b bVar = (b) ((HashMap) f16845a).get(cls);
        if (bVar != null) {
            T t = (T) bVar.f16776a.get(cls2);
            if (t != null) {
                return t;
            }
            StringBuilder sbA = f3.a("table ");
            sbA.append(cls2.getSimpleName());
            sbA.append(" has not been added to db ");
            sbA.append(bVar.a());
            throw new RuntimeException(sbA.toString());
        }
        StringBuilder sbA2 = f3.a("db ");
        sbA2.append(cls.getSimpleName());
        sbA2.append(" has not been initialized");
        throw new RuntimeException(sbA2.toString());
    }
}
