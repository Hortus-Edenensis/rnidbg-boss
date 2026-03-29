package com.opos.process.bridge.client;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.az;
import com.opos.process.bridge.b.a;
import com.opos.process.bridge.b.b;
import com.opos.process.bridge.b.d;
import com.opos.process.bridge.b.e;
import com.opos.process.bridge.provider.BridgeExecuteException;
import com.opos.process.bridge.provider.BundleUtil;
import com.opos.process.bridge.provider.ProcessBridgeLog;
import com.opos.process.bridge.provider.StringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class BaseActivityClient {
    private static final String NO_ACTION = "NoAction";
    private static final String TAG = "BaseActivityClient";
    protected List<a> clientMethodInterceptors;
    protected String[] defaultActions;
    protected String[] defaultPackages;
    int defaultRequestCode;
    int defaultTimeOut;
    final ReentrantLock lock;
    protected String mAction;
    protected final List<String> mActions;
    protected Context mContext;
    protected Bundle mData;
    protected String mPackage;
    protected final List<TargetInfo> mTargets;
    protected e serverFilter;

    public BaseActivityClient(Context context) {
        this(context, null);
    }

    private void getPackageAndAction(Context context) throws BridgeExecuteException {
        if (this.mAction == null || this.mPackage == null) {
            this.mActions.clear();
            this.mTargets.clear();
            PackageManager packageManager = this.mContext.getPackageManager();
            String[] strArr = this.defaultActions;
            if (strArr != null) {
                this.mActions.addAll(Arrays.asList(strArr));
                ProcessBridgeLog.v(TAG, "query actions:" + StringUtil.listToString(this.mActions));
                for (String strReplace : this.mActions) {
                    if (!TextUtils.isEmpty(strReplace)) {
                        if (strReplace.contains("${applicationId}")) {
                            strReplace = strReplace.replace("${applicationId}", context.getPackageName());
                        }
                        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(getActivityIntent(this.mPackage, getTargetClass(), strReplace, null), 128)) {
                            ActivityInfo activityInfo = resolveInfo.activityInfo;
                            if (activityInfo != null && !TextUtils.isEmpty(activityInfo.packageName)) {
                                List<TargetInfo> list = this.mTargets;
                                ActivityInfo activityInfo2 = resolveInfo.activityInfo;
                                list.add(TargetInfo.targetInfoAction(activityInfo2.packageName, strReplace, activityInfo2.name));
                            }
                        }
                    }
                }
            }
            if (this.defaultPackages != null) {
                ProcessBridgeLog.v(TAG, "query packages:" + StringUtil.arrayToString(this.defaultPackages));
                for (String str : this.defaultPackages) {
                    if (!TextUtils.isEmpty(str)) {
                        for (ResolveInfo resolveInfo2 : packageManager.queryIntentActivities(getActivityIntent(str, getTargetClass(), null, null), 128)) {
                            ActivityInfo activityInfo3 = resolveInfo2.activityInfo;
                            if (activityInfo3 != null && !TextUtils.isEmpty(activityInfo3.packageName)) {
                                this.mTargets.add(TargetInfo.targetInfoAction(resolveInfo2.activityInfo.packageName, NO_ACTION, getTargetClass()));
                            }
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

    public void call(Activity activity, String str, int i, Object... objArr) throws BridgeExecuteException {
        ProcessBridgeLog.d(TAG, "call --- activity:" + activity.getClass().getName() + ", targetClass:" + str + ", methodId:" + i);
        if (!BundleUtil.checkParams(objArr)) {
            throw new BridgeExecuteException("Invalid params", 101006);
        }
        d dVarA = new d.a().a(activity).a(activity.getPackageName()).a(this.mData).b(str).a(i).a();
        ProcessBridgeLog.v(TAG, "call clientMethodInterceptors");
        for (a aVar : this.clientMethodInterceptors) {
            b bVarA = aVar.a(dVarA);
            ProcessBridgeLog.v(TAG, "clientMethodInterceptor --- interceptor:" + aVar.getClass().getName() + ", result:" + bVarA.toString());
            if (bVarA.c()) {
                throw new BridgeExecuteException(bVarA.b(), bVarA.a());
            }
        }
        if (this.mAction == null || this.mPackage == null) {
            try {
                if (this.lock.tryLock() || this.lock.tryLock((long) this.defaultTimeOut, TimeUnit.MILLISECONDS)) {
                    getPackageAndAction(activity);
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
        ProcessBridgeLog.d(TAG, "use package:" + this.mPackage + ", action:" + this.mAction);
        Bundle bundleEncodeParams = BundleUtil.encodeParams(str, null, i, objArr);
        Bundle bundle = this.mData;
        if (bundle != null) {
            bundleEncodeParams.putBundle(az.M, bundle);
        }
        ProcessBridgeLog.d(TAG, "start activity for result");
        activity.startActivityForResult(getActivityIntent(this.mPackage, getTargetClass(), this.mAction, bundleEncodeParams), this.defaultRequestCode);
    }

    public Intent getActivityIntent(String str, String str2, String str3, Bundle bundle) {
        ProcessBridgeLog.d(TAG, "getActivityIntent --- packageName:" + str + ", targetClass:" + str2 + ", action:" + str3 + ", bundle:" + bundle);
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                intent.setPackage(str);
            } else {
                intent.setComponent(new ComponentName(str, str2));
            }
        }
        if (!TextUtils.isEmpty(str3) && !NO_ACTION.equals(str3)) {
            intent.setAction(str3);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        return intent;
    }

    public Bundle getData() {
        return this.mData;
    }

    public String getTargetClass() {
        ProcessBridgeLog.d(TAG, "getTargetClass");
        return null;
    }

    public List<TargetInfo> getTargetsClone() {
        ArrayList arrayList = new ArrayList();
        Iterator<TargetInfo> it = this.mTargets.iterator();
        while (it.hasNext()) {
            arrayList.add(new TargetInfo(it.next()));
        }
        return arrayList;
    }

    public void setRequestCode(int i) {
        this.defaultRequestCode = i;
    }

    public void setServerFilter(e eVar) {
        this.serverFilter = eVar;
    }

    public BaseActivityClient(Context context, Bundle bundle) {
        this.mTargets = new ArrayList();
        this.mActions = new ArrayList();
        this.defaultActions = null;
        this.defaultPackages = null;
        this.mPackage = null;
        this.mAction = null;
        this.clientMethodInterceptors = new ArrayList();
        this.lock = new ReentrantLock(true);
        this.defaultTimeOut = 5000;
        this.defaultRequestCode = 65244;
        this.mContext = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.mData = bundle;
    }
}
