package com.amap.api.col.p0002sl;

import com.amap.api.col.p0002sl.id;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class hc extends fy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f2858a;
    private String b;

    public hc(byte[] bArr, String str) {
        this.b = "1";
        this.f2858a = (byte[]) bArr.clone();
        this.b = str;
        a(id.a.SINGLE);
        a(id.c.HTTP);
    }

    @Override // com.amap.api.col.p0002sl.id
    public final boolean c_() {
        return false;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final Map<String, String> d() {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/zip");
        map.put("Content-Length", String.valueOf(this.f2858a.length));
        return map;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final Map<String, String> e() {
        return null;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        String strC = ge.c(go.b);
        byte[] bArrA = ge.a(go.f2837a);
        byte[] bArr = new byte[bArrA.length + 50];
        System.arraycopy(this.f2858a, 0, bArr, 0, 50);
        System.arraycopy(bArrA, 0, bArr, 50, bArrA.length);
        return String.format(strC, "1", this.b, "1", "open", fz.a(bArr));
    }

    @Override // com.amap.api.col.p0002sl.id
    public final byte[] h() {
        return this.f2858a;
    }
}
