package com.opos.process.bridge.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.az;
import com.opos.process.bridge.a;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.b.b;
import com.opos.process.bridge.b.d;
import com.opos.process.bridge.b.e;
import com.opos.process.bridge.b.f;
import com.opos.process.bridge.b.g;
import com.opos.process.bridge.b.h;
import com.opos.process.bridge.provider.BridgeDispatchException;
import com.opos.process.bridge.provider.BridgeExecuteException;
import com.opos.process.bridge.provider.BundleUtil;
import com.opos.process.bridge.provider.ProcessBridgeLog;
import com.opos.process.bridge.provider.StringUtil;
import com.opos.process.bridge.provider.ThreadLocalUtil;
import com.opos.process.bridge.server.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class BaseServiceClient extends BaseClient {
    private static final String TAG = "BaseServiceClient";
    protected IBinder baseBinder;
    private ServiceListener binderListener;
    protected String[] defaultActions;
    protected String mAction;
    protected List<String> mActions;
    protected AtomicInteger mMultiProcess;
    protected String mPackage;
    private ServiceListener serviceListener;

    /* JADX INFO: compiled from: SearchBox */
    public interface ServiceListener {
        void onServiceConnected(ComponentName componentName);

        void onServiceDisconnected(ComponentName componentName);
    }

    public BaseServiceClient(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
        this(context, iBridgeTargetIdentify, null);
    }

    private Bundle callFromRemote(d dVar, Object[] objArr) throws BridgeExecuteException {
        IBinder iBinder = this.baseBinder;
        if (iBinder == null) {
            ProcessBridgeLog.e(TAG, "baseBinder is NULL");
            return BundleUtil.makeBundle(101005, "connect error");
        }
        a aVarA = a.AbstractBinderC0820a.a(iBinder);
        Bundle bundleEncodeParams = BundleUtil.encodeParams(dVar.c(), dVar.d(), dVar.e(), objArr);
        Bundle bundle = this.mData;
        if (bundle != null) {
            bundleEncodeParams.putBundle(az.M, bundle);
        }
        try {
            ProcessBridgeLog.v(TAG, "bundle:" + bundleEncodeParams);
            return aVarA.a(bundleEncodeParams);
        } catch (RemoteException e) {
            ProcessBridgeLog.e(TAG, "executeSync", e);
            throw new BridgeExecuteException(e, 101007);
        }
    }

    private Bundle callInSameProcess(d dVar, Object[] objArr) {
        ProcessBridgeLog.d(TAG, "same process --- call direct dispatch");
        HashMap map = new HashMap();
        g gVarA = new g.a().a(dVar.a()).a(dVar.b()).b(dVar.c()).a(this.mData).a(map).a();
        ProcessBridgeLog.v(TAG, "call serverInterceptors");
        for (f fVar : c.a().c()) {
            b bVarA = fVar.a(gVarA);
            ProcessBridgeLog.v(TAG, "serverInterceptor --- interceptor:" + fVar.getClass().getName() + ", result:" + bVarA.toString());
            if (bVarA.c()) {
                return BundleUtil.makeBundle(bVarA.a(), bVarA.b());
            }
        }
        ProcessBridgeLog.v(TAG, "ServerInterceptor savedMap:" + map);
        ProcessBridgeLog.v(TAG, "call serverMethodInterceptors");
        for (h hVar : c.a().d()) {
            b bVarA2 = hVar.a(dVar);
            ProcessBridgeLog.v(TAG, "serverMethodInterceptor --- interceptor:" + hVar.getClass().getName() + ", result:" + bVarA2.toString());
            if (bVarA2.c()) {
                return BundleUtil.makeBundle(bVarA2.a(), bVarA2.b());
            }
        }
        ProcessBridgeLog.d(TAG, "save map and call Dispatch");
        ThreadLocalUtil.put(map);
        Bundle bundleA = com.opos.process.bridge.dispatch.a.a().a(dVar.a(), dVar.b(), dVar.c(), dVar.d(), dVar.e(), objArr);
        ThreadLocalUtil.remove((Set<String>) map.keySet());
        return bundleA;
    }

    private void getBinder(Context context) throws BridgeExecuteException {
        if (this.baseBinder != null) {
            ProcessBridgeLog.d(TAG, "get Binder");
            return;
        }
        ProcessBridgeLog.d(TAG, "use package:" + this.mPackage + ", action:" + this.mAction);
        this.baseBinder = BinderManager.getInstance().getBinderSync(context, getServiceIntent(this.mPackage, getTargetClass(), this.mAction, this.mData), this.defaultTimeOut, this.binderListener);
    }

    private void getPackageAndAction(Context context) throws BridgeExecuteException {
        if (this.mAction == null || this.mPackage == null) {
            PackageManager packageManager = this.mContext.getPackageManager();
            this.mActions.clear();
            this.mTargets.clear();
            String[] strArr = this.defaultActions;
            if (strArr != null) {
                this.mActions.addAll(Arrays.asList(strArr));
            }
            ProcessBridgeLog.v(TAG, "query actions:" + StringUtil.listToString(this.mActions));
            for (String strReplace : this.mActions) {
                if (!TextUtils.isEmpty(strReplace)) {
                    if (strReplace.contains("${applicationId}")) {
                        strReplace = strReplace.replace("${applicationId}", context.getPackageName());
                    }
                    for (ResolveInfo resolveInfo : packageManager.queryIntentServices(getServiceIntent(this.mPackage, getTargetClass(), strReplace, null), 128)) {
                        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                        if (serviceInfo != null && !TextUtils.isEmpty(serviceInfo.packageName)) {
                            List<TargetInfo> list = this.mTargets;
                            ServiceInfo serviceInfo2 = resolveInfo.serviceInfo;
                            list.add(TargetInfo.targetInfoAction(serviceInfo2.packageName, strReplace, serviceInfo2.name));
                        }
                    }
                }
            }
            ProcessBridgeLog.v(TAG, "get targets:" + StringUtil.listToString(this.mTargets));
            if (this.mTargets.size() < 1) {
                ProcessBridgeLog.e(TAG, "No target found for all actions");
                throw new BridgeExecuteException("No target found for all actions", 101001);
            }
            if (this.serverFilter == null) {
                this.mPackage = this.mTargets.get(0).packageName;
                this.mAction = this.mTargets.get(0).action;
                ProcessBridgeLog.v(TAG, "select first package:" + this.mPackage + ", action:" + this.mAction);
                return;
            }
            ProcessBridgeLog.v(TAG, "serverFilter:" + this.serverFilter.getClass().getName());
            TargetInfo targetInfoA = this.serverFilter.a(context, getTargetsClone());
            if (targetInfoA == null || !this.mTargets.contains(targetInfoA)) {
                throw new BridgeExecuteException("serverFilter block all app package", 101003);
            }
            this.mPackage = targetInfoA.packageName;
            this.mAction = targetInfoA.action;
            ProcessBridgeLog.v(TAG, "filter package:" + this.mPackage + ", action:" + this.mAction);
            if (TextUtils.isEmpty(this.mAction)) {
                throw new BridgeExecuteException("serverFilter return unknown package", 101003);
            }
        }
    }

    @Override // com.opos.process.bridge.client.BaseClient
    public /* bridge */ /* synthetic */ void addClientMethodInterceptor(com.opos.process.bridge.b.a aVar) {
        super.addClientMethodInterceptor(aVar);
    }

    @Override // com.opos.process.bridge.client.BaseClient
    public void call(Context context, String str, IBridgeTargetIdentify iBridgeTargetIdentify, int i, Object... objArr) throws BridgeExecuteException, BridgeDispatchException {
        ProcessBridgeLog.d(TAG, "call method call");
        super.call(context, str, iBridgeTargetIdentify, i, objArr);
    }

    @Override // com.opos.process.bridge.client.BaseClient
    public Object callForResult(Context context, String str, IBridgeTargetIdentify iBridgeTargetIdentify, int i, Object... objArr) throws BridgeExecuteException, BridgeDispatchException {
        ProcessBridgeLog.d(TAG, "callForResult method call");
        return super.callForResult(context, str, iBridgeTargetIdentify, i, objArr);
    }

    @Override // com.opos.process.bridge.client.BaseClient
    public Bundle callRemote(Context context, String str, IBridgeTargetIdentify iBridgeTargetIdentify, int i, Object... objArr) throws BridgeExecuteException, BridgeDispatchException {
        String str2;
        ProcessBridgeLog.d(TAG, "callRemote");
        if (!BundleUtil.checkParams(objArr)) {
            return BundleUtil.makeBundle(101006, "Invalid params");
        }
        d dVarA = new d.a().a(context).a(context.getPackageName()).a(this.mData).b(str).a(iBridgeTargetIdentify).a(i).a();
        ProcessBridgeLog.v(TAG, "call clientMethodInterceptors");
        for (com.opos.process.bridge.b.a aVar : this.clientMethodInterceptors) {
            b bVarA = aVar.a(dVarA);
            ProcessBridgeLog.v(TAG, "clientMethodInterceptor --- interceptor:" + aVar.getClass().getName() + ", result:" + bVarA.toString());
            if (bVarA.c()) {
                throw new BridgeExecuteException(bVarA.b(), bVarA.a());
            }
        }
        if (this.baseBinder == null) {
            if (this.mAction == null || this.mPackage == null) {
                try {
                    ProcessBridgeLog.d(TAG, "try to lock");
                    if (this.lock.tryLock() || this.lock.tryLock((long) this.defaultTimeOut, TimeUnit.MILLISECONDS)) {
                        getPackageAndAction(context);
                        this.lock.unlock();
                    } else {
                        ProcessBridgeLog.d(TAG, "lock fail");
                    }
                } catch (InterruptedException e) {
                    ProcessBridgeLog.e(TAG, "lock", e);
                    try {
                        this.lock.unlock();
                    } catch (Exception e2) {
                        ProcessBridgeLog.e(TAG, "unlock", e2);
                    }
                }
                if (checkMultiProcess(context)) {
                    str2 = "getBinder";
                    ProcessBridgeLog.d(TAG, str2);
                    getBinder(context);
                }
            } else if (checkMultiProcess(context)) {
                str2 = "getBinder use exist package & action";
                ProcessBridgeLog.d(TAG, str2);
                getBinder(context);
            }
        }
        int i2 = this.mMultiProcess.get();
        if (i2 > 0) {
            return callFromRemote(dVarA, objArr);
        }
        if (i2 == 0) {
            return callInSameProcess(dVarA, objArr);
        }
        throw new BridgeExecuteException("not init", -1);
    }

    @Override // com.opos.process.bridge.client.BaseClient
    public void checkMainThread() throws BridgeExecuteException {
        ProcessBridgeLog.d(TAG, "ServiceClient checkMainThread");
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new BridgeExecuteException("MainThread call not allowed", 101000);
        }
    }

    public boolean checkMultiProcess(Context context) {
        ProcessBridgeLog.d(TAG, "checkMultiProcess");
        int i = this.mMultiProcess.get();
        if (i >= 0) {
            return i == 1;
        }
        try {
            String myProcessName = ProcessUtil.getMyProcessName(context.getApplicationContext());
            ResolveInfo resolveInfoResolveService = context.getApplicationContext().getPackageManager().resolveService(getServiceIntent(this.mPackage, getTargetClass(), this.mAction, null), 128);
            if (resolveInfoResolveService != null && !TextUtils.isEmpty(resolveInfoResolveService.serviceInfo.processName) && resolveInfoResolveService.serviceInfo.processName.equals(myProcessName)) {
                this.mMultiProcess.compareAndSet(-1, 0);
                return false;
            }
        } catch (Exception unused) {
        }
        this.mMultiProcess.compareAndSet(-1, 1);
        return true;
    }

    @Override // com.opos.process.bridge.client.BaseClient
    public /* bridge */ /* synthetic */ void checkNullResultType(Object obj, Class cls) throws BridgeExecuteException {
        super.checkNullResultType(obj, cls);
    }

    @Override // com.opos.process.bridge.client.BaseClient
    public /* bridge */ /* synthetic */ void clearClientMethodInterceptor() {
        super.clearClientMethodInterceptor();
    }

    public final void destroyClient() {
        this.serviceListener = null;
        this.baseBinder = null;
        BinderManager.getInstance().freeBinder(this.mContext, getServiceIntent(this.mPackage, getTargetClass(), this.mAction, this.mData), this.binderListener);
        this.mTargets.clear();
        this.mPackage = "";
        this.mAction = "";
    }

    @Override // com.opos.process.bridge.client.BaseClient
    public /* bridge */ /* synthetic */ Bundle getData() {
        return super.getData();
    }

    public Intent getServiceIntent() throws BridgeExecuteException {
        if (TextUtils.isEmpty(this.mPackage) || TextUtils.isEmpty(this.mAction)) {
            getPackageAndAction(this.mContext);
        }
        return getServiceIntent(this.mPackage, getTargetClass(), this.mAction, this.mData);
    }

    public String getTargetClass() {
        return null;
    }

    public void preLink() throws BridgeExecuteException {
        if (this.mAction == null || this.mPackage == null) {
            getPackageAndAction(this.mContext);
        }
        ProcessBridgeLog.d(TAG, "preLink package:" + this.mPackage + ", action:" + this.mAction);
        if (this.baseBinder == null) {
            BinderManager.getInstance().getBinderAsync(this.mContext, getServiceIntent(this.mPackage, getTargetClass(), this.mAction, this.mData), this.serviceListener);
        }
    }

    @Override // com.opos.process.bridge.client.BaseClient
    public /* bridge */ /* synthetic */ boolean removeClientMethodInterceptor(com.opos.process.bridge.b.a aVar) {
        return super.removeClientMethodInterceptor(aVar);
    }

    @Override // com.opos.process.bridge.client.BaseClient
    public /* bridge */ /* synthetic */ void setDefaultTimeOut(int i) {
        super.setDefaultTimeOut(i);
    }

    @Override // com.opos.process.bridge.client.BaseClient
    public /* bridge */ /* synthetic */ void setServerFilter(e eVar) {
        super.setServerFilter(eVar);
    }

    public void setServiceListener(ServiceListener serviceListener) {
        this.serviceListener = serviceListener;
    }

    public BaseServiceClient(Context context, IBridgeTargetIdentify iBridgeTargetIdentify, Bundle bundle) {
        this.defaultActions = null;
        this.mMultiProcess = new AtomicInteger(-1);
        this.mPackage = null;
        this.mAction = null;
        this.mActions = new ArrayList();
        this.serviceListener = null;
        this.binderListener = new ServiceListener() { // from class: com.opos.process.bridge.client.BaseServiceClient.1
            @Override // com.opos.process.bridge.client.BaseServiceClient.ServiceListener
            public void onServiceConnected(ComponentName componentName) {
                ProcessBridgeLog.d(BaseServiceClient.TAG, "onServiceConnected:" + componentName);
                if (BaseServiceClient.this.serviceListener != null) {
                    BaseServiceClient.this.serviceListener.onServiceConnected(componentName);
                }
            }

            @Override // com.opos.process.bridge.client.BaseServiceClient.ServiceListener
            public void onServiceDisconnected(ComponentName componentName) {
                ProcessBridgeLog.d(BaseServiceClient.TAG, "onServiceDisconnected:" + componentName);
                ProcessBridgeLog.d(BaseServiceClient.TAG, "mPackage:" + BaseServiceClient.this.mPackage + ", targetClass:" + BaseServiceClient.this.getTargetClass());
                ProcessBridgeLog.d(BaseServiceClient.TAG, "reset baseBinder to null");
                BaseServiceClient baseServiceClient = BaseServiceClient.this;
                baseServiceClient.baseBinder = null;
                if (baseServiceClient.serviceListener != null) {
                    BaseServiceClient.this.serviceListener.onServiceDisconnected(componentName);
                }
            }
        };
        this.mContext = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.mTargetIdentify = iBridgeTargetIdentify;
        this.mData = bundle;
    }

    public Intent getServiceIntent(String str, String str2, String str3, Bundle bundle) {
        ProcessBridgeLog.d(TAG, "getServiceIntent --- packageName:" + str + ", targetClass:" + str2 + ", action" + str3 + ", bundle:" + bundle);
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            intent.setComponent(new ComponentName(str, str2));
        }
        intent.setPackage(str);
        intent.setAction(str3);
        intent.putExtra("callingPackage", this.mContext.getPackageName());
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        return intent;
    }
}
