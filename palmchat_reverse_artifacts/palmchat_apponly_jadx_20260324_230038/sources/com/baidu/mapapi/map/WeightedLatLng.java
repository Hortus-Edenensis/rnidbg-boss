package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.map.e;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class WeightedLatLng extends e.a {
    public static final double DEFAULT_INTENSITY = 1.0d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Point f3720a;
    public final double intensity;
    public final LatLng mLatLng;

    public WeightedLatLng(LatLng latLng, double d) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: latLng can not be null");
        }
        this.mLatLng = latLng;
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLng);
        this.f3720a = new Point((int) geoPointLl2mc.getLongitudeE6(), (int) geoPointLl2mc.getLatitudeE6());
        if (d > 0.0d) {
            this.intensity = d;
        } else {
            this.intensity = 1.0d;
        }
    }

    public double getIntensity() {
        return this.intensity;
    }

    @Override // com.baidu.mapapi.map.e.a
    public Point getPoint() {
        return this.f3720a;
    }

    public WeightedLatLng(LatLng latLng) {
        this(latLng, 1.0d);
    }
}
