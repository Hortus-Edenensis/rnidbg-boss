package com.bytedance.adsdk.ugeno.pn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {
    private static Map<String, nr> u = new HashMap();

    public static void u(List<nr> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (nr nrVar : list) {
            if (nrVar != null) {
                u.put(nrVar.u(), nrVar);
            }
        }
    }

    public static nr u(String str) {
        return u.get(str);
    }
}
