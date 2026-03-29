package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.Point;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class DistanceUtil {
    public static double getDistance(LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null) {
            Point pointLl2point = CoordUtil.ll2point(latLng);
            Point pointLl2point2 = CoordUtil.ll2point(latLng2);
            if (pointLl2point != null && pointLl2point2 != null) {
                return CoordUtil.getDistance(pointLl2point, pointLl2point2);
            }
        }
        return -1.0d;
    }
}
