package com.wifi.ad.core.spstrategy;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/wifi/ad/core/spstrategy/SPMaterialModel;", "", "()V", "frequency_pv", "", "getFrequency_pv", "()I", "setFrequency_pv", "(I)V", "frequency_time", "getFrequency_time", "setFrequency_time", "url_prefix", "", "", "getUrl_prefix", "()Ljava/util/List;", "setUrl_prefix", "(Ljava/util/List;)V", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SPMaterialModel {
    private int frequency_pv;
    private int frequency_time;
    private List<String> url_prefix;

    public final int getFrequency_pv() {
        return this.frequency_pv;
    }

    public final int getFrequency_time() {
        return this.frequency_time;
    }

    public final List<String> getUrl_prefix() {
        return this.url_prefix;
    }

    public final void setFrequency_pv(int i) {
        this.frequency_pv = i;
    }

    public final void setFrequency_time(int i) {
        this.frequency_time = i;
    }

    public final void setUrl_prefix(List<String> list) {
        this.url_prefix = list;
    }
}
