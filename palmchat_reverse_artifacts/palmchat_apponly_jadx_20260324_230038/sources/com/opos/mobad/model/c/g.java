package com.opos.mobad.model.c;

import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class g extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, com.opos.mobad.i.b> f9072a = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, com.opos.mobad.i.b> a() {
        return this.f9072a;
    }

    public String toString() {
        return "FetchMaterialResponse{downloadResponseMap=" + this.f9072a + '}';
    }

    public void a(String str, com.opos.mobad.i.b bVar) {
        this.f9072a.put(str, bVar);
    }
}
