package com.amap.api.col.p0002sl;

import com.amap.api.maps2d.model.LatLng;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class cr {
    public static LatLng a(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        if (!cs.a(latLng.latitude, latLng.longitude)) {
            return latLng;
        }
        double[] dArrA = mn.a(latLng.longitude, latLng.latitude);
        return new LatLng(dArrA[1], dArrA[0]);
    }
}
