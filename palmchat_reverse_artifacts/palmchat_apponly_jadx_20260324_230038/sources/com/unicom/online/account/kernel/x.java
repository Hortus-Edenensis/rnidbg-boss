package com.unicom.online.account.kernel;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class x {
    private static x f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Network f11174a = null;
    private ConnectivityManager.NetworkCallback b = null;
    private ConnectivityManager c = null;
    private List<a> d = new ArrayList();
    private Timer e = null;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(boolean z, Object obj);
    }

    private x() {
    }

    public final synchronized void b() {
        ConnectivityManager.NetworkCallback networkCallback;
        try {
            Timer timer = this.e;
            if (timer != null) {
                timer.cancel();
                this.e = null;
            }
            ConnectivityManager connectivityManager = this.c;
            if (connectivityManager != null && (networkCallback = this.b) != null) {
                connectivityManager.unregisterNetworkCallback(networkCallback);
            }
            this.c = null;
            this.b = null;
            this.f11174a = null;
            this.d.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static x a() {
        if (f == null) {
            synchronized (x.class) {
                if (f == null) {
                    f = new x();
                }
            }
        }
        return f;
    }

    @TargetApi(21)
    public final synchronized void a(Context context, a aVar) {
        Network network = this.f11174a;
        if (network != null) {
            aVar.a(true, network);
            return;
        }
        a(aVar);
        if (this.b == null || this.d.size() < 2) {
            try {
                this.c = (ConnectivityManager) context.getSystemService("connectivity");
                NetworkRequest.Builder builder = new NetworkRequest.Builder();
                builder.addTransportType(0);
                builder.addCapability(12);
                NetworkRequest networkRequestBuild = builder.build();
                this.b = new ConnectivityManager.NetworkCallback() { // from class: com.unicom.online.account.kernel.x.1
                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public final void onAvailable(Network network2) {
                        super.onAvailable(network2);
                        ab.b("Network onAvailable");
                        x.this.f11174a = network2;
                        x.this.a(true, network2);
                        try {
                            String extraInfo = x.this.c.getNetworkInfo(x.this.f11174a).getExtraInfo();
                            if (TextUtils.isEmpty(extraInfo)) {
                                return;
                            }
                            ac.d(extraInfo);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public final void onLost(Network network2) {
                        super.onLost(network2);
                        ab.b("Network onLost");
                        x.this.b();
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public final void onUnavailable() {
                        super.onUnavailable();
                        ab.b("Network onUnavailable");
                        x.this.a(false, (Network) null);
                        x.this.b();
                    }
                };
                int i = 3000;
                if (ac.g() < 3000) {
                    i = 2000;
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    this.c.requestNetwork(networkRequestBuild, this.b, i);
                    return;
                }
                Timer timer = new Timer();
                this.e = timer;
                timer.schedule(new TimerTask() { // from class: com.unicom.online.account.kernel.x.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public final void run() {
                        x.this.a(false, (Network) null);
                    }
                }, i);
                this.c.requestNetwork(networkRequestBuild, this.b);
            } catch (Exception e) {
                e.printStackTrace();
                a(false, (Network) null);
            }
        }
    }

    private synchronized void a(a aVar) {
        try {
            this.d.add(aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, Network network) {
        try {
            Timer timer = this.e;
            if (timer != null) {
                timer.cancel();
                this.e = null;
            }
            Iterator<a> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().a(z, network);
            }
            this.d.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
