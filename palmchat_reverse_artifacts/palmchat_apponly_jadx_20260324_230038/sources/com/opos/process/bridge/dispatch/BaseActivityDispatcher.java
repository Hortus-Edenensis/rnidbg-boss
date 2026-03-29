package com.opos.process.bridge.dispatch;

import android.app.Activity;
import android.os.Bundle;
import com.huawei.openalliance.ad.constant.az;
import com.opos.process.bridge.b.b;
import com.opos.process.bridge.b.d;
import com.opos.process.bridge.b.f;
import com.opos.process.bridge.b.g;
import com.opos.process.bridge.b.h;
import com.opos.process.bridge.provider.BundleUtil;
import com.opos.process.bridge.provider.ProcessBridgeLog;
import com.opos.process.bridge.provider.ThreadLocalUtil;
import com.opos.process.bridge.server.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class BaseActivityDispatcher implements IActivityDispatcher {
    private static final String TAG = "BaseActivityDispatcher";

    @Override // com.opos.process.bridge.dispatch.IActivityDispatcher
    public void dispatch(Activity activity) {
        b bVarA;
        ProcessBridgeLog.d(TAG, "dispatch this");
        if (activity.getIntent() == null || activity.getIntent().getExtras() == null) {
            activity.finish();
            return;
        }
        Bundle bundle = activity.getIntent().getExtras().getBundle(az.M);
        HashMap map = new HashMap();
        String strDecodeParamsGetTargetClass = BundleUtil.decodeParamsGetTargetClass(activity.getIntent().getExtras());
        g gVarA = new g.a().a(activity).a(activity.getCallingPackage()).b(strDecodeParamsGetTargetClass).a(bundle).a(map).a();
        Iterator<f> it = c.a().c().iterator();
        while (true) {
            if (!it.hasNext()) {
                int iDecodeParamsGetMethodId = BundleUtil.decodeParamsGetMethodId(activity.getIntent().getExtras());
                ProcessBridgeLog.d(TAG, "targetClass:" + strDecodeParamsGetTargetClass + ", methodId:" + iDecodeParamsGetMethodId);
                d dVarA = new d.a().a(activity).a(activity.getCallingPackage()).a(bundle).b(strDecodeParamsGetTargetClass).a(iDecodeParamsGetMethodId).a();
                for (h hVar : c.a().d()) {
                    bVarA = hVar.a(dVarA);
                    ProcessBridgeLog.d(TAG, "ServerMethodInterceptor: " + hVar.getClass().getName() + ", result:" + bVarA);
                    if (bVarA.c()) {
                    }
                }
                try {
                    Object[] objArrDecodeParamsGetArgs = BundleUtil.decodeParamsGetArgs(activity.getIntent().getExtras());
                    ThreadLocalUtil.put(map);
                    ProcessBridgeLog.d(TAG, "dispatch ");
                    dispatch(activity, strDecodeParamsGetTargetClass, iDecodeParamsGetMethodId, objArrDecodeParamsGetArgs);
                    ThreadLocalUtil.remove((Set<String>) map.keySet());
                    return;
                } catch (Exception e) {
                    c.a().a(activity.getClass().getName(), activity.getCallingPackage(), 101008, e.getMessage());
                    return;
                }
            }
            f next = it.next();
            bVarA = next.a(gVarA);
            ProcessBridgeLog.d(TAG, "ServerInterceptor: " + next.getClass().getName() + ", result:" + bVarA);
            if (bVarA.c()) {
                break;
            }
        }
        c.a().a(activity.getCallingPackage(), bVarA);
        activity.finish();
    }

    public abstract void dispatch(Activity activity, String str, int i, Object[] objArr);
}
