package com.huawei.hms.ads;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class dg extends df {
    private eh Code;

    public dg(Context context) {
        this.Code = eh.Code(context);
    }

    @Override // com.huawei.hms.ads.df
    public boolean Code() {
        if (this.Code.j() >= com.huawei.openalliance.ad.utils.z.Code()) {
            return true;
        }
        return V();
    }
}
