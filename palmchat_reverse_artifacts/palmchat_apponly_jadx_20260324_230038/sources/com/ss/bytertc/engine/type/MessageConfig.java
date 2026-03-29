package com.ss.bytertc.engine.type;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum MessageConfig {
    RELIABLE_ORDERED(0),
    UNRELIABLE_ORDERED(1),
    UNRELIABLE_UNORDERED(2);

    int value;

    MessageConfig(int i) {
        this.value = i;
    }

    public static MessageConfig fromId(int i) {
        for (MessageConfig messageConfig : values()) {
            if (messageConfig.value() == i) {
                return messageConfig;
            }
        }
        return RELIABLE_ORDERED;
    }

    public int value() {
        return this.value;
    }
}
