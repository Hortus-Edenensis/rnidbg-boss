package com.zx.a.I8b7;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class m2 {

    /* JADX INFO: compiled from: SearchBox */
    @SuppressLint({"NewApi"})
    public class a extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ConnectivityManager f16827a;
        public b b;
        public TimerTask d;
        public final AtomicBoolean e = new AtomicBoolean(false);
        public Timer c = new Timer();

        /* JADX INFO: renamed from: com.zx.a.I8b7.m2$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1178a extends TimerTask {
            public C1178a(m2 m2Var) {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    b bVar = a.this.b;
                    if (bVar != null) {
                        bVar.a(1, "time out 7s!");
                    }
                } catch (Throwable th) {
                    r2.a(th);
                }
            }
        }

        public a(m2 m2Var, ConnectivityManager connectivityManager, b bVar) {
            this.f16827a = connectivityManager;
            this.b = bVar;
            C1178a c1178a = new C1178a(m2Var);
            this.d = c1178a;
            this.c.schedule(c1178a, 7000L);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            try {
                if (this.e.getAndSet(true)) {
                    return;
                }
                this.d.cancel();
                this.c.cancel();
                this.b.a(network);
                this.f16827a.unregisterNetworkCallback(this);
            } catch (Throwable th) {
                r2.a(th);
                b bVar = this.b;
                if (bVar != null) {
                    try {
                        bVar.a(1, th.getMessage());
                        this.f16827a.unregisterNetworkCallback(this);
                    } catch (Throwable th2) {
                        r2.a(th2);
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a();

        void a(int i, String str);

        void a(Network network);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m2 f16829a = new m2();
    }

    public void a(b bVar) throws Throwable {
        boolean zA = w3.a(m3.f16830a, com.kuaishou.weapon.p0.g.d, false);
        boolean zA2 = w3.a(m3.f16830a, "android.permission.CHANGE_NETWORK_STATE", false);
        if (zA && zA2 && a(m3.f16830a)) {
            if (!b(m3.f16830a)) {
                bVar.a();
                return;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) m3.f16830a.getSystemService("connectivity");
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(0);
            connectivityManager.requestNetwork(builder.build(), new a(this, connectivityManager, bVar));
        }
    }

    public boolean b(Context context) {
        if (!((WifiManager) context.getSystemService("wifi")).isWifiEnabled()) {
            return false;
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        return wifiManager.isWifiEnabled() && (connectionInfo == null ? 0 : connectionInfo.getIpAddress()) != 0;
    }

    public boolean a(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 24) {
                return true;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return ((Boolean) telephonyManager.getClass().getDeclaredMethod("getDataEnabled", new Class[0]).invoke(telephonyManager, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return true;
        }
    }
}
