package com.amap.api.col.p0002sl;

import com.amap.api.maps2d.model.LatLng;
import java.math.BigDecimal;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class co {
    public static LatLng a(LatLng latLng) {
        if (latLng != null) {
            return b(latLng);
        }
        return null;
    }

    private static double b(double d) {
        return Math.cos(d * 3000.0d * 0.017453292519943295d) * 3.0E-6d;
    }

    private static double c(double d) {
        return new BigDecimal(d).setScale(8, 4).doubleValue();
    }

    private static double a(double d) {
        return Math.sin(d * 3000.0d * 0.017453292519943295d) * 2.0E-5d;
    }

    private static LatLng b(LatLng latLng) {
        return c(latLng);
    }

    private static cp a(double d, double d2) {
        cp cpVar = new cp();
        double d3 = (d * d) + (d2 * d2);
        double dCos = (Math.cos(b(d) + Math.atan2(d2, d)) * (a(d2) + Math.sqrt(d3))) + 0.0065d;
        double dSin = (Math.sin(b(d) + Math.atan2(d2, d)) * (a(d2) + Math.sqrt(d3))) + 0.006d;
        cpVar.f2679a = c(dCos);
        cpVar.b = c(dSin);
        return cpVar;
    }

    private static LatLng c(LatLng latLng) {
        LatLng latLngA = null;
        double d = 0.006401062d;
        double d2 = 0.0060424805d;
        for (int i = 0; i < 2; i++) {
            latLngA = a(latLng.longitude, latLng.latitude, d, d2);
            d = latLng.longitude - latLngA.longitude;
            d2 = latLng.latitude - latLngA.latitude;
        }
        return latLngA;
    }

    private static LatLng a(double d, double d2, double d3, double d4) {
        cp cpVar = new cp();
        double d5 = d - d3;
        double d6 = d2 - d4;
        cp cpVarA = a(d5, d6);
        cpVar.f2679a = c((d + d5) - cpVarA.f2679a);
        cpVar.b = c((d2 + d6) - cpVarA.b);
        return new LatLng(cpVar.b, cpVar.f2679a);
    }
}
