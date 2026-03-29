package com.bytedance.adsdk.nr.nr.nr.u;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends o {
    public b() {
        super(com.bytedance.adsdk.nr.nr.b.fx.EQ);
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public Object u(Map<String, JSONObject> map) {
        Object objU = this.u.u(map);
        Object objU2 = this.nr.u(map);
        return (objU == null && objU2 == null) ? Boolean.TRUE : (objU != null || objU2 == null) ? (objU == null || objU2 != null) ? ((objU instanceof Number) && (objU2 instanceof Number)) ? Boolean.valueOf(com.bytedance.adsdk.nr.nr.pn.u.nr.u((Number) objU, (Number) objU2)) : Boolean.valueOf(objU.equals(objU2)) : Boolean.FALSE : Boolean.FALSE;
    }
}
