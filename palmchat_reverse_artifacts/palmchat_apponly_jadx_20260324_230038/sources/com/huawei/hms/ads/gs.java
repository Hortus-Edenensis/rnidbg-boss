package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.AdEvents;
import com.iab.omid.library.huawei.adsession.AdSession;
import com.iab.omid.library.huawei.adsession.media.VastProperties;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class gs extends gt implements gx {
    private static final String Code = "DisplayEventAgent";
    private static boolean V = hc.Code(hc.e);
    private final List<AdEvents> I = new ArrayList();

    @Override // com.huawei.hms.ads.gx
    public void Code(hm hmVar) {
        if (hmVar instanceof gq) {
            List<AdSession> listV = ((gq) hmVar).V();
            if (listV.isEmpty()) {
                return;
            }
            for (AdSession adSession : listV) {
                if (adSession != null) {
                    this.I.add(AdEvents.createAdEvents(adSession));
                }
            }
        }
    }

    @Override // com.huawei.hms.ads.gt, com.huawei.hms.ads.hr
    public void D() {
        if (this.I.isEmpty()) {
            fh.I(Code, "impressionOccurred, mAdEventList isEmpty");
            return;
        }
        try {
            Iterator<AdEvents> it = this.I.iterator();
            while (it.hasNext()) {
                it.next().impressionOccurred();
            }
        } catch (IllegalStateException unused) {
            fh.V(Code, "impressionOccurred, fail");
        }
    }

    @Override // com.huawei.hms.ads.gt, com.huawei.hms.ads.hr
    public void L() {
        fh.V(Code, "load");
        if (this.I.isEmpty()) {
            fh.V(Code, "load, AdEventList isEmpty");
            return;
        }
        try {
            Iterator<AdEvents> it = this.I.iterator();
            while (it.hasNext()) {
                it.next().loaded();
            }
        } catch (IllegalStateException unused) {
            fh.V(Code, "loaded, fail");
        }
    }

    @Override // com.huawei.hms.ads.gx
    public void V() {
        this.I.clear();
    }

    @Override // com.huawei.hms.ads.gt, com.huawei.hms.ads.hr
    public void Code(hv hvVar) {
        VastProperties vastPropertiesC;
        fh.V(Code, "load vastPropertiesWrapper");
        if (hvVar == null || !hv.Code() || (vastPropertiesC = hvVar.C()) == null) {
            return;
        }
        Code(vastPropertiesC);
    }

    @Override // com.huawei.hms.ads.gt
    public void Code(VastProperties vastProperties) {
        if (this.I.isEmpty()) {
            return;
        }
        try {
            Iterator<AdEvents> it = this.I.iterator();
            while (it.hasNext()) {
                it.next().loaded(vastProperties);
            }
        } catch (IllegalStateException unused) {
            fh.V(Code, "loaded, fail");
        }
    }

    public static boolean Code() {
        return V;
    }
}
