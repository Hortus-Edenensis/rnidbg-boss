package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.NetworkUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class o {
    public static boolean b(Context context) {
        return fx(context) == 4;
    }

    public static int fx(Context context) {
        return gi.u(context, 60000L);
    }

    public static boolean iz(Context context) {
        return fx(context) == 6;
    }

    public static int nr(Context context) {
        int iFx = fx(context);
        if (iFx == 1) {
            return 0;
        }
        if (iFx == 4) {
            return 1;
        }
        if (iFx == 5) {
            return 4;
        }
        if (iFx != 6) {
            return iFx;
        }
        return 6;
    }

    public static boolean pn(Context context) {
        return fx(context) == 5;
    }

    public static void u(sx sxVar) {
        gi.u(sxVar);
    }

    public static String x(Context context) {
        int iFx = fx(context);
        return iFx != 2 ? iFx != 3 ? iFx != 4 ? iFx != 5 ? iFx != 6 ? "mobile" : NetworkUtil.NETWORK_CLASS_5G : "4g" : "wifi" : "3g" : "2g";
    }

    public static boolean u(Context context) {
        return fx(context) != 0;
    }

    public static boolean u(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http://") || str.startsWith("https://");
    }
}
