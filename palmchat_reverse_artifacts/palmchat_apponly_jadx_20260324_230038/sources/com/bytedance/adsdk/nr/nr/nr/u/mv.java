package com.bytedance.adsdk.nr.nr.nr.u;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class mv extends o {
    public mv() {
        super(com.bytedance.adsdk.nr.nr.b.fx.MULTI);
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public Object u(Map<String, JSONObject> map) {
        Object objU;
        Object objU2 = this.u.u(map);
        if (objU2 == null || (objU = this.nr.u(map)) == null) {
            return null;
        }
        return com.bytedance.adsdk.nr.nr.pn.u.x.u((Number) objU2, (Number) objU);
    }
}
