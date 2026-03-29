package com.bytedance.embedapplog;

import android.content.Context;
import com.bytedance.embedapplog.ky;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class t implements ky {
    private static Method fx;
    private static Class<?> nr;
    private static Object u;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            nr = cls;
            u = cls.newInstance();
            fx = nr.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            ti.u("Api#static reflect exception! " + e.getMessage());
        }
    }

    public static boolean u() {
        return (nr == null || u == null || fx == null) ? false : true;
    }

    @Override // com.bytedance.embedapplog.ky
    public ky.u nr(Context context) {
        try {
            ky.u uVar = new ky.u();
            uVar.nr = u(context, fx);
            return uVar;
        } catch (Exception e) {
            ti.u(e);
            return null;
        }
    }

    @Override // com.bytedance.embedapplog.ky
    public boolean u(Context context) {
        return u();
    }

    private static String u(Context context, Method method) {
        Object obj = u;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
