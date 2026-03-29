package com.ss.android.socialbase.downloader.depend;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class nr implements c {
    private boolean u = false;

    @Override // com.ss.android.socialbase.downloader.depend.c
    public void u(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.u = true;
    }

    @Override // com.ss.android.socialbase.downloader.depend.c
    public boolean u() {
        return this.u;
    }
}
