package com.bytedance.adsdk.ugeno.pn.u;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u {
    private volatile Map<String, fx> u = new HashMap();

    public fx u(String str) {
        if (this.u.containsKey(str) && this.u.get(str) != null) {
            return this.u.get(str);
        }
        nr nrVar = new nr();
        this.u.put(str, nrVar);
        return nrVar;
    }

    public void u(String str, fx fxVar) {
        if (!this.u.containsKey(str) || this.u.get(str) == null) {
            this.u.put(str, fxVar);
        }
    }
}
