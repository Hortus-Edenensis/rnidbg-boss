package com.opos.cmn.an.g.a.a;

import android.content.Context;
import android.net.Proxy;
import com.opos.cmn.an.g.f;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.security.GeneralSecurityException;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f7778a;
    protected f b;
    protected HttpURLConnection c = a();

    public a(Context context, f fVar) {
        this.f7778a = context;
        this.b = fVar;
    }

    private HttpURLConnection a() {
        c();
        HttpURLConnection httpURLConnection = null;
        if (com.opos.cmn.an.d.b.a(this.b.c)) {
            return null;
        }
        try {
            URL url = new URL(this.b.c);
            URLConnection uRLConnectionOpenConnection = (!com.opos.cmn.an.h.c.a.c(this.f7778a) || com.opos.cmn.an.d.b.a(Proxy.getDefaultHost())) ? url.openConnection() : url.openConnection(b());
            httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            c(httpURLConnection);
            a(httpURLConnection);
            b(httpURLConnection);
            return httpURLConnection;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("HttpURLBaseTask", "", e);
            return httpURLConnection;
        }
    }

    private java.net.Proxy b() {
        return new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort()));
    }

    private void c() {
    }

    private static SSLSocketFactory d() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    private void a(HttpURLConnection httpURLConnection) throws ProtocolException {
        if (httpURLConnection != null) {
            httpURLConnection.setConnectTimeout(this.b.e);
            httpURLConnection.setReadTimeout(this.b.f);
            httpURLConnection.setDoInput(true);
            if ("GET".equals(this.b.b)) {
                httpURLConnection.setUseCaches(true);
            } else if ("POST".equals(this.b.b)) {
                httpURLConnection.setDoOutput(true);
            }
            httpURLConnection.setRequestMethod(this.b.b);
        }
    }

    private void b(HttpURLConnection httpURLConnection) {
        Map<String, String> map;
        if (httpURLConnection == null || (map = this.b.d) == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : this.b.d.entrySet()) {
            if (entry != null) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024 A[Catch: Exception -> 0x002a, TRY_LEAVE, TryCatch #0 {Exception -> 0x002a, blocks: (B:4:0x0004, B:6:0x000a, B:7:0x000d, B:11:0x001e, B:13:0x0024, B:8:0x0011, B:10:0x001a), top: B:18:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(HttpURLConnection httpURLConnection) {
        HttpsURLConnection httpsURLConnection;
        HostnameVerifier hostnameVerifier;
        if (!(httpURLConnection instanceof HttpsURLConnection)) {
            return;
        }
        try {
            SSLSocketFactory sSLSocketFactoryD = this.b.h;
            if (sSLSocketFactoryD == null) {
                System.currentTimeMillis();
                sSLSocketFactoryD = d();
                if (sSLSocketFactoryD != null) {
                    httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                }
                hostnameVerifier = this.b.i;
                if (hostnameVerifier == null) {
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(hostnameVerifier);
                    return;
                }
                return;
            }
            httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setSSLSocketFactory(sSLSocketFactoryD);
            hostnameVerifier = this.b.i;
            if (hostnameVerifier == null) {
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("HttpURLBaseTask", "setHttpsPropertyIfNeed", e);
        }
    }
}
