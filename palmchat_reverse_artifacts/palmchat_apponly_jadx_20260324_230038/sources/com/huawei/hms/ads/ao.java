package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
class ao extends ah {
    private static final int B = -1;
    private static final int Z = 0;

    public ao() {
        super(ak.v);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, new ad() { // from class: com.huawei.hms.ads.ao.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                if (adContentData == null) {
                    ah.Code(remoteCallResultCallback, ao.this.Code, 3002, null, true);
                } else {
                    ah.Code(remoteCallResultCallback, ao.this.Code, 1000, Integer.valueOf(com.huawei.openalliance.ad.utils.z.Code(context, adContentData) ? 0 : -1), true);
                }
            }
        });
    }
}
