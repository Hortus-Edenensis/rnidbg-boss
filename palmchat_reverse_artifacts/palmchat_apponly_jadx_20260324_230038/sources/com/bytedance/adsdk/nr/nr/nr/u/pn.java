package com.bytedance.adsdk.nr.nr.nr.u;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class pn extends o {
    public pn() {
        super(com.bytedance.adsdk.nr.nr.b.fx.GT_EQ);
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public Object u(Map<String, JSONObject> map) {
        Object objU;
        if (this.u.u(map) == null || (objU = this.nr.u(map)) == null) {
            return null;
        }
        return Boolean.valueOf(!((Boolean) com.bytedance.adsdk.nr.nr.pn.u.b.u(r0, (Number) objU)).booleanValue());
    }
}
