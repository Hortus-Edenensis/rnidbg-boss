package com.amap.api.col.p0002sl;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ServiceInfo;
import com.amap.api.location.AMapLocationClient;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationManagerBase;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationOption;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class cu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f2682a;
    Inner_3dMap_locationManagerBase b = null;
    Object c = null;
    boolean d = false;
    ms e;
    gd f;

    public cu(Context context) {
        this.e = null;
        this.f = null;
        try {
            this.f = nb.a();
        } catch (Throwable unused) {
        }
        this.e = new ms();
        a(context);
    }

    private static Inner_3dMap_locationManagerBase b(Context context) {
        Inner_3dMap_locationManagerBase muVar;
        try {
            ge.c("YY29tLmFtYXAuYXBpLndyYXBwZXIuSW5uZXJfM2RNYXBfbG9jYXRpb25NYW5hZ2VyV3JhcHBlcg==");
            muVar = (Inner_3dMap_locationManagerBase) hl.a();
        } catch (Throwable unused) {
            muVar = new mu(context);
        }
        return muVar == null ? new mu(context) : muVar;
    }

    public final void a() {
        try {
            if (this.d) {
                ((AMapLocationClient) this.c).startLocation();
            } else {
                this.b.startLocation();
            }
        } catch (Throwable th) {
            nl.a(th, "AMapLocationClient", "startLocation");
        }
    }

    public final void c() {
        try {
            if (this.d) {
                ((AMapLocationClient) this.c).onDestroy();
            } else {
                this.b.destroy();
            }
            if (this.e != null) {
                this.e = null;
            }
        } catch (Throwable th) {
            nl.a(th, "AMapLocationClient", "onDestroy");
        }
    }

    private void a(Context context) {
        ServiceInfo serviceInfo;
        try {
            if (context == null) {
                throw new IllegalArgumentException("Context参数不能为null");
            }
            this.f2682a = context.getApplicationContext();
            try {
                try {
                    serviceInfo = this.f2682a.getPackageManager().getServiceInfo(new ComponentName(this.f2682a, "com.amap.api.location.APSService"), 128);
                } catch (Throwable unused) {
                    serviceInfo = null;
                }
                if (serviceInfo != null) {
                    this.d = true;
                }
            } catch (Throwable unused2) {
                this.d = false;
            }
            if (this.d) {
                this.c = new AMapLocationClient(this.f2682a);
            } else {
                this.b = b(this.f2682a);
            }
        } catch (Throwable th) {
            nl.a(th, "AMapLocationClient", "AMapLocationClient 1");
        }
    }

    public final void b() {
        try {
            if (this.d) {
                ((AMapLocationClient) this.c).stopLocation();
            } else {
                this.b.stopLocation();
            }
        } catch (Throwable th) {
            nl.a(th, "AMapLocationClient", "stopLocation");
        }
    }

    public final void a(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        try {
            if (this.d) {
                this.e.a(this.c, inner_3dMap_locationListener);
            } else {
                this.b.setLocationListener(inner_3dMap_locationListener);
            }
        } catch (Throwable th) {
            nl.a(th, "AMapLocationClient", "setLocationListener");
        }
    }

    public final void a(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        try {
            if (inner_3dMap_locationOption == null) {
                throw new IllegalArgumentException("LocationManagerOption参数不能为null");
            }
            if (this.d) {
                ms.a(this.c, inner_3dMap_locationOption);
            } else {
                this.b.setLocationOption(inner_3dMap_locationOption);
            }
        } catch (Throwable th) {
            nl.a(th, "AMapLocationClient", "setLocationOption");
        }
    }
}
