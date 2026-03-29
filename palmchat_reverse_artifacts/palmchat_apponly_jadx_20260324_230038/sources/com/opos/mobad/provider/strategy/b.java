package com.opos.mobad.provider.strategy;

import android.content.Context;
import android.os.Bundle;
import com.opos.process.bridge.client.BaseProviderClient;
import com.opos.process.bridge.dispatch.StrategyModel$Dispatcher;
import com.opos.process.bridge.provider.BridgeDispatchException;
import com.opos.process.bridge.provider.BridgeExecuteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b extends BaseProviderClient {
    public b(Context context) {
        this(context, null);
    }

    public final Bundle a(String str) throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        Object objCallForResult = callForResult(this.mContext, StrategyModel$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 3, str);
        checkNullResultType(objCallForResult, Bundle.class);
        if (objCallForResult == null || (objCallForResult instanceof Bundle)) {
            return (Bundle) objCallForResult;
        }
        throw new BridgeExecuteException("return value is not match:" + objCallForResult, 102004);
    }

    public final AppInfo b(String str) throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        Object objCallForResult = callForResult(this.mContext, StrategyModel$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 4, str);
        checkNullResultType(objCallForResult, AppInfo.class);
        if (objCallForResult == null || (objCallForResult instanceof AppInfo)) {
            return (AppInfo) objCallForResult;
        }
        throw new BridgeExecuteException("return value is not match:" + objCallForResult, 102004);
    }

    @Override // com.opos.process.bridge.client.BaseProviderClient
    public String getTargetClass() {
        return "com.opos.mobad.provider.MobAdGlobalProvider";
    }

    public b(Context context, Bundle bundle) {
        super(context, null, bundle);
        this.defaultAuthorities = new String[]{"${applicationId}.MobAdGlobalProvider"};
    }

    public final void a(String str, StrategyInfo strategyInfo) throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        call(this.mContext, StrategyModel$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 2, str, strategyInfo);
    }

    public final void a(String str, String str2, AppInfo appInfo) throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        call(this.mContext, StrategyModel$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 1, str, str2, appInfo);
    }
}
