package com.tide.protocol.report;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ITideReporter {
    void onEvent(String str, String str2);

    void onEvent(String str, String str2, Map<String, Object> map);

    void onEvent(String str, String str2, JSONObject jSONObject);
}
