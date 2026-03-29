package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class bi extends au {
    public bi() {
        super(ak.S);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, true, new ad() { // from class: com.huawei.hms.ads.bi.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                RemoteCallResultCallback remoteCallResultCallback2;
                String str2;
                int i;
                if (adContentData != null) {
                    final com.huawei.openalliance.ad.inter.data.s sVar = new com.huawei.openalliance.ad.inter.data.s(adContentData);
                    if (bi.this.Code(adContentData)) {
                        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.bi.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                int iCode = bi.this.V(context, str).Code(context, sVar);
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                ah.Code(remoteCallResultCallback, bi.this.Code, 1000, Integer.valueOf(iCode), true);
                            }
                        });
                        return;
                    } else {
                        remoteCallResultCallback2 = remoteCallResultCallback;
                        str2 = bi.this.Code;
                        i = 3004;
                    }
                } else {
                    remoteCallResultCallback2 = remoteCallResultCallback;
                    str2 = bi.this.Code;
                    i = 3002;
                }
                ah.Code(remoteCallResultCallback2, str2, i, null, true);
            }
        });
    }
}
