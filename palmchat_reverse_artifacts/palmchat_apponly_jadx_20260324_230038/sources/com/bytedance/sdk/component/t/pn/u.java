package com.bytedance.sdk.component.t.pn;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static Map<String, Map<String, Object>> nr = new HashMap();
    private static volatile u u;

    private u() {
    }

    public static u u() {
        if (u != null) {
            return u;
        }
        synchronized (u.class) {
            if (u != null) {
                return u;
            }
            u uVar = new u();
            u = uVar;
            return uVar;
        }
    }

    public Map<String, Object> u(String str) {
        Map<String, Object> map = nr.get(str);
        if (map != null) {
            return map;
        }
        HashMap map2 = new HashMap();
        nr.put(str, map2);
        return map2;
    }
}
