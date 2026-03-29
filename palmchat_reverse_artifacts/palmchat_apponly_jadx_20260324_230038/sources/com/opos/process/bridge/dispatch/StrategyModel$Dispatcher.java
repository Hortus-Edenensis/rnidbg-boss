package com.opos.process.bridge.dispatch;

import android.content.Context;
import android.os.Bundle;
import com.opos.mobad.provider.strategy.AppInfo;
import com.opos.mobad.provider.strategy.StrategyInfo;
import com.opos.mobad.provider.strategy.StrategyModel;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.BundleUtil;
import com.opos.process.bridge.server.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class StrategyModel$Dispatcher implements IDispatcher {
    public static final String TARGET_CLASS = "com.opos.mobad.provider.strategy.StrategyModel";

    public static void init() {
        a.a().a(TARGET_CLASS, new StrategyModel$Dispatcher());
    }

    @Override // com.opos.process.bridge.dispatch.IDispatcher
    public Bundle dispatch(Context context, String str, IBridgeTargetIdentify iBridgeTargetIdentify, int i, Object[] objArr) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        if (i == 1) {
            if (3 == objArr.length && (((obj = objArr[0]) == null || (obj instanceof String)) && (((obj2 = objArr[1]) == null || (obj2 instanceof String)) && ((obj3 = objArr[2]) == null || (obj3 instanceof AppInfo))))) {
                ((StrategyModel) StrategyModel.FACTORY.getInstance(context, iBridgeTargetIdentify)).a((String) objArr[0], (String) objArr[1], (AppInfo) objArr[2]);
                return BundleUtil.makeBundle(0, "");
            }
            c.a().a(TARGET_CLASS, str, 102003, "received params not match");
            return BundleUtil.makeBundle(102003, "received params not match");
        }
        if (i == 2) {
            if (2 == objArr.length && (((obj4 = objArr[0]) == null || (obj4 instanceof String)) && ((obj5 = objArr[1]) == null || (obj5 instanceof StrategyInfo)))) {
                ((StrategyModel) StrategyModel.FACTORY.getInstance(context, iBridgeTargetIdentify)).a((String) objArr[0], (StrategyInfo) objArr[1]);
                return BundleUtil.makeBundle(0, "");
            }
            c.a().a(TARGET_CLASS, str, 102003, "received params not match");
            return BundleUtil.makeBundle(102003, "received params not match");
        }
        if (i == 3) {
            if (1 == objArr.length && ((obj6 = objArr[0]) == null || (obj6 instanceof String))) {
                return BundleUtil.packageBundle(((StrategyModel) StrategyModel.FACTORY.getInstance(context, iBridgeTargetIdentify)).a((String) objArr[0]), Bundle.class);
            }
            c.a().a(TARGET_CLASS, str, 102003, "received params not match");
            return BundleUtil.makeBundle(102003, "received params not match");
        }
        if (i != 4) {
            if (i == 5) {
                return BundleUtil.packageBundle(((StrategyModel) StrategyModel.FACTORY.getInstance(context, iBridgeTargetIdentify)).a(), AppInfo.class);
            }
            return BundleUtil.makeBundle(102002, "methodId:" + i);
        }
        if (1 == objArr.length && ((obj7 = objArr[0]) == null || (obj7 instanceof String))) {
            return BundleUtil.packageBundle(((StrategyModel) StrategyModel.FACTORY.getInstance(context, iBridgeTargetIdentify)).b((String) objArr[0]), AppInfo.class);
        }
        c.a().a(TARGET_CLASS, str, 102003, "received params not match");
        return BundleUtil.makeBundle(102003, "received params not match");
    }
}
