package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Handler;
import com.ss.android.ttvecamera.TECameraResult;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class lq extends li<kr> {
    public lq(Context context, String str, Handler handler) {
        super(context, str, handler);
    }

    @Override // com.amap.api.col.p0002sl.li
    public final /* bridge */ /* synthetic */ void a(kr krVar, long j) {
        a2(krVar, j);
    }

    @Override // com.amap.api.col.p0002sl.li
    public final /* synthetic */ String b(kr krVar) {
        return a(krVar);
    }

    @Override // com.amap.api.col.p0002sl.li
    public final /* synthetic */ int c(kr krVar) {
        return b2(krVar);
    }

    @Override // com.amap.api.col.p0002sl.li
    public final /* synthetic */ long d(kr krVar) {
        return c2(krVar);
    }

    private static String a(kr krVar) {
        return krVar == null ? "" : krVar.a();
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    private static int b2(kr krVar) {
        return krVar == null ? TECameraResult.TER_CLOSE_CALLED : krVar.c;
    }

    /* JADX INFO: renamed from: c, reason: avoid collision after fix types in other method */
    private static long c2(kr krVar) {
        if (krVar == null) {
            return 0L;
        }
        return krVar.f;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(kr krVar, long j) {
        if (krVar != null) {
            krVar.f = j;
        }
    }

    @Override // com.amap.api.col.p0002sl.li
    public final long b() {
        return lf.e;
    }

    @Override // com.amap.api.col.p0002sl.li
    public final long c() {
        return lf.f;
    }
}
