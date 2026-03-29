package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class bm extends bk {
    private static final String Z = "JsbReportCloseEvent";

    public bm() {
        super(ak.o);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fh.Code(Z, Z);
        final AdEventReport adEventReport = (AdEventReport) com.huawei.openalliance.ad.utils.ad.Code(str, AdEventReport.class, new Class[0]);
        Code(context, str, new ad() { // from class: com.huawei.hms.ads.bm.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                if (adContentData != null) {
                    AdEventReport adEventReport2 = adEventReport;
                    jk.Code(context, adContentData, 0, 0, adEventReport2 != null ? adEventReport2.k() : null);
                    bm.this.V(remoteCallResultCallback, true);
                }
            }
        });
    }
}
