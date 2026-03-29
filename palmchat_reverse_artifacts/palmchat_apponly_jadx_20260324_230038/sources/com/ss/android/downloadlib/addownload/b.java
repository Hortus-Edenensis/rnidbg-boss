package com.ss.android.downloadlib.addownload;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.pn;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {
    private com.ss.android.downloadlib.addownload.nr.pn nr;
    private Handler u;
    private AtomicBoolean fx = new AtomicBoolean(false);
    private AtomicBoolean b = new AtomicBoolean(false);

    public b(Handler handler) {
        this.u = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long b() {
        return com.ss.android.downloadlib.x.mv.nr(0L);
    }

    public static long nr() {
        if (l.mv() != null) {
            return l.mv().u();
        }
        return 0L;
    }

    private void nr(com.ss.android.downloadad.api.u.nr nrVar, JSONObject jSONObject, long j, long j2) {
        nrVar.l("1");
        com.ss.android.downloadlib.addownload.nr.a.u().u(nrVar);
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(j2 - j));
        } catch (JSONException unused) {
        }
        com.ss.android.downloadlib.b.u.u().u("cleanspace_download_after_quite_clean", jSONObject, nrVar);
    }

    public void u(com.ss.android.downloadlib.addownload.nr.pn pnVar) {
        this.nr = pnVar;
    }

    public boolean u() {
        return this.b.get();
    }

    public void u(boolean z) {
        this.b.set(z);
    }

    public void u(final int i, final long j, long j2, final pn.u uVar) {
        this.b.set(false);
        if (uVar == null) {
            return;
        }
        if (com.ss.android.downloadlib.x.pn.iz(i) && com.ss.android.downloadlib.x.pn.pn(i)) {
            long jFx = com.ss.android.downloadlib.x.pn.fx(i);
            this.fx.set(false);
            final String downloadUrl = this.nr.nr.getDownloadUrl();
            com.ss.android.downloadad.api.u.nr nrVarNr = com.ss.android.downloadlib.addownload.nr.iz.u().nr(downloadUrl);
            if (nrVarNr == null) {
                com.ss.android.downloadlib.addownload.nr.pn pnVar = this.nr;
                nrVarNr = new com.ss.android.downloadad.api.u.nr(pnVar.nr, pnVar.fx, pnVar.b, 0);
                com.ss.android.downloadlib.addownload.nr.iz.u().u(nrVarNr);
            }
            final com.ss.android.downloadad.api.u.nr nrVar = nrVarNr;
            nrVar.pn(false);
            if (l.mv() != null) {
                l.mv();
                nrVar.nr();
            }
            com.ss.android.downloadlib.addownload.fx.b.u().u(nrVar.u());
            boolean zB = com.ss.android.downloadlib.x.pn.b(i);
            if (j2 > 0) {
                u(i, downloadUrl, j2, nrVar, j, uVar);
            } else if (zB) {
                u(downloadUrl, nrVar, new pn.nr() { // from class: com.ss.android.downloadlib.addownload.b.1
                    @Override // com.ss.android.downloadlib.addownload.pn.nr
                    public void u(long j3) throws Throwable {
                        b.this.u(i, downloadUrl, j3, nrVar, j, uVar);
                    }
                });
            } else {
                jFx = 0;
            }
            this.u.postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.fx.get()) {
                        return;
                    }
                    b.this.fx.set(true);
                    uVar.u();
                }
            }, jFx);
            return;
        }
        uVar.u();
    }

    private void u(String str, com.ss.android.downloadad.api.u.nr nrVar, final pn.nr nrVar2) {
        if (nrVar2 == null) {
            return;
        }
        com.ss.android.socialbase.downloader.network.u.nr.u(str, new com.ss.android.socialbase.downloader.network.jk() { // from class: com.ss.android.downloadlib.addownload.b.3
            @Override // com.ss.android.socialbase.downloader.network.jk
            public void u(Map<String, String> map) {
                if (b.this.fx.get()) {
                    return;
                }
                b.this.fx.set(true);
                long jU = b.this.u(map);
                if (jU > 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("apk_size", Long.valueOf(jU));
                        jSONObject.putOpt("available_space", Long.valueOf(b.b()));
                    } catch (JSONException unused) {
                    }
                }
                nrVar2.u(jU);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long u(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return 0L;
        }
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if ("content-length".equalsIgnoreCase(key)) {
                    return Long.parseLong(value);
                }
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, String str, long j, final com.ss.android.downloadad.api.u.nr nrVar, long j2, final pn.u uVar) throws Throwable {
        this.fx.set(true);
        boolean zU = false;
        if (j > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("apk_size", Long.valueOf(j));
            } catch (JSONException unused) {
            }
            long jLongValue = (Double.valueOf((com.ss.android.downloadlib.x.pn.u(i) + 1.0d) * j).longValue() + com.ss.android.downloadlib.x.pn.nr(i)) - j2;
            long jB = b();
            if (jB < jLongValue) {
                u(nrVar, jSONObject, jLongValue, jB);
                u(nrVar);
                long jB2 = b();
                if (jB2 < jLongValue) {
                    nrVar.b(true);
                    final String strU = nrVar.u();
                    com.ss.android.downloadlib.addownload.fx.b.u().u(strU, new com.ss.android.downloadlib.addownload.fx.pn() { // from class: com.ss.android.downloadlib.addownload.b.4
                    });
                    zU = u(i, nrVar, str, jLongValue);
                    if (zU) {
                        nrVar.pn(true);
                    }
                } else {
                    nr(nrVar, jSONObject, jB, jB2);
                }
            }
        }
        if (zU) {
            return;
        }
        this.u.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.b.5
            @Override // java.lang.Runnable
            public void run() {
                uVar.u();
            }
        });
    }

    private boolean u(int i, @NonNull com.ss.android.downloadad.api.u.nr nrVar, String str, long j) {
        if (!com.ss.android.downloadlib.x.pn.iz(i)) {
            return false;
        }
        if (l.mv() != null) {
            return l.mv().u(i, str, true, j);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_dialog_result", 3);
        } catch (JSONException unused) {
        }
        com.ss.android.downloadlib.b.u.u().u("cleanspace_window_show", jSONObject, nrVar);
        return false;
    }

    public static boolean u(final DownloadInfo downloadInfo, long j) {
        int id = downloadInfo.getId();
        boolean zU = false;
        if (!com.ss.android.downloadlib.x.pn.iz(id)) {
            return false;
        }
        if (l.mv() != null && (zU = l.mv().u(id, downloadInfo.getUrl(), false, j))) {
            com.ss.android.downloadlib.addownload.fx.b.u().u(downloadInfo.getUrl(), new com.ss.android.downloadlib.addownload.fx.pn() { // from class: com.ss.android.downloadlib.addownload.b.6
            });
        }
        return zU;
    }

    public static JSONObject u(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("clean_space_install_params", str);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static void u(int i) {
        if (com.ss.android.downloadlib.x.pn.iz(i) && l.mv() != null && l.mv().nr()) {
            l.mv();
        }
    }

    private static void u(com.ss.android.downloadad.api.u.nr nrVar) throws Throwable {
        long jB = b();
        if (l.mv() != null) {
            l.mv();
        }
        com.ss.android.downloadlib.addownload.fx.fx.u();
        com.ss.android.downloadlib.addownload.fx.fx.nr();
        if (com.ss.android.downloadlib.x.pn.x(nrVar.bg())) {
            com.ss.android.downloadlib.addownload.fx.fx.u(l.getContext());
        }
        long jB2 = b();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(jB2 - jB));
        } catch (JSONException unused) {
        }
        com.ss.android.downloadlib.b.u.u().u("clean_quite_finish", jSONObject, nrVar);
    }

    private void u(com.ss.android.downloadad.api.u.nr nrVar, JSONObject jSONObject, long j, long j2) {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j2));
            jSONObject.putOpt("apk_download_need_size", Long.valueOf(j));
        } catch (JSONException unused) {
        }
        com.ss.android.downloadlib.b.u.u().u("clean_space_no_enough_for_download", jSONObject, nrVar);
    }
}
