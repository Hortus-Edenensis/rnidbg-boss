package com.ss.android.downloadlib.fx;

import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.x.mv;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class pn implements com.ss.android.socialbase.downloader.b.fx {
    @Override // com.ss.android.socialbase.downloader.b.fx
    public void nr(int i, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.u.nr nrVarU;
        DownloadInfo downloadInfo = Downloader.getInstance(l.getContext()).getDownloadInfo(i);
        if (downloadInfo == null || (nrVarU = com.ss.android.downloadlib.addownload.nr.iz.u().u(downloadInfo)) == null) {
            return;
        }
        com.ss.android.downloadlib.b.u.u().u(str, jSONObject, nrVarU);
    }

    @Override // com.ss.android.socialbase.downloader.b.fx
    public void u(int i, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.u.nr nrVarU;
        DownloadInfo downloadInfo = Downloader.getInstance(l.getContext()).getDownloadInfo(i);
        if (downloadInfo == null || (nrVarU = com.ss.android.downloadlib.addownload.nr.iz.u().u(downloadInfo)) == null) {
            return;
        }
        if ("install_view_result".equals(str)) {
            jSONObject = mv.u(jSONObject);
            com.ss.android.downloadlib.u.u(jSONObject, downloadInfo);
            mv.u(jSONObject, "model_id", Long.valueOf(nrVarU.nr()));
        }
        com.ss.android.downloadlib.b.u.u().nr(str, jSONObject, nrVarU);
    }
}
