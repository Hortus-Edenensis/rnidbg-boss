package com.bytedance.sdk.component.t.x;

import com.bytedance.sdk.component.t.b.b;
import com.bytedance.sdk.component.t.u.nr;
import com.bytedance.sdk.component.t.u.u.fx;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static volatile u nr;
    private Map<String, com.bytedance.sdk.component.t.u.u.u> u = new HashMap();

    private u() {
    }

    public static u u() {
        if (nr != null) {
            return nr;
        }
        synchronized (u.class) {
            if (nr != null) {
                return nr;
            }
            u uVar = new u();
            nr = uVar;
            return uVar;
        }
    }

    public void u(String str, com.bytedance.sdk.component.t.u.u.u uVar) {
        this.u.put(str, uVar);
    }

    public void u(String str, com.bytedance.sdk.component.t.u.u uVar, com.bytedance.sdk.component.t.b.u uVar2) {
        com.bytedance.sdk.component.t.u.u.u uVarU = this.u.get(str);
        if (uVarU == null || uVar == null) {
            return;
        }
        Map<String, Object> mapU = uVar.u();
        b bVarPn = uVar.pn();
        if (bVarPn instanceof nr) {
            Map<String, Object> mapU2 = com.bytedance.sdk.component.t.pn.u.u().u(String.valueOf(bVarPn.hashCode()));
            mapU.putAll(mapU2);
            mapU2.clear();
            com.bytedance.sdk.component.t.iz.u uVarU2 = com.bytedance.sdk.component.t.iz.u.u();
            uVarU = uVarU2.u(uVarU);
            HashMap map = new HashMap();
            map.putAll(uVar.nr());
            map.putAll(mapU);
            uVarU2.u(uVarU, map);
        }
        if (uVarU instanceof fx) {
            ((fx) uVarU).u(uVar.nr(), uVar.u(), uVar);
        } else if (uVarU instanceof com.bytedance.sdk.component.t.u.u.nr) {
            ((com.bytedance.sdk.component.t.u.u.nr) uVarU).u(uVar.nr(), uVar.u(), uVar);
        }
    }
}
