package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class SpatialRelationUtil {
    private static Point a(List<Point> list, Point point) {
        Point point2 = null;
        if (list != null && point != null && list.size() != 0) {
            if (list.size() >= 2) {
                Point point3 = list.get(0);
                int size = list.size();
                int i = 1;
                while (true) {
                    int i2 = size - 1;
                    if (i > i2) {
                        break;
                    }
                    Point point4 = list.get(i);
                    if ((i == i2 && point4.equals(point)) || point3.equals(point)) {
                        return point;
                    }
                    Point pointA = a(point.doubleX, point.doubleY, point3.doubleX, point3.doubleY, point4.doubleX, point4.doubleY);
                    i++;
                    size = size;
                    point3 = point4;
                    point2 = pointA;
                }
            } else {
                return null;
            }
        }
        return point2;
    }

    public static LatLng getNearestDistancePointFromLine(List<LatLng> list, LatLng latLng) {
        if (list != null && list.size() != 0 && latLng != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<LatLng> it = list.iterator();
            while (it != null && it.hasNext()) {
                LatLng next = it.next();
                arrayList.add(new Point(next.longitude, next.latitude));
                if (next.equals(latLng)) {
                    return next;
                }
            }
            Point pointA = a(arrayList, new Point(latLng.longitude, latLng.latitude));
            if (pointA != null) {
                return new LatLng(pointA.doubleY, pointA.doubleX);
            }
        }
        return null;
    }

    public static LatLng getNearestPointFromLine(List<LatLng> list, LatLng latLng) {
        LatLng latLng2 = null;
        if (list != null && list.size() != 0 && latLng != null) {
            int i = 0;
            while (i < list.size() - 1) {
                int i2 = i + 1;
                LatLng latLngA = a(list.get(i), list.get(i2), latLng);
                if ((latLngA.latitude - list.get(i).latitude) * (latLngA.latitude - list.get(i2).latitude) > 0.0d || (latLngA.longitude - list.get(i).longitude) * (latLngA.longitude - list.get(i2).longitude) > 0.0d) {
                    latLngA = DistanceUtil.getDistance(latLng, list.get(i)) < DistanceUtil.getDistance(latLng, list.get(i2)) ? list.get(i) : list.get(i2);
                }
                if (latLng2 == null || DistanceUtil.getDistance(latLng, latLngA) < DistanceUtil.getDistance(latLng, latLng2)) {
                    latLng2 = latLngA;
                }
                i = i2;
            }
        }
        return latLng2;
    }

    public static boolean isCircleContainsPoint(LatLng latLng, int i, LatLng latLng2) {
        return (latLng == null || i == 0 || latLng2 == null || DistanceUtil.getDistance(latLng, latLng2) > ((double) i)) ? false : true;
    }

    public static boolean isPolygonContainsPoint(List<LatLng> list, LatLng latLng) {
        int i;
        if (list == null || list.size() == 0 || latLng == null) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (latLng.longitude == list.get(i2).longitude && latLng.latitude == list.get(i2).latitude) {
                return true;
            }
        }
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            LatLng latLng2 = list.get(i3);
            i3++;
            LatLng latLng3 = list.get(i3 % size);
            double d = latLng2.latitude;
            double d2 = latLng3.latitude;
            if (d != d2 && latLng.latitude >= Math.min(d, d2) && latLng.latitude < Math.max(latLng2.latitude, latLng3.latitude)) {
                double d3 = latLng.latitude;
                double d4 = latLng2.latitude;
                double d5 = latLng3.longitude;
                i = size;
                double d6 = latLng2.longitude;
                double d7 = (((d3 - d4) * (d5 - d6)) / (latLng3.latitude - d4)) + d6;
                double d8 = latLng.longitude;
                if (d7 == d8) {
                    return true;
                }
                if (d7 < d8) {
                    i4++;
                }
            } else {
                i = size;
            }
            size = i;
        }
        return i4 % 2 == 1;
    }

    private static Point a(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d5 - d3;
        double d8 = d6 - d4;
        double d9 = ((d - d3) * d7) + ((d2 - d4) * d8);
        if (d9 <= 0.0d) {
            return new Point(d3, d4);
        }
        double d10 = (d7 * d7) + (d8 * d8);
        if (d9 >= d10) {
            return new Point(d5, d6);
        }
        double d11 = d9 / d10;
        return new Point(d3 + (d7 * d11), d4 + (d8 * d11));
    }

    private static LatLng a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLng);
        GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(latLng2);
        GeoPoint geoPointLl2mc3 = CoordUtil.ll2mc(latLng3);
        double dSqrt = Math.sqrt(((geoPointLl2mc2.getLongitudeE6() - geoPointLl2mc.getLongitudeE6()) * (geoPointLl2mc2.getLongitudeE6() - geoPointLl2mc.getLongitudeE6())) + ((geoPointLl2mc2.getLatitudeE6() - geoPointLl2mc.getLatitudeE6()) * (geoPointLl2mc2.getLatitudeE6() - geoPointLl2mc.getLatitudeE6())));
        double longitudeE6 = (((geoPointLl2mc2.getLongitudeE6() - geoPointLl2mc.getLongitudeE6()) * (geoPointLl2mc3.getLongitudeE6() - geoPointLl2mc.getLongitudeE6())) + ((geoPointLl2mc2.getLatitudeE6() - geoPointLl2mc.getLatitudeE6()) * (geoPointLl2mc3.getLatitudeE6() - geoPointLl2mc.getLatitudeE6()))) / (dSqrt * dSqrt);
        return CoordUtil.mc2ll(new GeoPoint(geoPointLl2mc.getLatitudeE6() + ((geoPointLl2mc2.getLatitudeE6() - geoPointLl2mc.getLatitudeE6()) * longitudeE6), geoPointLl2mc.getLongitudeE6() + ((geoPointLl2mc2.getLongitudeE6() - geoPointLl2mc.getLongitudeE6()) * longitudeE6)));
    }
}
