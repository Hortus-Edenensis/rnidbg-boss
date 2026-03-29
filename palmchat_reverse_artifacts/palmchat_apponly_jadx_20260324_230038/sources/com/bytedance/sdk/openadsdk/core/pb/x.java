package com.bytedance.sdk.openadsdk.core.pb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x {
    public boolean u = false;
    public boolean nr = false;
    public boolean fx = false;
    public boolean b = false;
    private boolean pn = false;

    public static x u(String str) {
        x xVar = new x();
        if (TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.gi.iz.u().delete();
            return xVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            xVar.u = jSONObject.optBoolean("use_csj_main", false);
            xVar.nr = jSONObject.optBoolean("use_layze_layout", false);
            xVar.fx = jSONObject.optBoolean("create_ad_in_io", false);
            xVar.b = jSONObject.optBoolean("opt_panel_view", false);
            boolean zOptBoolean = jSONObject.optBoolean("so_lock", false);
            xVar.pn = zOptBoolean;
            if (zOptBoolean) {
                com.bytedance.sdk.openadsdk.gi.iz.u().mkdirs();
            } else {
                com.bytedance.sdk.openadsdk.gi.iz.u().delete();
            }
        } catch (Throwable unused) {
        }
        return xVar;
    }

    @NonNull
    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("use_csj_main", this.u);
            jSONObject.put("use_layze_layout", this.nr);
            jSONObject.put("create_ad_in_io", this.fx);
            jSONObject.put("opt_panel_view", this.b);
            jSONObject.put("so_lock", this.pn);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
