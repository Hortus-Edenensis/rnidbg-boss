package com.opos.process.bridge.dispatch;

import android.content.Context;
import android.os.Bundle;
import com.heytap.msp.opos.sv.interapi.CommonAdModule;
import com.heytap.msp.opos.sv.interapi.bean.commonad.deeplink.DeepLinkRequest;
import com.heytap.msp.opos.sv.interapi.bean.commonad.deeplink.DeepLinkResult;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.BundleUtil;
import com.opos.process.bridge.server.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class CommonAdModule$Dispatcher implements IDispatcher {
    public static final String TARGET_CLASS = "com.heytap.msp.opos.sv.interapi.CommonAdModule";

    public static void init() {
        a.a().a("com.heytap.msp.opos.sv.interapi.CommonAdModule", new CommonAdModule$Dispatcher());
    }

    @Override // com.opos.process.bridge.dispatch.IDispatcher
    public Bundle dispatch(Context context, String str, IBridgeTargetIdentify iBridgeTargetIdentify, int i, Object[] objArr) {
        Object obj;
        if (i != 0) {
            return BundleUtil.makeBundle(102002, "methodId:" + i);
        }
        if (1 == objArr.length && ((obj = objArr[0]) == null || (obj instanceof DeepLinkRequest))) {
            return BundleUtil.packageBundle(((CommonAdModule) CommonAdModule.FACTORY.getInstance(context, iBridgeTargetIdentify)).executeDeepLink((DeepLinkRequest) objArr[0]), DeepLinkResult.class);
        }
        c.a().a("com.heytap.msp.opos.sv.interapi.CommonAdModule", str, 102003, "received params not match");
        return BundleUtil.makeBundle(102003, "received params not match");
    }
}
