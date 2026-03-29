package com.wifi.ad.core.config.adx.model;

import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/wifi/ad/core/config/adx/model/WkAdMutliPrice;", "", "()V", WkAdMutliPrice.TAG_CPMLEVEL, "", "getCpmlevel", "()Ljava/lang/String;", "setCpmlevel", "(Ljava/lang/String;)V", "ecpm", "", "getEcpm", "()I", "setEcpm", "(I)V", "ratio", "getRatio", "setRatio", "Companion", "core_release"}, k = 1, mv = {1, 1, 16})
public final class WkAdMutliPrice {
    public static final String TAG_CPMLEVEL = "cpmlevel";
    public static final String TAG_ECPM = "ecpm";
    public static final String TAG_RATIO = "ratio";
    private String cpmlevel;
    private int ecpm;
    private int ratio;

    public final String getCpmlevel() {
        return this.cpmlevel;
    }

    public final int getEcpm() {
        return this.ecpm;
    }

    public final int getRatio() {
        return this.ratio;
    }

    public final void setCpmlevel(String str) {
        this.cpmlevel = str;
    }

    public final void setEcpm(int i) {
        this.ecpm = i;
    }

    public final void setRatio(int i) {
        this.ratio = i;
    }
}
