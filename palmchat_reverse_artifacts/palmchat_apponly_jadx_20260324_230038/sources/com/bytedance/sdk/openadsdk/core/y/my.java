package com.bytedance.sdk.openadsdk.core.y;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class my {
    public static boolean nr() {
        JSONObject jSONObjectDc = com.bytedance.sdk.openadsdk.core.dw.nr().dc();
        return jSONObjectDc != null && u() && jSONObjectDc.optInt("force_drop", 0) == 1;
    }

    public static boolean u() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObjectDc = com.bytedance.sdk.openadsdk.core.dw.nr().dc();
        if (jSONObjectDc == null) {
            return false;
        }
        return jCurrentTimeMillis >= jSONObjectDc.optLong("start", 1707480000000L) && jCurrentTimeMillis <= jSONObjectDc.optLong("end", 1707498000000L);
    }
}
