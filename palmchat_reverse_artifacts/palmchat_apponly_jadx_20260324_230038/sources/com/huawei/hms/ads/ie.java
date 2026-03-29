package com.huawei.hms.ads;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ie extends ip {
    public ie(eh ehVar, mg mgVar) {
        super(ehVar, mgVar);
    }

    @Override // com.huawei.hms.ads.ip
    public void V() {
        long jLongValue = ((Long) com.huawei.openalliance.ad.utils.be.Code(new Callable<Long>() { // from class: com.huawei.hms.ads.ie.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
            public Long call() {
                return Long.valueOf(ie.this.Code.c());
            }
        }, 300L)).longValue();
        int iIntValue = ((Integer) com.huawei.openalliance.ad.utils.be.Code(new Callable<Integer>() { // from class: com.huawei.hms.ads.ie.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
            public Integer call() {
                return Integer.valueOf(ie.this.Code.b());
            }
        }, 2000)).intValue();
        V(jLongValue);
        Code(iIntValue);
    }
}
