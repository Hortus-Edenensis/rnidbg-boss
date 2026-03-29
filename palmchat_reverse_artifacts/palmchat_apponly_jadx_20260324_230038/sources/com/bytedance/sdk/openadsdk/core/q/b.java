package com.bytedance.sdk.openadsdk.core.q;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private static final Map<Integer, fx<?, ?>> u = new ConcurrentHashMap();

    public static fx<?, ?> u(int i) {
        Map<Integer, fx<?, ?>> map = u;
        fx<?, ?> uVar = map.get(Integer.valueOf(i));
        if (uVar != null) {
            return uVar;
        }
        if (i == 0) {
            uVar = new com.bytedance.sdk.openadsdk.core.q.u.u();
        } else if (i == 1) {
            uVar = new com.bytedance.sdk.openadsdk.core.q.u.nr();
        }
        if (uVar != null) {
            map.put(Integer.valueOf(i), uVar);
        }
        return uVar;
    }
}
