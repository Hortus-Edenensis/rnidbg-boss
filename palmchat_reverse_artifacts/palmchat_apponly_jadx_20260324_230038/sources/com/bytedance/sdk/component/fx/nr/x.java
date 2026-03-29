package com.bytedance.sdk.component.fx.nr;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class x {
    public static final x u = new u().u();
    private final com.bytedance.sdk.component.fx.nr.u.a.fx fx;
    private final Set<nr> nr;

    /* JADX INFO: compiled from: SearchBox */
    public static final class nr {
        final com.bytedance.sdk.component.fx.u.iz b;
        final String fx;
        final String nr;
        final String u;

        public boolean equals(Object obj) {
            if (!(obj instanceof nr)) {
                return false;
            }
            nr nrVar = (nr) obj;
            return this.u.equals(nrVar.u) && this.fx.equals(nrVar.fx) && this.b.equals(nrVar.b);
        }

        public int hashCode() {
            return ((((this.u.hashCode() + 527) * 31) + this.fx.hashCode()) * 31) + this.b.hashCode();
        }

        public String toString() {
            return this.fx + this.b.nr();
        }

        public boolean u(String str) {
            if (!this.u.startsWith("*.")) {
                return str.equals(this.nr);
            }
            int iIndexOf = str.indexOf(46);
            if ((str.length() - iIndexOf) - 1 != this.nr.length()) {
                return false;
            }
            String str2 = this.nr;
            return str.regionMatches(false, iIndexOf + 1, str2, 0, str2.length());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {
        private final List<nr> u = new ArrayList();

        public x u() {
            return new x(new LinkedHashSet(this.u), null);
        }
    }

    public x(Set<nr> set, com.bytedance.sdk.component.fx.nr.u.a.fx fxVar) {
        this.nr = set;
        this.fx = fxVar;
    }

    public static com.bytedance.sdk.component.fx.u.iz nr(X509Certificate x509Certificate) {
        return com.bytedance.sdk.component.fx.u.iz.u(x509Certificate.getPublicKey().getEncoded()).b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return com.bytedance.sdk.component.fx.nr.u.fx.u(this.fx, xVar.fx) && this.nr.equals(xVar.nr);
    }

    public int hashCode() {
        com.bytedance.sdk.component.fx.nr.u.a.fx fxVar = this.fx;
        return ((fxVar != null ? fxVar.hashCode() : 0) * 31) + this.nr.hashCode();
    }

    public void u(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<nr> listU = u(str);
        if (listU.isEmpty()) {
            return;
        }
        com.bytedance.sdk.component.fx.nr.u.a.fx fxVar = this.fx;
        if (fxVar != null) {
            list = fxVar.u(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = listU.size();
            com.bytedance.sdk.component.fx.u.iz izVarNr = null;
            com.bytedance.sdk.component.fx.u.iz izVarU = null;
            for (int i2 = 0; i2 < size2; i2++) {
                nr nrVar = listU.get(i2);
                if (nrVar.fx.equals("sha256/")) {
                    if (izVarNr == null) {
                        izVarNr = nr(x509Certificate);
                    }
                    if (nrVar.b.equals(izVarNr)) {
                        return;
                    }
                } else {
                    if (!nrVar.fx.equals("sha1/")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + nrVar.fx);
                    }
                    if (izVarU == null) {
                        izVarU = u(x509Certificate);
                    }
                    if (nrVar.b.equals(izVarU)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ");
            sb.append(u((Certificate) x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = listU.size();
        for (int i4 = 0; i4 < size4; i4++) {
            nr nrVar2 = listU.get(i4);
            sb.append("\n    ");
            sb.append(nrVar2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public List<nr> u(String str) {
        List<nr> listEmptyList = Collections.emptyList();
        for (nr nrVar : this.nr) {
            if (nrVar.u(str)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                listEmptyList.add(nrVar);
            }
        }
        return listEmptyList;
    }

    public x u(com.bytedance.sdk.component.fx.nr.u.a.fx fxVar) {
        return com.bytedance.sdk.component.fx.nr.u.fx.u(this.fx, fxVar) ? this : new x(this.nr, fxVar);
    }

    public static String u(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + nr((X509Certificate) certificate).nr();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    public static com.bytedance.sdk.component.fx.u.iz u(X509Certificate x509Certificate) {
        return com.bytedance.sdk.component.fx.u.iz.u(x509Certificate.getPublicKey().getEncoded()).fx();
    }
}
