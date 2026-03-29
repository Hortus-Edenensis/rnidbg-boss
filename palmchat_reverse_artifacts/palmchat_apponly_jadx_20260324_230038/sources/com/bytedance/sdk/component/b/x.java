package com.bytedance.sdk.component.b;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface x {
    void onExceptionEvent(String str, JSONObject jSONObject, Throwable th);

    void onStatsEvent(String str, JSONObject jSONObject);

    void onStatsEvent(String str, JSONObject jSONObject, JSONObject jSONObject2);
}
