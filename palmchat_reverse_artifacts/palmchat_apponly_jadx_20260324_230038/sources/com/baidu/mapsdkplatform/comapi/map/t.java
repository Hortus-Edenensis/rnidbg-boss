package com.baidu.mapsdkplatform.comapi.map;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.AlgorithmUtil;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comjni.tools.JNITools;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class t {
    private ArrayList<LatLng> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<LatLng> arrayList = new ArrayList<>();
        for (String str2 : str.split("\\|")) {
            String[] strArrSplit = str2.split(",");
            String str3 = strArrSplit[0];
            String str4 = strArrSplit[1];
            try {
                arrayList.add(new LatLng(Integer.parseInt(str3) / 1000000.0f, Integer.parseInt(str4) / 1000000.0f));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return null;
            }
        }
        return arrayList;
    }

    private String c(String str) {
        String authToken = SyncSysInfo.getAuthToken();
        if (TextUtils.isEmpty(authToken)) {
            return null;
        }
        String aESSaltKey = JNITools.getAESSaltKey(authToken);
        String aESViKey = JNITools.getAESViKey(authToken);
        if (!TextUtils.isEmpty(aESSaltKey) && !TextUtils.isEmpty(aESViKey) && !TextUtils.isEmpty(str)) {
            try {
                return new String(AlgorithmUtil.getDecryptInfo(aESViKey, aESSaltKey, g(str))).trim();
            } catch (Exception unused) {
                Log.e("PrismBuildingInfo", "getBuildingGeom Decrypt failed");
            }
        }
        return null;
    }

    private byte[] f(String str) {
        if (str == null || str.length() < 2) {
            return new byte[0];
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (Integer.parseInt(str.substring(i2, i2 + 2), 16) & 255);
        }
        return bArr;
    }

    private byte[] g(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i2, i3), 16) * 16) + Integer.parseInt(str.substring(i3, i2 + 2), 16));
        }
        return bArr;
    }

    public ArrayList<LatLng> b(String str) {
        String strC = c(str);
        ArrayList<LatLng> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(strC)) {
            for (String str2 : strC.split("\\|")) {
                String[] strArrSplit = str2.split(",");
                if (strArrSplit.length == 2) {
                    String str3 = strArrSplit[0];
                    try {
                        arrayList.add(CoordUtil.mc2llDirect(new GeoPoint(Double.parseDouble(strArrSplit[1]), Double.parseDouble(str3))));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return arrayList;
    }

    public ArrayList<LatLng> d(String str) {
        String strC = c(str);
        ArrayList<LatLng> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(strC)) {
            for (String str2 : strC.split(com.huawei.openalliance.ad.constant.x.aQ)) {
                String[] strArrSplit = str2.split(",");
                if (strArrSplit.length == 2) {
                    String str3 = strArrSplit[0];
                    try {
                        arrayList.add(new LatLng(Double.parseDouble(strArrSplit[1]), Double.parseDouble(str3)));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return arrayList;
    }

    public ArrayList<LatLng> e(String str) {
        ArrayList<LatLng> arrayListA = a(new String(JNITools.decryptPNKD(f(str)), StandardCharsets.UTF_8));
        if (arrayListA == null) {
            return null;
        }
        return a(arrayListA);
    }

    private ArrayList<LatLng> a(List<LatLng> list) {
        ArrayList<LatLng> arrayList = new ArrayList<>();
        arrayList.add(0, list.get(0));
        int size = list.size();
        for (int i = 1; i < size; i++) {
            int i2 = i - 1;
            arrayList.add(new LatLng(arrayList.get(i2).latitude + list.get(i).latitude, arrayList.get(i2).longitude + list.get(i).longitude));
        }
        return arrayList;
    }
}
