package com.ss.android.downloadlib;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.x.mv;
import com.ss.android.downloadlib.x.t;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.u.u;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class fx implements com.ss.android.socialbase.appdownloader.fx.a {
    private static String u = "fx";
    private Handler nr = new Handler(Looper.getMainLooper());

    @Override // com.ss.android.socialbase.appdownloader.fx.a
    public void u(DownloadInfo downloadInfo, BaseException baseException, int i) {
        BaseException baseException2;
        final DownloadModel downloadModelU;
        if (downloadInfo == null) {
            return;
        }
        if (i == -1 && baseException != null) {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.x.iz.fx(downloadInfo, jSONObject);
            u.u(jSONObject, downloadInfo);
            t.u("download_failed", jSONObject.toString());
        }
        com.ss.android.downloadad.api.u.nr nrVarU = com.ss.android.downloadlib.addownload.nr.iz.u().u(downloadInfo);
        if (nrVarU == null) {
            return;
        }
        try {
            if (i != -1) {
                if (i == -3) {
                    u.u(downloadInfo, nrVarU);
                    return;
                }
                if (i == 2001) {
                    u.u().u(downloadInfo, nrVarU, 2001);
                    return;
                } else {
                    if (i == 11) {
                        u.u().u(downloadInfo, nrVarU, 2000);
                        if (nrVarU.wi()) {
                            return;
                        }
                        u(downloadInfo, nrVarU);
                        return;
                    }
                    return;
                }
            }
            if (baseException != null) {
                if (com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                    this.nr.post(new Runnable() { // from class: com.ss.android.downloadlib.fx.1
                        @Override // java.lang.Runnable
                        public void run() {
                            l.fx().u(5, l.getContext(), null, "无网络，请检查网络设置", null, 0);
                        }
                    });
                }
                if (com.ss.android.socialbase.downloader.jk.iz.n(baseException)) {
                    if (l.mv() != null) {
                        l.mv();
                        nrVarU.nr();
                    }
                    com.ss.android.downloadlib.b.u.u().u("download_failed_for_space", nrVarU);
                    if (!nrVarU.cj()) {
                        com.ss.android.downloadlib.b.u.u().u("download_can_restart", nrVarU);
                        u(downloadInfo);
                    }
                    if ((l.mv() == null || !l.mv().fx()) && (downloadModelU = com.ss.android.downloadlib.addownload.nr.iz.u().u(nrVarU.nr())) != null && downloadModelU.isShowToast()) {
                        final com.ss.android.socialbase.downloader.n.u uVarU = com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId());
                        if (uVarU.u("show_no_enough_space_toast", 0) == 1) {
                            this.nr.post(new Runnable() { // from class: com.ss.android.downloadlib.fx.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.fx().u(2, l.getContext(), downloadModelU, uVarU.u("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
                                }
                            });
                        }
                    }
                }
                baseException2 = new BaseException(baseException.getErrorCode(), mv.u(baseException.getMessage(), l.a().optInt("exception_msg_length", 500)));
            } else {
                baseException2 = null;
            }
            com.ss.android.downloadlib.b.u.u().nr(downloadInfo, baseException2);
            n.u().u(downloadInfo, baseException, "");
        } catch (Exception e) {
            l.bq().u(e, "onAppDownloadMonitorSend");
        }
    }

    private void u(final DownloadInfo downloadInfo, final com.ss.android.downloadad.api.u.nr nrVar) {
        final long jU = mv.u(Environment.getDataDirectory(), -1L);
        long jMin = Math.min(524288000L, mv.u(Environment.getDataDirectory()) / 10);
        final long totalBytes = downloadInfo.getTotalBytes();
        final double d = (totalBytes * 2.5d) + jMin;
        if (jU > -1 && totalBytes > -1) {
            double d2 = jU;
            if (d2 < d && d - d2 > com.ss.android.downloadlib.addownload.b.nr()) {
                com.ss.android.downloadlib.addownload.b.u(downloadInfo.getId());
            }
        }
        com.ss.android.socialbase.downloader.u.u.u().u(new u.InterfaceC0886u() { // from class: com.ss.android.downloadlib.fx.3
            @Override // com.ss.android.socialbase.downloader.u.u.InterfaceC0886u
            public void nr() {
                if (mv.nr(nrVar)) {
                    com.ss.android.socialbase.downloader.u.u.u().nr(this);
                    return;
                }
                long j = jU;
                if (j <= -1 || totalBytes <= -1 || j >= d) {
                    return;
                }
                com.ss.android.downloadlib.b.u.u().u("clean_space_install", com.ss.android.downloadlib.addownload.b.u("install_no_enough_space"), nrVar);
                if (com.ss.android.downloadlib.addownload.b.u(downloadInfo, ((long) d) - jU)) {
                    com.ss.android.socialbase.downloader.u.u.u().nr(this);
                    nrVar.x(true);
                }
            }

            @Override // com.ss.android.socialbase.downloader.u.u.InterfaceC0886u
            public void fx() {
            }
        });
    }

    private void u(@NonNull DownloadInfo downloadInfo) {
        if (com.ss.android.downloadlib.x.pn.iz(downloadInfo.getId())) {
            pn.u().nr(new com.ss.android.downloadlib.addownload.fx.nr(downloadInfo));
        }
    }
}
