package com.ss.android.downloadlib.addownload.compliance;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.bg;
import com.ss.android.downloadlib.addownload.l;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class iz {
    private final AtomicInteger u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private static iz u = new iz();
    }

    private iz() {
        this.u = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String nr() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.u.get() < 3 ? "https://apps.bytesfield.com" : "https://apps.bytesfield-b.com");
        sb.append("/customer/api/app/deep_link");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(@NonNull final com.ss.android.downloadlib.addownload.nr.pn pnVar, final String str, final byte[] bArr, final n nVar) {
        l.b().u(str, bArr, "application/json; charset=utf-8", 0, new bg() { // from class: com.ss.android.downloadlib.addownload.compliance.iz.2
            @Override // com.ss.android.download.api.config.bg
            public void u(String str2) {
                iz.this.u(pnVar, str2, nVar);
            }

            @Override // com.ss.android.download.api.config.bg
            public void u(Throwable th) {
                iz.this.u(pnVar, str, bArr, nVar);
            }
        });
    }

    public static iz u() {
        return u.u;
    }

    public void u(final com.ss.android.downloadlib.addownload.nr.pn pnVar, final n nVar) {
        if (l.b() == null) {
            com.ss.android.downloadlib.pn.fx.u().u("getDownloadNetworkFactory == NULL");
            u(401, pnVar);
        } else {
            com.ss.android.downloadlib.pn.u().u(new Runnable() { // from class: com.ss.android.downloadlib.addownload.compliance.iz.1
                @Override // java.lang.Runnable
                public void run() {
                    iz izVar = iz.this;
                    izVar.nr(pnVar, izVar.nr(), iz.this.u(pnVar, true, 4), nVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.ss.android.downloadlib.addownload.nr.pn pnVar, String str, byte[] bArr, n nVar) {
        if (this.u.get() < 6) {
            this.u.incrementAndGet();
            nr(pnVar, str, bArr, nVar);
        } else {
            u("当前网络不佳，请稍后再试");
            this.u.set(0);
            u(402, pnVar);
        }
    }

    private void u(final String str) {
        com.ss.android.downloadlib.n.u().nr().post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.compliance.iz.3
            @Override // java.lang.Runnable
            public void run() {
                l.fx().u(6, l.getContext(), null, str, null, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] u(com.ss.android.downloadlib.addownload.nr.pn pnVar, boolean z, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(WfConstant.EXTRA_KEY_DOWNLOAD_URL, pnVar.u());
            jSONObject.put("package_name", pnVar.pn());
            jSONObject.put("call_scene", 50);
            if (z) {
                jSONObject.put("sender_package_name", l.getContext().getPackageName());
                jSONObject.put("sender_version", l.jk().pn);
                if (i > 0) {
                    jSONObject.put("store", i);
                }
            } else {
                jSONObject.put("id", String.valueOf(pnVar.nr()));
                if (pnVar.dw().getDeepLink() != null) {
                    if (TextUtils.isEmpty(pnVar.dw().getDeepLink().getWebUrl())) {
                        com.ss.android.downloadlib.pn.fx.u().u("web_url is null");
                    }
                    jSONObject.put("web_url", pnVar.dw().getDeepLink().getWebUrl());
                } else {
                    com.ss.android.downloadlib.pn.fx.u().u("deeplink is null");
                }
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.pn.fx.u().u("param build error");
        }
        return jSONObject.toString().getBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(@NonNull com.ss.android.downloadlib.addownload.nr.pn pnVar, String str, n nVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.pn.fx.u().u("response content is null");
                u(404, pnVar);
                nVar.u();
                return;
            }
            this.u.set(0);
            pn pnVarX = pn.x(str);
            if (pnVarX.u() != 0) {
                u(403, pnVar);
                nVar.u();
            } else if (TextUtils.isEmpty(pnVarX.nr())) {
                u(405, pnVar);
                nVar.u();
            } else {
                nVar.u(pnVarX.nr());
            }
        } catch (Exception e) {
            com.ss.android.downloadlib.pn.fx.u().u(e, "DownloadMiuiMarketHelper parseResponse");
        }
    }

    public void u(int i, com.ss.android.downloadlib.addownload.nr.pn pnVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_miui_market_fail_code", Integer.valueOf(i));
        } catch (Exception unused) {
        }
        com.ss.android.downloadlib.b.u.u().u("get_miui_market_compliance_error", jSONObject, pnVar);
    }

    public void u(int i, com.ss.android.downloadlib.addownload.nr.pn pnVar, JSONObject jSONObject) {
        try {
            jSONObject.putOpt("download_miui_market_success_result", Integer.valueOf(i));
        } catch (Exception unused) {
        }
        com.ss.android.downloadlib.b.u.u().u("get_miui_market_compliance_success", jSONObject, pnVar);
    }
}
