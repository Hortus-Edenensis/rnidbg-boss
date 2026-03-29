package com.ss.android.downloadlib.addownload;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.x.s;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u implements s.u {
    private static u nr = null;
    private static final String u = "u";
    private long b;
    private com.ss.android.downloadlib.x.s fx = new com.ss.android.downloadlib.x.s(Looper.getMainLooper(), this);

    private u() {
    }

    public static u u() {
        if (nr == null) {
            synchronized (u.class) {
                if (nr == null) {
                    nr = new u();
                }
            }
        }
        return nr;
    }

    public void u(@NonNull DownloadInfo downloadInfo, long j, long j2, String str, String str2, String str3, String str4) {
        int i;
        com.ss.android.downloadlib.addownload.nr.u uVar = new com.ss.android.downloadlib.addownload.nr.u(downloadInfo.getId(), j, j2, str, str2, str3, str4);
        if (com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("back_miui_silent_install", 1) == 0 && ((com.ss.android.socialbase.appdownloader.iz.pn.mv() || com.ss.android.socialbase.appdownloader.iz.pn.s()) && com.ss.android.socialbase.downloader.jk.jk.u(l.getContext(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (com.ss.android.socialbase.downloader.jk.iz.u(downloadInfo.getTempCacheData().get("extra_silent_install_succeed"), false)) {
                Message messageObtainMessage = this.fx.obtainMessage(200, uVar);
                messageObtainMessage.arg1 = 2;
                this.fx.sendMessageDelayed(messageObtainMessage, r1.u("check_silent_install_interval", 60000));
                return;
            }
            com.ss.android.downloadad.api.u.nr nrVarB = com.ss.android.downloadlib.addownload.nr.iz.u().b(uVar.nr);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                i = 5;
            } catch (Exception unused) {
                i = -1;
            }
            l.iz().u(null, new BaseException(i, jSONObject.toString()), i);
            com.ss.android.downloadlib.b.u.u().u("embeded_ad", "ah_result", jSONObject, nrVarB);
        }
        if (com.ss.android.downloadlib.x.pn.fx()) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.b;
            long jB = com.ss.android.downloadlib.x.pn.b();
            if (jCurrentTimeMillis < com.ss.android.downloadlib.x.pn.pn()) {
                long jPn = com.ss.android.downloadlib.x.pn.pn() - jCurrentTimeMillis;
                jB += jPn;
                this.b = System.currentTimeMillis() + jPn;
            } else {
                this.b = System.currentTimeMillis();
            }
            com.ss.android.downloadlib.x.s sVar = this.fx;
            sVar.sendMessageDelayed(sVar.obtainMessage(200, uVar), jB);
        }
    }

    private void u(com.ss.android.downloadlib.addownload.nr.u uVar, int i) {
        int i2;
        if (l.l() == null || l.l().u() || uVar == null) {
            return;
        }
        if (2 == i) {
            com.ss.android.downloadad.api.u.nr nrVarB = com.ss.android.downloadlib.addownload.nr.iz.u().b(uVar.nr);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                if (com.ss.android.downloadlib.x.mv.pn(l.getContext(), uVar.b)) {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                    i2 = 4;
                } else {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                    i2 = 5;
                }
            } catch (Exception unused) {
                i2 = -1;
            }
            l.iz().u(null, new BaseException(i2, jSONObject.toString()), i2);
            com.ss.android.downloadlib.b.u.u().u("embeded_ad", "ah_result", jSONObject, nrVarB);
        }
        if (com.ss.android.downloadlib.x.mv.pn(l.getContext(), uVar.b)) {
            com.ss.android.downloadlib.b.u.u().nr("delayinstall_installed", uVar.nr);
            return;
        }
        if (!com.ss.android.downloadlib.x.mv.u(uVar.x)) {
            com.ss.android.downloadlib.b.u.u().nr("delayinstall_file_lost", uVar.nr);
        } else if (com.ss.android.downloadlib.addownload.u.u.u().u(uVar.b)) {
            com.ss.android.downloadlib.b.u.u().nr("delayinstall_conflict_with_back_dialog", uVar.nr);
        } else {
            com.ss.android.downloadlib.b.u.u().nr("delayinstall_install_start", uVar.nr);
            com.ss.android.socialbase.appdownloader.b.u(l.getContext(), (int) uVar.u);
        }
    }

    @Override // com.ss.android.downloadlib.x.s.u
    public void u(Message message) {
        if (message.what != 200) {
            return;
        }
        u((com.ss.android.downloadlib.addownload.nr.u) message.obj, message.arg1);
    }
}
