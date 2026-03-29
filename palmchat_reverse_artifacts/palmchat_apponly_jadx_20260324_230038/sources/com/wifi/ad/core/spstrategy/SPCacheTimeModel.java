package com.wifi.ad.core.spstrategy;

import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/wifi/ad/core/spstrategy/SPCacheTimeModel;", "", "()V", "allNum", "", "getAllNum", "()I", "setAllNum", "(I)V", "failedNum", "getFailedNum", "setFailedNum", "maxEcpm", "getMaxEcpm", "setMaxEcpm", "successNum", "getSuccessNum", "setSuccessNum", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SPCacheTimeModel {
    private int allNum;
    private int failedNum;
    private int maxEcpm;
    private int successNum;

    public final int getAllNum() {
        return this.allNum;
    }

    public final int getFailedNum() {
        return this.failedNum;
    }

    public final int getMaxEcpm() {
        return this.maxEcpm;
    }

    public final int getSuccessNum() {
        return this.successNum;
    }

    public final void setAllNum(int i) {
        this.allNum = i;
    }

    public final void setFailedNum(int i) {
        this.failedNum = i;
    }

    public final void setMaxEcpm(int i) {
        this.maxEcpm = i;
    }

    public final void setSuccessNum(int i) {
        this.successNum = i;
    }
}
