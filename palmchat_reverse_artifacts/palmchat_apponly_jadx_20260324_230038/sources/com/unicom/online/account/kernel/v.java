package com.unicom.online.account.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f11172a = "v";
    private static Boolean b = Boolean.TRUE;

    private static String a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                        return inetAddressNextElement.getHostAddress();
                    }
                }
            }
            return null;
        } catch (SocketException unused) {
            return null;
        }
    }

    private static String b(Context context, String str, String str2) {
        String strA = ad.a(context);
        String strA2 = a();
        if (!ag.a(strA2).booleanValue()) {
            return null;
        }
        return "accessCode" + strA + strA2 + str + str2;
    }

    public static String a(Context context, String str, String str2) {
        try {
            String strB = b(context, str, str2);
            if (ag.a(strB).booleanValue()) {
                return ae.a(context, strB);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("cuAuthCacheName", 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        for (String str : sharedPreferences.getAll().keySet()) {
            if (str.startsWith("accessCode")) {
                editorEdit.remove(str);
            }
        }
        editorEdit.commit();
    }

    public static boolean a(Context context, String str, String str2, String str3) {
        if (!ag.a(str3).booleanValue()) {
            return false;
        }
        String strB = b(context, str, str2);
        if (ag.a(strB).booleanValue()) {
            return ae.a(context, strB, str3);
        }
        return false;
    }
}
