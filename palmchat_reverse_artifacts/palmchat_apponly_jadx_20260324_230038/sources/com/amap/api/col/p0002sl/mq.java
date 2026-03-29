package com.amap.api.col.p0002sl;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.autonavi.amap.mapcore2d.Inner_3dMap_location;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationListener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class mq implements AMapLocationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Inner_3dMap_locationListener f3009a = null;

    public final void a(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        this.f3009a = inner_3dMap_locationListener;
    }

    @Override // com.amap.api.location.AMapLocationListener
    public final void onLocationChanged(AMapLocation aMapLocation) {
        try {
            Inner_3dMap_location inner_3dMap_locationA = ms.a(aMapLocation);
            if (nb.a(inner_3dMap_locationA)) {
                ms.f3012a = inner_3dMap_locationA;
            }
            Inner_3dMap_locationListener inner_3dMap_locationListener = this.f3009a;
            if (inner_3dMap_locationListener != null) {
                inner_3dMap_locationListener.onLocationChanged(inner_3dMap_locationA);
            }
        } catch (Throwable th) {
            nl.a(th, "LocationListener", "onLocationChanged");
        }
    }
}
