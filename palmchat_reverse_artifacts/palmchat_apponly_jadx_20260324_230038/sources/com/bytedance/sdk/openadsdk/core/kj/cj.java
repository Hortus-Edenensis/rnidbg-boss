package com.bytedance.sdk.openadsdk.core.kj;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class cj {
    private int u;

    public cj(JSONObject jSONObject) {
        this.u = 0;
        if (jSONObject == null) {
            return;
        }
        this.u = jSONObject.optInt("playable_reward_type", 0);
    }

    private static cj fx(bc bcVar) {
        if (bcVar == null) {
            return null;
        }
        return bcVar.ay();
    }

    public static int nr(bc bcVar) {
        com.bykv.vk.openvk.component.video.api.fx.b bVarS = zx.s(bcVar);
        String strA = bVarS != null ? bVarS.a() : null;
        try {
            if (TextUtils.isEmpty(strA)) {
                return 0;
            }
            String[] strArrSplit = strA.split("x");
            if (strArrSplit.length < 2) {
                return 0;
            }
            if (Integer.parseInt(strArrSplit[0]) > Integer.parseInt(strArrSplit[1])) {
                return 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public void u(JSONObject jSONObject) {
        try {
            jSONObject.put("playable_reward_type", this.u);
        } catch (JSONException unused) {
        }
    }

    public static int u(bc bcVar) {
        int i;
        cj cjVarFx = fx(bcVar);
        if (cjVarFx == null || (i = cjVarFx.u) < 0 || i > 1) {
            return 0;
        }
        if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.dw.nr().wi()) || bg.t(bcVar)) {
            return cjVarFx.u;
        }
        return 1;
    }
}
