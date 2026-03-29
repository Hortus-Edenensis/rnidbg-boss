package com.kwad.sdk.mobileid.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    private ConnectivityManager.NetworkCallback aYl;
    private ConnectivityManager aYm;
    private volatile boolean aYn = false;

    /* JADX INFO: renamed from: com.kwad.sdk.mobileid.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0631a {
        void Pn();
    }

    private static ConnectivityManager ct(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    public final void Pi() {
        synchronized (this) {
            ConnectivityManager.NetworkCallback networkCallback = this.aYl;
            if (networkCallback == null) {
                return;
            }
            try {
                ConnectivityManager connectivityManager = this.aYm;
                if (connectivityManager != null) {
                    connectivityManager.unregisterNetworkCallback(networkCallback);
                }
            } catch (Exception e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
            if (Build.VERSION.SDK_INT >= 23) {
                this.aYm.bindProcessToNetwork(null);
            }
            this.aYl = null;
        }
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.aYn = true;
        return true;
    }

    @SuppressLint({"MissingPermission"})
    public final void a(Context context, final InterfaceC0631a interfaceC0631a) {
        synchronized (this) {
            this.aYm = ct(context);
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addTransportType(0).addCapability(12).build();
                    if (this.aYl == null) {
                        this.aYl = new ConnectivityManager.NetworkCallback() { // from class: com.kwad.sdk.mobileid.a.a.a.1
                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public final void onAvailable(Network network) {
                                a.this.aYm.bindProcessToNetwork(network);
                                if (interfaceC0631a != null && !a.this.aYn) {
                                    interfaceC0631a.Pn();
                                }
                                a.a(a.this, true);
                            }

                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public final void onLost(Network network) {
                                a.this.aYm.bindProcessToNetwork(null);
                                c.d("MobileIdManager.RequestMobileDataOnWifiHelper", "onLost unbindNetwork");
                                a.this.Pi();
                            }

                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public final void onUnavailable() {
                                a.this.aYm.bindProcessToNetwork(null);
                                c.d("MobileIdManager.RequestMobileDataOnWifiHelper", "onUnavailable unbindNetwork");
                                a.this.Pi();
                            }
                        };
                    }
                    if (!this.aYn) {
                        this.aYm.requestNetwork(networkRequestBuild, this.aYl);
                    } else {
                        c.d("MobileIdManager.RequestMobileDataOnWifiHelper", "isRequestUaidToken is true unbindNetwork");
                        Pi();
                    }
                }
            } catch (Exception e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
        }
    }
}
