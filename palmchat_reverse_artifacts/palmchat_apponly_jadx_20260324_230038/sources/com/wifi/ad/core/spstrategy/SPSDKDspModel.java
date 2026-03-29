package com.wifi.ad.core.spstrategy;

import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/wifi/ad/core/spstrategy/SPSDKDspModel;", "", "()V", "dspName", "", "getDspName", "()Ljava/lang/String;", "setDspName", "(Ljava/lang/String;)V", "weight", "", "getWeight", "()I", "setWeight", "(I)V", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SPSDKDspModel {
    private String dspName;
    private int weight;

    public final String getDspName() {
        return this.dspName;
    }

    public final int getWeight() {
        return this.weight;
    }

    public final void setDspName(String str) {
        this.dspName = str;
    }

    public final void setWeight(int i) {
        this.weight = i;
    }
}
