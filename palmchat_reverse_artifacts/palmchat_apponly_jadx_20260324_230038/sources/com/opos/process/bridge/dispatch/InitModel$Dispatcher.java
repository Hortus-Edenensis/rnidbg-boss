package com.opos.process.bridge.dispatch;

import android.content.Context;
import android.os.Bundle;
import com.opos.mobad.provider.init.InitModel;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.BundleUtil;
import com.opos.process.bridge.server.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class InitModel$Dispatcher implements IDispatcher {
    public static final String TARGET_CLASS = "com.opos.mobad.provider.init.InitModel";

    public static void init() {
        a.a().a(TARGET_CLASS, new InitModel$Dispatcher());
    }

    @Override // com.opos.process.bridge.dispatch.IDispatcher
    public Bundle dispatch(Context context, String str, IBridgeTargetIdentify iBridgeTargetIdentify, int i, Object[] objArr) {
        Object obj;
        Object obj2;
        Object obj3;
        if (i != 1) {
            return BundleUtil.makeBundle(102002, "methodId:" + i);
        }
        if (3 == objArr.length && (((obj = objArr[0]) == null || (obj instanceof Boolean)) && (((obj2 = objArr[1]) == null || (obj2 instanceof Boolean)) && ((obj3 = objArr[2]) == null || (obj3 instanceof String))))) {
            ((InitModel) InitModel.FACTORY.getInstance(context, iBridgeTargetIdentify)).a(((Boolean) objArr[0]).booleanValue(), ((Boolean) objArr[1]).booleanValue(), (String) objArr[2]);
            return BundleUtil.makeBundle(0, "");
        }
        c.a().a(TARGET_CLASS, str, 102003, "received params not match");
        return BundleUtil.makeBundle(102003, "received params not match");
    }
}
