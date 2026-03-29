package com.getui.gtc.dim;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public enum AllowSysCall {
    NOT_ALLOW(0),
    ONLY_ALLOW_FORE_CALL(1),
    ALL_ALLOW(2);

    private final int value;

    AllowSysCall(int i) {
        this.value = i;
    }

    public static AllowSysCall valueOf(int i) {
        return i != 0 ? i != 1 ? ALL_ALLOW : ONLY_ALLOW_FORE_CALL : NOT_ALLOW;
    }

    public final int getValue() {
        return this.value;
    }
}
