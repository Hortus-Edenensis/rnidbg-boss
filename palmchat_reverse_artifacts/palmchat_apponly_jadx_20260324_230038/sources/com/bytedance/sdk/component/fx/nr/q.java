package com.bytedance.sdk.component.fx.nr;

import android.os.Bundle;
import com.bytedance.sdk.component.fx.nr.h;
import com.bytedance.sdk.component.fx.nr.my;
import com.bytedance.sdk.component.fx.nr.sx;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class q implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final my.u f5126a;
    final Proxy b;
    final nr bg;
    final nr bq;
    final k c;
    final int d;
    final jk dw;
    final s fx;
    final int gi;
    final int h;
    final List<t> iz;
    final ProxySelector jk;
    final SSLSocketFactory k;
    final boolean kj;
    final fx l;
    final com.bytedance.sdk.component.fx.nr.u.u.iz mv;
    final com.bytedance.sdk.component.fx.nr.u.a.fx my;
    final List<bq> n;
    final HostnameVerifier o;
    final List<qq> pn;
    final boolean q;
    final boolean qq;
    public Set<String> rh;
    final SocketFactory s;
    final x sx;
    final mv t;
    final List<bq> x;
    final int z;
    static final List<qq> u = com.bytedance.sdk.component.fx.nr.u.fx.u(qq.HTTP_2, qq.HTTP_1_1);
    static final List<t> nr = com.bytedance.sdk.component.fx.nr.u.fx.u(t.u, t.fx);

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        mv f5127a;
        List<t> b;
        public TimeUnit bf;
        jk bg;
        k bq;
        boolean c;
        public Bundle d;
        boolean dw;
        public List<qq> fx;
        int gi;
        public Set<String> h;
        final List<bq> iz;
        public TimeUnit ja;
        fx jk;
        HostnameVerifier k;
        public int kj;
        SocketFactory l;
        SSLSocketFactory mv;
        x my;
        ProxySelector n;
        Proxy nr;
        nr o;
        public final List<bq> pn;
        boolean q;
        public int qq;
        public TimeUnit rh;
        com.bytedance.sdk.component.fx.nr.u.a.fx s;
        nr sx;
        com.bytedance.sdk.component.fx.nr.u.u.iz t;
        s u;
        my.u x;
        public int z;

        public u() {
            this("");
        }

        public u u(bq bqVar) {
            if (bqVar == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.pn.add(bqVar);
            return this;
        }

        public u(String str) {
            this.pn = new ArrayList();
            this.iz = new ArrayList();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.rh = timeUnit;
            this.ja = timeUnit;
            this.bf = timeUnit;
            this.u = new s(str);
            this.fx = q.u;
            this.b = q.nr;
            this.x = my.u(my.u);
            this.n = ProxySelector.getDefault();
            this.f5127a = mv.u;
            this.l = SocketFactory.getDefault();
            this.k = com.bytedance.sdk.component.fx.nr.u.a.pn.u;
            this.my = x.u;
            nr nrVar = nr.u;
            this.o = nrVar;
            this.sx = nrVar;
            this.bg = new jk();
            this.bq = k.u;
            this.dw = true;
            this.c = true;
            this.q = true;
            this.qq = 10000;
            this.kj = 10000;
            this.z = 10000;
            this.gi = 0;
        }

        public u u(my myVar) {
            if (myVar != null) {
                this.x = my.u(myVar);
                return this;
            }
            throw new NullPointerException("eventListener == null");
        }

        public q u() {
            return new q(this);
        }
    }

    static {
        com.bytedance.sdk.component.fx.nr.u.u.u = new com.bytedance.sdk.component.fx.nr.u.u() { // from class: com.bytedance.sdk.component.fx.nr.q.1
            @Override // com.bytedance.sdk.component.fx.nr.u.u
            public void nr(jk jkVar, com.bytedance.sdk.component.fx.nr.u.nr.fx fxVar) {
                jkVar.u(fxVar);
            }

            @Override // com.bytedance.sdk.component.fx.nr.u.u
            public void u(sx.u uVar, String str) {
                uVar.u(str);
            }

            @Override // com.bytedance.sdk.component.fx.nr.u.u
            public void u(sx.u uVar, String str, String str2) {
                uVar.nr(str, str2);
            }

            @Override // com.bytedance.sdk.component.fx.nr.u.u
            public boolean u(jk jkVar, com.bytedance.sdk.component.fx.nr.u.nr.fx fxVar) {
                return jkVar.nr(fxVar);
            }

            @Override // com.bytedance.sdk.component.fx.nr.u.u
            public com.bytedance.sdk.component.fx.nr.u.nr.fx u(jk jkVar, com.bytedance.sdk.component.fx.nr.u uVar, com.bytedance.sdk.component.fx.nr.u.nr.x xVar, ja jaVar) {
                return jkVar.u(uVar, xVar, jaVar);
            }

            @Override // com.bytedance.sdk.component.fx.nr.u.u
            public boolean u(com.bytedance.sdk.component.fx.nr.u uVar, com.bytedance.sdk.component.fx.nr.u uVar2) {
                return uVar.u(uVar2);
            }

            @Override // com.bytedance.sdk.component.fx.nr.u.u
            public Socket u(jk jkVar, com.bytedance.sdk.component.fx.nr.u uVar, com.bytedance.sdk.component.fx.nr.u.nr.x xVar) {
                return jkVar.u(uVar, xVar);
            }

            @Override // com.bytedance.sdk.component.fx.nr.u.u
            public com.bytedance.sdk.component.fx.nr.u.nr.b u(jk jkVar) {
                return jkVar.u;
            }

            @Override // com.bytedance.sdk.component.fx.nr.u.u
            public int u(h.u uVar) {
                return uVar.fx;
            }

            @Override // com.bytedance.sdk.component.fx.nr.u.u
            public void u(t tVar, SSLSocket sSLSocket, boolean z) {
                tVar.u(sSLSocket, z);
            }
        };
    }

    public q() {
        this(new u());
    }

    private X509TrustManager kj() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e) {
            throw com.bytedance.sdk.component.fx.nr.u.fx.u("No System TLS", (Exception) e);
        }
    }

    private SSLSocketFactory u(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw com.bytedance.sdk.component.fx.nr.u.fx.u("No System TLS", (Exception) e);
        }
    }

    public SocketFactory a() {
        return this.s;
    }

    public Proxy b() {
        return this.b;
    }

    public s bg() {
        return this.fx;
    }

    public List<qq> bq() {
        return this.pn;
    }

    public List<bq> c() {
        return this.x;
    }

    public List<t> dw() {
        return this.iz;
    }

    public int fx() {
        return this.d;
    }

    public mv iz() {
        return this.t;
    }

    public SSLSocketFactory jk() {
        return this.k;
    }

    public jk k() {
        return this.dw;
    }

    public x l() {
        return this.sx;
    }

    public nr mv() {
        return this.bq;
    }

    public boolean my() {
        return this.q;
    }

    public k n() {
        return this.c;
    }

    public int nr() {
        return this.gi;
    }

    public boolean o() {
        return this.qq;
    }

    public ProxySelector pn() {
        return this.jk;
    }

    public List<bq> q() {
        return this.n;
    }

    public my.u qq() {
        return this.f5126a;
    }

    public nr s() {
        return this.bg;
    }

    public boolean sx() {
        return this.kj;
    }

    public HostnameVerifier t() {
        return this.o;
    }

    public com.bytedance.sdk.component.fx.nr.u.u.iz x() {
        fx fxVar = this.l;
        return fxVar != null ? fxVar.u : this.mv;
    }

    public q(u uVar) {
        boolean z;
        this.fx = uVar.u;
        this.b = uVar.nr;
        this.pn = uVar.fx;
        List<t> list = uVar.b;
        this.iz = list;
        this.x = com.bytedance.sdk.component.fx.nr.u.fx.u(uVar.pn);
        this.n = com.bytedance.sdk.component.fx.nr.u.fx.u(uVar.iz);
        this.f5126a = uVar.x;
        this.jk = uVar.n;
        this.t = uVar.f5127a;
        this.l = uVar.jk;
        this.mv = uVar.t;
        this.s = uVar.l;
        this.rh = uVar.h;
        Iterator<t> it = list.iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                z = z || it.next().u();
            }
        }
        SSLSocketFactory sSLSocketFactory = uVar.mv;
        if (sSLSocketFactory == null && z) {
            X509TrustManager x509TrustManagerKj = kj();
            this.k = u(x509TrustManagerKj);
            this.my = com.bytedance.sdk.component.fx.nr.u.a.fx.u(x509TrustManagerKj);
        } else {
            this.k = sSLSocketFactory;
            this.my = uVar.s;
        }
        this.o = uVar.k;
        this.sx = uVar.my.u(this.my);
        this.bg = uVar.o;
        this.bq = uVar.sx;
        jk jkVar = uVar.bg;
        this.dw = jkVar;
        if (jkVar != null) {
            jkVar.u(uVar.d);
        }
        this.c = uVar.bq;
        this.q = uVar.dw;
        this.qq = uVar.c;
        this.kj = uVar.q;
        this.z = uVar.qq;
        this.gi = uVar.kj;
        this.d = uVar.z;
        this.h = uVar.gi;
        if (this.x.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.x);
        }
        if (this.n.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.n);
        }
    }

    public int u() {
        return this.z;
    }

    public pn u(z zVar) {
        return kj.u(this, zVar, false);
    }
}
