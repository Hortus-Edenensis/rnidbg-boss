package com.huawei.hms.ads;

import android.content.Context;
import com.iab.omid.library.huawei.adsession.AdSessionContext;
import com.iab.omid.library.huawei.adsession.Partner;
import com.iab.omid.library.huawei.adsession.VerificationScriptResource;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class hh implements hn {
    private static final String Code = "AdSessionContextWrapper";
    private static boolean I = hc.Code(hc.i);
    private static final String V = "Huawei";
    private Context Z;

    public hh(Context context) {
        this.Z = context;
    }

    public AdSessionContext Code(hq hqVar, String str) {
        String strCode;
        if (!hc.Code(hc.p) || !hc.Code(hc.q) || !hc.Code(hc.i)) {
            fh.I(Code, "createNativeAdSessionContext, not available ");
            return null;
        }
        List<VerificationScriptResource> listV = hqVar.V();
        if (listV.isEmpty()) {
            return null;
        }
        try {
            strCode = com.huawei.openalliance.ad.utils.bc.Code("openmeasure/omsdk-v1.js", this.Z);
        } catch (IOException e) {
            fh.I(Code, "getNativeAdSession: " + com.huawei.openalliance.ad.utils.bl.Code(e.getMessage()));
            strCode = null;
        }
        if (strCode == null) {
            return null;
        }
        return AdSessionContext.createNativeAdSessionContext(Partner.createPartner(V, "13.4.80.301"), strCode, listV, str, (String) null);
    }

    public static boolean Code() {
        return I;
    }
}
