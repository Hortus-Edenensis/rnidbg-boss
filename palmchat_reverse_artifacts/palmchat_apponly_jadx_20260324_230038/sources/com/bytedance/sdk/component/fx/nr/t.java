package com.bytedance.sdk.component.fx.nr;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class t {
    public static final t fx;
    private static final n[] n;
    public static final t nr;
    public static final t u;
    final boolean b;
    final String[] iz;
    final boolean pn;
    final String[] x;

    static {
        n[] nVarArr = {n.t, n.mv, n.l, n.s, n.my, n.k, n.x, n.f5125a, n.n, n.jk, n.pn, n.iz, n.fx, n.b, n.nr};
        n = nVarArr;
        u uVarU = new u(true).u(nVarArr);
        bf bfVar = bf.TLS_1_0;
        t tVarU = uVarU.u(bf.TLS_1_3, bf.TLS_1_2, bf.TLS_1_1, bfVar).u(true).u();
        u = tVarU;
        nr = new u(tVarU).u(bfVar).u(true).u();
        fx = new u(false).u();
    }

    public t(u uVar) {
        this.b = uVar.u;
        this.iz = uVar.nr;
        this.x = uVar.fx;
        this.pn = uVar.b;
    }

    public boolean b() {
        return this.pn;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        t tVar = (t) obj;
        boolean z = this.b;
        if (z != tVar.b) {
            return false;
        }
        return !z || (Arrays.equals(this.iz, tVar.iz) && Arrays.equals(this.x, tVar.x) && this.pn == tVar.pn);
    }

    public List<bf> fx() {
        String[] strArr = this.x;
        if (strArr != null) {
            return bf.u(strArr);
        }
        return null;
    }

    public int hashCode() {
        if (this.b) {
            return ((((Arrays.hashCode(this.iz) + 527) * 31) + Arrays.hashCode(this.x)) * 31) + (!this.pn ? 1 : 0);
        }
        return 17;
    }

    public List<n> nr() {
        String[] strArr = this.iz;
        if (strArr != null) {
            return n.u(strArr);
        }
        return null;
    }

    public String toString() {
        if (!this.b) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.iz != null ? nr().toString() : "[all enabled]") + ", tlsVersions=" + (this.x != null ? fx().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.pn + ")";
    }

    public boolean u() {
        return this.b;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {
        boolean b;
        String[] fx;
        String[] nr;
        boolean u;

        public u(boolean z) {
            this.u = z;
        }

        public u nr(String... strArr) {
            if (!this.u) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.fx = (String[]) strArr.clone();
            return this;
        }

        public u u(n... nVarArr) {
            if (!this.u) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[nVarArr.length];
            for (int i = 0; i < nVarArr.length; i++) {
                strArr[i] = nVarArr[i].o;
            }
            return u(strArr);
        }

        public u(t tVar) {
            this.u = tVar.b;
            this.nr = tVar.iz;
            this.fx = tVar.x;
            this.b = tVar.pn;
        }

        public u u(String... strArr) {
            if (this.u) {
                if (strArr.length != 0) {
                    this.nr = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public u u(bf... bfVarArr) {
            if (this.u) {
                String[] strArr = new String[bfVarArr.length];
                for (int i = 0; i < bfVarArr.length; i++) {
                    strArr[i] = bfVarArr[i].iz;
                }
                return nr(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public u u(boolean z) {
            if (this.u) {
                this.b = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public t u() {
            return new t(this);
        }
    }

    private t nr(SSLSocket sSLSocket, boolean z) {
        String[] strArrU = this.iz != null ? com.bytedance.sdk.component.fx.nr.u.fx.u(n.u, sSLSocket.getEnabledCipherSuites(), this.iz) : sSLSocket.getEnabledCipherSuites();
        String[] strArrU2 = this.x != null ? com.bytedance.sdk.component.fx.nr.u.fx.u(com.bytedance.sdk.component.fx.nr.u.fx.n, sSLSocket.getEnabledProtocols(), this.x) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iU = com.bytedance.sdk.component.fx.nr.u.fx.u(n.u, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && iU != -1) {
            strArrU = com.bytedance.sdk.component.fx.nr.u.fx.u(strArrU, supportedCipherSuites[iU]);
        }
        return new u(this).u(strArrU).nr(strArrU2).u();
    }

    public void u(SSLSocket sSLSocket, boolean z) {
        t tVarNr = nr(sSLSocket, z);
        String[] strArr = tVarNr.x;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = tVarNr.iz;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean u(SSLSocket sSLSocket) {
        if (!this.b) {
            return false;
        }
        String[] strArr = this.x;
        if (strArr != null && !com.bytedance.sdk.component.fx.nr.u.fx.nr(com.bytedance.sdk.component.fx.nr.u.fx.n, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.iz;
        return strArr2 == null || com.bytedance.sdk.component.fx.nr.u.fx.nr(n.u, strArr2, sSLSocket.getEnabledCipherSuites());
    }
}
