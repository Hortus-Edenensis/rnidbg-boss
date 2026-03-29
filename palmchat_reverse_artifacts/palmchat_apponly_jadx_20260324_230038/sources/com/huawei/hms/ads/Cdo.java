package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.r;

/* JADX INFO: renamed from: com.huawei.hms.ads.do, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class Cdo extends dn {
    private static final String B = "117";
    private static final String I = "115";
    private static final String V = "ConfirmDownloadAlertStrategy";
    private static final String Z = "116";

    /* JADX INFO: renamed from: com.huawei.hms.ads.do$a */
    /* JADX INFO: compiled from: SearchBox */
    public static class a implements RemoteCallResultCallback<String> {
        private a() {
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            if (callResult.getCode() != -1) {
                fh.V(Cdo.V, "confirm reminder reject");
            }
        }
    }

    public Cdo(Context context) {
        super(context);
    }

    private void Code(final com.huawei.openalliance.ad.inter.data.AppInfo appInfo, final AdContentData adContentData) {
        fh.V(V, "showConfirmDownloadAlert, context:" + Code());
        Code(I, adContentData);
        com.huawei.openalliance.ad.download.app.f.Code(Code(), "11".equals(appInfo.y()), new r.a() { // from class: com.huawei.hms.ads.do.1
            @Override // com.huawei.openalliance.ad.utils.r.a
            public void Code() {
                Cdo.this.Code(Cdo.Z, adContentData);
                Cdo.this.Code(appInfo);
            }

            @Override // com.huawei.openalliance.ad.utils.r.a
            public void V() {
                Cdo.this.Code(Cdo.B, adContentData);
                Cdo.this.V(appInfo);
            }
        });
    }

    @Override // com.huawei.hms.ads.dn
    public void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, long j) {
        if (appInfo != null && adContentData != null) {
            Code(appInfo, adContentData);
        } else {
            fh.V(V, "appInfo or contentRecord is empty");
            V(appInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str, AdContentData adContentData) {
        com.huawei.openalliance.ad.download.app.c.Code(this.Code, str, adContentData, new a(), String.class);
    }
}
