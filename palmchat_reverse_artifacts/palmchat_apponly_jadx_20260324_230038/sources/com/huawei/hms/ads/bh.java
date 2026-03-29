package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class bh extends au {
    public bh() {
        super(ak.D);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, new ad() { // from class: com.huawei.hms.ads.bh.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                final int[] iArr = {-1};
                if (adContentData != null) {
                    final com.huawei.openalliance.ad.inter.data.s sVar = new com.huawei.openalliance.ad.inter.data.s(adContentData);
                    com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.bh.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int[] iArr2 = iArr;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            iArr2[0] = bh.this.V(context, str).Z(context, sVar);
                        }
                    });
                }
                ah.Code(remoteCallResultCallback, bh.this.Code, 1000, Integer.toString(iArr[0]), true);
            }
        });
    }
}
