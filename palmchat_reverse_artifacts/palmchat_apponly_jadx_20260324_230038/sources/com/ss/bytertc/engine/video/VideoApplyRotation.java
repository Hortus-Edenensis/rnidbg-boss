package com.ss.bytertc.engine.video;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum VideoApplyRotation {
    DEFAULT(-1),
    DEGREE_0(0);

    private int value;

    VideoApplyRotation(int i) {
        this.value = i;
    }

    public static VideoApplyRotation convertFromInt(int i) {
        if (i == -1) {
            return DEFAULT;
        }
        if (i == 0) {
            return DEGREE_0;
        }
        throw new IllegalArgumentException("VideoApplyRotation enum value invalidate: " + i);
    }

    public int getValue() {
        return this.value;
    }
}
