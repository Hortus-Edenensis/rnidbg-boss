package com.bytedance.sdk.component.fx.nr;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class o {
    private final List<Certificate> b;
    private final List<Certificate> fx;
    private final n nr;
    private final bf u;

    private o(bf bfVar, n nVar, List<Certificate> list, List<Certificate> list2) {
        this.u = bfVar;
        this.nr = nVar;
        this.fx = list;
        this.b = list2;
    }

    public static o u(SSLSession sSLSession) {
        String cipherSuite;
        Certificate[] peerCertificates = null;
        try {
            cipherSuite = sSLSession.getCipherSuite();
        } catch (Exception unused) {
            cipherSuite = null;
        }
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        n nVarU = n.u(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        bf bfVarU = bf.u(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused2) {
        }
        List listU = peerCertificates != null ? com.bytedance.sdk.component.fx.nr.u.fx.u(peerCertificates) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new o(bfVarU, nVarU, listU, localCertificates != null ? com.bytedance.sdk.component.fx.nr.u.fx.u(localCertificates) : Collections.emptyList());
    }

    public List<Certificate> b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.u.equals(oVar.u) && this.nr.equals(oVar.nr) && this.fx.equals(oVar.fx) && this.b.equals(oVar.b);
    }

    public List<Certificate> fx() {
        return this.fx;
    }

    public int hashCode() {
        return ((((((this.u.hashCode() + 527) * 31) + this.nr.hashCode()) * 31) + this.fx.hashCode()) * 31) + this.b.hashCode();
    }

    public n nr() {
        return this.nr;
    }

    public bf u() {
        return this.u;
    }
}
