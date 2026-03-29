package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public enum n {
    UNDEFINED(0),
    EXACTLY(1),
    AT_MOST(2);

    private final int b;

    n(int i) {
        this.b = i;
    }

    public static n u(int i) {
        if (i == 0) {
            return UNDEFINED;
        }
        if (i == 1) {
            return EXACTLY;
        }
        if (i == 2) {
            return AT_MOST;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
    }
}
