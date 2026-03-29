package com.baidu.mapapi.common;

import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.util.f;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class SysOSUtil {
    public static String getAuthToken() {
        return f.a();
    }

    public static float getDensity() {
        return f.y;
    }

    public static int getDensityDpi() {
        return f.d();
    }

    public static String getDeviceID() {
        String strC = f.c();
        return TextUtils.isEmpty(strC) ? strC : strC.substring(0, strC.indexOf(HiAnalyticsConstant.REPORT_VAL_SEPARATOR));
    }

    public static String getModuleFileName() {
        return f.e();
    }

    public static String getNetType() {
        return f.f();
    }

    public static String getPhoneType() {
        return f.k();
    }

    public static int getScreenSizeX() {
        return f.l();
    }

    public static int getScreenSizeY() {
        return f.m();
    }

    public static void updateCuid() {
        f.c();
    }
}
