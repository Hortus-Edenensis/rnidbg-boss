package com.kwai.adclient.kscommerciallogger.snapshot;

import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d {
    private final String bkg;
    private final LinkedHashMap<String, String> bkh = new LinkedHashMap<>();
    private final long time = System.nanoTime();

    public d(String str) {
        this.bkg = str;
    }

    public synchronized JSONObject Vi() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.bkh.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("time", this.time);
            jSONObject.put("span_name", this.bkg);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
