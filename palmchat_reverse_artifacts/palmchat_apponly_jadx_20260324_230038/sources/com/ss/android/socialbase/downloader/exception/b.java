package com.ss.android.socialbase.downloader.exception;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b extends BaseException {
    private final long nr;
    private final long u;

    public b(long j, long j2) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j2), String.valueOf(j)));
        this.u = j;
        this.nr = j2;
    }

    public long nr() {
        return this.nr;
    }

    public long u() {
        return this.u;
    }
}
