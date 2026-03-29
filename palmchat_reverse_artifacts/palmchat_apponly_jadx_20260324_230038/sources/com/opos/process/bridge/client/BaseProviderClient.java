package com.opos.process.bridge.client;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.az;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.b.b;
import com.opos.process.bridge.b.d;
import com.opos.process.bridge.b.e;
import com.opos.process.bridge.b.f;
import com.opos.process.bridge.b.g;
import com.opos.process.bridge.b.h;
import com.opos.process.bridge.dispatch.a;
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
public class BaseProviderClient extends BaseClient {
    private static final String TAG = "BaseProviderClient";
    protected String[] defaultAuthorities;
    private final List<String> mAuthorities;
    private String mAuthority;
    private final AtomicInteger mMultiProcess;
    private String mPackage;

    public BaseProviderClient(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
        this(context, iBridgeTargetIdentify, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bundle callFromRemote(d dVar, Object[] objArr) throws Throwable {
        ContentProviderClient contentProviderClient;
        ProcessBridgeLog.d(TAG, "multi process --- call remote");
        Bundle bundleEncodeParams = BundleUtil.encodeParams(dVar.c(), dVar.d(), dVar.e(), objArr);
        Bundle bundle = this.mData;
        if (bundle != null) {
            bundleEncodeParams.putBundle(az.M, bundle);
        }
        Uri uri = Uri.parse("content://" + this.mAuthority);
        StringBuilder sb = new StringBuilder();
        sb.append("uri:");
        sb.append(uri.toString());
        Object objAcquireUnstableContentProviderClient = ",bundle:";
        sb.append(",bundle:");
        sb.append(bundleEncodeParams);
        ProcessBridgeLog.d(TAG, sb.toString());
        ContentProviderClient contentProviderClient2 = 0;
        bundleMakeBundle = null;
        Bundle bundleMakeBundle = null;
        try {
            try {
                objAcquireUnstableContentProviderClient = dVar.a().getContentResolver().acquireUnstableContentProviderClient(this.mAuthority);
                try {
                    bundleMakeBundle = objAcquireUnstableContentProviderClient == null ? BundleUtil.makeBundle(101010, "acquireUnstableContentProviderClient error") : dVar.a().getContentResolver().call(uri, "dispatch", "", bundleEncodeParams);
                    contentProviderClient = objAcquireUnstableContentProviderClient;
                } catch (Exception e) {
                    e = e;
                    ProcessBridgeLog.e(TAG, "resolve error", e);
                    contentProviderClient = objAcquireUnstableContentProviderClient;
                    if (objAcquireUnstableContentProviderClient != null) {
                    }
                    return bundleMakeBundle;
                }
            } catch (Throwable th) {
                th = th;
                contentProviderClient2 = objAcquireUnstableContentProviderClient;
                if (contentProviderClient2 != 0) {
                    contentProviderClient2.release();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            objAcquireUnstableContentProviderClient = null;
        } catch (Throwable th2) {
            th = th2;
            if (contentProviderClient2 != 0) {
            }
            throw th;
        }
        if (objAcquireUnstableContentProviderClient != null) {
            contentProviderClient.release();
        }
        return bundleMakeBundle;
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
        Bundle bundleA = a.a().a(dVar.a(), dVar.b(), dVar.c(), dVar.d(), dVar.e(), objArr);
        ThreadLocalUtil.remove((Set<String>) map.keySet());
        return bundleA;
    }

    private void getPackageAndAuthority(Context context) throws BridgeExecuteException {
        if (this.mAuthority == null || this.mPackage == null) {
            PackageManager packageManager = this.mContext.getPackageManager();
            this.mAuthorities.clear();
            this.mTargets.clear();
            String[] strArr = this.defaultAuthorities;
            if (strArr != null) {
                this.mAuthorities.addAll(Arrays.asList(strArr));
            }
            ProcessBridgeLog.v(TAG, "query Authorities:" + StringUtil.listToString(this.mAuthorities));
            for (String strReplace : this.mAuthorities) {
                if (!TextUtils.isEmpty(strReplace)) {
                    if (strReplace.contains("${applicationId}")) {
                        strReplace = strReplace.replace("${applicationId}", context.getPackageName());
                    }
                    ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strReplace, 128);
                    if (providerInfoResolveContentProvider != null && !TextUtils.isEmpty(providerInfoResolveContentProvider.packageName) && (TextUtils.isEmpty(getTargetClass()) || providerInfoResolveContentProvider.name.equals(getTargetClass()))) {
                        this.mTargets.add(TargetInfo.targetInfoAuthorities(providerInfoResolveContentProvider.packageName, strReplace, providerInfoResolveContentProvider.name));
                    }
                }
            }
            ProcessBridgeLog.v(TAG, "get targets:" + StringUtil.listToString(this.mTargets));
            if (this.mTargets.size() < 1) {
                ProcessBridgeLog.e(TAG, "No target found for all authorities");
                throw new BridgeExecuteException("No target found for all authorities", 101001);
            }
            if (this.serverFilter != null) {
                ProcessBridgeLog.v(TAG, "serverFilter:" + this.serverFilter.getClass().getName());
                TargetInfo targetInfoA = this.serverFilter.a(context, getTargetsClone());
                if (targetInfoA == null || !this.mTargets.contains(targetInfoA)) {
                    throw new BridgeExecuteException("serverFilter block all app package", 101003);
                }
                this.mPackage = targetInfoA.packageName;
                this.mAuthority = targetInfoA.authorities;
                ProcessBridgeLog.v(TAG, "filter package:" + this.mPackage + ", authority:" + this.mAuthority);
                if (TextUtils.isEmpty(this.mAuthority)) {
                    throw new BridgeExecuteException("serverFilter return unknown package", 101003);
                }
            } else {
                this.mPackage = this.mTargets.get(0).packageName;
                this.mAuthority = this.mTargets.get(0).authorities;
                ProcessBridgeLog.v(TAG, "select first package:" + this.mPackage + ", authority:" + this.mAuthority);
            }
        }
        ProcessBridgeLog.d(TAG, "use package:" + this.mPackage + ", authority:" + this.mAuthority);
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
    public Bundle callRemote(Context context, String str, IBridgeTargetIdentify iBridgeTargetIdentify, int i, Object... objArr) throws BridgeExecuteException {
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
        if (this.mAuthority == null || this.mPackage == null) {
            try {
                if (this.lock.tryLock() || this.lock.tryLock((long) this.defaultTimeOut, TimeUnit.MILLISECONDS)) {
                    if (this.mMultiProcess.get() < 0) {
                        getPackageAndAuthority(context);
                    }
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
        }
        StringBuilder sb = new StringBuilder();
        sb.append("content://");
        sb.append(this.mAuthority);
        return checkMultiProcess(context, Uri.parse(sb.toString())) ? callFromRemote(dVarA, objArr) : callInSameProcess(dVarA, objArr);
    }

    @Override // com.opos.process.bridge.client.BaseClient
    public void checkMainThread() throws BridgeExecuteException {
        ProcessBridgeLog.d(TAG, "ProviderClient checkMainThread");
    }

    public boolean checkMultiProcess(Context context, Uri uri) {
        ProcessBridgeLog.d(TAG, "checkMultiProcess");
        int i = this.mMultiProcess.get();
        if (i >= 0) {
            return i == 1;
        }
        try {
            String myProcessName = ProcessUtil.getMyProcessName(context.getApplicationContext());
            ProviderInfo providerInfoResolveContentProvider = context.getApplicationContext().getPackageManager().resolveContentProvider(uri.getAuthority(), 128);
            if (providerInfoResolveContentProvider != null && !TextUtils.isEmpty(providerInfoResolveContentProvider.processName) && providerInfoResolveContentProvider.processName.equals(myProcessName)) {
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

    public String getAuthority() throws BridgeExecuteException {
        if (TextUtils.isEmpty(this.mAuthority)) {
            getPackageAndAuthority(this.mContext);
        }
        return this.mAuthority;
    }

    @Override // com.opos.process.bridge.client.BaseClient
    public /* bridge */ /* synthetic */ Bundle getData() {
        return super.getData();
    }

    public String getTargetClass() {
        return null;
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

    public BaseProviderClient(Context context, IBridgeTargetIdentify iBridgeTargetIdentify, Bundle bundle) {
        this.mPackage = null;
        this.mAuthority = null;
        this.mAuthorities = new ArrayList();
        this.defaultAuthorities = null;
        this.mMultiProcess = new AtomicInteger(-1);
        this.mContext = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.mTargetIdentify = iBridgeTargetIdentify;
        this.mData = bundle;
    }
}
