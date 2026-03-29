package com.ss.android.downloadlib.addownload.fx;

import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.addownload.nr.a;
import com.ss.android.downloadlib.addownload.nr.iz;
import com.ss.android.downloadlib.x.mv;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr implements Runnable {
    private DownloadInfo u;

    public nr(DownloadInfo downloadInfo) {
        this.u = downloadInfo;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        final com.ss.android.downloadad.api.u.nr nrVarU;
        if (this.u == null || (nrVarU = iz.u().u(this.u)) == null) {
            return;
        }
        com.ss.android.downloadlib.b.u.u().u("cleanspace_task", nrVarU);
        long jLongValue = Double.valueOf((com.ss.android.downloadlib.x.pn.u(this.u.getId()) + 1.0d) * this.u.getTotalBytes()).longValue() - this.u.getCurBytes();
        long jNr = mv.nr(0L);
        if (l.mv() != null) {
            l.mv();
        }
        fx.u();
        fx.nr();
        if (com.ss.android.downloadlib.x.pn.x(nrVarU.bg())) {
            fx.u(l.getContext());
        }
        long jNr2 = mv.nr(0L);
        if (jNr2 >= jLongValue) {
            nrVarU.l("1");
            a.u().u(nrVarU);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(jNr2 - jNr));
            } catch (JSONException unused) {
            }
            com.ss.android.downloadlib.b.u.u().u("cleanspace_download_after_quite_clean", jSONObject, nrVarU);
            Downloader.getInstance(l.getContext()).restart(this.u.getId());
            return;
        }
        if (l.mv() == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("show_dialog_result", 3);
            } catch (JSONException unused2) {
            }
            com.ss.android.downloadlib.b.u.u().u("cleanspace_window_show", jSONObject2, nrVarU);
        } else {
            nrVarU.b(false);
            b.u().u(nrVarU.u(), new pn() { // from class: com.ss.android.downloadlib.addownload.fx.nr.1
            });
            if (l.mv().u(this.u.getId(), this.u.getUrl(), true, jLongValue)) {
                nrVarU.pn(true);
            }
        }
    }
}
