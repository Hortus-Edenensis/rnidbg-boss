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
public class fx implements x {
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
        String str;
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
        long curBytes = downloadInfoNr.getCurBytes();
        long totalBytes = downloadInfoNr.getTotalBytes();
        if (curBytes < 0 || totalBytes <= 0) {
            return false;
        }
        final int iU = com.ss.android.downloadlib.addownload.jk.u(downloadInfoNr.getId(), (int) ((100 * curBytes) / totalBytes));
        final int i2 = (int) (curBytes / 1048576);
        boolean z = iU > u(nrVar.bg());
        u = new com.ss.android.downloadlib.addownload.u.b() { // from class: com.ss.android.downloadlib.addownload.b.fx.1
            @Override // com.ss.android.downloadlib.addownload.u.b
            public void nr() {
                com.ss.android.downloadlib.addownload.u.b unused = fx.u = null;
                fx.this.u(iU, i2, i2, nrVar, "download_percent_cancel", "cancel");
                nVar.u(nrVar);
            }

            @Override // com.ss.android.downloadlib.addownload.u.b
            public void u() {
                com.ss.android.downloadlib.addownload.u.b unused = fx.u = null;
                fx.this.u(iU, i2, i2, nrVar, "download_percent_cancel", "confirm");
            }
        };
        String strU = mv.u(com.ss.android.downloadlib.addownload.jk.u(nrVar.bg(), curBytes, totalBytes));
        if (z) {
            str = String.format("该任务已下载%s，仅需%s即可下载完成，是否继续？", strU, mv.u(totalBytes - curBytes));
        } else {
            str = String.format("该任务已下载%s，即将下载完成，是否继续下载？", strU);
        }
        String str2 = str;
        if (fxVar != null) {
            u(new com.ss.android.downloadlib.addownload.u.fx() { // from class: com.ss.android.downloadlib.addownload.b.fx.2
                @Override // com.ss.android.downloadlib.addownload.u.fx
                public void delete() {
                    com.ss.android.downloadlib.addownload.u.b unused = fx.u = null;
                    fx.this.u(iU, i2, i2, nrVar, "download_percent_cancel", Launcher.Method.DELETE_CALLBACK);
                    fxVar.delete();
                }
            });
        }
        TTDelegateActivity.nr(nrVar, str2, "继续", "暂停", "删除");
        return true;
    }

    private int u(int i) {
        return com.ss.android.socialbase.downloader.n.u.u(i).u("cancel_pause_optimise_download_percent_value", 50);
    }

    private boolean u(com.ss.android.downloadad.api.u.u uVar) {
        return com.ss.android.downloadlib.x.pn.u(uVar).u("cancel_pause_optimise_download_percent_retain_switch", 0) == 1 && uVar.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, int i2, int i3, com.ss.android.downloadad.api.u.nr nrVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_percent", Integer.valueOf(i));
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i2));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i3));
        } catch (JSONException unused) {
        }
        com.ss.android.downloadlib.b.u.u().u("pause_cancel_optimise", jSONObject, nrVar);
    }
}
