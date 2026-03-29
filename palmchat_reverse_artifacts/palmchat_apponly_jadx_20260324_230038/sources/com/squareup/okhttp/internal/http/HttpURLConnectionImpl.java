package com.squareup.okhttp.internal.http;

import com.android.volley.toolbox.HttpClientStack;
import com.qiniu.android.http.request.Request;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketPermission;
import java.net.URL;
import java.security.Permission;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class HttpURLConnectionImpl extends HttpURLConnection implements Policy {
    public static final int HTTP_TEMP_REDIRECT = 307;
    private static final int MAX_REDIRECTS = 20;
    final OkHttpClient client;
    private long fixedContentLength;
    protected HttpEngine httpEngine;
    protected IOException httpEngineFailure;
    private final RawHeaders rawRequestHeaders;
    private int redirectionCount;
    private Proxy selectedProxy;

    /* JADX INFO: compiled from: SearchBox */
    public enum Retry {
        NONE,
        SAME_CONNECTION,
        DIFFERENT_CONNECTION
    }

    public HttpURLConnectionImpl(URL url, OkHttpClient okHttpClient) {
        super(url);
        this.rawRequestHeaders = new RawHeaders();
        this.fixedContentLength = -1L;
        this.client = okHttpClient;
    }

    private boolean execute(boolean z) throws IOException {
        try {
            this.httpEngine.sendRequest();
            if (!z) {
                return true;
            }
            this.httpEngine.readResponse();
            return true;
        } catch (IOException e) {
            if (handleFailure(e)) {
                return false;
            }
            throw e;
        }
    }

    private HttpEngine getResponse() throws IOException {
        initHttpEngine();
        if (this.httpEngine.hasResponse()) {
            return this.httpEngine;
        }
        while (true) {
            if (execute(true)) {
                Retry retryProcessResponseHeaders = processResponseHeaders();
                if (retryProcessResponseHeaders == Retry.NONE) {
                    this.httpEngine.automaticallyReleaseConnectionToPool();
                    return this.httpEngine;
                }
                String str = ((HttpURLConnection) this).method;
                OutputStream requestBody = this.httpEngine.getRequestBody();
                int responseCode = this.httpEngine.getResponseCode();
                if (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303) {
                    str = "GET";
                    requestBody = null;
                }
                if (requestBody != null && !(requestBody instanceof RetryableOutputStream)) {
                    throw new HttpRetryException("Cannot retry streamed HTTP body", responseCode);
                }
                if (retryProcessResponseHeaders == Retry.DIFFERENT_CONNECTION) {
                    this.httpEngine.automaticallyReleaseConnectionToPool();
                }
                this.httpEngine.release(false);
                HttpEngine httpEngineNewHttpEngine = newHttpEngine(str, this.rawRequestHeaders, this.httpEngine.getConnection(), (RetryableOutputStream) requestBody);
                this.httpEngine = httpEngineNewHttpEngine;
                if (requestBody == null) {
                    httpEngineNewHttpEngine.getRequestHeaders().removeContentLength();
                }
            }
        }
    }

    private boolean handleFailure(IOException iOException) throws IOException {
        Connection connection;
        HttpEngine httpEngine = this.httpEngine;
        RouteSelector routeSelector = httpEngine.routeSelector;
        if (routeSelector != null && (connection = httpEngine.connection) != null) {
            routeSelector.connectFailed(connection, iOException);
        }
        OutputStream requestBody = this.httpEngine.getRequestBody();
        boolean z = requestBody == null || (requestBody instanceof RetryableOutputStream);
        if ((routeSelector == null && this.httpEngine.connection == null) || ((routeSelector != null && !routeSelector.hasNext()) || !isRecoverable(iOException) || !z)) {
            this.httpEngineFailure = iOException;
            return false;
        }
        this.httpEngine.release(true);
        HttpEngine httpEngineNewHttpEngine = newHttpEngine(((HttpURLConnection) this).method, this.rawRequestHeaders, null, (RetryableOutputStream) requestBody);
        this.httpEngine = httpEngineNewHttpEngine;
        httpEngineNewHttpEngine.routeSelector = routeSelector;
        return true;
    }

    private void initHttpEngine() throws IOException {
        IOException iOException = this.httpEngineFailure;
        if (iOException != null) {
            throw iOException;
        }
        if (this.httpEngine != null) {
            return;
        }
        ((HttpURLConnection) this).connected = true;
        try {
            if (((HttpURLConnection) this).doOutput) {
                if (((HttpURLConnection) this).method.equals("GET")) {
                    ((HttpURLConnection) this).method = "POST";
                } else if (!((HttpURLConnection) this).method.equals("POST") && !((HttpURLConnection) this).method.equals("PUT") && !((HttpURLConnection) this).method.equals(HttpClientStack.HttpPatch.METHOD_NAME)) {
                    throw new ProtocolException(((HttpURLConnection) this).method + " does not support writing");
                }
            }
            this.httpEngine = newHttpEngine(((HttpURLConnection) this).method, this.rawRequestHeaders, null, null);
        } catch (IOException e) {
            this.httpEngineFailure = e;
            throw e;
        }
    }

    private boolean isRecoverable(IOException iOException) {
        return (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof ProtocolException)) ? false : true;
    }

    private static boolean isValidNonDirectProxy(Proxy proxy) {
        return (proxy == null || proxy.type() == Proxy.Type.DIRECT) ? false : true;
    }

    private HttpEngine newHttpEngine(String str, RawHeaders rawHeaders, Connection connection, RetryableOutputStream retryableOutputStream) throws IOException {
        if (((HttpURLConnection) this).url.getProtocol().equals(HttpHost.DEFAULT_SCHEME_NAME)) {
            return new HttpEngine(this.client, this, str, rawHeaders, connection, retryableOutputStream);
        }
        if (((HttpURLConnection) this).url.getProtocol().equals(BaseConstants.SCHEME_HTTPS)) {
            return new HttpsEngine(this.client, this, str, rawHeaders, connection, retryableOutputStream);
        }
        throw new AssertionError();
    }

    private Retry processResponseHeaders() throws IOException {
        Connection connection = this.httpEngine.connection;
        Proxy proxy = connection != null ? connection.getRoute().getProxy() : this.client.getProxy();
        int responseCode = getResponseCode();
        if (responseCode != 307) {
            if (responseCode != 401) {
                if (responseCode != 407) {
                    switch (responseCode) {
                        case 300:
                        case 301:
                        case 302:
                        case 303:
                            break;
                        default:
                            return Retry.NONE;
                    }
                } else if (proxy.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
            }
            return HttpAuthenticator.processAuthHeader(this.client.getAuthenticator(), getResponseCode(), this.httpEngine.getResponseHeaders().getHeaders(), this.rawRequestHeaders, proxy, ((HttpURLConnection) this).url) ? Retry.SAME_CONNECTION : Retry.NONE;
        }
        if (!getInstanceFollowRedirects()) {
            return Retry.NONE;
        }
        int i = this.redirectionCount + 1;
        this.redirectionCount = i;
        if (i > 20) {
            throw new ProtocolException("Too many redirects: " + this.redirectionCount);
        }
        if (responseCode == 307 && !((HttpURLConnection) this).method.equals("GET") && !((HttpURLConnection) this).method.equals(Request.HttpMethodHEAD)) {
            return Retry.NONE;
        }
        String headerField = getHeaderField(HttpHeaders.LOCATION);
        if (headerField == null) {
            return Retry.NONE;
        }
        URL url = ((HttpURLConnection) this).url;
        URL url2 = new URL(url, headerField);
        ((HttpURLConnection) this).url = url2;
        if (!url2.getProtocol().equals(BaseConstants.SCHEME_HTTPS) && !((HttpURLConnection) this).url.getProtocol().equals(HttpHost.DEFAULT_SCHEME_NAME)) {
            return Retry.NONE;
        }
        boolean zEquals = url.getProtocol().equals(((HttpURLConnection) this).url.getProtocol());
        if (zEquals || this.client.getFollowProtocolRedirects()) {
            return (url.getHost().equals(((HttpURLConnection) this).url.getHost()) && (Util.getEffectivePort(url) == Util.getEffectivePort(((HttpURLConnection) this).url)) && zEquals) ? Retry.SAME_CONNECTION : Retry.DIFFERENT_CONNECTION;
        }
        return Retry.NONE;
    }

    private void setTransports(String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.addAll(this.client.getTransports());
        }
        for (String str2 : str.split(",", -1)) {
            arrayList.add(str2);
        }
        this.client.setTransports(arrayList);
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (((HttpURLConnection) this).connected) {
            throw new IllegalStateException("Cannot add request property after connection is made");
        }
        if (str == null) {
            throw new NullPointerException("field == null");
        }
        if (str2 != null) {
            if ("X-Android-Transports".equals(str)) {
                setTransports(str2, true);
                return;
            } else {
                this.rawRequestHeaders.add(str, str2);
                return;
            }
        }
        Platform.get().logW("Ignoring header " + str + " because its value was null.");
    }

    @Override // java.net.URLConnection
    public final void connect() throws IOException {
        initHttpEngine();
        while (!execute(false)) {
        }
    }

    @Override // java.net.HttpURLConnection
    public final void disconnect() {
        HttpEngine httpEngine = this.httpEngine;
        if (httpEngine != null) {
            if (httpEngine.hasResponse()) {
                Util.closeQuietly(this.httpEngine.getResponseBody());
            }
            this.httpEngine.release(true);
        }
    }

    @Override // com.squareup.okhttp.internal.http.Policy
    public final int getChunkLength() {
        return ((HttpURLConnection) this).chunkLength;
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return this.client.getConnectTimeout();
    }

    @Override // java.net.HttpURLConnection
    public final InputStream getErrorStream() {
        try {
            HttpEngine response = getResponse();
            if (!response.hasResponseBody() || response.getResponseCode() < 400) {
                return null;
            }
            return response.getResponseBody();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // com.squareup.okhttp.internal.http.Policy
    public final long getFixedContentLength() {
        return this.fixedContentLength;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        try {
            return getResponse().getResponseHeaders().getHeaders().getValue(i);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        try {
            return getResponse().getResponseHeaders().getHeaders().getFieldName(i);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.net.URLConnection
    public final Map<String, List<String>> getHeaderFields() {
        try {
            return getResponse().getResponseHeaders().getHeaders().toMultimap(true);
        } catch (IOException unused) {
            return Collections.emptyMap();
        }
    }

    public HttpEngine getHttpEngine() {
        return this.httpEngine;
    }

    @Override // java.net.URLConnection
    public final InputStream getInputStream() throws IOException {
        if (!((HttpURLConnection) this).doInput) {
            throw new ProtocolException("This protocol does not support input");
        }
        HttpEngine response = getResponse();
        if (getResponseCode() >= 400) {
            throw new FileNotFoundException(((HttpURLConnection) this).url.toString());
        }
        InputStream responseBody = response.getResponseBody();
        if (responseBody != null) {
            return responseBody;
        }
        throw new ProtocolException("No response body exists; responseCode=" + getResponseCode());
    }

    @Override // java.net.URLConnection
    public final OutputStream getOutputStream() throws IOException {
        connect();
        OutputStream requestBody = this.httpEngine.getRequestBody();
        if (requestBody != null) {
            if (this.httpEngine.hasResponse()) {
                throw new ProtocolException("cannot write request body after response has been read");
            }
            return requestBody;
        }
        throw new ProtocolException("method does not support a request body: " + ((HttpURLConnection) this).method);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final Permission getPermission() throws IOException {
        String host = getURL().getHost();
        int effectivePort = Util.getEffectivePort(getURL());
        if (usingProxy()) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) this.client.getProxy().address();
            String hostName = inetSocketAddress.getHostName();
            effectivePort = inetSocketAddress.getPort();
            host = hostName;
        }
        return new SocketPermission(host + ":" + effectivePort, "connect, resolve");
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return this.client.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public final Map<String, List<String>> getRequestProperties() {
        if (((HttpURLConnection) this).connected) {
            throw new IllegalStateException("Cannot access request header fields after connection is set");
        }
        return this.rawRequestHeaders.toMultimap(false);
    }

    @Override // java.net.URLConnection
    public final String getRequestProperty(String str) {
        if (str == null) {
            return null;
        }
        return this.rawRequestHeaders.get(str);
    }

    @Override // java.net.HttpURLConnection
    public final int getResponseCode() throws IOException {
        return getResponse().getResponseCode();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        return getResponse().getResponseHeaders().getHeaders().getResponseMessage();
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        this.client.setConnectTimeout(i, TimeUnit.MILLISECONDS);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        setFixedLengthStreamingMode(i);
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        this.client.setReadTimeout(i, TimeUnit.MILLISECONDS);
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (((HttpURLConnection) this).connected) {
            throw new IllegalStateException("Cannot set request property after connection is made");
        }
        if (str == null) {
            throw new NullPointerException("field == null");
        }
        if (str2 != null) {
            if ("X-Android-Transports".equals(str)) {
                setTransports(str2, false);
                return;
            } else {
                this.rawRequestHeaders.set(str, str2);
                return;
            }
        }
        Platform.get().logW("Ignoring header " + str + " because its value was null.");
    }

    @Override // com.squareup.okhttp.internal.http.Policy
    public final void setSelectedProxy(Proxy proxy) {
        this.selectedProxy = proxy;
    }

    @Override // java.net.HttpURLConnection, com.squareup.okhttp.internal.http.Policy
    public final boolean usingProxy() {
        Proxy proxy = this.selectedProxy;
        return proxy != null ? isValidNonDirectProxy(proxy) : isValidNonDirectProxy(this.client.getProxy());
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            RawHeaders headers = getResponse().getResponseHeaders().getHeaders();
            return str == null ? headers.getStatusLine() : headers.get(str);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(long j) {
        if (((HttpURLConnection) this).connected) {
            throw new IllegalStateException("Already connected");
        }
        if (((HttpURLConnection) this).chunkLength > 0) {
            throw new IllegalStateException("Already in chunked mode");
        }
        if (j < 0) {
            throw new IllegalArgumentException("contentLength < 0");
        }
        this.fixedContentLength = j;
        ((HttpURLConnection) this).fixedContentLength = (int) Math.min(j, 2147483647L);
    }

    @Override // com.squareup.okhttp.internal.http.Policy
    public HttpURLConnection getHttpConnectionToCache() {
        return this;
    }
}
