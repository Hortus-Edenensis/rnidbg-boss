package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class bv extends bk {
    private static final String Z = "JsbReportShowStartEvent";

    public bv() {
        super(ak.m);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fh.Code(Z, "start");
        Code(context, str, new ad() { // from class: com.huawei.hms.ads.bv.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                jk.Code(context, adContentData);
                bv.this.V(remoteCallResultCallback, true);
            }
        });
    }
}
