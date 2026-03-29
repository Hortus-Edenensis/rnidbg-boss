package com.ss.bytertc.engine.video;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum RemoteVideoRenderPosition {
    AFTER_DECODER(0),
    AFTER_POST_PROCESS(1);

    private int value;

    RemoteVideoRenderPosition(int i) {
        this.value = i;
    }

    public static RemoteVideoRenderPosition convertFromInt(int i) {
        return values()[i];
    }

    public int getValue() {
        return this.value;
    }
}
