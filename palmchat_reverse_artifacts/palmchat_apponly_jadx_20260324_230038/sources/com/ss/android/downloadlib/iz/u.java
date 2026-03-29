package com.ss.android.downloadlib.iz;

import androidx.annotation.NonNull;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.nr.iz;
import com.ss.android.downloadlib.nr.a;
import com.ss.android.socialbase.appdownloader.fx.jk;
import com.ss.android.socialbase.appdownloader.fx.t;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u implements t {
    /* JADX INFO: Access modifiers changed from: private */
    public void nr(DownloadInfo downloadInfo, @NonNull final com.ss.android.downloadlib.guide.install.u uVar) {
        com.ss.android.downloadad.api.u.nr nrVarU = iz.u().u(downloadInfo);
        boolean zU = com.ss.android.downloadlib.nr.iz.u(nrVarU);
        boolean zNr = com.ss.android.downloadlib.nr.iz.nr(nrVarU);
        if (zU && zNr) {
            com.ss.android.downloadlib.nr.fx.u(nrVarU, new com.ss.android.downloadlib.guide.install.u() { // from class: com.ss.android.downloadlib.iz.u.3
                @Override // com.ss.android.downloadlib.guide.install.u
                public void u() {
                    uVar.u();
                }
            });
        } else {
            uVar.u();
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.fx.t
    public void u(DownloadInfo downloadInfo, final jk jkVar) {
        u(downloadInfo, new com.ss.android.downloadlib.guide.install.u() { // from class: com.ss.android.downloadlib.iz.u.1
            @Override // com.ss.android.downloadlib.guide.install.u
            public void u() {
                jkVar.u();
            }
        });
    }

    public void u(final DownloadInfo downloadInfo, @NonNull final com.ss.android.downloadlib.guide.install.u uVar) {
        com.ss.android.downloadad.api.u.nr nrVarU = iz.u().u(downloadInfo);
        if (nrVarU != null && a.u(nrVarU)) {
            TTDelegateActivity.u(nrVarU, new com.ss.android.downloadlib.guide.install.u() { // from class: com.ss.android.downloadlib.iz.u.2
                @Override // com.ss.android.downloadlib.guide.install.u
                public void u() {
                    u.this.nr(downloadInfo, uVar);
                }
            });
        } else {
            nr(downloadInfo, uVar);
        }
    }
}
