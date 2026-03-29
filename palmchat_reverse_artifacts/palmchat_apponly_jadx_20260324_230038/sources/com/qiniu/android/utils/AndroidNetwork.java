package com.qiniu.android.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;
import android.telephony.TelephonyManager;
import com.kuaishou.weapon.p0.g;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class AndroidNetwork {
    public static String getHostIP() {
        String hostAddress = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return null;
            }
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddressNextElement = inetAddresses.nextElement();
                        if (!inetAddressNextElement.isLinkLocalAddress() && !inetAddressNextElement.isLoopbackAddress()) {
                            hostAddress = inetAddressNextElement.getHostAddress();
                            break;
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return hostAddress;
    }

    private static String getNetWorkClass(Context context) {
        TelephonyManager telephonyManager;
        if (context.checkPermission(g.c, Process.myPid(), Process.myUid()) != 0 || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
            return "none";
        }
        switch (telephonyManager.getNetworkType()) {
        }
        return "none";
    }

    public static boolean isNetWorkReady() {
        Context contextApplicationContext = ContextGetter.applicationContext();
        if (contextApplicationContext == null) {
            return true;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) contextApplicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static String networkType(Context context) {
        try {
            return networkTypeWithException(context);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String networkTypeWithException(Context context) throws Exception {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                return "wifi";
            }
            if (type == 0) {
                return getNetWorkClass(context);
            }
        }
        return "none";
    }
}
