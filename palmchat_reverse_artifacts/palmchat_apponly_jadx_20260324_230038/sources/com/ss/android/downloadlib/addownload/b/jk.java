package com.ss.android.downloadlib.addownload.b;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class jk implements a {
    private boolean nr(int i) {
        return com.ss.android.socialbase.downloader.n.u.u(i).u("pause_optimise_mistake_click_interval_switch", 0) == 1;
    }

    @Override // com.ss.android.downloadlib.addownload.b.a
    public boolean u(com.ss.android.downloadad.api.u.nr nrVar, int i, n nVar) {
        if (nrVar == null || !nr(nrVar.bg())) {
            return false;
        }
        if (System.currentTimeMillis() - nrVar.su() > u(nrVar.bg())) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", "mistake_click");
        } catch (JSONException unused) {
        }
        com.ss.android.downloadlib.b.u.u().u("pause_optimise", jSONObject, nrVar);
        return true;
    }

    private long u(int i) {
        return com.ss.android.socialbase.downloader.n.u.u(i).u("pause_optimise_mistake_click_interval", 300);
    }
}
