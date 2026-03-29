package com.bytedance.sdk.openadsdk.iz.u;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements nr {
    nr u;

    @Override // com.bytedance.sdk.openadsdk.iz.u.nr
    public void u(JSONObject jSONObject) throws JSONException {
        nr nrVar = this.u;
        if (nrVar != null) {
            nrVar.u(jSONObject);
        }
        jSONObject.put("event_ts", System.currentTimeMillis());
    }
}
