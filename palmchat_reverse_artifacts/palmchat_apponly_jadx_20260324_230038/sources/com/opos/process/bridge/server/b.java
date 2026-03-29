package com.opos.process.bridge.server;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.openalliance.ad.constant.az;
import com.opos.process.bridge.a;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.b.d;
import com.opos.process.bridge.b.f;
import com.opos.process.bridge.b.g;
import com.opos.process.bridge.b.h;
import com.opos.process.bridge.provider.BundleUtil;
import com.opos.process.bridge.provider.ProcessBridgeLog;
import com.opos.process.bridge.provider.ThreadLocalUtil;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b extends a.AbstractBinderC0820a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10386a;
    private Map<String, Object> b;

    public b(Context context, Map<String, Object> map) {
        this.f10386a = context;
        this.b = map;
    }

    @Override // com.opos.process.bridge.a
    public Bundle a(Bundle bundle) throws RemoteException {
        String str;
        String[] packagesForUid = this.f10386a.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (packagesForUid == null || packagesForUid.length != 1) {
            ProcessBridgeLog.e("ProcessBridgeBinder", "could not find correct package name");
            str = "";
        } else {
            str = packagesForUid[0];
            ProcessBridgeLog.d("ProcessBridgeBinder", "callingPackage:" + str);
        }
        bundle.setClassLoader(ProcessBridgeProvider.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle(az.M);
        String strDecodeParamsGetTargetClass = BundleUtil.decodeParamsGetTargetClass(bundle);
        g gVarA = new g.a().a(this.f10386a).a(str).b(strDecodeParamsGetTargetClass).a(bundle2).a(this.b).a();
        for (f fVar : c.a().c()) {
            com.opos.process.bridge.b.b bVarA = fVar.a(gVarA);
            ProcessBridgeLog.d("ProcessBridgeBinder", "ServerInterceptor: " + fVar.getClass().getName() + ", result:" + bVarA);
            if (bVarA.c()) {
                c.a().a(str, bVarA);
                return BundleUtil.makeInterceptorResultBundle(bVarA.a(), bVarA.b());
            }
        }
        IBridgeTargetIdentify iBridgeTargetIdentifyDecodeParamsGetIdentify = BundleUtil.decodeParamsGetIdentify(bundle);
        int iDecodeParamsGetMethodId = BundleUtil.decodeParamsGetMethodId(bundle);
        com.opos.process.bridge.b.d dVarA = new d.a().a(this.f10386a).a(str).a(bundle2).b(strDecodeParamsGetTargetClass).a(iBridgeTargetIdentifyDecodeParamsGetIdentify).a(iDecodeParamsGetMethodId).a();
        for (h hVar : c.a().d()) {
            com.opos.process.bridge.b.b bVarA2 = hVar.a(dVarA);
            ProcessBridgeLog.d("ProcessBridgeBinder", "ServerMethodInterceptor: " + hVar.getClass().getName() + ", result:" + bVarA2);
            if (bVarA2.c()) {
                c.a().a(str, bVarA2);
                return BundleUtil.makeInterceptorResultBundle(bVarA2.a(), bVarA2.b());
            }
        }
        try {
            Object[] objArrDecodeParamsGetArgs = BundleUtil.decodeParamsGetArgs(bundle);
            ThreadLocalUtil.put(this.b);
            Bundle bundleA = com.opos.process.bridge.dispatch.a.a().a(this.f10386a, str, strDecodeParamsGetTargetClass, iBridgeTargetIdentifyDecodeParamsGetIdentify, iDecodeParamsGetMethodId, objArrDecodeParamsGetArgs);
            ThreadLocalUtil.remove(this.b.keySet());
            return bundleA;
        } catch (Exception e) {
            c.a().a(strDecodeParamsGetTargetClass, str, 101008, e.getMessage());
            return BundleUtil.makeExceptionBundle(e);
        }
    }
}
