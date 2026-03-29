package com.opos.mobad.provider.openId;

import android.content.Context;
import android.os.Bundle;
import com.opos.process.bridge.client.BaseProviderClient;
import com.opos.process.bridge.dispatch.IdModel$Dispatcher;
import com.opos.process.bridge.provider.BridgeDispatchException;
import com.opos.process.bridge.provider.BridgeExecuteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a extends BaseProviderClient {
    public a(Context context, IdModelIdentify idModelIdentify) {
        this(context, idModelIdentify, null);
    }

    public final OpenIdData a() throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        Object objCallForResult = callForResult(this.mContext, IdModel$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 1, new Object[0]);
        checkNullResultType(objCallForResult, OpenIdData.class);
        if (objCallForResult == null || (objCallForResult instanceof OpenIdData)) {
            return (OpenIdData) objCallForResult;
        }
        throw new BridgeExecuteException("return value is not match:" + objCallForResult, 102004);
    }

    public final boolean b() throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        Object objCallForResult = callForResult(this.mContext, IdModel$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 2, new Object[0]);
        checkNullResultType(objCallForResult, Boolean.TYPE);
        if (objCallForResult == null || (objCallForResult instanceof Boolean)) {
            return ((Boolean) objCallForResult).booleanValue();
        }
        throw new BridgeExecuteException("return value is not match:" + objCallForResult, 102004);
    }

    public final OpenIdData c() throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        Object objCallForResult = callForResult(this.mContext, IdModel$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 4, new Object[0]);
        checkNullResultType(objCallForResult, OpenIdData.class);
        if (objCallForResult == null || (objCallForResult instanceof OpenIdData)) {
            return (OpenIdData) objCallForResult;
        }
        throw new BridgeExecuteException("return value is not match:" + objCallForResult, 102004);
    }

    public final boolean d() throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        Object objCallForResult = callForResult(this.mContext, IdModel$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 6, new Object[0]);
        checkNullResultType(objCallForResult, Boolean.TYPE);
        if (objCallForResult == null || (objCallForResult instanceof Boolean)) {
            return ((Boolean) objCallForResult).booleanValue();
        }
        throw new BridgeExecuteException("return value is not match:" + objCallForResult, 102004);
    }

    public final boolean e() throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        Object objCallForResult = callForResult(this.mContext, IdModel$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 7, new Object[0]);
        checkNullResultType(objCallForResult, Boolean.TYPE);
        if (objCallForResult == null || (objCallForResult instanceof Boolean)) {
            return ((Boolean) objCallForResult).booleanValue();
        }
        throw new BridgeExecuteException("return value is not match:" + objCallForResult, 102004);
    }

    @Override // com.opos.process.bridge.client.BaseProviderClient
    public String getTargetClass() {
        return "com.opos.mobad.provider.MobAdGlobalProvider";
    }

    public a(Context context, IdModelIdentify idModelIdentify, Bundle bundle) {
        super(context, idModelIdentify, bundle);
        this.defaultAuthorities = new String[]{"${applicationId}.MobAdGlobalProvider"};
    }
}
