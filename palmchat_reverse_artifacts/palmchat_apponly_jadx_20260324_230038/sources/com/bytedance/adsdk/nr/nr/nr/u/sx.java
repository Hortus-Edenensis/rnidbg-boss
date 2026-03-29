package com.bytedance.adsdk.nr.nr.nr.u;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class sx extends o {
    private static final ThreadLocal<StringBuilder> b = new ThreadLocal<StringBuilder>() { // from class: com.bytedance.adsdk.nr.nr.nr.u.sx.1
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    };

    public sx() {
        super(com.bytedance.adsdk.nr.nr.b.fx.PLUS);
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public Object u(Map<String, JSONObject> map) {
        Object objU;
        Object objU2 = this.u.u(map);
        if (objU2 == null || (objU = this.nr.u(map)) == null) {
            return null;
        }
        if (!(objU2 instanceof String) && !(objU instanceof String)) {
            return com.bytedance.adsdk.nr.nr.pn.u.n.u((Number) objU2, (Number) objU);
        }
        StringBuilder sb = b.get();
        sb.append(objU2);
        sb.append(objU);
        String string = sb.toString();
        sb.setLength(0);
        return string;
    }
}
