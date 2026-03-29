package com.huawei.hms.ads;

import com.huawei.openalliance.ad.beans.metadata.Om;
import com.iab.omid.library.huawei.adsession.VerificationScriptResource;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class hq implements hn {
    private static final String Code = "VerficationScriptResourceWrapper";
    private static boolean V = hc.Code(hc.q);
    private List<VerificationScriptResource> I = new ArrayList();

    private URL Code(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            fh.I(Code, "parseURL: " + com.huawei.openalliance.ad.utils.bl.Code(e.getMessage()));
            return null;
        }
    }

    public List<VerificationScriptResource> V() {
        return this.I;
    }

    public void Code(Om om) {
        if (om == null || !V) {
            fh.V(Code, "om is not avalible");
            return;
        }
        String strCode = om.Code();
        URL urlCode = Code(om.V());
        String strI = om.I();
        if (strCode == null || urlCode == null || strI == null) {
            fh.V(Code, "Parameters is null");
            return;
        }
        VerificationScriptResource verificationScriptResourceCreateVerificationScriptResourceWithParameters = VerificationScriptResource.createVerificationScriptResourceWithParameters(strCode, urlCode, strI);
        if (verificationScriptResourceCreateVerificationScriptResourceWithParameters == null) {
            fh.V(Code, "Create verificationScriptResource failed");
        } else {
            this.I.add(verificationScriptResourceCreateVerificationScriptResourceWithParameters);
        }
    }

    public static boolean Code() {
        return V;
    }
}
