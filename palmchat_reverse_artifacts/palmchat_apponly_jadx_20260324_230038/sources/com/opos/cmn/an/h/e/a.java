package com.opos.cmn.an.h.e;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static TelephonyManager f7792a;

    public static TelephonyManager a(Context context) {
        if (f7792a == null && context != null) {
            f7792a = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
        }
        return f7792a;
    }

    public static String b(Context context) {
        if (context == null) {
            return "none";
        }
        try {
            TelephonyManager telephonyManagerA = a(context);
            return telephonyManagerA != null ? telephonyManagerA.getNetworkOperatorName() : "none";
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TelMgrTool", "", e);
            return "none";
        }
    }

    public static String c(Context context) {
        if (context == null) {
            return "none";
        }
        try {
            TelephonyManager telephonyManagerA = a(context);
            return telephonyManagerA != null ? telephonyManagerA.getSimOperatorName() : "none";
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TelMgrTool", "", e);
            return "none";
        }
    }

    public static String d(Context context) {
        if (context == null) {
            return "none";
        }
        try {
            TelephonyManager telephonyManagerA = a(context);
            return telephonyManagerA != null ? telephonyManagerA.getSimOperator() : "none";
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TelMgrTool", "", e);
            return "none";
        }
    }

    public static String e(Context context) {
        if (context == null) {
            return "none";
        }
        try {
            return a(d(context));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TelMgrTool", "", e);
            return "none";
        }
    }

    private static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("46000") || str.startsWith("46002") || str.startsWith("46004") || str.startsWith("46007") || str.startsWith("46008")) {
                return "mobile";
            }
            if (str.startsWith("46001") || str.startsWith("46006") || str.startsWith("46009")) {
                return "unicom";
            }
            if (str.startsWith("46003") || str.startsWith("46011")) {
                return "telecom";
            }
        }
        return "none";
    }
}
