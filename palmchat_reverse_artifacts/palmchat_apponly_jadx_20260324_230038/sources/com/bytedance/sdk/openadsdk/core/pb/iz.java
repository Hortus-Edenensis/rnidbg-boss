package com.bytedance.sdk.openadsdk.core.pb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz {
    public boolean u = false;
    public boolean nr = true;

    public static iz u(String str) {
        iz izVar = new iz();
        if (TextUtils.isEmpty(str)) {
            return izVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            izVar.u = jSONObject.optBoolean("encrypt", false);
            izVar.nr = jSONObject.optBoolean("wait_io", true);
        } catch (Throwable unused) {
        }
        return izVar;
    }

    @NonNull
    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("encrypt", this.u);
            jSONObject.put("wait_io", this.nr);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
