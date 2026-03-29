package com.opos.cmn.an.g;

import java.util.Arrays;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7783a;
    public final String b;
    public final String c;
    public final Map<String, String> d;
    public final int e;
    public final int f;
    public final byte[] g;
    public final SSLSocketFactory h;
    public final HostnameVerifier i;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private String b;
        private String c;
        private Map<String, String> d;
        private byte[] g;
        private SSLSocketFactory h;
        private HostnameVerifier i;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7784a = 0;
        private int e = 30000;
        private int f = 30000;

        public a b(int i) {
            this.f = i;
            return this;
        }

        private boolean c(int i) {
            return i == 0 || 1 == i || 2 == i || 3 == i;
        }

        public a a(int i) {
            this.e = i;
            return this;
        }

        public a b(String str) {
            this.c = str;
            return this;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        private void b() {
        }

        public a a(Map<String, String> map) {
            this.d = map;
            return this;
        }

        public a a(HostnameVerifier hostnameVerifier) {
            this.i = hostnameVerifier;
            return this;
        }

        public a a(SSLSocketFactory sSLSocketFactory) {
            this.h = sSLSocketFactory;
            return this;
        }

        public a a(byte[] bArr) {
            this.g = bArr;
            return this;
        }

        public f a() throws Exception {
            if (com.opos.cmn.an.d.b.a(this.b) || com.opos.cmn.an.d.b.a(this.c)) {
                throw new NullPointerException("httpMethod or url is null.");
            }
            if (!c(this.f7784a)) {
                throw new Exception("protocol should be NET_PROTOCOL_HTTP or NET_PROTOCOL_HTTPS or NET_PROTOCOL_HTTP2 or NET_PROTOCOL_SPDY");
            }
            b();
            return new f(this);
        }
    }

    public f(a aVar) {
        this.f7783a = aVar.f7784a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
    }

    public String toString() {
        return "NetRequest{protocol=" + this.f7783a + ", httpMethod='" + this.b + "', url='" + this.c + "', headerMap=" + this.d + ", connectTimeout=" + this.e + ", readTimeout=" + this.f + ", data=" + Arrays.toString(this.g) + ", sslSocketFactory=" + this.h + ", hostnameVerifier=" + this.i + '}';
    }
}
