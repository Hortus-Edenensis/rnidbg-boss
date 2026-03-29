package com.ss.android.socialbase.downloader.impls;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr implements com.ss.android.socialbase.downloader.downloader.x {
    @Override // com.ss.android.socialbase.downloader.downloader.x
    public int u(int i, com.ss.android.socialbase.downloader.network.l lVar) {
        if (lVar.ordinal() <= com.ss.android.socialbase.downloader.network.l.MODERATE.ordinal()) {
            return 1;
        }
        return lVar == com.ss.android.socialbase.downloader.network.l.GOOD ? i - 1 : i;
    }
}
