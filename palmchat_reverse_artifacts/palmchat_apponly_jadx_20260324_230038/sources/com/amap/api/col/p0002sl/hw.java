package com.amap.api.col.p0002sl;

import com.amap.api.col.p0002sl.id;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class hw extends id {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f2879a;
    private Map<String, String> b;

    public hw(byte[] bArr, Map<String, String> map) {
        this.f2879a = bArr;
        this.b = map;
        a(id.a.SINGLE);
        a(id.c.HTTPS);
    }

    @Override // com.amap.api.col.p0002sl.id
    public final Map<String, String> d() {
        return null;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final Map<String, String> e() {
        return this.b;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return "https://adiu.amap.com/ws/device/adius";
    }

    @Override // com.amap.api.col.p0002sl.id
    public final byte[] h() {
        return this.f2879a;
    }
}
