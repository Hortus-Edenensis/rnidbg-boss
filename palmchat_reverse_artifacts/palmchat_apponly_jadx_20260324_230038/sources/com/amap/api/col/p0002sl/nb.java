package com.amap.api.col.p0002sl;

import com.amap.api.col.p0002sl.gd;
import com.amap.api.maps2d.MapsInitializer;
import com.autonavi.amap.mapcore2d.Inner_3dMap_location;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class nb {
    private static final String[] b = {"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"};
    private static final String[] c = {"com.amap.api.mapcore2d", "com.amap.api.maps2d"};
    private static final String[] d = {"com.amap.trace"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static gd f3026a = null;

    public static gd a() throws fq {
        Class<?> cls;
        Class<?> cls2;
        gd gdVar = f3026a;
        if (gdVar != null) {
            return gdVar;
        }
        try {
            cls = Class.forName("com.amap.api.maps.MapsInitializer");
        } catch (Throwable unused) {
            cls = null;
        }
        try {
            if (cls != null) {
                String str = (String) nn.a(cls, "getVersion", (Object[]) null, (Class<?>[]) null);
                f3026a = new gd.a("3dmap", str, "AMAP_SDK_Android_Map_".concat(String.valueOf(str))).a(b).a();
            } else {
                String str2 = MapsInitializer.sdcardDir;
                try {
                    String str3 = (String) nn.a((Class<?>) MapsInitializer.class, "getVersion", (Object[]) null, (Class<?>[]) null);
                    f3026a = new gd.a("2dmap", str3, "AMAP_SDK_Android_2DMap_".concat(String.valueOf(str3))).a(c).a();
                } catch (Throwable unused2) {
                }
                cls = MapsInitializer.class;
            }
        } catch (Throwable unused3) {
        }
        if (cls == null) {
            try {
                cls2 = Class.forName("com.amap.trace.AMapTraceClient");
            } catch (Throwable unused4) {
                cls2 = null;
            }
            if (cls2 != null) {
                try {
                    String str4 = (String) nn.a(cls2, "getVersion", (Object[]) null, (Class<?>[]) null);
                    f3026a = new gd.a("trace", str4, "AMAP_TRACE_Android_".concat(String.valueOf(str4))).a(d).a();
                } catch (Throwable unused5) {
                }
            }
        }
        return f3026a;
    }

    public static boolean a(mx mxVar) {
        if (mxVar == null || mxVar.d().equals("8") || mxVar.d().equals("5") || mxVar.d().equals("6")) {
            return false;
        }
        return a((Inner_3dMap_location) mxVar);
    }

    public static boolean a(Inner_3dMap_location inner_3dMap_location) {
        double longitude = inner_3dMap_location.getLongitude();
        double latitude = inner_3dMap_location.getLatitude();
        return !(longitude == 0.0d && latitude == 0.0d) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d;
    }
}
