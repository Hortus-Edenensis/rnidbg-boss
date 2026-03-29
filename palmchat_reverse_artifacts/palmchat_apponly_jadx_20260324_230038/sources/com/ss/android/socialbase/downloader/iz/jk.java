package com.ss.android.socialbase.downloader.iz;

import com.lantern.auth.app.FunDC;
import com.ss.android.socialbase.downloader.exception.BaseException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class jk extends BaseException {
    private int u;

    public jk(int i, String str) {
        super(FunDC.ID_AUTH_1072, "applyCode=" + i + ", " + str);
        this.u = i;
    }
}
