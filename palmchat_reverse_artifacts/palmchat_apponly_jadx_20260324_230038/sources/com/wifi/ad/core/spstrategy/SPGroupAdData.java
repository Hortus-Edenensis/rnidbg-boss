package com.wifi.ad.core.spstrategy;

import com.wifi.ad.core.data.NestAdData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/wifi/ad/core/spstrategy/SPGroupAdData;", "", "()V", "adDatas", "", "Lcom/wifi/ad/core/data/NestAdData;", "getAdDatas", "()Ljava/util/List;", "setAdDatas", "(Ljava/util/List;)V", "groupId", "", "getGroupId", "()I", "setGroupId", "(I)V", "maxEcpm", "getMaxEcpm", "setMaxEcpm", "minEcpm", "getMinEcpm", "setMinEcpm", "timeOut", "getTimeOut", "setTimeOut", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SPGroupAdData {
    private List<NestAdData> adDatas = new ArrayList();
    private int groupId;
    private int maxEcpm;
    private int minEcpm;
    private int timeOut;

    public final List<NestAdData> getAdDatas() {
        return this.adDatas;
    }

    public final int getGroupId() {
        return this.groupId;
    }

    public final int getMaxEcpm() {
        return this.maxEcpm;
    }

    public final int getMinEcpm() {
        return this.minEcpm;
    }

    public final int getTimeOut() {
        return this.timeOut;
    }

    public final void setAdDatas(List<NestAdData> list) {
        this.adDatas = list;
    }

    public final void setGroupId(int i) {
        this.groupId = i;
    }

    public final void setMaxEcpm(int i) {
        this.maxEcpm = i;
    }

    public final void setMinEcpm(int i) {
        this.minEcpm = i;
    }

    public final void setTimeOut(int i) {
        this.timeOut = i;
    }
}
