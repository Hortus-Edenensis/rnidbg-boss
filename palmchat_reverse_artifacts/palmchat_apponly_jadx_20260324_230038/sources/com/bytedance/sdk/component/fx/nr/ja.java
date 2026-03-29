package com.bytedance.sdk.component.fx.nr;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class ja {
    final InetSocketAddress fx;
    final Proxy nr;
    final u u;

    public ja(u uVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (uVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.u = uVar;
        this.nr = proxy;
        this.fx = inetSocketAddress;
    }

    public boolean b() {
        return this.u.f5128a != null && this.nr.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ja)) {
            return false;
        }
        ja jaVar = (ja) obj;
        return jaVar.u.equals(this.u) && jaVar.nr.equals(this.nr) && jaVar.fx.equals(this.fx);
    }

    public InetSocketAddress fx() {
        return this.fx;
    }

    public int hashCode() {
        return ((((this.u.hashCode() + 527) * 31) + this.nr.hashCode()) * 31) + this.fx.hashCode();
    }

    public Proxy nr() {
        return this.nr;
    }

    public String toString() {
        return "Route{" + this.fx + "}";
    }

    public u u() {
        return this.u;
    }
}
