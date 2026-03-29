package com.zm.adxsdk.protocol.bridge;

import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class AdxSdkBridge {
    private static final ConcurrentHashMap<Class<?>, Object> bridgeCache = new ConcurrentHashMap<>();

    private AdxSdkBridge() {
    }

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
