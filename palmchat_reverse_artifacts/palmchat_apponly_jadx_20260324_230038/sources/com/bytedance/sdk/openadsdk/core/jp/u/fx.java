package com.bytedance.sdk.openadsdk.core.jp.u;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private static volatile fx u;
    private nr b;
    private Network fx;
    private ConnectivityManager nr;
    private boolean pn;

    /* JADX INFO: compiled from: SearchBox */
    public static class nr extends ConnectivityManager.NetworkCallback {
        private AtomicBoolean fx = new AtomicBoolean(false);
        private final fx nr;
        private u u;

        public nr(u uVar, fx fxVar) {
            this.u = uVar;
            this.nr = fxVar;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            if (this.fx.compareAndSet(false, true)) {
                try {
                    this.nr.fx = network;
                    this.u.u(network);
                    this.nr.pn = false;
                } catch (Exception unused) {
                    this.nr.fx = null;
                    this.u.u(null);
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            this.nr.pn = true;
        }

        public void u(u uVar) {
            this.u = uVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(Network network);
    }

    private fx(Context context) {
        try {
            this.nr = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void nr() {
        ConnectivityManager connectivityManager = this.nr;
        if (connectivityManager == null) {
            return;
        }
        try {
            try {
                nr nrVar = this.b;
                if (nrVar == null) {
                    return;
                }
                connectivityManager.unregisterNetworkCallback(nrVar);
            } finally {
                this.b = null;
                this.fx = null;
            }
        } catch (Exception unused) {
        }
    }

    public static fx u(Context context) {
        if (u == null) {
            synchronized (fx.class) {
                if (u == null) {
                    u = new fx(context);
                }
            }
        }
        return u;
    }

    private static boolean u(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public int u() {
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = this.nr;
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (Build.VERSION.SDK_INT >= 23) {
                    Network activeNetwork = this.nr.getActiveNetwork();
                    if (activeNetwork != null && (networkCapabilities = this.nr.getNetworkCapabilities(activeNetwork)) != null) {
                        boolean zHasTransport = networkCapabilities.hasTransport(4);
                        boolean zHasTransport2 = networkCapabilities.hasTransport(0);
                        boolean zHasTransport3 = networkCapabilities.hasTransport(1);
                        if (zHasTransport) {
                            return 4;
                        }
                        if (u(this.nr) && zHasTransport3) {
                            return 3;
                        }
                        if (zHasTransport3) {
                            return 1;
                        }
                        return zHasTransport2 ? 2 : 5;
                    }
                } else {
                    int type = activeNetworkInfo.getType();
                    return type == 1 ? u(this.nr) ? 3 : 1 : type == 0 ? 2 : 5;
                }
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public void u(u uVar) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = this.nr;
        if (connectivityManager == null) {
            uVar.u(null);
            return;
        }
        Network network = this.fx;
        if (network != null && !this.pn && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.isAvailable()) {
            uVar.u(this.fx);
            return;
        }
        nr nrVar = this.b;
        if (nrVar != null) {
            nrVar.u(uVar);
            return;
        }
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        nr nrVar2 = new nr(uVar, u);
        this.b = nrVar2;
        try {
            this.nr.requestNetwork(networkRequestBuild, nrVar2);
        } catch (Exception unused) {
            uVar.u(null);
        }
    }
}
