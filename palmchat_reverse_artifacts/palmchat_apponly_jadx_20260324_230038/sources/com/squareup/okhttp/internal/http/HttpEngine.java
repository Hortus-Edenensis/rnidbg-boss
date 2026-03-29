package com.squareup.okhttp.internal.http;

import com.android.volley.toolbox.HttpClientStack;
import com.efs.sdk.base.Constants;
import com.qiniu.android.http.request.Request;
import com.squareup.okhttp.Address;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkResponseCache;
import com.squareup.okhttp.ResponseSource;
import com.squareup.okhttp.TunnelRequest;
import com.squareup.okhttp.internal.Dns;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.CookieHandler;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class HttpEngine {
    private static final CacheResponse GATEWAY_TIMEOUT_RESPONSE = new CacheResponse() { // from class: com.squareup.okhttp.internal.http.HttpEngine.1
        @Override // java.net.CacheResponse
        public InputStream getBody() throws IOException {
            return new ByteArrayInputStream(Util.EMPTY_BYTE_ARRAY);
        }

        @Override // java.net.CacheResponse
        public Map<String, List<String>> getHeaders() throws IOException {
            HashMap map = new HashMap();
            map.put(null, Collections.singletonList("HTTP/1.1 504 Gateway Timeout"));
            return map;
        }
    };
    public static final int HTTP_CONTINUE = 100;
    private boolean automaticallyReleaseConnectionToPool;
    private CacheRequest cacheRequest;
    private CacheResponse cacheResponse;
    private InputStream cachedResponseBody;
    private ResponseHeaders cachedResponseHeaders;
    protected final OkHttpClient client;
    boolean connected;
    protected Connection connection;
    private boolean connectionReleased;
    protected final String method;
    protected final Policy policy;
    private OutputStream requestBodyOut;
    final RequestHeaders requestHeaders;
    private InputStream responseBodyIn;
    ResponseHeaders responseHeaders;
    private ResponseSource responseSource;
    private InputStream responseTransferIn;
    protected RouteSelector routeSelector;
    long sentRequestMillis = -1;
    private boolean transparentGzip;
    private Transport transport;
    final URI uri;

    public HttpEngine(OkHttpClient okHttpClient, Policy policy, String str, RawHeaders rawHeaders, Connection connection, RetryableOutputStream retryableOutputStream) throws IOException {
        this.client = okHttpClient;
        this.policy = policy;
        this.method = str;
        this.connection = connection;
        this.requestBodyOut = retryableOutputStream;
        try {
            URI uriLenient = Platform.get().toUriLenient(policy.getURL());
            this.uri = uriLenient;
            this.requestHeaders = new RequestHeaders(uriLenient, new RawHeaders(rawHeaders));
        } catch (URISyntaxException e) {
            throw new IOException(e.getMessage());
        }
    }

    public static String getDefaultUserAgent() {
        String property = System.getProperty("http.agent");
        if (property != null) {
            return property;
        }
        return "Java" + System.getProperty("java.version");
    }

    public static String getOriginAddress(URL url) {
        int port = url.getPort();
        String host = url.getHost();
        if (port <= 0 || port == Util.getDefaultPort(url.getProtocol())) {
            return host;
        }
        return host + ":" + port;
    }

    private void initContentStream(InputStream inputStream) throws IOException {
        this.responseTransferIn = inputStream;
        if (!this.transparentGzip || !this.responseHeaders.isContentEncodingGzip()) {
            this.responseBodyIn = inputStream;
            return;
        }
        this.responseHeaders.stripContentEncoding();
        this.responseHeaders.stripContentLength();
        this.responseBodyIn = new GZIPInputStream(inputStream);
    }

    private void initResponseSource() throws IOException {
        OkResponseCache okResponseCache;
        CacheResponse cacheResponse;
        ResponseSource responseSource = ResponseSource.NETWORK;
        this.responseSource = responseSource;
        if (!this.policy.getUseCaches() || (okResponseCache = this.client.getOkResponseCache()) == null || (cacheResponse = okResponseCache.get(this.uri, this.method, this.requestHeaders.getHeaders().toMultimap(false))) == null) {
            return;
        }
        Map<String, List<String>> headers = cacheResponse.getHeaders();
        this.cachedResponseBody = cacheResponse.getBody();
        if (!acceptCacheResponseType(cacheResponse) || headers == null || this.cachedResponseBody == null) {
            Util.closeQuietly(this.cachedResponseBody);
            return;
        }
        this.cachedResponseHeaders = new ResponseHeaders(this.uri, RawHeaders.fromMultimap(headers, true));
        ResponseSource responseSourceChooseResponseSource = this.cachedResponseHeaders.chooseResponseSource(System.currentTimeMillis(), this.requestHeaders);
        this.responseSource = responseSourceChooseResponseSource;
        if (responseSourceChooseResponseSource == ResponseSource.CACHE) {
            this.cacheResponse = cacheResponse;
            setResponse(this.cachedResponseHeaders, this.cachedResponseBody);
        } else if (responseSourceChooseResponseSource == ResponseSource.CONDITIONAL_CACHE) {
            this.cacheResponse = cacheResponse;
        } else {
            if (responseSourceChooseResponseSource != responseSource) {
                throw new AssertionError();
            }
            Util.closeQuietly(this.cachedResponseBody);
        }
    }

    private void maybeCache() throws IOException {
        OkResponseCache okResponseCache;
        if (this.policy.getUseCaches() && (okResponseCache = this.client.getOkResponseCache()) != null) {
            HttpURLConnection httpConnectionToCache = this.policy.getHttpConnectionToCache();
            if (this.responseHeaders.isCacheable(this.requestHeaders)) {
                this.cacheRequest = okResponseCache.put(this.uri, httpConnectionToCache);
            } else {
                okResponseCache.maybeRemove(httpConnectionToCache.getRequestMethod(), this.uri);
            }
        }
    }

    private void prepareRawRequestHeaders() throws IOException {
        this.requestHeaders.getHeaders().setRequestLine(getRequestLine());
        if (this.requestHeaders.getUserAgent() == null) {
            this.requestHeaders.setUserAgent(getDefaultUserAgent());
        }
        if (this.requestHeaders.getHost() == null) {
            this.requestHeaders.setHost(getOriginAddress(this.policy.getURL()));
        }
        Connection connection = this.connection;
        if ((connection == null || connection.getHttpMinorVersion() != 0) && this.requestHeaders.getConnection() == null) {
            this.requestHeaders.setConnection(HTTP.CONN_KEEP_ALIVE);
        }
        if (this.requestHeaders.getAcceptEncoding() == null) {
            this.transparentGzip = true;
            this.requestHeaders.setAcceptEncoding(Constants.CP_GZIP);
        }
        if (hasRequestBody() && this.requestHeaders.getContentType() == null) {
            this.requestHeaders.setContentType("application/x-www-form-urlencoded");
        }
        long ifModifiedSince = this.policy.getIfModifiedSince();
        if (ifModifiedSince != 0) {
            this.requestHeaders.setIfModifiedSince(new Date(ifModifiedSince));
        }
        CookieHandler cookieHandler = this.client.getCookieHandler();
        if (cookieHandler != null) {
            RequestHeaders requestHeaders = this.requestHeaders;
            requestHeaders.addCookies(cookieHandler.get(this.uri, requestHeaders.getHeaders().toMultimap(false)));
        }
    }

    public static String requestPath(URL url) {
        String file = url.getFile();
        if (file == null) {
            return "/";
        }
        if (file.startsWith("/")) {
            return file;
        }
        return "/" + file;
    }

    private String requestString() {
        URL url = this.policy.getURL();
        return includeAuthorityInRequestLine() ? url.toString() : requestPath(url);
    }

    private void sendSocketRequest() throws IOException {
        if (this.connection == null) {
            connect();
        }
        if (this.transport != null) {
            throw new IllegalStateException();
        }
        this.transport = (Transport) this.connection.newTransport(this);
        if (hasRequestBody() && this.requestBodyOut == null) {
            this.requestBodyOut = this.transport.createRequestBody();
        }
    }

    private void setResponse(ResponseHeaders responseHeaders, InputStream inputStream) throws IOException {
        if (this.responseBodyIn != null) {
            throw new IllegalStateException();
        }
        this.responseHeaders = responseHeaders;
        if (inputStream != null) {
            initContentStream(inputStream);
        }
    }

    public boolean acceptCacheResponseType(CacheResponse cacheResponse) {
        return true;
    }

    public final void automaticallyReleaseConnectionToPool() {
        this.automaticallyReleaseConnectionToPool = true;
        if (this.connection == null || !this.connectionReleased) {
            return;
        }
        this.client.getConnectionPool().recycle(this.connection);
        this.connection = null;
    }

    public final void connect() throws IOException {
        SSLSocketFactory sslSocketFactory;
        HostnameVerifier hostnameVerifier;
        if (this.connection != null) {
            return;
        }
        if (this.routeSelector == null) {
            String host = this.uri.getHost();
            if (host == null) {
                throw new UnknownHostException(this.uri.toString());
            }
            if (this.uri.getScheme().equalsIgnoreCase(BaseConstants.SCHEME_HTTPS)) {
                sslSocketFactory = this.client.getSslSocketFactory();
                hostnameVerifier = this.client.getHostnameVerifier();
            } else {
                sslSocketFactory = null;
                hostnameVerifier = null;
            }
            this.routeSelector = new RouteSelector(new Address(host, Util.getEffectivePort(this.uri), sslSocketFactory, hostnameVerifier, this.client.getAuthenticator(), this.client.getProxy(), this.client.getTransports()), this.uri, this.client.getProxySelector(), this.client.getConnectionPool(), Dns.DEFAULT, this.client.getRoutesDatabase());
        }
        Connection next = this.routeSelector.next(this.method);
        this.connection = next;
        if (!next.isConnected()) {
            this.connection.connect(this.client.getConnectTimeout(), this.client.getReadTimeout(), getTunnelConfig());
            this.client.getConnectionPool().maybeShare(this.connection);
            this.client.getRoutesDatabase().connected(this.connection.getRoute());
        } else if (!this.connection.isSpdy()) {
            this.connection.updateReadTimeout(this.client.getReadTimeout());
        }
        connected(this.connection);
        if (this.connection.getRoute().getProxy() != this.client.getProxy()) {
            this.requestHeaders.getHeaders().setRequestLine(getRequestLine());
        }
    }

    public void connected(Connection connection) {
        this.policy.setSelectedProxy(connection.getRoute().getProxy());
        this.connected = true;
    }

    public final CacheResponse getCacheResponse() {
        return this.cacheResponse;
    }

    public final Connection getConnection() {
        return this.connection;
    }

    public final OutputStream getRequestBody() {
        if (this.responseSource != null) {
            return this.requestBodyOut;
        }
        throw new IllegalStateException();
    }

    public final RequestHeaders getRequestHeaders() {
        return this.requestHeaders;
    }

    public String getRequestLine() {
        Connection connection = this.connection;
        return this.method + " " + requestString() + " " + ((connection == null || connection.getHttpMinorVersion() != 0) ? "HTTP/1.1" : "HTTP/1.0");
    }

    public final InputStream getResponseBody() {
        if (this.responseHeaders != null) {
            return this.responseBodyIn;
        }
        throw new IllegalStateException();
    }

    public final int getResponseCode() {
        ResponseHeaders responseHeaders = this.responseHeaders;
        if (responseHeaders != null) {
            return responseHeaders.getHeaders().getResponseCode();
        }
        throw new IllegalStateException();
    }

    public final ResponseHeaders getResponseHeaders() {
        ResponseHeaders responseHeaders = this.responseHeaders;
        if (responseHeaders != null) {
            return responseHeaders;
        }
        throw new IllegalStateException();
    }

    public TunnelRequest getTunnelConfig() {
        return null;
    }

    public URI getUri() {
        return this.uri;
    }

    public boolean hasRequestBody() {
        return this.method.equals("POST") || this.method.equals("PUT") || this.method.equals(HttpClientStack.HttpPatch.METHOD_NAME);
    }

    public final boolean hasResponse() {
        return this.responseHeaders != null;
    }

    public final boolean hasResponseBody() {
        int responseCode = this.responseHeaders.getHeaders().getResponseCode();
        if (this.method.equals(Request.HttpMethodHEAD)) {
            return false;
        }
        return (((responseCode >= 100 && responseCode < 200) || responseCode == 204 || responseCode == 304) && this.responseHeaders.getContentLength() == -1 && !this.responseHeaders.isChunked()) ? false : true;
    }

    public boolean includeAuthorityInRequestLine() {
        Connection connection = this.connection;
        return connection == null ? this.policy.usingProxy() : connection.getRoute().getProxy().type() == Proxy.Type.HTTP;
    }

    public final void readResponse() throws IOException {
        if (hasResponse()) {
            this.responseHeaders.setResponseSource(this.responseSource);
            return;
        }
        ResponseSource responseSource = this.responseSource;
        if (responseSource == null) {
            throw new IllegalStateException("readResponse() without sendRequest()");
        }
        if (responseSource.requiresConnection()) {
            if (this.sentRequestMillis == -1) {
                if (this.requestBodyOut instanceof RetryableOutputStream) {
                    this.requestHeaders.setContentLength(((RetryableOutputStream) r0).contentLength());
                }
                this.transport.writeRequestHeaders();
            }
            OutputStream outputStream = this.requestBodyOut;
            if (outputStream != null) {
                outputStream.close();
                OutputStream outputStream2 = this.requestBodyOut;
                if (outputStream2 instanceof RetryableOutputStream) {
                    this.transport.writeRequestBody((RetryableOutputStream) outputStream2);
                }
            }
            this.transport.flushRequest();
            ResponseHeaders responseHeaders = this.transport.readResponseHeaders();
            this.responseHeaders = responseHeaders;
            responseHeaders.setLocalTimestamps(this.sentRequestMillis, System.currentTimeMillis());
            this.responseHeaders.setResponseSource(this.responseSource);
            if (this.responseSource == ResponseSource.CONDITIONAL_CACHE) {
                if (this.cachedResponseHeaders.validate(this.responseHeaders)) {
                    release(false);
                    this.responseHeaders = this.cachedResponseHeaders.combine(this.responseHeaders);
                    OkResponseCache okResponseCache = this.client.getOkResponseCache();
                    okResponseCache.trackConditionalCacheHit();
                    okResponseCache.update(this.cacheResponse, this.policy.getHttpConnectionToCache());
                    initContentStream(this.cachedResponseBody);
                    return;
                }
                Util.closeQuietly(this.cachedResponseBody);
            }
            if (hasResponseBody()) {
                maybeCache();
            }
            initContentStream(this.transport.getTransferStream(this.cacheRequest));
        }
    }

    public void receiveHeaders(RawHeaders rawHeaders) throws IOException {
        CookieHandler cookieHandler = this.client.getCookieHandler();
        if (cookieHandler != null) {
            cookieHandler.put(this.uri, rawHeaders.toMultimap(true));
        }
    }

    public final void release(boolean z) {
        InputStream inputStream = this.responseBodyIn;
        if (inputStream == this.cachedResponseBody) {
            Util.closeQuietly(inputStream);
        }
        if (this.connectionReleased || this.connection == null) {
            return;
        }
        this.connectionReleased = true;
        Transport transport = this.transport;
        if (transport == null || !transport.makeReusable(z, this.requestBodyOut, this.responseTransferIn)) {
            Util.closeQuietly(this.connection);
            this.connection = null;
        } else if (this.automaticallyReleaseConnectionToPool) {
            this.client.getConnectionPool().recycle(this.connection);
            this.connection = null;
        }
    }

    public final void sendRequest() throws IOException {
        if (this.responseSource != null) {
            return;
        }
        prepareRawRequestHeaders();
        initResponseSource();
        OkResponseCache okResponseCache = this.client.getOkResponseCache();
        if (okResponseCache != null) {
            okResponseCache.trackResponse(this.responseSource);
        }
        if (this.requestHeaders.isOnlyIfCached() && this.responseSource.requiresConnection()) {
            if (this.responseSource == ResponseSource.CONDITIONAL_CACHE) {
                Util.closeQuietly(this.cachedResponseBody);
            }
            this.responseSource = ResponseSource.CACHE;
            CacheResponse cacheResponse = GATEWAY_TIMEOUT_RESPONSE;
            this.cacheResponse = cacheResponse;
            setResponse(new ResponseHeaders(this.uri, RawHeaders.fromMultimap(cacheResponse.getHeaders(), true)), this.cacheResponse.getBody());
        }
        if (this.responseSource.requiresConnection()) {
            sendSocketRequest();
        } else if (this.connection != null) {
            this.client.getConnectionPool().recycle(this.connection);
            this.connection = null;
        }
    }

    public void writingRequestHeaders() {
        if (this.sentRequestMillis != -1) {
            throw new IllegalStateException();
        }
        this.sentRequestMillis = System.currentTimeMillis();
    }
}
