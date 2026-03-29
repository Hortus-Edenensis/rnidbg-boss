package com.ss.android.downloadlib.iz;

import com.ss.android.downloadlib.addownload.nr.iz;
import com.ss.android.socialbase.appdownloader.fx.jk;
import com.ss.android.socialbase.appdownloader.fx.t;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr implements t {
    @Override // com.ss.android.socialbase.appdownloader.fx.t
    public void u(DownloadInfo downloadInfo, jk jkVar) {
        com.ss.android.downloadad.api.u.nr nrVarU;
        if (downloadInfo != null && (nrVarU = iz.u().u(downloadInfo)) != null) {
            downloadInfo.setLinkMode(nrVarU.oa());
        }
        if (jkVar != null) {
            jkVar.u();
        }
    }
}
