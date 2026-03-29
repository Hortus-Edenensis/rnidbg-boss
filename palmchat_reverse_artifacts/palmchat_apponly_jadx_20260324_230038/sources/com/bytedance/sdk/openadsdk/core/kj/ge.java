package com.bytedance.sdk.openadsdk.core.kj;

import android.os.Build;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ge {
    public static int fx = 1;
    public static int nr;
    public static int u;

    public static void u(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("ugen_image_load_config")) == null) {
            return;
        }
        u = jSONObjectOptJSONObject.optInt("api", 0);
        nr = jSONObjectOptJSONObject.optInt("size_limit", 0);
        fx = jSONObjectOptJSONObject.optInt("zip_level", 1);
    }

    public static int u(int i, int i2) {
        if (u <= 0 || Build.VERSION.SDK_INT > u || i == 0 || i2 == 0) {
            return 1;
        }
        int i3 = nr;
        if (i >= i3 || i2 >= i3) {
            return Math.max(1, fx);
        }
        return 1;
    }
}
