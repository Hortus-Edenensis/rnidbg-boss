package com.baidu.platform.comapi.util;

import android.text.TextUtils;
import com.baidu.mapapi.map.EncodePointType;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.t;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static g f4238a = new g();
    }

    public static g a() {
        return a.f4238a;
    }

    private ArrayList<LatLng> c(String str) {
        return new t().e(str);
    }

    public ArrayList<LatLng> b(String str) {
        return new t().d(str);
    }

    public ArrayList<LatLng> a(String str, int i) {
        if (TextUtils.isEmpty(str) || i == EncodePointType.NONE.ordinal()) {
            return null;
        }
        if (i == EncodePointType.BUILDINGINFO.ordinal()) {
            return b(str);
        }
        if (i == EncodePointType.AOI.ordinal()) {
            return a(str);
        }
        if (i == EncodePointType.RECOGNIZE_AOI.ordinal()) {
            return c(str);
        }
        return null;
    }

    private ArrayList<LatLng> a(String str) {
        return new t().b(str);
    }
}
