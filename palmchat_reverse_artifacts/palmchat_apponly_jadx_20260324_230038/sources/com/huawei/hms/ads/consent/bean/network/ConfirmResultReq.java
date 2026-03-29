package com.huawei.hms.ads.consent.bean.network;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.annotations.DataKeep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
public class ConfirmResultReq {
    private List<ApiStatisticsReq> caches = new ArrayList();

    @AllApi
    public List<ApiStatisticsReq> getCaches() {
        return this.caches;
    }

    @AllApi
    public void setCaches(List<ApiStatisticsReq> list) {
        this.caches = list;
    }
}
