package com.bytedance.sdk.openadsdk.core.l;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private JSONObject u;

    public fx(JSONObject jSONObject) {
        this.u = jSONObject;
    }

    public long b() {
        JSONObject jSONObject = this.u;
        if (jSONObject == null) {
            return 300L;
        }
        return jSONObject.optLong("uninstall_delay", 300L);
    }

    public boolean fx() {
        JSONObject jSONObject = this.u;
        return jSONObject != null && jSONObject.optInt("enable_install_interface", 0) == 1;
    }

    public int iz() {
        JSONObject jSONObject = this.u;
        if (jSONObject == null) {
            return 1;
        }
        return jSONObject.optInt("max_notification", 1);
    }

    public boolean nr() {
        JSONObject jSONObject = this.u;
        return jSONObject == null || jSONObject.optInt("enable_active_notification", 1) == 1;
    }

    public long pn() {
        JSONObject jSONObject = this.u;
        if (jSONObject == null) {
            return 1800L;
        }
        return jSONObject.optLong("notification_internal", 1800L);
    }

    public boolean u() {
        JSONObject jSONObject = this.u;
        return jSONObject == null || jSONObject.optInt("enable_install_notification", 1) == 1;
    }

    public int x() {
        JSONObject jSONObject = this.u;
        if (jSONObject == null) {
            return 1;
        }
        return jSONObject.optInt("max_interface", 1);
    }
}
