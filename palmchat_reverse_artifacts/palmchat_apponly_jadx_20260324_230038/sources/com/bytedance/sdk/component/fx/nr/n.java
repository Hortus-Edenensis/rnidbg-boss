package com.bytedance.sdk.component.fx.nr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f5125a;
    public static final n b;
    public static final n fx;
    public static final n iz;
    public static final n jk;
    public static final n k;
    public static final n l;
    public static final n mv;
    public static final n my;
    public static final n n;
    public static final n nr;
    public static final n pn;
    public static final n s;
    private static final Map<String, n> sx;
    public static final n t;
    static final Comparator<String> u;
    public static final n x;
    final String o;

    static {
        Comparator<String> comparator = new Comparator<String>() { // from class: com.bytedance.sdk.component.fx.nr.n.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public int compare(String str, String str2) {
                int iMin = Math.min(str.length(), str2.length());
                for (int i = 4; i < iMin; i++) {
                    char cCharAt = str.charAt(i);
                    char cCharAt2 = str2.charAt(i);
                    if (cCharAt != cCharAt2) {
                        return cCharAt < cCharAt2 ? -1 : 1;
                    }
                }
                int length = str.length();
                int length2 = str2.length();
                if (length != length2) {
                    return length < length2 ? -1 : 1;
                }
                return 0;
            }
        };
        u = comparator;
        sx = new TreeMap(comparator);
        nr = u("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        fx = u("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        b = u("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        pn = u("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        iz = u("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        x = u("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        n = u("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        f5125a = u("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        jk = u("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        t = u("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        l = u("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        mv = u("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        s = u("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        k = u("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        my = u("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    }

    private n(String str) {
        str.getClass();
        this.o = str;
    }

    public static synchronized n u(String str) {
        n nVar;
        Map<String, n> map = sx;
        nVar = map.get(str);
        if (nVar == null) {
            nVar = new n(str);
            map.put(str, nVar);
        }
        return nVar;
    }

    public String toString() {
        return this.o;
    }

    public static List<n> u(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(u(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static n u(String str, int i) {
        return u(str);
    }

    public String u() {
        return this.o;
    }
}
