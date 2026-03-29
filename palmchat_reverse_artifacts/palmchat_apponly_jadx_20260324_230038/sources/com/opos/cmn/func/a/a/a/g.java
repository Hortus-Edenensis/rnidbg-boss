package com.opos.cmn.func.a.a.a;

import com.opos.cmn.func.a.a.a.d;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7929a;
    public final int b;
    public final SSLSocketFactory c;
    public final HostnameVerifier d;
    public final X509TrustManager e;
    public final d f;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7930a = 30000;
        private int b = 30000;
        private SSLSocketFactory c;
        private HostnameVerifier d;
        private d e;
        private X509TrustManager f;

        public a a(SSLSocketFactory sSLSocketFactory) {
            this.c = sSLSocketFactory;
            return this;
        }

        public g a() {
            if (this.e == null) {
                this.e = new d.a().a();
            }
            return new g(this);
        }
    }

    private g(a aVar) {
        this.f7929a = aVar.f7930a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.f;
        this.f = aVar.e;
    }

    public String toString() {
        return "InitParameter{, connectTimeout=" + this.f7929a + ", readTimeout=" + this.b + ", sslSocketFactory=" + this.c + ", hostnameVerifier=" + this.d + ", x509TrustManager=" + this.e + ", httpExtConfig=" + this.f + '}';
    }
}
