package com.tide.protocol.bridge;

import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TideProtocolBridge {
    private static final ConcurrentHashMap<Class<?>, Object> bridgeCache = new ConcurrentHashMap<>();

    public static <T> T getService(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        return (T) bridgeCache.get(cls);
    }

    public static <T> void putService(Class<T> cls, T t) {
        if (cls == null || t == null) {
            return;
        }
        bridgeCache.putIfAbsent(cls, t);
    }
}
