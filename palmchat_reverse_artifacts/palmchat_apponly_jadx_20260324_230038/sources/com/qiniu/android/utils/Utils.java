package com.qiniu.android.utils;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Utils {
    private static Boolean isDebug;

    public static Long calculateSpeed(Long l, Long l2) {
        if (l == null || l.longValue() < 0 || l2 == null || l2.longValue() == 0) {
            return null;
        }
        return Long.valueOf((l.longValue() * 1000) / l2.longValue());
    }

    public static long currentSecondTimestamp() {
        return currentTimestamp() / 1000;
    }

    public static long currentTimestamp() {
        return new Date().getTime();
    }

    public static long dateDuration(Date date, Date date2) {
        if (date == null || date2 == null) {
            return 0L;
        }
        return date2.getTime() - date.getTime();
    }

    private static String deviceName(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        if (lowerCase.startsWith("unknown") || lowerCase.startsWith("alps") || lowerCase.startsWith("android") || lowerCase.startsWith("sprd") || lowerCase.startsWith("spreadtrum") || lowerCase.startsWith("rockchip") || lowerCase.startsWith("wondermedia") || lowerCase.startsWith("mtk") || lowerCase.startsWith("mt65") || lowerCase.startsWith("nvidia") || lowerCase.startsWith("brcm") || lowerCase.startsWith("marvell") || str2.toLowerCase(Locale.getDefault()).contains(lowerCase)) {
            return null;
        }
        return str;
    }

    public static String formEscape(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    public static String getCurrentNetworkType() {
        Context contextApplicationContext = ContextGetter.applicationContext();
        return contextApplicationContext == null ? "" : AndroidNetwork.networkType(contextApplicationContext);
    }

    public static Integer getCurrentProcessID() {
        return Integer.valueOf(Process.myPid());
    }

    public static Integer getCurrentSignalStrength() {
        return null;
    }

    public static Long getCurrentThreadID() {
        return Long.valueOf(Thread.currentThread().getId());
    }

    private static String getIPV4StringType(String str, String str2) {
        String str3;
        if (str2 == null) {
            str2 = "";
        }
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length == 4) {
            str3 = Integer.parseInt(strArrSplit[0]) + "-" + Integer.parseInt(strArrSplit[1]);
        } else {
            str3 = null;
        }
        return str2 + "-" + str3;
    }

    private static String getIPV6StringType(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        String[] strArrSplit = str.split(":");
        String[] strArr = {"0000", "0000", "0000", "0000", "0000", "0000", "0000", "0000"};
        String[] strArr2 = {"0000", "000", "00", "0", ""};
        int i = 0;
        while (i < strArrSplit.length) {
            String str3 = strArrSplit[i];
            if (str3.length() <= 0) {
                break;
            }
            strArr[i] = strArr2[str3.length()] + str3;
            i++;
        }
        int length = strArrSplit.length - 1;
        int i2 = 7;
        while (i < length) {
            String str4 = strArrSplit[length];
            if (str4.length() <= 0) {
                break;
            }
            strArr[i2] = strArr2[str4.length()] + str4;
            length += -1;
            i2 += -1;
        }
        return str2 + "-ipv6-" + StringUtils.join((String[]) Arrays.copyOfRange(strArr, 0, 4), "-");
    }

    public static String getIpType(String str, String str2) {
        return (str == null || str.length() == 0) ? str2 : str.contains(":") ? getIPV6StringType(str, str2) : str.contains(".") ? getIPV4StringType(str, str2) : str2;
    }

    public static boolean isDebug() {
        Boolean bool = isDebug;
        if (bool != null) {
            return bool.booleanValue();
        }
        Context contextApplicationContext = ContextGetter.applicationContext();
        if (contextApplicationContext == null) {
            return false;
        }
        try {
            Boolean boolValueOf = Boolean.valueOf((contextApplicationContext.getApplicationInfo().flags & 2) != 0);
            isDebug = boolValueOf;
            return boolValueOf.booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isIpv6(String str) {
        if (StringUtils.isNullOrEmpty(str)) {
            return false;
        }
        return IPAddressUtil.isIPv6LiteralAddress(str);
    }

    public static String sdkDirectory() {
        Context contextApplicationContext = ContextGetter.applicationContext();
        if (contextApplicationContext == null) {
            return null;
        }
        return contextApplicationContext.getCacheDir().getAbsolutePath() + "/qiniu";
    }

    public static String sdkLanguage() {
        return AnalyticsConstants.SDK_TYPE;
    }

    public static String sdkVerion() {
        return com.qiniu.android.common.Constants.VERSION;
    }

    public static String systemName() {
        try {
            String str = Build.MODEL;
            String strTrim = str != null ? str.trim() : "";
            String strDeviceName = deviceName(Build.MANUFACTURER.trim(), strTrim);
            if (TextUtils.isEmpty(strDeviceName)) {
                strDeviceName = deviceName(Build.BRAND.trim(), strTrim);
            }
            String str2 = Build.VERSION.SDK;
            return strDeviceName + "/" + strTrim + "/" + (str2 != null ? str2 : "");
        } catch (Throwable unused) {
            return "-";
        }
    }

    public static String systemVersion() {
        try {
            String str = Build.VERSION.RELEASE;
            return str == null ? "-" : StringUtils.strip(str.trim());
        } catch (Throwable unused) {
            return "-";
        }
    }
}
