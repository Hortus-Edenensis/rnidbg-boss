package com.ss.bytertc.engine.type;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum SubscribeMode {
    AUTO_SUBSCRIBE_MODE(0),
    MANUAL_SUBSCRIBE_MODE(1);

    private int value;

    SubscribeMode(int i) {
        this.value = i;
    }

    public int value() {
        return this.value;
    }
}
