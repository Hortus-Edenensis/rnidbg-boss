package com.ss.android.downloadlib.b;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.fx;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.addownload.nr.a;
import com.ss.android.downloadlib.addownload.nr.iz;
import com.ss.android.downloadlib.addownload.nr.pn;
import com.ss.android.downloadlib.x.mv;
import com.ss.android.socialbase.appdownloader.pn.b;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u {

    /* JADX INFO: renamed from: com.ss.android.downloadlib.b.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0844u {
        private static u u = new u();
    }

    public static u u() {
        return C0844u.u;
    }

    public void nr(long j, int i) {
        u(j, i, (DownloadInfo) null);
    }

    private u() {
    }

    public void nr(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadad.api.u.nr nrVarU = iz.u().u(downloadInfo);
        if (nrVarU == null) {
            com.ss.android.downloadlib.pn.fx.u().u("sendDownloadFailedEvent nativeModel null");
            return;
        }
        if (nrVarU.fx.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.x.iz.fx(downloadInfo, jSONObject);
            com.ss.android.downloadlib.u.u(jSONObject, downloadInfo);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                nrVarU.b(baseException.getErrorCode());
                nrVarU.u(baseException.getErrorMessage());
            }
            nrVarU.kj();
            jSONObject.put("download_failed_times", nrVarU.qq());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            int i = 1;
            jSONObject.put("has_send_download_failed_finally", nrVarU.b.get() ? 1 : 2);
            com.ss.android.downloadlib.x.iz.u(nrVarU, jSONObject);
            if (!nrVarU.yd()) {
                i = 2;
            }
            jSONObject.put("is_update_download", i);
        } catch (JSONException unused) {
        }
        u(nrVarU.jk(), "download_failed", jSONObject, nrVarU);
        a.u().u(nrVarU);
    }

    public void u(long j, int i) {
        pn pnVarPn = iz.u().pn(j);
        if (pnVarPn.qq()) {
            com.ss.android.downloadlib.pn.fx.u().u("sendClickEvent ModelBox notValid");
            return;
        }
        if (pnVarPn.fx.isEnableClickEvent()) {
            int i2 = 1;
            DownloadEventConfig downloadEventConfig = pnVarPn.fx;
            String clickItemTag = i == 1 ? downloadEventConfig.getClickItemTag() : downloadEventConfig.getClickButtonTag();
            String strU = mv.u(pnVarPn.fx.getClickLabel(), "click");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i));
                jSONObject.putOpt("permission_notification", Integer.valueOf(b.u() ? 1 : 2));
                if (!com.ss.android.socialbase.downloader.jk.iz.fx(l.getContext())) {
                    i2 = 2;
                }
                jSONObject.putOpt("network_available", Integer.valueOf(i2));
            } catch (JSONException unused) {
            }
            u(clickItemTag, strU, jSONObject, pnVarPn);
            if (!"click".equals(strU) || pnVarPn.nr == null) {
                return;
            }
            fx.u().u(j, pnVarPn.nr.getLogExtra());
        }
    }

    public void u(long j, int i, DownloadInfo downloadInfo) {
        String strU;
        pn pnVarPn = iz.u().pn(j);
        if (pnVarPn.qq()) {
            com.ss.android.downloadlib.pn.fx.u().u("sendEvent ModelBox notValid");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        mv.u(jSONObject, "download_scene", Integer.valueOf(pnVarPn.bq()));
        if (i == 1) {
            strU = mv.u(pnVarPn.fx.getStorageDenyLabel(), "storage_deny");
        } else if (i == 2) {
            strU = mv.u(pnVarPn.fx.getClickStartLabel(), "click_start");
            com.ss.android.downloadlib.x.iz.u(downloadInfo, jSONObject);
        } else if (i == 3) {
            strU = mv.u(pnVarPn.fx.getClickPauseLabel(), "click_pause");
            com.ss.android.downloadlib.x.iz.nr(downloadInfo, jSONObject);
        } else if (i == 4) {
            strU = mv.u(pnVarPn.fx.getClickContinueLabel(), "click_continue");
            com.ss.android.downloadlib.x.iz.fx(downloadInfo, jSONObject);
        } else if (i != 5) {
            strU = null;
        } else {
            if (downloadInfo != null) {
                try {
                    com.ss.android.downloadlib.x.iz.u(jSONObject, downloadInfo.getId());
                    com.ss.android.downloadlib.u.nr(jSONObject, downloadInfo);
                } catch (Throwable unused) {
                }
            }
            strU = mv.u(pnVarPn.fx.getClickInstallLabel(), "click_install");
        }
        u(null, strU, jSONObject, 0L, 1, pnVarPn);
    }

    public void nr(String str, long j) {
        com.ss.android.downloadad.api.u.nr nrVarB = iz.u().b(j);
        if (nrVarB != null) {
            nr(str, nrVarB);
        } else {
            nr(str, iz.u().pn(j));
        }
    }

    public void nr(String str, com.ss.android.downloadad.api.u.u uVar) {
        u((String) null, str, uVar);
    }

    public void nr(String str, JSONObject jSONObject, com.ss.android.downloadad.api.u.u uVar) {
        u((String) null, str, jSONObject, uVar);
    }

    public void u(String str, int i, pn pnVar) {
        u(null, str, null, i, 0, pnVar);
    }

    public void u(long j, boolean z, int i) {
        pn pnVarPn = iz.u().pn(j);
        if (pnVarPn.qq()) {
            com.ss.android.downloadlib.pn.fx.u().u("sendQuickAppEvent ModelBox notValid");
            return;
        }
        if (pnVarPn.nr.getQuickAppModel() == null) {
            return;
        }
        DownloadModel downloadModel = pnVarPn.nr;
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_click_type", Integer.valueOf(i));
        } catch (JSONException unused) {
        }
        nr(z ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, pnVarPn);
    }

    public void u(long j, BaseException baseException) {
        pn pnVarPn = iz.u().pn(j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_time", 0);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
            }
        } catch (JSONException unused) {
        }
        nr("download_failed", jSONObject, pnVarPn);
    }

    public void u(DownloadInfo downloadInfo) {
        com.ss.android.downloadad.api.u.nr nrVarU = iz.u().u(downloadInfo);
        if (nrVarU == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.x.iz.fx(downloadInfo, jSONObject);
            nrVarU.u(System.currentTimeMillis());
            u(nrVarU.jk(), "download_resume", jSONObject, nrVarU);
            a.u().u(nrVarU);
        } catch (Throwable unused) {
        }
    }

    public void u(JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.u.nr nrVar) {
        u(nrVar.jk(), "install_finish", jSONObject, nrVar);
    }

    public void u(DownloadInfo downloadInfo, BaseException baseException) {
        com.ss.android.downloadad.api.u.nr nrVarU;
        if (downloadInfo == null || (nrVarU = iz.u().u(downloadInfo)) == null || nrVarU.fx.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.u.u(jSONObject, downloadInfo);
            jSONObject.putOpt("fail_status", Integer.valueOf(nrVarU.ja()));
            jSONObject.putOpt("fail_msg", nrVarU.bf());
            jSONObject.put("download_failed_times", nrVarU.qq());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (nrVarU.pb() > 0) {
                jSONObject.put("time_from_start_download", jCurrentTimeMillis - nrVarU.pb());
            }
            if (nrVarU.d() > 0) {
                jSONObject.put("time_from_download_resume", jCurrentTimeMillis - nrVarU.d());
            }
            int i = 1;
            jSONObject.put("is_update_download", nrVarU.yd() ? 1 : 2);
            jSONObject.put("can_show_notification", b.u() ? 1 : 2);
            if (!nrVarU.b.get()) {
                i = 2;
            }
            jSONObject.put("has_send_download_failed_finally", i);
        } catch (JSONException unused) {
        }
        u(nrVarU.jk(), "download_cancel", jSONObject, nrVarU);
    }

    public void u(String str, long j) {
        u(str, (JSONObject) null, j);
    }

    public void u(String str, com.ss.android.downloadad.api.u.u uVar) {
        u(str, (JSONObject) null, uVar);
    }

    public void u(String str, JSONObject jSONObject, long j) {
        com.ss.android.downloadad.api.u.u uVarB = iz.u().b(j);
        if (uVarB != null) {
            u(str, jSONObject, uVarB);
            return;
        }
        pn pnVarPn = iz.u().pn(j);
        if (pnVarPn.qq()) {
            com.ss.android.downloadlib.pn.fx.u().u("sendUnityEvent ModelBox notValid");
        } else {
            u(str, jSONObject, pnVarPn);
        }
    }

    public void u(String str, JSONObject jSONObject, com.ss.android.downloadad.api.u.u uVar) {
        JSONObject jSONObject2 = new JSONObject();
        mv.u(jSONObject2, "unity_label", str);
        u("embeded_ad", "ttdownloader_unity", mv.u(jSONObject, jSONObject2), uVar);
    }

    public void u(String str, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        nr(str, new pn(downloadModel.getId(), downloadModel, downloadEventConfig, downloadController));
    }

    public void u(String str, String str2, com.ss.android.downloadad.api.u.u uVar) {
        u(str, str2, (JSONObject) null, uVar);
    }

    public void u(String str, String str2, JSONObject jSONObject, com.ss.android.downloadad.api.u.u uVar) {
        u(str, str2, jSONObject, 0L, 0, uVar);
    }

    private void u(String str, String str2, JSONObject jSONObject, long j, int i, com.ss.android.downloadad.api.u.u uVar) {
        if (uVar == null) {
            com.ss.android.downloadlib.pn.fx.u().u("onEvent data null");
            return;
        }
        if ((uVar instanceof pn) && ((pn) uVar).qq()) {
            com.ss.android.downloadlib.pn.fx.u().u("onEvent ModelBox notValid");
            return;
        }
        try {
            fx.u uVarFx = new fx.u().u(mv.u(str, uVar.jk(), "embeded_ad")).nr(str2).nr(uVar.fx()).u(uVar.nr()).fx(uVar.b());
            if (j <= 0) {
                j = uVar.l();
            }
            fx.u uVarU = uVarFx.nr(j).b(uVar.a()).u(uVar.s()).u(mv.u(u(uVar), jSONObject)).nr(uVar.t()).u(uVar.k());
            if (i <= 0) {
                i = 2;
            }
            u(uVarU.u(i).u(uVar.mv()).u());
        } catch (Exception e) {
            com.ss.android.downloadlib.pn.fx.u().u(e, "onEvent");
        }
    }

    private JSONObject u(com.ss.android.downloadad.api.u.u uVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            mv.u(uVar.x(), jSONObject);
            mv.u(uVar.my(), jSONObject);
            jSONObject.putOpt(WfConstant.EXTRA_KEY_DOWNLOAD_URL, uVar.u());
            jSONObject.putOpt("package_name", uVar.pn());
            jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", com.ss.android.socialbase.appdownloader.iz.pn.n());
            jSONObject.putOpt("rom_version", com.ss.android.socialbase.appdownloader.iz.pn.a());
            jSONObject.putOpt("ttdownloader", 1);
            jSONObject.putOpt("funnel_type", Integer.valueOf(uVar.n()));
            if (uVar.n() == 2) {
                com.ss.android.downloadlib.x.iz.nr(jSONObject, uVar);
            }
            if (com.ss.android.socialbase.appdownloader.iz.pn.my()) {
                com.ss.android.downloadlib.x.iz.u(jSONObject);
            }
        } catch (Exception e) {
            l.bq().u(e, "getBaseJson");
        }
        return jSONObject;
    }

    private void u(com.ss.android.download.api.model.fx fxVar) {
        if (l.u() == null) {
            return;
        }
        if (fxVar.mv()) {
            l.u().u(fxVar);
        } else {
            l.u().nr(fxVar);
        }
    }
}
