package com.wifi.ad.core.spstrategy;

import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001c\u0010'\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000e¨\u0006*"}, d2 = {"Lcom/wifi/ad/core/spstrategy/SPSlotcfgModel;", "", "()V", "adCostType", "", "getAdCostType", "()I", "setAdCostType", "(I)V", "dspName", "", "getDspName", "()Ljava/lang/String;", "setDspName", "(Ljava/lang/String;)V", "ecpm", "getEcpm", "setEcpm", "ecpmLowPrice", "getEcpmLowPrice", "setEcpmLowPrice", "ecpmRatio", "", "getEcpmRatio", "()F", "setEcpmRatio", "(F)V", "ecpmTag", "getEcpmTag", "setEcpmTag", "freezetime", "getFreezetime", "setFreezetime", "preRequest", "getPreRequest", "setPreRequest", "priceSwitch", "getPriceSwitch", "setPriceSwitch", "slotid", "getSlotid", "setSlotid", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SPSlotcfgModel {
    private int adCostType;
    private String dspName;
    private int ecpm;
    private int ecpmLowPrice;
    private String ecpmTag;
    private int freezetime;
    private int preRequest;
    private String slotid;
    private float ecpmRatio = 1.0f;
    private int priceSwitch = 1;

    public final int getAdCostType() {
        return this.adCostType;
    }

    public final String getDspName() {
        return this.dspName;
    }

    public final int getEcpm() {
        return this.ecpm;
    }

    public final int getEcpmLowPrice() {
        return this.ecpmLowPrice;
    }

    public final float getEcpmRatio() {
        return this.ecpmRatio;
    }

    public final String getEcpmTag() {
        return this.ecpmTag;
    }

    public final int getFreezetime() {
        return this.freezetime;
    }

    public final int getPreRequest() {
        return this.preRequest;
    }

    public final int getPriceSwitch() {
        return this.priceSwitch;
    }

    public final String getSlotid() {
        return this.slotid;
    }

    public final void setAdCostType(int i) {
        this.adCostType = i;
    }

    public final void setDspName(String str) {
        this.dspName = str;
    }

    public final void setEcpm(int i) {
        this.ecpm = i;
    }

    public final void setEcpmLowPrice(int i) {
        this.ecpmLowPrice = i;
    }

    public final void setEcpmRatio(float f) {
        this.ecpmRatio = f;
    }

    public final void setEcpmTag(String str) {
        this.ecpmTag = str;
    }

    public final void setFreezetime(int i) {
        this.freezetime = i;
    }

    public final void setPreRequest(int i) {
        this.preRequest = i;
    }

    public final void setPriceSwitch(int i) {
        this.priceSwitch = i;
    }

    public final void setSlotid(String str) {
        this.slotid = str;
    }
}
