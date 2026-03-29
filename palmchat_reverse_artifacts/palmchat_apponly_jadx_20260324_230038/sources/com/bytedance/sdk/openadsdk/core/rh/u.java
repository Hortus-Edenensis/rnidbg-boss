package com.bytedance.sdk.openadsdk.core.rh;

import com.bytedance.sdk.openadsdk.core.y.bf;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static volatile u u;
    private Map<String, nr> nr = new HashMap();

    private u() {
        u(com.bytedance.sdk.openadsdk.core.rh.fx.u.fx());
        u(com.bytedance.sdk.openadsdk.core.rh.u.u.u());
        u(com.bytedance.sdk.openadsdk.core.rh.b.u.fx());
        u(com.bytedance.sdk.openadsdk.core.rh.pn.u.u());
        u(com.bytedance.sdk.openadsdk.core.s.nr.u());
    }

    public static u u() {
        if (u == null) {
            synchronized (u.class) {
                if (u == null) {
                    u = new u();
                }
            }
        }
        return u;
    }

    private void u(nr nrVar) {
        this.nr.put(nrVar.nr(), nrVar);
    }

    public String u(String str, String str2) {
        if (this.nr.containsKey(str)) {
            return this.nr.get(str).u(str2);
        }
        return bf.u(str).get(str2, "");
    }

    public void u(String str, String str2, String str3) {
        if (this.nr.containsKey(str)) {
            this.nr.get(str).u(str2, str3);
        } else {
            bf.u(str).put(str2, str3);
        }
    }
}
