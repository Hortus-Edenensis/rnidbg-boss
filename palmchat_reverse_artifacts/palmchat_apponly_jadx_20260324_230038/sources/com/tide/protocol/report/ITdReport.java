package com.tide.protocol.report;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ITdReport {
    void onEvent(String str);

    void onEvent(String str, Map<String, Object> map);

    void onEvent(String str, JSONObject jSONObject);
}
