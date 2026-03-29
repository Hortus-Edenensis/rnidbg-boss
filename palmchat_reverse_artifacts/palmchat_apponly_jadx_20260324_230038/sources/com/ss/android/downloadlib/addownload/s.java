package com.ss.android.downloadlib.addownload;

import com.ss.android.socialbase.downloader.downloader.sx;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class s implements sx {
    @Override // com.ss.android.socialbase.downloader.downloader.sx
    public void u(DownloadInfo downloadInfo, int i, int i2) {
        com.ss.android.downloadad.api.u.nr nrVarU = com.ss.android.downloadlib.addownload.nr.iz.u().u(downloadInfo);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("reserve_wifi_source", Integer.valueOf(i2));
            jSONObject.putOpt("reserve_wifi_status", Integer.valueOf(i));
        } catch (JSONException unused) {
        }
        com.ss.android.downloadlib.b.u.u().u("pause_reserve_wifi", jSONObject, nrVarU);
    }
}
