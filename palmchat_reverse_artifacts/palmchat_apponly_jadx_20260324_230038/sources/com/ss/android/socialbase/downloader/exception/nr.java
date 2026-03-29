package com.ss.android.socialbase.downloader.exception;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr extends BaseException {
    private final int u;

    public nr(int i, int i2, String str) {
        super(i, str);
        this.u = i2;
    }

    public int u() {
        return this.u;
    }
}
