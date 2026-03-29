package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class b extends AbsDownloadListener implements bg {
    private void fx(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.canShowNotification() && downloadInfo.getStatus() == 4) {
            com.ss.android.socialbase.downloader.notification.u uVarPn = com.ss.android.socialbase.downloader.notification.nr.u().pn(downloadInfo.getId());
            if (uVarPn == null) {
                uVarPn = u();
            }
            uVarPn.u(downloadInfo.getCurBytes(), downloadInfo.getTotalBytes());
        }
    }

    private void nr(DownloadInfo downloadInfo) {
        if (downloadInfo == null || !downloadInfo.canShowNotification()) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.u uVarPn = com.ss.android.socialbase.downloader.notification.nr.u().pn(downloadInfo.getId());
        if (uVarPn != null) {
            uVarPn.u(downloadInfo);
        } else {
            com.ss.android.socialbase.downloader.notification.nr.u().u(u());
        }
    }

    private void u(int i, DownloadInfo downloadInfo, BaseException baseException, boolean z) {
        if (downloadInfo == null || !downloadInfo.canShowNotification() || i == 4) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.u uVarPn = com.ss.android.socialbase.downloader.notification.nr.u().pn(downloadInfo.getId());
        if (uVarPn == null) {
            uVarPn = u();
        }
        uVarPn.nr(downloadInfo.getTotalBytes());
        if (i == -3) {
            uVarPn.u(downloadInfo.getTotalBytes());
        } else {
            uVarPn.u(downloadInfo.getCurBytes());
        }
        uVarPn.u(i, baseException, z);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        super.onFailed(downloadInfo, baseException);
        u(-1, downloadInfo, baseException, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        super.onPause(downloadInfo);
        u(-2, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        super.onPrepare(downloadInfo);
        nr(downloadInfo);
        u(1, downloadInfo, null, true);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        super.onProgress(downloadInfo);
        fx(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        super.onStart(downloadInfo);
        u(2, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        super.onSuccessed(downloadInfo);
        u(-3, downloadInfo, null, false);
    }

    public abstract com.ss.android.socialbase.downloader.notification.u u();

    @Override // com.ss.android.socialbase.downloader.depend.bg
    public void u(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        u(11, downloadInfo, null, true);
    }
}
