package com.opos.mobad.provider.monitor;

import android.content.Context;
import android.os.Bundle;
import com.opos.cmn.biz.monitor.MonitorEvent;
import com.opos.process.bridge.client.BaseProviderClient;
import com.opos.process.bridge.dispatch.MonitorModel$Dispatcher;
import com.opos.process.bridge.provider.BridgeDispatchException;
import com.opos.process.bridge.provider.BridgeExecuteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a extends BaseProviderClient {
    public a(Context context) {
        this(context, null);
    }

    public final void a(String str, MonitorEvent monitorEvent) throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        call(this.mContext, MonitorModel$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 1, str, monitorEvent);
    }

    @Override // com.opos.process.bridge.client.BaseProviderClient
    public String getTargetClass() {
        return "com.opos.mobad.provider.MobAdGlobalProvider";
    }

    public a(Context context, Bundle bundle) {
        super(context, null, bundle);
        this.defaultAuthorities = new String[]{"${applicationId}.MobAdGlobalProvider"};
    }
}
