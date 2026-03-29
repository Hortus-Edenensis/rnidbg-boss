package com.huawei.openalliance.ad.beans.inner;

import com.huawei.openalliance.ad.annotations.DataKeep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
public class BaseAdReqParam {
    private long adLoadStartTime;
    private String cachedDslEngineVersion;
    private String cachedStylePkgVersion;

    public long Code() {
        return this.adLoadStartTime;
    }

    public String I() {
        return this.cachedDslEngineVersion;
    }

    public String V() {
        return this.cachedStylePkgVersion;
    }

    public void Code(long j) {
        this.adLoadStartTime = j;
    }

    public void V(String str) {
        this.cachedDslEngineVersion = str;
    }

    public void Code(String str) {
        this.cachedStylePkgVersion = str;
    }
}
