package com.bytedance.adsdk.nr.nr.nr.u;

import com.huawei.hms.ads.ex;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class x implements com.bytedance.adsdk.nr.nr.nr.u {
    private final Object u;

    public x(String str) {
        if (str.equalsIgnoreCase(ex.Code)) {
            this.u = Boolean.TRUE;
        } else if (str.equalsIgnoreCase(ex.V)) {
            this.u = Boolean.FALSE;
        } else {
            if (!str.equalsIgnoreCase(com.igexin.push.core.b.m)) {
                throw new IllegalArgumentException();
            }
            this.u = null;
        }
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public String nr() {
        Object obj = this.u;
        return obj != null ? obj.toString() : "NULL";
    }

    public String toString() {
        return "KeywordNode [keywordValue=" + this.u + "]";
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public Object u(Map<String, JSONObject> map) {
        return this.u;
    }

    @Override // com.bytedance.adsdk.nr.nr.nr.u
    public com.bytedance.adsdk.nr.nr.b.pn u() {
        return com.bytedance.adsdk.nr.nr.b.iz.CONSTANT;
    }
}
