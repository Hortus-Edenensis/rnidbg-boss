package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.model.DownloadShortInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class jk {
    public static int u(int i, int i2) {
        return (i2 <= 0 || i2 >= 100 || !u(i)) ? i2 : (int) (Math.sqrt(i2) * 10.0d);
    }

    public static long u(int i, long j, long j2) {
        if (!u(i)) {
            return j;
        }
        if (j <= 0) {
            return 0L;
        }
        return j2 <= 0 ? j : (j2 * ((long) u(i, (int) ((j * 100) / j2)))) / 100;
    }

    public static DownloadShortInfo u(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo != null && u((int) downloadShortInfo.id)) {
            downloadShortInfo.currentBytes = u((int) downloadShortInfo.id, downloadShortInfo.currentBytes, downloadShortInfo.totalBytes);
        }
        return downloadShortInfo;
    }

    private static boolean u(int i) {
        return com.ss.android.socialbase.downloader.n.u.u(i).u("pause_optimise_pretend_download_percent_switch", 0) == 1 && com.ss.android.socialbase.downloader.n.u.u(i).u("pause_optimise_switch", 0) == 1;
    }
}
