package com.opos.mobad.provider.ad;

import android.content.Context;
import android.os.Bundle;
import com.opos.process.bridge.client.BaseProviderClient;
import com.opos.process.bridge.dispatch.AdCacheModel$Dispatcher;
import com.opos.process.bridge.provider.BridgeDispatchException;
import com.opos.process.bridge.provider.BridgeExecuteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a extends BaseProviderClient {
    public a(Context context) {
        this(context, null);
    }

    public final AdEntity a(String str) throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        Object objCallForResult = callForResult(this.mContext, AdCacheModel$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 2, str);
        checkNullResultType(objCallForResult, AdEntity.class);
        if (objCallForResult == null || (objCallForResult instanceof AdEntity)) {
            return (AdEntity) objCallForResult;
        }
        throw new BridgeExecuteException("return value is not match:" + objCallForResult, 102004);
    }

    @Override // com.opos.process.bridge.client.BaseProviderClient
    public String getTargetClass() {
        return "com.opos.mobad.provider.MobAdGlobalProvider";
    }

    public a(Context context, Bundle bundle) {
        super(context, null, bundle);
        this.defaultAuthorities = new String[]{"${applicationId}.MobAdGlobalProvider"};
    }

    public final void a(String str, AdEntity adEntity) throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        call(this.mContext, AdCacheModel$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 1, str, adEntity);
    }
}
