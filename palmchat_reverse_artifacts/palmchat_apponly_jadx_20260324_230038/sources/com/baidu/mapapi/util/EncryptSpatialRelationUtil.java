package com.baidu.mapapi.util;

import android.text.TextUtils;
import com.baidu.mapapi.map.EncodePointType;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.util.g;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class EncryptSpatialRelationUtil {
    private static boolean a(LatLng latLng, String str, EncodePointType encodePointType) {
        ArrayList<LatLng> arrayList;
        if (encodePointType == null) {
            return false;
        }
        ArrayList<LatLng> arrayListA = g.a().a(str, encodePointType.ordinal());
        if (arrayListA == null || arrayListA.size() == 0 || latLng == null) {
            return false;
        }
        for (int i = 0; i < arrayListA.size(); i++) {
            if (latLng.longitude == arrayListA.get(i).longitude && latLng.latitude == arrayListA.get(i).latitude) {
                return true;
            }
        }
        int size = arrayListA.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            LatLng latLng2 = arrayListA.get(i2);
            i2++;
            LatLng latLng3 = arrayListA.get(i2 % size);
            double d = latLng2.latitude;
            double d2 = latLng3.latitude;
            if (d != d2 && latLng.latitude >= Math.min(d, d2) && latLng.latitude < Math.max(latLng2.latitude, latLng3.latitude)) {
                double d3 = latLng.latitude;
                double d4 = latLng2.latitude;
                double d5 = latLng3.longitude;
                arrayList = arrayListA;
                double d6 = latLng2.longitude;
                double d7 = (((d3 - d4) * (d5 - d6)) / (latLng3.latitude - d4)) + d6;
                double d8 = latLng.longitude;
                if (d7 == d8) {
                    return true;
                }
                if (d7 < d8) {
                    i3++;
                }
            } else {
                arrayList = arrayListA;
            }
            arrayListA = arrayList;
        }
        return i3 % 2 == 1;
    }

    public static boolean isEncodedGeoPointsContainsPoint(LatLng latLng, String str, EncodePointType encodePointType) {
        if (latLng == null || TextUtils.isEmpty(str) || encodePointType == null) {
            return false;
        }
        return a(latLng, str, encodePointType);
    }
}
