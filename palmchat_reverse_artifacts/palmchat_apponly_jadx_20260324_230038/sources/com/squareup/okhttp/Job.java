package com.squareup.okhttp;

import com.squareup.okhttp.Dispatcher;
import com.squareup.okhttp.Failure;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpAuthenticator;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpsEngine;
import com.squareup.okhttp.internal.http.Policy;
import com.squareup.okhttp.internal.http.RawHeaders;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class Job implements Runnable, Policy {
    private final OkHttpClient client;
    private final Dispatcher dispatcher;
    private Request request;
    private final Response.Receiver responseReceiver;

    public Job(Dispatcher dispatcher, OkHttpClient okHttpClient, Request request, Response.Receiver receiver) {
        this.dispatcher = dispatcher;
        this.client = okHttpClient;
        this.request = request;
        this.responseReceiver = receiver;
    }

    private Response execute() throws IOException {
        Connection connection = null;
        Response responseBuild = null;
        while (true) {
            HttpEngine httpEngineNewEngine = newEngine(connection);
            Request.Body body = this.request.body();
            if (body != null) {
                MediaType mediaTypeContentType = body.contentType();
                if (mediaTypeContentType == null) {
                    throw new IllegalStateException("contentType == null");
                }
                if (httpEngineNewEngine.getRequestHeaders().getContentType() == null) {
                    httpEngineNewEngine.getRequestHeaders().setContentType(mediaTypeContentType.toString());
                }
            }
            httpEngineNewEngine.sendRequest();
            if (body != null) {
                body.writeTo(httpEngineNewEngine.getRequestBody());
            }
            httpEngineNewEngine.readResponse();
            responseBuild = new Response.Builder(this.request, httpEngineNewEngine.getResponseCode()).rawHeaders(httpEngineNewEngine.getResponseHeaders().getHeaders()).body(new Dispatcher.RealResponseBody(httpEngineNewEngine.getResponseHeaders(), httpEngineNewEngine.getResponseBody())).redirectedBy(responseBuild).build();
            Request requestProcessResponse = processResponse(httpEngineNewEngine, responseBuild);
            if (requestProcessResponse == null) {
                httpEngineNewEngine.automaticallyReleaseConnectionToPool();
                return responseBuild;
            }
            connection = sameConnection(this.request, requestProcessResponse) ? httpEngineNewEngine.getConnection() : null;
            this.request = requestProcessResponse;
        }
    }

    private Request processResponse(HttpEngine httpEngine, Response response) throws IOException {
        String strHeader;
        Request request = response.request();
        Proxy proxy = httpEngine.getConnection() != null ? httpEngine.getConnection().getRoute().getProxy() : this.client.getProxy();
        int iCode = response.code();
        if (iCode != 307) {
            if (iCode != 401) {
                if (iCode != 407) {
                    switch (iCode) {
                        case 300:
                        case 301:
                        case 302:
                        case 303:
                            break;
                        default:
                            return null;
                    }
                } else if (proxy.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
            }
            RawHeaders rawHeaders = request.rawHeaders();
            if (HttpAuthenticator.processAuthHeader(this.client.getAuthenticator(), response.code(), response.rawHeaders(), rawHeaders, proxy, this.request.url())) {
                return request.newBuilder().rawHeaders(rawHeaders).build();
            }
            return null;
        }
        String strMethod = request.method();
        if ((iCode == 307 && !strMethod.equals("GET") && !strMethod.equals(com.qiniu.android.http.request.Request.HttpMethodHEAD)) || (strHeader = response.header(HttpHeaders.LOCATION)) == null) {
            return null;
        }
        URL url = new URL(request.url(), strHeader);
        if (url.getProtocol().equals(BaseConstants.SCHEME_HTTPS) || url.getProtocol().equals(HttpHost.DEFAULT_SCHEME_NAME)) {
            return this.request.newBuilder().url(url).build();
        }
        return null;
    }

    private boolean sameConnection(Request request, Request request2) {
        return request.url().getHost().equals(request2.url().getHost()) && Util.getEffectivePort(request.url()) == Util.getEffectivePort(request2.url()) && request.url().getProtocol().equals(request2.url().getProtocol());
    }

    @Override // com.squareup.okhttp.internal.http.Policy
    public int getChunkLength() {
        return this.request.body().contentLength() == -1 ? 1024 : -1;
    }

    @Override // com.squareup.okhttp.internal.http.Policy
    public long getFixedContentLength() {
        return this.request.body().contentLength();
    }

    @Override // com.squareup.okhttp.internal.http.Policy
    public HttpURLConnection getHttpConnectionToCache() {
        return null;
    }

    @Override // com.squareup.okhttp.internal.http.Policy
    public long getIfModifiedSince() {
        return 0L;
    }

    @Override // com.squareup.okhttp.internal.http.Policy
    public URL getURL() {
        return this.request.url();
    }

    @Override // com.squareup.okhttp.internal.http.Policy
    public boolean getUseCaches() {
        return false;
    }

    public HttpEngine newEngine(Connection connection) throws IOException {
        String protocol = this.request.url().getProtocol();
        RawHeaders rawHeaders = this.request.rawHeaders();
        if (protocol.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
            return new HttpEngine(this.client, this, this.request.method(), rawHeaders, connection, null);
        }
        if (protocol.equals(BaseConstants.SCHEME_HTTPS)) {
            return new HttpsEngine(this.client, this, this.request.method(), rawHeaders, connection, null);
        }
        throw new AssertionError();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                this.responseReceiver.onResponse(execute());
            } catch (IOException e) {
                this.responseReceiver.onFailure(new Failure.Builder().request(this.request).exception(e).build());
            }
        } finally {
            this.dispatcher.finished(this);
        }
    }

    public Object tag() {
        return this.request.tag();
    }

    @Override // com.squareup.okhttp.internal.http.Policy
    public boolean usingProxy() {
        return false;
    }

    @Override // com.squareup.okhttp.internal.http.Policy
    public void setSelectedProxy(Proxy proxy) {
    }
}
