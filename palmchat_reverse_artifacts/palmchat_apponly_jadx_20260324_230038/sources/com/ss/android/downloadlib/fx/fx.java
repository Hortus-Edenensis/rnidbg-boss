package com.ss.android.downloadlib.fx;

import com.ss.android.download.api.config.s;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.socialbase.downloader.depend.mv;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class fx implements mv {
    @Override // com.ss.android.socialbase.downloader.depend.mv
    public boolean nr(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.ss.android.download.api.fx.nr.u(com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()), downloadInfo.getMimeType());
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.depend.mv
    public void u(DownloadInfo downloadInfo) throws BaseException {
        s sVarT = l.t();
        if (downloadInfo == null || sVarT == null) {
            return;
        }
        File fileU = u(downloadInfo.getPackageName(), downloadInfo.getTargetFilePath());
        com.ss.android.downloadad.api.u.nr nrVarU = com.ss.android.downloadlib.addownload.nr.iz.u().u(downloadInfo);
        if (nrVarU != null) {
            com.ss.android.downloadlib.x.mv.u(nrVarU.x());
        }
        downloadInfo.setMimeType(AdBaseConstants.MIME_APK);
        downloadInfo.setName(fileU.getName());
        downloadInfo.setMd5(null);
    }

    private File u(String str, String str2) {
        File file = new File(str2);
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf > 0) {
            str = name.substring(0, iLastIndexOf);
        }
        return new File(file.getParent(), str + com.huawei.hms.ads.dynamicloader.b.b);
    }
}
