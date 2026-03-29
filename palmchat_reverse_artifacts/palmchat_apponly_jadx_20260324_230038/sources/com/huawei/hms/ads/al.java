package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class al extends bk {
    private static final String Z = "JsbCommonAnalysis";

    public al() {
        super(ak.M);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        final JSONObject jSONObject = new JSONObject(str);
        Code(context, str, true, new ad() { // from class: com.huawei.hms.ads.al.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                RemoteCallResultCallback remoteCallResultCallback2;
                String str2;
                int i;
                if (jSONObject.optBoolean(com.huawei.openalliance.ad.constant.az.bd, true) && adContentData == null) {
                    fh.V(al.Z, "ad is null");
                    remoteCallResultCallback2 = remoteCallResultCallback;
                    str2 = al.this.Code;
                    i = 3002;
                } else {
                    fh.V(al.Z, "start report analysis");
                    db.Code(context, str);
                    remoteCallResultCallback2 = remoteCallResultCallback;
                    str2 = al.this.Code;
                    i = 1000;
                }
                ah.Code(remoteCallResultCallback2, str2, i, null, true);
            }
        });
    }
}
