package com.bytedance.adsdk.nr.nr.nr.u;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class n extends o {
    public n() {
        super(com.bytedance.adsdk.nr.nr.b.fx.LT_EQ);
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public Object u(Map<String, JSONObject> map) {
        Object objU;
        if (this.u.u(map) == null || (objU = this.nr.u(map)) == null) {
            return null;
        }
        return Boolean.valueOf(!((Boolean) com.bytedance.adsdk.nr.nr.pn.u.fx.u(r0, (Number) objU)).booleanValue());
    }
}
