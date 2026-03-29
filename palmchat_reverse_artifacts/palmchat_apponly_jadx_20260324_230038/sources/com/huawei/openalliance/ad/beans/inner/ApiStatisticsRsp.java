package com.huawei.openalliance.ad.beans.inner;

import com.huawei.openalliance.ad.annotations.DataKeep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
public class ApiStatisticsRsp {
    private int retcode = -1;

    public int Code() {
        return this.retcode;
    }

    public void Code(int i) {
        this.retcode = i;
    }
}
