package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class bl extends bk {
    private static final String Z = "JsbReportClickEvent";

    public bl() {
        super(ak.n);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fh.Code(Z, "start");
        final AdEventReport adEventReport = (AdEventReport) com.huawei.openalliance.ad.utils.ad.Code(str, AdEventReport.class, new Class[0]);
        final JSONObject jSONObject = new JSONObject(str);
        Code(context, str, true, new ad() { // from class: com.huawei.hms.ads.bl.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                int i;
                String str2;
                String strP;
                int i2;
                int i3;
                int i4;
                if (adContentData == null) {
                    fh.V(bl.Z, "ad not exist");
                    i = 3002;
                } else if (bl.this.Code(adContentData)) {
                    adContentData.Code(bl.this.S(jSONObject.optString(com.huawei.openalliance.ad.constant.az.aW)));
                    AdEventReport adEventReport2 = adEventReport;
                    boolean z = false;
                    String strJ = com.huawei.openalliance.ad.constant.v.f6927a;
                    if (adEventReport2 != null) {
                        int iH = adEventReport2.h();
                        i3 = adEventReport.i();
                        if (!TextUtils.isEmpty(adEventReport.j())) {
                            strJ = adEventReport.j();
                        }
                        int iIntValue = adEventReport.a() != null ? adEventReport.a().intValue() : 13;
                        strP = adEventReport.p();
                        i4 = iIntValue;
                        str2 = strJ;
                        i2 = iH;
                    } else {
                        str2 = com.huawei.openalliance.ad.constant.v.f6927a;
                        strP = null;
                        i2 = 0;
                        i3 = 0;
                        i4 = 13;
                    }
                    MaterialClickInfo materialClickInfoC = bl.this.C(str);
                    if (materialClickInfoC.D() == null && materialClickInfoC.L() == null) {
                        z = true;
                    }
                    if (13 == i4 && z) {
                        materialClickInfoC.B((Integer) 1);
                    }
                    Context context2 = context;
                    jk.Code(context2, adContentData, strP, i2, i3, str2, i4, com.huawei.openalliance.ad.utils.b.Code(context2), materialClickInfoC);
                    i = 1000;
                } else {
                    fh.V(bl.Z, "ad is not in whitelist");
                    i = 3004;
                }
                ah.Code(remoteCallResultCallback, bl.this.Code, i, null, true);
            }
        });
    }
}
