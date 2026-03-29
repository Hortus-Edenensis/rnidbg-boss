package com.bytedance.sdk.openadsdk.core.nr.u;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private final Map<Class, u> u = new HashMap();

    private <T extends u> T nr(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (Throwable unused) {
            try {
                Constructor<T> declaredConstructor = cls.getDeclaredConstructor(bc.class, Context.class);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(null, null);
            } catch (Throwable unused2) {
                return null;
            }
        }
    }

    public fx u(bc bcVar, Context context, com.bytedance.sdk.openadsdk.core.nr.b bVar, boolean z) {
        fx fxVar = new fx(bVar);
        com.bytedance.sdk.openadsdk.core.nr.u.nr.u uVar = new com.bytedance.sdk.openadsdk.core.nr.u.nr.u(bcVar, context);
        this.u.put(com.bytedance.sdk.openadsdk.core.nr.u.nr.u.class, uVar);
        nr nrVar = new nr(bcVar, context);
        this.u.put(nr.class, nrVar);
        com.bytedance.sdk.openadsdk.core.nr.u.u.u uVarU = u(bcVar, context);
        this.u.put(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class, uVarU);
        com.bytedance.sdk.openadsdk.core.nr.u.fx.u uVar2 = new com.bytedance.sdk.openadsdk.core.nr.u.fx.u(bcVar, context);
        this.u.put(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class, uVar2);
        com.bytedance.sdk.openadsdk.core.nr.u.fx.fx fxVar2 = new com.bytedance.sdk.openadsdk.core.nr.u.fx.fx(bcVar, context);
        this.u.put(com.bytedance.sdk.openadsdk.core.nr.u.fx.fx.class, fxVar2);
        fxVar.u(fxVar2);
        fxVar.u(uVar);
        fxVar.u(nrVar);
        fxVar.u(uVarU);
        fxVar.u(uVar2);
        return fxVar;
    }

    private com.bytedance.sdk.openadsdk.core.nr.u.u.u u(bc bcVar, Context context) {
        com.bytedance.sdk.openadsdk.core.nr.u.u.fx fxVar = new com.bytedance.sdk.openadsdk.core.nr.u.u.fx();
        fxVar.u(bcVar);
        fxVar.u(context);
        return fxVar;
    }

    public <T extends u> T u(Class<T> cls) {
        T t = (T) this.u.get(cls);
        return t == null ? (T) nr(cls) : t;
    }
}
