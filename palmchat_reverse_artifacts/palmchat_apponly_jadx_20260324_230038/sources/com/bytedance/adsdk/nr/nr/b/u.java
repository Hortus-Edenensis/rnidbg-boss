package com.bytedance.adsdk.nr.nr.b;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public enum u implements pn {
    TRUE,
    FALSE,
    NULL;

    private static final Map<String, u> b = new HashMap(128);

    static {
        for (u uVar : values()) {
            b.put(uVar.name().toLowerCase(), uVar);
        }
    }

    public static u u(String str) {
        return b.get(str.toLowerCase());
    }
}
