package com.huawei.hms.ads;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class cs extends cp {
    private static cy I;
    private static final byte[] Z = new byte[0];
    private com.huawei.openalliance.ad.utils.n B;

    private cs(Context context) {
        super(context);
        this.B = new com.huawei.openalliance.ad.utils.n(context);
    }

    private static cy I(Context context) {
        cy cyVar;
        synchronized (Z) {
            if (I == null) {
                I = new cs(context);
            }
            cyVar = I;
        }
        return cyVar;
    }

    public static cy V(Context context) {
        return I(context);
    }

    @Override // com.huawei.hms.ads.cp, com.huawei.hms.ads.cy
    public boolean Code() {
        return "CN".equalsIgnoreCase(this.B.Code());
    }

    @Override // com.huawei.hms.ads.cp, com.huawei.hms.ads.cy
    public boolean I() {
        return false;
    }

    @Override // com.huawei.hms.ads.cp, com.huawei.hms.ads.cy
    public boolean V() {
        return Code();
    }
}
