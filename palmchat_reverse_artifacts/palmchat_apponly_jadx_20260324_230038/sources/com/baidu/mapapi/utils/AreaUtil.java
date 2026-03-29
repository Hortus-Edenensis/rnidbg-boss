package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.LatLng;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class AreaUtil {
    public static double calculateArea(LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null) {
            LatLng latLng3 = new LatLng(latLng.latitude, latLng2.longitude);
            double distance = DistanceUtil.getDistance(latLng3, latLng2);
            double distance2 = DistanceUtil.getDistance(latLng, latLng3);
            if (distance != 0.0d && distance2 != 0.0d) {
                return distance * distance2;
            }
        }
        return 0.0d;
    }

    public static double calculateArea(List<LatLng> list) {
        double dCos = 0.0d;
        if (list == null || list.size() < 3) {
            return 0.0d;
        }
        int size = list.size();
        int i = 0;
        while (i < size) {
            LatLng latLng = list.get(i);
            i++;
            LatLng latLng2 = list.get(i % size);
            dCos += (((latLng.longitude * 111319.49079327358d) * Math.cos(latLng.latitude * 0.017453292519943295d)) * (latLng2.latitude * 111319.49079327358d)) - ((latLng.latitude * 111319.49079327358d) * ((latLng2.longitude * 111319.49079327358d) * Math.cos(latLng2.latitude * 0.017453292519943295d)));
        }
        return (float) Math.abs(dCos / 2.0d);
    }
}
