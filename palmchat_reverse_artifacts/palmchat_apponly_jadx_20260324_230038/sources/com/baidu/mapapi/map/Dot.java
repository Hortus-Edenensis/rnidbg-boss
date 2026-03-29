package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class Dot extends Overlay {
    LatLng g;
    int h;
    int i;

    public Dot() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.dot;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.g);
        bundle.putDouble("location_x", geoPointLl2mc.getLongitudeE6());
        bundle.putDouble("location_y", geoPointLl2mc.getLatitudeE6());
        bundle.putInt("radius", this.i);
        Overlay.d(this.h, bundle);
        return bundle;
    }

    public LatLng getCenter() {
        return this.g;
    }

    public int getColor() {
        return this.h;
    }

    public int getRadius() {
        return this.i;
    }

    public void setCenter(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: dot center can not be null");
        }
        this.g = latLng;
        this.listener.c(this);
    }

    public void setColor(int i) {
        this.h = i;
        this.listener.c(this);
    }

    public void setRadius(int i) {
        if (i > 0) {
            this.i = i;
            this.listener.c(this);
        }
    }
}
