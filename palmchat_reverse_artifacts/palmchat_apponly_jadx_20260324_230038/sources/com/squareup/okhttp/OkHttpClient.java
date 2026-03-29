package com.squareup.okhttp;

import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpAuthenticator;
import com.squareup.okhttp.internal.http.HttpURLConnectionImpl;
import com.squareup.okhttp.internal.http.HttpsURLConnectionImpl;
import com.squareup.okhttp.internal.http.OkResponseCacheAdapter;
import com.squareup.okhttp.internal.tls.OkHostnameVerifier;
import com.ss.android.download.api.constant.BaseConstants;
import java.net.CookieHandler;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.ResponseCache;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class OkHttpClient implements URLStreamHandlerFactory {
    private static final List<String> DEFAULT_TRANSPORTS = Util.immutableList(Arrays.asList("spdy/3", "http/1.1"));
    private OkAuthenticator authenticator;
    private int connectTimeout;
    private ConnectionPool connectionPool;
    private CookieHandler cookieHandler;
    private final Dispatcher dispatcher;
    private boolean followProtocolRedirects;
    private HostnameVerifier hostnameVerifier;
    private Proxy proxy;
    private ProxySelector proxySelector;
    private int readTimeout;
    private ResponseCache responseCache;
    private final RouteDatabase routeDatabase;
    private SSLSocketFactory sslSocketFactory;
    private List<String> transports;

    public OkHttpClient() {
        this.followProtocolRedirects = true;
        this.routeDatabase = new RouteDatabase();
        this.dispatcher = new Dispatcher();
    }

    private OkHttpClient copyWithDefaults() {
        OkHttpClient okHttpClient = new OkHttpClient(this);
        okHttpClient.proxy = this.proxy;
        ProxySelector proxySelector = this.proxySelector;
        if (proxySelector == null) {
            proxySelector = ProxySelector.getDefault();
        }
        okHttpClient.proxySelector = proxySelector;
        CookieHandler cookieHandler = this.cookieHandler;
        if (cookieHandler == null) {
            cookieHandler = CookieHandler.getDefault();
        }
        okHttpClient.cookieHandler = cookieHandler;
        ResponseCache responseCache = this.responseCache;
        if (responseCache == null) {
            responseCache = ResponseCache.getDefault();
        }
        okHttpClient.responseCache = responseCache;
        SSLSocketFactory defaultSSLSocketFactory = this.sslSocketFactory;
        if (defaultSSLSocketFactory == null) {
            defaultSSLSocketFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
        }
        okHttpClient.sslSocketFactory = defaultSSLSocketFactory;
        HostnameVerifier hostnameVerifier = this.hostnameVerifier;
        if (hostnameVerifier == null) {
            hostnameVerifier = OkHostnameVerifier.INSTANCE;
        }
        okHttpClient.hostnameVerifier = hostnameVerifier;
        OkAuthenticator okAuthenticator = this.authenticator;
        if (okAuthenticator == null) {
            okAuthenticator = HttpAuthenticator.SYSTEM_DEFAULT;
        }
        okHttpClient.authenticator = okAuthenticator;
        ConnectionPool connectionPool = this.connectionPool;
        if (connectionPool == null) {
            connectionPool = ConnectionPool.getDefault();
        }
        okHttpClient.connectionPool = connectionPool;
        okHttpClient.followProtocolRedirects = this.followProtocolRedirects;
        List<String> list = this.transports;
        if (list == null) {
            list = DEFAULT_TRANSPORTS;
        }
        okHttpClient.transports = list;
        okHttpClient.connectTimeout = this.connectTimeout;
        okHttpClient.readTimeout = this.readTimeout;
        return okHttpClient;
    }

    public void cancel(Object obj) {
        this.dispatcher.cancel(obj);
    }

    @Override // java.net.URLStreamHandlerFactory
    public URLStreamHandler createURLStreamHandler(final String str) {
        if (str.equals(HttpHost.DEFAULT_SCHEME_NAME) || str.equals(BaseConstants.SCHEME_HTTPS)) {
            return new URLStreamHandler() { // from class: com.squareup.okhttp.OkHttpClient.1
                @Override // java.net.URLStreamHandler
                public int getDefaultPort() {
                    if (str.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
                        return 80;
                    }
                    if (str.equals(BaseConstants.SCHEME_HTTPS)) {
                        return 443;
                    }
                    throw new AssertionError();
                }

                @Override // java.net.URLStreamHandler
                public URLConnection openConnection(URL url) {
                    return OkHttpClient.this.open(url);
                }

                @Override // java.net.URLStreamHandler
                public URLConnection openConnection(URL url, Proxy proxy) {
                    return OkHttpClient.this.open(url, proxy);
                }
            };
        }
        return null;
    }

    public void enqueue(Request request, Response.Receiver receiver) {
        this.dispatcher.enqueue(copyWithDefaults(), request, receiver);
    }

    public OkAuthenticator getAuthenticator() {
        return this.authenticator;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public ConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    public CookieHandler getCookieHandler() {
        return this.cookieHandler;
    }

    public boolean getFollowProtocolRedirects() {
        return this.followProtocolRedirects;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public OkResponseCache getOkResponseCache() {
        ResponseCache responseCache = this.responseCache;
        if (responseCache instanceof HttpResponseCache) {
            return ((HttpResponseCache) responseCache).okResponseCache;
        }
        if (responseCache != null) {
            return new OkResponseCacheAdapter(responseCache);
        }
        return null;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public ResponseCache getResponseCache() {
        return this.responseCache;
    }

    public RouteDatabase getRoutesDatabase() {
        return this.routeDatabase;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public List<String> getTransports() {
        return this.transports;
    }

    public HttpURLConnection open(URL url) {
        return open(url, this.proxy);
    }

    public OkHttpClient setAuthenticator(OkAuthenticator okAuthenticator) {
        this.authenticator = okAuthenticator;
        return this;
    }

    public void setConnectTimeout(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        long millis = timeUnit.toMillis(j);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException("Timeout too large.");
        }
        this.connectTimeout = (int) millis;
    }

    public OkHttpClient setConnectionPool(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
        return this;
    }

    public OkHttpClient setCookieHandler(CookieHandler cookieHandler) {
        this.cookieHandler = cookieHandler;
        return this;
    }

    public OkHttpClient setFollowProtocolRedirects(boolean z) {
        this.followProtocolRedirects = z;
        return this;
    }

    public OkHttpClient setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.hostnameVerifier = hostnameVerifier;
        return this;
    }

    public OkHttpClient setProxy(Proxy proxy) {
        this.proxy = proxy;
        return this;
    }

    public OkHttpClient setProxySelector(ProxySelector proxySelector) {
        this.proxySelector = proxySelector;
        return this;
    }

    public void setReadTimeout(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        long millis = timeUnit.toMillis(j);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException("Timeout too large.");
        }
        this.readTimeout = (int) millis;
    }

    public OkHttpClient setResponseCache(ResponseCache responseCache) {
        this.responseCache = responseCache;
        return this;
    }

    public OkHttpClient setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
        return this;
    }

    public OkHttpClient setTransports(List<String> list) {
        List<String> listImmutableList = Util.immutableList(list);
        if (!listImmutableList.contains("http/1.1")) {
            throw new IllegalArgumentException("transports doesn't contain http/1.1: " + listImmutableList);
        }
        if (listImmutableList.contains(null)) {
            throw new IllegalArgumentException("transports must not contain null");
        }
        if (listImmutableList.contains("")) {
            throw new IllegalArgumentException("transports contains an empty string");
        }
        this.transports = listImmutableList;
        return this;
    }

    public HttpURLConnection open(URL url, Proxy proxy) {
        String protocol = url.getProtocol();
        OkHttpClient okHttpClientCopyWithDefaults = copyWithDefaults();
        okHttpClientCopyWithDefaults.proxy = proxy;
        if (protocol.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
            return new HttpURLConnectionImpl(url, okHttpClientCopyWithDefaults);
        }
        if (protocol.equals(BaseConstants.SCHEME_HTTPS)) {
            return new HttpsURLConnectionImpl(url, okHttpClientCopyWithDefaults);
        }
        throw new IllegalArgumentException("Unexpected protocol: " + protocol);
    }

    private OkHttpClient(OkHttpClient okHttpClient) {
        this.followProtocolRedirects = true;
        this.routeDatabase = okHttpClient.routeDatabase;
        this.dispatcher = okHttpClient.dispatcher;
    }
}
