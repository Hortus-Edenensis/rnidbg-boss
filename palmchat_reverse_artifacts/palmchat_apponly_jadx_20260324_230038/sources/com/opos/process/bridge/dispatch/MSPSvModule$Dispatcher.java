package com.opos.process.bridge.dispatch;

import android.content.Context;
import android.os.Bundle;
import com.heytap.msp.opos.sv.interapi.MSPSvModule;
import com.heytap.msp.opos.sv.interapi.bean.csc.InitConfig;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.BundleUtil;
import com.opos.process.bridge.server.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class MSPSvModule$Dispatcher implements IDispatcher {
    public static final String TARGET_CLASS = "com.heytap.msp.opos.sv.interapi.MSPSvModule";

    public static void init() {
        a.a().a("com.heytap.msp.opos.sv.interapi.MSPSvModule", new MSPSvModule$Dispatcher());
    }

    @Override // com.opos.process.bridge.dispatch.IDispatcher
    public Bundle dispatch(Context context, String str, IBridgeTargetIdentify iBridgeTargetIdentify, int i, Object[] objArr) {
        Object obj;
        if (i != 0) {
            return BundleUtil.makeBundle(102002, "methodId:" + i);
        }
        if (1 == objArr.length && ((obj = objArr[0]) == null || (obj instanceof InitConfig))) {
            ((MSPSvModule) MSPSvModule.FACTORY.getInstance(context, iBridgeTargetIdentify)).init((InitConfig) objArr[0]);
            return BundleUtil.makeBundle(0, "");
        }
        c.a().a("com.heytap.msp.opos.sv.interapi.MSPSvModule", str, 102003, "received params not match");
        return BundleUtil.makeBundle(102003, "received params not match");
    }
}
