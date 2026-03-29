package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class bg extends au {
    public bg() {
        super(ak.L);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, new ad() { // from class: com.huawei.hms.ads.bg.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                RemoteCallResultCallback remoteCallResultCallback2;
                String str2;
                if (adContentData != null) {
                    com.huawei.openalliance.ad.inter.data.s sVar = new com.huawei.openalliance.ad.inter.data.s(adContentData);
                    if (sVar.E() != null) {
                        com.huawei.openalliance.ad.download.app.b.Code(context).Code(bg.this.Code(sVar.E(), adContentData));
                        bg.this.V((RemoteCallResultCallback<String>) remoteCallResultCallback, true);
                        return;
                    }
                    remoteCallResultCallback2 = remoteCallResultCallback;
                    str2 = bg.this.Code;
                } else {
                    remoteCallResultCallback2 = remoteCallResultCallback;
                    str2 = bg.this.Code;
                }
                ah.Code(remoteCallResultCallback2, str2, 3002, null, true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AppDownloadTask Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData) {
        AppDownloadTask appDownloadTaskCode = new AppDownloadTask.a().Code(appInfo).Code();
        appDownloadTaskCode.C(adContentData.aF());
        appDownloadTaskCode.D(adContentData.M());
        appDownloadTaskCode.I(adContentData.D());
        appDownloadTaskCode.Z(adContentData.L());
        appDownloadTaskCode.C(adContentData.a());
        return appDownloadTaskCode;
    }
}
