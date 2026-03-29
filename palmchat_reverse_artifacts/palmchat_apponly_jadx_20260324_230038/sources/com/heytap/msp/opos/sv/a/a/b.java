package com.heytap.msp.opos.sv.a.a;

import android.content.Context;
import android.os.Bundle;
import com.heytap.msp.opos.sv.api.innerapi.KitUtils;
import com.heytap.msp.opos.sv.api.innerapi.MSPSDKManager;
import com.heytap.msp.opos.sv.interapi.MSPSvModule;
import com.heytap.msp.opos.sv.interapi.bean.csc.InitConfig;
import com.heytap.mspsdk.MspSdk;
import com.heytap.mspsdk.exception.MspSdkException;
import com.heytap.mspsdk.log.MspLog;
import com.opos.process.bridge.provider.BridgeException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f6377a = new AtomicBoolean(false);
    private Context b;

    @Override // com.heytap.msp.opos.sv.a.a.a
    public void enableLog() {
        com.opos.cmn.an.f.a.a();
        MspLog.setDebug(true);
    }

    @Override // com.heytap.msp.opos.sv.a.a.a
    public int getSDKVerCode() {
        return 1003000;
    }

    @Override // com.heytap.msp.opos.sv.a.a.a
    public String getSDKVerName() {
        return "1.3.0";
    }

    @Override // com.heytap.msp.opos.sv.a.a.a
    public String getSupportAuthVerCodeList(Context context) {
        return KitUtils.getSupportAuthVerCodeList(context);
    }

    @Override // com.heytap.msp.opos.sv.a.a.a
    public void init(Context context) {
        if (!this.f6377a.compareAndSet(false, true)) {
            com.opos.cmn.an.f.a.a("MSPSvSDKImpl", "already initialized");
        } else {
            this.b = context.getApplicationContext();
            com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.heytap.msp.opos.sv.a.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MSPSDKManager.getInstance().initIfNeed(b.this.b);
                        b bVar = b.this;
                        if (bVar.a(bVar.b)) {
                            Bundle bundle = new Bundle();
                            KitUtils.assembleBundle(bundle);
                            ((MSPSvModule.Interface) MspSdk.apiProxy(new MSPSvModule.Client(b.this.b, bundle))).init(new InitConfig());
                        } else {
                            com.opos.cmn.an.f.a.a("MSPSvSDKImpl", "kit not support init");
                        }
                    } catch (MspSdkException | BridgeException e) {
                        com.opos.cmn.an.f.a.d("MSPSvSDKImpl", "init", e);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) {
        return KitUtils.getKitVersion(context) >= 1000000;
    }
}
