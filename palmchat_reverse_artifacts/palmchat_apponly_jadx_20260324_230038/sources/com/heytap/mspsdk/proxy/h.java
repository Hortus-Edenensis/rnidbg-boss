package com.heytap.mspsdk.proxy;

import com.heytap.mspsdk.constants.MspSdkCode;
import com.heytap.mspsdk.exception.MspProxyException;
import com.heytap.mspsdk.exception.MspSdkException;
import com.heytap.mspsdk.log.MspLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class h implements com.heytap.mspsdk.interceptor.b<e, Object> {
    @Override // com.heytap.mspsdk.interceptor.b
    public Object a(com.heytap.mspsdk.interceptor.a<e, Object> aVar) {
        return a(aVar.a());
    }

    private Object a(e eVar) {
        eVar.a("realCallStart");
        return a(eVar.f6409a, eVar.b, eVar.c, eVar.e);
    }

    private Object a(Object obj, Method method, Object[] objArr, com.heytap.mspsdk.event.a aVar) {
        int length;
        if (objArr == null) {
            length = -1;
        } else {
            try {
                length = objArr.length;
            } catch (IllegalAccessException e) {
                throw new MspSdkException(MspSdkCode.CODE_REFLECT_EXCEPTION, "reflect exception:" + e.getMessage());
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                aVar.l();
                if (cause != null) {
                    throw new MspProxyException(cause);
                }
                throw ((RuntimeException) a(e2));
            }
        }
        MspLog.iIgnore("RealIPCInterceptor", "before invoke [" + obj.getClass().getSimpleName() + "#" + method.getName() + "], len(args) = " + length + ", thread name = " + Thread.currentThread().getName());
        aVar.m();
        Object objInvoke = method.invoke(obj, objArr);
        aVar.o();
        aVar.n();
        MspLog.iIgnore("RealIPCInterceptor", "after invoke [" + obj.getClass().getSimpleName() + "#" + method.getName() + "]");
        return objInvoke;
    }

    private static <T extends Throwable> T a(Throwable th) throws Throwable {
        throw th;
    }
}
