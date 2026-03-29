package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.ax;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class i extends ProxySelector {
    private static final List<Proxy> aQd = Arrays.asList(Proxy.NO_PROXY);
    private final ProxySelector aQe;
    private final String aQf;
    private final int aQg;

    private i(ProxySelector proxySelector, String str, int i) {
        this.aQe = (ProxySelector) ax.checkNotNull(proxySelector);
        this.aQf = ax.hy(str);
        this.aQg = i;
    }

    public static void install(String str, int i) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public final void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.aQe.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public final List<Proxy> select(URI uri) {
        return this.aQf.equals(uri.getHost()) && this.aQg == uri.getPort() ? aQd : this.aQe.select(uri);
    }
}
