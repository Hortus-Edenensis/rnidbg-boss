package com.bytedance.adsdk.ugeno.pn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class jk {
    private static Map<String, x> u = new HashMap();

    public static void u(List<x> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (x xVar : list) {
            if (xVar != null) {
                u.put(xVar.u(), xVar);
            }
        }
    }

    public static x u(String str) {
        return u.get(str);
    }
}
