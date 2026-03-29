package com.ss.bytertc.engine.type;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum LocalProxyState {
    INITED(0),
    CONNECTED(1),
    ERROR(2);

    private int value;

    LocalProxyState(int i) {
        this.value = i;
    }

    @CalledByNative
    public static LocalProxyState fromId(int i) {
        for (LocalProxyState localProxyState : values()) {
            if (localProxyState.value() == i) {
                return localProxyState;
            }
        }
        return null;
    }

    public int value() {
        return this.value;
    }
}
