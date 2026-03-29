package com.ss.bytertc.engine.video;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum VideoRenderMirrorType {
    ON(1),
    OFF(2);

    private int value;

    VideoRenderMirrorType(int i) {
        this.value = i;
    }

    public static VideoRenderMirrorType convertFromInt(int i) {
        if (i == 1) {
            return ON;
        }
        if (i == 2) {
            return OFF;
        }
        throw new IllegalArgumentException("VideoRenderMirrorType enum value invalidate: " + i);
    }

    public int getValue() {
        return this.value;
    }
}
