package com.ss.android.downloadlib.addownload.nr;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class n {
    private static volatile n u;

    private n() {
    }

    public static n u() {
        if (u == null) {
            synchronized (b.class) {
                if (u == null) {
                    u = new n();
                }
            }
        }
        return u;
    }

    public void u(int i, int i2, com.ss.android.downloadad.api.u.nr nrVar) {
        if (nrVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.n.u uVarU = com.ss.android.socialbase.downloader.n.u.u(nrVar.bg());
        if (uVarU.u("report_api_hijack", 0) == 0) {
            return;
        }
        int i3 = i2 - i;
        if (i <= 0 || i3 <= uVarU.u("check_api_hijack_version_code_diff", 500)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version_code_diff", i3);
            jSONObject.put("installed_version_code", i2);
            jSONObject.put("hijack_type", 1);
        } catch (JSONException unused) {
        }
        com.ss.android.downloadlib.b.u.u().nr("api_hijack", jSONObject, nrVar);
    }
}
