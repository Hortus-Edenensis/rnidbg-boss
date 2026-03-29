package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class Address {
    final OkAuthenticator authenticator;
    final HostnameVerifier hostnameVerifier;
    final Proxy proxy;
    final SSLSocketFactory sslSocketFactory;
    final List<String> transports;
    final String uriHost;
    final int uriPort;

    public Address(String str, int i, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, OkAuthenticator okAuthenticator, Proxy proxy, List<String> list) throws UnknownHostException {
        if (str == null) {
            throw new NullPointerException("uriHost == null");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("uriPort <= 0: " + i);
        }
        if (okAuthenticator == null) {
            throw new IllegalArgumentException("authenticator == null");
        }
        if (list == null) {
            throw new IllegalArgumentException("transports == null");
        }
        this.proxy = proxy;
        this.uriHost = str;
        this.uriPort = i;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.authenticator = okAuthenticator;
        this.transports = Util.immutableList(list);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Address)) {
            return false;
        }
        Address address = (Address) obj;
        return Util.equal(this.proxy, address.proxy) && this.uriHost.equals(address.uriHost) && this.uriPort == address.uriPort && Util.equal(this.sslSocketFactory, address.sslSocketFactory) && Util.equal(this.hostnameVerifier, address.hostnameVerifier) && Util.equal(this.authenticator, address.authenticator) && Util.equal(this.transports, address.transports);
    }

    public OkAuthenticator getAuthenticator() {
        return this.authenticator;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public List<String> getTransports() {
        return this.transports;
    }

    public String getUriHost() {
        return this.uriHost;
    }

    public int getUriPort() {
        return this.uriPort;
    }

    public int hashCode() {
        int iHashCode = (((527 + this.uriHost.hashCode()) * 31) + this.uriPort) * 31;
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactory;
        int iHashCode2 = (iHashCode + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.hostnameVerifier;
        int iHashCode3 = (iHashCode2 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        OkAuthenticator okAuthenticator = this.authenticator;
        int iHashCode4 = (iHashCode3 + (okAuthenticator != null ? okAuthenticator.hashCode() : 0)) * 31;
        Proxy proxy = this.proxy;
        return ((iHashCode4 + (proxy != null ? proxy.hashCode() : 0)) * 31) + this.transports.hashCode();
    }
}
