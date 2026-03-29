package com.ss.android.downloadlib.fx;

import android.content.pm.PackageInfo;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.socialbase.downloader.depend.mv;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr implements mv {
    @Override // com.ss.android.socialbase.downloader.depend.mv
    public boolean nr(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.downloadlib.x.pn.nr() && downloadInfo.getPackageInfo() == null;
    }

    @Override // com.ss.android.socialbase.downloader.depend.mv
    public void u(DownloadInfo downloadInfo) throws BaseException {
        PackageInfo packageInfoU = com.ss.android.socialbase.appdownloader.fx.u(l.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        if (packageInfoU != null) {
            downloadInfo.setAppVersionCode(packageInfoU.versionCode);
        }
    }
}
