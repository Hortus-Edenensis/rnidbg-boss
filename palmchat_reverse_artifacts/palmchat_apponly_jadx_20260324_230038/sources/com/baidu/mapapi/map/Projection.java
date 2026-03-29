package com.baidu.mapapi.map;

import android.graphics.Point;
import android.graphics.PointF;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class Projection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.map.b f3682a;

    public Projection(com.baidu.mapsdkplatform.comapi.map.b bVar) {
        this.f3682a = bVar;
    }

    public LatLng fromScreenLocation(Point point) {
        com.baidu.mapsdkplatform.comapi.map.b bVar;
        if (point == null || (bVar = this.f3682a) == null) {
            return null;
        }
        return CoordUtil.mc2ll(bVar.a(point.x, point.y));
    }

    public Point geoPoint3toScreenLocation(LatLng latLng, int i) {
        if (latLng == null || this.f3682a == null || i < 0) {
            return null;
        }
        return this.f3682a.a(CoordUtil.ll2mc(latLng), i);
    }

    public float metersToEquatorPixels(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        return (float) (((double) f) / this.f3682a.E());
    }

    public PointF toOpenGLLocation(LatLng latLng, MapStatus mapStatus) {
        if (latLng == null || mapStatus == null) {
            return null;
        }
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLng);
        s sVar = mapStatus.c;
        return new PointF((float) (geoPointLl2mc.getLongitudeE6() - sVar.d), (float) (geoPointLl2mc.getLatitudeE6() - sVar.e));
    }

    public PointF toOpenGLNormalization(LatLng latLng, MapStatus mapStatus) {
        if (latLng == null || mapStatus == null) {
            return null;
        }
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLng);
        s.a aVar = mapStatus.c.k;
        return new PointF((float) ((((geoPointLl2mc.getLongitudeE6() - aVar.f3993a) * 2.0d) / Math.abs(aVar.b - aVar.f3993a)) - 1.0d), (float) ((((geoPointLl2mc.getLatitudeE6() - aVar.d) * 2.0d) / Math.abs(aVar.c - aVar.d)) - 1.0d));
    }

    public Point toScreenLocation(LatLng latLng) {
        if (latLng == null || this.f3682a == null) {
            return null;
        }
        return this.f3682a.a(CoordUtil.ll2mc(latLng));
    }
}
