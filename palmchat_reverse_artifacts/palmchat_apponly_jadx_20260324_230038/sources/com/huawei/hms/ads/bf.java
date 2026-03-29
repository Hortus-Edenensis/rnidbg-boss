package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class bf extends ah {
    private static final String Z = "JsbRegisterAppStatusProxy";

    public bf() {
        super(ak.y);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, false, new ad() { // from class: com.huawei.hms.ads.bf.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                if (adContentData != null) {
                    com.huawei.hms.ads.jsb.a.Code(context).Code(adContentData.a(), adContentData.y());
                }
            }
        });
    }
}
