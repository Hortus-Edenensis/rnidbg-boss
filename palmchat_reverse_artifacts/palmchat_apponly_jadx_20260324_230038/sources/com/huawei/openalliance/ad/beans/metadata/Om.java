package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
public class Om implements Serializable {
    private static final long serialVersionUID = 6514947323166042687L;

    @com.huawei.openalliance.ad.annotations.a
    private String resourceUrl;
    private String vendorKey;

    @com.huawei.openalliance.ad.annotations.a
    private String verificationParameters;

    public String Code() {
        return this.vendorKey;
    }

    public String I() {
        return this.verificationParameters;
    }

    public String V() {
        return this.resourceUrl;
    }

    public String toString() {
        return "Om{vendorKey='" + this.vendorKey + "', resourceUrl='" + this.resourceUrl + "', verificationParameters='" + this.verificationParameters + "'}";
    }
}
