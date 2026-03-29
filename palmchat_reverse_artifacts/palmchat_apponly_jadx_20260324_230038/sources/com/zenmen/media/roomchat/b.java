package com.zenmen.media.roomchat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import com.igexin.sdk.PushConsts;
import com.zenmen.media.roomchat.NetworkUtil;
import com.zenmen.palmchat.AppContext;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b extends BroadcastReceiver {
    public static Context d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NetworkUtil.NetworkType f11971a = NetworkUtil.e(RTCParameters.c());
    public List<InterfaceC0935b> b = new ArrayList();
    public String c;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f11972a = new b();
    }

    /* JADX INFO: renamed from: com.zenmen.media.roomchat.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0935b {
        void a();

        void b(NetworkUtil.NetworkType networkType);
    }

    public static String a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return null;
            }
            if (activeNetworkInfo.getType() != 0) {
                if (activeNetworkInfo.getType() == 1) {
                    return b(((WifiManager) AppContext.getContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getIpAddress());
                }
                return null;
            }
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
            } catch (SocketException e) {
                e.printStackTrace();
                return null;
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    public static void d(InterfaceC0935b interfaceC0935b) {
        if (interfaceC0935b == null || a.f11972a.b.contains(interfaceC0935b)) {
            return;
        }
        a.f11972a.b.add(interfaceC0935b);
    }

    public static void e(Context context) {
        context.registerReceiver(a.f11972a, new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
        d = context;
    }

    public static void f(InterfaceC0935b interfaceC0935b) {
        if (interfaceC0935b == null || a.f11972a.b == null) {
            return;
        }
        try {
            a.f11972a.b.remove(interfaceC0935b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void g(Context context) {
        if (context != null) {
            try {
                context.unregisterReceiver(a.f11972a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void c(NetworkUtil.NetworkType networkType) {
        String strA = a(d);
        Log.i("NetStateChangeReceiver", "networkType:" + networkType + " ipaddress:" + strA);
        if (this.f11971a == networkType && this.c == strA) {
            return;
        }
        this.c = strA;
        this.f11971a = networkType;
        try {
            if (networkType == NetworkUtil.NetworkType.NETWORK_NO) {
                for (InterfaceC0935b interfaceC0935b : this.b) {
                    if (interfaceC0935b != null) {
                        interfaceC0935b.a();
                    }
                }
                return;
            }
            for (InterfaceC0935b interfaceC0935b2 : this.b) {
                if (interfaceC0935b2 != null) {
                    interfaceC0935b2.b(networkType);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.i("NetStateChangeReceiver", "onReceive 1 " + this.f11971a);
        if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(intent.getAction())) {
            c(NetworkUtil.e(context));
        }
    }
}
