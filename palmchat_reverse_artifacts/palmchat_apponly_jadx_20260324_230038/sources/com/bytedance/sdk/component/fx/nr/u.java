package com.bytedance.sdk.component.fx.nr;

import com.bytedance.sdk.component.fx.nr.bg;
import com.ss.android.download.api.constant.BaseConstants;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SSLSocketFactory f5128a;
    final nr b;
    final SocketFactory fx;
    final List<t> iz;
    final HostnameVerifier jk;
    final Proxy n;
    final k nr;
    final List<qq> pn;
    final x t;
    final bg u;
    final ProxySelector x;

    public u(String str, int i, k kVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, x xVar, nr nrVar, Proxy proxy, List<qq> list, List<t> list2, ProxySelector proxySelector) {
        this.u = new bg.u().u(sSLSocketFactory != null ? BaseConstants.SCHEME_HTTPS : HttpHost.DEFAULT_SCHEME_NAME).b(str).u(i).fx();
        if (kVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.nr = kVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.fx = socketFactory;
        if (nrVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.b = nrVar;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.pn = com.bytedance.sdk.component.fx.nr.u.fx.u(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.iz = com.bytedance.sdk.component.fx.nr.u.fx.u(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.x = proxySelector;
        this.n = proxy;
        this.f5128a = sSLSocketFactory;
        this.jk = hostnameVerifier;
        this.t = xVar;
    }

    public SSLSocketFactory a() {
        return this.f5128a;
    }

    public nr b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.u.equals(uVar.u) && u(uVar);
    }

    public SocketFactory fx() {
        return this.fx;
    }

    public int hashCode() {
        int iHashCode = (((((((((((this.u.hashCode() + 527) * 31) + this.nr.hashCode()) * 31) + this.b.hashCode()) * 31) + this.pn.hashCode()) * 31) + this.iz.hashCode()) * 31) + this.x.hashCode()) * 31;
        Proxy proxy = this.n;
        int iHashCode2 = (iHashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f5128a;
        int iHashCode3 = (iHashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.jk;
        int iHashCode4 = (iHashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        x xVar = this.t;
        return iHashCode4 + (xVar != null ? xVar.hashCode() : 0);
    }

    public List<t> iz() {
        return this.iz;
    }

    public HostnameVerifier jk() {
        return this.jk;
    }

    public Proxy n() {
        return this.n;
    }

    public k nr() {
        return this.nr;
    }

    public List<qq> pn() {
        return this.pn;
    }

    public x t() {
        return this.t;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Address{");
        sb.append(this.u.x());
        sb.append(":");
        sb.append(this.u.n());
        if (this.n != null) {
            sb.append(", proxy=");
            sb.append(this.n);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.x);
        }
        sb.append("}");
        return sb.toString();
    }

    public bg u() {
        return this.u;
    }

    public ProxySelector x() {
        return this.x;
    }

    public boolean u(u uVar) {
        return this.nr.equals(uVar.nr) && this.b.equals(uVar.b) && this.pn.equals(uVar.pn) && this.iz.equals(uVar.iz) && this.x.equals(uVar.x) && com.bytedance.sdk.component.fx.nr.u.fx.u(this.n, uVar.n) && com.bytedance.sdk.component.fx.nr.u.fx.u(this.f5128a, uVar.f5128a) && com.bytedance.sdk.component.fx.nr.u.fx.u(this.jk, uVar.jk) && com.bytedance.sdk.component.fx.nr.u.fx.u(this.t, uVar.t) && u().n() == uVar.u().n();
    }
}
