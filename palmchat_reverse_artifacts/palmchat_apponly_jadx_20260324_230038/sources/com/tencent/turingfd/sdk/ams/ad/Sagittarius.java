package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.huawei.openalliance.ad.constant.x;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Sagittarius {
    public static byte a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return (byte) -1;
            }
            if (activeNetworkInfo.getState() != NetworkInfo.State.CONNECTING && activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
                return (byte) -1;
            }
            if (activeNetworkInfo.getType() == 1) {
                return (byte) 0;
            }
            if (activeNetworkInfo.getType() != 0) {
                return (byte) 3;
            }
            if (Proxy.getDefaultHost() == null) {
                return Proxy.getHost(context) != null ? (byte) 2 : (byte) 1;
            }
            return (byte) 2;
        } catch (Throwable th) {
            String message = th.getMessage();
            return (message == null || !message.contains("ACCESS_NETWORK_STATE")) ? (byte) -3 : (byte) -2;
        }
    }

    public static String b(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean c(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            String message = th.getMessage();
            return message != null && message.contains("ACCESS_NETWORK_STATE");
        }
    }

    public static String a() {
        Context context;
        Context context2;
        Long lValueOf;
        Long lValueOf2;
        String string;
        if (Build.VERSION.SDK_INT < 23) {
            return null;
        }
        synchronized (Ccase.class) {
            context = Ccase.f10751a;
        }
        Network activeNetwork = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetwork();
        if (activeNetwork == null) {
            return null;
        }
        try {
            synchronized (Ccase.class) {
                context2 = Ccase.f10751a;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            Object objA = Almond.a(networkCapabilities.getClass(), "mTransportTypes", networkCapabilities);
            long j = 0;
            if (objA instanceof Long) {
                lValueOf = (Long) objA;
            } else {
                long j2 = 0;
                for (int i = 0; i < 64; i++) {
                    if (networkCapabilities.hasTransport(i)) {
                        j2 |= 1 << i;
                    }
                }
                lValueOf = Long.valueOf(j2);
            }
            sb.append(lValueOf);
            sb.append(",");
            Object objA2 = Almond.a(networkCapabilities.getClass(), "mNetworkCapabilities", networkCapabilities);
            if (objA2 instanceof Long) {
                lValueOf2 = (Long) objA2;
            } else {
                for (int i2 = 0; i2 < 64; i2++) {
                    if (networkCapabilities.hasCapability(i2)) {
                        j |= 1 << i2;
                    }
                }
                lValueOf2 = Long.valueOf(j);
            }
            sb.append(lValueOf2);
            LinkProperties linkProperties = connectivityManager.getLinkProperties(activeNetwork);
            if (linkProperties == null) {
                string = sb.toString();
            } else {
                String interfaceName = linkProperties.getInterfaceName();
                int i3 = Damson.f10689a;
                if (interfaceName == null) {
                    interfaceName = "";
                }
                String strReplace = interfaceName.replace(",", "").replace(x.aQ, "");
                sb.append(",");
                sb.append(strReplace);
                sb.append(",");
                List<LinkAddress> linkAddresses = linkProperties.getLinkAddresses();
                if (!Cimport.a(linkAddresses)) {
                    for (int i4 = 0; i4 < linkAddresses.size(); i4++) {
                        sb.append(linkAddresses.get(i4).getAddress().getHostAddress());
                        if (i4 != linkAddresses.size() - 1) {
                            sb.append(x.aQ);
                        }
                    }
                }
                sb.append(",");
                List<InetAddress> dnsServers = linkProperties.getDnsServers();
                if (!Cimport.a(dnsServers)) {
                    for (int i5 = 0; i5 < dnsServers.size(); i5++) {
                        sb.append(dnsServers.get(i5).getHostAddress());
                        if (i5 != dnsServers.size() - 1) {
                            sb.append(x.aQ);
                        }
                    }
                }
                string = sb.toString();
            }
            return string;
        } catch (Throwable unused) {
            return null;
        }
    }
}
