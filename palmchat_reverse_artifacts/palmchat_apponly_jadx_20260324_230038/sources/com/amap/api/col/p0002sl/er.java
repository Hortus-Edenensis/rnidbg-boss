package com.amap.api.col.p0002sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.oplus.tblplayer.Constants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class er {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static ik f2732a;

    public static void a(Context context, String str, long j, boolean z) {
        try {
            String strA = a(str, j, z);
            if (strA != null && strA.length() > 0) {
                if (f2732a == null) {
                    f2732a = new ik(context, "sea", "9.7.2", "O002");
                }
                f2732a.a(strA);
                il.a(f2732a, context);
            }
        } catch (Throwable th) {
            di.a(th, "StatisticsUtil", "recordResponseAction");
        }
    }

    private static String a(String str, long j, boolean z) {
        try {
            return "{\"RequestPath\":\"" + str + "\",\"ResponseTime\":" + j + ",\"Success\":" + z + "}";
        } catch (Throwable th) {
            di.a(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }

    public static void a(String str, String str2, AMapException aMapException) {
        if (str != null) {
            String errorType = aMapException.getErrorType();
            String strA = a(aMapException);
            if (strA == null || strA.length() <= 0) {
                return;
            }
            hd.a(dh.a(true), str, errorType, str2, strA);
        }
    }

    private static String a(AMapException aMapException) {
        if (aMapException == null) {
            return null;
        }
        if (aMapException.getErrorLevel() == 0) {
            int errorCode = aMapException.getErrorCode();
            if (errorCode == 0) {
                return "4";
            }
            int iPow = (int) Math.pow(10.0d, Math.floor(Math.log10(errorCode)));
            return String.valueOf((errorCode % iPow) + (iPow * 4));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(aMapException.getErrorCode());
        return sb.toString();
    }

    public static void a(Context context, String str, boolean z) {
        try {
            String strA = a(str, z);
            if (strA != null && strA.length() > 0) {
                ik ikVar = new ik(context, "sea", "9.7.2", "O006");
                ikVar.a(strA);
                il.a(ikVar, context);
            }
        } catch (Throwable th) {
            di.a(th, "StatisticsUtil", "recordResponseAction");
        }
    }

    private static String a(String str, boolean z) {
        String strSubstring;
        try {
            strSubstring = "";
            int iIndexOf = str.indexOf(Constants.STRING_VALUE_UNSET);
            int length = str.length();
            if (iIndexOf > 0) {
                String strSubstring2 = str.substring(0, iIndexOf);
                int i = iIndexOf + 1;
                strSubstring = i < length ? str.substring(i) : "";
                str = strSubstring2;
            }
            return "{\"RequestPath\":\"" + str + "\",\"RequestParm\":\"" + strSubstring + "\",\"IsCacheRequest\":" + z + "}";
        } catch (Throwable th) {
            di.a(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }
}
