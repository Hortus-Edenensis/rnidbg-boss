package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.huawei.hms.ads.fh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ap {
    private static final String Code = "ap";

    private static int B(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return 0;
        }
        try {
            NetworkInfo networkInfoCode = Code(connectivityManager);
            if (networkInfoCode != null) {
                int type = networkInfoCode.getType();
                if (type == 0) {
                    return Code(networkInfoCode.getSubtype());
                }
                if (9 == type) {
                    return 1;
                }
                if (1 == type) {
                    return 2;
                }
            }
        } catch (Exception unused) {
            fh.I(Code, "get net info err");
        }
        return 0;
    }

    private static int Code(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 4;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 5;
            case 13:
            case 18:
                return 6;
            case 19:
            default:
                return 0;
            case 20:
                return 7;
        }
    }

    public static boolean I(Context context) {
        return Code(context) || V(context);
    }

    public static boolean V(Context context) {
        return context != null && 1 == B(context);
    }

    public static boolean Z(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception unused) {
            fh.I(Code, "check net conn err");
            return false;
        }
    }

    public static NetworkInfo Code(ConnectivityManager connectivityManager) {
        NetworkInfo networkInfo;
        if (connectivityManager != null) {
            return (Build.VERSION.SDK_INT >= 24 && ((networkInfo = connectivityManager.getNetworkInfo(connectivityManager.getActiveNetwork())) == null || 17 != networkInfo.getType())) ? networkInfo : connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static boolean Code(Context context) {
        return context != null && 2 == B(context);
    }
}
