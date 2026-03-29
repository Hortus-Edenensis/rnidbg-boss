package cn.fly.verify;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.SystemClock;
import cn.fly.verify.common.exception.VerifyErr;
import cn.fly.verify.common.exception.VerifyException;
import cn.fly.verify.fq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class aj {
    private static List<Network> d = new ArrayList();
    private static List<ConnectivityManager.NetworkCallback> e = new ArrayList();
    private static HashMap<String, Network> g = new HashMap<>();
    private Network b;
    private ConnectivityManager.NetworkCallback c;
    private long f = 3000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConnectivityManager f2065a = (ConnectivityManager) fq.d.a("connectivity");

    public static void b() {
        if (e.size() > 0) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) fq.d.a("connectivity");
                Iterator<ConnectivityManager.NetworkCallback> it = e.iterator();
                while (it.hasNext()) {
                    connectivityManager.unregisterNetworkCallback(it.next());
                }
                e.clear();
                if (d.size() > 0) {
                    d.clear();
                }
            } catch (Throwable th) {
                f.a().b(th);
            }
            f.a().b("[FlyVerify] ==>%s", "release");
        }
    }

    public Network c() throws VerifyException {
        try {
            f.a().b("[FlyVerify] ==>%s", "Force switch network");
            if (!fq.d.b("android.permission.CHANGE_NETWORK_STATE")) {
                VerifyException verifyException = new VerifyException(VerifyErr.INNER_NO_SWITCH_PERMISSION_ERR);
                f.a().c("[FlyVerify] ==>%s", "switch no permission");
                throw verifyException;
            }
            this.b = null;
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(0);
            NetworkRequest networkRequestBuild = builder.build();
            ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: cn.fly.verify.aj.2
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    aj.this.b = network;
                    aj.d.add(network);
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                }
            };
            this.c = networkCallback;
            this.f2065a.requestNetwork(networkRequestBuild, networkCallback);
            e.add(this.c);
            long j = 0;
            do {
                Network network = this.b;
                if (network != null) {
                    return network;
                }
                j++;
                SystemClock.sleep(50L);
            } while (j <= this.f / 50);
            f.a().c("[FlyVerify] ==>%s", "switch timeout");
            throw new VerifyException(VerifyErr.INNER_SWITCH_EXCEPTION_ERR.getCode(), "switch_timeout");
        } catch (Throwable th) {
            f.a().c("[FlyVerify] ==>%s", "switch failure " + th);
            if (th instanceof VerifyException) {
                throw th;
            }
            throw new VerifyException(VerifyErr.INNER_SWITCH_EXCEPTION_ERR.getCode(), as.a(th));
        }
    }

    public void a() {
        new ar() { // from class: cn.fly.verify.aj.1
            @Override // cn.fly.verify.ar
            public void a() {
                synchronized (aj.g) {
                    String strD = al.d();
                    try {
                        if (!aj.g.containsKey(strD)) {
                            long jUptimeMillis = SystemClock.uptimeMillis();
                            f.a().a("switchNetworkAsync ");
                            Network networkC = aj.this.c();
                            if (networkC != null) {
                                aj.g.put(strD, networkC);
                            }
                            f.a().a("switchNetworkAsync complete " + (SystemClock.uptimeMillis() - jUptimeMillis));
                        }
                    } catch (VerifyException unused) {
                    }
                }
            }
        }.b();
    }
}
