package com.heytap.mspsdk.proxy;

import android.os.Bundle;
import android.os.Parcelable;
import com.heytap.mspsdk.constants.MspSdkCode;
import com.heytap.mspsdk.event.b;
import com.heytap.mspsdk.exception.MspBridgeWrapException;
import com.heytap.mspsdk.exception.MspProxyException;
import com.heytap.mspsdk.exception.MspSdkException;
import com.heytap.mspsdk.exception.MspUnHandledException;
import com.heytap.mspsdk.log.MspLog;
import com.opos.process.bridge.provider.BridgeException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.LinkedList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
class d implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f6408a;
    private final Object b;
    private final com.heytap.mspsdk.event.b c;
    private final Bundle d;
    private final Parcelable e;
    private com.heytap.msp.ipc.a.g f;

    public d(a aVar, Object obj, Parcelable parcelable, Bundle bundle, com.heytap.mspsdk.event.b bVar) {
        this.f6408a = aVar;
        this.b = obj;
        this.c = bVar;
        this.e = parcelable;
        this.d = bundle;
    }

    public Parcelable a() {
        return this.e;
    }

    public com.heytap.msp.ipc.a.g b() {
        return this.f;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Throwable cause;
        boolean z = false;
        if (method.getDeclaringClass() == Object.class) {
            if ("hashCode".equals(method.getName())) {
                return Integer.valueOf(hashCode());
            }
            if ("equals".equals(method.getName())) {
                if (objArr.length > 0 && objArr[0] != null && hashCode() == objArr[0].hashCode()) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        }
        try {
            com.heytap.mspsdk.event.b bVar = this.c;
            com.heytap.mspsdk.event.a aVarA = bVar != null ? bVar.a() : new b.a();
            aVarA.a();
            com.heytap.mspsdk.core.b bVarA = com.heytap.mspsdk.core.b.a(com.heytap.mspsdk.core.e.a().b());
            e eVar = new e(this.b, method, objArr, bVarA, this.d, aVarA);
            eVar.a("invokeStart");
            LinkedList linkedList = new LinkedList();
            linkedList.add(new b());
            if (bVarA.c() && com.heytap.mspsdk.core.b.g()) {
                linkedList.add(new i());
                linkedList.add(new g(this.f6408a));
            }
            linkedList.add((!bVarA.c() || (this.b instanceof Class)) ? new f(this) : new h());
            com.heytap.mspsdk.interceptor.c cVar = new com.heytap.mspsdk.interceptor.c(linkedList, 0, eVar);
            eVar.a("chainProceedStart");
            RESPONSE responseA = cVar.a(eVar);
            eVar.a("chainProceedEnd");
            return responseA;
        } catch (Throwable th) {
            MspLog.e(th);
            if (!(th instanceof MspProxyException) || (cause = th.getCause()) == null) {
                if (th instanceof MspSdkException) {
                    throw th;
                }
                throw new MspUnHandledException(th);
            }
            if (cause instanceof BridgeException) {
                throw new MspBridgeWrapException(cause.getMessage(), cause, ((BridgeException) cause).getCode());
            }
            if (cause instanceof MspSdkException) {
                throw cause;
            }
            throw new MspUnHandledException(cause);
        }
    }

    public com.heytap.msp.ipc.a.g a(com.heytap.mspsdk.core.b bVar, Bundle bundle) {
        com.heytap.msp.ipc.a.g gVar = this.f;
        if (gVar != null) {
            return gVar;
        }
        Object obj = this.b;
        Class cls = obj instanceof Class ? (Class) obj : null;
        if (cls == null || !cls.isInterface()) {
            throw new MspSdkException(2007, MspSdkCode.EXCEPTION_MSG_2007_INTERFACE_ERROR);
        }
        com.heytap.msp.ipc.a.g gVarA = com.heytap.mspsdk.core.c.a(com.heytap.mspsdk.core.e.a().b(), cls, a(), bundle);
        this.f = gVarA;
        gVarA.a(new c(bVar));
        return this.f;
    }
}
