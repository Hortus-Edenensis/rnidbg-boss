package com.huawei.openalliance.ad.beans.parameter;

import com.huawei.openalliance.ad.annotations.DataKeep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
public class DecoupleStylePackageInfo {
    private String sha256;
    private int size;
    private String version;

    public String Code() {
        return this.version;
    }

    public int I() {
        return this.size;
    }

    public String V() {
        return this.sha256;
    }

    public void Code(int i) {
        this.size = i;
    }

    public void V(String str) {
        this.sha256 = str;
    }

    public void Code(String str) {
        this.version = str;
    }
}
