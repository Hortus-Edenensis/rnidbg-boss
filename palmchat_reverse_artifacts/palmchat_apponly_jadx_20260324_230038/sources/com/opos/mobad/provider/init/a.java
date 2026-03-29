package com.opos.mobad.provider.init;

import android.content.Context;
import android.os.Bundle;
import com.opos.process.bridge.client.BaseProviderClient;
import com.opos.process.bridge.dispatch.InitModel$Dispatcher;
import com.opos.process.bridge.provider.BridgeDispatchException;
import com.opos.process.bridge.provider.BridgeExecuteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a extends BaseProviderClient {
    public a(Context context) {
        this(context, null);
    }

    public final void a(boolean z, boolean z2, String str) throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        call(this.mContext, InitModel$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 1, Boolean.valueOf(z), Boolean.valueOf(z2), str);
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
