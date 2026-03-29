package com.vivo.push.restructure.request;

import com.vivo.push.restructure.request.a.a.b;
import com.vivo.push.util.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class b<I extends com.vivo.push.restructure.request.a.a.b, O extends com.vivo.push.restructure.request.a.a.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a<I, O> f11277a;
    private c<O> b;
    private long c;

    private b(a<I, O> aVar) {
        this.c = 5000L;
        this.f11277a = aVar;
        if (aVar == null) {
            t.a(8100, "Command object is null, please construct command first");
        }
    }

    public final a a() {
        return this.f11277a;
    }

    public final c b() {
        return this.b;
    }

    public final long c() {
        return this.c;
    }

    private b(a<I, O> aVar, c<O> cVar) {
        this(aVar);
        this.b = cVar;
    }

    public b(a<I, O> aVar, c<O> cVar, byte b) {
        this(aVar, cVar);
        this.c = 20000L;
    }
}
