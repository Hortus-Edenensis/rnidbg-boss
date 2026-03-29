package com.heytap.mspsdk.proxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.heytap.msp.IMspCoreBinder;
import com.heytap.msp.IResult;
import com.heytap.mspsdk.constants.Constants;
import com.heytap.mspsdk.exception.MspProxyException;
import com.heytap.mspsdk.log.MspLog;
import com.opos.process.bridge.client.BaseActivityClient;
import com.opos.process.bridge.client.BaseProviderClient;
import com.opos.process.bridge.client.BaseServiceClient;
import com.opos.process.bridge.provider.BridgeExecuteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class g implements com.heytap.mspsdk.interceptor.b<e, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f6411a;

    public g(a aVar) {
        this.f6411a = aVar;
    }

    private void b(final e eVar) throws InterruptedException {
        eVar.e.j();
        boolean z = true;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        synchronized (this.f6411a.b()) {
            if (this.f6411a.c().values().size() > 0) {
                z = false;
            }
            this.f6411a.c().put(Long.valueOf(Thread.currentThread().getId()), countDownLatch);
            if (z) {
                com.heytap.mspsdk.executor.b.a().a(new Runnable() { // from class: com.heytap.mspsdk.proxy.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6412a.e(eVar);
                    }
                });
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        MspLog.iIgnore("PreConnectCoreInterceptor", "InnerInvocationHandler method [" + eVar.b + "], await connect begin");
        eVar.a("startActivityWait");
        countDownLatch.await(5000L, TimeUnit.MILLISECONDS);
        eVar.a("startActivityWaitEnd");
        this.f6411a.c().clear();
        MspLog.iIgnore("PreConnectCoreInterceptor", "InnerInvocationHandler method [" + eVar.b + "], await connect end, cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(e eVar) {
        Activity activityB;
        Object obj = eVar.f6409a;
        Intent intent = new Intent(Constants.APP_MSP_CORE_ACTIVITY_ACTION);
        intent.setPackage("com.heytap.htms");
        intent.putExtra(Constants.KEY_MSP_RESULT_RECEIVER, d(eVar));
        long jNanoTime = System.nanoTime();
        MspLog.d("PreConnectCoreInterceptor", "startTargetCp startTargetCPTime = " + jNanoTime + "   TimeMills = " + System.currentTimeMillis());
        if (eVar.a().getBundle(Constants.BUNDLE_KEY_MSP_SDK_COMMON_BUNDLE) != null) {
            eVar.a().getBundle(Constants.BUNDLE_KEY_MSP_SDK_COMMON_BUNDLE).putLong(Constants.BUNDLE_KEY_MSP_SDK_START_TARGET_TIME_POINT, jNanoTime);
        }
        intent.putExtra(Constants.BUNDLE_KEY_MSP_SDK_START_TARGET_TIME_POINT, jNanoTime);
        try {
        } catch (BridgeExecuteException e) {
            e.printStackTrace();
            MspLog.e("PreConnectCoreInterceptor", e);
        }
        if (!(obj instanceof BaseProviderClient)) {
            if (obj instanceof BaseServiceClient) {
                Intent serviceIntent = ((BaseServiceClient) obj).getServiceIntent();
                intent.putExtra("target_service_intent", serviceIntent);
                MspLog.iIgnore("PreConnectCoreInterceptor", "target_service_intent, " + serviceIntent.toUri(0));
            }
            activityB = com.heytap.mspsdk.common.a.a().b();
            if (activityB != null) {
                intent.addFlags(276824064);
                com.heytap.mspsdk.core.e.a().b().startActivity(intent);
                return;
            } else {
                if (!(obj instanceof BaseActivityClient)) {
                    intent.addFlags(276824064);
                }
                activityB.startActivity(intent);
                return;
            }
        }
        String authority = ((BaseProviderClient) obj).getAuthority();
        intent.putExtra("target_authority", authority);
        MspLog.iIgnore("PreConnectCoreInterceptor", "target_authority, " + authority);
        activityB = com.heytap.mspsdk.common.a.a().b();
        if (activityB != null) {
        }
    }

    private ResultReceiver d(final e eVar) {
        final Handler handler = null;
        return a(new ResultReceiver(handler) { // from class: com.heytap.mspsdk.proxy.PreConnectCoreInterceptor$2
            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i, Bundle bundle) {
                super.onReceiveResult(i, bundle);
                eVar.a("startActBack");
                MspLog.iIgnore("PreConnectCoreInterceptor", "MspResultReceiver onReceiveResult " + i + ", thread name " + Thread.currentThread().getName());
                if (i == 1000) {
                    synchronized (this.b.f6411a.b()) {
                        IMspCoreBinder iMspCoreBinderAsInterface = IMspCoreBinder.Stub.asInterface(bundle.getBinder(Constants.KEY_MSP_CORE_BINDER));
                        if (iMspCoreBinderAsInterface != null) {
                            MspLog.iIgnore("PreConnectCoreInterceptor", "MspResultReceiver onReceiveResult takes core binder");
                            com.heytap.mspsdk.core.e.a().a(iMspCoreBinderAsInterface);
                        }
                        Collection<CountDownLatch> collectionValues = this.b.f6411a.c().values();
                        MspLog.iIgnore("PreConnectCoreInterceptor", "MspResultReceiver onReceiveResult latches size " + collectionValues.size());
                        if (!collectionValues.isEmpty() && collectionValues.size() > 0) {
                            Iterator<CountDownLatch> it = collectionValues.iterator();
                            while (it.hasNext()) {
                                it.next().countDown();
                                MspLog.iIgnore("PreConnectCoreInterceptor", "MspResultReceiver onReceiveResult latches countDown()");
                            }
                        }
                    }
                }
                eVar.a("startActBackEnd");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(e eVar) {
        try {
            eVar.a("startActReal");
            c(eVar);
        } catch (Exception e) {
            eVar.a("startActivityEpt");
            e.printStackTrace();
            MspLog.e("PreConnectCoreInterceptor", e);
            Collection<CountDownLatch> collectionValues = this.f6411a.c().values();
            if (!collectionValues.isEmpty()) {
                for (CountDownLatch countDownLatch : collectionValues) {
                    if (countDownLatch.getCount() > 0) {
                        countDownLatch.countDown();
                    }
                }
            }
            MspLog.iIgnore("PreConnectCoreInterceptor", "start Activity error latch countDown()");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> Bundle a(T t, com.heytap.mspsdk.event.a aVar) {
        aVar.f();
        Bundle bundle = new Bundle();
        try {
        } catch (BridgeExecuteException e) {
            e.printStackTrace();
            MspLog.e("PreConnectCoreInterceptor", e);
        }
        if (!(t instanceof BaseProviderClient)) {
            if (t instanceof BaseServiceClient) {
                Intent serviceIntent = ((BaseServiceClient) t).getServiceIntent();
                bundle.putParcelable("target_service_intent", serviceIntent);
                MspLog.iIgnore("PreConnectCoreInterceptor", "target_service_intent, " + serviceIntent.toUri(0));
            }
            aVar.g();
            return bundle;
        }
        String authority = ((BaseProviderClient) t).getAuthority();
        bundle.putString("target_authority", authority);
        MspLog.iIgnore("PreConnectCoreInterceptor", "target_authority, " + authority);
        aVar.g();
        return bundle;
    }

    private ResultReceiver a(ResultReceiver resultReceiver) {
        Parcel parcelObtain = Parcel.obtain();
        resultReceiver.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        ResultReceiver resultReceiver2 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return resultReceiver2;
    }

    @Override // com.heytap.mspsdk.interceptor.b
    public Object a(com.heytap.mspsdk.interceptor.a<e, Object> aVar) throws Exception {
        String str;
        e eVarA = aVar.a();
        eVarA.a("PreConnect");
        Object obj = eVarA.f6409a;
        if (!(obj instanceof BaseActivityClient)) {
            if (obj instanceof BaseProviderClient) {
                try {
                    eVarA.a("PreProviderStart");
                    return aVar.a(eVarA);
                } catch (Exception e) {
                    if (e instanceof MspProxyException) {
                        Exception exc = (Exception) e.getCause();
                        if (exc instanceof BridgeExecuteException) {
                            BridgeExecuteException bridgeExecuteException = (BridgeExecuteException) exc;
                            if (bridgeExecuteException.getCode() == 101001 || bridgeExecuteException.getCode() == 101010) {
                                a(eVarA);
                                str = "PreProviderRetry";
                            }
                        }
                    }
                    throw e;
                }
            }
            if (!(obj instanceof BaseServiceClient)) {
                return aVar.a(eVarA);
            }
            eVarA.a("BindServiceStart");
            try {
                return aVar.a(eVarA);
            } catch (Exception e2) {
                if (e2 instanceof MspProxyException) {
                    Exception exc2 = (Exception) e2.getCause();
                    if (exc2 instanceof BridgeExecuteException) {
                        BridgeExecuteException bridgeExecuteException2 = (BridgeExecuteException) exc2;
                        MspLog.e("PreConnectCoreInterceptor", "bind service code: " + bridgeExecuteException2.getCode());
                        if (bridgeExecuteException2.getCode() == 101004 || bridgeExecuteException2.getCode() == 101005) {
                            a(eVarA);
                        }
                    }
                }
                throw e2;
            }
        }
        str = "PreActivityStart";
        eVarA.a(str);
        return aVar.a(eVarA);
    }

    private void a(e eVar) {
        eVar.a("startCore");
        eVar.e.d();
        boolean zA = com.heytap.mspsdk.core.e.a().a((ArrayList<String>) null);
        eVar.a("checkBinderEnd");
        eVar.e.e();
        if (zA) {
            Bundle bundleA = a(eVar.f6409a, eVar.e);
            try {
                eVar.a("startTarget");
                a(eVar, bundleA);
                eVar.a("startTargetEnd");
                return;
            } catch (RemoteException | InterruptedException e) {
                eVar.a("startTargetEx");
                MspLog.e("PreConnectCoreInterceptor", e);
                return;
            }
        }
        MspLog.iIgnore("PreConnectCoreInterceptor", "InnerInvocationHandler method [" + eVar.b + "], IPC disabled");
        try {
            eVar.e.j();
            eVar.a("startActivity");
            b(eVar);
            eVar.a("startActivityEnd");
            eVar.e.k();
        } catch (InterruptedException e2) {
            MspLog.e(e2);
        }
    }

    public void a(final e eVar, Bundle bundle) throws InterruptedException, RemoteException {
        eVar.e.h();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        synchronized (this.f6411a.b()) {
            if (this.f6411a.c().values().size() <= 0) {
                IMspCoreBinder iMspCoreBinderC = com.heytap.mspsdk.core.e.a().c();
                long jNanoTime = System.nanoTime();
                MspLog.d("PreConnectCoreInterceptor", "startTargetCp startTargetCPTime = " + jNanoTime + "   TimeMills = " + System.currentTimeMillis());
                if (eVar.a().getBundle(Constants.BUNDLE_KEY_MSP_SDK_COMMON_BUNDLE) != null) {
                    eVar.a().getBundle(Constants.BUNDLE_KEY_MSP_SDK_COMMON_BUNDLE).putLong(Constants.BUNDLE_KEY_MSP_SDK_START_TARGET_TIME_POINT, jNanoTime);
                }
                bundle.putLong(Constants.BUNDLE_KEY_MSP_SDK_START_TARGET_TIME_POINT, jNanoTime);
                iMspCoreBinderC.call("start_target_cp", bundle, new IResult.Stub() { // from class: com.heytap.mspsdk.proxy.PreConnectCoreInterceptor$1
                    @Override // com.heytap.msp.IResult
                    public void onResult(int i) throws RemoteException {
                        eVar.a("startTargetBack");
                        if (countDownLatch.getCount() > 0) {
                            countDownLatch.countDown();
                            MspLog.iIgnore("PreConnectCoreInterceptor", "onResult latch countDown()");
                        }
                        Collection<CountDownLatch> collectionValues = this.this$0.f6411a.c().values();
                        MspLog.iIgnore("PreConnectCoreInterceptor", "onResult latches size " + collectionValues.size());
                        if (collectionValues.isEmpty() || collectionValues.size() <= 0) {
                            return;
                        }
                        for (CountDownLatch countDownLatch2 : collectionValues) {
                            if (countDownLatch2.getCount() > 0) {
                                countDownLatch2.countDown();
                                MspLog.iIgnore("PreConnectCoreInterceptor", "onResult latches countDown()");
                            }
                        }
                    }
                });
            }
            if (countDownLatch.getCount() > 0) {
                this.f6411a.c().put(Long.valueOf(Thread.currentThread().getId()), countDownLatch);
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        MspLog.iIgnore("PreConnectCoreInterceptor", "InnerInvocationHandler start target cp, method [" + eVar.b + "], await connect begin");
        eVar.a("TargetWait");
        countDownLatch.await(5000L, TimeUnit.MILLISECONDS);
        eVar.a("TargetWaitEnd");
        this.f6411a.c().clear();
        MspLog.iIgnore("PreConnectCoreInterceptor", "InnerInvocationHandler start target cp, method [" + eVar.b + "], await connect end, cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        eVar.e.i();
    }
}
