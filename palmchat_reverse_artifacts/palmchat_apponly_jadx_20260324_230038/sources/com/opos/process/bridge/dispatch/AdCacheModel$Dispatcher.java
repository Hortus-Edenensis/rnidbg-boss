package com.opos.process.bridge.dispatch;

import android.content.Context;
import android.os.Bundle;
import com.opos.mobad.provider.ad.AdCacheModel;
import com.opos.mobad.provider.ad.AdEntity;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.BundleUtil;
import com.opos.process.bridge.server.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class AdCacheModel$Dispatcher implements IDispatcher {
    public static final String TARGET_CLASS = "com.opos.mobad.provider.ad.AdCacheModel";

    public static void init() {
        a.a().a(TARGET_CLASS, new AdCacheModel$Dispatcher());
    }

    @Override // com.opos.process.bridge.dispatch.IDispatcher
    public Bundle dispatch(Context context, String str, IBridgeTargetIdentify iBridgeTargetIdentify, int i, Object[] objArr) {
        Object obj;
        Object obj2;
        Object obj3;
        if (i == 1) {
            if (2 == objArr.length && (((obj = objArr[0]) == null || (obj instanceof String)) && ((obj2 = objArr[1]) == null || (obj2 instanceof AdEntity)))) {
                ((AdCacheModel) AdCacheModel.FACTORY.getInstance(context, iBridgeTargetIdentify)).a((String) objArr[0], (AdEntity) objArr[1]);
                return BundleUtil.makeBundle(0, "");
            }
            c.a().a(TARGET_CLASS, str, 102003, "received params not match");
            return BundleUtil.makeBundle(102003, "received params not match");
        }
        if (i != 2) {
            return BundleUtil.makeBundle(102002, "methodId:" + i);
        }
        if (1 == objArr.length && ((obj3 = objArr[0]) == null || (obj3 instanceof String))) {
            return BundleUtil.packageBundle(((AdCacheModel) AdCacheModel.FACTORY.getInstance(context, iBridgeTargetIdentify)).a((String) objArr[0]), AdEntity.class);
        }
        c.a().a(TARGET_CLASS, str, 102003, "received params not match");
        return BundleUtil.makeBundle(102003, "received params not match");
    }
}
