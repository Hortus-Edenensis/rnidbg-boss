package com.bytedance.sdk.component.x.u;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    public Map<String, Object> nr(Map<String, Object> map, com.bytedance.sdk.component.b.nr.u uVar, boolean z) {
        if (uVar == null) {
            return map;
        }
        Map<String, Object> concurrentHashMap = z ? new ConcurrentHashMap<>() : map;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (z) {
                key = uVar.encrypt(key);
            }
            concurrentHashMap.put(key, uVar.encrypt(value.toString()));
        }
        return concurrentHashMap;
    }

    public Map<String, Object> u(Map<String, Object> map, com.bytedance.sdk.component.b.nr.u uVar, boolean z) {
        if (uVar == null) {
            return map;
        }
        Map<String, Object> concurrentHashMap = z ? new ConcurrentHashMap<>() : map;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (z) {
                key = uVar.decrypt(key);
            }
            concurrentHashMap.put(key, uVar.decrypt(value.toString()));
        }
        return concurrentHashMap;
    }
}
