package com.ss.android.downloadlib.addownload;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.sx;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class k {
    private static com.ss.android.downloadlib.addownload.u.fx nr;
    private static com.ss.android.downloadlib.addownload.u.b u;

    public static com.ss.android.downloadlib.addownload.u.fx nr() {
        return nr;
    }

    public static boolean u(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 7 || i == 8;
    }

    public static com.ss.android.downloadlib.addownload.u.b u() {
        return u;
    }

    public static void u(com.ss.android.downloadlib.addownload.u.b bVar) {
        u = bVar;
    }

    public static void u(com.ss.android.downloadlib.addownload.u.fx fxVar) {
        nr = fxVar;
    }

    public static boolean u(final com.ss.android.downloadad.api.u.nr nrVar, DownloadInfo downloadInfo, int i, final com.ss.android.downloadlib.addownload.b.n nVar, final boolean z, final com.ss.android.downloadlib.addownload.u.fx fxVar) {
        boolean zNr;
        if (nrVar == null) {
            com.ss.android.downloadlib.pn.fx.u().u("tryReverseWifi nativeModel null");
            return false;
        }
        if (downloadInfo == null) {
            com.ss.android.downloadlib.pn.fx.u().u("tryReverseWifi info null");
            return false;
        }
        final int id = downloadInfo.getId();
        if (z) {
            zNr = com.ss.android.downloadlib.x.pn.fx((com.ss.android.downloadad.api.u.u) nrVar);
        } else {
            zNr = com.ss.android.downloadlib.x.pn.nr((com.ss.android.downloadad.api.u.u) nrVar);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("switch_status", Integer.valueOf(zNr ? 1 : 0));
        } catch (Exception unused) {
        }
        if (z) {
            com.ss.android.downloadlib.b.u.u().u("cancel_pause_reserve_wifi_switch_status", jSONObject, nrVar);
        } else {
            com.ss.android.downloadlib.b.u.u().u("pause_reserve_wifi_switch_status", jSONObject, nrVar);
        }
        if (!zNr || !u(i) || com.ss.android.socialbase.downloader.jk.iz.nr(l.getContext())) {
            return false;
        }
        if (!z && downloadInfo.hasPauseReservedOnWifi()) {
            return false;
        }
        u(new com.ss.android.downloadlib.addownload.u.b() { // from class: com.ss.android.downloadlib.addownload.k.1
            @Override // com.ss.android.downloadlib.addownload.u.b
            public void nr() {
                k.u((com.ss.android.downloadlib.addownload.u.b) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(l.getContext()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.stopPauseReserveOnWifi();
                }
                if (z) {
                    com.ss.android.downloadlib.b.u.u().u("cancel_pause_reserve_wifi_cancel", nrVar);
                } else {
                    com.ss.android.downloadlib.b.u.u().nr("pause_reserve_wifi_cancel", nrVar);
                }
                nVar.u(nrVar);
            }

            @Override // com.ss.android.downloadlib.addownload.u.b
            public void u() {
                k.u((com.ss.android.downloadlib.addownload.u.b) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(l.getContext()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.startPauseReserveOnWifi();
                    sx.u().u(downloadInfo2);
                    if (z) {
                        com.ss.android.downloadlib.b.u.u().u("cancel_pause_reserve_wifi_confirm", nrVar);
                    } else {
                        com.ss.android.downloadlib.b.u.u().nr("pause_reserve_wifi_confirm", nrVar);
                    }
                }
                nVar.u(nrVar);
            }
        });
        if (z && fxVar != null) {
            u(new com.ss.android.downloadlib.addownload.u.fx() { // from class: com.ss.android.downloadlib.addownload.k.2
                @Override // com.ss.android.downloadlib.addownload.u.fx
                public void delete() {
                    com.ss.android.downloadlib.b.u.u().u("cancel_pause_reserve_wifi_delete", nrVar);
                    fxVar.delete();
                }
            });
        }
        if (z) {
            TTDelegateActivity.u(nrVar, "删除");
        } else {
            TTDelegateActivity.nr(nrVar);
        }
        return true;
    }
}
