package com.ss.android.downloadlib.fx;

import androidx.annotation.WorkerThread;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.addownload.nr.a;
import com.ss.android.downloadlib.x.mv;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b implements com.ss.android.socialbase.appdownloader.fx.n, t {
    @Override // com.ss.android.socialbase.appdownloader.fx.n
    public void u(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        u(downloadInfo, downloadInfo.getRealStatus(), z);
    }

    @WorkerThread
    public void u(DownloadInfo downloadInfo, int i, boolean z) {
        com.ss.android.downloadlib.addownload.nr.iz.u().nr();
        com.ss.android.downloadad.api.u.nr nrVarU = com.ss.android.downloadlib.addownload.nr.iz.u().u(downloadInfo);
        if (nrVarU == null) {
            return;
        }
        try {
            if (z) {
                nrVarU.fx(downloadInfo.getFailedResumeCount());
            } else if (nrVarU.rh() == -1) {
                return;
            } else {
                nrVarU.fx(-1);
            }
            a.u().u(nrVarU);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_id", downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
            jSONObject.put("url", downloadInfo.getUrl());
            jSONObject.put("download_time", downloadInfo.getDownloadTime());
            jSONObject.put("download_status", i);
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            int i2 = 1;
            jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
            jSONObject.put("chunk_count", downloadInfo.getChunkCount());
            if (!z) {
                i2 = 2;
            }
            jSONObject.put("launch_resumed", i2);
            jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
            com.ss.android.downloadlib.b.u.u().u("embeded_ad", "download_uncompleted", jSONObject, nrVarU);
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.t
    public void u() {
        com.ss.android.downloadlib.pn.u().u(new Runnable() { // from class: com.ss.android.downloadlib.fx.b.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo;
                int spIntVal;
                com.ss.android.downloadlib.addownload.nr.iz.u().nr();
                for (com.ss.android.downloadad.api.u.nr nrVar : com.ss.android.downloadlib.addownload.nr.iz.u().fx().values()) {
                    int iBg = nrVar.bg();
                    if (iBg != 0) {
                        com.ss.android.socialbase.downloader.n.u uVarU = com.ss.android.socialbase.downloader.n.u.u(iBg);
                        if (uVarU.nr("notification_opt_2") == 1 && (downloadInfo = Downloader.getInstance(l.getContext()).getDownloadInfo(iBg)) != null) {
                            if (mv.nr(nrVar) && !mv.fx(nrVar.pn())) {
                                int spIntVal2 = downloadInfo.getSpIntVal("restart_notify_open_app_count");
                                if (spIntVal2 < uVarU.u("noti_open_restart_times", 1)) {
                                    n.u().pn(nrVar);
                                    downloadInfo.setSpValue("restart_notify_open_app_count", String.valueOf(spIntVal2 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -2) {
                                int spIntVal3 = downloadInfo.getSpIntVal("restart_notify_continue_count");
                                if (spIntVal3 < uVarU.u("noti_continue_restart_times", 1)) {
                                    n.u().u(nrVar);
                                    downloadInfo.setSpValue("restart_notify_continue_count", String.valueOf(spIntVal3 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -3 && com.ss.android.socialbase.downloader.jk.iz.fx(downloadInfo) && !mv.nr(nrVar) && (spIntVal = downloadInfo.getSpIntVal("restart_notify_install_count")) < uVarU.u("noti_install_restart_times", 1)) {
                                n.u().fx(nrVar);
                                downloadInfo.setSpValue("restart_notify_install_count", String.valueOf(spIntVal + 1));
                            }
                        }
                    }
                }
            }
        }, 5000L);
    }
}
