package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.d;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class dp implements dq {
    private static long V;

    private Map<String, String> Code(AdContentData adContentData) {
        HashMap map = new HashMap();
        if (adContentData != null && adContentData.S() != null) {
            MetaData metaDataS = adContentData.S();
            String strB = metaDataS.b();
            String strA = metaDataS.a();
            if (strB != null && strA != null) {
                map.put("appId", strB);
                map.put(kk.V, strA);
            }
        }
        return map;
    }

    private void Code(final Context context, final d dVar) {
        long jCode = com.huawei.openalliance.ad.utils.z.Code();
        fh.V("DownloadChecker", "trigger action list lastTime:%s curTime:%s", Long.valueOf(V), Long.valueOf(jCode));
        if (jCode - V < 500) {
            fh.V("DownloadChecker", "trigger action list too frequently");
        } else {
            V = jCode;
            com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.dp.1
                @Override // java.lang.Runnable
                public void run() {
                    dp.this.Code(dVar, context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(d dVar, Context context) {
        if (dVar == null || context == null) {
            return;
        }
        if (dVar instanceof com.huawei.openalliance.ad.inter.data.l) {
            fh.V("DownloadChecker", "native trigger action list result:%s", Boolean.valueOf(((com.huawei.openalliance.ad.inter.data.l) dVar).B(context, null)));
        } else if (!(dVar instanceof com.huawei.openalliance.ad.inter.data.c)) {
            fh.V("DownloadChecker", "not baseAd no need trigger action list");
        } else {
            AdContentData adContentDataQ = dVar.q();
            fh.V("DownloadChecker", "trigger action list result:%s", Boolean.valueOf(ks.Code(context, adContentDataQ, Code(adContentDataQ)).Code()));
        }
    }

    @Override // com.huawei.hms.ads.dq
    public boolean Code(Context context, d dVar, boolean z) {
        if (context == null || dVar == null) {
            return false;
        }
        if (dVar instanceof com.huawei.openalliance.ad.inter.data.s) {
            return true;
        }
        int iJ = dVar.J();
        fh.Code("DownloadChecker", "api control flag:%s", Integer.valueOf(iJ));
        if (iJ == 0) {
            return true;
        }
        if (iJ != 1) {
            if (iJ != 2) {
                fh.I("DownloadChecker", "invalid apiDownloadFlag value!");
            }
            return false;
        }
        if (z) {
            Code(context, dVar);
        }
        return false;
    }
}
