package com.ss.android.socialbase.downloader.impls;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class l {
    private static volatile com.ss.android.socialbase.downloader.downloader.mv nr;
    private static volatile com.ss.android.socialbase.downloader.downloader.mv u;

    public static com.ss.android.socialbase.downloader.downloader.mv u(boolean z) {
        if (z && com.ss.android.socialbase.downloader.downloader.fx.su()) {
            if (nr == null) {
                synchronized (l.class) {
                    if (nr == null) {
                        nr = com.ss.android.socialbase.downloader.downloader.fx.mh().nr();
                    }
                }
            }
            return nr;
        }
        if (u == null) {
            synchronized (l.class) {
                if (u == null) {
                    u = new my();
                }
            }
        }
        return u;
    }
}
