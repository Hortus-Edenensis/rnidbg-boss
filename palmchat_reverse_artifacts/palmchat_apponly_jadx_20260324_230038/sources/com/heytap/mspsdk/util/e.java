package com.heytap.mspsdk.util;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.heytap.mspsdk.constants.Constants;
import com.heytap.mspsdk.log.MspLog;
import java.io.IOException;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class e {
    public static String a() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static boolean b() {
        return TextUtils.isEmpty(c());
    }

    public static String c() {
        String strA = a(String.valueOf(Base64.decode(Constants.ROM_OS_VERSION, 0)), "");
        return TextUtils.isEmpty(strA) ? a("ro.build.version.oplusrom", "") : strA;
    }

    public static boolean d() {
        String strF = f();
        return ("CN".equalsIgnoreCase(strF) || "OC".equalsIgnoreCase(strF)) ? false : true;
    }

    public static boolean e() {
        try {
            String strA = com.heytap.mspsdk.util.md5.a.a(Build.BRAND.toUpperCase());
            if (!TextUtils.equals("67843bc0e7e7b09cc369beabf05e9d30", strA) && !TextUtils.equals("60c89617499cd5202c71062b5f22087d", strA)) {
                if (!TextUtils.equals("5836b6c1f251363d1ebc8e1c2e1fb9b9", strA)) {
                    return false;
                }
            }
            return true;
        } catch (IOException e) {
            MspLog.e("Md5Util", "isOwnBrand: " + e.getMessage());
            return false;
        }
    }

    public static String f() {
        int i = 0;
        while (true) {
            String[] strArr = com.heytap.mspsdk.constants.a.f6384a;
            if (i >= strArr.length) {
                return i.a("ro.boot.regionmark", "");
            }
            String strB = h.b(strArr[i]);
            if (!TextUtils.isEmpty(strB)) {
                String strA = i.a(strB, "");
                if (!TextUtils.isEmpty(strA)) {
                    MspLog.d("DeviceUtils", String.format("==== getRegion:%s from %s", strB, strA));
                    return strA;
                }
            }
            i++;
        }
    }

    public static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            MspLog.e("DeviceUtils", "getProperty: " + e.getMessage());
            return str2;
        }
    }
}
