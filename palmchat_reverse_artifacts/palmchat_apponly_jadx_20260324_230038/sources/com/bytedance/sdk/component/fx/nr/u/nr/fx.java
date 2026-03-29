package com.bytedance.sdk.component.fx.nr.u.nr;

import com.bytedance.sdk.component.fx.nr.a;
import com.bytedance.sdk.component.fx.nr.bg;
import com.bytedance.sdk.component.fx.nr.bq;
import com.bytedance.sdk.component.fx.nr.h;
import com.bytedance.sdk.component.fx.nr.ja;
import com.bytedance.sdk.component.fx.nr.jk;
import com.bytedance.sdk.component.fx.nr.my;
import com.bytedance.sdk.component.fx.nr.o;
import com.bytedance.sdk.component.fx.nr.q;
import com.bytedance.sdk.component.fx.nr.qq;
import com.bytedance.sdk.component.fx.nr.t;
import com.bytedance.sdk.component.fx.nr.u.pn.x;
import com.bytedance.sdk.component.fx.nr.z;
import com.bytedance.sdk.component.fx.u.l;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class fx extends x.nr implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Socket f5131a;
    private Socket jk;
    private com.bytedance.sdk.component.fx.u.b k;
    private qq l;
    private com.bytedance.sdk.component.fx.nr.u.pn.x mv;
    private final ja n;
    public int nr;
    private com.bytedance.sdk.component.fx.u.pn s;
    private o t;
    public boolean u;
    private final jk x;
    public int fx = 1;
    public final List<Reference<x>> b = new ArrayList();
    public long pn = Long.MAX_VALUE;

    public fx(jk jkVar, ja jaVar) {
        this.x = jkVar;
        this.n = jaVar;
    }

    private z iz() {
        return new z.u().u(this.n.u().u()).u("Host", com.bytedance.sdk.component.fx.nr.u.fx.u(this.n.u().u(), true)).u("Proxy-Connection", HTTP.CONN_KEEP_ALIVE).u("User-Agent", com.bytedance.sdk.component.fx.nr.u.b.u()).u();
    }

    public o b() {
        return this.t;
    }

    public Socket fx() {
        return this.jk;
    }

    public void nr() {
        com.bytedance.sdk.component.fx.nr.u.fx.u(this.f5131a);
    }

    public boolean pn() {
        return this.mv != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Connection{");
        sb.append(this.n.u().u().x());
        sb.append(":");
        sb.append(this.n.u().u().n());
        sb.append(", proxy=");
        sb.append(this.n.nr());
        sb.append(" hostAddress=");
        sb.append(this.n.fx());
        sb.append(" cipherSuite=");
        o oVar = this.t;
        sb.append(oVar != null ? oVar.nr() : "none");
        sb.append(" protocol=");
        sb.append(this.l);
        sb.append('}');
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ca A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(int i, int i2, int i3, boolean z, com.bytedance.sdk.component.fx.nr.pn pnVar, my myVar) throws Throwable {
        if (this.l != null) {
            throw new IllegalStateException("already connected");
        }
        List<t> listIz = this.n.u().iz();
        nr nrVar = new nr(listIz);
        if (this.n.u().a() == null) {
            if (!listIz.contains(t.fx)) {
                throw new pn(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String strX = this.n.u().u().x();
            if (!com.bytedance.sdk.component.fx.nr.u.x.pn.nr().nr(strX)) {
                throw new pn(new UnknownServiceException("CLEARTEXT communication to " + strX + " not permitted by network security policy"));
            }
        }
        pn pnVar2 = null;
        do {
            try {
                if (this.n.b()) {
                    u(i, i2, i3, pnVar, myVar);
                    if (this.f5131a == null) {
                        if (!this.n.b() && this.f5131a == null) {
                            throw new pn(new ProtocolException("Too many tunnel connections attempted: 21"));
                        }
                        if (this.mv == null) {
                            synchronized (this.x) {
                                this.fx = this.mv.u();
                            }
                            return;
                        }
                        return;
                    }
                } else {
                    try {
                        u(i, i2, pnVar, myVar);
                    } catch (IOException e) {
                        e = e;
                        com.bytedance.sdk.component.fx.nr.u.fx.u(this.jk);
                        com.bytedance.sdk.component.fx.nr.u.fx.u(this.f5131a);
                        this.jk = null;
                        this.f5131a = null;
                        this.s = null;
                        this.k = null;
                        this.t = null;
                        this.l = null;
                        this.mv = null;
                        myVar.u(pnVar, this.n.fx(), this.n.nr(), null, e);
                        if (pnVar2 == null) {
                            pnVar2 = new pn(e);
                        } else {
                            pnVar2.u(e);
                        }
                        if (!z) {
                            throw pnVar2;
                        }
                    }
                }
                u(nrVar, pnVar, myVar);
                if (!this.n.b()) {
                }
                if (this.mv == null) {
                }
            } catch (IOException e2) {
                e = e2;
            }
        } while (nrVar.u(e));
        throw pnVar2;
    }

    private void u(int i, int i2, int i3, com.bytedance.sdk.component.fx.nr.pn pnVar, my myVar) throws IOException {
        z zVarIz = iz();
        bg bgVarU = zVarIz.u();
        for (int i4 = 0; i4 < 21; i4++) {
            u(i, i2, pnVar, myVar);
            zVarIz = u(i2, i3, zVarIz, bgVarU);
            if (zVarIz == null) {
                return;
            }
            com.bytedance.sdk.component.fx.nr.u.fx.u(this.f5131a);
            this.f5131a = null;
            this.k = null;
            this.s = null;
        }
    }

    private void u(int i, int i2, com.bytedance.sdk.component.fx.nr.pn pnVar, my myVar) throws IOException {
        Proxy proxyNr = this.n.nr();
        Socket socketCreateSocket = (proxyNr.type() == Proxy.Type.DIRECT || proxyNr.type() == Proxy.Type.HTTP) ? this.n.u().fx().createSocket() : new Socket(proxyNr);
        this.f5131a = socketCreateSocket;
        socketCreateSocket.setSoTimeout(i2);
        try {
            com.bytedance.sdk.component.fx.nr.u.x.pn.nr().u(this.f5131a, this.n.fx(), i);
            try {
                this.s = l.u(l.nr(this.f5131a));
                this.k = l.u(l.u(this.f5131a));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.n.fx());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void u(nr nrVar, com.bytedance.sdk.component.fx.nr.pn pnVar, my myVar) throws Throwable {
        if (this.n.u().a() == null) {
            this.l = qq.HTTP_1_1;
            this.jk = this.f5131a;
            return;
        }
        u(nrVar);
        try {
            if (this.l == qq.HTTP_2) {
                this.jk.setSoTimeout(0);
                com.bytedance.sdk.component.fx.nr.u.pn.x xVarU = new x.u(true).u(this.jk, this.n.u().u().x(), this.s, this.k).u(this).u();
                this.mv = xVarU;
                xVarU.fx();
            }
        } catch (Throwable unused) {
        }
    }

    private void u(nr nrVar) throws Throwable {
        SSLSocket sSLSocket;
        com.bytedance.sdk.component.fx.nr.u uVarU = this.n.u();
        SSLSocket sSLSocket2 = null;
        try {
            try {
                sSLSocket = (SSLSocket) uVarU.a().createSocket(this.f5131a, uVarU.u().x(), uVarU.u().n(), true);
            } catch (Throwable th) {
                th = th;
            }
        } catch (AssertionError e) {
            e = e;
        }
        try {
            t tVarU = nrVar.u(sSLSocket);
            if (tVarU.b()) {
                com.bytedance.sdk.component.fx.nr.u.x.pn.nr().u(sSLSocket, uVarU.u().x(), uVarU.pn());
            }
            try {
                sSLSocket.startHandshake();
            } catch (Throwable unused) {
            }
            o oVarU = o.u(sSLSocket.getSession());
            if (uVarU.jk().verify(uVarU.u().x(), sSLSocket.getSession())) {
                uVarU.t().u(uVarU.u().x(), oVarU.fx());
                String strU = tVarU.b() ? com.bytedance.sdk.component.fx.nr.u.x.pn.nr().u(sSLSocket) : null;
                this.jk = sSLSocket;
                this.s = l.u(l.nr(sSLSocket));
                this.k = l.u(l.u(this.jk));
                this.t = oVarU;
                this.l = strU != null ? qq.u(strU) : qq.HTTP_1_1;
                com.bytedance.sdk.component.fx.nr.u.x.pn.nr().nr(sSLSocket);
                return;
            }
            X509Certificate x509Certificate = (X509Certificate) oVarU.fx().get(0);
            throw new SSLPeerUnverifiedException("Hostname " + uVarU.u().x() + " not verified:\n    certificate: " + com.bytedance.sdk.component.fx.nr.x.u((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.bytedance.sdk.component.fx.nr.u.a.pn.u(x509Certificate));
        } catch (AssertionError e2) {
            e = e2;
            if (!com.bytedance.sdk.component.fx.nr.u.fx.u(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                com.bytedance.sdk.component.fx.nr.u.x.pn.nr().nr(sSLSocket2);
            }
            com.bytedance.sdk.component.fx.nr.u.fx.u((Socket) sSLSocket2);
            throw th;
        }
    }

    private z u(int i, int i2, z zVar, bg bgVar) throws IOException {
        String str = "CONNECT " + com.bytedance.sdk.component.fx.nr.u.fx.u(bgVar, true) + " HTTP/1.1";
        while (true) {
            com.bytedance.sdk.component.fx.nr.u.b.u uVar = new com.bytedance.sdk.component.fx.nr.u.b.u(null, null, this.s, this.k);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.s.u().u(i, timeUnit);
            this.k.u().u(i2, timeUnit);
            uVar.u(zVar.fx(), str);
            uVar.nr();
            h hVarU = uVar.u(false).u(zVar).u();
            long jU = com.bytedance.sdk.component.fx.nr.u.fx.pn.u(hVarU);
            if (jU == -1) {
                jU = 0;
            }
            com.bytedance.sdk.component.fx.u.bg bgVarNr = uVar.nr(jU);
            com.bytedance.sdk.component.fx.nr.u.fx.nr(bgVarNr, Integer.MAX_VALUE, timeUnit);
            bgVarNr.close();
            int iFx = hVarU.fx();
            if (iFx == 200) {
                if (this.s.fx().pn() && this.k.fx().pn()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iFx == 407) {
                z zVarU = this.n.u().b().u(this.n, hVarU);
                if (zVarU != null) {
                    if ("close".equalsIgnoreCase(hVarU.u("Connection"))) {
                        return zVarU;
                    }
                    zVar = zVarU;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + hVarU.fx());
            }
        }
    }

    public boolean u(com.bytedance.sdk.component.fx.nr.u uVar, ja jaVar) {
        if (this.b.size() >= this.fx || this.u || !com.bytedance.sdk.component.fx.nr.u.u.u.u(this.n.u(), uVar)) {
            return false;
        }
        if (uVar.u().x().equals(u().u().u().x())) {
            return true;
        }
        if (this.mv == null || jaVar == null || jaVar.nr().type() != Proxy.Type.DIRECT || this.n.nr().type() != Proxy.Type.DIRECT || !this.n.fx().equals(jaVar.fx()) || jaVar.u().jk() != com.bytedance.sdk.component.fx.nr.u.a.pn.u || !u(uVar.u())) {
            return false;
        }
        try {
            uVar.t().u(uVar.u().x(), b().fx());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean u(bg bgVar) {
        if (bgVar.n() != this.n.u().u().n()) {
            return false;
        }
        if (bgVar.x().equals(this.n.u().u().x())) {
            return true;
        }
        return this.t != null && com.bytedance.sdk.component.fx.nr.u.a.pn.u.u(bgVar.x(), (X509Certificate) this.t.fx().get(0));
    }

    public com.bytedance.sdk.component.fx.nr.u.fx.fx u(q qVar, bq.u uVar, x xVar) throws SocketException {
        if (this.mv != null) {
            return new com.bytedance.sdk.component.fx.nr.u.pn.iz(qVar, uVar, xVar, this.mv);
        }
        this.jk.setSoTimeout(uVar.fx());
        com.bytedance.sdk.component.fx.u.bq bqVarU = this.s.u();
        long jFx = uVar.fx();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        bqVarU.u(jFx, timeUnit);
        this.k.u().u(uVar.b(), timeUnit);
        return new com.bytedance.sdk.component.fx.nr.u.b.u(qVar, xVar, this.s, this.k);
    }

    @Override // com.bytedance.sdk.component.fx.nr.a
    public ja u() {
        return this.n;
    }

    public boolean u(boolean z) {
        if (this.jk.isClosed() || this.jk.isInputShutdown() || this.jk.isOutputShutdown()) {
            return false;
        }
        com.bytedance.sdk.component.fx.nr.u.pn.x xVar = this.mv;
        if (xVar != null) {
            return !xVar.b();
        }
        if (z) {
            try {
                int soTimeout = this.jk.getSoTimeout();
                try {
                    this.jk.setSoTimeout(1);
                    return !this.s.pn();
                } finally {
                    this.jk.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.pn.x.nr
    public void u(com.bytedance.sdk.component.fx.nr.u.pn.a aVar) throws IOException {
        aVar.u(com.bytedance.sdk.component.fx.nr.u.pn.nr.REFUSED_STREAM);
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.pn.x.nr
    public void u(com.bytedance.sdk.component.fx.nr.u.pn.x xVar) {
        synchronized (this.x) {
            this.fx = xVar.u();
        }
    }
}
