package com.bytedance.sdk.component.t.fx;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public enum nr {
    INSTANCE;

    private Map<String, fx> nr = new HashMap();

    nr() {
    }

    public fx u(String str) {
        return this.nr.get(str);
    }

    public void u(JSONObject jSONObject) {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                String next = itKeys.next();
                jSONObject2.putOpt(next, jSONObject.opt(next));
                fx fxVar = new fx(jSONObject2);
                this.nr.put(fxVar.nr(), fxVar);
            } catch (JSONException unused) {
            }
        }
    }
}
