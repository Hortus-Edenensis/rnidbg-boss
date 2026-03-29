package com.bytedance.sdk.openadsdk.core.bf.u;

import com.bytedance.sdk.openadsdk.core.dw;
import com.ss.android.download.api.constant.BaseConstants;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u {
    public boolean fx(int i) {
        return i == 2 || i == 3;
    }

    public boolean nr(int i) {
        return i == 0 || i == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int u(int i) {
        int iOptInt;
        JSONObject jSONObjectTr = dw.nr().tr();
        if (jSONObjectTr == null) {
            iOptInt = -1;
        } else if (nr(i)) {
            iOptInt = jSONObjectTr.optInt("explicit_interval", 0);
        } else if (fx(i)) {
            iOptInt = jSONObjectTr.optInt("ambiguous_interval", 0);
        }
        return iOptInt > 86400000 ? BaseConstants.Time.DAY : iOptInt;
    }

    public void u(int i, long j, long j2) {
        com.bytedance.sdk.openadsdk.core.bf.u uVarU = com.bytedance.sdk.openadsdk.core.bf.u.u();
        uVarU.u(i);
        uVarU.u(j, j2);
    }

    public int u(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("delay", 200);
        }
        return 200;
    }
}
