package com.amap.api.col.p0002sl;

import com.amap.api.maps2d.model.LatLng;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class cq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static double f2680a = 3.141592653589793d;

    public static LatLng a(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return cr.a(c(latLng.longitude, latLng.latitude));
    }

    private static double b(double d, double d2) {
        return (Math.sin(d2 / 100000.0d) * (d / 18000.0d)) + (Math.cos(d / 100000.0d) * (d2 / 9000.0d));
    }

    private static LatLng c(double d, double d2) {
        double d3 = ((long) (d * 100000.0d)) % 36000000;
        double d4 = ((long) (d2 * 100000.0d)) % 36000000;
        double d5 = (int) ((-a(d3, d4)) + d3);
        double d6 = (int) ((-b(d3, d4)) + d4);
        double d7 = (int) ((-a(d5, d6)) + d3 + ((double) (d3 > 0.0d ? 1 : -1)));
        return new LatLng(((double) ((int) (((-b(d7, d6)) + d4) + ((double) (d4 <= 0.0d ? -1 : 1))))) / 100000.0d, d7 / 100000.0d);
    }

    private static double a(double d, double d2) {
        return (Math.cos(d2 / 100000.0d) * (d / 18000.0d)) + (Math.sin(d / 100000.0d) * (d2 / 9000.0d));
    }
}
