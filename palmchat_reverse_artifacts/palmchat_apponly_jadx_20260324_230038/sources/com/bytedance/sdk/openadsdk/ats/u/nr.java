package com.bytedance.sdk.openadsdk.ats.u;

import com.bytedance.sdk.component.b.t;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements t {
    private Method b;
    private Method fx;
    private boolean iz;
    private Method nr;
    private Method pn;
    private Class u;

    public nr() {
        try {
            Class<?> clsLoadClass = getClass().getClassLoader().loadClass("android.os.SystemProperties");
            this.u = clsLoadClass;
            Method declaredMethod = clsLoadClass.getDeclaredMethod("get", String.class);
            this.nr = declaredMethod;
            declaredMethod.setAccessible(true);
            this.iz = true;
        } catch (Exception unused) {
            this.u = null;
            this.iz = false;
        }
    }

    private Method u(String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = this.u.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.b.t
    public String get(String str) {
        return (String) u(this.nr, str);
    }

    @Override // com.bytedance.sdk.component.b.t
    public boolean getBoolean(String str) {
        if (this.pn == null) {
            this.pn = u("getBoolean", String.class, Boolean.TYPE);
        }
        Boolean bool = (Boolean) u(this.pn, str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.b.t
    public int getInt(String str) {
        if (this.fx == null) {
            this.fx = u("getInt", String.class, Integer.TYPE);
        }
        Integer num = (Integer) u(this.fx, str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.b.t
    public long getLong(String str) {
        if (this.b == null) {
            this.b = u("getLong", String.class, Long.TYPE);
        }
        Long l = (Long) u(this.b, str);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    private <T> T u(Method method, String str) {
        if (method == null) {
            return null;
        }
        try {
            return (T) method.invoke(this.u, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean u() {
        return this.iz;
    }

    @Override // com.bytedance.sdk.component.b.t
    public void set(String str, String str2) {
    }
}
