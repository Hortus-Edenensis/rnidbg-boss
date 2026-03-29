package com.baidu.mapapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class NetworkUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f3543a = false;
    private static a b;
    private static ConnectivityManager c;
    private static NetworkUpdate2MapListener d;

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return null;
        }
        c = (ConnectivityManager) context.getSystemService("connectivity");
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                NetworkRequest networkRequestBuild = new NetworkRequest.Builder().build();
                ConnectivityManager connectivityManager = c;
                if (connectivityManager == null) {
                    return null;
                }
                if (!f3543a) {
                    a aVar = new a(context);
                    b = aVar;
                    c.registerNetworkCallback(networkRequestBuild, aVar);
                    f3543a = true;
                    return null;
                }
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } else {
                activeNetworkInfo = c.getActiveNetworkInfo();
            }
            return activeNetworkInfo;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getCurrentNetMode(Context context) {
        NetworkCapabilities networkCapabilities;
        if (context == null) {
            return null;
        }
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        int i = 0;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() != 1) {
                if (Build.VERSION.SDK_INT <= 29) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        switch (telephonyManager.getNetworkType()) {
                            case 1:
                            case 2:
                                i = 6;
                                break;
                            case 3:
                            case 9:
                            case 10:
                            case 15:
                                i = 9;
                                break;
                            case 4:
                                i = 5;
                                break;
                            case 5:
                            case 6:
                            case 7:
                            case 12:
                                i = 7;
                                break;
                            case 8:
                                i = 8;
                                break;
                            case 11:
                                i = 2;
                                break;
                            case 13:
                                i = 4;
                                break;
                            case 14:
                                i = 10;
                                break;
                        }
                    } else {
                        return Integer.toString(0);
                    }
                } else {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) == null) {
                        return "mobile";
                    }
                    return networkCapabilities.hasTransport(1) ? "WIFI" : networkCapabilities.hasTransport(0) ? "CELLULAR" : networkCapabilities.hasTransport(3) ? "ETHERNET" : networkCapabilities.hasTransport(6) ? "LoWPAN" : networkCapabilities.hasTransport(4) ? "VPN" : networkCapabilities.hasTransport(5) ? "WifiAware" : "mobile";
                }
            } else {
                i = 1;
            }
        }
        return Integer.toString(i);
    }

    public static boolean initConnectState() {
        return true;
    }

    public static boolean isNetworkAvailable(Context context) {
        try {
            if (isWifiConnected(context)) {
                return true;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isWifiConnected(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return false;
        }
        try {
            if (1 == networkInfo.getType()) {
                return networkInfo.isConnected();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void setNetworkUpdate2MapListener(NetworkUpdate2MapListener networkUpdate2MapListener) {
        d = networkUpdate2MapListener;
    }

    public static void unregisterNetworkCallback() {
        ConnectivityManager connectivityManager;
        a aVar;
        if (Build.VERSION.SDK_INT < 29 || (connectivityManager = c) == null || (aVar = b) == null || !f3543a) {
            return;
        }
        connectivityManager.unregisterNetworkCallback(aVar);
        f3543a = false;
    }

    public static void updateNetworkInfo2Map() {
        NetworkUpdate2MapListener networkUpdate2MapListener = d;
        if (networkUpdate2MapListener != null) {
            networkUpdate2MapListener.networkUpdate();
        }
    }

    public static void updateNetworkProxy(Context context) {
        SysUpdateObservable.getInstance().updateNetworkProxy(context);
    }

    public static boolean isWifiConnected(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || 1 != activeNetworkInfo.getType()) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }
}
