package com.baidu.bdhttpdns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BDNetworkStateChangeReceiver extends BroadcastReceiver {
    private static boolean f = true;
    private static boolean g = true;
    private boolean b = false;
    private boolean c = true;
    private boolean d = true;
    private String e = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ExecutorService f3347a = Executors.newFixedThreadPool(1);

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Callable<Object> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            DatagramSocket datagramSocket;
            DatagramSocket datagramSocket2;
            InetSocketAddress inetSocketAddress = new InetSocketAddress("2001:4860:4860::8888", 443);
            InetSocketAddress inetSocketAddress2 = new InetSocketAddress("180.76.76.76", 80);
            try {
                datagramSocket = new DatagramSocket();
            } catch (SocketException unused) {
                datagramSocket = null;
            }
            try {
                datagramSocket.connect(inetSocketAddress2);
                boolean unused2 = BDNetworkStateChangeReceiver.g = true;
            } catch (SocketException unused3) {
                boolean unused4 = BDNetworkStateChangeReceiver.g = false;
            }
            if (datagramSocket != null) {
                try {
                    datagramSocket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                datagramSocket2 = new DatagramSocket();
                try {
                    datagramSocket2.connect(inetSocketAddress);
                    boolean unused5 = BDNetworkStateChangeReceiver.f = true;
                } catch (SocketException unused6) {
                    datagramSocket = datagramSocket2;
                    boolean unused7 = BDNetworkStateChangeReceiver.f = false;
                    datagramSocket2 = datagramSocket;
                }
            } catch (SocketException unused8) {
            }
            if (datagramSocket2 != null) {
                try {
                    datagramSocket2.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            l.a("isIPv4Reachable(%s), isIPv6Reachable(%s)", Boolean.valueOf(BDNetworkStateChangeReceiver.g), Boolean.valueOf(BDNetworkStateChangeReceiver.f));
            return null;
        }
    }

    private void a(Context context) {
        l.a("Network change, clearCache(%b) httpDnsPrefetch(%b)", Boolean.valueOf(this.c), Boolean.valueOf(this.d));
        i iVarA = i.a();
        iVarA.b();
        BDHttpDns service = BDHttpDns.getService(context);
        refreshIpReachable();
        ArrayList<String> arrayListB = service.a().b();
        if (this.c) {
            service.a().a();
            service.b().a();
        }
        if (!this.d || arrayListB == null || arrayListB.isEmpty()) {
            return;
        }
        iVarA.a(arrayListB, new k(context));
    }

    public static boolean isIPv4Reachable() {
        return g;
    }

    public static boolean isIPv6Reachable() {
        return f;
    }

    public void b(boolean z) {
        this.d = z;
    }

    public boolean isIPv6Only() {
        return !g && f;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:10|(1:(6:21|41|22|(1:25)|36|37)(1:19))(1:14)|15|41|22|(1:25)|36|37) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005b, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
    
        r6 = r0;
        r0 = r9;
        r9 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0061, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0064, code lost:
    
        a(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0069, code lost:
    
        r8.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006c, code lost:
    
        r0 = r9;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        String string;
        ConnectivityManager connectivityManager;
        String extraInfo;
        String str = "";
        if (!this.b) {
            this.b = true;
            return;
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (RuntimeException e) {
            e = e;
        }
        if (connectivityManager == null) {
            a(context);
            return;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
            extraInfo = networkInfo.getExtraInfo();
        } else {
            if (networkInfo2 == null || networkInfo2.getState() != NetworkInfo.State.CONNECTED) {
                string = "";
                if (!this.e.equals(string) && string != "") {
                    l.a("Current net type: %s.", string);
                    a(context);
                }
                this.e = string;
            }
            extraInfo = networkInfo2.getExtraInfo();
        }
        string = extraInfo.toString();
        if (!this.e.equals(string)) {
            l.a("Current net type: %s.", string);
            a(context);
        }
        this.e = string;
    }

    public void refreshIpReachable() {
        this.f3347a.submit(new a());
    }

    public void a(boolean z) {
        this.c = z;
    }
}
