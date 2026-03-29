package com.baidu.mapapi.map.bmsdk.ui;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public enum Located {
    CENTER(1),
    TOP(2),
    BOTTOM(4),
    LEFT(8),
    RIGHT(16),
    LEFT_TOP(10),
    LEFT_BOTTOM(12),
    RIGHT_TOP(18),
    RIGHT_BOTTOM(20);

    private int b;

    Located(int i) {
        this.b = i;
    }

    public int getNumber() {
        return this.b;
    }
}
