package com.amap.api.col.p0002sl;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
final class gf extends id {
    private String b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, String> f2826a = new HashMap();
    private Map<String, String> c = new HashMap();

    public final void a(Map<String, String> map) {
        this.f2826a.clear();
        this.f2826a.putAll(map);
    }

    public final void b(Map<String, String> map) {
        this.c.clear();
        this.c.putAll(map);
    }

    @Override // com.amap.api.col.p0002sl.id
    public final Map<String, String> d() {
        return this.f2826a;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final Map<String, String> e() {
        return this.c;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }
}
