package com.ss.bytertc.engine.data;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum AggregationOption {
    MIN(0),
    MAX(1),
    MAJORITY(2);

    private int value;

    AggregationOption(int i) {
        this.value = i;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == MIN ? "AggregationOptionMin" : this == MAX ? "AggregationOptionMax" : this == MAJORITY ? "AggregationOptionMajority" : "AggregationOptionMin";
    }

    public int value() {
        return this.value;
    }
}
