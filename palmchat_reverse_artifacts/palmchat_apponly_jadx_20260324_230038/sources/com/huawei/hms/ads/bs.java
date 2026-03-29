package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class bs extends bk {
    private static final String Z = "JsbReportPlayTimeEvent";

    public bs() {
        super(ak.l);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fh.Code(Z, "start");
        final long jOptLong = new JSONObject(str).optLong(com.huawei.openalliance.ad.constant.az.bb, 0L);
        Code(context, str, new ad() { // from class: com.huawei.hms.ads.bs.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                adContentData.B(jOptLong);
                jk.V(context, adContentData, com.huawei.openalliance.ad.constant.aj.h);
                bs.this.V(remoteCallResultCallback, true);
            }
        });
    }
}
