package com.ss.android.downloadlib;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.c;
import com.ss.android.download.api.config.mv;
import com.ss.android.download.api.config.sx;
import com.ss.android.download.api.config.t;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.depend.ja;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.u.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class iz implements com.ss.android.download.api.u {
    @Override // com.ss.android.download.api.u
    public com.ss.android.download.api.u u(@NonNull com.ss.android.download.api.config.a aVar) {
        l.u(aVar);
        return this;
    }

    @Override // com.ss.android.download.api.u
    public com.ss.android.download.api.u u(@NonNull com.ss.android.download.api.config.x xVar) {
        l.u(xVar);
        return this;
    }

    @Override // com.ss.android.download.api.u
    public com.ss.android.download.api.u u(@NonNull mv mvVar) {
        l.u(mvVar);
        return this;
    }

    @Override // com.ss.android.download.api.u
    public com.ss.android.download.api.u u(@NonNull com.ss.android.download.api.config.n nVar) {
        l.u(nVar);
        return this;
    }

    @Override // com.ss.android.download.api.u
    public com.ss.android.download.api.u u(@NonNull t tVar) {
        l.u(tVar);
        return this;
    }

    @Override // com.ss.android.download.api.u
    public com.ss.android.download.api.u u(@NonNull com.ss.android.download.api.model.u uVar) {
        l.u(uVar);
        return this;
    }

    @Override // com.ss.android.download.api.u
    public com.ss.android.download.api.u u(String str) {
        l.u(str);
        return this;
    }

    @Override // com.ss.android.download.api.u
    public com.ss.android.download.api.u u(com.ss.android.socialbase.appdownloader.fx.fx fxVar) {
        l.u(fxVar);
        return this;
    }

    @Override // com.ss.android.download.api.u
    public com.ss.android.download.api.u u(@NonNull final com.ss.android.download.api.config.nr nrVar) {
        l.u(nrVar);
        com.ss.android.socialbase.downloader.u.u.u().u(new u.fx() { // from class: com.ss.android.downloadlib.iz.1
        });
        return this;
    }

    @Override // com.ss.android.download.api.u
    public com.ss.android.download.api.u u(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder.getNotificationClickCallback() == null) {
            downloaderBuilder.notificationClickCallback(new ja() { // from class: com.ss.android.downloadlib.iz.2
                private boolean b(DownloadInfo downloadInfo) {
                    c cVarBg = l.bg();
                    if (cVarBg == null) {
                        return false;
                    }
                    com.ss.android.downloadad.api.u.nr nrVarU = com.ss.android.downloadlib.addownload.nr.iz.u().u(downloadInfo);
                    String strU = (nrVarU == null || !nrVarU.fx()) ? com.ss.android.downloadlib.addownload.a.u(downloadInfo) : com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("ad_notification_jump_url", (String) null);
                    if (TextUtils.isEmpty(strU)) {
                        return false;
                    }
                    return cVarBg.u(l.getContext(), strU);
                }

                @Override // com.ss.android.socialbase.downloader.depend.ja
                public boolean fx(DownloadInfo downloadInfo) {
                    if (downloadInfo == null) {
                        return false;
                    }
                    com.ss.android.downloadad.api.u.nr nrVarU = com.ss.android.downloadlib.addownload.nr.iz.u().u(downloadInfo);
                    if (nrVarU != null) {
                        com.ss.android.downloadlib.nr.u.u(nrVarU);
                    } else {
                        com.ss.android.downloadlib.x.a.nr(l.getContext(), downloadInfo.getPackageName());
                    }
                    com.ss.android.socialbase.downloader.notification.nr.u().iz(downloadInfo.getId());
                    return true;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ja
                public boolean nr(DownloadInfo downloadInfo) {
                    return false;
                }

                @Override // com.ss.android.socialbase.downloader.depend.ja
                public boolean u(DownloadInfo downloadInfo) {
                    com.ss.android.socialbase.downloader.n.u uVarU = com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId());
                    if (uVarU.nr("notification_opt_2") != 1) {
                        boolean zB = b(downloadInfo);
                        if (uVarU.u("disable_delete_dialog", 0) == 1) {
                            return true;
                        }
                        return zB;
                    }
                    if (downloadInfo.getStatus() == -2) {
                        DownloadHandlerService.u(l.getContext(), downloadInfo, com.ss.android.socialbase.appdownloader.b.t().fx(), Downloader.getInstance(l.getContext()).getDownloadNotificationEventListener(downloadInfo.getId()));
                    }
                    return true;
                }
            });
        }
        downloaderBuilder.addDownloadCompleteHandler(new com.ss.android.downloadlib.fx.fx());
        Downloader.initOrCover(downloaderBuilder, true);
        return this;
    }

    @Override // com.ss.android.download.api.u
    public com.ss.android.download.api.u u(com.ss.android.socialbase.appdownloader.fx.x xVar) {
        com.ss.android.socialbase.appdownloader.b.t().u(xVar);
        return this;
    }

    @Override // com.ss.android.download.api.u
    public com.ss.android.download.api.u u(sx sxVar) {
        l.u(sxVar);
        return this;
    }

    @Override // com.ss.android.download.api.u
    public com.ss.android.download.api.u u(com.ss.android.download.api.config.jk jkVar) {
        l.u(jkVar);
        return this;
    }

    @Override // com.ss.android.download.api.u
    public void u() {
        if (!l.qq()) {
            com.ss.android.downloadlib.pn.fx.u().u("ttdownloader init error");
        }
        l.u(com.ss.android.downloadlib.pn.fx.u());
        try {
            com.ss.android.socialbase.appdownloader.b.t().nr(l.q());
        } catch (Exception unused) {
        }
        com.ss.android.socialbase.appdownloader.b.t().u(u.u());
        pn.u().nr(new Runnable() { // from class: com.ss.android.downloadlib.iz.3
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.iz.pn.u("");
                if (com.ss.android.socialbase.appdownloader.iz.pn.k()) {
                    com.ss.android.socialbase.downloader.downloader.fx.u(true);
                }
                if (com.ss.android.socialbase.downloader.n.u.fx().u("disable_security_init", 1) == 1) {
                    com.ss.android.socialbase.appdownloader.iz.iz.u(l.getContext());
                }
            }
        });
    }
}
