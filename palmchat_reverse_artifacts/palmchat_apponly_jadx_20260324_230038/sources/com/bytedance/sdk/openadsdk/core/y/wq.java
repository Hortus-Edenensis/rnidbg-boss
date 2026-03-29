package com.bytedance.sdk.openadsdk.core.y;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class wq<K, V> extends HashMap<K, V> {
    /* JADX WARN: Multi-variable type inference failed */
    public wq<String, Object> u(K k, V v) {
        put(k, v);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public wq<String, Object> u(Map<? extends K, ? extends V> map) {
        putAll(map);
        return this;
    }
}
