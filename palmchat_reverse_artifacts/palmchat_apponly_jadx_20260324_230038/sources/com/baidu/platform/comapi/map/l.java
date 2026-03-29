package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class l {
    public static GeoPoint a(GeoPoint geoPoint) {
        Point pointBd09llTobd09mc = CoordinateUtil.bd09llTobd09mc(geoPoint.getLongitude(), geoPoint.getLatitude());
        if (pointBd09llTobd09mc != null) {
            return new GeoPoint(pointBd09llTobd09mc.getDoubleY(), pointBd09llTobd09mc.getDoubleX());
        }
        return null;
    }
}
