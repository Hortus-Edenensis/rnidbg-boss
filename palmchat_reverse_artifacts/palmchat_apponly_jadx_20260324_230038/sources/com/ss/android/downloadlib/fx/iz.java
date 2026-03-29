package com.ss.android.downloadlib.fx;

import android.content.Context;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class iz implements com.ss.android.socialbase.appdownloader.fx.pn {
    private Context u;

    public iz(Context context) {
        this.u = context.getApplicationContext();
    }

    @Override // com.ss.android.socialbase.appdownloader.fx.pn
    public void u(Context context, String str) {
        com.ss.android.downloadlib.u.u().u(str);
    }

    @Override // com.ss.android.socialbase.appdownloader.fx.pn
    public void u(int i, int i2, String str, int i3, long j) {
        DownloadInfo downloadInfo;
        com.ss.android.downloadad.api.u.nr nrVarU;
        Context context = this.u;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i)) == null || downloadInfo.getStatus() == 0 || (nrVarU = com.ss.android.downloadlib.addownload.nr.iz.u().u(downloadInfo)) == null) {
            return;
        }
        if (i2 == 1) {
            com.ss.android.downloadlib.u.u(downloadInfo, nrVarU);
            if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
                com.ss.android.downloadlib.addownload.u.u().u(downloadInfo, nrVarU.nr(), nrVarU.l(), nrVarU.pn(), downloadInfo.getTitle(), nrVarU.b(), downloadInfo.getTargetFilePath());
                return;
            }
            return;
        }
        if (i2 == 3) {
            com.ss.android.downloadlib.b.u.u().u("download_notification", "download_notification_install", com.ss.android.downloadlib.u.nr(new JSONObject(), downloadInfo), nrVarU);
            return;
        }
        if (i2 == 5) {
            com.ss.android.downloadlib.b.u.u().u("download_notification", "download_notification_pause", nrVarU);
        } else if (i2 == 6) {
            com.ss.android.downloadlib.b.u.u().u("download_notification", "download_notification_continue", nrVarU);
        } else {
            if (i2 != 7) {
                return;
            }
            com.ss.android.downloadlib.b.u.u().u("download_notification", "download_notification_click", nrVarU);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.fx.pn
    public boolean u(int i, boolean z) {
        if (l.k() != null) {
            return l.k().u(z);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.fx.pn
    public void u(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadlib.n.u().u(downloadInfo);
        if (com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("report_download_cancel", 1) == 1) {
            com.ss.android.downloadlib.b.u.u().u(downloadInfo, new BaseException(1012, ""));
        } else {
            com.ss.android.downloadlib.b.u.u().nr(downloadInfo, new BaseException(1012, ""));
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.fx.pn
    public void u(int i, int i2, String str, String str2, String str3) {
        DownloadInfo downloadInfo;
        Context context = this.u;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i)) == null || downloadInfo.getStatus() != -3) {
            return;
        }
        downloadInfo.setPackageName(str2);
        com.ss.android.downloadlib.addownload.nr.u().u(this.u, downloadInfo);
    }

    @Override // com.ss.android.socialbase.appdownloader.fx.pn
    public boolean u() {
        return com.ss.android.downloadlib.addownload.nr.u().nr();
    }
}
