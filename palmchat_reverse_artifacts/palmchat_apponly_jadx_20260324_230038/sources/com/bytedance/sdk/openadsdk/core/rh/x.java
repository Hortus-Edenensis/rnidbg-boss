package com.bytedance.sdk.openadsdk.core.rh;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x {
    private JSONObject u;

    public x(JSONObject jSONObject) {
        this.u = jSONObject;
    }

    @NonNull
    public String toString() {
        JSONObject jSONObject = this.u;
        return jSONObject != null ? jSONObject.toString() : "pitaya error is null";
    }

    public int u() {
        JSONObject jSONObject = this.u;
        if (jSONObject != null) {
            return jSONObject.optInt("code", -1);
        }
        return -1;
    }
}
