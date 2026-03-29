package com.cmic.sso.sdk.e;

import com.cmic.sso.sdk.auth.TokenListener;
import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, TokenListener> f5519a = new ConcurrentHashMap<>(16);

    public static boolean a(String str) {
        return !f5519a.containsKey(str);
    }

    public static void b(String str) {
        f5519a.remove(str);
    }

    public static TokenListener c(String str) {
        return f5519a.get(str);
    }

    public static void a(String str, TokenListener tokenListener) {
        f5519a.put(str, tokenListener);
    }
}
