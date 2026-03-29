package com.bun.miitmdid.provider.huawei;

import android.content.Context;
import com.bun.miitmdid.m;
import com.bun.miitmdid.p0;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.entity.AAIDResult;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import com.huawei.hms.opendevice.OpenDevice;
import com.huawei.hms.support.api.opendevice.OdidResult;
import defpackage.s74;
import defpackage.w64;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class HWProvider extends m {
    public static final String TAG = "HWProvider";
    private AdvertisingIdClient.Info mAdvertisingIdInfo;
    private int mCallbackCount;
    public Context mContext;

    public HWProvider(Context context) {
        this.mContext = checkContext(context);
        p0.c(TAG, "enter into HWProvider");
    }

    private native void finishCallback();

    private native void initCallbackCount();

    private native boolean isClassExists(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getIdAAID$0(AAIDResult aAIDResult) {
        this.AAIDCache = aAIDResult.getId();
        finishCallback();
        p0.a(TAG, "getAAID successfully, aaid is " + this.AAIDCache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getIdAAID$1(Exception exc) {
        finishCallback();
        p0.a(TAG, "getAAID failed, catch exception: " + exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getIdVAID$2(OdidResult odidResult) {
        this.VAIDCache = odidResult.getId();
        finishCallback();
        p0.a(TAG, "getVAID successfully, the VAID is " + this.VAIDCache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getIdVAID$3(Exception exc) {
        finishCallback();
        p0.a(TAG, "getVAID failed, catch exception : " + exc);
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public native void doStart();

    public void getIdAAID() {
        if (!isGetOAID()) {
            this.isSupportedCache = true;
        }
        if (isClassExists("com.huawei.hms.opendevice.OpenDevice")) {
            HmsInstanceId.getInstance(this.mContext).getAAID().c(new s74() { // from class: tf2
                @Override // defpackage.s74
                public final void onSuccess(Object obj) {
                    this.f20976a.lambda$getIdAAID$0((AAIDResult) obj);
                }
            }).b(new w64() { // from class: uf2
                @Override // defpackage.w64
                public final void onFailure(Exception exc) {
                    this.f21202a.lambda$getIdAAID$1(exc);
                }
            });
            return;
        }
        p0.a(TAG, "no combined class to unsupport get AAID ");
        this.AAIDCache = "";
        finishCallback();
    }

    public native void getIdOAID();

    public void getIdVAID() {
        if (!isGetOAID()) {
            this.isSupportedCache = true;
        }
        if (isClassExists("com.huawei.hms.opendevice.OpenDevice")) {
            OpenDevice.getOpenDeviceClient(this.mContext).getOdid().c(new s74() { // from class: rf2
                @Override // defpackage.s74
                public final void onSuccess(Object obj) {
                    this.f20460a.lambda$getIdVAID$2((OdidResult) obj);
                }
            }).b(new w64() { // from class: sf2
                @Override // defpackage.w64
                public final void onFailure(Exception exc) {
                    this.f20732a.lambda$getIdVAID$3(exc);
                }
            });
            return;
        }
        p0.a(TAG, "no combined class to unsupport get VAID ");
        this.VAIDCache = "";
        finishCallback();
    }

    @Override // com.bun.miitmdid.m, com.bun.miitmdid.interfaces.IdSupplier
    public native boolean isLimited();

    @Override // com.bun.miitmdid.m, com.bun.miitmdid.interfaces.IIdProvider
    public native boolean isSync();

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public native void shutDown();
}
