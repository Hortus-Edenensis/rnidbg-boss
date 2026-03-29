package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class an extends ah {
    private static final String Z = "JsbFeedbackClose";

    public an() {
        super(ak.G);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        if (fh.Code()) {
            fh.Code(Z, "start");
        }
        final String strOptString = new JSONObject(str).optString(com.huawei.openalliance.ad.constant.az.aV, "3");
        Code(context, str, new ad() { // from class: com.huawei.hms.ads.an.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                int i;
                if (adContentData != null) {
                    db.Code(context, adContentData, strOptString);
                    i = 1000;
                } else {
                    fh.Code(an.Z, "ad not exist");
                    i = 3002;
                }
                ah.Code(remoteCallResultCallback, an.this.Code, i, null, true);
            }
        });
    }
}
