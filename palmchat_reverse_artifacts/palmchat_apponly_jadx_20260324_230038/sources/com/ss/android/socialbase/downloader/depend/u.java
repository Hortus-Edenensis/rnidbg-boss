package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class u extends AbsDownloadListener implements bg {
    private static final String u = "u";

    public void u(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.fx.u.u() || downloadInfo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.fx.u.nr(u, " onWaitingDownloadCompleteHandler -- " + downloadInfo.getName());
    }
}
