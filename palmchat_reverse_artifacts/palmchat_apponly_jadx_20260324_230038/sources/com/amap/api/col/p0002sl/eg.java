package com.amap.api.col.p0002sl;

import com.baidu.platform.comapi.map.MapBundleKey;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class eg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f2722a = false;

    public static synchronized void a() {
        if (!f2722a) {
            eh.a().a("regeo", new ej("/geocode/regeo"));
            eh.a().a("placeAround", new ej("/place/around"));
            eh.a().a("placeText", new ei("/place/text"));
            eh.a().a(MapBundleKey.MapObjKey.OBJ_GEO, new ei("/geocode/geo"));
            f2722a = true;
        }
    }
}
