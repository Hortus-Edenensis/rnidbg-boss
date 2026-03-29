package cn.fly.verify;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class au {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ConnectivityManager f2076a;
    private static au c;
    public volatile Network b;
    private ConnectivityManager.NetworkCallback d;

    private au(Context context) {
        try {
            f2076a = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Throwable unused) {
        }
    }

    public static au a(Context context) {
        if (c == null) {
            synchronized (au.class) {
                if (c == null) {
                    c = new au(context);
                }
            }
        }
        return c;
    }

    public void a() {
        try {
            if (f2076a != null && this.d != null) {
                this.b = null;
                f2076a.unregisterNetworkCallback(this.d);
            }
            aj.b();
            f.a().b("[FlyVerify] ==>%s", "release cell");
        } catch (Throwable unused) {
        }
    }
}
