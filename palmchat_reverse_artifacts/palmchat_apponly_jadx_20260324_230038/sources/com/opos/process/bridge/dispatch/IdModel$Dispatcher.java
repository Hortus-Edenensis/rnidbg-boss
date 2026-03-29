package com.opos.process.bridge.dispatch;

import android.content.Context;
import android.os.Bundle;
import com.opos.mobad.provider.openId.IdModel;
import com.opos.mobad.provider.openId.OpenIdData;
import com.opos.mobad.provider.openId.OutOpenIdWrapper;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.BundleUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class IdModel$Dispatcher implements IDispatcher {
    public static final String TARGET_CLASS = "com.opos.mobad.provider.openId.IdModel";

    public static void init() {
        a.a().a(TARGET_CLASS, new IdModel$Dispatcher());
    }

    @Override // com.opos.process.bridge.dispatch.IDispatcher
    public Bundle dispatch(Context context, String str, IBridgeTargetIdentify iBridgeTargetIdentify, int i, Object[] objArr) {
        switch (i) {
            case 1:
                return BundleUtil.packageBundle(((IdModel) IdModel.FACTORY.getInstance(context, iBridgeTargetIdentify)).a(), OpenIdData.class);
            case 2:
                return BundleUtil.packageBundle(Boolean.valueOf(((IdModel) IdModel.FACTORY.getInstance(context, iBridgeTargetIdentify)).b()), Boolean.TYPE);
            case 3:
                return BundleUtil.packageBundle(((IdModel) IdModel.FACTORY.getInstance(context, iBridgeTargetIdentify)).c(), String.class);
            case 4:
                return BundleUtil.packageBundle(((IdModel) IdModel.FACTORY.getInstance(context, iBridgeTargetIdentify)).d(), OpenIdData.class);
            case 5:
                return BundleUtil.packageBundle(((IdModel) IdModel.FACTORY.getInstance(context, iBridgeTargetIdentify)).e(), OutOpenIdWrapper.class);
            case 6:
                return BundleUtil.packageBundle(Boolean.valueOf(((IdModel) IdModel.FACTORY.getInstance(context, iBridgeTargetIdentify)).f()), Boolean.TYPE);
            case 7:
                return BundleUtil.packageBundle(Boolean.valueOf(((IdModel) IdModel.FACTORY.getInstance(context, iBridgeTargetIdentify)).g()), Boolean.TYPE);
            default:
                return BundleUtil.makeBundle(102002, "methodId:" + i);
        }
    }
}
