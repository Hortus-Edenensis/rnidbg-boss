package com.bytedance.adsdk.nr.nr.nr.u;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class s extends o {
    public s() {
        super(com.bytedance.adsdk.nr.nr.b.fx.NOT_EQ);
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public Object u(Map<String, JSONObject> map) {
        Object objU = this.u.u(map);
        Object objU2 = this.nr.u(map);
        return (objU == null && objU2 == null) ? Boolean.FALSE : (objU != null || objU2 == null) ? (objU == null || objU2 != null) ? ((objU instanceof Number) && (objU2 instanceof Number)) ? Boolean.valueOf(!com.bytedance.adsdk.nr.nr.pn.u.nr.u((Number) objU, (Number) objU2)) : Boolean.valueOf(!objU.equals(objU2)) : Boolean.TRUE : Boolean.TRUE;
    }
}
