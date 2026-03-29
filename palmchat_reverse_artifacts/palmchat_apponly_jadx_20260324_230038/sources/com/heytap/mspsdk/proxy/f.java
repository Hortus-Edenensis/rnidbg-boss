package com.heytap.mspsdk.proxy;

import android.content.Context;
import android.text.TextUtils;
import com.heytap.msp.ipc.a.l;
import com.heytap.msp.ipc.annotation.IPCBridgeMethod;
import com.heytap.msp.ipc.common.exception.IPCBridgeException;
import com.heytap.mspsdk.constants.MspSdkCode;
import com.heytap.mspsdk.exception.MspProxyException;
import com.heytap.mspsdk.exception.MspSdkException;
import com.heytap.mspsdk.log.MspLog;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
class f implements com.heytap.msp.ipc.c.a, com.heytap.mspsdk.interceptor.b<e, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.heytap.mspsdk.core.b f6410a;
    private final d b;

    public f(d dVar) {
        this.b = dVar;
    }

    @Override // com.heytap.msp.ipc.c.a
    public l a(Context context, List<l> list) {
        if (list != null && !list.isEmpty()) {
            for (l lVar : list) {
                if (TextUtils.equals(lVar.a(), this.f6410a.f())) {
                    MspLog.iIgnore("PackageReplace", "filter target = " + lVar);
                    return lVar;
                }
            }
        }
        return null;
    }

    @Override // com.heytap.mspsdk.interceptor.b
    public Object a(com.heytap.mspsdk.interceptor.a<e, Object> aVar) {
        Object objA;
        Object objA2;
        e eVarA = aVar.a();
        this.f6410a = eVarA.d;
        Object obj = eVarA.f6409a;
        Class cls = obj instanceof Class ? (Class) obj : null;
        if (cls == null || !cls.isInterface()) {
            throw new MspSdkException(2007, MspSdkCode.EXCEPTION_MSG_2007_INTERFACE_ERROR);
        }
        IPCBridgeMethod iPCBridgeMethod = (IPCBridgeMethod) eVarA.b.getAnnotation(IPCBridgeMethod.class);
        if (iPCBridgeMethod == null) {
            throw new MspSdkException(2008, MspSdkCode.EXCEPTION_MSG_2008_METHOD_NO_ANNOTATION);
        }
        com.heytap.msp.ipc.a.g gVarA = this.b.a(this.f6410a, eVarA.a());
        try {
            if (gVarA instanceof com.heytap.msp.ipc.a.d) {
                ((com.heytap.msp.ipc.a.d) gVarA).a(iPCBridgeMethod.methodId(), eVarA.c);
                return null;
            }
            Class<?> returnType = eVarA.b.getReturnType();
            if (gVarA instanceof com.heytap.msp.ipc.a.e) {
                com.heytap.msp.ipc.a.e eVar = (com.heytap.msp.ipc.a.e) gVarA;
                eVar.a(this);
                objA = eVar.a(iPCBridgeMethod.methodId(), eVarA.c);
            } else if (gVarA instanceof com.heytap.msp.ipc.a.f) {
                com.heytap.msp.ipc.a.f fVar = (com.heytap.msp.ipc.a.f) gVarA;
                fVar.a(this);
                objA = fVar.a(iPCBridgeMethod.methodId(), eVarA.c);
            } else {
                objA = null;
            }
            if (returnType == Void.TYPE) {
                return null;
            }
            return (returnType.isPrimitive() && objA == null && (objA2 = com.heytap.mspsdk.util.f.a(returnType)) != null) ? objA2 : objA;
        } catch (IPCBridgeException e) {
            throw new MspProxyException(e);
        }
    }
}
