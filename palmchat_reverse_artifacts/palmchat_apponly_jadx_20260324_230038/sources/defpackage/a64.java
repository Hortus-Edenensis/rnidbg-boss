package defpackage;

import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a64 {
    public static a64 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<String, ex4> f1160a = new ConcurrentHashMap<>();

    public static ex4 a(String str) {
        return b().f1160a.get(str);
    }

    public static a64 b() {
        if (b == null) {
            b = new a64();
        }
        return b;
    }
}
