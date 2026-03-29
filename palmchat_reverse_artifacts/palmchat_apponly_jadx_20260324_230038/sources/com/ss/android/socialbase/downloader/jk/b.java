package com.ss.android.socialbase.downloader.jk;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {
    public static boolean nr(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).nr("optimize_save_path") == 1;
    }

    public static boolean u(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).nr("optimize_head_request") == 1;
    }
}
