package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class bn extends bk {
    private static final String Z = "JsbReportCommonEvent";

    public bn() {
        super(ak.K);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        final AdEventReport adEventReport = (AdEventReport) com.huawei.openalliance.ad.utils.ad.Code(str, AdEventReport.class, new Class[0]);
        final JSONObject jSONObject = new JSONObject(str);
        Code(context, str, true, new ad() { // from class: com.huawei.hms.ads.bn.1
            /* JADX WARN: Removed duplicated region for block: B:11:0x003b  */
            @Override // com.huawei.hms.ads.ad
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void Code(AdContentData adContentData) {
                RemoteCallResultCallback remoteCallResultCallback2;
                String str2;
                int i;
                if (jSONObject.optBoolean(com.huawei.openalliance.ad.constant.az.bd, true)) {
                    if (adContentData == null) {
                        fh.V(bn.Z, "ad is null");
                        remoteCallResultCallback2 = remoteCallResultCallback;
                        str2 = bn.this.Code;
                        i = 3002;
                    } else if (!bn.this.Code(adContentData)) {
                        fh.V(bn.Z, "ad is not in whitelist");
                        remoteCallResultCallback2 = remoteCallResultCallback;
                        str2 = bn.this.Code;
                        i = 3004;
                    }
                } else if (adEventReport == null) {
                    fh.V(bn.Z, "parmas is null");
                    remoteCallResultCallback2 = remoteCallResultCallback;
                    str2 = bn.this.Code;
                    i = 3001;
                } else {
                    fh.V(bn.Z, "start report event");
                    jk.Code(context, str);
                    remoteCallResultCallback2 = remoteCallResultCallback;
                    str2 = bn.this.Code;
                    i = 1000;
                }
                ah.Code(remoteCallResultCallback2, str2, i, null, true);
            }
        });
    }
}
