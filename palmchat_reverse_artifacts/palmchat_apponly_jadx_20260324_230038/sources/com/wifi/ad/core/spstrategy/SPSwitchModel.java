package com.wifi.ad.core.spstrategy;

import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\b¨\u0006$"}, d2 = {"Lcom/wifi/ad/core/spstrategy/SPSwitchModel;", "", "()V", "adHighPrioritySwitch", "", "getAdHighPrioritySwitch", "()I", "setAdHighPrioritySwitch", "(I)V", "adMaxPriceSwitch", "getAdMaxPriceSwitch", "setAdMaxPriceSwitch", "adStrategyOptimizeSwitch", "getAdStrategyOptimizeSwitch", "setAdStrategyOptimizeSwitch", "blackSwitch", "getBlackSwitch", "setBlackSwitch", "interactSettings", "", "getInteractSettings", "()Ljava/lang/String;", "setInteractSettings", "(Ljava/lang/String;)V", "primeRitSwitch", "getPrimeRitSwitch", "setPrimeRitSwitch", "shakeSwitch", "getShakeSwitch", "setShakeSwitch", "shakeSwitchLxad", "getShakeSwitchLxad", "setShakeSwitchLxad", "whiteSwitch", "getWhiteSwitch", "setWhiteSwitch", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SPSwitchModel {
    private int adHighPrioritySwitch;
    private int adMaxPriceSwitch;
    private int adStrategyOptimizeSwitch;
    private int blackSwitch;
    private String interactSettings;
    private int primeRitSwitch;
    private int shakeSwitch;
    private int shakeSwitchLxad;
    private int whiteSwitch;

    public final int getAdHighPrioritySwitch() {
        return this.adHighPrioritySwitch;
    }

    public final int getAdMaxPriceSwitch() {
        return this.adMaxPriceSwitch;
    }

    public final int getAdStrategyOptimizeSwitch() {
        return this.adStrategyOptimizeSwitch;
    }

    public final int getBlackSwitch() {
        return this.blackSwitch;
    }

    public final String getInteractSettings() {
        return this.interactSettings;
    }

    public final int getPrimeRitSwitch() {
        return this.primeRitSwitch;
    }

    public final int getShakeSwitch() {
        return this.shakeSwitch;
    }

    public final int getShakeSwitchLxad() {
        return this.shakeSwitchLxad;
    }

    public final int getWhiteSwitch() {
        return this.whiteSwitch;
    }

    public final void setAdHighPrioritySwitch(int i) {
        this.adHighPrioritySwitch = i;
    }

    public final void setAdMaxPriceSwitch(int i) {
        this.adMaxPriceSwitch = i;
    }

    public final void setAdStrategyOptimizeSwitch(int i) {
        this.adStrategyOptimizeSwitch = i;
    }

    public final void setBlackSwitch(int i) {
        this.blackSwitch = i;
    }

    public final void setInteractSettings(String str) {
        this.interactSettings = str;
    }

    public final void setPrimeRitSwitch(int i) {
        this.primeRitSwitch = i;
    }

    public final void setShakeSwitch(int i) {
        this.shakeSwitch = i;
    }

    public final void setShakeSwitchLxad(int i) {
        this.shakeSwitchLxad = i;
    }

    public final void setWhiteSwitch(int i) {
        this.whiteSwitch = i;
    }
}
