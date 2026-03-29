package cn.shuzilm.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class h extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f2478a;

    public h(Context context) {
        this.f2478a = context;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        super.onAvailable(network);
        try {
            DUHelper.oxlbmV0d(this.f2478a, network, 1);
        } catch (Throwable unused) {
        }
    }
}
