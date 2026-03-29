package com.opos.process.bridge.client;

import android.content.Context;
import android.os.Bundle;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.b.a;
import com.opos.process.bridge.b.e;
import com.opos.process.bridge.provider.BridgeBizException;
import com.opos.process.bridge.provider.BridgeDispatchException;
import com.opos.process.bridge.provider.BridgeExecuteException;
import com.opos.process.bridge.provider.ProcessBridgeLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class BaseClient {
    private static final String TAG = "BaseClient";
    protected Context mContext;
    protected Bundle mData;
    protected IBridgeTargetIdentify mTargetIdentify;
    protected e serverFilter;
    protected final List<TargetInfo> mTargets = new ArrayList();
    protected List<a> clientMethodInterceptors = new ArrayList();
    final ReentrantLock lock = new ReentrantLock(true);
    int defaultTimeOut = 5000;

    public void addClientMethodInterceptor(a aVar) {
        ProcessBridgeLog.d(TAG, "addClientMethodInterceptor:" + aVar.getClass().getName());
        this.clientMethodInterceptors.add(aVar);
    }

    public void call(Context context, String str, IBridgeTargetIdentify iBridgeTargetIdentify, int i, Object... objArr) throws BridgeExecuteException, BridgeDispatchException {
        ProcessBridgeLog.d(TAG, "call --- targetClass:" + str + ", methodId:" + i);
        callForResult(context, str, iBridgeTargetIdentify, i, objArr);
    }

    public Object callForResult(Context context, String str, IBridgeTargetIdentify iBridgeTargetIdentify, int i, Object... objArr) throws BridgeExecuteException, BridgeDispatchException {
        ProcessBridgeLog.d(TAG, "callForResult");
        Bundle bundleCallRemote = callRemote(context, str, iBridgeTargetIdentify, i, objArr);
        ProcessBridgeLog.v(TAG, "callRemote --- resultBundle:" + bundleCallRemote);
        if (bundleCallRemote == null) {
            ProcessBridgeLog.e(TAG, "remote response is NULL");
            throw new BridgeExecuteException("remote response is NULL", 102004);
        }
        bundleCallRemote.setClassLoader(getClass().getClassLoader());
        int i2 = bundleCallRemote.getInt("resultCode");
        if (i2 == 0) {
            return bundleCallRemote.get("resultData");
        }
        String string = bundleCallRemote.getString("resultMsg");
        ProcessBridgeLog.e(TAG, "error code:" + i2 + ", message:" + string);
        if (i2 == 101008) {
            Exception exc = (Exception) bundleCallRemote.getSerializable("resultException");
            ProcessBridgeLog.e(TAG, "code:" + i2, exc);
            throw new BridgeExecuteException(exc, i2);
        }
        if (i2 < 102000) {
            throw new BridgeExecuteException(string, i2);
        }
        if (i2 < 103000) {
            throw new BridgeDispatchException(string, i2);
        }
        if (i2 != 103000) {
            throw new BridgeExecuteException(string, i2);
        }
        int i3 = bundleCallRemote.getInt("interceptorCode");
        String string2 = bundleCallRemote.getString("interceptorMsg");
        ProcessBridgeLog.e(TAG, "interceptor error code:" + i2 + ", message:" + string);
        throw new BridgeBizException(string2, i3);
    }

    public abstract Bundle callRemote(Context context, String str, IBridgeTargetIdentify iBridgeTargetIdentify, int i, Object... objArr) throws BridgeExecuteException, BridgeDispatchException;

    public abstract void checkMainThread() throws BridgeExecuteException;

    public void checkNullResultType(Object obj, Class<?> cls) throws BridgeExecuteException {
        if (cls.isPrimitive() && obj == null) {
            throw new BridgeExecuteException("Primitive not allow return null", 101009);
        }
    }

    public void clearClientMethodInterceptor() {
        ProcessBridgeLog.d(TAG, "clearClientMethodInterceptor");
        this.clientMethodInterceptors.clear();
    }

    public Bundle getData() {
        return this.mData;
    }

    public List<TargetInfo> getTargetsClone() {
        ArrayList arrayList = new ArrayList();
        Iterator<TargetInfo> it = this.mTargets.iterator();
        while (it.hasNext()) {
            arrayList.add(new TargetInfo(it.next()));
        }
        return arrayList;
    }

    public boolean removeClientMethodInterceptor(a aVar) {
        ProcessBridgeLog.d(TAG, "removeClientMethodInterceptor:" + aVar.getClass().getName());
        return this.clientMethodInterceptors.remove(aVar);
    }

    public void setDefaultTimeOut(int i) {
        this.defaultTimeOut = i;
    }

    public void setServerFilter(e eVar) {
        ProcessBridgeLog.d(TAG, "setServerFilter:" + eVar.getClass().getName());
        this.serverFilter = eVar;
    }
}
