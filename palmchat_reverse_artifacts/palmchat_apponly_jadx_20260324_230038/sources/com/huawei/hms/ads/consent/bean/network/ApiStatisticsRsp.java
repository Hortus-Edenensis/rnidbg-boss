package com.huawei.hms.ads.consent.bean.network;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.annotations.DataKeep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
public class ApiStatisticsRsp {
    private int retcode = -1;

    @AllApi
    public int getRetcode() {
        return this.retcode;
    }

    @AllApi
    public void setRetcode(int i) {
        this.retcode = i;
    }
}
