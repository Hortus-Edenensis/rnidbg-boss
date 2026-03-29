package com.igexin.push.core.i;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class b {
    private static b b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<Long, a> f7285a = new HashMap();

    private b() {
    }

    private void b(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    private void c(a aVar) {
        if (aVar != null) {
            this.f7285a.put(aVar.a(), aVar);
        }
    }

    public final a a(Long l) {
        return this.f7285a.get(l);
    }

    public static b a() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.f7285a.remove(aVar.a());
        }
    }
}
