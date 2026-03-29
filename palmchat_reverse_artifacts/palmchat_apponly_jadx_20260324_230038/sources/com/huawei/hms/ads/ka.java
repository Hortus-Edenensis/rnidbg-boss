package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ka extends kr {
    private static final String Code = "AgentAction";

    public ka(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    private boolean B() {
        AdContentData adContentData = this.Z;
        if (adContentData == null || adContentData.S() == null) {
            return false;
        }
        long jP = this.Z.S().p();
        String strQ = this.Z.S().q();
        fh.Code(Code, "agent id is %s, click url is %s", Long.valueOf(jP), strQ);
        return com.huawei.openalliance.ad.utils.g.Code(this.I, strQ, jP);
    }

    @Override // com.huawei.hms.ads.kr
    public boolean Code() {
        fh.V(Code, "in decouple handle agent action");
        if (!B()) {
            return I();
        }
        Code(com.huawei.openalliance.ad.constant.v.g);
        return true;
    }
}
