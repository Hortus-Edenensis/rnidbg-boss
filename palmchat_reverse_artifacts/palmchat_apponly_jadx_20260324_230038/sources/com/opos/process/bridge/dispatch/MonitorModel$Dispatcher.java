package com.opos.process.bridge.dispatch;

import android.content.Context;
import android.os.Bundle;
import com.opos.cmn.biz.monitor.MonitorEvent;
import com.opos.mobad.provider.monitor.MonitorModel;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.BundleUtil;
import com.opos.process.bridge.server.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class MonitorModel$Dispatcher implements IDispatcher {
    public static final String TARGET_CLASS = "com.opos.mobad.provider.monitor.MonitorModel";

    public static void init() {
        a.a().a(TARGET_CLASS, new MonitorModel$Dispatcher());
    }

    @Override // com.opos.process.bridge.dispatch.IDispatcher
    public Bundle dispatch(Context context, String str, IBridgeTargetIdentify iBridgeTargetIdentify, int i, Object[] objArr) {
        Object obj;
        Object obj2;
        if (i != 1) {
            return BundleUtil.makeBundle(102002, "methodId:" + i);
        }
        if (2 == objArr.length && (((obj = objArr[0]) == null || (obj instanceof String)) && ((obj2 = objArr[1]) == null || (obj2 instanceof MonitorEvent)))) {
            ((MonitorModel) MonitorModel.FACTORY.getInstance(context, iBridgeTargetIdentify)).a((String) objArr[0], (MonitorEvent) objArr[1]);
            return BundleUtil.makeBundle(0, "");
        }
        c.a().a(TARGET_CLASS, str, 102003, "received params not match");
        return BundleUtil.makeBundle(102003, "received params not match");
    }
}
