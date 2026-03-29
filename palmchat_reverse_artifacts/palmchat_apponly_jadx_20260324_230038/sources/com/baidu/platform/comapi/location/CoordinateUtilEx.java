package com.baidu.platform.comapi.location;

import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class CoordinateUtilEx {
    public static Point Coordinate_encryptEx(float f, float f2, String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("")) {
            str = "bd09ll";
        }
        switch (str) {
        }
        return null;
    }

    public static ArrayList<Point> Coordinate_encryptExArray(ArrayList<Point> arrayList, String str) {
        int i;
        Point pointBd09llTobd09mc;
        String str2 = str;
        Point point = null;
        if (str2 == null) {
            return null;
        }
        if (str2.equals("")) {
            str2 = "bd09ll";
        }
        if (!str2.equals("bd09ll") && !str2.equals("bd09mc") && !str2.equals("gcj02") && !str2.equals("wgs84")) {
            return null;
        }
        int size = arrayList.size();
        float[] fArr = new float[size];
        float[] fArr2 = new float[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            fArr[i2] = arrayList.get(i2).getIntX() / 100000.0f;
            fArr2[i2] = arrayList.get(i2).getIntY() / 100000.0f;
        }
        ArrayList<Point> arrayList2 = new ArrayList<>();
        int i3 = 0;
        while (i3 < size) {
            switch (str2) {
                case "bd09ll":
                    i = size;
                    pointBd09llTobd09mc = CoordinateUtil.bd09llTobd09mc(fArr[i3], fArr2[i3]);
                    break;
                case "bd09mc":
                    i = size;
                    pointBd09llTobd09mc = new Point(fArr[i3], fArr2[i3]);
                    break;
                case "gcj02":
                    pointBd09llTobd09mc = CoordinateUtil.gcj02Tobd09mc(fArr[i3], fArr2[i3]);
                    i = size;
                    break;
                case "wgs84":
                    pointBd09llTobd09mc = CoordinateUtil.wgs84Tobd09mc(fArr[i3], fArr2[i3]);
                    i = size;
                    break;
                default:
                    pointBd09llTobd09mc = point;
                    i = size;
                    break;
            }
            if (pointBd09llTobd09mc != null) {
                arrayList2.add(pointBd09llTobd09mc);
            }
            i3++;
            size = i;
            point = null;
        }
        return arrayList2;
    }

    public static double getDistanceByMc(Point point, Point point2) {
        return CoordinateUtil.getDistanceByMc(point.getDoubleX(), point.getDoubleY(), point2.getDoubleX(), point2.getDoubleY());
    }

    @Deprecated
    public static ComplexPt getGeoComplexPointFromString(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        return CoordinateUtil.geoStringToComplexPt(str);
    }

    @Deprecated
    public static ComplexPt getGeoComplexPtBoundFromString(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        return CoordinateUtil.geoStringToComplexPtBound(str);
    }

    public static Point getGeoPointFromString(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        return CoordinateUtil.geoStringToPoint(str);
    }

    public static Point getIntermediatePointByMC(Point point, Point point2, double d) {
        return CoordinateUtil.getIntermediatePointByMC(point.getDoubleX(), point.getDoubleY(), point2.getDoubleX(), point2.getDoubleY(), d);
    }

    public static String getStringFromGeoPoint(Point point) {
        return CoordinateUtil.pointToGeoString(point);
    }

    public static double getDistanceByMc(GeoPoint geoPoint, GeoPoint geoPoint2) {
        return CoordinateUtil.getDistanceByMc(geoPoint.getLongitude(), geoPoint.getLatitude(), geoPoint2.getLongitude(), geoPoint2.getLatitude());
    }

    public static Point getIntermediatePointByMC(GeoPoint geoPoint, GeoPoint geoPoint2, double d) {
        return CoordinateUtil.getIntermediatePointByMC(geoPoint.getLongitude(), geoPoint.getLatitude(), geoPoint2.getLongitude(), geoPoint2.getLatitude(), d);
    }
}
