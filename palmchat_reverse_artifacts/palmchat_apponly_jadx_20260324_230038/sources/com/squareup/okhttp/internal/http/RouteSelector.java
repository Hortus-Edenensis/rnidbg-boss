package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.RouteDatabase;
import com.squareup.okhttp.internal.Dns;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class RouteSelector {
    private static final int TLS_MODE_COMPATIBLE = 0;
    private static final int TLS_MODE_MODERN = 1;
    private static final int TLS_MODE_NULL = -1;
    private final Address address;
    private final Dns dns;
    private boolean hasNextProxy;
    private InetSocketAddress lastInetSocketAddress;
    private Proxy lastProxy;
    private int nextSocketAddressIndex;
    private final ConnectionPool pool;
    private final ProxySelector proxySelector;
    private Iterator<Proxy> proxySelectorProxies;
    private final RouteDatabase routeDatabase;
    private InetAddress[] socketAddresses;
    private int socketPort;
    private final URI uri;
    private Proxy userSpecifiedProxy;
    private int nextTlsMode = -1;
    private final List<Route> postponedRoutes = new LinkedList();

    public RouteSelector(Address address, URI uri, ProxySelector proxySelector, ConnectionPool connectionPool, Dns dns, RouteDatabase routeDatabase) {
        this.address = address;
        this.uri = uri;
        this.proxySelector = proxySelector;
        this.pool = connectionPool;
        this.dns = dns;
        this.routeDatabase = routeDatabase;
        resetNextProxy(uri, address.getProxy());
    }

    private boolean hasNextInetSocketAddress() {
        return this.socketAddresses != null;
    }

    private boolean hasNextPostponed() {
        return !this.postponedRoutes.isEmpty();
    }

    private boolean hasNextProxy() {
        return this.hasNextProxy;
    }

    private boolean hasNextTlsMode() {
        return this.nextTlsMode != -1;
    }

    private InetSocketAddress nextInetSocketAddress() throws UnknownHostException {
        InetAddress[] inetAddressArr = this.socketAddresses;
        int i = this.nextSocketAddressIndex;
        this.nextSocketAddressIndex = i + 1;
        InetSocketAddress inetSocketAddress = new InetSocketAddress(inetAddressArr[i], this.socketPort);
        if (this.nextSocketAddressIndex == this.socketAddresses.length) {
            this.socketAddresses = null;
            this.nextSocketAddressIndex = 0;
        }
        return inetSocketAddress;
    }

    private Route nextPostponed() {
        return this.postponedRoutes.remove(0);
    }

    private Proxy nextProxy() {
        Proxy proxy = this.userSpecifiedProxy;
        if (proxy != null) {
            this.hasNextProxy = false;
            return proxy;
        }
        if (this.proxySelectorProxies != null) {
            while (this.proxySelectorProxies.hasNext()) {
                Proxy next = this.proxySelectorProxies.next();
                if (next.type() != Proxy.Type.DIRECT) {
                    return next;
                }
            }
        }
        this.hasNextProxy = false;
        return Proxy.NO_PROXY;
    }

    private int nextTlsMode() {
        int i = this.nextTlsMode;
        if (i == 1) {
            this.nextTlsMode = 0;
            return 1;
        }
        if (i != 0) {
            throw new AssertionError();
        }
        this.nextTlsMode = -1;
        return 0;
    }

    private void resetNextInetSocketAddress(Proxy proxy) throws UnknownHostException {
        String host;
        this.socketAddresses = null;
        if (proxy.type() == Proxy.Type.DIRECT) {
            host = this.uri.getHost();
            this.socketPort = Util.getEffectivePort(this.uri);
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            String hostName = inetSocketAddress.getHostName();
            this.socketPort = inetSocketAddress.getPort();
            host = hostName;
        }
        this.socketAddresses = this.dns.getAllByName(host);
        this.nextSocketAddressIndex = 0;
    }

    private void resetNextProxy(URI uri, Proxy proxy) {
        this.hasNextProxy = true;
        if (proxy != null) {
            this.userSpecifiedProxy = proxy;
            return;
        }
        List<Proxy> listSelect = this.proxySelector.select(uri);
        if (listSelect != null) {
            this.proxySelectorProxies = listSelect.iterator();
        }
    }

    private void resetNextTlsMode() {
        this.nextTlsMode = this.address.getSslSocketFactory() != null ? 1 : 0;
    }

    public void connectFailed(Connection connection, IOException iOException) {
        ProxySelector proxySelector;
        Route route = connection.getRoute();
        if (route.getProxy().type() != Proxy.Type.DIRECT && (proxySelector = this.proxySelector) != null) {
            proxySelector.connectFailed(this.uri, route.getProxy().address(), iOException);
        }
        this.routeDatabase.failed(route, iOException);
    }

    public boolean hasNext() {
        return hasNextTlsMode() || hasNextInetSocketAddress() || hasNextProxy() || hasNextPostponed();
    }

    public Connection next(String str) throws IOException {
        Connection connection;
        while (true) {
            connection = this.pool.get(this.address);
            if (connection == null) {
                if (!hasNextTlsMode()) {
                    if (!hasNextInetSocketAddress()) {
                        if (!hasNextProxy()) {
                            if (hasNextPostponed()) {
                                return new Connection(nextPostponed());
                            }
                            throw new NoSuchElementException();
                        }
                        Proxy proxyNextProxy = nextProxy();
                        this.lastProxy = proxyNextProxy;
                        resetNextInetSocketAddress(proxyNextProxy);
                    }
                    this.lastInetSocketAddress = nextInetSocketAddress();
                    resetNextTlsMode();
                }
                Route route = new Route(this.address, this.lastProxy, this.lastInetSocketAddress, nextTlsMode() == 1);
                if (!this.routeDatabase.shouldPostpone(route)) {
                    return new Connection(route);
                }
                this.postponedRoutes.add(route);
                return next(str);
            }
            if (str.equals("GET") || connection.isReadable()) {
                break;
            }
            connection.close();
        }
        return connection;
    }
}
