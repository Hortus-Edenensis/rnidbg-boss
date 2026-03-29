package com.ss.bytertc.engine.video;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum LocalVideoRenderPosition {
    AFTER_CAPTURE(0),
    AFTER_PREPROCESS(1);

    private int value;

    LocalVideoRenderPosition(int i) {
        this.value = i;
    }

    public static LocalVideoRenderPosition convertFromInt(int i) {
        return values()[i];
    }

    public int getValue() {
        return this.value;
    }
}
