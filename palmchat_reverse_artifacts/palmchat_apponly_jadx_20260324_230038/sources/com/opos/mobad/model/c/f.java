package com.opos.mobad.model.c;

import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class f extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, com.opos.mobad.i.a> f9071a;

    public ConcurrentHashMap<String, com.opos.mobad.i.a> a() {
        return this.f9071a;
    }

    public String toString() {
        return "FetchMaterialRequest{downloadRequestMap=" + this.f9071a + '}';
    }

    public void a(ConcurrentHashMap<String, com.opos.mobad.i.a> concurrentHashMap) {
        this.f9071a = concurrentHashMap;
    }
}
