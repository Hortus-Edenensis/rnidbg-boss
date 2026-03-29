package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.TunnelRequest;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.CacheResponse;
import java.net.SecureCacheResponse;
import java.net.URL;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class HttpsEngine extends HttpEngine {
    private SSLSocket sslSocket;

    public HttpsEngine(OkHttpClient okHttpClient, Policy policy, String str, RawHeaders rawHeaders, Connection connection, RetryableOutputStream retryableOutputStream) throws IOException {
        super(okHttpClient, policy, str, rawHeaders, connection, retryableOutputStream);
        this.sslSocket = connection != null ? (SSLSocket) connection.getSocket() : null;
    }

    @Override // com.squareup.okhttp.internal.http.HttpEngine
    public boolean acceptCacheResponseType(CacheResponse cacheResponse) {
        return cacheResponse instanceof SecureCacheResponse;
    }

    @Override // com.squareup.okhttp.internal.http.HttpEngine
    public void connected(Connection connection) {
        this.sslSocket = (SSLSocket) connection.getSocket();
        super.connected(connection);
    }

    public SSLSocket getSslSocket() {
        return this.sslSocket;
    }

    @Override // com.squareup.okhttp.internal.http.HttpEngine
    public TunnelRequest getTunnelConfig() {
        String userAgent = this.requestHeaders.getUserAgent();
        if (userAgent == null) {
            userAgent = HttpEngine.getDefaultUserAgent();
        }
        URL url = this.policy.getURL();
        return new TunnelRequest(url.getHost(), Util.getEffectivePort(url), userAgent, this.requestHeaders.getProxyAuthorization());
    }

    @Override // com.squareup.okhttp.internal.http.HttpEngine
    public boolean includeAuthorityInRequestLine() {
        return false;
    }
}
