package com.wifi.ad.core.data;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u0017H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/wifi/ad/core/data/NestMixAdLevel;", "", "()V", "adSortStrategy", "", "Lcom/wifi/ad/core/data/NestAdData;", "getAdSortStrategy", "()Ljava/util/List;", "setAdSortStrategy", "(Ljava/util/List;)V", "adStrategy", "getAdStrategy", "setAdStrategy", "ecpm", "", "getEcpm", "()I", "setEcpm", "(I)V", "level", "getLevel", "setLevel", "levelNames", "", "getLevelNames", "setLevelNames", "ratios", "getRatios", "setRatios", "toString", "core_release"}, k = 1, mv = {1, 1, 16})
public final class NestMixAdLevel {
    private int ecpm;
    private int level;
    private List<NestAdData> adStrategy = new ArrayList();
    private List<NestAdData> adSortStrategy = new ArrayList();
    private List<Integer> ratios = new ArrayList();
    private List<String> levelNames = new ArrayList();

    public final List<NestAdData> getAdSortStrategy() {
        return this.adSortStrategy;
    }

    public final List<NestAdData> getAdStrategy() {
        return this.adStrategy;
    }

    public final int getEcpm() {
        return this.ecpm;
    }

    public final int getLevel() {
        return this.level;
    }

    public final List<String> getLevelNames() {
        return this.levelNames;
    }

    public final List<Integer> getRatios() {
        return this.ratios;
    }

    public final void setAdSortStrategy(List<NestAdData> list) {
        this.adSortStrategy = list;
    }

    public final void setAdStrategy(List<NestAdData> list) {
        this.adStrategy = list;
    }

    public final void setEcpm(int i) {
        this.ecpm = i;
    }

    public final void setLevel(int i) {
        this.level = i;
    }

    public final void setLevelNames(List<String> list) {
        this.levelNames = list;
    }

    public final void setRatios(List<Integer> list) {
        this.ratios = list;
    }

    public String toString() {
        return "NestMixAdLevel(adStrategy=" + this.adStrategy + ", adSortStrategy=" + this.adSortStrategy + ", ratios=" + this.ratios + ", levelNames=" + this.levelNames + ", level=" + this.level + ", ecpm=" + this.ecpm + ')';
    }
}
