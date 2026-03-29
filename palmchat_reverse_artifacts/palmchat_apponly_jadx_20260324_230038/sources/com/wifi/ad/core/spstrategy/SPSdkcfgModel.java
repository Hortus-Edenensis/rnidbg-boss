package com.wifi.ad.core.spstrategy;

import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/wifi/ad/core/spstrategy/SPSdkcfgModel;", "", "()V", "caschSes", "", "getCaschSes", "()I", "setCaschSes", "(I)V", "dspId", "getDspId", "setDspId", "dspName", "", "getDspName", "()Ljava/lang/String;", "setDspName", "(Ljava/lang/String;)V", "timeOut", "getTimeOut", "setTimeOut", "type", "getType", "setType", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SPSdkcfgModel {
    private int caschSes;
    private int dspId;
    private String dspName;
    private int timeOut;
    private int type;

    public final int getCaschSes() {
        return this.caschSes;
    }

    public final int getDspId() {
        return this.dspId;
    }

    public final String getDspName() {
        return this.dspName;
    }

    public final int getTimeOut() {
        return this.timeOut;
    }

    public final int getType() {
        return this.type;
    }

    public final void setCaschSes(int i) {
        this.caschSes = i;
    }

    public final void setDspId(int i) {
        this.dspId = i;
    }

    public final void setDspName(String str) {
        this.dspName = str;
    }

    public final void setTimeOut(int i) {
        this.timeOut = i;
    }

    public final void setType(int i) {
        this.type = i;
    }
}
