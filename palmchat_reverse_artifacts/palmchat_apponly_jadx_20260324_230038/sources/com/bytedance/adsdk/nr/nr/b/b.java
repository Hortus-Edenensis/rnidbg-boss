package com.bytedance.adsdk.nr.nr.b;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public enum b implements pn {
    LEFT_PAREN("("),
    RIGHT_PAREN(")"),
    LEFT_BRACKET("["),
    RIGHT_BRACKET("]"),
    COMMA(",");

    private static final Map<String, b> iz;
    private final String x;

    static {
        HashMap map = new HashMap(128);
        iz = map;
        for (b bVar : map.values()) {
            iz.put(bVar.u(), bVar);
        }
    }

    b(String str) {
        this.x = str;
    }

    public static boolean u(pn pnVar) {
        return pnVar instanceof b;
    }

    public String u() {
        return this.x;
    }
}
