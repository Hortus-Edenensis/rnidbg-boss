package com.unicom.xiaowo.account.shield.b;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class d implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f11185a;

    public d(e eVar) {
        this.f11185a = eVar;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        if ("onResult".equals(method.getName())) {
            c.b().b((String) objArr[0]);
            return null;
        }
        c.b().a("调用失败");
        return null;
    }
}
