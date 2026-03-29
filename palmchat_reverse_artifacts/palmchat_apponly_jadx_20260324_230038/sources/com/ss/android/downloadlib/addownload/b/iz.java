package com.ss.android.downloadlib.addownload.b;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class iz implements a {
    private static com.ss.android.downloadlib.addownload.u.b u;

    public static com.ss.android.downloadlib.addownload.u.b u() {
        return u;
    }

    @Override // com.ss.android.downloadlib.addownload.b.a
    public boolean u(final com.ss.android.downloadad.api.u.nr nrVar, int i, final n nVar) {
        DownloadInfo downloadInfoNr;
        if (nrVar == null || nrVar.p() || !u(nrVar)) {
            return false;
        }
        if (!TextUtils.isEmpty(nrVar.f())) {
            downloadInfoNr = com.ss.android.downloadlib.jk.u(com.ss.android.downloadlib.addownload.l.getContext()).u(nrVar.f(), null, true);
        } else {
            downloadInfoNr = com.ss.android.downloadlib.jk.u(com.ss.android.downloadlib.addownload.l.getContext()).nr(nrVar.u());
        }
        if (downloadInfoNr == null) {
            return false;
        }
        long curBytes = downloadInfoNr.getCurBytes();
        long totalBytes = downloadInfoNr.getTotalBytes();
        if (curBytes > 0 && totalBytes > 0) {
            int iU = com.ss.android.downloadlib.addownload.jk.u(downloadInfoNr.getId(), (int) ((curBytes * 100) / totalBytes));
            if (iU > u(nrVar.bg())) {
                u = new com.ss.android.downloadlib.addownload.u.b() { // from class: com.ss.android.downloadlib.addownload.b.iz.1
                    @Override // com.ss.android.downloadlib.addownload.u.b
                    public void nr() {
                        com.ss.android.downloadlib.addownload.u.b unused = iz.u = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "cancel");
                        } catch (JSONException unused2) {
                        }
                        com.ss.android.downloadlib.b.u.u().u("pause_optimise", jSONObject, nrVar);
                        nVar.u(nrVar);
                    }

                    @Override // com.ss.android.downloadlib.addownload.u.b
                    public void u() {
                        com.ss.android.downloadlib.addownload.u.b unused = iz.u = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "confirm");
                        } catch (JSONException unused2) {
                        }
                        com.ss.android.downloadlib.b.u.u().u("pause_optimise", jSONObject, nrVar);
                    }
                };
                TTDelegateActivity.nr(nrVar, String.format("已下载%s%%，即将下载完成，是否继续下载？", Integer.valueOf(iU)), "继续", "暂停");
                nrVar.k(true);
                return true;
            }
        }
        return false;
    }

    private int u(int i) {
        return com.ss.android.socialbase.downloader.n.u.u(i).u("pause_optimise_download_percent", 50);
    }

    private boolean u(com.ss.android.downloadad.api.u.u uVar) {
        return com.ss.android.downloadlib.x.pn.u(uVar).u("pause_optimise_download_percent_switch", 0) == 1 && uVar.o();
    }
}
