package com.amap.api.col.p0002sl;

import com.amap.api.location.AMapLocation;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@hi(a = "c")
public class lv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hj(a = "a2", b = 6)
    private String f2982a;

    @hj(a = "a3", b = 5)
    private long b;

    @hj(a = "a4", b = 6)
    private String c;
    private AMapLocation d;

    public final AMapLocation a() {
        return this.d;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.f2982a;
    }

    public final long d() {
        return this.b;
    }

    public final void a(AMapLocation aMapLocation) {
        this.d = aMapLocation;
    }

    public final void b(String str) {
        this.f2982a = str;
    }

    public final void a(String str) {
        this.c = str;
    }

    public final void a(long j) {
        this.b = j;
    }
}
