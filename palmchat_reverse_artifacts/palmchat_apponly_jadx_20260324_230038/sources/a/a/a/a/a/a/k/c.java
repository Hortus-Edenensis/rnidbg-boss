package a.a.a.a.a.a.k;

import a.a.a.a.a.a.g;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c f1062a;
    public ConnectivityManager b;
    public Network c;
    public ConnectivityManager.NetworkCallback d;
    public boolean e;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f1063a;

        public a(b bVar) {
            this.f1063a = bVar;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            try {
                c.this.c = network;
                this.f1063a.a(network);
                c.this.e = false;
            } catch (Exception unused) {
                c.this.c = null;
                this.f1063a.a(null);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            c.this.e = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(Network network);
    }

    public c(Context context) {
        try {
            this.b = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static c a(Context context) {
        if (f1062a == null) {
            synchronized (c.class) {
                if (f1062a == null) {
                    f1062a = new c(context);
                }
            }
        }
        return f1062a;
    }

    public void a(b bVar) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = this.b;
        if (connectivityManager != null) {
            Network network = this.c;
            if (network != null && !this.e && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.isAvailable()) {
                ((g.a) bVar).a(this.c);
                return;
            }
            ConnectivityManager.NetworkCallback networkCallback = this.d;
            if (networkCallback != null) {
                try {
                    this.b.unregisterNetworkCallback(networkCallback);
                } catch (Exception unused) {
                    this.d = null;
                }
            }
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
            a aVar = new a(bVar);
            this.d = aVar;
            try {
                this.b.requestNetwork(networkRequestBuild, aVar);
                return;
            } catch (Exception unused2) {
            }
        }
        ((g.a) bVar).a(null);
    }

    public static boolean a(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }
}
