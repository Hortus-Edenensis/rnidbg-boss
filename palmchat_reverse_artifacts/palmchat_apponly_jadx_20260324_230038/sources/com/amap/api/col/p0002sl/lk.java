package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Handler;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class lk extends li<ll> {
    public lk(Context context, String str, Handler handler) {
        super(context, str, handler);
    }

    @Override // com.amap.api.col.p0002sl.li
    public final /* bridge */ /* synthetic */ void a(ll llVar, long j) {
        a2(llVar, j);
    }

    @Override // com.amap.api.col.p0002sl.li
    public final /* synthetic */ String b(ll llVar) {
        return a(llVar);
    }

    @Override // com.amap.api.col.p0002sl.li
    public final /* synthetic */ int c(ll llVar) {
        return b2(llVar);
    }

    @Override // com.amap.api.col.p0002sl.li
    public final /* synthetic */ long d(ll llVar) {
        return c2(llVar);
    }

    private static String a(ll llVar) {
        return llVar == null ? "" : llVar.b();
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    private static int b2(ll llVar) {
        if (llVar == null) {
            return 99;
        }
        return llVar.s;
    }

    /* JADX INFO: renamed from: c, reason: avoid collision after fix types in other method */
    private static long c2(ll llVar) {
        if (llVar == null) {
            return 0L;
        }
        return llVar.t;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(ll llVar, long j) {
        if (llVar != null) {
            llVar.t = j;
        }
    }

    @Override // com.amap.api.col.p0002sl.li
    public final long b() {
        return lf.g;
    }

    @Override // com.amap.api.col.p0002sl.li
    public final long c() {
        return lf.h;
    }
}
