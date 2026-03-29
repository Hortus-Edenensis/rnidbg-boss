package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.AdSessionConfiguration;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class hg implements hn {
    private static boolean Code = hc.Code(hc.g);
    private static final String V = "AdSessionConfiguration";
    private AdSessionConfiguration I;

    private hg(hj hjVar, ho hoVar, hp hpVar, hp hpVar2, boolean z) {
        this.I = null;
        if (hj.Code() && ho.Code() && hp.Code()) {
            this.I = AdSessionConfiguration.createAdSessionConfiguration(hj.Code(hjVar), ho.Code(hoVar), hp.Code(hpVar), hp.Code(hpVar2), z);
        }
    }

    public static hg Code(hj hjVar, ho hoVar, hp hpVar, hp hpVar2, boolean z) {
        if (Code) {
            return new hg(hjVar, hoVar, hpVar, hpVar2, z);
        }
        return null;
    }

    public AdSessionConfiguration V() {
        return this.I;
    }

    public static boolean Code() {
        return Code;
    }
}
