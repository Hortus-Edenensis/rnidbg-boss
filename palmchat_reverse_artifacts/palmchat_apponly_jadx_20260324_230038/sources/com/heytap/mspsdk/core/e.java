package com.heytap.mspsdk.core;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.heytap.msp.IMspCallback;
import com.heytap.msp.IMspCoreBinder;
import com.heytap.msp.MspResponse;
import com.heytap.msp.ipc.a.m;
import com.heytap.msp.ipc.annotation.IPCModule;
import com.heytap.mspsdk.constants.Constants;
import com.heytap.mspsdk.constants.MspSdkCode;
import com.heytap.mspsdk.log.MspLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f6393a;
    private static AtomicBoolean e = new AtomicBoolean(false);
    private volatile IMspCoreBinder b;
    private volatile com.heytap.mspsdk.guide.b c;
    private IBinder.DeathRecipient d;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final e f6394a = new e();
    }

    private e() {
        this.b = null;
        this.c = null;
        this.d = new IBinder.DeathRecipient() { // from class: com.heytap.mspsdk.core.f
            @Override // android.os.IBinder.DeathRecipient
            public final void binderDied() {
                this.f6395a.e();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        MspLog.iIgnore("SdkRunTime", "binderDied");
        this.b = null;
        d.a();
    }

    public Context b() {
        return f6393a;
    }

    public synchronized IMspCoreBinder c() {
        return this.b;
    }

    public void d() {
        this.c = null;
    }

    public static e a() {
        return a.f6394a;
    }

    private synchronized IMspCoreBinder b(ArrayList<String> arrayList) {
        try {
            IPCModule iPCModule = (IPCModule) com.heytap.mspsdk.core.a.class.getAnnotation(IPCModule.class);
            if (iPCModule == null) {
                return null;
            }
            b bVarA = b.a(b());
            com.heytap.msp.ipc.a.e eVar = new com.heytap.msp.ipc.a.e(b(), iPCModule, null, new Bundle());
            eVar.a((m) new com.heytap.mspsdk.proxy.c(bVarA));
            Object objA = eVar.a(0, new Object[0]);
            if (objA instanceof IBinder) {
                MspLog.iIgnore("SdkRunTime", "start connect");
                IMspCoreBinder iMspCoreBinderAsInterface = IMspCoreBinder.Stub.asInterface((IBinder) objA);
                a(iMspCoreBinderAsInterface);
                iMspCoreBinderAsInterface.call("getMspCoreBinder", null, null);
                MspLog.iIgnore("SdkRunTime", "connect success by provider");
                return iMspCoreBinderAsInterface;
            }
        } catch (Exception e2) {
            if (arrayList != null) {
                arrayList.add(e2.getMessage());
            }
            e2.printStackTrace();
            MspLog.w("SdkRunTime", e2);
        }
        return null;
    }

    public void a(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        f6393a = context;
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(com.heytap.mspsdk.common.a.a());
        } else {
            MspLog.e("SdkRunTime", "context is not Application");
        }
        e.set(true);
    }

    public void a(Context context, String str, final com.heytap.mspsdk.listener.a aVar) {
        if (!a(context, Constants.MSP_CORE_KIT_INFO_SERVICE_COMPONENT)) {
            MspLog.e("SdkRunTime", "getKitVersion: not support kit info service");
            if (aVar != null) {
                com.heytap.mspsdk.listener.b bVar = new com.heytap.mspsdk.listener.b();
                bVar.a(3010);
                bVar.a(MspSdkCode.MSP_NOT_SUPPORT_KITINFP_SERVICE);
                aVar.onResult(bVar);
                return;
            }
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString(Constants.BUNDLE_KEY_MSP_SDK_KIT_NAME, str);
            this.b.exec("get_kit_version", bundle, new IMspCallback.Stub() { // from class: com.heytap.mspsdk.core.SdkRunTime$1
                @Override // com.heytap.msp.IMspCallback
                public void callback(MspResponse mspResponse) throws RemoteException {
                    com.heytap.mspsdk.listener.b bVar2 = new com.heytap.mspsdk.listener.b();
                    bVar2.a(mspResponse.a());
                    bVar2.a(mspResponse.b());
                    if (mspResponse.c() != null) {
                        bVar2.a((HashMap<String, String>) mspResponse.c().getSerializable("result_map"));
                    }
                    com.heytap.mspsdk.listener.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.onResult(bVar2);
                    }
                }
            });
        } catch (Exception e2) {
            MspLog.e("SdkRunTime", "getKitVersion: " + e2.getMessage());
            if (aVar != null) {
                com.heytap.mspsdk.listener.b bVar2 = new com.heytap.mspsdk.listener.b();
                bVar2.a(MspSdkCode.CODE_METHOD_CALL_EXCEPTION);
                bVar2.a(e2.getMessage());
                aVar.onResult(bVar2);
            }
        }
    }

    public synchronized void a(IMspCoreBinder iMspCoreBinder) {
        if (this.b == null) {
            this.b = iMspCoreBinder;
            try {
                this.b.asBinder().linkToDeath(this.d, 0);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a(com.heytap.mspsdk.guide.b bVar) {
        if (!e.get()) {
            throw new RuntimeException("MspSdk.init() must be invoked at first!");
        }
        this.c = bVar;
    }

    public boolean a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.htms", str));
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        return listQueryIntentServices != null && listQueryIntentServices.size() > 0;
    }

    public synchronized boolean a(ArrayList<String> arrayList) {
        if (this.b == null || !this.b.asBinder().pingBinder()) {
            return b(arrayList) != null;
        }
        MspLog.iIgnore("SdkRunTime", "ping OK");
        return true;
    }
}
