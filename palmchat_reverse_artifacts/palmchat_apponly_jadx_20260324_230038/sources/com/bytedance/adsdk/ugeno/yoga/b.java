package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public enum b {
    LEFT(0),
    TOP(1),
    RIGHT(2),
    BOTTOM(3),
    START(4),
    END(5),
    HORIZONTAL(6),
    VERTICAL(7),
    ALL(8);

    private final int jk;

    b(int i) {
        this.jk = i;
    }

    public int u() {
        return this.jk;
    }
}
