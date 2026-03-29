package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.ji;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class bu extends bk {
    private static final String Z = "JsbReportShowEvent";

    public bu() {
        super(ak.l);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fh.Code(Z, "start");
        final AdEventReport adEventReport = (AdEventReport) com.huawei.openalliance.ad.utils.ad.Code(str, AdEventReport.class, new Class[0]);
        final JSONObject jSONObject = new JSONObject(str);
        Code(context, str, true, new ad() { // from class: com.huawei.hms.ads.bu.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                int i;
                AdEventReport adEventReport2 = adEventReport;
                if (adEventReport2 != null) {
                    if (adEventReport2.F()) {
                        jk.Code(context, adContentData, adEventReport.D().longValue(), adEventReport.L().intValue());
                    } else if (adContentData != null) {
                        adContentData.Code(bu.this.S(jSONObject.optString(com.huawei.openalliance.ad.constant.az.aW)));
                        if (bu.this.Code(adContentData)) {
                            jk.Code(context, adContentData, new ji.a().Code(adEventReport.D()).Code(adEventReport.L()).V(adEventReport.a()).I(adEventReport.r()).Code(adEventReport.v()).Code());
                        } else {
                            fh.V(bu.Z, "ad is not in whitelist");
                            i = 3004;
                        }
                    } else {
                        i = 3002;
                    }
                    i = 1000;
                } else {
                    i = 3001;
                }
                ah.Code(remoteCallResultCallback, bu.this.Code, i, null, true);
            }
        });
    }
}
