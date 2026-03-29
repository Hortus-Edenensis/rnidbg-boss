package com.ss.android.socialbase.appdownloader.iz;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr {
    private static void nr(final DownloadInfo downloadInfo) {
        final Context contextOa = com.ss.android.socialbase.downloader.downloader.fx.oa();
        boolean z = true;
        if (((downloadInfo.isAutoResumed() && !downloadInfo.isShowNotificationForNetworkResumed()) || com.ss.android.socialbase.appdownloader.fx.nr(downloadInfo.getExtra()) || TextUtils.isEmpty(downloadInfo.getMimeType()) || !downloadInfo.getMimeType().equals(AdBaseConstants.MIME_APK)) && com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("auto_install_when_resume", 0) != 1) {
            z = false;
        }
        final int iU = z ? com.ss.android.socialbase.appdownloader.fx.u(contextOa, downloadInfo.getId(), false) : 2;
        com.ss.android.socialbase.downloader.downloader.fx.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.iz.nr.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.fx.pn pnVarFx = com.ss.android.socialbase.appdownloader.b.t().fx();
                z downloadNotificationEventListener = Downloader.getInstance(contextOa).getDownloadNotificationEventListener(downloadInfo.getId());
                if (pnVarFx == null && downloadNotificationEventListener == null) {
                    return;
                }
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.exists()) {
                    try {
                        PackageInfo packageInfoU = com.ss.android.socialbase.appdownloader.fx.u(downloadInfo, file);
                        if (packageInfoU != null) {
                            String packageName = (iU == 1 || TextUtils.isEmpty(downloadInfo.getPackageName())) ? packageInfoU.packageName : downloadInfo.getPackageName();
                            if (pnVarFx != null) {
                                pnVarFx.u(downloadInfo.getId(), 1, packageName, -3, downloadInfo.getDownloadTime());
                            }
                            if (downloadNotificationEventListener != null) {
                                downloadNotificationEventListener.u(1, downloadInfo, packageName, "");
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        });
    }

    public static void u(DownloadInfo downloadInfo) {
        nr(downloadInfo);
    }
}
