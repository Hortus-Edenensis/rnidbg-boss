package com.huawei.hms.ads;

import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class gw {
    public static gx Code(AdContentData adContentData) {
        if (adContentData == null) {
            return new gv();
        }
        if (adContentData.t() != null || (adContentData.u() != null && "video/mp4".equals(adContentData.u().Code()))) {
            if (ha.C()) {
                return new ha();
            }
        } else if (gs.Code()) {
            return new gs();
        }
        return new gv();
    }
}
