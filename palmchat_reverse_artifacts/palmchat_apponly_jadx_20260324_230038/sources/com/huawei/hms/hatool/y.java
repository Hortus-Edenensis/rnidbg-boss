package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class y {
    private static y b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Map<String, p0> f6797a = new HashMap();

    private y() {
    }

    private p0 a(String str) {
        if (!this.f6797a.containsKey(str)) {
            this.f6797a.put(str, new p0());
        }
        return this.f6797a.get(str);
    }

    private static synchronized void b() {
        if (b == null) {
            b = new y();
        }
    }

    public p0 a(String str, long j) {
        p0 p0VarA = a(str);
        p0VarA.a(j);
        return p0VarA;
    }

    public static y a() {
        if (b == null) {
            b();
        }
        return b;
    }
}
