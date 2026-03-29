package com.ss.android.socialbase.downloader.exception;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class x extends BaseException {
    public x(int i, String str) {
        super(i, str);
    }

    public x u(String str) {
        setExtraInfo(str);
        return this;
    }

    public String u() {
        return getExtraInfo();
    }
}
