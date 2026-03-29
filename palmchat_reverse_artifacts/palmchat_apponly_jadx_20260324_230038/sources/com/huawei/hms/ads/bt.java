package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class bt extends bk {
    private static final String Z = "JsbReportPraiseEvent";

    public bt() {
        super(ak.H);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fh.Code(Z, "start");
        Code(context, str, new ad() { // from class: com.huawei.hms.ads.bt.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                db.Code(context, adContentData);
                bt.this.V(remoteCallResultCallback, true);
            }
        });
    }
}
