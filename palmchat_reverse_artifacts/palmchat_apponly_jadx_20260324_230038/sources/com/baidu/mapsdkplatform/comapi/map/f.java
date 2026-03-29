package com.baidu.mapsdkplatform.comapi.map;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.Point;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class f {
    private static double a(double d) {
        return (d / 3.141592653589793d) * 180.0d;
    }

    private static double b(double d) {
        return (d * 3.141592653589793d) / 180.0d;
    }

    public static double c(LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null) {
            Point pointLl2point = CoordUtil.ll2point(latLng);
            Point pointLl2point2 = CoordUtil.ll2point(latLng2);
            if (pointLl2point != null && pointLl2point2 != null) {
                return CoordUtil.getDistance(pointLl2point, pointLl2point2);
            }
        }
        return -1.0d;
    }

    private static double a(LatLng latLng, LatLng latLng2) {
        double dB = b(latLng.latitude);
        double dB2 = b(latLng2.latitude);
        double dB3 = b(latLng.longitude);
        return Math.acos((Math.sin(dB) * Math.sin(dB2)) + (Math.cos(dB) * Math.cos(dB2) * Math.cos(Math.abs(b(latLng2.longitude) - dB3))));
    }

    public static List<LatLng> b(LatLng latLng, LatLng latLng2) {
        double dC = c(latLng, latLng2);
        ArrayList arrayList = new ArrayList();
        if (150000.0d > dC || dC < 250000.0d) {
            arrayList.add(latLng);
            arrayList.add(latLng2);
            return arrayList;
        }
        double dRound = Math.round(dC / 150000.0d);
        double dA = a(latLng, latLng2);
        arrayList.add(latLng);
        for (double d = 0.0d; d < dRound; d += 1.0d) {
            arrayList.add(a(latLng, latLng2, d / dRound, dA));
        }
        arrayList.add(latLng2);
        return arrayList;
    }

    private static LatLng a(LatLng latLng, LatLng latLng2, double d, double d2) {
        double d3 = latLng.latitude;
        double d4 = latLng2.latitude;
        double d5 = latLng.longitude;
        double d6 = latLng2.longitude;
        double dSin = Math.sin((1.0d - d) * d2) / Math.sin(d2);
        double dSin2 = Math.sin(d * d2) / Math.sin(d2);
        double dB = b(d3);
        double dB2 = b(d4);
        double dB3 = b(d5);
        double dB4 = b(d6);
        double dCos = (Math.cos(dB) * dSin * Math.cos(dB3)) + (Math.cos(dB2) * dSin2 * Math.cos(dB4));
        double dCos2 = (Math.cos(dB) * dSin * Math.sin(dB3)) + (Math.cos(dB2) * dSin2 * Math.sin(dB4));
        return new LatLng(a(Math.atan2((dSin * Math.sin(dB)) + (dSin2 * Math.sin(dB2)), Math.sqrt(Math.pow(dCos, 2.0d) + Math.pow(dCos2, 2.0d)))), a(Math.atan2(dCos2, dCos)));
    }
}
