package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class bp extends bk {
    private static final String Z = "JsbReportPlayPauseEvent";

    public bp() {
        super(ak.l);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fh.Code(Z, "start");
        final AdEventReport adEventReport = (AdEventReport) com.huawei.openalliance.ad.utils.ad.Code(str, AdEventReport.class, new Class[0]);
        Code(context, str, new ad() { // from class: com.huawei.hms.ads.bp.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                AdEventReport adEventReport2 = adEventReport;
                if (adEventReport2 != null) {
                    jk.Code(context, adContentData, com.huawei.openalliance.ad.constant.aj.C, Long.valueOf(adEventReport2.d() == null ? 0L : adEventReport.d().longValue()), Long.valueOf(adEventReport.e() != null ? adEventReport.e().longValue() : 0L), Integer.valueOf(adEventReport.f() == null ? 0 : adEventReport.f().intValue()), Integer.valueOf(adEventReport.g() != null ? adEventReport.g().intValue() : 0));
                }
                bp.this.V(remoteCallResultCallback, true);
            }
        });
    }
}
