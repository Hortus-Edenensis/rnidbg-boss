package com.bytedance.sdk.openadsdk.x;

import android.util.SparseArray;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u implements nr {
    private Object nr;
    private SparseArray<Method> u = new SparseArray<>();

    @Override // com.bytedance.sdk.openadsdk.x.nr
    public <T> T call(int i, Object... objArr) {
        Object obj;
        Method method = this.u.get(i);
        if (method == null || (obj = this.nr) == null) {
            u();
            return null;
        }
        try {
            return obj instanceof Class ? (T) method.invoke(null, objArr) : (T) method.invoke(obj, objArr);
        } catch (Throwable th) {
            u();
            th.getMessage();
            return null;
        }
    }

    public abstract String u();

    @Override // com.bytedance.sdk.openadsdk.x.nr
    public void u(int i, Method method) {
        this.u.put(i, method);
    }

    @Override // com.bytedance.sdk.openadsdk.x.nr
    public void u(Object obj) {
        this.nr = obj;
    }
}
