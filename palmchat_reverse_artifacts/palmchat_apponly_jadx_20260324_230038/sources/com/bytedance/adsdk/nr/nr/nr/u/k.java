package com.bytedance.adsdk.nr.nr.nr.u;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class k implements com.bytedance.adsdk.nr.nr.nr.u {
    private Number u;

    public k(String str) {
        if (str.indexOf(46) < 0) {
            try {
                this.u = Integer.valueOf(str);
            } catch (NumberFormatException unused) {
                this.u = Long.valueOf(str);
            }
        } else {
            Float fValueOf = Float.valueOf(str);
            this.u = fValueOf;
            if (Float.isInfinite(fValueOf.floatValue())) {
                this.u = Double.valueOf(str);
            }
        }
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public String nr() {
        return this.u.toString();
    }

    public String toString() {
        return nr();
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public Object u(Map<String, JSONObject> map) {
        return this.u;
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public com.bytedance.adsdk.nr.nr.b.pn u() {
        return com.bytedance.adsdk.nr.nr.b.iz.NUMBER;
    }
}
