package defpackage;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import com.zenmen.palmchat.c;
import defpackage.b05;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class zh6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Boolean f22429a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static zh6 f22430a = new zh6();
    }

    public static zh6 c() {
        return a.f22430a;
    }

    public static /* synthetic */ Object f(Exception exc) {
        return "checkVpnStatus error: " + exc.getMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object g() {
        return "vpn status updated: " + this.f22429a;
    }

    public final boolean d() {
        NetworkCapabilities networkCapabilities;
        if (r75.l()) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) c.b().getSystemService("connectivity");
                if (connectivityManager == null) {
                    return false;
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    Network activeNetwork = connectivityManager.getActiveNetwork();
                    if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
                        return networkCapabilities.hasTransport(4);
                    }
                } else {
                    Network[] allNetworks = connectivityManager.getAllNetworks();
                    if (allNetworks != null) {
                        for (Network network : allNetworks) {
                            NetworkCapabilities networkCapabilities2 = connectivityManager.getNetworkCapabilities(network);
                            if (networkCapabilities2 != null && networkCapabilities2.hasTransport(4)) {
                                return true;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                b05.c(new b05.a() { // from class: yh6
                    @Override // b05.a
                    public final Object getValue() {
                        return zh6.f(e);
                    }
                });
            }
        }
        return false;
    }

    public boolean e() {
        if (this.f22429a == null) {
            this.f22429a = Boolean.valueOf(d());
        }
        return this.f22429a.booleanValue();
    }

    public void h() {
        this.f22429a = Boolean.valueOf(d());
        b05.c(new b05.a() { // from class: xh6
            @Override // b05.a
            public final Object getValue() {
                return this.f21964a.g();
            }
        });
    }

    public zh6() {
        this.f22429a = null;
    }
}
