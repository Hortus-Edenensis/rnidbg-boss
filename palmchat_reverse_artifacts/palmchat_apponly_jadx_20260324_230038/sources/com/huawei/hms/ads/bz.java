package com.huawei.hms.ads;

import com.huawei.hms.ads.nativead.DislikeAdReason;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class bz implements DislikeAdReason {
    private String Code;

    public bz(String str) {
        this.Code = str;
    }

    @Override // com.huawei.hms.ads.nativead.DislikeAdReason
    public String getDescription() {
        return this.Code;
    }
}
