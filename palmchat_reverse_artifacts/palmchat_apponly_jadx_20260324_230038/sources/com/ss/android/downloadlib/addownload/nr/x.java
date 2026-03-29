package com.ss.android.downloadlib.addownload.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class x {
    private String fx;
    private int nr;
    private int u;

    public x(int i) {
        this(i, 0, null);
    }

    public int getType() {
        return this.u;
    }

    public String nr() {
        return this.fx;
    }

    public int u() {
        return this.nr;
    }

    public x(int i, int i2) {
        this(i, i2, null);
    }

    public x(int i, String str) {
        this(i, 0, str);
    }

    public x(int i, int i2, String str) {
        this.u = i;
        this.nr = i2;
        this.fx = str;
    }
}
