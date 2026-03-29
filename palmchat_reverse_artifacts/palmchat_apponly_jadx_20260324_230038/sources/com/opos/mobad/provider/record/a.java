package com.opos.mobad.provider.record;

import android.content.Context;
import android.os.Bundle;
import com.opos.process.bridge.client.BaseProviderClient;
import com.opos.process.bridge.dispatch.SdKRecord$Dispatcher;
import com.opos.process.bridge.provider.BridgeDispatchException;
import com.opos.process.bridge.provider.BridgeExecuteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a extends BaseProviderClient {
    public a(Context context) {
        this(context, null);
    }

    public final CacheEntity a() throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        Object objCallForResult = callForResult(this.mContext, SdKRecord$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 2, new Object[0]);
        checkNullResultType(objCallForResult, CacheEntity.class);
        if (objCallForResult == null || (objCallForResult instanceof CacheEntity)) {
            return (CacheEntity) objCallForResult;
        }
        throw new BridgeExecuteException("return value is not match:" + objCallForResult, 102004);
    }

    public final CacheEntity b() throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        Object objCallForResult = callForResult(this.mContext, SdKRecord$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 4, new Object[0]);
        checkNullResultType(objCallForResult, CacheEntity.class);
        if (objCallForResult == null || (objCallForResult instanceof CacheEntity)) {
            return (CacheEntity) objCallForResult;
        }
        throw new BridgeExecuteException("return value is not match:" + objCallForResult, 102004);
    }

    public final void c() throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        call(this.mContext, SdKRecord$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 5, new Object[0]);
    }

    public final ControlEntity d() throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        Object objCallForResult = callForResult(this.mContext, SdKRecord$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 6, new Object[0]);
        checkNullResultType(objCallForResult, ControlEntity.class);
        if (objCallForResult == null || (objCallForResult instanceof ControlEntity)) {
            return (ControlEntity) objCallForResult;
        }
        throw new BridgeExecuteException("return value is not match:" + objCallForResult, 102004);
    }

    public final int e() throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        Object objCallForResult = callForResult(this.mContext, SdKRecord$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 10, new Object[0]);
        checkNullResultType(objCallForResult, Integer.TYPE);
        if (objCallForResult == null || (objCallForResult instanceof Integer)) {
            return ((Integer) objCallForResult).intValue();
        }
        throw new BridgeExecuteException("return value is not match:" + objCallForResult, 102004);
    }

    public final long f() throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        Object objCallForResult = callForResult(this.mContext, SdKRecord$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 11, new Object[0]);
        checkNullResultType(objCallForResult, Long.TYPE);
        if (objCallForResult == null || (objCallForResult instanceof Long)) {
            return ((Long) objCallForResult).longValue();
        }
        throw new BridgeExecuteException("return value is not match:" + objCallForResult, 102004);
    }

    public final String g() throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        Object objCallForResult = callForResult(this.mContext, SdKRecord$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 12, new Object[0]);
        checkNullResultType(objCallForResult, String.class);
        if (objCallForResult == null || (objCallForResult instanceof String)) {
            return (String) objCallForResult;
        }
        throw new BridgeExecuteException("return value is not match:" + objCallForResult, 102004);
    }

    @Override // com.opos.process.bridge.client.BaseProviderClient
    public String getTargetClass() {
        return "com.opos.mobad.provider.MobAdGlobalProvider";
    }

    public final String h() throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        Object objCallForResult = callForResult(this.mContext, SdKRecord$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 14, new Object[0]);
        checkNullResultType(objCallForResult, String.class);
        if (objCallForResult == null || (objCallForResult instanceof String)) {
            return (String) objCallForResult;
        }
        throw new BridgeExecuteException("return value is not match:" + objCallForResult, 102004);
    }

    public final CookieData i() throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        Object objCallForResult = callForResult(this.mContext, SdKRecord$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 16, new Object[0]);
        checkNullResultType(objCallForResult, CookieData.class);
        if (objCallForResult == null || (objCallForResult instanceof CookieData)) {
            return (CookieData) objCallForResult;
        }
        throw new BridgeExecuteException("return value is not match:" + objCallForResult, 102004);
    }

    public a(Context context, Bundle bundle) {
        super(context, null, bundle);
        this.defaultAuthorities = new String[]{"${applicationId}.MobAdGlobalProvider"};
    }

    public final void a(CacheEntity cacheEntity) throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        call(this.mContext, SdKRecord$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 1, cacheEntity);
    }

    public final void b(CacheEntity cacheEntity) throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        call(this.mContext, SdKRecord$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 3, cacheEntity);
    }

    public final void a(ControlEntity controlEntity) throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        call(this.mContext, SdKRecord$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 7, controlEntity);
    }

    public final void a(CookieData cookieData) throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        call(this.mContext, SdKRecord$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 15, cookieData);
    }

    public final void a(String str) throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        call(this.mContext, SdKRecord$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 9, str);
    }

    public final void a(String str, String str2) throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        call(this.mContext, SdKRecord$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 13, str, str2);
    }
}
