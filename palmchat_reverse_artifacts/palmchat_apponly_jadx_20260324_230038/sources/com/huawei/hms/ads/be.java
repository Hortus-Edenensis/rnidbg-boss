package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.download.app.AppStatus;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class be extends au {
    public be() {
        super(ak.d);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, new ad() { // from class: com.huawei.hms.ads.be.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                AppStatus appStatusS = AppStatus.DOWNLOAD;
                if (adContentData != null) {
                    appStatusS = com.huawei.hms.ads.jsb.a.Code(context).Code().S(context, new com.huawei.openalliance.ad.inter.data.s(adContentData));
                }
                ah.Code(remoteCallResultCallback, be.this.Code, 1000, be.this.Code(appStatusS), true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Code(AppStatus appStatus) {
        return appStatus == null ? AppStatus.DOWNLOAD.toString() : appStatus.toString();
    }
}
