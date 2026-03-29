package com.bytedance.sdk.openadsdk.core.ja;

import com.baidu.location.LocationConst;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.live.pn.nr;
import com.bytedance.sdk.openadsdk.gi.l;
import com.bytedance.sdk.openadsdk.gi.x;
import com.huawei.hms.framework.common.ContainerUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private final int u;

    public u(int i) {
        this.u = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iz() {
        x.u(new a("csj-plugin-check") { // from class: com.bytedance.sdk.openadsdk.core.ja.u.2
            @Override // java.lang.Runnable
            public void run() {
                if (u.this.nr() == 5) {
                    nr.u();
                }
            }
        });
    }

    public int b() {
        return 2;
    }

    public int fx() {
        return u(8);
    }

    public int nr() {
        return u(4);
    }

    public void pn() {
        JSONObject jSONObjectHj = dw.nr().hj();
        if (jSONObjectHj == null) {
            return;
        }
        try {
            u(jSONObjectHj, "com.byted.live.lite", 4, true);
            u(jSONObjectHj, "com.byted.csj.ext", 8, true);
            u(jSONObjectHj, "com.byted.mixed", 0, true);
            u(jSONObjectHj, "com.byted.pangle", 0, false);
        } catch (Throwable unused) {
        }
    }

    public String toString() {
        return String.valueOf(this.u);
    }

    public int u(int i) {
        int i2 = this.u >> i;
        int i3 = i2 & 7;
        return i3 == 0 ? b() : ((i2 & 8) >> 3) == 1 ? -i3 : i3;
    }

    public u(int i, boolean z) {
        this.u = i;
        jk.u().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ja.u.1
            @Override // java.lang.Runnable
            public void run() {
                u.this.iz();
            }
        }, 5000L);
    }

    public int u() {
        return u(0);
    }

    public int u(String str) {
        if ("com.byted.live.lite".equals(str)) {
            if (dw.nr().hl()) {
                return nr();
            }
            return 4;
        }
        if ("com.byted.csj.ext".equals(str)) {
            return fx();
        }
        if ("com.byted.pangle".equals(str)) {
            return u();
        }
        return b();
    }

    private void u(JSONObject jSONObject, String str, int i, boolean z) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        int iOptInt = jSONObjectOptJSONObject.optInt(LocationConst.HDYawConst.KEY_HD_YAW_STATE, 2);
        if (iOptInt == 5) {
            int iNr = l.nr(str);
            int iFx = l.fx(str);
            int iB = l.b(str);
            if (z || iFx > iB) {
                String strOptString = jSONObjectOptJSONObject.optString("api_rule", ContainerUtils.KEY_VALUE_DELIMITER);
                String strOptString2 = jSONObjectOptJSONObject.optString("plugin_rule", ContainerUtils.KEY_VALUE_DELIMITER);
                int iOptInt2 = jSONObjectOptJSONObject.optInt("api_v", 0);
                int iOptInt3 = jSONObjectOptJSONObject.optInt("plugin_v", 0);
                if (u(iNr, iOptInt2, strOptString) && u(iFx, iOptInt3, strOptString2)) {
                    l.u(str);
                    return;
                }
                return;
            }
            return;
        }
        if (iOptInt == -1 && u(i) == 5 && l.fx(str) > l.b(str)) {
            l.u(str);
        }
    }

    private boolean u(int i, int i2, String str) {
        str.hashCode();
        switch (str) {
            case "<":
                return i < i2;
            case "=":
            case "==":
                return i == i2;
            case ">":
                return i > i2;
            case "<=":
                return i <= i2;
            case ">=":
                return i >= i2;
            default:
                return false;
        }
    }
}
