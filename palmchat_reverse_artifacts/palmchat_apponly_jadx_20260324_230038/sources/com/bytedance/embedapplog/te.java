package com.bytedance.embedapplog;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class te {
    private static final hs u = new hs();
    private static final Map<String, String> nr = new ConcurrentHashMap();

    public static String u(String str) {
        Map<String, String> map = nr;
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        String strU = u.u(str);
        if (strU != null) {
            map.put(str, strU);
        }
        return strU;
    }
}
