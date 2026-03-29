package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class bd extends au {
    public bd() {
        super(ak.c);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, new ad() { // from class: com.huawei.hms.ads.bd.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                int iF;
                if (adContentData != null) {
                    iF = com.huawei.hms.ads.jsb.a.Code(context).Code().F(context, new com.huawei.openalliance.ad.inter.data.s(adContentData));
                } else {
                    iF = 0;
                }
                ah.Code(remoteCallResultCallback, bd.this.Code, 1000, Integer.valueOf(iF), true);
            }
        });
    }
}
