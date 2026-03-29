package com.ss.android.downloadlib.addownload.b;

import android.text.TextUtils;
import com.cdo.oaps.ad.Launcher;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.x.mv;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr implements x {
    private static com.ss.android.downloadlib.addownload.u.fx nr;
    private static com.ss.android.downloadlib.addownload.u.b u;

    public static com.ss.android.downloadlib.addownload.u.fx nr() {
        return nr;
    }

    public static com.ss.android.downloadlib.addownload.u.b u() {
        return u;
    }

    public static void u(com.ss.android.downloadlib.addownload.u.fx fxVar) {
        nr = fxVar;
    }

    @Override // com.ss.android.downloadlib.addownload.b.x
    public boolean u(final com.ss.android.downloadad.api.u.nr nrVar, int i, final n nVar, final com.ss.android.downloadlib.addownload.u.fx fxVar) {
        DownloadInfo downloadInfoNr;
        if (nrVar == null || !u(nrVar)) {
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
        long jU = com.ss.android.downloadlib.addownload.jk.u(downloadInfoNr.getId(), downloadInfoNr.getCurBytes(), downloadInfoNr.getTotalBytes());
        long totalBytes = downloadInfoNr.getTotalBytes();
        if (jU >= 0 && totalBytes > 0) {
            if (totalBytes <= u(nrVar.bg())) {
                final int i2 = (int) (jU / 1048576);
                u = new com.ss.android.downloadlib.addownload.u.b() { // from class: com.ss.android.downloadlib.addownload.b.nr.1
                    @Override // com.ss.android.downloadlib.addownload.u.b
                    public void nr() {
                        com.ss.android.downloadlib.addownload.u.b unused = nr.u = null;
                        nr.this.u(i2, i2, nrVar, "apk_size_cancel", "cancel");
                        nVar.u(nrVar);
                    }

                    @Override // com.ss.android.downloadlib.addownload.u.b
                    public void u() {
                        com.ss.android.downloadlib.addownload.u.b unused = nr.u = null;
                        nr.this.u(i2, i2, nrVar, "apk_size_cancel", "confirm");
                    }
                };
                String str = String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", mv.u(totalBytes - jU));
                if (fxVar != null) {
                    u(new com.ss.android.downloadlib.addownload.u.fx() { // from class: com.ss.android.downloadlib.addownload.b.nr.2
                        @Override // com.ss.android.downloadlib.addownload.u.fx
                        public void delete() {
                            com.ss.android.downloadlib.addownload.u.b unused = nr.u = null;
                            nr.this.u(i2, i2, nrVar, "apk_size_cancel", Launcher.Method.DELETE_CALLBACK);
                            fxVar.delete();
                        }
                    });
                }
                TTDelegateActivity.u(nrVar, str, "继续", "暂停", "删除");
                return true;
            }
        }
        return false;
    }

    private int u(int i) {
        return com.ss.android.socialbase.downloader.n.u.u(i).u("cancel_pause_optimise_apk_size", 100) * 1024 * 1024;
    }

    private boolean u(com.ss.android.downloadad.api.u.u uVar) {
        return com.ss.android.downloadlib.x.pn.u(uVar).u("cancel_pause_optimise_apk_retain_switch", 0) == 1 && uVar.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, int i2, com.ss.android.downloadad.api.u.nr nrVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i2));
        } catch (JSONException unused) {
        }
        com.ss.android.downloadlib.b.u.u().u("pause_cancel_optimise", jSONObject, nrVar);
    }
}
