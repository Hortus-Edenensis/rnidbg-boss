package com.heytap.msp.ipc.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.heytap.msp.ipc.annotation.IPCModule;
import com.heytap.msp.ipc.annotation.IPCType;
import com.heytap.msp.ipc.b.c;
import com.heytap.msp.ipc.common.exception.IPCBridgeException;
import com.huawei.openalliance.ad.constant.az;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class d extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ReentrantLock f6367a;
    int b;
    int c;
    private String d;

    public d(Context context, IPCModule iPCModule, Bundle bundle) {
        this(context, h.a(iPCModule), iPCModule.targetComponentClass(), bundle);
    }

    @Override // com.heytap.msp.ipc.a.g
    public String a() {
        return this.d;
    }

    @Override // com.heytap.msp.ipc.a.g
    public String b() {
        return this.d;
    }

    @Override // com.heytap.msp.ipc.a.g
    public IPCType c() {
        return IPCType.ACTIVITY;
    }

    public d(Context context, List<l> list, String str, Bundle bundle) {
        super(list);
        this.f6367a = new ReentrantLock(true);
        this.b = 5000;
        this.c = 65244;
        this.h = context;
        this.j = bundle;
        this.d = str;
    }

    public void a(int i, Object... objArr) throws IPCBridgeException {
        Object[] objArr2;
        Activity activity = null;
        Object[] objArr3 = null;
        if (objArr == null || objArr.length <= 0) {
            objArr2 = null;
        } else {
            Object obj = objArr[0];
            Activity activity2 = obj instanceof Activity ? (Activity) obj : null;
            if (objArr.length > 1) {
                objArr3 = new Object[objArr.length - 1];
                System.arraycopy(objArr, 1, objArr3, 0, objArr.length - 1);
            }
            objArr2 = objArr3;
            activity = activity2;
        }
        a(activity, a(), i, objArr2);
    }

    public void a(Activity activity, String str, int i, Object... objArr) throws IPCBridgeException {
        l lVar;
        l lVarA;
        j.b("BaseActivityClient", "call --- activity:" + activity.getClass().getName() + ", targetClass:" + str + ", methodId:" + i);
        if (!c.a(objArr)) {
            throw new IPCBridgeException("Invalid params", 101006);
        }
        com.heytap.msp.ipc.b.c cVarA = new c.a().a(activity).a(activity.getPackageName()).a(this.j).b(str).a(i).a();
        j.a("BaseActivityClient", "call clientMethodInterceptors");
        for (com.heytap.msp.ipc.b.a aVar : this.k) {
            com.heytap.msp.ipc.b.b bVarA = aVar.a(cVarA);
            j.a("BaseActivityClient", "clientMethodInterceptor --- interceptor:" + aVar.getClass().getName() + ", result:" + bVarA.toString());
            if (bVarA.c()) {
                throw new IPCBridgeException(bVarA.b(), bVarA.a());
            }
        }
        try {
            if (this.f6367a.tryLock() || this.f6367a.tryLock((long) this.b, TimeUnit.MILLISECONDS)) {
                lVarA = a(activity);
                try {
                    this.f6367a.unlock();
                } catch (InterruptedException e) {
                    lVar = lVarA;
                    e = e;
                    j.a("BaseActivityClient", "lock", e);
                    try {
                        this.f6367a.unlock();
                    } catch (Exception e2) {
                        j.a("BaseActivityClient", "unlock", e2);
                    }
                    lVarA = lVar;
                }
            } else {
                j.b("BaseActivityClient", "lock fail");
                lVarA = null;
            }
        } catch (InterruptedException e3) {
            e = e3;
            lVar = null;
        }
        if (lVarA == null) {
            throw new IPCBridgeException("No target found", 101001);
        }
        j.b("BaseActivityClient", "use package:" + lVarA);
        Bundle bundleA = c.a(str, null, i, objArr);
        Bundle bundle = this.j;
        if (bundle != null) {
            bundleA.putBundle(az.M, bundle);
        }
        j.b("BaseActivityClient", "start activity for result");
        activity.startActivityForResult(a(lVarA.b, a(), lVarA.d, bundleA), this.c);
    }
}
