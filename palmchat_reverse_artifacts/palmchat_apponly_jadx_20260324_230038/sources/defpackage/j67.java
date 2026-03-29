package defpackage;

import android.annotation.TargetApi;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.cdadata.sdk.api.ZMDataSDKManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(21)
public class j67 extends ConnectivityManager.NetworkCallback {
    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        super.onAvailable(network);
        e67.c = null;
        ZMDataSDKManager.getInstance().getZMDataActivityLifecycleCallbacks().f("AppNetChange", false);
        g57.b("NetworkUtils", "网络可用");
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        super.onCapabilitiesChanged(network, networkCapabilities);
        e67.c = null;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        super.onLost(network);
        e67.c = null;
        g57.b("NetworkUtils", "网络丢失");
    }
}
