package com.opos.process.bridge.server;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.openalliance.ad.constant.az;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.b.d;
import com.opos.process.bridge.b.f;
import com.opos.process.bridge.b.g;
import com.opos.process.bridge.b.h;
import com.opos.process.bridge.provider.BundleUtil;
import com.opos.process.bridge.provider.ProcessBridgeLog;
import com.opos.process.bridge.provider.ThreadLocalUtil;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ProcessBridgeProvider extends ContentProvider {
    private static final String TAG = "ProcessBridgeProvider";

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        bundle.setClassLoader(ProcessBridgeProvider.class.getClassLoader());
        String strDecodeParamsGetTargetClass = BundleUtil.decodeParamsGetTargetClass(bundle);
        Bundle bundle2 = bundle.getBundle(az.M);
        HashMap map = new HashMap();
        if (!"dispatch".equals(str)) {
            c.a().a(strDecodeParamsGetTargetClass, getCallingPackage(), 102000, "only support method [dispatch]");
            return BundleUtil.makeBundle(102000, "only support method [dispatch]");
        }
        g gVarA = new g.a().a(getContext()).a(getCallingPackage()).b(strDecodeParamsGetTargetClass).a(bundle2).a(map).a();
        for (f fVar : c.a().c()) {
            com.opos.process.bridge.b.b bVarA = fVar.a(gVarA);
            ProcessBridgeLog.d(TAG, "ServerInterceptor: " + fVar.getClass().getName() + ", result:" + bVarA);
            if (bVarA.c()) {
                c.a().a(getCallingPackage(), bVarA);
                return BundleUtil.makeInterceptorResultBundle(bVarA.a(), bVarA.b());
            }
        }
        IBridgeTargetIdentify iBridgeTargetIdentifyDecodeParamsGetIdentify = BundleUtil.decodeParamsGetIdentify(bundle);
        int iDecodeParamsGetMethodId = BundleUtil.decodeParamsGetMethodId(bundle);
        com.opos.process.bridge.b.d dVarA = new d.a().a(getContext()).a(getCallingPackage()).a(bundle2).b(strDecodeParamsGetTargetClass).a(iBridgeTargetIdentifyDecodeParamsGetIdentify).a(iDecodeParamsGetMethodId).a();
        for (h hVar : c.a().d()) {
            com.opos.process.bridge.b.b bVarA2 = hVar.a(dVarA);
            ProcessBridgeLog.d(TAG, "ServerMethodInterceptor: " + hVar.getClass().getName() + ", result:" + bVarA2);
            if (bVarA2.c()) {
                c.a().a(getCallingPackage(), bVarA2);
                return BundleUtil.makeInterceptorResultBundle(bVarA2.a(), bVarA2.b());
            }
        }
        try {
            Object[] objArrDecodeParamsGetArgs = BundleUtil.decodeParamsGetArgs(bundle);
            ThreadLocalUtil.put(map);
            Bundle bundleA = com.opos.process.bridge.dispatch.a.a().a(getContext(), getCallingPackage(), strDecodeParamsGetTargetClass, iBridgeTargetIdentifyDecodeParamsGetIdentify, iDecodeParamsGetMethodId, objArrDecodeParamsGetArgs);
            ThreadLocalUtil.remove((Set<String>) map.keySet());
            return bundleA;
        } catch (Exception e) {
            c.a().a(strDecodeParamsGetTargetClass, getCallingPackage(), 101008, e.getMessage());
            return BundleUtil.makeExceptionBundle(e);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
