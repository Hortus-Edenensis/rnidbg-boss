package com.wifi.ad.core.spstrategy;

import com.wifi.ad.core.data.NestAdData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/wifi/ad/core/spstrategy/SPCacheModel;", "", "()V", "allAds", "", "Lcom/wifi/ad/core/data/NestAdData;", "getAllAds", "()Ljava/util/List;", "setAllAds", "(Ljava/util/List;)V", "count", "", "getCount", "()I", "setCount", "(I)V", "strategyId", "", "getStrategyId", "()Ljava/lang/String;", "setStrategyId", "(Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SPCacheModel {
    private List<NestAdData> allAds = new ArrayList();
    private int count;
    private String strategyId;

    public final List<NestAdData> getAllAds() {
        return this.allAds;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getStrategyId() {
        return this.strategyId;
    }

    public final void setAllAds(List<NestAdData> list) {
        this.allAds = list;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void setStrategyId(String str) {
        this.strategyId = str;
    }
}
