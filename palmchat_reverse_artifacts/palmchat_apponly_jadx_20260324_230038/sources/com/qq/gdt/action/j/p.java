package com.qq.gdt.action.j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class p {
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
    
        if (r2.hasTransport(4) == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a() {
        Context contextG = com.qq.gdt.action.d.a().g();
        try {
            if (!q.a(contextG, com.kuaishou.weapon.p0.g.b)) {
                return GrsBaseInfo.CountryCodeSource.UNKNOWN;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) contextG.getSystemService("connectivity");
            if (connectivityManager != null) {
                if (Build.VERSION.SDK_INT < 23) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                            return "WIFI";
                        }
                    }
                    return GrsBaseInfo.CountryCodeSource.UNKNOWN;
                }
                Network activeNetwork = connectivityManager.getActiveNetwork();
                if (activeNetwork != null) {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                    if (networkCapabilities != null) {
                        if (networkCapabilities.hasTransport(1)) {
                            return "WIFI";
                        }
                        if (!networkCapabilities.hasTransport(0)) {
                            if (!networkCapabilities.hasTransport(3)) {
                            }
                        }
                    }
                }
                return GrsBaseInfo.CountryCodeSource.UNKNOWN;
            }
            TelephonyManager telephonyManager = (TelephonyManager) contextG.getSystemService("phone");
            if (telephonyManager == null) {
                return GrsBaseInfo.CountryCodeSource.UNKNOWN;
            }
            switch (telephonyManager.getNetworkType()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    return "2G";
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
                    return "3G";
                case 13:
                case 18:
                    return "4G";
                case 19:
                default:
                    return GrsBaseInfo.CountryCodeSource.UNKNOWN;
                case 20:
                    return "5G";
            }
        } catch (Exception unused) {
            return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    public static boolean b() {
        try {
            return com.qq.gdt.action.b.a(com.qq.gdt.action.d.a().g()).u() == 0;
        } catch (Exception e) {
            o.a("isActionHttpsEnable e  = " + e, new Object[0]);
            return true;
        }
    }

    public static boolean c() {
        try {
            return com.qq.gdt.action.b.a(com.qq.gdt.action.d.a().g()).v() == 0;
        } catch (Exception e) {
            o.a("isEventHttpsEnable e  = " + e, new Object[0]);
            return true;
        }
    }

    public static boolean a(Context context) {
        NetworkCapabilities networkCapabilities;
        if (!q.a(context, com.kuaishou.weapon.p0.g.b)) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT < 23) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            }
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
                return false;
            }
            return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(4);
        } catch (Exception e) {
            o.a("Check network available exception", e);
            return false;
        }
    }
}
