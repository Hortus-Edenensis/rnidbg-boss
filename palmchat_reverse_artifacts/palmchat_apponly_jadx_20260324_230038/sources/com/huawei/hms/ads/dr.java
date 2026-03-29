package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.r;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class dr extends dn {
    public static final String I = "16";
    public static final String V = "15";
    private static final String Z = "AlertReminder";

    public dr(Context context) {
        super(context);
    }

    private void I(final com.huawei.openalliance.ad.inter.data.AppInfo appInfo, final AdContentData adContentData, long j) {
        fh.V(Z, "showNonWifiAlert, context:" + Code());
        com.huawei.openalliance.ad.download.app.f.V(Code(), j, new r.a() { // from class: com.huawei.hms.ads.dr.1
            @Override // com.huawei.openalliance.ad.utils.r.a
            public void Code() {
                com.huawei.openalliance.ad.download.app.c.Code(dr.this.Code, "15", adContentData, new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.dr.1.1
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        if (callResult.getCode() != -1) {
                            fh.V(dr.Z, " traffic reminder accept");
                        }
                    }
                }, String.class);
                dr.this.Code(appInfo);
            }

            @Override // com.huawei.openalliance.ad.utils.r.a
            public void V() {
                com.huawei.openalliance.ad.download.app.c.Code(dr.this.Code, "16", adContentData, new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.dr.1.2
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        if (callResult.getCode() != -1) {
                            fh.V(dr.Z, " traffic reminder reject");
                        }
                    }
                }, String.class);
                dr.this.V(appInfo);
            }
        });
    }

    @Override // com.huawei.hms.ads.dn
    public void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, long j) {
        if (appInfo != null && adContentData != null) {
            I(appInfo, adContentData, j);
        } else {
            fh.V(Z, "appInfo or contentRecord is empty");
            V(appInfo);
        }
    }
}
