package com.ss.android.downloadlib.fx;

import androidx.annotation.NonNull;
import com.baidu.mapapi.SDKInitializer;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.x.mv;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class n {

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private static n u = new n();
    }

    public void b(@NonNull com.ss.android.downloadad.api.u.nr nrVar) {
        fx(nrVar, com.ss.android.socialbase.downloader.n.u.u(nrVar.bg()).u("noti_install_delay_secs", 5));
    }

    public void fx(@NonNull com.ss.android.downloadad.api.u.nr nrVar) {
        fx(nrVar, 5L);
    }

    public void iz(@NonNull com.ss.android.downloadad.api.u.nr nrVar) {
        u(nrVar, com.ss.android.socialbase.downloader.n.u.u(nrVar.bg()).u("noti_open_delay_secs", 5));
    }

    public void nr(com.ss.android.downloadad.api.u.nr nrVar) {
        if (nrVar == null) {
            return;
        }
        nr(nrVar, com.ss.android.socialbase.downloader.n.u.u(nrVar.bg()).u("noti_continue_delay_secs", 5));
    }

    public void pn(@NonNull com.ss.android.downloadad.api.u.nr nrVar) {
        u(nrVar, 5L);
    }

    private n() {
    }

    private void fx(@NonNull final com.ss.android.downloadad.api.u.nr nrVar, long j) {
        final int iBg = nrVar.bg();
        if (com.ss.android.socialbase.downloader.n.u.u(iBg).nr("notification_opt_2") != 1) {
            return;
        }
        u(iBg);
        com.ss.android.downloadlib.pn.u().u(new Runnable() { // from class: com.ss.android.downloadlib.fx.n.2
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(l.getContext()).getDownloadInfo(iBg);
                JSONObject jSONObject = new JSONObject();
                mv.u(jSONObject, "ttdownloader_type", (Object) 2);
                com.ss.android.downloadlib.x.iz.fx(downloadInfo, jSONObject);
                if (mv.nr(nrVar)) {
                    mv.u(jSONObject, SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, (Object) 1002);
                } else {
                    n.this.u(iBg, nrVar, jSONObject);
                }
                com.ss.android.downloadlib.b.u.u().nr("download_notification_try_show", jSONObject, nrVar);
            }
        }, j * 1000);
    }

    private void nr(@NonNull final com.ss.android.downloadad.api.u.nr nrVar, long j) {
        final int iBg = nrVar.bg();
        if (com.ss.android.socialbase.downloader.n.u.u(iBg).nr("notification_opt_2") != 1) {
            return;
        }
        u(iBg);
        com.ss.android.downloadlib.pn.u().u(new Runnable() { // from class: com.ss.android.downloadlib.fx.n.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(l.getContext()).getDownloadInfo(iBg);
                JSONObject jSONObject = new JSONObject();
                mv.u(jSONObject, "ttdownloader_type", (Object) 1);
                com.ss.android.downloadlib.x.iz.fx(downloadInfo, jSONObject);
                if (downloadInfo == null || -2 != downloadInfo.getRealStatus() || downloadInfo.isPauseReserveOnWifi()) {
                    mv.u(jSONObject, SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, (Object) 1001);
                } else {
                    n.this.u(iBg, nrVar, jSONObject);
                }
                com.ss.android.downloadlib.b.u.u().nr("download_notification_try_show", jSONObject, nrVar);
            }
        }, j * 1000);
    }

    public static n u() {
        return u.u;
    }

    public void u(com.ss.android.downloadad.api.u.nr nrVar) {
        nr(nrVar, 5L);
    }

    public void u(@NonNull final com.ss.android.downloadad.api.u.nr nrVar, long j) {
        final int iBg = nrVar.bg();
        if (com.ss.android.socialbase.downloader.n.u.u(iBg).nr("notification_opt_2") != 1) {
            return;
        }
        u(iBg);
        com.ss.android.downloadlib.pn.u().u(new Runnable() { // from class: com.ss.android.downloadlib.fx.n.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(l.getContext()).getDownloadInfo(iBg);
                JSONObject jSONObject = new JSONObject();
                mv.u(jSONObject, "ttdownloader_type", (Object) 3);
                com.ss.android.downloadlib.x.iz.fx(downloadInfo, jSONObject);
                if (mv.fx(nrVar.pn())) {
                    mv.u(jSONObject, SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, (Object) 1003);
                } else {
                    n.this.u(iBg, nrVar, jSONObject);
                }
                com.ss.android.downloadlib.b.u.u().nr("download_notification_try_show", jSONObject, nrVar);
            }
        }, j * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, com.ss.android.downloadad.api.u.nr nrVar, JSONObject jSONObject) {
        if (!com.ss.android.socialbase.appdownloader.pn.b.u()) {
            mv.u(jSONObject, SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, (Object) 1004);
            return;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(l.getContext()).getDownloadInfo(i);
        if (downloadInfo == null) {
            mv.u(jSONObject, SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, (Object) 1005);
            return;
        }
        if (com.ss.android.socialbase.downloader.notification.nr.u().pn(i) != null) {
            com.ss.android.socialbase.downloader.notification.nr.u().iz(i);
        }
        com.ss.android.socialbase.appdownloader.pn.u uVar = new com.ss.android.socialbase.appdownloader.pn.u(l.getContext(), i, downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
        uVar.u(downloadInfo.getCurBytes());
        uVar.nr(downloadInfo.getTotalBytes());
        uVar.u(downloadInfo.getStatus(), null, false, false);
        com.ss.android.socialbase.downloader.notification.nr.u().u(uVar);
        uVar.u((BaseException) null, false);
        com.ss.android.downloadlib.b.u.u().nr("download_notification_show", jSONObject, nrVar);
    }

    public void u(int i) {
        DownloadInfo downloadInfo;
        if (com.ss.android.socialbase.appdownloader.pn.fx.u().u(i) != null || (downloadInfo = Downloader.getInstance(l.getContext()).getDownloadInfo(i)) == null) {
            return;
        }
        com.ss.android.socialbase.appdownloader.pn.fx.u().u(i, downloadInfo.getIconUrl());
    }
}
