package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.g;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Vulpecula {
    public static boolean a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return false;
            }
            for (NetworkInterface networkInterface : Collections.list(networkInterfaces)) {
                if (networkInterface.isUp() && networkInterface.getInterfaceAddresses().size() != 0 && networkInterface.getName().matches("tun\\d+")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(Context context) {
        List<WifiConfiguration> configuredNetworks;
        if (!TextUtils.isEmpty(System.getProperty("http.proxyHost")) && !TextUtils.equals(System.getProperty("http.proxyPort"), "-1")) {
            return true;
        }
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (Triangulum.a(context, g.d) != 0) {
            return false;
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null && connectionInfo.getNetworkId() != -1) {
                Object objInvoke = null;
                try {
                    configuredNetworks = wifiManager.getConfiguredNetworks();
                } catch (Throwable unused) {
                    configuredNetworks = null;
                }
                if (configuredNetworks != null) {
                    int networkId = connectionInfo.getNetworkId();
                    Iterator<WifiConfiguration> it = configuredNetworks.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        WifiConfiguration next = it.next();
                        if (next.networkId == networkId) {
                            try {
                                Method methodA = Apple.a((Class<?>) WifiConfiguration.class, "getProxySettings", (Class<?>[]) new Class[0]);
                                if (methodA != null) {
                                    objInvoke = methodA.invoke(next, new Object[0]);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                            Object objA = Apple.a("android.net.IpConfiguration$ProxySettings", "STATIC");
                            if (objA != null && objA == objInvoke) {
                                return true;
                            }
                            Object objA2 = Apple.a("android.net.IpConfiguration$ProxySettings", "PAC");
                            if (objA2 == null || objA2 != objInvoke) {
                                break;
                            }
                            return true;
                        }
                    }
                } else {
                    return false;
                }
            }
        } catch (Throwable unused2) {
        }
        return false;
    }
}
