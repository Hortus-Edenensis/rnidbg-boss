package com.bytedance.sdk.openadsdk.core.pb;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk {
    public static boolean b() {
        return nr() > 0;
    }

    public static boolean fx() {
        return u() > 0;
    }

    public static boolean iz() {
        return pn() > 0;
    }

    public static int nr() {
        JSONObject jSONObjectFq = dw.nr().fq();
        if (jSONObjectFq != null && d.fx >= 7200) {
            return jSONObjectFq.optInt("live_init_max_count", 0);
        }
        return 0;
    }

    public static int pn() {
        JSONObject jSONObjectFq = dw.nr().fq();
        if (jSONObjectFq == null) {
            return 0;
        }
        return jSONObjectFq.optInt("pangle_max_count", 0);
    }

    public static int u() {
        JSONObject jSONObjectFq = dw.nr().fq();
        if (jSONObjectFq == null) {
            return 0;
        }
        return jSONObjectFq.optInt("live_max_count", 0);
    }

    public static boolean u(String str) {
        if (TextUtils.equals(str, "com.byted.pangle")) {
            return iz();
        }
        if (TextUtils.equals(str, "com.byted.live.lite")) {
            return fx();
        }
        return false;
    }

    public static int nr(String str) {
        if (TextUtils.equals(str, "com.byted.pangle")) {
            return pn();
        }
        if (TextUtils.equals(str, "com.byted.live.lite")) {
            return u();
        }
        return 0;
    }
}
